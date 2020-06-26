package repos;

import entities.constructions.HouseEntity;
import org.hibernate.Session;

import java.util.List;

public class HouseRepo extends Repo {

    public List<HouseEntity> getHousesWithAllAttributes() {
        try (Session session = getSession()) {
            return session.createQuery("select distinct h from HouseEntity h " +
                    "left join fetch h.construction cn" +
                    "left join fetch h.owner on" +
                    "left join fetch h.rooms", HouseEntity.class).getResultList();
        }
    }

}
