<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="taglib.jsp" %>
<c:set var="title" value="Create a New Post" />
<%@include file="head.jsp" %>
<%@include file="header.jsp" %>

<html>
    <body>

        <div class="container-sm justify-content-center border rounded bg-light my-4 p-4">
            <h2 class="text-center">Create a New Post</h2>

            <form action="${pageContext.request.contextPath}/addPost" method="post" class="needs-validation" novalidate>
                <div class="mb-3">
                    <label for="title" class="form-label">Post Title:</label>
                    <input type="text" id="title" name="title" class="form-control" required>
                    <div class="invalid-feedback">
                        Please enter a title for your post.
                    </div>
                </div>

                <div class="mb-3">
                    <label for="content" class="form-label">Content:</label>
                    <textarea id="content" name="content" class="form-control" rows="6" required></textarea>
                    <div class="invalid-feedback">
                        Please enter the content of your post.
                    </div>
                </div>

                <div class="text-center">
                    <button type="submit" class="btn btn-success">Post</button>
                    <a href="index.jsp" class="btn btn-secondary">Cancel</a>
                </div>
            </form>
        </div>

    </body>
</html>
