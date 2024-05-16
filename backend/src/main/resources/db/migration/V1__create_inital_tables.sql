CREATE TABLE IF NOT EXISTS public.app_user
(
    id           BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    phone_number VARCHAR(255),
    username     VARCHAR(255) NOT NULL,
    first_name     VARCHAR(255) NOT NULL,
    last_name     VARCHAR(255) NOT NULL,
    email        VARCHAR(255) NOT NULL,
    password     VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.category
(
    category_id   BIGINT PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL
);
