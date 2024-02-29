<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Tache" %>
<%@ page import="models.Utilisateur" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Liste des tâches</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	
	</head>
	<body>
		<%@ include file="header.jsp"%>
		
		<main>

			<div class="mt-4 p-5 bg-secondary text-white rounded">
				<h1 class="display-4">Liste de tâches</h1>
			</div>

			<%Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur"); %>

			<h2 class="m-5">Bonjour <%=utilisateur.getuPseudo() %> - voici la liste de vos missions</h2>

			<% ArrayList<Tache> allTasks = (ArrayList <Tache>) request.getAttribute("listeTaches");
			
			if (allTasks != null && allTasks.size() > 0) { 
				 for (Tache t : allTasks) { 
			%>
			<div >
				<ul class="list-group list-group-horizontal m-5">
					<li class="list-group-item w-25"><%=t.getDescription()%> </li>
					<li>
						<form method="POST" action="details">
							<input type="hidden" name="idtask" value="<%=t.getId()%>">						
							<input type="submit" value="details">
						</form>
					</li>
				</ul>			
			</div>

				<%	}
			}	 
			
			else {%>
			<p>
				Vous n'avez pas encore de tâche !<br>
				Vous pouvez remplir le formulaire ci-dessous pour ajouter une tâche dès à présent.
			</p>
	  <%} %>
			
			<h2 class="m-5">Ajouter une nouvelle tâche</h2>
			 
			<form class="container mt-5" method="post" action="task">
				<div class="form-floating mb-3 mt-3">
					<label for="ndescription" class="form-label">description de la tâche :</label><br>
					<input type="text" id="ndescription" name="ndescription" class="form-control"><br>
				</div>
				<div class="form-floating mb-3 mt-3">
					<label for="ndatelim" class="form-label"></label>date limite :<br>
					<input type="date" id="ndatelim" name="ndatelim" class="form-control"><br>
				</div>
				<input type="submit" value="submit" class="btn btn-l	ight">
			</form>
			
			<div class="mt-5">
				<h2 class="m-5"><a href="deconnection">Déconnection</a></h2>
			</div>
			
		</main>
		
		<%@ include file="footer.jsp" %>

	</body>
</html>