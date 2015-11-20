<jsp:include page="fragments/header.html" />
<%@ page contentType="text/html; charset=UTF-8" %>
    
  <div class="container">
    <div class="section">
      <h1>Ajout d'un service</h1>
      <form action="service" method="post" class="col s12">
          <div class="row">
            <div class="input-field col s12">
                <input type="text" name="title" class="validate active" id="title">
                <label for="title">Titre</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
              <textarea id="description" class="materialize-textarea"></textarea>
              <label for="textarea1">Description</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
                <input type="text" name="type" class="validate" id="type">
                <label for="type">Type</label>
            </div>
             <div class="input-field col s6">
                <input type="text" name="category" class="validate" id="category">
                <label for="category">Catégorie</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s6">
                <input type="text" name="limitdate" class="validate" id="limitdate">
                <label for="limitdate">Date limite</label>
            </div>
          </div>
          <button class="btn waves-effect waves-light" type="submit" name="action">Ajouter
            <i class="material-icons right">send</i>
          </button>   
      </form>
    </div>    
  </div><!-- End Container -->
<jsp:include page="fragments/footer.html" />