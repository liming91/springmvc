<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8" >
    <title>json交互的测试</title>
  <%-- <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.1.1.min.js"></script>--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
    <script type="text/javascript">
        //请求的是json，输出的是json
        function requestJson() {
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/jsonTest/requestJson.action",
                contentType:"application/json;charset=UTF-8",
                data: JSON.stringify({"name":"手机","price":999}),
                success: function(data){
                    //返回json
                    alert( "data: " + data );
                },
                error:function (error) {
                    alert( "error: " + error );
                }
            });
        }
        //请求的是key/value，输出的是json
        function  responseJson() {

        }

    </script>
</head>
<body>
<input type="button" onclick="requestJson()" value="请求的是json,输出的是json"/>
<input type="button" onclick="responseJson()" value="请求的是key/value,输出的是json"/>
</body>
</html>
