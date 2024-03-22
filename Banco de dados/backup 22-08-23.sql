CREATE DATABASE  IF NOT EXISTS `leiteria2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `leiteria2`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: leiteria2
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
-- Table structure for table `animais`
--

DROP TABLE IF EXISTS `animais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animais` (
  `id_animal` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `brinco` int NOT NULL,
  `data_nasc` date NOT NULL,
  `registro` bigint NOT NULL,
  `sexo` char(1) NOT NULL,
  `pai` varchar(60) DEFAULT NULL,
  `mae` varchar(60) DEFAULT NULL,
  `id_raca` int NOT NULL,
  `id_propriedade` bigint DEFAULT NULL,
  `id_pai` bigint DEFAULT NULL,
  `id_mae` bigint DEFAULT NULL,
  `id_motivos_baixa` int DEFAULT NULL,
  `id_origem_animal` int NOT NULL DEFAULT '1',
  `ativo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_animal`),
  KEY `animais_fk0` (`id_raca`),
  KEY `animais_fk1` (`id_propriedade`),
  KEY `animais_fk2` (`id_pai`),
  KEY `animais_fk3` (`id_mae`),
  KEY `animais_fk4` (`id_origem_animal`),
  KEY `animais_fk5` (`id_motivos_baixa`),
  CONSTRAINT `animais_fk0` FOREIGN KEY (`id_raca`) REFERENCES `racas` (`id_raca`),
  CONSTRAINT `animais_fk1` FOREIGN KEY (`id_propriedade`) REFERENCES `propriedades` (`id_propriedade`),
  CONSTRAINT `animais_fk2` FOREIGN KEY (`id_pai`) REFERENCES `animais` (`id_animal`),
  CONSTRAINT `animais_fk3` FOREIGN KEY (`id_mae`) REFERENCES `animais` (`id_animal`),
  CONSTRAINT `animais_fk4` FOREIGN KEY (`id_origem_animal`) REFERENCES `origem_animal` (`id_origem_animal`),
  CONSTRAINT `animais_fk5` FOREIGN KEY (`id_motivos_baixa`) REFERENCES `motivos_baixa` (`id_motivos_baixa`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animais`
--

