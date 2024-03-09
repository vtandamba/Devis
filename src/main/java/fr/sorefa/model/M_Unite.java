package fr.sorefa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

// import javafx.collections.FXCollections;
import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;

public class M_Unite {

    private Db_mysql db;
    private String code_unite;
    private String libelle_unite;
    private String comment;
    private String date_create;
    private String date_update;

    public M_Unite(Db_mysql db, String code_unite, String libelle_unite, String comment,
            String date_create, String date_update) {
        this.db = db;
        this.code_unite = code_unite;
        this.libelle_unite = libelle_unite;
        this.comment = comment;
        this.date_create = date_create;
        this.date_update = date_update;
    }

    public M_Unite(Db_mysql db, String code_unite) throws SQLException {
        this.db = db;
        this.code_unite = code_unite;
        String sql;

        sql = "SELECT * FROM SO_UNITE WHERE code_unite = " + code_unite;
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        // this.code_unite = res.getString("code_unite");
        this.libelle_unite = res.getString("libelle_unite");
        this.comment = res.getString("comment");
        this.date_create = res.getString("date_create");
        this.date_update = res.getString("date_update");

    }

    // public M_Unite(Db_mysql db, String code_unite, String libelle_unite, String
    // comment, String date_create,
    // String date_update) throws SQLException {
    // this.db = db;
    // this.code_unite = code_unite;
    // this.libelle_unite = libelle_unite;
    // this.comment = comment;
    // this.date_create = date_create;
    // this.date_update = date_update;
    // String sql;

    // sql = "INSERT INTO SO_UNITE (code_unite,libelle_unite,comment,date_create) "
    // + "VALUES ('" + code_unite + "', '" + libelle_unite + "', '" + comment +
    // "','" + date_create + "');";
    // db.sqlExec(sql);

    // ResultSet res;
    // res = db.sqlLastId();
    // res.first();
    // this.code_unite = res.getString("id");

    // }

    public void update() throws SQLException {
        String sql;

        sql = "UPDATE SO_UNITE SET code_unite = '" + code_unite + "', libelle_unite = '" + libelle_unite
                + "', comment = '" + comment + "', date_create = '" + date_create
                + "WHERE code_unite = '" + code_unite;

        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql;
        sql = "DELETE FROM SO_UNITE WHERE code_unite = " + code_unite;
        db.sqlExec(sql);
    }

    public String getCode_unite() {
        return code_unite;
    }

    public void setCode_unite(String code_unite) {
        this.code_unite = code_unite;
    }

    public String getLibelle_unite() {
        return libelle_unite;
    }

    public void setLibelle_unite(String libelle_unite) {
        this.libelle_unite = libelle_unite;
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

    public static LinkedHashMap<String, M_Unite> getRecords(Db_mysql db) throws Exception {
        return getRecords(db, "1 = 1");
    }

    public static LinkedHashMap<String, M_Unite> getRecords(Db_mysql db, String clauseWhere) throws SQLException {
        LinkedHashMap<String, M_Unite> lesUnites;
        lesUnites = new LinkedHashMap<>();

        M_Unite uneUnite;
        String code_unite, libelle_unite, comment;
        String date_create, date_update;
        String sql;
        try {
            sql = "SELECT * FROM SO_UNITE WHERE " + clauseWhere + " ORDER BY  libelle_unite, comment";
            ResultSet res = db.sqlSelect(sql);

            while (res.next()) {

                code_unite = res.getString("code_unite");
                libelle_unite = res.getString("libelle_unite");
                comment = res.getString("comment");
                date_create = res.getString("date_create");
                date_update = res.getString("date_update");

                uneUnite = new M_Unite(db, code_unite, libelle_unite, comment, date_create, date_update);
                lesUnites.put(code_unite, uneUnite);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fin getRecords unite");
        return lesUnites;

    }

    public void affiche() {
        System.out.println(code_unite + " " + libelle_unite + " " + comment + " " + date_create + " " + date_update);
    }

    public static void main(String[] args) throws Exception {
        M_Unite uneUnite;
        Db_mysql maBase;

        // _________________________________test getgetRecords avec

        Cl_Connection.connection();

        maBase = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);
        // uneUnite = new M_Unite(maBase, "1", "test_libelle", "no comment",
        // "2023-01-01", "2023-01-01");
        LinkedHashMap<String, M_Unite> lesUnites;
        lesUnites = M_Unite.getRecords(maBase);

        for (String uneCle : lesUnites.keySet()) {
            uneUnite = lesUnites.get(uneCle);
            uneUnite.affiche();
        }
        // ______________________________fin test getRecordss_______________________
    }

}
