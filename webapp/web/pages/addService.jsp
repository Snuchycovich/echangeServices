<jsp:include page="/fragments/header.jsp" />

<div class="page">
  <div class="container">
    <div class="section">
      <h1>Ajout d'un service</h1>
      <form action="addService" method="post" class="form">
        <div class="form-group">
          <label for="title">Titre</label><br>
          <input type="text" name="title" class="form-control" id="title">
            <label for="sel2">Selectionner un service</label>
            <select class="form-control" id="service">
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>4</option>
              <option>5</option>
            </select>
        </div>
        <div  class="form-group">
          <label for="description">Description</label><br>
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
        <div  class="form-group">
          <div class="input-group date">
            <label for="limitdate">Date limit pour offir ou recevoir le Service</label><br>
            <input type="text" class="form-control" name="limitDate" id="limitdate"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
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
