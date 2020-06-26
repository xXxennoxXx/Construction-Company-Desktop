package repos;

import entities.constructions.HouseEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.show;

class HouseRepoTest {

    private static HouseRepo houseRepo;

    @BeforeAll
    public static void init(){

        houseRepo = new HouseRepo();
    }

    @Test
    void getHouses() {

        List<HouseEntity> houses = houseRepo.getHousesWithAllAttributes();

        show(houses.get(0).toString());


    }
}