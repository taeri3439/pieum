package pieum.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pieum.capsule.model.TimeCapsuleDTO;
import pieum.capsule.service.CapsuleService;
import pieum.capsule.service.CapsuleServiceImpl;
import pieum.user.model.UserDTO;

@WebServlet("*.capsule")
@MultipartConfig
public class CapsuleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CapsuleController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request,response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println("요청경로 : "+command);
		
		CapsuleService service = new CapsuleServiceImpl();
		if(command.equals("/writeForm.capsule")) {
			
			HttpSession session = request.getSession();
            UserDTO userDto = (UserDTO)session.getAttribute("userDTO");
            
            if (userDto == null) {
                // 로그인되지 않은 경우 로그인 페이지로 리다이렉트
                response.sendRedirect(request.getContextPath() + "/login.user");
                return;
            }
			service.getTags(request,response);
		} else if(command.equals("/write.capsule")) {
			service.write(request, response);
		}else if(command.equals("/list.capsule")) {
			service.selectCapsulesByGno(request,response);
		}else if(command.equals("/viewList.capsule")) {
			request.getRequestDispatcher("capsuleList.jsp").forward(request, response);
		}else if(command.equals("/view.capsule")) {
			service.selectCapsuleByTcno(request,response);
			
		}
	}

}
