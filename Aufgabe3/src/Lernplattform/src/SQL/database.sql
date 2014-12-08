CREATE TABLE LERNKARTE
(
       LERNKARTENID           NUMBER(11)    
,      LERNKARTENNAME         VARCHAR2(100)     NOT NULL
--,      LERNKARTENERSTELLER    VARCHAR2(100)
,      LERNKARTENFRAGE        VARCHAR2(1000) 
,      LERNKARTENANTWORT      VARCHAR2(1000) 
,      LERNKARTENMODUL        VARCHAR2(200)     NOT NULL
,      LERNKARTEUEBERPRUEFT   VARCHAR2(10)      NOT NULL 
,      PRIMARY KEY(LERNKARTENID)               
);

CREATE TABLE INUTZER
(
       NUTZERNAME             VARCHAR2(30)
,      NAME                   VARCHAR2(200)
,      LERNKARTENID           NUMBER(11)
,      EMAIL                  VARCHAR2(100)
,      NUTZERKENNUNG          VARCHAR2(6)
,      NUTZERID               NUMBER(11)                                               
);

CREATE TABLE MODUL
(
       MODULID                NUMBER(11)
,      MODULNAME              VARCHAR2(100)
,      MODULBESCHREIBUNG      VARCHAR2(2000)       
);
