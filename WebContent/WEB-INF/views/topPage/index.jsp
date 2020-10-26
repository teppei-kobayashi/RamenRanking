<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>ラーメンランキングへようこそ</h2>
        <h3>【ラーメンランキング　一覧】</h3>
        <h2>${ranking.point}</h2>
        <table id="ranking_list">
            <tbody>

                <tr>
                    <th class="ranking">順位</th>
                    <th class="ranking_name">ラーメン名</th>
                    <th class="ranking_point">ポイント</th>
                </tr>
                <c:forEach var="ranking" items="${rankings}" varStatus="status"  >
                    <tr class="row${status.count % 2}">
                        <td class="ranking"><c:out value="${status.count}"/>位</td>
                        <td class="ranking_name"><c:out value="${ranking.ramen_name}" /></td>
                        <td class="ranking_point"><c:out value="${ranking.point}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:param>
</c:import>