--
-- PostgreSQL database dump
--

-- Dumped from database version 10.6
-- Dumped by pg_dump version 10.3

-- Started on 2019-09-14 21:42:46 -05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 13241)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 3426 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 18288)
-- Name: canalizacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.canalizacion (
    canalizacion_id integer NOT NULL,
    tipo_zona_id integer NOT NULL,
    lampara_id integer NOT NULL,
    id_estado integer NOT NULL,
    tipo_soporte_id integer NOT NULL,
    caja_inspeccion text,
    ducteria text
);


ALTER TABLE public.canalizacion OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 18286)
-- Name: canalizacion_canalizacion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.canalizacion_canalizacion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.canalizacion_canalizacion_id_seq OWNER TO postgres;

--
-- TOC entry 3427 (class 0 OID 0)
-- Dependencies: 196
-- Name: canalizacion_canalizacion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.canalizacion_canalizacion_id_seq OWNED BY public.canalizacion.canalizacion_id;


--
-- TOC entry 199 (class 1259 OID 18304)
-- Name: estado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.estado (
    id_estado integer NOT NULL,
    estado text
);


ALTER TABLE public.estado OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 18302)
-- Name: estado_id_estado_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.estado_id_estado_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.estado_id_estado_seq OWNER TO postgres;

--
-- TOC entry 3428 (class 0 OID 0)
-- Dependencies: 198
-- Name: estado_id_estado_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.estado_id_estado_seq OWNED BY public.estado.id_estado;


--
-- TOC entry 201 (class 1259 OID 18316)
-- Name: lampara; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lampara (
    lampara_id integer NOT NULL,
    tipo_lampara_id integer NOT NULL,
    transformador_id integer NOT NULL,
    tipo_balasto_id integer NOT NULL,
    tipo_espacio_iluminado_id integer NOT NULL,
    soporte_lampara_id integer NOT NULL,
    red_alimentacion_id integer NOT NULL,
    id_estado integer NOT NULL,
    potencia integer,
    nivel_tension integer,
    funcionamiento text,
    control_encendido text,
    valor_perdidas numeric,
    url_imagen text,
    latitud_lampara numeric(30,6),
    longitud_lampara numeric(30,6)
);


ALTER TABLE public.lampara OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 18314)
-- Name: lampara_lampara_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lampara_lampara_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lampara_lampara_id_seq OWNER TO postgres;

--
-- TOC entry 3429 (class 0 OID 0)
-- Dependencies: 200
-- Name: lampara_lampara_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lampara_lampara_id_seq OWNED BY public.lampara.lampara_id;


--
-- TOC entry 203 (class 1259 OID 18335)
-- Name: lampara_registrada; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.lampara_registrada (
    lampara_registrada_id integer NOT NULL,
    usuario_id text NOT NULL,
    lampara_id integer NOT NULL,
    latitud_pos_actual_tecnico numeric(30,6),
    longitud_pos_actual_tecnico numeric(30,6),
    fecha_hora date
);


ALTER TABLE public.lampara_registrada OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 18333)
-- Name: lampara_registrada_lampara_registrada_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.lampara_registrada_lampara_registrada_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.lampara_registrada_lampara_registrada_id_seq OWNER TO postgres;

--
-- TOC entry 3430 (class 0 OID 0)
-- Dependencies: 202
-- Name: lampara_registrada_lampara_registrada_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.lampara_registrada_lampara_registrada_id_seq OWNED BY public.lampara_registrada.lampara_registrada_id;


--
-- TOC entry 205 (class 1259 OID 18349)
-- Name: red_alimentacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.red_alimentacion (
    red_alimentacion_id integer NOT NULL,
    tipo_instalacion_id integer NOT NULL,
    tipo_material_id integer NOT NULL,
    tipo_soporte_id integer NOT NULL,
    id_estado integer NOT NULL,
    calibre_conductor_awg text
);


ALTER TABLE public.red_alimentacion OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 18347)
-- Name: red_alimentacion_red_alimentacion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.red_alimentacion_red_alimentacion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.red_alimentacion_red_alimentacion_id_seq OWNER TO postgres;

--
-- TOC entry 3431 (class 0 OID 0)
-- Dependencies: 204
-- Name: red_alimentacion_red_alimentacion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.red_alimentacion_red_alimentacion_id_seq OWNED BY public.red_alimentacion.red_alimentacion_id;


--
-- TOC entry 207 (class 1259 OID 18365)
-- Name: soporte_lampara; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.soporte_lampara (
    soporte_lampara_id integer NOT NULL,
    tipo_material_id integer NOT NULL,
    tipo_soporte_id integer NOT NULL,
    id_estado integer NOT NULL,
    longitud integer
);


ALTER TABLE public.soporte_lampara OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 18363)
-- Name: soporte_lampara_soporte_lampara_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.soporte_lampara_soporte_lampara_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.soporte_lampara_soporte_lampara_id_seq OWNER TO postgres;

--
-- TOC entry 3432 (class 0 OID 0)
-- Dependencies: 206
-- Name: soporte_lampara_soporte_lampara_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.soporte_lampara_soporte_lampara_id_seq OWNED BY public.soporte_lampara.soporte_lampara_id;


--
-- TOC entry 209 (class 1259 OID 18377)
-- Name: tercero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tercero (
    tercero_id integer NOT NULL,
    tipo_documento_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tercero text,
    numero_documento numeric,
    direccion text,
    email text,
    telefono numeric
);


ALTER TABLE public.tercero OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 18375)
-- Name: tercero_tercero_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tercero_tercero_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tercero_tercero_id_seq OWNER TO postgres;

--
-- TOC entry 3433 (class 0 OID 0)
-- Dependencies: 208
-- Name: tercero_tercero_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tercero_tercero_id_seq OWNED BY public.tercero.tercero_id;


--
-- TOC entry 211 (class 1259 OID 18391)
-- Name: tipo_balasto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_balasto (
    tipo_balasto_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_balasto text
);


ALTER TABLE public.tipo_balasto OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 18389)
-- Name: tipo_balasto_tipo_balasto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_balasto_tipo_balasto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_balasto_tipo_balasto_id_seq OWNER TO postgres;

