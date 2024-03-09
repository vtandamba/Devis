package fr.sorefa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;

public class M_Produits {

    private Db_mysql db;
    private int id_produit;
    private String libelle_produit;
    private String commentaire_produit;
    private Float prix_achat;
    private String formule_calcul;
    private Float prix_produit;
    private String commentaire_calcul;
    private String comment;
    private String date_update;
    private String date_create;
    private int id_tva, nb_produit;

    public int getNb_produit() {
        return nb_produit;
    }

    public void setNb_produit(int nb_produit) {
        this.nb_produit = nb_produit;
    }

    private String code_unite;

    public M_Produits(Db_mysql db, int nb_produit, int id_produit, String libelle_produit, String commentaire_produit,
            Float prix_achat,
            String formule_calcul, Float prix_produit, String commentaire_calcul, String comment, String date_create,
            int id_tva, String code_unite) {
        this.db = db;
        this.id_produit = id_produit;
        this.nb_produit = nb_produit;
        this.libelle_produit = libelle_produit;
        this.commentaire_produit = commentaire_produit;
        this.prix_achat = prix_achat;
        this.formule_calcul = formule_calcul;
        this.prix_produit = prix_produit;
        this.commentaire_calcul = commentaire_calcul;
        this.comment = comment;
        this.date_create = date_create;
        this.id_tva = id_tva;
        this.code_unite = code_unite;
    }

    public M_Produits(Db_mysql db, int id_produit) throws SQLException {
        this.db = db;
        this.id_produit = id_produit;
        String sql;
        sql = "SELECT * FROM SO_PRODUIT WHERE id_produit = " + id_produit;
        ResultSet res;
        res = db.sqlSelect(sql);
        res.first();
        libelle_produit = res.getString("libelle_produit");
        commentaire_produit = res.getString("commentaire_produit");
        prix_achat = res.getFloat("prix_achat");
        formule_calcul = res.getString("formule_calcul");
        prix_produit = res.getFloat("prix_produit");
        commentaire_calcul = res.getString("commentaire_calcul");
        comment = res.getString("comment");
        date_create = res.getString("date_create");
        id_tva = Integer.parseInt(res.getString("id_tva"));
        code_unite = res.getString("code_unite");

    }

    public M_Produits(Db_mysql db, String libelle_produit, String commentaire_produit, Float prix_achat,
            String formule_calcul, Float prix_produit, String commentaire_calcul, String comment, int id_tva,
            String code_unite) throws SQLException {
        this.db = db;
        this.libelle_produit = libelle_produit;
        this.commentaire_produit = commentaire_produit;
        this.prix_achat = prix_achat;
        this.formule_calcul = formule_calcul;
        this.prix_produit = prix_produit;
        this.commentaire_calcul = commentaire_calcul;
        this.comment = comment;
        this.id_tva = id_tva;
        this.code_unite = code_unite;
        // INSERT
        String sql;
        sql = "INSERT INTO SO_PRODUIT (libelle_produit, commentaire_produit, prix_achat, formule_calcul, prix_produit, commentaire_calcul,"
                + "comment,  id_tva, code_unite) "
                + "VALUES ('" + libelle_produit + "', '" + commentaire_produit + "', " + prix_achat + ", '"
                + formule_calcul
                + "', " + prix_produit + ", '" + commentaire_calcul + "', '" + comment + "', " + id_tva
                + ",'" + code_unite + "');";
        db.sqlExec(sql);

        ResultSet res;
        res = db.sqlLastId();
        res.first();
        this.id_produit = res.getInt("id");
    }

    public void update() throws SQLException {
        String sql;

        sql = "UPDATE SO_PRODUIT SET libelle_produit = '" + libelle_produit + "', commentaire_produit = '"
                + commentaire_produit
                + "', prix_achat = " + prix_achat + ", formule_calcul = '" + formule_calcul
                + "', prix_produit = " + prix_produit + ", commentaire_calcul = '" + commentaire_calcul
                + "', comment = '" + comment + "', id_tva = " + id_tva
                + ", code_unite = '" + code_unite
                + "' "
                + "WHERE id_produit = " + id_produit;

        db.sqlExec(sql);
    }

    public void delete() throws SQLException {
        String sql;
        sql = "DELETE FROM SO_PRODUIT WHERE id_produit = " + id_produit;
        db.sqlExec(sql);
    }

    public String getLibelle_produit() {
        return libelle_produit;
    }

    public void setLibelle_produit(String libelle_produit) {
        this.libelle_produit = libelle_produit;
    }

    public String getCommentaire_produit() {
        return commentaire_produit;
    }

