<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="fragments/header.jsp" />
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header>
  <div class="container">
    <div class="row">
        <div class="col-lg-12">
          <div class="row">
            <div class="col-lg-4 col-lg-offset-2">
              <img class="img-responsive" src="img/profile.png" alt="Image perfil">
            </div>
            <div class="col-lg-4">
              <img class="img-responsive" src="img/profile.png" alt="Image perfil 2">
            </div>

          </div>

            <div class="intro-text">
                <span class="name">KoodMain</span>
                <hr class="star-light">
                <span class="skills">Donne un coup de main à ton voisin</span>
            </div>
        </div>
    </div>
  </div>
</header>
<section id="services">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Dernières demandes</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
              <c:forEach var="service" items="${listeServicesDemandes}">
                <div class="col-md-4 service-home liste-demande-home">
                    <h3><a href="service/add">${service.title}</a></h3>
                    <p>${service.description}</p>
                    <p>
						        Date limite pour rendre ce service : <fmt:formatDate value="${service.limitDate}" pattern="dd/MM/yyyy" />
                    </p>
                    <p>Demandé par <strong>${service.firstName}</strong></p>
                </div>
              </c:forEach>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Dernières offres</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
              <c:forEach var="service" items="${listeServicesOffres}">
                <div class="col-sm-4 service-home liste-offre-home">
                  <h3><a href="service/add">${service.title}</a></h3>
                  <p>${service.description}</p>
                  <p>
					Date limite pour profiter de ce service : <fmt:formatDate value="${service.limitDate}" pattern="dd/MM/yyyy" />
                  </p>
                  <p>Offert par <strong>${service.firstName}</strong></p>
                </div>
              </c:forEach>
            </div>
        </div>
    </section>
    <section>
    </section>

<jsp:include page="fragments/footer.html" />
