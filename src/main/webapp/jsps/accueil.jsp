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
		<header>
			<div class="p-5 bg-primary text-white text-center"><h2>Application TO-DO list</h2></div>
		</header>
		
		<main>

			<div class="m-5">
				<h1>Liste de tâches</h1>
			</div>
			
			<h2 class="m-5">Bonjour ${idUser} - voici la liste de vos missions</h2>

			<% ArrayList<Tache> allTasks = (ArrayList <Tache>) request.getAttribute("listeTaches");
			
			if (allTasks != null && allTasks.size() > 0) { 

				 for (Tache t : allTasks) { 
					session.setAttribute("oneTask", t);  %>
					
					<ul class="list-group list-group-horizontal">
						<li class="list-group-item"><%=t.getDescription()%> </li>
						<li class="list-group-item"><a href="details">details</a> </li>
					
					</ul>
	
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

				<input type="submit" vale="submit" class="btn btn-l	ight">
			</form>
			
		</main>

		<footer
        class="text-center text-lg-start text-white"
        style="background-color: #1c2331"
        >
            <section
                class="d-flex justify-content-between p-4"
                style="background-color: #6351ce"
            >

                <div class="me-5">
                    <span>Morgane Rossi</span>
                </div>

                <div>
                    <a href="https://github.com/morgane-du-tweize?tab=repositories" class="text-white me-4">
                        <i class="fab fa-github"></i>
                      </a>
                </div>

                <div>
                    <a href="" class="text-white me-4">
                        <i class="fab fa-linkedin"></i>
                      </a>
                </div>

            </section>
		</footer>

	</body>
</html>