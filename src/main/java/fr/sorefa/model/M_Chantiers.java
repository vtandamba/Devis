package fr.sorefa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;
import javafx.collections.FXCollections;

public class M_Chantiers {

    private Db_mysql db;
    private int id_chantier;
    private String libelle_chantier;
    private String adresse1_chantier;
    private String adresse2_chantier;
    private String lieu_dit_chantier;
    private String cp_chantier;
    private String ville_chantier;
    private String description_chantier;
    private String comment;
    private String date_create;
    private String date_update;
    private int id_client;

    public M_Chantiers(Db_mysql db, int id_chantier) throws NumberFormatException, SQLException {
        this.db = db;
        this.id_chantier = id_chantier;

        String sql;
        sql = "SELECT * FROM SO_CHANTIER WHERE id_chantier = " + id_chantier;
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        this.libelle_chantier = res.getString("libelle_chantier");
        this.adresse1_chantier = res.getString("adresse1_chantier");
        this.adresse2_chantier = res.getString("adresse2_chantier");
        this.lieu_dit_chantier = res.getString("lieu_dit_chantier");
        this.cp_chantier = res.getString("cp_chantier");
        this.ville_chantier = res.getString("ville_chantier");
        this.description_chantier = res.getString("description_chantier");
        this.comment = res.getString("comment");
        this.date_create = res.getString("date_create");
        this.date_update = res.getString("date_update");
        this.id_client = Integer.parseInt(res.getString("id_client"));

    }

    public M_Chantiers(Db_mysql db, String libelle_chantier, String adresse1_chantier, String adresse2_chantier,
            String lieu_dit_chantier, String cp_chantier, String ville_chantier, String description_chantier,
            String comment, String date_create, String date_update, int id_client) throws SQLException {
        this.db = db;
        this.libelle_chantier = libelle_chantier;
        this.adresse1_chantier = adresse1_chantier;
        this.adresse2_chantier = adresse2_chantier;
        this.lieu_dit_chantier = lieu_dit_chantier;
        this.cp_chantier = cp_chantier;
        this.ville_chantier = ville_chantier;
        this.description_chantier = description_chantier;
        this.comment = comment;
        this.date_create = date_create;
        this.date_update = date_update;
        this.id_client = id_client;

        String sql;
        sql = "INSERT INTO SO_CHANTIER (libelle_chantier, adresse1_chantier, lieu_dit_chantier, cp_chantier, ville_chantier, description_chantier,"
                + "comment,  date_create, date_update, id_client) "
                + "VALUES ('" + libelle_chantier + "', '" + adresse1_chantier + "', '" + lieu_dit_chantier + "', "
                + cp_chantier
                + ", '" + ville_chantier + "', " + description_chantier + ", '" + comment + "', '" + date_create
                + "', '" + date_update + "'," + id_client + ");";
        db.sqlExec(sql);

        ResultSet res;
        res = db.sqlLastId();
        res.first();
        this.id_client = res.getInt("id_chantier");
    }

    public M_Chantiers(Db_mysql db, int id_chantier, String libelle_chantier, String adresse1_chantier,
            String adresse2_chantier, String lieu_dit_chantier, String cp_chantier, String ville_chantier,
            String description_chantier, String comment, String date_create, String date_update, int id_client) {
        this.db = db;
        this.id_chantier = id_chantier;
        this.libelle_chantier = libelle_chantier;
        this.adresse1_chantier = adresse1_chantier;
        this.adresse2_chantier = adresse2_chantier;
        this.lieu_dit_chantier = lieu_dit_chantier;
        this.cp_chantier = cp_chantier;
        this.ville_chantier = ville_chantier;
        this.description_chantier = description_chantier;
        this.comment = comment;
        this.date_create = date_create;
        this.date_update = date_update;
        this.id_client = id_client;
    }

    public void update() throws SQLException {
        String sql;

        sql = "UPDATE SO_CHANTIER SET libelle_chantier = '" + libelle_chantier + "', adresse1_chantier = '"
                + adresse1_chantier
                + "', adresse2_chantier = '" + adresse2_chantier + ", lieu_dit_chantier = '" + lieu_dit_chantier
                + "', cp_chantier = '" + cp_chantier + "', ville_chantier = '" + ville_chantier
                + "', description_chantier ='" + description_chantier + "',comment = '" + comment
                + "',date_update = '" + date_update + "', id_client = " + id_client
                + "WHERE id_chantier = " + id_chantier;

        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql;
        sql = "DELETE FROM SO_CHANTIER WHERE id_chantier = " + id_chantier;
        db.sqlExec(sql);
    }

