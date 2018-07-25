<%--
  Created by IntelliJ IDEA.
  User: BaoNQ9
  Date: 6/26/2018
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<head>
    <%--<meta http-equiv="Content-Type" content="text/html; char/--%>
</head>

<body class="hold-transition skin-blue sidebar-mini">
<p>
    Username: <span id="username">asdgdg</span>
    Class: <small id="user-role"></small>
</p>
<a onclick="document.forms['logoutForm'].submit()" class="btn btn-default btn-flat">Logoutttttt</a>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <form class="hidden" id="logoutForm" method="POST" action="${contextPath}/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</c:if>

<form onsubmit="sendFile()">
    Upload file<input id="file" type="file">
    <button type="submit" id="send-file">Submit</button>
</form>
</body>
</html>
<script type="application/javascript">
    let username = '${pageContext.request.userPrincipal.principal}'.toUpperCase();
    let userRole = "Unknown";
    if (!username) {
        username = "Unknown";
    }
    switch ('${pageContext.request.userPrincipal.authorities}') {
        case '[ROLE_ADMIN]':
            userRole = "Admin";
            break;
        case '[ROLE_USER]':
            userRole = "User";
            break;
    }
    document.getElementById("username").textContent = username;
    document.getElementById("user-role").textContent = userRole;

    function sendFile() {
        let input = document.getElementById('btn-upload-file');
        let check = AssetView.validateFileInput(AssetView.content.btnUploadFile, ['csv']);
        //In case the input file are valid
        if (check) {
            AssetOctopus.uploadFile();
        } else {
            AssetAddView.showNotify(BUNDLES.invalidInputFile, ERROR);
        }
    }

</script>