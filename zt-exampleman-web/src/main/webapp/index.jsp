<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>测试页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   	<a href="/service?cid=2&cmd=01&version=1.0&loginname=1&pwd=1231&tid=1&pid=1&ip=10.10.10.1&verify=993fdac8833e5b7fd66bfb10c2090b28">账户登陆测试</a>
   	<a href="/service?cid=2&cmd=02&version=1.0&ip=192.168.31.132&verify=a1de4ef54793dfcccfe07047e1f904e8&sid=_account-3-RniXK6MXQ7bp9sLw5Kcd&pid=1&ip=192.168.31.132">账户登出测试</a>
   	<a href="/service?cid=2&cmd=03&version=1.0&accountname=1&loginname=w2&pwd=2&tid=1&pid=1&ip=10.10.10.1&verify=20175611d054398e1972bda2152956d7">员工登陆测试</a>
   	<a href="/service?cid=2&cmd=05&version=1.0&sid=_account-4-XCPWVlC9PaDDwlPbrwbT&verify=66490f5d6dfdc45d47fce1acd519806d">SESSION验证测试</a>
   	<a href="/service?cid=2&cmd=06&version=1.0&sid=_account-4-XCPWVlC9PaDDwlPbrwbT&verify=0b44469ef2e5f29e54421cf43a60639b">会话心跳测试</a>
   	<a href="/service?cid=2&cmd=07&version=1.0&sid=_user-14-TiuAoecOkNpm0zc5QNBe&verify=52aa4c416fe9851d827a3daa3f67ff23">清除会话测试</a>
   	<a href="/service?cid=2&cmd=08&version=1.0&sid=_account-3-lNWwOHYGkJnFAhWMDdP1&tid=2&pid=1&ip=10.10.10.1&verify=8184b4c90c7d4ddfadfd7ca94697556a">其他终端登陆测试</a>
  </body>
</html>
