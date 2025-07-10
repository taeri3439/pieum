package pieum.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import pieum.capsule.mapper.TimeCapsuleMapper;
import pieum.capsule.model.FileDTO;
import pieum.util.mybatis.MyBatisUtil;


@WebServlet("/image")
public class imageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    public imageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 파라미터 받기
        String fno = request.getParameter("fno");

        if (fno == null || fno.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "파일 ID가 없습니다.");
            return;
        }

        // 2. DB에서 파일 조회
        try (SqlSession sql = sqlSessionFactory.openSession()) {
            TimeCapsuleMapper mapper = sql.getMapper(TimeCapsuleMapper.class);
            FileDTO file = mapper.selectFileById(fno);  // fno로 파일 조회

            if (file == null || file.getFileData() == null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "파일을 찾을 수 없습니다.");
                return;
            }

            // 3. Content-Type 지정 (여기선 임의로 jpeg로 설정. 필요 시 동적으로 처리)
            response.setContentType("image/png");

            // 4. 응답으로 byte[] 전송
            response.getOutputStream().write(file.getFileData());
            response.getOutputStream().flush();
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
