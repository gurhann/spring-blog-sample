insert into authorities values(1, "ROLE_USER","gurhan.kucuk@yandex.com" );
insert into authorities values(2, "ROLE_USER","nida.seker@gmail.com" );

insert into user_account values(1,"gurhan.kucuk@yandex.com", 1, "gurhan", "kucuk","$2a$12$9wzQTsvtWR.tMRClj1kmQOwcxMcjoaDKlBxRQj0SZ3mhFM7vERzZK");
insert into user_account values(2,"nida.seker@gmail.com", 1, "nida", "seker","$2a$12$9wzQTsvtWR.tMRClj1kmQOwcxMcjoaDKlBxRQj0SZ3mhFM7vERzZK");

insert into post(id,userId, title, url, text,date) values(1, 1, "ba�l�k1", "baslik", "i�erik", STR_TO_DATE('27/07/2016','%d/%m/%Y'));
insert into post(id,userId, title, url, text,date) values(2, 1, "ba�l�k2", "baslik", "i�erik", STR_TO_DATE('28/07/2016','%d/%m/%Y'));
insert into post(id,userId, title, url, text,date) values(3, 1, "ba�l�k3", "baslik", "i�erik", STR_TO_DATE('29/07/2016','%d/%m/%Y'));
insert into post(id,userId, title, url, text,date) values(4, 1, "ba�l�k4", "baslik", "i�erik", STR_TO_DATE('30/07/2016','%d/%m/%Y'));
insert into post(id,userId, title, url, text,date) values(5, 1, "ba�l�k5", "baslik", "i�erik", STR_TO_DATE('31/07/2016','%d/%m/%Y'));
insert into post(id,userId, title, url, text,date) values(6, 1, "ba�l�k6", "baslik", "i�erik", STR_TO_DATE('01/08/2016','%d/%m/%Y'));

