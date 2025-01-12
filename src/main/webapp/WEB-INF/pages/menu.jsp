<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 03/12/2024
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<header>
  <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
      <a class="navbar-brand" href="${pageContext.request.contextPath}">Parking lot</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav me-auto mb-2 mb-md-0">
          <li class="nav-item">
            <a class="nav-link"
              ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf(
"/")) eq '/about.jsp' ? ' active' : ''}
             aria-current="page" href="${pageContext.request.contextPath}/about.jsp">About</a>
          </li>
          <li class="nav-item">
            <c:if test="${pageContext.request.isUserInRole('READ_CARS')}">
              <a class="nav-link"
              ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf(
                      "/")) eq '/Cars' ? ' active' : ''}
                 aria-current="page" href="${pageContext.request.contextPath}/Cars">Cars</a>
            </c:if>
          </li>
          <li class="nav-item">
            <c:if test="${pageContext.request.isUserInRole('READ_USERS')}">
            <a class="nav-link"
            ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf(
                    "/")) eq '/Users' ? ' active' : ''}
               aria-current="page" href="${pageContext.request.contextPath}/Users">Users</a>
            </c:if>
          </li>
          <li class="nav-item">
            <a class="nav-link disabled">Disabled</a>
          </li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item">
            <c:choose>
              <c:when test="${pageContext.request.getRemoteUser() == null}">
                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
              </c:when>
              <c:otherwise>
                <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
              </c:otherwise>
            </c:choose>
          </li>

        </ul>
      </div>
    </div>
  </nav>
</header>
<body>
<footer class="text-center text-muted " >
  <p>© 2024 Faur Sebastian </p>
</footer>
</body>
</html>
