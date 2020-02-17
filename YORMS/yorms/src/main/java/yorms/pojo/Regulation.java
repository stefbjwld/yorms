package yorms.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Regulation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	/**制度名称*/
	@Column(nullable = false, unique = true)
    private String regulationName;
	
	
	/**制度分类*/
	@Column(nullable = false, unique = true)
    private String regulationCategory;
	
	/**文号*/
	@Column(nullable = false, unique = true)
	private String referenceNumber;
	
	/**发布机构*/
	@Column(nullable = false, unique = true)
	private String publisher;
	
	/**上传部门*/
	@OneToOne(targetEntity = Organization.class)
	private Organization uploadOrg;
	
	/**提交时间*/
	private Date uploadDate;
	
	
	@OneToMany(targetEntity = Attachment.class)
    private List<Attachment> attachments;
	
	
}
