package fr.sorefa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;

public class M_Taux_tva {
    private Db_mysql db;
    private int id_tva;
    private Float taux_tva;
    private String comment;
    private String date_create;
    private String date_update;

    public M_Taux_tva(Db_mysql db, int id_tva, Float taux_tva, String comment,
            String date_create, String date_update) {
        this.db = db;
        this.id_tva = id_tva;
        this.taux_tva = taux_tva;
        this.comment = comment;
        this.date_create = date_create;
        this.date_update = date_update;
    }

    public M_Taux_tva(Db_mysql db, int id_tva) throws SQLException {
        this.db = db;
        this.id_tva = id_tva;
        String sql;

        sql = "SELECT * FROM SO_TAUX_TVA WHERE id_tva = " + id_tva;
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        this.taux_tva = res.getFloat("taux_tva");
        this.comment = res.getString("comment");
        this.date_create = res.getString("date_create");

    }

    public M_Taux_tva(Db_mysql db, Float taux_tva, String comment) throws SQLException {
        this.db = db;
        this.taux_tva = taux_tva;
        this.comment = comment;
        String sql;

        sql = "INSERT INTO SO_TAUX_TVA (taux_tva,comment) "
                + "VALUES (" + taux_tva + ", '" + comment + "');";
        db.sqlExec(sql);

        ResultSet res;
        res = db.sqlLastId();
        res.first();
        this.id_tva = Integer.parseInt(res.getString("id"));

    }

    public void update() throws SQLException {
        String sql;

        sql = "UPDATE SO_TAUX_TVA SET taux_tva = " + taux_tva
                + ", comment = '" + comment
                + "WHERE id_tva = '" + id_tva;

        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql;
        sql = "DELETE FROM SO_TAUX_TVA WHERE id_tva = " + id_tva;
        db.sqlExec(sql);
    }

    public int getid_tva() {
        return id_tva;
    }

    public void setid_tva(int id_tva) {
        this.id_tva = id_tva;
    }

    public Float getTaux_tva() {
        return taux_tva;
    }

    public void setTaux_tva(Float taux_tva) {
        this.taux_tva = taux_tva;
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

    public static LinkedHashMap<Integer, M_Taux_tva> getRecords(Db_mysql db) throws Exception {
        return getRecords(db, "1 = 1");
    }

    public static LinkedHashMap<Integer, M_Taux_tva> getRecords(Db_mysql db, String clauseWhere) throws SQLException {
        LinkedHashMap<Integer, M_Taux_tva> lesTaux_tva;
        lesTaux_tva = new LinkedHashMap<>();

        M_Taux_tva unTauxTva;
        int cle;
        String date_create, date_update, sql, comment;
        Float taux_tva;

        try {
            sql = "SELECT * FROM SO_TAUX_TVA WHERE " + clauseWhere + " ORDER BY  taux_tva, comment";
            ResultSet res = db.sqlSelect(sql);

            while (res.next()) {

                cle = Integer.parseInt(res.getString("id_tva"));
                taux_tva = res.getFloat("taux_tva");
                comment = res.getString("comment");
                date_create = res.getString("date_create");
                date_update = res.getString("date_update");

                unTauxTva = new M_Taux_tva(db, cle, taux_tva, comment, date_create, date_update);
                lesTaux_tva.put(cle, unTauxTva);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fin getRecords tva");
        return lesTaux_tva;

    }

    public void affiche() {
        System.out.println(id_tva + " " + taux_tva + " " + comment + " " + date_create + " " + date_update);
    }

    public static void main(String[] args) throws Exception {
        M_Taux_tva unTauxTva;
        Db_mysql maBase;

        // _________________________________test getgetRecords avec

        Cl_Connection.connection();

        maBase = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);
        // unTauxTva = new M_Taux_tva(maBase, "1", "test_libelle", "no comment",
        // "2023-01-01", "2023-01-01");
        LinkedHashMap<Integer, M_Taux_tva> lesTaux_tva;
        lesTaux_tva = M_Taux_tva.getRecords(maBase);

        for (Integer uneCle : lesTaux_tva.keySet()) {
            unTauxTva = lesTaux_tva.get(uneCle);
            unTauxTva.affiche();
        }
        // ______________________________fin test getRecordss_______________________
    }

}