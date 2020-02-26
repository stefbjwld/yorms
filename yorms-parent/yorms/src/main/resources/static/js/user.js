/**
 * 显示用户管理界面
 */
function showUserManage(){
	activeTabReload("/user/userManage");
}

/**
 * 显示用户组管理界面
 */
function showGroupManage(){
	activeTabReload("/user/groupManage");
}

/**
 * 显示角色管理界面
 */
function showRoleManage(){
	activeTabReload("/user/roleManage");
}



/**
 * 新增用户
 */
function userAdd(){
	activeTabReload("/user/userAdd");
}




/**
 * 新增用户——提交
 */
function userAddSave(){
	
	if ($("#username").val() == "" || $("#password").val() == "") {
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("正确填写信息")
		$(".alert.alert-danger").show();
		return false;
	}
		
	/**
	 * 用户JSON数据
	 */
	var userInfo = {
		"userName" : "",
		"password" : "",
		"company" : "",
		"userDesc" : "",
		"enable" : "",
		"groups" :{},
		"roles":{}
	};

	userInfo.userName=$("#userName").val();
	userInfo.password=md5($("#password").val());
	userInfo.company=$("#company").val();
	userInfo.userDesc=$("#userDesc").val();
	userInfo.enable=$("#enable").val();

	var groupIdArray = $('select[id^=groupId]');
	
	for(var i=0;i<groupIdArray.length;i++){
		userInfo.groups["groupId"+i] = $(groupIdArray[i]).val();
		
	}
	
	
	var roleIdArray = $('select[id^=roleId]');
	
	for(var i=0;i<roleIdArray.length;i++){
		userInfo.roles["roleId"+i] = $(roleIdArray[i]).val();
		
	}	
	
	var groupsJson = userInfo.groups;
	var arrGroups = [];
	for(var i in groupsJson){
		arrGroups.push(groupsJson[i]);
	}
	
	var rolesJson = userInfo.roles;
	var arrRoles = [];
	for(var i in rolesJson){
		arrRoles.push(rolesJson[i]);
	}
	
	if(!unique(arrGroups)){
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("用户组不能重复，请删除重复项")
		$(".alert.alert-danger").show();
		return false;
	}
	
	if(!unique(arrRoles)){
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("角色不能重复，请删除重复项")
		$(".alert.alert-danger").show();
		return false;
	}
		
	var dataSumit = JSON.stringify(userInfo);
	console.info(dataSumit);
	
	$.ajax({
		url : '/user/userAdd',
		type: "POST",//方法类型
		data : dataSumit,
		cache : false,//false是不缓存，true为缓存
		async : true,//true为异步，false为同步
		contentType: "application/json; charset=utf-8",
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			activeTabReload("user/userManage");
		},
		complete : function(data) {
			//请求结束时
		},
		error : function(e) {
			//请求失败时
			var responseTextObject = JSON.parse(e.responseText); 
			$(".alert.alert-danger").removeClass("hide");
			$("#checkPromoteMessage").text("服务器内部错误,错误码："+responseTextObject.status+"可能的原因有：服务器异常、名称重复等")
			$(".alert.alert-danger").show();
		}
	});
}


/**
 * 删除用户
 */
function userDel(thisButton){
	var href = $(thisButton).attr("href");
	$("#deleteAlertModal").modal({
		backdrop:true,
		show:true
	});	
	$("#deleteConfirmBtn").click(function(){
		activeTabReload(href);
		$('#deleteAlertModal').modal('hide');
		$('.modal-backdrop').remove(); 
	})
}


/**
 * 编辑用户
 */
function userEdit(thisButton){
	
	if ($("#repositoryName").val() == "" || $("#repositoryDesc").val() == "") {
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("正确填写信息")
		$(".alert.alert-danger").show();
		return false;
	}
	
	var href = $(thisButton).attr("href");
	activeTabReload(href);
}



/**
 * 编辑用户——提交
 */
