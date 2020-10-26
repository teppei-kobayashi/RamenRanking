<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${ranking != null}">
                <h2>ランキング　編集ページ</h2>
                <form method="POST" action="<c:url value='/rankings/update2' />">
                    <c:import url="_form2.jsp" />
                </form>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/rankings/index2' />">一覧に戻る</a></p>
    </c:param>
</c:import>