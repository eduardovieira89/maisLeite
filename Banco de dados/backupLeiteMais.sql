CREATE DATABASE  IF NOT EXISTS `leiteria3` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `leiteria3`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: leiteria3
-- ------------------------------------------------------
-- Server version	8.0.29

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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'Estrela',1,'2022-12-30',1,'f',1,NULL,NULL,NULL,NULL,1,3,2,NULL,2),(2,'Pintado',2,'2021-02-16',2,'m',1,NULL,NULL,NULL,NULL,3,3,1,NULL,3),(3,'3',3,'2023-11-23',3,'f',1,NULL,NULL,NULL,NULL,1,3,2,NULL,2),(4,'Valente',84771,'2020-06-17',3447852,'\0',1,'Castor',NULL,NULL,'Floribela',1,NULL,4,NULL,NULL),(5,'Mimosa',1,'2023-11-05',1,'f',1,NULL,NULL,NULL,NULL,1,1,2,NULL,1),(6,'Pintado',23324,'2023-11-05',567786,'m',1,NULL,NULL,NULL,NULL,1,1,1,NULL,6),(7,'Estrela',3,'2023-11-22',3,'f',1,NULL,NULL,NULL,NULL,1,1,2,NULL,1),(8,'Severino',4512788,'2014-05-06',976753,'\0',1,'Touro Gir',NULL,NULL,'Vaca Gir',1,NULL,4,NULL,NULL),(9,'sadf',123,'2023-12-04',123,'f',1,NULL,NULL,NULL,NULL,1,2,1,NULL,9),(10,'22',22,'2022-05-22',220522,'f',1,'Devile',NULL,NULL,'',3,1,1,NULL,1);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `causa_encerramento_lactacao`
--

DROP TABLE IF EXISTS `causa_encerramento_lactacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `causa_encerramento_lactacao` (
  `id_causa_encerramento` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_causa_encerramento`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `causa_encerramento_lactacao`
--

