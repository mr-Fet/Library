package Servlets.LibraryServ;

import Model.User;
import Services.Classes.WorkerServiceIMPL;
import Services.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/EnterIntoSystem")
public class EnterIntoSystem extends HttpServlet {

    private WorkerService workerService = new WorkerServiceIMPL();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = workerService.searchUser(login, password);

        if (user.getLogin()!=null&&user.getLogin().equals(login)){
            if (user.getPassword()!=null&&user.getPassword().equals(password)){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("sessionUser", user);
                String path = req.getContextPath() + "/webPart/WEB-INF/views/mainMenu.html";
                resp.sendRedirect(path);
            }
            else {
                writer.println("Неверный пароль!");
            }
        }
        else {
            writer.println("Неверный логин!");
        }

    }
}
