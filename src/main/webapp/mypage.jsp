<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Page</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
.logout-form {
        position: fixed;
        right: 8px;
        top: 8px;
      }
</style>
</head>
<body>
    <div class="logout-form">
    <form action="./files/out"  method="post" accept-charset="UTF-8">
        <button type="submit" class="btn btn-primary btn-block">
            Выход
        </button>
    </form>
    </div>
    <h5>${requestScope.date}</h5>
        <h1>${requestScope.currentPath.getParent().toFile().getAbsolutePath()}</h1>
            <ul>
                  <b><img src="https://w7.pngwing.com/pngs/17/645/png-transparent-close-folder-common-toolbar-icon.png" width="16" height="16">
                      <a href="?path=${requestScope.currentPath.getParent().toFile().getAbsolutePath()}">Вверх</a>
                  </b>
                <br><br>
                <c:forEach var="directory" items="${requestScope.directories}">
                    <b><img src="https://pngimg.com/uploads/folder/folder_PNG100476.png" width="16" height="16" alt="directory">
                        <a href="?path=${directory.getAbsolutePath()}">${directory.getName()}/</a><br>
                </c:forEach>
                <c:forEach var="file" items="${requestScope.files}">
                <b><img src="https://e7.pngegg.com/pngimages/806/948/png-clipart-computer-icons-pdf-computer-software-exe-torn-edges-border-angle-rectangle.png" width="16" height="16" alt="file">
                    <a href="?path=${file.getAbsolutePath()}">${file.getName()}</a><br>
                </c:forEach>
            </ul>
</body>
</html>