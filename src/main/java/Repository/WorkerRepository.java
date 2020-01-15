package Repository;

import Model.User;

public interface WorkerRepository {
    User searchUser(String login, String password);
    void addWorker(int workerId, int roleId, String login, String password);
    void updateWorker(int workerId, int roleId, String login, String password);
    void deleteWorker(int workerId);
}
