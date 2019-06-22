-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 19 Avril 2019 à 15:15
-- Version du serveur :  5.6.15-log
-- Version de PHP :  5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `resume`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `idclient` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) DEFAULT NULL,
  `niveau_scolaire` varchar(255) DEFAULT NULL,
  `cvforum` varchar(255) DEFAULT 'aucun',
  `description` varchar(255) DEFAULT NULL,
  `descriptionshort` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `nbr_experience` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `numtel` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `datenaissance` datetime DEFAULT NULL,
  PRIMARY KEY (`idclient`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idclient`, `location`, `niveau_scolaire`, `cvforum`, `description`, `descriptionshort`, `email`, `login`, `nbr_experience`, `nom`, `numtel`, `password`, `prenom`, `type`, `datenaissance`) VALUES
(1, 'mednine', 'bac+5', 'cv.pdf', 'Titulaire étudiant en 2ème année Master Professionnel en Ingénierie des systèmes d’information et aide à la prise des décisions, diplômé en informatique spécialité en informatique et développement en 2017. C’est avec sérieux et autonomie que j’ai mené à b', NULL, 'oussama.belhouchette@gmail.com', 'oussama', 2, 'oussama', 54319765, 'oussama', 'belhouchette', NULL, NULL),
(2, 'mednine', 'bac+3', 'cv.pdf', 'Titulaire étudiant en 2ème année Master Professionnel en Ingénierie des systèmes d’information et aide à la prise des décisions, diplômé en informatique spécialité en informatique et développement en 2017. C’est avec sérieux et autonomie que j’ai mené à b', NULL, 'ihsen.drine@gmail.com', 'ihsen', 3, 'ihsen', 22145789, 'ihsen', 'drine', NULL, NULL),
(3, 'sfax', 'bac+5', 'cv1.pdf', 'Titulaire étudiant en 2ème année Master Professionnel en Ingénierie des systèmes d’information et aide à la prise des décisions, diplômé en informatique spécialité en informatique et développement en 2017. C’est avec sérieux et autonomie que j’ai mené à b', NULL, 'mejdi.hafiene@gmail.com', 'mejdi', 1, 'mejdi', 99801210, 'mejdi', 'hafien', NULL, NULL),
(4, 'mednin', 'bac+3', 'cv_Amin.pdf', 'Titulaire étudiant en 2ème année Master Professionnel en Ingénierie des systèmes d’information et aide à la prise des décisions, diplômé en informatique spécialité en informatique et développement en 2017. C’est avec sérieux et autonomie que j’ai mené à b', NULL, 'amin.jmil@gmail.com', 'amin', 4, 'amin', 24063145, 'amin', 'jmil', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `coments`
--

CREATE TABLE IF NOT EXISTS `coments` (
  `idcoment` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `idclient` int(11) DEFAULT NULL,
  PRIMARY KEY (`idcoment`),
  KEY `FKr1mxrv4vlsfrof17bneadxpah` (`idclient`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=30 ;

--
-- Contenu de la table `coments`
--

INSERT INTO `coments` (`idcoment`, `message`, `idclient`) VALUES
(1, 'good job bro', 1),
(2, 'good', 1),
(3, 'good', 1),
(4, 'good', 1),
(5, 'good work', 1),
(6, 'good work man', 1),
(7, 'bad work', 1),
(8, 'bad work', 1),
(9, 'very bed', 1),
(10, 'very bad', 1),
(11, 'very bad', 1),
(12, 'bad', 1),
(13, 'good job', 1),
(14, 'very good', 1),
(15, 'good good', 1),
(16, 'very good', 1),
(17, 'bad', 1),
(18, 'good job', 1),
(19, 'good job', 1),
(20, 'bad job', 1),
(21, 'bad', 1),
(22, 'bad', 1),
(23, 'tres bien', 1),
(24, 'excellent ', 2),
(25, 'bien', 2),
(26, 'good', 3),
(27, 'good job', 4),
(28, 'good job', 2),
(29, 'good job', 1);

-- --------------------------------------------------------

--
-- Structure de la table `demande`
--

CREATE TABLE IF NOT EXISTS `demande` (
  `id_demande` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `exigences` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `experience` int(11) NOT NULL,
  `niveau` varchar(255) DEFAULT NULL,
  `post` varchar(255) DEFAULT NULL,
  `salairemax` int(11) NOT NULL,
  `identreprise` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_demande`),
  KEY `FKi8y2pi7bcb1pn9b31pkmppkc6` (`identreprise`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=50 ;

--
-- Contenu de la table `demande`
--

INSERT INTO `demande` (`id_demande`, `description`, `exigences`, `adress`, `experience`, `niveau`, `post`, `salairemax`, `identreprise`) VALUES
(28, 'Geeks data est un éditeur logiciel spécialisé en Data science / MachineLearning et développement applicatif présente en Tunisie, nous recherchons un profil (H/F), qui aura pour principales missions ; \n \n -La recherche via internet des opportunités d’aff', '', 'tunis', 2, 'bac+5', 'Data science', 750, 1),
(30, 'The name think tank stands for innovations - achievements that can be learned.\r\n \r\n As a forward-looking IT consultancy and development company we provide our customers with innovative and solution-oriented solutions\r\n \r\n In the field of specialist proces', '', 'sfax', 3, 'bac+5', 'programeur', 1200, 1),
(31, 'Geeks data est un éditeur logiciel spécialisé en Data science / MachineLearning et développement applicatif présente en Tunisie, nous recherchons un profil (H/F), qui aura pour principales missions ; ', '', 'sfax', 7, 'bac+3', 'programeur', 455, 1),
(49, 'gf', '', 'yj', 4, 'gf', 'g', 250, 1);

-- --------------------------------------------------------

--
-- Structure de la table `entreprise`
--

CREATE TABLE IF NOT EXISTS `entreprise` (
  `identreprise` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) DEFAULT NULL,
  `nomentreprise` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`identreprise`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `entreprise`
--

INSERT INTO `entreprise` (`identreprise`, `login`, `nomentreprise`, `password`) VALUES
(1, 'googl', 'Acm', 'google');

-- --------------------------------------------------------

--
-- Structure de la table `experience`
--

CREATE TABLE IF NOT EXISTS `experience` (
  `idexperience` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `datedebut` varchar(255) DEFAULT NULL,
  `datefin` varchar(255) DEFAULT NULL,
  `nomentreprise` varchar(255) DEFAULT NULL,
  `idclient` int(11) DEFAULT NULL,
  PRIMARY KEY (`idexperience`),
  KEY `FKppc3tuejs6b5aq11mn28kdhcg` (`idclient`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `id_formation` int(11) NOT NULL AUTO_INCREMENT,
  `descriptionformation` varchar(255) DEFAULT NULL,
  `locationformation` varchar(255) DEFAULT NULL,
  `datedebutformation` varchar(255) DEFAULT NULL,
  `datefinformation` varchar(255) DEFAULT NULL,
  `institue` varchar(255) DEFAULT NULL,
  `idclient` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_formation`),
  KEY `FKet5efwt1skinkcl19q10v1fa4` (`idclient`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `formation`
--

INSERT INTO `formation` (`id_formation`, `descriptionformation`, `locationformation`, `datedebutformation`, `datefinformation`, `institue`, `idclient`) VALUES
(1, 'Etudiant – Licence Fondamentale en Informatique de Gestion', 'sfax', '01/01/2015', '10/10/2018', 'Faculté des Sciences Economiques et des Gestions de Sfax (FSEGS)', 4),
(2, '\r\n \r\n Baccalauréat Sciences Informatique -', 'mednine', '01/01/2014', '01/01/2015', 'Lycée Rue de Gabes  Médenine', 4),
(3, 'Ingénierie des systèmes d''information et aide a la pris', 'sfax', '01/09/2018', '01/10/2019', 'Faculté des Sciences Economiques et des Gestions de Sfax', 1),
(4, 'Licence Fondamentale en Informatique de Gestion', 'sfax', '15/09/2015', '01/10/2017', 'Faculté des Sciences Economiques et des Gestions de Sfax', 1),
(5, 'Baccalauréat Baccalauréat Sciences Informatique Mention assez Bien', 'mednine', '15/09/2014', '30/10/2015', 'Lycée Rue de benkdach Médenin', 1),
(6, ' Licence Fondamentale en Informatique de Gestion', 'sfax', '2015', '2018', 'fsegs', 2),
(7, 'Baccalauréat en sciences informatique', 'mednine', '2014', '2015', 'Lycée secondaire route de gabes', 2),
(8, 'Etudié en 2em année Master Professionnelle en Ingénierie Système d’Information et d’aide à la prise de décisio', 'sfax', '2017', '2019', 'fsegs', 3),
(9, ' Diplôme en informatique et développement', ' Nouakchott-Mauritanie', '2014', '2017', 'Institut supérieur de comptabilité et d’administration des entreprises (ISCAE)', 3);

-- --------------------------------------------------------

--
-- Structure de la table `langue`
--

CREATE TABLE IF NOT EXISTS `langue` (
  `idlangue` int(11) NOT NULL AUTO_INCREMENT,
  `langue` varchar(255) DEFAULT NULL,
  `idclient` int(11) DEFAULT NULL,
  PRIMARY KEY (`idlangue`),
  KEY `FKpwgfc4o0jl5crncqp86y12834` (`idclient`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `skilpardemande`
--

CREATE TABLE IF NOT EXISTS `skilpardemande` (
  `idskilsdemande` int(11) NOT NULL AUTO_INCREMENT,
  `skilsdemande` varchar(255) DEFAULT NULL,
  `id_demande` int(11) DEFAULT NULL,
  PRIMARY KEY (`idskilsdemande`),
  KEY `FKaeg48vrspynho8istag9ym1lh` (`id_demande`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=38 ;

--
-- Contenu de la table `skilpardemande`
--

INSERT INTO `skilpardemande` (`idskilsdemande`, `skilsdemande`, `id_demande`) VALUES
(28, 'java-ee', 30),
(30, 'mysql', 30),
(31, 'JAVA', 31),
(36, 'java', 49),
(37, 'java', 49);

-- --------------------------------------------------------

--
-- Structure de la table `skils`
--

CREATE TABLE IF NOT EXISTS `skils` (
  `id_skils` int(11) NOT NULL AUTO_INCREMENT,
  `skil` varchar(255) DEFAULT NULL,
  `idclient` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_skils`),
  KEY `FKec7oip6yaw4b6f4ef426bogwd` (`idclient`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `skils`
--

INSERT INTO `skils` (`id_skils`, `skil`, `idclient`) VALUES
(1, 'java', 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
