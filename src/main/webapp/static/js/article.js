$(document).ready(function(){
	//增加文章
	$("#addArticle").click(function(){
		if($("#add_columnId").val() == null || $("#add_columnId").val() == ""){
			alert("请输入栏目id");
			return;
		}
		if($("#add_title").val() == null || $("#add_title").val() == ""){
			alert("请输入标题");
			return;
		}
		if($("#add_content").val() == null || $("#add_content").val() == ""){
			alert("请输入内容");
			return;
		}
		$.post("addArticle",$("#addArticleForm").serialize(),function(data){
			if(data == "success"){
				$('#addArticleModal').modal('hide');
				alert("新增文章成功");
				window.location.href="article";
			}else{
				$('#addArticleModal').modal('hide');
				alert("新增文章失败");
			}
		});
	});
	
	//修改文章
	$("#updateArticleBefore").click(function(){
		var ids = $("input[name='checkedIds']:checked");
		if(ids.length == 0){
			alert("请选择需要修改的数据");
			return;
		}
		if(ids.length > 1){
			alert("请选择一行数据");
			return;
		}
		$.get("getArticleById",{id:$(ids).val()},function(data){
			if(data != null){
				$("#update_id").val(data.id);
				$("#update_columnId").val(data.columnId);
				$("#update_title").val(data.title);
				$("#update_content").val(data.content);
				$("#updateArticleModal").modal({
					show:true
				});
			}
		});
	});
	
	//修改文章
	$("#updateArticle").click(function(){
		$.post("updateArticle",$("#updateArticleForm").serialize(),function(data){
			if(data == "success"){
				$('#updateArticle').modal('hide');
				alert("修改文章成功");
				window.location.href="article";
			}else{
				$('#updateArticle').modal('hide');
				alert("修改文章失败");
				$('#updateArticleModal').modal('hide');
			}
		});
	});
	
	//删除文章
	$("#deleteArticle").click(function(){
		var array = $("input[name='checkedIds']:checked");
		if(array.length == 0){
			alert("请选择需要删除的数据");
			return;
		}
		var ids = new Array();
		$(array).each(function(index, item){
			ids[index] = $(this).val();
		});
		var r = confirm("是否确认删除");
		if (r == true)
		{
			$.post("deleteArticle",{ids:ids},function(data){
				if(data == "success"){
					alert("删除文章成功");
					window.location.href="article";
				}else{
					alert("删除文章失败");
				}
			});
		}
		else
		{
			
		}
	});
});