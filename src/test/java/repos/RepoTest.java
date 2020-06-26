package repos;

import entities.constructions.HouseEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.show;

class RepoTest {
    private static HouseRepo houseRepo;

    @BeforeAll
    public static void init() {
        houseRepo = new HouseRepo();
    }

    @Test
    public void houseRoomEnum() {
        List<HouseEntity> houses = houseRepo.getHousesWithAllAttributes();
        show(String.valueOf((houses.size())));
        assertNotNull(houses);
        assertNotEquals(0, houses.size());


    }


}