<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="fragments/header.jsp" />
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<header>
  <div class="container">
    <div class="row">
        <div class="col-lg-12">
          <div class="row">
            <div class="col-lg-4 col-lg-offset-1">
              <img class="img-responsive" src="img/profile.png" alt="Image perfil">
            </div>
            <div class="col-lg-2">
              <img class="img-responsive" src="img/fleches.png" alt="Image perfil">
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
<section id="about">
  <div class="container">
    <h2 class="text-center">Comment ça marche ?</h2>
    <hr class="star-primary">
      <div class="row">
        <div class="col-sm-2">
          <div class="square"></div>
        </div>
        <div class="col-sm-10">
          <p class="skills">Le principe est simple, vous vous inscrivez « Inscription », vous rajoutez deux services
            (un offre et une demande). Nous vous proposent une liste de services, mais si vous ne trouvez
            pas votre bonheur vous pouvez en rajouter.</p>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-10">
          <p class="skills">Il faut savoir qu'il sera plus facile de trouver une réponse a votre besoin si vous
            choisissez parmi la liste car le service est déjà présente dans le site.</p>
        </div>
        <div class="col-sm-2">
          <div class="square"></div>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-2">
          <div class="square"></div>
        </div>
        <div class="col-sm-10">
          <p class="skills">Vous accédez a votre espace personnel pour gérer vos services. Vous lancez un cycle
            pour trouver quelqu'un qui puisse vous rendre  le service demandé.</p>
        </div>
      </div>
      <div class="row">
        <div class="col-sm-10">
          <p class="skills">Si vous ne trouvez pas un ne vous découragez pas il faut un petit peu de patience
            que l'est autres utilisateurs connaissent le service que vous avez proposé. N’hésitez
            à en parler dans votre entourage. Plus on est plus il y a des services.</p>
        </div>
        <div class="col-sm-2">
          <div class="square"></div>
        </div>
      </div>






  </div>

</section>
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


<jsp:include page="fragments/footer.html" />
