<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<header class="bg-primary text-white text-center py-3">
  <h1>WildLink</h1>
  <nav>
    <ul class="nav justify-content-center">
      <li class="nav-item"><a class="nav-link text-white" href="<%= request.getContextPath() %>/index.jsp">Home</a></li>
      <li class="nav-item"><a class="nav-link text-white" href="<%= request.getContextPath() %>/search.jsp">User Search</a></li>
      <li class="nav-item"><a class="nav-link text-white" href="<%= request.getContextPath() %>/weather.jsp">Weather Search</a></li>
      <li class="nav-item"><a class="nav-link text-white" href="<%= request.getContextPath() %>/login.jsp">Login</a></li>
    </ul>
  </nav>
</header>
