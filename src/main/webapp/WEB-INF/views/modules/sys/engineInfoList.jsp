<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>发动机主要参数管理</title>
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
		<li class="active"><a href="${ctx}/sys/engineInfo/">发动机主要参数列表</a></li>
		<shiro:hasPermission name="sys:engineInfo:edit"><li><a href="${ctx}/sys/engineInfo/form">发动机主要参数添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="engineInfo" action="${ctx}/sys/engineInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>总成件序列号：</label>
				<form:input path="zcjxlh" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>总成件序列号</th>
				<th>已维修次数</th>
				<th>质保小时</th>
				<th>目前使用小时</th>
				<th>维修厂家</th>
				<th>维修原因</th>
				<th>本轮投入使用日期</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sys:engineInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="engineInfo">
			<tr>
				<td><a href="${ctx}/sys/engineInfo/form?id=${engineInfo.id}">
					${engineInfo.zcjxlh}
				</a></td>
				<td>
					${engineInfo.ywxcs}
				</td>
				<td>
					${engineInfo.zbxs}
				</td>
				<td>
					${engineInfo.mqsyxs}
				</td>
				<td>
					${engineInfo.wxcj}
				</td>
				<td>
					${engineInfo.wxyy}
				</td>
				<td>
					${engineInfo.bltrsyrq}
				</td>
				<td>
					<fmt:formatDate value="${engineInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${engineInfo.remarks}
				</td>
				<shiro:hasPermission name="sys:engineInfo:edit"><td>
    				<a href="${ctx}/sys/engineInfo/form?id=${engineInfo.id}">修改</a>
					<a href="${ctx}/sys/engineInfo/delete?id=${engineInfo.id}" onclick="return confirmx('确认要删除该发动机主要参数吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>