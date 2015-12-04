<jsp:include page="fragments/header.html" />
<%@ page contentType="text/html; charset=UTF-8" %>
    
  <div class="container">
    <div class="section">
      <h1>Ajout d'un service</h1>
      <form action="serviceAdded" method="post">
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
              <input type="text" name="type" id="type">
                
            </div>
             <div>
              <label for="category">Catégorie</label><br>
              <input type="text" name="category" class="validate" id="category">
            </div>
            <div>
              <label for="limitdate">Date limite</label><br>
              <input type="text" name="limitDate" id="limitdate">
            </div>
          <button type="submit" name="action">Ajouter</button>   
      </form>
    </div>    
  </div><!-- End Container -->
<jsp:include page="fragments/footer.html" />