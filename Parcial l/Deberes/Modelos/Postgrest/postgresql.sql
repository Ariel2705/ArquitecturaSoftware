/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     06/01/2021 12:06:09                          */
/*==============================================================*/


drop index IDX_COD_CANTON;

drop table CANTON;

drop index IDX_DEFUNCION;

drop table DEFUNCION;

drop index IDX_FIRMA_ELECTRONICA;

drop table FIRMA_ELECTRONICA;

drop index IDX_COD_PAIS;

drop table ISO_PAIS;

drop index IDX_MATRIMONIO;

drop table MATRIMONIO;

drop index IDX_NACIONALIDAD;

drop table NACIMIENTO;

drop index IDX_COD_PARROQUIA;

drop table PARROQUIA;

drop index IDX_PERSONA_CEDULA;

drop table PERSONA;

drop index IDX_PERSONA_NACIMIENTO;

drop table PERSONA_NACIMIENTO;

drop index IDX_COD_PROVINCIA;

drop table PROVINCIA;

/*==============================================================*/
/* Table: CANTON                                                */
/*==============================================================*/
create table CANTON (
   COD_CANTON           SERIAL               not null,
   COD_PROVINCIA        VARCHAR(2)           null,
   NOMBRE_CANTON        VARCHAR(32)          not null,
   constraint PK_CANTON primary key (COD_CANTON)
);

/*==============================================================*/
/* Index: IDX_COD_CANTON                                        */
/*==============================================================*/
create unique index IDX_COD_CANTON on CANTON (
COD_CANTON
);

/*==============================================================*/
/* Table: DEFUNCION                                             */
/*==============================================================*/
create table DEFUNCION (
   COD_DEFUNCION        SERIAL               not null,
   LUGAR_DEFUNCION      INT4                 not null,
   COD_PERSONA          INT4                 not null,
   EDAD_FALLECIDO       INT4                 not null,
   FECHA_DEFUNCION      DATE                 not null,
   HORA_DEFUNCION       TIME                 not null,
   MOTIVO_DEFUNCION     VARCHAR(64)          not null,
   constraint PK_DEFUNCION primary key (COD_DEFUNCION)
);

/*==============================================================*/
/* Index: IDX_DEFUNCION                                         */
/*==============================================================*/
create unique index IDX_DEFUNCION on DEFUNCION (
COD_DEFUNCION
);

/*==============================================================*/
/* Table: FIRMA_ELECTRONICA                                     */
/*==============================================================*/
create table FIRMA_ELECTRONICA (
   COD_FIRMA_ELECTRONICA SERIAL               not null,
   COD_PERSONA          INT4                 not null,
   COD_PARROQUIA        INT4                 not null,
   EMAIL                VARCHAR(32)          not null,
   TIPO_FIRMA           VARCHAR(3)           not null
      constraint CKC_TIPO_FIRMA_FIRMA_EL check (TIPO_FIRMA in ('TOK','ELE') and TIPO_FIRMA = upper(TIPO_FIRMA)),
   FECHA_CREACION       DATE                 not null,
   FECHA_CADUCIDAD      DATE                 not null,
   CLAVE                VARCHAR(32)          not null,
   constraint PK_FIRMA_ELECTRONICA primary key (COD_FIRMA_ELECTRONICA)
);

/*==============================================================*/
/* Index: IDX_FIRMA_ELECTRONICA                                 */
/*==============================================================*/
create unique index IDX_FIRMA_ELECTRONICA on FIRMA_ELECTRONICA (
COD_FIRMA_ELECTRONICA
);

/*==============================================================*/
/* Table: ISO_PAIS                                              */
/*==============================================================*/
create table ISO_PAIS (
   COD_PAIS             VARCHAR(3)           not null,
   NOMBRE               VARCHAR(64)          not null,
   COD_ALTERNO          VARCHAR(3)           not null,
   constraint PK_ISO_PAIS primary key (COD_PAIS)
);

comment on column ISO_PAIS.COD_PAIS is
'Codigo ISO ALPHA-3';

