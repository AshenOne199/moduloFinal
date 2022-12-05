/*==============================================================*/
/* DBMS name:      ORACLE Version 11g                           */
/* Created on:     12/3/2022 12:47:07 PM                        */
/*==============================================================*/


alter table AIPORT
   drop constraint FK_AIPORT_PLACE_AIR_PLACE;

alter table AIPORT
   drop constraint FK_AIPORT_TYPE_AIRP_AIRPORTT;

alter table AIRLINE
   drop constraint FK_AIRLINE_PLACE_AIR_PLACE;

alter table CONNECTIONS
   drop constraint FK_CONNECTI_CONEXIOND_FLIGHTSE;

alter table CONNECTIONS
   drop constraint FK_CONNECTI_CONEXIONO_FLIGHTSE;

alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_AIRLINE_E_AIRLINE;

alter table EMPLOYEE
   drop constraint FK_EMPLOYEE_RELATIONS_PERSON;

alter table FLIGHT
   drop constraint FK_FLIGHT_AIRLINE_F_AIRLINE;

alter table FLIGHTSEGMENT
   drop constraint FK_FLIGHTSE_DESTINO_AIPORT;

alter table FLIGHTSEGMENT
   drop constraint FK_FLIGHTSE_FLIGHT_SE_FLIGHT;

alter table FLIGHTSEGMENT
   drop constraint FK_FLIGHTSE_ORIGEN_AIPORT;

alter table GROUNCREW
   drop constraint FK_GROUNCRE_PERSON_GR_PERSON;

alter table PASSANGER
   drop constraint FK_PASSANGE_PERSON_PA_PERSON;

alter table PERSON
   drop constraint FK_PERSON_PLACE_PER_PLACE;

alter table PILOT
   drop constraint FK_PILOT_RELATIONS_EMPLOYEE;

alter table PILOTASSGIMENT
   drop constraint FK_PILOTASS_PILOT_ASS_PILOT;

alter table PILOTASSGIMENT
   drop constraint FK_PILOTASS_SEGMENT_P_FLIGHTSE;

alter table PLACE
   drop constraint FK_PLACE_CIUDAD_PLACE;

alter table PLACE
   drop constraint FK_PLACE_PAIS_PLACE;

alter table PLACE
   drop constraint FK_PLACE_PLACETYPE_PLACETYP;

drop index TYPE_AIRPORT_FK;

drop index PLACE_AIRPORT_FK;

drop table AIPORT cascade constraints;

drop index PLACE_AIRLINE_FK;

drop table AIRLINE cascade constraints;

drop table AIRPORTTYPE cascade constraints;

drop index CONEXIONORIGEN_FK;

drop index CONEXIONDESTINO_FK;

drop table CONNECTIONS cascade constraints;

drop index AIRLINE_EMPLOYEE_FK;

drop index RELATIONSHIP_7_FK;

drop table EMPLOYEE cascade constraints;

drop index AIRLINE_FLIGHT_FK;

drop table FLIGHT cascade constraints;

drop index FLIGHT_SEGMENT_FK;

drop index DESTINO_FK;

drop index ORIGEN_FK;

drop table FLIGHTSEGMENT cascade constraints;

drop index PERSON_GROUNDCREW_FK;

drop table GROUNCREW cascade constraints;

drop index PERSON_PASSANGER_FK;

drop table PASSANGER cascade constraints;

drop index PLACE_PERSON_FK;

drop table PERSON cascade constraints;

drop index RELATIONSHIP_10_FK;

drop table PILOT cascade constraints;

drop index SEGMENT_PILOT_FK;

drop index PILOT_ASSIGMENT_FK;

drop table PILOTASSGIMENT cascade constraints;

drop index CIUDAD_FK;

drop index PAIS_FK;

drop index PLACETYPE_PLACE_FK;

drop table PLACE cascade constraints;

drop table PLACETYPE cascade constraints;

/*==============================================================*/
/* Table: AIPORT                                                */
/*==============================================================*/
create table AIPORT 
(
   AIRPORTCODE          VARCHAR2(100)        not null,
   IDPLACEAIRPORTFK     VARCHAR2(100),
   AIRPORTTYPEFK        VARCHAR2(100)        not null,
   AIPORTNAME           VARCHAR2(100)        not null,
   constraint PK_AIPORT primary key (AIRPORTCODE)
);

