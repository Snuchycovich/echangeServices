<jsp:include page="/fragments/header.jsp" />

<p>Bonjour ${person.email}</p>
    
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
              <label for="type">Type</label><br>
              <input type="radio" name="type" value="0"> Demande<br>
  			  <input type="radio" name="type" value="1"> Offer<br>
  
                
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
