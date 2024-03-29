CREATE TABLE IF NOT EXISTS public.job_provider
(
    id          BIGINT PRIMARY KEY REFERENCES app_user (id) ON DELETE CASCADE,
    location_id BIGINT
);
