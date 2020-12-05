<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>查询商品列表</title>
    <script type="text/javascript">
        function updateItemsBatch() {
            //提交form
            document.itemsForm.action="${pageContext.request.contextPath}/items/updateItemsBatch.action";
            document.itemsForm.submit();
        }
        function queryItems() {
            //提交form
            document.itemsForm.action="${pageContext.request.contextPath}/items/queryItems.action";
            document.itemsForm.submit();
        }
    </script>
</head>
<body>
<form name="itemsForm" method="post">
查询条件：
    <table width="100%" border="1">
        <tr>
            <td>
                商品名称：<input type="text" name="itemsCustom.name">
            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="查询" onclick="queryItems()">
                <input type="button" value="批量修改" onclick="updateItemsBatch()">
            </td>
        </tr>
    </table>
商品列表：
    <table width="100%" border="1">
        <tr>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>生产日期</td>
            <td>商品描述</td>
        </tr>
        <c:forEach items="${itemsList}" var="item" varStatus="status">
            <input type="hidden" name="itemsCustomList[${status.index }].id" value="${item.id}"/>
            <tr>
            <td><input type="text" name="itemsCustomList[${status.index }].name" value="${item.name}"/></td>
            <td><input type="text" name="itemsCustomList[${status.index }].price" value="${item.price}"/></td>
            <td><input type="text" name ="itemsCustomList[${status.index }].createtime" value="<fmt:formatDate value="${item.createtime}"  pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
            <td>
                <input type="text" name="itemsCustomList[${status.index }].detail" value="${item.detail}"/>
            </td>
        </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
