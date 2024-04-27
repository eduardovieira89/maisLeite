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
-- Table structure for table `vacina_aplicacao`
--

DROP TABLE IF EXISTS `vacina_aplicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacina_aplicacao` (
  `id_aplicacao` int NOT NULL AUTO_INCREMENT,
  `dose` float NOT NULL,
  `data` date NOT NULL,
  `vacina_id` int NOT NULL,
  `animal_id` bigint NOT NULL,
  `aplicador_id` bigint NOT NULL,
  PRIMARY KEY (`id_aplicacao`),
  KEY `fk_vacina_aplicacao_vacinas1_idx` (`vacina_id`),
  KEY `fk_vacina_aplicacao_animais1_idx` (`animal_id`),
  KEY `fk_vacina_aplicacao_usuarios1_idx` (`aplicador_id`),
  CONSTRAINT `fk_vacina_aplicacao_animais1` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `fk_vacina_aplicacao_usuarios1` FOREIGN KEY (`aplicador_id`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `fk_vacina_aplicacao_vacinas1` FOREIGN KEY (`vacina_id`) REFERENCES `vacina` (`id_vacina`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina_aplicacao`
--

LOCK TABLES `vacina_aplicacao` WRITE;
/*!40000 ALTER TABLE `vacina_aplicacao` DISABLE KEYS */;
INSERT INTO `vacina_aplicacao` VALUES (1,1,'2023-12-08',1,5,2),(2,1,'2023-12-08',2,5,2),(3,1,'2024-02-21',1,5,2),(4,1,'2024-02-20',2,5,2),(8,7,'2024-03-11',1,5,2),(9,7,'2024-03-11',1,7,2),(10,4,'2024-03-10',1,6,2),(11,3,'2024-03-11',1,5,2),(12,3,'2024-03-11',1,7,2),(13,5,'2024-03-04',1,5,2),(14,5,'2024-03-04',1,7,2),(15,10,'2024-02-26',2,5,2),(16,10,'2024-02-26',2,7,2),(17,3,'2024-03-11',1,6,2),(18,3,'2024-03-11',1,5,2),(19,3,'2024-03-11',1,7,2),(20,8,'2024-03-11',1,5,2),(21,8,'2024-03-11',1,7,2),(22,1,'2024-03-11',1,5,2),(23,1,'2024-03-11',1,7,2),(24,1,'2024-03-12',1,6,2),(25,1,'2024-03-25',1,6,2);
/*!40000 ALTER TABLE `vacina_aplicacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-05 21:37:22
