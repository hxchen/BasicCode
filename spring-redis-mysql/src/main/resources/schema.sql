
CREATE TABLE IF NOT EXISTS `Person` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `name` varchar(20) DEFAULT NULL,
    `age` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;