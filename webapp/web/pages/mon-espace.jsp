<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/fragments/header.jsp" />

<div class="page">
  <div class="container">

        <div class="row">
          <h1>Mon espace</h1>
          <p>Bonjour <strong>${person.firstName}</strong>, voici la liste des offres vous concernant : </p>
        </div>
        <div class="row">
          <!--Liste demande de services-->
          <div class="col-lg-6" id="demandes">
        		<h2 class="text-center title-service-block">Demandes</h2>
        			<c:forEach var="service" items="${listeServicesDemandes}">
                <div class="serviceContainer demande">
                  <div class="row">
                    <form method="post">
                      <div class="col-md-8">
                        <div class="service-title"><a data-toggle="modal" data-target="#${service.idService}">${service.title}</a></div>
                      </div>
                      <div class="col-md-2">
                        <a class="btn btn-default" href="mon-espace/cycle/service?id=${service.idService}" title="Rechercher le service qui me correspond">CYCLE</a>
                      </div>
                      <div class="col-md-2">
                        <button type="submit" class="btn btn-default" title="Supprimer"><span class="glyphicon glyphicon-trash" aria-hidden="true"></button>
                      </div>
                      <input type="hidden" name="idPerson" value="${service.idPerson}">
                      <input type="hidden" name="idService" value="${service.idService}">
                    </form>
                  </div>
                  <!-- Modal-->
                  <div id="${service.idService}" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal">&times;</button>
                          <h2>${service.title}</h2>
                        </div>
                        <div class="modal-body">
                          <p><strong>Description:</strong><br> ${service.description}</p>
                          <p>
          					          Date limite : <fmt:formatDate value="${service.limitDate}" pattern="dd/MM/yyyy" />
                          </p>
                        </div>
                        <div class="modal-footer">
                         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                       </div>
                      </div>
                    </div>
                  </div><!-- End Modal-->
                </div>
        			</c:forEach>
        	</div>

          <!--Liste demande de services-->
          <div class="col-lg-6" id="offres">
            <h2 class="text-center title-service-block">Offres</h2>
              <c:forEach var="service" items="${listeServicesOffres}">
                <div class="serviceContainer offre">
                  <div class="row">
                    <form method="post">
                      <div class="col-md-10">
                          <div class="service-title"><a data-toggle="modal" data-target="#${service.idService}">${service.title}</a></div>
                      </div>
                      <div class="col-md-2">
                        <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-trash" aria-hidden="true"></button>
                      </div>
                      <input type="hidden" name="idPerson" value="${service.idPerson}">
                      <input type="hidden" name="idService" value="${service.idService}">
                    </form>
                  </div>
                  <!-- Modal-->
                  <div id="${service.idService}" class="modal fade" role="dialog">
                    <div class="modal-dialog">
                      <div class="modal-content">
                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal">&times;</button>
                          <h2>${service.title}</h2>
                        </div>
                        <div class="modal-body">
                          <p><strong>Description:</strong><br> ${service.description}</p>
                          <p>
          					          Date limite : <fmt:formatDate value="${service.limitDate}" pattern="dd/MM/yyyy" />
                          </p>
                        </div>
                        <div class="modal-footer">
                         <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                       </div>
                      </div>
                    </div>
                  </div><!-- End Modal-->
              </div>
              </c:forEach>
          </div>
        </div>

    </div>
</div>

<jsp:include page="/fragments/footer.html" />
