<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${ramen != null}">
                <h2>ラーメン　詳細ページ</h2>

                <table>
                    <tbody>
                        <tr>
                            <th>氏名</th>
                            <td><c:out value="${ramen.name}" /></td>
                        </tr>
                        <tr>
                            <th>種類</th>
                            <td><c:out value="${ramen.type}" /></td>
                        </tr>
                        <tr>
                            <th>内容</th>
                            <td>
                                <pre><c:out value="${ramen.content}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>価格</th>
                                <td><c:out value="${ramen.price}" /></td>
                        </tr>
                    </tbody>
                </table>
                <p><a href="<c:url value="/ramens/edit?id=${ramen.id}" />">このラーメンを編集する</a></p>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value="/ramens/index" />">一覧に戻る</a></p>
    </c:param>
</c:import>