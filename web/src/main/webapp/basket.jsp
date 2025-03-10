<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>
<body>
<form id="frm" method="post" action="./paylist.do">
<p>장바구니</p>
<div style="display: flex; width: 300px;">
<input type="checkbox" name="p" id="p1" value="399000" data-name="프리즘코리아 CP55G5" onclick="price()">
    <span style="flex: 1; text-align: left; margin-left: 1px;">프리즘코리아 CP55G5</span>
    <span style="text-align: right; width: 120px;">399900 원</span>
</div>

<div style="display: flex; width: 300px;">
<input type="checkbox" name="p" id="p2" value="2192810" data-name="삼성전자 QLED KQ85" onclick="price()">
    <span style="flex: 1; text-align: left; margin-left: 1px;">삼성전자 QLED KQ85</span>
    <span style="text-align: right; width: 120px;">2192810 원</span>
</div>

<div style="display: flex; width: 300px;">
<input type="checkbox" name="p" id="p3" value="2732230" data-name="LG전자 올레드 evo" onclick="price()">
    <span style="flex: 1; text-align: left; margin-left: 1px;">LG전자 올레드 evo</span>
    <span style="text-align: right; width: 120px;">2732230 원</span>
</div>

<div style="display: flex; width: 300px;">
<input type="checkbox" name="p" id="p4" value="359000" data-name="이스트라 스마트 TV" onclick="price()">
    <span style="flex: 1; text-align: left; margin-left: 1px;">이스트라 스마트 TV</span>
    <span style="text-align: right; width: 120px;">359000 원</span>
</div>

<div style="display: flex; width: 300px;">
<input type="checkbox" name="p" id="p5" value="790000" data-name="LG전자 울트라 HD" onclick="price()">
    <span style="flex: 1; text-align: left; margin-left: 1px;">LG전자 울트라 HD</span>
    <span style="text-align: right; width: 120px;">790000 원</span>
</div>

<p>최종 결제 금액 : <input type="text" name="total" id ="total" value="0" readonly style="width: 100px; text-align: right;"> 원<p>
<br>
<input type="button" value="결제하기" onclick="pay()">
</form>
</body>
<script>


</script>
</html>