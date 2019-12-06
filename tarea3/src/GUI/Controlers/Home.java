package GUI.Controlers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Home {
    public void clickMusic(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/Music.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Música");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            msg.show();
        }
    }

    public void clickVideos(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/Video.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Vídeos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            msg.show();
        }
    }

    public void clickVideogames(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../Views/Videogame.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Videojuegos");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            msg.show();
        }
    }
}
