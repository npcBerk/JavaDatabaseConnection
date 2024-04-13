
-- serie Tablosu
CREATE TABLE serie (
    serie_id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    poster VARCHAR(255),
    production_year INT,
    age_category VARCHAR(10),
    season_number INT,
    adding_date DATE
);

-- genre Tablosu
CREATE TABLE genre (
    genre_id SERIAL PRIMARY KEY,
    genre_name VARCHAR(50)
);

-- actor Tablosu
CREATE TABLE actor (
    actor_id SERIAL PRIMARY KEY,
    actor_name VARCHAR(50),
    actor_lastname VARCHAR(50),
    gender VARCHAR(10),
    birthdate DATE
);

-- credit_card Tablosu
CREATE TABLE credit_card (
    credit_card_id SERIAL PRIMARY KEY,
    card_number VARCHAR(16),
    cvc INT,
    expiration_date DATE,
    owner_name VARCHAR(50),
    owner_lastname VARCHAR(50)
);

-- payment_method Tablosu
CREATE TABLE payment_method (
    payment_method_id SERIAL PRIMARY KEY,
    credit_card_id INT REFERENCES credit_card(credit_card_id),
    gift_card_id INT
);

-- user Tablosu   (Create edildikten sonra tablo adı user olarak değiştirilmiştir. Kullanılırken reserved word olmasından ötürü public.user olarak kullanılması gerekmektedir.)
CREATE TABLE public.user (
    user_id SERIAL PRIMARY KEY,
    nick_name VARCHAR(50),
    is_adult BOOLEAN,
    password VARCHAR(255),
    age INT,
    country_id INT,
    phone_number VARCHAR(20)
);

-- user_payment_method Tablosu
CREATE TABLE user_payment_method (
    user_id INT REFERENCES public.user(user_id),
    payment_method_id INT REFERENCES payment_method(payment_method_id),
    user_payment_method_id SERIAL PRIMARY KEY
);

-- payment_plans Tablosu
CREATE TABLE payment_plans (
    payment_plans_id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    price DECIMAL(10, 2)
);

-- payment Tablosu
CREATE TABLE payment (
    payment_id SERIAL PRIMARY KEY,
    payment_date DATE,
    payment_method_id INT REFERENCES payment_method(payment_method_id),
    payment_plans_id INT REFERENCES payment_plans(payment_plans_id)
);

-- movie Tablosu
CREATE TABLE movie (
    movie_id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    poster VARCHAR(255),
    production_year INT,
    age_category VARCHAR(10),
    adding_date DATE,
    how_long INT,
    about TEXT
);

-- episode Tablosu
CREATE TABLE episode (
    episode_id SERIAL PRIMARY KEY,
    episode_title VARCHAR(100),
    season INT,
    about TEXT,
    serie_id INT REFERENCES serie(serie_id),
    how_long INT,
    number_of_episode INT
);

-- movies_actors Tablosu
CREATE TABLE movies_actors (
    movie_id INT REFERENCES movie(movie_id),
    actor_id INT REFERENCES actor(actor_id)
);

-- series_actors Tablosu
CREATE TABLE series_actors (
    serie_id INT REFERENCES serie(serie_id),
    actor_id INT REFERENCES actor(actor_id)
);

-- serie_genre Tablosu
CREATE TABLE serie_genre (
    serie_id INT REFERENCES serie(serie_id),
    genre_id INT REFERENCES genre(genre_id),
    serie_genre_id SERIAL PRIMARY KEY
);

-- movie_genre Tablosu
CREATE TABLE movie_genre (
    genre_id INT REFERENCES genre(genre_id),
    movie_id INT REFERENCES movie(movie_id),
    movie_genre_id SERIAL PRIMARY KEY
);

-- watched_content Tablosu
CREATE TABLE watched_content (
    movie_id INT REFERENCES movie(movie_id),
    user_id INT REFERENCES public.user(user_id),
    serie_id INT REFERENCES serie(serie_id)
	);
