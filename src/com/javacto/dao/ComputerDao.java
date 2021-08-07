package com.javacto.dao;

import com.javacto.po.Computer;
import com.javacto.utils.PageInfo;

import java.util.List;

public interface ComputerDao {
    //添加
    public  int addComputer(Computer computer);

    //删除
    public int deleteComputer(int id) ;

    //根据id查询
    public Computer findByID(int id);
    //修改
    public int updateComputer(Computer computer);
    //查询所有
    public List<Computer> queryAll();
    //查询总条数
    public int getTotalCount(Computer computer);
    //分页查询
    public List<Computer> pageQueryComputer(PageInfo pageInfo,Computer computer);
    //根据品牌查询
    public boolean findByBrand(String brand);

}
