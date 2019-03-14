<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>快递助手 -- 锡职快递服务平台</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<link href="${ctxStatic}/wx/wxcss/normalize.css" type="text/css" rel="stylesheet" />
	<link href="${ctxStatic}/wx/wxcss/common.css" type="text/css" rel="stylesheet" />
	<script src="${ctxStatic}/wx/wxjs/jquery.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/wx/wxjs/qrcode.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/wx/wxjs/common.js" type="text/javascript"></script>
</head>
<body>
	 <ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sys/carInfo/">车辆信息</a></li>
	</ul>
	<form:form class="form-horizontal">
	<sys:message content="${message}"/>
		<fieldset>
				<legend>车辆信息</legend>
				<table class="table-form">
					<tr>
						<td class="tit">车型</td>
						<td colspan="2">${carInfo.motorcycleType}</td>
						<td class="tit">编号</td>
						<td colspan="2">${carInfo.seriaNumber}</td>							
						<td class="tit">投入使用日期</td>
						<td colspan="2">${carInfo.inputTime}</td>				
						<td class="tit">目前运行时间</td>
						<td colspan="2">${carInfo.runDate}</td>
					</tr>
					<c:forEach items="${carInfo.charterInfos}" var="charterinfo" varStatus="status">
							<tr>
								<td class="tit">包机负责人</td>
								<td colspan="2">${charterinfo.name}</td>
								<td class="tit">工种</td>
								<td colspan="2">${charterinfo.profession}</td>
								<td class="tit">联系方式</td>
								<td colspan="4">${charterinfo.contact}</td>
							</tr>
					</c:forEach>
				</table>
