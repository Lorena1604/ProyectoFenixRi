CREATE DATABASE  IF NOT EXISTS `fenixbd` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fenixbd`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: fenixbd
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.9-MariaDB

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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividades` (
  `idActividad` int(11) NOT NULL AUTO_INCREMENT,
  `lugar` varchar(35) NOT NULL,
  `fechaYhoraDeActividad` datetime DEFAULT NULL,
  `tipoDeActividad` int(11) NOT NULL,
  `descripcionActividad` text NOT NULL,
  PRIMARY KEY (`idActividad`),
  KEY `actividad_tipo_idx` (`tipoDeActividad`),
  KEY `fechaYhoraDeActividad` (`fechaYhoraDeActividad`),
  KEY `lugar` (`lugar`),
  FULLTEXT KEY `descripcion` (`descripcionActividad`),
  CONSTRAINT `actividad_tipo` FOREIGN KEY (`tipoDeActividad`) REFERENCES `tipoactividades` (`idtipoActividad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asignarpermisos`
--

DROP TABLE IF EXISTS `asignarpermisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asignarpermisos` (
  `idRol` int(11) NOT NULL,
  `idPermiso` int(11) NOT NULL,
  PRIMARY KEY (`idRol`,`idPermiso`),
  KEY `permisoRol_idx` (`idRol`),
  KEY `permisoAsignarPermiso_idx` (`idPermiso`),
  CONSTRAINT `permisoAsignarPermiso` FOREIGN KEY (`idPermiso`) REFERENCES `permisos` (`idPermiso`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `permisoRol` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignarpermisos`
--

LOCK TABLES `asignarpermisos` WRITE;
/*!40000 ALTER TABLE `asignarpermisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignarpermisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asistencias`
--

DROP TABLE IF EXISTS `asistencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistencias` (
  `idAsistencia` int(11) NOT NULL,
  `ficha` int(11) DEFAULT NULL,
  `actividad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAsistencia`),
  KEY `AsistenciaFicha_idx` (`ficha`),
  KEY `AsistenciaActividad_idx` (`actividad`),
  CONSTRAINT `AsistenciaActividad` FOREIGN KEY (`actividad`) REFERENCES `actividades` (`idActividad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `AsistenciaFicha` FOREIGN KEY (`ficha`) REFERENCES `fichas` (`idFicha`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistencias`
--

LOCK TABLES `asistencias` WRITE;
/*!40000 ALTER TABLE `asistencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `asistencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cinturones`
--

DROP TABLE IF EXISTS `cinturones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cinturones` (
  `idCinturon` int(11) NOT NULL AUTO_INCREMENT,
  `cinturon` varchar(25) NOT NULL,
  `rango` varchar(20) NOT NULL,
  PRIMARY KEY (`idCinturon`),
  KEY `cinturon` (`cinturon`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cinturones`
--

LOCK TABLES `cinturones` WRITE;
/*!40000 ALTER TABLE `cinturones` DISABLE KEYS */;
INSERT INTO `cinturones` VALUES (1,'Cabuya',''),(2,'Blanco','13°  kup'),(3,'Blanco franja Amarillo','12° Kup'),(4,'Amarillo','11° Kup'),(5,'Amarillo franja Verde','10° Kup'),(6,'Verde','9° Kup'),(7,'Verde franja Azul','8° Kup'),(8,'Azul','7° Kup'),(9,'Azul franja Violeta','6° Kup'),(10,'Violeta','5° Kup'),(11,'Violeta franja Rojo','4° Kup'),(12,'Rojo','3° Kup'),(13,'Rojo franja Negro','2° Kup'),(14,'Negro','1° Kup'),(15,'Negro','l Dan'),(16,'Negro','ll Dan'),(17,'Negro','lll Dan'),(18,'Negro','lV Dan'),(19,'Negro','V Dan'),(20,'Negro','Vl Dan'),(21,'Negro','Vll Dan'),(22,'Negro','Vlll Dan'),(23,'Negro','lX Dan');
/*!40000 ALTER TABLE `cinturones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eps`
--

DROP TABLE IF EXISTS `eps`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eps` (
  `idEps` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idEps`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eps`
--

LOCK TABLES `eps` WRITE;
/*!40000 ALTER TABLE `eps` DISABLE KEYS */;
INSERT INTO `eps` VALUES (1,'Salud Total'),(2,'Capital Salud'),(3,'Compensar'),(4,'Famisanar'),(5,'Cruz Blanca'),(6,'Nueva Eps'),(7,'Coomeva'),(8,'Saludcoop'),(9,'Solsalud');
/*!40000 ALTER TABLE `eps` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estados`
--

DROP TABLE IF EXISTS `estados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estados` (
  `idEstado` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(12) NOT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estados`
--

LOCK TABLES `estados` WRITE;
/*!40000 ALTER TABLE `estados` DISABLE KEYS */;
INSERT INTO `estados` VALUES (1,'Activo'),(2,'Inactivo'),(3,'Trasladado');
/*!40000 ALTER TABLE `estados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evidencias`
--

DROP TABLE IF EXISTS `evidencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evidencias` (
  `idEvidencias` int(11) NOT NULL AUTO_INCREMENT,
  `documentos` blob NOT NULL,
  `idActividad` int(11) NOT NULL,
  PRIMARY KEY (`idEvidencias`),
  KEY `evidenciasActividades_idx` (`idActividad`),
  CONSTRAINT `evidenciasActividades` FOREIGN KEY (`idActividad`) REFERENCES `actividades` (`idActividad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evidencias`
--

LOCK TABLES `evidencias` WRITE;
/*!40000 ALTER TABLE `evidencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `evidencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evoluciones`
--

DROP TABLE IF EXISTS `evoluciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evoluciones` (
  `idEvolucion` int(11) NOT NULL AUTO_INCREMENT,
  `idFicha` int(11) NOT NULL,
  `fechaEvolucion` date NOT NULL,
  `peso` varchar(5) NOT NULL,
  `idRendimiento` int(11) NOT NULL,
  `idCinturon` int(11) NOT NULL,
  `estatura` varchar(10) NOT NULL,
  PRIMARY KEY (`idEvolucion`),
  KEY `evolucionesCinturon_idx` (`idCinturon`),
  KEY `fichaEvoluciones_idx` (`idFicha`),
  KEY `evolucionesRendimiento_idx` (`idRendimiento`),
  CONSTRAINT `evolucionesCinturon` FOREIGN KEY (`idCinturon`) REFERENCES `cinturones` (`idCinturon`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `evolucionesFicha` FOREIGN KEY (`idFicha`) REFERENCES `fichas` (`idFicha`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `evolucionesRendimiento` FOREIGN KEY (`idRendimiento`) REFERENCES `rendimientos` (`idRendimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evoluciones`
--

LOCK TABLES `evoluciones` WRITE;
/*!40000 ALTER TABLE `evoluciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `evoluciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fichas`
--

DROP TABLE IF EXISTS `fichas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fichas` (
  `idFicha` int(11) NOT NULL AUTO_INCREMENT,
  `numeroRegistro` varchar(8) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `fotoUsuario` blob,
  `epsUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idFicha`),
  KEY `usuariosFichas_idx` (`idUsuario`),
  KEY `fechaIngreso` (`fechaIngreso`),
  KEY `usuariosEps_idx` (`epsUsuario`),
  CONSTRAINT `usuariosEps` FOREIGN KEY (`epsUsuario`) REFERENCES `eps` (`idEps`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuariosFichas` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fichas`
--

LOCK TABLES `fichas` WRITE;
/*!40000 ALTER TABLE `fichas` DISABLE KEYS */;
/*!40000 ALTER TABLE `fichas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instructores`
--

DROP TABLE IF EXISTS `instructores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instructores` (
  `idInstructor` int(11) NOT NULL,
  `licenciaDeportiva` blob NOT NULL,
  PRIMARY KEY (`idInstructor`),
  CONSTRAINT `instructorUsuario` FOREIGN KEY (`idInstructor`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instructores`
--

LOCK TABLES `instructores` WRITE;
/*!40000 ALTER TABLE `instructores` DISABLE KEYS */;
/*!40000 ALTER TABLE `instructores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localidades`
--

DROP TABLE IF EXISTS `localidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localidades` (
  `idLocalidad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(25) NOT NULL,
  PRIMARY KEY (`idLocalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localidades`
--

LOCK TABLES `localidades` WRITE;
/*!40000 ALTER TABLE `localidades` DISABLE KEYS */;
INSERT INTO `localidades` VALUES (1,'Usaquén'),(2,'Chapinero'),(3,'Santa fe'),(4,'San Cristóbal'),(5,'Usme'),(6,'Tunjuelito'),(7,'Bosa'),(8,'Ciudad Kennedy'),(9,'Fontibón'),(10,'Engativa'),(11,'Suba'),(12,'Barrios Unidos'),(13,'Teusaquillo'),(14,'Los Mártires'),(15,'Antonio Nariño'),(16,'Puente Aranda'),(17,'Candelaria'),(18,'Rafael Uribe '),(19,'Ciudad Bolivar'),(20,'Sumapáz');
/*!40000 ALTER TABLE `localidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagosestudiante`
--

DROP TABLE IF EXISTS `pagosestudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pagosestudiante` (
  `idpago` int(11) NOT NULL AUTO_INCREMENT,
  `idEstudiante` int(11) NOT NULL,
  `fechaPago` date NOT NULL,
  `monto` int(11) NOT NULL,
  `mensualidad` date NOT NULL,
  PRIMARY KEY (`idpago`),
  KEY `EstudiantePagos_idx` (`idEstudiante`),
  KEY `mensualidad` (`mensualidad`),
  CONSTRAINT `EstudiantePagos` FOREIGN KEY (`idEstudiante`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagosestudiante`
--

LOCK TABLES `pagosestudiante` WRITE;
/*!40000 ALTER TABLE `pagosestudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagosestudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permisos`
--

DROP TABLE IF EXISTS `permisos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permisos` (
  `idPermiso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `descripcion` text,
  `urlPermiso` varchar(120) DEFAULT NULL,
  `idPermisoPadre` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPermiso`),
  KEY `nombre` (`nombre`),
  KEY `permisoPermisoPadre_idx` (`idPermisoPadre`),
  CONSTRAINT `permisoPermisoPadre` FOREIGN KEY (`idPermisoPadre`) REFERENCES `permisos` (`idPermiso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permisos`
--

LOCK TABLES `permisos` WRITE;
/*!40000 ALTER TABLE `permisos` DISABLE KEYS */;
/*!40000 ALTER TABLE `permisos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rendimientos`
--

DROP TABLE IF EXISTS `rendimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rendimientos` (
  `idRendimiento` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`idRendimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rendimientos`
--

LOCK TABLES `rendimientos` WRITE;
/*!40000 ALTER TABLE `rendimientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `rendimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuestas`
--

DROP TABLE IF EXISTS `respuestas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuestas` (
  `idrespuesta` int(11) NOT NULL AUTO_INCREMENT,
  `idInstructor` int(11) NOT NULL,
  `idSugerencia` int(11) NOT NULL,
  `fechaRespuesta` datetime NOT NULL,
  `respuesta` text NOT NULL,
  PRIMARY KEY (`idrespuesta`),
  KEY `respuestaSugerencia_idx` (`idSugerencia`),
  KEY `instructorRespuesta_idx` (`idInstructor`),
  FULLTEXT KEY `respuesta` (`respuesta`),
  CONSTRAINT `instructorRespuesta` FOREIGN KEY (`idInstructor`) REFERENCES `instructores` (`idInstructor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `respuestaSugerencia` FOREIGN KEY (`idSugerencia`) REFERENCES `sugerencias` (`idSugerencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuestas`
--

LOCK TABLES `respuestas` WRITE;
/*!40000 ALTER TABLE `respuestas` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuestas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `roles` (
  `idRol` int(11) NOT NULL,
  `descripcion` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Estudiante'),(2,'Instructor');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rolesusuario`
--

DROP TABLE IF EXISTS `rolesusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rolesusuario` (
  `idUsuario` int(11) NOT NULL,
  `rol` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`,`rol`),
  KEY `rolUsuario_idx` (`idUsuario`),
  KEY `rolesUsuarioRol_idx` (`rol`),
  CONSTRAINT `rolUsuario` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `rolesUsuarioRol` FOREIGN KEY (`rol`) REFERENCES `roles` (`idRol`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rolesusuario`
--

LOCK TABLES `rolesusuario` WRITE;
/*!40000 ALTER TABLE `rolesusuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `rolesusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sugerencias`
--

DROP TABLE IF EXISTS `sugerencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sugerencias` (
  `idSugerencia` int(11) NOT NULL AUTO_INCREMENT,
  `ficha` int(11) NOT NULL,
  `sugerencia` text NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`idSugerencia`),
  KEY `fichasSugerencias_idx` (`ficha`),
  FULLTEXT KEY `sugerencia` (`sugerencia`),
  CONSTRAINT `fichasSugerencias` FOREIGN KEY (`ficha`) REFERENCES `fichas` (`idFicha`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sugerencias`
--

LOCK TABLES `sugerencias` WRITE;
/*!40000 ALTER TABLE `sugerencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `sugerencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonos`
--

DROP TABLE IF EXISTS `telefonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefonos` (
  `idTelefono` int(11) NOT NULL AUTO_INCREMENT,
  `numero` bigint(20) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idTelefono`),
  KEY `telefonoUsuarios_idx` (`idUsuario`),
  CONSTRAINT `telefonoUsuarios` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonos`
--

LOCK TABLES `telefonos` WRITE;
/*!40000 ALTER TABLE `telefonos` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefonos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoactividades`
--

DROP TABLE IF EXISTS `tipoactividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipoactividades` (
  `idtipoActividad` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(80) NOT NULL,
  PRIMARY KEY (`idtipoActividad`),
  KEY `descripcion` (`descripcion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoactividades`
--

LOCK TABLES `tipoactividades` WRITE;
/*!40000 ALTER TABLE `tipoactividades` DISABLE KEYS */;
INSERT INTO `tipoactividades` VALUES (3,'Cumpleaños del club'),(4,'Entrenamiento especial'),(2,'Examen'),(1,'Torneo');
/*!40000 ALTER TABLE `tipoactividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodocumentos`
--

DROP TABLE IF EXISTS `tipodocumentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipodocumentos` (
  `idtipoDocumentos` int(11) NOT NULL AUTO_INCREMENT,
  `tipoDeDocumento` varchar(25) NOT NULL,
  PRIMARY KEY (`idtipoDocumentos`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodocumentos`
--

LOCK TABLES `tipodocumentos` WRITE;
/*!40000 ALTER TABLE `tipodocumentos` DISABLE KEYS */;
INSERT INTO `tipodocumentos` VALUES (1,'Cedula'),(2,'Tarjeta de identidad');
/*!40000 ALTER TABLE `tipodocumentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `identificacion` bigint(20) NOT NULL,
  `nombres` varchar(35) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `tipoDocumento` int(11) NOT NULL,
  `idLocalidad` int(11) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `correoElectronico` varchar(35) NOT NULL,
  `contrasena` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date NOT NULL,
  `estado` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`),
  KEY `usuaioTipoDocumento_idx` (`tipoDocumento`),
  KEY `usuarioEstado_idx` (`estado`),
  KEY `nombres,apellidos` (`nombres`,`apellidos`),
  KEY `contraseña` (`contrasena`),
  KEY `usuarioLocalidad_idx` (`idLocalidad`),
  CONSTRAINT `usuarioEstado` FOREIGN KEY (`estado`) REFERENCES `estados` (`idEstado`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuarioLocalidad` FOREIGN KEY (`idLocalidad`) REFERENCES `localidades` (`idLocalidad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `usuarioTipoDocumento` FOREIGN KEY (`tipoDocumento`) REFERENCES `tipodocumentos` (`idtipoDocumentos`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1019114353 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (445254212,4144524587,'Carlos','Fernandez ',1,9,'calle 62','carfer@gmail.com','—öÜ2ø½Ö¼$xOóåñ','1992-04-08',3),(1019114331,1019114330,'Lorena ','Forero Martinez',1,5,'calle 139','ylforero0@misena.edu.co','‹3ŒÈoEk‹ï‚zÙ›ù','1995-11-03',1),(1019114332,1201554222,'Angie ','Garcia Lopez',1,4,'Calle 655','Anga@hotmail.com','Ã¢“ósÊ£øÇÍ„ý¹','1994-04-05',1),(1019114342,6546455665,'Julian','Gonzales',1,6,'calle 76','juligo@hotmail.com','Ù‡î×RµU\ZLH£$Æ|','1993-11-07',3);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fenixbd'
--

--
-- Dumping routines for database 'fenixbd'
--
/*!50003 DROP FUNCTION IF EXISTS `guardarContrasena` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `guardarContrasena`(contra VARCHAR(45)) RETURNS varchar(45) CHARSET latin1
BEGIN
DECLARE resultado VARCHAR(45);
SET resultado = (SELECT AES_ENCRYPT('fenixcontra202',contra));
RETURN resultado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `crearContrasena` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `crearContrasena`(in identificacion int)
BEGIN

DECLARE contra VARCHAR(45);

SET contra = identificacion;

INSERT INTO usuarios(contrasena) values(guardarContraseña(contra));
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-05 19:50:47
