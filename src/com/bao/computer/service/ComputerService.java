package com.bao.computer.service;

import java.util.List;

import com.bao.computer.dao.ComputerDao;
import com.bao.computer.domain.Computer;

public class ComputerService {

  ComputerDao computerDao = new ComputerDao();
  
  //分页查询电脑信息
  public List<Computer> findAll(int page){
	  
	  List<Computer> computerList = computerDao.findAll(page);
	  
	  return computerList;
  }
  
  //查询电脑总数
  public int findCount(){
	  return computerDao.findCount();
  }
  
  //按id查询电脑
  public Computer findByNid(String nid){
	  return computerDao.findByNid(nid);
  }
  
  //按名字模糊查询电脑信息
  public List<Computer> findByNname(String nname){
	  
	  return computerDao.findByNname(nname);
  }
  
}
