package fr.sorefa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;

public class M_Clients {

    // private final Db_mysql db;
    // private final IntegerProperty id_client;
    // private final StringProperty nom_client;
    // private final StringProperty prenom_client;
    // private final StringProperty siret_client;
    // private final BooleanProperty bool_entreprise;
    // private final StringProperty nom_entreprise;
    // private final FloatProperty num_tva_client;
    // private final ObjectProperty object;

    private Db_mysql db;
    private int id_client;
    private String nom_client;
    private String prenom_client;
    private String siret_client;
    private Boolean bool_entreprise;
    private String nom_entreprise;
    private Float num_tva_client;
    private String adresse1_client;
    private String adresse2_client;
    private String lieu_dit_client;
    private String cp_client;
    private String ville_client;
    private String tel_client;
    private String comment;
    private String date_create;
    private String date_update;
    private String code_statut;
    private String code_civilite;

    // private static ResultSet res;
    // public static ResultSet rs = res;
    // public static ObservableList<String> row;
    // public static ObservableList<M_Clients> data =
    // FXCollections.observableArrayList();

    public M_Clients(Db_mysql db, int id_client, String nom_client, String prenom_client, String siret_client,
            Boolean bool_entreprise,
            String nom_entreprise, Float num_tva_client, String adresse1_client,
            String adresse2_client, String lieu_dit_client,
            String cp_client, String ville_client, String tel_client, String comment, String date_create,
            /* String date_update, */String code_statut, String code_civilite)

    {
        this.db = db;
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.siret_client = siret_client;
        this.bool_entreprise = bool_entreprise;
        this.nom_entreprise = nom_entreprise;
        this.num_tva_client = num_tva_client;
        this.adresse1_client = adresse1_client;
        this.adresse2_client = adresse2_client;
        this.lieu_dit_client = lieu_dit_client;

        this.cp_client = cp_client;
        this.ville_client = ville_client;
        this.tel_client = tel_client;
        this.comment = comment;
        this.date_create = date_create;
        this.code_statut = code_statut;
        this.code_civilite = code_civilite;

    }

    public M_Clients(Db_mysql db, String nom_client, String prenom_client, String siret_client, Boolean bool_entreprise,
            String nom_entreprise, Float num_tva_client, String adresse1_client,
            String adresse2_client, String lieu_dit_client,
            String cp_client, String ville_client, String tel_client, String comment, String code_statut,
            String code_civilite) throws SQLException {
        this.db = db;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.siret_client = siret_client;
        this.bool_entreprise = bool_entreprise;
        this.nom_entreprise = nom_entreprise;
        this.num_tva_client = num_tva_client;
        this.lieu_dit_client = lieu_dit_client;
        this.adresse1_client = adresse1_client;
        this.adresse2_client = adresse2_client;
        this.cp_client = cp_client;
        this.ville_client = ville_client;
        this.tel_client = tel_client;
        this.comment = comment;
        this.code_statut = code_statut;
        this.code_civilite = code_civilite;

        String sql;
        sql = "INSERT INTO SO_CLIENT (nom_client, prenom_client, siret_client, bool_entreprise, nom_entreprise, num_tva_client,"
                + "adresse1_client,  adresse2_client, lieu_dit_client, cp_client, ville_client, tel_client, comment,code_statut , code_civilite) "
                + "VALUES ('" + nom_client + "', '" + prenom_client + "', '" + siret_client + "', " + bool_entreprise
                + ", '" + nom_entreprise + "', " + num_tva_client + ", '" + adresse1_client + "', '" + adresse2_client
                + "','" + lieu_dit_client + "', '" + cp_client + "', '" + ville_client + "', '" + tel_client
                + "', '" + comment + "',   '" + code_statut + "', '" + code_civilite + "');";
        db.sqlExec(sql);

        ResultSet res;
        res = db.sqlLastId();
        res.first();
        this.id_client = res.getInt("id");
    }
    // public M_Clients(Db_mysql db, int id_client, String nom_client, String
    // prenom_client, String siret_client,
    // Boolean bool_entreprise, String nom_entreprise, Float num_tva_client) {

