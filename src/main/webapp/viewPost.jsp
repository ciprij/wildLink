<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="taglib.jsp" %>
<c:set var="title" value="Post Results" />
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

<div class="container mt-5">

<c:if test="${not empty post}">
    <div class="text-center mb-5">
        <h1 class="text-success">Successfully Posted!</h1>
    </div>

    <div class="card shadow-sm">
        <div class="card-body">
            <h3 class="card-title">${post.post_subject}</h3>
            <p class="card-text">${post.post_body}</p>
            <p class="text-muted small mb-0">
                Posted by <strong>${post.user.username}</strong>
                on ${post.date_posted}
            </p>
        </div>
    </div>

    <div class="mt-4">
        <a href="postFeed" class="btn btn-outline-primary">Back to Post Feed</a>
    </div>
</c:if>

<c:if test="${empty post}">
    <div class="alert alert-warning text-center">
        <p class="mb-0">Post not found.</p>
    </div>
</c:if>