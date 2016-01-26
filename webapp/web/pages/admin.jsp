<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="/fragments/header.jsp" />

<div class="page">
  <div class="container">
    <div class="section">
      <h1>Admin</h1>
      <p>Bonjour ${person.firstName}</p>
      <div class="row">
        <div class="col-lg-4">
          <h2>Utilisateurs</h2>
          <c:forEach var="person" items="${persons}">
            <div class="row">
                <form method="post">
                  <div class="col-md-8">
                    <a data-toggle="modal" data-target="#${person.id}">${person.firstName} ${person.name}</a>
                    <c:if test="${person.role == 0}">
                         <strong>Admin</strong>
                    </c:if>
                    <input type="hidden" name="idPerson" value="${person.id}">
                  </div>
                  <div class="col-md-4">
                    <button type="submit"><span class="glyphicon glyphicon-trash" aria-hidden="true"></button>
                  </div>
                </form>
                <div id="${person.id}" class="modal fade" role="dialog">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h2>${person.firstName} ${person.name}</h2>
                      </div>
                      <div class="modal-body">
                        <p><strong>Email:</strong> ${person.email}</p>
                        <p><strong>Date d'inscription : </strong>
                          <fmt:formatDate value="${person.subscriptionDate}" pattern="dd/MM/yyyy" />
                        </p>
                      </div>
                      <div class="modal-footer">
                       <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                     </div>
                    </div>
                  </div>
                </div>
            </div>
          </c:forEach>
        </div>
        <div class="col-lg-4">
          <h2>Services</h2>
          <c:forEach var="service" items="${services}">
            <div class="row">
              <form method="post">
                <div class="col-md-8">
                  <a>${service.title}</a>
                  <input type="hidden" name="idService" value="${service.id}">
                </div>
                <div class="col-md-4">
                  <button type="submit"><span class="glyphicon glyphicon-trash" aria-hidden="true"></button>
                </div>
              </form>
            </div>
          </c:forEach>
        </div>
        <div class="col-lg-4">
          <h2>Services - Utilisateurs</h2>
          <c:forEach var="ps" items="${psa}">
            <div class="row">
              <div class="col-md-8">
                <a data-toggle="modal" data-target="#ps-${ps.id}">${ps.firstName} ${ps.name} - ${ps.title}</a>
                <div id="ps-${ps.id}" class="modal fade" role="dialog">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h2>${ps.title}</h2>
                      </div>
                      <div class="modal-body">
                        <p>${ps.description}</p>
                        <p><strong>Date limite :</strong>
                          <fmt:formatDate value="${ps.limitDate}" pattern="dd/MM/yyyy" />
                        </p>
                        <p><strong>Ajouté par :</strong> ${ps.firstName} ${ps.name}</p>
                        <p><strong>Type :</strong>
                          <c:choose>
        										<c:when test="${ps.status == 0}">
        											Demande
        										</c:when>
                            <c:otherwise>
                              Offre
                            </c:otherwise>
                          </c:choose>
                         </p>
                      </div>
                      <div class="modal-footer">
                       <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                     </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-4">
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
