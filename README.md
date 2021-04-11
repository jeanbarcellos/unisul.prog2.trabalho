_Repositório apenas para o armazenamento dos arquivos e trabalhos da faculdade_

# Trabalho Final - Tópicos Avançados de Programação (Programação 2) - 4ª Fase - Unisul 2016/2

Prova 2 (Threds) da disciplina de Tópicos Avançados de Programação (Programação 2) - 4ª Fase - Unisul 2016/2

## O Trabalho

**Instruções iniciais**

- O trabalho contempla:
  - Trabalho escrito com modelagem e demais artefatos solicitados na documentação; Scripts de criação da base de dados;
  - Desenvolvimento de uma aplicação Java conforme os requisitos passados;
- Deve-se utilizar boas práticas de programação (e da orientação à objeto);
- Deve-se entregar:
  - O trabalho escrito + código fonte
  - e mais os scripts do banco de dados.

**Introdução**

- A biblioteca universitária solicitou que os alunos do curso de Sistemas de Informação da Unisul desenvolvessem um sistema para controle de empréstimo de livros.
- Como os alunos de Tópicos Avançados de Programação conhecem tudo sobre Java, eles foram os incumbidos para esta tarefa!

**Requisitos**

- O sistema deve armazenar todas informações em memória de modo que seja utilizada a estrutura de dados mais adequada para as operações em questão;
- O sistema deve permitir o cadastro de alunos;
- O sistema deve permitir o cadastro de professores
  - Tanto alunos como professores devem ser mantidos na mesma estrutura;
  - A forma de consulta de ambos é via sua matricula;
- O sistema deve permitir o cadastro de livros;
  - Não são permitidos o cadastro de livros repetidos;
  - Um livro deve ter uma lista de exemplares;
- O sistema deve permitir o vínculo de um exemplar com um usuário (aluno ou professor) da biblioteca
  - Cada usuário pode ter até 5 livros emprestados simultaneamente (não é permitido pegar mais de um exemplar do mesmo livro)

**Características**

- Característica do aluno:
  - Matricula;
  - Nome;
  - Nome do curso;
  - Exemplares pegos;
- Característica do professor:
  - Matricula;
  - Nome;
  - Exemplares pegos;
  - Lista de cursos que participa;
- Característica do livro:
  - Titulo;
  - Autor;
  - Lista de exemplares;
- Característica do exemplar:
  - Código;
  - Localização
  - Edição

**Requisitos (Continuação)**

- O sistema deve possuir uma interface (menu) para navegar entre as opções de operações;
- Outras operações permitidas (além do cadastro):
  - Fazer uma consulta por livro e/ou exemplar;
  - A partir da visualização da consulta o usuário pode fazer as seguintes operações:
    - Alterar os dados do objeto;
    - Excluir o objeto da estrutura de dados.
- Todas as informações devem serem persistidos em arquivos (serializados).
  - Dessa forma os dados devem ficar salvo mesmo depois da finalização do sistema.
- Deve‐se construir um modelo de dados (tabelas de um banco de dados) para suportar os requisitos do sistema da biblioteca universitária
- Após a criação do modelo é necessário construir uma camada para persistência e recuperar as informação a partir de um banco de dados.
- Desenvolva o DAO Factory para o sistema da Biblioteca Universitária da Unisul.
  - O DAO deve dar visibilidade para o acesso à arquivo e a banco de dados:
  - O sistema deve possuir um arquivo de configuração, onde o usuário possa escolher antes da inicialização da aplicação se ela deve utilizar a persistência baseada em arquivo ou em banco de dados. O arquivo pode ser desenvolvido:
    - Arquivo de texto comum;
    - Arquivo estilo properties;
    - Arquivo XML.
