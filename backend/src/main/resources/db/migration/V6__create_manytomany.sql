CREATE TABLE IF NOT EXISTS public.job_category
(
    job_id      BIGINT REFERENCES public.job (job_id) ON DELETE CASCADE,
    category_id BIGINT REFERENCES public.category (category_id) ON DELETE CASCADE,
    PRIMARY KEY (job_id, category_id)
);
