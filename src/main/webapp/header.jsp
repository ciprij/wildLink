<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<header class="bg-primary text-white text-center py-3">
  <h1>WildLink</h1>
  <nav>
    <ul class="nav justify-content-center">
      <li class="nav-item"><a class="nav-link text-white" href="<%= request.getContextPath() %>/index.jsp">Home</a></li>
      <li class="nav-item"><a class="nav-link text-white" href="<%= request.getContextPath() %>/searchUser.jsp">Search User</a></li>
      <li class="nav-item"><a class="nav-link text-white" href="<%= request.getContextPath() %>/logIn">Login</a></li>
    </ul>
  </nav>
</header>
