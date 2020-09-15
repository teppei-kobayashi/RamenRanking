<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ラーメンランキング（仮）</title>
        <link rel="stylesheet" href="<c:url value='/css/reset.css' />">
        <link rel="stylesheet" href="<c:url value='/css/style.css' />">
    </head>
    <body>
        <div id="wrapper">
            <div id="header">
                <div id="header_menu">
                    <h1><a href="<c:url value='/' />">ラーメンランキング（仮）</a></h1>
                    <a href="<c:url value='/' />">投稿</a>
                    <c:if test="${sessionScope.login_employee != null}">
                        <div id="employee_name">
                            <c:out value="${sessionScope.login_employee.name}" />&nbsp;さん&nbsp;&nbsp;&nbsp;
                            <a href="<c:url value='/logout' />">ログアウト</a>
                        </div>
                    </c:if>
                </div>
            </div>
            <div id="content">
                ${param.content}
            </div>
            <div id="footer">
                by Teppei Kobayashi.
            </div>
        </div>
    </body>
</html>