LOCK TABLES `causa_encerramento_lactacao` WRITE;
/*!40000 ALTER TABLE `causa_encerramento_lactacao` DISABLE KEYS */;
INSERT INTO `causa_encerramento_lactacao` VALUES (1,'Pré-parto'),(2,'Baixa produção'),(3,'Aborto com início de outra lactação'),(4,'Morte'),(5,'Separação do bezerro'),(6,'Doença'),(7,'Venda'),(8,'Glândulas mamárias perdidas');
/*!40000 ALTER TABLE `causa_encerramento_lactacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cobertura`
--

DROP TABLE IF EXISTS `cobertura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cobertura` (
  `id_cobertura` bigint NOT NULL AUTO_INCREMENT,
  `vaca_id` bigint NOT NULL,
  `tipo_cobertura_id` int NOT NULL,
  `touro_monta_id` bigint DEFAULT NULL,
  `inseminador_id` bigint DEFAULT NULL,
  `semen_id` bigint DEFAULT NULL,
  `qtde_dose_semen` int DEFAULT NULL,
  `data` date NOT NULL,
  `monta_controlada` tinyint DEFAULT NULL,
  `escore_corporal` float DEFAULT NULL,
  `observacao` varchar(1337) DEFAULT NULL,
  PRIMARY KEY (`id_cobertura`),
  KEY `coberturas_fk1` (`vaca_id`),
  KEY `coberturas_fk2` (`touro_monta_id`),
  KEY `coberturas_fk3` (`inseminador_id`),
  KEY `coberturas_fk4` (`semen_id`),
  KEY `fk_coberturas_tipos_cobertura1_idx` (`tipo_cobertura_id`),
  CONSTRAINT `coberturas_fk1` FOREIGN KEY (`vaca_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `coberturas_fk2` FOREIGN KEY (`touro_monta_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `coberturas_fk3` FOREIGN KEY (`inseminador_id`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `coberturas_fk4` FOREIGN KEY (`semen_id`) REFERENCES `semen` (`id_semen`),
  CONSTRAINT `fk_coberturas_tipos_cobertura1` FOREIGN KEY (`tipo_cobertura_id`) REFERENCES `tipo_cobertura` (`id_tipo_cobertura`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cobertura`
--

LOCK TABLES `cobertura` WRITE;
/*!40000 ALTER TABLE `cobertura` DISABLE KEYS */;
INSERT INTO `cobertura` VALUES (3,7,2,NULL,2,2,2,'2023-12-05',NULL,3.5,NULL),(4,5,2,NULL,2,2,3,'2023-12-06',NULL,4,NULL),(5,5,2,NULL,2,2,3,'2024-03-25',NULL,3.5,NULL);
/*!40000 ALTER TABLE `cobertura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `controle_leiteiro`
--

DROP TABLE IF EXISTS `controle_leiteiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `controle_leiteiro` (
  `id_controle_leiteiro` bigint NOT NULL AUTO_INCREMENT,
  `data_controle` date NOT NULL,
  `temperatura` float DEFAULT NULL,
  `umidade_ar` float DEFAULT NULL,
  `propriedade_id` bigint NOT NULL,
  PRIMARY KEY (`id_controle_leiteiro`),
  KEY `fk_controle_leiteiro_propriedades1_idx` (`propriedade_id`),
  CONSTRAINT `fk_controle_leiteiro_propriedades1` FOREIGN KEY (`propriedade_id`) REFERENCES `propriedade` (`id_propriedade`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controle_leiteiro`
--

LOCK TABLES `controle_leiteiro` WRITE;
/*!40000 ALTER TABLE `controle_leiteiro` DISABLE KEYS */;
INSERT INTO `controle_leiteiro` VALUES (3,'2023-12-06',25,80,1),(4,'2023-12-05',0,0,1);
/*!40000 ALTER TABLE `controle_leiteiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cria`
--

DROP TABLE IF EXISTS `cria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cria` (
  `id_cria` bigint NOT NULL AUTO_INCREMENT,
  `sexo` char(1) NOT NULL,
  `abortada` char(1) DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `parto_id` bigint NOT NULL,
  PRIMARY KEY (`id_cria`),
  KEY `fk_crias_partos1_idx` (`parto_id`),
  CONSTRAINT `fk_crias_partos1` FOREIGN KEY (`parto_id`) REFERENCES `parto` (`id_parto`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cria`
--

LOCK TABLES `cria` WRITE;
/*!40000 ALTER TABLE `cria` DISABLE KEYS */;
INSERT INTO `cria` VALUES (8,'f','0',50,9),(9,'f','0',60,10),(10,'f','0',80,11),(11,'f','0',80,11),(12,'f','0',100,12),(13,'f','0',80,13);
/*!40000 ALTER TABLE `cria` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lactacao`
--

LOCK TABLES `lactacao` WRITE;
/*!40000 ALTER TABLE `lactacao` DISABLE KEYS */;
INSERT INTO `lactacao` VALUES (3,'2023-12-05','2023-12-06',1,NULL,1,9),(4,'2023-12-05',NULL,0,NULL,NULL,10),(5,'2023-12-06','2023-12-06',1,NULL,1,11),(6,'2024-03-05',NULL,0,NULL,NULL,12),(7,'2024-03-15',NULL,0,NULL,NULL,13);
/*!40000 ALTER TABLE `lactacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `id_lote` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  `propriedade_id` bigint NOT NULL,
  PRIMARY KEY (`id_lote`),
  KEY `fk_lotes_propriedades1_idx` (`propriedade_id`),
  CONSTRAINT `fk_lotes_propriedades1` FOREIGN KEY (`propriedade_id`) REFERENCES `propriedade` (`id_propriedade`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES (1,'Novilhas',1),(2,'Novilhas',3),(3,'Machos',3),(4,'Vacas em lactação',3),(5,'Vacas secas',3),(6,'Machos',1),(7,'Vacas em lactação',1),(8,'Vacas secas',1),(9,'Novilhas',2);
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodo_prenhez`
--

DROP TABLE IF EXISTS `metodo_prenhez`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metodo_prenhez` (
  `id_metodo_prenhez` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_metodo_prenhez`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodo_prenhez`
--

LOCK TABLES `metodo_prenhez` WRITE;
/*!40000 ALTER TABLE `metodo_prenhez` DISABLE KEYS */;
INSERT INTO `metodo_prenhez` VALUES (1,'Toque'),(2,'Ultrassom');
/*!40000 ALTER TABLE `metodo_prenhez` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivo_baixa`
--

DROP TABLE IF EXISTS `motivo_baixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motivo_baixa` (
  `id_motivo_baixa` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_motivo_baixa`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivo_baixa`
--

LOCK TABLES `motivo_baixa` WRITE;
/*!40000 ALTER TABLE `motivo_baixa` DISABLE KEYS */;
INSERT INTO `motivo_baixa` VALUES (1,'Morte'),(2,'Venda'),(3,'Doação');
/*!40000 ALTER TABLE `motivo_baixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenhadores`
--

DROP TABLE IF EXISTS `ordenhadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenhadores` (
  `controle_leiteiro_id` bigint NOT NULL,
  `usuario_id` bigint NOT NULL,
  PRIMARY KEY (`controle_leiteiro_id`,`usuario_id`),
  KEY `fk_controle_leiteiro_has_usuarios_usuarios1_idx` (`usuario_id`),
  KEY `fk_controle_leiteiro_has_usuarios_controle_leiteiro1_idx` (`controle_leiteiro_id`),
  CONSTRAINT `fk_controle_leiteiro_has_usuarios_controle_leiteiro1` FOREIGN KEY (`controle_leiteiro_id`) REFERENCES `controle_leiteiro` (`id_controle_leiteiro`),
  CONSTRAINT `fk_controle_leiteiro_has_usuarios_usuarios1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenhadores`
--

LOCK TABLES `ordenhadores` WRITE;
/*!40000 ALTER TABLE `ordenhadores` DISABLE KEYS */;
INSERT INTO `ordenhadores` VALUES (3,2),(4,2);
/*!40000 ALTER TABLE `ordenhadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `origem_animal`
--

DROP TABLE IF EXISTS `origem_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `origem_animal` (
  `id_origem_animal` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_origem_animal`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `origem_animal`
--

LOCK TABLES `origem_animal` WRITE;
/*!40000 ALTER TABLE `origem_animal` DISABLE KEYS */;
INSERT INTO `origem_animal` VALUES (1,'Comprado'),(2,'Nascido do rebanho'),(3,'Doado'),(4,'Animal doador');
/*!40000 ALTER TABLE `origem_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parto`
--

DROP TABLE IF EXISTS `parto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parto` (
  `id_parto` bigint NOT NULL AUTO_INCREMENT,
  `vaca_id` bigint NOT NULL,
  `cobertura_id` bigint DEFAULT NULL,
  `prenhez_id` bigint DEFAULT NULL,
  `tipo_parto_id` int NOT NULL,
  `data` date NOT NULL,
  `escore_corporal` float DEFAULT NULL,
  `qtde_crias` int NOT NULL,
  `observacao` varchar(1337) DEFAULT NULL,
  PRIMARY KEY (`id_parto`),
  KEY `partos_fk0` (`vaca_id`),
  KEY `partos_fk1` (`cobertura_id`),
  KEY `partos_fk2` (`prenhez_id`),
  KEY `fk_partos_tipos_parto1_idx` (`tipo_parto_id`),
  CONSTRAINT `fk_partos_tipos_parto1` FOREIGN KEY (`tipo_parto_id`) REFERENCES `tipo_parto` (`id_tipo_parto`),
  CONSTRAINT `partos_fk0` FOREIGN KEY (`vaca_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `partos_fk1` FOREIGN KEY (`cobertura_id`) REFERENCES `cobertura` (`id_cobertura`),
  CONSTRAINT `partos_fk2` FOREIGN KEY (`prenhez_id`) REFERENCES `diagnostico_prenhez` (`id_diagnostico`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parto`
--

LOCK TABLES `parto` WRITE;
/*!40000 ALTER TABLE `parto` DISABLE KEYS */;
INSERT INTO `parto` VALUES (9,5,NULL,NULL,1,'2023-12-05',4,1,NULL),(10,7,3,3,2,'2023-12-05',3.5,1,NULL),(11,5,4,4,1,'2023-12-06',4,2,NULL),(12,5,5,NULL,1,'2024-03-05',4.5,1,NULL),(13,10,NULL,NULL,1,'2024-03-15',4.5,1,NULL);
/*!40000 ALTER TABLE `parto` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `propriedade`
--

DROP TABLE IF EXISTS `propriedade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propriedade` (
  `id_propriedade` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) DEFAULT NULL,
  `localidade` varchar(60) DEFAULT NULL,
  `municipio` varchar(60) DEFAULT NULL,
  `proprietario_id` bigint NOT NULL,
  PRIMARY KEY (`id_propriedade`),
  KEY `propriedades_fk0` (`proprietario_id`),
  CONSTRAINT `propriedades_fk0` FOREIGN KEY (`proprietario_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propriedade`
--

LOCK TABLES `propriedade` WRITE;
/*!40000 ALTER TABLE `propriedade` DISABLE KEYS */;
INSERT INTO `propriedade` VALUES (1,'Chacara do Mel','Passo Liso','Catanduvas',2),(2,'Propriedade 2','N S de Lurdes','Catanduvas',2),(3,'Tão Distante','Ibiracema','Catanduvas',3);
/*!40000 ALTER TABLE `propriedade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `raca`
--

DROP TABLE IF EXISTS `raca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `raca` (
  `id_raca` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_raca`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `raca`
--

LOCK TABLES `raca` WRITE;
/*!40000 ALTER TABLE `raca` DISABLE KEYS */;
INSERT INTO `raca` VALUES (1,'Nelore'),(2,'Gir'),(3,'Girolando'),(4,'Caracu'),(5,'Guernsey'),(6,'Ayrshire'),(7,'Jersey');
/*!40000 ALTER TABLE `raca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regra`
--

DROP TABLE IF EXISTS `regra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regra` (
  `nome_regra` varchar(60) NOT NULL,
  PRIMARY KEY (`nome_regra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regra`
--

LOCK TABLES `regra` WRITE;
/*!40000 ALTER TABLE `regra` DISABLE KEYS */;
INSERT INTO `regra` VALUES ('ROLE_ADMIN'),('ROLE_FUNCIONARIO'),('ROLE_PRODUTOR');
/*!40000 ALTER TABLE `regra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semen`
--

DROP TABLE IF EXISTS `semen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semen` (
  `id_semen` bigint NOT NULL AUTO_INCREMENT,
  `touro_doador_id` bigint NOT NULL,
  `data_entrada` date NOT NULL,
  `quantidade` int NOT NULL,
  `preco_unitario` double DEFAULT NULL,
  `cod_palheta` int NOT NULL,
  PRIMARY KEY (`id_semen`),
  KEY `semens_fk0` (`touro_doador_id`),
  CONSTRAINT `semens_fk0` FOREIGN KEY (`touro_doador_id`) REFERENCES `animal_doador` (`id_doador`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semen`
--

LOCK TABLES `semen` WRITE;
/*!40000 ALTER TABLE `semen` DISABLE KEYS */;
INSERT INTO `semen` VALUES (1,1,'2023-11-02',22,45,533),(2,2,'2023-12-04',9,45,815);
/*!40000 ALTER TABLE `semen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_cobertura`
--

DROP TABLE IF EXISTS `tipo_cobertura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_cobertura` (
  `id_tipo_cobertura` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_cobertura`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_cobertura`
--

LOCK TABLES `tipo_cobertura` WRITE;
/*!40000 ALTER TABLE `tipo_cobertura` DISABLE KEYS */;
INSERT INTO `tipo_cobertura` VALUES (1,'Monta'),(2,'Inseminação');
/*!40000 ALTER TABLE `tipo_cobertura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_parto`
--

DROP TABLE IF EXISTS `tipo_parto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_parto` (
  `id_tipo_parto` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_parto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_parto`
--

LOCK TABLES `tipo_parto` WRITE;
/*!40000 ALTER TABLE `tipo_parto` DISABLE KEYS */;
INSERT INTO `tipo_parto` VALUES (1,'Normal'),(2,'Cesárea');
/*!40000 ALTER TABLE `tipo_parto` ENABLE KEYS */;
UNLOCK TABLES;

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
  `senha` varchar(255) NOT NULL,
  `chefe_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`),
  KEY `usuarios_fk0` (`chefe_id`),
  CONSTRAINT `usuarios_fk0` FOREIGN KEY (`chefe_id`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (2,'Eduardo Vieira','eduardo@gmail.com','$2a$10$7A9I5VUXYnyW5Hi5ry3F.urgNau.iVpTyg202Gs6Wlmpv6SyYjv0i',NULL),(3,'Pedro','pedro@gmail.com','$2a$10$NPPtyldWco8vCNbDDefxyemC7Ij5Ur08YM4fgdOf9VNmixH3PEej2',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_regras`
--

DROP TABLE IF EXISTS `usuario_regras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_regras` (
  `usuario_id` bigint NOT NULL,
  `regra_id` varchar(60) NOT NULL,
  KEY `usuario_regras_fk0` (`usuario_id`),
  KEY `usuario_regras_fk1` (`regra_id`),
  CONSTRAINT `usuario_regras_fk0` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE,
  CONSTRAINT `usuario_regras_fk1` FOREIGN KEY (`regra_id`) REFERENCES `regra` (`nome_regra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_regras`
--

LOCK TABLES `usuario_regras` WRITE;
/*!40000 ALTER TABLE `usuario_regras` DISABLE KEYS */;
INSERT INTO `usuario_regras` VALUES (2,'ROLE_PRODUTOR'),(2,'ROLE_FUNCIONARIO'),(3,'ROLE_PRODUTOR'),(3,'ROLE_FUNCIONARIO');
/*!40000 ALTER TABLE `usuario_regras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacina_aplicacao`
--

DROP TABLE IF EXISTS `vacina_aplicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacina_aplicacao` (
  `id_aplicacao` bigint NOT NULL AUTO_INCREMENT,
  `dose` int NOT NULL,
  `data` date NOT NULL,
  `vacina_id` int NOT NULL,
  `animal_id` bigint NOT NULL,
  `aplicador_id` bigint NOT NULL,
  `doenca_evento_id_doenca` int NOT NULL,
  PRIMARY KEY (`id_aplicacao`),
  KEY `fk_vacina_aplicacao_vacinas1_idx` (`vacina_id`),
  KEY `fk_vacina_aplicacao_animais1_idx` (`animal_id`),
  KEY `fk_vacina_aplicacao_usuarios1_idx` (`aplicador_id`),
  KEY `fk_vacina_aplicacao_doenca_evento1_idx` (`doenca_evento_id_doenca`),
  CONSTRAINT `fk_vacina_aplicacao_animais1` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id_animal`),
  CONSTRAINT `fk_vacina_aplicacao_doenca_evento1` FOREIGN KEY (`doenca_evento_id_doenca`) REFERENCES `doenca_evento` (`id_doenca`),
  CONSTRAINT `fk_vacina_aplicacao_usuarios1` FOREIGN KEY (`aplicador_id`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `fk_vacina_aplicacao_vacinas1` FOREIGN KEY (`vacina_id`) REFERENCES `medicacao_vacina` (`id_medicacao_vacina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
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

-- Dump completed on 2025-05-14 22:49:50
