<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>左侧电动轮主要参数管理</title>
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
		<li class="active"><a href="${ctx}/sys/leftMotorWheelInfo/">左侧电动轮主要参数列表</a></li>
		<shiro:hasPermission name="sys:leftMotorWheelInfo:edit"><li><a href="${ctx}/sys/leftMotorWheelInfo/form">左侧电动轮主要参数添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="leftMotorWheelInfo" action="${ctx}/sys/leftMotorWheelInfo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>总成件序号：</label>
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
				<shiro:hasPermission name="sys:leftMotorWheelInfo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="leftMotorWheelInfo">
			<tr>
				<td><a href="${ctx}/sys/leftMotorWheelInfo/form?id=${leftMotorWheelInfo.id}">
					${leftMotorWheelInfo.zcjxlh}
				</a></td>
				<td>
					${leftMotorWheelInfo.ywxcs}
				</td>
				<td>
					${leftMotorWheelInfo.zbxs}
				</td>
				<td>
					${leftMotorWheelInfo.mqsyxs}
				</td>
				<td>
					${leftMotorWheelInfo.wxcj}
				</td>
				<td>
					${leftMotorWheelInfo.wxyy}
				</td>
				<td>
					${leftMotorWheelInfo.bltrsyrq}
				</td>
				<td>
					<fmt:formatDate value="${leftMotorWheelInfo.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${leftMotorWheelInfo.remarks}
				</td>
				<shiro:hasPermission name="sys:leftMotorWheelInfo:edit"><td>
    				<a href="${ctx}/sys/leftMotorWheelInfo/form?id=${leftMotorWheelInfo.id}">修改</a>
					<a href="${ctx}/sys/leftMotorWheelInfo/delete?id=${leftMotorWheelInfo.id}" onclick="return confirmx('确认要删除该左侧电动轮主要参数吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>