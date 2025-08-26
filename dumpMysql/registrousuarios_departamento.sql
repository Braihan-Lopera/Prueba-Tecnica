-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: registrousuarios
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id_departamento` int NOT NULL AUTO_INCREMENT,
  `departamento` varchar(100) DEFAULT NULL,
  `id_pais` int DEFAULT NULL,
  PRIMARY KEY (`id_departamento`),
  KEY `id_pais` (`id_pais`),
  CONSTRAINT `departamento_ibfk_1` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id_pais`)
) ENGINE=InnoDB AUTO_INCREMENT=177 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Amazonas',1),(2,'Antioquia',1),(3,'Arauca',1),(4,'Atlántico',1),(5,'Bolívar',1),(6,'Boyacá',1),(7,'Caldas',1),(8,'Caquetá',1),(9,'Casanare',1),(10,'Cauca',1),(11,'Cesar',1),(12,'Chocó',1),(13,'Córdoba',1),(14,'Cundinamarca',1),(15,'Guainía',1),(16,'Guaviare',1),(17,'Huila',1),(18,'La Guajira',1),(19,'Magdalena',1),(20,'Meta',1),(21,'Nariño',1),(22,'Norte de Santander',1),(23,'Putumayo',1),(24,'Quindío',1),(25,'Risaralda',1),(26,'San Andrés y Providencia',1),(27,'Santander',1),(28,'Sucre',1),(29,'Tolima',1),(30,'Valle del Cauca',1),(31,'Vaupés',1),(32,'Vichada',1),(33,'Region de Arica y Parinacota',2),(34,'Region de Tarapaca',2),(35,'Region de Antofagasta',2),(36,'Region de Atacama',2),(37,'Region de Coquimbo',2),(38,'Region de Valparaiso',2),(39,'Region Metropolitana de Santiago',2),(40,'Region de OHiggins',2),(41,'Region del Maule',2),(42,'Region de Nuble',2),(43,'Region del Biobio',2),(44,'Region de La Araucania',2),(45,'Region de Los Rios',2),(46,'Region de Los Lagos',2),(47,'Region de Aysen',2),(48,'Region de Magallanes',2),(49,'Aguascalientes',3),(50,'Baja California',3),(51,'Baja California Sur',3),(52,'Campeche',3),(53,'Chiapas',3),(54,'Chihuahua',3),(55,'Ciudad de México',3),(56,'Coahuila',3),(57,'Colima',3),(58,'Durango',3),(59,'Estado de México',3),(60,'Guanajuato',3),(61,'Guerrero',3),(62,'Hidalgo',3),(63,'Jalisco',3),(64,'Michoacán',3),(65,'Morelos',3),(66,'Nayarit',3),(67,'Nuevo León',3),(68,'Oaxaca',3),(69,'Puebla',3),(70,'Querétaro',3),(71,'Quintana Roo',3),(72,'San Luis Potosí',3),(73,'Sinaloa',3),(74,'Sonora',3),(75,'Tabasco',3),(76,'Tamaulipas',3),(77,'Tlaxcala',3),(78,'Veracruz',3),(79,'Yucatán',3),(80,'Zacatecas',3),(81,'Buenos Aires',4),(82,'Catamarca',4),(83,'Chaco',4),(84,'Chubut',4),(85,'Córdoba',4),(86,'Corrientes',4),(87,'Entre Ríos',4),(88,'Formosa',4),(89,'Jujuy',4),(90,'La Pampa',4),(91,'La Rioja',4),(92,'Mendoza',4),(93,'Misiones',4),(94,'Neuquén',4),(95,'Río Negro',4),(96,'Salta',4),(97,'San Juan',4),(98,'San Luis',4),(99,'Santa Cruz',4),(100,'Santa Fe',4),(101,'Santiago del Estero',4),(102,'Tierra del Fuego',4),(103,'Tucumán',4),(104,'Ciudad Autónoma de Buenos Aires',4),(105,'California',5),(106,'Texas',5),(107,'Florida',5),(108,'New York',5),(109,'Illinois',5),(110,'Pennsylvania',5),(111,'Ohio',5),(112,'Georgia',5),(113,'North Carolina',5),(114,'Michigan',5),(115,'California',5),(116,'Texas',5),(117,'Florida',5),(118,'New York',5),(119,'Illinois',5),(120,'Pennsylvania',5),(121,'Ohio',5),(122,'Georgia',5),(123,'North Carolina',5),(124,'Michigan',5),(125,'Île-de-France',6),(126,'Auvergne-Rhône-Alpes',6),(127,'Nouvelle-Aquitaine',6),(128,'Occitanie',6),(129,'Hauts-de-France',6),(130,'Provence-Alpes-Côte d\'Azur',6),(131,'Grand Est',6),(132,'Bretagne',6),(133,'Normandie',6),(134,'Pays de la Loire',6),(135,'Bourgogne-Franche-Comté',6),(136,'Centre-Val de Loire',6),(137,'Corse',6),(138,'Andalucía',7),(139,'Aragón',7),(140,'Asturias',7),(141,'Islas Baleares',7),(142,'Canarias',7),(143,'Cantabria',7),(144,'Castilla-La Mancha',7),(145,'Castilla y León',7),(146,'Cataluña',7),(147,'Extremadura',7),(148,'Galicia',7),(149,'Madrid',7),(150,'Murcia',7),(151,'Navarra',7),(152,'La Rioja',7),(153,'País Vasco',7),(154,'Comunidad Valenciana',7),(155,'Ceuta',7),(156,'Melilla',7),(157,'Abruzzo',8),(158,'Basilicata',8),(159,'Calabria',8),(160,'Campania',8),(161,'Emilia-Romagna',8),(162,'Friuli-Venezia Giulia',8),(163,'Lazio',8),(164,'Liguria',8),(165,'Lombardia',8),(166,'Marche',8),(167,'Molise',8),(168,'Piemonte',8),(169,'Puglia',8),(170,'Sardegna',8),(171,'Sicilia',8),(172,'Toscana',8),(173,'Trentino-Alto Adige',8),(174,'Umbria',8),(175,'Valle d\'Aosta',8),(176,'Veneto',8);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-26  1:33:26
