CREATE DATABASE  IF NOT EXISTS `cfgym` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `cfgym`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: cfgym
-- ------------------------------------------------------
-- Server version	5.7.11-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aktualna_perma`
--

DROP TABLE IF EXISTS `aktualna_perma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aktualna_perma` (
  `id_aktualna_perma` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_perma` int(11) DEFAULT NULL,
  `kupena` date DEFAULT NULL,
  `platna_do` date DEFAULT NULL,
  PRIMARY KEY (`id_aktualna_perma`),
  KEY `id_user` (`id_user`),
  KEY `id_perma` (`id_perma`),
  CONSTRAINT `aktualna_perma_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `aktualna_perma_ibfk_2` FOREIGN KEY (`id_perma`) REFERENCES `perma` (`id_perma`)
) ENGINE=InnoDB AUTO_INCREMENT=718 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aktualna_perma`
--

LOCK TABLES `aktualna_perma` WRITE;
/*!40000 ALTER TABLE `aktualna_perma` DISABLE KEYS */;
INSERT INTO `aktualna_perma` VALUES (700,1,502,'2016-03-01','2016-04-01'),(715,2,501,'2016-01-01','2016-01-08'),(716,3,503,'2016-01-01','2017-01-01'),(717,4,502,'2016-02-01','2016-03-01');
/*!40000 ALTER TABLE `aktualna_perma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objednavka`
--

DROP TABLE IF EXISTS `objednavka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objednavka` (
  `id_objednavka` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `datum_objednavky` date DEFAULT NULL,
  PRIMARY KEY (`id_objednavka`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `objednavka_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objednavka`
--

LOCK TABLES `objednavka` WRITE;
/*!40000 ALTER TABLE `objednavka` DISABLE KEYS */;
INSERT INTO `objednavka` VALUES (54,1,'2014-01-16'),(105,1,'2013-02-16'),(106,1,'2011-11-16'),(107,1,'2011-11-16'),(108,1,'2013-01-01'),(109,1,'2013-07-16'),(110,1,'2014-11-23'),(111,1,'2015-01-17'),(112,1,'2015-04-28'),(113,1,'2015-02-28'),(114,1,'2015-12-16'),(115,1,'2015-09-12'),(116,1,'2016-04-25'),(117,2,'2016-01-16'),(118,2,'2016-01-17'),(119,2,'2015-01-18'),(120,2,'2015-01-19'),(121,2,'2015-01-11'),(122,2,'2015-01-10'),(123,554,'2008-08-08'),(124,554,'2009-01-16'),(125,554,'2011-11-16'),(126,554,'2010-01-16'),(127,4,'2016-01-28'),(128,4,'2011-08-16'),(129,4,'2011-01-25'),(130,4,'2011-01-16');
/*!40000 ALTER TABLE `objednavka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perma`
--

DROP TABLE IF EXISTS `perma`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perma` (
  `id_perma` int(11) NOT NULL AUTO_INCREMENT,
  `perma_meno` varchar(55) DEFAULT NULL,
  `perma_cena` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_perma`)
) ENGINE=InnoDB AUTO_INCREMENT=504 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perma`
--

LOCK TABLES `perma` WRITE;
/*!40000 ALTER TABLE `perma` DISABLE KEYS */;
INSERT INTO `perma` VALUES (500,'Jednovstupova',4),(501,'Tyzdenna',20),(502,'Mesacna',40),(503,'Celorocna',450);
/*!40000 ALTER TABLE `perma` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `platba_permy`
--

DROP TABLE IF EXISTS `platba_permy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `platba_permy` (
  `id_platba_permy` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_perma` int(11) DEFAULT NULL,
  `zaplatena` date DEFAULT NULL,
  PRIMARY KEY (`id_platba_permy`),
  KEY `id_user` (`id_user`),
  KEY `id_perma` (`id_perma`),
  CONSTRAINT `platba_permy_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `platba_permy_ibfk_2` FOREIGN KEY (`id_perma`) REFERENCES `perma` (`id_perma`)
) ENGINE=InnoDB AUTO_INCREMENT=621 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `platba_permy`
--

LOCK TABLES `platba_permy` WRITE;
/*!40000 ALTER TABLE `platba_permy` DISABLE KEYS */;
INSERT INTO `platba_permy` VALUES (600,1,503,'2011-01-01'),(601,1,502,'2012-01-01'),(602,1,502,'2012-02-01'),(603,1,502,'2012-03-01'),(604,1,502,'2015-01-01'),(605,1,502,'2015-09-01'),(606,1,502,'2015-10-01'),(607,1,501,'2015-11-01'),(608,1,501,'2016-01-01'),(609,1,501,'2016-02-01'),(610,1,501,'2016-03-01'),(611,2,500,'2015-08-01'),(612,2,500,'2015-05-01'),(613,2,500,'2015-03-01'),(614,2,502,'2015-01-01'),(615,2,502,'2015-01-01'),(616,4,500,'2015-05-01'),(617,4,501,'2015-07-01'),(618,4,502,'2015-09-01'),(619,4,502,'2015-11-01'),(620,4,502,'2016-01-01');
/*!40000 ALTER TABLE `platba_permy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `polozka`
--

DROP TABLE IF EXISTS `polozka`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `polozka` (
  `id_polozka` int(11) NOT NULL AUTO_INCREMENT,
  `id_objednavka` int(11) NOT NULL,
  `id_produkt` int(11) NOT NULL,
  `pocet_kusov` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_polozka`),
  KEY `id_objednavka` (`id_objednavka`),
  KEY `id_produkt` (`id_produkt`),
  CONSTRAINT `polozka_ibfk_1` FOREIGN KEY (`id_objednavka`) REFERENCES `objednavka` (`id_objednavka`),
  CONSTRAINT `polozka_ibfk_2` FOREIGN KEY (`id_produkt`) REFERENCES `produkt` (`id_produkt`)
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polozka`
--

LOCK TABLES `polozka` WRITE;
/*!40000 ALTER TABLE `polozka` DISABLE KEYS */;
INSERT INTO `polozka` VALUES (104,54,1,1),(131,105,2,4),(132,106,3,4),(133,107,4,1),(134,108,5,2),(135,109,6,3),(136,110,7,2),(137,111,8,7),(138,112,9,7),(140,114,11,5),(141,115,12,2),(142,116,13,5),(143,117,14,4),(144,118,15,4),(145,119,16,7),(146,120,5,2),(147,121,8,2),(148,122,7,8),(149,123,9,1),(150,124,6,4),(151,125,8,4),(152,126,10,4),(153,127,11,5),(154,128,12,1),(155,129,13,8),(156,129,14,5),(157,128,10,1),(160,130,1,5),(161,129,1,5),(162,129,1,5),(163,129,1,5);
/*!40000 ALTER TABLE `polozka` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produkt`
--

DROP TABLE IF EXISTS `produkt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produkt` (
  `id_produkt` int(11) NOT NULL AUTO_INCREMENT,
  `nazov_produktu` text,
  `cena` double DEFAULT NULL,
  PRIMARY KEY (`id_produkt`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produkt`
--

LOCK TABLES `produkt` WRITE;
/*!40000 ALTER TABLE `produkt` DISABLE KEYS */;
INSERT INTO `produkt` VALUES (1,'Nike_1',30.99),(2,'Nike_run',41.55),(3,'Nike_lift',65.3),(4,'Nike_train',55.89),(5,'Nike_walk',25.29),(6,'Nike_prof',25.64),(7,'Nike_wear',155.78),(8,'Shorts_run',47.41),(9,'Shorts_train',58.58),(10,'Shorts_wear',64.44),(11,'Shirt_train',51.51),(12,'Shirt_wear',31.35),(13,'Shirt_lift',65.69),(14,'Shirt_run',88.05),(15,'Shirt_alter',103.03),(16,'Shirt_spec',128.99);
/*!40000 ALTER TABLE `produkt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profil`
--

DROP TABLE IF EXISTS `profil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profil` (
  `id_profil` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `heigh` int(11) DEFAULT NULL,
  `bench` int(11) DEFAULT NULL,
  `back` int(11) DEFAULT NULL,
  `front` int(11) DEFAULT NULL,
  `clean` int(11) DEFAULT NULL,
  `snatch` int(11) DEFAULT NULL,
  `pull` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_profil`),
  KEY `id_user` (`id_user`),
  CONSTRAINT `profil_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `profil_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `profil_ibfk_3` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profil`
--

LOCK TABLES `profil` WRITE;
/*!40000 ALTER TABLE `profil` DISABLE KEYS */;
INSERT INTO `profil` VALUES (1,1,84,174,152,124,178,132,45,32),(2,3,100,184,100,150,130,90,60,20),(54,2,55,172,30,60,30,20,25,5),(55,4,74,185,65,100,80,60,50,25),(56,550,95,180,130,200,152,100,85,35),(57,551,85,95,105,142,152,95,55,12),(58,552,84,54,65,32,45,541,212,21),(59,6,54,54,54,8,87,98,98,54),(60,5,454,185,78,98,35,314,548,453),(61,549,65,56,78,87,98,87,47,48),(62,553,32,23,21,24,25,26,28,29),(63,NULL,1,1,1,1,1,1,1,1);
/*!40000 ALTER TABLE `profil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treningy`
--

DROP TABLE IF EXISTS `treningy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `treningy` (
  `id_trening` int(11) NOT NULL AUTO_INCREMENT,
  `id_typ_treningu` int(11) DEFAULT NULL,
  `pocet_cvicencov` int(11) DEFAULT NULL,
  `zaciatok` datetime DEFAULT NULL,
  `koniec` datetime DEFAULT NULL,
  `pocet_akt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_trening`),
  KEY `id_typ_treningu` (`id_typ_treningu`),
  CONSTRAINT `treningy_ibfk_1` FOREIGN KEY (`id_typ_treningu`) REFERENCES `typ_treningu` (`id_typ_treningu`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treningy`
--

LOCK TABLES `treningy` WRITE;
/*!40000 ALTER TABLE `treningy` DISABLE KEYS */;
INSERT INTO `treningy` VALUES (10,1,20,NULL,NULL,5),(11,1,20,NULL,NULL,9),(12,1,20,NULL,NULL,7),(13,1,20,NULL,NULL,15),(14,1,20,NULL,NULL,20),(15,1,20,NULL,NULL,7),(16,1,20,NULL,NULL,17),(17,1,20,NULL,NULL,18),(18,2,20,NULL,NULL,16),(19,2,20,NULL,NULL,3),(20,2,20,NULL,NULL,5),(21,2,20,NULL,NULL,6),(22,2,20,NULL,NULL,8),(23,2,20,NULL,NULL,7),(24,3,15,NULL,NULL,9),(25,3,15,NULL,NULL,12),(26,3,15,NULL,NULL,13),(27,3,15,NULL,NULL,18),(28,3,15,NULL,NULL,3),(29,3,15,NULL,NULL,4),(30,1,20,NULL,NULL,12),(31,1,20,NULL,NULL,12),(32,1,20,NULL,NULL,12),(33,1,20,NULL,NULL,8),(34,1,20,NULL,NULL,5),(35,1,20,NULL,NULL,5),(36,1,20,NULL,NULL,11),(37,1,20,NULL,NULL,19),(38,1,20,NULL,NULL,19),(39,1,20,NULL,NULL,19),(40,1,20,NULL,NULL,19),(41,1,20,NULL,NULL,18),(42,4,20,NULL,NULL,6),(43,1,20,NULL,NULL,18);
/*!40000 ALTER TABLE `treningy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typ_treningu`
--

DROP TABLE IF EXISTS `typ_treningu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typ_treningu` (
  `id_typ_treningu` int(11) NOT NULL AUTO_INCREMENT,
  `nazov_treningu` varchar(21) DEFAULT NULL,
  PRIMARY KEY (`id_typ_treningu`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typ_treningu`
--

LOCK TABLES `typ_treningu` WRITE;
/*!40000 ALTER TABLE `typ_treningu` DISABLE KEYS */;
INSERT INTO `typ_treningu` VALUES (1,'Crossfit'),(2,'OpenGym'),(3,'Begginers'),(4,'Lifting'),(5,'Yoga'),(6,'Competitors');
/*!40000 ALTER TABLE `typ_treningu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `skill` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=562 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Alexadner','Pajkos','Alexej','alexander.pajkos@gmail.com','1995-01-16',0),(2,'Michaela','Onufrakova','Miska','michaela.onufrakova@gmail.com','1994-12-06',0),(3,'Milan','Balko','Balky','balko.milan@gmail.com','1994-08-02',0),(4,'Peter','Pajkos','Petrik','peter.pajkos@gmail.com','1990-02-24',0),(5,'Roman','Kohut','Kohut','roman.kohut.centrum.sk','1997-12-03',0),(6,'Martin','Borek','Borek','borek.martin@hotmail.com','1994-10-17',0),(546,'Igor','Onufrak','Igor','igor.onufrak@centrum.sk','1990-10-15',0),(547,'Dasa','Onufrakova','Dasa','dasa.onufrak@centrum.sk','1989-10-15',0),(548,'Stefan','Dano','Stefan','stefan.dano@centrum.sk','1995-07-13',0),(549,'Stanislav','Murdzik','Stanko','stano.murdzik@centrum.sk','1994-09-10',0),(550,'Filip','Herman','Filka','filip.herman@gmail.com','1994-08-10',0),(551,'Patrik','Belej','Hunka','patrik.belej@gmail.com','1995-08-24',0),(552,'Tomas','Pirohanic','Piroh','piroh.tomas@gmail.com','1995-12-24',0),(553,'Miro','Hucko','Mirec','miro.hucko@gmail.com','1995-05-20',0),(554,'Michal','Pajkos','Mechal','michal.pajkos@gmail.com','1988-07-11',0),(555,'Michal','Bogdan','Michal','michal.bogdan@gmail.com','1994-07-28',0),(556,'Karolina','Wozniak','Karka','kaja.wozniak@gmail.com','1994-11-28',0),(557,'Jana','Kulikova','Janka','jana.pajkosova@gmail.com','1988-11-28',0),(558,'Vladka','Antolikova','Lado','vladka.antolikova@gmail.com','1995-11-28',0),(559,'Martin','Bicko','Martinko','martin.bicko@gmail.com','1995-07-31',0),(560,'Maros','Cobirka','Marosko','maros.cobirka@gmail.com','1995-01-17',0),(561,'Jozko','Du','Dodo','dodo@zoznam.sk',NULL,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vazba_trening`
--

DROP TABLE IF EXISTS `vazba_trening`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vazba_trening` (
  `id_vazba_trening` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) DEFAULT NULL,
  `id_trening` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_vazba_trening`),
  KEY `id_user` (`id_user`),
  KEY `id_trening` (`id_trening`),
  CONSTRAINT `vazba_trening_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`),
  CONSTRAINT `vazba_trening_ibfk_2` FOREIGN KEY (`id_trening`) REFERENCES `treningy` (`id_trening`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vazba_trening`
--

LOCK TABLES `vazba_trening` WRITE;
/*!40000 ALTER TABLE `vazba_trening` DISABLE KEYS */;
INSERT INTO `vazba_trening` VALUES (20,1,19),(21,1,14),(22,1,25),(23,1,23),(24,1,22),(25,1,10),(26,1,21),(27,1,20),(28,2,19),(29,2,18),(30,2,17),(31,2,16),(32,2,15),(33,4,14),(34,4,13),(35,4,12),(36,4,11),(37,4,10),(54,1,10),(55,1,10),(56,1,10),(57,1,10),(58,1,10),(59,1,10),(60,1,11),(61,1,12),(62,1,13),(63,2,15),(64,2,10),(65,2,10),(66,2,14),(67,4,11),(68,4,13),(69,4,14),(70,4,15),(71,4,10),(72,1,36),(73,1,40),(74,1,41),(75,1,42),(76,1,43);
/*!40000 ALTER TABLE `vazba_trening` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'cfgym'
--

--
-- Dumping routines for database 'cfgym'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-14 13:46:48