function userEditSave(page,size){
	
	var flag = nameCheck($("#userName").val())&&nameCheck($("#company").val())&&nameCheck($("#userDesc").val());
	
	if (!flag) {
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("正确填写信息")
		$(".alert.alert-danger").show();
		return false;
	}
		
	/**
	 * 用户JSON数据
	 */
	var userInfo = {
		"id":"",
		"userName" : "",
		"company" : "",
		"userDesc" : "",
		"enable" : "",
		"groups" :{},
		"roles":{}
	};
	
	
	userInfo.id=$("#id").val();
	userInfo.userName=$("#userName").val();
	userInfo.company=$("#company").val();
	userInfo.userDesc=$("#userDesc").val();
	userInfo.enable=$("#enable").val();
	
	
	
	var groupIdArray = $('select[id^=groupId]');
	
	for(var i=0;i<groupIdArray.length;i++){
		userInfo.groups["groupId"+i] = $(groupIdArray[i]).val();
		
	}
	
	
	var roleIdArray = $('select[id^=roleId]');
	
	for(var i=0;i<roleIdArray.length;i++){
		userInfo.roles["roleId"+i] = $(roleIdArray[i]).val();
		
	}	
	
	var groupsJson = userInfo.groups;
	var arrGroups = [];
	for(var i in groupsJson){
		arrGroups.push(groupsJson[i]);
	}
	
	var rolesJson = userInfo.roles;
	var arrRoles = [];
	for(var i in rolesJson){
		arrRoles.push(rolesJson[i]);
	}
	
	if(!unique(arrGroups)){
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("用户组不能重复，请删除重复项")
		$(".alert.alert-danger").show();
		return false;
	}
	
	if(!unique(arrRoles)){
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("角色不能重复，请删除重复项")
		$(".alert.alert-danger").show();
		return false;
	}
		
	var dataSumit = JSON.stringify(userInfo);
	console.info(dataSumit);
	
	$.ajax({
		url : '/user/userEdit',
		type: "POST",//方法类型
		data : dataSumit,
		cache : false,//false是不缓存，true为缓存
		async : false,//true为异步，false为同步
		contentType: "application/json; charset=utf-8",
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			activeTabReload("user/userManage?page="+ page +"&size=" + size);
		},
		complete : function(data) {
			//请求结束时
		},
		error : function(e) {
			//请求失败时
			var responseTextObject = JSON.parse(e.responseText); 
			$(".alert.alert-danger").removeClass("hide");
			$("#checkPromoteMessage").text("服务器内部错误,错误码："+responseTextObject.status+"可能的原因有：服务器异常、名称重复等")
			$(".alert.alert-danger").show();
		}
	});
}

/**
 * 附加组
 */
function addAuxiliaryGroup(){
	
	var selectOpiton = "";
	
	$.ajax({
		url : '/user/groupJSON',
		type : "GET",//方法类型
		cache : false,//false是不缓存，true为缓存
		async : true,//true为异步，false为同步
		dataType : "json",//返回数据的数据类型
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			
			for (var i = 0; i < result.length; i++) {
				//result[i]表示获得第i个json对象即JSONObject
				//result[i]通过.字段名称即可获得指定字段的值
				/*if(defaultOption == result[i].groupName){
					selectOpiton = selectOpiton + "<option selected=\"selected\">" + result[i].groupName + "</option>";
				}*/
				selectOpiton = selectOpiton + "<option value = "+ result[i].id +">"
						+ result[i].groupName + "</option>";
			}
			
			var oldId = $("#roleRowDom").prev().children("td:nth-child(2)").find("select").attr("id");
			var oldIdNum = parseInt(oldId.replace(/[^0-9]/ig,"")); 
			var newIdNum = 1;
			if( isNaN(oldIdNum)){
			}else{
				newIdNum = oldIdNum + 1;
			}
			var newIdString = "groupId" + newIdNum;
			
			$("#roleRowDom").before("<tr>" +
										"<td class=\"lefttd\"><label for=\"userName\">附加组</label></td>" +
										"<td><select class=\"form-control\" name=\""+ newIdString +"\" id=\""+ newIdString +"\">" + selectOpiton + "</select></td>" +
										"<td><button class=\"btn btn-danger btn-xs margin-left\" onclick=\"delAuxiliaryGroup(this)\" type=\"button\">删除</button></td>" +
									"</tr>");

		},
		complete : function() {
			//请求结束时
		},
		error : function() {
			//请求失败时
			$("#roleRowDom").before("<tr><td class=\"lefttd\"><label for=\"userName\">附加用户组</label></td><td><select class=\"form-control\"><option>数据读取失败</option></select></td></tr>");
		}
	});
	
	
	
}


