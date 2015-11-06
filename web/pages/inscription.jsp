<jsp:include page="fragments/header.html" />
  
    <h1>Inscription</h1>
    <form action="connexion" method="post">
        <div>
            <label for="">Nom:</label>
        <input type="text" name="nom">
        </div>
        <div>
            <label for="">Pénom:</label>
            <input type="text" name="prenom">
        </div>
        <div>
            <label for="">Email:</label>
        <input type="text" name="email">
        </div>
        <div>
            <label for="">Password:</label>
            <input type="text" name="password">
        </div>
        
        <button type="submit">S'inscrir</button>   
    </form>    
  </div><!-- End #wrapper-->
<jsp:include page="fragments/footer.html" />