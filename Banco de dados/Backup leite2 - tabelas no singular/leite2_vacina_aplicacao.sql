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
-- Table structure for table `vacina_aplicacao`
--

DROP TABLE IF EXISTS `vacina_aplicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacina_aplicacao` (
  `dose` int NOT NULL,
  `data_aplicacao` date NOT NULL,
  `id_animal` bigint NOT NULL,
  `vacina_id` bigint NOT NULL,
  `aplicador_id_usuario` bigint DEFAULT NULL,
  PRIMARY KEY (`id_animal`,`dose`,`vacina_id`),
  KEY `FKofxc3wewj0syjvuh5x74ewjak` (`vacina_id`),
  KEY `FK7mbr6oshqsvbfjp4c73yii9dn` (`aplicador_id_usuario`),
  CONSTRAINT `FK7mbr6oshqsvbfjp4c73yii9dn` FOREIGN KEY (`aplicador_id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `FKofxc3wewj0syjvuh5x74ewjak` FOREIGN KEY (`vacina_id`) REFERENCES `vacina` (`id`),
  CONSTRAINT `FKqrb4qv7xw1owm86cxyhw1gabt` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id_animal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina_aplicacao`
--

LOCK TABLES `vacina_aplicacao` WRITE;
/*!40000 ALTER TABLE `vacina_aplicacao` DISABLE KEYS */;
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

-- Dump completed on 2022-07-13 21:52:56
