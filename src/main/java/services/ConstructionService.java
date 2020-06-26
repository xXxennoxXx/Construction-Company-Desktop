package services;

import entities.constructions.ConstructionEntity;
import entities.persons.WorkerEntity;
import repos.ConstructionRepo;

import java.util.*;

public class ConstructionService {

    //TODO czy static zeby mniej obiektów było, czy bezpiecznie nie?
    private ConstructionRepo constructionRepo;


    public ConstructionService() {
        this.constructionRepo = new ConstructionRepo();
    }

    public Long save(String name, WorkerEntity boss) {
        return save(new ConstructionEntity(name, boss));
    }


    private Long save(ConstructionEntity constructionEntity) {
        return constructionRepo.save(constructionEntity);
    }

    public List<ConstructionEntity> getConstructionsWithAllProperties() {
        return constructionRepo.getConstructionsWithAllAttributes();
    }

    //    TODO Logika w setterach i getterach czy np package private czesc "niebezpiecznej" logiki
//    Czy addWorker i addConstruction
    public void assignWorkers(ConstructionEntity constructionEntity, WorkerEntity... workerEntities) {
        constructionEntity.getWorkers().addAll(Arrays.asList(workerEntities));
        constructionRepo.update(constructionEntity);
        for (WorkerEntity workerEntity : workerEntities)
            workerEntity.getConstructions().add(constructionEntity);
    }

    public void assignWorkersWithAdder(ConstructionEntity constructionEntity, WorkerEntity... workerEntities) {


        Set<WorkerEntity> workers = new HashSet<>(constructionEntity.getWorkers());
        Set<WorkerEntity> workerEntities1 = new HashSet<>(Arrays.asList(workerEntities));

        workers.removeAll(workerEntities1);

        for (WorkerEntity workerEntity : workers)
            workerEntity.removeConstruction(constructionEntity);

        for (WorkerEntity workerEntity : workerEntities)
            constructionEntity.addWorker(workerEntity);

//        TODO Update jednego czy obu?
        constructionRepo.update(constructionEntity);

    }
}
