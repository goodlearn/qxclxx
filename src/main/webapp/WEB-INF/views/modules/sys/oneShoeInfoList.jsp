<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>1#轮胎主要参数管理</title>
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
		<li class="active"><a href="${ctx}/sys/oneShoeInfo/">1#轮胎主要参数列表</a></li>
		<shiro:hasPermission name="sys:oneShoeInfo:edit"><li><a href="${ctx}/sys/oneShoeInfo/form">1#轮胎主要参数添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="oneShoeInfo" action="${ctx}/sys/oneShoeInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>序列号：</label>
				<form:input path="xlh" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>车辆管理信息</th>
				<th>序列号</th>
				<th>花纹类型</th>
				<th>轮胎型号</th>
				<th>修复次数</th>
				<th>更新时间</th>
				<shiro:hasPermission name="sys:oneShoeInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="oneShoeInfo">
			<tr>
				<td><a href="${ctx}/sys/oneShoeInfo/form?id=${oneShoeInfo.id}">
					${oneShoeInfo.id}
				</a></td>
				<td>
					${oneShoeInfo.xlh}
				</td>
				<td>
					${oneShoeInfo.hwlx}
				</td>
				<td>
					${oneShoeInfo.ltxh}
				</td>
				<td>
					${oneShoeInfo.xfcs}
				</td>
				<td>
					<fmt:formatDate value="${oneShoeInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="sys:oneShoeInfo:edit"><td>
    				<a href="${ctx}/sys/oneShoeInfo/form?id=${oneShoeInfo.id}">修改</a>
<%-- 					<a href="${ctx}/sys/oneShoeInfo/delete?id=${oneShoeInfo.id}" onclick="return confirmx('确认要删除该1#轮胎主要参数吗？', this.href)">删除</a>
 --%>				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>