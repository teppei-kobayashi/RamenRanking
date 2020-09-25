<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${errors != null}">
    <div id="flush_error">
        入力内容にエラーがあります。<br />
        <c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" /><br />
        </c:forEach>

    </div>
</c:if>

<label for="name">ラーメン名</label><br />
<input type="text" name="name" value="${ramen.name}" />
<br /><br />

<label for="title">種類</label><br />
<input type="text" name="type" value="${ramen.type}" />
<br /><br />


<label for="content">内容</label><br />
<textarea name="content" rows="10" cols="50">${ramen.content}</textarea>
<br /><br />

<label for="price">価格</label><br />
<input type="text" name="price" value="${ramen.price}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">投稿</button>