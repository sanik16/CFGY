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
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vazba_trening`
--

LOCK TABLES `vazba_trening` WRITE;
/*!40000 ALTER TABLE `vazba_trening` DISABLE KEYS */;
INSERT INTO `vazba_trening` VALUES (20,1,19),(21,1,14),(22,1,25),(23,1,23),(24,1,22),(25,1,10),(26,1,21),(27,1,20),(28,2,19),(29,2,18),(30,2,17),(31,2,16),(32,2,15),(33,4,14),(34,4,13),(35,4,12),(36,4,11),(37,4,10),(54,1,10),(55,1,10),(56,1,10),(57,1,10),(58,1,10),(59,1,10),(60,1,11),(61,1,12),(62,1,13),(63,2,15),(64,2,10),(65,2,10),(66,2,14),(67,4,11),(68,4,13),(69,4,14),(70,4,15),(71,4,10);
/*!40000 ALTER TABLE `vazba_trening` ENABLE KEYS */;
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
