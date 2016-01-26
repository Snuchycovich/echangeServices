<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/fragments/header.jsp" />

<div class="page">
	<div class="container">
		<div class="row">
			<h1>Cycle</h1>
			<p>${cycle}</p>
		</div>
	</div>
</div>

<jsp:include page="/fragments/footer.html" />
