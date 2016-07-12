insert into authorities values(1, "ROLE_USER","gurhan.kucuk@yandex.com" );
insert into authorities values(2, "ROLE_USER","nida.seker@gmail.com" );

insert into user_account values(1,"gurhan.kucuk@yandex.com", 1, "gurhan", "kucuk","$2a$12$9wzQTsvtWR.tMRClj1kmQOwcxMcjoaDKlBxRQj0SZ3mhFM7vERzZK");
insert into user_account values(2,"nida.seker@gmail.com", 1, "nida", "seker","$2a$12$9wzQTsvtWR.tMRClj1kmQOwcxMcjoaDKlBxRQj0SZ3mhFM7vERzZK");

insert into post(id,userId, title, url, text) values(1, 1, "baþlýk", "baslik", "içerik");