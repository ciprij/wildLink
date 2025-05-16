<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglib.jsp" %>
<c:set var="title" value="Edit Profile" />
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

<div class="container mt-5">
    <h2>Edit Profile</h2>
    <form action="${pageContext.request.contextPath}/updateProfile" method="post">
        <div class="mb-3">
            <label for="firstName" class="form-label">First Name</label>
            <input type="text" name="firstName" id="firstName" class="form-control" value="${user.first_name}" required>
        </div>

        <div class="mb-3">
            <label for="lastName" class="form-label">Last Name</label>
            <input type="text" name="lastName" id="lastName" class="form-control" value="${user.last_name}" required>
        </div>

        <div class="mb-3">
            <label for="bio" class="form-label">Bio</label>
            <textarea name="bio" id="bio" class="form-control">${user.bio}</textarea>
        </div>

        <button type="submit" class="btn btn-success">Save Changes</button>
        <a href="profile" class="btn btn-secondary">Cancel</a>
    </form>
</div>
