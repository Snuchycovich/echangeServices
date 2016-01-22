<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/fragments/header.jsp" />

<div class="page">
  <div class="container">
    <h1>Mon espace</h1>
    <p>Bonjour ${person.firstName}, voici la liste des offres vous concernant : </p>
	<div id="demandes">
		<h2>Demandes</h2>
		<ul>
			<c:forEach var="service" items="${listeServicesDemandes}">
				<li>${service.title}</li>
			</c:forEach>
		</ul>
	</div>
	<div id="offres">
		<h2>Offres</h2>
		<ul>
			<c:forEach var="service" items="${listeServicesOffres}">
				<li>${service.title}</li>
			</c:forEach>
		</ul>
	</div>
  </div>
</div>

<jsp:include page="/fragments/footer.html" />
