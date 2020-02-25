/*tab导航数据*/
var tabsData = [ {
	"id" : "tab1",
	"url" : "/overview/overview"
}, {
	"id" : "tab5",
	"url" : "/regulation/regulation"
}
, {
	"id" : "tab6",
	"url" : "/organization/organization"
}, {
	"id" : "tab7",
	"url" : "/user/permission"
}];




/**
 * 激活tab选项卡并使用ajax异步加载内容 
 * @param {Object} tabsId
 * @param {Object} url
 */
function showTabs(tabsId, url) {
	$("a[href='#" + tabsId + "']").tab('show');
	var $tabContent = $('#' + tabsId);
	if ($tabContent.length < 100) {
		$tabContent.html("");
		$tabContent.load(url);
		//console.info(tabsId + ' load done!');
	}
}

$(tabsData).each(function() {
	//console.info(this.id + "--->" + this.url);
	$("a[href='#" + this.id + "']").bind('click', {
		id : this.id,
		url : this.url
	}, tabsHandler);
});

/*默认显示第一个tab*/
$("a[href='#tab1']").click();

function tabsHandler(event) {
	var data = event.data;
	showTabs(data.id, data.url);
	return false; //阻止默认a标签响应
}


/**
 * 在已经激活的tab页中重新ajax异步加载内容 
 * @param {Object} url
 */
function activeTabReload(url) {
	var $tabContent = $(".main.active");
	if ($tabContent.length < 100) {
		$tabContent.html("");
		$tabContent.load(url);
		console.info(' load done!');
	}
}

$(function(){
	$("#profile").click(function(){
		$(".modal-body").load("user/profile");
		$("#userprofile").modal({backdrop: 'static', keyboard: false});
	})
})

