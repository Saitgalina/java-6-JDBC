package myServlets;
import model.User;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/files")
public class MainServlet extends HttpServlet {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            HttpSession session = req.getSession(true);
            Object login = session.getAttribute("login");
        String path = req.getParameter("path");
        File root = new File("C:\\Users\\");
        if (path == null) {
            path = searchDir(root,login);
        }
        if (path == null) {
            Path pathNew = Files.createDirectories(Paths.get("C:\\Users\\home\\java_test\\"+login+"\\"));
            path = pathNew.toAbsolutePath().toString();
        }

        File currentPath = new File(path);

        Path path1 = currentPath.toPath();
        String strpath = path1.toString();
        path1.getParent().toFile().getAbsolutePath();

        if (currentPath.isDirectory() && strpath.contains(login.toString())) {
            viewFiles(req, currentPath);
            req.setAttribute("date", dateFormat.format(new Date()));
            req.setAttribute("currentPath", path1);
            req.getRequestDispatcher("mypage.jsp").forward(req, resp);
        } else if (currentPath.isFile()){
            downloadFile(resp, currentPath);
        }
        else{
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }
    private String  searchDir(File root, Object login){
        String res = null;
        if(root.isDirectory()){
            File[] dirFiles = root.listFiles();
             for(File f : dirFiles){
                 if(f.isDirectory() && f.getName().equals(login)) {
                     res = f.getPath();
                     return res;
                 }
             }
        }
        return res;
    }

    private void viewFiles(HttpServletRequest req, File currentPath) {
        File[] allFiles = currentPath.listFiles();
        if (allFiles == null) {
            return;
        }
        List<File> directories = new ArrayList<>();
        List<File> files = new ArrayList<>();
        for (File file : allFiles) {
            (file.isDirectory() ? directories : files).add(file);
        }
        req.setAttribute("files", files);
        req.setAttribute("directories", directories);
    }
    private void downloadFile(HttpServletResponse resp, File file) throws IOException {
        resp.setHeader("Content-disposition", "attachment; filename=" + file.getName());

        try (InputStream in = Files.newInputStream(file.toPath()); OutputStream out = resp.getOutputStream()) {
            byte[] buffer = new byte[4096];

            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

    }
}
