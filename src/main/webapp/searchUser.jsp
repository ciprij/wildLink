<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Search User" />
<%@include file="head.jsp"%>
<%@include file="header.jsp"%>

<html>
    <body class="bg-white">

        <div class="container my-5">
            <div class="text-center mb-4">
                <h3>Search for a User</h3>
                <p>Enter a username to find a fellow adventurer.</p>

                <form action="${pageContext.request.contextPath}/searchUser" method="get" class="row g-2 justify-content-center mt-2">
                    <div class="col-md-4 col-sm-6">
                        <input type="text" name="username" id="username" class="form-control" placeholder="Enter username" required>
                        <label for="username"></label>
                    </div>
                    <div class="col-auto">
                        <button type="submit" class="btn btn-outline-primary">Search</button>
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>
