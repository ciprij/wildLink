<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="edu.matc.entity.User" %>
<%@include file="taglib.jsp"%>
<%@include file="head.jsp"%>

<%
  User loggedInUser = (User) session.getAttribute("loggedInUser");
%>

<header class="bg-primary text-white text-center py-3">
  <h1>WildLink</h1>

  <% if (loggedInUser != null) { %>
  <p class="mb-1">Hi, <%= loggedInUser.getUsername() %>!</p>
  <% } %>

  <nav>
    <ul class="nav justify-content-center">
      <li class="nav-item">
        <a class="nav-link text-white" href="<%= request.getContextPath() %>/index.jsp">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-white" href="<%= request.getContextPath() %>/searchUser.jsp">Search User</a>
      </li>

      <% if (loggedInUser == null) { %>
      <li class="nav-item">
        <a class="nav-link text-white" href="<%= request.getContextPath() %>/logIn">Login</a>
      </li>
      <% } else { %>
      <li class="nav-item">
        <a class="nav-link text-white" href="<%= request.getContextPath() %>/logout">Logout</a>
      </li>
      <% } %>
    </ul>
  </nav>
</header>
