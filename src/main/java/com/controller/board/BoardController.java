package com.controller.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.biz.board.BoardService;
import com.biz.board.BoardVO;

@Controller
@SessionAttributes("board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/json.do")
    public @ResponseBody BoardVO json(BoardVO vo){
        return boardService.getBoard(vo);
    }

    @GetMapping("/jsonList.do")
    public @ResponseBody List<BoardVO> jsonList(BoardVO vo) throws Exception {
        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("");
        return boardService.getBoardList(vo);
    }

    @RequestMapping("/insertBoardBView.do")
    public String insertBoardView() throws Exception {
        return "insertBoard";
    }
}
