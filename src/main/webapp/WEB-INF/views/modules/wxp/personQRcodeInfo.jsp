<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>车辆信息</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<link href="${ctxStatic}/wx/wxcss/index.css" type="text/css" rel="stylesheet" />
	<link href="${ctxStatic}/wx/wxcss/common.css" type="text/css" rel="stylesheet" />
	<script src="${ctxStatic}/wx/wxjs/jquery.min.js" type="text/javascript"></script>
	<script src="${ctxStatic}/wx/wxjs/common.js" type="text/javascript"></script>
	<style type="text/css">
		*{
			margin: 0px;
			padding: 0px;
		}
		body{
			background: #f1f1f1;
		}
		.content{
			width: 100%;
			max-width: 600px;
			margin: 0 auto;
			padding-top: 20px;
			padding-bottom: 20px;
			background: #fff;

			font-size: 16px;
			color: #000004;
			font-family: '微软雅黑';
		}
		.logo{
			width: 30%;
			margin: 0px auto;
			overflow: hidden;
		}

		.ws-title{
			width: 96%;
			margin: 0 auto;
			line-height: 40px;
		}

		.car-info{
			width: 96%;
			margin: 0px auto 20px;
			border-collapse:collapse;
		}
		.car-info th{
			height: 50px;
			color: #000004;
			background: #f7f7ff;
			border:1px solid #dddddd;
			text-align: center;
		}
		.car-info td{
			height: 50px;
			border:1px solid #dddddd;
			text-align: center;
		}
		.car-info td:nth-child(1){
			width: 130px;
		}

		.person-info{
			width: 96%;
			margin: 0px auto 20px;
			border-collapse:collapse;
		}
		.person-info th{
			height: 50px;
			color: #000004;
			background: #e7eaef;
			text-align: center;
		}
		.person-info td{
			height: 50px;
			text-align: center;
			overflow: hidden;
			text-overflow: ellipsis;
			white-space: nowrap;
		}
		.person-info tr:nth-child(odd){
			background: #f8f3f7;
		}
	</style>
