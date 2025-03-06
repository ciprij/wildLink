<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<html>
<body>

<div>
  <h2>Search Results: </h2>
  <table id="userTable">
    <thead>
      <th>Name</th>
      <th>Username</th>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.first_name} ${user.last_name}</td>
        <td>${user.username}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>