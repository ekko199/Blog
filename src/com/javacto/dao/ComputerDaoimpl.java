package com.javacto.dao;

import com.javacto.po.Computer;
import com.javacto.utils.BaseDao;
import com.javacto.utils.PageInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class     ComputerDaoimpl implements ComputerDao {
    @Override
    public int addComputer(Computer computer) {
        String sql="INSERT INTO computer(brand,country,production,sales,price,id) VALUES(?,?,NOW(),?,?,?)";
        Object sbqsbq[]={computer.getBrand(),computer.getCountry(),computer.getSales(),computer.getPrice(),computer.getId()};
        return BaseDao.myExecuteUpdate(sql,sbqsbq);
    }

    @Override
    public int deleteComputer(int id) {
        String sql = "DELETE FROM computer WHERE id = ?";
        Object sbqsbq[]={id};
        return BaseDao.myExecuteUpdate(sql,sbqsbq);
    }


    @Override
    public int updateComputer(Computer computer) {
        String sql ="UPDATE   computer SET brand=?,country=?,production=?,sales=?,price=? WHERE  id=?";
        Object sbqsbq[]={computer.getBrand(),computer.getCountry(),computer.getProduction(),computer.getSales(),computer.getPrice(),computer.getId()};
        return BaseDao.myExecuteUpdate(sql,sbqsbq);

    }

    @Override
    public Computer findByID(int id) {
        Computer computer=null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
            PreparedStatement pstm=conn.prepareStatement("SELECT * FROM computer WHERE id=?");
            pstm.setObject(1,id);
            ResultSet re = pstm.executeQuery();
            while (re.next()) {
                computer = new Computer();
                computer.setBrand(re.getString(1));
                computer.setCountry(re.getString(2));
                computer.setProduction(re.getDate(3));
                computer.setSales(re.getInt(4));
                computer.setPrice(re.getDouble(5));
                computer.setId(re.getInt(6));
                System.out.println(computer);
            }
            //6.释放资源
            pstm.close();
            conn.close();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return computer;

        }



    @Override
    public List<Computer> queryAll() {
        List<Computer> list = new ArrayList<Computer>();

        try {
            //1.加载驱动 DriverManager
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接  Connection
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
            //3.处理预编译 SQL语句  ?代表占位符  ?一个问号代码一个变量，没有赋值
            PreparedStatement pstm = conn.prepareStatement("SELECT * FROM computer ");
            //4.如果SQL语句 有？ 号必需给? 赋值
            /**
             * java.sql.SQLException: No value specified for parameter 4
             */
            ResultSet re = pstm.executeQuery();
            while (re.next()){
                Computer computer = new Computer();

                computer.setBrand(re.getString(1));
                computer.setCountry(re.getString(2));
                computer.setProduction(re.getDate(3));
                computer.setSales(re.getInt(4));
                computer.setPrice(re.getDouble(5));
                computer.setId(re.getInt(6));

                list.add(computer);
            }
            //6.释放资源
            pstm.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;

    }
    @Override
    public int getTotalCount(Computer computer) {
        int count=0;
        Connection conn =BaseDao.getCollections();
        PreparedStatement pstm =null;
        ResultSet rs =null;
        try {
            String sql="SELECT COUNT(*) FROM computer";
            pstm =conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            {
                BaseDao.closeAll(conn,pstm,rs);
            }
        }
        return count;
    }

    @Override
    public List<Computer> pageQueryComputer(PageInfo pageInfo, Computer computer) {
        List<Computer> list =new ArrayList<Computer>();
        Connection conn= null;
        PreparedStatement pstm =null;
        ResultSet rs =null;
        try{
            conn =BaseDao.getCollections();
            String sql ="SELECT * FROM computer LIMIT ?,?";
            pstm = conn.prepareStatement(sql);
            int begin= (pageInfo.getPageNo()-1)*pageInfo.getPageSize();
            int end =pageInfo.getPageSize();
            pstm.setObject(1,begin);
            pstm.setObject(2,end);
            rs = pstm.executeQuery();
            while (rs.next()){
                Computer computer1 =new Computer();
                computer1.setBrand(rs.getString(1));
                computer1.setCountry(rs.getString(2));
                computer1.setProduction(rs.getDate(3));
                computer1.setSales(rs.getInt(4));
                computer1.setPrice(rs.getDouble(5));
                computer1.setId(rs.getInt(6));

                list.add(computer1);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,rs);
        }
        return list;
    }

    @Override
    public boolean findByBrand(String brand) {
        boolean b = false;
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try {
            conn=BaseDao.getCollections();
            String sql ="SELECT * FROM Computer where brand=?";
            pstm=conn.prepareStatement(sql);
            pstm.setObject(1,brand);
            rs=pstm.executeQuery();
            //6.循环遍历
            while (rs.next()){
                b=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            BaseDao.closeAll(conn,pstm,rs);
        }
        return b;
    }
}

