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

create table user() {
    id varchar2(12) primary key,
    password varchar2(12),
    name varchar2(50),
    role varchar2(5),
};

insert into users values('test', 'test', '테스터', 'User');
insert into users values('admin', 'admin', '관리자', 'Admin');