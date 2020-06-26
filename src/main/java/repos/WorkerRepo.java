package repos;

import entities.persons.WorkerEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class WorkerRepo extends Repo {

    public List<WorkerEntity> getWorkers() {
        try (Session session = getSession()) {
            return session.createQuery(
                    "select distinct w from worker w"
                    , WorkerEntity.class).getResultList();
        }
    }


    public List<WorkerEntity> getWorkersWithConstructions() {

        List<WorkerEntity> entities;

        try (Session session = getSession()) {
            entities = session.createQuery(
                    "select distinct w from worker w "
                    , WorkerEntity.class).getResultList();
            for (WorkerEntity workerEntity : entities) {
                Hibernate.initialize(workerEntity.getConstructions());
                Hibernate.initialize(workerEntity.getBossOnConstructions());
            }
        }
        return entities;
    }

    public Long save(WorkerEntity workerEntity) {
        try (Session session = getSession()) {
            session.beginTransaction();
            Long save = (Long) session.save(workerEntity);
            session.getTransaction().commit();
            return save;
        }

    }


}
