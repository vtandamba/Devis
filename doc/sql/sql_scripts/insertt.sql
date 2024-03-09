INSERT INTO
    SO_PARAMETRE (
        nom_Entreprise,
        adresse1_Entreprise,
        adresse2_Entreprise,
        lieu_dit_Entreprise,
        CP_Entreprise,
        ville_Entreprise,
        tel_Entreprise,
        siret_Entreprise,
        num_TVA_Entreprise,
        prix_Resto,
        taux_charge_salaire,
        delais_Validite_Devis
    )
VALUES
    (
        "Sorefa",
        "53 Rue Lavoisier 79300 BRESSUIRE",
        "53 Rue de la lustice 95 000 CERGY",
        "_____",
        "70300",
        "BRESSUIRE",
        "0549740538",
        "123 568 941 00056",
        "10 tva",
        60,
        70,
        24
    ),
    (
        "Sorefa",
        "53 Rue Lavoisier 79300 BRESSUIRE",
        "4 Rue du docteur Brillaud 79300 BRESSUIRE",
        "_____",
        "70300",
        "BRESSUIRE",
        "0549740538",
        "123 568 941 00056",
        "10 tva",
        60,
        60,
        64
    ),
    (
        "Sorefa",
        "28 Rue Jean Jaurès 79300 BRESSUIRE",
        " 38 Av. du Château 92195 Meudon",
        "_____",
        "70300",
        "BRESSUIRE",
        "0549740538",
        "123 568 941 00056",
        "10 tva",
        10,
        70,
        54
    ),
    (
        "Sorefa",
        "53 Rue Lavoisier 79300 BRESSUIRE",
        "53 Rue Lavoisier 79300 BRESSUIRE",
        "_____",
        "70300",
        "BRESSUIRE",
        "0549740538",
        "123 568 941 00056",
        "10 tva",
        60,
        70,
        24
    ),
    (
        "Sorefa",
        " 10 Rue du Plus- Que- Tout 27000 Évreux",
        "52 Rue Jean Mermoz 78114 Magny-les-Hameaux",
        "_____",
        "70300",
        "BRESSUIRE",
        "0549740538",
        "123 568 941 00056",
        "15",
        40,
        30,
        64
    );

INSERT INTO
    SO_TEXTE (code_Texte, contenu_texte)
VALUES
    ("1", "texte à ajouter"),
    ("2", "texte à ajouter"),
    ("3", "texte à ajouter"),
    ("4", "texte à ajouter"),
    ("5", "texte à ajouter");

INSERT INTO
    `SO_-MCD-` (
        `sorefa_4-2c`,
        `mar_10_janv_2023`,
        `14:37:35`,
        `jean_h`
    )
VALUES
    (
        "sorefa",
        "mar_10_janv_2023",
        "14:37:35",
        "jean_h"
    ),
    (
        "sorefa-2c",
        "mar_10_janv_2023",
        "14:37:35",
        "jean_h"
    ),
    (
        "sorefa_4",
        "mar_10_janv_2023",
        "14:37:35",
        "jean_h"
    ),
    (
        "sorefa_4-",
        "mar_10_janv_2023",
        "14:37:35",
        "jean_h"
    );

INSERT INTO
    SO_STATUT (code_Statut, libelle_Statut,comment)
VALUES
    ("1", "EURL","noComment"),
    ("2", "SARL","noComment"),
    ("3", "SAS","noComment"),
    ("4", "SA","noComment"),
    ("5", "EI","noComment");

INSERT INTO
    SO_TYPE_RUBRIQUE (
        nom_Type_Rubrique,
        libelle_Rubrique,
        `libelle_secondaire_rubrique`,
        somme_Total,
        total_General,
        variante,
        Hierarchie,
        Numerotation_Visible,
        `comment`
    )
