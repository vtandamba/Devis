package fr.sorefa.controllers;

import java.io.IOException;
import java.util.LinkedHashMap;

import fr.sorefa.App;
import fr.sorefa.model.M_Chantiers;
import fr.sorefa.model.M_Civilite;
import fr.sorefa.model.M_Clients;
import fr.sorefa.model.M_Statut;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;

public class C_Chantiers {
    @FXML
    private TableView<M_Chantiers> tb_chantiers;

    @FXML
    private TableColumn<M_Chantiers, Integer> tc_id_chantier;

    @FXML
    private TableColumn<M_Chantiers, String> tc_nomChantier;

    @FXML
    private TableColumn<M_Chantiers, String> tc_codePostal;

    @FXML
    private TableColumn<M_Chantiers, String> tc_ville;

    @FXML
    private TableColumn<M_Chantiers, String> tc_adresse;

    @FXML
    private Button bt_details;

    @FXML
    private Button bt_chantiers;
    @FXML
    private Button bt_ajout;

    @FXML
    private Button bt_modif;

    @FXML
    private TextField ed_chantier;

    @FXML
    private Label lb_chantier;

    @FXML
    private TextField ed_nom_client;
    @FXML
    private TextField ed_prenom_client;

    @FXML
    private Label lb_nom_client;

    @FXML
    private Label lb_prenom_client;

    @FXML
    private TextField ed_adresse;

    @FXML
    private Label lb_adresse;

    @FXML
    private TextField ed_adresse_suite;

    @FXML
    private Label lb_adresse_suite;

    @FXML
    private TextField ed_lieu_dit;

    @FXML
    private Label lb_lieu_dit;

    @FXML
    private TextField ed_cp;

    @FXML
    private Label lb_cp;

    @FXML
    private TextField ed_ville;

    @FXML
    private Label lb_ville;

    @FXML
    private Label lb_description;

    @FXML
    private TextArea ta_description;

    @FXML
    private Button bt_annuler;

    @FXML
    private Button bt_client;

    @FXML
    private Button bt_devis;

    @FXML
    private Button bt_supp;
    @FXML
    private Button bt_enreg;
    @FXML
    private Label lb_idChant;

    @FXML
    private Label lb_idchantier;

    private M_Chantiers unChantier;
    private TableViewSelectionModel<M_Chantiers> tv_model;
    private ObservableList<M_Chantiers> les_Chantiers;
    private ObservableList<M_Clients> les_Clients;
    private ObservableList<M_Statut> les_statuts;
    private ObservableList<M_Civilite> les_civilites;
    private Db_mysql baseSO;
    public int iChantierSelected;

    private App leControl;

    public void setApp(App leControlleur) {
        leControl = leControlleur;
    }

