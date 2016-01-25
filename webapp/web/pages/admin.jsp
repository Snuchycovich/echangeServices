<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="/fragments/header.jsp" />

<div class="page">
  <div class="container">
    <div class="section">
      <h1>Admin</h1>
      <div class="row">
        <div class="col-lg-4">
          <h2>Utilisateurs</h2>
          <c:forEach var="person" items="${persons}">
            <div class="row">
              <div class="col-md-8">
                <a data-toggle="modal" data-target="#myModal">${person.firstName} ${person.name}</a>
                <div id="myModal" class="modal-dialog modal-lg">
                  <h2>${person.firstName} ${person.name}</h2>
                  <p>${person.email}</p>
                  <p>${person.subscriptionDate}</p>
                </div>
              </div>
              <div class="col-md-4">
                <button type="button"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></button>
                <button type="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></button>
              </div>
            </div>
          </c:forEach>
        </div>
        <div class="col-lg-4">
          <h2>Services</h2>
          <c:forEach var="service" items="${services}">
            <div class="row">
              <div class="col-md-8">
                <a href="#">${service.title}</a>
              </div>
              <div class="col-md-4">
                <button type="button"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></button>
                <button type="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></button>
              </div>
            </div>
          </c:forEach>
        </div>
        <div class="col-lg-4">
          <h2>Services - Utilisateurs</h2>
          <c:forEach var="ps" items="${psa}">
            <div class="row">
              <div class="col-md-8">
                <a href="#">${ps.description}</a>
              </div>
              <div class="col-md-4">
                <button type="button"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></button>
                <button type="button"><span class="glyphicon glyphicon-trash" aria-hidden="true"></button>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
</div>

<jsp:include page="/fragments/footer.html" />
