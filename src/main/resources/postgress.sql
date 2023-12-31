PGDMP                         {            postgres    15.3    15.3                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            !           1262    5    postgres    DATABASE     j   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
    DROP DATABASE postgres;
                postgres    false            "           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    3617                        3079    16384 	   adminpack 	   EXTENSION     A   CREATE EXTENSION IF NOT EXISTS adminpack WITH SCHEMA pg_catalog;
    DROP EXTENSION adminpack;
                   false            #           0    0    EXTENSION adminpack    COMMENT     M   COMMENT ON EXTENSION adminpack IS 'administrative functions for PostgreSQL';
                        false    2            �            1259    16479    deparement_head    TABLE     x   CREATE TABLE public.deparement_head (
    department_id character varying(10),
    employee_id character varying(10)
);
 #   DROP TABLE public.deparement_head;
       public         heap    postgres    false            �            1259    16476 
   department    TABLE     �   CREATE TABLE public.department (
    dept_id character varying(10),
    dept_name character varying(100),
    dept_create_date date,
    dept_update_date date,
    dept_org_code character varying(10)
);
    DROP TABLE public.department;
       public         heap    postgres    false            �            1259    16473    department_detail    TABLE     z   CREATE TABLE public.department_detail (
    employee_id character varying(10),
    department_id character varying(10)
);
 %   DROP TABLE public.department_detail;
       public         heap    postgres    false            �            1259    16470    emp_position    TABLE     %  CREATE TABLE public.emp_position (
    epos_id character varying(10),
    epos_emp_id character varying(10),
    epos_pos_id character varying(10),
    epos_status character varying(10),
    epos_start_date date,
    epos_end_date date,
    epos_create_date date,
    epos_update_date date
);
     DROP TABLE public.emp_position;
       public         heap    postgres    false            �            1259    16465    employee    TABLE     �  CREATE TABLE public.employee (
    emp_id character varying(10),
    emp_name character varying(50),
    emp_lastname character varying(50),
    emp_birthday character varying(10),
    emp_status character varying(10),
    emp_idcard character varying(20),
    emp_create_date date,
    emp_update_date date,
    emp_mobile_no character varying(10),
    emp_email character varying(50),
    emp_address character varying(2000),
    emp_image text
);
    DROP TABLE public.employee;
       public         heap    postgres    false            �            1259    16455    employee_detail    TABLE     &  CREATE TABLE public.employee_detail (
    employee_id character varying(10),
    employee_name character varying(100),
    birthdate date,
    mobile_no character varying(10),
    email character varying(50),
    start_date date,
    terminate_date date,
    address character varying(2000)
);
 #   DROP TABLE public.employee_detail;
       public         heap    postgres    false            �            1259    16451    position    TABLE     �   CREATE TABLE public."position" (
    pos_id character varying(10),
    pos_dept_id character varying(10),
    pos_name character varying(100),
    pos_create_date date,
    pos_update_date date
);
    DROP TABLE public."position";
       public         heap    postgres    false                      0    16479    deparement_head 
   TABLE DATA           E   COPY public.deparement_head (department_id, employee_id) FROM stdin;
    public          postgres    false    221                    0    16476 
   department 
   TABLE DATA           k   COPY public.department (dept_id, dept_name, dept_create_date, dept_update_date, dept_org_code) FROM stdin;
    public          postgres    false    220   I                 0    16473    department_detail 
   TABLE DATA           G   COPY public.department_detail (employee_id, department_id) FROM stdin;
    public          postgres    false    219   S                 0    16470    emp_position 
   TABLE DATA           �   COPY public.emp_position (epos_id, epos_emp_id, epos_pos_id, epos_status, epos_start_date, epos_end_date, epos_create_date, epos_update_date) FROM stdin;
    public          postgres    false    218   �                 0    16465    employee 
   TABLE DATA           �   COPY public.employee (emp_id, emp_name, emp_lastname, emp_birthday, emp_status, emp_idcard, emp_create_date, emp_update_date, emp_mobile_no, emp_email, emp_address, emp_image) FROM stdin;
    public          postgres    false    217   �                 0    16455    employee_detail 
   TABLE DATA           �   COPY public.employee_detail (employee_id, employee_name, birthdate, mobile_no, email, start_date, terminate_date, address) FROM stdin;
    public          postgres    false    216   �                 0    16451    position 
   TABLE DATA           e   COPY public."position" (pos_id, pos_dept_id, pos_name, pos_create_date, pos_update_date) FROM stdin;
    public          postgres    false    215   �          4   x�%Ʊ  ���B[(���D�'�ke�7�tS-���n����{�&�.�F         �   x�}�AKQ���~Ŭ�of4�n�������Z�S&��-B��$!� :�ߜ�қ;(=��p���=G�( ���bI; ��1툘�ﺯ��%>�����&�u�Tu�]�.[M�u�U��KQ2��ɥ���H+����+���⃘I]�#�dՄU8^;ex�3Yxy����Ϋ���~�#ދ��,!�Տ�S�2НT���ɑ��O�8������8\��jf:�g�J�6i�ۿ1�~ˉj�)�~ �B         @   x�E�K
  �us�h����,���B$�k8	1�Y,d+Y�N6q�]�o��韸g+��'�            x������ � �            x������ � �         �   x�U���0�s2�N�6Kt�,B*�p�#p�8�TU˳�%�}xB�����[�|��d�h(�E�Qpĭ�E�,F�9�a0��+sA#`<�N�	�ӡ	�\�t`���M �(�X�������F�=�v35�@Ӄ�$e�h0i����Y&e_h��2�=fe>`r��ef4��r������ņ         >   x�0000�400�v�4202�50�5�@br ���8�SbTb��O�	XI .%1z\\\ p��     