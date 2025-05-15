<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglib.jsp" %>
<c:set var="title" value="Edit Post" />
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

    <body class="bg-light">
        <div class="container mt-5">
            <h1>Edit Post</h1>

            <form action="updatePost" method="post">
                <input type="hidden" name="postId" value="${post.post_id}" />

                <div class="mb-3">
                    <label for="post_subject" class="form-label">Subject</label>
                    <input type="text" class="form-control" id="post_subject" name="post_subject" value="${post.post_subject}" required>
                </div>

                <div class="mb-3">
                    <label for="post_body" class="form-label">Body</label>
                    <textarea class="form-control" id="post_body" name="post_body" rows="5" required>${post.post_body}</textarea>
                </div>

                <button type="submit" class="btn btn-primary">Update Post</button>
                <a href="postFeed" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </body>
</html>
