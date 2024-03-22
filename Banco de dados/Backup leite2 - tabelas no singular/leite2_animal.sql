-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: leite2
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `id_animal` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `brinco` int NOT NULL,
  `data_nasc` date NOT NULL,
  `registro` bigint DEFAULT NULL,
  `sexo` char(1) NOT NULL,
  `pai` varchar(60) DEFAULT NULL,
  `mae` varchar(60) DEFAULT NULL,
  `id_raca` int NOT NULL,
  `id_propriedade` bigint NOT NULL,
  `id_pai` bigint DEFAULT NULL,
  `id_mae` bigint DEFAULT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `animal_fk0` (`id_raca`),
  KEY `animal_fk1` (`id_propriedade`),
  KEY `animal_fk2` (`id_pai`),
  KEY `animal_fk3` (`id_mae`),
  CONSTRAINT `animal_fk0` FOREIGN KEY (`id_raca`) REFERENCES `raca` (`id_raca`),
  CONSTRAINT `animal_fk1` FOREIGN KEY (`id_propriedade`) REFERENCES `propriedade` (`id_propriedade`),
  CONSTRAINT `animal_fk2` FOREIGN KEY (`id_pai`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `animal_fk3` FOREIGN KEY (`id_mae`) REFERENCES `animal` (`id_animal`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'Joselino',10,'2020-01-01',201,'m',NULL,NULL,1,1,NULL,NULL),(2,'Mimosa',11,'2017-01-01',212121,'f',NULL,NULL,1,1,NULL,NULL),(3,'Charmosa',50,'2021-04-22',222,'f','Joselino','Mimosa',1,1,NULL,2),(4,'Malu',12,'2015-03-30',852143,'f',NULL,NULL,2,4,1,NULL),(5,'Celi',13,'2014-04-20',215874,'f',NULL,NULL,2,4,1,NULL),(6,'Pintada',14,'2016-03-01',474125,'f',NULL,NULL,1,4,NULL,NULL),(7,'Saralii',21,'2021-05-05',3728900,'f','Joselino','Mimosa',1,1,10,2),(8,'Manquinha',76,'2021-05-23',2234765,'f','Joselino','Mimosa',1,1,NULL,NULL),(9,'Malu2',98776,'2020-06-27',45690874,'f',NULL,NULL,2,4,NULL,NULL),(10,'Pintado',85,'2019-06-04',98196213,'m','Joselino','Mimosa',1,1,NULL,NULL),(11,'Ferdinando',235,'2018-08-24',84795,'m','Touro Ferdinando','Pintadinha',6,4,NULL,NULL),(12,'Bagolino',792,'2020-02-12',234566,'m',NULL,NULL,4,4,11,4),(13,NULL,23,'2013-06-17',15134567,'f','Maltazer','Magrinha',2,2,NULL,NULL),(32,'Vaquinha',3075,'2022-05-03',3899976,'f','Touro emprestado do vizinho',NULL,5,1,1,8);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-13 21:52:57
