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
) ENGINE=InnoDB AUTO_INCREMENT=163 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `polozka`
--

LOCK TABLES `polozka` WRITE;
/*!40000 ALTER TABLE `polozka` DISABLE KEYS */;
INSERT INTO `polozka` VALUES (104,54,1,1),(131,105,2,4),(132,106,3,4),(133,107,4,1),(134,108,5,2),(135,109,6,3),(136,110,7,2),(137,111,8,7),(138,112,9,7),(140,114,11,5),(141,115,12,2),(142,116,13,5),(143,117,14,4),(144,118,15,4),(145,119,16,7),(146,120,5,2),(147,121,8,2),(148,122,7,8),(149,123,9,1),(150,124,6,4),(151,125,8,4),(152,126,10,4),(153,127,11,5),(154,128,12,1),(155,129,13,8),(156,129,14,5),(157,128,10,1),(160,130,1,5),(161,129,1,5),(162,129,1,5);
/*!40000 ALTER TABLE `polozka` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-10 21:04:45
