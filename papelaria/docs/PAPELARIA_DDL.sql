
CREATE TABLE "DESENV"."PRODUTO" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"COD_BARRAS" VARCHAR2(13 BYTE) NOT NULL ENABLE, 
	"DESCRICAO" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"QUANTIDADE" NUMBER(*,0) NOT NULL ENABLE, 
	"PRECO_MEDIO" NUMBER(18,2) , 
	"NOME" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"CATEGORIA" NUMBER NOT NULL ENABLE, 
	"DETALHE" VARCHAR(50) , 
	 PRIMARY KEY ("ID")
   )
  TABLESPACE "SYSTEM" ;
-----------------------------------------------------------------------------------------------------------
ALTER TABLE PRODUTO ADD  NOME VARCHAR(30)NOT NULL; 
ALTER TABLE PRODUTO ADD  CATEGORIA NUMBER NOT NULL; 
ALTER TABLE PRODUTO ADD  DETALHE NUMBER NOT NULL; 
ALTER TABLE PRODUTO DROP COLUMN DETALHE;
ALTER TABLE PRODUTO ADD  DETALHE VARCHAR(50); 

--PRECO_MEDIO" NUMBER(18,2)
ALTER TABLE PRODUTO DROP COLUMN PRECO_MEDIO; 
ALTER TABLE PRODUTO ADD PRECO_MEDIO NUMBER(18,2); 

-----------------------------------------------------------------------------------------------------------
select * from produto
delete from   produto
------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUTO 
   (ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO_MEDIO,NOME,CATEGORIA,DETALHE)
   VALUES
   (PRODUTO_SEQ.NEXTVAL,'1234567890','DESCRICAO',999,99.99,'NOME',1,'TESTE')
   
   
------------------------------------------------------------------------------------------------------------


CREATE TABLE "DESENV"."PRODUTO" 
   (	
    "ID"          NUMBER            NOT NULL ENABLE, 
	"COD_BARRAS"  VARCHAR2(13 BYTE) NOT NULL ENABLE, 
	"DESCRICAO"   VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"QUANTIDADE"  NUMBER(*,0)       NOT NULL ENABLE, 
	"NOME"        VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"CATEGORIA"   NUMBER            NOT NULL ENABLE, 
	"DETALHE"     VARCHAR2(50 BYTE)                , 
	"PRECO_MEDIO" NUMBER(18,2)                     , 
	 PRIMARY KEY ("ID")
   ) TABLESPACE "SYSTEM" ;   