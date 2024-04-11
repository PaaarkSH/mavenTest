import java.util.List;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.biz.board.BoardVO;
import com.biz.user.UserService;
import com.biz.user.UserVO;

public class UserServiceClient {
    public static void main(String[] args) {
        GenericXmlApplicationContext container = new GenericXmlApplicationContext("business-layer.xml");

        // 스프링 컨테이너로 부터 사용할 비즈니스 객체를 lookup(검색)
        UserService userService = (UserService) container.getBean("userService");

        // 회원 조회 상세 테스트
        UserVO vo = new UserVO();
        vo.setId("admin");
        vo.setPasswod("admin");
        UserVO user = userService.getUser(vo);
        if (user != null) {
            System.out.println("이름 : " + user.getName());
        } else {
            System.out.println("로그인 실패");
        }

        // 스프링 컨테이너 종료
        container.close();
    }
}
