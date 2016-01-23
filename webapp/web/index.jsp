<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="fragments/header.jsp" />
<%@ page contentType="text/html; charset=UTF-8" %>
<header>
  <div class="container">
    <div class="row">
        <div class="col-lg-12">
          <div class="row">
            <div class="col-lg-4 col-lg-offset-2">
              <img class="img-responsive" src="img/profile.png" alt="Image perfil">
            </div>
            <div class="col-lg-4">
              <img class="img-responsive" src="img/profile2.png" alt="Image perfil 2">
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
                    <h2>Derniers SERVICES demandés</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
              <c:forEach var="service" items="${listeServicesDemandes}">
                <div class="col-sm-4 serviceContainer">
                    <h3><a href="addService">${service.title}</a></h3>
                    <p>${service.description}</p>
                    <p>Date limite pour rendre ce service :${service.limitDate}</p>
                    <p>Demandé par ${service.firstName}</p>
                </div>
              </c:forEach>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Derniers SERVICES offertés</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
              <c:forEach var="service" items="${listeServicesOffres}">
                <div class="col-sm-4 serviceContainer">
                  <h3><a href="addService">${service.title}</a></h3>
                  <p>${service.description}</p>
                  <p>Date limite pour profiter de ce service :${service.limitDate}</p>
                  <p>Oferté par ${service.firstName}</p>
                </div>
              </c:forEach>
            </div>
        </div>
    </section>

<jsp:include page="fragments/footer.html" />
