package com.javacto.action;

import com.javacto.po.Computer;
import com.javacto.service.ComputerService;
import com.javacto.service.ComputerServiceimpl;
import com.javacto.utils.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/computerPage.do")
public class ComputerPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        //处理响映编码格式
        resp.setContentType("text/html;charset=UTF-8");
        //获取当前页
        String curNo = req.getParameter("pageNo");
        Integer pageNo =1;
        if (null!=curNo){
            //如果不为空则赋值
            pageNo = Integer.parseInt(curNo);
        }
        //把结果存入PageInfo对象中
        PageInfo infoSbq = new PageInfo();

        infoSbq.setPageNo(pageNo);
        //创建业务层代码

        ComputerService computerService = new ComputerServiceimpl();
        List<Computer> list = computerService.pageQueryComputer(infoSbq,null);
        int count =computerService.getTotalCount(null);
        //把总条数存入PageInfo中
        infoSbq.setTotalCount(count);
        //把结果存入Http中
        req.setAttribute("list",list);
        req.setAttribute("info",infoSbq);
        //跳转
        req.getRequestDispatcher("/computerListPage.jsp").forward(req,resp);

    }
}
