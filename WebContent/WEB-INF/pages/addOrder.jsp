<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>addOrder</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("input[name='odrCustomerName']").blur(function(){
			var odrCustomerName = $(this).val();
			var span = $("#span");
			$.ajax({
				url:"${pageContext.request.contextPath}/sale/findCustomerByName",
				type:"post",
				dataType:"text",
				data:{odrCustomerName:odrCustomerName},
				success:function(data){
					//alert(data);
					if(data==0){
						span.html("客户不存在");
						$("input[name='submit']").attr("disabled",true);
					}else{
						span.html("");
						$("input[name='submit']").attr("disabled",false);
					}
					
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
		})
	})
</script>
</head>
<body>
	<p>您所在的位置：销售管理>添加订单</p>
	<form action="${pageContext.request.contextPath}/sale/addOrder" method="get">
		<table border="1" cellspacing="0" width="800px">
			<tr>
				<td>订单编号</td>
				<td width="300px"><input type="text" name="orderId" value="${requestScope.orderId}" readonly="readonly"></td>
				<td>下单日期</td>
				<td width="300px"><input type="text" name="odrOrderDateStr" value="${requestScope.odrOrderDate}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>客户名称</td>
				<td width="300px"><input type="text" name="odrCustomerName"><span id="span"></span></td>
				<td>送货时间</td>
				<td width="300px"><input type="text" name="odrDeliverDateStr"></td>
			</tr>
			<tr>
				<td>送货地址</td>
				<td colspan="3"><input type="text" name="odrDeliverAddr" style="width:450px;"></td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center">
					<input type="button" value="保存">&nbsp&nbsp
					<input type="submit" value="提交" name="submit">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>