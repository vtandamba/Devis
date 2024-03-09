package fr.sorefa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;

public class M_Composer {
    private Db_mysql db;
    private int id_produit_mix;
    private int id_produit_composant;
    private int ordre_mix;
    private float qte_mix;
    private String comment, libelle_produit;
    private String date_create;
    private String date_update;

    public M_Composer(Db_mysql db, int id_produit_mix, int id_produit_composant, int ordre_mix, float qte_mix,
            String comment, String date_create, String date_update) {
        this.db = db;
        this.id_produit_mix = id_produit_mix;
        this.id_produit_composant = id_produit_composant;
        this.ordre_mix = ordre_mix;
        this.qte_mix = qte_mix;
        this.comment = comment;
        this.date_create = date_create;
        this.date_update = date_update;

    }

    public M_Composer(Db_mysql db, int id_produit_mix, int id_produit_composant, int ordre_mix, float qte_mix,
            String comment) throws SQLException {
        this.db = db;
        this.id_produit_mix = id_produit_mix;
        this.id_produit_composant = id_produit_composant;
        this.ordre_mix = ordre_mix;
        this.qte_mix = qte_mix;
        this.comment = comment;
        String sql;
        sql = " INSERT INTO SO_COMPOSER ( `id_produit_mix`, `id_produit_composant`, `ordre_mix`, `qte_mix`, `comment`)"
                + "VALUES(" + id_produit_mix + "," + id_produit_composant + "," + ordre_mix + "," + qte_mix + ",'"
                + comment + "')";
        db.sqlExec(sql);

        ResultSet res;
        res = db.sqlLastId();
        res.first();
        this.id_produit_mix = res.getInt("id");
    }

    public M_Composer(Db_mysql db, int id_produit_mix, int id_produit_composant) throws SQLException {
        this.db = db;
        this.id_produit_mix = id_produit_mix;
        this.id_produit_composant = id_produit_composant;
        String sql;

        sql = "SELECT * FROM SO_COMPOSER WHERE id_produit_mix = " + id_produit_mix
                + " AND id_produit_composant =" + id_produit_composant;
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        this.ordre_mix = Integer.parseInt(res.getString("ordre_mix"));
        this.qte_mix = Integer.parseInt(res.getString("qte_mix"));
        this.comment = res.getString("comment");
        this.date_create = res.getString("date_create");
        this.date_update = res.getString("date_update");
    }

    public void update() throws SQLException {
        String sql;

        sql = "UPDATE SO_COMPOSER SET ordre_mix = " + ordre_mix + ", qte_mix = " + qte_mix
                + ", comment = '" + comment
                + "' WHERE id_produit_composant =" + id_produit_composant
                + " AND id_produit_mix = " + id_produit_mix;
        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql;
        sql = "DELETE FROM SO_COMPOSER WHERE id_produit_mix = " + id_produit_mix
                + " AND id_produit_composant = " + id_produit_composant;
        db.sqlExec(sql);
    }

    public int getId_produit_mix() {
        return id_produit_mix;
    }

    public void setId_produit_mix(int id_produit_mix) {
        this.id_produit_mix = id_produit_mix;
    }

    public int getId_produit_composant() {
        return id_produit_composant;
    }

    public void setId_produit_composant(int id_produit_composant) {
        this.id_produit_composant = id_produit_composant;
    }

    public int getOrdre_mix() {
        return ordre_mix;
    }

    public void setOrdre_mix(int ordre_mix) {
        this.ordre_mix = ordre_mix;
    }

    public float getQte_mix() {
        return qte_mix;
    }

    public void setQte_mix(float qte_mix) {
        this.qte_mix = qte_mix;
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

    public static LinkedHashMap<Integer, M_Composer> getRecords(Db_mysql db) throws Exception {
        return getRecords(db, "1=1");
    }

    public static LinkedHashMap<Integer, M_Composer> getRecords(Db_mysql db, String clauseWhere) throws SQLException {
        LinkedHashMap<Integer, M_Composer> lesCompos;
        lesCompos = new LinkedHashMap<>();

        M_Composer uneCompos;
        int cle, cle1, ordre_mix;
        String comment, date_create, date_update, sql, libelle, id;
        float qte_mix;

        try {
            // Requête SQL pour récupérer les données de la table Compose et de la table
            // Produit

            // jointure afin de recupérer le libellé
            sql = "SELECT * " +
                    "FROM SO_COMPOSER c " +
                    "JOIN SO_PRODUIT p ON c.id_produit_mix = p.id_produit or c.id_produit_composant = p.id_produit WHERE "
                    + clauseWhere;

            // sql = "SELECT * FROM SO_COMPOSER WHERE " + clauseWhere + " ORDER BY
            // ordre_mix, comment";
            // recuperer tout les produits d'un composé par la clauseWhere
            ResultSet res = db.sqlSelect(sql);

            while (res.next()) {
                cle = Integer.parseInt(res.getString("id_produit_mix"));
                cle1 = Integer.parseInt(res.getString("id_produit_composant"));
                ordre_mix = Integer.parseInt(res.getString("ordre_mix"));
                qte_mix = res.getFloat("qte_mix");
                comment = res.getString("comment");
                libelle = res.getString("libelle_produit");
                date_create = res.getString("date_create");
                date_update = res.getString("date_update");

                uneCompos = new M_Composer(db, cle, cle1, ordre_mix, qte_mix, comment, date_create, date_update);
                lesCompos.put(cle - cle1, uneCompos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fin getRecords statuts");
        return lesCompos;

    }

    public void affiche() {
        System.out
                .println(id_produit_mix + " " + id_produit_composant + " " + qte_mix + " " + comment + " " + ordre_mix
                        + " " + libelle_produit);
    }

    public static void main(String[] args) throws Exception {
        M_Composer uneCompos;
        Db_mysql maBase;
        Cl_Connection.connection();
        maBase = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);

        LinkedHashMap<Integer, M_Composer> lesClients;
        lesClients = M_Composer.getRecords(maBase);

        for (Integer uneCle : lesClients.keySet()) {
            uneCompos = lesClients.get(uneCle);
            uneCompos.affiche();
        }

    }
}
