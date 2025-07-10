package pieum.capsule.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pieum.capsule.model.FileDTO;
import pieum.capsule.model.TimeCapsuleDTO;

public interface CapsuleService {
	
	void write(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException;
	void selectCapsulesByGno(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException;
	void getTags(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException;
	void selectCapsuleByTcno(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
}