    public void setCommentaire_produit(String commentaire_produit) {
        this.commentaire_produit = commentaire_produit;
    }

    public Float getPrix_achat() {
        return prix_achat;
    }

    public void setPrix_achat(Float prix_achat) {
        this.prix_achat = prix_achat;
    }

    public String getFormule_calcul() {
        return formule_calcul;
    }

    public void setFormule_calcul(String formule_calcul) {
        this.formule_calcul = formule_calcul;
    }

    public Float getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(Float prix_produit) {
        this.prix_produit = prix_produit;
    }

    public String getCommentaire_calcul() {
        return commentaire_calcul;
    }

    public void setCommentaire_calcul(String commentaire_calcul) {
        this.commentaire_calcul = commentaire_calcul;
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

    public int getId_tva() {
        return id_tva;
    }

    public void setId_tva(int id_tva) {
        this.id_tva = id_tva;
    }

    public String getCode_unite() {
        return code_unite;
    }

    public void setCode_unite(String code_unite) {
        this.code_unite = code_unite;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public static LinkedHashMap<Integer, M_Produits> getRecords(Db_mysql db)
            throws SQLException {
        return getRecords(db, "1 = 1");
    }

    public static LinkedHashMap<Integer, M_Produits> getRecords(Db_mysql db, String clauseWhere) throws SQLException {
        LinkedHashMap<Integer, M_Produits> lesProduits;
        lesProduits = new LinkedHashMap<>();
        M_Produits unProduit;
        int cle, id_tva, nb_produit;
        Float prix_achat, prix_produit;
        String libelle_produit, commentaire_produit, formule_calcul, commentaire_calcul,
                comment, date_create, code_unite, sql;
        try {
            sql = "SELECT COUNT(id_produit_mix) as nb_produit,`id_produit`,`libelle_produit`,`commentaire_produit`,"
                    + "`prix_achat`,`formule_calcul`,`prix_produit`,`commentaire_calcul`,p.`comment`,p.`date_create`,`id_tva`,`code_unite`,`ordre_mix`"
                    + " FROM SO_PRODUIT p"
                    + " Left JOIN SO_COMPOSER c ON c.id_produit_mix = id_produit "
                    + " WHERE " + clauseWhere + " Group by id_produit";

            // SELECT
            // COUNT(id_produit_mix),`id_produit`,`libelle_produit`,`commentaire_produit`,
            // `prix_achat`,`formule_calcul`,`prix_produit`,`commentaire_calcul`,p.`comment`,p.`date_create`,
            // `id_tva`,`code_unite` FROM SO_PRODUIT p Left JOIN SO_COMPOSER c ON
            // c.id_produit_mix = id_produit
            // Group by id_produit, libelle_produit, prix_achat,commentaire_produit

            ResultSet res = db.sqlSelect(sql);

            while (res.next()) {
                cle = Integer.parseInt(res.getString("id_produit"));
                nb_produit = Integer.parseInt(res.getString("nb_produit"));

                libelle_produit = res.getString("libelle_produit");
                commentaire_produit = res.getString("commentaire_produit");
                prix_achat = res.getFloat("prix_achat");
                formule_calcul = res.getString("formule_calcul");
                prix_produit = res.getFloat("prix_produit");
                commentaire_calcul = res.getString("commentaire_calcul");
                comment = res.getString("comment");
                date_create = res.getString("date_create");
                id_tva = Integer.parseInt(res.getString("id_tva"));
                code_unite = res.getString("code_unite");

                unProduit = new M_Produits(db, nb_produit, cle, libelle_produit, commentaire_produit,
                        prix_achat, formule_calcul, prix_produit, commentaire_calcul, comment,
                        date_create, id_tva, code_unite);

                lesProduits.put(cle, unProduit);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("fin get records ");
        return lesProduits;

    }

    public void affiche() {
        System.out.println(id_produit + " " + libelle_produit + " " + commentaire_produit + " " + prix_achat
                + " \t nb : " + nb_produit
                + " ");

    }

    public static void main(String[] args) throws Exception {
        M_Produits unProduit;
        Db_mysql maBase;
        Cl_Connection.connection();
        maBase = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);
        // unProduit = new M_Produits(maBase, null,
        // null, null, null,
        // null, null, null,
        // 0, null);
        // unProduit.affiche();

        LinkedHashMap<Integer, M_Produits> lesProduits;
        lesProduits = M_Produits.getRecords(maBase);

        for (Integer uneCle : lesProduits.keySet()) {
            unProduit = lesProduits.get(uneCle);
            unProduit.affiche();
        }

    }

}
