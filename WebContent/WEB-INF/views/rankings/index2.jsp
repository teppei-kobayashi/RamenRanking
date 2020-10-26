<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>ランキング　一覧</h2>
        <table id="ramen_list">
            <tbody>
                <tr>
                     <th class="ramen_name">ラーメン名</th>
                    <th class="ramen_type">種類</th>
                    <th class="ramen_content">タイトル</th>
                    <th class="ramen_action">操作</th>
                </tr>
                <c:forEach var="ramen" items="${ramens}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="ramen_name"><c:out value="${ramen.name}" /></td>
                        <td class="ramen_type"><c:out value="${ramen.type}" /></td>
                        <td class="ramen_content">${ramen.content}</td>
                        <td class="rament_action"><a href="<c:url value='/rankings/show2?id=${ramen.id}' />">詳細を見る</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${ramens_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((ramens_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/rankings/index2?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

    </c:param>
</c:import>