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
                <div class="col-md-4">
                    <h3>Ins&eacute;rtion Region</h3>
                    <br>
                    <form action="/admin/createRegion" method="post">
                        <input type="text" name="nomregion" placeholder="Nom Region..."
                               class="form-control input-lg m-bot15">
                        <br>
                        <div class="form-group">
                            <button class="btn btn-primary" type="submit">Ins&eacute;rer</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-4">
                    <h3>Modifier Region</h3>
                    <br>
                    <form action="/admin/updateRegion" method="post">
                        <select name="idregion" class="form-control input-lg m-bot15">
                            <option value="">Region...</option>
                            <c:forEach var="ls" items="${listeRegion}">
                                <option value="${ls.getId()}">${ls.getNomregion()}
                                </option>
                            </c:forEach>
                        </select>
                        <br>
                        <input type="text" name="nomregion" placeholder="Nom Region..."
                               class="form-control input-lg m-bot15">
                        <br>
                        <div class="form-group">
                            <button class="btn btn-warning" type="submit">Modifier</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-4"><h3>Supprimer Region</h3>
                    <br>
                    <form action="/admin/deleteRegion" method="post">
                        <select name="idregion" class="form-control input-lg m-bot15">
                            <option value="">Region...</option>
                            <c:forEach var="ls" items="${listeRegion}">
                                <option value="${ls.getId()}">${ls.getNomregion()}
                                </option>
                            </c:forEach>
                        </select>
                        <br>
                        <div class="form-group">
                            <button class="btn btn-danger" type="submit">Supprimer</button>
                        </div>
                    </form>
                </div>
                <br>
                <table
                        class="table table-striped table-hover table-condensed table-bordered">
                    <tr>
                        <th>Id</th>
                        <th>Date et heure</th>
                    </tr>
                    <c:forEach var="lregion" items="${listeRegion}">
                        <tr>
                            <td>${lregion.id}</td>
                            <td>${lregion.nomregion}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </section>
        <!-- footer -->
        <%@ include file="../fichiers/footer.jsp" %>
        <!-- / footer -->
</body>
</html>