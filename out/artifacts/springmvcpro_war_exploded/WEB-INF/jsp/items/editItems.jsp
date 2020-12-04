<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>商品修改页面</title>
</textarea>
</head>
<body>
<form id="itemForm" action="${pageContext.request.contextPath}/items/editItemsSubmit.action" method="post" enctype="multipart/form-data">
   <input type="hidden" name="id" value="${itemsCustom.id}">
    修改商品信息:
    <table width="100%" border="1">
        <tr>
            <td>商品名称</td>
            <td><input type="text" name ="name" value="${itemsCustom.name}"></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><input type="text" name ="price" value="${itemsCustom.price}"></td>
        </tr>
        <tr>
            <td>日期</td>
            <td>
                <input type="text" name ="createtime" value="<fmt:formatDate value="${itemsCustom.createtime}"  pattern="yyyy-MM-dd HH:mm:ss"/>">
            </td>
        </tr>
        <tr>
            <td>商品图片</td>
            <td>
                <c:if test="${itemsCustom.price!=null}">
                    <img src="/springmvc_img/${itemsCustom.pic}" width="100" height="100"/>
                </c:if>
                <input type="file" name="multipartFile"/>
            </td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td>
                <textarea name="detail" rows="8" cols="30">${itemsCustom.detail}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="4" align="center" >
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
