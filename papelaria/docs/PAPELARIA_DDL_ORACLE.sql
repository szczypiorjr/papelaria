---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------LOGADO COM USUARIO SYSTEM E PASSWORD ORACLE
--https://www.devmedia.com.br/criando-usuarios-e-liberando-privilegios-e-atribuicoes-no-oracle/26414
  ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  --TABLESPACES
 CREATE    TABLESPACE  TS_PAPELARIA 
					LOGGING DATAFILE 'C:\oraclexe\app\oracle\oradata\TS_PAPELARIA.dbf'          
						SIZE 100m AUTOEXTEND ON NEXT 100m EXTENT MANAGEMENT LOCAL  ;	
	
 CREATE  TEMPORARY   TABLESPACE  TS_PAPELARIA_TEMP 	 TEMPFILE  'C:\oraclexe\app\oracle\oradata\TS_PAPELARIA_TEMP.dbf' 
 SIZE 100m AUTOEXTEND ON NEXT 100m EXTENT MANAGEMENT LOCAL ;
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--USER
 
 CREATE USER PAPELARIA IDENTIFIED BY  PAPELARIA
DEFAULT TABLESPACE  TS_PAPELARIA
TEMPORARY TABLESPACE TS_PAPELARIA_TEMP;
  ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--VERIFICANDO
  SELECT
  USERNAME,
  DEFAULT_TABLESPACE,
  TEMPORARY_TABLESPACE
FROM
  DBA_USERS
WHERE
   USERNAME = 'PAPELARIA';
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--PRIVILEGES
GRANT ALL PRIVILEGES TO PAPELARIA;
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

---LOGADO E CONECTADO NO USUARIO PAPELARIA



--SEQUENCES
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE SEQUENCE  PRO_SEQ     MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 ;
CREATE SEQUENCE  CAT_SEQ      MINVALUE 1 MAXVALUE 9999999999 INCREMENT BY 1 START WITH 1 ;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--TABLES
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 CREATE TABLE CATEGORIA 
   (	ID NUMBER NOT NULL , 
	NOME VARCHAR2(30) NOT NULL , 
	 PRIMARY KEY (ID)
   ) ;
 ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
   CREATE TABLE PRODUTO
 (
	ID NUMBER NOT NULL , 
	COD_BARRAS VARCHAR2(13) NOT NULL , 
	DESCRICAO VARCHAR2(50) NOT NULL , 
	QUANTIDADE NUMBER  NOT NULL , 
	PRECO NUMBER(18,2) , 
	PRECO_COM_DESCONTO NUMBER(18,2) , 
    DESCONTO_PERCENTUAL NUMBER(18,2) ,
    NOME VARCHAR2(30) NOT NULL , 
	CATEGORIA_ID NUMBER  , 
	DETALHE VARCHAR(50) , 
	 PRIMARY KEY (ID),
	 CONSTRAINT FK_CATEGORIA 
    FOREIGN KEY (CATEGORIA_ID)
    REFERENCES CATEGORIA(ID)
   );

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------   
----NSERTS  CATEGORIA DE PRODUTOS
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------   
   INSERT INTO CATEGORIA 
   (ID,NOME)
   VALUES
   (CAT_SEQ.NEXTVAL,'MATERIAL ESCOLAR');
   
    INSERT INTO CATEGORIA 
   (ID,NOME)
   VALUES
   (CAT_SEQ.NEXTVAL,'MATERIAL ESCRITORIO');
   
   INSERT INTO CATEGORIA 
   (ID,NOME)
   VALUES
   (CAT_SEQ.NEXTVAL,'ELETRONICOS');
   
    INSERT INTO CATEGORIA 
   (ID,NOME)
   VALUES
   (CAT_SEQ.NEXTVAL,'OUTROS');
   
    INSERT INTO CATEGORIA 
   (ID,NOME)
   VALUES
   (CAT_SEQ.NEXTVAL,'CARTÕES PRÉ-PAGOS');
   
   INSERT INTO CATEGORIA 
   (ID,NOME)
   VALUES
   (CAT_SEQ.NEXTVAL,'VALE-PRESENTES');
   
   INSERT INTO CATEGORIA 
   (ID,NOME)
   VALUES
   (CAT_SEQ.NEXTVAL,'SOUVENIERS');
   
   INSERT INTO CATEGORIA 
   (ID,NOME)
   VALUES
   (CAT_SEQ.NEXTVAL,'CD/DVD');
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------   
----NSERTS PRODUTOS
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'0000000000','DESCRICAO PRODUTO A',000,00.00,00.00,00.00,'NOME  PRODUTO A',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='MATERIAL ESCRITORIO' ),'DETALHE  PRODUTO A');

INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'1111111111','DESCRICAO PRODUTO B',000,00.00,00.00,00.00,'NOME  PRODUTO B',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='MATERIAL ESCOLAR' ),'DETALHE  PRODUTO B');

INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'2222222222','DESCRICAO PRODUTO C',000,00.00,00.00,00.00,'NOME  PRODUTO C',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='ELETRONICOS' ),'DETALHE  PRODUTO C');

INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'3333333333','DESCRICAO PRODUTO D',000,00.00,00.00,00.00,'NOME  PRODUTO D',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='CD/DVD' ),'DETALHE  PRODUTO D');

INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'4444444444','DESCRICAO PRODUTO E',000,00.00,00.00,00.00,'NOME  PRODUTO E',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='SOUVENIERS' ),'DETALHE  PRODUTO E');

INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'5555555555','DESCRICAO PRODUTO F',000,00.00,00.00,00.00,'NOME  PRODUTO F',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='MATERIAL ESCRITORIO' ),'DETALHE  PRODUTO F');

INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'6666666666','DESCRICAO PRODUTO G',000,00.00,00.00,00.00,'NOME  PRODUTO G',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='CARTÕES PRÉ-PAGOS' ),'DETALHE  PRODUTO G');

INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'7777777777','DESCRICAO PRODUTO H',000,00.00,00.00,00.00,'NOME  PRODUTO H',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='ELETRONICOS' ),'DETALHE  PRODUTO H');

INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'8888888888','DESCRICAO PRODUTO I',000,00.00,00.00,00.00,'NOME  PRODUTO I',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='CD/DVD' ),'DETALHE  PRODUTO I');

INSERT INTO PRODUTO 
(ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO,PRECO_COM_DESCONTO,DESCONTO_PERCENTUAL,NOME,CATEGORIA_ID,DETALHE)
VALUES
(PRO_SEQ.NEXTVAL,'9999999999','DESCRICAO PRODUTO J',000,00.00,00.00,00.00,'NOME  PRODUTO J',(SELECT C.ID FROM CATEGORIA C WHERE C.NOME='OUTROS' ),'DETALHE  PRODUTO J');
-----------------------------------------------------------------
--verificando a inserção
SELECT * FROM PRODUTO PRO, CATEGORIA CAT
WHERE CAT.ID=PRO.CATEGORIA_ID
   
   