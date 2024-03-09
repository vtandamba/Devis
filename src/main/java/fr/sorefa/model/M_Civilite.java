package fr.sorefa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

// import javafx.collections.FXCollections;
import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;

public class M_Civilite {
    private Db_mysql db;
    private String code_civilite;
    private String libelle_civilite;
    private String comment;
    private String date_create;
    private String date_update;

    public M_Civilite(Db_mysql db, String code_civilite, String libelle_civilite, String comment,
            String date_create, String date_update) {
        this.db = db;
        this.code_civilite = code_civilite;
        this.libelle_civilite = libelle_civilite;
        this.comment = comment;
        this.date_create = date_create;
        this.date_update = date_update;
    }

    public M_Civilite(Db_mysql db, String code_civilite) throws SQLException {
        this.db = db;
        this.code_civilite = code_civilite;
        String sql;

        sql = "SELECT * FROM SO_CIVILITE WHERE code_civilite = " + code_civilite;
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        // this.code_civilite = res.getString("code_civilite");
        this.libelle_civilite = res.getString("libelle_civilite");
        this.comment = res.getString("comment");
        this.date_create = res.getString("date_create");
        this.date_update = res.getString("date_update");

    }

    // public M_Civilite(Db_mysql db, String code_civilite, String libelle_civilite,
    // String comment, String date_create,
    // String date_update) throws SQLException {
    // this.db = db;
    // this.code_civilite = code_civilite;
    // this.libelle_civilite = libelle_civilite;
    // this.comment = comment;
    // this.date_create = date_create;
    // this.date_update = date_update;
    // String sql;

    // sql = "INSERT INTO SO_CIVILITE
    // (code_civilite,libelle_civilite,comment,date_create) "
    // + "VALUES ('" + code_civilite + "', '" + libelle_civilite + "', '" + comment
    // + "','" + date_create + "');";
    // db.sqlExec(sql);

    // ResultSet res;
    // res = db.sqlLastId();
    // res.first();
    // this.code_civilite = res.getString("id");

    // }

    public void update() throws SQLException {
        String sql;

        sql = "UPDATE SO_CIVILITE SET code_civilite = '" + code_civilite + "', libelle_civilite = '" + libelle_civilite
                + "', comment = '" + comment + "', date_create = '" + date_create
                + "WHERE code_civilite = '" + code_civilite;

        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql;
        sql = "DELETE FROM SO_CIVILITE WHERE code_civilite = " + code_civilite;
        db.sqlExec(sql);
    }

    public String getCode_civilite() {
        return code_civilite;
    }

    public void setCode_civilite(String code_civilite) {
        this.code_civilite = code_civilite;
    }

    public String getLibelle_civilite() {
        return libelle_civilite;
    }

    public void setLibelle_civilite(String libelle_civilite) {
        this.libelle_civilite = libelle_civilite;
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

    public static LinkedHashMap<String, M_Civilite> getRecords(Db_mysql db) throws Exception {
        return getRecords(db, "1 = 1");
    }

    public static LinkedHashMap<String, M_Civilite> getRecords(Db_mysql db, String clauseWhere) throws SQLException {
        LinkedHashMap<String, M_Civilite> lesCivilites;
        lesCivilites = new LinkedHashMap<>();

        M_Civilite uneCivilite;
        String code_civilite, libelle_civilite, comment;
        String date_create, date_update;
        String sql;
        try {
            sql = "SELECT * FROM SO_CIVILITE WHERE " + clauseWhere + " ORDER BY  libelle_civilite, comment";
            ResultSet res = db.sqlSelect(sql);

            while (res.next()) {

                code_civilite = res.getString("code_civilite");
                libelle_civilite = res.getString("libelle_civilite");
                comment = res.getString("comment");
                date_create = res.getString("date_create");
                date_update = res.getString("date_update");

                uneCivilite = new M_Civilite(db, code_civilite, libelle_civilite, comment, date_create, date_update);
                lesCivilites.put(code_civilite, uneCivilite);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fin getRecords civilités");
        return lesCivilites;

    }

    public void affiche() {
        System.out.println(
                code_civilite + " " + libelle_civilite + " " + comment + " " + date_create + " " + date_update);
    }

    public static void main(String[] args) throws Exception {
        M_Civilite uneCivilite;
        Db_mysql maBase;

        // _________________________________test getgetRecords avec

        Cl_Connection.connection();

        maBase = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);
        // uneCivilite = new M_Civilite(maBase, "1", "test_libelle", "no comment",
        // "2023-01-01", "2023-01-01");
        LinkedHashMap<String, M_Civilite> lesCivilites;
        lesCivilites = M_Civilite.getRecords(maBase);

        for (String uneCle : lesCivilites.keySet()) {
            uneCivilite = lesCivilites.get(uneCle);
            uneCivilite.affiche();
        }
        // ______________________________fin test getRecordss_______________________
    }

}