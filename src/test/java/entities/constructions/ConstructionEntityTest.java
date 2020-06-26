package entities.constructions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import repos.ConstructionRepo;

import java.text.NumberFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.show;

class ConstructionEntityTest {

    private static ConstructionRepo constructionRepo;

    @BeforeAll
    public static void init() {
        constructionRepo = new ConstructionRepo();
    }

    @Test
    void getCost() {

        List<ConstructionEntity> constructionsWithAllAttributes = constructionRepo.getConstructionsWithAllAttributes();

        ConstructionEntity constructionEntity = constructionsWithAllAttributes.get(0);
//Exception
//        show("Cost: ", NumberFormat.getCurrencyInstance().format(constructionEntity.getCost()));

    }

    @Test
    void cost() {
        List<ConstructionEntity> constructionsWithAllAttributes = constructionRepo.getConstructionsWithAllAttributes();

        ConstructionEntity constructionEntity = constructionsWithAllAttributes.get(0);

        show("Cost: ", NumberFormat.getCurrencyInstance().format(constructionEntity.cost()));
    }

    @Test
    void getCost2() {
        List<ConstructionEntity> constructionsWithAllAttributes = constructionRepo.getConstructionsWithAllAttributes();

        ConstructionEntity constructionEntity = constructionsWithAllAttributes.get(0);

        show("Cost: ", NumberFormat.getCurrencyInstance().format(constructionEntity.getCost2()));
    }
}