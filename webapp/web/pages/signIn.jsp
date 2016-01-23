<jsp:include page="/fragments/header.jsp" />
<%@ page contentType="text/html; charset=UTF-8" %>

<div class="page">
 <div class="container">
    <h1>Inscription</h1>
    <form action="signIn" method="post" rol="form">
        <div class="form-group">
            <label for="">Nom:</label>
        <input type="text" name="nom" class="form-control">
        </div>
        <div class="form-group">
            <label for="">Prénom:</label>
            <input type="text" name="prenom" class="form-control">
        </div>
        <div class="form-group">
            <label for="">Email:</label>
            <div class="input-group">
              <span class="input-group-addon">@</span>
              <input type="text" name="email" class="form-control">
            </div>
        </div>
        <div class="form-group">
            <label for="">Password:</label>
            <input type="password" name="password" class="form-control">
        </div>

        <button type="submit" class="btn btn-default">S'inscrire</button>
    </form>
  </div>
</div>
<jsp:include page="/fragments/footer.html" />
