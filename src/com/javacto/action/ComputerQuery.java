package com.javacto.action;

import com.javacto.service.ComputerService;
import com.javacto.service.ComputerServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/query.aa")
public class ComputerQuery extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //编码格式
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取前端数据
        String brand=req.getParameter("brandQuery");
        String id=req.getParameter("idQuery");
        //调用业务层代码
        ComputerService computerService=new ComputerServiceimpl();

        List list = computerService.queryAll();

        //传值给jsp并跳转
        req.setAttribute("computer",list);

        req.getRequestDispatcher("/ComputerList.jsp").forward(req,resp);


    }
}
