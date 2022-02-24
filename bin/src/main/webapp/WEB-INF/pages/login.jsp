<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <%@ include file="../fichiers/header.jsp" %>
</head>
<body>
<div class="log-w3">
    <div class="w3layouts-main">
        <h2>LOGIN</h2>
        <form action="/admin/login" method="post">
            <input type="email" class="ggg" name="email" value="trema@gmail.com" placeholder="Email">
            <input type="password" id="password" class="ggg" name="mdp" value="qwerty123" placeholder="Mot de passe" onKeyUp="checkPassword();">

            <div class="clearfix"></div>
            <input type="submit" value="Se connecter" name="login">
        </form>
        <div class="invalid-feedback" id="check-pwd" ></div>
<%--        <div class="alert alert-warning" id="check-pwd" role="alert"></div>--%>

        <% String errorLogin = (String) request.getAttribute("errorLogin"); %>
        <% if (errorLogin != null && errorLogin.equals("errorInformation")) { %>
        <div class="alert alert-danger" role="alert">
            <strong>Erreur: </strong> Verifier vos informations
        </div>
        <% } else if (errorLogin != null && errorLogin.equals("accents")) { %>
        <div class="alert alert-danger" role="alert">
            <strong>Erreur: </strong> Mot de passe contenant des accents
        </div>
        <% } else if (errorLogin != null && errorLogin.equals("tropCourt")) { %>
        <div class="alert alert-danger" role="alert">
            <strong>Erreur: </strong> Mot de passe trop court
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
<script src="<%= request.getContextPath()%>/js/jquery.min.js"></script>
<script>
    function checkPassword() {
        var accents = /([\u00C0-\u024F])/;
        if ($('#password').val().length < 8) {
            $('#check-pwd').html("<strong>Attention: </strong> Doit etre superieur a 8 caracteres");
        } else {
            if ($('#password').val().match(accents)) {
                $('#check-pwd').html("<strong>Attention: </strong> Accents non autoris&eacute;");
            } else {
                $('#check-pwd').html("");
            }
        }
    }
</script>
</body>
</html>