VALUES
    (
        "première rubrique",
        "libelle rubrique",
        "libelle secondaire",
        true,
        true,
        false,
        true,
        true,
        "noComment"
    ),
    (
        "première rubrique",
        "libelle rubrique",
        "libelle secondaire",
        false,
        true,
        true,
        false,
        true,
        "noComment"
    ),
    (
        "première rubrique",
        "libelle rubrique",
        "libelle secondaire",
        true,
        true,
        true,
        true,
        false,
        "noComment"
    ),
    (
        "première rubrique",
        "libelle rubrique",
        "libelle secondaire",
        false,
        true,
        true,
        true,
        true,
        "noComment"
    ),
    (
        "première rubrique",
        "libelle rubrique",
        "libelle secondaire",
        true,
        true,
        false,
        true,
        true,
        "noComment"
    );

INSERT INTO
    SO_GROUPE_TACHE (libelle_Groupe, comment)
VALUES
    (
        " premier groupe des taches",
        "aucun tache restante pour ce groupe"
    ),
    (" groupe des taches", "meilleur groupe"),
    (" groupe des taches", "aucun commentaire"),
    (" groupe des taches", "aucun groupe"),
    (" aucun groupe des taches", " aucune tache");

INSERT INTO
    SO_UNITE (code_Unite, libelle_Unite)
VALUES
    ("2", "m²"),
    ("3", "L"),
    ("1", "m²"),
    ("4", "L"),
    ("5", "m²");

INSERT INTO
    SO_CIVILITE (code_Civilite, libelle_Civilite, comment)
VALUES
    (1, "Mme", " noComment"),
    (2, "Mme", " noComment"),
    (3, "M", " noComment"),
    (4, "Mme", " noComment"),
    (5, "M", " noComment");

INSERT INTO
    SO_ETAT (libelle_etat, description_etat, comment)
VALUES
    ("bon etat ", "c\'est en bonne état", " noComment"),
    (
        "assez bon etat",
        "c\'est en assez bonne état",
        " noComment"
    ),
    (
        "Très bon etat",
        "c\'est en très bonne état",
        " noComment"
    ),
    ("Noeuf", " c\'est tout noeuf", "noComment"),
    ("Nouveau", "c\'est du nouveau", "noComment");

INSERT INTO
    `SO_TAUX_TVA` (taux_tva, comment)
VALUES
    (20, "noComment"),
    (40, "noComment"),
    (10, "noComment"),
    (15, "noComment"),
    (30, "noComment");

INSERT INTO
    SO_CLIENT (
        nom_Client,
        prenom_Client,
        nom_Entreprise,
        bool_entreprise,
        adresse1_Client,
        adresse2_Client,
        lieu_dit_Client,
        cp_Client,
        ville_Client,
        tel_Client,
        num_TVA_Client,
        siret_Client,
        code_Statut,
        code_Civilite
    )
