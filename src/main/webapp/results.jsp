<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="taglib.jsp" %>
<c:set var="title" value="Search Results" />
<%@ include file="head.jsp" %>
<%@ include file="header.jsp" %>

<html>
<body>
<h2 class="text-center">Results</h2>

<!-- No results message -->
<c:if test="${empty users && not empty searchQuery}">
  <div class="alert alert-warning text-center my-4">
    No users found with the username: <strong>${searchQuery}</strong>
  </div>
</c:if>

<!-- User results table -->
<c:if test="${not empty users}">
  <div class="d-flex justify-content-center">
    <table id="userTable" class="table table-striped table-bordered" style="width: 50%;">
      <thead>
      <tr>
        <th>Username</th>
      </tr>
      </thead>
      <tbody>
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
</c:if>
</body>
</html>
