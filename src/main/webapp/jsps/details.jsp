<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="models.Tache" %>
<%@ page import="models.Utilisateur" %>    
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Détails de la tâche</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">	
	</head>
	
	<body>
	
		<%@ include file="header.jsp" %>

		<main>
		<%
			String idTache = (String) request.getAttribute("idTache");
			Date dateLimite = (Date) request.getAttribute("dateLimite");
			String datelim = dateLimite.toString();
			String description = (String) request.getAttribute("description");
		%>
			<div class="m-5">
				<h1><%=description%></h1>
				<p>Date limite : <%=datelim%></p>
			</div>
			
			
			<h2 class="m-5">Mettre à jour la tâche :</h2>
			<form method="post" action="UpdateTask" class="container mt-5">
				<div class="form-floating mb-3 mt-3">
					<label for="ndescription" class="form-label">nouvelle description :</label><br>
					<input type="text" id="ndescription" name="ndescription" class="form-control"><br>
				</div>
				<div class="form-floating mb-3 mt-3">
					<label for="ndatelim" class="form-label"></label>nouvelle date limite :<br>
					<input type="date" id="ndatelim" name="ndatelim" class="form-control"><br>
				</div>
				<input type="hidden" name="idtache" value="<%=idTache%>">
				<input type="submit" value="mettre à jour" class="btn btn-light">
			</form>

			<h2 class="m-5">Supprimer la tâche :</h2>
			<form method="post" action="DeleteTask" class="container mt-5">
				<input type="hidden" name="idtache" value="<%=idTache%>">
				<input type="submit" value="supprimer">
			</form>
		
		</main>

		<%@ include file="footer.jsp" %>
	
	</body>
</html>