-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : ven. 27 jan. 2023 à 15:23
-- Version du serveur : 10.5.18-MariaDB-0+deb11u1
-- Version de PHP : 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `sorefa`
--

-- --------------------------------------------------------

--
-- Structure de la table `DB_DEPT`
--

CREATE TABLE `DB_DEPT` (
  `dep` varchar(3) NOT NULL,
  `reg` varchar(2) NOT NULL,
  `chefLieu` varchar(5) NOT NULL,
  `tncc` varchar(1) NOT NULL,
  `ncc` varchar(200) NOT NULL,
  `nccEnr` varchar(200) NOT NULL,
  `libelle` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `DB_DEPT`
--

INSERT INTO `DB_DEPT` (`dep`, `reg`, `chefLieu`, `tncc`, `ncc`, `nccEnr`, `libelle`) VALUES
('01', '84', '01053', '5', 'AIN', 'Ain', 'Ain'),
('02', '32', '02408', '5', 'AISNE', 'Aisne', 'Aisne'),
('03', '84', '03190', '5', 'ALLIER', 'Allier', 'Allier'),
('04', '93', '04070', '4', 'ALPES DE HAUTE PROVENCE', 'Alpes-de-Haute-Provence', 'Alpes-de-Haute-Provence'),
('05', '93', '05061', '4', 'HAUTES ALPES', 'Hautes-Alpes', 'Hautes-Alpes'),
('06', '93', '06088', '4', 'ALPES MARITIMES', 'Alpes-Maritimes', 'Alpes-Maritimes'),
('07', '84', '07186', '5', 'ARDECHE', 'Ardèche', 'Ardèche'),
('08', '44', '08105', '4', 'ARDENNES', 'Ardennes', 'Ardennes'),
('09', '76', '09122', '5', 'ARIEGE', 'Ariège', 'Ariège'),
('10', '44', '10387', '5', 'AUBE', 'Aube', 'Aube'),
('11', '76', '11069', '5', 'AUDE', 'Aude', 'Aude'),
('12', '76', '12202', '5', 'AVEYRON', 'Aveyron', 'Aveyron'),
('13', '93', '13055', '4', 'BOUCHES DU RHONE', 'Bouches-du-Rhône', 'Bouches-du-Rhône'),
('14', '28', '14118', '2', 'CALVADOS', 'Calvados', 'Calvados'),
('15', '84', '15014', '2', 'CANTAL', 'Cantal', 'Cantal'),
('16', '75', '16015', '3', 'CHARENTE', 'Charente', 'Charente'),
('17', '75', '17300', '3', 'CHARENTE MARITIME', 'Charente-Maritime', 'Charente-Maritime'),
('18', '24', '18033', '2', 'CHER', 'Cher', 'Cher'),
('19', '75', '19272', '3', 'CORREZE', 'Corrèze', 'Corrèze'),
('21', '27', '21231', '3', 'COTE D OR', 'Côte-d\'Or', 'Côte-d\'Or'),
('22', '53', '22278', '4', 'COTES D ARMOR', 'Côtes-d\'Armor', 'Côtes-d\'Armor'),
('23', '75', '23096', '3', 'CREUSE', 'Creuse', 'Creuse'),
('24', '75', '24322', '3', 'DORDOGNE', 'Dordogne', 'Dordogne'),
('25', '27', '25056', '2', 'DOUBS', 'Doubs', 'Doubs'),
('26', '84', '26362', '3', 'DROME', 'Drôme', 'Drôme'),
('27', '28', '27229', '5', 'EURE', 'Eure', 'Eure'),
('28', '24', '28085', '1', 'EURE ET LOIR', 'Eure-et-Loir', 'Eure-et-Loir'),
('29', '53', '29232', '2', 'FINISTERE', 'Finistère', 'Finistère'),
('2A', '94', '2A004', '3', 'CORSE DU SUD', 'Corse-du-Sud', 'Corse-du-Sud'),
('2B', '94', '2B033', '3', 'HAUTE CORSE', 'Haute-Corse', 'Haute-Corse'),
('30', '76', '30189', '2', 'GARD', 'Gard', 'Gard'),
('31', '76', '31555', '3', 'HAUTE GARONNE', 'Haute-Garonne', 'Haute-Garonne'),
('32', '76', '32013', '2', 'GERS', 'Gers', 'Gers'),
('33', '75', '33063', '3', 'GIRONDE', 'Gironde', 'Gironde'),
('34', '76', '34172', '5', 'HERAULT', 'Hérault', 'Hérault'),
('35', '53', '35238', '1', 'ILLE ET VILAINE', 'Ille-et-Vilaine', 'Ille-et-Vilaine'),
('36', '24', '36044', '5', 'INDRE', 'Indre', 'Indre'),
('37', '24', '37261', '1', 'INDRE ET LOIRE', 'Indre-et-Loire', 'Indre-et-Loire'),
('38', '84', '38185', '5', 'ISERE', 'Isère', 'Isère'),
('39', '27', '39300', '2', 'JURA', 'Jura', 'Jura'),
('40', '75', '40192', '4', 'LANDES', 'Landes', 'Landes'),
('41', '24', '41018', '2', 'LOIR ET CHER', 'Loir-et-Cher', 'Loir-et-Cher'),
('42', '84', '42218', '3', 'LOIRE', 'Loire', 'Loire'),
('43', '84', '43157', '3', 'HAUTE LOIRE', 'Haute-Loire', 'Haute-Loire'),
('44', '52', '44109', '3', 'LOIRE ATLANTIQUE', 'Loire-Atlantique', 'Loire-Atlantique'),
('45', '24', '45234', '2', 'LOIRET', 'Loiret', 'Loiret'),
('46', '76', '46042', '2', 'LOT', 'Lot', 'Lot'),
('47', '75', '47001', '2', 'LOT ET GARONNE', 'Lot-et-Garonne', 'Lot-et-Garonne'),
('48', '76', '48095', '3', 'LOZERE', 'Lozère', 'Lozère'),
('49', '52', '49007', '0', 'MAINE ET LOIRE', 'Maine-et-Loire', 'Maine-et-Loire'),
('50', '28', '50502', '3', 'MANCHE', 'Manche', 'Manche'),
('51', '44', '51108', '3', 'MARNE', 'Marne', 'Marne'),
('52', '44', '52121', '3', 'HAUTE MARNE', 'Haute-Marne', 'Haute-Marne'),
('53', '52', '53130', '3', 'MAYENNE', 'Mayenne', 'Mayenne'),
('54', '44', '54395', '0', 'MEURTHE ET MOSELLE', 'Meurthe-et-Moselle', 'Meurthe-et-Moselle'),
('55', '44', '55029', '3', 'MEUSE', 'Meuse', 'Meuse'),
('56', '53', '56260', '2', 'MORBIHAN', 'Morbihan', 'Morbihan'),
('57', '44', '57463', '3', 'MOSELLE', 'Moselle', 'Moselle'),
('58', '27', '58194', '3', 'NIEVRE', 'Nièvre', 'Nièvre'),
('59', '32', '59350', '2', 'NORD', 'Nord', 'Nord'),
('60', '32', '60057', '5', 'OISE', 'Oise', 'Oise'),
('61', '28', '61001', '5', 'ORNE', 'Orne', 'Orne'),
('62', '32', '62041', '2', 'PAS DE CALAIS', 'Pas-de-Calais', 'Pas-de-Calais'),
('63', '84', '63113', '2', 'PUY DE DOME', 'Puy-de-Dôme', 'Puy-de-Dôme'),
('64', '75', '64445', '4', 'PYRENEES ATLANTIQUES', 'Pyrénées-Atlantiques', 'Pyrénées-Atlantiques'),
('65', '76', '65440', '4', 'HAUTES PYRENEES', 'Hautes-Pyrénées', 'Hautes-Pyrénées'),
('66', '76', '66136', '4', 'PYRENEES ORIENTALES', 'Pyrénées-Orientales', 'Pyrénées-Orientales'),
('67', '44', '67482', '2', 'BAS RHIN', 'Bas-Rhin', 'Bas-Rhin'),
('68', '44', '68066', '2', 'HAUT RHIN', 'Haut-Rhin', 'Haut-Rhin'),
('69', '84', '69123', '2', 'RHONE', 'Rhône', 'Rhône'),
('70', '27', '70550', '3', 'HAUTE SAONE', 'Haute-Saône', 'Haute-Saône'),
('71', '27', '71270', '0', 'SAONE ET LOIRE', 'Saône-et-Loire', 'Saône-et-Loire'),
('72', '52', '72181', '3', 'SARTHE', 'Sarthe', 'Sarthe'),
('73', '84', '73065', '3', 'SAVOIE', 'Savoie', 'Savoie'),
('74', '84', '74010', '3', 'HAUTE SAVOIE', 'Haute-Savoie', 'Haute-Savoie'),
('75', '11', '75056', '0', 'PARIS', 'Paris', 'Paris'),
('76', '28', '76540', '3', 'SEINE MARITIME', 'Seine-Maritime', 'Seine-Maritime'),
('77', '11', '77288', '0', 'SEINE ET MARNE', 'Seine-et-Marne', 'Seine-et-Marne'),
('78', '11', '78646', '4', 'YVELINES', 'Yvelines', 'Yvelines'),
('79', '75', '79191', '4', 'DEUX SEVRES', 'Deux-Sèvres', 'Deux-Sèvres'),
('80', '32', '80021', '3', 'SOMME', 'Somme', 'Somme'),
('81', '76', '81004', '2', 'TARN', 'Tarn', 'Tarn'),
('82', '76', '82121', '2', 'TARN ET GARONNE', 'Tarn-et-Garonne', 'Tarn-et-Garonne'),
('83', '93', '83137', '2', 'VAR', 'Var', 'Var'),
('84', '93', '84007', '2', 'VAUCLUSE', 'Vaucluse', 'Vaucluse'),
('85', '52', '85191', '3', 'VENDEE', 'Vendée', 'Vendée'),
('86', '75', '86194', '3', 'VIENNE', 'Vienne', 'Vienne'),
('87', '75', '87085', '3', 'HAUTE VIENNE', 'Haute-Vienne', 'Haute-Vienne'),
('88', '44', '88160', '4', 'VOSGES', 'Vosges', 'Vosges'),
('89', '27', '89024', '5', 'YONNE', 'Yonne', 'Yonne'),
('90', '27', '90010', '2', 'TERRITOIRE DE BELFORT', 'Territoire de Belfort', 'Territoire de Belfort'),
('91', '11', '91228', '5', 'ESSONNE', 'Essonne', 'Essonne'),
('92', '11', '92050', '4', 'HAUTS DE SEINE', 'Hauts-de-Seine', 'Hauts-de-Seine'),
('93', '11', '93008', '3', 'SEINE SAINT DENIS', 'Seine-Saint-Denis', 'Seine-Saint-Denis'),
('94', '11', '94028', '2', 'VAL DE MARNE', 'Val-de-Marne', 'Val-de-Marne'),
('95', '11', '95500', '2', 'VAL D OISE', 'Val-d\'Oise', 'Val-d\'Oise'),
('971', '01', '97105', '3', 'GUADELOUPE', 'Guadeloupe', 'Guadeloupe'),
('972', '02', '97209', '3', 'MARTINIQUE', 'Martinique', 'Martinique'),
('973', '03', '97302', '3', 'GUYANE', 'Guyane', 'Guyane'),
('974', '04', '97411', '0', 'LA REUNION', 'La Réunion', 'La Réunion'),
('976', '06', '97608', '0', 'MAYOTTE', 'Mayotte', 'Mayotte');

-- --------------------------------------------------------

--
-- Structure de la table `SO_-MCD-`
--

CREATE TABLE `SO_-MCD-` (
  `sorefa_4-2c` varchar(42) NOT NULL,
  `mar_10_janv_2023` varchar(42) DEFAULT NULL,
  `14:37:35` varchar(42) DEFAULT NULL,
  `jean_h` varchar(42) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_-MCD-`
--

INSERT INTO `SO_-MCD-` (`sorefa_4-2c`, `mar_10_janv_2023`, `14:37:35`, `jean_h`) VALUES
('sorefa', 'mar_10_janv_2023', '14:37:35', 'jean_h'),
('sorefa-2c', 'mar_10_janv_2023', '14:37:35', 'jean_h'),
('sorefa_4', 'mar_10_janv_2023', '14:37:35', 'jean_h'),
('sorefa_4-', 'mar_10_janv_2023', '14:37:35', 'jean_h');

-- --------------------------------------------------------

--
-- Structure de la table `SO_CHANTIER`
--

CREATE TABLE `SO_CHANTIER` (
  `id_chantier` bigint(20) UNSIGNED NOT NULL,
  `libelle_chantier` varchar(38) DEFAULT NULL,
  `adresse1_chantier` varchar(38) DEFAULT NULL,
  `adresse2_chantier` varchar(38) DEFAULT NULL,
  `lieu_dit_chantier` varchar(38) DEFAULT NULL,
  `cp_chantier` varchar(5) DEFAULT NULL,
  `ville_chantier` varchar(38) DEFAULT NULL,
  `description_chantier` varchar(5000) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp(),
  `id_client` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_CHANTIER`
--

INSERT INTO `SO_CHANTIER` (`id_chantier`, `libelle_chantier`, `adresse1_chantier`, `adresse2_chantier`, `lieu_dit_chantier`, `cp_chantier`, `ville_chantier`, `description_chantier`, `comment`, `date_create`, `date_update`, `id_client`) VALUES
(26, 'chantier_sorefa', '28 Rue Jean Jaurès ', '04 rue du Docteur Brillaud', 'premier lieu chantier', '95000', 'CERGY', 'description du premier chantier', NULL, '2023-01-19 14:16:26', '2023-01-19 14:16:26', 70),
(27, 'chantier_sorefa', '28 Rue Jean Jaurès ', '14 rue Brillaud', 'premier lieu chantier', '95000', 'POSSY', 'description du premier chantier', NULL, '2023-01-19 14:16:26', '2023-01-19 14:16:26', 69),
(28, 'chantier_sorefa', '28 Rue Jean Jaurès ', '16 av  Brillaud ', 'premier lieu chantier', '65000', 'LYON', 'description du premier chantier', NULL, '2023-01-19 14:16:26', '2023-01-19 14:16:26', 68),
(29, 'chantier_sorefa', '28 Rue Jean Jaurès ', '20 rue du Docteur ', 'premier lieu chantier', '79300', 'BRESSUIRE', 'description du premier chantier', NULL, '2023-01-19 14:16:26', '2023-01-19 14:16:26', 66),
(30, 'chantier_sorefa', '28 Rue Jean Jaurès', '07 rue John Kenedy ', 'premier lieu chantier', '79000', 'NIORT', 'description du premier chantier', NULL, '2023-01-19 14:16:26', '2023-01-19 14:16:26', 67);

--
-- Déclencheurs `SO_CHANTIER`
--
DELIMITER $$
CREATE TRIGGER `SO_CHANTIER_set_update_date` BEFORE UPDATE ON `SO_CHANTIER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_CIVILITE`
--

CREATE TABLE `SO_CIVILITE` (
  `code_civilite` varchar(20) NOT NULL,
  `libelle_civilite` varchar(30) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_CIVILITE`
--

INSERT INTO `SO_CIVILITE` (`code_civilite`, `libelle_civilite`, `comment`, `date_create`, `date_update`) VALUES
('1', 'Mme', ' noComment', '2023-01-19 11:48:03', '2023-01-19 11:48:03'),
('2', 'Mme', ' noComment', '2023-01-19 11:48:03', '2023-01-19 11:48:03'),
('3', 'M', ' noComment', '2023-01-19 11:48:03', '2023-01-19 11:48:03'),
('4', 'Mme', ' noComment', '2023-01-19 11:48:03', '2023-01-19 11:48:03'),
('5', 'M', ' noComment', '2023-01-19 11:48:03', '2023-01-19 11:48:03');

--
-- Déclencheurs `SO_CIVILITE`
--
DELIMITER $$
CREATE TRIGGER `SO_CIVILITE_set_update_date` BEFORE UPDATE ON `SO_CIVILITE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_CLIENT`
--

CREATE TABLE `SO_CLIENT` (
  `id_client` bigint(20) UNSIGNED NOT NULL,
  `nom_client` varchar(38) DEFAULT NULL,
  `prenom_client` varchar(38) DEFAULT NULL,
  `bool_entreprise` tinyint(1) DEFAULT NULL,
  `nom_entreprise` varchar(38) DEFAULT NULL,
  `siret_client` varchar(25) DEFAULT NULL,
  `num_tva_client` varchar(25) DEFAULT NULL,
  `adresse1_client` varchar(38) DEFAULT NULL,
  `adresse2_client` varchar(38) DEFAULT NULL,
  `lieu_dit_client` varchar(38) DEFAULT NULL,
  `cp_client` varchar(5) DEFAULT NULL,
  `ville_client` varchar(38) DEFAULT NULL,
  `tel_client` varchar(25) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp(),
  `code_statut` varchar(20) NOT NULL,
  `code_civilite` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_CLIENT`
--

INSERT INTO `SO_CLIENT` (`id_client`, `nom_client`, `prenom_client`, `bool_entreprise`, `nom_entreprise`, `siret_client`, `num_tva_client`, `adresse1_client`, `adresse2_client`, `lieu_dit_client`, `cp_client`, `ville_client`, `tel_client`, `comment`, `date_create`, `date_update`, `code_statut`, `code_civilite`) VALUES
(66, 'Martin', 'Bernard', 1, 'ADECCO', '123 568 941 00056', '48', '28 Rue Jean Jaurès 79300 BRESSUIRE', '04 rue du Docteur Brillaud ', 'premier lieu client', '95000', 'BRESSUIRE', '0539482723', NULL, '2023-01-19 14:03:46', '2023-01-24 11:19:27', '1', '3'),
(67, 'Julien', 'Paul', 1, 'Sora', '123 568 941 00056', '48', '20 Av. Léo Lagrange, 79000 Niort', ' 3 Rue Archimède, 79000 Niort', 'premier lieu client', '95000', 'Niort', '0539482723', NULL, '2023-01-19 14:03:46', '2023-01-27 10:00:27', '5', '4'),
(68, 'Philipe', 'Mathias', 1, 'Sony', '123 568 941 00056', '48', ' La Bertramière, 79500 Melle', ' 13 Rue Louis Brébion, 79400 Saint', 'premier lieu client', '95000', 'Melle', '0539482723', NULL, '2023-01-19 14:03:46', '2023-01-27 10:02:43', '3', '5'),
(69, 'Louis', 'Bernard', 1, 'LCL', '123 568 941 00056', '48', '28 Rue Jean Jaurès 79300 BRESSUIRE', '04 rue du Docteur Brillaud 79300 ', 'premier lieu client', '95000', 'BRESSUIRE', '0539482723', NULL, '2023-01-19 14:03:46', '2023-01-27 10:03:59', '4', '1'),
(70, 'Martin', 'Bernard', 1, 'ADECCO', '123 568 941 00056', '48', '28 Rue Jean Jaurès 79300 BRESSUIRE', '41 Rue de l\'Atlantique, 79200', 'premier lieu client', '95000', ' LeTallud', '0539482723', NULL, '2023-01-19 14:03:46', '2023-01-24 11:19:27', '2', '2');

--
-- Déclencheurs `SO_CLIENT`
--
DELIMITER $$
CREATE TRIGGER `SO_CLIENT_set_update_date` BEFORE UPDATE ON `SO_CLIENT` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_COMPOSER`
--

CREATE TABLE `SO_COMPOSER` (
  `id_produit_mix` bigint(20) UNSIGNED NOT NULL,
  `id_produit_composant` bigint(20) UNSIGNED NOT NULL,
  `ordre_mix` int(11) DEFAULT NULL,
  `qte_mix` float DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_COMPOSER`
--

INSERT INTO `SO_COMPOSER` (`id_produit_mix`, `id_produit_composant`, `ordre_mix`, `qte_mix`, `comment`, `date_create`, `date_update`) VALUES
(1, 1, 1, 5, 'aucun commentaire', '2023-01-19 15:47:38', '2023-01-19 15:47:38'),
(2, 2, 2, 5, 'aucun commentaire', '2023-01-19 15:47:38', '2023-01-19 15:47:38'),
(3, 3, 3, 5, 'aucun bonne composition de produits', '2023-01-19 15:47:38', '2023-01-19 15:47:38'),
(4, 4, 4, 5, 'aucun bonne composition de produits', '2023-01-19 15:47:38', '2023-01-19 15:47:38'),
(5, 5, 5, 5, 'aucun bonne composition de produits', '2023-01-19 15:47:38', '2023-01-19 15:47:38');

--
-- Déclencheurs `SO_COMPOSER`
--
DELIMITER $$
CREATE TRIGGER `SO_COMPOSER_set_update_date` BEFORE UPDATE ON `SO_COMPOSER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_DEVIS`
--

CREATE TABLE `SO_DEVIS` (
  `id_chantier` bigint(20) UNSIGNED NOT NULL,
  `id_devis` bigint(20) UNSIGNED NOT NULL,
  `ref_devis` varchar(15) DEFAULT NULL,
  `libelle_devis` varchar(100) DEFAULT NULL,
  `nature_devis` varchar(5000) DEFAULT NULL,
  `date_devis` date DEFAULT NULL,
  `date_signature` date DEFAULT NULL,
  `hypothese_devis` varchar(5000) DEFAULT NULL,
  `commentaire_devis` varchar(5000) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_DEVIS`
--

INSERT INTO `SO_DEVIS` (`id_chantier`, `id_devis`, `ref_devis`, `libelle_devis`, `nature_devis`, `date_devis`, `date_signature`, `hypothese_devis`, `commentaire_devis`, `comment`, `date_create`, `date_update`) VALUES
(26, 4, '4', 'premierDevis', 'descriptif', '2023-01-09', '2023-01-12', 'hyphotes possibles', 'le commmentaire du devis', NULL, '2023-01-19 14:26:56', '2023-01-19 14:26:56'),
(27, 3, '3', 'premierDevis', 'descriptif', '2023-01-09', '2023-01-12', 'hyphotes possibles', 'le commmentaire du devis', NULL, '2023-01-19 14:26:56', '2023-01-19 14:26:56'),
(28, 2, '2', 'premierDevis', 'descriptif', '2023-01-09', '2023-01-12', 'hyphotes possibles', 'le commmentaire du devis', NULL, '2023-01-19 14:26:56', '2023-01-19 14:26:56'),
(29, 1, '1', 'premierDevis', 'descriptif', '2023-01-09', '2023-01-12', 'hyphotes possibles', 'le commmentaire du devis', NULL, '2023-01-19 14:26:56', '2023-01-19 14:26:56'),
(30, 5, '5', 'premierDevis', 'descriptif', '2023-01-09', '2023-01-12', 'hyphotes possibles', 'le commmentaire du devis', NULL, '2023-01-19 14:26:56', '2023-01-19 14:26:56');

--
-- Déclencheurs `SO_DEVIS`
--
DELIMITER $$
CREATE TRIGGER `SO_DEVIS_set_update_date` BEFORE UPDATE ON `SO_DEVIS` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_EFFECTUER`
--

CREATE TABLE `SO_EFFECTUER` (
  `id_tache_effectuee` bigint(20) UNSIGNED NOT NULL,
  `qte_tache` float DEFAULT NULL,
  `ordre_tache` int(11) DEFAULT NULL,
  `num_ligne` varchar(20) DEFAULT NULL,
  `prix_unitaire` decimal(13,4) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp(),
  `id_rubrique` bigint(20) UNSIGNED NOT NULL,
  `id_chantier` bigint(20) UNSIGNED DEFAULT NULL,
  `id_devis` bigint(20) UNSIGNED NOT NULL,
  `id_tva` bigint(20) UNSIGNED DEFAULT NULL,
  `id_tache` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_EFFECTUER`
--

INSERT INTO `SO_EFFECTUER` (`id_tache_effectuee`, `qte_tache`, `ordre_tache`, `num_ligne`, `prix_unitaire`, `comment`, `date_create`, `date_update`, `id_rubrique`, `id_chantier`, `id_devis`, `id_tva`, `id_tache`) VALUES
(21, 1, 1, '1', '25.5000', ' déjà effectué', '2023-01-19 15:37:00', '2023-01-19 15:37:00', 1, 29, 1, 1, 16),
(22, 2, 2, '2', '25.5000', ' à effectuer', '2023-01-19 15:37:00', '2023-01-19 15:37:00', 2, 28, 2, 2, 17),
(23, 3, 3, '3', '25.5000', 'aucun commentaire', '2023-01-19 15:37:00', '2023-01-19 15:37:00', 3, 27, 3, 3, 18),
(24, 4, 4, '4', '25.5000', ' à effectuer rapidement', '2023-01-19 15:37:00', '2023-01-19 15:37:00', 4, 26, 4, 4, 19),
(25, 5, 5, '5', '25.5000', ' à effectuer ', '2023-01-19 15:37:00', '2023-01-19 15:37:00', 5, 30, 5, 5, 20);

--
-- Déclencheurs `SO_EFFECTUER`
--
DELIMITER $$
CREATE TRIGGER `SO_EFFECTUER_set_update_date` BEFORE UPDATE ON `SO_EFFECTUER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_ETAT`
--

CREATE TABLE `SO_ETAT` (
  `id_etat` bigint(20) UNSIGNED NOT NULL,
  `libelle_etat` varchar(100) DEFAULT NULL,
  `description_etat` varchar(5000) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_ETAT`
--

INSERT INTO `SO_ETAT` (`id_etat`, `libelle_etat`, `description_etat`, `comment`, `date_create`, `date_update`) VALUES
(1, 'bon etat ', 'c\'est en bonne état', ' noComment', '2023-01-19 13:10:51', '2023-01-19 13:10:51'),
(2, 'assez bon etat', 'c\'est en assez bonne état', ' noComment', '2023-01-19 13:10:51', '2023-01-19 13:10:51'),
(3, 'Très bon etat', 'c\'est en très bonne état', ' noComment', '2023-01-19 13:10:51', '2023-01-19 13:10:51'),
(4, 'Noeuf', ' c\'est tout noeuf', 'noComment', '2023-01-19 13:10:51', '2023-01-19 13:10:51'),
(5, 'Nouveau', 'c\'est du nouveau', 'noComment', '2023-01-19 13:10:51', '2023-01-19 13:10:51');

--
-- Déclencheurs `SO_ETAT`
--
DELIMITER $$
CREATE TRIGGER `SO_ETAT_set_update_date` BEFORE UPDATE ON `SO_ETAT` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_GROUPE_TACHE`
--

CREATE TABLE `SO_GROUPE_TACHE` (
  `id_groupe` bigint(20) UNSIGNED NOT NULL,
  `libelle_groupe` varchar(100) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_GROUPE_TACHE`
--

INSERT INTO `SO_GROUPE_TACHE` (`id_groupe`, `libelle_groupe`, `comment`, `date_create`, `date_update`) VALUES
(1, ' premier groupe des taches', 'aucun tache restante pour ce groupe', '2023-01-19 11:38:57', '2023-01-19 11:38:57'),
(2, ' groupe des taches', 'meilleur groupe', '2023-01-19 11:38:57', '2023-01-19 11:38:57'),
(3, ' groupe des taches', 'aucun commentaire', '2023-01-19 11:38:57', '2023-01-19 11:38:57'),
(4, ' groupe des taches', 'aucun groupe', '2023-01-19 11:38:57', '2023-01-19 11:38:57'),
(5, ' aucun groupe des taches', ' aucune tache', '2023-01-19 11:38:57', '2023-01-19 11:38:57');

--
-- Déclencheurs `SO_GROUPE_TACHE`
--
DELIMITER $$
CREATE TRIGGER `SO_GROUPE_TACHE_set_update_date` BEFORE UPDATE ON `SO_GROUPE_TACHE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_HISTORISER`
--

CREATE TABLE `SO_HISTORISER` (
  `id_chantier` bigint(20) UNSIGNED NOT NULL,
  `id_devis` bigint(20) UNSIGNED NOT NULL,
  `id_etat` bigint(20) UNSIGNED NOT NULL,
  `date_etat` date DEFAULT NULL,
  `commentaire_etat` varchar(5000) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déclencheurs `SO_HISTORISER`
--
DELIMITER $$
CREATE TRIGGER `SO_HISTORISER_set_update_date` BEFORE UPDATE ON `SO_HISTORISER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_PARAMETRE`
--

CREATE TABLE `SO_PARAMETRE` (
  `id_param` bigint(20) UNSIGNED NOT NULL,
  `nom_entreprise` varchar(38) DEFAULT NULL,
  `adresse1_entreprise` varchar(38) DEFAULT NULL,
  `adresse2_entreprise` varchar(38) DEFAULT NULL,
  `lieu_dit_entreprise` varchar(38) DEFAULT NULL,
  `cp_entreprise` varchar(5) DEFAULT NULL,
  `ville_entreprise` varchar(38) DEFAULT NULL,
  `tel_entreprise` varchar(25) DEFAULT NULL,
  `siret_entreprise` varchar(25) DEFAULT NULL,
  `num_tva_entreprise` varchar(25) DEFAULT NULL,
  `prix_resto` decimal(13,4) DEFAULT NULL,
  `taux_charge_salaire` float DEFAULT NULL,
  `delais_validite_devis` int(11) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_PARAMETRE`
--

INSERT INTO `SO_PARAMETRE` (`id_param`, `nom_entreprise`, `adresse1_entreprise`, `adresse2_entreprise`, `lieu_dit_entreprise`, `cp_entreprise`, `ville_entreprise`, `tel_entreprise`, `siret_entreprise`, `num_tva_entreprise`, `prix_resto`, `taux_charge_salaire`, `delais_validite_devis`, `comment`, `date_create`, `date_update`) VALUES
(16, 'Sorefa', '53 Rue Lavoisier 79300 BRESSUIRE', '53 Rue de la lustice 95 000 CERGY', '_____', '70300', 'BRESSUIRE', '0549740538', '123 568 941 00056', '10 tva', '60.0000', 70, 24, NULL, '2023-01-27 10:25:42', '2023-01-27 10:25:42'),
(17, 'Sorefa', '53 Rue Lavoisier 79300 BRESSUIRE', '4 Rue du docteur Brillaud 79300', '_____', '70300', 'BRESSUIRE', '0549740538', '123 568 941 00056', '10 tva', '60.0000', 60, 64, NULL, '2023-01-27 10:25:42', '2023-01-27 10:25:42'),
(18, 'Sorefa', '28 Rue Jean Jaurès 79300 BRESSUIRE', ' 38 Av. du Château 92195 Meudon', '_____', '70300', 'BRESSUIRE', '0549740538', '123 568 941 00056', '10 tva', '10.0000', 70, 54, NULL, '2023-01-27 10:25:42', '2023-01-27 10:25:42'),
(19, 'Sorefa', '53 Rue Lavoisier 79300 BRESSUIRE', '53 Rue Lavoisier 79300 BRESSUIRE', '_____', '70300', 'BRESSUIRE', '0549740538', '123 568 941 00056', '10 tva', '60.0000', 70, 24, NULL, '2023-01-27 10:25:42', '2023-01-27 10:25:42'),
(20, 'Sorefa', ' 10 Rue du Plus- Que- Tout 27000 ', '52 Rue Jean Mermoz 78114 Magny-les', '_____', '70300', 'BRESSUIRE', '0549740538', '123 568 941 00056', '15', '40.0000', 30, 64, NULL, '2023-01-27 10:25:42', '2023-01-27 10:25:42');

--
-- Déclencheurs `SO_PARAMETRE`
--
DELIMITER $$
CREATE TRIGGER `SO_PARAMETRE_set_update_date` BEFORE UPDATE ON `SO_PARAMETRE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_PRODUIT`
--

CREATE TABLE `SO_PRODUIT` (
  `id_produit` bigint(20) UNSIGNED NOT NULL,
  `libelle_produit` varchar(100) DEFAULT NULL,
  `commentaire_produit` varchar(5000) DEFAULT NULL,
  `prix_achat` decimal(13,4) DEFAULT NULL,
  `formule_calcul` varchar(200) DEFAULT NULL,
  `prix_produit` decimal(13,4) DEFAULT NULL,
  `commentaire_calcul` varchar(5000) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp(),
  `id_tva` bigint(20) UNSIGNED DEFAULT NULL,
  `code_unite` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_PRODUIT`
--

INSERT INTO `SO_PRODUIT` (`id_produit`, `libelle_produit`, `commentaire_produit`, `prix_achat`, `formule_calcul`, `prix_produit`, `commentaire_calcul`, `comment`, `date_create`, `date_update`, `id_tva`, `code_unite`) VALUES
(1, 'enduit traditionnel', 'produit recommandé', '300.0000', 'benefice', '700.0000', 'commentaire du calcul', 'produits rares', '2023-01-19 15:17:34', '2023-01-19 15:17:34', 1, '1'),
(2, 'enduit traditionnel', 'produit recommandé', '300.0000', 'benefice', '700.0000', 'commentaire du calcul', 'produits rares', '2023-01-19 15:17:34', '2023-01-19 15:17:34', 2, '2'),
(3, 'enduit traditionnel', 'produit recommandé', '300.0000', 'benefice', '700.0000', 'commentaire du calcul', 'produits rares', '2023-01-19 15:17:34', '2023-01-19 15:17:34', 3, '3'),
(4, 'enduit traditionnel', 'produit recommandé', '300.0000', 'benefice', '700.0000', 'commentaire du calcul', 'produits rares', '2023-01-19 15:17:34', '2023-01-19 15:17:34', 4, '4'),
(5, 'enduit traditionnel', 'produit recommandé', '300.0000', 'benefice', '700.0000', 'commentaire du calcul', 'produits rares', '2023-01-19 15:17:34', '2023-01-19 15:17:34', 5, '5');

--
-- Déclencheurs `SO_PRODUIT`
--
DELIMITER $$
CREATE TRIGGER `SO_PRODUIT_set_update_date` BEFORE UPDATE ON `SO_PRODUIT` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_RUBRIQUE`
--

CREATE TABLE `SO_RUBRIQUE` (
  `id_rubrique` bigint(20) UNSIGNED NOT NULL,
  `nom_type_rubrique` varchar(100) DEFAULT NULL,
  `libelle_rubrique` varchar(100) DEFAULT NULL,
  `libelle_secondaire_rubrique` varchar(100) DEFAULT NULL,
  `somme_total` tinyint(1) DEFAULT NULL,
  `total_general` tinyint(1) DEFAULT NULL,
  `variante` tinyint(1) DEFAULT NULL,
  `hierarchie` tinyint(1) DEFAULT NULL,
  `numerotation_visible` tinyint(1) DEFAULT NULL,
  `num_ligne` varchar(20) DEFAULT NULL,
  `ordre_rubrique` int(11) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp(),
  `id_rubrique_modele` bigint(20) UNSIGNED DEFAULT NULL,
  `id_chantier` bigint(20) UNSIGNED DEFAULT NULL,
  `id_devis` bigint(20) UNSIGNED NOT NULL,
  `id_rubrique_parent` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_RUBRIQUE`
--

INSERT INTO `SO_RUBRIQUE` (`id_rubrique`, `nom_type_rubrique`, `libelle_rubrique`, `libelle_secondaire_rubrique`, `somme_total`, `total_general`, `variante`, `hierarchie`, `numerotation_visible`, `num_ligne`, `ordre_rubrique`, `comment`, `date_create`, `date_update`, `id_rubrique_modele`, `id_chantier`, `id_devis`, `id_rubrique_parent`) VALUES
(1, NULL, 'rubrique', 'rubrique secondaire', 1, 1, 1, 1, 1, '30', 1, 'noComment', '2023-01-19 15:01:52', '2023-01-19 15:01:52', 1, 30, 5, 1),
(2, NULL, 'rubrique', 'rubrique secondaire', 1, 1, 1, 1, 1, '30', 1, 'noComment', '2023-01-19 15:01:52', '2023-01-19 15:01:52', 2, 28, 2, 2),
(3, NULL, 'rubrique', 'rubrique secondaire', 1, 1, 1, 1, 1, '30', 2, 'noComment', '2023-01-19 15:01:52', '2023-01-19 15:01:52', 3, 27, 3, 3),
(4, NULL, 'rubrique', 'rubrique secondaire', 1, 1, 1, 1, 1, '30', 3, 'noComment', '2023-01-19 15:01:52', '2023-01-19 15:01:52', 4, 26, 4, 4),
(5, NULL, 'rubrique', 'rubrique secondaire', 1, 1, 1, 1, 1, '30', 4, 'noComment', '2023-01-19 15:01:52', '2023-01-19 15:01:52', 5, 29, 1, 5);

--
-- Déclencheurs `SO_RUBRIQUE`
--
DELIMITER $$
CREATE TRIGGER `SO_RUBRIQUE_set_update_date` BEFORE UPDATE ON `SO_RUBRIQUE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_STATUT`
--

CREATE TABLE `SO_STATUT` (
  `code_statut` varchar(20) NOT NULL,
  `libelle_statut` varchar(100) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_STATUT`
--

INSERT INTO `SO_STATUT` (`code_statut`, `libelle_statut`, `comment`, `date_create`, `date_update`) VALUES
('1', 'EURL', NULL, '2023-01-19 13:55:04', '2023-01-19 13:55:04'),
('2', 'SARL', NULL, '2023-01-19 13:55:04', '2023-01-19 13:55:04'),
('3', 'SAS', NULL, '2023-01-19 13:55:04', '2023-01-19 13:55:04'),
('4', 'SA', NULL, '2023-01-19 13:55:04', '2023-01-19 13:55:04'),
('5', 'EI', NULL, '2023-01-19 13:55:04', '2023-01-19 13:55:04');

--
-- Déclencheurs `SO_STATUT`
--
DELIMITER $$
CREATE TRIGGER `SO_STATUT_set_update_date` BEFORE UPDATE ON `SO_STATUT` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_TACHE`
--

CREATE TABLE `SO_TACHE` (
  `id_tache` bigint(20) UNSIGNED NOT NULL,
  `code_tache` varchar(20) DEFAULT NULL,
  `libelle_tache` varchar(100) DEFAULT NULL,
  `cout_unitaire` decimal(13,4) DEFAULT NULL,
  `commentaire_tache` varchar(5000) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp(),
  `id_groupe` bigint(20) UNSIGNED DEFAULT NULL,
  `code_unite` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_TACHE`
--

INSERT INTO `SO_TACHE` (`id_tache`, `code_tache`, `libelle_tache`, `cout_unitaire`, `commentaire_tache`, `comment`, `date_create`, `date_update`, `id_groupe`, `code_unite`) VALUES
(16, '1', 'decrepir un mur', '70.0000', 'tache à faire en premier', NULL, '2023-01-19 15:11:47', '2023-01-19 15:11:47', 1, '1'),
(17, '2', 'decrepir un mur', '70.0000', 'tache à faire en premier', NULL, '2023-01-19 15:11:47', '2023-01-19 15:11:47', 2, '2'),
(18, '3', 'decrepir un mur', '70.0000', 'tache à faire en premier', NULL, '2023-01-19 15:11:47', '2023-01-19 15:11:47', 3, '3'),
(19, '3', 'decrepir un mur', '70.0000', 'tache à faire en premier', NULL, '2023-01-19 15:11:47', '2023-01-19 15:11:47', 4, '4'),
(20, '5', 'decrepir un mur', '70.0000', 'tache à faire en premier', NULL, '2023-01-19 15:11:47', '2023-01-19 15:11:47', 5, '5');

--
-- Déclencheurs `SO_TACHE`
--
DELIMITER $$
CREATE TRIGGER `SO_TACHE_set_update_date` BEFORE UPDATE ON `SO_TACHE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_TAUX_TVA`
--

CREATE TABLE `SO_TAUX_TVA` (
  `id_tva` bigint(20) UNSIGNED NOT NULL,
  `taux_tva` float DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_TAUX_TVA`
--

INSERT INTO `SO_TAUX_TVA` (`id_tva`, `taux_tva`, `comment`, `date_create`, `date_update`) VALUES
(1, 20, 'noComment', '2023-01-19 13:14:24', '2023-01-19 13:14:24'),
(2, 40, 'noComment', '2023-01-19 13:14:24', '2023-01-19 13:14:24'),
(3, 10, 'noComment', '2023-01-19 13:14:24', '2023-01-19 13:14:24'),
(4, 15, 'noComment', '2023-01-19 13:14:24', '2023-01-19 13:14:24'),
(5, 30, 'noComment', '2023-01-19 13:14:24', '2023-01-19 13:14:24');

--
-- Déclencheurs `SO_TAUX_TVA`
--
DELIMITER $$
CREATE TRIGGER `SO_TAUX_TVA_set_update_date` BEFORE UPDATE ON `SO_TAUX_TVA` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_TEXTE`
--

CREATE TABLE `SO_TEXTE` (
  `code_texte` varchar(20) NOT NULL,
  `contenu_texte` varchar(5000) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_TEXTE`
--

INSERT INTO `SO_TEXTE` (`code_texte`, `contenu_texte`, `comment`, `date_create`, `date_update`) VALUES
('1', 'texte à ajouter', NULL, '2023-01-27 10:26:37', '2023-01-27 10:26:37'),
('2', 'texte à ajouter', NULL, '2023-01-27 10:26:37', '2023-01-27 10:26:37'),
('3', 'texte à ajouter', NULL, '2023-01-27 10:26:37', '2023-01-27 10:26:37'),
('4', 'texte à ajouter', NULL, '2023-01-27 10:26:37', '2023-01-27 10:26:37'),
('5', 'texte à ajouter', NULL, '2023-01-27 10:26:37', '2023-01-27 10:26:37');

--
-- Déclencheurs `SO_TEXTE`
--
DELIMITER $$
CREATE TRIGGER `SO_TEXTE_set_update_date` BEFORE UPDATE ON `SO_TEXTE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_TYPE_RUBRIQUE`
--

CREATE TABLE `SO_TYPE_RUBRIQUE` (
  `id_rubrique` bigint(20) UNSIGNED NOT NULL,
  `nom_type_rubrique` varchar(100) DEFAULT NULL,
  `libelle_rubrique` varchar(100) DEFAULT NULL,
  `libelle_secondaire_rubrique` varchar(100) DEFAULT NULL,
  `somme_total` tinyint(1) DEFAULT NULL,
  `total_general` tinyint(1) DEFAULT NULL,
  `variante` tinyint(1) DEFAULT NULL,
  `hierarchie` tinyint(1) DEFAULT NULL,
  `numerotation_visible` tinyint(1) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_TYPE_RUBRIQUE`
--

INSERT INTO `SO_TYPE_RUBRIQUE` (`id_rubrique`, `nom_type_rubrique`, `libelle_rubrique`, `libelle_secondaire_rubrique`, `somme_total`, `total_general`, `variante`, `hierarchie`, `numerotation_visible`, `comment`, `date_create`, `date_update`) VALUES
(1, 'première rubrique', 'libelle rubrique', 'libelle secondaire', 1, 1, 1, 1, 1, 'noComment', '2023-01-19 11:29:25', '2023-01-19 11:29:25'),
(2, 'première rubrique', 'libelle rubrique', 'libelle secondaire', 1, 1, 1, 1, 1, 'noComment', '2023-01-19 11:31:42', '2023-01-19 11:31:42'),
(3, 'première rubrique', 'libelle rubrique', 'libelle secondaire', 1, 1, 1, 1, 1, 'noComment', '2023-01-19 11:31:42', '2023-01-19 11:31:42'),
(4, 'première rubrique', 'libelle rubrique', 'libelle secondaire', 1, 1, 1, 1, 1, 'noComment', '2023-01-19 11:31:42', '2023-01-19 11:31:42'),
(5, 'première rubrique', 'libelle rubrique', 'libelle secondaire', 1, 1, 1, 1, 1, 'noComment', '2023-01-19 11:31:42', '2023-01-19 11:31:42');

--
-- Déclencheurs `SO_TYPE_RUBRIQUE`
--
DELIMITER $$
CREATE TRIGGER `SO_TYPE_RUBRIQUE_set_update_date` BEFORE UPDATE ON `SO_TYPE_RUBRIQUE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_UNITE`
--

CREATE TABLE `SO_UNITE` (
  `code_unite` varchar(20) NOT NULL,
  `libelle_unite` varchar(30) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `SO_UNITE`
--

INSERT INTO `SO_UNITE` (`code_unite`, `libelle_unite`, `comment`, `date_create`, `date_update`) VALUES
('1', 'm²', NULL, '2023-01-19 11:41:10', '2023-01-19 11:41:10'),
('2', 'm²', NULL, '2023-01-19 11:41:10', '2023-01-19 11:41:10'),
('3', 'L', NULL, '2023-01-19 11:41:10', '2023-01-19 11:41:10'),
('4', 'L', NULL, '2023-01-19 11:41:10', '2023-01-19 11:41:10'),
('5', 'm²', NULL, '2023-01-19 11:41:10', '2023-01-19 11:41:10');

--
-- Déclencheurs `SO_UNITE`
--
DELIMITER $$
CREATE TRIGGER `SO_UNITE_set_update_date` BEFORE UPDATE ON `SO_UNITE` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `SO_UTILISER`
--

CREATE TABLE `SO_UTILISER` (
  `id_tache_effectuee` bigint(20) UNSIGNED NOT NULL,
  `id_produit` bigint(20) UNSIGNED NOT NULL,
  `qte_produit` float DEFAULT NULL,
  `prix_unitaire` decimal(13,4) DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  `date_create` datetime DEFAULT current_timestamp(),
  `date_update` datetime DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déclencheurs `SO_UTILISER`
--
DELIMITER $$
CREATE TRIGGER `SO_UTILISER_set_update_date` BEFORE UPDATE ON `SO_UTILISER` FOR EACH ROW SET NEW.date_update=CURRENT_TIMESTAMP()
$$
DELIMITER ;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `SO_-MCD-`
--
ALTER TABLE `SO_-MCD-`
  ADD PRIMARY KEY (`sorefa_4-2c`);

--
-- Index pour la table `SO_CHANTIER`
--
ALTER TABLE `SO_CHANTIER`
  ADD PRIMARY KEY (`id_chantier`),
  ADD UNIQUE KEY `id_chantier` (`id_chantier`),
  ADD KEY `id_client` (`id_client`);

--
-- Index pour la table `SO_CIVILITE`
--
ALTER TABLE `SO_CIVILITE`
  ADD PRIMARY KEY (`code_civilite`),
  ADD UNIQUE KEY `code_civilite` (`code_civilite`);

--
-- Index pour la table `SO_CLIENT`
--
ALTER TABLE `SO_CLIENT`
  ADD PRIMARY KEY (`id_client`),
  ADD UNIQUE KEY `id_client` (`id_client`),
  ADD UNIQUE KEY `code_statut` (`code_statut`),
  ADD UNIQUE KEY `code_civilite` (`code_civilite`);

--
-- Index pour la table `SO_COMPOSER`
--
ALTER TABLE `SO_COMPOSER`
  ADD PRIMARY KEY (`id_produit_mix`,`id_produit_composant`),
  ADD KEY `id_produit_composant` (`id_produit_composant`);

--
-- Index pour la table `SO_DEVIS`
--
ALTER TABLE `SO_DEVIS`
  ADD PRIMARY KEY (`id_chantier`,`id_devis`);

--
-- Index pour la table `SO_EFFECTUER`
--
ALTER TABLE `SO_EFFECTUER`
  ADD PRIMARY KEY (`id_tache_effectuee`),
  ADD UNIQUE KEY `id_tache_effectuee` (`id_tache_effectuee`),
  ADD KEY `id_tache` (`id_tache`),
  ADD KEY `id_tva` (`id_tva`),
  ADD KEY `id_chantier` (`id_chantier`,`id_devis`),
  ADD KEY `id_rubrique` (`id_rubrique`);

--
-- Index pour la table `SO_ETAT`
--
ALTER TABLE `SO_ETAT`
  ADD PRIMARY KEY (`id_etat`),
  ADD UNIQUE KEY `id_etat` (`id_etat`);

--
-- Index pour la table `SO_GROUPE_TACHE`
--
ALTER TABLE `SO_GROUPE_TACHE`
  ADD PRIMARY KEY (`id_groupe`),
  ADD UNIQUE KEY `id_groupe` (`id_groupe`);

--
-- Index pour la table `SO_HISTORISER`
--
ALTER TABLE `SO_HISTORISER`
  ADD PRIMARY KEY (`id_chantier`,`id_devis`,`id_etat`),
  ADD KEY `id_etat` (`id_etat`);

--
-- Index pour la table `SO_PARAMETRE`
--
ALTER TABLE `SO_PARAMETRE`
  ADD PRIMARY KEY (`id_param`),
  ADD UNIQUE KEY `id_param` (`id_param`);

--
-- Index pour la table `SO_PRODUIT`
--
ALTER TABLE `SO_PRODUIT`
  ADD PRIMARY KEY (`id_produit`),
  ADD UNIQUE KEY `id_produit` (`id_produit`),
  ADD UNIQUE KEY `code_unite` (`code_unite`),
  ADD KEY `id_tva` (`id_tva`);

--
-- Index pour la table `SO_RUBRIQUE`
--
ALTER TABLE `SO_RUBRIQUE`
  ADD PRIMARY KEY (`id_rubrique`),
  ADD KEY `id_rubrique_parent` (`id_rubrique_parent`),
  ADD KEY `id_chantier` (`id_chantier`,`id_devis`),
  ADD KEY `id_rubrique_modele` (`id_rubrique_modele`);

--
-- Index pour la table `SO_STATUT`
--
ALTER TABLE `SO_STATUT`
  ADD PRIMARY KEY (`code_statut`),
  ADD UNIQUE KEY `code_statut` (`code_statut`);

--
-- Index pour la table `SO_TACHE`
--
ALTER TABLE `SO_TACHE`
  ADD PRIMARY KEY (`id_tache`),
  ADD UNIQUE KEY `id_tache` (`id_tache`),
  ADD UNIQUE KEY `code_unite` (`code_unite`),
  ADD KEY `id_groupe` (`id_groupe`);

--
-- Index pour la table `SO_TAUX_TVA`
--
ALTER TABLE `SO_TAUX_TVA`
  ADD PRIMARY KEY (`id_tva`),
  ADD UNIQUE KEY `id_tva` (`id_tva`);

--
-- Index pour la table `SO_TEXTE`
--
ALTER TABLE `SO_TEXTE`
  ADD PRIMARY KEY (`code_texte`),
  ADD UNIQUE KEY `code_texte` (`code_texte`);

--
-- Index pour la table `SO_TYPE_RUBRIQUE`
--
ALTER TABLE `SO_TYPE_RUBRIQUE`
  ADD PRIMARY KEY (`id_rubrique`),
  ADD UNIQUE KEY `id_rubrique` (`id_rubrique`);

--
-- Index pour la table `SO_UNITE`
--
ALTER TABLE `SO_UNITE`
  ADD PRIMARY KEY (`code_unite`),
  ADD UNIQUE KEY `code_unite` (`code_unite`);

--
-- Index pour la table `SO_UTILISER`
--
ALTER TABLE `SO_UTILISER`
  ADD PRIMARY KEY (`id_tache_effectuee`,`id_produit`),
  ADD KEY `id_produit` (`id_produit`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `SO_CHANTIER`
--
ALTER TABLE `SO_CHANTIER`
  MODIFY `id_chantier` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT pour la table `SO_CLIENT`
--
ALTER TABLE `SO_CLIENT`
  MODIFY `id_client` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=71;

--
-- AUTO_INCREMENT pour la table `SO_EFFECTUER`
--
ALTER TABLE `SO_EFFECTUER`
  MODIFY `id_tache_effectuee` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT pour la table `SO_ETAT`
--
ALTER TABLE `SO_ETAT`
  MODIFY `id_etat` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `SO_GROUPE_TACHE`
--
ALTER TABLE `SO_GROUPE_TACHE`
  MODIFY `id_groupe` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `SO_PARAMETRE`
--
ALTER TABLE `SO_PARAMETRE`
  MODIFY `id_param` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `SO_PRODUIT`
--
ALTER TABLE `SO_PRODUIT`
  MODIFY `id_produit` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `SO_TACHE`
--
ALTER TABLE `SO_TACHE`
  MODIFY `id_tache` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `SO_TAUX_TVA`
--
ALTER TABLE `SO_TAUX_TVA`
  MODIFY `id_tva` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `SO_TYPE_RUBRIQUE`
--
ALTER TABLE `SO_TYPE_RUBRIQUE`
  MODIFY `id_rubrique` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `SO_CHANTIER`
--
ALTER TABLE `SO_CHANTIER`
  ADD CONSTRAINT `SO_CHANTIER_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `SO_CLIENT` (`id_client`);

--
-- Contraintes pour la table `SO_CLIENT`
--
ALTER TABLE `SO_CLIENT`
  ADD CONSTRAINT `SO_CLIENT_ibfk_1` FOREIGN KEY (`code_civilite`) REFERENCES `SO_CIVILITE` (`code_civilite`),
  ADD CONSTRAINT `SO_CLIENT_ibfk_2` FOREIGN KEY (`code_statut`) REFERENCES `SO_STATUT` (`code_statut`);

--
-- Contraintes pour la table `SO_COMPOSER`
--
ALTER TABLE `SO_COMPOSER`
  ADD CONSTRAINT `SO_COMPOSER_ibfk_1` FOREIGN KEY (`id_produit_composant`) REFERENCES `SO_PRODUIT` (`id_produit`),
  ADD CONSTRAINT `SO_COMPOSER_ibfk_2` FOREIGN KEY (`id_produit_mix`) REFERENCES `SO_PRODUIT` (`id_produit`);

--
-- Contraintes pour la table `SO_DEVIS`
--
ALTER TABLE `SO_DEVIS`
  ADD CONSTRAINT `SO_DEVIS_ibfk_1` FOREIGN KEY (`id_chantier`) REFERENCES `SO_CHANTIER` (`id_chantier`);

--
-- Contraintes pour la table `SO_EFFECTUER`
--
ALTER TABLE `SO_EFFECTUER`
  ADD CONSTRAINT `SO_EFFECTUER_ibfk_1` FOREIGN KEY (`id_tache`) REFERENCES `SO_TACHE` (`id_tache`),
  ADD CONSTRAINT `SO_EFFECTUER_ibfk_2` FOREIGN KEY (`id_tva`) REFERENCES `SO_TAUX_TVA` (`id_tva`),
  ADD CONSTRAINT `SO_EFFECTUER_ibfk_3` FOREIGN KEY (`id_chantier`,`id_devis`) REFERENCES `SO_DEVIS` (`id_chantier`, `id_devis`),
  ADD CONSTRAINT `SO_EFFECTUER_ibfk_4` FOREIGN KEY (`id_rubrique`) REFERENCES `SO_RUBRIQUE` (`id_rubrique`);

--
-- Contraintes pour la table `SO_HISTORISER`
--
ALTER TABLE `SO_HISTORISER`
  ADD CONSTRAINT `SO_HISTORISER_ibfk_1` FOREIGN KEY (`id_etat`) REFERENCES `SO_ETAT` (`id_etat`),
  ADD CONSTRAINT `SO_HISTORISER_ibfk_2` FOREIGN KEY (`id_chantier`,`id_devis`) REFERENCES `SO_DEVIS` (`id_chantier`, `id_devis`);

--
-- Contraintes pour la table `SO_PRODUIT`
--
ALTER TABLE `SO_PRODUIT`
  ADD CONSTRAINT `SO_PRODUIT_ibfk_1` FOREIGN KEY (`code_unite`) REFERENCES `SO_UNITE` (`code_unite`),
  ADD CONSTRAINT `SO_PRODUIT_ibfk_2` FOREIGN KEY (`id_tva`) REFERENCES `SO_TAUX_TVA` (`id_tva`);

--
-- Contraintes pour la table `SO_RUBRIQUE`
--
ALTER TABLE `SO_RUBRIQUE`
  ADD CONSTRAINT `SO_RUBRIQUE_ibfk_1` FOREIGN KEY (`id_rubrique_parent`) REFERENCES `SO_RUBRIQUE` (`id_rubrique`),
  ADD CONSTRAINT `SO_RUBRIQUE_ibfk_2` FOREIGN KEY (`id_chantier`,`id_devis`) REFERENCES `SO_DEVIS` (`id_chantier`, `id_devis`),
  ADD CONSTRAINT `SO_RUBRIQUE_ibfk_3` FOREIGN KEY (`id_rubrique_modele`) REFERENCES `SO_TYPE_RUBRIQUE` (`id_rubrique`);

--
-- Contraintes pour la table `SO_TACHE`
--
ALTER TABLE `SO_TACHE`
  ADD CONSTRAINT `SO_TACHE_ibfk_1` FOREIGN KEY (`code_unite`) REFERENCES `SO_UNITE` (`code_unite`),
  ADD CONSTRAINT `SO_TACHE_ibfk_2` FOREIGN KEY (`id_groupe`) REFERENCES `SO_GROUPE_TACHE` (`id_groupe`);

--
-- Contraintes pour la table `SO_UTILISER`
--
ALTER TABLE `SO_UTILISER`
  ADD CONSTRAINT `SO_UTILISER_ibfk_1` FOREIGN KEY (`id_produit`) REFERENCES `SO_PRODUIT` (`id_produit`),
  ADD CONSTRAINT `SO_UTILISER_ibfk_2` FOREIGN KEY (`id_tache_effectuee`) REFERENCES `SO_EFFECTUER` (`id_tache_effectuee`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
