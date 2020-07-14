DROP TABLE IF EXISTS `advertisement`;
CREATE TABLE `advertisement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `advertisementMedia` varchar(255) DEFAULT NULL,
  `amountSpent` double DEFAULT NULL,
  `noOfAudienceAttracted` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;