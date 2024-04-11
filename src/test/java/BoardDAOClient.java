import com.biz.board.BoardDAO;
import com.biz.board.BoardService;
import com.biz.board.BoardServiceImpl;
import com.biz.board.BoardVO;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardDAOClient {
    public static void main(String[] args) {
        // 스프링 컨테이너 구동
        GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");

        // 스프링 컨테이너로 부터 사용할 비즈니스 객체를 lookup(검색)
        BoardService boardService = (BoardService) container.getBean("boardService");

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

        // 스프링 컨테이너 종료
        container.close();
    }
}
