<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>addOrder</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
<script type="text/javascript">

	$(function(){
		$("select[name='productId']").change(function(){
			var productId = $(this).val();
			$.ajax({
				url:"${pageContext.request.contextPath}/sale/findProductById",
				type:"post",
				dataType:"text",
				data:{productId:productId},
				success:function(data){
					//alert(data);
					$("input[name=price]").attr("value",data);
				},
				error:function(x,msg,obj){
					alert(msg);
				}
			})
		})
	})
	
	$(function(){
		$("input[name='count']").blur(function(){
			var count = $(this).val();
			var price = $("input[name='price']").val();
			var sum = count*price;
			$("input[name='sum']").attr("value",sum);
		})
	})
	
	$(function(){
		$("#button").click(function(){
			var productId = $("select[name='productId']").val();
			var price = $("input[name='price']").val();
			var count = $("input[name='count']").val();
			var sum = $("input[name='sum']").val();
			var tr = $("#addTr");
			var option = $("#option");
			var input1 = $("input[name='price']");
			var input2 = $("input[name='count']");
			var input3 = $("input[name='sum']");
			$.ajax({
				url:"${pageContext.request.contextPath}/sale/addOrderLine",
				type:"post",
				dataType:"text",
				data:{productId:productId,count:count},
				success:function(data){
					//alert(data);
					tr.before(
						"<tr><td>"+data+"</td><td>"+price+"</td><td>"+count+"</td><td>"+sum+"</td><td><button>删除</button></td></tr>"		
					);
					option.attr("selected","selected");
					input1.val("");
					input2.val("");
					input3.val("");
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
	<table border="1" cellspacing="0" width="800px">
		<tr>
			<td>订单编号</td>
			<td width="300px">${requestScope.order.odrId}</td>
			<td>下单日期</td>
			<td width="300px"><f:formatDate value="${requestScope.order.odrOrderDate}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>客户名称</td>
			<td width="300px">${requestScope.order.odrCustomerName}</td>
			<td>送货时间</td>
			<td width="300px"><f:formatDate value="${requestScope.order.odrDeliverDate}" pattern="yyyy-MM-dd"/></td>
		</tr>
		<tr>
			<td>送货地址</td>
			<td colspan="3">${requestScope.order.odrDeliverAddr}</td>
		</tr>
	</table>
	<table border="1" cellspacing="0" width="800px">
		<tr>
			<td>产品名称</td>
			<td>单价</td>
			<td>数量</td>
			<td>总价</td>
			<td>操作</td>
		</tr>
		<tr id="addTr">
			<td>
				<select name="productId">
					 <option value="0" id="option" >请选择</option>
					 <c:forEach items="${requestScope.pList}" var="product">
					 	<option value="${product.prodId}">${product.prodName}-${product.prodPrice}</option>
					 </c:forEach>
				</select>
			</td>
			<td><input type="text" name="price" value=""></td>
			<td><input type="text" name="count" value=""></td>
			<td><input type="text" name="sum" value=""></td>
			<td><button id="button">保存订单行</button></td>
		</tr>
		<tr>
			<td colspan="5" style="text-align:center">
				<button onclick="window.open('${pageContext.request.contextPath}/sale/success')">保存</button>&nbsp&nbsp
				<button onclick="window.open('${pageContext.request.contextPath}/sale/success')">提交</button>
			</td>
		</tr>
	</table>
</body>
</html>