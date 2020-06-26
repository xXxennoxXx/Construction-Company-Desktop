package repos;

import entities.constructions.ConstructionEntity;
import entities.constructions.HouseEntity;
import entities.constructions.HouseType;
import entities.persons.WorkerEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.show;

class ConstructionRepoTest {

    private static ConstructionRepo constructionRepo;

    @BeforeAll
    public static void init() {
        constructionRepo = new ConstructionRepo();
    }

    @Test
    void getConstructions() {
        List<ConstructionEntity> constructions = constructionRepo.getConstructions();
        show("Constructions: " + constructions.size());


        assertNotNull(constructions);
        assertNotEquals(0, constructions.size());
    }

    @Test
    void getConstructionsWithHouses() {
        List<ConstructionEntity> constructions = constructionRepo.getConstructionsWithHouses();

        int count = 0,
                b = 0,
                w = 0,
                wb = 0,
                n = 0;
        for (ConstructionEntity c : constructions) {
            count += c.getHouses().size();
            for (HouseEntity h : c.getHouses())
                if (h.getType() == HouseType.WOODEN) w += 1;
                else if (h.getType() == HouseType.BRICK) b += 1;
                else if (h.getType() == HouseType.WOODEN_BRICK) wb += 1;
                else n += 1;
        }
        show("Constructions: " + constructions.size() +
                        ", Houses: " + count,
                "\tWooden: " + w,
                "\tBrick: " + b,
                "\tWooden-Brick: " + wb,
                "\tNon recognized: " + n);


        assertNotNull(constructions);
        assertNotEquals(0, constructions.size());
    }


    @Test
    void save() {

        ConstructionEntity constructionEntity = new ConstructionEntity();
        constructionEntity.setName("Test");
        WorkerEntity workerEntity = new WorkerEntity();
        workerEntity.setId(1592l);
        constructionEntity.setBoss(workerEntity);

        Long save = constructionRepo.save(constructionEntity);
        show(String.valueOf(save));
    }

    @Test
    void getConstructionsOnly() {
        show(String.valueOf(constructionRepo.getConstructions().size()));
    }

    @Test
    public void updateTest() {
//TODO Działa
        List<ConstructionEntity> constructionsWithAllAttributes = constructionRepo.getConstructionsWithAllAttributes();
        ConstructionEntity constructionEntity = constructionsWithAllAttributes.get(0);

        show(constructionEntity.toString());

//        constructionEntity.setName("ABC"); Nie ma update
//        constructionEntity.setId(1000);
        constructionEntity.setName("Modelowanie i Analiza Systemów");
        show("------------------------------------------");
        new Repo() {
            public void update(ConstructionEntity constructionEntity) {
                try (Session session = getSession()) {
                    session.beginTransaction();
                    session.update(constructionEntity);
//                    session.flush();
                    session.getTransaction().commit();

                }
            }
        }.update(constructionEntity);

        show(constructionEntity.toString());
    }

    @Test
    public void updateTestAddWorkers() {
//TODO Skoro działa i ciągle ściągamy dane to czy martwić się wiązaniami?
        ConstructionEntity constructionEntity = constructionRepo.getConstructionsWithAllAttributes().get(0);
        WorkerEntity workerEntity = new WorkerRepo().getWorkers().get(0);

        show("------------------------------------------",
                constructionEntity.toString(),
                workerEntity.toString(),
                String.valueOf(constructionEntity.getWorkers().contains(workerEntity)));

        constructionEntity.getWorkers().add(workerEntity);
        show("------------------------------------------",
                constructionEntity.toString(),
                workerEntity.toString(),
                String.valueOf(constructionEntity.getWorkers().contains(workerEntity)));
        new Repo() {
            public void update(ConstructionEntity constructionEntity) {
                try (Session session = getSession()) {
                    session.beginTransaction();
                    session.update(constructionEntity);
                    session.getTransaction().commit();

                }
            }
        }.update(constructionEntity);
        constructionEntity = constructionRepo.getConstructionsWithAllAttributes().get(0);
        show("------------------------------------------",
                constructionEntity.toString(),
                workerEntity.toString(),
                String.valueOf(constructionEntity.getWorkers().contains(workerEntity)));
    }

}