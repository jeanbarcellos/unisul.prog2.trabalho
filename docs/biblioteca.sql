/*
Navicat PGSQL Data Transfer

Source Server         : pgsql-localhost
Source Server Version : 90504
Source Host           : localhost:5432
Source Database       : biblioteca
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90504
File Encoding         : 65001

Date: 2016-11-19 09:54:38
*/


-- ----------------------------
-- Table structure for "public"."aluno"
-- ----------------------------
DROP TABLE "public"."aluno";
CREATE TABLE "public"."aluno" (
"usuario_id" int4 NOT NULL,
"curso_id" int4 NOT NULL,
"matricula" int4 NOT NULL,
"data_inicio" date NOT NULL,
"data_fim" date
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of aluno
-- ----------------------------
INSERT INTO "public"."aluno" VALUES ('3', '19', '1003', '2016-11-16', null);
INSERT INTO "public"."aluno" VALUES ('6', '1', '1001', '2016-11-16', null);
INSERT INTO "public"."aluno" VALUES ('7', '2', '1002', '2016-11-16', null);
INSERT INTO "public"."aluno" VALUES ('8', '3', '1312', '2016-11-17', null);
INSERT INTO "public"."aluno" VALUES ('9', '4', '103', '2016-11-17', '2016-11-17');

-- ----------------------------
-- Table structure for "public"."curso"
-- ----------------------------
DROP TABLE "public"."curso";
CREATE TABLE "public"."curso" (
"id" int4 NOT NULL,
"nome" varchar(96)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of curso
-- ----------------------------
INSERT INTO "public"."curso" VALUES ('1', 'Sistemas de Informação');
INSERT INTO "public"."curso" VALUES ('2', 'Ciencia da Computação');
INSERT INTO "public"."curso" VALUES ('3', 'Arquitetura e Urbanismo');
INSERT INTO "public"."curso" VALUES ('4', 'Educação Física');
INSERT INTO "public"."curso" VALUES ('5', 'Letras');
INSERT INTO "public"."curso" VALUES ('6', 'Psicologia');
INSERT INTO "public"."curso" VALUES ('7', 'Matemática');
INSERT INTO "public"."curso" VALUES ('8', 'Inglês');
INSERT INTO "public"."curso" VALUES ('9', 'Psiclogia');
INSERT INTO "public"."curso" VALUES ('11', 'Agronomia');
INSERT INTO "public"."curso" VALUES ('13', 'Sistemas');
INSERT INTO "public"."curso" VALUES ('14', 'Tal coisa');
INSERT INTO "public"."curso" VALUES ('15', 'Ciências Agrárias');
INSERT INTO "public"."curso" VALUES ('16', 'Pedagogia');
INSERT INTO "public"."curso" VALUES ('17', 'teste');
INSERT INTO "public"."curso" VALUES ('18', 'Testando eita');
INSERT INTO "public"."curso" VALUES ('19', 'Letras (Inglês)');

-- ----------------------------
-- Table structure for "public"."emprestimo"
-- ----------------------------
DROP TABLE "public"."emprestimo";
CREATE TABLE "public"."emprestimo" (
"id" int4 NOT NULL,
"usuario_id" int4 NOT NULL,
"exemplar_id" int4 NOT NULL,
"data_emprestimo" date NOT NULL,
"data_devolucao_previsao" date NOT NULL,
"data_devolucao" date
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of emprestimo
-- ----------------------------
INSERT INTO "public"."emprestimo" VALUES ('1', '1', '1', '2016-11-16', '2016-11-20', null);

-- ----------------------------
-- Table structure for "public"."exemplar"
-- ----------------------------
DROP TABLE "public"."exemplar";
CREATE TABLE "public"."exemplar" (
"id" int4 NOT NULL,
"livro_id" int4 NOT NULL,
"localizacao" varchar(250) NOT NULL,
"edicao" varchar(96) NOT NULL,
"data_cadastro" timestamp(6) NOT NULL,
"data_exclusao" timestamptz(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of exemplar
-- ----------------------------
INSERT INTO "public"."exemplar" VALUES ('1', '1', 'Plateleira tal', '1 Edição editada', '2016-11-15 03:07:25.618', null);
INSERT INTO "public"."exemplar" VALUES ('2', '1', 'Estante B', '2ª Edição', '2016-11-15 04:29:33.611', null);
INSERT INTO "public"."exemplar" VALUES ('3', '1', 'Eita ', '4ª Edição ', '2016-11-15 04:30:23.467', null);
INSERT INTO "public"."exemplar" VALUES ('4', '1', 'adsad', 'adas', '2016-11-15 04:31:01.638', '2016-11-17 00:59:26.253-03');
INSERT INTO "public"."exemplar" VALUES ('5', '1', 'Plate', '5', '2016-11-15 15:31:01.425', '2016-11-15 21:00:40.432-03');
INSERT INTO "public"."exemplar" VALUES ('6', '2', 'TEste', '7', '2016-11-15 15:33:55.703', null);
INSERT INTO "public"."exemplar" VALUES ('7', '5', 'Eita', '10', '2016-11-15 15:49:29.757', null);
INSERT INTO "public"."exemplar" VALUES ('8', '5', 'Prateleira', 'Exemplar 2', '2016-11-15 19:40:40.493', null);
INSERT INTO "public"."exemplar" VALUES ('9', '2', 'Tal painel', '9', '2016-11-15 21:08:47.978', null);
INSERT INTO "public"."exemplar" VALUES ('10', '1', '1', '1', '2016-11-15 21:12:35.355', '2016-11-15 20:59:27.517-03');
INSERT INTO "public"."exemplar" VALUES ('11', '2', 'Prateleira tal', '10', '2016-11-15 21:50:24.353', null);
INSERT INTO "public"."exemplar" VALUES ('12', '2', 'Localização tal', '10', '2016-11-17 00:14:14.756', null);
INSERT INTO "public"."exemplar" VALUES ('13', '3', 'Prateleira Tal', '1ª Edição', '2016-11-17 00:17:33.994', null);
INSERT INTO "public"."exemplar" VALUES ('14', '1', 'Eadsadsa', 'Eitaaaaaaaaaaaa', '2016-11-17 21:25:17.085', '2016-11-17 20:28:57.844-03');

-- ----------------------------
-- Table structure for "public"."livro"
-- ----------------------------
DROP TABLE "public"."livro";
CREATE TABLE "public"."livro" (
"id" int4 NOT NULL,
"titulo" varchar(96) NOT NULL,
"autor" varchar(96) NOT NULL,
"data_cadastro" timestamp(6) NOT NULL,
"data_exclusao" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of livro
-- ----------------------------
INSERT INTO "public"."livro" VALUES ('1', 'Livro de Teste tchê', 'Jean Barcellos', '2016-11-03 19:15:54.953', null);
INSERT INTO "public"."livro" VALUES ('2', 'Aprendendo padrões de projeto em php', 'Wlliam sanders', '2016-10-23 21:49:48', null);
INSERT INTO "public"."livro" VALUES ('3', 'Testando Inserção', 'Jean Barcelos', '2016-10-23 21:49:52', null);
INSERT INTO "public"."livro" VALUES ('4', 'Livro PHP Programando com Orientação a Objetos', 'Pablo Dall''Oglio', '2016-10-23 21:51:48', '2016-10-23 23:13:10.193');
INSERT INTO "public"."livro" VALUES ('5', 'Testando Timestamp', 'Jean Barcellos', '2016-10-23 22:26:57.27', null);
INSERT INTO "public"."livro" VALUES ('6', 'Testando Alteração', 'Daniela', '2016-10-23 22:59:19.858', null);
INSERT INTO "public"."livro" VALUES ('7', 'Bíblia do PHP', 'Constâncio', '2016-10-23 23:08:29.333', '2016-10-23 23:21:25.675');
INSERT INTO "public"."livro" VALUES ('8', 'Design Patterns', 'Altor Desconhecido', '2016-10-23 23:21:58.663', null);
INSERT INTO "public"."livro" VALUES ('9', 'teste', 'teste', '2016-10-24 01:06:55.317', null);

-- ----------------------------
-- Table structure for "public"."professor"
-- ----------------------------
DROP TABLE "public"."professor";
CREATE TABLE "public"."professor" (
"usuario_id" int4 NOT NULL,
"matricula" int4 NOT NULL,
"data_inicio" date NOT NULL,
"data_fim" date
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of professor
-- ----------------------------
INSERT INTO "public"."professor" VALUES ('1', '10101', '2016-11-16', '2016-11-16');
INSERT INTO "public"."professor" VALUES ('2', '10001', '2016-11-16', null);
INSERT INTO "public"."professor" VALUES ('4', '10004', '2016-11-16', null);
INSERT INTO "public"."professor" VALUES ('5', '10005', '2016-11-16', null);

-- ----------------------------
-- Table structure for "public"."professor_curso"
-- ----------------------------
DROP TABLE "public"."professor_curso";
CREATE TABLE "public"."professor_curso" (
"professor_id" int4 NOT NULL,
"curso_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of professor_curso
-- ----------------------------
INSERT INTO "public"."professor_curso" VALUES ('1', '1');
INSERT INTO "public"."professor_curso" VALUES ('1', '2');

-- ----------------------------
-- Table structure for "public"."usuario"
-- ----------------------------
DROP TABLE "public"."usuario";
CREATE TABLE "public"."usuario" (
"id" int4 NOT NULL,
"nome" varchar(96) NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO "public"."usuario" VALUES ('1', 'Jean Barcellos EDITADO 2');
INSERT INTO "public"."usuario" VALUES ('2', 'Ricardo Ribeiro');
INSERT INTO "public"."usuario" VALUES ('3', 'Pafuncio da Silva');
INSERT INTO "public"."usuario" VALUES ('4', 'Saulo PV');
INSERT INTO "public"."usuario" VALUES ('5', 'Flávio Ceci');
INSERT INTO "public"."usuario" VALUES ('6', 'Victor 1');
INSERT INTO "public"."usuario" VALUES ('7', 'Victor 2');
INSERT INTO "public"."usuario" VALUES ('8', 'Daniela Silva de Barcellos');
INSERT INTO "public"."usuario" VALUES ('9', 'Débora Silva de Barcellos');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Indexes structure for table aluno
-- ----------------------------
CREATE INDEX "aluno_usuario_id_idx" ON "public"."aluno" USING btree ("usuario_id");

-- ----------------------------
-- Primary Key structure for table "public"."aluno"
-- ----------------------------
ALTER TABLE "public"."aluno" ADD PRIMARY KEY ("usuario_id");

-- ----------------------------
-- Primary Key structure for table "public"."curso"
-- ----------------------------
ALTER TABLE "public"."curso" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table emprestimo
-- ----------------------------
CREATE INDEX "emprestimo_exemplar_id_idx" ON "public"."emprestimo" USING btree ("usuario_id");
CREATE INDEX "emprestimo_usuario_id_idx" ON "public"."emprestimo" USING btree ("usuario_id");

-- ----------------------------
-- Primary Key structure for table "public"."emprestimo"
-- ----------------------------
ALTER TABLE "public"."emprestimo" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table exemplar
-- ----------------------------
CREATE INDEX "livro_exemplar_livro_id_idx" ON "public"."exemplar" USING btree ("livro_id");

-- ----------------------------
-- Primary Key structure for table "public"."exemplar"
-- ----------------------------
ALTER TABLE "public"."exemplar" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table "public"."livro"
-- ----------------------------
ALTER TABLE "public"."livro" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table professor
-- ----------------------------
CREATE INDEX "professor_usuario_id_idx" ON "public"."professor" USING btree ("usuario_id");

-- ----------------------------
-- Primary Key structure for table "public"."professor"
-- ----------------------------
ALTER TABLE "public"."professor" ADD PRIMARY KEY ("usuario_id");

-- ----------------------------
-- Indexes structure for table professor_curso
-- ----------------------------
CREATE INDEX "professor_curso_curso_id_idx" ON "public"."professor_curso" USING btree ("curso_id");
CREATE INDEX "professor_curso_professor_id_idx" ON "public"."professor_curso" USING btree ("professor_id");

-- ----------------------------
-- Primary Key structure for table "public"."professor_curso"
-- ----------------------------
ALTER TABLE "public"."professor_curso" ADD PRIMARY KEY ("professor_id", "curso_id");

-- ----------------------------
-- Primary Key structure for table "public"."usuario"
-- ----------------------------
ALTER TABLE "public"."usuario" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."aluno"
-- ----------------------------
ALTER TABLE "public"."aluno" ADD FOREIGN KEY ("curso_id") REFERENCES "public"."curso" ("id") ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE "public"."aluno" ADD FOREIGN KEY ("usuario_id") REFERENCES "public"."usuario" ("id") ON DELETE NO ACTION ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."emprestimo"
-- ----------------------------
ALTER TABLE "public"."emprestimo" ADD FOREIGN KEY ("usuario_id") REFERENCES "public"."usuario" ("id") ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE "public"."emprestimo" ADD FOREIGN KEY ("exemplar_id") REFERENCES "public"."exemplar" ("id") ON DELETE NO ACTION ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."exemplar"
-- ----------------------------
ALTER TABLE "public"."exemplar" ADD FOREIGN KEY ("livro_id") REFERENCES "public"."livro" ("id") ON DELETE NO ACTION ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."professor"
-- ----------------------------
ALTER TABLE "public"."professor" ADD FOREIGN KEY ("usuario_id") REFERENCES "public"."usuario" ("id") ON DELETE NO ACTION ON UPDATE CASCADE;

-- ----------------------------
-- Foreign Key structure for table "public"."professor_curso"
-- ----------------------------
ALTER TABLE "public"."professor_curso" ADD FOREIGN KEY ("professor_id") REFERENCES "public"."professor" ("usuario_id") ON DELETE NO ACTION ON UPDATE CASCADE;
ALTER TABLE "public"."professor_curso" ADD FOREIGN KEY ("curso_id") REFERENCES "public"."curso" ("id") ON DELETE NO ACTION ON UPDATE CASCADE;
