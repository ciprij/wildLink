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

      <!-- This functionality to be added at a later time
      <a href="editProfile.jsp" class="btn btn-primary">Edit Profile</a>
      -->
      <a href="index.jsp" class="btn btn-primary">Home</a>
    </div>

  </body>

</html>
