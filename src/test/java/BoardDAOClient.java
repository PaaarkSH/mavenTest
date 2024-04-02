import com.biz.board.BoardDAO;
import com.biz.board.BoardVO;

import java.util.List;

public class BoardDAOClient {
    public static void main(String[] args) {
        BoardDAO dao = new BoardDAO();

        BoardVO vo = new BoardVO();
        vo.setSeq(2);
        vo.setTitle("mybatis 제목");
        vo.setWriter("테스터");
        vo.setContent("내용");
        dao.insertBoard(vo);

        List<BoardVO> boardList = dao.getBoardList();
        for (BoardVO board: boardList){
            System.out.println("-->" + board.toString());
        }
    }
}
