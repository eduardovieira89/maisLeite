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
-- Table structure for table `animal_doador`
--

DROP TABLE IF EXISTS `animal_doador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal_doador` (
  `id_doador` bigint NOT NULL AUTO_INCREMENT,
  `proprietario_id` bigint NOT NULL,
  `teste_progenie` tinyint DEFAULT NULL,
  `nucleo_moet` tinyint DEFAULT NULL,
  `dono` varchar(255) DEFAULT NULL,
  `pais_origem` varchar(255) DEFAULT NULL,
  `animal_id` bigint NOT NULL,
  PRIMARY KEY (`id_doador`),
  KEY `animais_doadores_fk0` (`proprietario_id`),
  KEY `fk_animais_doadores_animais1_idx` (`animal_id`),
  CONSTRAINT `animais_doadores_fk0` FOREIGN KEY (`proprietario_id`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `fk_animais_doadores_animais1` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id_animal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal_doador`
--

LOCK TABLES `animal_doador` WRITE;
/*!40000 ALTER TABLE `animal_doador` DISABLE KEYS */;
INSERT INTO `animal_doador` VALUES (1,3,1,1,'Khal Drogo','Brasil',4),(2,2,0,1,'Khal Drogo','Brasil',8);
/*!40000 ALTER TABLE `animal_doador` ENABLE KEYS */;
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
