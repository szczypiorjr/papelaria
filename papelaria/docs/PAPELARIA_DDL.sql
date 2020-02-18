
CREATE TABLE "DESENV"."PRODUTO" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"COD_BARRAS" VARCHAR2(13 BYTE) NOT NULL ENABLE, 
	"DESCRICAO" VARCHAR2(50 BYTE) NOT NULL ENABLE, 
	"QUANTIDADE" NUMBER(*,0) NOT NULL ENABLE, 
	"PRECO_MEDIO" NUMBER(18,2) NOT NULL ENABLE, 
	"NOME" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"CATEGORIA" NUMBER NOT NULL ENABLE, 
	"DETALHE" NUMBER NOT NULL ENABLE, 
	 PRIMARY KEY ("ID")
   )
  TABLESPACE "SYSTEM" ;
-----------------------------------------------------------------------------------------------------------
ALTER TABLE PRODUTO ADD  NOME VARCHAR(30)NOT NULL; 
ALTER TABLE PRODUTO ADD  CATEGORIA NUMBER NOT NULL; 
ALTER TABLE PRODUTO ADD  DETALHE NUMBER NOT NULL; 
-----------------------------------------------------------------------------------------------------------
select * from produto

------------------------------------------------------------------------------------------------------------
INSERT INTO PRODUTO 
   (ID,COD_BARRAS,DESCRICAO,QUANTIDADE,PRECO_MEDIO,NOME,CATEGORIA,DETALHE)
   VALUES
   (PRODUTO_SEQ.NEXTVAL,'1234567890','DESCRICAO',999,99.99,'NOME',1,1)
   