package fr.sorefa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;

public class M_Statut {
    private Db_mysql db;
    private String code_statut;
    private String libelle_statut;
    private String comment;
    private String date_create;
    private String date_update;

    public M_Statut(Db_mysql db, String code_statut, String libelle_statut, String comment, String date_create,
            String date_update) throws SQLException {
        this.db = db;
        this.code_statut = code_statut;
        this.libelle_statut = libelle_statut;
        this.comment = comment;
        this.date_create = date_create;
        this.date_update = date_update;
    }

    public M_Statut(Db_mysql db, String code_statut) throws SQLException {
        this.db = db;
        this.code_statut = code_statut;

        String sql;

        sql = "SELECT * FROM SO_STATUT WHERE code_statut = " + code_statut;
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        // this.code_statut = res.getString("code_statut");
        this.libelle_statut = res.getString("libelle_statut");
        this.comment = res.getString("comment");
        this.date_create = res.getString("date_create");
        this.date_update = res.getString("date_update");
    }

    // public M_Statut(Db_mysql db, String code_statut, String libelle_statut,
    // String comment, String date_create,
    // String date_update) throws SQLException {
    // this.db = db;
    // this.code_statut = code_statut;
    // this.libelle_statut = libelle_statut;
    // this.comment = comment;
    // this.date_create = date_create;
    // this.date_update = date_update;

    // String sql;

    // sql = "INSERT INTO SO_STATUT(code_statut,libelle_statut,comment,date_create)
    // "
    // + "VALUES ('" +code_statut+ "', '" + libelle_statut+ "', '" + comment + "',
    // '" + date_create + "');";
    // db.sqlExec(sql);

    // ResultSet res;
    // res = db.sqlLastId();
    // res.first();
    // this.code_statut= res.getString("id");

    // }

    public void update() throws SQLException {
        String sql;

        sql = "UPDATE SO_STATUT SET code_statut = '" + code_statut + "', libelle_statut = '" + libelle_statut
                + "', comment = '" + comment + "', date_create = '" + date_create
                + "WHERE code_statut = " + code_statut;

        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql;
        sql = "DELETE FROM SO_STATUT WHERE code_statut = " + code_statut;
        db.sqlExec(sql);
    }

    public String getCode_statut() {
        return code_statut;
    }

    public void setCode_statut(String code_statut) {
        this.code_statut = code_statut;
    }

    public String getLibelle_statut() {
        return libelle_statut;
    }

    public void setLibelle_statut(String libelle_statut) {
        this.libelle_statut = libelle_statut;
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

    public static LinkedHashMap<String, M_Statut> getRecords(Db_mysql db) throws Exception {
        return getRecords(db, "1 = 1");
    }

    public static LinkedHashMap<String, M_Statut> getRecords(Db_mysql db, String clauseWhere) throws SQLException {
        LinkedHashMap<String, M_Statut> lesStatuts;
        lesStatuts = new LinkedHashMap<>();

        M_Statut unStatut;
        String code_statut, libelle_statut, comment;
        String date_create, date_update;
        String sql;
        try {
            sql = "SELECT * FROM SO_STATUT WHERE " + clauseWhere + " ORDER BY  libelle_statut, comment";
            ResultSet res = db.sqlSelect(sql);

            while (res.next()) {

                code_statut = res.getString("code_statut");
                libelle_statut = res.getString("libelle_statut");
                comment = res.getString("comment");
                date_create = res.getString("date_create");
                date_update = res.getString("date_update");

                unStatut = new M_Statut(db, code_statut, libelle_statut, comment, date_create, date_update);
                lesStatuts.put(code_statut, unStatut);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fin getRecords statuts");
        return lesStatuts;

    }
    //

    public void affiche() {
        System.out.println(code_statut + " " + libelle_statut + " " + comment + " " + date_create + " " + date_update);
    }

    public static void main(String[] args) throws Exception {
        M_Statut unStatut;
        Db_mysql maBase;

        // _________________________________test getgetRecords avec

        Cl_Connection.connection();

        maBase = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);
        // unStatut = new M_Statut(maBase, "1", "test_libelle", "no comment",
        // "2023-01-01", "2023-01-01");
        LinkedHashMap<String, M_Statut> lesStatuts;
        lesStatuts = M_Statut.getRecords(maBase);

        for (String uneCle : lesStatuts.keySet()) {
            unStatut = lesStatuts.get(uneCle);
            unStatut.affiche();
        }
        // ______________________________fin test getRecords_______________________
    }

}