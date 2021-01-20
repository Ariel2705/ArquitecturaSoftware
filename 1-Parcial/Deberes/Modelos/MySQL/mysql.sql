/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     06/01/2021 12:01:48                          */
/*==============================================================*/


drop table if exists CANTON;

drop table if exists DEFUNCION;

drop table if exists FIRMA_ELECTRONICA;

drop table if exists ISO_PAIS;

drop table if exists MATRIMONIO;

drop table if exists NACIMIENTO;

drop table if exists PARROQUIA;

drop table if exists PERSONA;

drop table if exists PERSONA_NACIMIENTO;

drop table if exists PROVINCIA;

/*==============================================================*/
/* Table: CANTON                                                */
/*==============================================================*/
create table CANTON
(
   COD_CANTON           int not null auto_increment,
   COD_PROVINCIA        varchar(2),
   NOMBRE_CANTON        varchar(32) not null,
   primary key (COD_CANTON)
);

/*==============================================================*/
/* Table: DEFUNCION                                             */
/*==============================================================*/
create table DEFUNCION
(
   COD_DEFUNCION        int not null auto_increment,
   COD_PARROQUIA        int not null,
   COD_PERSONA          int not null,
   EDAD_FALLECIDO       int not null,
   FECHA_DEFUNCION      date not null,
   HORA_DEFUNCION       time not null,
   MOTIVO_DEFUNCION     varchar(64) not null,
   primary key (COD_DEFUNCION)
);

/*==============================================================*/
/* Table: FIRMA_ELECTRONICA                                     */
/*==============================================================*/
create table FIRMA_ELECTRONICA
(
   COD_FIRMA_ELECTRONICA int not null auto_increment,
   COD_PARROQUIA        int not null,
   COD_PERSONA          int not null,
   EMAIL                varchar(32) not null,
   TIPO_FIRMA           varchar(3) not null,
   FECHA_CREACION       date not null,
   FECHA_CADUCIDAD      date not null,
   CLAVE                varchar(32) not null,
   primary key (COD_FIRMA_ELECTRONICA)
);

/*==============================================================*/
/* Table: ISO_PAIS                                              */
/*==============================================================*/
create table ISO_PAIS
(
   COD_PAIS             varchar(3) not null comment 'Codigo ISO ALPHA-3',
   NOMBRE               varchar(64) not null,
   COD_ALTERNO          varchar(3) not null,
   primary key (COD_PAIS)
);

/*==============================================================*/
/* Table: MATRIMONIO                                            */
/*==============================================================*/
create table MATRIMONIO
(
   COD_MATRIMONIO       int not null auto_increment,
   COD_PERSONA          int not null,
   COD_PARROQUIA        int not null,
   FECHA_REGISTRO       date not null,
   ESTADO               varchar(3) not null,
   CONYUGE              int not null,
   primary key (COD_MATRIMONIO)
);

/*==============================================================*/
/* Table: NACIMIENTO                                            */
/*==============================================================*/
create table NACIMIENTO
(
   COD_NACIMIENTO       int not null auto_increment,
   COD_PARROQUIA        int not null,
   FECHA_REGISTRO       date not null,
   HORA_NACIMIENTO      time not null,
   primary key (COD_NACIMIENTO)
);

/*==============================================================*/
/* Table: PARROQUIA                                             */
/*==============================================================*/
create table PARROQUIA
(
   COD_PARROQUIA        int not null auto_increment,
   COD_CANTON           int,
   NOMBRE_PARROQUIA     varchar(32) not null,
   primary key (COD_PARROQUIA)
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA
(
   COD_PERSONA          int not null auto_increment,
   COD_PAIS             varchar(3) not null comment 'Codigo ISO ALPHA-3',
   CEDULA_IDENTIDAD     varchar(10) not null,
   APELLIDOS            varchar(32) not null,
   NOMBRES              varchar(32) not null,
   GENERO               varchar(3) not null,
   CODIGO_DACTILAR      varchar(10),
   ESTADO_CIVIL         varchar(3) not null default 'SOL',
   FECHA_NACIMIENTO     date not null,
   primary key (COD_PERSONA)
);

/*==============================================================*/
/* Table: PERSONA_NACIMIENTO                                    */
/*==============================================================*/
create table PERSONA_NACIMIENTO
(
   COD_PERSONA_NACIMIENTO int not null auto_increment,
   COD_PERSONA          int not null,
   COD_NACIMIENTO       int not null,
   COD_MADRE            int,
   COD_PADRE            int,
   COD_EMISOR           int not null,
   primary key (COD_PERSONA_NACIMIENTO)
);

/*==============================================================*/
/* Table: PROVINCIA                                             */
/*==============================================================*/
create table PROVINCIA
(
   COD_PROVINCIA        varchar(2) not null,
   COD_PAIS             varchar(3) not null comment 'Codigo ISO ALPHA-3',
   NOMBRE_PROVINCIA     varchar(32) not null,
   primary key (COD_PROVINCIA)
);

alter table CANTON add constraint FK_CANTON_A_PROVINCIA foreign key (COD_PROVINCIA)
      references PROVINCIA (COD_PROVINCIA) on delete restrict on update restrict;

alter table DEFUNCION add constraint FK_DEFUNCION_A_PARROQUIA foreign key (COD_PARROQUIA)
      references PARROQUIA (COD_PARROQUIA) on delete restrict on update restrict;

alter table DEFUNCION add constraint FK_REFERENCE_11 foreign key (COD_PERSONA)
      references PERSONA (COD_PERSONA) on delete restrict on update restrict;

alter table FIRMA_ELECTRONICA add constraint FK_FIRMA_A_PARROQUIA foreign key (COD_PARROQUIA)
      references PARROQUIA (COD_PARROQUIA) on delete restrict on update restrict;

alter table FIRMA_ELECTRONICA add constraint FK_FIRMA_A_PERSONA foreign key (COD_PERSONA)
      references PERSONA (COD_PERSONA) on delete restrict on update restrict;

alter table MATRIMONIO add constraint FK_MATRIMONIO_A_PARROQUIA foreign key (COD_PARROQUIA)
      references PARROQUIA (COD_PARROQUIA) on delete restrict on update restrict;

alter table MATRIMONIO add constraint FK_MATRIMONIO_A_PERSONA foreign key (COD_PERSONA)
      references PERSONA (COD_PERSONA) on delete restrict on update restrict;

alter table NACIMIENTO add constraint FK_NACIMIENTO_A_PARROQUIA foreign key (COD_PARROQUIA)
      references PARROQUIA (COD_PARROQUIA) on delete restrict on update restrict;

alter table PARROQUIA add constraint FK_PARROQUIA_A_CANTON foreign key (COD_CANTON)
      references CANTON (COD_CANTON) on delete restrict on update restrict;

alter table PERSONA add constraint FK_PERSONA_A_PAIS foreign key (COD_PAIS)
      references ISO_PAIS (COD_PAIS) on delete restrict on update restrict;

alter table PERSONA_NACIMIENTO add constraint FK_PERNACIMIENTO_A_NACIMIENTO foreign key (COD_NACIMIENTO)
      references NACIMIENTO (COD_NACIMIENTO) on delete restrict on update restrict;

alter table PERSONA_NACIMIENTO add constraint FK_PERNACIMIENTO_A_PERSONA foreign key (COD_PERSONA)
      references PERSONA (COD_PERSONA) on delete restrict on update restrict;

alter table PROVINCIA add constraint FK_PROVINCIA_A_PAIS foreign key (COD_PAIS)
      references ISO_PAIS (COD_PAIS) on delete restrict on update restrict;

