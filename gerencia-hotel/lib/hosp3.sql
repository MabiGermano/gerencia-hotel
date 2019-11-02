-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: hosp3
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `consumo_extra`
--
CREATE DATABASE IF NOT EXISTS hosp3;
DROP TABLE IF EXISTS `hosp3`.`consumo_extra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosp3`.`consumo_extra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumo_extra`
--

LOCK TABLES `hosp3`.`consumo_extra` WRITE;
/*!40000 ALTER TABLE `consumo_extra` DISABLE KEYS */;
INSERT INTO `hosp3`.`consumo_extra` VALUES (1,'1 hospede extra',80),(2,'1 hospede extra',80),(3,'chocolate ',4),(4,'consumo de 4 águas',12),(5,'Almoço do chefe',30),(6,'Ceviche',45),(7,'Chá de camomila',6),(8,'1 hospede extra',80),(9,'Salada',14),(10,'Salgadinho',3);
/*!40000 ALTER TABLE `consumo_extra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `hosp3`.`endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosp3`.`endereco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rua` varchar(45) DEFAULT NULL,
  `numero` varchar(3) DEFAULT NULL,
  `cep` varchar(9) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `pais` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `hosp3`.`endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
INSERT INTO `hosp3`.`endereco` VALUES (1,'R Torquato de Aquino','15','2562659','Peixinhos','Brasil','Olinda',''),(2,'Av tabatinga','5','9859867','Santa maria','Brasil','São Paulo','apto 9'),(3,'R aderval costa','98','256418','Corrente','Brasil','Recife',''),(4,'Av Gauchos','24','5256985','Chimarrão','Brasil','Santa catarina',NULL),(5,'R Treze de outubro','12','8523647','São josé dos campos','Brasil','São paulo',NULL),(6,'Av O erro','56','9845621','Penha','Brasil','Rio de Janeiro',NULL),(7,'R Barracão','8','9785956','São Gonçalo','Brasil','São paulo','apto 25'),(8,'Av Governador onório','52','8527419','Vila madaloca','Brasil','São Paulo',''),(9,'Av Marquês de olinda','3','9859748','Recife','Brasil','Recife','6 Andar'),(10,'Av Santada e Santos','856','9586325','Casa forte','Brasil','Recife',NULL);
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `hosp3`.`funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosp3`.`funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `endereco_id` int(11) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `codigo` varchar(10) DEFAULT NULL,
  `palavra_passe` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_funcionario_1_idx` (`endereco_id`),
  CONSTRAINT `fk_funcionario_1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `hosp3`.`funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `hosp3`.`funcionario` VALUES (1,'Ana rosa','339.592.190-59',5,'anaRosa@gmail.com','928286547','25B','oxeoxe'),(2,'Lucas Silva','129.607.840-06',2,'lucas.silva@hotmail.com','958626478','77B','ukeuke'),(3,'Papai noel','726.334.960-40',6,'renas@gmail.com','789456123','21B','renas'),(4,'Natasha Romanoff','467.527.870-18',1,'blackWindow@gmail.com','808051648','01B','viuvaNegra');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospedagem`
--

DROP TABLE IF EXISTS `hosp3`.`hospedagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosp3`.`hospedagem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `hospede_id` int(11) NOT NULL,
  `quarto_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_table1_1_idx` (`hospede_id`),
  KEY `fk_table1_2_idx` (`quarto_id`),
  CONSTRAINT `fk_table1_1` FOREIGN KEY (`hospede_id`) REFERENCES `hospede` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_2` FOREIGN KEY (`quarto_id`) REFERENCES `quarto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospedagem`
--

LOCK TABLES `hosp3`.`hospedagem` WRITE;
/*!40000 ALTER TABLE `hospedagem` DISABLE KEYS */;
INSERT INTO `hosp3`.`hospedagem` VALUES (1,2,7),(2,4,1),(3,9,10),(4,1,8),(5,6,6),(6,5,2),(7,8,3),(8,10,4),(9,3,9),(10,5,5);
/*!40000 ALTER TABLE `hospedagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospede`
--

DROP TABLE IF EXISTS `hosp3`.`hospede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosp3`.`hospede` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `endereco_id` int(11) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `palavra_passe` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_hospede_1_idx` (`endereco_id`),
  CONSTRAINT `fk_hospede_1` FOREIGN KEY (`endereco_id`) REFERENCES `endereco` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospede`
--

LOCK TABLES `hosp3`.`hospede` WRITE;
/*!40000 ALTER TABLE `hospede` DISABLE KEYS */;
INSERT INTO `hosp3`.`hospede` VALUES (1,'José Bezerra','476.913.520-34','jose.bezerra@hotmail.com',2,'985895895','rapunzel*'),(2,'Rapunzel','533.996.080-39','rapunzel@hotmail.com',6,'852678496','estrelasflutuantes'),(3,'Bocão','865.839.170-17','bocao@gmail.com',1,'741523986','falafala'),(4,'Marcos','899.328.160-27','carrinho@gmail.com',3,'42344423343','tacalepau'),(5,'Sabrina Spellman','111.821.650-44','spellman@gmail.com',9,'957699021','salem'),(6,'Kara denvers','923.834.180-05','supergirl@gmail.com',4,'851245863','al3xdenvers'),(7,'Nunguento Mais','398.568.470-79','tatarde@hotmail.com',5,'232343560','mizera'),(8,'Lampião','792.409.730-95','lampiao@hotmail.com',8,'828282823','cangaco'),(9,'Maria Bonita','165.144.840-00','buritinha@hotmail.com',10,'828956978','cangaceira'),(10,'Elsa','165.144.840-00','elsa@gmail.com',7,'978584978','lerigou');
/*!40000 ALTER TABLE `hospede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quarto`
--

DROP TABLE IF EXISTS `hosp3`.`quarto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosp3`.`quarto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `valor` float DEFAULT NULL,
  `quantidade_pessoas` int(11) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `disponivel` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quarto`
--

LOCK TABLES `hosp3`.`quarto` WRITE;
/*!40000 ALTER TABLE `quarto` DISABLE KEYS */;
INSERT INTO `quarto` VALUES (1,150,2,'Simples','1',1),(2,200,2,'Suite','5',1),(3,150,2,'Simples','2',1),(4,300,4,'Suite','3',1),(5,200,2,'Suite','4',1),(6,300,4,'Suite','6',1),(7,150,2,'Simples','7',1),(8,300,4,'Suite','8',1),(9,200,2,'Suite','9',1),(10,300,4,'Suite','10',1);
/*!40000 ALTER TABLE `quarto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registro`
--

DROP TABLE IF EXISTS `hosp3`.`registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hosp3`.`registro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flag_ativo` tinyint(1) DEFAULT NULL,
  `consumo_id` int(11) DEFAULT NULL,
  `pagamento` varchar(45) DEFAULT NULL,
  `funcionario_id` int(11) DEFAULT NULL,
  `hospedagem_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_registro_1_idx` (`consumo_id`),
  KEY `fk_registro_4_idx` (`funcionario_id`),
  KEY `fk_registro_2_idx` (`hospedagem_id`),
  CONSTRAINT `fk_registro_1` FOREIGN KEY (`consumo_id`) REFERENCES `consumo_extra` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_registro_2` FOREIGN KEY (`hospedagem_id`) REFERENCES `hospedagem` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_registro_4` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro`
--

LOCK TABLES `hosp3`.`registro` WRITE;
/*!40000 ALTER TABLE `registro` DISABLE KEYS */;
INSERT INTO `hosp3`.`registro` VALUES (1,1,6,'925',2,4),(2,0,10,'600',3,1),(3,1,3,'400',1,2),(4,0,9,'700',4,3),(5,1,8,'300',2,7),(6,0,1,'280',3,6),(7,1,2,'400',3,8),(8,0,5,'650',4,5),(9,1,4,'480',2,10),(10,0,7,'300',1,9);
/*!40000 ALTER TABLE `registro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-18  0:18:25
