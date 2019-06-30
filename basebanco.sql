SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 16691)
-- Name: cuenta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cuenta (
    numero_cuenta character varying(10) NOT NULL,    
    saldo numeric DEFAULT 0 NOT NULL
    
);

drop table public.cuenta


ALTER TABLE public.cuenta OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16686)
-- Name: tarjeta; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tarjeta (	
    numero_tarjeta character varying(16) NOT NULL,
	numero_cuenta character varying(10) NOT NULL,
    clave character varying(8) NOT NULL,
	esta_activa boolean NOT NULL
);


ALTER TABLE public.tarjeta OWNER TO postgres;

--
-- TOC entry 2818 (class 0 OID 16691)
-- Dependencies: 197
-- Data for Name: cuenta; Type: TABLE DATA; Schema: public; Owner: postgres
--

insert into public.cuenta values (1505254, 50000);
insert into public.cuenta values (8452175, 1550000);
insert into public.cuenta values (9865472, 105000);




--
-- TOC entry 2817 (class 0 OID 16686)
-- Dependencies: 196
-- Data for Name: tarjeta; Type: TABLE DATA; Schema: public; Owner: postgres
--
insert into public.tarjeta values (15456842354,1505254, 1957, true);
insert into public.tarjeta values (4565002561,8452175, 1957, true);
insert into public.tarjeta values (56454566156,9865472, 1957, true);




--
-- TOC entry 2692 (class 2606 OID 16699)
-- Name: cuenta cuenta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pk PRIMARY KEY (numero_cuenta);


--
-- TOC entry 2690 (class 2606 OID 16690)
-- Name: tarjeta tarjeta_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjeta
    ADD CONSTRAINT tarjeta_pk PRIMARY KEY (numero_tarjeta);


--
-- TOC entry 2695 (class 2606 OID 16702)
-- Name: cuenta cuenta_tarjeta_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tarjeta
    ADD CONSTRAINT cuenta_tarjeta_fk FOREIGN KEY (numero_cuenta) REFERENCES public.cuenta(numero_cuenta);

select * from public.cuenta
select * from public.tarjeta

update public.tarjeta set esta_activa=true where numero_tarjeta='15456842354';
update public.cuenta set saldo=10000000 where numero_cuenta='1505254';

-- Completed on 2019-06-26 15:07:18

--
-- PostgreSQL database dump complete
--

