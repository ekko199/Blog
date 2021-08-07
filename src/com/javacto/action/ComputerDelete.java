package com.javacto.action;

import com.javacto.service.ComputerService;
import com.javacto.service.ComputerServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/deleteComputer")
public class ComputerDelete extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取前端数据
        String ID = req.getParameter("id");
        Integer id =Integer.parseInt(ID);
        //调用业务层代码
        ComputerService computerService =new ComputerServiceimpl();

        computerService.deleteComputer(id);
        //跳转查询所有
        req.getRequestDispatcher("/query.aa").forward(req,resp);
    }
}
