DROP TABLE LERNKARTE;
DROP TABLE INUTZER;
DROP TABLE MODUL;

-- Tabelle der Nutzer -> INUTZER weil in meiner Datenbank schon ein NUTZER war den ich noch brauchte
CREATE TABLE INUTZER
(
       NUTZERNAME             VARCHAR2(30)
,      NAME                   VARCHAR2(200)
,      LERNKARTENID           NUMBER(11)
,      EMAIL                  VARCHAR2(100)
,      NUTZERKENNUNG          VARCHAR2(6)
,      NUTZERID               NUMBER(11)  
,      PRIMARY KEY(NUTZERID) 
--,      FOREIGN KEY(LERNKARTENID) REFERENCES LERNKARTE(LERNKARTENID)                                            
);

-- Tabelle der Lernkarte
CREATE TABLE LERNKARTE
(
       LERNKARTENID                             NUMBER(11)    
,      LERNKARTENNAME                           VARCHAR2(100)     NOT NULL
,      LERNKARTENERSTELLER                      NUMBER(11)        NOT NULL
,      LERNKARTENFRAGE                          VARCHAR2(1000) 
,      LERNKARTENANTWORT                        VARCHAR2(1000) 
,      LERNKARTENMODUL                          VARCHAR2(200)     NOT NULL
,      LERNKARTEUEBERPRUEFT                     VARCHAR2(10)      NOT NULL 
,      PRIMARY KEY(LERNKARTENID)  
,      FOREIGN KEY(LERNKARTENERSTELLER) REFERENCES INUTZER(NUTZERID)             
);



-- Eine Tabelle für Module, wird jedoch nicht genutzt zur Zeit, da erst einmal nur Modul in der Lernkarte steht
CREATE TABLE MODUL
(
       MODULID                NUMBER(11)
,      MODULNAME              VARCHAR2(100)
,      MODULBESCHREIBUNG      VARCHAR2(2000)       
);
