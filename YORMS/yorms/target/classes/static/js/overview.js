//
var materialsPriceTotal = echarts.init(document.getElementById('businessStatus'));
var materialsPriceTotalOption = {
		toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: false, readOnly: false},
	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
		xAxis: {
	        type: 'category',
	        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: [120, 200, 150, 80, 70, 110, 130],
	        type: 'line'
	    }]
	};
materialsPriceTotal.setOption(materialsPriceTotalOption);


//
var materialInPriceRanking = echarts.init(document.getElementById('orsRadarView'));

var materialInPriceRankingOption = {
		toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: false, readOnly: false},
	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
		xAxis: {
	        type: 'category',
	        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: [120, 200, 150, 80, 70, 110, 130],
	        type: 'bar'
	    }]
	};
materialInPriceRanking.setOption(materialInPriceRankingOption);



//
/*var materialsPriceRanking = echarts.init(document.getElementById('businessStatus'));
var materialsPriceRankingOption = {
	    tooltip: {
	        trigger: 'item',
	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	    },
	    legend: {
	        orient: 'vertical',
	        x: 'left',
	        data:['轮胎','电脑','发电机','饮水机','空调']
	    },
	    series: [
	        {
	            name:'占比',
	            type:'pie',
	            radius: ['50%', '70%'],
	            avoidLabelOverlap: false,
	            label: {
	                normal: {
	                    show: false,
	                    position: 'center'
	                },
	                emphasis: {
	                    show: true,
	                    textStyle: {
	                        fontSize: '30',
	                        fontWeight: 'bold'
	                    }
	                }
	            },
	            labelLine: {
	                normal: {
	                    show: false
	                }
	            },
	            data:[
	                {value:335, name:'轮胎'},
	                {value:310, name:'电脑'},
	                {value:234, name:'发电机'},
	                {value:135, name:'饮水机'},
	                {value:1548, name:'空调'}
	            ]
	        }
	    ]
	};
materialsPriceRanking.setOption(materialsPriceRankingOption);*/


//常用物资commonMaterials
var commonMaterials = echarts.init(document.getElementById('workOverview'));
var commonMaterialsOption = {
	    tooltip: {
	        trigger: 'axis',
	        formatter: function (params) {
	            params = params[0];
	            return params.name + ' : ' + params.value;
	        },
	        axisPointer: {
	            animation: false
	        }
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: false, readOnly: false},
	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    xAxis: {
	        splitLine: {
	            show: false
	        },
	        data : ['04-01','04-02','04-03','04-04','04-05','04-06','04-07','04-08','04-09','04-10','04-11','04-12']
	    },
	    yAxis: [
	        {
	        	position:'left',
	        	type: 'value',
	        	splitArea : {show : true},//保留网格区域
	        	splitLine: {
	        		show: false
	        	}
	        }
	    ],
	    series: [{
            name: '交易量',
            type: 'bar',
		    itemStyle : {
		    	normal : {
		    		color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B',
                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[(params.dataIndex)%15]
                    },
		    		borderWidth : '0'
		    	}
		    },
		    barWidth:20,
            data:[600, 800, 600, 700, 900, 850, 900,950,1000,1060,1100,1200]
        }]

	};
commonMaterials.setOption(commonMaterialsOption);