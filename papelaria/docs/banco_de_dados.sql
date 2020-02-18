CREATE TABLE USUARIOS(
                id 			NUMBER(5)      PRIMARY KEY ,
                nome 			VARCHAR(30) NOT NULL,
                senha 			VARCHAR(10) NOT NULL,
                email 			VARCHAR(30) 		,
				superusuario 	VARCHAR(1)	NOT NULL
		
);

CREATE SEQUENCE USUARIOS_SEQ  MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  CYCLE ;

INSERT INTO "USUARIOS" (id, nome, senha, email,superusuario) VALUES(USUARIOS_SEQ.NEXTVAL, 'mkyong','abcde09876', '111@yahoo.com', 'S');
