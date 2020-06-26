package gui;

import entities.constructions.ConstructionEntity;
import entities.constructions.HouseEntity;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.NumberFormat;

public enum DisplayListView {

    SHOW_ALL_CONSTRUCTION("Show all constructions") {
        @Override
        public Tab getTab() {
//            TODO Czy można po naciśnieciu wyświtlać dane na bocznym Panelu, sciagac dane na biezaco czy raz?
//            Raz trwa dlugo
            Tab constructions = new Tab("Display All Constrictions");
            constructions.getProperties().put("TYPE", this);
            TableView<ConstructionEntity> tvConstructions = new TableView<>();

            TableColumn<ConstructionEntity, Integer> entityIntegerTableColumn = new TableColumn<>("ID");
            entityIntegerTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            tvConstructions.getColumns().add(entityIntegerTableColumn);

            TableColumn<ConstructionEntity, String> name = new TableColumn<>("Name");
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            tvConstructions.getColumns().add(name);

            TableColumn<ConstructionEntity, String> cost = new TableColumn<>("Total");
            cost.setCellValueFactory(param -> {
                        ConstructionEntity value = param.getValue();
                        return new ReadOnlyObjectWrapper<>(NumberFormat.getCurrencyInstance().format(value.cost()));
                    }
            );
            tvConstructions.getColumns().add(cost);

            TableColumn<ConstructionEntity, Integer> columnHouses = new TableColumn<>("Houses");
            columnHouses.setCellValueFactory(param -> {
                        ConstructionEntity value = param.getValue();
                        return new ReadOnlyObjectWrapper<>(value.getHouses().size());
                    }
            );
            tvConstructions.getColumns().add(columnHouses);

            TableColumn<ConstructionEntity, Integer> columnWorkers = new TableColumn<>("Workers");
            columnWorkers.setCellValueFactory(param -> {
                        ConstructionEntity value = param.getValue();
                        return new ReadOnlyObjectWrapper<>(value.getWorkers().size());
                    }
            );
            tvConstructions.getColumns().add(columnWorkers);

            TableColumn<ConstructionEntity, Integer> owner = new TableColumn<>("Boss");
            owner.setCellValueFactory(param -> {
                return new SimpleIntegerProperty(Math.toIntExact(param.getValue().getBoss().getId())).asObject();
            });
            tvConstructions.getColumns().add(owner);


            TableColumn<ConstructionEntity, String> ownerName = new TableColumn<>("Boss Name");
            ownerName.setCellValueFactory(param -> {
                return new SimpleStringProperty(param.getValue().getBoss().getFirstName());
            });
            tvConstructions.getColumns().add(ownerName);


            constructions.setContent(tvConstructions);
            return constructions;
        }
    },
    SHOW_ALL_WORKER("Show all workers") {
        @Override
        public Tab getTab() {
            //TODO
            Tab show_all_workers = new Tab("Show all workers");

            show_all_workers.setContent(new Label("TODO"));

            return show_all_workers;
        }
    },
    SHOW_ALL_HOUSES("Show all houses") {
        @Override
        public Tab getTab() {
            Tab houses = new Tab("Display All Houses");
            houses.getProperties().put("TYPE", this);
            TableView<HouseEntity> tvHouses = new TableView<>();


            TableColumn<HouseEntity, Integer> entityIntegerTableColumn = new TableColumn<>("ID");
            entityIntegerTableColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            tvHouses.getColumns().add(entityIntegerTableColumn);

            TableColumn<HouseEntity, String> name = new TableColumn<>("House Name");
            name.setCellValueFactory(new PropertyValueFactory<>("name"));
            tvHouses.getColumns().add(name);

            TableColumn<HouseEntity, String> type = new TableColumn<>("Type");
            type.setCellValueFactory(new PropertyValueFactory<>("type"));
            tvHouses.getColumns().add(type);


            TableColumn<HouseEntity, String> cost = new TableColumn<>("Total");
            cost.setCellValueFactory(param -> {
                        HouseEntity value = param.getValue();
                        return new ReadOnlyObjectWrapper<>(NumberFormat.getCurrencyInstance().format(value.getCost()));
                    }
            );
            tvHouses.getColumns().add(cost);

            TableColumn<HouseEntity, Integer> columnRooms = new TableColumn<>("Rooms");
            columnRooms.setCellValueFactory(param -> {
                        HouseEntity value = param.getValue();
                        return new ReadOnlyObjectWrapper<>(value.getRooms().size());
                    }
            );
            tvHouses.getColumns().add(columnRooms);


            TableColumn<HouseEntity, String> owner = new TableColumn<>("Construction Name");
            owner.setCellValueFactory(param -> {
                return new SimpleStringProperty(param.getValue().getConstruction().getName());
            });
            tvHouses.getColumns().add(owner);


            TableColumn<HouseEntity, String> ownerName = new TableColumn<>("Owner Name");
            ownerName.setCellValueFactory(param -> {
                return new SimpleStringProperty(param.getValue().getOwner().getFirstName());
            });
            tvHouses.getColumns().add(ownerName);

            houses.setContent(tvHouses);
            return houses;
        }
    };

    private final String name;

    DisplayListView(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract Tab getTab();
}