    @FXML
    void aff_client(ActionEvent event) throws Exception {
        Integer idClient = Integer.valueOf(lb_idChant.getText());
        try {
            System.out.println(" id.." + idClient);
            M_Clients unClient = les_Clients.get(idClient);
            leControl.afficherClients_details(unClient, 0);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @FXML
    void aff_devis(ActionEvent event) {

    }

    @FXML
    void fermer_chantierDetails(ActionEvent event) {
        leControl.closeWindow("chantier_details");
    }

    @FXML
    void supp_chantier_details(ActionEvent event) {

    }

    @FXML
    void enreg_chantiers(ActionEvent event) {

    }

    @FXML
    void ajoutChantiers(ActionEvent event) {

    }

    @FXML
    void modifChantiers(ActionEvent event) {

    }

    @FXML
    void aff_details(ActionEvent event) throws Exception {
        int choix = 0;
        tv_model = tb_chantiers.getSelectionModel();
        M_Chantiers itemsChantiers = tv_model.getSelectedItem();
        if (itemsChantiers != null) {
            iChantierSelected = les_Chantiers.indexOf(itemsChantiers);
            if (iChantierSelected >= 0) {
                unChantier = les_Chantiers.get(iChantierSelected);
                leControl.afficherChantier_details(itemsChantiers, choix);
                ;
            }
        }

    }

    @FXML
    void onClickFermerChantiers(ActionEvent event) throws IOException {
        leControl.closeWindow("chantier_liste");
    }

    /**
     * @param lesChantiers
     * @throws Exception
     */
    public void affChantiers(LinkedHashMap<Integer, M_Chantiers> lesChantiers) throws Exception {

        TableViewSelectionModel<M_Chantiers> tv_model = tb_chantiers.getSelectionModel();
        tv_model.setSelectionMode(SelectionMode.SINGLE);
        les_Chantiers = FXCollections.observableArrayList(lesChantiers.values());

        try {
            tc_id_chantier
                    .setCellValueFactory(new PropertyValueFactory<M_Chantiers, Integer>(String.valueOf("id_chantier")));
            tc_nomChantier.setCellValueFactory(
                    new PropertyValueFactory<M_Chantiers, String>(String.valueOf("libelle_chantier")));
            tc_ville.setCellValueFactory(new PropertyValueFactory<M_Chantiers, String>("ville_chantier"));
            tc_codePostal.setCellValueFactory(new PropertyValueFactory<M_Chantiers, String>("cp_chantier"));
            tc_adresse.setCellValueFactory(new PropertyValueFactory<M_Chantiers, String>("adresse1_chantier"));

            tb_chantiers.setItems(les_Chantiers);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erreur");

        }
    }

    public void aff_V_Chantier_details(M_Chantiers unChantier,
            LinkedHashMap<Integer, M_Chantiers> lesChantiers,
            LinkedHashMap<Integer, M_Clients> lesClients,
            LinkedHashMap<String, M_Civilite> lesCivilites,
            LinkedHashMap<String, M_Statut> lesStatuts, int choix) {

        les_Chantiers = FXCollections.observableArrayList(lesChantiers.values());
        les_Clients = FXCollections.observableArrayList(lesClients.values());
        les_statuts = FXCollections.observableArrayList(lesStatuts.values());
        les_civilites = FXCollections.observableArrayList(lesCivilites.values());

        switch (choix) {
            case 0:
                // Partie détail
                M_Clients unClient = lesClients.get(unChantier.getId_client());
                ed_chantier.setText(unChantier.getLibelle_chantier());
                ed_nom_client.setText(unClient.getNom_client());
                ed_prenom_client.setText(unClient.getPrenom_client());
                ed_adresse.setText(unChantier.getAdresse1_chantier());
                ed_adresse_suite.setText(unChantier.getAdresse2_chantier());
                ed_cp.setText(unChantier.getCp_chantier());
                ed_ville.setText(unChantier.getVille_chantier());
                ed_lieu_dit.setText(unChantier.getLieu_dit_chantier());
                ta_description.setText(unChantier.getDescription_chantier());
                lb_idChant.setText(String.valueOf(unChantier.getId_client()));
                lb_idchantier.setText(String.valueOf(unChantier.getId_chantier()));
                bt_annuler.setVisible(true);
                lb_idChant.setVisible(false);
                lb_idchantier.setVisible(false);
                ;
                // bt_ajout.setVisible(false);
                bt_enreg.setVisible(false);
                bt_supp.setVisible(true);

                break;
            case 1:
                // Partie Ajout
                bt_annuler.setVisible(true);
                bt_ajout.setVisible(false);
                bt_enreg.setVisible(true);
                bt_supp.setVisible(false);
                break;
            case 2:
                // Partie modifier
                ed_chantier.setText(unChantier.getLibelle_chantier());
                ed_nom_client.setText(String.valueOf(unChantier.getId_client()));
                ed_adresse.setText(unChantier.getAdresse1_chantier());
                ed_adresse_suite.setText(unChantier.getAdresse2_chantier());
                ed_cp.setText(unChantier.getCp_chantier());
                ed_ville.setText(unChantier.getVille_chantier());
                ed_lieu_dit.setText(unChantier.getLieu_dit_chantier());
                ta_description.setText(unChantier.getDescription_chantier());

                bt_ajout.setVisible(false);
                bt_supp.setVisible(false);
                bt_enreg.setVisible(true);
                bt_annuler.setVisible(true);

                break;
            case 3:
                // Partie supprimer
                break;
        }
    }

}
