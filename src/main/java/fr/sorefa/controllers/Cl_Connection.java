package fr.sorefa.controllers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Cl_Connection {

    private static String db_host;

    private static String db_port;
    // private String db_name;
    // private String db_password;
    // private String db_url;
    private static String db_user;

    private static String db_passwordConfirm;

    private static String db_prefixe;

    private static Db_mysql baseSo;

    public static String url;
    public static String login;
    public static String password;

    private static String db_name;
    private static String db_password;
    private static String db_url;

    // public static String url = db_url;
    // public static String login = db_name;
    // public static String password = db_password;
    @FXML
    void ok(ActionEvent event) throws Exception {
        // connection();
        System.out.println(Cl_Connection.db_password);
    }

    public static void connection() throws Exception {
        JSONParser jsonP = new JSONParser();
        try {

            // faire la connexion avec la base de donnée
            // lecture du fichier install.json//recuperation des

            JSONObject jsonO = (JSONObject) jsonP.parse(new FileReader("doc/json/install.json"));

            db_user = (String) jsonO.get("DB_USER");
            db_password = (String) jsonO.get("DB_PASSWORD");
            db_host = (String) jsonO.get("DB_HOST");
            db_port = (String) jsonO.get("DB_PORT");
            db_name = (String) jsonO.get("DB_NAME");
            // public static String url = "//falbala.futaie.org:3306/tandambav";
            db_url = "//" + db_host + ":" + db_port + "/" + db_user;
            url = db_url;
            login = db_name;
            password = db_password;

            try {
                baseSo = new Db_mysql(url, login, password);
                System.out.println("Connection réussi");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();

                System.out.println("connection impossible");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