/*==============================================================*/
/* Index: PLACE_AIRPORT_FK                                      */
/*==============================================================*/
create index PLACE_AIRPORT_FK on AIPORT (
   IDPLACEAIRPORTFK ASC
);

/*==============================================================*/
/* Index: TYPE_AIRPORT_FK                                       */
/*==============================================================*/
create index TYPE_AIRPORT_FK on AIPORT (
   AIRPORTTYPEFK ASC
);

/*==============================================================*/
/* Table: AIRLINE                                               */
/*==============================================================*/
create table AIRLINE 
(
   AIRLINECODE          VARCHAR2(100)        not null,
   IDPLACEAIRLINEFK     VARCHAR2(100)        not null,
   AIRLINENAME          VARCHAR2(100)        not null,
   constraint PK_AIRLINE primary key (AIRLINECODE)
);

/*==============================================================*/
/* Index: PLACE_AIRLINE_FK                                      */
/*==============================================================*/
create index PLACE_AIRLINE_FK on AIRLINE (
   IDPLACEAIRLINEFK ASC
);

/*==============================================================*/
/* Table: AIRPORTTYPE                                           */
/*==============================================================*/
create table AIRPORTTYPE 
(
   AIRPORTTYPE          VARCHAR2(100)        not null,
   DESCTYPE             VARCHAR2(100)        not null,
   constraint PK_AIRPORTTYPE primary key (AIRPORTTYPE)
);

/*==============================================================*/
/* Table: CONNECTIONS                                           */
/*==============================================================*/
create table CONNECTIONS 
(
   IDCONEXIONES         VARCHAR2(100)        not null,
   ORIGEN_AIRLINECODESEGMENTFK VARCHAR2(100),
   ORIGEN_FLIGHTNUMBERSEGMENTFK VARCHAR2(100),
   ORIGENI_AIRPORTCODEDESTINOFK VARCHAR2(100),
   ORIGEN_IDSEGMENT     VARCHAR2(100),
   DESTINO_AIRLINECODESEGMENTFK VARCHAR2(100),
   DESTINO_FLIGHTNUMBERSEGMENTFK VARCHAR2(100),
   DESTINO_AIRPORTCODEDESTINOFK VARCHAR2(100),
   DESTINO_IDSEGMENT    VARCHAR2(100),
   constraint PK_CONNECTIONS primary key (IDCONEXIONES)
);

/*==============================================================*/
/* Index: CONEXIONDESTINO_FK                                    */
/*==============================================================*/
create index CONEXIONDESTINO_FK on CONNECTIONS (
   DESTINO_AIRLINECODESEGMENTFK ASC,
   DESTINO_FLIGHTNUMBERSEGMENTFK ASC,
   DESTINO_AIRPORTCODEDESTINOFK ASC,
   DESTINO_IDSEGMENT ASC
);

/*==============================================================*/
/* Index: CONEXIONORIGEN_FK                                     */
/*==============================================================*/
create index CONEXIONORIGEN_FK on CONNECTIONS (
   ORIGEN_AIRLINECODESEGMENTFK ASC,
   ORIGEN_FLIGHTNUMBERSEGMENTFK ASC,
   ORIGENI_AIRPORTCODEDESTINOFK ASC,
   ORIGEN_IDSEGMENT ASC
);

/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
create table EMPLOYEE 
(
   EMPLOYEENUMBER       VARCHAR2(100)        not null,
   AIRLINECODE          VARCHAR2(100)        not null,
   IDPERSONEMPLOYEEFK   VARCHAR2(100),
   DATEHIRED            DATE                 not null,
   constraint PK_EMPLOYEE primary key (AIRLINECODE, EMPLOYEENUMBER)
);

/*==============================================================*/
/* Index: RELATIONSHIP_7_FK                                     */
/*==============================================================*/
create index RELATIONSHIP_7_FK on EMPLOYEE (
   IDPERSONEMPLOYEEFK ASC
);

/*==============================================================*/
/* Index: AIRLINE_EMPLOYEE_FK                                   */
/*==============================================================*/
create index AIRLINE_EMPLOYEE_FK on EMPLOYEE (
   AIRLINECODE ASC
);

