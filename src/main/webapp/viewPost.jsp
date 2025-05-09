<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="taglib.jsp" %>
<c:set var="title" value="Post Results" />
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

<div class="container mt-5">
    <c:if test="${not empty post}">
        <h1 class="text-center mb-5">Successfully posted!</h1>
        <h2>${post.post_subject}</h2>
        <p>${post.post_body}</p>
        <p><small>Posted by ${post.user.username} on ${post.date_posted}</small></p>
    </c:if>

    <c:if test="${empty post}">
        <p>Post not found.</p>
    </c:if>
</div>
