package fr.sorefa.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import fr.sorefa.App;
import fr.sorefa.model.M_Composer;
import fr.sorefa.model.M_Produits;
import fr.sorefa.model.M_Taux_tva;
import fr.sorefa.model.M_Unite;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class C_Produits {
    // liste
    @FXML
    private RadioButton rb_prod;

    @FXML
    private ToggleGroup rbg_prod;

    @FXML
    private RadioButton rb_prodComp;

    @FXML
    private RadioButton rb_proBase;

    @FXML
    private TableView<M_Produits> tb_produits;

    @FXML
    private TableColumn<M_Produits, Integer> tc_id_produit;

    @FXML
    private TableColumn<M_Produits, String> tc_libelle_produit;

    @FXML
    private TableColumn<M_Produits, String> tc_commentaire;

    @FXML
    private TableColumn<M_Produits, Float> tc_prix_achat;

    @FXML
    private TableColumn<M_Produits, Float> tc_prix_unitaire;

    @FXML
    private TableView<M_Produits> tb_produits1;

    @FXML
    private TableColumn<M_Produits, Integer> tc_id_produit1;

    @FXML
    private TableColumn<M_Produits, String> tc_libelle_produit1;

    @FXML
    private TableColumn<M_Produits, String> tc_commentaire1;

    @FXML
    private TableColumn<M_Produits, Float> tc_prix_achat1;

    @FXML
    private TableColumn<M_Produits, Float> tc_prix_unitaire1;
    @FXML
    private Button bt_details;

    @FXML
    private Button bt_fermer;

    @FXML
    private Button bt_modif;

    @FXML
    private Button bt_ajout;

    // details

    @FXML
    private TextField ed_libelle_produit;

    @FXML
    private Label lb_libelle_produit;

    @FXML
    private Label lb_com_produit;

    @FXML
    private TextField ed_prix_achat;

    @FXML
    private Label lb_prix_achat;

    @FXML
    private TextField ed_formuleCalc;

    @FXML
    private Label lb_formuleCalc;

    @FXML
    private TextArea ta_com_produit;

    @FXML
    private TextArea ta_com;

    @FXML
    private Label lb_com;

    @FXML
    private TextField ed_prix_prod;

    @FXML
    private Label lb_prix_prod;

    @FXML
    private TextField ed_condition;

    @FXML
    private Label lb_condition;

    @FXML
    private Label lb_comCalcul;

    @FXML
    private TextArea ta_comCalcul;

    @FXML
    private Button bt_calculer;

    @FXML
    private TextField ed_prix_unitHT;

    @FXML
    private Label lb_prix_unitHT;

    @FXML
    private Label lb_unite;
    @FXML
    private Label lb_tva;

    @FXML
    private ComboBox<M_Taux_tva> cb_tva;
    @FXML
    private ComboBox<M_Unite> cb_unite;
    @FXML
    private Button bt_retour_mix;

    // compos
    @FXML
    private Button bt_down;
    @FXML
    private Button bt_up;

    @FXML
    private Label lb_isMix;
    @FXML
    private GridPane gp_compos;
    @FXML
    private Button bt_addRow;

    @FXML
    private Button bt_edit;

    @FXML
    private Button bt_detail;

    @FXML
    private Button bt_removeRow;

    @FXML
    private TableView<M_Produits> tb_compos;

    @FXML
    private TableColumn<M_Produits, String> tc_libelle_compos;

    // @FXML
    // private TableColumn<M_Composer, Integer> //tc_ordre_compos;

    @FXML
    private TableColumn<M_Produits, String> tc_com;
    @FXML
    private TableColumn<M_Produits, Integer> tc_id_compos;
    @FXML
    private Pane pn_compos;
    @FXML
    private Button bt_avancer;
    @FXML
    private Button bt_reculer;
    @FXML
    private Button bt_enreg_compos;

    @FXML
    private Button bt_fermerCompos;

    @FXML
    private Button bt_personnaliser;
    @FXML
    private Button bt_ajoutCompos;

    @FXML
    private Button bt_personaAnnuler;

    @FXML
    private Button bt_personnaVal;
    @FXML
    private Label lb_ordre;

    @FXML
    private Label lb_qte;
    @FXML
    private TextField ed_ordre;

    @FXML
    private TextField ed_qte;

    @FXML
    private Label lb_idProd;

    @FXML
    private Label lb_idProduit;

    @FXML
    private Button bt_enreg;

    private App leControl;

    /**
     * Cette méthode permet de définir l'instance de la classe "App"
     * à utiliser comme contrôleur dans l'objet courant.
     * Elle prend en paramètre une instance de la classe "App" et
     * définit la variable "leControl" de l'objet courant avec cette instance.
     * 
     * @param leControlleur
     */
    public void setApp(App leControlleur) {
        leControl = leControlleur;
    }

    private M_Produits unProduit;
    private String typeProduit = "tous";
    private TableViewSelectionModel<M_Produits> tv_model;
    private int iProduitSelected;
    private ObservableList<M_Produits> les_produits;
    private ObservableList<M_Taux_tva> les_tvas;
    private ObservableList<M_Unite> les_unite;
    private ObservableList<M_Composer> les_compos;
    private ObservableList<M_Produits> obProduitsFiltres;
    private boolean is_mix;

    @FXML
    void avancerOnClick(ActionEvent event) {
            // M_Composer enregistrementSelectionne = table.getSelectionModel().getSelectedItem();
            // if (enregistrementSelectionne == null) {
            //     return;
            // }
        
            // int index = les_composants.indexOf(enregistrementSelectionne);
            // if (index == 0) {
            //     // L'enregistrement est déjà en première position, rien à faire
            //     return;
            // }
        
            // // Déplacer l'enregistrement vers l'avant
            // M_Composer enregistrementPrecedent = les_composants.get(index - 1);
            // int ordrePrecedent = enregistrementPrecedent.getOrdre_mix();
            // int nouvelOrdre = enregistrementSelectionne.getOrdre_mix();
        
            // if (ordrePrecedent == nouvelOrdre) {
            //     // Gérer les cas où deux enregistrements ont le même ordre
            //     enregistrementSelectionne.setOrdre_mix(nouvelOrdre + 1);
            //     nouvelOrdre = nouvelOrdre + 1;
            // }
        
            // enregistrementPrecedent.setOrdre_mix(nouvelOrdre);
            // enregistrementSelectionne.setOrdre_mix(ordrePrecedent);
        
            // // Mettre à jour l'affichage du tableau
            // tb_compos.getItems().setAll(les_composants);
        
        /*
        M_Produits produitSelectionne = tb_compos.getSelectionModel().getSelectedItem();
        M_Composer unComposer=null ;
         if (produitSelectionne != null) {
            if (obProduitsFiltres == null) {
                obProduitsFiltres = FXCollections.observableArrayList();
            }
            // recuperer les composants :
            int id_composant = produitSelectionne.getId_produit();
            for(M_Composer cp : les_compos){
if(cp.getId_produit_composant() == id_composant){
unComposer =cp;

            
// unComposer    = les_compos.get(id_composant);

            int index = les_compos.indexOf(unComposer);
            if (index < 0) {
                // l'enregistrement n'existe pas dans les données
            }
            int ordre = unComposer.getOrdre_mix();
           
                if (index == les_compos.size() - 1) {
                    // l'unComposer est déjà en dernière position
               
                M_Composer enregistrementSuivant = les_compos.get(index + 1);
                int nouvelOrdre = enregistrementSuivant.getOrdre_mix();
                enregistrementSuivant.setOrdre_mix(ordre);
                unComposer.setOrdre_mix(nouvelOrdre);
            } else   if (index == 0) {
                    // l'unComposer est déjà en première position
                }
                M_Composer enregistrementPrecedent = les_compos.get(index - 1);
                int nouvelOrdre = enregistrementPrecedent.getOrdre_mix();
                enregistrementPrecedent.setOrdre_mix(ordre);
                unComposer.setOrdre_mix(nouvelOrdre);
            }
        }}
     * 
     */
    
    }
    

    @FXML
    void reculerOnClick(ActionEvent event) {
        // pour le bouton plus
        // leControl.afficherProduit_mixes(unProduit, typeProduit, is_mix); TODO
        // obtenir l'élément sélectionné dans le tableau
        M_Produits produitSelectionne = tb_compos.getSelectionModel().getSelectedItem();
        List<M_Composer> les_composants = new ArrayList<>();

        int idMix = Integer.valueOf(lb_idProd.getText());
        M_Composer unComposant = null;
        if (produitSelectionne != null) {

            for (M_Composer unCompos : les_compos) {
                int composant = Integer.valueOf(ed_ordre.getText());
                if (unCompos.getOrdre_mix() == composant) {
                    unComposant = les_compos.get(composant);
                }
                unCompos.setId_produit_mix(idMix);
                unCompos.setId_produit_composant(produitSelectionne.getId_produit());
                unCompos.setQte_mix(0);
                unCompos.setOrdre_mix(0);
                // les_composants.add(unCompos);

                deplacerEnregistrement(les_composants, unComposant, "moins");
            }
        }
    }

    @FXML
    void anulerPpersonnaliser(ActionEvent event) {
        // tb_produits1.setVisible(true);
        tb_compos.getSelectionModel().clearSelection();
        tb_compos.refresh();
        bt_enreg_compos.setVisible(true);
        bt_fermerCompos.setVisible(true);
        gp_compos.setVisible(false);
    }

    @FXML
    void validerPersonnaliser(ActionEvent event) throws Exception {
        // tb_produits1.setVisible(true);
        bt_enreg_compos.setVisible(true);
        bt_fermerCompos.setVisible(true);

        int id_produit_mix, id_produit_composant, ordre_mix;
        float qte_mix;
        String comment;
        tv_model = tb_compos.getSelectionModel();
        M_Produits itemComposer = tv_model.getSelectedItem();
        int icompoSelected;
        if (itemComposer != null) {
            icompoSelected = les_produits.indexOf(itemComposer);
            unProduit = les_produits.get(icompoSelected);

            id_produit_mix = Integer.valueOf(lb_idProd.getText());
            id_produit_composant = unProduit.getId_produit();
            ordre_mix = Integer.valueOf(ed_ordre.getText());
            qte_mix = Float.valueOf(ed_qte.getText());
            comment = ta_com.getText();
            System.out.println(" le selectionné " + unProduit.getId_produit() + "\tidProduit_mix " + id_produit_mix
                    + "\t id_produit_composant " + id_produit_composant
                    + "\t ordre_mix " + ordre_mix + "\t qte_mix " + qte_mix + "\t comment " + comment);

            leControl.modifier_Composant(id_produit_mix, id_produit_composant, ordre_mix, qte_mix, comment);
        }
    }

    @FXML
    void personnaliser(ActionEvent event) {
        // tb_produits1.setVisible(false);

        tv_model = tb_compos.getSelectionModel();
        M_Produits itemComposer = tv_model.getSelectedItem();
        int icompoSelected;
        if (itemComposer != null) {
            icompoSelected = les_produits.indexOf(itemComposer);
            unProduit = les_produits.get(icompoSelected);

            seplacer();
        }
    }

    /**
     * Cette méthode permet de recupérer les informations concernant le produit
     * selectionné
     * dans le tableau des produit composé d'un produit mixe donné, et permet
     * également
     * de recupérer les informations des produits selectioné depuis la table qui les
     * associe
     * aux mixes.
     */
    public void seplacer() { // TODO
        tv_model = tb_compos.getSelectionModel();
        M_Produits produitSelectionne = tv_model.getSelectedItem();
        int idPos =tv_model.getSelectedIndex();
        if (produitSelectionne != null) {
            iProduitSelected = les_produits.indexOf(produitSelectionne);
            if (iProduitSelected >= 0) {
                unProduit = les_produits.get(iProduitSelected);
                // System.out.println("le composant " + unProduit.getId_produit());
            }
        }
        M_Composer unCompos = null; // Initialiser l'objet unCompos à null
        int id = Integer.valueOf(lb_idProd.getText());
        for (M_Composer c : les_compos) {
            if (c.getId_produit_mix() == id && c.getId_produit_composant() == unProduit.getId_produit()) {
                unCompos = c;
                break;
            }
        }
        // Initialiser l'ordre précédent à 0 TODO
        int ordrePrecedent = 0;

        // // Boucler sur les composants et trier par ordre
        // for (M_Composer unComposant : les_compos) {
        //     // Vérifier si l'ordre actuel est égal à l'ordre précédent
        //     if (unComposant.getOrdre_mix() == ordrePrecedent) {
        //         // Décaler l'ordre actuel d'un rang
        //         unComposant.setOrdre_mix(unComposant.getOrdre_mix() + 1);
        //     }
        //     // Afficher et affecter l'ordre actuel au composant
        //     TextField ordre = new TextField(Integer.toString(unComposant.getOrdre_mix()));
        //     ordre.textProperty().addListener((observable, oldValue, newValue) -> {
        //         if (!newValue.matches("\\d*")) {
        //             ordre.setText(newValue.replaceAll("[^\\d]", ""));
        //         }
        //         unComposant.setOrdre_mix(Integer.parseInt(newValue));
        //     });

        //     // Mettre à jour l'ordre précédent avec l'ordre actuel
        //     ordrePrecedent = unComposant.getOrdre_mix();
        // }

        if (unCompos != null) {
            ed_ordre.setText(String.valueOf(unCompos.getOrdre_mix()));
            ed_qte.setText(String.valueOf(unCompos.getQte_mix()));
            ta_com.setText(unCompos.getComment());
        }
        // System.out.println("\nla place :"+idPos);

    }

    /**
     * Cette méthode permet de conserver une copie de la liste des composants avant
     * la modification
     * et la comparer à la liste après la modification. En comparant les deux
     * listes, on pouras facilement déterminer les ajouts et les suppressions.
     * OU BIEN
     * Récupérez la liste actuelle des composants dans la base de données.
     * Parcourez la liste des composants filtrés dans votre application.
     * Pour chaque composant filtré, vérifiez s'il existe déjà dans la liste des
     * composants de la base de données. Si non, ajoutez-le à la base de données. Si
     * oui, ignorez-le.
     * Pour chaque composant de la liste de la base de données, vérifiez s'il existe
     * dans la liste des composants filtrés. Si non, supprimez-le de la base de
     * données.
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void enregComposition(ActionEvent event) throws Exception {
        try {
            int id = Integer.valueOf(lb_idProd.getText());
            leControl.ajout_retrait_composants(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Cette méthode permet de fermer la fenetre d'affichage des produits mixes et
     * réactualise
     * les détails du produit mixe en appelant la méthode refreshModif(id, choix)
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void fermerCompositon(ActionEvent event) throws Exception {
        int id = Integer.valueOf(lb_idProd.getText());
        int choix = 2;
        System.out.println("retour id : " + id);
        leControl.closeWindow("produit_mixes");

        leControl.refreshModif(id, choix);
        tb_produits1.setVisible(true);
    }

    /**
     * Cette méthode permet le retrait d'un composant en tant que ligne dans le
     * produit mixe
     * 
     * @param event
     */
    @FXML
    void remove(ActionEvent event) {
        // obtenir l'élément sélectionné dans le tableau
        M_Produits produitSelectionne = tb_compos.getSelectionModel().getSelectedItem();
        if (produitSelectionne != null) {
            // supprimer l'élément sélectionné de la liste des produits filtrés
            obProduitsFiltres.remove(produitSelectionne);
        }
        tb_compos.getSelectionModel().clearSelection();
        tb_compos.refresh();
        gp_compos.setVisible(false);
        bt_enreg_compos.setVisible(true);
        bt_fermerCompos.setVisible(true);
    }

    /**
     * le premier consiste à afficher tous les produits même des produits mix et le
     * second consiste à
     * afficher les composants d'un produit mix donné. Mais j'aimerai permettre par
     * une méthode d'ajouter
     * des produits dans le tableau des produits composant concernant un produit
     * mix. mais aussi d'en retrancher .
     * pour cela j'ai creer deux bouton d'ajout et de retranchement
     * 
     * @param event
     */
    /**
     * Cette méthode permet l'ajout d'un composant en tant que ligne dans le produit
     * mixe
     * 
     * @param event
     */
    @FXML
    void add(ActionEvent event) {

        // obtenir l'élément sélectionné dans le tableau
        M_Produits produitSelectionne = tb_produits1.getSelectionModel().getSelectedItem();
        if (produitSelectionne != null) {
            if (obProduitsFiltres == null) {
                obProduitsFiltres = FXCollections.observableArrayList();
            }
            obProduitsFiltres.add(produitSelectionne);
        }
        tb_produits1.getSelectionModel().clearSelection();
        tb_produits1.refresh();
    }

    /**
     * Cette méthode affiche les détails d'un produit mixe
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void aff_details_mix(ActionEvent event) throws Exception {
        int idP = Integer.valueOf(lb_idProd.getText());
        sePlacerDetails(idP);
    }

    void sePlacerDetails(int idp) {
        int id = Integer.valueOf(lb_idProd.getText());
        if (idp == id) {

            for (M_Produits compMix : les_produits) {
                if (compMix.getId_produit() == idp) {

                    unProduit = compMix;
                    System.out.println(unProduit.getId_produit() + " : " + compMix.getId_produit());
                }
            }
        } else {
            tv_model = tb_compos.getSelectionModel();
            M_Produits composantSelected = tv_model.getSelectedItem();
            // int choix = 0;
            if (composantSelected != null) {
                iProduitSelected = les_produits.indexOf(composantSelected);
                unProduit = les_produits.get(iProduitSelected);
            }
        }

        // lb_idProd.setText(String.valueOf(unProduit.getId_produit()));
        ed_libelle_produit.setText(unProduit.getLibelle_produit());
        ta_com_produit.setText(unProduit.getCommentaire_produit());
        ed_prix_achat.setText(String.valueOf(unProduit.getPrix_achat()));
        ed_formuleCalc.setText(unProduit.getFormule_calcul());
        ed_prix_prod.setText(String.valueOf(unProduit.getPrix_produit()));
        ta_comCalcul.setText(unProduit.getCommentaire_calcul());
        ta_com.setText(unProduit.getComment());
    }

    /**
     * Cette méthode permet l'édition ou la modification des composants
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void editer(ActionEvent event) throws Exception {

        String id = lb_idProd.getText();
        tv_model = tb_compos.getSelectionModel();

        M_Produits composantSelected = tv_model.getSelectedItem();
        // if (composantSelected != null) {
        iProduitSelected = les_produits.indexOf(composantSelected);

        unProduit = les_produits.get(iProduitSelected);
        leControl.afficherProduit_mixes(unProduit, id, true);

        // }
    }

    @FXML
    void ajout_composants(ActionEvent event) throws Exception {

        String id = lb_idProd.getText();
        leControl.afficherProduit_mixes(unProduit, id, false);

    }

    /**
     * Cette méthode est une action qui est déclanchée lorsque une ligne du tableau
     * des composition est sélectionnée
     * 
     * @param event
     */
    @FXML
    void edition(MouseEvent event) {
        if (bt_supp != null || bt_enreg != null) {

            if (bt_supp.isVisible()) {
                bt_edit.setVisible(false);
                bt_detail.setVisible(true);
                sePlacerDetails(iProduitSelected);
            } else {
                bt_detail.setVisible(false);
                bt_edit.setVisible(true);
            }
        }

    }

    @FXML
    void editionCompo(KeyEvent event) {
        tv_model = tb_compos.getSelectionModel();
        int idPos =tv_model.getSelectedIndex()+1;

        M_Produits produitSelectionne = tv_model.getSelectedItem();
        if (produitSelectionne != null) {
            iProduitSelected = les_produits.indexOf(produitSelectionne);
            if (iProduitSelected >= 0) {
                unProduit = les_produits.get(iProduitSelected);
                // System.out.println("le composant " + unProduit.getId_produit());
            }
        }
        M_Composer unCompos = null; // Initialiser l'objet unCompos à null
        int id = Integer.valueOf(lb_idProd.getText());
        for (M_Composer c : les_compos) {
            if (c.getId_produit_mix() == id && c.getId_produit_composant() == unProduit.getId_produit()) {
                unCompos = c;
                break;
            }
        }
        if (unCompos != null) {
            ed_ordre.setText(String.valueOf(unCompos.getOrdre_mix()));
            ed_qte.setText(String.valueOf(unCompos.getQte_mix()));
            ta_com.setText(unCompos.getComment());
        }
        // seplacer();
        
    }

    @FXML
    void editionCompos(MouseEvent event) {
        // bt_personnaliser.setVisible(true);

        if (tb_produits1 != null) {
            tb_produits1.getSelectionModel().clearSelection();
            tb_produits1.refresh();
        }
        if (lb_isMix.getText().equals("true")) {
            is_mix = true;
        } else {
            is_mix = false;
        }
        if (is_mix) {

            bt_fermerCompos.setVisible(false);
            bt_enreg_compos.setVisible(false);
            gp_compos.setVisible(true);

            seplacer();
        }
    }

    /**
     * Cette méthode permet d'afficher les détails concernants les produits
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void details_produit(ActionEvent event) throws Exception {

        int choix = 0;
        tv_model = tb_produits.getSelectionModel();

        M_Produits produitSelectionne = tv_model.getSelectedItem();
        if (produitSelectionne != null) {
            iProduitSelected = les_produits.indexOf(produitSelectionne);
            if (iProduitSelected >= 0) {
                unProduit = les_produits.get(iProduitSelected);
                leControl.afficherProduits_details(unProduit, choix);

            }
        }
    }

    /**
     * Cette methode permet de fermer la fenêtre chargée d'afficher la liste des
     * produits
     * 
     * @param event
     */
    @FXML
    void fermer(ActionEvent event) {
        rb_proBase.setSelected(false);
        rb_prod.setSelected(false);
        rb_prodComp.setSelected(false);
        leControl.closeWindow("produit_liste");
    }

    /**
     * Cette méthode permet d'afficher la fenêtre de modification des produits
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void modifier_produit(ActionEvent event) throws Exception {
        int choix = 2;
        tv_model = tb_produits.getSelectionModel();
        M_Produits produitSelectionne = tv_model.getSelectedItem();

        if (produitSelectionne != null) {
            iProduitSelected = les_produits.indexOf(produitSelectionne);
            if (iProduitSelected >= 0) {
                unProduit = les_produits.get(iProduitSelected);
                leControl.afficherProduit_modif(unProduit, choix);
            }
        }
    }

    /**
     * Cette méthode permet l'affichage de la fenêtre d'ajout
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void ajout_produit(ActionEvent event) throws Exception {
        int choix = 1;
        iProduitSelected = 0;
        unProduit = les_produits.get(iProduitSelected);
        tv_model = tb_produits.getSelectionModel();
        iProduitSelected = tv_model.getSelectedIndex();
        leControl.afficherProduit_ajout(unProduit, choix);
    }

    // details
    @FXML
    private Button bt_supp;

    @FXML
    private Button bt_fermer_details;

    /**
     * Cette méthode fxml permet d'afficher le produit selectionner dans le tableau.
     * Elle n'est pas utile pour le projet, mais sert à gèrer l'événement MouseEvent
     * qui se produit lorsque l'on clique sur un composant TableView tb_produit.
     * Elle permet de faire des tests afin d'obtenir les informations sur le produit
     * selectionné dans le tableau
     * 
     * @param event
     */
    @FXML
    void tb_prodb_clicked(MouseEvent event) {
        // sePlacer();
        if (tb_compos != null) {

            tb_compos.getSelectionModel().clearSelection();
            tb_compos.refresh();
            gp_compos.setVisible(false);
            bt_enreg_compos.setVisible(true);
            bt_fermerCompos.setVisible(true);
        }
    }

    /**
     * Cette méthode fxml permet d'afficher le produit selectionné dans le tableau.
     * Elle n'est pas utile pour le projet, mais sert de test en gèrant l'événement
     * KeyEvent
     * qui se produit lorsqu'une touche est relâchée sur le composant TableView
     * tb_produit.
     * 
     * @param event
     */
    @FXML
    void tb_prodb_released(KeyEvent event) {
        sePlacer();
    }

    /**
     * Cette méthode permet de faire des tests sur l'emplacement du client
     * selectionné
     */
    private void sePlacer() {
        tv_model = tb_produits.getSelectionModel();
        iProduitSelected = tv_model.getSelectedIndex();
        unProduit = les_produits.get(iProduitSelected);
        int id_produit = unProduit.getId_produit();
        System.out.println(id_produit);
    }

    /**
     * Cette méthode permet de fermer la fenêtre d'affichage des détails d'un
     * produit
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    void fermer_details(ActionEvent event) throws Exception {

        leControl.closeWindow("produit_details");

    }

    @FXML
    void retour_mix(ActionEvent event) throws Exception {

        // sePlacerDetails(idP);
    } // TODO

    /**
     * Méthode chargée de la suppression d'un produit.
     * Elle parcours la collection à la recherche du produit correspondant
     * à l'id selectionné et lorsqu'il est trouvé, il est affecté de la valeur
     * corespondante à l'id selectionné et est envoyé à la méthode
     * supp_produit(M_Produit unProduit) chargé de la suppression
     * 
     * @param event
     * @throws Exception
     */
    @FXML
    // version alert
    void supp_produit(ActionEvent event) throws Exception {
        if (lb_idProd != null) {
            for (M_Produits prod : les_produits) {
                if (prod.getId_produit() == Integer.valueOf(lb_idProd.getText())) {
                    unProduit = prod;
                    // System.out.println(unProduit + "client correspondant id est : " +
                    // unProduit.getId_produit());
                } else {
                    // //System.out.println(unProduit + "client ne correspondant pas : " +
                    // prod.getId_produit());
                }
            }
        } else {
            // System.out.println("supp tableau");
            tv_model = tb_produits.getSelectionModel();

            M_Produits produitSelectionne = tv_model.getSelectedItem();
            if (produitSelectionne != null) {
                iProduitSelected = les_produits.indexOf(produitSelectionne);
                if (iProduitSelected >= 0) {
                    unProduit = les_produits.get(iProduitSelected);
                }
            }
        }

        // Création de la boîte de dialogue de confirmation
        Alert confirmation = new Alert(AlertType.CONFIRMATION);
        confirmation.setTitle("Confirmation de supression");
        confirmation.setHeaderText("Êtes-vous sûr de vouloir supprimer ce produit ?");
        confirmation.setContentText("Cette action est irréversible.");

        // Affichage de la boîte de dialogue et traitement de la réponse
        Optional<ButtonType> result = confirmation.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Action à effectuer si l'utilisateur choisit "OK"
            // System.out.println("supprimé");
            leControl.supprimerProduit(unProduit);

        } else {
            // System.out.println("supression annulé");
        }
        leControl.closeWindow("produit_details");
    }
    /*
     * version dialog:
     * void supp_produit(ActionEvent event) throws Exception {
     * if (lb_idProd != null) {
     * for (M_Produits prod : les_produits) {
     * if (prod.getId_produit() == Integer.valueOf(lb_idProd.getText())) {
     * unProduit = prod;
     * System.out.println(unProduit + "client  correspondant  id est : " +
     * unProduit.getId_produit());
     * } else {
     * // System.out.println(unProduit + "client ne correspondant pas : " +
     * prod.getId_produit());
     * }
     * }
     * } else {
     * System.out.println("supp tableau");
     * tv_model = tb_produits.getSelectionModel();
     * 
     * M_Produits produitSelectionne = tv_model.getSelectedItem();
     * if (produitSelectionne != null) {
     * iProduitSelected = les_produits.indexOf(produitSelectionne);
     * if (iProduitSelected >= 0) {
     * unProduit = les_produits.get(iProduitSelected);
     * }
     * }
     * }
     * 
     * // Création de la boîte de dialogue de confirmation
     * Dialog<ButtonType> confirmation = new Dialog<>();
     * confirmation.setTitle("Confirmation");
     * confirmation.setHeaderText("Êtes-vous sûr de vouloir supprimer ce produit ?"
     * );
     * confirmation.setContentText("Cette action est irréversible.");
     * 
     * // Ajout des boutons "OK" et "Annuler"
     * ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
     * ButtonType cancelButton = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
     * confirmation.getDialogPane().getButtonTypes().addAll(okButton, cancelButton);
     * 
     * // Affichage de la boîte de dialogue et traitement de la réponse
     * Optional<ButtonType> result = confirmation.showAndWait();
     * if (result.isPresent() && result.get() == okButton) {
     * // Action à effectuer si l'utilisateur choisit "OK"
     * leControl.supprimerProduit(unProduit);
     * leControl.closeWindow("produit_details");
     * } else {
     * // Action à effectuer si l'utilisateur choisit "Annuler"
     * // Par exemple : ne rien faire, ouvrir une autre boîte de dialogue, etc.
     * }
     * }
     * 
     */

    /**
     * Cette méthode est chargée de l'enregistrement d'un produit suite à un ajout
     * ou à une
     * modification.
     * L'ajout est distinguée de la modification par la condition si le produit
     * existe déjà (enregistrement de modification) ou non (ajout)
     * 
     * @param event
     */
    @FXML
    void enreg_produit(ActionEvent event) {
        try {
            // int index;
            int id_produit, id_tva;
            Float prix_achat, prix_produit;
            String libelle_produit, commentaire_produit, formule_calcul, commentaire_calcul,
                    comment, code_unite;

            libelle_produit = ed_libelle_produit.getText();
            commentaire_calcul = ta_comCalcul.getText();
            comment = ta_com.getText();
            commentaire_produit = ta_com_produit.getText();
            formule_calcul = ed_formuleCalc.getText();
            prix_achat = Float.valueOf(ed_prix_achat.getText());
            prix_produit = Float.valueOf(ed_prix_prod.getText());

            M_Taux_tva selectedM_Taux_tva = cb_tva.getValue();
            M_Unite selectedUnite = cb_unite.getValue();
            code_unite = selectedUnite.getCode_unite();
            id_tva = selectedM_Taux_tva.getid_tva();
            if (lb_idProd.getText() == "") {
                // System.out.println("produit peut etre ajouter avec un nouvel id : ");

                leControl.ajouter_Produit(libelle_produit, commentaire_produit, prix_achat, formule_calcul,
                        prix_produit, commentaire_calcul, comment, id_tva, code_unite);
                leControl.closeWindow("produit_details");

            } else {
                id_produit = Integer.valueOf(lb_idProd.getText());

                leControl.modifier_Produit(id_produit, libelle_produit, commentaire_produit, prix_achat,
                        formule_calcul, prix_produit, commentaire_calcul, comment, id_tva, code_unite);
                ;
                // System.out.println(" le selectionné modif");
                leControl.closeWindow("produit_details");

            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /**
     * eval() de la classe ScriptEngine de Java pour évaluer dynamiquement la
     * formule de calcul:
     * Dans ce code, nous utilisons ScriptEngineManager pour obtenir une instance de
     * ScriptEngine
     * qui permet d'évaluer des expressions mathématiques. Nous passons ensuite les
     * variables prix_achat,
     * formule et tva à la méthode eval() de ScriptEngine, qui retourne un objet
     * Object. Nous le convertissons
     * en chaîne de caractères et le convertissons ensuite en un nombre à virgule
     * flottante à l'aide de la méthode
     * parseFloat() de la classe Float. Le résultat est ensuite utilisé pour mettre
     * à jour le champ ed_prix_prod
     * 
     * @param event
     */
    @FXML
    void calculer(ActionEvent event) { // TODO
        M_Taux_tva selectedM_Taux_tva = cb_tva.getValue();
        // M_Unite selectedUnite = cb_unite.getValue();
        float prix_achat = Float.parseFloat(ed_prix_achat.getText());
        float prix_produit = 0;
        prix_produit = Float.parseFloat(ed_prix_prod.getText());
        // String unite = selectedUnite.getLibelle_unite();
        float tva = selectedM_Taux_tva.getTaux_tva();
        String formule = ed_formuleCalc.getText();
        float resultat = 0;

        if (formule.equals("+")) {
            resultat = prix_achat + tva / 100;
        } else if (formule.equals("-")) {
            resultat = prix_achat - tva / 100;
        } else if (formule.equals("*")) {
            resultat = prix_achat * tva / 100;
        } else if (formule.equals("/")) {
            resultat = prix_achat / tva / 100;
        }
        prix_produit = prix_achat + resultat;
        ed_prix_prod.setText(String.valueOf(prix_produit));

    }

    /**
     * Cette méthode permet de mettre à jour la vue de la liste des produits avec ou
     * sans filtrage
     */
    private void updateTable() {
        // Créez une liste filtrée pour les produits en fonction du type de produit
        // sélectionné
        FilteredList<M_Produits> filteredList = les_produits.filtered(p -> {
            switch (typeProduit) {
                case "base":
                    return p.getNb_produit() == 0; // Filtre les produits avec un ID de 1 (produits de base)
                case "compos":
                    return p.getNb_produit() >= 2; // Filtre les produits avec un ID de 2 (produits composés)
                default:
                    return true; // Affiche tous les produits par défaut
            }
        });
        tb_produits.setItems(filteredList);
    }

    /**
     * Méthode de filtrage des produits de base
     * 
     * @param event
     */
    @FXML
    void aff_base(ActionEvent event) {
        typeProduit = "base";
        updateTable();
    }

    /**
     * Méthode de filtrage des produits composés
     * 
     * @param event
     */
    @FXML
    void aff_compos(ActionEvent event) {
        typeProduit = "compos";
        updateTable();
    }

    /**
     * Methode de filtrage par défaut (tous afficher)
     * 
     * @param event
     */
    @FXML
    void aff_prod(ActionEvent event) {
        typeProduit = "tous";
        updateTable();

    }

    /**
     * cette méthode permet l'affichage de la liste des produits
     * 
     * @param lesProduits
     * @throws Exception
     */
    public void aff_V_Produit_liste(LinkedHashMap<Integer, M_Produits> lesProduits) throws Exception {
        les_produits = FXCollections.observableArrayList(lesProduits.values());

        try {
            tc_id_produit
                    .setCellValueFactory(new PropertyValueFactory<M_Produits, Integer>(String.valueOf("id_produit")));
            tc_libelle_produit.setCellValueFactory(
                    new PropertyValueFactory<M_Produits, String>(String.valueOf("libelle_produit")));
            tc_commentaire.setCellValueFactory(new PropertyValueFactory<M_Produits, String>(String.valueOf("comment")));
            tc_prix_achat.setCellValueFactory(new PropertyValueFactory<M_Produits, Float>("prix_achat"));
            tc_prix_unitaire.setCellValueFactory(new PropertyValueFactory<M_Produits, Float>("prix_produit"));

            tb_produits.setItems(les_produits);
            // Mettre à jour le tableau avec tous les produits par défaut
            updateTable();

        } catch (Exception e) {
            e.printStackTrace();
            // System.out.println("erreur");
        }
    }

    /**
     * Cette méthode affiche les détails d'un produit et l'ensemble des tritements
     * qui peuvent être effectuer sur le produit (modification supression ajout)
     * 
     * @param unProduit
     * @param lesProduits
     * @param lesTvas
     * @param lesUnites
     * @param choix
     * @throws Exception
     */
    public void aff_V_Produits_details(M_Produits unProduit,
            LinkedHashMap<Integer, M_Produits> lesProduits,
            LinkedHashMap<Integer, M_Taux_tva> lesTvas,
            LinkedHashMap<String, M_Unite> lesUnites,
            LinkedHashMap<Integer, M_Composer> lesCompos, int choix) throws Exception {

        les_produits = FXCollections.observableArrayList(lesProduits.values());
        les_tvas = FXCollections.observableArrayList(lesTvas.values());
        les_unite = FXCollections.observableArrayList(lesUnites.values());
        // les_compos = FXCollections.observableArrayList(lesCompos.values());

        // 1. valoriser la combobox
        cb_unite.setItems(les_unite);
        cb_tva.setItems(les_tvas);
        // 2. Définir le format d'affichage des données dans la ComboBox
        cb_unite.setCellFactory(new Callback<ListView<M_Unite>, ListCell<M_Unite>>() {
            @Override
            public ListCell<M_Unite> call(ListView<M_Unite> param) {
                return new ListCell<M_Unite>() {
                    @Override
                    protected void updateItem(M_Unite unite, boolean bln) {
                        super.updateItem(unite, bln);

                        if (unite != null) {
                            setText(unite.getCode_unite() + " : \t" + unite.getLibelle_unite());
                        } else {
                            setText(null);
                        }
                    }

                };
            }
        });
        cb_tva.setCellFactory(new Callback<ListView<M_Taux_tva>, ListCell<M_Taux_tva>>() {
            @Override
            public ListCell<M_Taux_tva> call(ListView<M_Taux_tva> param) {
                return new ListCell<M_Taux_tva>() {
                    @Override
                    protected void updateItem(M_Taux_tva tva, boolean bln) {
                        super.updateItem(tva, bln);

                        if (tva != null) {
                            setText(tva.getid_tva() + " : \t" + tva.getTaux_tva() + "%");
                        } else {
                            setText(null);
                        }
                    }

                };
            }
        });
        // 3. Définir le format d'affichage du choix sélectionné
        cb_unite.setConverter(new StringConverter<M_Unite>() {
            @Override
            public String toString(M_Unite unite) {
                if (unite == null) {
                    return null;
                } else {
                    return unite.getCode_unite() + " : \t" + unite.getLibelle_unite();
                }
            }

            @Override
            public M_Unite fromString(String string) {
                return null;
            }

        });
        cb_tva.setConverter(new StringConverter<M_Taux_tva>() {
            @Override
            public String toString(M_Taux_tva tva) {
                if (tva == null) {
                    return null;
                } else {
                    return tva.getid_tva() + " : \t" + tva.getTaux_tva() + "%";
                }
            }

            @Override
            public M_Taux_tva fromString(String string) {
                return null;
            }

        });
        // 4. Sélectionnez une valeur par défaut
        if (les_produits.size() > 0) {
            for (M_Unite unite : cb_unite.getItems()) {
                if (unite.getCode_unite().equals(unProduit.getCode_unite())) {
                    cb_unite.getSelectionModel().select(unite);
                }
            }
        }
        if (les_produits.size() > 0) {
            for (M_Taux_tva tva : cb_tva.getItems()) {
                if (tva.getid_tva() == unProduit.getId_tva()) {
                    cb_tva.getSelectionModel().select(tva);
                }
            }
        }

        bt_edit.setVisible(false);
        bt_detail.setVisible(false);

        switch (choix) {
            case 0:
                // System.out.println("le choix _" + choix + "_ des details du produit " +
                // unProduit.getId_produit());
                lb_idProd.setText(String.valueOf(unProduit.getId_produit()));
                ed_libelle_produit.setText(unProduit.getLibelle_produit());
                ta_com_produit.setText(unProduit.getCommentaire_produit());
                ed_prix_achat.setText(String.valueOf(unProduit.getPrix_achat()));
                ed_formuleCalc.setText(unProduit.getFormule_calcul());
                ed_prix_prod.setText(String.valueOf(unProduit.getPrix_produit()));
                ta_comCalcul.setText(unProduit.getCommentaire_calcul());
                ta_com.setText(unProduit.getComment());

                if (unProduit.getNb_produit() >= 2) {
                    pn_compos.setVisible(true);
                    // créer une liste vide pour contenir tous les produits filtrés
                    List<M_Produits> produitsFiltres = new ArrayList<>();

                    for (M_Composer unComposer : lesCompos.values()) {
                        // si l'enregistrement a le même id_produit_mix que celui sélectionné
                        // System.out.println("\nles produits _____________: " +
                        // unComposer.getId_produit_composant());

                        if (unComposer.getId_produit_mix() == unProduit.getId_produit()) {
                            // //System.out.println(unProduit.getId_produit());
                            produitsFiltres.add(lesProduits.get(unComposer.getId_produit_composant()));
                            // System.out.println("\n correspond " + unComposer.getId_produit_composant());
                        } else {
                            // System.out.println("\n ne correspond pas " +
                            // unComposer.getId_produit_composant());
                        }
                    }

                    // définir la liste filtrée de produits dans la vue de tableau on peut plus
                    // utiliser les_produits car ils ne sont pas filtré.
                    ObservableList<M_Produits> obProduitsFiltres = FXCollections
                            .observableArrayList(produitsFiltres);
                    tb_compos.setItems(obProduitsFiltres);

                    // définir les factories de valeurs de cellule pour les colonnes du tableau
                    tc_libelle_compos
                            .setCellValueFactory(new PropertyValueFactory<M_Produits, String>("libelle_produit"));
                    tc_com.setCellValueFactory(new PropertyValueFactory<M_Produits, String>("comment"));
                    tc_id_compos.setCellValueFactory(new PropertyValueFactory<M_Produits, Integer>("id_produit"));
                    // tc_ordre_compos.setCellValueFactory(new PropertyValueFactory<M_Composer,
                    // Integer>("ordre_mix"));

                } else {
                    pn_compos.setVisible(false);
                }

                bt_enreg.setVisible(false);
                bt_supp.setVisible(true);
                bt_ajoutCompos.setVisible(false);
            

                break;

            case 1:
                // TODO init components
                // System.out.println("le choix _" + choix + "_ des ajouts");
                pn_compos.setVisible(false);
                lb_idProd.setText("");
                ed_libelle_produit.setText("");
                ta_com_produit.setText("");
                ed_prix_achat.setText("");
                ed_formuleCalc.setText("");
                ed_prix_prod.setText("");
                ta_com_produit.setText("");
                ta_com.setText("");
                ta_comCalcul.setText("");

                
                bt_enreg.setVisible(true);
                bt_ajoutCompos.setVisible(false);
                bt_supp.setVisible(false);

                break;

            case 2:
                // partie modifier
                // System.out.println("le choix _" + choix + "_ de la modification");
                pn_compos.setVisible(true);

                lb_idProd.setText(String.valueOf(unProduit.getId_produit()));
                ed_libelle_produit.setText(unProduit.getLibelle_produit());
                ta_com_produit.setText(unProduit.getCommentaire_produit());
                ed_prix_achat.setText(String.valueOf(unProduit.getPrix_achat()));
                ed_formuleCalc.setText(unProduit.getFormule_calcul());
                ed_prix_prod.setText(String.valueOf(unProduit.getPrix_produit()));
                ta_comCalcul.setText(unProduit.getCommentaire_calcul());
                ta_com.setText(unProduit.getComment());
                if (unProduit.getNb_produit() >= 2) {

                    pn_compos.setVisible(true);
                    List<M_Produits> produitsFiltres = new ArrayList<>();

                    // parcourir tous les enregistrements de la liste lesCompos
                    for (M_Composer unComposer : lesCompos.values()) {
                        // si l'enregistrement a le même id_produit_mix que celui sélectionné
                        // System.out.println("\nles produits _____________: " +
                        // unComposer.getId_produit_composant());

                        if (unComposer.getId_produit_mix() == unProduit.getId_produit()) {
                            produitsFiltres.add(lesProduits.get(unComposer.getId_produit_composant()));
                            // System.out.println(unProduit.getId_produit()+"et"+unComposer.getId_produit_composant());

                        }
                    }

                    // // définir la liste filtrée de produits dans la vue de tableau on peut plus
                    // // utiliser les_produits car ils ne sont pas filtré.
                    ObservableList<M_Produits> obProduitsFiltres = FXCollections
                            .observableArrayList(produitsFiltres);
                    tb_compos.setItems(obProduitsFiltres);
                    // définir les factories de valeurs de cellule pour les colonnes du tableau
                    tc_libelle_compos
                            .setCellValueFactory(new PropertyValueFactory<M_Produits, String>("libelle_produit"));
                    tc_com.setCellValueFactory(new PropertyValueFactory<M_Produits, String>("comment"));
                    tc_id_compos.setCellValueFactory(new PropertyValueFactory<M_Produits, Integer>("id_produit"));
                    // tc_id_compos.setCellValueFactory(new PropertyValueFactory<M_Produits,
                    // Integer>("ordre_mix"));

                    bt_ajoutCompos.setVisible(false);
                } else {
                    bt_ajoutCompos.setVisible(true);

                    pn_compos.setVisible(false);
                }

                if (unProduit.getNb_produit() >= 2) {
                    pn_compos.setVisible(true);
                } else {
                    pn_compos.setVisible(false);
                }

                // bt_addRow.setVisible(true); null
                // bt_removeRow.setVisible(true);

                bt_enreg.setVisible(true);
                bt_supp.setVisible(false);
                break;
            // case 3:

        }
    }

    // -----------afficher mix------------//
    /**
     * Cette méthode permert de gérer les traitements d'affichages des produits avec
     * leur composés pour ceux étant des mixes.
     * Cette permet aussi d'afficher l'ajout des composé dans un mixe, ou la
     * modification d'un mixe.
     * 
     * @param unProduit
     * @param lesProduits
     * @param lesTvas
     * @param lesUnites
     * @param lesCompos
     * @param id
     */
    public void aff_V_Produits_mixes(
            LinkedHashMap<Integer, M_Produits> lesProduits,
            LinkedHashMap<Integer, M_Taux_tva> lesTvas,
            LinkedHashMap<String, M_Unite> lesUnites,
            LinkedHashMap<Integer, M_Composer> lesCompos, String id, boolean is_mix) {

        les_produits = FXCollections.observableArrayList(lesProduits.values());
        les_tvas = FXCollections.observableArrayList(lesTvas.values());
        les_unite = FXCollections.observableArrayList(lesUnites.values());
        les_compos = FXCollections.observableArrayList(lesCompos.values());
        bt_personnaliser.setVisible(false);
     

        int idMix = Integer.parseInt(id);
        lb_idProd.setText(id);

        // créer une liste vide pour contenir tous les produits filtrés
        List<M_Produits> produitsFiltres = new ArrayList<>();
        List<M_Composer> composants = new ArrayList<>(lesCompos.values());
        Collections.sort(composants, new Comparator<M_Composer>() {
            @Override
            public int compare(M_Composer c1, M_Composer c2) {
                if (c1.getOrdre_mix() == c2.getOrdre_mix()) {
                    // Si les deux composants ont le même ordre, on décale le deuxième d'un rang
                    return c1.getOrdre_mix() + 1 - c2.getOrdre_mix();
                } else {
                    return c1.getOrdre_mix() - c2.getOrdre_mix();
                }
            }
        });

        // for (M_Composer unComposer : composants) {
        // if (unComposer.getId_produit_mix() == idMix) {
        // int ordreMix = unComposer.getOrdre_mix();
        // if (ordreMix < 1) {
        // ordreMix = 1;
        // unComposer.setOrdre_mix(ordreMix);
        // }
        // produitsFiltres.add(lesProduits.get(unComposer.getId_produit_composant()));
        // }
        // }
        HashSet<Integer> ordres = new HashSet<>();
        int dernierOrdreDisponible = 0;
        for (M_Composer unComposer : composants) {
            if (unComposer.getId_produit_mix() == idMix) {
                int ordre = unComposer.getOrdre_mix() < 1 ? dernierOrdreDisponible + 1 : unComposer.getOrdre_mix();
                while (ordres.contains(ordre)) {
                    ordre++;
                }
                ordres.add(ordre);
                dernierOrdreDisponible = ordre;
                produitsFiltres.add(lesProduits.get(unComposer.getId_produit_composant()));
            }
        }

        // obProduitsFiltres = FXCollections.observableArrayList(produitsFiltres);
        // tb_compos.setItems(obProduitsFiltres);

        // définir la liste filtrée de produits dans la vue de tableau
        // on peut plus utiliser les_produits car ils ne sont pas filtrés.
        obProduitsFiltres = FXCollections.observableArrayList(produitsFiltres);
        tb_compos.setItems(obProduitsFiltres);

        // définir les factories de valeurs de cellule pour les colonnes du tableau
        tc_libelle_compos.setCellValueFactory(new PropertyValueFactory<M_Produits, String>("libelle_produit"));
        tc_com.setCellValueFactory(new PropertyValueFactory<M_Produits, String>("comment"));
        tc_id_compos.setCellValueFactory(new PropertyValueFactory<M_Produits, Integer>("id_produit"));

        // Créer une liste filtrée qui ne contient que les éléments qui ne sont pas dans
        // obProduitsFiltres
        FilteredList<M_Produits> produitsNonCompos = les_produits
                .filtered(p -> !obProduitsFiltres.contains(p) && p.getId_produit() != idMix);

        // Définir les factories de valeurs de cellule pour les colonnes du tableau
        // tb_produits1
        tc_id_produit1.setCellValueFactory(new PropertyValueFactory<M_Produits, Integer>(String.valueOf("id_produit")));
        tc_libelle_produit1
                .setCellValueFactory(new PropertyValueFactory<M_Produits, String>(String.valueOf("libelle_produit")));
        tc_commentaire1.setCellValueFactory(new PropertyValueFactory<M_Produits, String>(String.valueOf("comment")));
        tc_prix_achat1.setCellValueFactory(new PropertyValueFactory<M_Produits, Float>("prix_achat"));
        tc_prix_unitaire1.setCellValueFactory(new PropertyValueFactory<M_Produits, Float>("prix_produit"));

        // Définir la liste filtrée de produits dans la vue de tableau tb_produits1
        tb_produits1.setItems(produitsNonCompos);
        obProduitsFiltres.addListener((ListChangeListener<M_Produits>) c -> {
            c.next();
            // Mise à jour de la liste filtrée produitsNonCompos
            produitsNonCompos.setPredicate(p -> !obProduitsFiltres.contains(p) && p.getId_produit() != idMix);
        });

        // TODO TEST

        // FIN TODO TEST
        lb_isMix.setText(String.valueOf(is_mix));
        lb_isMix.setVisible(false);
        gp_compos.setVisible(false);

bt_up.setOnAction(e -> {
    M_Produits currentItem = tb_compos.getSelectionModel().getSelectedItem();
    int currentIndex = obProduitsFiltres.indexOf(currentItem);
    int newIndex = currentIndex - 1;
    if (newIndex >= 0) {
        tb_compos.getSelectionModel().getSelectedItem();
        obProduitsFiltres.remove(currentIndex);
        obProduitsFiltres.add(newIndex, currentItem);
        tb_compos.getSelectionModel().select(newIndex);
        // for(M_Composer c : les_compos){
            // M_Produits p = lesProduits.get(currentIndex);
            // if(p.getId_produit()==c.getId_produit_composant()){
                // c.getOrdre_mix();
                    ed_ordre.setText(String.valueOf(Integer.valueOf(ed_ordre.getText())-1));
               
            // } else{
            //     ed_ordre.setText(String.valueOf(currentIndex));
            // }
        // }
    }
});

bt_down.setOnAction(e -> {
    M_Produits currentItem = tb_compos.getSelectionModel().getSelectedItem();
    int currentIndex = obProduitsFiltres.indexOf(currentItem);
    int newIndex = currentIndex + 1;
    if (newIndex < obProduitsFiltres.size()) {
        obProduitsFiltres.remove(currentIndex);
        obProduitsFiltres.add(newIndex, currentItem);
        tb_compos.getSelectionModel().select(newIndex);
        ed_ordre.setText(String.valueOf(Integer.valueOf(ed_ordre.getText())+1));
    }
});
tb_compos.setSortPolicy(event -> false);

// ---------------------------------------Méthode des bouttons up & down---------------------------------------//
/*
* 
// Définissez une colonne pour les boutons de déplacement
TableColumn<M_Produits, Void> moveCol = new TableColumn<>("Déplacer");

// Créez une cellule de bouton pour la colonne de déplacement
Callback<TableColumn<M_Produits, Void>, TableCell<M_Produits, Void>> buttonCellFactory = new Callback<>() {
    @Override
    public TableCell<M_Produits, Void> call(TableColumn<M_Produits, Void> col) {
        return new TableCell<>() {
            private final Button btnUp = new Button("↑");
            private final Button btnDown = new Button("↓");
            
            // Ajoutez des gestionnaires d'événements de souris pour les boutons de déplacement
            {
                btnUp.setOnAction(e -> {
                    M_Produits currentItem = getTableView().getItems().get(getIndex());
                    int currentIndex = getTableView().getItems().indexOf(currentItem);
                    int newIndex = currentIndex - 1;
                    if (newIndex >= 0) {
                        getTableView().getItems().remove(currentIndex);
                        getTableView().getItems().add(newIndex, currentItem);
                        getTableView().getSelectionModel().select(newIndex);
                    }
                });
                btnDown.setOnAction(e -> {
                    M_Produits currentItem = getTableView().getItems().get(getIndex());
                    int currentIndex = getTableView().getItems().indexOf(currentItem);
                    int newIndex = currentIndex + 1;
                    if (newIndex < getTableView().getItems().size()) {
                        getTableView().getItems().remove(currentIndex);
                        getTableView().getItems().add(newIndex, currentItem);
                        getTableView().getSelectionModel().select(newIndex);
                    }
                });
            }
            
            @Override
            public void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    HBox box = new HBox(btnUp, btnDown);
                    box.setSpacing(5);
                    setGraphic(box);
                }
            }
        };
    }
};
moveCol.setCellFactory(buttonCellFactory);

// Ajoutez la colonne de déplacement à la TableView
tb_compos.getColumns().add(moveCol);
 */
// ---------------------------------------Fin Méthode des bouttons up & down---------------------------------------//

    }

    public void deplacerEnregistrement(List<M_Composer> donnes_replace, M_Composer enregistrement, String action) {
        int index = donnes_replace.indexOf(enregistrement);
        if (index < 0) {
            // l'enregistrement n'existe pas dans les données
            return;
        }
        int ordre = enregistrement.getOrdre_mix();
        if (action.equals("plus")) {
            if (index == donnes_replace.size() - 1) {
                // l'enregistrement est déjà en dernière position
                return;
            }
            M_Composer enregistrementSuivant = donnes_replace.get(index + 1);
            int nouvelOrdre = enregistrementSuivant.getOrdre_mix();
            enregistrementSuivant.setOrdre_mix(ordre);
            enregistrement.setOrdre_mix(nouvelOrdre);
        } else if (action.equals("moins")) {
            if (index == 0) {
                // l'enregistrement est déjà en première position
                return;
            }
            M_Composer enregistrementPrecedent = donnes_replace.get(index - 1);
            int nouvelOrdre = enregistrementPrecedent.getOrdre_mix();
            enregistrementPrecedent.setOrdre_mix(ordre);
            enregistrement.setOrdre_mix(nouvelOrdre);
        }
    }

    // ----------------comparaison des produits---------------//
    /**
     * Cette méthode permet de comparer les composants d'une liste filtré et de
     * liste de tous les produits.
     * Si dans la liste filtré,il a un element de plus, il est ajouté. s'il ya en
     * moins mais toujours au moins > 2, il est supprimer
     * Sinon S'il existe déja, la liste filtré n'as pas changée, rien ne se passe
     * 
     * @throws Exception
     */
    public void compareCompos(LinkedHashMap<Integer, M_Produits> lesProds, LinkedHashMap<Integer, M_Composer> lesCompos)
            throws Exception {

        les_compos = FXCollections.observableArrayList(lesCompos.values());
        les_produits = FXCollections.observableArrayList(lesProds.values());

        int id_produit_mix, id_produit_composant, ordre_mix, id;
        id = Integer.parseInt(lb_idProd.getText());

        float qte_mix;
        String comment;

        // ---------Ajouter les composants manquants dans la base de 
        // données------------//

        // Créer un Set pour stocker les identifiants des produits filtrés
        Set<Integer> filteredProduitIds = new HashSet<>();
        for (M_Produits produit : obProduitsFiltres) {
            filteredProduitIds.add(produit.getId_produit());

            if (produit.getId_produit() != id) {
                // Vérifier si le composant est déjà dans la base de données
                boolean isPresent = false;
                // System.out.println(produit.getId_produit()+" pas dans la db \n\t");
                for (M_Composer composant : les_compos) {
                    if (composant.getId_produit_mix() == id
                            && composant.getId_produit_composant() == produit.getId_produit()) {
                        isPresent = true;
                        ordre_mix = composant.getOrdre_mix();
                        // System.out.println(produit.getId_produit()+" deja dans la db mix =
                        // "+composant.getId_produit_mix()+"\n");
                        break;
                    }
                }
                // Si le composant n'est pas présent dans la base de données, l'ajouter
                if (!isPresent) {
                    try {
                        id_produit_mix = id;

                        id_produit_composant = produit.getId_produit();
                        // for (int i > 0; i<filteredProduitIds.size(); i++) {
                        // ordre_mix =+i; //12345678
                        // }
                        ordre_mix = 0;
                        qte_mix = 0; //
                        comment = ""; //
                        unProduit = lesProds.get(id_produit_composant);
                        // System.out.println("\n\t\t ajout dans la db "+produit.getId_produit());
                        // Ajouter le composant à la base de données
                        leControl.ajout_composant(unProduit, id_produit_mix, id_produit_composant, ordre_mix, qte_mix,
                                comment);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        // ---------------------supression des composants ------------------------//

        // Parcourir les composants de la base de données
        for (M_Composer composant : les_compos) {
            if (composant.getId_produit_mix() == id
                    && !filteredProduitIds.contains(composant.getId_produit_composant())) {
                // Supprimer le composant de la base de données
                // System.out.println("\ncomposant: produits :supprime = " +
                // composant.getId_produit_composant()+" idm:"+composant.getId_produit_mix());
                try {
                    leControl.supprimerComposant(composant);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
