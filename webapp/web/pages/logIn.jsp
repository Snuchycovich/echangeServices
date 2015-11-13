<jsp:include page="/fragments/header.html" />
  
    <h1>Connexion</h1>
    <p> ${nom} </p>
    <form action="auth" method="post">
        <div>
            <label for="">Email:</label>
            <input type="text" name="email">
        </div>
        <div>
            <label for="">Password:</label>
            <input type="text" name="password">
        </div>
        <button type="submit">Se connecter</button>   
    </form>    
  </div><!-- End #wrapper-->
<jsp:include page="/fragments/footer.html" />