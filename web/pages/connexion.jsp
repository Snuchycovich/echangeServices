<jsp:include page="/fragments/header.html" />
  
    <h1>Connexion</h1>
    <p> ${nom} </p>
    <form action="" method="post">
        <label for="">Email:</label>
        <input type="text" name="email">
        <label for="">Password:</label>
        <input type="text" name="password">
        <button type="submit">Se connecter</button>   
    </form>    
  </div><!-- End #wrapper-->
<jsp:include page="/fragments/footer.html" />