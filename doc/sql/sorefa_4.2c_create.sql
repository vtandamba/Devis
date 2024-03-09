<-- CREATE DATABASE IF NOT EXISTS `SOREFA` DEFAULT CHARACTER SET UTF8MB4 COLLATE utf8_general_ci;
-- USE `SOREFA`;

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `SO_COMPOSER`;
DROP TABLE IF EXISTS `SO_HISTORISER`;
DROP TABLE IF EXISTS `SO_-MCD-`;
DROP TABLE IF EXISTS `SO_PARAMETRE`;
DROP TABLE IF EXISTS `SO_TEXTE`;
DROP TABLE IF EXISTS `SO_UTILISER`;
DROP TABLE IF EXISTS `SO_EFFECTUER`;
DROP TABLE IF EXISTS `SO_ETAT`;
DROP TABLE IF EXISTS `SO_PRODUIT`;
DROP TABLE IF EXISTS `SO_RUBRIQUE`;
DROP TABLE IF EXISTS `SO_TACHE`;
DROP TABLE IF EXISTS `SO_TAUX_TVA`;
DROP TABLE IF EXISTS `SO_TYPE_RUBRIQUE`;
DROP TABLE IF EXISTS `SO_UNITE`;
DROP TABLE IF EXISTS `SO_DEVIS`;
DROP TABLE IF EXISTS `SO_GROUPE_TACHE`;
DROP TABLE IF EXISTS `SO_CHANTIER`;
DROP TABLE IF EXISTS `SO_CLIENT`;
DROP TABLE IF EXISTS `SO_STATUT`;
DROP TABLE IF EXISTS `SO_CIVILITE`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `SO_-MCD-` (
  `sorefa_4-2c`     VARCHAR(42),
  `mar_10_janv_2023` VARCHAR(42),
  `14:37:35`        VARCHAR(42),
  `jean_h`          VARCHAR(42),
  PRIMARY KEY (`sorefa_4-2c`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_CHANTIER` (
  `id_chantier` SERIAL,
  `libelle_chantier` VARCHAR(38),
  `adresse1_chantier` VARCHAR(38),
  `adresse2_chantier` VARCHAR(38),
  `lieu_dit_chantier` VARCHAR(38),
  `cp_chantier` VARCHAR(5),
  `ville_chantier` VARCHAR(38),
  `description_chantier` VARCHAR(5000),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  `id_client` BIGINT UNSIGNED,
  PRIMARY KEY (`id_chantier`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_CIVILITE` (
  `code_civilite` VARCHAR(20) NOT NULL UNIQUE,
  `libelle_civilite` VARCHAR(30),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`code_civilite`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_CLIENT` (
  `id_client` SERIAL,
  `nom_client` VARCHAR(38),
  `prenom_client` VARCHAR(38),
  `bool_entreprise` BOOLEAN,
  `nom_entreprise` VARCHAR(38),
  `siret_client` VARCHAR(25),
  `num_tva_client` VARCHAR(25),
  `adresse1_client` VARCHAR(38),
  `adresse2_client` VARCHAR(38),
  `lieu_dit_client` VARCHAR(38),
  `cp_client` VARCHAR(5),
  `ville_client` VARCHAR(38),
  `tel_client` VARCHAR(25),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  `code_statut` VARCHAR(20) NOT NULL UNIQUE,
  `code_civilite` VARCHAR(20) NOT NULL UNIQUE,
  PRIMARY KEY (`id_client`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_COMPOSER` (
  `id_produit_mix` BIGINT UNSIGNED,
  `id_produit_composant` BIGINT UNSIGNED,
  `ordre_mix` INT,
  `qte_mix` FLOAT,
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`id_produit_mix`, `id_produit_composant`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_DEVIS` (
  `id_chantier` BIGINT UNSIGNED,
  `id_devis` BIGINT UNSIGNED NOT NULL,
  `ref_devis` VARCHAR(15),
  `libelle_devis` VARCHAR(100),
  `nature_devis` VARCHAR(5000),
  `date_devis` DATE,
  `date_signature` DATE,
  `hypothese_devis` VARCHAR(5000),
  `commentaire_devis` VARCHAR(5000),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`id_chantier`, `id_devis`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_EFFECTUER` (
  `id_tache_effectuee` SERIAL,
  `qte_tache` FLOAT,
  `ordre_tache` INT,
  `num_ligne` VARCHAR(20),
  `prix_unitaire` DECIMAL(13,4),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  `id_rubrique` BIGINT UNSIGNED NOT NULL,
  `id_chantier` BIGINT UNSIGNED,
  `id_devis` BIGINT UNSIGNED NOT NULL,
  `id_tva` BIGINT UNSIGNED,
  `id_tache` BIGINT UNSIGNED,
  PRIMARY KEY (`id_tache_effectuee`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_ETAT` (
  `id_etat` SERIAL,
  `libelle_etat` VARCHAR(100),
  `description_etat` VARCHAR(5000),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`id_etat`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_GROUPE_TACHE` (
  `id_groupe` SERIAL,
  `libelle_groupe` VARCHAR(100),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`id_groupe`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_HISTORISER` (
  `id_chantier` BIGINT UNSIGNED,
  `id_devis` BIGINT UNSIGNED NOT NULL,
  `id_etat` BIGINT UNSIGNED,
  `date_etat` DATE,
  `commentaire_etat` varchar(5000),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`id_chantier`, `id_devis`, `id_etat`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_PARAMETRE` (
  `id_param` SERIAL,
  `nom_entreprise` VARCHAR(38),
  `adresse1_entreprise` VARCHAR(38),
  `adresse2_entreprise` VARCHAR(38),
  `lieu_dit_entreprise` VARCHAR(38),
  `cp_entreprise` VARCHAR(5),
  `ville_entreprise` VARCHAR(38),
  `tel_entreprise` VARCHAR(25),
  `siret_entreprise` VARCHAR(25),
  `num_tva_entreprise` VARCHAR(25),
  `prix_resto` DECIMAL(13,4),
  `taux_charge_salaire` FLOAT,
  `delais_validite_devis` INT,
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`id_param`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_PRODUIT` (
  `id_produit` SERIAL,
  `libelle_produit` VARCHAR(100),
  `commentaire_produit` VARCHAR(5000),
  `prix_achat` DECIMAL(13,4),
  `formule_calcul` VARCHAR(200),
  `prix_produit` DECIMAL(13,4),
  `commentaire_calcul` VARCHAR(5000),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  `id_tva` BIGINT UNSIGNED,
  `code_unite` VARCHAR(20) NOT NULL UNIQUE,
  PRIMARY KEY (`id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_RUBRIQUE` (
  `id_rubrique` BIGINT UNSIGNED NOT NULL,
  `nom_type_rubrique` VARCHAR(100),
  `libelle_rubrique` VARCHAR(100),
  `libelle_secondaire_rubrique` VARCHAR(100),
  `somme_total` BOOLEAN,
  `total_general` BOOLEAN,
  `variante` BOOLEAN,
  `hierarchie` BOOLEAN,
  `numerotation_visible` BOOLEAN,
  `num_ligne` VARCHAR(20),
  `ordre_rubrique` INT,
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  `id_rubrique_modele` BIGINT UNSIGNED,
  `id_chantier` BIGINT UNSIGNED,
  `id_devis` BIGINT UNSIGNED NOT NULL,
  `id_rubrique_parent` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_rubrique`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_STATUT` (
  `code_statut` VARCHAR(20) NOT NULL UNIQUE,
  `libelle_statut` VARCHAR(100),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`code_statut`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_TACHE` (
  `id_tache` SERIAL,
  `code_tache` VARCHAR(20),
  `libelle_tache` VARCHAR(100),
  `cout_unitaire` DECIMAL(13,4),
  `commentaire_tache` VARCHAR(5000),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  `id_groupe` BIGINT UNSIGNED,
  `code_unite` VARCHAR(20) NOT NULL UNIQUE,
  PRIMARY KEY (`id_tache`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_TAUX_TVA` (
  `id_tva` SERIAL,
  `taux_tva` FLOAT,
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`id_tva`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_TEXTE` (
  `code_texte` VARCHAR(20) NOT NULL UNIQUE,
  `contenu_texte` VARCHAR(5000),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`code_texte`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_TYPE_RUBRIQUE` (
  `id_rubrique` SERIAL,
  `nom_type_rubrique` VARCHAR(100),
  `libelle_rubrique` VARCHAR(100),
  `libelle_secondaire_rubrique` VARCHAR(100),
  `somme_total` BOOLEAN,
  `total_general` BOOLEAN,
  `variante` BOOLEAN,
  `hierarchie` BOOLEAN,
  `numerotation_visible` BOOLEAN,
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`id_rubrique`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_UNITE` (
  `code_unite` VARCHAR(20) NOT NULL UNIQUE,
  `libelle_unite` VARCHAR(30),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`code_unite`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

CREATE TABLE `SO_UTILISER` (
  `id_tache_effectuee` BIGINT UNSIGNED,
  `id_produit` BIGINT UNSIGNED,
  `qte_produit` FLOAT,
  `prix_unitaire` DECIMAL(13,4),
  `comment` VARCHAR(500),
  `date_create` DATETIME DEFAULT current_timestamp(),
  `date_update` DATETIME DEFAULT current_timestamp(),
  PRIMARY KEY (`id_tache_effectuee`, `id_produit`)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

ALTER TABLE `SO_CHANTIER` ADD FOREIGN KEY (`id_client`) REFERENCES `SO_CLIENT` (`id_client`);
ALTER TABLE `SO_CLIENT` ADD FOREIGN KEY (`code_civilite`) REFERENCES `SO_CIVILITE` (`code_civilite`);
ALTER TABLE `SO_CLIENT` ADD FOREIGN KEY (`code_statut`) REFERENCES `SO_STATUT` (`code_statut`);
ALTER TABLE `SO_COMPOSER` ADD FOREIGN KEY (`id_produit_composant`) REFERENCES `SO_PRODUIT` (`id_produit`);
ALTER TABLE `SO_COMPOSER` ADD FOREIGN KEY (`id_produit_mix`) REFERENCES `SO_PRODUIT` (`id_produit`);
ALTER TABLE `SO_DEVIS` ADD FOREIGN KEY (`id_chantier`) REFERENCES `SO_CHANTIER` (`id_chantier`);
ALTER TABLE `SO_EFFECTUER` ADD FOREIGN KEY (`id_tache`) REFERENCES `SO_TACHE` (`id_tache`);
ALTER TABLE `SO_EFFECTUER` ADD FOREIGN KEY (`id_tva`) REFERENCES `SO_TAUX_TVA` (`id_tva`);
ALTER TABLE `SO_EFFECTUER` ADD FOREIGN KEY (`id_chantier`, `id_devis`) REFERENCES `SO_DEVIS` (`id_chantier`, `id_devis`);
ALTER TABLE `SO_EFFECTUER` ADD FOREIGN KEY (`id_rubrique`) REFERENCES `SO_RUBRIQUE` (`id_rubrique`);
ALTER TABLE `SO_HISTORISER` ADD FOREIGN KEY (`id_etat`) REFERENCES `SO_ETAT` (`id_etat`);
ALTER TABLE `SO_HISTORISER` ADD FOREIGN KEY (`id_chantier`, `id_devis`) REFERENCES `SO_DEVIS` (`id_chantier`, `id_devis`);
ALTER TABLE `SO_PRODUIT` ADD FOREIGN KEY (`code_unite`) REFERENCES `SO_UNITE` (`code_unite`);
ALTER TABLE `SO_PRODUIT` ADD FOREIGN KEY (`id_tva`) REFERENCES `SO_TAUX_TVA` (`id_tva`);
ALTER TABLE `SO_RUBRIQUE` ADD FOREIGN KEY (`id_rubrique_parent`) REFERENCES `SO_RUBRIQUE` (`id_rubrique`);
ALTER TABLE `SO_RUBRIQUE` ADD FOREIGN KEY (`id_chantier`, `id_devis`) REFERENCES `SO_DEVIS` (`id_chantier`, `id_devis`);
ALTER TABLE `SO_RUBRIQUE` ADD FOREIGN KEY (`id_rubrique_modele`) REFERENCES `SO_TYPE_RUBRIQUE` (`id_rubrique`);
ALTER TABLE `SO_TACHE` ADD FOREIGN KEY (`code_unite`) REFERENCES `SO_UNITE` (`code_unite`);
ALTER TABLE `SO_TACHE` ADD FOREIGN KEY (`id_groupe`) REFERENCES `SO_GROUPE_TACHE` (`id_groupe`);
ALTER TABLE `SO_UTILISER` ADD FOREIGN KEY (`id_produit`) REFERENCES `SO_PRODUIT` (`id_produit`);
ALTER TABLE `SO_UTILISER` ADD FOREIGN KEY (`id_tache_effectuee`) REFERENCES `SO_EFFECTUER` (`id_tache_effectuee`);

CREATE TRIGGER `SO_COMPOSER_set_update_date` BEFORE UPDATE ON `SO_COMPOSER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_HISTORISER_set_update_date` BEFORE UPDATE ON `SO_HISTORISER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_PARAMETRE_set_update_date` BEFORE UPDATE ON `SO_PARAMETRE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_TEXTE_set_update_date` BEFORE UPDATE ON `SO_TEXTE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_UTILISER_set_update_date` BEFORE UPDATE ON `SO_UTILISER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_EFFECTUER_set_update_date` BEFORE UPDATE ON `SO_EFFECTUER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_ETAT_set_update_date` BEFORE UPDATE ON `SO_ETAT` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_PRODUIT_set_update_date` BEFORE UPDATE ON `SO_PRODUIT` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_RUBRIQUE_set_update_date` BEFORE UPDATE ON `SO_RUBRIQUE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_TACHE_set_update_date` BEFORE UPDATE ON `SO_TACHE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_TAUX_TVA_set_update_date` BEFORE UPDATE ON `SO_TAUX_TVA` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_TYPE_RUBRIQUE_set_update_date` BEFORE UPDATE ON `SO_TYPE_RUBRIQUE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_UNITE_set_update_date` BEFORE UPDATE ON `SO_UNITE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_DEVIS_set_update_date` BEFORE UPDATE ON `SO_DEVIS` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_GROUPE_TACHE_set_update_date` BEFORE UPDATE ON `SO_GROUPE_TACHE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_CHANTIER_set_update_date` BEFORE UPDATE ON `SO_CHANTIER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_CLIENT_set_update_date` BEFORE UPDATE ON `SO_CLIENT` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_STATUT_set_update_date` BEFORE UPDATE ON `SO_STATUT` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
CREATE TRIGGER `SO_CIVILITE_set_update_date` BEFORE UPDATE ON `SO_CIVILITE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP();
