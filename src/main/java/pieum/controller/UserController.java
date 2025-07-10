package pieum.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pieum.capsule.service.CapsuleService;
import pieum.capsule.service.CapsuleServiceImpl;
import pieum.user.model.UserDTO;
import pieum.user.service.UserService;
import pieum.user.service.UserServiceImpl;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
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

		UserService service = new UserServiceImpl();

		if(command.equals("/register.user")) {
			service.register(request, response);
		}else if (command.equals("/login.user")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else if (command.equals("/loginForm.user")) {
			service.login(request, response);
		}else if (command.equals("/userCheck.user")) {
			service.userCheck(request, response);
		} else if (command.equals("/home.user")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		} else if (command.equals("/mypage.user")) {
			HttpSession session = request.getSession();
			UserDTO userDto = (UserDTO)session.getAttribute("userDTO");

			if (userDto == null) {
				// 로그인되지 않은 경우 로그인 페이지로 리다이렉트
				response.sendRedirect(request.getContextPath() + "/login.jsp");
				return;
			}

			request.getRequestDispatcher("mypage.jsp").forward(request, response);
		} else if (command.equals("/modifyInfo.user")) {
			request.getRequestDispatcher("modifyInfo.jsp").forward(request, response);
		} else if (command.equals("/logout.user")) {
			service.logout(request, response);
		} else if (command.equals("/modifyInfoForm.user")) {
			service.modify(request, response);
		}else if (command.equals("/delete.user")) {
			service.delete(request, response);
		}else if (command.equals("/idSearch.user")) {
			request.getRequestDispatcher("idSearch.jsp").forward(request, response);
		}else if (command.equals("/idSearchForm.user")) {
			service.idSearch(request, response);
		}else if (command.equals("/pwSearch.user")) {
			request.getRequestDispatcher("pwSearch.jsp").forward(request, response);
		}else if (command.equals("/pwSearchForm.user")) {
			service.pwSearch(request, response);
		}
	}

}