--
-- TOC entry 3434 (class 0 OID 0)
-- Dependencies: 210
-- Name: tipo_balasto_tipo_balasto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_balasto_tipo_balasto_id_seq OWNED BY public.tipo_balasto.tipo_balasto_id;


--
-- TOC entry 213 (class 1259 OID 18404)
-- Name: tipo_documento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_documento (
    tipo_documento_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_documento text
);


ALTER TABLE public.tipo_documento OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 18402)
-- Name: tipo_documento_tipo_documento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_documento_tipo_documento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_documento_tipo_documento_id_seq OWNER TO postgres;

--
-- TOC entry 3435 (class 0 OID 0)
-- Dependencies: 212
-- Name: tipo_documento_tipo_documento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_documento_tipo_documento_id_seq OWNED BY public.tipo_documento.tipo_documento_id;


--
-- TOC entry 215 (class 1259 OID 18417)
-- Name: tipo_espacio_iluminado; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_espacio_iluminado (
    tipo_espacio_iluminado_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_espacio_iluminado text
);


ALTER TABLE public.tipo_espacio_iluminado OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 18415)
-- Name: tipo_espacio_iluminado_tipo_espacio_iluminado_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_espacio_iluminado_tipo_espacio_iluminado_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_espacio_iluminado_tipo_espacio_iluminado_id_seq OWNER TO postgres;

--
-- TOC entry 3436 (class 0 OID 0)
-- Dependencies: 214
-- Name: tipo_espacio_iluminado_tipo_espacio_iluminado_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_espacio_iluminado_tipo_espacio_iluminado_id_seq OWNED BY public.tipo_espacio_iluminado.tipo_espacio_iluminado_id;


--
-- TOC entry 217 (class 1259 OID 18430)
-- Name: tipo_instalacion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_instalacion (
    tipo_instalacion_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_instalacion text
);


ALTER TABLE public.tipo_instalacion OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 18428)
-- Name: tipo_instalacion_tipo_instalacion_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_instalacion_tipo_instalacion_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_instalacion_tipo_instalacion_id_seq OWNER TO postgres;

--
-- TOC entry 3437 (class 0 OID 0)
-- Dependencies: 216
-- Name: tipo_instalacion_tipo_instalacion_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_instalacion_tipo_instalacion_id_seq OWNED BY public.tipo_instalacion.tipo_instalacion_id;


--
-- TOC entry 219 (class 1259 OID 18443)
-- Name: tipo_lampara; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_lampara (
    tipo_lampara_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_lampara text
);


ALTER TABLE public.tipo_lampara OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 18441)
-- Name: tipo_lampara_tipo_lampara_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_lampara_tipo_lampara_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_lampara_tipo_lampara_id_seq OWNER TO postgres;

--
-- TOC entry 3438 (class 0 OID 0)
-- Dependencies: 218
-- Name: tipo_lampara_tipo_lampara_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_lampara_tipo_lampara_id_seq OWNED BY public.tipo_lampara.tipo_lampara_id;


--
-- TOC entry 221 (class 1259 OID 18456)
-- Name: tipo_material; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_material (
    tipo_material_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_material text
);


ALTER TABLE public.tipo_material OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 18454)
-- Name: tipo_material_tipo_material_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_material_tipo_material_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_material_tipo_material_id_seq OWNER TO postgres;

--
-- TOC entry 3439 (class 0 OID 0)
-- Dependencies: 220
-- Name: tipo_material_tipo_material_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_material_tipo_material_id_seq OWNED BY public.tipo_material.tipo_material_id;


--
-- TOC entry 223 (class 1259 OID 18469)
-- Name: tipo_soporte; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_soporte (
    tipo_soporte_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_soporte text
);


ALTER TABLE public.tipo_soporte OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 18467)
-- Name: tipo_soporte_tipo_soporte_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_soporte_tipo_soporte_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_soporte_tipo_soporte_id_seq OWNER TO postgres;

--
-- TOC entry 3440 (class 0 OID 0)
-- Dependencies: 222
-- Name: tipo_soporte_tipo_soporte_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_soporte_tipo_soporte_id_seq OWNED BY public.tipo_soporte.tipo_soporte_id;


--
-- TOC entry 225 (class 1259 OID 18482)
-- Name: tipo_transformador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_transformador (
    tipo_transformador_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_transformador text
);


ALTER TABLE public.tipo_transformador OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 18480)
-- Name: tipo_transformador_tipo_transformador_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_transformador_tipo_transformador_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_transformador_tipo_transformador_id_seq OWNER TO postgres;

--
-- TOC entry 3441 (class 0 OID 0)
-- Dependencies: 224
-- Name: tipo_transformador_tipo_transformador_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_transformador_tipo_transformador_id_seq OWNED BY public.tipo_transformador.tipo_transformador_id;


--
-- TOC entry 227 (class 1259 OID 18495)
-- Name: tipo_usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_usuario (
    tipo_usuario_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_usuario text
);


ALTER TABLE public.tipo_usuario OWNER TO postgres;

--
-- TOC entry 226 (class 1259 OID 18493)
-- Name: tipo_usuario_tipo_usuario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_usuario_tipo_usuario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_usuario_tipo_usuario_id_seq OWNER TO postgres;

--
-- TOC entry 3442 (class 0 OID 0)
-- Dependencies: 226
-- Name: tipo_usuario_tipo_usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_usuario_tipo_usuario_id_seq OWNED BY public.tipo_usuario.tipo_usuario_id;


--
-- TOC entry 229 (class 1259 OID 18508)
-- Name: tipo_zona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipo_zona (
    tipo_zona_id integer NOT NULL,
    id_estado integer NOT NULL,
    nombre_tipo_zona text
);


ALTER TABLE public.tipo_zona OWNER TO postgres;

--
-- TOC entry 228 (class 1259 OID 18506)
-- Name: tipo_zona_tipo_zona_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipo_zona_tipo_zona_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_zona_tipo_zona_id_seq OWNER TO postgres;

--
-- TOC entry 3443 (class 0 OID 0)
-- Dependencies: 228
-- Name: tipo_zona_tipo_zona_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipo_zona_tipo_zona_id_seq OWNED BY public.tipo_zona.tipo_zona_id;


