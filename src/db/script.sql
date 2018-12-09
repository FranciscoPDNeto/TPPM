/*
created		08/12/2018
modified		09/12/2018
project		
model			
company		
author		
version		
database		postgresql 8.1 
*/


/* drop referential integrity triggers */





/* drop domains */



/* drop indexes */



/* create domains */



/* create tables */


create table "medico"
(
	"cod_cpf" char(11) not null unique,
	"cod_crm" integer not null,
	"nom_medico" varchar not null,
	"num_telefone" bigint not null,
	"des_email" varchar,
	"hora_inicial1" timestamp not null,
	"hora_inicial2" timestamp not null,
	"hora_inicial3" timestamp not null,
	"hora_intervalo" smallint not null,
 primary key ("cod_cpf")
);


create table "especialidade"
(
	"cod_especialidade" serial not null,
	"nom_especialidade" varchar not null,
 primary key ("cod_especialidade")
);


create table "medicoespecialidade"
(
	"cod_cpf" char(11) not null,
	"cod_especialidade" integer not null,
 primary key ("cod_cpf","cod_especialidade")
);


create table "agendamedico"
(
	"cod_cpf" char(11) not null,
 primary key ("cod_cpf")
);


create table "consulta"
(
	"cod_consulta" bigserial not null,
	"hora_consulta" timestamp not null,
	"cod_cpf" char(11) not null,
	"cod_cliente" bigint not null,
 primary key ("cod_consulta","cod_cpf","cod_cliente")
);


create table "cliente"
(
	"cod_cliente" bigserial not null,
	"nom_cliente" char(100) not null,
	"num_telefone" bigint,
 primary key ("cod_cliente")
);


create table "equipamento"
(
	"cod_equipamento" bigserial not null,
	"cod_tipoexame" integer not null,
	"nom_equipamento" char(100) not null,
	"idt_defeito" boolean not null default false,
 primary key ("cod_equipamento","cod_tipoexame")
);


create table "tipoexame"
(
	"cod_tipoexame" serial not null,
	"nom_tipoexame" char(100) not null,
 primary key ("cod_tipoexame")
);


create table "medicoespecexame"
(
	"cod_cpf" char(11) not null,
	"cod_tipoexame" integer not null,
 primary key ("cod_cpf","cod_tipoexame")
);


create table "agendaequipamento"
(
	"cod_equipamento" bigint not null,
	"cod_tipoexame" integer not null,
 primary key ("cod_equipamento","cod_tipoexame")
);


create table "exame"
(
	"cod_exame" bigserial not null,
	"cod_cliente" bigint not null,
	"desc_exame" char(150) not null,
	"form_atendimento" boolean not null,
	"cod_equipamento" bigint not null,
	"cod_tipoexame" integer not null,
	"cod_cpf" char(11) not null,
 primary key ("cod_exame","cod_cliente","cod_equipamento","cod_tipoexame","cod_cpf")
);



/* create tab 'others' for selected tables */


/* create indexes */



/* create referential integrity triggers */







