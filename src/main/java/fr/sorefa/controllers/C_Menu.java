package fr.sorefa.controllers;

import fr.sorefa.App;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class C_Menu {
    @FXML
    private MenuItem mn_fermerMenu;

    @FXML
    private Button bt_chantiers;

    @FXML
    private Button bt_salaries;

    @FXML
    private Button bt_quitterDevis;

    @FXML
    private Button bt_clients;

    @FXML
    private Button bt_produits;

    @FXML
    private Button bt_parametre;

    @FXML
    private Button bt_Devis;

    private App leControl;

    public void setApp(App leControlleur) {
        leControl = leControlleur;
    }

    /**
     * @param event
     * @throws Exception
     */
    @FXML
    void onClickAffClients(ActionEvent event) throws Exception {
        // leControl.affClients();
        leControl.afficherClients_liste();

    }

    /**
     * @param event
     */
    @FXML
    void onClickFermerMenu(ActionEvent event) {
        Platform.exit();
    }

    /**
     * @param event
     * @throws Exception
     */
    @FXML
    void onClickAffDevis(ActionEvent event) throws Exception {
        leControl.afficherDevis();
    }

    /**
     * @param event
     * @throws Exception
     */
    @FXML
    void onClickAffChantiers(ActionEvent event) throws Exception {
        leControl.afficherChantiers();
    }

    /**
     * @param event
     * @throws Exception
     */
    @FXML
    void onClickAffProduits(ActionEvent event) throws Exception {
        leControl.afficherProduit_liste();

    }

}
