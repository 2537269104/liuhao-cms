//选中左侧的三个标签
		var navArrays = $(".row .nav .nav-link");
		console.log(navArrays);
		//保存当前标签的url
		var currentUrl = $(navArrays[0]).attr("url");
		
		console.log(currentUrl);
		//给导航菜单添加点击事件 且选中点击标签的url值
		$(".row .nav .nav-link").click(function() {
			var url = $(this).attr("url");
			chooseMenu(url);
		});
		////选中当前菜单，根据url，通过ajax加载页面主页面
		function chooseMenu(url, params) {
			//循环遍历左侧的标签
			navArrays.each(function() {
				//取消选中状态
				$(this).removeClass("active");
				//判断当前选中标签并对其进行部分页面刷新加载
				//判断当前url和参数url是否一致
				if ($(this).attr("url") == url) {
					//刷新页面时需选择当前页面的url
					currentUrl = url;
					$(this).addClass("active");
					//加载url返回html，赋值给class=tab-content的div
					$.get(url, params, function(html) {
						$(".tab-content").html(html);
					}, "html")

				}
			})
		}
		//初始化当前页面
		chooseMenu(currentUrl);
		//刷新当前页面的方法
		function reload(params){
			alert("reload:"+currentUrl);
			$.get(currentUrl,params,function(res){
				$(".tab-content").html(res);
			},"html")
		}
		