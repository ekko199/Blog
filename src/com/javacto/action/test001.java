package com.javacto.action;

import com.javacto.po.Computer;
import com.javacto.service.ComputerService;
import com.javacto.service.ComputerServiceimpl;

public class test001 {
    public static void main(String[] args) {
        ComputerService computerService =new ComputerServiceimpl();
        Computer computer = new Computer();
        computer.setId(9);
        computer.setPrice(9999.23);
        computer.setSales(2222);
        computer.setCountry("中国");
        computer.setBrand("华硕2");
        int num = computerService.addComputer(computer);
        System.out.println(num);
    }

}
