<%@ page import="com.spring.backoffice.model.Admin" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@ include file = "../fichiers/header.jsp" %>
</head>
<body>
<section id="container">
    <!--header start-->
    <%@ include file = "../fichiers/navBar.jsp" %>
    <!--header end-->
    <!--sidebar start-->
    <%@ include file = "../fichiers/sideBar.jsp" %>
    <!--sidebar end-->
    <!--main content start-->
    <!--Content manomboka eto-->
    <section id="main-content">
        <section class="wrapper">
            <div class="table-agile-info">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Les signalisations non affecter
                    </div>
                    <div>
                        <table class="table" ui-jq="footable" ui-options='{
                            "paging": {
                              "enabled": true
                            },
                            "filtering": {
                              "enabled": true
                            },
                            "sorting": {
                              "enabled": true
                            }}'>
                            <thead>
                            <tr>
                                <th>Date et heure</th>
                                <th>Designation</th>
                                <th>Latitude</th>
                                <th>Longitude</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="signalement" items="${signalements}">
                                    <tr>
                                        <td>${signalement.dateheure}</td>
                                        <td>${signalement.designation}</td>
                                        <td>${signalement.latitude}</td>
                                        <td>${signalement.longitude}</td>
                                        <td><a href="<%= request.getContextPath()%>/admin/affecter/${signalement.id}" type="button" class="btn btn-primary">Affecter</a></td>
                                        <td><a href="<%= request.getContextPath()%>/admin/seeMore/${signalement.idclient}/${signalement.id}" type="button" class="btn btn-info">Voir Plus</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="table-agile-info">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Toutes les signalisations
                    </div>
                    <div>
                        <table class="table" ui-jq="footable" ui-options='{
                            "paging": {
                              "enabled": true
                            },
                            "filtering": {
                              "enabled": true
                            },
                            "sorting": {
                              "enabled": true
                            }}'>
                            <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Username</th>
                                <th>Date et heure</th>
                                <th>Designation</th>
                                <th>Signalement</th>
                                <th>Region</th>
                                <th>Statut</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="sc" items="${signalementComplets}">
                                <tr>
                                    <td>${sc.nom}</td>
                                    <td>${sc.prenom}</td>
                                    <td>${sc.username}</td>
                                    <td>${sc.dateheure}</td>
                                    <td>${sc.designation}</td>
                                    <td>${sc.typesignalement}</td>
                                    <td>${sc.nomregion}</td>
                                    <td>${sc.nomstatut}</td>
                                    <td><a href="<%= request.getContextPath()%>/admin/supprimerSignalement/${sc.id}" type="button" class="btn btn-danger">Supprimer</a></td>
                                    <td><a href="<%= request.getContextPath()%>/admin/seeMore/${sc.idclient}/${sc.id}" type="button" class="btn btn-info">Voir Plus</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <!-- footer -->
        <%@ include file = "../fichiers/footer.jsp" %>
        <!-- / footer -->
</body>
</html>
