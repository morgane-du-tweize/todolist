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

		<header>
			<div class="p-5 bg-primary text-white text-center"><h2>Application TO-DO list</h2></div>
		</header>
        <div class="container m-5">
            <h1>Veuillez vous enregistrer ou vous connecter</h1>
        </div>
		
        <div class="mt-5">
            <h2>Formulaire d'enregistrement</h2>
        </div>

		<form class="container mt-5" method="post" action="enregistrement" >
            <div class="form-floating w-25">
                <label for="epseudo" class="form-label">Pseudo :</label><br>
                <input type="text" id="epseudo" name="epseudo" class="form-control"><br>
            </div>
            <div class="form-floating w-25">
                <label for="epassword" class="form-label"></label>Password :<br>
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


		<footer
        class="text-center text-lg-start text-white"
        style="background-color: #1c2331"
        >
            <section
                class="d-flex justify-content-between p-4"
                style="background-color: #6351ce"
            >

                <!-- Left-->
                <div class="me-5">
                    <span>Morgane Rossi</span>
                </div>

<!-- https://mdbootstrap.com/snippets  -->

                <!-- Right-->
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