<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@page import="com.event.qrcode.service.DbService"%>
<%@page import="com.event.qrcode.bean.FolderBean"%>
<%@ page language="java"
	import="java.util.*,java.io.*,java.lang.ClassNotFoundException,java.io.IOException,java.sql.SQLException"%>
<%
ArrayList<FolderBean> folderDetail = (ArrayList<FolderBean>) request.getAttribute("folderDetail");
DbService dbs = new DbService();
if (folderDetail == null) {
	folderDetail = dbs.getAllFolderDetailsService();
} else {

}
session = request.getSession();
if (session.getAttribute("username") == null) {
	response.sendRedirect("login.jsp");
} else {
	System.out.println(session.getAttribute("username"));
}
%>
<meta charset="ISO-8859-1">
<title>Home</title>
<jsp:include page="nav.jsp"></jsp:include>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="assets/css/my-login.css">
<link rel="stylesheet" type="text/css" href="assets/css/home.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
</head>
<body>
	<div class="container">
		<!-- Grid row -->
		<div class="row">

			<!-- Grid column -->
			<div class="col-md-6 col-lg-4">

				<button class="btn btn-default clf" data-toggle="collapse"
					data-target="#collapseOne" onclick="showf()">
					<i class="fas fa-folder pr-2" aria-hidden="true"></i>Create Folder
				</button>

				<div class="collapse" id="collapseOne" style="display: none;">
					<!--Panel-->
					<div class="card card-body ml-1"
						style="background: none; width: 85%;">
						<h4 class="card-title">Create Folder</h4>
						<form action="CreateFolder" method="post">
							<div class="form-group row">
								<label for="inputPassword" class="col-sm-10 col-form-label">Folder
									Name</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="folder"
										placeholder="Enter Folder Name" required="true"> <input
										type="hidden" class="form-control" name="username"
										value="<%=session.getAttribute("user")%>">
								</div>
							</div>
							<div class="flex-row">
								<input type="submit" class="btn btn-success cre" value="Create">
							</div>
						</form>
					</div>
					<!--/.Panel-->
				</div>


			</div>
			<!-- Grid column -->

		</div>

		<div class="row" style="padding-top: inherit;">

			<%
			try {
				for (int i = 0; i < folderDetail.size(); i++) {
			%>
			<div class="col-md-6 col-lg-4">
				<form method="post" action="FolderView" class="btn btn-default fol">
					<input type="hidden" name="folname"
						value="<%=folderDetail.get(i).getFolder_name()%>"> <i
						class="fas fa-folder-open"> <input type="submit"
						class="btn inp" value="<%=folderDetail.get(i).getFolder_name()%>"></i>

					<!--onclick="document.getElementById('id01').style.display='block'"-->


				</form>
			</div>
			<%
			}
			} catch (Exception e) {
			System.out.println(e);
			}
			%>
		</div>
		<!-- Grid row -->
	</div>
</body>
<script>
	$('#collapseOne').on('shown.bs.collapse', function() {
		$(".fa").removeClass("fa-folder-o").addClass("fa-folder-open-o");
	});

	$('#collapseOne').on('hidden.bs.collapse', function() {
		$(".fa").removeClass("fa-folder-open-o").addClass("fa-folder-o");
	});

	function showf() {
		var x = document.getElementById("collapseOne");
		if (x.style.display === "none") {
			x.style.display = "block";
		} else {
			x.style.display = "none";
		}
	}
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<script src="assets/js/my-login.js"></script>
</html>