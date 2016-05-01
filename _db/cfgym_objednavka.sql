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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-10 21:04:46
