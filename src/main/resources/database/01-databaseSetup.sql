-- changeSet hh22:1
CREATE TABLE public.civic_projects
(
    id            bigint NOT NULL,
    city          character varying(255),
    description   character varying(255),
    justification character varying(255),
    title         character varying(255),
    estimate_id   bigint
);

ALTER TABLE public.civic_projects
    OWNER TO root;

ALTER TABLE public.civic_projects
    ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
        SEQUENCE NAME public.civic_projects_id_seq
        START WITH 1
        INCREMENT BY 1
        NO MINVALUE
        NO MAXVALUE
        CACHE 1
        );

CREATE TABLE public.civic_projects_schedule_of_activities
(
    civic_project_entity_id   bigint NOT NULL,
    schedule_of_activities_id bigint NOT NULL
);


ALTER TABLE public.civic_projects_schedule_of_activities
    OWNER TO root;

CREATE TABLE public.estimates
(
    id          bigint NOT NULL,
    cost        real,
    description character varying(255),
    title       character varying(255)
);


ALTER TABLE public.estimates
    OWNER TO root;

ALTER TABLE public.estimates
    ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
        SEQUENCE NAME public.estimates_id_seq
        START WITH 1
        INCREMENT BY 1
        NO MINVALUE
        NO MAXVALUE
        CACHE 1
        );

CREATE TABLE public.schedule_of_activities
(
    id          bigint NOT NULL,
    date        bytea,
    description character varying(255),
    title       character varying(255)
);

ALTER TABLE public.schedule_of_activities
    OWNER TO root;

ALTER TABLE public.schedule_of_activities
    ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
        SEQUENCE NAME public.schedule_of_activities_id_seq
        START WITH 1
        INCREMENT BY 1
        NO MINVALUE
        NO MAXVALUE
        CACHE 1
        );

CREATE TABLE public.users
(
    user_id      bigint NOT NULL,
    pesel        character varying(255),
    city         character varying(255),
    email        character varying(255),
    name         character varying(255),
    password     character varying(255),
    phone_number integer,
    role         integer,
    surname      character varying(255)
);


ALTER TABLE public.users
    OWNER TO root;

ALTER TABLE public.users
    ALTER COLUMN user_id ADD GENERATED BY DEFAULT AS IDENTITY (
        SEQUENCE NAME public.users_user_id_seq
        START WITH 1
        INCREMENT BY 1
        NO MINVALUE
        NO MAXVALUE
        CACHE 1
        );


ALTER TABLE ONLY public.civic_projects
    ADD CONSTRAINT civic_projects_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.estimates
    ADD CONSTRAINT estimates_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.schedule_of_activities
    ADD CONSTRAINT schedule_of_activities_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.civic_projects_schedule_of_activities
    ADD CONSTRAINT uk_fxe0j3p2jpgu04gkpfwsmunxo UNIQUE (schedule_of_activities_id);

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);

ALTER TABLE ONLY public.civic_projects_schedule_of_activities
    ADD CONSTRAINT fk7ok0pumfhl4fseybbu48dacc1 FOREIGN KEY (civic_project_entity_id) REFERENCES public.civic_projects (id);

ALTER TABLE ONLY public.civic_projects
    ADD CONSTRAINT fk8emeewhyay4rtkkk3ypg7pfx FOREIGN KEY (estimate_id) REFERENCES public.estimates (id);

ALTER TABLE ONLY public.civic_projects_schedule_of_activities
    ADD CONSTRAINT fkis9ur8w2h9h2k2pya6waieijd FOREIGN KEY (schedule_of_activities_id) REFERENCES public.schedule_of_activities (id);


-- changeSet hh22:2
insert into users (pesel, city, email, name, password, phone_number, role, surname) values (123456789, 'olsztyn', 'mati@mati.pl', 'mati', '$2a$10$JHH3aH2pyLeUT5e7XxzhSu1nQLNFZ2HDUt79GLG65p1l8NsQv.nMa', '123456789', '1', 'mati')
