package Servlets.LibraryServ;

import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/RegisterNewUserServ")
public class RegisterNewUserServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("sessionUser");

        if(user!=null) {
            if (user.getRoleName().equals("admin")) {

                String path = req.getContextPath() + "/webPart/WEB-INF/views/worker/workerEditing.html";
                resp.sendRedirect(path);
            } else {
                writer.println("У вас нет прав доступа!");
            }
        }
        else {
            writer.println("У вас нет прав доступа!");
        }
    }
}
