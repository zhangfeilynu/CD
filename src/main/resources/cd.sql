USE cd;
CREATE TABLE `users2` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(255) NOT NULL,
    `age` INT(10) NOT NULL,
    `phone` BIGINT NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO users2 VALUES(1,'赵',23,158,'3658561548@qq.com');
INSERT INTO users2 VALUES(2,'钱',27,136,'3658561548@126.com');
INSERT INTO users2 VALUES(3,'孙',31,159,'3658561548@163.com');
INSERT INTO users2 VALUES(4,'李',35,130,'3658561548@sina.com');



USE cd;
CREATE TABLE `userposition` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    `city` VARCHAR(20) NOT NULL,
    `position` VARCHAR(128) NOT NULL,
    `longitude` DECIMAL(18,15) NOT NULL,
    `latitude` DECIMAL(18,15) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `userposition` VALUES(1,'北京市','回龙观新村中区', 116.310771,40.06263);
INSERT INTO `userposition` VALUES(2,'北京市','金域华府', 116.310127,40.064379);
INSERT INTO `userposition` VALUES(3,'北京市','融泽嘉园中区', 116.311962,40.064822);
INSERT INTO `userposition` VALUES(4,'北京市','回龙观新村东区', 116.312541,40.063246);
INSERT INTO `userposition` VALUES(5,'北京市','上地东里', 116.314168,40.033075);






SELECT
    *,
    ROUND(
        6378.138 * 2 * ASIN(
            SQRT(
                POW(
                    SIN(
                        (
                            40.06274 * PI() / 180 - latitude * PI() / 180
                        ) / 2
                    ),
                ) + COS(40.06274 * PI() / 180) * COS(latitude * PI() / 180) * POW(
                    SIN(
                        (
                            116.310517 * PI() / 180 - longitude * PI() / 180
                        ) / 2
                    ),
                )
            )
        ) * 1000
    ) AS distance
FROM
    userposition
ORDER BY
    distance ASC
