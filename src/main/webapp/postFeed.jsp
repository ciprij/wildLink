<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="taglib.jsp" %>
<c:set var="title" value="Post Feed" />
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

</head>
    <body class="bg-light">

        <div class="container mt-5">
            <h1 class="mb-4 text-center">Latest Posts</h1>
            <div class="text-center mb-4">
                <a href="addPost.jsp" class="btn btn-lg btn-success">
                    ✍️ Write a post now!
                </a>
            </div>
            <c:forEach var="post" items="${posts}">
                <div class="card mb-4 shadow-sm">
                    <div class="card-body">
                        <h4 class="card-title">${post.post_subject}</h4>
                        <p class="card-text">${post.post_body}</p>
                        <p class="text-muted small mb-2">
                            Posted by <strong>${post.user.username}</strong>
                            on ${post.date_posted}
                        </p>

                        <c:if test="${post.user.user_id eq sessionScope.userId}">
                            <div class="d-flex gap-2">
                                <form action="deletePost" method="post" onsubmit="return confirm('Are you sure you want to delete this post?');">
                                    <input type="hidden" name="postId" value="${post.post_id}" />
                                    <button type="submit" class="btn btn-sm btn-danger">🗑️ Delete</button>
                                </form>
                                <a href="editPostForm?postId=${post.post_id}" class="btn btn-sm btn-secondary">✏️ Edit</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:forEach>

        </div>

    </body>
</html>
