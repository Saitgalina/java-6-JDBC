package myServlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String parameter = req.getParameter("path");
        String defaultParameter = System.getProperty("user.home");
        String openPath;
        if(parameter == null || parameter.isEmpty()) {
            openPath = defaultParameter;
        }
        else {
            openPath = parameter;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        File file = new File(openPath);
        File[] files = file.listFiles();
        if(files == null){
            resp.sendError(404, "File not found)))");
            return;
        }
        SimpleDateFormat fileFormat = new SimpleDateFormat("d/M/yy, K:mm:ss a");

        List<FileDescription> fileDescriptionList = new ArrayList<>();

        for(File temp : files){
            fileDescriptionList.add(new FileDescription(temp.getName(),
                    openPath + System.getProperty("file.separator") + temp.getName(),
                    String.valueOf(temp.length()),
                    fileFormat.format(new Date(temp.lastModified())),
                    temp.isDirectory()));
        }

        req.setAttribute("date", LocalDateTime.now().format(formatter));
        req.setAttribute("back", file.getParent());
        req.setAttribute("name",openPath);
        req.setAttribute("files",fileDescriptionList);
        req.getRequestDispatcher("mypage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
