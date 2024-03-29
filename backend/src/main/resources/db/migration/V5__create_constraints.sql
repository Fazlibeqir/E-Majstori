ALTER TABLE public.job_provider
    ADD CONSTRAINT fk_job_provider_location_id FOREIGN KEY (location_id)
        REFERENCES public.location (id) ON DELETE CASCADE,
    ALTER COLUMN location_id SET NOT NULL;

ALTER TABLE public.job
    ADD CONSTRAINT fk_job_provider_id FOREIGN KEY (job_provider_id)
        REFERENCES public.job_provider (id) ON DELETE CASCADE,
    ALTER COLUMN job_provider_id SET NOT NULL;