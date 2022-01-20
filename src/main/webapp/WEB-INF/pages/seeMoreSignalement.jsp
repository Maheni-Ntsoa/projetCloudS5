<%@ page import="com.spring.backoffice.model.Admin" %>
<%@ page import="com.spring.backoffice.model.SignalementComplet" %>
<%@ page import="com.spring.backoffice.model.Photos" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@ include file="../fichiers/header.jsp" %>
</head>
<body>
<% Photos p = (Photos) request.getAttribute("lesPhotos"); %>
<section id="container">
    <!--header start-->
    <%@ include file="../fichiers/navBar.jsp" %>
    <!--header end-->
    <!--sidebar start-->
    <%@ include file="../fichiers/sideBar.jsp" %>
    <!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <div class="col-md-6">
                <div class="table-agile-info">
                    <h1>Signalement <c:out value="${sc.id}"/></h1>
                    <p>Nom: <c:out value="${sc.nom}"/></p>
                    <p>Prenom: <c:out value="${sc.prenom}"/></p>
                    <p>Username: <c:out value="${sc.username}"/></p>
                    <p>Type Signalement: <c:out value="${sc.typesignalement}"/></p>
                    <p>Statut: <c:out value="${sc.nomstatut}"/></p>
                    <p>Region: <c:out value="${sc.nomregion}"/></p>
                    <p>Designation: <c:out value="${sc.designation}"/></p>
                </div>
            </div>
            <div class="col-md-6">
                <% for (int i = 0; i < p.getPhotos().length; i++) { %>
                <img src="<%= request.getContextPath()%>/sary/<%=p.getPhotos()[i]%>" width="75px" height="75px">
                <% } %>
            </div>
            <br><br>
            <a href="<%= request.getContextPath()%>/admin/supprimerSignalement/${sc.id}" type="button"
               class="btn btn-danger">Supprimer</a>
        </section>
        <!-- footer -->
        <%@ include file="../fichiers/footer.jsp" %>
        <!-- / footer -->
</body>
</html>