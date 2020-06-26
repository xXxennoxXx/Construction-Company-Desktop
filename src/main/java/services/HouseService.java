package services;

import entities.constructions.HouseEntity;
import repos.HouseRepo;

import java.util.List;

public class HouseService {

    private HouseRepo houseRepo;

    public HouseService() {
        this.houseRepo = new HouseRepo();
    }

    public List<HouseEntity> getHousesWithAllProperties() {
        return houseRepo.getHousesWithAllAttributes();
    }

}
