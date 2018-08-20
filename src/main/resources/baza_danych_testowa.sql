CREATE TABLE tabela_testowa (
    id bigint NOT NULL,
    kolumna1 character varying(256),
    kolumna2 character varying(256),
    kolumna3 character varying(256),
    kolumna4 bigint
);

insert into tabela_testowa VALUES ('1','wartość1','wartość2','wartość3','1');
insert into tabela_testowa VALUES ('2','warość21','wartość22','wartość23','5');
insert into tabela_testowa VALUES ('3','wartość31','wartość22','wartość32','6');
insert into tabela_testowa VALUES ('4','wartość54','wartość43','wartość45','4');
insert into tabela_testowa VALUES ('5','wartość43','wartość23','wartość34','4');
insert into tabela_testowa VALUES ('6','wartość43','wartość54','wartość43','2');
insert into tabela_testowa VALUES ('7','wartość54','wartość52','wartość53','8');
insert into tabela_testowa VALUES ('8','wartość21','wartość2211','wartość43','4');
insert into tabela_testowa VALUES ('9','wartość43','wartość33','wartość45','9');
insert into tabela_testowa VALUES ('10','wartość87','wartość62','wartość11','3');

ALTER TABLE ONLY tabela_testowa
    ADD CONSTRAINT i1_constr PRIMARY KEY (id);


