package repos;

import entities.persons.ClientEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.show;

class ClientRepoTest {

    private static ClientRepo clientRepo;

    @BeforeAll
    public static void init() {

        clientRepo = new ClientRepo();
    }

    @Test
    void getClients() {

        List<ClientEntity> clients = clientRepo.getClients();
        show(clients.get(0).toString());

    }

    @Test
    void getClient() {
        List<ClientEntity> clients = clientRepo.getClients();
        Long id = clients.get(0).getId();

        ClientEntity client = clientRepo.getClient(id);


        show(client.toString());


    }
}