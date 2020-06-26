package services;

import entities.constructions.ConstructionEntity;
import entities.persons.WorkerEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repos.ConstructionRepo;
import repos.WorkerRepo;

import static org.junit.jupiter.api.Assertions.*;

class ConstructionServiceTest {

    private static ConstructionRepo constructionRepo;
    private static WorkerRepo workerRepo;

    @BeforeAll
    public static void init() {
        constructionRepo = new ConstructionRepo();
        workerRepo = new WorkerRepo();
    }

    @Test
    void assignWorkersWithAdder() {
        ConstructionEntity constructionEntity = constructionRepo.getConstructionsWithAllAttributes().get(0);

//        TODO Czy zapisywać tak czy oba obiekty lepiej

//        constructionEntity.addWorker(new WorkerEntity());
//        constructionRepo.update(constructionEntity);

// Najpierw wywołana metoda contains zamiast add..
//        java.lang.StackOverflowError
//        at java.util.Objects.hash(Objects.java:128)
//        at entities.persons.PersonEntity.hashCode(PersonEntity.java:42)
//        at entities.persons.WorkerEntity.hashCode(WorkerEntity.java:11)
//        at java.util.HashMap.hash(HashMap.java:339)
//        at java.util.HashMap.containsKey(HashMap.java:596)
//        at java.util.HashSet.contains(HashSet.java:204)
//        at org.hibernate.collection.internal.PersistentSet.contains(PersistentSet.java:181)

        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setFirstName("New Guy");
//DODAJE
//        workerRepo.save(workerEntity);

        constructionEntity.addWorker(workerEntity);
        constructionRepo.update(constructionEntity);


    }
}