    // this.db = db;
    // this.id_client = new SimpleIntegerProperty(id_client);
    // this.nom_client = new SimpleStringProperty("nom_client");
    // this.prenom_client = new SimpleStringProperty("prenom_client");
    // this.siret_client = new SimpleStringProperty("siret_client");
    // this.bool_entreprise = new SimpleBooleanProperty( bool_entreprise);
    // this.nom_entreprise = new SimpleStringProperty("nom_entreprise");
    // this.num_tva_client = new SimpleFloatProperty(num_tva_client);

    // }
    public M_Clients(Db_mysql db, int id_client) throws SQLException {
        this.db = db;
        this.id_client = id_client;
        String sql;
        sql = "SELECT * FROM SO_CLIENT WHERE id_client = " + id_client;
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        this.nom_client = res.getString("nom_client");
        this.prenom_client = res.getString("prenom_client");
        this.siret_client = res.getString("siret_client");
        this.bool_entreprise = res.getBoolean("bool_entreprise");
        this.nom_entreprise = res.getString("nom_entreprise");
        this.num_tva_client = Float.parseFloat(res.getString("num_tva_client"));
        this.adresse1_client = res.getString("adresse1_client");
        this.adresse2_client = res.getString("adresse2_client");
        this.lieu_dit_client = res.getString("lieu_dit_client");
        this.cp_client = res.getString("cp_client");
        this.ville_client = res.getString("ville_client");
        this.tel_client = res.getString("tel_client");
        this.comment = res.getString("comment");
        this.date_create = res.getString("date_create");
        // this.date_update = res.getString("date_update");
        this.code_statut = res.getString("code_statut");
        this.code_civilite = res.getString("code_civilite");

    }

    public void update() throws SQLException {
        String sql;

        sql = "UPDATE SO_CLIENT SET nom_client = '" + nom_client + "', prenom_client = '" + prenom_client
                + "', siret_client = '" + siret_client + "', bool_entreprise = " + bool_entreprise
                + ", nom_entreprise = '" + nom_entreprise + "', num_tva_client = " + num_tva_client
                + ", adresse1_client = '" + adresse1_client + "', adresse2_client = '" + adresse2_client
                + "', lieu_dit_client = '" + lieu_dit_client + "', cp_client ='" + cp_client
                + "',ville_client = '" + ville_client + "', tel_client = '" + tel_client
                + "', comment = '" + comment + "', code_statut = '" + code_statut + "',code_civilite = '"
                + code_civilite
                + "' "
                + "WHERE id_client = " + id_client;

        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql;
        sql = "DELETE FROM SO_CLIENT WHERE id_client = " + id_client;
        db.sqlExec(sql);
    }