/*==============================================================*/
/* Table: FLIGHT                                                */
/*==============================================================*/
create table FLIGHT 
(
   FLIGHTNUMBER         VARCHAR2(100)        not null,
   AIRLINECODEFK        VARCHAR2(100)        not null,
   constraint PK_FLIGHT primary key (AIRLINECODEFK, FLIGHTNUMBER)
);

/*==============================================================*/
/* Index: AIRLINE_FLIGHT_FK                                     */
/*==============================================================*/
create index AIRLINE_FLIGHT_FK on FLIGHT (
   AIRLINECODEFK ASC
);

/*==============================================================*/
/* Table: FLIGHTSEGMENT                                         */
/*==============================================================*/
create table FLIGHTSEGMENT 
(
   IDSEGMENT            VARCHAR2(100)        not null,
   AIRLINECODESEGMENTFK VARCHAR2(100)        not null,
   FLIGHTNUMBERSEGMENTFK VARCHAR2(100)        not null,
   AIRPORTCODEDESTINOFK VARCHAR2(100)        not null,
   AIRPORTCODEORIGENFK  VARCHAR2(100)        not null,
   IDTRAYECTO           VARCHAR2(100)        not null,
   constraint PK_FLIGHTSEGMENT primary key (AIRLINECODESEGMENTFK, FLIGHTNUMBERSEGMENTFK, AIRPORTCODEDESTINOFK, IDSEGMENT)
);

/*==============================================================*/
/* Index: ORIGEN_FK                                             */
/*==============================================================*/
create index ORIGEN_FK on FLIGHTSEGMENT (
   AIRPORTCODEORIGENFK ASC
);

/*==============================================================*/
/* Index: DESTINO_FK                                            */
/*==============================================================*/
create index DESTINO_FK on FLIGHTSEGMENT (
   AIRPORTCODEDESTINOFK ASC
);

/*==============================================================*/
/* Index: FLIGHT_SEGMENT_FK                                     */
/*==============================================================*/
create index FLIGHT_SEGMENT_FK on FLIGHTSEGMENT (
   AIRLINECODESEGMENTFK ASC,
   FLIGHTNUMBERSEGMENTFK ASC
);

/*==============================================================*/
/* Table: GROUNCREW                                             */
/*==============================================================*/
create table GROUNCREW 
(
   IDCREW               VARCHAR2(100)        not null,
   IDPERSONCREWFK       VARCHAR2(100),
   constraint PK_GROUNCREW primary key (IDCREW)
);

/*==============================================================*/
/* Index: PERSON_GROUNDCREW_FK                                  */
/*==============================================================*/
create index PERSON_GROUNDCREW_FK on GROUNCREW (
   IDPERSONCREWFK ASC
);

/*==============================================================*/
/* Table: PASSANGER                                             */
/*==============================================================*/
create table PASSANGER 
(
   IDPASSANGER          VARCHAR2(100)        not null,
   IDPERSONPASSANGERFK  VARCHAR2(100)        not null,
   constraint PK_PASSANGER primary key (IDPASSANGER)
);

/*==============================================================*/
/* Index: PERSON_PASSANGER_FK                                   */
/*==============================================================*/
create index PERSON_PASSANGER_FK on PASSANGER (
   IDPERSONPASSANGERFK ASC
);

/*==============================================================*/
/* Table: PERSON                                                */
/*==============================================================*/
create table PERSON 
(
   IDPERSON             VARCHAR2(100)        not null,
   IDPLACEPERSONFK      VARCHAR2(100),
   FIRST_NAME           VARCHAR2(100)        not null,
   LAST_NAME            VARCHAR2(100)        not null,
   constraint PK_PERSON primary key (IDPERSON)
);

/*==============================================================*/
/* Index: PLACE_PERSON_FK                                       */
/*==============================================================*/
create index PLACE_PERSON_FK on PERSON (
   IDPLACEPERSONFK ASC
);

/*==============================================================*/
/* Table: PILOT                                                 */
/*==============================================================*/
create table PILOT 
(
   PILOTLICENSE         VARCHAR2(100)        not null,
   AIRLINECODEPILOTFK   VARCHAR2(100),
   EMPLOYEENUMBERPILOTFK VARCHAR2(100),
   PLIOTLICENSEEXPIRATION DATE                 not null,
   constraint PK_PILOT primary key (PILOTLICENSE)
);

