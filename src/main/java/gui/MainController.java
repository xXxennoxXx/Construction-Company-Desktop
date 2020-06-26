package gui;

import entities.constructions.ConstructionEntity;
import entities.constructions.HouseEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import repos.ConstructionRepo;
import repos.HouseRepo;
import services.ConstructionService;
import services.HouseService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static final String CONSTRUCTIONS = "Constructions",
            HOUSES = "Houses";

    private static MainController instance;

    public MainController() {
        instance = this;
    }

    @FXML
    private Button btnReload;
    @FXML
    private FlowPane piProgress;
    @FXML
    private TableView<ConstructionEntity> tvConstructions;
    @FXML
    private TabPane tbMainTabPane;
    @FXML
    private Tab tabConstruction;
    @FXML
    private ListView<DisplayListView> lvConstructions;
    @FXML
    private ListView<AddDataListView> lvAddData;
    @FXML
    private ListView<String> lvInfo;


    private ConstructionService constructionService;
    private HouseService houseService;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        constructionService = new ConstructionService();
        houseService = new HouseService();

        //lvConstructions initialization
        {
            lvConstructions.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            lvConstructions.getItems().addAll(DisplayListView.values());
            lvAddData.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            lvAddData.getItems().addAll(AddDataListView.values());
        }


    }

    public void click(ActionEvent actionEvent) {
        //TODO Połączenie click z kartą inaczej niż umieszczanie przycisku na karcie?
//        EventHandler w karcie?

        if (tbMainTabPane.getSelectionModel().getSelectedItem().getProperties().get("TYPE") == DisplayListView.SHOW_ALL_CONSTRUCTION) {
            TableView<ConstructionEntity> tvConst = (TableView<ConstructionEntity>) tbMainTabPane.getSelectionModel().getSelectedItem().getContent();
            tvConst.setDisable(true);
            tvConst.getItems().clear();
            piProgress.setVisible(true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<ConstructionEntity> constructions = constructionService.getConstructionsWithAllProperties();
                    for (ConstructionEntity c : constructions)
                        tvConst.getItems().add(c);
                    piProgress.setVisible(false);
                    tvConst.setDisable(false);
                }
            }).start();

        } else if (tbMainTabPane.getSelectionModel().getSelectedItem().getProperties().get("TYPE") == DisplayListView.SHOW_ALL_HOUSES) {
            TableView<HouseEntity> tvConst = (TableView<HouseEntity>) tbMainTabPane.getSelectionModel().getSelectedItem().getContent();
            tvConst.setDisable(true);
            tvConst.getItems().clear();
            piProgress.setVisible(true);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    List<HouseEntity> houses = houseService.getHousesWithAllProperties();
                    for (HouseEntity c : houses)
                        tvConst.getItems().add(c);
                    piProgress.setVisible(false);
                    tvConst.setDisable(false);
                }
            }).start();

        }

    }

    public void conClick(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2)
            addTab(lvConstructions.getSelectionModel().getSelectedItem().getTab());

    }

    public void addClick(MouseEvent mouseEvent) {

//        TODO Resize dodanej karty do max wymiarów tabPane
//        CZy wszystkie elementy na computedSize i min max zmianiac?

        if (mouseEvent.getClickCount() == 2) {
            double width = tbMainTabPane.getWidth();
            double height = tbMainTabPane.getHeight();

            Tab pane = lvAddData.getSelectionModel().getSelectedItem().getPane();

//            pane.getContent()
//pane.getGraphic().setW
            FlowPane content = (FlowPane) pane.getContent();
            content.setMaxWidth(width);
            content.setMaxHeight(height);
            addTab(pane);
        }


    }

    private void addTab(Tab tab) {
        tbMainTabPane.getTabs().add(tab);
        tbMainTabPane.getSelectionModel().select(tab);
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void printMessage(String... msg) {
        lvInfo.getItems().addAll(msg);
    }

    //    TODO Komunikacja pomiedzy kontrollerami oknami
    public static MainController getInstance() {
        return instance;
    }

    public void longAction(Boolean bool) {
        tbMainTabPane.setDisable(bool);
        piProgress.setVisible(bool);
    }
}
