<%@ page import="com.spring.backoffice.model.Admin" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@ include file="../fichiers/header.jsp" %>
</head>
<body>
<section id="container">
    <!--header start-->
    <%@ include file="../fichiers/navBar.jsp" %>
    <!--header end-->
    <!--sidebar start-->
    <%@ include file="../fichiers/sideBar.jsp" %>
    <!--sidebar end-->
    <!--main content start-->
    <!--Content manomboka eto-->
    <section id="main-content">
        <section class="wrapper">
            <div class="table-agile-info">
                <h1>Recherche avanc&eacute;</h1>
                <br>
                <form action="/admin/rechercheAv" method="post">
                    <select name="idtypesignalement" class="form-control input-lg m-bot15">
                        <option value="">TypeSignalement...</option>
                        <c:forEach var="lts" items="${typeSignalements}">
                            <option value="${lts.id}">${lts.typesignalement}
                            </option>
                        </c:forEach>
                    </select>
                    <br>
                    <select name="idstatut" class="form-control input-lg m-bot15">
                        <option value="">Statut...</option>
                        <c:forEach var="ls" items="${statuts}">
                            <option value="${ls.getId()}">${ls.getNomstatut()}
                            </option>
                        </c:forEach>
                    </select>
                    <br>
                    <div class="form-group">
                        <button class="btn btn-danger" type="submit">Rechercher</button>
                    </div>
                </form>
                <br>
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
                            <th>Date et heure</th>
                            <th>Designation</th>
                            <th>Signalement</th>
                            <th>Region</th>
                            <th>Statut</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="sc" items="${listeSignalements}">
                            <tr>
                                <td>${sc.nom}</td>
                                <td>${sc.prenom}</td>
                                <td>${sc.dateheure}</td>
                                <td>${sc.designation}</td>
                                <td>${sc.typesignalement}</td>
                                <td>${sc.nomregion}</td>
                                <td>${sc.nomstatut}</td>
                                <td><a href="<%= request.getContextPath()%>/admin/supprimerSignalement/${sc.id}"
                                       type="button" class="btn btn-danger">Supprimer</a></td>
                                <td><a href="<%= request.getContextPath()%>/admin/seeMore/${sc.idclient}/${sc.id}"
                                       type="button" class="btn btn-info">Voir Plus</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <!-- footer -->
        <%@ include file="../fichiers/footer.jsp" %>
        <!-- / footer -->
</body>
</html>