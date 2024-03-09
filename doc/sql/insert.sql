INSERT INTO SO_PARAMETRE (nom_Entreprise,        
                         adresse1_Entreprise   ,
                         adresse2_Entreprise   ,
                         lieu_dit_Entreprise   ,
                         CP_Entreprise         ,
                         ville_Entreprise      ,
                         tel_Entreprise        ,
                         siret_Entreprise      ,
                         num_TVA_Entreprise    ,
                         prix_Resto            ,
                         taux_charge_salaire   ,
                         delais_Validite_Devis ) VALUES (
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
                         ),(
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
                         ),(
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
                         ),(
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
                         ),(
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
INSERT INTO SO_EFFECTUER (
                        qte_TACHE,
                        ordre_Tache,
                        num_Ligne,  
                        id_Devis,   
                        id_Chantier,
                        id_Tache,   
                        id_Tva,     
                        id_Rubrique
) VALUES (
                        2,
                        1,
                        "10",
                        1,
                        1,
                        1,
                        1,
                        1
),(
                        2,
                        1,
                        "10",
                        1,
                        1,
                        1,
                        1,
                        1
),(
                        2,
                        1,
                        "10",
                        1,
                        1,
                        1,
                        1,
                        1
),(
                        2,
                        1,
                        "10",
                        1,
                        1,
                        1,
                        1,
                        1
),(
                        2,
                        1,
                        "10",
                        1,
                        1,
                        1,
                        1,
                        1
),(
                        2,
                        1,
                        "10",
                        1,
                        1,
                        1,
                        1,
                        1
);
INSERT INTO SO_RUBRIQUE (
                        libelle_Rubrique    ,
                        libelle_Secondaire  ,
                        somme_Total         ,
                        total_General       ,
                        variante            ,
                        Hierarchie          ,
                        Numerotation_Visible,
                        num_Ligne           ,
                        id_Devis            ,
                        id_Chantier         ,
                        id_Rubrique_Modele  ,
                        id_Rubrique_Parent  
) VALUES (
    "rubrique",
    "rubrique secondaire",
    true,
    true,
    true,
    true,
    true,
    "30",
    1,
    1,
    1,
    1,
    1
), (
    "rubrique",
    "rubrique secondaire",
    true,
    true,
    true,
    true,
    true,
    "30",
    1,
    1,
    1,
    1,
    1
), (
    "rubrique",
    "rubrique secondaire",
    true,
    true,
    true,
    true,
    true,
    "30",
    1,
    1,
    1,
    1,
    1
), (
    "rubrique",
    "rubrique secondaire",
    true,
    true,
    true,
    true,
    true,
    "30",
    1,
    1,
    1,
    1,
    1
), (
    "rubrique",
    "rubrique secondaire",
    true,
    true,
    true,
    true,
    true,
    "30",
    1,
    1,
    1,
    1,
    1
);
INSERT INTO SO_DEVIS (
       ref_Devis        ,
       libelle_Devis    ,
       nature_Devis     ,
       date_Devis       ,
       date_Signature   ,
       hypotheses_Devis ,
       commentaire_Devis,
       id_Chantier      
) VALUES (
        "1",
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
        1 
)
, (
        "1",
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
        1 
)
, (
        "1",
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
        1 
)
, (
        "1",
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
        1 
)
, (
        "1",
        "premierDevis",
        "descriptif",
        "2023-01-09",
        "2023-01-12",
        "hyphotes possibles",
        "le commmentaire du devis",
        1 
)
;

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
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu chantier",
            "description du premier chantier",
            1
),
(
            "chantier_sorefa",
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu chantier",
            "description du premier chantier",
            1
),
(
            "chantier_sorefa",
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu chantier",
            "description du premier chantier",
            1
),(
            "chantier_sorefa",
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu chantier",
            "description du premier chantier",
            1
),(
            "chantier_sorefa",
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu chantier",
            "description du premier chantier",
            1
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
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu client",
            "95000",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "1",
            "2"

),(
            "Martin",
            "Bernard",
            "ADECCO",
            true,
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu client",
            "95000",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "1",
            "2"

),(
            "Martin",
            "Bernard",
            "ADECCO",
            true,
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu client",
            "95000",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "1",
            "2"

),( 
            "Martin",
            "Bernard",
            "ADECCO",
            true,
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu client",
            "95000",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "1",
            "2"

),(
            "Martin",
            "Bernard",
            "ADECCO",
            true,
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu client",
            "95000",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "1",
            "2"

),(
            "Martin",
            "Bernard",
            "ADECCO",
            true,
            "28 Rue Jean Jaurès 79300 BRESSUIRE",
            "04 rue du Docteur Brillaud 79300 BRESSUIRE",
            "premier lieu client",
            "95000",
            "0539482723",
            "48 num_TVA",
            "123 568 941 00056",
            "1",
            "2"

);
INSERT INTO SO_TACHE (
            code_Tache 
            libelle_Tache    
            cout_Unitaire    
            commentaire_Tache
            id_Groupe        
            code_Unite       
) VALUES (
            "2",
            "decrepir un mur",
            70,
            "tache à faire en premier",
            1,
            "code unit 3"
),
(
            "2",
            "decrepir un mur",
            70,
            "tache à faire en premier",
            1,
            "code unit 3"
),(
            "2",
            "decrepir un mur",
            70,
            "tache à faire en premier",
            1,
            "code unit 3"
),(
            "2",
            "decrepir un mur",
            70,
            "tache à faire en premier",
            1,
            "code unit 3"
),(
            "2",
            "decrepir un mur",
            70,
            "tache à faire en premier",
            1,
            "code unit 3"
);
INSERT INTO SO_TEXTE (
            code_Texte,
            contenu_texte
) VALUES (
            "1",
            "texte à ajouter"
),
(
            "2",
            "texte à ajouter"
),(
            "3",
            "texte à ajouter"
),(
            "4",
            "texte à ajouter"
),(
            "5",
            "texte à ajouter"
);
INSERT INTO SO_STATUT (
            code_Statut, 
            libelle_Statut
) VALUES (
            "1",
            "EURL"
),(
            "2",
            "SARL"
),(
            "3",
            "SAS"
),(
            "4",
            "SA"
),(
            "5",
            "EI"
);

