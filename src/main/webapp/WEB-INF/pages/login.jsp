<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
    <head>
        <%@ include file = "../fichiers/header.jsp" %>
    </head>
    <body>
        <div class="log-w3">
            <div class="w3layouts-main">
                <h2>LOGIN</h2>
                <form action="/admin/login" method="post">
                    <input type="text" class="ggg" name="username" value="TREMA" placeholder="Nom utilisateur" >
                    <input type="password" class="ggg" name="mdp" value="123456" placeholder="Mot de passe" >

                    <div class="clearfix"></div>
                    <input type="submit" value="Se connecter" name="login">
                </form>
                <% String errorLogin = (String) request.getAttribute("errorLogin"); %>
                <% if (errorLogin != null && errorLogin.equals("errorInformation")) { %>
                    <div class="alert alert-danger" role="alert">
                        <strong>Erreur: </strong> Verifier vos informations
                    </div>
                <% } %>
            </div>
        </div>
        <script src="<%= request.getContextPath()%>/js/bootstrap.js"></script>
        <script src="<%= request.getContextPath()%>/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="<%= request.getContextPath()%>/js/scripts.js"></script>
        <script src="<%= request.getContextPath()%>/js/jquery.slimscroll.js"></script>
        <script src="<%= request.getContextPath()%>/js/jquery.nicescroll.js"></script>
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="<%= request.getContextPath()%>/js/flot-chart/excanvas.min.js"></script><![endif]-->
        <script src="js/jquery.scrollTo.js"></script>
    </body>
</html>
