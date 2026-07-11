-- delete from users.role where id_role = 'e5150d87-1cc6-41b1-98ec-6281cdc99c00';

alter table users.role add constraint name_role unique (nombre);