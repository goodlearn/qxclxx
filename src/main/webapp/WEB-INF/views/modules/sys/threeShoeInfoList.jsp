<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>3#轮胎主要参数管理</title>
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
		<li class="active"><a href="${ctx}/sys/threeShoeInfo/">3#轮胎主要参数列表</a></li>
		<shiro:hasPermission name="sys:threeShoeInfo:edit"><li><a href="${ctx}/sys/threeShoeInfo/form">3#轮胎主要参数添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="threeShoeInfo" action="${ctx}/sys/threeShoeInfo/" method="post" class="breadcrumb form-search">
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
				<th>车辆关联信息</th>
				<th>序列号</th>
				<th>花纹类型</th>
				<th>轮胎型号</th>
				<th>修复次数</th>
				<th>使用时间</th>
				<th>更新时间</th>
				<shiro:hasPermission name="sys:threeShoeInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="threeShoeInfo">
			<tr>
				<td><a href="${ctx}/sys/threeShoeInfo/form?id=${threeShoeInfo.id}">
					${threeShoeInfo.id}
				</a></td>
				<td>
					${threeShoeInfo.xlh}
				</td>
				<td>
					${threeShoeInfo.hwlx}
				</td>
				<td>
					${threeShoeInfo.ltxh}
				</td>
				<td>
					${threeShoeInfo.xfcs}
				</td>
				<td>
					${threeShoeInfo.sysj}
				</td>
				<td>
					<fmt:formatDate value="${threeShoeInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="sys:threeShoeInfo:edit"><td>
    				<a href="${ctx}/sys/threeShoeInfo/form?id=${threeShoeInfo.id}">修改</a>
<%-- 					<a href="${ctx}/sys/threeShoeInfo/delete?id=${threeShoeInfo.id}" onclick="return confirmx('确认要删除该3#轮胎主要参数吗？', this.href)">删除</a>
 --%>				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>