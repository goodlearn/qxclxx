<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>5#轮胎主要参数管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/fiveShoeInfo/">5#轮胎主要参数列表</a></li>
		<shiro:hasPermission name="sys:fiveShoeInfo:edit"><li><a href="${ctx}/sys/fiveShoeInfo/form">5#轮胎主要参数添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="fiveShoeInfo" action="${ctx}/sys/fiveShoeInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sys:fiveShoeInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="fiveShoeInfo">
			<tr>
				<td><a href="${ctx}/sys/fiveShoeInfo/form?id=${fiveShoeInfo.id}">
					<fmt:formatDate value="${fiveShoeInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</a></td>
				<td>
					${fiveShoeInfo.remarks}
				</td>
				<shiro:hasPermission name="sys:fiveShoeInfo:edit"><td>
    				<a href="${ctx}/sys/fiveShoeInfo/form?id=${fiveShoeInfo.id}">修改</a>
					<a href="${ctx}/sys/fiveShoeInfo/delete?id=${fiveShoeInfo.id}" onclick="return confirmx('确认要删除该5#轮胎主要参数吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>