<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>包机负责人信息管理</title>
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
		<li class="active"><a href="${ctx}/sys/charterInfo/">包机负责人信息列表</a></li>
		<shiro:hasPermission name="sys:charterInfo:edit"><li><a href="${ctx}/sys/charterInfo/form">包机负责人信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="charterInfo" action="${ctx}/sys/charterInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>工种：</label>
				<form:input path="profession" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>联系方式：</label>
				<form:input path="contact" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>归属包机：</label>
				<form:input path="charterId" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>工种</th>
				<th>姓名</th>
				<th>联系方式</th>
				<th>归属包机</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sys:charterInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="charterInfo">
			<tr>
				<td><a href="${ctx}/sys/charterInfo/form?id=${charterInfo.id}">
					${charterInfo.profession}
				</a></td>
				<td>
					${charterInfo.name}
				</td>
				<td>
					${charterInfo.contact}
				</td>
				<td>
					${charterInfo.charterId}
				</td>
				<td>
					<fmt:formatDate value="${charterInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${charterInfo.remarks}
				</td>
				<shiro:hasPermission name="sys:charterInfo:edit"><td>
    				<a href="${ctx}/sys/charterInfo/form?id=${charterInfo.id}">修改</a>
					<a href="${ctx}/sys/charterInfo/delete?id=${charterInfo.id}" onclick="return confirmx('确认要删除该包机负责人信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>