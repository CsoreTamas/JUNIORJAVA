CREATE SCHEMA `movie_rental_store` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci ;

CREATE TABLE `movie_rental_store`.`movie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `genre` VARCHAR(45) NOT NULL,
  `available` TINYINT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `movie_rental_store`.`rental` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_name` VARCHAR(45) NOT NULL,
  `movie_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `movie_id_idx` (`movie_id` ASC) VISIBLE,
  CONSTRAINT `movie_id`
    FOREIGN KEY (`movie_id`)
    REFERENCES `movie_rental_store`.`movie` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

