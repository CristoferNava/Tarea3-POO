package GUI.Controlers;

import javafx.fxml.Initializable;
import Negocios.Video;
import Negocios.VideoManager;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class VideoControler implements Initializable {
    public TextField txtSKU;
    public TextField txtArtist;
    public TextField txtTitle;
    public TextField txtYear;
    public TextField txtRating;
    public TextField txtType;
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
    private VideoManager videoManager = null;
    private int position = -1;

    public void initialize(URL url, ResourceBundle rb) {
        try {
            this.videoManager = new VideoManager();
            this.controls();
            if (!this.videoManager.getVideosList().isEmpty()) {
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
        if (this.position > this.videoManager.getVideosList().size() - 1) {
            this.position = this.videoManager.getVideosList().size() - 1;
        }
        this.load();
    }

    public void clickLast(ActionEvent actionEvent) {
        this.position = this.videoManager.getVideosList().size() - 1;
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
            Video video = new Video(this.txtSKU.getText(), this.txtArtist.getText(), this.txtTitle.getText(),
                    this.txtYear.getText(), this.txtRating.getText(), this.txtType.getText());
            switch (this.action) {
                case ADD:
                    this.videoManager.add(video);
                    this.position += 1;
                    break;
                case EDIT:
                    this.videoManager.edit(video);
                    break;
                case REMOVE:
                    this.videoManager.remove(video);
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
        this.txtArtist.setDisable(true);
        this.txtTitle.setDisable(true);
        this.txtYear.setDisable(true);
        this.txtRating.setDisable(true);
        this.txtType.setDisable(true);


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
                this.txtArtist.setDisable(false);
                this.txtTitle.setDisable(false);
                this.txtYear.setDisable(false);
                this.txtRating.setDisable(false);
                this.txtType.setDisable(false);
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
            this.txtArtist.setText("");
            this.txtTitle.setText("");
            this.txtYear.setText("");
            this.txtRating.setText("");
            this.txtType.setText("");
            this.counter.setText("0/0");
            return;
        }

        Video video = videoManager.getVideosList().get(this.position);
        this.txtSKU.setText(video.getSKU());
        this.txtArtist.setText(video.getArtist());
        this.txtTitle.setText(video.getTitle());
        this.txtYear.setText(video.getYear());
        this.txtRating.setText(video.getRating());
        this.txtType.setText(video.getType());
        this.counter.setText((this.position + 1) + "/" + (this.videoManager.getVideosList().size()));
    }
}
