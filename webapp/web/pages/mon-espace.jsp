<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/fragments/header.jsp" />

<div class="page">
  <div class="container">
    <div class="row">
      <div class="col-lg-8">
        <div class="row">
          <h1>Mon espace</h1>
          <p>Bonjour ${person.firstName}, voici la liste des offres vous concernant : </p>
        </div>
        <div class="row">
          <div class="col-lg-6" id="demandes">
        		<h2 class="text-center">Demandes</h2>
        			<c:forEach var="service" items="${listeServicesDemandes}">
                <div class="serviceContainer demande">
        				<h5>${service.title}</h5>
                <p>
                  ${service.description}
                </p>
                <p>
					Date limite : <fmt:formatDate value="${service.limitDate}" pattern="dd/MM/yyyy" />
                </p>
                <a href="mon-espace/cycle/service?id=${service.id}">(demander un cycle de service)</a>
                </div>
        			</c:forEach>
        	</div>
          <div class="col-lg-6" id="offres">
            <h2 class="text-center">Offres</h2>
              <c:forEach var="service" items="${listeServicesOffres}">
                <div class="serviceContainer offre">
                <h5>${service.title}</h5>
                <p>
                  ${service.description}
                </p>
                <p>
					Date limite : <fmt:formatDate value="${service.limitDate}" pattern="dd/MM/yyyy" />
                </p>
              </div>
              </c:forEach>
          </div>
        </div>
        </div>
      </div>
    </div>
</div>

<jsp:include page="/fragments/footer.html" />