--
-- TOC entry 231 (class 1259 OID 18521)
-- Name: transformador; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transformador (
    transformador_id integer NOT NULL,
    tipo_soporte_id integer NOT NULL,
    tipo_transformador_id integer NOT NULL,
    id_estado integer NOT NULL
);


ALTER TABLE public.transformador OWNER TO postgres;

--
-- TOC entry 230 (class 1259 OID 18519)
-- Name: transformador_transformador_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.transformador_transformador_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.transformador_transformador_id_seq OWNER TO postgres;

--
-- TOC entry 3444 (class 0 OID 0)
-- Dependencies: 230
-- Name: transformador_transformador_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.transformador_transformador_id_seq OWNED BY public.transformador.transformador_id;


--
-- TOC entry 232 (class 1259 OID 18531)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    usuario_id text NOT NULL,
    tipo_usuario_id integer NOT NULL,
    tercero_id integer NOT NULL,
    id_estado integer NOT NULL,
    contrasenia text
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 3110 (class 2604 OID 18291)
-- Name: canalizacion canalizacion_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canalizacion ALTER COLUMN canalizacion_id SET DEFAULT nextval('public.canalizacion_canalizacion_id_seq'::regclass);


--
-- TOC entry 3111 (class 2604 OID 18307)
-- Name: estado id_estado; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado ALTER COLUMN id_estado SET DEFAULT nextval('public.estado_id_estado_seq'::regclass);


--
-- TOC entry 3112 (class 2604 OID 18319)
-- Name: lampara lampara_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara ALTER COLUMN lampara_id SET DEFAULT nextval('public.lampara_lampara_id_seq'::regclass);


--
-- TOC entry 3113 (class 2604 OID 18338)
-- Name: lampara_registrada lampara_registrada_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara_registrada ALTER COLUMN lampara_registrada_id SET DEFAULT nextval('public.lampara_registrada_lampara_registrada_id_seq'::regclass);


--
-- TOC entry 3114 (class 2604 OID 18352)
-- Name: red_alimentacion red_alimentacion_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.red_alimentacion ALTER COLUMN red_alimentacion_id SET DEFAULT nextval('public.red_alimentacion_red_alimentacion_id_seq'::regclass);


--
-- TOC entry 3115 (class 2604 OID 18368)
-- Name: soporte_lampara soporte_lampara_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soporte_lampara ALTER COLUMN soporte_lampara_id SET DEFAULT nextval('public.soporte_lampara_soporte_lampara_id_seq'::regclass);


--
-- TOC entry 3116 (class 2604 OID 18380)
-- Name: tercero tercero_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tercero ALTER COLUMN tercero_id SET DEFAULT nextval('public.tercero_tercero_id_seq'::regclass);


--
-- TOC entry 3117 (class 2604 OID 18394)
-- Name: tipo_balasto tipo_balasto_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_balasto ALTER COLUMN tipo_balasto_id SET DEFAULT nextval('public.tipo_balasto_tipo_balasto_id_seq'::regclass);


--
-- TOC entry 3118 (class 2604 OID 18407)
-- Name: tipo_documento tipo_documento_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_documento ALTER COLUMN tipo_documento_id SET DEFAULT nextval('public.tipo_documento_tipo_documento_id_seq'::regclass);


--
-- TOC entry 3119 (class 2604 OID 18420)
-- Name: tipo_espacio_iluminado tipo_espacio_iluminado_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_espacio_iluminado ALTER COLUMN tipo_espacio_iluminado_id SET DEFAULT nextval('public.tipo_espacio_iluminado_tipo_espacio_iluminado_id_seq'::regclass);


--
-- TOC entry 3120 (class 2604 OID 18433)
-- Name: tipo_instalacion tipo_instalacion_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_instalacion ALTER COLUMN tipo_instalacion_id SET DEFAULT nextval('public.tipo_instalacion_tipo_instalacion_id_seq'::regclass);


--
-- TOC entry 3121 (class 2604 OID 18446)
-- Name: tipo_lampara tipo_lampara_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_lampara ALTER COLUMN tipo_lampara_id SET DEFAULT nextval('public.tipo_lampara_tipo_lampara_id_seq'::regclass);


--
-- TOC entry 3122 (class 2604 OID 18459)
-- Name: tipo_material tipo_material_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_material ALTER COLUMN tipo_material_id SET DEFAULT nextval('public.tipo_material_tipo_material_id_seq'::regclass);


--
-- TOC entry 3123 (class 2604 OID 18472)
-- Name: tipo_soporte tipo_soporte_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_soporte ALTER COLUMN tipo_soporte_id SET DEFAULT nextval('public.tipo_soporte_tipo_soporte_id_seq'::regclass);


--
-- TOC entry 3124 (class 2604 OID 18485)
-- Name: tipo_transformador tipo_transformador_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_transformador ALTER COLUMN tipo_transformador_id SET DEFAULT nextval('public.tipo_transformador_tipo_transformador_id_seq'::regclass);


--
-- TOC entry 3125 (class 2604 OID 18498)
-- Name: tipo_usuario tipo_usuario_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_usuario ALTER COLUMN tipo_usuario_id SET DEFAULT nextval('public.tipo_usuario_tipo_usuario_id_seq'::regclass);


--
-- TOC entry 3126 (class 2604 OID 18511)
-- Name: tipo_zona tipo_zona_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_zona ALTER COLUMN tipo_zona_id SET DEFAULT nextval('public.tipo_zona_tipo_zona_id_seq'::regclass);


--
-- TOC entry 3127 (class 2604 OID 18524)
-- Name: transformador transformador_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transformador ALTER COLUMN transformador_id SET DEFAULT nextval('public.transformador_transformador_id_seq'::regclass);


--
-- TOC entry 3383 (class 0 OID 18288)
-- Dependencies: 197
-- Data for Name: canalizacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3385 (class 0 OID 18304)
-- Dependencies: 199
-- Data for Name: estado; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.estado (id_estado, estado) VALUES (1, 'S');
INSERT INTO public.estado (id_estado, estado) VALUES (2, 'N');


