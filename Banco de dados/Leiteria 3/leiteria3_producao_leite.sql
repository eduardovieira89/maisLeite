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
-- Table structure for table `producao_leite`
--

DROP TABLE IF EXISTS `producao_leite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producao_leite` (
  `id_producao` bigint NOT NULL AUTO_INCREMENT,
  `lactacao_id` bigint NOT NULL,
  `ordenha_1` float NOT NULL,
  `ordenha_2` float DEFAULT NULL,
  `ordenha_3` float DEFAULT NULL,
  `controle_leiteiro_id` bigint NOT NULL,
  PRIMARY KEY (`id_producao`),
  KEY `fk_producao_leite_lactacoes1_idx` (`lactacao_id`),
  KEY `fk_producao_leite_controle_leiteiro1_idx` (`controle_leiteiro_id`),
  CONSTRAINT `fk_producao_leite_controle_leiteiro1` FOREIGN KEY (`controle_leiteiro_id`) REFERENCES `controle_leiteiro` (`id_controle_leiteiro`),
  CONSTRAINT `fk_producao_leite_lactacoes1` FOREIGN KEY (`lactacao_id`) REFERENCES `lactacao` (`id_lactacao`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producao_leite`
--

LOCK TABLES `producao_leite` WRITE;
/*!40000 ALTER TABLE `producao_leite` DISABLE KEYS */;
INSERT INTO `producao_leite` VALUES (1,3,21,23,0,3),(2,4,20,22,0,3),(3,5,15,18,0,4),(4,4,20,17,0,4);
/*!40000 ALTER TABLE `producao_leite` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-06 19:51:51
