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
        <table id="ranking_list">
            <tbody>
                <tr>
                    <th class="ramen_name">ラーメン名</th>
                    <th class="ranking_product">味</th>
                    <th class="ranking_price">価格</th>
                    <th class="ranking_place">場所</th>
                    <th class="ranking_action">操作</th>
                </tr>
                <c:forEach var="ranking" items="${rankings}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td class="ramen_name"><c:out value="${ranking.id}" /></td>
                        <td class="ranking_product">${ranking.product}</td>
                        <td class="ranking_price">${ranking.price}</td>
                        <td class="ranking_place">${ranking.place}</td>
                        <td class="ranking_action"><a href="<c:url value='/rankings/show?id=${ranking.id}' />">得点をつける</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <div id="pagination">
            （全 ${rankings_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((rankings_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/rankings/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

    </c:param>
</c:import>