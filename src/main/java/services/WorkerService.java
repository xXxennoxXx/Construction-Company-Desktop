package services;

import entities.persons.WorkerEntity;
import repos.WorkerRepo;

import java.util.List;

public class WorkerService {

    private WorkerRepo workerRepo;

    public WorkerService() {
        workerRepo = new WorkerRepo();
    }

    public List<WorkerEntity> getWorkers() {
        return workerRepo.getWorkers();
    }

    public List<WorkerEntity> getWorkersWithConstructions() {
        return workerRepo.getWorkersWithConstructions();
    }

}
