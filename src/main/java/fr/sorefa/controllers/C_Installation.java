package fr.sorefa.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import org.json.simple.JSONObject;

// import com.mysql.cj.xdevapi.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

// C:\Users\tanda\OneDrive\Bureau\sorefa\src\main\com\example\C_Installation.java
public class C_Installation {

    @FXML
    private Label lb_title;

    @FXML
    private Button bt_install;

    @FXML
    private TextField ed_host;

    @FXML
    private TextField ed_port;

    @FXML
    private TextField ed_user;

    @FXML
    private Label lb_host;

    @FXML
    private Label lb_port;

    @FXML
    private Label ld_user;

    @FXML
    private Label lb_dbName;

    @FXML
    private TextField ed_dbName;

    @FXML
    private Label lb_motPasse;

    @FXML
    private Label lb_motPasseConfirm;

    @FXML
    private PasswordField ed_motPasseConfirm;

    @FXML
    private PasswordField ed_motPasse;

    @FXML
    private Label lb_prefixe;

    @FXML
    private TextField ed_prefixe;

    private static String db_name;

    private static String db_password;

    private String db_host;

    private String db_port;

    private String db_user;

    private String db_passwordConfirm;

    private String db_prefixe;

    private JSONObject installInfo;

    // private File file = new File("doc/json/install.json");
    // private App mainControlApp;
    private BufferedReader bufferedReader = null;

    // test pdf
    // @FXML

    // public C_Installation(App unControleur) {
    // mainControlApp = unControleur;
    // // le constructeur

    @FXML
    void bt_installer(ActionEvent event) {

        // // recuperer les +db_+ saisies dans le formulaire
        db_name = ed_dbName.getText();
        db_host = ed_host.getText();
        db_port = ed_port.getText();
        db_user = ed_user.getText(); // nom d'utilisateur la base de donnée
        db_password = ed_motPasse.getText();
        db_passwordConfirm = ed_motPasseConfirm.getText();
        db_prefixe = ed_prefixe.getText();
        // String db_url = "jdbc:mysql://" + db_host + ":" + db_port + "/" + db_user;

        // this.mainControlApp.lireInfo();
        lireInfoConnect();

        // }
    }

    public void lireInfoConnect() {
        /**
         * lecture du fichier json
         */
        // BufferedReader bufferedReader = null;
        try {
            File file = new File("doc/json/install.json");
            FileReader fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader);
                String line = null;
                ecrireInfoInstall();
                System.out.println("fichier mis à jour");
                if ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                } else {
                    ecrireInfoInstall();
                    System.out.println("nouveau fichier créer");
                }
                // App.connexion("SELECT * FROM DB_DEPT;","dep");

            } catch (Exception e) {
                System.out.println("fichier non trouvé");
            }
            try {
                bufferedReader.close();
            } catch (Exception e) {
                System.out.println("impossible de fermer le fichier");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void ecrireInfoInstall() {
        installInfo = new JSONObject();
        installInfo.put("DB_NAME", db_name);
        installInfo.put("DB_HOST", db_host);
        installInfo.put("DB_PORT", db_port);
        installInfo.put("DB_USER", db_user);
        installInfo.put("DB_PASSWORD", db_password);
        installInfo.put("DB_PASSWORD_CONFIRM", db_passwordConfirm);
        installInfo.put("DB_PREFIX", db_prefixe);
        // ajout des info dans un tableau
        // JSONArray infoList = new JSONArray();
        // infoList.add(installInfo);
        // file.write(infoList.toJSONString());

        // /**
        // * Ecrire dans (ou créer)le fichier Json
        // *
        // */
        try (FileWriter file = new FileWriter("doc/json/install.json")) {

            file.write(installInfo.toJSONString());
            file.flush();

        } catch (Exception e) {
            System.out.println("fichier non créer");
        }
    }

}
