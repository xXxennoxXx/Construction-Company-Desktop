package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.FlowPane;

import java.io.IOException;

public enum AddDataListView {

    ADD_CONSTRUCTION("Add Construction") {
        @Override
        public Tab getPane() {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Add_Construction.fxml"));
                root.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
                root.getProperties().put("TYPE", this);
                Tab tab = new Tab(this.toString());
                tab.setContent(root);

                return tab;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }, ASSIGN_WORKER("Assign workers") {
        @Override
        public Tab getPane() {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/Add_Worker_To_Construction.fxml"));
                root.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
                root.getProperties().put("TYPE", this);
                Tab tab = new Tab(this.toString());
                tab.setContent(root);
                root.setDisable(true);


                return tab;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    };

    private final String name;

    AddDataListView(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract Tab getPane();
}
