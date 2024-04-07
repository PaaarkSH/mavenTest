import com.biz.board.BoardDAO;
import com.biz.board.BoardService;
import com.biz.board.BoardServiceImpl;
import com.biz.board.BoardVO;

import java.util.List;

public class
BoardDAOClient {
    public static void main(String[] args) {
        BoardDAO dao = new BoardDAO();
        BoardService boardService = new BoardServiceImpl(dao);

        BoardVO vo = new BoardVO();
        vo.setSeq(2);
        vo.setTitle("mybatis 제목");
        vo.setWriter("테스터");
        vo.setContent("내용");
        boardService.insertBoard(vo);

        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("가입");

        List<BoardVO> boardList = boardService .getBoardList(vo);
        for (BoardVO board: boardList){
            System.out.println("-->" + board.toString());
        }
    }
}
