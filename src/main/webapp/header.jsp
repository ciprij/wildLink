<%@ include file="taglib.jsp" %>
<%@ include file="head.jsp" %>

<header class="bg-primary text-white text-center py-3">
  <h1>WildLink</h1>

  <c:if test="${not empty sessionScope.loggedInUser}">
    <p class="mb-1">Hi, ${sessionScope.loggedInUser.username}!</p>
  </c:if>

  <nav>
    <ul class="nav justify-content-center">
      <li class="nav-item">
        <a class="nav-link text-white" href="${pageContext.request.contextPath}/index.jsp">Home</a>
      </li>
      <c:choose>
        <c:when test="${empty sessionScope.loggedInUser}">
          <li class="nav-item">
            <a class="nav-link text-white" href="${pageContext.request.contextPath}/logIn">Login/Sign up</a>
          </li>
        </c:when>
        <c:otherwise>
          <li class="nav-item">
            <a class="nav-link text-white" href="${pageContext.request.contextPath}/addPost.jsp">Create Post</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="${pageContext.request.contextPath}/postFeed">Post Feed</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="${pageContext.request.contextPath}/searchUser.jsp">Search User</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="${pageContext.request.contextPath}/profile">Profile</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white" href="${pageContext.request.contextPath}/logout">Logout</a>
          </li>
        </c:otherwise>
      </c:choose>
    </ul>
  </nav>
</header>