function delAuxiliaryRole(thisButton){
	$(thisButton).parent().parent().remove();
}

function delAuxiliaryGroup(thisButton){
	$(thisButton).parent().parent().remove();
}


/**
 * 附加角色
 */
function addAuxiliaryRole(){
	
	var selectOpiton = "";
	
	$.ajax({
		url : '/user/roleJSON',
		type : "GET",//方法类型
		cache : false,//false是不缓存，true为缓存
		async : true,//true为异步，false为同步
		dataType : "json",//返回数据的数据类型
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			
			for (var i = 0; i < result.length; i++) {
				//result[i]表示获得第i个json对象即JSONObject
				//result[i]通过.字段名称即可获得指定字段的值
				/*if(defaultOption == result[i].groupName){
					selectOpiton = selectOpiton + "<option selected=\"selected\">" + result[i].groupName + "</option>";
				}*/
				selectOpiton = selectOpiton + "<option value = "+ result[i].id +">"
						+ result[i].authorityName + "</option>";
			}
			
			
			var oldId = $("#sumit").prev().children("td:nth-child(2)").find("select").attr("id");
			var oldIdNum = parseInt(oldId.replace(/[^0-9]/ig,"")); 
			var newIdNum = 1;
			if( isNaN(oldIdNum)){
			}else{
				newIdNum = oldIdNum + 1;
			}
			var newIdString = "roleId" + newIdNum;
			
			

			$("#sumit").before("<tr>"+
										"<td class=\"lefttd\"><label for=\"userName\">其他角色</label></td>"+
										"<td><select class=\"form-control\" name=\"" + newIdString+ "\" id=\""+ newIdString+ "\">" + selectOpiton + "</select>" +"</td>" +
										"<td><button class=\"btn btn-danger btn-xs margin-left\" onclick=\"delAuxiliaryRole(this)\" type=\"button\">删除</button></td>" +
									"</tr>");

		},
		complete : function() {
			//请求结束时
		},
		error : function() {
			//请求失败时
			$("#sumit").before("<tr><td class=\"lefttd\"><label for=\"userName\">其他角色</label></td><td><select class=\"form-control\"><option>数据读取失败</option></select></td></tr>");
		}
	});
	
	
	
}

/**
 * 用户筛选
 */
function userFilter(){
	
	var data = $('#userFilterForm').serialize();
	//序列化获得表单数据，结果为：user_id=12&user_name=John&user_age=20
	var submitData = decodeURIComponent(data, true);
	//submitData是解码后的表单数据，结果同上
	
	activeTabReload("user/userFilter?" + submitData);
}


























/**
 * 新增用户组
 */
function groupAdd(){
	activeTabReload("/user/groupAdd");
}


/**
 * 新增用户组——提交
 */
