INSERT INTO serie (title, poster, production_year, age_category, season_number, adding_date)
VALUES ('Stranger Things', 'stranger_things_poster.jpg', 2016, '13+', 3, '2023-01-15'),
       ('Breaking Bad', 'breaking_bad_poster.jpg', 2008, '18+', 5, '2023-01-16'),
       ('Game of Thrones', 'game_of_thrones_poster.jpg', 2011, '18+', 8, '2023-01-17'),
       ('The Mandalorian', 'mandalorian_poster.jpg', 2019, '7+', 2, '2023-01-18'),
       ('The Witcher', 'witcher_poster.jpg', 2019, '18+', 2, '2023-01-19'),
       ('Friends', 'friends_poster.jpg', 1994, '13+', 10, '2023-01-20'),
       ('Money Heist', 'money_heist_poster.jpg', 2017, '18+', 5, '2023-01-21'),
       ('Black Mirror', 'black_mirror_poster.jpg', 2011, '18+', 5, '2023-01-22'),
       ('The Office', 'office_poster.jpg', 2005, '13+', 9, '2023-01-23'),
       ('Narcos', 'narcos_poster.jpg', 2015, '18+', 3, '2023-01-24');
	   
	   
INSERT INTO episode (episode_title, season, about, serie_id, how_long, number_of_episode)
VALUES ('Chapter 1: The Vanishing of Will Byers', 1, 'Strange things are happening in Hawkins', 1, 50, 8),
       ('Pilot', 1, 'Walter White, a high school chemistry teacher, turns to a life of crime', 2, 45, 7),
       ('Winter Is Coming', 1, 'The Seven Kingdoms of Westeros are preparing for the winter ahead', 3, 55, 10),
       ('Chapter 1: The Mandalorian', 1, 'A lone bounty hunter navigates the outer reaches of the galaxy', 4, 40, 8),
       ('The End"s Beginning', 1, 'Geralt of Rivia, a monster hunter, seeks his destiny', 5, 50, 8),
       ('The One Where Monica Gets a Roommate', 1, 'Monica introduces her friends to her new roommate', 6, 25, 1),
       ('Episode 1: Do as Planned', 1, 'The Royal Mint of Spain is invaded', 7, 45, 13),
       ('The National Anthem', 1, 'A prime minister faces a shocking dilemma', 8, 60, 1),
       ('Pilot', 1, 'A mockumentary about office life in a mundane office', 9, 30, 1),
       ('Descenso', 1, 'DEA agent Steve Murphy joins the war on drugs in Colombia', 10, 55, 10);


INSERT INTO genre (genre_id, genre_name)
VALUES (1, 'Action'),
       (2, 'Comedy'),
       (3, 'Drama'),
       (4, 'Science Fiction'),
       (5, 'Horror'),
       (6, 'Romance'),
       (7, 'Thriller'),
       (8, 'Fantasy'),
       (9, 'Mystery'),
       (10, 'Documentary');


INSERT INTO actor (actor_id, actor_name, actor_lastname, gender, birthdate)
VALUES (1, 'Tom', 'Hanks', 'Male', '1956-07-09'),
       (2, 'Meryl', 'Streep', 'Female', '1949-06-22'),
       (3, 'Brad', 'Pitt', 'Male', '1963-12-18'),
       (4, 'Julia', 'Roberts', 'Female', '1967-10-28'),
       (5, 'Leonardo', 'DiCaprio', 'Male', '1974-11-11'),
       (6, 'Cate', 'Blanchett', 'Female', '1969-05-14'),
       (7, 'Johnny', 'Depp', 'Male', '1963-06-09'),
       (8, 'Angelina', 'Jolie', 'Female', '1975-06-04'),
       (9, 'Denzel', 'Washington', 'Male', '1954-12-28'),
       (10, 'Natalie', 'Portman', 'Female', '1981-06-09');


INSERT INTO credit_card (credit_card_id, card_number, cvc, expiration_date, owner_name, owner_lastname)
VALUES (1, '1111222233334444', 123, '2025-12-01', 'John', 'Doe'),
       (2, '5555666677778888', 456, '2026-05-01', 'Jane', 'Smith'),
       (3, '9999000011112222', 789, '2024-09-01', 'Bob', 'Johnson'),
       (4, '4444333322221111', 234, '2023-03-01', 'Alice', 'Williams'),
       (5, '6666777788889999', 567, '2027-11-01', 'Charlie', 'Taylor'),
       (6, '1212121212121212', 890, '2025-07-01', 'Emma', 'Martin'),
       (7, '9898989898989898', 123, '2023-12-01', 'Daniel', 'Clark'),
       (8, '7777666655554444', 456, '2024-06-01', 'Olivia', 'Baker'),
       (9, '3333222211110000', 789, '2026-02-01', 'William', 'Anderson'),
       (10, '5555111122223333', 234, '2027-08-01', 'Sophia', 'White');


