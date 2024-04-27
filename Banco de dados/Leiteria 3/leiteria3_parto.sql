-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: leiteria3
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `parto`
--

DROP TABLE IF EXISTS `parto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parto` (
  `id_parto` bigint NOT NULL AUTO_INCREMENT,
  `vaca_id` bigint NOT NULL,
  `cobertura_id` bigint DEFAULT NULL,
  `prenhez_id` bigint DEFAULT NULL,
  `tipo_parto_id` int NOT NULL,
  `data` date NOT NULL,
  `escore_corporal` float DEFAULT NULL,
  `qtde_crias` int NOT NULL,
  `observacao` varchar(1337) DEFAULT NULL,
  PRIMARY KEY (`id_parto`),
  KEY `partos_fk0` (`vaca_id`),
  KEY `partos_fk1` (`cobertura_id`),
  KEY `partos_fk2` (`prenhez_id`),
  KEY `fk_partos_tipos_parto1_idx` (`tipo_parto_id`),
  CONSTRAINT `fk_partos_tipos_parto1` FOREIGN KEY (`tipo_parto_id`) REFERENCES `tipo_parto` (`id_tipo_parto`),
  CONSTRAINT `partos_fk0` FOREIGN KEY (`vaca_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `partos_fk1` FOREIGN KEY (`cobertura_id`) REFERENCES `cobertura` (`id_cobertura`),
  CONSTRAINT `partos_fk2` FOREIGN KEY (`prenhez_id`) REFERENCES `diagnostico_prenhez` (`id_diagnostico`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parto`
--

LOCK TABLES `parto` WRITE;
/*!40000 ALTER TABLE `parto` DISABLE KEYS */;
INSERT INTO `parto` VALUES (9,5,NULL,NULL,1,'2023-12-05',4,1,NULL),(10,7,3,3,2,'2023-12-05',3.5,1,NULL),(11,5,4,4,1,'2023-12-06',4,2,NULL);
/*!40000 ALTER TABLE `parto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-06 19:51:49
