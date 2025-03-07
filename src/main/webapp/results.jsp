<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<html>
<body>

  <h2 class="d-flex justify-content-center">Search Results: </h2>
  <div class="d-flex justify-content-center">
    <table id="userTable" class="table table-striped-columns table-bordered" style="width:80%">
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