--
-- TOC entry 3387 (class 0 OID 18316)
-- Dependencies: 201
-- Data for Name: lampara; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3389 (class 0 OID 18335)
-- Dependencies: 203
-- Data for Name: lampara_registrada; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3391 (class 0 OID 18349)
-- Dependencies: 205
-- Data for Name: red_alimentacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3393 (class 0 OID 18365)
-- Dependencies: 207
-- Data for Name: soporte_lampara; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3395 (class 0 OID 18377)
-- Dependencies: 209
-- Data for Name: tercero; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tercero (tercero_id, tipo_documento_id, id_estado, nombre_tercero, numero_documento, direccion, email, telefono) VALUES (1, 1, 1, 'Giovanny Ayala', 67897123, 'Call 16', 'ayala@yopmail.com', 3112342123);


--
-- TOC entry 3397 (class 0 OID 18391)
-- Dependencies: 211
-- Data for Name: tipo_balasto; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3399 (class 0 OID 18404)
-- Dependencies: 213
-- Data for Name: tipo_documento; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tipo_documento (tipo_documento_id, id_estado, nombre_tipo_documento) VALUES (1, 1, 'Cedula');


--
-- TOC entry 3401 (class 0 OID 18417)
-- Dependencies: 215
-- Data for Name: tipo_espacio_iluminado; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3403 (class 0 OID 18430)
-- Dependencies: 217
-- Data for Name: tipo_instalacion; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3405 (class 0 OID 18443)
-- Dependencies: 219
-- Data for Name: tipo_lampara; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3407 (class 0 OID 18456)
-- Dependencies: 221
-- Data for Name: tipo_material; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3409 (class 0 OID 18469)
-- Dependencies: 223
-- Data for Name: tipo_soporte; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3411 (class 0 OID 18482)
-- Dependencies: 225
-- Data for Name: tipo_transformador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3413 (class 0 OID 18495)
-- Dependencies: 227
-- Data for Name: tipo_usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tipo_usuario (tipo_usuario_id, id_estado, nombre_tipo_usuario) VALUES (1, 1, 'Administrador');
INSERT INTO public.tipo_usuario (tipo_usuario_id, id_estado, nombre_tipo_usuario) VALUES (2, 1, 'Coordinador');
INSERT INTO public.tipo_usuario (tipo_usuario_id, id_estado, nombre_tipo_usuario) VALUES (3, 1, 'Tecnico');


--
-- TOC entry 3415 (class 0 OID 18508)
-- Dependencies: 229
-- Data for Name: tipo_zona; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3417 (class 0 OID 18521)
-- Dependencies: 231
-- Data for Name: transformador; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 3418 (class 0 OID 18531)
-- Dependencies: 232
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.usuario (usuario_id, tipo_usuario_id, tercero_id, id_estado, contrasenia) VALUES ('ayala', 1, 1, 1, 'ayala');


--
-- TOC entry 3445 (class 0 OID 0)
-- Dependencies: 196
-- Name: canalizacion_canalizacion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.canalizacion_canalizacion_id_seq', 1, false);


--
-- TOC entry 3446 (class 0 OID 0)
-- Dependencies: 198
-- Name: estado_id_estado_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.estado_id_estado_seq', 1, false);


--
-- TOC entry 3447 (class 0 OID 0)
-- Dependencies: 200
-- Name: lampara_lampara_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lampara_lampara_id_seq', 1, false);


--
-- TOC entry 3448 (class 0 OID 0)
-- Dependencies: 202
-- Name: lampara_registrada_lampara_registrada_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.lampara_registrada_lampara_registrada_id_seq', 1, false);


--
-- TOC entry 3449 (class 0 OID 0)
-- Dependencies: 204
-- Name: red_alimentacion_red_alimentacion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.red_alimentacion_red_alimentacion_id_seq', 1, false);


--
-- TOC entry 3450 (class 0 OID 0)
-- Dependencies: 206
-- Name: soporte_lampara_soporte_lampara_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.soporte_lampara_soporte_lampara_id_seq', 1, false);


--
-- TOC entry 3451 (class 0 OID 0)
-- Dependencies: 208
-- Name: tercero_tercero_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tercero_tercero_id_seq', 1, false);


--
-- TOC entry 3452 (class 0 OID 0)
-- Dependencies: 210
-- Name: tipo_balasto_tipo_balasto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_balasto_tipo_balasto_id_seq', 1, false);


--
-- TOC entry 3453 (class 0 OID 0)
-- Dependencies: 212
-- Name: tipo_documento_tipo_documento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_documento_tipo_documento_id_seq', 1, false);


--
-- TOC entry 3454 (class 0 OID 0)
-- Dependencies: 214
-- Name: tipo_espacio_iluminado_tipo_espacio_iluminado_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_espacio_iluminado_tipo_espacio_iluminado_id_seq', 1, false);


--
-- TOC entry 3455 (class 0 OID 0)
-- Dependencies: 216
-- Name: tipo_instalacion_tipo_instalacion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_instalacion_tipo_instalacion_id_seq', 1, false);


--
-- TOC entry 3456 (class 0 OID 0)
-- Dependencies: 218
-- Name: tipo_lampara_tipo_lampara_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_lampara_tipo_lampara_id_seq', 1, false);


--
-- TOC entry 3457 (class 0 OID 0)
-- Dependencies: 220
-- Name: tipo_material_tipo_material_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_material_tipo_material_id_seq', 1, false);


--
-- TOC entry 3458 (class 0 OID 0)
-- Dependencies: 222
-- Name: tipo_soporte_tipo_soporte_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_soporte_tipo_soporte_id_seq', 1, false);


--
-- TOC entry 3459 (class 0 OID 0)
-- Dependencies: 224
-- Name: tipo_transformador_tipo_transformador_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_transformador_tipo_transformador_id_seq', 1, false);


--
-- TOC entry 3460 (class 0 OID 0)
-- Dependencies: 226
-- Name: tipo_usuario_tipo_usuario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_usuario_tipo_usuario_id_seq', 1, false);


--
-- TOC entry 3461 (class 0 OID 0)
-- Dependencies: 228
-- Name: tipo_zona_tipo_zona_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipo_zona_tipo_zona_id_seq', 1, false);


