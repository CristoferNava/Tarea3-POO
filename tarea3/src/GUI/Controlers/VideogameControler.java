package GUI.Controlers;

import Negocios.Videogame;
import Negocios.VideogameManager;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class VideogameControler implements Initializable {
    public TextField txtSKU;
    public TextField txtTitle;
    public TextField txtYear;
    public TextField txtEdition;
    public TextField txtRating;
    public TextField txtConsole;
    public Button btnFirst;
    public Button btnPrevious;
    public Button btnNext;
    public Button btnLast;
    public Button btnAdd;
    public Button btnEdit;
    public Button btnRemove;
    public Button btnAccept;
    public Button btnCancel;
    public Label counter;

    private Action action = Action.NAVIGATE;
    private VideogameManager videogameManager = null;
    private int position = -1;

    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.videogameManager = new VideogameManager();
            this.controls();
            if (!this.videogameManager.getVideogamesList().isEmpty()) {
                this.position = 0;
                this.load();
            }
        } catch (Exception ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            msg.show();
        }
    }

    public void clickFirst(ActionEvent actionEvent) {
        this.position = 0;
        this.load();
    }

    public void clickPrevious(ActionEvent actionEvent) {
        this.position -= 1;
        if (this.position < 0) {
            this.position = 0;
        }
        this.load();
    }

    public void clickNext(ActionEvent actionEvent) {
        this.position += 1;
        if (this.position > this.videogameManager.getVideogamesList().size() - 1) {
            this.position = this.videogameManager.getVideogamesList().size() - 1;
        }
        this.load();
    }

    public void clickLast(ActionEvent actionEvent) {
        this.position = this.videogameManager.getVideogamesList().size() - 1;
        this.load();
    }

    public void clickAdd(ActionEvent actionEvent) {
        this.action = Action.ADD;
        this.controls();
    }

    public void clickEdit(ActionEvent actionEvent) {
        this.action = Action.EDIT;
        this.controls();
    }

    public void clickRemove(ActionEvent actionEvent) {
        this.action = Action.REMOVE;
        this.controls();
    }

    public void clickAccept(ActionEvent actionEvent) {
        try {
            Videogame videogame = new Videogame(this.txtSKU.getText(), this.txtTitle.getText(), this.txtYear.getText(),
                    this.txtEdition.getText(), this.txtRating.getText(), this.txtConsole.getText());
            switch (this.action) {
                case ADD:
                    this.videogameManager.add(videogame);
                    this.position += 1;
                    break;
                case EDIT:
                    this.videogameManager.edit(videogame);
                    break;
                case REMOVE:
                    this.videogameManager.remove(videogame);
                    this.position -= 1;
                    break;
            }
            this.load();
            this.action = Action.NAVIGATE;
            this.controls();
        } catch (Exception ex) {
            Alert msg = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            msg.show();
        }
    }

    public void clickCancel(ActionEvent actionEvent) {
        this.load();
        this.action = Action.NAVIGATE;
        this.controls();
    }

    public void controls() {
        this.txtSKU.setDisable(true);
        this.txtTitle.setDisable(true);
        this.txtYear.setDisable(true);
        this.txtEdition.setDisable(true);
        this.txtRating.setDisable(true);
        this.txtConsole.setDisable(true);


        btnFirst.setDisable(true);
        btnPrevious.setDisable(true);
        btnNext.setDisable(true);
        btnLast.setDisable(true);

        btnAdd.setDisable(true);
        btnEdit.setDisable(true);
        btnRemove.setDisable(true);

        btnAccept.setDisable(true);
        btnCancel.setDisable(true);

        switch (this.action) {
            case NAVIGATE:
                btnFirst.setDisable(false);
                btnPrevious.setDisable(false);
                btnNext.setDisable(false);
                btnLast.setDisable(false);
                btnAdd.setDisable(false);
                btnEdit.setDisable(false);
                btnRemove.setDisable(false);
                break;
            case ADD:
                this.txtSKU.setDisable(false);
            case EDIT:
                this.txtTitle.setDisable(false);
                this.txtYear.setDisable(false);
                this.txtEdition.setDisable(false);
                this.txtRating.setDisable(false);
                this.txtConsole.setDisable(false);
                this.btnAccept.setDisable(false);
                this.btnCancel.setDisable(false);
                break;
            case REMOVE:
                this.btnAccept.setDisable(false);
                this.btnCancel.setDisable(false);
                break;
        }
    }

    public void load() {
        if (this.position < 0) {
            this.txtSKU.setText("");
            this.txtTitle.setText("");
            this.txtYear.setText("");
            this.txtEdition.setText("");
            this.txtRating.setText("");
            this.txtConsole.setText("");
            this.counter.setText("0/0");
            return;
        }

        Videogame videogame = videogameManager.getVideogamesList().get(this.position);
        this.txtSKU.setText(videogame.getSKU());
        this.txtTitle.setText(videogame.getTitle());
        this.txtYear.setText(videogame.getYear());
        this.txtEdition.setText(videogame.getEdition());
        this.txtRating.setText(videogame.getRating());
        this.txtConsole.setText(videogame.getConsole());
        this.counter.setText((this.position + 1) + "/" + (this.videogameManager.getVideogamesList().size()));
    }
}
