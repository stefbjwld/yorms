
$("#treeviewContainer").load("organization/organizationTree");

function addOrg(){
	
	$("#success").hide();
	$(".alert.alert-danger").hide();
	
	if($("#selectedNodeId").html()==""){
		$("#selectedNode").addClass("red");
		$('#selectedNode').html("请选择父节点");
		return false;
	}
	
	
	$("#operationOrg").removeClass("hide");
	$("#selectedNode").removeClass("red");
	$("#operationOrg").load("organization/organizationAddForm");
	$("#operationOrg").show();
	
	
}


function addOrgSave(){
	var flag = nameCheck($("#name").val()) && nameCheck($("#organization_code").val()) && nameCheck($("#orgDesc").val());
	
	if (!flag) {
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("请正确填写信息")
		$(".alert.alert-danger").show();
		return false;
	}
	
	var data = $('#orgAddForm').serialize();
	//序列化获得表单数据，结果为：user_id=12&user_name=John&user_age=20
	var submitData = decodeURIComponent(data, true);
	var parentId = $("#selectedNodeId").text();
	
	submitData = submitData + "&parentId=" + parentId;
	
	
	$.ajax({
		url : '/organization/organizationAdd',
		type : "GET",//方法类型
		data : submitData,
		cache : false,//false是不缓存，true为缓存
		async : false,//true为异步，false为同步
		dataType : "text",//返回数据的数据类型
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			
			//请求成功时
			 if(result=="success"){
				 $("#success").removeClass("hide");
				 $("#resultSuccessMessage").text("保存成功")
				 $("#success").show();
			 }else{
				 $(".alert.alert-danger").removeClass("hide");
				 $("#checkPromoteMessage").text("保存失败")
				 $(".alert.alert-danger").show();

			 }
		},
		complete : function() {
			userInterfaceReInit();
		},
		error : function() {
			//请求失败时
			userInterfaceReInit();
		}
	});
	
}


function editOrg(){
	
	$("#success").hide();
	$(".alert.alert-danger").hide();
	
	if($("#selectedNodeId").html()==""){
		$("#selectedNode").addClass("red");
		$('#selectedNode').html("请选择节点");
		return false;
	}
	
	var id = $("#selectedNodeId").text();
	
	$("#operationOrg").removeClass("hide");
	$("#selectedNode").removeClass("red");
	$("#operationOrg").html("");
	$("#operationOrg").load("organization/organizationEdit?id="+id);
	$("#operationOrg").show();
}

function editOrgSave(){
	
	var flag = nameCheck($("#name").val()) && nameCheck($("#organization_code").val()) && nameCheck($("#orgDesc").val());
	
	if (!flag) {
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("请正确填写信息")
		$(".alert.alert-danger").show();
		return false;
	}
	
	
	var data = $('#orgEditForm').serialize();
	//序列化获得表单数据，结果为：user_id=12&user_name=John&user_age=20
	var submitData = decodeURIComponent(data, true);
	
	$.ajax({
		url : '/organization/organizationEditSave',
		type : "GET",//方法类型
		data : submitData,
		cache : false,//false是不缓存，true为缓存
		async : false,//true为异步，false为同步
		dataType : "text",//返回数据的数据类型
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			 if(result=="success"){
				 $("#success").removeClass("hide");
				 $("#resultSuccessMessage").text("保存成功")
				 $("#success").show();
				 
			 }else{
				 $(".alert.alert-danger").removeClass("hide");
				 $("#checkPromoteMessage").text("保存失败")
				 $(".alert.alert-danger").show();

			 }
		},
		complete : function() {
			userInterfaceReInit();
		},
		error : function() {
			//请求失败时
			userInterfaceReInit();
		}
	});
}



function deleteOrg(){
	
	$("#success").hide();
	$(".alert.alert-danger").hide();
	
	if($("#selectedNodeId").html()==""){
		$("#selectedNode").addClass("red");
		$('#selectedNode').html("请选择节点");
		return false;
	}
	
	$("#deleteAlertModal").modal({
		backdrop:true,
		show:true
	});	
	$("#deleteConfirmBtn").click(function(){
		/*activeTabReload(href);*/
		var id = $("#selectedNodeId").text();
		var submitData = "id=" + id;
		
		$.ajax({
			url : '/organization/organizationDel',
			type : "GET",//方法类型
			data : submitData,
			cache : false,//false是不缓存，true为缓存
			async : false,//true为异步，false为同步
			dataType : "text",//返回数据的数据类型
			beforeSend : function() {
				//请求前
			},
			success : function(result) {
				//请求成功时
				 if(result=="success"){
					 $("#success").removeClass("hide");
					 $("#resultSuccessMessage").text("删除成功")
					 $("#success").show();
				 }else{
					 $(".alert.alert-danger").removeClass("hide");
					 $("#checkPromoteMessage").text("删除失败")
					 $(".alert.alert-danger").show();
				 }
			},
			complete : function() {
				userInterfaceReInit();
			},
			error : function() {
				//请求失败时
				userInterfaceReInit();
			}
		});
		
		$('#deleteAlertModal').modal('hide');
		$('.modal-backdrop').remove(); 
	})
}



function userInterfaceReInit(){
	$("#treeviewContainer").load("organization/organizationTree");
	 $('#selectedNode').html("");
	 $('#selectedNodeId').html("");
	 $("#operationOrg").html("");
	 $("#operationOrg").hide();
}



/**
 * 命名规约 不能包含特殊字符跟空格，不能为空
 */
function nameCheck(s) {
	var regex = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
	var re = new RegExp(regex);
	
	if (re.test(s)&&nameNotNull(s)) {
		return true;
	} else {
		return false;
	}
}

/**
 * 不为空
 */
function nameNotNull(s) {
	if (s == "") {
		return false;
	} else {
		return true;
	}
}