<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:pageTemplate pageTitle="Users">

    <h1>Users</h1>
    <div class="container text-center">
        <c:forEach var="user" items="${users}">
            <div class="row">
                <div class="col">
                        ${user.username}
                </div>
                <div class="col">
                        ${user.email}
                </div>
                <div class="col">
                        ${user.id}
                </div>
            </div>
        </c:forEach>
    </div>

    <h5>Total users: ${numberOfUsers}</h5>

</t:pageTemplate>
