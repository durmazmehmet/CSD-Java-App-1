-- Table: public.products

-- DROP TABLE public.products;

CREATE TABLE public.products
(
    product_id serial NOT NULL,
    code character varying(20) COLLATE pg_catalog."default" NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    stock double precision NOT NULL,
    unit_price money not null,
    CONSTRAINT products_pkey PRIMARY KEY (product_id),
    CONSTRAINT code_unique UNIQUE (code),
    CONSTRAINT stock_neg_check CHECK (stock >= 0.0::double precision) NOT VALID,
    CONSTRAINT unit_price_neg_check CHECK (unit_price >= 0.0::money) NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.products
    OWNER to postgres;
    
    
-- Table: public.customers

-- DROP TABLE public.customers;

CREATE TABLE public.customers
(
    customer_id serial NOT NULL,
    title character varying(200) COLLATE pg_catalog."default" NOT NULL,
    address character varying(250) COLLATE pg_catalog."default" NOT NULL,
    email character varying(100) COLLATE pg_catalog."default" NOT NULL,
    phone character(14) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT customers_pkey PRIMARY KEY (customer_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.customers
    OWNER to postgres;
    
    
    
-- Table: public.orders

-- DROP TABLE public.orders;

CREATE TABLE public.orders
(
    order_id integer NOT NULL,
    customer_id integer NOT NULL,
    product_id integer NOT NULL,
    quantity double precision not null, 
    unit_price money not null,
    
    CONSTRAINT orders_pkey PRIMARY KEY (order_id),    
    CONSTRAINT orders_customer_id FOREIGN KEY (customer_id)
        REFERENCES public.customers (customer_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT orders_product_id FOREIGN KEY (product_id)
        REFERENCES public.products (product_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT quantity_neg_check CHECK (quantity >= 0.0::double precision) NOT VALID,   
    CONSTRAINT unit_price_neg_check CHECK (unit_price >= 0.0::money) NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.orders
    OWNER to postgres;


    
    
