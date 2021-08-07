package com.javacto.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
@WebServlet("/cookieGet.do")
public class CookieAction002 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //处理响应编码格式
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out =resp.getWriter();
        //获取Cookies  cookies通常是多个  所以使用数组来接收
        Cookie[] cookies =req.getCookies();
        //2.判断cookies中是否有值
        if (null!=cookies){
            //循环
            for (Cookie c:cookies){
                //获取值
                String str1=c.getValue();
                //必须进行解码（如果是中文）
                String str2= URLDecoder.decode(str1,"UTF-8");
                out.println("<h1>无解码的"+str1+"<h1>");

                out.println("<h1>解码的"+str2+"<h1>");
            }
        }
    }
}

