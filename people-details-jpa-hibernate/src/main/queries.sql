--Let's populate the table with different records using the INSERT INTO command!
INSERT INTO people.person (first_name, last_name, mother_name, father_name, birth_date, gender, highest_education, number_of_children)
VALUES ('Anna', 'Kovács', 'Kovács Rozi', 'Kovács Pál', '1980-11-21', 'FEMALE', 'HIGH_SCHOOL', 0),
('Bence', 'Nagy', 'Nagy Péterné', 'Nagy Péter', '1949-06-19', 'MALE', 'PHD', 3),
('Soos', 'Marci', 'Soosné Erika', 'Soos Józsi', '2001-06-13', 'MALE', 'VOCATIONAL_TRAINING', 2),
('Peter', 'Peter', 'Gizella Márton', 'Tóth Sándor', '2001-12-14', 'MALE', 'ELEMENTARY_SCHOOL', 4),
('Kovacsics', 'Kovács', 'Kovácsné Petra', 'Kovács Tamás', '2013-03-20', 'OTHER', 'PHD', 0);

--Overwrite some of the records!
UPDATE person SET first_name = "Kovacs" AND father_name = "Kovacs" WHERE id = 0;
UPDATE person SET number_of_children = 12 WHERE id = 5;

--How many people there are by gender
SELECT COUNT(gender) FROM person;
--How many women named Jane were born before 1980-03-02
SELECT COUNT(*) AS Jane_counter FROM person WHERE last_name = 'Jane' AND gender = 'FEMALE' AND birth_date < 1980-03-02;
--How many women named Susan were born after 1995 and have at least an MSc degree
SELECT COUNT(*) AS Susan_counter FROM person WHERE gender = 'FEMALE' AND birth_date > 1995 AND highest_education = 'MSC_DEGREE' OR 'PHD';
--How many men or women born before 1960 have no children
SELECT COUNT(*) AS people_born_after_1960 FROM person WHERE birth_date < 1960 AND number_of_children = 0;
--How many men or people of other genders born before 1980-05-06 have a BSc degree and at least 5 children
SELECT COUNT(*) AS bsc_with_5plus_children FROM person WHERE birth_date < 1980-05-06 AND highest_education = 'BSC_DEGREE' AND number_of_children >= 5;