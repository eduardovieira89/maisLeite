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
-- Table structure for table `diagnostico_prenhez`
--

DROP TABLE IF EXISTS `diagnostico_prenhez`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnostico_prenhez` (
  `id_diagnostico` bigint NOT NULL AUTO_INCREMENT,
  `vaca_id` bigint NOT NULL,
  `metodo_prenhez_id` int NOT NULL,
  `cobertura_id` bigint DEFAULT NULL,
  `data` date NOT NULL,
  `diagnostico` tinyint NOT NULL,
  `observacao` varchar(1337) DEFAULT NULL,
  PRIMARY KEY (`id_diagnostico`),
  KEY `diagnosticos_prenhez_fk0` (`vaca_id`),
  KEY `diagnosticos_prenhez_fk1` (`cobertura_id`),
  KEY `fk_diagnosticos_prenhez_metodos_prenhez1_idx` (`metodo_prenhez_id`),
  CONSTRAINT `diagnosticos_prenhez_fk0` FOREIGN KEY (`vaca_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `diagnosticos_prenhez_fk1` FOREIGN KEY (`cobertura_id`) REFERENCES `cobertura` (`id_cobertura`),
  CONSTRAINT `fk_diagnosticos_prenhez_metodos_prenhez1` FOREIGN KEY (`metodo_prenhez_id`) REFERENCES `metodo_prenhez` (`id_metodo_prenhez`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico_prenhez`
--

LOCK TABLES `diagnostico_prenhez` WRITE;
/*!40000 ALTER TABLE `diagnostico_prenhez` DISABLE KEYS */;
INSERT INTO `diagnostico_prenhez` VALUES (3,7,1,3,'2023-12-05',1,NULL),(4,5,1,4,'2023-12-06',1,NULL);
/*!40000 ALTER TABLE `diagnostico_prenhez` ENABLE KEYS */;
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
