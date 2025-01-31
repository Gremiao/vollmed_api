alter table consultas add ativo tinyint default 1 not null;
alter table consultas add motivo_cancelamento varchar(100) null;