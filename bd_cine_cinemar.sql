-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_cine_final
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
-- Table structure for table `butacas`
--

DROP TABLE IF EXISTS `butacas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `butacas` (
  `id_Butaca` int NOT NULL AUTO_INCREMENT,
  `fila` varchar(5) NOT NULL,
  `numero` int NOT NULL,
  `reservada` tinyint NOT NULL,
  `sala` int NOT NULL,
  PRIMARY KEY (`id_Butaca`),
  KEY `fk_id_sala_idx` (`sala`),
  CONSTRAINT `fk_idsala` FOREIGN KEY (`sala`) REFERENCES `salas` (`id_salas`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `butacas`
--

LOCK TABLES `butacas` WRITE;
/*!40000 ALTER TABLE `butacas` DISABLE KEYS */;
INSERT INTO `butacas` VALUES (127,'A',1,0,3),(128,'A',2,0,3),(129,'A',3,0,3),(130,'A',4,0,3),(131,'A',5,0,3),(132,'A',6,0,3),(133,'A',7,0,3),(134,'A',8,0,3),(135,'A',9,0,3),(136,'A',10,0,3),(137,'B',1,0,3),(138,'B',2,0,3),(139,'B',3,0,3),(140,'B',4,0,3),(141,'B',5,0,3),(142,'B',6,0,3),(143,'B',7,0,3),(144,'B',8,0,3),(145,'B',9,0,3),(146,'B',10,0,3),(147,'C',1,0,3),(148,'C',2,0,3),(149,'C',3,0,3),(150,'C',4,0,3),(151,'C',5,0,3),(152,'C',6,0,3),(153,'C',7,0,3),(154,'C',8,0,3),(155,'C',9,0,3),(156,'C',10,0,3);
/*!40000 ALTER TABLE `butacas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descuento`
--

DROP TABLE IF EXISTS `descuento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `descuento` (
  `id_descuento` int NOT NULL AUTO_INCREMENT,
  `dia` varchar(10) NOT NULL,
  `porcentaje` float NOT NULL,
  `precioFinal` int NOT NULL,
  PRIMARY KEY (`id_descuento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuento`
--

LOCK TABLES `descuento` WRITE;
/*!40000 ALTER TABLE `descuento` DISABLE KEYS */;
INSERT INTO `descuento` VALUES (3,'lunes',20,800);
/*!40000 ALTER TABLE `descuento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funciones`
--

DROP TABLE IF EXISTS `funciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funciones` (
  `idfunciones` int NOT NULL AUTO_INCREMENT,
  `id_pelicula` int NOT NULL,
  `id_sala` int NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `precio` int NOT NULL,
  PRIMARY KEY (`idfunciones`),
  KEY `fk_id_pelicula_idx` (`id_pelicula`),
  KEY `fk_id_sala_idx` (`id_sala`),
  CONSTRAINT `fk_id_pelicula` FOREIGN KEY (`id_pelicula`) REFERENCES `pelicula` (`id_pelicula`),
  CONSTRAINT `fk_id_sala` FOREIGN KEY (`id_sala`) REFERENCES `salas` (`id_salas`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funciones`
--

LOCK TABLES `funciones` WRITE;
/*!40000 ALTER TABLE `funciones` DISABLE KEYS */;
INSERT INTO `funciones` VALUES (2,1,3,'2022-05-12','13:00:00',500),(3,2,3,'2021-03-12','14:00:00',700),(4,3,2,'2021-04-12','18:00:00',400);
/*!40000 ALTER TABLE `funciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelicula`
--

DROP TABLE IF EXISTS `pelicula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pelicula` (
  `id_pelicula` int NOT NULL AUTO_INCREMENT,
  `duracion` int NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `Estreno` tinyint DEFAULT NULL,
  `Idioma` varchar(45) NOT NULL,
  `PrecioXpers` float NOT NULL,
  PRIMARY KEY (`id_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelicula`
--

LOCK TABLES `pelicula` WRITE;
/*!40000 ALTER TABLE `pelicula` DISABLE KEYS */;
INSERT INTO `pelicula` VALUES (1,2,'comedia','los simpsons xd',1,'ingles',200),(2,2,'infantil','madagascar',0,'castellano',400),(3,3,'terror','actividad paranormal',0,'japones',300);
/*!40000 ALTER TABLE `pelicula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id_reservas` int NOT NULL AUTO_INCREMENT,
  `fk_idFunc` int NOT NULL,
  `fecha` date NOT NULL,
  `precio` float NOT NULL,
  `fk_idUser` int NOT NULL,
  `hora` time NOT NULL,
  `fk_idButac` int NOT NULL,
  `fk_iddesc` int NOT NULL,
  `fk_tarjCredito` int NOT NULL,
  PRIMARY KEY (`id_reservas`),
  KEY `fk_id_user_idx` (`fk_idUser`),
  KEY `fk_idButac_idx` (`fk_idButac`),
  KEY `fk_idfunc_idx` (`fk_idFunc`),
  KEY `fk_idDesc_idx` (`fk_iddesc`),
  KEY `fk_idtarjCre_idx` (`fk_tarjCredito`),
  CONSTRAINT `fk_id_user` FOREIGN KEY (`fk_idUser`) REFERENCES `usuarios` (`id_usuario`),
  CONSTRAINT `fk_idButac` FOREIGN KEY (`fk_idButac`) REFERENCES `butacas` (`id_Butaca`),
  CONSTRAINT `fk_idDesc` FOREIGN KEY (`fk_iddesc`) REFERENCES `descuento` (`id_descuento`),
  CONSTRAINT `fk_idfunc` FOREIGN KEY (`fk_idFunc`) REFERENCES `funciones` (`idfunciones`),
  CONSTRAINT `fk_idtarjCre` FOREIGN KEY (`fk_tarjCredito`) REFERENCES `tarjcredito` (`id_tarjCredito`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (3,2,'2022-07-16',500,1,'13:47:00',127,3,1),(4,2,'2022-05-12',500,1,'13:00:00',127,3,1);
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salas`
--

DROP TABLE IF EXISTS `salas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salas` (
  `id_salas` int NOT NULL,
  `formato` varchar(45) NOT NULL,
  `capacidades` int NOT NULL,
  PRIMARY KEY (`id_salas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salas`
--

LOCK TABLES `salas` WRITE;
/*!40000 ALTER TABLE `salas` DISABLE KEYS */;
INSERT INTO `salas` VALUES (2,'3d',30),(3,'3d',30);
/*!40000 ALTER TABLE `salas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarjcredito`
--

DROP TABLE IF EXISTS `tarjcredito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjcredito` (
  `id_tarjCredito` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `balance` double NOT NULL,
  `limite` double NOT NULL,
  `banco` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_tarjCredito`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjcredito`
--

LOCK TABLES `tarjcredito` WRITE;
/*!40000 ALTER TABLE `tarjcredito` DISABLE KEYS */;
INSERT INTO `tarjcredito` VALUES (1,314,800,1000,'santander'),(2,0,0,0,'');
/*!40000 ALTER TABLE `tarjcredito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `tipoUsuario` int NOT NULL,
  `id_tarjCred` int NOT NULL,
  `dni` int NOT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `fk_tarjCred_idx` (`id_tarjCred`),
  CONSTRAINT `fk_tarjCred` FOREIGN KEY (`id_tarjCred`) REFERENCES `tarjcredito` (`id_tarjCredito`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'user@gmail.com','hola1','cristian','villa',2,1,23431123),(2,'admin@gmail.com','priv1','Jefe1','jefecito',1,2,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-10 23:18:12
