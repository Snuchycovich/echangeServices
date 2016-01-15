<jsp:include page="/fragments/header.jsp" />

<div class="page">
  <div class="container">
	<p>Bonjour ${person.email}, ${person.id}</p>
    <div class="section">
      <h1>Ajout d'un service</h1>
      <form action="addService" method="post" class="form">
            <div class="input-group">
              <label for="title">Titre</label><br>
              <input type="text" name="title" class="form-control" id="title">
            </div>
            <div  class="form-group">
              <label for="description">Description</label><br>
              <textarea id="description" class="form-control" name="description"></textarea>
            </div>
            <div  class="form-group">
              <p>Type :</p>
              <input type="radio" name="status" value="0" id="demande"><label for="demande">Demande</label><br>
  			  <input type="radio" name="status" value="1" id="offre"> <label for="offre">Offre</label><br>
            </div>
            <div  class="form-group">
              <label for="limitdate">Date limite</label><br>
              <input type="text" name="limitDate" id="limitdate">
            </div>
            <div  class="form-group">	
				<button type="submit" name="action">Ajouter</button>
			</div>   
      </form>
    </div>    
  </div>
</div>
<jsp:include page="/fragments/footer.html" />
