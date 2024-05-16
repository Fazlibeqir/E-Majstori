CREATE TABLE IF NOT EXISTS public.job_provider
(
    id          BIGINT PRIMARY KEY NOT NULL,
    name        VARCHAR(255) NOT NULL,
    image        VARCHAR(255),
    phone_number        VARCHAR(255),
    description VARCHAR(255),
    location_id BIGINT
);
