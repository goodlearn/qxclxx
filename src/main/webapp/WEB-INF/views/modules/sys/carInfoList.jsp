<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>车辆信息管理</title>
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
		<li class="active"><a href="${ctx}/sys/carInfo/">车辆信息列表</a></li>
		<shiro:hasPermission name="sys:carInfo:edit"><li><a href="${ctx}/sys/carInfo/form">车辆信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="carInfo" action="${ctx}/sys/carInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>车型：</label>
				<form:input path="motorcycleType" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>编号：</label>
				<form:input path="seriaNumber" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>车型</th>
				<th>编号</th>
				<th>投入时间</th>
				<th>运行时间</th>
				<th>包机负责人</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sys:carInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="carInfo">
			<tr>
				<td><a href="${ctx}/sys/carInfo/form?id=${carInfo.id}">
					${carInfo.motorcycleType}
				</a></td>
				<td>
					${carInfo.seriaNumber}
				</td>
				<td>
					${carInfo.inputTime}
				</td>
				<td>
					${carInfo.runDate}
				</td>
				<td>
					${carInfo.charterId}
				</td>
				<td>
					<fmt:formatDate value="${carInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${carInfo.remarks}
				</td>
				<shiro:hasPermission name="sys:carInfo:edit"><td>
    				<a href="${ctx}/sys/carInfo/form?id=${carInfo.id}">修改</a>
					<a href="${ctx}/sys/carInfo/delete?id=${carInfo.id}" onclick="return confirmx('确认要删除该车辆信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>