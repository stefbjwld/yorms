function regulationAdd(){
	activeTabReload("/regulation/regulationAdd");
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