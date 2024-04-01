create table board (
    seq         integer primary key ,
    title       varchar,
    writer      varchar,
    content     varchar,
    regdate     date        default current_date,
    cnt         integer     default 0 ,
);

insert into board(seq, title, writer, content)
values (1, '가입인사', '홍길동', '잘해봅시다')
;