<%@page import="java.text.SimpleDateFormat"%>
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
		
		<div class="mt-4 p-4 bg-secondary text-white rounded">
			<h1 class="display-4">Détails de la tâche</h1>
		</div>
		<%
			String idTache = (String) request.getAttribute("idTache");
			Date dateLimite = (Date) request.getAttribute("dateLimite");
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			String description = (String) request.getAttribute("description");
			String dateFormat = f.format(dateLimite).toString();
		%>
			<div class="m-5">
				<h2><%=description%></h2>
				<p>Date limite : <%=dateFormat%></p>
			</div>
			<div class="container mt-5">
				<h3>Mettre à jour la tâche :</h3>
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
				<div class="my-4">
					<h3>Supprimer la tâche :</h3>
					<form method="post" action="DeleteTask" class="container mt-5">
						<input type="hidden" name="idtache" value="<%=idTache%>">
						<input type="submit" value="supprimer">
					</form>
				</div>
			</div>
			
			<div class="mt-5">
				<h2 class="m-5"><a href="accueil">Retour à l'accueil</a></h2>
			</div>			
	
		</main>

		<%@ include file="footer.jsp" %>
	
	</body>
</html>