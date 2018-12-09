/*
Created		08/12/2018
Modified		09/12/2018
Project		
Model			
Company		
Author		
Version		
Database		PostgreSQL 8.1 
*/


/* Create Domains */



/* Create Tables */


Create table "Medico"
(
	"cod_cpf" Char(11) NOT NULL UNIQUE,
	"cod_crm" Integer NOT NULL,
	"nom_medico" Varchar NOT NULL,
	"num_telefone" Bigint NOT NULL,
	"des_email" Varchar,
	"hora_inicial1" Timestamp NOT NULL,
	"hora_inicial2" Timestamp NOT NULL,
	"hora_inicial3" Timestamp NOT NULL,
	"hora_intervalo" Smallint NOT NULL,
 primary key ("cod_cpf")
) Without Oids;


Create table "Especialidade"
(
	"cod_especialidade" Serial NOT NULL,
	"nom_especialidade" Varchar NOT NULL,
 primary key ("cod_especialidade")
) Without Oids;


Create table "MedicoEspecialidade"
(
	"cod_cpf" Char(11) NOT NULL,
	"cod_especialidade" Integer NOT NULL,
 primary key ("cod_cpf","cod_especialidade")
) Without Oids;


Create table "AgendaMedico"
(
	"cod_cpf" Char(11) NOT NULL,
 primary key ("cod_cpf")
) Without Oids;


Create table "Consulta"
(
	"cod_consulta" BigSerial NOT NULL,
	"hora_consulta" Timestamp NOT NULL,
	"cod_cpf" Char(11) NOT NULL,
	"cod_cliente" Bigint NOT NULL,
 primary key ("cod_consulta","cod_cpf","cod_cliente")
) Without Oids;


Create table "Cliente"
(
	"cod_cliente" BigSerial NOT NULL,
	"nom_cliente" Char(100) NOT NULL,
	"num_telefone" Bigint,
 primary key ("cod_cliente")
) Without Oids;


Create table "Equipamento"
(
	"cod_equipamento" BigSerial NOT NULL,
	"cod_tipoExame" Integer NOT NULL,
	"nom_equipamento" Char(100) NOT NULL,
	"idt_defeito" Boolean NOT NULL Default FALSE,
 primary key ("cod_equipamento","cod_tipoExame")
) Without Oids;


Create table "TipoExame"
(
	"cod_tipoExame" Serial NOT NULL,
	"nom_tipoExame" Char(100) NOT NULL,
 primary key ("cod_tipoExame")
) Without Oids;


Create table "MedicoEspecExame"
(
	"cod_cpf" Char(11) NOT NULL,
	"cod_tipoExame" Integer NOT NULL,
 primary key ("cod_cpf","cod_tipoExame")
) Without Oids;


Create table "AgendaEquipamento"
(
	"cod_equipamento" Bigint NOT NULL,
	"cod_tipoExame" Integer NOT NULL,
 primary key ("cod_equipamento","cod_tipoExame")
) Without Oids;


Create table "Exame"
(
	"cod_exame" BigSerial NOT NULL,
	"cod_cliente" Bigint NOT NULL,
	"desc_exame" Char(150) NOT NULL,
	"form_atendimento" Boolean NOT NULL,
	"cod_equipamento" Bigint NOT NULL,
	"cod_tipoExame" Integer NOT NULL,
	"cod_cpf" Char(11) NOT NULL,
 primary key ("cod_exame","cod_cliente","cod_equipamento","cod_tipoExame","cod_cpf")
) Without Oids;



/* Create Tab 'Others' for Selected Tables */


/* Create Alternate Keys */



/* Create Indexes */



/* Create Foreign Keys */

Alter table "MedicoEspecialidade" add  foreign key ("cod_cpf") references "Medico" ("cod_cpf") on update restrict on delete restrict;

Alter table "AgendaMedico" add  foreign key ("cod_cpf") references "Medico" ("cod_cpf") on update restrict on delete restrict;

Alter table "MedicoEspecExame" add  foreign key ("cod_cpf") references "Medico" ("cod_cpf") on update restrict on delete restrict;

Alter table "MedicoEspecialidade" add  foreign key ("cod_especialidade") references "Especialidade" ("cod_especialidade") on update restrict on delete restrict;

Alter table "Consulta" add  foreign key ("cod_cpf") references "AgendaMedico" ("cod_cpf") on update restrict on delete restrict;

Alter table "Exame" add  foreign key ("cod_cpf") references "AgendaMedico" ("cod_cpf") on update restrict on delete restrict;

Alter table "Consulta" add  foreign key ("cod_cliente") references "Cliente" ("cod_cliente") on update restrict on delete restrict;

Alter table "Exame" add  foreign key ("cod_cliente") references "Cliente" ("cod_cliente") on update restrict on delete restrict;

Alter table "AgendaEquipamento" add  foreign key ("cod_equipamento","cod_tipoExame") references "Equipamento" ("cod_equipamento","cod_tipoExame") on update restrict on delete restrict;

Alter table "MedicoEspecExame" add  foreign key ("cod_tipoExame") references "TipoExame" ("cod_tipoExame") on update restrict on delete restrict;

Alter table "Equipamento" add  foreign key ("cod_tipoExame") references "TipoExame" ("cod_tipoExame") on update restrict on delete restrict;

Alter table "Exame" add  foreign key ("cod_equipamento","cod_tipoExame") references "AgendaEquipamento" ("cod_equipamento","cod_tipoExame") on update restrict on delete restrict;





