-- Table: public.students

-- DROP TABLE public.students;

CREATE TABLE public.students
(
    student_id serial NOT NULL,
    first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    second_name character varying(100) COLLATE pg_catalog."default",
    surname character varying(100) COLLATE pg_catalog."default" NOT NULL,
    citizen_id character(11) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT students_pkey PRIMARY KEY (student_id),
    CONSTRAINT citizen_id CHECK (length(citizen_id) = 11) NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.students
    OWNER to postgres;	
	
	
-- Table: public.lectures

-- DROP TABLE public.lectures;

CREATE TABLE public.lectures
(
    lecture_id serial NOT NULL,
    code character(7) COLLATE pg_catalog."default" NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    credits integer NOT NULL,
    ects_credits integer,
    CONSTRAINT lectures_pkey PRIMARY KEY (lecture_id),
    CONSTRAINT code_unique UNIQUE (code)
,
    CONSTRAINT code_check CHECK (length(code) = 7) NOT VALID
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.lectures
    OWNER to postgres;
	
	
	
	
-- Table: public.grades

-- DROP TABLE public.grades;

CREATE TABLE public.grades
(
    grade_id serial NOT NULL,
    "desc" character(2) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT grades_pkey PRIMARY KEY (grade_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.grades
    OWNER to postgres;
	
	
-- Table: public.enrolls

-- DROP TABLE public.enrolls;

CREATE TABLE public.enrolls
(
    enroll_id serial NOT NULL,
    student_id integer NOT NULL,
    lecture_id integer NOT NULL,
    grade_id integer NOT NULL,
    CONSTRAINT enrolls_pkey PRIMARY KEY (enroll_id),
    CONSTRAINT grade_id_foreign_key FOREIGN KEY (grade_id)
        REFERENCES public.grades (grade_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT lecture_id_foreign_key FOREIGN KEY (lecture_id)
        REFERENCES public.lectures (lecture_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT student_id_foreign_key FOREIGN KEY (student_id)
        REFERENCES public.students (student_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.enrolls
    OWNER to postgres;