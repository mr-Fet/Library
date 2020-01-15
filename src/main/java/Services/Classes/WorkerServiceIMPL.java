package Services.Classes;

import Model.User;
import Repository.WorkerRepository;
import Repository.WorkerRepositoryIMPL;
import Services.WorkerService;

public class WorkerServiceIMPL implements WorkerService {

    private WorkerRepository workerRepository = new WorkerRepositoryIMPL();

    @Override
    public User searchUser(String login, String password){
        return workerRepository.searchUser(login,password);
    }

    @Override
    public void addWorker(int workerId, int roleId, String login, String password) {
        workerRepository.addWorker(workerId,roleId,login,password);
    }

    @Override
    public void updateWorker(int workerId, int roleId, String login, String password) {
        workerRepository.updateWorker(workerId,roleId,login,password);
    }

    @Override
    public void deleteWorker(int workerId) {
        workerRepository.deleteWorker(workerId);
    }
}
