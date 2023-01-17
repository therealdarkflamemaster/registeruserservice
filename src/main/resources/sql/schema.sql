DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `id` INT AUTO_INCREMENT  PRIMARY KEY,
    `username` VARCHAR(250) NOT NULL UNIQUE,
    `brithdate` DATE NOT NULL,
    `residence` VARCHAR(250) NOT NULL,
    `phone_number` VARCHAR(250) DEFAULT NULL,
    `gender` VARCHAR(250) DEFAULT NULL
);