INSERT INTO payment_method (payment_method_id, credit_card_id, gift_card_id)
VALUES (1, 1, 123),
       (2, 2, 456),
       (3, 3, 789),
       (4, 4, NULL),
       (5, 5, NULL),
       (6, 6, 987),
       (7, 7, 654),
       (8, 8, 321),
       (9, 9, NULL),
       (10, 10, NULL);


INSERT INTO public.user (user_id, nick_name, is_adult, password, age, country_id, phone_number)
VALUES (1, 'john_doe', true, 'password123', 30, 1, '+1234567890'),
       (2, 'jane_smith', false, 'pass456', 25, 2, '+9876543210'),
       (3, 'bob_johnson', true, 'securePass', 40, 3, '+1122334455'),
       (4, 'alice_williams', false, 'myPassword', 28, 4, '+9988776655'),
       (5, 'charlie_taylor', true, 'charliePass', 35, 5, '+6677889900'),
       (6, 'emma_martin', false, 'emmaPass', 22, 1, '+1122334455'),
       (7, 'daniel_clark', true, 'danielPass', 33, 2, '+9988776655'),
       (8, 'olivia_baker', false, 'oliviaPass', 27, 3, '+6677889900'),
       (9, 'william_anderson', true, 'williamPass', 32, 4, '+1122334455'),
       (10, 'sophia_white', false, 'sophiaPass', 29, 5, '+9988776655');


INSERT INTO user_payment_method (user_id, payment_method_id, user_payment_method_id)
VALUES (1, 1, 101),
       (2, 2, 102),
       (3, 3, 103),
       (4, 4, 104),
       (5, 5, 105),
       (6, 6, 106),
       (7, 7, 107),
       (8, 8, 108),
       (9, 9, 109),
       (10, 10, 110);


INSERT INTO payment_plans (payment_plans_id, name, price)
VALUES (1, 'Basic Plan', 9.99),
       (2, 'Standard Plan', 14.99),
       (3, 'Premium Plan', 19.99),
       (4, 'Family Plan', 24.99),
       (5, 'Business Plan', 29.99),
       (6, 'Silver Plan', 12.99),
       (7, 'Gold Plan', 17.99),
       (8, 'Platinum Plan', 22.99),
       (9, 'VIP Plan', 27.99),
       (10, 'Custom Plan', 34.99);


INSERT INTO payment (payment_id, payment_date, payment_method_id, payment_plans_id)
VALUES (1, '2024-01-01', 1, 3),
       (2, '2024-02-02', 2, 5),
       (3, '2024-03-03', 3, 2),
       (4, '2024-04-04', 4, 7),
       (5, '2024-05-05', 5, 1),
       (6, '2024-06-06', 6, 4),
       (7, '2024-07-07', 7, 9),
       (8, '2024-08-08', 8, 6),
       (9, '2024-09-09', 9, 10),
       (10, '2024-10-10', 10, 8);


