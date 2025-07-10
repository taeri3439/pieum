package pieum.user.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
	
	void register(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
	void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
	void modify(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
	void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
	void userCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void idSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	void pwSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
