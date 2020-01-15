package Servlets.WorkerServ;

import Model.User;
import Services.Classes.WorkerServiceIMPL;
import Services.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/UpdateWorkerServ")
public class UpdateWorkerServ extends HttpServlet {

    Integer workerId;
    Integer roleId;
    String login;
    String password;
    private WorkerService workerService = new WorkerServiceIMPL();
    private User user;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("workerId");
        try {
            workerId = Integer.parseInt(id);
            switch (req.getParameter("role")) {

                case ("byAdmin"):
                    roleId = 1;
                    break;

                case ("byLibrarian"):
                    roleId = 2;
                    break;
            }

            login = req.getParameter("login");
            password = req.getParameter("password");
            user = workerService.searchUser(login,password);
            if(user==null){
                writer.println("Сотрудника с такими данными не существует");
            }
            else {
                workerService.updateWorker(workerId,roleId,login,password);

                writer.println("Сотрудник успешно создан" + "<br/>");
                writer.println(  workerId +  "<br/>");
                writer.println(  roleId +  "<br/>");
                writer.println( login +  "<br/>");
                writer.println( password +  "<br/>");
            }
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id сотрудника");
        }
    }
}