--
-- TOC entry 3462 (class 0 OID 0)
-- Dependencies: 230
-- Name: transformador_transformador_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.transformador_transformador_id_seq', 1, false);


--
-- TOC entry 3132 (class 2606 OID 18296)
-- Name: canalizacion pk_canalizacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canalizacion
    ADD CONSTRAINT pk_canalizacion PRIMARY KEY (canalizacion_id);


--
-- TOC entry 3137 (class 2606 OID 18312)
-- Name: estado pk_estado; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.estado
    ADD CONSTRAINT pk_estado PRIMARY KEY (id_estado);


--
-- TOC entry 3141 (class 2606 OID 18324)
-- Name: lampara pk_lampara; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara
    ADD CONSTRAINT pk_lampara PRIMARY KEY (lampara_id);


--
-- TOC entry 3151 (class 2606 OID 18343)
-- Name: lampara_registrada pk_lampara_registrada; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara_registrada
    ADD CONSTRAINT pk_lampara_registrada PRIMARY KEY (lampara_registrada_id);


--
-- TOC entry 3155 (class 2606 OID 18357)
-- Name: red_alimentacion pk_red_alimentacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.red_alimentacion
    ADD CONSTRAINT pk_red_alimentacion PRIMARY KEY (red_alimentacion_id);


--
-- TOC entry 3162 (class 2606 OID 18370)
-- Name: soporte_lampara pk_soporte_lampara; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soporte_lampara
    ADD CONSTRAINT pk_soporte_lampara PRIMARY KEY (soporte_lampara_id);


--
-- TOC entry 3168 (class 2606 OID 18385)
-- Name: tercero pk_tercero; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tercero
    ADD CONSTRAINT pk_tercero PRIMARY KEY (tercero_id);


--
-- TOC entry 3173 (class 2606 OID 18399)
-- Name: tipo_balasto pk_tipo_balasto; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_balasto
    ADD CONSTRAINT pk_tipo_balasto PRIMARY KEY (tipo_balasto_id);


--
-- TOC entry 3177 (class 2606 OID 18412)
-- Name: tipo_documento pk_tipo_documento; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT pk_tipo_documento PRIMARY KEY (tipo_documento_id);


--
-- TOC entry 3181 (class 2606 OID 18425)
-- Name: tipo_espacio_iluminado pk_tipo_espacio_iluminado; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_espacio_iluminado
    ADD CONSTRAINT pk_tipo_espacio_iluminado PRIMARY KEY (tipo_espacio_iluminado_id);


--
-- TOC entry 3185 (class 2606 OID 18438)
-- Name: tipo_instalacion pk_tipo_instalacion; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_instalacion
    ADD CONSTRAINT pk_tipo_instalacion PRIMARY KEY (tipo_instalacion_id);


--
-- TOC entry 3189 (class 2606 OID 18451)
-- Name: tipo_lampara pk_tipo_lampara; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_lampara
    ADD CONSTRAINT pk_tipo_lampara PRIMARY KEY (tipo_lampara_id);


--
-- TOC entry 3193 (class 2606 OID 18464)
-- Name: tipo_material pk_tipo_material; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_material
    ADD CONSTRAINT pk_tipo_material PRIMARY KEY (tipo_material_id);


--
-- TOC entry 3197 (class 2606 OID 18477)
-- Name: tipo_soporte pk_tipo_soporte; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_soporte
    ADD CONSTRAINT pk_tipo_soporte PRIMARY KEY (tipo_soporte_id);


--
-- TOC entry 3201 (class 2606 OID 18490)
-- Name: tipo_transformador pk_tipo_transformador; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_transformador
    ADD CONSTRAINT pk_tipo_transformador PRIMARY KEY (tipo_transformador_id);


--
-- TOC entry 3205 (class 2606 OID 18503)
-- Name: tipo_usuario pk_tipo_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_usuario
    ADD CONSTRAINT pk_tipo_usuario PRIMARY KEY (tipo_usuario_id);


--
-- TOC entry 3209 (class 2606 OID 18516)
-- Name: tipo_zona pk_tipo_zona; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_zona
    ADD CONSTRAINT pk_tipo_zona PRIMARY KEY (tipo_zona_id);


--
-- TOC entry 3213 (class 2606 OID 18526)
-- Name: transformador pk_transformador; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transformador
    ADD CONSTRAINT pk_transformador PRIMARY KEY (transformador_id);


--
-- TOC entry 3219 (class 2606 OID 18538)
-- Name: usuario pk_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (usuario_id);


--
-- TOC entry 3128 (class 1259 OID 18297)
-- Name: canalizacion_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX canalizacion_pk ON public.canalizacion USING btree (canalizacion_id);


--
-- TOC entry 3129 (class 1259 OID 18300)
-- Name: estado_canalizacion_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_canalizacion_fk ON public.canalizacion USING btree (id_estado);


--
-- TOC entry 3138 (class 1259 OID 18332)
-- Name: estado_lampara_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_lampara_fk ON public.lampara USING btree (id_estado);


--
-- TOC entry 3135 (class 1259 OID 18313)
-- Name: estado_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX estado_pk ON public.estado USING btree (id_estado);


--
-- TOC entry 3153 (class 1259 OID 18362)
-- Name: estado_red_alimentacion_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_red_alimentacion_fk ON public.red_alimentacion USING btree (id_estado);


--
-- TOC entry 3160 (class 1259 OID 18374)
-- Name: estado_sop_lampara_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_sop_lampara_fk ON public.soporte_lampara USING btree (id_estado);


--
-- TOC entry 3166 (class 1259 OID 18388)
-- Name: estado_tercero_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tercero_fk ON public.tercero USING btree (id_estado);


--
-- TOC entry 3171 (class 1259 OID 18401)
-- Name: estado_tipo_balas_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_balas_fk ON public.tipo_balasto USING btree (id_estado);


--
-- TOC entry 3175 (class 1259 OID 18414)
-- Name: estado_tipo_documento_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_documento_fk ON public.tipo_documento USING btree (id_estado);


--
-- TOC entry 3179 (class 1259 OID 18427)
-- Name: estado_tipo_espacio_ilum_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_espacio_ilum_fk ON public.tipo_espacio_iluminado USING btree (id_estado);


