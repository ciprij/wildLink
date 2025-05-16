<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglib.jsp" %>
<c:set var="title" value="Your Profile" />
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

    <body class="bg-light">

        <div class="container mt-5">

            <h1>Your Profile</h1>

            <p><strong>Username:</strong> ${user.username}</p>
            <p><strong>First Name:</strong> ${user.first_name}</p>
            <p><strong>Last Name:</strong> ${user.last_name}</p>
            <p><strong>Email:</strong> ${user.email}</p>
            <c:if test="${not empty user.bio}">
              <p><strong>Bio:</strong> ${user.bio}</p>
            </c:if>

            <!-- Buttons -->
            <a href="index.jsp" class="btn btn-primary">Home</a>

            <a href="editProfile.jsp" class="btn btn-warning">Edit Profile</a>

            <form action="${pageContext.request.contextPath}/deleteAccount" method="post"
                  onsubmit="return confirm('Are you sure you want to delete your account? This cannot be undone.');">
              <button type="submit" class="btn btn-danger mt-3">Delete My Account</button>
            </form>

        </div>

    </body>

</html>
