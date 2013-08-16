CREATE  TABLE `video_locadora`.`people` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `legal_name` VARCHAR(255) NULL,
  `document_1` VARCHAR(10) NULL,
  `document_2` VARCHAR(10) NULL,
  `email` VARCHAR(255) NULL,
  `phone` VARCHAR(10) NULL,
  `cel` VARCHAR(10) NULL,
  `status` VARCHAR(45) NULL,
  `kind` VARCHAR(10) NULL,
  PRIMARY KEY (`id`)
);

CREATE  TABLE `video_locadora`.`countries` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  PRIMARY KEY (`id`)
);

CREATE  TABLE `video_locadora`.`states` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `country_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_states_country_id` (`country_id` ASC),
  CONSTRAINT `fk_states_country_id` FOREIGN KEY (`country_id`) REFERENCES `video_locadora`.`countries` (`id`)
);

CREATE  TABLE `video_locadora`.`cities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `zip` VARCHAR(10) NULL,
  `state_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_cities_state_id` (`state_id` ASC),
  CONSTRAINT `fk_cities_state_id` FOREIGN KEY (`state_id`) REFERENCES `video_locadora`.`states` (`id`)
);

CREATE  TABLE `video_locadora`.`districts` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `city_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_districts_city_id` (`city_id` ASC),
  CONSTRAINT `fk_districts_city_id` FOREIGN KEY (`city_id`) REFERENCES `video_locadora`.`cities` (`id`)
);

CREATE  TABLE `video_locadora`.`addresses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `location` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  `district_id` INT NULL,
  `person_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_addresses_district_id` (`district_id` ASC),
  INDEX `fk_addresses_person_id` (`person_id` ASC),
  CONSTRAINT `fk_addresses_district_id` FOREIGN KEY (`district_id`) REFERENCES `video_locadora`.`districts` (`id`),
  CONSTRAINT `fk_addresses_person_id` FOREIGN KEY (`person_id`) REFERENCES `video_locadora`.`people` (`id`)
);

CREATE  TABLE `video_locadora`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `person_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_person_id` (`person_id` ASC) ,
  CONSTRAINT `fk_users_person_id` FOREIGN KEY (`person_id`) REFERENCES `video_locadora`.`people` (`id`)
);


