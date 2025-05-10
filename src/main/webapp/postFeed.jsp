<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="taglib.jsp" %>
<c:set var="title" value="Post Feed" />
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

</head>
    <body class="bg-light">

        <div class="container mt-5">
            <h1 class="mb-4 text-center">Latest Posts</h1>

            <c:forEach var="post" items="${posts}">
                <div class="card mb-4 shadow-sm">
                    <div class="card-body">
                        <h4 class="card-title">${post.post_subject}</h4>
                        <p class="card-text">${post.post_body}</p>
                        <p class="text-muted small mb-0">
                            Posted by <strong>${post.user.username}</strong>
                            on ${post.date_posted}
                        </p>
                    </div>
                </div>
            </c:forEach>

        </div>

    </body>
</html>
