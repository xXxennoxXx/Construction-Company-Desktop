package repos;

import entities.constructions.ConstructionEntity;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static utils.StringUtils.show;

public class ConstructionRepo extends Repo {


    public Long save(ConstructionEntity constructionEntity) {
        try (Session session = getSession()) {
            return Long.valueOf((Integer) session.save(constructionEntity));
        }
    }


    //TODO Który sposoób inicjalizacji
//    TODO Czy w każdym przypadku metoda czy np. 3 ogólne, z nadmiarem info w niektórych sytuacjach?
    public List<ConstructionEntity> getConstructionsWithAllAttributes() {

        List<ConstructionEntity> constructions;
        try (Session session = getSession()) {
            constructions = session.createQuery("select distinct c " +
                            "from construction c "
                    , ConstructionEntity.class)
                    .getResultList();
            for (ConstructionEntity c : constructions) {
                c.getHouses().size();
                c.getWorkers().size();
                c.getBoss();
            }

        }
        return constructions;
    }

    public List<ConstructionEntity> getConstructions() {

        List<ConstructionEntity> constructions;
        try (Session session = getSession()) {
            constructions = session.createQuery("select distinct c from construction c  "
                    , ConstructionEntity.class)
                    .getResultList();
        }
        return constructions;
    }


    public List<ConstructionEntity> getConstructionsWithHouses() {
        try (Session session = getSession()) {
            return session.createQuery("select distinct c from construction c " +
                    "left  join fetch c.houses", ConstructionEntity.class).list();
        }
    }

    public void update(ConstructionEntity constructionEntity) {

//        TODO po zmianie na save i zmianie name, nie kluczowy, zaczał zapisywać nowe wartości
        try (Session session = getSession()) {
            session.beginTransaction();
            session.update(constructionEntity);//save
            show("updating", constructionEntity.getName());
            session.getTransaction().commit();

        }

//        TODO Ręczny update?
//        Modelowanie i Analiza Systemów
//        Hibernate: update MAS.dbo.Construction set BossID=?, Name=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: update person set firstName=? where ID=?
//        Hibernate: insert into Construction_Worker (IDConstruction, IDWorker) values (?, ?)


    }

}