    public int getId_chantier() {
        return id_chantier;
    }

    public void setId_chantier(int id_chantier) {
        this.id_chantier = id_chantier;
    }

    public String getLibelle_chantier() {
        return libelle_chantier;
    }

    public void setLibelle_chantier(String libelle_chantier) {
        this.libelle_chantier = libelle_chantier;
    }

    public String getAdresse1_chantier() {
        return adresse1_chantier;
    }

    public void setAdresse1_chantier(String adresse1_chantier) {
        this.adresse1_chantier = adresse1_chantier;
    }

    public String getAdresse2_chantier() {
        return adresse2_chantier;
    }

    public void setAdresse2_chantier(String adresse2_chantier) {
        this.adresse2_chantier = adresse2_chantier;
    }

    public String getLieu_dit_chantier() {
        return lieu_dit_chantier;
    }

    public void setLieu_dit_chantier(String lieu_dit_chantier) {
        this.lieu_dit_chantier = lieu_dit_chantier;
    }

    public String getCp_chantier() {
        return cp_chantier;
    }

    public void setCp_chantier(String cp_chantier) {
        this.cp_chantier = cp_chantier;
    }

    public String getVille_chantier() {
        return ville_chantier;
    }

    public void setVille_chantier(String ville_chantier) {
        this.ville_chantier = ville_chantier;
    }

    public String getDescription_chantier() {
        return description_chantier;
    }

    public void setDescription_chantier(String description_chantier) {
        this.description_chantier = description_chantier;
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

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public static LinkedHashMap<Integer, M_Chantiers> getRecords(Db_mysql db) throws Exception {
        db = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);

        return getRecords(db, "1 = 1");
    }

    public static LinkedHashMap<Integer, M_Chantiers> getRecords(Db_mysql db, String clauseWhere) throws SQLException {
        LinkedHashMap<Integer, M_Chantiers> lesChantiers;
        lesChantiers = new LinkedHashMap<>();

        M_Chantiers unChantier;
        int cle, id_client;
        String libelle_chantier, adresse1_chantier, adresse2_chantier, lieu_dit_chantier, cp_chantier, ville_chantier,
                description_chantier, comment, date_create, date_update;
        String sql;
        try {
            sql = "SELECT * FROM SO_CHANTIER WHERE " + clauseWhere + " ORDER BY libelle_chantier, adresse1_chantier";
            ResultSet res = db.sqlSelect(sql);

            while (res.next()) {
                cle = Integer.parseInt(res.getString("id_chantier"));
                libelle_chantier = res.getString("libelle_chantier");
                adresse1_chantier = res.getString("adresse1_chantier");
                adresse2_chantier = res.getString("adresse2_chantier");
                lieu_dit_chantier = res.getString("lieu_dit_chantier");
                cp_chantier = res.getString("cp_chantier");
                ville_chantier = res.getString("ville_chantier");
                description_chantier = res.getString("description_chantier");
                comment = res.getString("comment");
                date_create = res.getString("date_create");
                date_update = res.getString("date_update");
                id_client = Integer.parseInt(res.getString("id_client"));

                unChantier = new M_Chantiers(db, cle, libelle_chantier, adresse1_chantier, adresse2_chantier,
                        lieu_dit_chantier, cp_chantier, ville_chantier, description_chantier, comment, date_create,
                        date_update, id_client);
                lesChantiers.put(cle, unChantier);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fin records chantier");
        return lesChantiers;

    }

    public void affiche() {
        System.out.println(id_chantier + " " + libelle_chantier + " " + lieu_dit_chantier + " " + description_chantier);
    }

    public static void main(String[] args) throws Exception {
        M_Chantiers unChantier;
        Db_mysql maBase;
        Cl_Connection.connection();
        maBase = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);

        LinkedHashMap<Integer, M_Chantiers> lesChantiers;
        lesChantiers = M_Chantiers.getRecords(maBase);

        for (Integer uneCle : lesChantiers.keySet()) {
            unChantier = lesChantiers.get(uneCle);
            unChantier.affiche();
        }
    }

}