<%-- 				<legend>包机人信息</legend>
				<table class="table-form">
					<c:forEach items="${carInfo.charterInfos}" var="charterinfo" varStatus="status">
							<tr>
								<td class="tit">工种</td>
								<td colspan="2">${charterinfo.profession}</td>
								<td class="tit">姓名</td>
								<td colspan="2">${charterinfo.name}</td>
								<td class="tit">联系方式</td>
								<td colspan="2">${charterinfo.contact}</td>
							</tr>
					</c:forEach>
				</table>
 --%>			<legend>发动机主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">总成件序列号</td>
						<td colspan="2">${carInfo.engineInfo.zcjxlh}</td>
						<td class="tit">已维修次数</td>
						<td colspan="2">${carInfo.engineInfo.ywxcs}</td>
						<td class="tit">质保小时</td>
						<td colspan="2">${carInfo.engineInfo.zbxs}</td>
						<td class="tit">目前使用小时</td>
						<td colspan="2">${carInfo.engineInfo.mqsyxs}</td>
					</tr>
					<tr>
						<td class="tit">维修厂家</td>
						<td colspan="2">${carInfo.engineInfo.wxcj}</td>
						<td class="tit">本轮投入使用日期</td>
						<td colspan="2">${carInfo.engineInfo.bltrsyrq}</td>
						<td class="tit">维修原因</td>
						<td colspan="4">${carInfo.engineInfo.wxyy}</td>
					</tr>
				</table>
				<legend>主发电机主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">总成件序列号</td>
						<td colspan="2">${carInfo.mainDynamoInfo.zcjxlh}</td>
						<td class="tit">已维修次数</td>
						<td colspan="2">${carInfo.mainDynamoInfo.ywxcs}</td>
						<td class="tit">质保小时</td>
						<td colspan="2">${carInfo.mainDynamoInfo.zbxs}</td>
						<td class="tit">目前使用小时</td>
						<td colspan="2">${carInfo.mainDynamoInfo.mqsyxs}</td>
					</tr>
					<tr>
						<td class="tit">维修厂家</td>
						<td colspan="2">${carInfo.mainDynamoInfo.wxcj}</td>
						<td class="tit">本轮投入使用日期</td>
						<td colspan="2">${carInfo.mainDynamoInfo.bltrsyrq}</td>
						<td class="tit">维修原因</td>
						<td colspan="4">${carInfo.mainDynamoInfo.wxyy}</td>
					</tr>
				</table>
				<legend>左侧电动轮主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">总成件序列号</td>
						<td colspan="2">${carInfo.leftMonotrwheelInfo.zcjxlh}</td>
						<td class="tit">已维修次数</td>
						<td colspan="2">${carInfo.leftMonotrwheelInfo.ywxcs}</td>
						<td class="tit">质保小时</td>
						<td colspan="2">${carInfo.leftMonotrwheelInfo.zbxs}</td>
						<td class="tit">目前使用小时</td>
						<td colspan="2">${carInfo.leftMonotrwheelInfo.mqsyxs}</td>
					</tr>
					<tr>
						<td class="tit">维修厂家</td>
						<td colspan="2">${carInfo.leftMonotrwheelInfo.wxcj}</td>
						<td class="tit">本轮投入使用日期</td>
						<td colspan="2">${carInfo.leftMonotrwheelInfo.bltrsyrq}</td>
						<td class="tit">维修原因</td>
						<td colspan="4">${carInfo.leftMonotrwheelInfo.wxyy}</td>
					</tr>
				</table>
				<legend>右侧电动轮主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">总成件序列号</td>
						<td colspan="2">${carInfo.rightMotorWheelInfo.zcjxlh}</td>
						<td class="tit">已维修次数</td>
						<td colspan="2">${carInfo.rightMotorWheelInfo.ywxcs}</td>
						<td class="tit">质保小时</td>
						<td colspan="2">${carInfo.rightMotorWheelInfo.zbxs}</td>
						<td class="tit">目前使用小时</td>
						<td colspan="2">${carInfo.rightMotorWheelInfo.mqsyxs}</td>
					</tr>
					<tr>
						<td class="tit">维修厂家</td>
						<td colspan="2">${carInfo.rightMotorWheelInfo.wxcj}</td>
						<td class="tit">本轮投入使用日期</td>
						<td colspan="2">${carInfo.rightMotorWheelInfo.bltrsyrq}</td>
						<td class="tit">维修原因</td>
						<td colspan="4">${carInfo.rightMotorWheelInfo.wxyy}</td>
					</tr>
				</table>
				<legend>箱斗主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">总成件序列号</td>
						<td colspan="2">${carInfo.boxBucketInfo.zcjxlh}</td>
						<td class="tit">已维修次数</td>
						<td colspan="2">${carInfo.boxBucketInfo.ywxcs}</td>
						<td class="tit">质保小时</td>
						<td colspan="2">${carInfo.boxBucketInfo.zbxs}</td>
						<td class="tit">目前使用小时</td>
						<td colspan="2">${carInfo.boxBucketInfo.mqsyxs}</td>
					</tr>
					<tr>
						<td class="tit">维修厂家</td>
						<td colspan="2">${carInfo.boxBucketInfo.wxcj}</td>
						<td class="tit">本轮投入使用日期</td>
						<td colspan="2">${carInfo.boxBucketInfo.bltrsyrq}</td>
						<td class="tit">维修原因</td>
						<td colspan="4">${carInfo.boxBucketInfo.wxyy}</td>
					</tr>
				</table>
				<legend>1#轮胎主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">序列号</td>
						<td colspan="2">${carInfo.oneShoeInfo.xlh}</td>
						<td class="tit">花纹类型</td>
						<td colspan="2">${carInfo.oneShoeInfo.hwlx}</td>
						<td class="tit">轮胎型号</td>
						<td colspan="2">${carInfo.oneShoeInfo.ltxh}</td>
						<td class="tit">修复次数</td>
						<td colspan="2">${carInfo.oneShoeInfo.xfcs}</td>
						<td class="tit">使用时间</td>
						<td colspan="2">${carInfo.oneShoeInfo.sysj}</td>
					</tr>
				</table>
				<legend>2#轮胎主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">序列号</td>
						<td colspan="2">${carInfo.twoShoeInfo.xlh}</td>
						<td class="tit">花纹类型</td>
						<td colspan="2">${carInfo.twoShoeInfo.hwlx}</td>
						<td class="tit">轮胎型号</td>
						<td colspan="2">${carInfo.twoShoeInfo.ltxh}</td>
						<td class="tit">修复次数</td>
						<td colspan="2">${carInfo.twoShoeInfo.xfcs}</td>
						<td class="tit">使用时间</td>
						<td colspan="2">${carInfo.twoShoeInfo.sysj}</td>
					</tr>
				</table>
				<legend>3#轮胎主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">序列号</td>
						<td colspan="2">${carInfo.threeShoeInfo.xlh}</td>
						<td class="tit">花纹类型</td>
						<td colspan="2">${carInfo.threeShoeInfo.hwlx}</td>
						<td class="tit">轮胎型号</td>
						<td colspan="2">${carInfo.threeShoeInfo.ltxh}</td>
						<td class="tit">修复次数</td>
						<td colspan="2">${carInfo.threeShoeInfo.xfcs}</td>
						<td class="tit">使用时间</td>
						<td colspan="2">${carInfo.threeShoeInfo.sysj}</td>
					</tr>
				</table>
				<legend>4#轮胎主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">序列号</td>
						<td colspan="2">${carInfo.fourShoeInfo.xlh}</td>
						<td class="tit">花纹类型</td>
						<td colspan="2">${carInfo.fourShoeInfo.hwlx}</td>
						<td class="tit">轮胎型号</td>
						<td colspan="2">${carInfo.fourShoeInfo.ltxh}</td>
						<td class="tit">修复次数</td>
						<td colspan="2">${carInfo.fourShoeInfo.xfcs}</td>
						<td class="tit">使用时间</td>
						<td colspan="2">${carInfo.fourShoeInfo.sysj}</td>
					</tr>
				</table>
				<legend>5#轮胎主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">序列号</td>
						<td colspan="2">${carInfo.fiveShoeInfo.xlh}</td>
						<td class="tit">花纹类型</td>
						<td colspan="2">${carInfo.fiveShoeInfo.hwlx}</td>
						<td class="tit">轮胎型号</td>
						<td colspan="2">${carInfo.fiveShoeInfo.ltxh}</td>
						<td class="tit">修复次数</td>
						<td colspan="2">${carInfo.fiveShoeInfo.xfcs}</td>
						<td class="tit">使用时间</td>
						<td colspan="2">${carInfo.fiveShoeInfo.sysj}</td>
					</tr>
				</table>
					<legend>6#轮胎主要参数</legend>
				<table class="table-form">
					<tr>
						<td class="tit">序列号</td>
						<td colspan="2">${carInfo.sixShoeInfo.xlh}</td>
						<td class="tit">花纹类型</td>
						<td colspan="2">${carInfo.sixShoeInfo.hwlx}</td>
						<td class="tit">轮胎型号</td>
						<td colspan="2">${carInfo.sixShoeInfo.ltxh}</td>
						<td class="tit">修复次数</td>
						<td colspan="2">${carInfo.sixShoeInfo.xfcs}</td>
						<td class="tit">使用时间</td>
						<td colspan="2">${carInfo.sixShoeInfo.sysj}</td>
					</tr>
				</table>
			</fieldset>
			<div class="form-actions">
				<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
			</div>
		</form:form>
</body>
</html>