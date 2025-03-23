<%@ include file="taglib.jsp" %>
<c:set var="title" value="Search Results" />
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

<html>
<body>
<!-- Centered title with Bootstrap class -->
<h2 class="text-center">All WildLink Users!</h2>

<div class="d-flex justify-content-center">
  <!-- Table with responsive design and Bootstrap classes -->
  <table id="userTable" class="table table-striped table-bordered" style="width: 50%;">
    <thead>
    <tr>
      <th>Username</th>
    </tr>
    </thead>
    <tbody>
    <!-- Iterate over users and display data -->
    <c:forEach var="user" items="${users}">
      <tr>
        <td>${user.username}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<!-- Pagination controls -->
<div class="d-flex justify-content-center mt-4">
  <nav aria-label="Page navigation">
    <ul class="pagination">
      <!-- Previous button -->
      <c:if test="${currentPage > 1}">
        <li class="page-item">
          <a class="page-link" href="${pageContext.request.contextPath}/searchUser?page=${currentPage - 1}" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>
      </c:if>

      <!-- Page numbers -->
      <c:forEach var="i" begin="1" end="${totalPages}" varStatus="status">
        <li class="page-item ${status.index + 1 == currentPage ? 'active' : ''}">
          <a class="page-link" href="${pageContext.request.contextPath}/searchUser?page=${i}">
              ${i}
          </a>
        </li>
      </c:forEach>

      <!-- Next button -->
      <c:if test="${currentPage < totalPages}">
        <li class="page-item">
          <a class="page-link" href="${pageContext.request.contextPath}/searchUser?page=${currentPage + 1}" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </c:if>
    </ul>
  </nav>
</div>

</body>
</html>