    public int getId_client() {
        return id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public String getSiret_client() {
        return siret_client;
    }

    public boolean isBool_entreprise() {
        return bool_entreprise;
    }

    public String getNom_entreprise() {
        return nom_entreprise;
    }

    public Float getNum_tva_client() {
        return num_tva_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public void setSiret_client(String siret_client) {
        this.siret_client = siret_client;
    }

    public void setBool_entreprise(boolean bool_entreprise) {
        this.bool_entreprise = bool_entreprise;
    }

    public void setNom_entreprise(String nom_entreprise) {
        this.nom_entreprise = nom_entreprise;
    }

    public void setNum_tva_client(Float num_tva_client) {
        this.num_tva_client = num_tva_client;
    }

    public String getAdresse1_client() {
        return adresse1_client;
    }

    public void setAdresse1_client(String adresse1_client) {
        this.adresse1_client = adresse1_client;
    }

    public String getAdresse2_client() {
        return adresse2_client;
    }

    public void setAdresse2_client(String adresse2_client) {
        this.adresse2_client = adresse2_client;
    }

    public String getLieu_dit_client() {
        return lieu_dit_client;
    }

    public void setLieu_dit_client(String lieu_dit_client) {
        this.lieu_dit_client = lieu_dit_client;
    }

    public String getCp_client() {
        return cp_client;
    }

    public void setCp_client(String cp_client) {
        this.cp_client = cp_client;
    }

    public String getVille_client() {
        return ville_client;
    }

    public void setVille_client(String ville_client) {
        this.ville_client = ville_client;
    }

    public String getTel_client() {
        return tel_client;
    }

    public void setTel_client(String tel_client) {
        this.tel_client = tel_client;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getDate_update() {
        return date_update;
    }

    public void setDate_update(String date_update) {
        this.date_update = date_update;
    }

    public String getCode_statut() {
        return code_statut;
    }

    public void setCode_statut(String code_statut) {
        this.code_statut = code_statut;
    }

    public String getCode_civilite() {
        return code_civilite;
    }

    public void setCode_civilite(String code_civilite) {
        this.code_civilite = code_civilite;
    }

    public static LinkedHashMap<Integer, M_Clients> getRecords(Db_mysql db)
            throws SQLException {
        return getRecords(db, "1 = 1");
    }

    public static LinkedHashMap<Integer, M_Clients> getRecords(Db_mysql db, String clauseWhere) throws SQLException {
        LinkedHashMap<Integer, M_Clients> lesClients;
        lesClients = new LinkedHashMap<>();
        M_Clients unClient;
        Boolean bool_entreprise;
        int cle;
        Float num_tva_client;
        String nom_client, prenom_client,
                siret_client, nom_entreprise, adresse1_client,
                adresse2_client, cp_client, ville_client, tel_client, comment, lieu_dit_client;
        String date_create/* ,date_update */, code_civilite, code_statut;
        String sql;
        try {
            sql = "SELECT * FROM SO_CLIENT WHERE " + clauseWhere + " ORDER BY nom_client, prenom_client";
            ResultSet res = db.sqlSelect(sql);

            while (res.next()) {
                cle = Integer.parseInt(res.getString("id_client"));
                nom_client = res.getString("nom_client");
                prenom_client = res.getString("prenom_client");
                siret_client = res.getString("siret_client");
                bool_entreprise = res.getBoolean("bool_entreprise");
                nom_entreprise = res.getString("nom_entreprise");
                num_tva_client = res.getFloat("num_tva_client");
                adresse1_client = res.getString("adresse1_client");
                adresse2_client = res.getString("adresse2_client");
                lieu_dit_client = res.getString("lieu_dit_client");
                cp_client = res.getString("cp_client");
                ville_client = res.getString("ville_client");
                tel_client = res.getString("tel_client");
                comment = res.getString("comment");
                date_create = res.getString("date_create");
                // date_update = res.getString("date_update");
                code_statut = res.getString("code_statut");
                code_civilite = res.getString("code_civilite");

                unClient = new M_Clients(db, cle, nom_client, prenom_client, siret_client, bool_entreprise,
                        nom_entreprise,
                        num_tva_client, adresse1_client, adresse2_client, lieu_dit_client, cp_client,
                        ville_client, tel_client, comment, date_create, code_statut, code_civilite);
                lesClients.put(cle, unClient);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fin get records");
        return lesClients;

    }

    public void affiche() {
        System.out.println(id_client + " " + nom_client + " " + prenom_client + " " + nom_entreprise);
    }

    public static void main(String[] args) throws Exception {
        M_Clients unClient;
        Db_mysql maBase;
        Cl_Connection.connection();
        maBase = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);

        LinkedHashMap<Integer, M_Clients> lesClients;
        lesClients = M_Clients.getRecords(maBase);

        for (Integer uneCle : lesClients.keySet()) {
            unClient = lesClients.get(uneCle);
            unClient.affiche();
        }

    }

}