</head>
<body>
	<input id="PageContext" type="hidden" value="${pageContext.request.contextPath}" />
	<div class="content">
		<div class="logo">
			<img src="../static/wx/wximages/toptitle.png" width="100%" alt="">
		</div>
		<div class="ws-title">班组口号：脚踏实地，百折不挠。</div>
		<div class="logo">
			<img src="${carInfo.imgurl}" width="100%" alt="">
		</div>
		<div class="ws-title">${carInfo.kh}</div>
		<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">车辆信息</th>
			</tr>
			<tr>
				<td>车型</td>
				<td>${carInfo.motorcycleType}</td>
			</tr>
			<tr>
				<td>编号</td>
				<td>${carInfo.seriaNumber}</td>
			</tr>
			<tr>
				<td>投入使用日期</td>
				<td>${carInfo.inputTime}</td>
			</tr>
			<tr>
				<td>目前运行时间</td>
				<td>${carInfo.runDate}</td>
			</tr>
		</table>
	
		<table class="person-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="3">包机负责人</th>
			</tr>
			<tr>
				<td>工种</td>
				<td>姓名</td>
				<td>联系方式</td>
			</tr>
			<c:forEach items="${carInfo.charterInfos}" var="charterinfo" varStatus="status">
					<tr>
						<td>${charterinfo.name}</td>
						<td>${charterinfo.profession}</td>
						<td>${charterinfo.contact}</td>
					</tr>
			</c:forEach>
		</table>
	
		<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">发送机主要参数</th>
			</tr>
			<tr>
				<td>总成件序列号</td>
				<td>${carInfo.engineInfo.zcjxlh}</td>
			</tr>
			<tr>
				<td>已维修次数</td>
				<td>${carInfo.engineInfo.ywxcs}</td>
			</tr>
			<tr>
				<td>质保小时</td>
				<td>${carInfo.engineInfo.zbxs}</td>
			</tr>
			<tr>
				<td>目前使用小时</td>
				<td>${carInfo.engineInfo.mqsyxs}</td>
			</tr>
			<tr>
				<td>维修厂家</td>
				<td>${carInfo.engineInfo.wxcj}</td>
			</tr>
			<tr>
				<td>本轮投入使用日期</td>
				<td>${carInfo.engineInfo.bltrsyrq}</td>
			</tr>
			<tr>
				<td>维修原因</td>
				<td>${carInfo.engineInfo.wxyy}</td>
			</tr>
		</table>
	
		<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">主发电机主要参数</th>
			</tr>
			<tr>
				<td>总成件序列号</td>
				<td>${carInfo.mainDynamoInfo.zcjxlh}</td>
			</tr>
			<tr>
				<td>已维修次数</td>
				<td>${carInfo.mainDynamoInfo.ywxcs}</td>
			</tr>
			<tr>
				<td>质保小时</td>
				<td>${carInfo.mainDynamoInfo.zbxs}</td>
			</tr>
			<tr>
				<td>目前使用小时</td>
				<td>${carInfo.mainDynamoInfo.mqsyxs}</td>
			</tr>
			<tr>
				<td>维修厂家</td>
				<td>${carInfo.mainDynamoInfo.wxcj}</td>
			</tr>
			<tr>
				<td>本轮投入使用日期</td>
				<td>${carInfo.mainDynamoInfo.bltrsyrq}</td>
			</tr>
			<tr>
				<td>维修原因</td>
				<td>${carInfo.mainDynamoInfo.wxyy}</td>
			</tr>
		</table>
		
		
		<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">左侧电动轮主要参数</th>
			</tr>
			<tr>
				<td>总成件序列号</td>
				<td>${carInfo.leftMonotrwheelInfo.zcjxlh}</td>
			</tr>
			<tr>
				<td>已维修次数</td>
				<td>${carInfo.leftMonotrwheelInfo.ywxcs}</td>
			</tr>
			<tr>
				<td>质保小时</td>
				<td>${carInfo.leftMonotrwheelInfo.zbxs}</td>
			</tr>
			<tr>
				<td>目前使用小时</td>
				<td>${carInfo.leftMonotrwheelInfo.mqsyxs}</td>
			</tr>
			<tr>
				<td>维修厂家</td>
				<td>${carInfo.leftMonotrwheelInfo.wxcj}</td>
			</tr>
			<tr>
				<td>本轮投入使用日期</td>
				<td>${carInfo.leftMonotrwheelInfo.bltrsyrq}</td>
			</tr>
			<tr>
				<td>维修原因</td>
				<td>${carInfo.leftMonotrwheelInfo.wxyy}</td>
			</tr>
		</table>
		
		<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">右侧电动轮主要参数</th>
			</tr>
			<tr>
				<td>总成件序列号</td>
				<td>${carInfo.rightMotorWheelInfo.zcjxlh}</td>
			</tr>
			<tr>
				<td>已维修次数</td>
				<td>${carInfo.rightMotorWheelInfo.ywxcs}</td>
			</tr>
			<tr>
				<td>质保小时</td>
				<td>${carInfo.rightMotorWheelInfo.zbxs}</td>
			</tr>
			<tr>
				<td>目前使用小时</td>
				<td>${carInfo.rightMotorWheelInfo.mqsyxs}</td>
			</tr>
			<tr>
				<td>维修厂家</td>
				<td>${carInfo.rightMotorWheelInfo.wxcj}</td>
			</tr>
			<tr>
				<td>本轮投入使用日期</td>
				<td>${carInfo.rightMotorWheelInfo.bltrsyrq}</td>
			</tr>
			<tr>
				<td>维修原因</td>
				<td>${carInfo.rightMotorWheelInfo.wxyy}</td>
			</tr>
		</table>
		
		<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">箱斗主要参数</th>
			</tr>
			<tr>
				<td>总成件序列号</td>
				<td>${carInfo.boxBucketInfo.zcjxlh}</td>
			</tr>
			<tr>
				<td>已维修次数</td>
				<td>${carInfo.boxBucketInfo.ywxcs}</td>
			</tr>
			<tr>
				<td>质保小时</td>
				<td>${carInfo.boxBucketInfo.zbxs}</td>
			</tr>
			<tr>
				<td>目前使用小时</td>
				<td>${carInfo.boxBucketInfo.mqsyxs}</td>
			</tr>
			<tr>
				<td>维修厂家</td>
				<td>${carInfo.boxBucketInfo.wxcj}</td>
			</tr>
			<tr>
				<td>本轮投入使用日期</td>
				<td>${carInfo.boxBucketInfo.bltrsyrq}</td>
			</tr>
			<tr>
				<td>维修原因</td>
				<td>${carInfo.boxBucketInfo.wxyy}</td>
			</tr>
		</table>
		
		<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">1#轮胎主要参数</th>
			</tr>
			<tr>
				<td>序列号</td>
				<td>${carInfo.oneShoeInfo.xlh}</td>
			</tr>
			<tr>
				<td>花纹类型</td>
				<td>${carInfo.oneShoeInfo.hwlx}</td>
			</tr>
			<tr>
				<td>轮胎型号</td>
				<td>${carInfo.oneShoeInfo.ltxh}</td>
			</tr>
			<tr>
				<td>修复次数</td>
				<td>${carInfo.oneShoeInfo.xfcs}</td>
			</tr>
			<tr>
				<td>使用时间</td>
				<td>${carInfo.oneShoeInfo.sysj}</td>
			</tr>
		</table>
		
		<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">2#轮胎主要参数</th>
			</tr>
			<tr>
				<td>序列号</td>
				<td>${carInfo.twoShoeInfo.xlh}</td>
			</tr>
			<tr>
				<td>轮胎品牌</td>
				<td>${carInfo.twoShoeInfo.hwlx}</td>
			</tr>
			<tr>
				<td>轮胎型号</td>
				<td>${carInfo.twoShoeInfo.ltxh}</td>
			</tr>
			<tr>
				<td>修复次数</td>
				<td>${carInfo.twoShoeInfo.xfcs}</td>
			</tr>
			<tr>
				<td>使用时间</td>
				<td>${carInfo.twoShoeInfo.sysj}</td>
			</tr>
		</table>
		
			<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">3#轮胎主要参数</th>
			</tr>
			<tr>
				<td>序列号</td>
				<td>${carInfo.threeShoeInfo.xlh}</td>
			</tr>
			<tr>
				<td>花纹类型</td>
				<td>${carInfo.threeShoeInfo.hwlx}</td>
			</tr>
			<tr>
				<td>轮胎型号</td>
				<td>${carInfo.threeShoeInfo.ltxh}</td>
			</tr>
			<tr>
				<td>修复次数</td>
				<td>${carInfo.threeShoeInfo.xfcs}</td>
			</tr>
			<tr>
				<td>使用时间</td>
				<td>${carInfo.threeShoeInfo.sysj}</td>
			</tr>
		</table>
		
			<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">4#轮胎主要参数</th>
			</tr>
			<tr>
				<td>序列号</td>
				<td>${carInfo.fourShoeInfo.xlh}</td>
			</tr>
			<tr>
				<td>花纹类型</td>
				<td>${carInfo.fourShoeInfo.hwlx}</td>
			</tr>
			<tr>
				<td>轮胎型号</td>
				<td>${carInfo.fourShoeInfo.ltxh}</td>
			</tr>
			<tr>
				<td>修复次数</td>
				<td>${carInfo.fourShoeInfo.xfcs}</td>
			</tr>
			<tr>
				<td>使用时间</td>
				<td>${carInfo.fourShoeInfo.sysj}</td>
			</tr>
		</table>
		
			<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">5#轮胎主要参数</th>
			</tr>
			<tr>
				<td>序列号</td>
				<td>${carInfo.fiveShoeInfo.xlh}</td>
			</tr>
			<tr>
				<td>花纹类型</td>
				<td>${carInfo.fiveShoeInfo.hwlx}</td>
			</tr>
			<tr>
				<td>轮胎型号</td>
				<td>${carInfo.fiveShoeInfo.ltxh}</td>
			</tr>
			<tr>
				<td>修复次数</td>
				<td>${carInfo.fiveShoeInfo.xfcs}</td>
			</tr>
			<tr>
				<td>使用时间</td>
				<td>${carInfo.fiveShoeInfo.sysj}</td>
			</tr>
		</table>
		
			<table class="car-info" cellspacing="0" cellpadding="0">
			<tr>
				<th colspan="2">6#轮胎主要参数</th>
			</tr>
			<tr>
				<td>序列号</td>
				<td>${carInfo.sixShoeInfo.xlh}</td>
			</tr>
			<tr>
				<td>花纹类型</td>
				<td>${carInfo.sixShoeInfo.hwlx}</td>
			</tr>
			<tr>
				<td>轮胎型号</td>
				<td>${carInfo.sixShoeInfo.ltxh}</td>
			</tr>
			<tr>
				<td>修复次数</td>
				<td>${carInfo.sixShoeInfo.xfcs}</td>
			</tr>
			<tr>
				<td>使用时间</td>
				<td>${carInfo.sixShoeInfo.sysj}</td>
			</tr>
		</table>
		
	</div>
</body>
</html>