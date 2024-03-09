package fr.sorefa.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.io.BufferedInputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import fr.sorefa.App;
import fr.sorefa.model.M_Civilite;
import fr.sorefa.model.M_Clients;
import fr.sorefa.model.M_Statut;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class C_Clients {
    // client liste nom attributs privés fxml

    @FXML
    private AnchorPane id_anchorPane;

    @FXML
    private Button bt_retour;

    @FXML
    private TableView<M_Clients> tb_clients;

    @FXML
    private TableColumn<M_Clients, Integer> tc_id_client;

    @FXML
    private TableColumn<M_Clients, String> tc_prenom_client;

    @FXML
    private TableColumn<M_Clients, String> tc_nom_client;

    @FXML
    private TableColumn<M_Clients, String> tc_nom_entreprise;
    @FXML
    private TableColumn<M_Clients, Boolean> tc_boolEntreprise;

    @FXML
    private Button bt_details;
    @FXML
    private Button bt_ajout;

    @FXML
    private Button bt_modif;

    @FXML
    private Button bt_supp;
    @FXML
    private Button bt_annuler;
    @FXML
    private Button bt_enreg;
    // fin client liste attributs privés fxml

    // ________________________>> client details attributs privés fxml

    // @FXML
    // private Label lb_idCient;

    @FXML
    private Label lb_prenomClient;

    @FXML
    private Label lb_nomClient;

    @FXML
    private Label lb_nomEntreprise;

    @FXML
    private Label lb_siretClient;

    @FXML
    private Label lb_numTvaClient;

    @FXML
    private Label lb_add1Client;

    @FXML
    private Label lb_add2Client;

    @FXML
    private Label lb_lieuDitClient;

    @FXML
    private Label lb_cpClient;

    @FXML
    private Label lb_villeClient;

    @FXML
    private Label lb_telClient;

    @FXML
    private Label lb_com;

    @FXML
    private Label lb_dateCreate;

    @FXML
    private Label lb_dateUpdate;

    @FXML
    private RadioButton rb_particulier;

    @FXML
    private RadioButton rb_profesionnel;

    @FXML
    private TextField ed_idClient;

    @FXML
    private TextField ed_prenomClient;

    @FXML
    private TextField ed_nomClient;

    @FXML
    private TextField ed_nomEntreprise;

    @FXML
    private TextField ed_siretClient;

    @FXML
    private TextField ed_numTvaClient;

    @FXML
    private TextField ed_add1Client;

    @FXML
    private TextField ed_add2Client;

    @FXML
    private TextField ed_lieuDitClient;

    @FXML
    private TextField ed_cpClient;

    @FXML
    private TextField ed_villeClient;

    @FXML
    private TextField ed_telClient;

    @FXML
    private TextArea ta_com;

    @FXML
    private TextField ed_dateCreate;

    @FXML
    private TextField ed_dateUpdate;
    @FXML
    private Label lb_codeStatut;

    @FXML
    private Label lb_codeCivilite;

    @FXML
    private ComboBox<M_Statut> cb_statut;

    @FXML
    private ComboBox<M_Civilite> cb_civilite;

    @FXML
    private ToggleGroup rbg_boolEnt;
    // _______________fin client attributs details____________

    private App leControl;
    private int iClientSelected;
    private int choix;
    // private int idClient;
    // private Object key;
    // private PdfPTable lesPdfs;
    private M_Civilite uneCivilite;
    private Db_mysql baseSO;
    private M_Statut unStatut;
    private M_Clients unClient;
    private ObservableList<M_Clients> les_Clients;
    private ObservableList<M_Statut> les_statuts;
    private ObservableList<M_Civilite> les_civilites;
    private TableViewSelectionModel<M_Clients> tv_model;
    private LinkedHashMap<Integer, M_Clients> lesClients;
    @FXML
    private TextField ed_filtre;

    // ___________________>> methodes fxml listes clients_______________

    /**
     * Cette méthode fxml se déclanche lorsque l'on clique sur le bouton détail
     * affin d'afficher les détails du client.
     * Elle selectionne le client en fonction de la ligne selectionner,
     * et l'envoi à la méthode afficherClients_details(M_Clients unClient,int
     * choix).
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void aff_details(ActionEvent event) throws Exception {
        int choix = 0;
        tv_model = tb_clients.getSelectionModel();
        // recuperer le client au lieu de son id
        // iClientSelected = tv_model.getSelectedIndex();
        M_Clients itemClientSelected = tv_model.getSelectedItem();

        if (itemClientSelected != null) {
            // unClient = les_Clients.get(iClientSelected);
            iClientSelected = les_Clients.indexOf(itemClientSelected);
            if (iClientSelected >= 0) {
                unClient = les_Clients.get(iClientSelected);
                leControl.afficherClients_details(unClient, choix);
            }
        }
    }

    /**
     * Cette méthode fxml permet de fermer l'interface graphique qui affiche la
     * liste des clients
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void onClickFermerClients(ActionEvent event) throws Exception {
        leControl.closeWindow("client_liste");
    }

    /**
     * Cette méthode fxml permet de charger l'interface d'ajout d'un nouveau client.
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void ajoutClient(ActionEvent event) throws Exception {
        int choix = 1;
        unClient = les_Clients.get(iClientSelected);
        tv_model = tb_clients.getSelectionModel();
        iClientSelected = tv_model.getSelectedIndex();
        leControl.afficherClients_ajout(unClient, choix);
    }

    /**
     * Cette méthode fxml permet de charger l'interface de modification d'un client.
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void modifClient(ActionEvent event) throws Exception {
        int choix = 2;
        tv_model = tb_clients.getSelectionModel();
        M_Clients itemClientSelected = tv_model.getSelectedItem();

        if (itemClientSelected != null) {
            iClientSelected = les_Clients.indexOf(itemClientSelected);
            if (iClientSelected >= 0) {
                leControl.afficherClients_modif(unClient, choix);
            }
        }
    }

    /**
     * Cette méthode fxml permet d'afficher le client selectionner dans le tableau.
     * Elle n'est pas utile pour le projet, mais sert à gèrer l'événement KeyEvent
     * qui se produit lorsqu'une touche est relâchée sur le composant TableView
     * tb_Client.
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void tb_ClientKeyReleased(KeyEvent event) throws Exception {
        sePlacer();
    }

    /**
     * Cette méthode fxml permet d'afficher le client selectionner dans le tableau.
     * Elle n'est pas utile pour le projet, mais sert à gèrer l'événement MouseEvent
     * qui se produit lorsque l'on clique sur un composant TableView tb_Client.
     * Elle permet de faire des tests afin d'obtenir les informations sur le client
     * selectionné dans le tableau
     * 
     * @param event
     */
    @FXML
    void tb_ClientMouseClicked(MouseEvent event) {
        sePlacer();
    }

    /**
     * Cette méthode permet de faire des tests sur l'emplacement du client
     * selectionné
     */
    private void sePlacer() {
        tv_model = tb_clients.getSelectionModel();
        iClientSelected = tv_model.getSelectedIndex();
        unClient = les_Clients.get(iClientSelected);
        int id_client = unClient.getId_client();

        System.out.println("\nle client : " + unClient + " \nson idCLient : " +
                id_client + "\nid du  client selectionné du tableau " + iClientSelected +
                "e place \net l'id recuperer par unClient " + unClient.getId_client());
    }

    /**
     * Methode setApp qui relie les controlleurs aux fenetres
     * 
     * @param leControlleur
     */
    public void setApp(App leControlleur) {
        leControl = leControlleur;
    }

    // _________ methodes fxml de Clients_détail >>>>>>>>>>> TODO

    /**
     * Cette méthode permet de faire un retour à la fenêtre précédente
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void annuler(ActionEvent event) throws Exception {
        // leControl.control();
        initIHM();
        leControl.closeWindow("client_details");
    }

    /**
     * Méthode chargée de la suppression d'un client.
     * Elle parcours la collection à la recherche du client correspondant
     * à l'id selectionné et lorsqu'il est trouvé, il est affecté de la valeur
     * corespondante à l'id selectionné et est envoyé à la méthode
     * supp_Client(M_Clients unClient) chargé de la suppression
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void suppClient(ActionEvent event) throws Exception {
        if (ed_idClient != null) {

            for (M_Clients client : les_Clients) {
                if (client.getId_client() == Integer.valueOf(ed_idClient.getText())) {
                    unClient = client;
                    System.out.println(unClient + "client  correspondant  id est : " + unClient.getId_client());
                } else {
                    // System.out.println(client + "client ne correspondant pas : " +
                    // client.getId_client());
                }
            }
        } else {
            tv_model = tb_clients.getSelectionModel();
            M_Clients itemClientSelected = tv_model.getSelectedItem();
            if (itemClientSelected != null) {
                iClientSelected = les_Clients.indexOf(itemClientSelected);
                if (iClientSelected >= 0) {
                    unClient = les_Clients.get(iClientSelected);
                }
            }
        }

        // Création de la boîte de dialogue de confirmation
        Alert confirmSupp = new Alert(AlertType.CONFIRMATION);
        confirmSupp.setTitle("Confirmarion de supression ");
        confirmSupp.setHeaderText("Vooulez-vous vraiment suprimer ce client ?");
        confirmSupp.setContentText("Cette action est irréversible");

        // Affichage de la boîte de dialogue et traitement de la réponse
        Optional<ButtonType> result = confirmSupp.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            leControl.supprimer_Client(unClient);
            System.out.println("supprimé");
        } else {
            System.out.println("supression annulé");
        }
        leControl.closeWindow("client_details");
    }

    /**
     * Méthode chargée de l'enregistrement d'un client suite à un ajout ou à une
     * modification.
     * L'ajout est distinguée de la modification par la condition si le client
     * existe déjà
     * (enregistrement de modification) ou non (ajout)
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void enreg_client(ActionEvent event) throws Exception {
        try {
            // int index;
            int id_Client;
            Boolean bool_entreprise;
            Float num_tva_client;
            String nom_client, prenom_client,
                    nom_entreprise, siret_client, adresse1_client,
                    adresse2_client, lieu_dit_client, cp_client, ville_client, tel_client, comment,
                    date_create, code_statut, code_civilite;

            nom_client = ed_nomClient.getText();
            prenom_client = ed_prenomClient.getText();
            siret_client = ed_siretClient.getText();
            bool_entreprise = rb_particulier.isSelected() ? false : true;

            nom_entreprise = ed_nomEntreprise.getText();
            num_tva_client = Float.valueOf(ed_numTvaClient.getText());
            adresse1_client = ed_add1Client.getText();
            adresse2_client = ed_add2Client.getText();
            lieu_dit_client = ed_lieuDitClient.getText();
            cp_client = ed_cpClient.getText();
            ville_client = ed_villeClient.getText();
            tel_client = ed_telClient.getText();
            comment = ta_com.getText();
            unStatut = cb_statut.getValue();
            uneCivilite = cb_civilite.getValue();
            M_Statut selectedStatut = cb_statut.getValue();
            code_statut = selectedStatut.getCode_statut();
            M_Civilite selectedCivilite = cb_civilite.getValue();
            code_civilite = selectedCivilite.getCode_civilite();

            System.out.println(ed_idClient.getText() + " l'id du client " + ed_idClient.getText() + " l'id du client ");

            if (ed_idClient.getText() == "") {
                System.out.println("client peut etre ajouter avec un nouvel id : ");

                date_create = ed_dateCreate.getText();
                leControl.ajouter_Client(nom_client, prenom_client, siret_client, bool_entreprise,
                        nom_entreprise, num_tva_client, adresse1_client,
                        adresse2_client, lieu_dit_client, cp_client, ville_client, tel_client, comment,
                        code_statut, code_civilite);
                System.out.println(" le selectionné ajout");
                leControl.closeWindow("client_details");

            } else {
                id_Client = Integer.valueOf(ed_idClient.getText());

                System.out.println("client  peut etre  modifier et garde son id : " + code_statut
                        + " >>code statut et code_civilite<< " + code_civilite);

                leControl.modifier_Client(id_Client, nom_client, prenom_client, siret_client, bool_entreprise,
                        nom_entreprise, num_tva_client, adresse1_client, adresse2_client, lieu_dit_client, cp_client,
                        ville_client, tel_client, comment, code_statut, code_civilite);
                System.out.println(" le selectionné modif");
                leControl.closeWindow("client_details");

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    // ---- fin des_ methodes fxml de Clients_détail -----//

    /**
     * cette méthode permet l'affichage de la liste des clients
     * 
     * @param lesClients
     */
    public void aff_V_Client_liste(LinkedHashMap<Integer, M_Clients> lesClients) {

        TableViewSelectionModel<M_Clients> tv_model = tb_clients.getSelectionModel();
        tv_model.setSelectionMode(SelectionMode.SINGLE);
        // conversion des données linkedhasmap en observableList
        les_Clients = FXCollections.observableArrayList(lesClients.values());

        try {

            tc_id_client.setCellValueFactory(new PropertyValueFactory<M_Clients, Integer>(String.valueOf("id_client")));
            tc_nom_client
                    .setCellValueFactory(new PropertyValueFactory<M_Clients, String>(String.valueOf("nom_client")));
            tc_prenom_client.setCellValueFactory(new PropertyValueFactory<M_Clients, String>("prenom_client"));

            tc_nom_entreprise.setCellValueFactory(cellData -> new ObservableValueBase<String>() {
                @Override
                public String getValue() {
                    return cellData.getValue().getNom_entreprise();
                }
            });
            tc_boolEntreprise.setCellValueFactory(cellData -> {
                M_Clients client = cellData.getValue();
                SimpleBooleanProperty booleanProp = new SimpleBooleanProperty(client.isBool_entreprise());
                return booleanProp;
            });
            tc_boolEntreprise
                    .setCellFactory(new Callback<TableColumn<M_Clients, Boolean>, TableCell<M_Clients, Boolean>>() {
                        @Override
                        public TableCell<M_Clients, Boolean> call(TableColumn<M_Clients, Boolean> param) {
                            return new CheckBoxTableCell<M_Clients, Boolean>() {
                                @Override
                                public void updateItem(Boolean item, boolean empty) {
                                    super.updateItem(item, empty);
                                    if (!isEmpty()) {
                                        updateSelected(empty);
                                    }
                                }
                            };
                        }
                    });

            tb_clients.setItems(les_Clients);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erreur");
        }

        // -----filtrer via une recherche----//

        // Création d'une FilteredList à partir de la liste des clients observables
        FilteredList<M_Clients> filteredClients = new FilteredList<>(les_Clients, p -> true);
        // le prédicat est p -> true, ce qui signifie que tous les éléments sont inclus
        // dans la liste filtrée
        // Liaison de la FilteredList à la TableView
        tb_clients.setItems(filteredClients);
        // Création d'un ChangeListener pour la valeur de recherche saisie
        ed_filtre.textProperty().addListener((observable, oldValue, newValue) -> {
            // Mise à jour du filtre
            filteredClients.setPredicate(client -> {
                // Si la valeur de recherche est vide, afficher tous les clients
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Recherche insensible à la casse du nom ou prénom
                String lowerCaseFilter = newValue.toLowerCase();
                if (client.getNom_client().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (client.getPrenom_client().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if (client.getNom_entreprise().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }else if (String.valueOf(client.isBool_entreprise()).toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

                return false;
            });
        });

    }
    // ----- fin_ affiche liste clients----//

    // ----- details clients ----//

    /**
     * méthode qui initialise les champs
     */
    private void initIHM() {
        ed_idClient.setText("");
        ed_add1Client.setText("");
        ed_add2Client.setText("");
        ed_lieuDitClient.setText("");
        ed_siretClient.setText("");
        ed_cpClient.setText("");
        ed_nomClient.setText("");
        ed_prenomClient.setText("");
        ed_telClient.setText("");
        ed_villeClient.setText("");
        ed_numTvaClient.setText("");
        ed_nomEntreprise.setText("");
        ed_dateCreate.setText("");
        ta_com.setText("");

        cb_statut.getSelectionModel().select(null);
        cb_civilite.getSelectionModel().select(null);
        ed_dateCreate.setEditable(true);
        ed_idClient.setEditable(true);
        ed_add1Client.setEditable(true);
        ed_add2Client.setEditable(true);
        ed_lieuDitClient.setEditable(true);
        ed_siretClient.setEditable(true);
        ed_cpClient.setEditable(true);
        ed_nomClient.setEditable(true);
        ed_prenomClient.setEditable(true);
        ed_telClient.setEditable(true);
        ed_villeClient.setEditable(true);
        ed_numTvaClient.setEditable(true);
        ed_nomEntreprise.setEditable(true);
        ta_com.setEditable(true);
        rb_particulier.setDisable(false);
        rb_profesionnel.setDisable(false);
        cb_statut.setEditable(false);
        cb_civilite.setEditable(false);
        bt_ajout.setVisible(true);
        bt_supp.setVisible(true);
        bt_enreg.setVisible(true);
        bt_annuler.setVisible(true);
    }

    /**
     * Cette méthode affiche les détails d'un client et l'ensemble des traitements
     * qui peuvent être
     * effectuer sur le client (modification supression ajout)
     * 
     * @param id
     * @param lesClients
     * @param lesCivilites
     * @param lesStatuts
     * @param choix
     */
    public void aff_V_Client_details(M_Clients unClient,
            LinkedHashMap<Integer, M_Clients> lesClients,
            LinkedHashMap<String, M_Civilite> lesCivilites,
            LinkedHashMap<String, M_Statut> lesStatuts, int choix) {

        // les observablelistes sont utilisée au lieu des dictionnaires car
        // l'environnement est mieux adapté dans ce cas pour et le tableau se rempli
        // avec ces données et
        // pour l'exploiter il faudrait aller dans la même lancéee
        les_Clients = FXCollections.observableArrayList(lesClients.values());
        les_statuts = FXCollections.observableArrayList(lesStatuts.values());
        les_civilites = FXCollections.observableArrayList(lesCivilites.values());

        this.choix = choix;
        int idClient = unClient.getId_client();

        cb_civilite.setItems(les_civilites);
        cb_statut.setItems(les_statuts);

        // 3. Définir le format d'affichage des données dans la ComboBox
        cb_statut.setCellFactory(new Callback<ListView<M_Statut>, ListCell<M_Statut>>() {
            @Override
            public ListCell<M_Statut> call(ListView<M_Statut> param) {
                return new ListCell<M_Statut>() {
                    @Override
                    protected void updateItem(M_Statut statut, boolean bln) {
                        super.updateItem(statut, bln);

                        if (statut != null) {
                            setText(statut.getLibelle_statut());
                        } else {
                            setText(null);
                        }
                    }

                };
            }

        });

        // 3. Définir le format d'affichage des données dans la ComboBox
        cb_civilite.setCellFactory(new Callback<ListView<M_Civilite>, ListCell<M_Civilite>>() {

            @Override
            public ListCell<M_Civilite> call(ListView<M_Civilite> param) {
                return new ListCell<M_Civilite>() {
                    @Override
                    protected void updateItem(M_Civilite civilite, boolean bln) {
                        super.updateItem(civilite, bln);

                        if (civilite != null) {
                            setText(civilite.getLibelle_civilite());
                        } else {
                            setText(null);
                        }
                    }

                };
            }

        });

        // 4. Définir le format d'affichage du choix sélectionné
        cb_statut.setConverter(new StringConverter<M_Statut>() {
            @Override
            public String toString(M_Statut statut) {
                if (statut == null) {
                    return null;
                } else {
                    return statut.getLibelle_statut();
                }
            }

            @Override
            public M_Statut fromString(String string) {
                return null;
            }

        });
        // 4. Définir le format d'affichage du choix sélectionné
        cb_civilite.setConverter(new StringConverter<M_Civilite>() {

            @Override
            public String toString(M_Civilite civilite) {
                if (civilite == null) {
                    return null;
                } else {
                    return civilite.getLibelle_civilite();
                }
            }

            @Override
            public M_Civilite fromString(String string) {
                return null;
            }

        });

        // 5. Sélectionnez une valeur par défaut
        if (les_statuts.size() > 0) {
            for (M_Statut statut : cb_statut.getItems()) {
                if (statut.getCode_statut().equals(unClient.getCode_statut())) {
                    cb_statut.getSelectionModel().select(statut);
                }
            }
        }

        if (les_civilites.size() > 0) {
            for (M_Civilite civilite : cb_civilite.getItems()) {
                if (civilite.getCode_civilite().equals(unClient.getCode_civilite())) {
                    cb_civilite.getSelectionModel().select(civilite);
                }
            }
        }

        ed_idClient.setEditable(false);

        // Selon que choix (permet d'afficher des informations dans le champs ou pas, et
        // de definir quels boutons seront visibles ou non)
        switch (choix) {
            case 0:
                // Partie détail

                // choixAff = false;
                // aff_ed_enable(choixAff);//

                System.out.println("le choix _" + choix + "_ des details du client " + unClient.getDate_create());

                ed_idClient.setText(String.valueOf(unClient.getId_client()));
                ed_nomClient.setText(unClient.getNom_client());
                ed_prenomClient.setText(unClient.getPrenom_client());
                ed_siretClient.setText(unClient.getSiret_client());
                ed_nomEntreprise.setText(unClient.getNom_entreprise());
                ed_numTvaClient.setText(String.valueOf(unClient.getNum_tva_client()));
                ed_add1Client.setText(unClient.getAdresse1_client());
                ed_add2Client.setText(unClient.getAdresse2_client());
                ed_lieuDitClient.setText(unClient.getLieu_dit_client());
                ta_com.setText(unClient.getComment());
                ed_cpClient.setText(unClient.getCp_client());
                ed_villeClient.setText(unClient.getVille_client());
                ed_telClient.setText(unClient.getTel_client());
                ed_dateCreate.setText(unClient.getDate_create());

                // cb_civilite.setDisable(true);
                // cb_statut.setDisable(true);

                // for (M_Statut statut : cb_statut.getItems()) {
                // if (statut.getCode_statut().equals(unClient.getCode_statut())) {
                // cb_statut.getSelectionModel().select(statut);
                // System.out.println(unClient.getCode_statut() + " match");
                // } else {
                // System.out.println(unClient.getCode_statut() + " don't match " +
                // statut.getCode_statut());
                // }
                // }
                // for (M_Civilite civilite : cb_civilite.getItems()) {
                // if (civilite.getCode_civilite().equals(unClient.getCode_civilite())) {
                // cb_civilite.getSelectionModel().select(civilite);
                // System.out.println(unClient.getCode_civilite() + " match");
                // } else {
                // System.out.println(unClient.getCode_civilite() + " don't match " +
                // civilite.getCode_civilite());
                // }
                // }

                rb_particulier.setDisable(true);
                rb_profesionnel.setDisable(true);
                ed_dateCreate.setEditable(false);
                ed_idClient.setEditable(false);
                ed_add1Client.setEditable(false);
                ed_add2Client.setEditable(false);
                ed_lieuDitClient.setEditable(false);
                ed_siretClient.setEditable(false);
                ed_cpClient.setEditable(false);
                ed_nomClient.setEditable(false);
                ed_prenomClient.setEditable(false);
                ed_telClient.setEditable(false);
                ed_villeClient.setEditable(false);
                ed_numTvaClient.setEditable(false);
                ed_nomEntreprise.setEditable(false);
                ta_com.setEditable(false);
                cb_statut.setDisable(false);
                cb_civilite.setEditable(false);

                bt_ajout.setVisible(true);
                bt_supp.setVisible(true);
                bt_enreg.setVisible(true);

                if (unClient.isBool_entreprise() == true) {
                    rb_profesionnel.setSelected(true);
                    rb_particulier.setSelected(false);
                } else {
                    rb_profesionnel.setSelected(false);
                    rb_particulier.setSelected(true);
                }

                // ed_idClient.setDisable(true);
                bt_annuler.setVisible(true);
                bt_ajout.setVisible(false);
                bt_enreg.setVisible(false);
                bt_supp.setVisible(true);
                break;

            case 1:
                System.out.println("le choix _" + choix + "_ des ajouts");

                // Partie Ajouter
                ed_dateCreate.setVisible(false);
                lb_dateCreate.setVisible(false);
                ed_idClient.setDisable(true);

                if (rb_profesionnel.isSelected()) {
                    rb_particulier.setSelected(false);
                    rb_profesionnel.setSelected(true);
                } else {
                    rb_particulier.setSelected(true);
                    rb_profesionnel.setSelected(false);
                }
                bt_ajout.setVisible(false);
                bt_supp.setVisible(false);
                bt_enreg.setVisible(true);
                bt_annuler.setVisible(true);
                break;

            case 2:
                System.out.println("le choix _" + choix + "_ de la modification");

                // Partie Modifier
                ed_idClient.setText(String.valueOf(unClient.getId_client()));
                ed_nomClient.setText(unClient.getNom_client());
                ed_prenomClient.setText(unClient.getPrenom_client());
                ed_siretClient.setText(unClient.getSiret_client());
                ed_nomEntreprise.setText(unClient.getNom_entreprise());
                ed_numTvaClient.setText(String.valueOf(unClient.getNum_tva_client()));
                ed_add1Client.setText(unClient.getAdresse1_client());
                ed_add2Client.setText(unClient.getAdresse2_client());
                ed_lieuDitClient.setText(unClient.getLieu_dit_client());
                ta_com.setText(unClient.getComment());
                ed_cpClient.setText(unClient.getCp_client());
                ed_villeClient.setText(unClient.getVille_client());
                ed_telClient.setText(unClient.getTel_client());

                if (unClient.isBool_entreprise() == true) {
                    rb_profesionnel.setSelected(true);
                    rb_particulier.setSelected(false);
                } else {
                    rb_profesionnel.setSelected(false);
                    rb_particulier.setSelected(true);
                }

                ed_idClient.setDisable(true);
                ed_dateCreate.setVisible(false);
                lb_dateCreate.setVisible(false);

                ed_dateCreate.setDisable(true);
                bt_ajout.setVisible(false);
                bt_supp.setVisible(false);
                bt_enreg.setVisible(true);
                bt_annuler.setVisible(true);

                break;

        }

    }

    /**
     * methode permettant de générer un pdf, de d'ajouter du contenu
     */

    public void genererAnunaireC() throws Exception {

        // Créer une LinkedHashMap<Integer, M__Clients> pour stocker les données
        LinkedHashMap<Integer, M_Clients> lesCLientsPdf = new LinkedHashMap<>();

        // Créer un document PDF
        Document document = new Document();
        try {

            // String fileName = "./doc/pdf/clients.pdf";
            String imageFile = "./doc/img/logo_sorefa.png";
            // Créer un objet Image
            Image image = Image.getInstance(imageFile);
            // Redimensionner l'image
            image.scaleAbsolute(150f, 40f);
            // Régler la position de l'image
            image.setAbsolutePosition(450f, 800f);

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("./doc/pdf/clients.pdf"));
            document.open();
            Cl_Connection.connection();
            baseSO = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);
            lesCLientsPdf = M_Clients.getRecords(baseSO);
            // Créer un tableau iText
            document.addTitle("Liste des clients");
            document.addAuthor("Sorefa");
            Paragraph preface = new Paragraph();

            Font base = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
            Paragraph tilte = new Paragraph("Annuaire des clients", base);
            tilte.setAlignment(Element.ALIGN_CENTER);
            preface.add(tilte);
            document.add(preface);
            document.add(Chunk.NEWLINE);
            PdfPTable tabl = new PdfPTable(4);
            PdfPTable table = new PdfPTable(4);
            // table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            tabl.getDefaultCell().setBorderColor(BaseColor.GRAY);
            ;
            tabl.getDefaultCell().setBackgroundColor(BaseColor.GRAY);
            tabl.setHorizontalAlignment(Element.ALIGN_CENTER);
            // tabl.getDefaultCell().setColspan(1);
            tabl.addCell("ID");
            tabl.addCell("Nom");
            tabl.addCell("Prenom");
            tabl.addCell("Entreprise / TVA");

            List<Integer> keys = new ArrayList<>(lesCLientsPdf.keySet());

            // Trier la liste de clés par ordre alphabétique
            Collections.sort(keys);

            table.getDefaultCell().setBackgroundColor(BaseColor.LIGHT_GRAY);

            // table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            table.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
            Font police = new Font(FontFamily.TIMES_ROMAN, 12);
            Font police1 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            for (Map.Entry<Integer, M_Clients> entry : lesCLientsPdf.entrySet()) {

                M_Clients unClient = entry.getValue();
                table.addCell(new Phrase(String.valueOf(entry.getKey())));
                table.addCell(new Phrase(unClient.getNom_client(),police));
                table.addCell(new Phrase(unClient.getPrenom_client()));
                table.addCell(new Phrase(String.valueOf(unClient.isBool_entreprise()),police));
                table.addCell(new Phrase("          Adresse :",police1));
                table.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.setSpacingAfter(20f);
                table.addCell(new Phrase(unClient.getNom_entreprise(),police));
                table.addCell(new Phrase(" TVA :",police1));
                table.addCell(new Phrase(String.valueOf(unClient.getNum_tva_client()),police));
                table.addCell(new Phrase("\n "));
                table.addCell(new Phrase("\n          Adresse :",police1));
                table.addCell(new Phrase((unClient.getAdresse1_client() + " _ " + unClient.getAdresse2_client() + " _ "
                        + unClient.getLieu_dit_client() + "_" +
                        unClient.getCp_client() + "_" + unClient.getVille_client()),police));
                table.addCell(new Phrase("\n"));

                table.addCell(new Phrase("\n"));
                table.addCell(new Phrase("\n"));
                table.addCell(new Phrase(unClient.getTel_client(),police));

                table.addCell(new Phrase("\n"));
                table.setHorizontalAlignment(Element.ALIGN_CENTER);
            }
            table.setWidthPercentage(100);
            tabl.setWidthPercentage(100);
            table.getDefaultCell().setBorder(0);

            // Ajouter le tableau au document PDF
            Image background = Image.getInstance("doc\\img\\logo_sorefa.png");
            float width = background.getWidth();
            float height = background.getHeight();
            // Ajouter l'image
            document.add(image);
            document.add(tabl);
            document.add(table);
            // document.add(table2);
            // document.add(table1);
            writer.getDirectContent().addImage(background, width, 0, 0, height, 0, 0);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

    // // fin ______________________________________ pdf
    // /**
    // * Methode de test de téléchargement d'un fichier pdf via une application java
    // * @param response
    // * @throws Exception
    // */
    // public void downloadPdf(HttpServletResponse response) throws Exception {
    // response.setContentType("clients/pdf");
    // response.setHeader("Content-Disposition", "attachment;
    // filename=./doc/pdf/clients.pdf");

    // try (OutputStream os = response.getOutputStream()) {
    // // générer le PDF
    // genererAnunaireC();
    // // ajouter du contenu au PDF

    // }
    // }

    // @RequestMapping(value = "/downloadPDF", method = RequestMethod.GET)
    public void downloadPDF(HttpServletRequest request, HttpServletResponse response) {
        String filePath = "./doc/pdf/clients.pdf";
        try {
            downloadPDF(request, response, filePath);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public void downloadPDF(HttpServletRequest request, HttpServletResponse response, String filePath)
            throws ServletException, IOException {

        filePath = "./doc/pdf/down.pdf";
        File file = new File(filePath);

        if (!file.exists()) {
            throw new ServletException("Le fichier demandé n'existe pas.");
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            mimeType = "application/pdf";
        }

        response.setContentType(mimeType);

        response.setHeader("Content-Disposition",
                String.format("attachment; filename=\"./doc/pdf/down.pdf\"", file.getName()));

        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        OutputStream outputStream = response.getOutputStream();

        byte[] buffer = new byte[4096];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outputStream.close();
    }

}
