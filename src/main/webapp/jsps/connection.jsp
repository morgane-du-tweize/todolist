<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Page de connection</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
	</head>

	<body>

		<%@ include file="header.jsp" %>

        <div class="container m-5">
            <h1>Veuillez vous enregistrer ou vous connecter</h1>
        </div>
		
        <div class="mt-5">
            <h2>Formulaire d'enregistrement</h2>
        </div>

		<form class="container mt-5" method="post" action="enregistrement" >
            <div class="form-floating w-25">
                <label for="epseudo" class="form-label">Nom d'utilisateur :</label><br>
                <input type="text" id="epseudo" name="epseudo" class="form-control"><br>
            </div>
            <div class="form-floating w-25">
                <label for="epassword" class="form-label"></label>Mot de passe :<br>
                <input type="password" id="epassword" name="epassword" class="form-control"><br>
            </div>
            <input type="submit" value="submit" class="btn btn-light w-25"><br><br>
        </form>

		<h2>Formulaire de connection</h2>
		<form class="container mt-5" method="post" action="connection">
            <div class="form-floating w-25">
                <label for="cpseudo" class="form-label">Pseudo :</label><br>
                <input type="text" id="cpseudo" name="cpseudo" class="form-control"><br>
            </div>
            <div class="form-floating w-25">
                <label for="cpassword" class="form-label"></label><br>
                <input type="password" id="cpassword" name="cpassword" class="form-control"><br>
            </div>
            <input type="submit" value="submit" class="btn btn-light w-25"><br><br>
        </form>

		<%@ include file="footer.jsp" %>

	</body>
</html>