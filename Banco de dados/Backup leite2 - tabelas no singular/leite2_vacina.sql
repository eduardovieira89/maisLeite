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
-- Table structure for table `vacina`
--

DROP TABLE IF EXISTS `vacina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacina` (
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
-- Dumping data for table `vacina`
--

LOCK TABLES `vacina` WRITE;
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
INSERT INTO `vacina` VALUES (1,'Frasco-ampola contendo 5, 15 e 25 doses, acompanhado de diluente de 10, 30 e 50 mL respectivamente.','A vacinação de fêmeas bovinas utilizando a vacina RB-51® é recomendada em qualquer idade a partir dos 3 meses de vida.','Reconstituir, utilizando somente o diluente do produto, que é constituído de uma solução tamponada preparada especificamente para esta vacina. Agitar bem antes de usar, mantendo a vacina em constante agitação durante o uso, para assegurar a suspensão do material antigênico. Após a reconstituição da vacina, utilizar todo o conteúdo do frasco dentro de 60 minutos. Administrar na dose de 2 mL por via subcutânea.\nÉ proibida a utilização da vacina RB-51® em bovinos machos de qualquer idade.\nEm caso de inoculação acidental no aplicador, o mesmo deverá procurar imediatamente um médico, levando esta bula.','Brucelose','Em caso de reação anafilática, administrar adrenalina ou equivalente. Em caso de exposição acidental de humanos, consultar um médico.\nA cepa RB-51 é resistente à rifampicina.Ao manusear a vacina o aplicador deverá utilizar luvas e óculos de proteção para evitar o contato com os olhos, boca e pele.\nNão aplicar a vacina em animais enfermos, parasitados, subnutridos ou sob condições de estresse. O uso concomitante com substâncias antimicrobianas ou anti-inflamatórias poderá interferir no desenvolvimento e manutenção da resposta imune após a vacinação.\nUtilizar seringas e agulhas estéreis, desinfetar e descartar seringas e agulhas utilizadas na aplicação da vacina.\nO conteúdo e os frascos não utilizados devem ser queimados.\n'),(2,'Em qualquer idade a cada 6 meses. A critério da autoridade sanitária, outros esquemas poderão ser adotados. ','Imunização de bovinos e bubalinos contra a febre aftosa. ','Agitar o frasco antes de usar.\nAdministrar a dose de 2 mL em bovinos ou bubalinos através da via subcutânea ou intramuscular, na região da tábua do pescoço (terço médio). ','Aftosa','Reações alérgicas do tipo hipersensibilidade podem ser observadas em animais vacinados e dependem da sensibilidade individual.');
/*!40000 ALTER TABLE `vacina` ENABLE KEYS */;
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
