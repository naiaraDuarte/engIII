CREATE DATABASE geacad;
USE geacad;

CREATE TABLE alunos (
    id_aluno           INT NOT NULL AUTO_INCREMENT,
    status             VARCHAR(15),
    ra                 VARCHAR(13),
    pessoas_id_pessoa  INT NOT NULL,
    turmas_id_turma    INT NOT NULL,
    CONSTRAINT alunos_pk PRIMARY KEY ( pessoas_id_pessoa ),
    CONSTRAINT alunos_id_aluno_un UNIQUE ( id_aluno )
);

CREATE TABLE cursos (
    id_curso   INT NOT NULL AUTO_INCREMENT,
    nome       VARCHAR(30),
    turno      VARCHAR(10),
    descricao  VARCHAR(60),
    duracao    INT,
    CONSTRAINT cursos_pk PRIMARY KEY ( id_curso )
);

CREATE TABLE disciplinas (
    id_disciplina             INT NOT NULL AUTO_INCREMENT,
    nome                      VARCHAR(30) NOT NULL,
    carga_horaria             INT,
    ementa                    VARCHAR(100),
    objetivo                  VARCHAR(60),
    bibliografia              VARCHAR(100),
    semestre_recomendado      INT,
    cursos_id_curso           INT NOT NULL,
    professores_id_professor  INT NOT NULL,
    CONSTRAINT disciplinas_pk PRIMARY KEY ( id_disciplina )
);

CREATE TABLE pessoas (
    id_pessoa        INT NOT NULL AUTO_INCREMENT,
    nome             VARCHAR(60),
    rg               VARCHAR(9),
    cpf              INT,
    email            VARCHAR(80),
    data_nascimento  DATETIME,
    sexo             VARCHAR(9),
    CONSTRAINT pessoas_pk PRIMARY KEY ( id_pessoa )
);

CREATE TABLE professores (
    id_professor       INT NOT NULL AUTO_INCREMENT,
    salario            DOUBLE,
    titulacao          VARCHAR(20),
    pessoas_id_pessoa  INT NOT NULL,
	CONSTRAINT professores_pk PRIMARY KEY ( pessoas_id_pessoa ),
    CONSTRAINT professores_id_professor_un UNIQUE ( id_professor )
);

CREATE TABLE turmas (
    id_turma         INT NOT NULL AUTO_INCREMENT,
    descricao        VARCHAR(30),
    data_inicio      DATETIME,
    cursos_id_curso  INT NOT NULL,
    CONSTRAINT turmas_pk PRIMARY KEY ( id_turma )
);

ALTER TABLE alunos
    ADD CONSTRAINT alunos_pessoas_fk FOREIGN KEY ( pessoas_id_pessoa )
        REFERENCES pessoas ( id_pessoa );

ALTER TABLE alunos
    ADD CONSTRAINT alunos_turmas_fk FOREIGN KEY ( turmas_id_turma )
        REFERENCES turmas ( id_turma );

ALTER TABLE disciplinas
    ADD CONSTRAINT disciplinas_cursos_fk FOREIGN KEY ( cursos_id_curso )
        REFERENCES cursos ( id_curso );

ALTER TABLE disciplinas
    ADD CONSTRAINT disciplinas_professores_fk FOREIGN KEY ( professores_id_professor )
        REFERENCES professores ( id_professor );

ALTER TABLE professores
    ADD CONSTRAINT professores_pessoas_fk FOREIGN KEY ( pessoas_id_pessoa )
        REFERENCES pessoas ( id_pessoa );

ALTER TABLE turmas
    ADD CONSTRAINT turmas_cursos_fk FOREIGN KEY ( cursos_id_curso )
        REFERENCES cursos ( id_curso );