INSERT INTO SO_CIVILITE (
        code_Civilite,
        libelle_Civilite
) VALUES (
        "1",
        "Mme"
),(
        "3",
        "Mme"
),(
        "1",
        "M"
),(
        "1",
        "Mme"
),(
        "1",
        "M"
);
INSERT INTO SO_CIVILITE (
          code_Civilite,libelle_Civilite,
        comment
) VALUES (
        1,"Mme"," noComment"
),(
        2,"Mme"," noComment"
),(
      3,  "M"," noComment"
),(
       4,"Mme"," noComment"
),(
        
      5,  "M"," noComment"
);


INSERT INTO SO_GROUPE_TACHE (
    libelle_Groupe
) VALUES (
    " premier groupe des taches"
),(
    " groupe des taches"
),(
    " groupe des taches"
),(
    " groupe des taches"
,
    " aucun groupe des taches"
);
INSERT INTO SO_TAUX_TVA (
     taux_Tva
) VALUES (20),(40),(10),(15),(30);

INSERT INTO SO_UNITE (
code_Unite   ,
libelle_Unite
) VALUES ("2","m²"),("3","L"),("1","m²"),("4","L"),("5","m²");

INSERT INTO SO_TYPE_RUBRIQUE (
        nom_Type_Rubrique   ,
        libelle_Rubrique    ,
        libelle_Secondaire  ,
        somme_Total         ,
        total_General       ,
        variante            ,
        Hierarchie          ,
        Numerotation_Visible
) VALUES (
        "première rubrique",
        "libelle rubrique",
        "libelle secondaire",
        true,
        true,
        true,
        true,
        true
);
INSERT INTO SO_PRODUIT (
    libelle_Produit    ,
    commentaire_produit,
    prix_achat         ,
    formule_calcul     ,
    prix_produit       ,
    commentaire_calcul 
) VALUES (
        "enduit traditionnel",
        "produit recommandé",
        300,
        "benefice = prixv-prixa",
        "700",
        "commentaire du calcul"
);   

-- INSERT INTO SO_-MCD- () VALUES () => 0

-- INSERT INTO SO_PARAMETRE () VALUES ()
-- INSERT INTO SO_TEXTE () VALUES ()
-- INSERT INTO SO_STATUT () VALUES ()
-- INSERT INTO SO_TYPE_RUBRIQUE () VALUES ()  => 01
-- INSERT INTO SO_GROUPE_TACHE () VALUES ()
-- INSERT INTO SO_UNITE () VALUES ()
-- INSERT INTO SO_CIVILITE () VALUES ()
-- INSERT INTO SO_ETAT () VALUES ()
-- INSERT INTO SO_TAUX_TVA () VALUES ()



-- INSERT INTO SO_CLIENT () VALUES ()  => 1
-- INSERT INTO SO_CHANTIER () VALUES ()
-- INSERT INTO SO_DEVIS () VALUES ()
-- INSERT INTO SO_RUBRIQUE () VALUES ()
-- INSERT INTO SO_TACHE () VALUES ()
-- INSERT INTO SO_PRODUIT () VALUES ()


-- INSERT INTO SO_EFFECTUER () VALUES () =>
-- INSERT INTO SO_COMPOSER () VALUES ()

-- suppression des enregidstrement
-- DELETE FROM `SO_COMPOSER`;
-- DELETE FROM `SO_EFFECTUER`;
-- DELETE FROM `SO_PRODUIT`;
-- DELETE FROM `SO_TACHE`;
-- DELETE FROM `SO_RUBRIQUE`;
-- DELETE FROM `SO_DEVIS`;
-- DELETE FROM `SO_CHANTIER`;
-- DELETE FROM `SO_CLIENT`;
-- DELETE FROM `SO_TAUX_TVA`;
-- DELETE FROM `SO_ETAT`;
-- DELETE FROM `SO_CIVILITE`;
-- DELETE FROM `SO_UNITE`;
-- DELETE FROM `SO_GROUPE_TACHE`;
-- DELETE FROM `SO_TYPE_RUBRIQUE`;
-- DELETE FROM `SO_STATUT`;
-- DELETE FROM `SO_TEXTE`;
-- DELETE FROM `SO_PARAMETRE`;
-- DELETE FROM `SO_-MCD-`;

-- DELETE FROM `SO_HISTORISER`;
-- DELETE FROM `SO_UTILISER`;
