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
                <h1>Affectation</h1>
                <br>
                <% Long idSignalement = (Long) request.getAttribute("idSignalement"); %>
                <form action="/admin/updateRegion/<%=idSignalement%>" method="post">
                    <select name="idRegion" class="form-control input-lg m-bot15">
                        <option value="">Region...</option>
                        <c:forEach var="re" items="${regions}">
                            <option value="${re.getId()}">${re.getNomregion()}
                            </option>
                        </c:forEach>
                    </select>
                    <br>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">Affecter</button>
                    </div>
                </form>
            </div>
        </section>
        <!-- footer -->
        <%@ include file="../fichiers/footer.jsp" %>
        <!-- / footer -->
</body>
</html>