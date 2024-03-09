package fr.sorefa.controllers;

import fr.sorefa.App;

// import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class C_Devis {

    @FXML
    private MenuItem bt_fermer;

    @FXML
    private Button bt_retourduDevis;
    @FXML
    private MenuItem devisPdf;

    @FXML
    private MenuItem mi_devis_enreg;

    private App leControl;

    public void setApp(App leControlleur) {
        leControl = leControlleur;
    }

    @FXML
    void charger_devis(ActionEvent event) {

    }

    @FXML
    void ouvrirDevisPdf(ActionEvent event) throws Exception {
        leControl.telechargerPDF();
    }

    @FXML
    void onClickFermerDevis(ActionEvent event) {
        leControl.closeWindow("devis_liste");
    }

    @FXML
    void fermer(Button bt_retourduDevis) {
        String bouton = bt_retourduDevis.getText();
        System.out.println(bouton);
    }

    // App.closeDevis();
    // Platform.visibles(false);
}