/*==============================================================*/
/* Index: RELATIONSHIP_10_FK                                    */
/*==============================================================*/
create index RELATIONSHIP_10_FK on PILOT (
   AIRLINECODEPILOTFK ASC,
   EMPLOYEENUMBERPILOTFK ASC
);

/*==============================================================*/
/* Table: PILOTASSGIMENT                                        */
/*==============================================================*/
create table PILOTASSGIMENT 
(
   IDPILOTASSGIMENT     VARCHAR2(100)        not null,
   AIRLINECODESEGMENT_PILOTFK VARCHAR2(100)        not null,
   FLIGHTNUMBERSEGMENT_PILOTFK VARCHAR2(100)        not null,
   AIRPORTCODEDESTINO_PILOTFK VARCHAR2(100)        not null,
   IDSEGMENTFK          VARCHAR2(100)        not null,
   PILOTLICENSEFK       VARCHAR2(100)        not null,
   constraint PK_PILOTASSGIMENT primary key (AIRLINECODESEGMENT_PILOTFK, FLIGHTNUMBERSEGMENT_PILOTFK, AIRPORTCODEDESTINO_PILOTFK, IDSEGMENTFK, PILOTLICENSEFK, IDPILOTASSGIMENT)
);

/*==============================================================*/
/* Index: PILOT_ASSIGMENT_FK                                    */
/*==============================================================*/
create index PILOT_ASSIGMENT_FK on PILOTASSGIMENT (
   PILOTLICENSEFK ASC
);

/*==============================================================*/
/* Index: SEGMENT_PILOT_FK                                      */
/*==============================================================*/
create index SEGMENT_PILOT_FK on PILOTASSGIMENT (
   AIRLINECODESEGMENT_PILOTFK ASC,
   FLIGHTNUMBERSEGMENT_PILOTFK ASC,
   AIRPORTCODEDESTINO_PILOTFK ASC,
   IDSEGMENTFK ASC
);

/*==============================================================*/
/* Table: PLACE                                                 */
/*==============================================================*/
create table PLACE 
(
   IDPLACE              VARCHAR2(100)        not null,
   IDPLACETYPEFK        VARCHAR2(100)        not null,
   PAIS_FK              VARCHAR2(100),
   CIUDAD_FK            VARCHAR2(100),
   PLACENAME            VARCHAR2(100)        not null,
   constraint PK_PLACE primary key (IDPLACE)
);

/*==============================================================*/
/* Index: PLACETYPE_PLACE_FK                                    */
/*==============================================================*/
create index PLACETYPE_PLACE_FK on PLACE (
   IDPLACETYPEFK ASC
);

/*==============================================================*/
/* Index: PAIS_FK                                               */
/*==============================================================*/
create index PAIS_FK on PLACE (
   PAIS_FK ASC
);

/*==============================================================*/
/* Index: CIUDAD_FK                                             */
/*==============================================================*/
create index CIUDAD_FK on PLACE (
   CIUDAD_FK ASC
);

/*==============================================================*/
/* Table: PLACETYPE                                             */
/*==============================================================*/
create table PLACETYPE 
(
   IDPLACETYPE          VARCHAR2(100)        not null,
   DESPLACETYPE         VARCHAR2(100)        not null,
   constraint PK_PLACETYPE primary key (IDPLACETYPE)
);

alter table AIPORT
   add constraint FK_AIPORT_PLACE_AIR_PLACE foreign key (IDPLACEAIRPORTFK)
      references PLACE (IDPLACE);

alter table AIPORT
   add constraint FK_AIPORT_TYPE_AIRP_AIRPORTT foreign key (AIRPORTTYPEFK)
      references AIRPORTTYPE (AIRPORTTYPE);

alter table AIRLINE
   add constraint FK_AIRLINE_PLACE_AIR_PLACE foreign key (IDPLACEAIRLINEFK)
      references PLACE (IDPLACE);

