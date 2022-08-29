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
-- Table structure for table `usuario_regras`
--

DROP TABLE IF EXISTS `usuario_regras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_regras` (
  `id_usuario` bigint NOT NULL,
  `id_regra` varchar(60) NOT NULL,
  KEY `usuario_regras_fk0` (`id_usuario`),
  KEY `usuario_regras_fk1` (`id_regra`),
  CONSTRAINT `usuario_regras_fk0` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `usuario_regras_fk1` FOREIGN KEY (`id_regra`) REFERENCES `regra` (`nome_regra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_regras`
--

LOCK TABLES `usuario_regras` WRITE;
/*!40000 ALTER TABLE `usuario_regras` DISABLE KEYS */;
INSERT INTO `usuario_regras` VALUES (2,'ROLE_FUNCIONARIO'),(3,'ROLE_FUNCIONARIO'),(4,'ROLE_FUNCIONARIO'),(4,'ROLE_PRODUTOR'),(4,'ROLE_ADMIN'),(5,'ROLE_FUNCIONARIO'),(6,'ROLE_FUNCIONARIO'),(7,'ROLE_PRODUTOR'),(8,'ROLE_PRODUTOR'),(9,'ROLE_PRODUTOR'),(1,'ROLE_PRODUTOR'),(1,'ROLE_FUNCIONARIO'),(19,'ROLE_FUNCIONARIO');
/*!40000 ALTER TABLE `usuario_regras` ENABLE KEYS */;
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
