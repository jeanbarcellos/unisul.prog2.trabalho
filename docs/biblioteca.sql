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

Date: 2016-11-22 20:18:37
*/


-- ----------------------------
-- Table structure for "public"."aluno"
-- ----------------------------
DROP TABLE "public"."aluno";
CREATE TABLE "public"."aluno" (
"usuario_id" int4 NOT NULL,
"curso_id" int4 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of aluno
-- ----------------------------
INSERT INTO "public"."aluno" VALUES ('1', '1');
INSERT INTO "public"."aluno" VALUES ('2', '3');
INSERT INTO "public"."aluno" VALUES ('5', '4');
INSERT INTO "public"."aluno" VALUES ('6', '5');
INSERT INTO "public"."aluno" VALUES ('8', '1');
INSERT INTO "public"."aluno" VALUES ('10', '1');

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
INSERT INTO "public"."curso" VALUES ('2', 'Ciência da Computação');
INSERT INTO "public"."curso" VALUES ('3', 'Arquitetura e Urbanismo');
INSERT INTO "public"."curso" VALUES ('4', 'Educação Física');
INSERT INTO "public"."curso" VALUES ('5', 'Design de Moda');
INSERT INTO "public"."curso" VALUES ('6', 'Matemática');
INSERT INTO "public"."curso" VALUES ('7', 'Letras');
INSERT INTO "public"."curso" VALUES ('8', 'Matemática');
INSERT INTO "public"."curso" VALUES ('9', 'Análise e Desenvolvimento de Sistemas');

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
INSERT INTO "public"."emprestimo" VALUES ('1', '1', '12', '2016-11-22', '2016-12-03', null);
INSERT INTO "public"."emprestimo" VALUES ('2', '3', '9', '2016-11-22', '2016-12-03', null);
INSERT INTO "public"."emprestimo" VALUES ('3', '1', '6', '2016-11-22', '2016-12-03', null);
INSERT INTO "public"."emprestimo" VALUES ('4', '2', '13', '2016-11-22', '2016-12-03', null);
INSERT INTO "public"."emprestimo" VALUES ('5', '1', '8', '2016-11-22', '2016-12-03', null);

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
INSERT INTO "public"."exemplar" VALUES ('15', '14', 'Estante A, Linha 5', '1ª', '2016-11-22 12:05:03.296', null);
INSERT INTO "public"."exemplar" VALUES ('16', '1', 'Estante Tal', '5ª Edição Limitada', '2016-11-22 12:10:29.907', null);
INSERT INTO "public"."exemplar" VALUES ('17', '1', 'Em um lugar qualquer', '3ª Edição', '2016-11-22 12:10:55.834', null);

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
INSERT INTO "public"."livro" VALUES ('3', 'Livro tal', 'Jean Barcelos', '2016-10-23 21:49:52', null);
INSERT INTO "public"."livro" VALUES ('4', 'Livro PHP Programando com Orientação a Objetos', 'Pablo Dall''Oglio', '2016-10-23 21:51:48', '2016-10-23 23:13:10.193');
INSERT INTO "public"."livro" VALUES ('5', 'Testando Timestamp', 'Jean Barcellos', '2016-10-23 22:26:57.27', null);
INSERT INTO "public"."livro" VALUES ('6', 'Testando Alteração', 'Daniela', '2016-10-23 22:59:19.858', null);
INSERT INTO "public"."livro" VALUES ('7', 'Bíblia do PHP', 'Constâncio', '2016-10-23 23:08:29.333', '2016-10-23 23:21:25.675');
INSERT INTO "public"."livro" VALUES ('8', 'Design Patterns', 'Altor Desconhecido', '2016-10-23 23:21:58.663', null);
INSERT INTO "public"."livro" VALUES ('9', 'PHP Orientado a Objetos', 'Pafuncio Constâncio', '2016-10-24 01:06:55.317', null);
INSERT INTO "public"."livro" VALUES ('10', 'Jean alterando', 'teste este', '2016-11-20 20:39:16.919', null);
INSERT INTO "public"."livro" VALUES ('11', 'editad asdad ', 'editado', '2016-11-22 10:16:08.76', null);
INSERT INTO "public"."livro" VALUES ('12', 'ewerwrwrwerew', 'testewerw', '2016-11-22 10:17:27.892', '2016-11-22 10:21:28.493');
INSERT INTO "public"."livro" VALUES ('13', '22525252', 'teste', '2016-11-22 10:17:38.172', '2016-11-22 10:21:24.11');
INSERT INTO "public"."livro" VALUES ('14', 'Eita nóis', 'Eita nóis', '2016-11-22 11:52:52.401', null);

-- ----------------------------
-- Table structure for "public"."professor"
-- ----------------------------
DROP TABLE "public"."professor";
CREATE TABLE "public"."professor"()
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of professor
-- ----------------------------
