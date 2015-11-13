<jsp:include page="fragments/header.html" />
  
    <h1>Création d'un service</h1>
    <form action="createService" method="post">
        <div>
            <label for="titre">Titre:</label>
            <input type="text" name="titre">
        </div>
        <div>
            <label for="">:</label>
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