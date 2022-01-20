<header class="header fixed-top clearfix">
    <!--logo start-->
    <div class="brand">

        <a href="/accueil" class="logo">
            ADMIN
        </a>
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars"></div>
        </div>
    </div>
    <!--logo end-->

    <div class="top-nav clearfix">
        <!--search & user info start-->
        <ul class="nav pull-right top-menu">
            <!-- user login dropdown start-->
            <li class="dropdown">
                <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                    <img alt="" src="<%= request.getContextPath()%>/images/2.png">
                    <% Admin a = (Admin) session.getAttribute("admin"); %>
                    <span class="username"><%= a.getNom() %></span>
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu extended logout">
                    <% if (a.getUsername() != null) { %>
                    <li><a href="/admin/logout"><i class="fa fa-key"></i> Deconnexion</a></li>
                    <% } %>
                </ul>
            </li>
            <!-- user login dropdown end -->

        </ul>
        <!--search & user info end-->
    </div>
</header>