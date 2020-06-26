package repos;

import entities.persons.WorkerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static utils.StringUtils.show;

class WorkerRepoTest {

    private static WorkerRepo workerRepo;

    @BeforeAll
    public static void init() {
        workerRepo = new WorkerRepo();
    }

    @Test
    void getWorkers() {
        List<WorkerEntity> workers = workerRepo.getWorkersWithConstructions();
        show(workers.get(0).toString());
        Assertions.assertNotNull(workers);

    }

    @Test
    void testGetWorkers() {
        show(String.valueOf(workerRepo.getWorkers().size()));
        Assertions.assertTrue(workerRepo.getWorkers().size() > 0);

    }
}