--
-- TOC entry 3183 (class 1259 OID 18440)
-- Name: estado_tipo_instalacion_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_instalacion_fk ON public.tipo_instalacion USING btree (id_estado);


--
-- TOC entry 3187 (class 1259 OID 18453)
-- Name: estado_tipo_lamp_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_lamp_fk ON public.tipo_lampara USING btree (id_estado);


--
-- TOC entry 3191 (class 1259 OID 18466)
-- Name: estado_tipo_material_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_material_fk ON public.tipo_material USING btree (id_estado);


--
-- TOC entry 3195 (class 1259 OID 18479)
-- Name: estado_tipo_soporte_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_soporte_fk ON public.tipo_soporte USING btree (id_estado);


--
-- TOC entry 3199 (class 1259 OID 18492)
-- Name: estado_tipo_transformador_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_transformador_fk ON public.tipo_transformador USING btree (id_estado);


--
-- TOC entry 3203 (class 1259 OID 18505)
-- Name: estado_tipo_usuario_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_usuario_fk ON public.tipo_usuario USING btree (id_estado);


--
-- TOC entry 3207 (class 1259 OID 18518)
-- Name: estado_tipo_zona_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_tipo_zona_fk ON public.tipo_zona USING btree (id_estado);


--
-- TOC entry 3211 (class 1259 OID 18530)
-- Name: estado_transformador_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_transformador_fk ON public.transformador USING btree (id_estado);


--
-- TOC entry 3217 (class 1259 OID 18542)
-- Name: estado_usuario_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX estado_usuario_fk ON public.usuario USING btree (id_estado);


--
-- TOC entry 3130 (class 1259 OID 18299)
-- Name: lampara_canalizacion_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX lampara_canalizacion_fk ON public.canalizacion USING btree (lampara_id);


--
-- TOC entry 3139 (class 1259 OID 18325)
-- Name: lampara_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX lampara_pk ON public.lampara USING btree (lampara_id);


--
-- TOC entry 3148 (class 1259 OID 18346)
-- Name: lampara_regis_lampara_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX lampara_regis_lampara_fk ON public.lampara_registrada USING btree (lampara_id);


--
-- TOC entry 3149 (class 1259 OID 18344)
-- Name: lampara_registrada_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX lampara_registrada_pk ON public.lampara_registrada USING btree (lampara_registrada_id);


--
-- TOC entry 3156 (class 1259 OID 18358)
-- Name: red_alimentacion_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX red_alimentacion_pk ON public.red_alimentacion USING btree (red_alimentacion_id);


--
-- TOC entry 3142 (class 1259 OID 18331)
-- Name: red_alimentcn_lampara_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX red_alimentcn_lampara_fk ON public.lampara USING btree (red_alimentacion_id);


--
-- TOC entry 3157 (class 1259 OID 18359)
-- Name: relationship_5_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX relationship_5_fk ON public.red_alimentacion USING btree (tipo_instalacion_id);


--
-- TOC entry 3163 (class 1259 OID 18373)
-- Name: sopor_lamp_tip__sopor_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX sopor_lamp_tip__sopor_fk ON public.soporte_lampara USING btree (tipo_soporte_id);


--
-- TOC entry 3164 (class 1259 OID 18372)
-- Name: sopor_lamp_tip_mater_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX sopor_lamp_tip_mater_fk ON public.soporte_lampara USING btree (tipo_material_id);


--
-- TOC entry 3143 (class 1259 OID 18330)
-- Name: soport_lamp_lampara_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX soport_lamp_lampara_fk ON public.lampara USING btree (soporte_lampara_id);


--
-- TOC entry 3165 (class 1259 OID 18371)
-- Name: soporte_lampara_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX soporte_lampara_pk ON public.soporte_lampara USING btree (soporte_lampara_id);


--
-- TOC entry 3169 (class 1259 OID 18386)
-- Name: tercero_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tercero_pk ON public.tercero USING btree (tercero_id);


--
-- TOC entry 3158 (class 1259 OID 18360)
-- Name: tip_materi_red_alimentacn_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tip_materi_red_alimentacn_fk ON public.red_alimentacion USING btree (tipo_material_id);


--
-- TOC entry 3159 (class 1259 OID 18361)
-- Name: tip_soport_red_alimentacn_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tip_soport_red_alimentacn_fk ON public.red_alimentacion USING btree (tipo_soporte_id);


--
-- TOC entry 3133 (class 1259 OID 18298)
-- Name: tip_zona_canalizcn_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tip_zona_canalizcn_fk ON public.canalizacion USING btree (tipo_zona_id);


--
-- TOC entry 3144 (class 1259 OID 18328)
-- Name: tipo_balasto_lampara_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tipo_balasto_lampara_fk ON public.lampara USING btree (tipo_balasto_id);


--
-- TOC entry 3174 (class 1259 OID 18400)
-- Name: tipo_balasto_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_balasto_pk ON public.tipo_balasto USING btree (tipo_balasto_id);


--
-- TOC entry 3170 (class 1259 OID 18387)
-- Name: tipo_documen_tercero_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tipo_documen_tercero_fk ON public.tercero USING btree (tipo_documento_id);


--
-- TOC entry 3178 (class 1259 OID 18413)
-- Name: tipo_documento_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_documento_pk ON public.tipo_documento USING btree (tipo_documento_id);


--
-- TOC entry 3145 (class 1259 OID 18329)
-- Name: tipo_espacio_ilum_lampara_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tipo_espacio_ilum_lampara_fk ON public.lampara USING btree (tipo_espacio_iluminado_id);


--
-- TOC entry 3182 (class 1259 OID 18426)
-- Name: tipo_espacio_iluminado_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_espacio_iluminado_pk ON public.tipo_espacio_iluminado USING btree (tipo_espacio_iluminado_id);


--
-- TOC entry 3186 (class 1259 OID 18439)
-- Name: tipo_instalacion_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_instalacion_pk ON public.tipo_instalacion USING btree (tipo_instalacion_id);


--
-- TOC entry 3146 (class 1259 OID 18326)
-- Name: tipo_lampara_lampara_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tipo_lampara_lampara_fk ON public.lampara USING btree (tipo_lampara_id);