VALUES
    (
        "Martin",
        "Bernard",
        "ADECCO",
        true,
        "28 Rue Jean Jaurès 79300 BRESSUIRE",
        "04 rue du Docteur Brillaud ",
        "premier lieu client",
        "95000",
        "BRESSUIRE",
        "0539482723",
        "48 num_TVA",
        "123 568 941 00056",
        "1",
        "2"
    ),
    (
        "Martin",
        "Bernard",
        "ADECCO",
        true,
        "28 Rue Jean Jaurès 79300 BRESSUIRE",
        "04 rue du Docteur BRESSUIRE",
        "premier lieu client",
        "95000",
        "BRESSUIRE",
        "0539482723",
        "48 num_TVA",
        "123 568 941 00056",
        "4",
        "3"
    ),
    (
        "Martin",
        "Bernard",
        "ADECCO",
        true,
        "20 Av. Léo Lagrange, 79000 Niort",
        " 3 Rue Archimède, 79000 Niort",
        "premier lieu client",
        "95000",
        "Niort",
        "0539482723",
        "48 num_TVA",
        "123 568 941 00056",
        "5",
        "2"
    ),
    (
        "Martin",
        "Bernard",
        "ADECCO",
        true,
        " La Bertramière, 79500 Melle",
        " 13 Rue Louis Brébion, 79400 Saint-Maixent",
        "premier lieu client",
        "95000",
        "Melle",
        "0539482723",
        "48 num_TVA",
        "123 568 941 00056",
        "1",
        "3"
    ),
    (
        "Martin",
        "Bernard",
        "ADECCO",
        true,
        "28 Rue Jean Jaurès 79300 BRESSUIRE",
        "04 rue du Docteur Brillaud 79300 BRESSUIRE",
        "premier lieu client",
        "95000",
        "BRESSUIRE",
        "0539482723",
        "48 num_TVA",
        "123 568 941 00056",
        "1",
        "2"
    ),
    (
        "Martin",
        "Bernard",
        "ADECCO",
        true,
        "28 Rue Jean Jaurès 79300 BRESSUIRE",
        "41 Rue de l'Atlantique, 79200 Le Tallud",
        "premier lieu client",
        "95000",
        " LeTallud",
        "0539482723",
        "48 num_TVA",
        "123 568 941 00056",
        "5",
        "2"
    );
    INSERT INTO SO_CLIENT (
    
            nom_Client     ,
            prenom_Client  ,
            nom_Entreprise ,
            bool_entreprise,
            adresse1_Client,
            adresse2_Client,
            lieu_dit_Client,
            cp_Client      ,
            ville_Client   ,
            tel_Client     ,
            num_TVA_Client ,
            siret_Client   ,
            code_Statut    ,
            code_Civilite  
) VALUES (
            "Martin",
            "Bernard",
            "ADECCO",
            true,
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud ",
            "premier lieu client",
            "95000",
    		"BRESSUIRE",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "1",
            "3"

),(
            "Anger",
            "Julien",
            "ADECCO",
            true,
            "20 Av. Léo Lagrange, 79000 Niort",
            " 3 Rue Archimède, 79000 Niort",
            "premier lieu client",
            "95000",
    	"Niort",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "5",
            "4"

),( 
            "Paul",
            "Alex",
            "ADECCO",
            true,
            " La Bertramière, 79500 Melle",
            " 13 Rue Louis Brébion, 79400 Saint",
            "premier lieu client",
            "95000",
    	"Melle",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "3",
            "5"

),(
            "Jean",
            "Claude",
            "ADECCO",
            true,
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 ",
            "premier lieu client",
            "95000",
    	"BRESSUIRE",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "4",
            "1"

),(
            "Rémi",
            "Boscaud",
            "ADECCO",
            true,
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "41 Rue de l'Atlantique, 79200",
            "premier lieu client",
            "95000",
    	" LeTallud",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "2",
            "2"

);
INSERT INTO SO_CHANTIER (
            libelle_Chantier    ,
            adresse1_Chantier   ,
            adresse2_Chantier   ,
            lieu_dit_Chantier   ,
            cp_Chantier         ,
            ville_Chantier      ,
            description_Chantier,
            id_Client           
) VALUES (
            "chantier_sorefa",
            "28 Rue Jean Jaurès ",
            "04 rue du Docteur Brillaud",
            "premier lieu chantier", "95000","CERGY",
            "description du premier chantier",
            70
),
(
            "chantier_sorefa",
            "28 Rue Jean Jaurès ",
            "14 rue Brillaud",
            "premier lieu chantier", "95000", "POSSY",
            "description du premier chantier",
           69
),
(
            "chantier_sorefa",
            "28 Rue Jean Jaurès ",
            "16 av  Brillaud ",
            "premier lieu chantier","65000", "LYON",
            "description du premier chantier",  
            68
),(
            "chantier_sorefa",
            "28 Rue Jean Jaurès ",
            "20 rue du Docteur ",
            "premier lieu chantier","79300","BRESSUIRE",
            "description du premier chantier", 
            66
),(
            "chantier_sorefa",
            "28 Rue Jean Jaurès",
            "07 rue John Kenedy ",
            "premier lieu chantier","79000",  "NIORT",
            "description du premier chantier", 
            67
);
INSERT INTO SO_DEVIS (
    	`id_devis`,
       ref_Devis        ,
       libelle_Devis    ,
       nature_Devis     ,
       date_Devis       ,
       date_Signature   ,
       hypothese_Devis ,
       commentaire_Devis,
       id_Chantier      
) VALUES (1,
        "1", 
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
       29 
)
, (2,
        "2",
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
        28 
)
, (3,
        "3",
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
        27
)
, (4,
        "4",
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
        26 
)
, (5,
        "5",
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
       30 
)
;
INSERT INTO SO_RUBRIQUE (id_rubrique, libelle_Rubrique , `libelle_secondaire_rubrique`  , somme_Total, total_General , variante , Hierarchie , `numerotation_visible`,
    num_Ligne  ,ordre_rubrique, comment, id_Devis   , id_Chantier    , id_Rubrique_Modele  , `id_rubrique_parent`  
    				
) VALUES 
(1,"rubrique", "rubrique secondaire",true,true,true,true,true,
    "30",1,"noComment",  5, 30,  1,   1
),

