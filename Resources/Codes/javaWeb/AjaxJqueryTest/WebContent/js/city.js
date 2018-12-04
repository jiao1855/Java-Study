$(function() {
		//当省份改变时，查询该省份下的城市
		$("#province").change(function() {
			//获取省份
			var pid = $(this).val();
			$.post("CityServlet",{pid:pid},function(data,status){
				//先清空以前的值：
				$("#city").html("<option value='' >-请选择-")
				
				//从data数据里面找出所有的city， 然后遍历所有的city。
				//遍历一个city，就执行一次function方法
				$(data).find("city").each(function() {
					
					//遍历出来的每一个city，取它的孩子。 id , name
					var id = $(this).children("id").text();
					var name = $(this).children("name").text();
					
					$("#city").append("<option value='"+id+"' >"+name)
				});
			});
		});
});