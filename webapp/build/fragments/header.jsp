<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />


<!DOCTYPE html>
<html lang="fr">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
	<title>KoodMain</title>
	
	<base href="${fn:substring(url, 0, fn:length(url) - fn:length(uri))}${req.contextPath}/">
	<!--Import Google Icon Font-->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<!--Import materialize.css-->
	<!--<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>-->
	<!--<link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>-->
	<link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
	
	
</head>
	<body>
		<nav class="light-blue lighten-1" role="navigation">
	    <div><a href="${pageContext.request.contextPath}" >KoodMain</a>
	      <ul>
	        <li><a href="signIn">Inscription</a></li>
	        <li><a href="logIn">Connexion</a></li>
	        <li><a href="addService">Ajouter un Service</a></li>
	      </ul>
	  </nav>
	  <div id="wrapper">
	  
	
