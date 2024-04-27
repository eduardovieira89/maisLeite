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
-- Table structure for table `lactacao`
--

DROP TABLE IF EXISTS `lactacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lactacao` (
  `id_lactacao` bigint NOT NULL AUTO_INCREMENT,
  `inicio` date NOT NULL,
  `encerramento` date DEFAULT NULL,
  `finalizado` tinyint DEFAULT NULL,
  `observacao` varchar(1337) DEFAULT NULL,
  `causa_enc_lactacao_id` int DEFAULT NULL,
  `parto_id` bigint NOT NULL,
  PRIMARY KEY (`id_lactacao`),
  KEY `fk_lactacao_causa_enc_lactacao1_idx` (`causa_enc_lactacao_id`),
  KEY `fk_lactacao_partos1_idx` (`parto_id`),
  CONSTRAINT `fk_lactacao_causa_enc_lactacao1` FOREIGN KEY (`causa_enc_lactacao_id`) REFERENCES `causa_encerramento_lactacao` (`id_causa_encerramento`),
  CONSTRAINT `fk_lactacao_partos1` FOREIGN KEY (`parto_id`) REFERENCES `parto` (`id_parto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lactacao`
--

LOCK TABLES `lactacao` WRITE;
/*!40000 ALTER TABLE `lactacao` DISABLE KEYS */;
INSERT INTO `lactacao` VALUES (3,'2023-12-05','2023-12-06',1,NULL,1,9),(4,'2023-12-05',NULL,0,NULL,NULL,10),(5,'2023-12-06','2023-12-06',1,NULL,1,11);
/*!40000 ALTER TABLE `lactacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-06 19:51:50
