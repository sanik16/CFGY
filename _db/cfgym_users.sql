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
) ENGINE=InnoDB AUTO_INCREMENT=561 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Alexadner','Pajkos','Alexej','alexander.pajkos@gmail.com','1995-01-16',0),(2,'Michaela','Onufrakova','Miska','michaela.onufrakova@gmail.com','1994-12-06',0),(3,'Milan','Balko','Balky','balko.milan@gmail.com','1994-08-02',0),(4,'Peter','Pajkos','Petrik','peter.pajkos@gmail.com','1990-02-24',0),(5,'Roman','Kohut','Kohut','roman.kohut.centrum.sk','1997-12-03',0),(6,'Martin','Borek','Borek','borek.martin@hotmail.com','1994-10-17',0),(546,'Igor','Onufrak','Igor','igor.onufrak@centrum.sk','1990-10-15',0),(547,'Dasa','Onufrakova','Dasa','dasa.onufrak@centrum.sk','1989-10-15',0),(548,'Stefan','Dano','Stefan','stefan.dano@centrum.sk','1995-07-13',0),(549,'Stanislav','Murdzik','Stanko','stano.murdzik@centrum.sk','1994-09-10',0),(550,'Filip','Herman','Filka','filip.herman@gmail.com','1994-08-10',0),(551,'Patrik','Belej','Hunka','patrik.belej@gmail.com','1995-08-24',0),(552,'Tomas','Pirohanic','Piroh','piroh.tomas@gmail.com','1995-12-24',0),(553,'Miro','Hucko','Mirec','miro.hucko@gmail.com','1995-05-20',0),(554,'Michal','Pajkos','Mechal','michal.pajkos@gmail.com','1988-07-11',0),(555,'Michal','Bogdan','Michal','michal.bogdan@gmail.com','1994-07-28',0),(556,'Karolina','Wozniak','Karka','kaja.wozniak@gmail.com','1994-11-28',0),(557,'Jana','Kulikova','Janka','jana.pajkosova@gmail.com','1988-11-28',0),(558,'Vladka','Antolikova','Lado','vladka.antolikova@gmail.com','1995-11-28',0),(559,'Martin','Bicko','Martinko','martin.bicko@gmail.com','1995-07-31',0),(560,'Maros','Cobirka','Marosko','maros.cobirka@gmail.com','1995-01-17',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
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