--
-- TOC entry 3190 (class 1259 OID 18452)
-- Name: tipo_lampara_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_lampara_pk ON public.tipo_lampara USING btree (tipo_lampara_id);


--
-- TOC entry 3194 (class 1259 OID 18465)
-- Name: tipo_material_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_material_pk ON public.tipo_material USING btree (tipo_material_id);


--
-- TOC entry 3198 (class 1259 OID 18478)
-- Name: tipo_soporte_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_soporte_pk ON public.tipo_soporte USING btree (tipo_soporte_id);


--
-- TOC entry 3202 (class 1259 OID 18491)
-- Name: tipo_transformador_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_transformador_pk ON public.tipo_transformador USING btree (tipo_transformador_id);


--
-- TOC entry 3206 (class 1259 OID 18504)
-- Name: tipo_usuario_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_usuario_pk ON public.tipo_usuario USING btree (tipo_usuario_id);


--
-- TOC entry 3220 (class 1259 OID 18540)
-- Name: tipo_usuario_usuario_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tipo_usuario_usuario_fk ON public.usuario USING btree (tipo_usuario_id);


--
-- TOC entry 3210 (class 1259 OID 18517)
-- Name: tipo_zona_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX tipo_zona_pk ON public.tipo_zona USING btree (tipo_zona_id);


--
-- TOC entry 3214 (class 1259 OID 18529)
-- Name: transfo_tipo_transfo_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX transfo_tipo_transfo_fk ON public.transformador USING btree (tipo_transformador_id);


--
-- TOC entry 3147 (class 1259 OID 18327)
-- Name: transformador_lampara_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX transformador_lampara_fk ON public.lampara USING btree (transformador_id);


--
-- TOC entry 3215 (class 1259 OID 18527)
-- Name: transformador_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX transformador_pk ON public.transformador USING btree (transformador_id);


--
-- TOC entry 3216 (class 1259 OID 18528)
-- Name: transformador_tipo_soporte_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX transformador_tipo_soporte_fk ON public.transformador USING btree (tipo_soporte_id);


--
-- TOC entry 3134 (class 1259 OID 18301)
-- Name: tsoport_canalizacion_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX tsoport_canalizacion_fk ON public.canalizacion USING btree (tipo_soporte_id);


--
-- TOC entry 3152 (class 1259 OID 18345)
-- Name: usuario_lamp_registrada_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX usuario_lamp_registrada_fk ON public.lampara_registrada USING btree (usuario_id);


--
-- TOC entry 3221 (class 1259 OID 18539)
-- Name: usuario_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX usuario_pk ON public.usuario USING btree (usuario_id);


--
-- TOC entry 3222 (class 1259 OID 18541)
-- Name: usuario_tercero_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX usuario_tercero_fk ON public.usuario USING btree (tercero_id);


--
-- TOC entry 3223 (class 2606 OID 18543)
-- Name: canalizacion fk_canaliza_estado_ca_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canalizacion
    ADD CONSTRAINT fk_canaliza_estado_ca_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3224 (class 2606 OID 18548)
