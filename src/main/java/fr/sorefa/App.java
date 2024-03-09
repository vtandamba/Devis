package fr.sorefa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import fr.sorefa.controllers.C_Chantiers;
import fr.sorefa.controllers.C_Clients;
import fr.sorefa.controllers.C_Devis;
import fr.sorefa.controllers.C_Menu;
import fr.sorefa.controllers.C_Param;
import fr.sorefa.controllers.C_Produits;
import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;
import fr.sorefa.controllers.C_Installation;
import fr.sorefa.controllers.C_Pdf;
import fr.sorefa.model.M_Chantiers;
import fr.sorefa.model.M_Civilite;
import fr.sorefa.model.M_Clients;
import fr.sorefa.model.M_Composer;
import fr.sorefa.model.M_Produits;
import fr.sorefa.model.M_Statut;
import fr.sorefa.model.M_Taux_tva;
import fr.sorefa.model.M_Unite;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private static FXMLLoader l_install;
    private static Parent v_install;
    private static C_Installation c_install;

    private static FXMLLoader l_client_details;
    private static Parent v_client_details;
    private static C_Clients c_client_details;

    // private static FXMLLoader l_param;
    // private static Parent v_param;
    // private static C_Param c_param;

    private static FXMLLoader l_pdf;
    private static Parent v_pdf;
    private static C_Pdf c_pdf;
    // Les attributs privés pour le menuController
    private static FXMLLoader l_menu;
    private static Parent v_menu;
    private static C_Menu c_menu;
    // les attributs privés pour le devis controller
    private static FXMLLoader l_devis_liste;
    private static Parent v_devis_liste;
    private static C_Devis c_devis_liste;
    // private static FXMLLoader l_devis_liste;
    // private static Parent v_devis_liste;
    // private static C_Devis c_devis_liste;

    // les attributs privés pour le client controller
    private static FXMLLoader l_client_liste;
    public static Parent v_client_liste;
    private static C_Clients c_client_liste;

    // les attributs privés pour le chantier controller
    private static FXMLLoader l_chantier_liste;
    private static Parent v_chantier_liste;
    private static C_Chantiers c_chantier_liste;

    private static FXMLLoader l_chantier_details;
    private static Parent v_chantier_details;
    private static C_Chantiers c_chantier_details;

    //-- les attributs privés pour le controller produit --//
    private static FXMLLoader l_produit_liste;
    private static Parent v_produit_liste;
    private static C_Produits c_produit_liste;

    private static FXMLLoader l_produit_details;
    private static Parent v_produit_details;
    private static C_Produits c_produit_details;

    private static FXMLLoader l_produit_mixes;
    private static Parent v_produit_mixes;
    private static C_Produits c_produit_mixes;

    private static Db_mysql baseSo;
    private File file = new File("./doc/json/install.json");
    private static LinkedHashMap<Integer, M_Clients> lesClients;
    private static LinkedHashMap<String, M_Statut> lesStatuts;
    private static LinkedHashMap<String, M_Civilite> lesCivilites;
    private static LinkedHashMap<Integer, M_Chantiers> lesChantiers;
    private static LinkedHashMap<Integer, M_Produits> lesProduits;
    private static LinkedHashMap<Integer, M_Taux_tva> lesTvas;
    private static LinkedHashMap<String, M_Unite> lesUnites;
    private static LinkedHashMap<Integer, M_Composer> lesCompos;

    private static M_Clients unClient;
    private static M_Produits unProduit;
    private static M_Composer unCompos;
    private static Map<String, Stage> windows = new HashMap<>();

    // private static FXMLLoader l_produits;
    // private static Parent v_produits;
    // private static ProduitsController c_produits;

    /**
     * Cette méthode est appelée lorsque l'application démarre et crée la première
     * scène.
     * La méthode connection() est appelée pour établir une connexion à une base de
     * données.
     * Ensuite, diverses vues sont chargées en utilisant la méthode loadFXML(). Les
     * méthode loadFXML() et load()
     * renvoie un objet FXMLLoader et permettent le chargement du ficier FXML.
     * Les vues sont ensuite enregistrées dans des variables, telles que
     * v_devis_liste, v_client_liste, etc.
     * Les contrôleurs correspondants pour chaque vue sont également enregistrés
     * dans des variables,
     * telles que c_devis_liste, c_client_liste, etc.Ensuite. En profitant, la
     * méthode setApp() est appelée pour chaque contrôleur
     * afin de fournir une référence à l'application. Cela permet aux contrôleurs
     * d'interagir avec l'application.
     */
    @Override
    public void start(Stage stage) throws Exception {
        connection();
        // vue devis
        l_devis_liste = loadFXML("devis_liste");
        v_devis_liste = l_devis_liste.load();
        c_devis_liste = l_devis_liste.<C_Devis>getController();

        // l_devis_liste = loadFXML("devis_liste");
        // v_devis_liste = l_devis_liste.load();
        // c_devis_liste = l_devis_liste.<C_Devis>getController();

        // vue clients
        l_client_liste = loadFXML("client_liste");
        v_client_liste = l_client_liste.load();
        c_client_liste = l_client_liste.<C_Clients>getController();
        l_client_details = loadFXML("client_details");
        v_client_details = l_client_details.load();
        c_client_details = l_client_details.<C_Clients>getController();

        // vue produits
        l_produit_liste = loadFXML("produit_liste");
        v_produit_liste = l_produit_liste.load();
        c_produit_liste = l_produit_liste.<C_Produits>getController();
        l_produit_details = loadFXML("produit_details");
        v_produit_details = l_produit_details.load();
        c_produit_details = l_produit_details.<C_Produits>getController();
        l_produit_mixes = loadFXML("produit_mixes");
        v_produit_mixes = l_produit_mixes.load();
        c_produit_mixes = l_produit_mixes.<C_Produits>getController();

        // vue install
        l_install = loadFXML("install");
        v_install = l_install.load();
        c_install = l_install.<C_Installation>getController();
        // vue pdf
        l_pdf = loadFXML("pdf");
        v_pdf = l_pdf.load();
        c_pdf = l_pdf.<C_Pdf>getController();
        // vue param
        // l_param = loadFXML("param");
        // v_param = l_param.load();
        // c_param = l_param.<C_Param>getController();
        // vue menu
        l_menu = loadFXML("menu");
        v_menu = l_menu.load();
        c_menu = l_menu.<C_Menu>getController();
        // vue chantier
        l_chantier_details = loadFXML("chantier_details");
        v_chantier_details = l_chantier_details.load();
        c_chantier_details = l_chantier_details.<C_Chantiers>getController();

        l_chantier_liste = loadFXML("chantier_liste");
        v_chantier_liste = l_chantier_liste.load();
        c_chantier_liste = l_chantier_liste.<C_Chantiers>getController();

        c_client_liste.setApp(this);
        c_client_details.setApp(this);

        c_chantier_liste.setApp(this);
        c_chantier_details.setApp(this);

        c_devis_liste.setApp(this);

        c_produit_liste.setApp(this);
        c_produit_details.setApp(this);
        c_produit_mixes.setApp(this);

        // c_param.setApp(this);

        if (file.exists() && (file.length() != 0)) {
            scene = new Scene(v_menu, 620, 400);
            c_menu.setApp(this);
        } else {
            scene = new Scene(v_install, 640, 480);
        }

        stage.setScene(scene);
        stage.show();

    }

    /**
     * La méthode définit la racine de la Scene en utilisant
     * le résultat du chargement du fichier FXML défini par le paramètre fxml.
     * La méthode load de cet objet est alors appelée pour charger le fichier FXML
     * et renvoyer la vue associée au contrôleur. Le résultat est défini comme la
     * racine de la Scene en utilisant la méthode setRoot.
     * 
     * @param fxml
     * @throws IOException
     */
    public void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml).load());
    }

    /**
     * La méthode loadFXML permet de charger un fichier FXML. Elle prend en entrée
     * un String
     * correspondant au nom du fichier FXML à charger (sans l'extension .fxml) et
     * retourne un objet FXMLLoader.
     * L'objet FXMLLoader est initialisé avec le chemin du fichier FXML à charger à
     * l'aide de App.class.getResource(fxml + ".fxml").
     * Le chemin est déterminé à partir de la classe App.Ensuite, l'objet FXMLLoader
     * est retourné pour
     * être utilisé ailleurs dans le code (notament dans start(Stage stage)) pour
     * charger le fichier FXML.
     * 
     * @param fxml
     * @return
     * @throws IOException
     */
    private FXMLLoader loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader;
    }

    /**
     * Cette méthode permet de mettre à jour le titre de la fenêtre
     * à chaque fois que la méthode openWindow est appelé avec un titre différent
     * pour la même fenêtre
     * 
     * @param fxml
     * @param defaultTitle
     * @throws Exception
     */
    public void openWindow(String fxml, String defaultTitle) throws Exception {
        openWindow(fxml, defaultTitle, defaultTitle);
    }

    /**
     * Cette méthode openWindow permet d'ouvrir une nouvelle fenêtre pour afficher
     * un formulaire (fxml) en fonction de sa valeur.
     * Il vérifie d'abord si la fenêtre est déjà ouverte en utilisant une map
     * (windows) qui contient les fenêtres ouvertes en tant que clé
     * et leur état Stage en tant que valeur.
     * Ensuite, s'il n'y a pas de fenêtre ouverte pour le formulaire, une nouvelle
     * fenêtre est créée en utilisant un objet Scene associé au formulaire.
     * La scène est définie en fonction de la valeur de fxml.
     * La nouvelle fenêtre est initialisée avec une modalité d'application modale
     * (Modality.APPLICATION_MODAL), ce qui signifie que
     * l'utilisateur ne peut pas interagir avec les autres fenêtres de l'application
     * tant que la fenêtre modale est ouverte.
     * Enfin, la nouvelle fenêtre est ajoutée à la map windows pour la suivante.
     * Et si la fenêtre est déjà ouverte, la méthode show est simplement appelée
     * pour la montrer avec le titre correspondant.
     * Car la méthode prend en charge les deux titres et met à jour le titre de la
     * fenêtre si le nouveau titre est différent du titre actuel.
     */

    public void openWindow(String fxml, String defaultTitle, String newTitle) throws Exception {
        Stage eStage = windows.get(fxml);

        if (eStage == null) {
            eStage = new Stage();
            switch (fxml) {
                case "client_liste":
                    scene = new Scene(v_client_liste, 800, 550);
                    break;
                //  case "param":
                //     scene = new Scene(v_param, 800, 550);
                //     break;
                case "produit_liste":
                    scene = new Scene(v_produit_liste, 800, 550);
                    break;
                case "chantier_liste":
                    scene = new Scene(v_chantier_liste, 800, 550);
                    break;
                case "devis_liste":
                    scene = new Scene(v_devis_liste, 800, 550);
                    break;
                case "client_details":
                    scene = new Scene(v_client_details, 800, 635);
                    break;
                case "produit_details":
                    scene = new Scene(v_produit_details, 800, 635);
                    break;
                case "produit_mixes":
                    scene = new Scene(v_produit_mixes, 800, 650);
                    break;
                case "chantier_details":
                    scene = new Scene(v_chantier_details, 800, 635);
                    break;
                default:
                    System.out.println("fenetre non trouvée");
            }
            eStage.setScene(scene);
            eStage.initModality(Modality.APPLICATION_MODAL);

            eStage.setTitle(defaultTitle);

            windows.put(fxml, eStage);
        }
        if (!eStage.getTitle().equals(newTitle)) {
            eStage.setTitle(newTitle);
        }
        // initialiser le comportement de la fenêtre
        // par exemple, définir l'action à effectuer lors de la fermeture de la fenêtre
        eStage.setOnCloseRequest(event -> {
            closeWindow(fxml);
        });
        eStage.show();
    }

    /**
     * La fonction "closeWindow" ferme une fenêtre donnée. Cette fenêtre est
     * référencée par le paramètre "fxml",
     * qui représente le nom du fichier FXML associé à la fenêtre. La fonction
     * vérifie si la fenêtre existe
     * dans la collection "windows", en utilisant la méthode "get (fxml)". Si elle
     * existe, la fenêtre
     * est fermée en appelant la méthode "close ()". Si elle n'existe pas, le
     * message d'erreur "verifier
     * le fichier fxml à fermer" est affiché.
     * 
     * @param fxml
     */
    public void closeWindow(String fxml) {
        Stage window = windows.get(fxml);
        if (window != null) {
            window.close();

            // windows.remove(fxml);
        } else {
            System.out.println("verifier le fichier fxml à fermer");
        }
    }

    // ----- Fin traitements d'affichage des fenetres--- CLIENTS__>>
    /**
     * Cette méthode affiche la liste des clients en utilisant la méthode openWindow
     * pour
     * ouvrir la fenêtre "client_liste" et en définissant le titre de la fenêtre
     * comme "Liste des clients".
     * Ensuite, il obtient la liste des clients en utilisant la méthode getRecords
     * de la classe M_Clients
     * et la passe à la méthode aff_V_Client_liste de la classe c_client_liste.
     * 
     * @throws Exception
     */

    public void afficherClients_liste() throws Exception {
        openWindow("client_liste", "Liste des clients");
        lesClients = M_Clients.getRecords(baseSo);
        c_client_liste.aff_V_Client_liste(lesClients);
    }

    /**
     * Cette méthode affiche le détails des clients en utilisant la méthode
     * openWindow pour
     * ouvrir la fenêtre "client_details" et en définissant le titre de la fenêtre
     * comme "details des clients".
     * Ensuite, il obtient le details des clients en utilisant la méthode getRecords
     * de la classe M_Clients
     * et la passe à la méthode aff_V_Client_details de la classe c_client_details.
     * 
     * @param unClient
     * @param choix
     * @throws Exception
     */
    public void afficherClients_details(M_Clients unClient, int choix) throws Exception {
        openWindow("client_details", "Les details du clients");
        lesClients = M_Clients.getRecords(baseSo);
        lesCivilites = M_Civilite.getRecords(baseSo);
        lesStatuts = M_Statut.getRecords(baseSo);
        c_client_details.aff_V_Client_details(unClient, lesClients, lesCivilites, lesStatuts, choix);
    }

    /**
     * Cette méthode permet d'afficher une fenêtre "Ajout d'un client" pour ajouter
     * un nouveau client.
     * Elle utilise le controlleur c_client_details pour afficher la vue
     * V_Client_details.
     * La méthode récupère également les données des clients, des civilités et des
     * statuts depuis la base de données
     * à l'aide de la classe M_Clients, M_Civilite et M_Statut respectivement.
     * L'identifiant id et le choix choix sont passés en paramètres pour indiquer
     * les données à afficher.
     * 
     * @param id
     * @param choix
     * @throws Exception
     */
    public void afficherClients_ajout(M_Clients unClient, int choix) throws Exception {
        openWindow("client_details", "Ajout d'un client");
        lesClients = M_Clients.getRecords(baseSo);
        lesCivilites = M_Civilite.getRecords(baseSo);
        lesStatuts = M_Statut.getRecords(baseSo);
        c_client_details.aff_V_Client_details(unClient, lesClients, lesCivilites, lesStatuts, choix);
    }

    /**
     * Cette méthode permet d'afficher une fenêtre "Modification d'un client" pour
     * modifier un client.
     * Cette méthode affiche une fenêtre pour la modification d'un client.
     * Elle récupère tous les enregistrements de clients, de civilités et de statuts
     * depuis la base de données,
     * puis utilise la méthode aff_V_Client_details de la classe C_Client_details
     * pour afficher
     * les détails du client sélectionné ainsi que les options de civilité et de
     * statut.
     * Le choix est transmis en argument pour déterminer le mode d'affichage
     * (consultation, ajout ou modification).
     * 
     * @param id
     * @param choix
     * @throws Exception
     */
    public void afficherClients_modif(M_Clients unClient, int choix) throws Exception {
        openWindow("client_details", "Modification d'un client");
        lesClients = M_Clients.getRecords(baseSo);
        lesCivilites = M_Civilite.getRecords(baseSo);
        lesStatuts = M_Statut.getRecords(baseSo);
        c_client_details.aff_V_Client_details(unClient, lesClients, lesCivilites, lesStatuts, choix);
        System.out.println(unClient + " le client selectionné d'id depuis app : " + unClient.getId_client());

    }

    /**
     * Cette méthode permet d'enregistrer les modification effectuées sur un client.
     * Elle affiche le dictionnaire LinkedHasmap des clients mis à jour après la
     * modification en appelant
     * la méthode afficherClients_liste()
     * 
     * @param id_Client
     * @param nom
     * @param prenom
     * @param codeSiret
     * @param Ent_bool
     * @param nomEntr
     * @param numTVA
     * @param adresse1
     * @param adresse2
     * @param lieu_dit
     * @param cp
     * @param ville
     * @param tel
     * @param comment
     * @param Statut
     * @param civilite
     * @throws Exception
     */
    public void modifier_Client(int id_Client, String nom, String prenom, String codeSiret, Boolean Ent_bool,
            String nomEntr, Float numTVA, String adresse1, String adresse2, String lieu_dit, String cp, String ville,
            String tel, String comment, String Statut, String civilite) throws Exception {
        // les_Clients = FXCollections.observableArrayList(lesClients.values());

        System.out.println(id_Client + " l'id recupérée pour l'enregistrement après la modification");
        unClient = lesClients.get(id_Client);
        unClient.setNom_client(nom);
        unClient.setPrenom_client(prenom);
        unClient.setSiret_client(codeSiret);
        unClient.setBool_entreprise(Ent_bool);
        unClient.setNom_entreprise(nomEntr);
        unClient.setNum_tva_client(numTVA);
        unClient.setAdresse1_client(adresse1);
        unClient.setAdresse2_client(adresse2);
        unClient.setLieu_dit_client(lieu_dit);
        unClient.setCp_client(cp);
        unClient.setVille_client(ville);
        unClient.setTel_client(tel);
        unClient.setComment(comment);
        unClient.setCode_statut(Statut);
        unClient.setCode_civilite(civilite);
        unClient.update();
        this.afficherClients_liste();

    }

    /**
     * Cette méthode permet d'enregistrer l'ajouter un nouveau client.
     * Elle affiche la liste des clients mis à jour après l'ajout du mouveau client
     * en appelant la méthode afficherClients_liste()
     * 
     * @param nom_client
     * @param prenom_client
     * @param siret_client
     * @param bool_entreprise
     * @param nom_entreprise
     * @param num_tva_client
     * @param adresse1_client
     * @param adresse2_client
     * @param lieu_dit_client
     * @param cp_client
     * @param ville_client
     * @param tel_client
     * @param comment
     * @param date_create
     * @param code_statut
     * @param code_civilite
     * @throws Exception
     */
    public void ajouter_Client(String nom_client, String prenom_client, String siret_client, Boolean bool_entreprise,
            String nom_entreprise, Float num_tva_client, String adresse1_client,
            String adresse2_client, String lieu_dit_client,
            String cp_client, String ville_client, String tel_client, String comment,
            String code_statut, String code_civilite) throws Exception {
        unClient = new M_Clients(baseSo, nom_client, prenom_client, siret_client, bool_entreprise, nom_entreprise,
                num_tva_client, adresse1_client, adresse2_client, lieu_dit_client, cp_client, ville_client, tel_client,
                comment, code_statut, code_civilite);
        this.afficherClients_liste();
    }

    /**
     * Cette méthode permet la supression d'un client en recupérant l'id du client
     * en paramètre.
     * Elle affiche la liste des clients mis à jour après la supression par
     * l'appel de la méthode afficherClients_liste()
     * 
     * @param id_client
     * @throws Exception
     */
    public void supprimer_Client(M_Clients unClient) throws Exception {
        // les_Clients = FXCollections.observableArrayList(lesClients.values());
        // unClient = les_Clients.get(id_client);
        unClient.delete();
        this.afficherClients_liste();
    }

    // ------ Fin CLIENTS ----------------- PRODUIT ->>
    /**
     * Cette méthode permet d'afficher la liste des produits
     * 
     * @throws Exception
     */
    public void afficherProduit_liste() throws Exception {
        openWindow("produit_liste", "Liste des produit");
        lesProduits = M_Produits.getRecords(baseSo);
        lesCompos = M_Composer.getRecords(baseSo);
        c_produit_liste.aff_V_Produit_liste(lesProduits/* ,lesCompos */);
    }

    /**
     * Cette méthode permet d'afficher les détails des produits
     * 
     * @param unProduit
     * @param choix
     * @throws Exception
     */
    public void afficherProduits_details(M_Produits unProduit, int choix) throws Exception {
        // TODO
        openWindow("produit_details", "Les details d\'un produit");
        lesProduits = M_Produits.getRecords(baseSo);
        lesTvas = M_Taux_tva.getRecords(baseSo);
        lesUnites = M_Unite.getRecords(baseSo);
        lesCompos = M_Composer.getRecords(baseSo);
        c_produit_details.aff_V_Produits_details(unProduit, lesProduits, lesTvas, lesUnites, lesCompos, choix);
    }

    public void afficherProduit_mixes(M_Produits unProduit, String id,boolean is_mix) throws Exception {
        openWindow("produit_mixes", "Les mixes du produit composé");
        lesProduits = M_Produits.getRecords(baseSo);
        lesTvas = M_Taux_tva.getRecords(baseSo);
        lesUnites = M_Unite.getRecords(baseSo);
        lesCompos = M_Composer.getRecords(baseSo);
        // lesCompos = M_Composer.getRecords(baseSo,"id_produit_mix ="+id);
        c_produit_mixes.aff_V_Produits_mixes( lesProduits, lesTvas, lesUnites, lesCompos, id,is_mix);
    }

    /**
     * Cette méthode affiche la fenetre de la modification d'un produit
     * 
     * @param unProduit
     * @param choix
     * @throws Exception
     */
    public void afficherProduit_modif(M_Produits unProduit, int choix) throws Exception {
        openWindow("produit_details", "Modification d'un produit");
        lesProduits = M_Produits.getRecords(baseSo);
        lesTvas = M_Taux_tva.getRecords(baseSo);
        lesUnites = M_Unite.getRecords(baseSo);
        lesCompos = M_Composer.getRecords(baseSo);
        c_produit_details.aff_V_Produits_details(unProduit, lesProduits, lesTvas, lesUnites, lesCompos, choix);
        // System.out.println(unProduit + " le produit selectionné d'id depuis app : " + unProduit.getId_produit());

    }

    /**
     * Cette méthode affiche la fenetre d'ajout d'un produit
     * 
     * @param unProduit
     * @param choix
     * @throws Exception
     */
    public void afficherProduit_ajout(M_Produits unProduit, int choix) throws Exception {
        openWindow("produit_details", "Ajout d'un produit");
        lesProduits = M_Produits.getRecords(baseSo);
        lesTvas = M_Taux_tva.getRecords(baseSo);
        lesUnites = M_Unite.getRecords(baseSo);
        lesCompos = M_Composer.getRecords(baseSo);
        c_produit_details.aff_V_Produits_details(unProduit, lesProduits, lesTvas, lesUnites, lesCompos, choix);

    }

    /**
     * Cette méthode est chargée de faire l'enregistrement de la modification d'un
     * produit
     * 
     * @param id_produit
     * @param libelle_produit
     * @param commentaire_produit
     * @param prix_achat
     * @param formule_calcul
     * @param prix_produit
     * @param commentaire_calcul
     * @param comment
     * @param id_tva
     * @param code_unite
     * @throws Exception
     */
    public void modifier_Produit(int id_produit, String libelle_produit, String commentaire_produit, Float prix_achat,
            String formule_calcul, Float prix_produit, String commentaire_calcul, String comment,
            int id_tva, String code_unite) throws Exception {
        System.out.println("modifier le produit");
        unProduit = lesProduits.get(id_produit);
        unProduit.setLibelle_produit(libelle_produit);
        unProduit.setCommentaire_produit(commentaire_produit);
        unProduit.setPrix_achat(prix_achat);
        unProduit.setFormule_calcul(formule_calcul);
        unProduit.setPrix_produit(prix_produit);
        unProduit.setCommentaire_calcul(commentaire_calcul);
        unProduit.setComment(comment);
        unProduit.setId_tva(id_tva);
        unProduit.setCode_unite(code_unite);
        unProduit.update();
        this.afficherProduit_liste();
    }

    /**
     * Cette méthode permet la modiification du contenu d'un composant
     * 
     * @param id_produit_mix
     * @param id_produit_composant
     * @param ordre_mix
     * @param qte_mix
     * @param comment
     * @throws Exception
     */
    public void modifier_Composant(int id_produit_mix, int id_produit_composant, int ordre_mix, Float qte_mix,
            String comment) throws Exception {
        unCompos = lesCompos.get(id_produit_mix - id_produit_composant);
        System.out.println();
        unCompos.setOrdre_mix(ordre_mix);
        unCompos.setQte_mix(qte_mix);
        unCompos.setComment(comment);
        System.out.println("\n App : : " + unCompos.getId_produit_composant() + ":" + unCompos.getId_produit_mix()
                + " p" + ordre_mix + "qte : " + qte_mix + "com : " + comment);
        unCompos.update();

        String id = String.valueOf(id_produit_mix);
        unProduit = lesProduits.get(id_produit_mix);
        this.afficherProduit_mixes(unProduit, id,true);
    }

    /**
     * Cette méthode permet l'ajout ou le retrait d'un produit dans ou d'un ensemble mixe.
     * Il prend en paramètre l'id du mixe qui permet de mettre à jour les évantuelles modifications en rafraichissant la page.
     * @param id
     * @throws Exception
     */
    public void ajout_retrait_composants(int id) throws Exception {
        lesCompos = M_Composer.getRecords(baseSo);
        lesProduits = M_Produits.getRecords(baseSo);
        c_produit_mixes.compareCompos(lesProduits, lesCompos);
     
        unProduit = lesProduits.get(id);
        String idI = String.valueOf(id);
        this.afficherProduit_mixes(unProduit, idI,true);
               
    }

    // public void refreshMixe(int id) throws Exception{
    //     unProduit = lesProduits.get(id);
    //     String idI = String.valueOf(id);
    //     this.afficherProduit_mixes(unProduit, idI);
    // }
    /**
     * Cette méthode permet de faire afficher les détails d'un produit mixe à la fermeture des détails des produits composés.
     * Elle réactualise les détails au éventuelles modifications
     * @param id
     * @param choix
     * @throws Exception
     */
    public void refreshModif(int id,int choix) throws Exception{
      
        lesProduits = M_Produits.getRecords(baseSo);
        unProduit = lesProduits.get(id);
        System.out.println("refresh modif "+id);
        this.afficherProduit_modif(unProduit, choix);
    }
    /**
     * Cette méthode permet l'ajout d'un composant
     * 
     * @param id_produit_mix
     * @param id_produit_composant
     * @param ordre_mix
     * @param qte_mix
     * @param comment
     * @throws Exception
     */
    public void ajout_composant(M_Produits unProduit, int id_produit_mix, int id_produit_composant,
            int ordre_mix, float qte_mix, String comment) throws Exception {
        unCompos = new M_Composer(baseSo, id_produit_mix, id_produit_composant,
                ordre_mix, qte_mix, comment);
        String id = String.valueOf(id_produit_mix);
        closeWindow("produit_mixe");
        // on recupère le unProduit pour afficher le produit composé mis à jour
        // this.afficherProduit_modif(unProduit, 2);
    }

    /**
     * Cette méthode est chargée de faire l'enregistrement d'ajout d'un produit
     * 
     * @param libelle_produit
     * @param commentaire_produit
     * @param prix_achat
     * @param formule_calcul
     * @param prix_produit
     * @param commentaire_calcul
     * @param comment
     * @param id_tva
     * @param code_unite
     * @throws Exception
     */
    public void ajouter_Produit(String libelle_produit, String commentaire_produit, Float prix_achat,
            String formule_calcul, Float prix_produit, String commentaire_calcul, String comment, int id_tva,
            String code_unite) throws Exception {
        System.out.println("ajout un produit");
        unProduit = new M_Produits(baseSo, libelle_produit, commentaire_produit, prix_achat,
                formule_calcul, prix_produit, commentaire_calcul, comment, id_tva, code_unite);
        this.afficherProduit_liste();
    }

    /**
     * Cette méthode est chargée de faire l'enregistrement de la suppression d'un
     * produit
     * 
     * @param unProduit
     * @throws Exception
     */
    public void supprimerProduit(M_Produits unProduit) throws Exception {
        unProduit.delete();
        this.afficherProduit_liste();

    }

    /**
     * Cette méthode est chargée de faire l'enregistrement de la suppression d'un
     * composant
     * 
     * @param unProduit
     * @throws Exception
     */
    public void supprimerComposant(M_Composer unCompos) throws Exception {
        int id_produit_mix = unCompos.getId_produit_mix();
        int id_produit_composant = unCompos.getId_produit_composant();
        System.out.println(id_produit_composant + " de " + id_produit_mix);
        unCompos = lesCompos.get(id_produit_mix - id_produit_composant);
        unCompos.delete();
    }

    // ----------------- Fin Produits ------ CHANTIER ----------->>

    public void afficherChantier_details(M_Chantiers unChantier, int choix) throws Exception {
        openWindow("chantier_details", "Les details du chantier");
        lesChantiers = M_Chantiers.getRecords(baseSo);
        lesClients = M_Clients.getRecords(baseSo);
        lesCivilites = M_Civilite.getRecords(baseSo);
        lesStatuts = M_Statut.getRecords(baseSo);
        c_chantier_details.aff_V_Chantier_details(unChantier, lesChantiers, lesClients, lesCivilites, lesStatuts,
                choix);
    }
    public void afficherChantiers() throws Exception {
        openWindow("chantier_liste", "Liste des chantier_liste");
        lesChantiers = M_Chantiers.getRecords(baseSo);
        c_chantier_liste.affChantiers(lesChantiers);
    }

    // ----------------- Fin CHANTIER-----------------DEVIS>>
    /**
     * Cette méthode permet d'afficher la liste des devis
     * 
     * @throws Exception
     */
    public void afficherDevis() throws Exception {
        openWindow("devis_liste", "Liste des devis");
        // c_devis_liste.aff TODO
    }

    /**
     * Cette méthode permet le téléchargement d'un devis pdf
     * 
     * @throws Exception
     */
    public void telechargerPDF() throws Exception {
        // HttpServletRequest request = ((ServletRequestAttributes)
        // RequestContextHolder.getRequestAttributes())
        // .getRequest();
        // HttpServletResponse response = ((ServletRequestAttributes)
        // RequestContextHolder.getRequestAttributes())
        // .getResponse();
        // String filePath = "./doc/pdf/cli.pdf";
        // c_client_liste.downloadPDF(request, response, filePath);
        c_client_liste.genererAnunaireC();
    }

    // ---------------- Fin DEVIS ---------------->>

 // ---------------- PARAMÈTRE ---------------->>
    public void afficherParamètre() throws Exception{
        openWindow("param", "Paramètres");
    }
    /**
     * Cette méthode permet la connection à la base de donnée
     */
    private void connection() throws Exception {
        Cl_Connection.connection();
        baseSo = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);
    }

    public static void main(String[] args) {
        launch();
    }

}