/*==============================================================*/
/* Index: IDX_COD_PAIS                                          */
/*==============================================================*/
create unique index IDX_COD_PAIS on ISO_PAIS (
COD_PAIS
);

/*==============================================================*/
/* Table: MATRIMONIO                                            */
/*==============================================================*/
create table MATRIMONIO (
   COD_MATRIMONIO       SERIAL               not null,
   COD_PARROQUIA        INT4                 not null,
   COD_PERSONA          INT4                 not null,
   FECHA_REGISTRO       DATE                 not null,
   ESTADO               VARCHAR(3)           not null
      constraint CKC_ESTADO_MATRIMON check (ESTADO in ('VAL','INV') and ESTADO = upper(ESTADO)),
   CONYUGE              INT4                 not null,
   constraint PK_MATRIMONIO primary key (COD_MATRIMONIO)
);

/*==============================================================*/
/* Index: IDX_MATRIMONIO                                        */
/*==============================================================*/
create unique index IDX_MATRIMONIO on MATRIMONIO (
COD_MATRIMONIO
);

/*==============================================================*/
/* Table: NACIMIENTO                                            */
/*==============================================================*/
create table NACIMIENTO (
   COD_NACIMIENTO       SERIAL               not null,
   COD_PARROQUIA        INT4                 not null,
   FECHA_REGISTRO       DATE                 not null,
   HORA_NACIMIENTO      TIME                 not null,
   constraint PK_NACIMIENTO primary key (COD_NACIMIENTO)
);

/*==============================================================*/
/* Index: IDX_NACIONALIDAD                                      */
/*==============================================================*/
create unique index IDX_NACIONALIDAD on NACIMIENTO (
COD_NACIMIENTO
);

/*==============================================================*/
/* Table: PARROQUIA                                             */
/*==============================================================*/
create table PARROQUIA (
   COD_PARROQUIA        SERIAL               not null,
   COD_CANTON           INT4                 null,
   NOMBRE_PARROQUIA     VARCHAR(32)          not null,
   constraint PK_PARROQUIA primary key (COD_PARROQUIA)
);

/*==============================================================*/
/* Index: IDX_COD_PARROQUIA                                     */
/*==============================================================*/
create unique index IDX_COD_PARROQUIA on PARROQUIA (
COD_PARROQUIA
);

/*==============================================================*/
/* Table: PERSONA                                               */
/*==============================================================*/
create table PERSONA (
   COD_PERSONA          SERIAL               not null,
   NACIONALIDAD         VARCHAR(3)           not null,
   CEDULA_IDENTIDAD     VARCHAR(10)          not null,
   APELLIDOS            VARCHAR(32)          not null,
   NOMBRES              VARCHAR(32)          not null,
   GENERO               VARCHAR(3)           not null
      constraint CKC_GENERO_PERSONA check (GENERO in ('MAS','FEM','OTR') and GENERO = upper(GENERO)),
   CODIGO_DACTILAR      VARCHAR(10)          null,
   ESTADO_CIVIL         VARCHAR(3)           not null default 'SOL'
      constraint CKC_ESTADO_CIVIL_PERSONA check (ESTADO_CIVIL in ('SOL','CAS','DIV','VIU','UDH') and ESTADO_CIVIL = upper(ESTADO_CIVIL)),
   FECHA_NACIMIENTO     DATE                 not null,
   constraint PK_PERSONA primary key (COD_PERSONA)
);

comment on column PERSONA.NACIONALIDAD is
'Codigo ISO ALPHA-3';

/*==============================================================*/
/* Index: IDX_PERSONA_CEDULA                                    */
/*==============================================================*/
create unique index IDX_PERSONA_CEDULA on PERSONA (
CEDULA_IDENTIDAD
);

/*==============================================================*/
/* Table: PERSONA_NACIMIENTO                                    */
/*==============================================================*/
create table PERSONA_NACIMIENTO (
   COD_PERSONA_NACIMIENTO SERIAL               not null,
   COD_PERSONA          INT4                 not null,
   COD_NACIMIENTO       INT4                 not null,
   COD_MADRE            INT4                 null,
   COD_PADRE            INT4                 null,
   COD_EMISOR           INT4                 not null,
   constraint PK_PERSONA_NACIMIENTO primary key (COD_PERSONA_NACIMIENTO)
);

