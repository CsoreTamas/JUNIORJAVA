CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `mother_name` varchar(45) DEFAULT NULL,
  `father_name` varchar(45) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `gender` enum('FEMALE','MALE','OTHER') DEFAULT NULL,
  `highest_education` enum('ELEMENTARY_SCHOOL','HIGH_SCHOOL','VOCATIONAL_TRAINING','BSC_DEGREE','MSC_DEGREE','PHD') DEFAULT NULL,
  `number_of_children` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `person_chk_1` CHECK ((`number_of_children` >= 0))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

INSERT INTO people.person (first_name, last_name, mother_name, father_name, birth_date, gender, highest_education, number_of_children)
VALUES ('John', 'Perry', 'Gizella Janos', 'Peter Joska', '1977-10-20', 'MALE', 'HIGH_SCHOOL', 2),
('Katty', 'Doby', 'Sopiane Lakatos', 'Doby Deer', '1999-06-19', 'FEMALE', 'PHD', 0),
('László', 'Mátron', 'Szabó Erika', 'Márton István', '2002-11-30', 'MALE', 'ELEMENTARY_SCHOOL', 1),
('Tóth', 'Gergely', 'Horváth Juliska', 'Tóth Sándor', '2007-01-01', 'MALE', 'MSC_DEGREE', 3),
('János', 'Pál', 'Péter Bori', 'János Péter', '2009-09-22', 'OTHER', 'PHD', 0);

UPDATE person SET highest_education = 'MSC_DEGREE' WHERE first_name = 'John' AND last_name = 'Perry';
UPDATE person SET father_name = 'Dobbbby John Deer' WHERE id = 2;

--How many people there are by gender
SELECT COUNT(gender) FROM person;
--How many women named Jane were born before 1980-03-02
SELECT COUNT(*) AS Jane_counter FROM person WHERE last_name = 'Jane' AND gender = 'FEMALE' AND birth_date < 1980-03-02;
--How many women named Susan were born after 1995 and have at least an MSc degree
SELECT COUNT(*) AS Susan_counter FROM person WHERE gender = 'FEMALE' AND birth_date > 1995 AND highest_education = 'MSC_DEGREE' OR 'PHD';
--How many men or women born before 1960 have no children
SELECT COUNT(*) AS peoples_born_after_1960 FROM person WHERE birth_date < 1960 AND number_of_children = 0;
--How many men or people of other genders born before 1980-05-06 have a BSc degree and at least 5 children
SELECT COUNT(*) AS bsc_with_5plus_children FROM person WHERE birth_date < 1980-05-06 AND highest_education = 'BSC_DEGREE' AND number_of_children >= 5;