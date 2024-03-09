package fr.sorefa.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import com.itextpdf.text.pdf.PdfPTable;

import fr.sorefa.controllers.Cl_Connection;
import fr.sorefa.controllers.Db_mysql;

public class M_Pdf {
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

    public M_Pdf(Db_mysql db, int id_client, String nom_client, String prenom_client, Boolean bool_entreprise,
            String nom_entreprise, String siret_client, Float num_tva_client, String adresse1_client,
            String adresse2_client, String lieu_dit_client,
            String cp_client, String ville_client, String tel_client, String comment, String date_create,
            String date_update, String code_statut, String code_civilite)

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
        this.date_update = date_update;
        this.code_statut = code_statut;
        this.code_civilite = code_civilite;

    }

    public static PdfPTable getRecords(Db_mysql db) throws Exception {
        db = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);

        return getRecords(db, "1 = 1");
    }

    public static PdfPTable getRecords(Db_mysql db, String clauseWhere) throws SQLException {
        PdfPTable lesPdfs = new PdfPTable(13);
        // lesPdfs = new PdfPTable(lesPdfs.size());
        M_Pdf unPdfClient;

        int cle;
        Float num_tva_client;
        String nom_client, prenom_client, siret_client, nom_entreprise, adresse1_client, adresse2_client, cp_client,
                ville_client, tel_client, comment, lieu_dit_client;
        String date_create, date_update, code_civilite, code_statut;
        Boolean bool_entreprise;
        String sql;
        sql = "SELECT * FROM SO_CLIENT WHERE " + clauseWhere + " ORDER BY nom_client, prenom_client";
        ResultSet res;
        res = db.sqlSelect(sql);

        while (res.next()) {
            cle = Integer.parseInt(res.getString("id_client"));
            nom_client = res.getString("nom_client");
            prenom_client = res.getString("prenom_client");
            siret_client = res.getString("siret_client");
            bool_entreprise = res.getBoolean("bool_entreprise");
            nom_entreprise = res.getString("nom_entreprise");
            num_tva_client = Float.parseFloat(res.getString("num_tva_client"));
            adresse1_client = res.getString("adresse1_client");
            adresse2_client = res.getString("adresse2_client");
            lieu_dit_client = res.getString("lieu_dit_client");
            cp_client = res.getString("cp_client");
            ville_client = res.getString("ville_client");
            tel_client = res.getString("tel_client");
            comment = res.getString("comment");
            date_create = res.getString("date_create");
            date_update = res.getString("date_update");
            code_statut = res.getString("code_statut");
            code_civilite = res.getString("code_civilite");

            lesPdfs.addCell(String.valueOf(cle));
            lesPdfs.addCell(nom_client);
            lesPdfs.addCell(prenom_client);
            lesPdfs.addCell(siret_client);
            lesPdfs.addCell(String.valueOf(bool_entreprise));
            lesPdfs.addCell(String.valueOf(num_tva_client));
            lesPdfs.addCell(adresse1_client);
            lesPdfs.addCell(adresse2_client);
            lesPdfs.addCell(lieu_dit_client);
            lesPdfs.addCell(cp_client);
            lesPdfs.addCell(ville_client);
            lesPdfs.addCell(tel_client);
            lesPdfs.addCell(comment);

        }
        System.out.println("fin get records");
        return lesPdfs;

    }

    public static LinkedHashMap<Integer, M_Pdf> records(Db_mysql db) throws Exception {
        db = new Db_mysql(Cl_Connection.url, Cl_Connection.login, Cl_Connection.password);

        return records(db, "1 = 1");
    }

    public static LinkedHashMap<Integer, M_Pdf> records(Db_mysql db, String clauseWhere) throws SQLException {
        LinkedHashMap<Integer, M_Pdf> lesPdfs;
        lesPdfs = new LinkedHashMap<>();
        M_Pdf unPdfClient;

        int cle;
        Float num_tva_client;
        String nom_client, prenom_client, siret_client, nom_entreprise, adresse1_client, adresse2_client, cp_client,
                ville_client, tel_client,
                comment, lieu_dit_client, date_create, date_update, code_civilite, code_statut;
        Boolean bool_entreprise;
        String sql;
        sql = "SELECT * FROM SO_CLIENT WHERE " + clauseWhere + " ORDER BY nom_client, prenom_client";
        ResultSet res;
        res = db.sqlSelect(sql);

        while (res.next()) {
            cle = Integer.parseInt(res.getString("id_client"));
            nom_client = res.getString("nom_client");
            prenom_client = res.getString("prenom_client");
            siret_client = res.getString("siret_client");
            bool_entreprise = res.getBoolean("bool_entreprise");
            nom_entreprise = res.getString("nom_entreprise");
            num_tva_client = Float.parseFloat(res.getString("num_tva_client"));
            adresse1_client = res.getString("adresse1_client");
            adresse2_client = res.getString("adresse2_client");
            lieu_dit_client = res.getString("lieu_dit_client");
            cp_client = res.getString("cp_client");
            ville_client = res.getString("ville_client");
            tel_client = res.getString("tel_client");
            comment = res.getString("comment");
            date_create = res.getString("date_create");
            date_update = res.getString("date_update");
            code_statut = res.getString("code_statut");
            code_civilite = res.getString("code_civilite");

            unPdfClient = new M_Pdf(db, cle, nom_client, prenom_client, bool_entreprise, nom_entreprise,
                    siret_client, num_tva_client, adresse1_client, adresse2_client, lieu_dit_client, cp_client,
                    ville_client, tel_client, comment, ville_client, tel_client, comment, sql);
            lesPdfs.put(cle, unPdfClient);

        }
        System.out.println("fin get_records");
        return lesPdfs;

    }
}
