CREATE TABLE IF NOT EXISTS public.job_provider
(
    id          BIGINT PRIMARY KEY NOT NULL,
    name        VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    location_id BIGINT
);
