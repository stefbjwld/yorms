package cn.com.yusys.console.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.com.yusys.console.dao.IndexAcqFreqDao;
import cn.com.yusys.console.dao.PipetteClassificationDao;
import cn.com.yusys.console.dao.PipetteDao;
import cn.com.yusys.console.dto.pipette.PipetteResponse;
import cn.com.yusys.console.dto.pipetteTree.IndexAcqFreq2;
import cn.com.yusys.console.dto.pipetteTree.Level1;
import cn.com.yusys.console.dto.pipetteTree.Level2;
import cn.com.yusys.console.dto.pipetteTree.PipetteObj;
import cn.com.yusys.console.po.IndexAcqFreq;
import cn.com.yusys.console.po.Pipette;
import cn.com.yusys.console.po.PipetteClassification;
import cn.com.yusys.console.service.PiPetteService;
import cn.com.yusys.file.util.RiskException;

@Service
public class PipetteServiceImpl implements PiPetteService {
	
	private static final Logger log = LoggerFactory.getLogger(PipetteServiceImpl.class);
	
	@Autowired
	private PipetteDao pipetteDao;
	
	@Autowired
	private IndexAcqFreqDao indexAcqFreqDao;
	
	@Autowired
	private PipetteClassificationDao pipetteClassificationDao;
	
	@Override
	public List<PipetteResponse> queryAll() {
		List<Pipette> pipetteList = pipetteDao.findAll();
		List<PipetteResponse> result = new ArrayList<PipetteResponse> ();
		PipetteResponse pipetteResponse = null;
		List<Integer> ids = new ArrayList<Integer>();
		for(Pipette pipette:pipetteList){
			pipetteResponse = new PipetteResponse();
			BeanUtils.copyProperties(pipette, pipetteResponse);
			pipetteResponse.setObjClassName(pipetteClassificationDao.getClassName(pipette.getObjClass()));
			String indexIndicatIds = pipette.getIndexIndicat();
			log.info("被管对象管理指标：{}",indexIndicatIds);
			String names = "";
			if(!StringUtils.isEmpty(indexIndicatIds)){
				if(indexIndicatIds.contains(",")){
					String[] str2 = indexIndicatIds.split(",");
					for(int i=0;i<str2.length;i++){
						if(!ids.contains(Integer.valueOf(str2[i]))){
							ids.add(Integer.valueOf(str2[i]));
						}
					}
				}else{
					ids.add(Integer.valueOf(indexIndicatIds));
				}
				
				List<IndexAcqFreq> indexAcqFreqList = indexAcqFreqDao.findByIds(ids);
				for(IndexAcqFreq iaf:indexAcqFreqList){
					names += iaf.getIndexZh()+"/";
				}
				if(names.endsWith("/")){
					names = names.substring(0, names.length()-1);
				}
			}
			pipetteResponse.setIndexIndicatNames(names);
			result.add(pipetteResponse);
		}
		return result;
	}

	@Override
	@Transactional
    public void save(Pipette pipette) throws RiskException {
		pipetteDao.saveAndFlush(pipette);
    }

	@Override
    public List<Level1> queryTree() {
	    /**1.先查出所有被管对象一级分类*/
		List<Level1> result = new ArrayList<Level1>();
		List<PipetteClassification> list1 = pipetteClassificationDao.getAllLevel1();
		for(PipetteClassification pcf:list1){
			Level1 level1 = new Level1();
			level1.setLevel1Id(pcf.getId());
			level1.setLevelName(pcf.getName());
			
			/**2.查询当前被管对象的二级分类*/
			List<PipetteClassification> list2 = pipetteClassificationDao.getInfoByLevel1(level1.getLevel1Id());
			List<Level2> level2List = new ArrayList<Level2>();
			for(PipetteClassification level2:list2){
				Level2 l2 = new Level2();
				l2.setLevel2Id(level2.getId());
				l2.setLevel2Name(level2.getName());
				
				/**3.查询二级分类下的被管对象*/
				List<Pipette> pipetteList = pipetteDao.queryByLevel2(l2.getLevel2Id());
				List<PipetteObj> objList = new ArrayList<PipetteObj>();
				for(Pipette pipette:pipetteList){
					PipetteObj obj = new PipetteObj();
					obj.setObjId(pipette.getId());
					obj.setObjName(pipette.getObjName());
					/**4.查询当前被管对象的指标项集合*/
					List<Integer> ids = new ArrayList<Integer>();
					String[] strs = pipette.getIndexIndicat().split(",");
					for(String str:strs){
						ids.add(Integer.valueOf(str));
					}
					List<IndexAcqFreq> iafList = indexAcqFreqDao.findByIds(ids);
					List<IndexAcqFreq2> iaf2List = new ArrayList<IndexAcqFreq2>();
					for(IndexAcqFreq iaf:iafList){
						IndexAcqFreq2 iaf2 = new IndexAcqFreq2();
						iaf2.setIndexAcqFreqId(iaf.getId());
						iaf2.setIndexAcqFreqName(iaf.getIndexZh());
						iaf2List.add(iaf2);
					}
					obj.setIndexAcqFreqList(iaf2List);
					objList.add(obj);
				}
				l2.setPiptteObjList(objList);
				level2List.add(l2);
			}
			
			level1.setLevel2List(level2List);
			result.add(level1);
		}
	    return result;
    }
	
}
