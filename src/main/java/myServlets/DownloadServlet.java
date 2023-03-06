package myServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/downland")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("path");
        String fileName = Paths.get(parameter).getFileName().toString();

        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition","attachment; filename=" + fileName);


        File myFile = new File(parameter);

        OutputStream out = resp.getOutputStream();
        FileInputStream in = new FileInputStream(myFile);

        byte[] buffer = new byte[4096];
        int length;

        while ((length = in.read(buffer)) > 0){
            out.write(buffer, 0, length);
        }

        in.close();
        out.flush();
    }
}