alter table CONNECTIONS
   add constraint FK_CONNECTI_CONEXIOND_FLIGHTSE foreign key (DESTINO_AIRLINECODESEGMENTFK, DESTINO_FLIGHTNUMBERSEGMENTFK, DESTINO_AIRPORTCODEDESTINOFK, DESTINO_IDSEGMENT)
      references FLIGHTSEGMENT (AIRLINECODESEGMENTFK, FLIGHTNUMBERSEGMENTFK, AIRPORTCODEDESTINOFK, IDSEGMENT);

alter table CONNECTIONS
   add constraint FK_CONNECTI_CONEXIONO_FLIGHTSE foreign key (ORIGEN_AIRLINECODESEGMENTFK, ORIGEN_FLIGHTNUMBERSEGMENTFK, ORIGENI_AIRPORTCODEDESTINOFK, ORIGEN_IDSEGMENT)
      references FLIGHTSEGMENT (AIRLINECODESEGMENTFK, FLIGHTNUMBERSEGMENTFK, AIRPORTCODEDESTINOFK, IDSEGMENT);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_AIRLINE_E_AIRLINE foreign key (AIRLINECODE)
      references AIRLINE (AIRLINECODE);

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_RELATIONS_PERSON foreign key (IDPERSONEMPLOYEEFK)
      references PERSON (IDPERSON);

alter table FLIGHT
   add constraint FK_FLIGHT_AIRLINE_F_AIRLINE foreign key (AIRLINECODEFK)
      references AIRLINE (AIRLINECODE);

alter table FLIGHTSEGMENT
   add constraint FK_FLIGHTSE_DESTINO_AIPORT foreign key (AIRPORTCODEDESTINOFK)
      references AIPORT (AIRPORTCODE);

alter table FLIGHTSEGMENT
   add constraint FK_FLIGHTSE_FLIGHT_SE_FLIGHT foreign key (AIRLINECODESEGMENTFK, FLIGHTNUMBERSEGMENTFK)
      references FLIGHT (AIRLINECODEFK, FLIGHTNUMBER);

alter table FLIGHTSEGMENT
   add constraint FK_FLIGHTSE_ORIGEN_AIPORT foreign key (AIRPORTCODEORIGENFK)
      references AIPORT (AIRPORTCODE);

alter table GROUNCREW
   add constraint FK_GROUNCRE_PERSON_GR_PERSON foreign key (IDPERSONCREWFK)
      references PERSON (IDPERSON);

alter table PASSANGER
   add constraint FK_PASSANGE_PERSON_PA_PERSON foreign key (IDPERSONPASSANGERFK)
      references PERSON (IDPERSON);

alter table PERSON
   add constraint FK_PERSON_PLACE_PER_PLACE foreign key (IDPLACEPERSONFK)
      references PLACE (IDPLACE);

alter table PILOT
   add constraint FK_PILOT_RELATIONS_EMPLOYEE foreign key (AIRLINECODEPILOTFK, EMPLOYEENUMBERPILOTFK)
      references EMPLOYEE (AIRLINECODE, EMPLOYEENUMBER);

alter table PILOTASSGIMENT
   add constraint FK_PILOTASS_PILOT_ASS_PILOT foreign key (PILOTLICENSEFK)
      references PILOT (PILOTLICENSE);

alter table PILOTASSGIMENT
   add constraint FK_PILOTASS_SEGMENT_P_FLIGHTSE foreign key (AIRLINECODESEGMENT_PILOTFK, FLIGHTNUMBERSEGMENT_PILOTFK, AIRPORTCODEDESTINO_PILOTFK, IDSEGMENTFK)
      references FLIGHTSEGMENT (AIRLINECODESEGMENTFK, FLIGHTNUMBERSEGMENTFK, AIRPORTCODEDESTINOFK, IDSEGMENT);

alter table PLACE
   add constraint FK_PLACE_CIUDAD_PLACE foreign key (CIUDAD_FK)
      references PLACE (IDPLACE);

alter table PLACE
   add constraint FK_PLACE_PAIS_PLACE foreign key (PAIS_FK)
      references PLACE (IDPLACE);

alter table PLACE
   add constraint FK_PLACE_PLACETYPE_PLACETYP foreign key (IDPLACETYPEFK)
      references PLACETYPE (IDPLACETYPE);

