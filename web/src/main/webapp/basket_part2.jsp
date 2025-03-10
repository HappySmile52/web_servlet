<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> product_nm = (ArrayList<String>)request.getAttribute("product_nm");
	ArrayList<String> product_p = (ArrayList<String>)request.getAttribute("product_p");
    String price = (String)request.getAttribute("price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구매확정 물품</title>
</head>
<body>
<form id="frm" method="post" action="http://172.30.1.17:8080/web/mallok1.do">
<p>구매 확정 물품</p>
<%
	for(int f = 0; f < product_nm.size(); f++){
		String product_name = product_nm.get(f);
		String product_price = product_p.get(f);
		out.print("<p style='width: 250px; display: flex; justify-content: space-between;'><span>" + product_name + "</span><span>" + product_price + "</span></p>");
	}
%>
<br>
최종 결제 금액 : <input type="text" name="price" value="<%=price%>" readonly style="width: 100px; text-align: right;"> 원<br><br>
<p>결제수단</p>
<label><input type="radio" name="pay" value="신용카드">신용카드</label><br>
<label><input type="radio" name="pay" value="가상계좌">가상계좌</label><br>
<label><input type="radio" name="pay" value="휴대폰 결제">휴대폰 결제</label><br>
<label><input type="radio" name="pay" value="무통장 입금">무통장 입금</label><br><br>
<input type="button" value="결제진행" onclick="pay_ing()">
</form>
</body>
<script>
function pay_ing(){	
	var pay = document.getElementsByName("pay");
	
	var pay_ch = false;
	for(var f = 0; f < pay.length; f++){
		if(pay[f].checked){
			pay_ch = true;
			break;
		}
	}
	
	if(pay_ch){
		frm.submit();
	}
	else{
		alert("결제수단을 선택해주세요.");
	}
}
</script>
</html>