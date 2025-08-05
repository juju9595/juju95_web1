drop database if exists exam12;
create database exam12;
use exam12;

create table waiting(
	wno int auto_increment,
    wphone varchar(13) not null,
    wcount varchar(2) not null,
    constraint primary key(wno)
);

#sample 

INSERT INTO waiting (wphone, wcount) VALUES ('010-1234-5678', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-2345-6789', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-3456-7890', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-4567-8901', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-5678-9012', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-6789-0123', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-7890-1234', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-8901-2345', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-9012-3456', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0123-4567', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-1111-2222', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-2222-3333', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-3333-4444', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-4444-5555', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-5555-6666', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-6666-7777', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-7777-8888', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-8888-9999', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-9999-0000', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0000-1111', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-1212-3434', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-2323-4545', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-3434-5656', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-4545-6767', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-5656-7878', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-6767-8989', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-7878-9090', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-8989-1010', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-9090-2121', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-1010-3232', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-2020-4343', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-3030-5454', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-4040-6565', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-5050-7676', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-6060-8787', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-7070-9898', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-8080-0909', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-9090-1011', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0101-1213', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-1112-1314', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-2123-1415', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-3134-1516', '5');
INSERT INTO waiting (wphone, wcount) VALUES ('010-4145-1617', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-5156-1718', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-6167-1819', '2');
INSERT INTO waiting (wphone, wcount) VALUES ('010-7178-1920', '3');
INSERT INTO waiting (wphone, wcount) VALUES ('010-8189-2021', '4');
INSERT INTO waiting (wphone, wcount) VALUES ('010-9190-2122', '1');
INSERT INTO waiting (wphone, wcount) VALUES ('010-0202-2324', '5');


select *from waiting