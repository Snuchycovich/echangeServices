<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<jsp:include page="/fragments/header.jsp" />

<div class="page">
  <div class="container">
    <div class="section">
      <h1>Ajout d'un service</h1>
      <form action="service/add" method="post" class="form">
        <div class="row">
          <div class="col-md-6">
            <div class="form-group">
              <label for="serviceTitle">Selectionnez un service</label>
              <select class="form-control" name="title" id="serviceTitle">
                <option value="0"></option>
              <c:forEach var="service" items="${servicesList}">
                <option value="${service.id}">${service.title}</option>
              </c:forEach>
              </select>
            </div>
          </div>
            <div class="col-md-6">
              <div class="form-group">
                <label for="addServiceTitle">Vous ne trouvez pas votre service ? Rajoutez-le !</label>
                <input type="text" class="form-control" name="addServiceTitle">
              </div>
            </div>
          </div>
        </div>
        <div  class="form-group">
          <label for="description">Description</label>
          <textarea id="description" class="form-control" name="description"></textarea>
        </div>
        <div  class="form-group">
          <p>Type de service</p>
          <div class="radio-inline">
            <label><input type="radio" name="status" value="0">Demande</label>
          </div>
          <div class="radio-inline">
            <label><input type="radio" name="status" value="1">Offre</label>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-4">
            <div  class="form-group">
              <div class="input-group date">
                <label for="limitdate">Date limite pour offrir ou recevoir le service</label>
                <input type="text" class="form-control" name="limitDate" id="limitdate">
              </div>
            </div>
          </div>
        </div>
        <div  class="form-group">
			    <button type="submit" name="action" class="btn btn-default">Ajouter</button>
		    </div>
      </form>
    </div>
  </div>
</div>
<jsp:include page="/fragments/footer.html" />
