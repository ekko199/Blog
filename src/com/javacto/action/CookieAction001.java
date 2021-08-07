package com.javacto.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
@WebServlet("/cookieAdd.do")
public class CookieAction001 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        //处理响映编码格式
        resp.setContentType("text/html;charset=UTF-8");
        //1.创建 输出流
        PrintWriter out = resp.getWriter();
        //2.设置将要存入cookie的字符串  只能存字符串 不能存User对象 Session可以存对象
        //Cookie 存的值比较少，最多的就是用户名 密码
        String str1 = URLEncoder.encode("sbqSbq","UTF-8");

        String str2=URLEncoder.encode("张三","UTF-8");
        //3.创建Cookie,把str1存入cookie必需是键对值的方式
        Cookie cookie= new Cookie("sbqKey",str1);
        Cookie cookie1= new Cookie("sbqKey2",str2);
        //设置cookie的过期时间 如果没有设置 关闭浏览器立即失效
        //等于0直接删除 不保存
        //<0保存在内存中
        //>1保存在硬盘中 秒为单位 60
       // cookie.setMaxAge(0);//直接删除，不保存
        //cookie.setMaxAge(-1);//<0保存在内存中
        cookie.setMaxAge(1200);//120秒
        cookie1.setMaxAge(1000);//100秒

        //必需将cookie响应给浏览器， 如果不操作，cookies不保存
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
    }
}
