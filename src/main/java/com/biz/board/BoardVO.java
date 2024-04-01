package com.biz.board;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

// value object
//@Getter
//@Setter
//@ToString
@Data  // get set tostring equals hashcode 등등 한번에 다 선언해줌
public class BoardVO {
    /*
    *     seq         integer primary key ,
    title       varchar,
    writer      varchar,
    content     varchar,
    regdate     date        default current_date,
    cnt         integer     default 0 ,
    * */
    private int seq;
    private String title;
    private String writer;
    private String content;
    private Date regdate;
    private int cnt;
}
