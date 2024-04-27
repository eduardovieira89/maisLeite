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
-- Table structure for table `cobertura`
--

DROP TABLE IF EXISTS `cobertura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cobertura` (
  `id_cobertura` bigint NOT NULL AUTO_INCREMENT,
  `vaca_id` bigint NOT NULL,
  `tipo_cobertura_id` int NOT NULL,
  `touro_monta_id` bigint DEFAULT NULL,
  `inseminador_id` bigint DEFAULT NULL,
  `semen_id` bigint DEFAULT NULL,
  `qtde_dose_semen` int DEFAULT NULL,
  `data` date NOT NULL,
  `monta_controlada` tinyint DEFAULT NULL,
  `escore_corporal` float DEFAULT NULL,
  `observacao` varchar(1337) DEFAULT NULL,
  PRIMARY KEY (`id_cobertura`),
  KEY `coberturas_fk1` (`vaca_id`),
  KEY `coberturas_fk2` (`touro_monta_id`),
  KEY `coberturas_fk3` (`inseminador_id`),
  KEY `coberturas_fk4` (`semen_id`),
  KEY `fk_coberturas_tipos_cobertura1_idx` (`tipo_cobertura_id`),
  CONSTRAINT `coberturas_fk1` FOREIGN KEY (`vaca_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `coberturas_fk2` FOREIGN KEY (`touro_monta_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `coberturas_fk3` FOREIGN KEY (`inseminador_id`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `coberturas_fk4` FOREIGN KEY (`semen_id`) REFERENCES `semen` (`id_semen`),
  CONSTRAINT `fk_coberturas_tipos_cobertura1` FOREIGN KEY (`tipo_cobertura_id`) REFERENCES `tipo_cobertura` (`id_tipo_cobertura`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cobertura`
--

LOCK TABLES `cobertura` WRITE;
/*!40000 ALTER TABLE `cobertura` DISABLE KEYS */;
INSERT INTO `cobertura` VALUES (3,7,2,NULL,2,2,2,'2023-12-05',NULL,3.5,NULL),(4,5,2,NULL,2,2,3,'2023-12-06',NULL,4,NULL),(5,5,2,NULL,2,2,3,'2024-03-25',NULL,3.5,NULL);
/*!40000 ALTER TABLE `cobertura` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-06 19:51:52