function groupAddSave(){
	
	var flag = nameCheck($("#groupName").val()) && nameCheck($("#groupDesc").val());
	
	if (!flag) {
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("请正确填写信息，用户组名及描述仅能输入字母、数字、中文，不能包含特殊字符")
		$(".alert.alert-danger").show();
		return false;
	}
	
	var data = $('#groupAddForm').serialize();
	//序列化获得表单数据，结果为：user_id=12&user_name=John&user_age=20
	var submitData = decodeURIComponent(data, true);
	//submitData是解码后的表单数据，结果同上
	$.ajax({
		url : '/user/groupAdd',
		type: "POST",//方法类型
		data : submitData,
		cache : false,//false是不缓存，true为缓存
		async : true,//true为异步，false为同步
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			activeTabReload("user/groupManage");
		},
		complete : function(data) {
			//请求结束时
		},
		error : function(e) {
			//请求失败时
			var responseTextObject = JSON.parse(e.responseText); 
			$(".alert.alert-danger").removeClass("hide");
			$("#checkPromoteMessage").text("服务器内部错误,错误码："+responseTextObject.status+"可能的原因有：服务器异常、名称重复等")
			$(".alert.alert-danger").show();
		}
	});
}

/**
 * 编辑用户组
 */
function groupMEdit(thisButton){
	
	var href = $(thisButton).attr("href");
	activeTabReload(href);
}


/**
 * 编辑用户组——提交
 */
function groupEditSave(page,size){
	
	var flag = nameCheck($("#groupName").val()) && nameCheck($("#groupDesc").val());
	
	if (!flag) {
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("请正确填写信息，用户组名及描述仅能输入字母、数字、中文，不能包含特殊字符")
		$(".alert.alert-danger").show();
		return false;
	}
	
	var data = $('#groupEditForm').serialize();
	//序列化获得表单数据，结果为：user_id=12&user_name=John&user_age=20
	var submitData = decodeURIComponent(data, true);
	//submitData是解码后的表单数据，结果同上
	$.ajax({
		url : '/user/groupEdit',
		type: "POST",//方法类型
		data : submitData,
		cache : false,//false是不缓存，true为缓存
		async : true,//true为异步，false为同步
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			activeTabReload("user/groupManage?page="+ page +"&size=" + size);
		},
		complete : function(data) {
			//请求结束时
		},
		error : function(e) {
			//请求失败时
			var responseTextObject = JSON.parse(e.responseText); 
			$(".alert.alert-danger").removeClass("hide");
			$("#checkPromoteMessage").text("服务器内部错误,错误码："+responseTextObject.status+"可能的原因有：服务器异常、名称重复等")
			$(".alert.alert-danger").show();
		}
	});
}

/**
 * 用户组赋权保存
 */
function groupAuthorityGrantSave(page,size){
	
	/**
	 * 用户组赋权JSON数据
	 */
	var groupInfo = {
		"id":"",
		"roles":{}
	};
	
	groupInfo.id=$("#id").val();
	
	var roleIdArray = $('select[id^=roleId]');
	
	for(var i=0;i<roleIdArray.length;i++){
		groupInfo.roles["roleId"+i] = $(roleIdArray[i]).val();
		
	}
	
	var rolesJson = groupInfo.roles;
	var arrRoles = [];
	for(var i in rolesJson){
		arrRoles.push(rolesJson[i]);
	}
	
	if(!unique(arrRoles)){
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("角色不能重复，请删除重复项")
		$(".alert.alert-danger").show();
		return false;
	}
		
	var dataSumit = JSON.stringify(groupInfo);
	console.info(dataSumit);
	
	$.ajax({
		url : '/user/groupAuthorityGrant',
		type: "POST",//方法类型
		data : dataSumit,
		cache : false,//false是不缓存，true为缓存
		async : false,//true为异步，false为同步
		contentType: "application/json; charset=utf-8",
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			activeTabReload("user/groupManage?page="+ page +"&size=" + size);
		},
		complete : function(data) {
			//请求结束时
		},
		error : function(e) {
			//请求失败时
			var responseTextObject = JSON.parse(e.responseText); 
			$(".alert.alert-danger").removeClass("hide");
			$("#checkPromoteMessage").text("服务器内部错误,错误码："+responseTextObject.status+"可能的原因有：服务器异常、信息重复等")
			$(".alert.alert-danger").show();
		}
	});
}

/**
 * 取消赋权
 */
function groupAuthorityGrantCancel(page,size){
	activeTabReload("user/groupManage?page="+ page +"&size=" + size);
}

