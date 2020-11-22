<%--
  Created by IntelliJ IDEA.
  User: yangqiuli
  Date: 2020/10/31
  Time: 1:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="welcome_layout.jsp"/>
    <jsp:include page="sideBar.jsp"/>
    <script src="${pageContext.request.contextPath}/static/js/viewProfile.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/viewProfile.css" rel="stylesheet" type="text/css">

    <title>Edit Profile</title>
</head>
<body>


<div class = "wholeBottom">
    <div class = "leftPage">
    </div>

    <div class = "main-page" >
<%--        <div>--%>
<%--            <h1 style="text-align:center">--%>
<%--                Edit your profile--%>
<%--            </h1>--%>
<%--        </div>--%>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">

        <main class="profile">
            <div class="profile-bg"></div>
            <div class="container">
                <aside class="profile-side">
                    <div class="edit-icon">
                        <button class="fas fa-backward" type="button" onclick="location.href='<%=request.getContextPath()%>/viewProfile'"></button>
                    </div>
                </aside>
                <form class="profile-info" method="post">
                    <h1 class="name">${userName}</h1>
                    ${warning}
<%--                    <label for="userName">Reset your username: </label>--%>
                    <h2>Reset your username:</h2>
                    <input type="text" class="form-control" id="userName" name="userName"
                           placeholder = "${userName}"
                           onfocus="this.placeholder = ''"
                           onblur="this.placeholder = '${userName}'" >
                    ${userNameWarning}
                    <br>
                    <h2>ABOUT</h2>
                    <textarea rows="4" cols="30" name="description"
                              placeholder="${description}"
                              onfocus="this.placeholder = ''"
                              onblur="this.placeholder = '${description}'"
                    ></textarea>
                    ${desWarning}
                    <br>
                    <br>
                    <h2>Your Address</h2>
                    <input type="text" class="form-control"
                           id="address"
                           placeholder="E.g., 1 ABC Road"
                           onfocus="this.placeholder = ''"
                           onblur="this.placeholder = 'E.g., 1 ABC Road'"
                           name="address">
                    ${addressWarning}
                    <br>
                    <h2>Your Facebook Link</h2>
                    <input type="text" class="form-control"
                           id="fbURL"
                           placeholder="E.g., https://www.facebook.com/profile.****"
                           onfocus="this.placeholder = ''"
                           onblur="this.placeholder = 'E.g., https://www.facebook.com/profile.****'"
                           name="fbURL">
                    ${fbWarning}

                    <div>
                        <button type="submit">Submit</button>
                    </div>


                </form>
            </div>
        </main>

    </div>

</div>

</body>
</html>
