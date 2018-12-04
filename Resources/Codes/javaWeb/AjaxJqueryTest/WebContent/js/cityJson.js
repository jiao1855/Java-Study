$(function() {
	//当省份改变时，查询该省份下的城市
	$("#province").change(function() {
		//获取省份
		var pid = $(this).val();
		$.post("CityJsonServlet",{pid:pid},function(data,status){
			//先清空
			$("#city").html("<option value='' >-请选择-");
			//再遍历，追加
			$(data).each(function(index , c) {
				$("#city").append("<option value='"+c.id+"' >"+c.name)
			});
		},"json" );
	});
});