(2, "rubrique", "rubrique secondaire",true,true,true,true,true,
    "30",1,"noComment",  2, 28,  2,   2
),

(3, "rubrique", "rubrique secondaire",true,true,true,true,true,
    "30",2,"noComment",  3, 27,  3,   3
),

(4, "rubrique","rubrique secondaire",true,true,true,true,true,
    "30",3,"noComment",  4, 26, 4,   4
), 

(5, "rubrique","rubrique secondaire",true,true,true,true,true,
    "30",4,"noComment",  1, 29,  5,   5
);
INSERT INTO SO_PRODUIT (
    libelle_Produit    ,
    commentaire_produit,
    prix_achat         ,
    formule_calcul     ,
    prix_produit       ,
    commentaire_calcul ,
    `comment`,id_tva,code_unite
) VALUES (
        "enduit traditionnel",
        "produit recommandé",
        300,
        "benefice",
        "700",
        "commentaire du calcul",
    	"produits rares",1,"1"
), (
        "enduit traditionnel",
        "produit recommandé",
        300,
        "benefice",
        "700",
        "commentaire du calcul",
    	"produits rares",2,"2"
), (
        "enduit traditionnel",
        "produit recommandé",
        300,
        "benefice",
        "700",
        "commentaire du calcul",
    	"produits rares",3,"3"
), (
        "enduit traditionnel",
        "produit recommandé",
        300,
        "benefice",
        "700",
        "commentaire du calcul",
    	"produits rares",4,"4"
), (
        "enduit traditionnel",
        "produit recommandé",
        300,
        "benefice",
        "700",
        "commentaire du calcul",
    	"produits rares",5,"5"
)
;   


INSERT INTO
    `SO_COMPOSER` (
        `id_produit_mix`,
        `id_produit_composant`,
        `ordre_mix`,
        `qte_mix`,
        `comment`
    )
VALUES
      ( 1,1,1,5,"aucun commentaire"),
      ( 2,2,2,5,"aucun commentaire"),
      ( 3,3,3,5,"aucun bonne composition de produits"),
      ( 4,4,4,5,"aucun bonne composition de produits"),
      ( 5,5,5,5,"aucun bonne composition de produits")
         ;
         
INSERT INTO SO_EFFECTUER (
                        qte_TACHE,
                        ordre_Tache,
                        num_Ligne,  
    	prix_unitaire,
    comment,
                        `id_devis`,   
                        `id_chantier`,
                        `id_tache`,   
                        `id_tva`,     
                        `id_rubrique`
) VALUES (
                        1, 1,"1", 25.5," déjà effectué",
                        1,  29,  16,  1,  1
),(
                        2, 2,"2", 25.5," à effectuer", 
    					2, 28, 17, 2, 2
),( 
                        3,  3, "3", 25.5,"aucun commentaire",
                        3,  27,  18,  3,  3
),(
                        4, 4,"4", 25.5," à effectuer rapidement", 
    					4, 26, 19, 4, 4
),(
                        5,  5, "5", 25.5," à effectuer ",
                        5, 30, 20, 5, 5
);
