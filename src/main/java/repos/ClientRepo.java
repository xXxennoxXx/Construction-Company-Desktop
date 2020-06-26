package repos;

import entities.persons.ClientEntity;
import org.hibernate.Session;

import java.util.List;

public class ClientRepo extends Repo {
    public List<ClientEntity> getClients() {
        try (Session session = getSession()) {
            return session.createQuery("select c from client c", ClientEntity.class).getResultList();
        }
    }

    public ClientEntity getClient(Long id) {
        try (Session session = getSession()) {
            return session.createQuery("select c from client c left join fetch c.houses where c.id= " + id,
                    ClientEntity.class).getSingleResult();
        }
    }
}
