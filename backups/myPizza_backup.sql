-- MySQL dump 10.13  Distrib 5.7.12, for osx10.11 (x86_64)
--
-- Host: localhost    Database: myPizzaSystem
-- ------------------------------------------------------
-- Server version	5.7.12

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
-- Table structure for table `cheese`
--

DROP TABLE IF EXISTS `cheese`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cheese` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cheese` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheese`
--

LOCK TABLES `cheese` WRITE;
/*!40000 ALTER TABLE `cheese` DISABLE KEYS */;
INSERT INTO `cheese` VALUES (1,'Mozzarella'),(2,'Cream');
/*!40000 ALTER TABLE `cheese` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_size`
--

DROP TABLE IF EXISTS `item_size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_size` (
  `size_id` int(11) NOT NULL AUTO_INCREMENT,
  `size` varchar(20) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`size_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_size`
--

LOCK TABLES `item_size` WRITE;
/*!40000 ALTER TABLE `item_size` DISABLE KEYS */;
INSERT INTO `item_size` VALUES (1,'small',1),(2,'medium',1),(3,'large',1);
/*!40000 ALTER TABLE `item_size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_types`
--

DROP TABLE IF EXISTS `item_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item_types` (
  `type_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) DEFAULT NULL,
  `size_id` int(11) DEFAULT NULL,
  `type` varchar(80) DEFAULT NULL,
  `detail` varchar(164) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_types`
--

LOCK TABLES `item_types` WRITE;
/*!40000 ALTER TABLE `item_types` DISABLE KEYS */;
INSERT INTO `item_types` VALUES (1,1,1,'Deep Dish Pizza','Tomato, oregano, garlic, and extra virgin olive oil',100),(2,1,2,'Neapolitan Pizza','Tomato sauce and grated mozzarella cheese',200),(3,1,2,'New York-Style Pizza','Cheese, meat, vegetables, and diced tomatoes or chunky marinara sauce',210),(4,1,3,'Deep Dish Pizza','Tomato, oregano, garlic, and extra virgin olive oil',250);
/*!40000 ALTER TABLE `item_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'pizza');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order1`
--

DROP TABLE IF EXISTS `order1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order1` (
  `order_id` int(11) DEFAULT NULL,
  `custName` varchar(40) DEFAULT NULL,
  `payment_id` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `date` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order1`
--

LOCK TABLES `order1` WRITE;
/*!40000 ALTER TABLE `order1` DISABLE KEYS */;
INSERT INTO `order1` VALUES (-429573009,'tausif',-1876132392,111,'Tue Aug 09 17:19:09 IST 2016'),(-2109993826,'jaydip',1065570317,338,'Tue Aug 09 17:51:09 IST 2016'),(925286073,'zxcczc',498748956,111,'Tue Aug 09 17:55:53 IST 2016'),(1802767780,'aditya',-14769102,626,'Tue Aug 09 17:56:41 IST 2016'),(1187086338,'kl',2042259402,348,'Wed Aug 10 12:11:47 IST 2016'),(1861198049,'Tausif',-1835585955,111,'Fri Oct 27 09:48:43 IST 2017');
/*!40000 ALTER TABLE `order1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `detail_id` int(11) DEFAULT NULL,
  `quant` int(11) DEFAULT NULL,
  `size` varchar(20) DEFAULT NULL,
  `base` varchar(40) DEFAULT NULL,
  `sauce` varchar(40) DEFAULT NULL,
  `topping` varchar(180) DEFAULT NULL,
  `cheese` varchar(20) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=275 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (258,-429573009,1,'small','Deep Dish Pizza','','Tomato, oregano, garlic, and extra virgin olive oil','',100),(264,-2109993826,1,'small','Normal','Margarita','Capsicum','Mozzarella',105),(265,-2109993826,1,'medium','Neapolitan Pizza','','Tomato sauce and grated mozzarella cheese','',200),(267,925286073,1,'small','Deep Dish Pizza','','Tomato, oregano, garlic, and extra virgin olive oil','',100),(268,1802767780,3,'small','Normal','Margarita','Capsicum','Mozzarella',315),(269,1802767780,1,'large','Deep Dish Pizza','','Tomato, oregano, garlic, and extra virgin olive oil','',250),(272,1187086338,1,'medium','New York-Style Pizza','','Cheese, meat, vegetables, and diced tomatoes or chunky marinara sauce','',210),(273,1187086338,1,'small','Normal','Margarita','Capsicum','Mozzarella',105),(274,1861198049,1,'small','Deep Dish Pizza','','Tomato, oregano, garlic, and extra virgin olive oil','',100);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizzaBase`
--

DROP TABLE IF EXISTS `pizzaBase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizzaBase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `base` varchar(40) DEFAULT NULL,
  `size_id` int(11) DEFAULT '1',
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzaBase`
--

LOCK TABLES `pizzaBase` WRITE;
/*!40000 ALTER TABLE `pizzaBase` DISABLE KEYS */;
INSERT INTO `pizzaBase` VALUES (1,'Normal',1,75),(2,'Pan Crust',1,100),(3,'Thin Crust',1,100),(4,'Cheesy Bites',1,125);
/*!40000 ALTER TABLE `pizzaBase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pizzaSauce`
--

DROP TABLE IF EXISTS `pizzaSauce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pizzaSauce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sauce` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pizzaSauce`
--

LOCK TABLES `pizzaSauce` WRITE;
/*!40000 ALTER TABLE `pizzaSauce` DISABLE KEYS */;
INSERT INTO `pizzaSauce` VALUES (1,'Margarita'),(2,'Mexican Salsa');
/*!40000 ALTER TABLE `pizzaSauce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temp`
--

DROP TABLE IF EXISTS `temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chesse` varchar(40) DEFAULT NULL,
  `abc` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temp`
--

LOCK TABLES `temp` WRITE;
/*!40000 ALTER TABLE `temp` DISABLE KEYS */;
INSERT INTO `temp` VALUES (1,'Red Pepper',NULL),(2,'Red Peppe2r',NULL),(3,NULL,'tausif'),(4,NULL,'ravi');
/*!40000 ALTER TABLE `temp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topping`
--

DROP TABLE IF EXISTS `topping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topping` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topping`
--

LOCK TABLES `topping` WRITE;
/*!40000 ALTER TABLE `topping` DISABLE KEYS */;
INSERT INTO `topping` VALUES (1,'Capsicum'),(2,'Onion'),(3,'Tomato'),(4,'Corn'),(5,'Baby Corn'),(6,'Jalapeno'),(7,'Black Olive'),(8,'Paneer'),(9,'Red Pepper');
/*!40000 ALTER TABLE `topping` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-30 19:41:10
