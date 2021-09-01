-- Table: public.devices

-- DROP TABLE public.devices;

CREATE TABLE public.devices
(
    device_id serial not null,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    ip_address character(15) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT devices_pkey PRIMARY KEY (device_id),
    CONSTRAINT name_unique UNIQUE (name)

)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.devices
    OWNER to postgres;
	
	
	-- Table: public.ports

-- DROP TABLE public.ports;

CREATE TABLE public.ports
(
    port_id serial NOT NULL,
    device_id integer NOT NULL,
    num integer NOT NULL,
    CONSTRAINT ports_pkey PRIMARY KEY (port_id),
    CONSTRAINT device_id_foreign FOREIGN KEY (device_id)
        REFERENCES public.devices (device_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT num_check CHECK (num >= 0) NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.ports
    OWNER to postgres;