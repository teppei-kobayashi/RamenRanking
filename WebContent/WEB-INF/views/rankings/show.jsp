<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${ranking != null}">
                <h2>ランキング　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${ranking.id}" /></td>
                        </tr>
                        <tr>
                            <th>味</th>
                            <td>
                                <pre><c:out value="${ranking.product}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>価格</th>
                            <td>
                                <pre><c:out value="${ranking.price}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>アクセス</th>
                            <td>
                                <pre><c:out value="${ranking.place}" /></pre>
                            </td>
                        </tr>
                    </tbody>
                </table>
                    <p><a href="<c:url value="/rankings/edit?id=${ranking.id}" />">この日報を編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/rankings/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>