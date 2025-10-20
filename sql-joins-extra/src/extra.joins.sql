--Show all countries with their capital city name and capital’s population.
1. SELECT co.name AS country, ci.name AS capital, ci.population AS capital_population FROM city ci JOIN country co ON co.capital = ci.id;
--List each continent together with the number of official languages spoken in its countries.
2. SELECT co.continent AS continent, COUNT(DISTINCT cl.language) AS official_language_num FROM country co JOIN CountryLanguage cl ON country.code = cl.CountryCode WHERE cl.isOfficial = 'T' GROUP BY co.continent;
--Display all cities and their country’s GNP (Gross National Product).
3. SELECT ci.name AS city, co.GNP FROM city ci JOIN country co ON city.CountryCode = country.code;
--Find all cities where the city’s population is greater than the average city population of that country.
4. SELECT ci.name FROM city ci WHERE ci.population > (SELECT AVG(ci2.population) FROM city ci2 WHERE ci2.CountryCode = ci.CountryCode);
--List all countries and their most spoken language (highest percentage).
5. SELECT c.name AS country, cl.language AS most_spoken_language FROM country c JOIN CountryLanguage cl ON c.code = cl.CountryCode WHERE cl.percentage = (SELECT MAX(cl.percentage) FROM CountryLanguage cl WHERE cl.CountryCode = c.code) ORDER BY c.name;
--Show all countries with their capital and the continent they belong to.
6. SELECT c.name AS country, ci.name AS capital, c.continent FROM city ci JOIN country c ON c.capital = ci.id;
--List all countries that have at least one city with over 5 million population.
7. SELECT DISTINCT co.name AS country FROM country co JOIN city ci ON co.code = ci.CountryCode WHERE ci.population > 5000000;
--Display all cities in Africa along with the country’s life expectancy.
8. SELECT ci.name AS city, co.LifeExpectancy AS life_expectancy FROM city ci JOIN country co ON ci.CountryCode = co.code WHERE co.continent = 'Africa';
--Show all countries with the number of languages spoken in each.
9. SELECT co.name AS country, COUNT(cl.language) AS num_of_spoken_language FROM country co JOIN CountryLanguage cl ON co.code = cl.CountryCode GROUP BY co.name;
--List each country’s capital city, and also include the continent and region.
10. SELECT ci.name AS capital, co.continent AS continent, co.region AS region FROM city ci JOIN country co ON ci.id = co.capital;
--Display the 10 largest cities (by population) together with their country name and continent.
11. SELECT ci.name AS city, co.name AS country, co.continent AS continent FROM city ci JOIN country co ON ci.CountryCode = co.code ORDER BY ci.population DESC LIMIT 10;
--Show all countries and the number of cities in each region.
12. SELECT co.region AS region, co.name AS country, COUNT(ci.id) AS num_of_cities FROM city ci JOIN country co ON co.code = ci.CountryCode GROUP BY co.region, co.name;
--Display all countries with their capital city, but only for countries where Spanish is an official language.
13. SELECT co.name AS country, ci.name AS capital FROM country co JOIN city ci ON co.capital = ci.id JOIN CountryLanguage cl ON co.code = cl.CountryCode WHERE cl.isOfficial = 'T' AND cl.language = 'Spanish';
--List all official languages together with the total population of the countries where they are official.
14. SELECT cl.language AS language, SUM(co.population) AS total_population FROM country co JOIN CountryLanguage cl ON cl.CountryCode = co.code WHERE cl.isOfficial = 'T' GROUP BY cl.language;
--Show all Asian countries and all their cities ordered by city population descending.
15. SELECT co.name AS country, ci.name AS city FROM country co JOIN city ci ON ci.CountryCode = co.code WHERE co.continent = 'Asia' ORDER BY ci.population DESC;
--Display the country name, its capital, and the capital’s district.
16. SELECT  co.name AS country, ci.name AS capital, ci.district AS capital_district FROM country co JOIN city ci ON co.capital = ci.id;
--List each region and the total population of all its cities combined.
17. SELECT co.region AS region, SUM(ci.population) AS total_city_population FROM city ci JOIN country co ON co.code = ci.CountryCode GROUP BY co.region;
--Show each continent and the name of its most populated capital city.
18. SELECT co.continent, ci.name AS capital, ci.population FROM country co JOIN city ci ON co.capital = ci.id WHERE ci.population = (SELECT MAX(ci2.population) FROM country co2 JOIN city ci2 ON co2.capital = ci2.id WHERE co2.continent = co.continent);
--Display each country’s name, the name of its capital city, and the number of languages spoken there.
19. SELECT co.name AS country, ci.name AS capital, COUNT(cl.language) AS num_of_languages FROM country co JOIN city ci ON co.capital = ci.id JOIN CountryLanguage cl ON co.code = cl.CountryCode GROUP BY co.name, ci.name;
--Show all countries that share the same official language as France.
20. SELECT DISTINCT co.name AS country FROM country co JOIN CountryLanguage cl ON co.code = cl.CountryCode WHERE cl.isOfficial = 'T' AND cl.language IN(SELECT cl2.language FROM CountryLanguage cl2 JOIN country co2 ON cl2.CountryCode = co2.code WHERE co2.name = 'France' AND cl2.isOfficial = 'T') ORDER BY co.name;