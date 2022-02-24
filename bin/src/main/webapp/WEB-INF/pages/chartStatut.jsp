<%@ page import="com.spring.backoffice.model.Admin" %>
<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <%@ include file="../fichiers/header.jsp" %>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <script src="<%= request.getContextPath()%>/js/jquery2.0.3.min.js"></script>
    <!-- charts -->
    <script src="<%= request.getContextPath()%>/js/raphael-min.js"></script>
    <script src="<%= request.getContextPath()%>/js/morris.js"></script>
    <link rel="stylesheet" href="<%= request.getContextPath()%>/css/morris.css">
    <!-- //charts -->
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
    <section id="main-content">
        <section class="wrapper">
            <div class="chart_agile">
                <div class="col-md-6 floatcharts_w3layouts_left">
                    <div class="floatcharts_w3layouts_top">
                        <div class="floatcharts_w3layouts_bottom">
                            <div id="graph"></div>
                            <script>
                                // Use Morris.Bar
                                Morris.Bar({
                                    element: 'graph',
                                    data: [
                                        <c:forEach var="stat" items="${statStatut}">
                                        {x: '${stat.getNomstatut()}', y: '${stat.getNombre()}'},
                                        </c:forEach>
                                    ],
                                    xkey: 'x',
                                    ykeys: ['y'],
                                    labels: ['Effectif'],
                                    barColors: function (row, series, type) {
                                        if (type === 'bar') {
                                            var red = Math.ceil(255 * row.y / this.ymax);
                                            return 'rgb(' + red + ',0,0)';
                                        } else {
                                            return '#000';
                                        }
                                    }
                                });
                            </script>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </section>
        <!-- footer -->
        <%@ include file="../fichiers/footer.jsp" %>
        <!-- / footer -->
</body>
</html>
