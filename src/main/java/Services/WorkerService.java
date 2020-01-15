package Services;

import Model.Client;
import Model.User;

import javax.servlet.http.Cookie;
import java.util.List;

public interface WorkerService {
    User searchUser(String login, String password);
    void addWorker(int workerId, int roleId, String login, String password);
    void updateWorker(int workerId, int roleId, String login, String password);
    void deleteWorker(int workerId);
}
