<jsp:include page="/fragments/header.jsp" />
<div class="page">
  <div class="container">
    <h1>Connexion</h1>
    <p class="alert-danger">${error}</p>
    <div class="row">
      <div class="col-lg-6">
        <form action="logIn" method="post" rol="form">
            <div class="form-group">
                <label for="">Email:</label>
                <input type="email" name="email" class="form-control">
            </div>
            <div class="row">
              <div class="col-md-6">
                <div class="form-group">
                    <label for="">Mot de Passe:</label>
                    <input type="password" name="password" class="form-control">
                </div>
                <div class="checkbox vcenter">
                  <label><input type="checkbox" id="memoire" name="memoire"> Se souvenir de moi</label>
                </div>
              </div>
            </div>
            <div class="form-group">
              <button type="submit" class="btn btn-default">Se connecter</button>
            </div>
        </form>
      </div>
      <div class="col-lg-6 text-center">
        <p>Toujours pas inscrit ?<br> <a href="signIn" title="inscription">Inscrivez-vous en cliquant ici</a></p>
        <div class="col-lg-4 col-lg-offset-4">
          <a href="signIn" title="inscription">
            <figure>
              <img class="img-responsive" src="img/profile.png" alt="Image perfil">
            </figure>
          </a>
        </div>

      </div>
    </div>
  </div>
</div>
<jsp:include page="/fragments/footer.html" />
