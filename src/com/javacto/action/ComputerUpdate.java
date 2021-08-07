package com.javacto.action;

import com.javacto.po.Computer;
import com.javacto.service.ComputerService;
import com.javacto.service.ComputerServiceimpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateComputer.do")
public class ComputerUpdate extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取前端数据
        String id1= req.getParameter("id");

        Integer id = Integer.parseInt(id1);

        String brand =req.getParameter("brand");

        String country=req.getParameter("country");
        //String production=req.getParameter("production");
        //将String转为日期
        // SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        // Date date= java.sql.Date.valueOf(production);

        String sales=req.getParameter("sales");
        Integer sales1 =Integer.parseInt(sales);

        String price=req.getParameter("price");
        Double price1=Double.parseDouble(price);

        //调用业务层代码
        ComputerService computerService =new ComputerServiceimpl();
        Computer computer =new Computer();

        computer.setId(id);
        computer.setBrand(brand);
        computer.setCountry(country);
        // computer.setProduction(date);
        computer.setSales(sales1);
        computer.setPrice(price1);

        computerService.updateComputer(computer);
        //跳转到查询所有
        req.getRequestDispatcher("/query.aa").forward(req,resp);



    }
}