-- Name: canalizacion fk_canaliza_lampara_c_lampara; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canalizacion
    ADD CONSTRAINT fk_canaliza_lampara_c_lampara FOREIGN KEY (lampara_id) REFERENCES public.lampara(lampara_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3225 (class 2606 OID 18553)
-- Name: canalizacion fk_canaliza_tip_zona__tipo_zon; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canalizacion
    ADD CONSTRAINT fk_canaliza_tip_zona__tipo_zon FOREIGN KEY (tipo_zona_id) REFERENCES public.tipo_zona(tipo_zona_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3226 (class 2606 OID 18558)
-- Name: canalizacion fk_canaliza_tsoport_c_tipo_sop; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.canalizacion
    ADD CONSTRAINT fk_canaliza_tsoport_c_tipo_sop FOREIGN KEY (tipo_soporte_id) REFERENCES public.tipo_soporte(tipo_soporte_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3234 (class 2606 OID 18598)
-- Name: lampara_registrada fk_lampara__lampara_r_lampara; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara_registrada
    ADD CONSTRAINT fk_lampara__lampara_r_lampara FOREIGN KEY (lampara_id) REFERENCES public.lampara(lampara_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3235 (class 2606 OID 18603)
-- Name: lampara_registrada fk_lampara__usuario_l_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara_registrada
    ADD CONSTRAINT fk_lampara__usuario_l_usuario FOREIGN KEY (usuario_id) REFERENCES public.usuario(usuario_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3227 (class 2606 OID 18563)
-- Name: lampara fk_lampara_estado_la_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara
    ADD CONSTRAINT fk_lampara_estado_la_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3228 (class 2606 OID 18568)
-- Name: lampara fk_lampara_red_alime_red_alim; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara
    ADD CONSTRAINT fk_lampara_red_alime_red_alim FOREIGN KEY (red_alimentacion_id) REFERENCES public.red_alimentacion(red_alimentacion_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3229 (class 2606 OID 18573)
-- Name: lampara fk_lampara_soport_la_soporte_; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara
    ADD CONSTRAINT fk_lampara_soport_la_soporte_ FOREIGN KEY (soporte_lampara_id) REFERENCES public.soporte_lampara(soporte_lampara_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3230 (class 2606 OID 18578)
-- Name: lampara fk_lampara_tipo_bala_tipo_bal; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara
    ADD CONSTRAINT fk_lampara_tipo_bala_tipo_bal FOREIGN KEY (tipo_balasto_id) REFERENCES public.tipo_balasto(tipo_balasto_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3231 (class 2606 OID 18583)
-- Name: lampara fk_lampara_tipo_espa_tipo_esp; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara
    ADD CONSTRAINT fk_lampara_tipo_espa_tipo_esp FOREIGN KEY (tipo_espacio_iluminado_id) REFERENCES public.tipo_espacio_iluminado(tipo_espacio_iluminado_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3232 (class 2606 OID 18588)
-- Name: lampara fk_lampara_tipo_lamp_tipo_lam; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara
    ADD CONSTRAINT fk_lampara_tipo_lamp_tipo_lam FOREIGN KEY (tipo_lampara_id) REFERENCES public.tipo_lampara(tipo_lampara_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3233 (class 2606 OID 18593)
-- Name: lampara fk_lampara_transform_transfor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.lampara
    ADD CONSTRAINT fk_lampara_transform_transfor FOREIGN KEY (transformador_id) REFERENCES public.transformador(transformador_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3236 (class 2606 OID 18608)
-- Name: red_alimentacion fk_red_alim_estado_re_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.red_alimentacion
    ADD CONSTRAINT fk_red_alim_estado_re_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3237 (class 2606 OID 18613)
-- Name: red_alimentacion fk_red_alim_relations_tipo_ins; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.red_alimentacion
    ADD CONSTRAINT fk_red_alim_relations_tipo_ins FOREIGN KEY (tipo_instalacion_id) REFERENCES public.tipo_instalacion(tipo_instalacion_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3238 (class 2606 OID 18618)
-- Name: red_alimentacion fk_red_alim_tip_mater_tipo_mat; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.red_alimentacion
    ADD CONSTRAINT fk_red_alim_tip_mater_tipo_mat FOREIGN KEY (tipo_material_id) REFERENCES public.tipo_material(tipo_material_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3239 (class 2606 OID 18623)
-- Name: red_alimentacion fk_red_alim_tip_sopor_tipo_sop; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.red_alimentacion
    ADD CONSTRAINT fk_red_alim_tip_sopor_tipo_sop FOREIGN KEY (tipo_soporte_id) REFERENCES public.tipo_soporte(tipo_soporte_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3240 (class 2606 OID 18628)
-- Name: soporte_lampara fk_soporte__estado_so_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soporte_lampara
    ADD CONSTRAINT fk_soporte__estado_so_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3241 (class 2606 OID 18633)
-- Name: soporte_lampara fk_soporte__sopor_lam_tipo_mat; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soporte_lampara
    ADD CONSTRAINT fk_soporte__sopor_lam_tipo_mat FOREIGN KEY (tipo_material_id) REFERENCES public.tipo_material(tipo_material_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3242 (class 2606 OID 18638)
-- Name: soporte_lampara fk_soporte__sopor_lam_tipo_sop; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.soporte_lampara
    ADD CONSTRAINT fk_soporte__sopor_lam_tipo_sop FOREIGN KEY (tipo_soporte_id) REFERENCES public.tipo_soporte(tipo_soporte_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3243 (class 2606 OID 18643)
-- Name: tercero fk_tercero_estado_te_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tercero
    ADD CONSTRAINT fk_tercero_estado_te_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3244 (class 2606 OID 18648)
-- Name: tercero fk_tercero_tipo_docu_tipo_doc; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tercero
    ADD CONSTRAINT fk_tercero_tipo_docu_tipo_doc FOREIGN KEY (tipo_documento_id) REFERENCES public.tipo_documento(tipo_documento_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3245 (class 2606 OID 18653)
-- Name: tipo_balasto fk_tipo_bal_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_balasto
    ADD CONSTRAINT fk_tipo_bal_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3246 (class 2606 OID 18658)
-- Name: tipo_documento fk_tipo_doc_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_documento
    ADD CONSTRAINT fk_tipo_doc_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3247 (class 2606 OID 18663)
-- Name: tipo_espacio_iluminado fk_tipo_esp_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_espacio_iluminado
    ADD CONSTRAINT fk_tipo_esp_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3248 (class 2606 OID 18668)
-- Name: tipo_instalacion fk_tipo_ins_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_instalacion
    ADD CONSTRAINT fk_tipo_ins_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3249 (class 2606 OID 18673)
-- Name: tipo_lampara fk_tipo_lam_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_lampara
    ADD CONSTRAINT fk_tipo_lam_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3250 (class 2606 OID 18678)
-- Name: tipo_material fk_tipo_mat_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_material
    ADD CONSTRAINT fk_tipo_mat_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3251 (class 2606 OID 18683)
-- Name: tipo_soporte fk_tipo_sop_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_soporte
    ADD CONSTRAINT fk_tipo_sop_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3252 (class 2606 OID 18688)
-- Name: tipo_transformador fk_tipo_tra_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_transformador
    ADD CONSTRAINT fk_tipo_tra_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3253 (class 2606 OID 18693)
-- Name: tipo_usuario fk_tipo_usu_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_usuario
    ADD CONSTRAINT fk_tipo_usu_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3254 (class 2606 OID 18698)
-- Name: tipo_zona fk_tipo_zon_estado_ti_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipo_zona
    ADD CONSTRAINT fk_tipo_zon_estado_ti_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3255 (class 2606 OID 18703)
-- Name: transformador fk_transfor_estado_tr_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transformador
    ADD CONSTRAINT fk_transfor_estado_tr_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3257 (class 2606 OID 18713)
-- Name: transformador fk_transfor_transfo_t_tipo_tra; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transformador
    ADD CONSTRAINT fk_transfor_transfo_t_tipo_tra FOREIGN KEY (tipo_transformador_id) REFERENCES public.tipo_transformador(tipo_transformador_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3256 (class 2606 OID 18708)
-- Name: transformador fk_transfor_transform_tipo_sop; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transformador
    ADD CONSTRAINT fk_transfor_transform_tipo_sop FOREIGN KEY (tipo_soporte_id) REFERENCES public.tipo_soporte(tipo_soporte_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3258 (class 2606 OID 18718)
-- Name: usuario fk_usuario_estado_us_estado; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk_usuario_estado_us_estado FOREIGN KEY (id_estado) REFERENCES public.estado(id_estado) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3259 (class 2606 OID 18723)
-- Name: usuario fk_usuario_tipo_usua_tipo_usu; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk_usuario_tipo_usua_tipo_usu FOREIGN KEY (tipo_usuario_id) REFERENCES public.tipo_usuario(tipo_usuario_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3260 (class 2606 OID 18728)
-- Name: usuario fk_usuario_usuario_t_tercero; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT fk_usuario_usuario_t_tercero FOREIGN KEY (tercero_id) REFERENCES public.tercero(tercero_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


-- Completed on 2019-09-14 21:42:46 -05

--
-- PostgreSQL database dump complete
--

