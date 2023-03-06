<%@ page import="java.io.File"%>
<%@page import="java.util.List"%>
<%@page import="myServlets.FileDescription"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FileStorage</title>
</head>
<body>
<p>${date}</p>
<h1>${name}</h1>
<hr/>
<img src="https://w7.pngwing.com/pngs/17/645/png-transparent-close-folder-common-toolbar-icon.png" width="16" height="16"><a href="?path=${back}">Вверх</a>
<table>
    <tr>
        <th></th>
        <th>Файл</th>
        <th>Размер</th>
        <th>Дата</th>
    </tr>
    <%
    List<FileDescription> files = (List<FileDescription>) request.getAttribute("files");
    if(files == null) {
        out.print("Files is null");
        return;
    }
    for(int i = 0; i < files.size(); i++) {
        FileDescription file = files.get(i);
    %>
        <tr>
            <% if(file.isDirectory()) { %>
                    <td>
                        <img src="https://pngimg.com/uploads/folder/folder_PNG100476.png" width="16" height="16" alt="directory">
                    </td>
                    <td>
                        <a href="?path=<%=file.getLink()%>"><%=file.getFileName()%></a>
                    </td>
                    <td></td>
                <% } else { %>
                    <td>
                        <img src="https://e7.pngegg.com/pngimages/806/948/png-clipart-computer-icons-pdf-computer-software-exe-torn-edges-border-angle-rectangle.png" width="16" height="16" alt="file">
                    </td>
                    <td>
                        <a href="download?path=<%=file.getLink()%>"><%=file.getFileName()%></a>
                    </td>
                    <td><%=file.getFileSize()%> B</td>
               <% } %>
            <td><%=file.getDate()%></td>
        </tr>
    <% } %>
</table>
</body>
</html>