INSERT INTO movie (movie_id, title, poster, production_year, age_category, adding_date, how_long, about)
VALUES (1, 'The Matrix', 'matrix_poster.jpg', 1999, 'PG-13', '2023-01-01', 136, 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.'),
       (2, 'Inception', 'inception_poster.jpg', 2010, 'PG-13', '2023-02-02', 148, 'A thief who enters the dreams of others to steal their secrets.'),
       (3, 'The Shawshank Redemption', 'shawshank_poster.jpg', 1994, 'R', '2023-03-03', 142, 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.'),
       (4, 'Pulp Fiction', 'pulpfiction_poster.jpg', 1994, 'R', '2023-04-04', 154, 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.'),
       (5, 'The Dark Knight', 'darkknight_poster.jpg', 2008, 'PG-13', '2023-05-05', 152, 'When the menace known as The Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.'),
       (6, 'Fight Club', 'fightclub_poster.jpg', 1999, 'R', '2023-06-06', 139, 'An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.'),
       (7, 'Forrest Gump', 'forrestgump_poster.jpg', 1994, 'PG-13', '2023-07-07', 142, 'The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other historical events unfold through the perspective of an Alabama man with an IQ of 75.'),
       (8, 'The Godfather', 'godfather_poster.jpg', 1972, 'R', '2023-08-08', 175, 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.'),
       (9, 'Schindler"s List', 'schindlerslist_poster.jpg', 1993, 'R', '2023-09-09', 195, 'In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.'),
       (10, 'The Lord of the Rings: The Fellowship of the Ring', 'lotr_poster.jpg', 2001, 'PG-13', '2023-10-10', 178, 'A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.');


INSERT INTO movies_actors (movie_id, actor_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8),
       (5, 9),
       (5, 10);


INSERT INTO series_actors (serie_id, actor_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8),
       (5, 9),
       (5, 10);


INSERT INTO movie_genre (movie_genre_id, movie_id, genre_id)
VALUES
    (1, (SELECT movie_id FROM movie WHERE title = 'The Matrix'), (SELECT genre_id FROM genre WHERE genre_name = 'Action')),
    (2, (SELECT movie_id FROM movie WHERE title = 'Inception'), (SELECT genre_id FROM genre WHERE genre_name = 'Sci-Fi')),
    (3, (SELECT movie_id FROM movie WHERE title = 'The Shawshank Redemption'), (SELECT genre_id FROM genre WHERE genre_name = 'Drama')),
    (4, (SELECT movie_id FROM movie WHERE title = 'Pulp Fiction'), (SELECT genre_id FROM genre WHERE genre_name = 'Crime')),
    (5, (SELECT movie_id FROM movie WHERE title = 'The Dark Knight'), (SELECT genre_id FROM genre WHERE genre_name = 'Action')),
    (6, (SELECT movie_id FROM movie WHERE title = 'Forrest Gump'), (SELECT genre_id FROM genre WHERE genre_name = 'Romance')),
    (7, (SELECT movie_id FROM movie WHERE title = 'The Godfather'), (SELECT genre_id FROM genre WHERE genre_name = 'Crime')),
    (8, (SELECT movie_id FROM movie WHERE title = 'The Lord of the Rings: The Return of the King'), (SELECT genre_id FROM genre WHERE genre_name = 'Fantasy')),
    (9, (SELECT movie_id FROM movie WHERE title = 'Inception'), (SELECT genre_id FROM genre WHERE genre_name = 'Mystery')),
    (10, (SELECT movie_id FROM movie WHERE title = 'The Dark Knight'), (SELECT genre_id FROM genre WHERE genre_name = 'Thriller'));


INSERT INTO serie_genre (serie_genre_id, serie_id, genre_id)
VALUES
    (1, (SELECT serie_id FROM serie WHERE title = 'Stranger Things'), (SELECT genre_id FROM genre WHERE genre_name = 'Sci-Fi')),
    (2, (SELECT serie_id FROM serie WHERE title = 'Breaking Bad'), (SELECT genre_id FROM genre WHERE genre_name = 'Drama')),
    (3, (SELECT serie_id FROM serie WHERE title = 'The Witcher'), (SELECT genre_id FROM genre WHERE genre_name = 'Fantasy')),
    (4, (SELECT serie_id FROM serie WHERE title = 'Friends'), (SELECT genre_id FROM genre WHERE genre_name = 'Comedy')),
    (5, (SELECT serie_id FROM serie WHERE title = 'Money Heist'), (SELECT genre_id FROM genre WHERE genre_name = 'Crime')),
    (6, (SELECT serie_id FROM serie WHERE title = 'The Mandalorian'), (SELECT genre_id FROM genre WHERE genre_name = 'Action')),
    (7, (SELECT serie_id FROM serie WHERE title = 'Black Mirror'), (SELECT genre_id FROM genre WHERE genre_name = 'Drama')),
    (8, (SELECT serie_id FROM serie WHERE title = 'The Office'), (SELECT genre_id FROM genre WHERE genre_name = 'Comedy')),
    (9, (SELECT serie_id FROM serie WHERE title = 'Narcos'), (SELECT genre_id FROM genre WHERE genre_name = 'Crime')),
    (10, (SELECT serie_id FROM serie WHERE title = 'Game of Thrones'), (SELECT genre_id FROM genre WHERE genre_name = 'Fantasy'));


INSERT INTO watched_content (user_id, movie_id, serie_id)
VALUES (1, 1, null),
       (1, 2, null),
       (1, null, 3),
       (2, 2, null),
       (2, null, 7),
       (3, null, 7),
       (4, 3, null),
       (4, 5, null),
       (4, null, 4),
       (4, null, 8);