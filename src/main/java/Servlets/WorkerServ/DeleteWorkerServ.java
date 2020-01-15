package Servlets.WorkerServ;

import Services.Classes.WorkerServiceIMPL;
import Services.WorkerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/DeleteWorkerServ")
public class DeleteWorkerServ extends HttpServlet {

    Integer workerId;
    private WorkerService workerService = new WorkerServiceIMPL();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String id = req.getParameter("workerId");
        try {
            workerId = Integer.parseInt(id);
        }
        catch (NumberFormatException e)
        {
            writer.println("Перепроверьте id сотрудника" + e);
        }

        workerService.deleteWorker(workerId);
        writer.println("Сотрудник c id" + workerId + " успешно удален");

    }
}