/*==============================================================*/
/* Index: IDX_PERSONA_NACIMIENTO                                */
/*==============================================================*/
create unique index IDX_PERSONA_NACIMIENTO on PERSONA_NACIMIENTO (
COD_PERSONA_NACIMIENTO
);

/*==============================================================*/
/* Table: PROVINCIA                                             */
/*==============================================================*/
create table PROVINCIA (
   COD_PROVINCIA        VARCHAR(2)           not null,
   COD_PAIS             VARCHAR(3)           not null,
   NOMBRE_PROVINCIA     VARCHAR(32)          not null,
   constraint PK_PROVINCIA primary key (COD_PROVINCIA)
);

comment on column PROVINCIA.COD_PAIS is
'Codigo ISO ALPHA-3';

/*==============================================================*/
/* Index: IDX_COD_PROVINCIA                                     */
/*==============================================================*/
create unique index IDX_COD_PROVINCIA on PROVINCIA (
COD_PROVINCIA
);

alter table CANTON
   add constraint FK_CANTON_A_PROVINCIA foreign key (COD_PROVINCIA)
      references PROVINCIA (COD_PROVINCIA)
      on delete restrict on update restrict;

alter table DEFUNCION
   add constraint FK_DEFUNCION_A_PARROQUIA foreign key (LUGAR_DEFUNCION)
      references PARROQUIA (COD_PARROQUIA)
      on delete restrict on update restrict;

alter table DEFUNCION
   add constraint FK_DEFUNCIO_REFERENCE_PERSONA foreign key (COD_PERSONA)
      references PERSONA (COD_PERSONA)
      on delete restrict on update restrict;

alter table FIRMA_ELECTRONICA
   add constraint FK_FIRMA_A_PARROQUIA foreign key (COD_PARROQUIA)
      references PARROQUIA (COD_PARROQUIA)
      on delete restrict on update restrict;

alter table FIRMA_ELECTRONICA
   add constraint FK_FIRMA_A_PERSONA foreign key (COD_PERSONA)
      references PERSONA (COD_PERSONA)
      on delete restrict on update restrict;

alter table MATRIMONIO
   add constraint FK_MATRIMONIO_A_PARROQUIA foreign key (COD_PARROQUIA)
      references PARROQUIA (COD_PARROQUIA)
      on delete restrict on update restrict;

alter table MATRIMONIO
   add constraint FK_MATRIMONIO_A_PERSONA foreign key (COD_PERSONA)
      references PERSONA (COD_PERSONA)
      on delete restrict on update restrict;

alter table NACIMIENTO
   add constraint FK_NACIMIENTO_A_PARROQUIA foreign key (COD_PARROQUIA)
      references PARROQUIA (COD_PARROQUIA)
      on delete restrict on update restrict;

alter table PARROQUIA
   add constraint FK_PARROQUIA_A_CANTON foreign key (COD_CANTON)
      references CANTON (COD_CANTON)
      on delete restrict on update restrict;

alter table PERSONA
   add constraint FK_PERSONA_A_PAIS foreign key (NACIONALIDAD)
      references ISO_PAIS (COD_PAIS)
      on delete restrict on update restrict;

alter table PERSONA_NACIMIENTO
   add constraint FK_PERNACIMIENTO_A_NACIMIENTO foreign key (COD_NACIMIENTO)
      references NACIMIENTO (COD_NACIMIENTO)
      on delete restrict on update restrict;

alter table PERSONA_NACIMIENTO
   add constraint FK_PERNACIMIENTO_A_PERSONA foreign key (COD_PERSONA)
      references PERSONA (COD_PERSONA)
      on delete restrict on update restrict;

alter table PROVINCIA
   add constraint FK_PROVINCIA_A_PAIS foreign key (COD_PAIS)
      references ISO_PAIS (COD_PAIS)
      on delete restrict on update restrict;

