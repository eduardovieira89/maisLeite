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
  `registro` bigint NOT NULL,
  `sexo` char(1) NOT NULL,
  `ativo` tinyint NOT NULL,
  `pai` varchar(60) DEFAULT NULL,
  `pai_id` bigint DEFAULT NULL,
  `mae_id` bigint DEFAULT NULL,
  `mae` varchar(60) DEFAULT NULL,
  `raca_id` int NOT NULL,
  `propriedade_id` bigint DEFAULT NULL,
  `origem_animal_id` int NOT NULL,
  `motivo_baixa_id` int DEFAULT NULL,
  `lote_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id_animal`),
  KEY `animais_fk0` (`raca_id`),
  KEY `animais_fk1` (`propriedade_id`),
  KEY `animais_fk2` (`pai_id`),
  KEY `animais_fk3` (`mae_id`),
  KEY `fk_animais_origem_animal1_idx` (`origem_animal_id`),
  KEY `fk_animais_motivo_baixa1_idx` (`motivo_baixa_id`),
  KEY `fk_animais_lotes1_idx` (`lote_id`),
  CONSTRAINT `animais_fk0` FOREIGN KEY (`raca_id`) REFERENCES `raca` (`id_raca`),
  CONSTRAINT `animais_fk1` FOREIGN KEY (`propriedade_id`) REFERENCES `propriedade` (`id_propriedade`),
  CONSTRAINT `animais_fk2` FOREIGN KEY (`pai_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `animais_fk3` FOREIGN KEY (`mae_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `animais_fk4` FOREIGN KEY (`origem_animal_id`) REFERENCES `origem_animal` (`id_origem_animal`),
  CONSTRAINT `animais_fk5` FOREIGN KEY (`motivo_baixa_id`) REFERENCES `motivo_baixa` (`id_motivo_baixa`),
  CONSTRAINT `fk_animais_lotes1` FOREIGN KEY (`lote_id`) REFERENCES `lote` (`id_lote`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'Estrela',1,'2022-12-30',1,'f',1,NULL,NULL,NULL,NULL,1,3,2,NULL,2),(2,'Pintado',2,'2021-02-16',2,'m',1,NULL,NULL,NULL,NULL,3,3,1,NULL,3),(3,'3',3,'2023-11-23',3,'f',1,NULL,NULL,NULL,NULL,1,3,2,NULL,2),(4,'Valente',84771,'2020-06-17',3447852,'\0',1,'Castor',NULL,NULL,'Floribela',1,NULL,4,NULL,NULL),(5,'Mimosa',1,'2023-11-05',1,'f',1,NULL,NULL,NULL,NULL,1,1,2,NULL,1),(6,'Pintado',23324,'2023-11-05',567786,'m',1,NULL,NULL,NULL,NULL,1,1,1,NULL,6),(7,'Estrela',3,'2023-11-22',3,'f',1,NULL,NULL,NULL,NULL,1,1,2,NULL,1),(8,'Severino',4512788,'2014-05-06',976753,'\0',1,'Touro Gir',NULL,NULL,'Vaca Gir',1,NULL,4,NULL,NULL),(9,'sadf',123,'2023-12-04',123,'f',1,NULL,NULL,NULL,NULL,1,2,1,NULL,9);
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

-- Dump completed on 2024-04-06 19:51:52
