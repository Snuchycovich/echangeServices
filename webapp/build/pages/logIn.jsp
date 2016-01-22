<jsp:include page="/fragments/header.jsp" />
<div class="page">
  <div class="container">
    <h1>Connexion</h1>
    <p> ${error} </p>
    <form action="logIn" method="post" rol="form">
        <div class="form-group">
            <label for="">Email:</label>
            <input type="text" name="email" class="form-control">
        </div>
        <div class="form-group">
            <label for="">Password:</label>
            <input type="password" name="password" class="form-control">
        </div>
        <button type="submit" class="btn btn-default">Se connecter</button>
    </form>
    <p>Toujours pas inscrit ? <a href="signIn" title="inscription">Inscrivez-vous en cliquant ici</a></p>
  </div>
</div>
<jsp:include page="/fragments/footer.html" />
