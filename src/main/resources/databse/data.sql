-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: oswap
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (2,'46s791g328h453l278u65','46s791g328h453l278u65',1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `cart_item`
--

LOCK TABLES `cart_item` WRITE;
/*!40000 ALTER TABLE `cart_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (3);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `image`
--

LOCK TABLES `image` WRITE;
/*!40000 ALTER TABLE `image` DISABLE KEYS */;
/*!40000 ALTER TABLE `image` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `order_settings`
--

LOCK TABLES `order_settings` WRITE;
/*!40000 ALTER TABLE `order_settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'2021-09-21','The Samsung Galaxy Z Fold3 5G speaks volumes about the South Korean electronics maker Samsung’s efforts to add finesse to its foldable devices.',1620,15,'Samsung Galaxy Z Fold3 5G',1),(2,'2021-09-20','Samsung Galaxy s21 5G',830.25,32,'Samsung Galaxy s21 5G',1),(3,'2021-09-19','The iPhone 13 Pro and iPhone 13 Pro Max are Apple\'s new high-end flagship iPhones. Now available.',1599,10,'Apple iPhone 13 Pro Max',1),(4,'2021-09-18','Text text text text text text text text text text text text text text text text text',456,15,'HONOR Magic3 PRO',1),(5,'2021-09-17','Text text text text text text text text text text text text text text text text text',258,26,'HTC Desire 20+',2),(6,'2021-09-16','Text text text text text text text text text text text text text text text text text',985,32,'NOKIA C30',2),(7,'2021-09-15','Text text text text text text text text text text text text text text text text text',1256.45,5,'XIAOMI Redmi 10 Prime',2),(8,'2021-09-14','Text text text text text text text text text text text text text text text text text',999.99,41,'OPPO  Reno6',2),(9,'2021-09-13','Text text text text text text text text text text text text text text text text text',300,30,'SONY Xperia 5 III',1),(10,'2021-09-12','Text text text text text text text text text text text text text text text text text',687.49,0,'MOTOROLA Moto E20',1),(11,'2021-09-25','Sākuma nots: aldehīdi, ananass, zaļais mandarīns, galbanums, persiks. Sirds nots: neļķe, āda, dzeltenā narcise, muskuss, orhideja. Beigu nots: ambra, sandalkoks, tonka pupiņas, vaniļa, vetivērija.',122.31,6,' Tualetes ūdens Cartier Must de Cartier 100ml EDT',3),(12,'2021-09-24','Sākuma nots: zaļās notis un bergamote. Sirds nots: rozmarīns, lilija, ceriņi, jasmīns, boronija, amarilis, īlang-īlang, maijpuķīte. Beigu nots: sandalkoks un civets.',144.11,25,'Tualetes ūdens Christian Dior Diorissimo 100ml EDT',3),(13,'2021-09-17','ProSense technology® automātiski nosver ievietotās drēbes, lai izveidotu individuāli piemērotu ciklu. Sensori precīzi regulē mazgāšanas laiku, nodrošinot optimālu katra apģērba mazgāšanu.',549,5,'Veļas mašīna AEG L8FEC68S',3),(14,'2021-09-21','The Samsung Galaxy Z Fold3 5G speaks volumes about the South Korean electronics maker Samsung’s efforts to add finesse to its foldable devices.',1620,15,'Samsung Galaxy Z Fold3 5G',1),(15,'2021-09-20','Samsung Galaxy s21 5G',830.25,32,'Samsung Galaxy s21 5G',1),(16,'2021-09-19','The iPhone 13 Pro and iPhone 13 Pro Max are Apple\'s new high-end flagship iPhones. Now available.',1599,10,'Apple iPhone 13 Pro Max',1),(17,'2021-09-18','Text text text text text text text text text text text text text text text text text',456,15,'HONOR Magic3 PRO',1),(18,'2021-09-17','Text text text text text text text text text text text text text text text text text',258,26,'HTC Desire 20+',2),(19,'2021-09-16','Text text text text text text text text text text text text text text text text text',985,32,'NOKIA C30',2),(20,'2021-09-15','Text text text text text text text text text text text text text text text text text',1256.45,5,'XIAOMI Redmi 10 Prime',2),(21,'2021-09-14','Text text text text text text text text text text text text text text text text text',999.99,41,'OPPO  Reno6',2),(22,'2021-09-13','Text text text text text text text text text text text text text text text text text',300,30,'SONY Xperia 5 III',1),(23,'2021-09-12','Text text text text text text text text text text text text text text text text text',687.49,0,'MOTOROLA Moto E20',1),(24,'2021-09-25','Sākuma nots: aldehīdi, ananass, zaļais mandarīns, galbanums, persiks. Sirds nots: neļķe, āda, dzeltenā narcise, muskuss, orhideja. Beigu nots: ambra, sandalkoks, tonka pupiņas, vaniļa, vetivērija.',122.31,6,' Tualetes ūdens Cartier Must de Cartier 100ml EDT',3),(25,'2021-09-21','The Samsung Galaxy Z Fold3 5G speaks volumes about the South Korean electronics maker Samsung’s efforts to add finesse to its foldable devices.',1620,15,'Samsung Galaxy Z Fold3 5G',1),(26,'2021-09-20','Samsung Galaxy s21 5G',830.25,32,'Samsung Galaxy s21 5G',1),(27,'2021-09-19','The iPhone 13 Pro and iPhone 13 Pro Max are Apple\'s new high-end flagship iPhones. Now available.',1599,10,'Apple iPhone 13 Pro Max',1),(28,'2021-09-18','Text text text text text text text text text text text text text text text text text',456,15,'HONOR Magic3 PRO',1),(29,'2021-09-17','Text text text text text text text text text text text text text text text text text',258,26,'HTC Desire 20+',2),(30,'2021-09-16','Text text text text text text text text text text text text text text text text text',985,32,'NOKIA C30',2),(31,'2021-09-15','Text text text text text text text text text text text text text text text text text',1256.45,5,'XIAOMI Redmi 10 Prime',2),(32,'2021-09-14','Text text text text text text text text text text text text text text text text text',999.99,41,'OPPO  Reno6',2),(33,'2021-09-13','Text text text text text text text text text text text text text text text text text',300,30,'SONY Xperia 5 III',1),(34,'2021-09-12','Text text text text text text text text text text text text text text text text text',687.49,0,'MOTOROLA Moto E20',1),(35,'2021-09-25','Sākuma nots: aldehīdi, ananass, zaļais mandarīns, galbanums, persiks. Sirds nots: neļķe, āda, dzeltenā narcise, muskuss, orhideja. Beigu nots: ambra, sandalkoks, tonka pupiņas, vaniļa, vetivērija.',122.31,6,' Tualetes ūdens Cartier Must de Cartier 100ml EDT',3),(36,'2021-09-21','The Samsung Galaxy Z Fold3 5G speaks volumes about the South Korean electronics maker Samsung’s efforts to add finesse to its foldable devices.',1620,15,'Samsung Galaxy Z Fold3 5G',1),(37,'2021-09-20','Samsung Galaxy s21 5G',830.25,32,'Samsung Galaxy s21 5G',1);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_category`
--

LOCK TABLES `product_category` WRITE;
/*!40000 ALTER TABLE `product_category` DISABLE KEYS */;
INSERT INTO `product_category` VALUES (1,'2021-09-19','Phones & Accessories'),(2,'2021-09-16','Garden'),(3,'2021-09-21','Computers & Netbooks'),(4,'2021-09-25','Household Appliances');
/*!40000 ALTER TABLE `product_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2,'USER'),(3,'EDITOR'),(4,'ADMIN');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'user','$2a$10$krGWP3CUfNc4bjwAK50V2.R4VoyCMMB1UhesKYJFgXzics9DR3wAu','Ilmars','Mednis','1965-12-25','28742994','ilmarsm@gmail.com','male','2021-09-26','2021-09-18',1),(2,'admin','$2a$10$uMdQOzz.qT3AeR3xJOAbD.tryYvRCSW3nZ2UheCaYJn.0gze7sxee','Administrator','Super','1999-05-25','12345678','admin@ad,im.com','male','2021-09-02','2021-09-27',1),(3,'janis','$2a$10$eZbgLydjmeWwCw0U4Dw.cuzt1ezHovAaKshQYngcJTFEhrrx/b2MG','Jānis','Dreimanis','1970-01-01','12345678','janis@gmail.com','male','2021-09-20','2021-09-27',1),(4,'ilmars','$2a$10$gJuiHVllO0GZoa4jY8wt9.XMZwKUH/YB9m9o7K2YkpmV9W4hTbPCG','Ilmars','Mednis','1965-12-25','28742994','ilmasm@gmail.com','male','2021-09-27','2021-08-29',1),(5,'linda','$2a$10$ruNBfk/3AR2uvVhkvGdxVuzrJwEgu3tDy8DqkWfQekGxgHu9sD8mq','Linda','Aušte','1990-01-01','12345678','linda@gmail.com','female','2021-09-25','2021-09-26',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_review`
--

LOCK TABLES `user_review` WRITE;
/*!40000 ALTER TABLE `user_review` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,2),(2,4),(3,4),(4,4),(5,4);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-30 10:45:31
