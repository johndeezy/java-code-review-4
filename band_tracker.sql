--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: bands; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE bands (
    id integer NOT NULL,
    bandname character varying,
    genre character varying
);


ALTER TABLE bands OWNER TO postgres;

--
-- Name: bands_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE bands_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bands_id_seq OWNER TO postgres;

--
-- Name: bands_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE bands_id_seq OWNED BY bands.id;


--
-- Name: bands_venues; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE bands_venues (
    id integer NOT NULL,
    band_id integer,
    venue_id integer
);


ALTER TABLE bands_venues OWNER TO postgres;

--
-- Name: bands_venues_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE bands_venues_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE bands_venues_id_seq OWNER TO postgres;

--
-- Name: bands_venues_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE bands_venues_id_seq OWNED BY bands_venues.id;


--
-- Name: venues; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE venues (
    id integer NOT NULL,
    venuename character varying,
    venuecity character varying,
    venuestate character varying,
    venuecapacity integer
);


ALTER TABLE venues OWNER TO postgres;

--
-- Name: venues_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE venues_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE venues_id_seq OWNER TO postgres;

--
-- Name: venues_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE venues_id_seq OWNED BY venues.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bands ALTER COLUMN id SET DEFAULT nextval('bands_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bands_venues ALTER COLUMN id SET DEFAULT nextval('bands_venues_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venues ALTER COLUMN id SET DEFAULT nextval('venues_id_seq'::regclass);


--
-- Data for Name: bands; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bands (id, bandname, genre) FROM stdin;
\.


--
-- Name: bands_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('bands_id_seq', 1, false);


--
-- Data for Name: bands_venues; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY bands_venues (id, band_id, venue_id) FROM stdin;
\.


--
-- Name: bands_venues_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('bands_venues_id_seq', 1, false);


--
-- Data for Name: venues; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY venues (id, venuename, venuecity, venuestate, venuecapacity) FROM stdin;
1	Coliseum	Rome	Italy	10000
\.


--
-- Name: venues_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('venues_id_seq', 1, true);


--
-- Name: bands_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bands
    ADD CONSTRAINT bands_pkey PRIMARY KEY (id);


--
-- Name: bands_venues_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bands_venues
    ADD CONSTRAINT bands_venues_pkey PRIMARY KEY (id);


--
-- Name: venues_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY venues
    ADD CONSTRAINT venues_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

