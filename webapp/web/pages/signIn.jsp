<jsp:include page="/fragments/header.jsp" />
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="page">
 <div class="container">
    <h1>Inscription</h1>
    <form action="signIn" method="post" rol="form">
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
              <label for="">Nom:</label>
              <input type="text" name="nom" class="form-control">
          </div>
        </div>
        <div class="col-md-6">
          <div class="form-group">
              <label for="">Prénom:</label>
              <input type="text" name="prenom" class="form-control">
          </div>
        </div>
      </div>
      <div class="form-group">
          <label for="">Email:</label>
          <div class="input-group">
            <span class="input-group-addon">@</span>
            <input type="email" name="email" class="form-control">
          </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="form-group">
              <label for="">Mot de passe:</label>
              <input type="password" name="password" class="form-control">
          </div>
        </div>
        <div class="col-md-6">
          <div class="form-group">
              <label for="">Vérification Mot de passe:</label>
              <input type="password" name="verifMDP" class="form-control">
          </div>
        </div>

      </div>
      <button type="submit" class="btn btn-default">S'inscrire</button>
    </form>
  </div>
</div>
<jsp:include page="/fragments/footer.html" />
