<jsp:include page="/fragments/header.jsp" />

<p>Bonjour ${person.email}, ${person.id}</p>
    
  <div class="container">
    <div class="section">
      <h1>Ajout d'un service</h1>
      <form action="addService" method="post">
            <div>
              <label for="title">Titre</label><br>
              <input type="text" name="title" id="title">
            </div>
            <div>
              <label for="description">Description</label><br>
              <textarea id="description" name="description"></textarea>
            </div>
            <div>
              <p>Type :</p>
              <input type="radio" name="status" value="0" id="demande"><label for="demande">Demande</label><br>
  			  <input type="radio" name="status" value="1" id="offre"> <label for="offre">Offre</label><br>
            </div>
            <div>
              <label for="limitdate">Date limite</label><br>
              <input type="text" name="limitDate" id="limitdate">
            </div>
          <button type="submit" name="action">Ajouter</button>   
      </form>
    </div>    
  </div><!-- End Container -->
<jsp:include page="/fragments/footer.html" />
