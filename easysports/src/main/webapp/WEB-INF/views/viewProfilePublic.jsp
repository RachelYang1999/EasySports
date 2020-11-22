<%--
  Created by IntelliJ IDEA.
  User: yangqiuli
  Date: 2020/10/30
  Time: 8:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="sideBar.jsp"/>
    <script src="${pageContext.request.contextPath}/static/js/viewProfile.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/viewProfile.css" rel="stylesheet" type="text/css">

    <title>Profile</title>
</head>
<body>


<div class = "wholeBottom">
    <div class = "leftPage">
    </div>

    <div class = "main-page" >

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

        <main class="profile">
            <div class="profile-bg"></div>
            <section class="container">
                <aside class="profile-image">
                    <div class="edit-icon">
                        <button class="far fa-edit" type="button"  onclick="location.href='<%=request.getContextPath()%>/editProfile'"></button>
                    </div>
                    <%--                        <button class="edit-icon" type="button"  onclick="location.href='<%=request.getContextPath()%>/editProfile'"></button>--%>

                    <%--                        <a class="edit-icon" href="location.href='<%=request.getContextPath()%>/editProfile'">--%>
                    <%--                            <i class="far fa-edit"></i>--%>
                    <%--                        </a>--%>
                </aside>
                <section class="profile-info">
                    ${urlWarning}
                    <h1 class="name">${userName}</h1>
                    <h2>ABOUT</h2>
                    <p>
                        ${description}
                    </p>

                    <form class="social-media-icons" method="post">

                        <div>
                            <button type="submit" class="fab fa-facebook" name="facebook" value="facebook"></button>
                        </div>
                    </form>
                </section>
            </section>
        </main>

    </div>

</div>




</body>
</html>


    </div>




</body>
</html>
