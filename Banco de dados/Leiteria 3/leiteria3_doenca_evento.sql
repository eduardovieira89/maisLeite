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
-- Table structure for table `doenca_evento`
--

DROP TABLE IF EXISTS `doenca_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doenca_evento` (
  `id_doenca` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_doenca`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doenca_evento`
--

LOCK TABLES `doenca_evento` WRITE;
/*!40000 ALTER TABLE `doenca_evento` DISABLE KEYS */;
INSERT INTO `doenca_evento` VALUES (1,'Aborto'),(2,'Abscesso'),(3,'Afecções de casco'),(4,'Bicheira (miíase)'),(5,'Botulismo'),(6,'Brucelose'),(7,'Brucelose e Tuberculose'),(8,'CAE - Artrite Encefalite Caprina'),(9,'Carbúnculo Sintomático'),(10,'Carrapaticida'),(11,'Casqueamento'),(12,'Ceratoconjuntivite'),(13,'Cetose'),(14,'Cirurgia ocular'),(15,'Cisto Ovário Direito (COD)'),(16,'Cisto Ovário Esquerdo (COE)'),(17,'Clostridiose'),(18,'Congestão pulmonar'),(19,'Descorna'),(20,'Desidratação'),(21,'Deslocamento de Abomaso'),(22,'Diarréia'),(23,'Estefanofilariose (Úlcera de lactação)'),(24,'Febre'),(25,'Febre Aftosa'),(26,'Gangrena Gasosa'),(27,'Hipocalcemia (Febre do Leite)'),(28,'Hormônio de Produção'),(29,'Hormônio de Reprodução'),(30,'IATF'),(31,'IBR'),(32,'IBR / BVD'),(33,'Inchaço'),(34,'Indigestão'),(35,'Indução de Lactação'),(36,'Indução de cio'),(37,'Indução de parto'),(38,'Infecção Uterina'),(39,'Infusão intra-uterina'),(40,'Intoxicação'),(41,'Leptospirose'),(42,'Linfadenite'),(43,'Mastite'),(44,'Metrite'),(45,'Otite Parasitária'),(46,'Outro'),(47,'Papilomatose'),(48,'Pequenas Cirurgias'),(49,'Picada de cobra'),(50,'Pneumonia'),(51,'Preventivo'),(52,'Prevenção de Cetose'),(53,'Pós Parto'),(54,'Raiva'),(55,'Retenção de Leite'),(56,'Retenção de placenta'),(57,'Secagem'),(58,'Somatotropina bovina (BST)'),(59,'Timpanismo'),(60,'Toxemia'),(61,'Transferência de Embrião'),(62,'Transfusão de sangue'),(63,'Tripanossomose'),(64,'Tristeza parasitária bovina'),(65,'Tuberculose'),(66,'Tétano'),(67,'Vacina Polivalente'),(68,'Vacina Reprodutiva'),(69,'Vacinas Pré-Parto'),(70,'Vermifugação'),(71,'Vermifugação Oral'),(72,'Verrugas'),(73,'Vitaminas'),(74,'Úlcera De Lactação');
/*!40000 ALTER TABLE `doenca_evento` ENABLE KEYS */;
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
