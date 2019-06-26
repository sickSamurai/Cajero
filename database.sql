PGDMP     *                    w            banco    11.3    11.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    16685    banco    DATABASE        CREATE DATABASE banco WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE banco;
             postgres    false            Å            1259    16691    cuenta    TABLE     Ì   CREATE TABLE public.cuenta (
    numero_cuenta character varying(10) NOT NULL,
    numero_tarjeta character varying(16) NOT NULL,
    saldo numeric DEFAULT 0 NOT NULL,
    esta_activa boolean NOT NULL
);
    DROP TABLE public.cuenta;
       public         postgres    false            Ä            1259    16686    tarjeta    TABLE     |   CREATE TABLE public.tarjeta (
    numero_tarjeta character varying(16) NOT NULL,
    clave character varying(8) NOT NULL
);
    DROP TABLE public.tarjeta;
       public         postgres    false                      0    16691    cuenta 
   TABLE DATA               S   COPY public.cuenta (numero_cuenta, numero_tarjeta, saldo, esta_activa) FROM stdin;
    public       postgres    false    197   '                 0    16686    tarjeta 
   TABLE DATA               8   COPY public.tarjeta (numero_tarjeta, clave) FROM stdin;
    public       postgres    false    196   ]       
           2606    16699    cuenta cuenta_pk 
   CONSTRAINT     Y   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_pk PRIMARY KEY (numero_cuenta);
 :   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_pk;
       public         postgres    false    197            
           2606    16701    cuenta cuenta_uk1 
   CONSTRAINT     V   ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_uk1 UNIQUE (numero_tarjeta);
 ;   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_uk1;
       public         postgres    false    197            
           2606    16690    tarjeta tarjeta_pk 
   CONSTRAINT     \   ALTER TABLE ONLY public.tarjeta
    ADD CONSTRAINT tarjeta_pk PRIMARY KEY (numero_tarjeta);
 <   ALTER TABLE ONLY public.tarjeta DROP CONSTRAINT tarjeta_pk;
       public         postgres    false    196            
           2606    16702    cuenta cuenta_tarjeta_fk    FK CONSTRAINT        ALTER TABLE ONLY public.cuenta
    ADD CONSTRAINT cuenta_tarjeta_fk FOREIGN KEY (numero_tarjeta) REFERENCES public.tarjeta(numero_tarjeta);
 B   ALTER TABLE ONLY public.cuenta DROP CONSTRAINT cuenta_tarjeta_fk;
       public       postgres    false    197    196    2690               &   x3450525á44515³012²M@³+F o¸         3   x34515³01265á4´45çrMLÍ!|S33CS3@ !Ø	ê     