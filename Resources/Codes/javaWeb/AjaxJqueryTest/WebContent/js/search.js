$(function(){
	//捕获键盘弹起事件
	$("#word").keyup(function() {
		//获取输入框的值
		var word = $(this).val();
		if(word==""){
			$("#div01").hide();
		}
		else{
			//请求数据
			$.post("find",{word:word} ,function(data , status){
				$("#div01").show();
				$("#div01").html(data);
			});
		}
	})
});