LOCK TABLES `animais` WRITE;
/*!40000 ALTER TABLE `animais` DISABLE KEYS */;
INSERT INTO `animais` VALUES (1,'Joselino',10,'2020-01-01',201,'m','','',1,1,NULL,NULL,1,1,0),(2,'Mimosa',11,'2017-01-01',2121,'f','','',3,1,NULL,NULL,NULL,1,1),(3,'Charmosa',50,'2021-04-22',222,'f','Joselino','Mimosa',1,1,NULL,2,NULL,1,1),(4,'Malu',12,'2015-03-30',852143,'f','','',2,4,1,NULL,NULL,1,1),(5,'Celi',13,'2014-04-20',215874,'f','','',2,4,1,NULL,NULL,1,1),(6,'Pintada',14,'2016-03-01',474125,'f','','',1,4,NULL,NULL,NULL,1,1),(8,'Manquinha',76,'2021-05-23',2234765,'f','Joselino','Mimosa',1,1,NULL,NULL,NULL,1,1),(9,'Malu2',98776,'2020-06-27',45690874,'f','','',2,4,NULL,NULL,NULL,1,1),(10,'Pintado',85,'2019-06-04',98196213,'m','Joselino','Mimosa',1,1,NULL,NULL,NULL,1,1),(11,'Ferdinando',235,'2018-08-24',84795,'m','Touro Ferdinando','Pintadinha',6,4,NULL,NULL,NULL,1,1),(12,'Bagolino',792,'2020-02-12',234566,'m','','',4,4,11,4,NULL,1,1),(13,'',23,'2013-06-17',15134567,'f','Maltazer','Magrinha',2,2,NULL,NULL,NULL,1,1),(32,'Vaquinha',3075,'2022-05-03',3899976,'f','Touro emprestado do vizinho','',5,1,1,8,NULL,1,1),(35,'teste',2333,'2022-08-09',1,'\0','Touro emprestado do vizinho','werwer',3,NULL,NULL,NULL,NULL,1,1),(36,'Progenitor Master',565777,'2022-08-25',77882,'\0','Touro emprestado do vizinho',NULL,1,NULL,NULL,NULL,NULL,1,1),(37,'reprodutor alfa',1,'2018-03-06',616585,'\0','Pintado','Pintada',4,NULL,NULL,NULL,NULL,1,1),(38,'sfsdf',3,'2022-08-17',3,'\0','dsdf','sdsdf',3,NULL,NULL,NULL,1,1,0),(39,'vacuum',9875,'2022-08-19',98542,'\0','Postgres','Oracle',2,NULL,NULL,NULL,NULL,1,1),(40,'Deleve',4688,'2000-09-06',55418765,'\0',NULL,NULL,3,NULL,NULL,NULL,NULL,1,1),(41,NULL,77777,'2022-01-03',77777,'f',NULL,NULL,1,1,NULL,NULL,1,1,0),(42,'Bolsonaro',22,'2022-10-03',22,'m',NULL,NULL,2,1,1,3,NULL,1,1),(43,'teste',12,'2022-09-11',2,'m',NULL,NULL,2,1,NULL,NULL,1,1,0),(44,'dsfgdfsgf',3123,'2022-08-28',312321,'f',NULL,NULL,4,1,NULL,NULL,2,1,0),(45,'Sarali',1,'2022-10-03',1,'f',NULL,NULL,2,1,NULL,NULL,NULL,1,1),(46,'teste',2333,'2022-10-09',12312,'f',NULL,NULL,4,1,NULL,NULL,1,1,0),(47,'teste',1,'2022-10-03',1,'m',NULL,NULL,2,1,NULL,NULL,1,1,0),(48,'teste',1,'2022-10-03',1,'\0','teste','teste',1,1,NULL,NULL,2,1,0),(49,'teste2',1,'2022-10-03',1,'\0','teste2','teste2',1,1,NULL,NULL,2,1,0),(50,'ababababababab',1,'2022-10-12',2,'f',NULL,NULL,1,1,1,3,2,2,0),(51,'tatatatatatat',1,'2022-10-12',1,'f',NULL,NULL,1,1,NULL,NULL,1,1,0),(52,'xaxaxaxaxaxax',1,'2022-10-12',1,'f',NULL,NULL,1,1,NULL,NULL,1,2,0),(54,'adsfasdf',1,'2023-02-09',1,'m',NULL,NULL,1,1,NULL,NULL,1,2,0),(55,'asdfsdf',2,'2023-02-09',2,'\0','sdfsdf','sdfsdf',1,NULL,NULL,NULL,NULL,4,1),(56,'Vaca nova',1234,'2021-06-14',4567,'f',NULL,NULL,3,1,NULL,NULL,NULL,2,1),(57,'teste',3232,'2023-03-02',234234,'m',NULL,NULL,3,1,NULL,NULL,NULL,1,1);
/*!40000 ALTER TABLE `animais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `animais_doadores`
--

DROP TABLE IF EXISTS `animais_doadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animais_doadores` (
  `id_doador` bigint NOT NULL AUTO_INCREMENT,
  `id_proprietario` bigint NOT NULL,
  `teste_progenie` tinyint DEFAULT NULL,
  `nucleo_moet` tinyint DEFAULT NULL,
  `dono` varchar(255) DEFAULT NULL,
  `pais_origem` varchar(255) DEFAULT NULL,
  `animal` bigint DEFAULT NULL,
  PRIMARY KEY (`id_doador`),
  KEY `animais_doadores_fk0` (`id_proprietario`),
  KEY `animais_doadores_fk1` (`animal`),
  CONSTRAINT `animais_doadores_fk0` FOREIGN KEY (`id_proprietario`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `animais_doadores_fk1` FOREIGN KEY (`animal`) REFERENCES `animais` (`id_animal`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animais_doadores`
--

LOCK TABLES `animais_doadores` WRITE;
/*!40000 ALTER TABLE `animais_doadores` DISABLE KEYS */;
INSERT INTO `animais_doadores` VALUES (1,1,1,1,'dudu','Alemanha',35),(2,1,0,1,'Paola Oliveira','Argentina',36),(4,4,1,0,'Khal Drogo','Esos',37),(12,1,1,1,'Esus','Brasil',39),(13,1,1,0,'Pecuaria Agro Campo','Brasil',40),(16,1,0,1,'sdfsdf','sdfsdf',55);
/*!40000 ALTER TABLE `animais_doadores` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `causa_encerramento_lactacao`
--

LOCK TABLES `causa_encerramento_lactacao` WRITE;
/*!40000 ALTER TABLE `causa_encerramento_lactacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `causa_encerramento_lactacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coberturas`
--

DROP TABLE IF EXISTS `coberturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `coberturas` (
  `id_cobertura` bigint NOT NULL AUTO_INCREMENT,
  `vaca` bigint NOT NULL,
  `tipo_cobertura` int NOT NULL,
  `touro_monta` bigint DEFAULT NULL,
  `inseminador` bigint DEFAULT NULL,
  `semen` bigint DEFAULT NULL,
  `qtde_dose_semen` int DEFAULT NULL,
  `data` date NOT NULL,
  `monta_controlada` tinyint DEFAULT NULL,
  `escore_corporal` float DEFAULT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_cobertura`),
  KEY `coberturas_fk1` (`vaca`),
  KEY `coberturas_fk2` (`touro_monta`),
  KEY `coberturas_fk3` (`inseminador`),
  KEY `coberturas_fk4` (`semen`),
  KEY `fk_coberturas_tipos_cobertura1_idx` (`tipo_cobertura`),
  CONSTRAINT `coberturas_fk1` FOREIGN KEY (`vaca`) REFERENCES `animais` (`id_animal`),
  CONSTRAINT `coberturas_fk2` FOREIGN KEY (`touro_monta`) REFERENCES `animais` (`id_animal`),
  CONSTRAINT `coberturas_fk3` FOREIGN KEY (`inseminador`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `coberturas_fk4` FOREIGN KEY (`semen`) REFERENCES `semens` (`id_semen`),
  CONSTRAINT `fk_coberturas_tipos_cobertura1` FOREIGN KEY (`tipo_cobertura`) REFERENCES `tipos_cobertura` (`id_tipos_cobertura`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coberturas`
--

LOCK TABLES `coberturas` WRITE;
/*!40000 ALTER TABLE `coberturas` DISABLE KEYS */;
INSERT INTO `coberturas` VALUES (1,2,2,NULL,2,1,3,'2022-09-01',0,4.5,'Teste de cadastro de cobertura, o backend não está dando baixa das doses de inseminação aplicadas'),(2,3,2,NULL,2,3,2,'2022-09-01',NULL,3.5,'Testando o campo monta controlada, se quando seleciona inseminação a variavel monta controlada fica como null'),(3,8,1,1,NULL,NULL,0,'2022-09-14',1,4,'Cadastrando cobertura para testar o diagnóstico de prenhez'),(4,41,1,1,NULL,NULL,0,'2022-09-19',1,3.5,NULL),(5,41,2,NULL,3,2,2,'2022-09-22',NULL,2.5,NULL),(6,2,1,10,NULL,NULL,0,'2022-10-04',1,3.5,'Teste do form'),(7,44,1,10,NULL,NULL,0,'2022-10-04',1,2.5,'Verificando qual classe o form tem depois que faz o submit'),(8,8,1,42,NULL,NULL,0,'2022-10-04',NULL,0,NULL),(9,44,2,NULL,3,2,2,'2022-10-04',NULL,3,NULL),(10,44,1,1,NULL,NULL,0,'2022-10-05',NULL,0,NULL),(11,41,1,1,NULL,NULL,0,'2022-10-04',NULL,0,NULL),(12,2,2,NULL,NULL,NULL,0,'2022-10-04',NULL,0,NULL),(13,2,1,NULL,NULL,NULL,0,'2022-10-05',NULL,0,NULL),(14,44,2,NULL,NULL,NULL,0,'2022-10-05',NULL,0,NULL),(15,3,1,NULL,NULL,NULL,0,'2022-10-04',NULL,0,NULL),(16,8,1,NULL,NULL,NULL,0,'2022-10-03',NULL,0,NULL),(17,45,1,10,NULL,NULL,0,'2022-10-04',1,0,NULL),(18,2,1,42,NULL,NULL,0,'2022-10-10',1,0,NULL),(19,8,2,NULL,NULL,NULL,0,'2022-10-02',NULL,0,NULL),(20,2,1,NULL,NULL,NULL,0,'2022-10-04',NULL,0,NULL),(21,2,1,1,NULL,NULL,0,'2022-10-11',1,0,NULL),(22,32,1,10,NULL,NULL,0,'2022-12-20',1,4,NULL),(23,2,2,NULL,2,9,2,'2023-02-08',NULL,3.5,NULL),(24,56,2,NULL,2,3,2,'2022-11-13',NULL,4,'Registrando cobertura do 0 de um novo animal'),(25,56,1,10,NULL,NULL,0,'2023-04-15',1,3.5,'Segunda cobertura da vaca'),(26,56,2,42,1,2,2,'2024-02-16',NULL,1.5,'Testando card Cobertura Component'),(27,2,2,NULL,3,3,4,'2023-02-16',NULL,2.5,'Testando Card Cobertura e Diagnóstico de Prenhez'),(28,2,1,10,NULL,NULL,0,'2023-02-14',0,0,NULL),(29,3,2,NULL,3,4,3,'2023-02-16',NULL,0,'Testando validação dos campos de inseminação e monta'),(30,3,1,10,NULL,NULL,0,'2023-02-17',1,0,NULL),(31,8,2,NULL,1,7,2,'2023-03-08',NULL,4,NULL);
/*!40000 ALTER TABLE `coberturas` ENABLE KEYS */;
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
  PRIMARY KEY (`id_controle_leiteiro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `controle_leiteiro`
--

LOCK TABLES `controle_leiteiro` WRITE;
/*!40000 ALTER TABLE `controle_leiteiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `controle_leiteiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crias`
--

DROP TABLE IF EXISTS `crias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `crias` (
  `id_crias` bigint NOT NULL AUTO_INCREMENT,
  `sexo` char(1) NOT NULL,
  `abortada` tinyint DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `parto_id` bigint NOT NULL,
  PRIMARY KEY (`id_crias`),
  KEY `fk_crias_partos1_idx` (`parto_id`),
  CONSTRAINT `fk_crias_partos1` FOREIGN KEY (`parto_id`) REFERENCES `partos` (`id_parto`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crias`
--

LOCK TABLES `crias` WRITE;
/*!40000 ALTER TABLE `crias` DISABLE KEYS */;
INSERT INTO `crias` VALUES (2,'f',1,1,10),(3,'m',1,1,11),(4,'f',0,1,14),(7,'m',0,1,21),(8,'f',0,1,22),(9,'f',0,1,23),(10,'f',0,2,23),(11,'f',0,3,23),(12,'m',0,1,32),(13,'m',0,1,32),(14,'m',0,1,32),(15,'m',0,0,33),(16,'m',0,0,33),(17,'m',0,0,33),(18,'m',0,0,34),(19,'m',0,0,34),(20,'m',0,0,34),(21,'f',1,0,35),(22,'f',0,0,35),(23,'f',0,0,35),(24,'f',1,0,36),(25,'m',1,0,36),(26,'m',0,0,36),(27,'f',0,10,37),(28,'m',0,15,37),(29,'f',0,20,37),(33,'f',0,1,39),(34,'f',0,90,40),(35,'f',0,80,41),(36,'f',0,90,41),(37,'f',1,15,42),(38,'f',1,15,42),(39,'f',0,90,43),(40,'f',0,90,44),(41,'m',0,80,45),(42,'f',0,50,46),(43,'f',0,50,47);
/*!40000 ALTER TABLE `crias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnosticos_prenhez`
--

DROP TABLE IF EXISTS `diagnosticos_prenhez`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnosticos_prenhez` (
  `id_diagnostico` bigint NOT NULL AUTO_INCREMENT,
  `vaca` bigint NOT NULL,
  `metodo_prenhez` int NOT NULL,
  `cobertura` bigint DEFAULT NULL,
  `data` date NOT NULL,
  `diagnostico` tinyint NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_diagnostico`),
  KEY `diagnosticos_prenhez_fk0` (`vaca`),
  KEY `diagnosticos_prenhez_fk1` (`cobertura`),
  KEY `fk_diagnosticos_prenhez_metodos_prenhez1_idx` (`metodo_prenhez`),
  CONSTRAINT `diagnosticos_prenhez_fk0` FOREIGN KEY (`vaca`) REFERENCES `animais` (`id_animal`),
  CONSTRAINT `diagnosticos_prenhez_fk1` FOREIGN KEY (`cobertura`) REFERENCES `coberturas` (`id_cobertura`),
  CONSTRAINT `fk_diagnosticos_prenhez_metodos_prenhez1` FOREIGN KEY (`metodo_prenhez`) REFERENCES `metodos_prenhez` (`id_metodos_prenhez`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnosticos_prenhez`
--

LOCK TABLES `diagnosticos_prenhez` WRITE;
/*!40000 ALTER TABLE `diagnosticos_prenhez` DISABLE KEYS */;
INSERT INTO `diagnosticos_prenhez` VALUES (1,2,1,1,'2022-09-15',1,'Teste de diagnóstico de prenhez'),(2,8,1,3,'2022-09-15',1,'Teste de diagnóstico de prenhez. Colocado cobertura no diagnóstico'),(3,3,2,2,'2022-09-15',0,'Teste de diagnóstico'),(4,32,1,NULL,'2022-09-18',0,'Registro de diagnóstico em vaca que não tem cobertura registrada'),(5,41,1,4,'2022-09-20',1,NULL),(6,41,1,17,'2022-10-06',0,NULL),(7,32,1,22,'2022-12-24',1,NULL),(8,32,1,NULL,'2023-02-09',1,'as'),(9,56,1,24,'2023-01-13',1,'Resgistrando diagnóstico do 0 de um novo animal'),(10,56,1,25,'2023-06-15',1,'Segundo diagnóstico de prenhez da vaca'),(11,2,2,27,'2023-04-20',1,'Testando Card Cobertura e diagnóstico de prenhez'),(12,3,1,30,'2023-03-08',1,NULL);
/*!40000 ALTER TABLE `diagnosticos_prenhez` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lactacoes`
--

DROP TABLE IF EXISTS `lactacoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lactacoes` (
  `id_lactacao` bigint NOT NULL AUTO_INCREMENT,
  `inicio` date NOT NULL,
  `encerramento` date DEFAULT NULL,
  `finalizado` tinyint DEFAULT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `causa_enc_lactacao` int DEFAULT NULL,
  `parto` bigint NOT NULL,
  PRIMARY KEY (`id_lactacao`),
  KEY `fk_lactacao_causa_enc_lactacao1_idx` (`causa_enc_lactacao`),
  KEY `fk_lactacao_partos1_idx` (`parto`),
  CONSTRAINT `fk_lactacao_causa_enc_lactacao1` FOREIGN KEY (`causa_enc_lactacao`) REFERENCES `causa_encerramento_lactacao` (`id_causa_encerramento`),
  CONSTRAINT `fk_lactacao_partos1` FOREIGN KEY (`parto`) REFERENCES `partos` (`id_parto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lactacoes`
--

LOCK TABLES `lactacoes` WRITE;
/*!40000 ALTER TABLE `lactacoes` DISABLE KEYS */;
INSERT INTO `lactacoes` VALUES (1,'2023-04-01',NULL,0,NULL,NULL,44),(2,'2023-04-05',NULL,0,NULL,NULL,45),(3,'2023-04-06',NULL,0,NULL,NULL,46),(4,'2023-04-17',NULL,0,NULL,NULL,47);
/*!40000 ALTER TABLE `lactacoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodos_prenhez`
--

DROP TABLE IF EXISTS `metodos_prenhez`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metodos_prenhez` (
  `id_metodos_prenhez` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_metodos_prenhez`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodos_prenhez`
--

LOCK TABLES `metodos_prenhez` WRITE;
/*!40000 ALTER TABLE `metodos_prenhez` DISABLE KEYS */;
INSERT INTO `metodos_prenhez` VALUES (1,'Toque'),(2,'Ultrassom');
/*!40000 ALTER TABLE `metodos_prenhez` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivos_baixa`
--

DROP TABLE IF EXISTS `motivos_baixa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motivos_baixa` (
  `id_motivos_baixa` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_motivos_baixa`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivos_baixa`
--

LOCK TABLES `motivos_baixa` WRITE;
/*!40000 ALTER TABLE `motivos_baixa` DISABLE KEYS */;
INSERT INTO `motivos_baixa` VALUES (1,'Morte'),(2,'Venda');
/*!40000 ALTER TABLE `motivos_baixa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenhadores`
--

DROP TABLE IF EXISTS `ordenhadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenhadores` (
  `id_controle_leiteiro` bigint NOT NULL,
  `id_usuario` bigint NOT NULL,
  PRIMARY KEY (`id_controle_leiteiro`,`id_usuario`),
  KEY `fk_controle_leiteiro_has_usuarios_usuarios1_idx` (`id_usuario`),
  KEY `fk_controle_leiteiro_has_usuarios_controle_leiteiro1_idx` (`id_controle_leiteiro`),
  CONSTRAINT `fk_controle_leiteiro_has_usuarios_controle_leiteiro1` FOREIGN KEY (`id_controle_leiteiro`) REFERENCES `controle_leiteiro` (`id_controle_leiteiro`),
  CONSTRAINT `fk_controle_leiteiro_has_usuarios_usuarios1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenhadores`
--

LOCK TABLES `ordenhadores` WRITE;
/*!40000 ALTER TABLE `ordenhadores` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
-- Table structure for table `parto_crias`
--

DROP TABLE IF EXISTS `parto_crias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parto_crias` (
  `id_parto` bigint NOT NULL,
  `id_crias` bigint NOT NULL,
  KEY `fk_01_idx` (`id_crias`),
  KEY `fk_0` (`id_parto`),
  CONSTRAINT `fk_0` FOREIGN KEY (`id_parto`) REFERENCES `partos` (`id_parto`),
  CONSTRAINT `fk_01` FOREIGN KEY (`id_crias`) REFERENCES `crias` (`id_crias`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parto_crias`
--

LOCK TABLES `parto_crias` WRITE;
/*!40000 ALTER TABLE `parto_crias` DISABLE KEYS */;
INSERT INTO `parto_crias` VALUES (21,7);
/*!40000 ALTER TABLE `parto_crias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partos`
--

DROP TABLE IF EXISTS `partos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partos` (
  `id_parto` bigint NOT NULL AUTO_INCREMENT,
  `vaca` bigint NOT NULL,
  `cobertura` bigint DEFAULT NULL,
  `prenhez` bigint DEFAULT NULL,
  `tipo_parto` int NOT NULL,
  `data` date NOT NULL,
  `escore_corporal` float DEFAULT NULL,
  `qtde_crias` int NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_parto`),
  KEY `partos_fk0` (`vaca`),
  KEY `partos_fk1` (`cobertura`),
  KEY `partos_fk2` (`prenhez`),
  KEY `fk_partos_tipos_parto1_idx` (`tipo_parto`),
  CONSTRAINT `fk_partos_tipos_parto1` FOREIGN KEY (`tipo_parto`) REFERENCES `tipos_parto` (`id_tipos_parto`),
  CONSTRAINT `partos_fk0` FOREIGN KEY (`vaca`) REFERENCES `animais` (`id_animal`),
  CONSTRAINT `partos_fk1` FOREIGN KEY (`cobertura`) REFERENCES `coberturas` (`id_cobertura`),
  CONSTRAINT `partos_fk2` FOREIGN KEY (`prenhez`) REFERENCES `diagnosticos_prenhez` (`id_diagnostico`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partos`
--

LOCK TABLES `partos` WRITE;
/*!40000 ALTER TABLE `partos` DISABLE KEYS */;
INSERT INTO `partos` VALUES (1,2,1,1,1,'2022-09-19',3.5,1,'Testando cadastrar 1º parto no sistema'),(2,41,NULL,NULL,1,'2022-09-30',3.5,1,NULL),(3,41,NULL,NULL,1,'2022-09-23',3.5,1,'Testando o reset de formulário'),(4,8,3,2,1,'2022-10-05',3.5,1,NULL),(5,3,3,2,2,'2022-10-13',3.5,1,NULL),(10,2,21,NULL,1,'2022-12-13',3.5,3,NULL),(11,3,NULL,NULL,1,'2022-12-13',2,3,NULL),(14,45,NULL,NULL,1,'2022-12-13',3.5,3,NULL),(15,8,NULL,NULL,1,'2022-12-13',4.5,1,NULL),(21,2,NULL,NULL,1,'2022-12-14',3.5,1,NULL),(22,2,NULL,NULL,1,'2022-12-14',3.5,1,NULL),(23,2,NULL,NULL,1,'2022-12-14',3.5,1,NULL),(32,2,NULL,NULL,1,'2022-12-14',4,1,NULL),(33,2,NULL,NULL,1,'2022-12-15',0,1,NULL),(34,2,NULL,NULL,1,'2022-12-23',3.5,3,NULL),(35,3,NULL,NULL,2,'2022-12-23',5,3,NULL),(36,8,NULL,NULL,1,'2022-12-23',4,1,NULL),(37,2,NULL,NULL,1,'2022-12-23',5,3,NULL),(39,2,NULL,NULL,2,'2023-02-10',4,1,NULL),(40,56,24,9,1,'2023-02-15',4,1,'Registrando o primeiro parto de uma vaca com inseminação e cobertura resgistrados'),(41,56,25,10,1,'2023-09-15',3.5,2,'Registrando segundo parto da vaca nova'),(42,3,30,12,1,'2023-03-08',4,2,NULL),(43,45,NULL,NULL,1,'2023-04-01',3.5,1,'Registrando lactação automaticamente com o parto'),(44,32,NULL,8,1,'2023-04-01',4.5,1,'Registrando lactação junto com o parto'),(45,32,NULL,NULL,1,'2023-04-05',4,1,'testando segundo registro de lactação'),(46,32,NULL,NULL,2,'2023-04-06',4,1,'Testando a listagem de lactações'),(47,2,27,11,1,'2023-04-17',4,1,NULL);
/*!40000 ALTER TABLE `partos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producao_leite`
--

DROP TABLE IF EXISTS `producao_leite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producao_leite` (
  `id_producao` bigint NOT NULL AUTO_INCREMENT,
  `lactacao` bigint NOT NULL,
  `ordenha_1` float NOT NULL,
  `ordenha_2` float DEFAULT NULL,
  `ordenha_3` float DEFAULT NULL,
  `id_controle_leiteiro` bigint NOT NULL,
  PRIMARY KEY (`id_producao`),
  KEY `fk_producao_leite_lactacoes1_idx` (`lactacao`),
  KEY `fk_producao_leite_controle_leiteiro1_idx` (`id_controle_leiteiro`),
  CONSTRAINT `fk_producao_leite_controle_leiteiro1` FOREIGN KEY (`id_controle_leiteiro`) REFERENCES `controle_leiteiro` (`id_controle_leiteiro`),
  CONSTRAINT `fk_producao_leite_lactacoes1` FOREIGN KEY (`lactacao`) REFERENCES `lactacoes` (`id_lactacao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producao_leite`
--

LOCK TABLES `producao_leite` WRITE;
/*!40000 ALTER TABLE `producao_leite` DISABLE KEYS */;
/*!40000 ALTER TABLE `producao_leite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `propriedades`
--

DROP TABLE IF EXISTS `propriedades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `propriedades` (
  `id_propriedade` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) DEFAULT NULL,
  `localidade` varchar(60) DEFAULT NULL,
  `municipio` varchar(60) DEFAULT NULL,
  `id_proprietario` bigint NOT NULL,
  PRIMARY KEY (`id_propriedade`),
  KEY `propriedades_fk0` (`id_proprietario`),
  CONSTRAINT `propriedades_fk0` FOREIGN KEY (`id_proprietario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `propriedades`
--

LOCK TABLES `propriedades` WRITE;
/*!40000 ALTER TABLE `propriedades` DISABLE KEYS */;
INSERT INTO `propriedades` VALUES (1,'Sitio Dulci','Roncador','Catanduvas',1),(2,'Fazenda pai eterno','Santana','Catanduvas',4),(4,'Sitio da Malucelle','Malucelle','Catanduvas',1),(5,'nao deveria poder criar','nao deveria poder criar','nao deveria poder criar',3);
/*!40000 ALTER TABLE `propriedades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `racas`
--

DROP TABLE IF EXISTS `racas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `racas` (
  `id_raca` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`id_raca`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `racas`
--

LOCK TABLES `racas` WRITE;
/*!40000 ALTER TABLE `racas` DISABLE KEYS */;
INSERT INTO `racas` VALUES (1,'Nelore'),(2,'Gir'),(3,'Girolando'),(4,'Caracu'),(5,'Guernsey'),(6,'Ayrshire'),(7,'Jersey');
/*!40000 ALTER TABLE `racas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regras`
--

DROP TABLE IF EXISTS `regras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regras` (
  `nome_regra` varchar(60) NOT NULL,
  PRIMARY KEY (`nome_regra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regras`
--

LOCK TABLES `regras` WRITE;
/*!40000 ALTER TABLE `regras` DISABLE KEYS */;
INSERT INTO `regras` VALUES ('ROLE_ADMIN'),('ROLE_FUNCIONARIO'),('ROLE_PRODUTOR');
/*!40000 ALTER TABLE `regras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semens`
--

DROP TABLE IF EXISTS `semens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semens` (
  `id_semen` bigint NOT NULL AUTO_INCREMENT,
  `touro_doador` bigint NOT NULL,
  `data_entrada` date NOT NULL,
  `quantidade` int NOT NULL,
  `preco_unitario` double DEFAULT NULL,
  `cod_palheta` int NOT NULL,
  PRIMARY KEY (`id_semen`),
  KEY `semens_fk0` (`touro_doador`),
  CONSTRAINT `semens_fk0` FOREIGN KEY (`touro_doador`) REFERENCES `animais_doadores` (`id_doador`) ON DELETE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semens`
--

LOCK TABLES `semens` WRITE;
/*!40000 ALTER TABLE `semens` DISABLE KEYS */;
INSERT INTO `semens` VALUES (1,1,'2022-05-04',50,0.5,4584899),(2,2,'2022-05-04',44,5.6,486844),(3,2,'2022-08-18',44,0.5,854713),(4,12,'2022-08-19',97,0.5,88779966),(7,1,'2022-11-30',8,10,1),(9,16,'2023-02-09',18,0.5,5345);
/*!40000 ALTER TABLE `semens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_cobertura`
--

DROP TABLE IF EXISTS `tipos_cobertura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_cobertura` (
  `id_tipos_cobertura` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipos_cobertura`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_cobertura`
--

LOCK TABLES `tipos_cobertura` WRITE;
/*!40000 ALTER TABLE `tipos_cobertura` DISABLE KEYS */;
INSERT INTO `tipos_cobertura` VALUES (1,'Monta'),(2,'Inseminação');
/*!40000 ALTER TABLE `tipos_cobertura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_parto`
--

DROP TABLE IF EXISTS `tipos_parto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_parto` (
  `id_tipos_parto` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tipos_parto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_parto`
--

LOCK TABLES `tipos_parto` WRITE;
/*!40000 ALTER TABLE `tipos_parto` DISABLE KEYS */;
INSERT INTO `tipos_parto` VALUES (1,'Normal'),(2,'Cesárea');
/*!40000 ALTER TABLE `tipos_parto` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `usuario_regras_fk0` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE,
  CONSTRAINT `usuario_regras_fk1` FOREIGN KEY (`id_regra`) REFERENCES `regras` (`nome_regra`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_regras`
--

LOCK TABLES `usuario_regras` WRITE;
/*!40000 ALTER TABLE `usuario_regras` DISABLE KEYS */;
INSERT INTO `usuario_regras` VALUES (2,'ROLE_FUNCIONARIO'),(3,'ROLE_FUNCIONARIO'),(4,'ROLE_FUNCIONARIO'),(4,'ROLE_PRODUTOR'),(4,'ROLE_ADMIN'),(5,'ROLE_FUNCIONARIO'),(6,'ROLE_FUNCIONARIO'),(7,'ROLE_PRODUTOR'),(8,'ROLE_PRODUTOR'),(9,'ROLE_PRODUTOR'),(1,'ROLE_PRODUTOR'),(1,'ROLE_FUNCIONARIO'),(19,'ROLE_FUNCIONARIO'),(28,'ROLE_PRODUTOR'),(28,'ROLE_FUNCIONARIO'),(29,'ROLE_PRODUTOR'),(29,'ROLE_FUNCIONARIO'),(30,'ROLE_PRODUTOR'),(30,'ROLE_FUNCIONARIO'),(31,'ROLE_PRODUTOR'),(31,'ROLE_FUNCIONARIO');
/*!40000 ALTER TABLE `usuario_regras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `email` varchar(60) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `chefe` bigint DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `usuarios_email_IX` (`email`),
  KEY `usuarios_fk0` (`chefe`),
  CONSTRAINT `usuarios_fk0` FOREIGN KEY (`chefe`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Moacir','moacir@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',NULL),(2,'Matulle','anderson@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',1),(3,'Paulo','paulo@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',1),(4,'Elsio','elsio@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',NULL),(5,'Carlos','carlos@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',4),(6,'Rodrigo','rodrigo@gmail.com','$2a$10$lTFvkD4N7frAwdzoyDljLu/nPvQUKTNEWXZ96e19WG.ke4vXU9Kou',4),(7,'Eduardo','eduardo@gmail.com','$2a$10$Y1fDrAYcJ7mQajUIHGUFnOuCK.nbWhwuLvElTDg0m4ZvP6aEgKCCm',NULL),(8,'João','joao@gmail.com','$2a$10$UxeE3oFA4E.SyfchphfPmujuGKX8IWXU05IgsgbMAR6UGzPvRMhVO',NULL),(9,'Andreia Koch Vieira','andreia@gmail.com','$2a$10$l0q9Pfbzc9Ji0qi4vJKF2.fEltorLobOEjia3KUeG5h1tQTADmXjq',NULL),(19,'Reni','reni@maisleite.com','$2a$10$QU/whkKDwcQoxUMLCGUBfuXGk7rpVTHc2WHJngYiLdh7rZ0jTXj7u',1),(28,'jose','jose@gmail.com','$2a$10$g/WfHp2QUHxSil.mg65Dn.dO6H9VrLkp2IwlL9EB7MxqPHi7cN41y',NULL),(29,'Adalberto','adalberto@gmail.com','{bcrypt}$2a$10$HsW81H7j.03wy7XmcoPZXu2eiAbalqCSAiZRv5f5bEIC9DOZ0cI96',NULL),(30,'Alglacir','alglacir@gmail.com','$2a$10$I75K7iEh7kyKhp1ei04kKe4nPQf4FmYXSPUyTXpgW6WqknGQcO3ha',NULL),(31,'Anibal','anibal@gmail.com','$2a$10$TuHaEucFBTWnxafBD1IevORn9XnaLqkFiBRjEJlvlIW5Caar33.Bq',NULL);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacina_aplicacao`
--

DROP TABLE IF EXISTS `vacina_aplicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacina_aplicacao` (
  `dose` int NOT NULL,
  `data_aplicacao` date NOT NULL,
  `vacina_id` bigint NOT NULL,
  `id_animal` bigint NOT NULL,
  `aplicador_id_usuario` bigint DEFAULT NULL,
  PRIMARY KEY (`id_animal`,`dose`,`vacina_id`),
  KEY `FK54upf29k71nb13bymv4oaojk` (`vacina_id`),
  KEY `FKq0pjkikp8hwehuu2g4lyq2rec` (`aplicador_id_usuario`),
  CONSTRAINT `FK2gtfrhmpd22iy56etebvqd30q` FOREIGN KEY (`id_animal`) REFERENCES `animais` (`id_animal`),
  CONSTRAINT `FK54upf29k71nb13bymv4oaojk` FOREIGN KEY (`vacina_id`) REFERENCES `vacinas` (`id`),
  CONSTRAINT `FKq0pjkikp8hwehuu2g4lyq2rec` FOREIGN KEY (`aplicador_id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina_aplicacao`
--

LOCK TABLES `vacina_aplicacao` WRITE;
/*!40000 ALTER TABLE `vacina_aplicacao` DISABLE KEYS */;
INSERT INTO `vacina_aplicacao` VALUES (1,'2022-12-03',1,1,1),(2,'2022-12-04',1,1,1),(3,'2022-12-05',1,1,1);
/*!40000 ALTER TABLE `vacina_aplicacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacinas`
--

DROP TABLE IF EXISTS `vacinas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacinas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `esquema_de_vacincao` varchar(1337) DEFAULT NULL,
  `indicacao` varchar(1337) DEFAULT NULL,
  `modo_de_uso` varchar(1337) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `reacoes_pos_vacinais` varchar(1337) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacinas`
--

LOCK TABLES `vacinas` WRITE;
/*!40000 ALTER TABLE `vacinas` DISABLE KEYS */;
INSERT INTO `vacinas` VALUES (1,'Frasco-ampola contendo 5, 15 e 25 doses, acompanhado de diluente de 10, 30 e 50 mL respectivamente.','A vacinação de fêmeas bovinas utilizando a vacina RB-51® é recomendada em qualquer idade a partir dos 3 meses de vida.','Reconstituir, utilizando somente o diluente do produto, que é constituído de uma solução tamponada preparada especificamente para esta vacina. Agitar bem antes de usar, mantendo a vacina em constante agitação durante o uso, para assegurar a suspensão do material antigênico. Após a reconstituição da vacina, utilizar todo o conteúdo do frasco dentro de 60 minutos. Administrar na dose de 2 mL por via subcutânea.\nÉ proibida a utilização da vacina RB-51® em bovinos machos de qualquer idade.\nEm caso de inoculação acidental no aplicador, o mesmo deverá procurar imediatamente um médico, levando esta bula.','Brucelose','Em caso de reação anafilática, administrar adrenalina ou equivalente. Em caso de exposição acidental de humanos, consultar um médico.\nA cepa RB-51 é resistente à rifampicina.Ao manusear a vacina o aplicador deverá utilizar luvas e óculos de proteção para evitar o contato com os olhos, boca e pele.\nNão aplicar a vacina em animais enfermos, parasitados, subnutridos ou sob condições de estresse. O uso concomitante com substâncias antimicrobianas ou anti-inflamatórias poderá interferir no desenvolvimento e manutenção da resposta imune após a vacinação.\nUtilizar seringas e agulhas estéreis, desinfetar e descartar seringas e agulhas utilizadas na aplicação da vacina.\nO conteúdo e os frascos não utilizados devem ser queimados.\n'),(2,'Em qualquer idade a cada 6 meses. A critério da autoridade sanitária, outros esquemas poderão ser adotados. ','Imunização de bovinos e bubalinos contra a febre aftosa. ','Agitar o frasco antes de usar.\nAdministrar a dose de 2 mL em bovinos ou bubalinos através da via subcutânea ou intramuscular, na região da tábua do pescoço (terço médio). ','Aftosa','Reações alérgicas do tipo hipersensibilidade podem ser observadas em animais vacinados e dependem da sensibilidade individual.');
/*!40000 ALTER TABLE `vacinas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-22 22:19:02
