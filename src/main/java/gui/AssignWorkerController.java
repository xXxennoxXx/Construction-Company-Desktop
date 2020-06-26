package gui;

import entities.constructions.ConstructionEntity;
import entities.persons.WorkerEntity;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import repos.ConstructionRepo;
import repos.WorkerRepo;
import services.ConstructionService;
import services.WorkerService;

import java.net.URL;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.Set;

//TODO Czy dwa kontrollery to dobre rozwiązanie?
public class AssignWorkerController implements Initializable {

    @FXML
    private ListView<WorkerEntity> lvWorkers;
    @FXML
    private ComboBox<ConstructionEntity> cbConstruction;
    @FXML
    private ListView<WorkerEntity> lvWorkersOnConstruction;
    @FXML
    private FlowPane fpMain;

    private static MainController mainController = MainController.getInstance();

    private WorkerService workerService;
    private ConstructionService constructionService;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        constructionService = new ConstructionService();
        workerService = new WorkerService();

        fpMain.setDisable(true);

        mainController.longAction(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                cbConstruction.setItems(FXCollections.observableArrayList(constructionService.getConstructionsWithAllProperties()));
                lvWorkers.setItems(FXCollections.observableArrayList(workerService.getWorkersWithConstructions()));
                lvWorkers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                mainController.longAction(false);
                fpMain.setDisable(false);
            }
        }).start();

    }

    public void addSelected(ActionEvent actionEvent) {
        for (WorkerEntity w : lvWorkers.getSelectionModel().getSelectedItems())
            lvWorkersOnConstruction.getItems().add(w);

        lvWorkers.getItems().removeAll(lvWorkers.getSelectionModel().getSelectedItems());

    }

    public void chooseConst(ActionEvent actionEvent) {

        lvWorkers.getItems().addAll(lvWorkersOnConstruction.getItems());
        lvWorkers.getItems().sort(Comparator.comparing(e -> e.getId()));
        lvWorkersOnConstruction.getItems().clear();

        Set<WorkerEntity> workers = cbConstruction.getSelectionModel().getSelectedItem().getWorkers();

        lvWorkers.getItems().removeAll(workers);
        lvWorkersOnConstruction.getItems().addAll(workers);
        lvWorkersOnConstruction.getItems().sort(Comparator.comparing(e -> e.getId()));
    }

    public void removeSelected(ActionEvent actionEvent) {

        for (WorkerEntity w : lvWorkersOnConstruction.getSelectionModel().getSelectedItems())
            lvWorkers.getItems().add(w);

        lvWorkersOnConstruction.getItems().removeAll(lvWorkersOnConstruction.getSelectionModel().getSelectedItems());
    }

    public void assign(ActionEvent actionEvent) {

        constructionService.assignWorkersWithAdder(cbConstruction.getSelectionModel().getSelectedItem(),
                lvWorkersOnConstruction.getItems().toArray(new WorkerEntity[1]));

//        constructionService.assignWorkers(cbConstruction.getSelectionModel().getSelectedItem(),
//                lvWorkersOnConstruction.getItems().toArray(new WorkerEntity[1]));
    }
}
