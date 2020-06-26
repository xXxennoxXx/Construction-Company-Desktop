package gui;

import entities.constructions.ConstructionEntity;
import entities.persons.WorkerEntity;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import repos.ConstructionRepo;
import repos.WorkerRepo;
import services.ConstructionService;
import services.WorkerService;

import java.net.URL;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @FXML
    private TextField tfName;
    @FXML
    private ComboBox<WorkerEntity> cbBoss;

    private static MainController mainController;
    private ConstructionService constructionService;
    private WorkerService workerService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        {
            mainController = MainController.getInstance();
            workerService = new WorkerService();
            constructionService = new ConstructionService();
        }
        {
            new Thread(() -> {
                List<WorkerEntity> workers = workerService.getWorkers();
                workers.sort(Comparator.comparing(o -> o.getFirstName()));
                cbBoss.setItems(FXCollections.observableArrayList(workers));
            }).start();
        }
    }

    public void clickAdd(ActionEvent actionEvent) {

        String text = tfName.getText();
        WorkerEntity bossWorker = cbBoss.getSelectionModel().getSelectedItem();

        if (text == null || text.isEmpty() || bossWorker == null) {
            mainController.printMessage("Please fill mandatory fields.");
            return;
        }
        Long save = constructionService.save(text, bossWorker);
        mainController.printMessage("Constuction: " + text + " with Boss as: " + bossWorker.getFirstName() + " started with ID: " + save);
    }
}