/**
 * 删除所有组角色
 */
function delAllRoles(){
	$("#groupDescTr").nextUntil("#sumit").remove();
}








/**
 * 新增角色
 */
function roleAdd(){
	activeTabReload("/user/roleAdd");
}
/**
 * 新增角色——提交
 */
function roleAddSave(){
	
	var flag = nameCheck($("#authorityName").val()) && nameCheck($("#authorityDesc").val());
	
	if (!flag) {
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("请正确填写信息，角色名及描述仅能输入字母、数字、中文，不能包含特殊字符")
		$(".alert.alert-danger").show();
		return false;
	}
	
	var data = $('#authorityAddForm').serialize();
	//序列化获得表单数据，结果为：user_id=12&user_name=John&user_age=20
	var submitData = decodeURIComponent(data, true);
	//submitData是解码后的表单数据，结果同上
	$.ajax({
		url : '/user/roleAdd',
		type: "POST",//方法类型
		data : submitData,
		cache : false,//false是不缓存，true为缓存
		async : true,//true为异步，false为同步
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			activeTabReload("user/roleManage");
		},
		complete : function(data) {
			//请求结束时
		},
		error : function(e) {
			//请求失败时
			var responseTextObject = JSON.parse(e.responseText); 
			$(".alert.alert-danger").removeClass("hide");
			$("#checkPromoteMessage").text("服务器内部错误,错误码："+responseTextObject.status+"\n\n"+"角色名不能重复")
			$(".alert.alert-danger").show();
		}
	});
}
/**
 * 编辑角色
 */
function roleEdit(thisButton){
	var href = $(thisButton).attr("href");
	activeTabReload(href);
}


/**
 * 编辑角色——提交
 */
function roleEditSave(page,size){
	
	var flag = nameCheck($("#authorityName").val()) && nameCheck($("#authorityDesc").val());
	
	if (!flag) {
		$(".alert.alert-danger").removeClass("hide");
		$("#checkPromoteMessage").text("请正确填写信息，角色及描述仅能输入字母、数字、中文，不能包含特殊字符")
		$(".alert.alert-danger").show();
		return false;
	}
	
	var data = $('#authorityEditForm').serialize();
	//序列化获得表单数据，结果为：user_id=12&user_name=John&user_age=20
	var submitData = decodeURIComponent(data, true);
	//submitData是解码后的表单数据，结果同上
	$.ajax({
		url : '/user/roleEdit',
		type: "POST",//方法类型
		data : submitData,
		cache : false,//false是不缓存，true为缓存
		async : true,//true为异步，false为同步
		beforeSend : function() {
			//请求前
		},
		success : function(result) {
			//请求成功时
			activeTabReload("user/roleManage?page="+ page +"&size=" + size);
		},
		complete : function(data) {
			//请求结束时
		},
		error : function(e) {
			//请求失败时
			var responseTextObject = JSON.parse(e.responseText); 
			$(".alert.alert-danger").removeClass("hide");
			$("#checkPromoteMessage").text("服务器内部错误,错误码："+responseTextObject.status+"\n\n"+"角色名不能重复")
			$(".alert.alert-danger").show();
		}
	});
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

function nameNotNull(s) {
	if (s == "") {
		return false;
	} else {
		return true;
	}
}



/**
 * 查重
 */
function unique(arr){
	arr.sort();
    for (var i =1;i<arr.length;i++){
    	if(arr[i] == arr[i-1]){
    		return false;
    	}
    }
    
    return true;
}

/**
 * 分页请求
 */
function pageSumit(pageFunction,page,size,sort) {
	
	
	var data = "page="+page+"&size="+size;
	
	var dataFilterCriteria = $('#userFilterForm').serialize();
	//序列化获得表单数据，结果为：user_id=12&user_name=John&user_age=20
	var submitData = decodeURIComponent(dataFilterCriteria, true);	
	
	activeTabReload(pageFunction + "?" + data + "&" + submitData);
}