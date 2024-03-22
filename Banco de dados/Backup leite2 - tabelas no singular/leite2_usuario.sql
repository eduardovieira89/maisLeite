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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `senha` varchar(60) NOT NULL,
  `chefe` bigint DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`),
  KEY `usuario_fk0` (`chefe`),
  CONSTRAINT `usuario_fk0` FOREIGN KEY (`chefe`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Moacir','moacir@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',NULL),(2,'Matulle','anderson@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',1),(3,'Paulo','paulo@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',1),(4,'Elsio','elsio@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',NULL),(5,'Carlos','carlos@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',4),(6,'Rodrigo','rodrigo@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',4),(7,'Eduardo','eduardo@gmail.com','$2a$10$Y1fDrAYcJ7mQajUIHGUFnOuCK.nbWhwuLvElTDg0m4ZvP6aEgKCCm',NULL),(8,'João','joao@gmail.com','$2a$10$UxeE3oFA4E.SyfchphfPmujuGKX8IWXU05IgsgbMAR6UGzPvRMhVO',NULL),(9,'Andreia Koch Vieira','andreia@gmail.com','$2a$10$l0q9Pfbzc9Ji0qi4vJKF2.fEltorLobOEjia3KUeG5h1tQTADmXjq',NULL),(19,'Reni','reni@maisleite.com','$2a$10$QU/whkKDwcQoxUMLCGUBfuXGk7rpVTHc2WHJngYiLdh7rZ0jTXj7u',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
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
