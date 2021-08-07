package com.javacto.service;

import com.javacto.dao.ComputerDao;
import com.javacto.dao.ComputerDaoimpl;
import com.javacto.po.Computer;
import com.javacto.utils.BaseDao;
import com.javacto.utils.PageInfo;

import java.util.List;

public class ComputerServiceimpl implements ComputerService {
    //业务层需要调用dao层的方法 接口 变量名 = new 实现类(); new 出来的对象只给当前用
    private ComputerDao computerDao = new ComputerDaoimpl();

    @Override
    public int addComputer(Computer computer) {

        return computerDao.addComputer(computer);
    }

    @Override
    public int deleteComputer(int id) {
        return computerDao.deleteComputer(id);
    }

    @Override
    public Computer findByID(int id) {
        return computerDao.findByID(id);
    }

    @Override
    public int updateComputer(Computer computer) {
        return computerDao.updateComputer(computer);
    }

    @Override
    public List<Computer> queryAll() {
        return computerDao.queryAll();
    }

    @Override
    public int getTotalCount(Computer computer) {
        return computerDao.getTotalCount(computer);
    }

    @Override
    public List<Computer> pageQueryComputer(PageInfo pageInfo, Computer computer) {
        return computerDao.pageQueryComputer(pageInfo, computer);
    }

    @Override
    public boolean findByBrand(String brand) {
        return computerDao.findByBrand(brand);
    }
}
