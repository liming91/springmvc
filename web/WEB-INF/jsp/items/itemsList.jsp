<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>查询商品列表</title>
    <script type="text/javascript">
        function deleteItemsBatch() {
            //提交form
            document.itemsForm.action="${pageContext.request.contextPath}/items/deleteItemsBatch.action";
            document.itemsForm.submit();
        }
        function queryItems() {
            //提交form
            document.itemsForm.action="${pageContext.request.contextPath}/items/queryItems.action";
            document.itemsForm.submit();
        }
        function updateItemsBatch() {
            //提交form
            document.itemsForm.action="${pageContext.request.contextPath}/items/updateView.action";
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
                <select name="itemsType">
                    <c:forEach items="${itemsType}" var="item">
                        <option value="${item.key}">${item.value}</option>
                    </c:forEach>
                </select>

            </td>
        </tr>
        <tr>
            <td>
                <input type="button" value="查询" onclick="queryItems()">
                <input type="button" value="批量删除" onclick="deleteItemsBatch()">
                <input type="button" value="批量修改" onclick="updateItemsBatch()">
            </td>
        </tr>
    </table>
商品列表：
    <table width="100%" border="1">
        <tr>
            <td>选择</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>商品描述</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${itemsList}" var="item">
        <tr>
            <td><input type="checkbox" name="items_id" value="${item.id}"></td>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>${item.detail}</td>
            <td>
                <a href="${pageContext.request.contextPath}/items/editItems.action?id=${item.id}">修改</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
