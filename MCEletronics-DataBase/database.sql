--
-- PostgreSQL database dump
--

-- Dumped from database version 11.2
-- Dumped by pg_dump version 11.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: products; Type: TABLE; Schema: public; Owner: Cosmo
--

CREATE TABLE public.products (
    id bigint NOT NULL,
    name text,
    category text,
    price double precision,
    quantity integer,
    description text
);


ALTER TABLE public.products OWNER TO "Cosmo";

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: Cosmo
--

CREATE SEQUENCE public.products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.products_id_seq OWNER TO "Cosmo";

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Cosmo
--

ALTER SEQUENCE public.products_id_seq OWNED BY public.products.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: Cosmo
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    username text,
    password text
);


ALTER TABLE public.users OWNER TO "Cosmo";

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: Cosmo
--

CREATE SEQUENCE public.users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.users_id_seq OWNER TO "Cosmo";

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Cosmo
--

ALTER SEQUENCE public.users_id_seq OWNED BY public.users.id;


--
-- Name: products id; Type: DEFAULT; Schema: public; Owner: Cosmo
--

ALTER TABLE ONLY public.products ALTER COLUMN id SET DEFAULT nextval('public.products_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: Cosmo
--

ALTER TABLE ONLY public.users ALTER COLUMN id SET DEFAULT nextval('public.users_id_seq'::regclass);


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: Cosmo
--

COPY public.products (id, name, category, price, quantity, description) FROM stdin;



--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: Cosmo
--

COPY public.users (id, username, password) FROM stdin;



--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Cosmo
--

SELECT pg_catalog.setval('public.products_id_seq', 43, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Cosmo
--

SELECT pg_catalog.setval('public.users_id_seq', 12, true);


--
-- PostgreSQL database dump complete
--
