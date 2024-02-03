<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="models.Tache" %>
<%@ page import="models.Utilisateur" %>    
<!DOCTYPE html>



<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	
	</head>
	
	<body>
	
		<header>
			<div class="p-5 bg-primary text-white text-center"><h2>Application TO-DO list</h2></div>
		</header>	
	
		<main>
		<% Tache t = (Tache) session.getAttribute("oneTask"); %>
			<div class="m-5">
				<h1><%=t.getDescription()%></h1>
				<p><%=t.getDateLimite()%></p>
			</div>

		
			<!-- bouton modifier -->
			<!-- <form class="container mt-5" method="post" action="task"> -->
			
			<!--  uopdate -->
			<form method="put" action="task">
				<input type="submit">
			</form>

			<form method="delete" action="task">
				<input type="submit">
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