<jsp:include page="fragments/header.html" />
  
    <h1>Inscription</h1>
    <form action="logIn" method="post" rol="form">
        <div class="form-group">
            <label for="">Nom:</label>
        <input type="text" name="nom" class="form-control">
        </div>
        <div class="form-group">
            <label for="">Pénom:</label>
            <input type="text" name="prenom" class="form-control">
        </div>
        <div class="form-group">
            <label for="">Email:</label>
            <input type="text" name="email" class="form-control">
        </div>
        <div class="form-group">
            <label for="">Password:</label>
            <input type="password" name="password" class="form-control">
        </div>
        
        <button type="submit" class="btn btn-default">S'inscrir</button>   
    </form>    
  </div><!-- End #wrapper-->
<jsp:include page="fragments/footer.html" />