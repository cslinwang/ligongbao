package com.bao.computer.service;

import java.util.List;

import com.bao.computer.dao.ComputerDao;
import com.bao.computer.domain.Computer;

public class ComputerService {

  ComputerDao computerDao = new ComputerDao();
  
  //��ҳ��ѯ������Ϣ
  public List<Computer> findAll(int page){
	  
	  List<Computer> computerList = computerDao.findAll(page);
	  
	  return computerList;
  }
  
  //��ѯ��������
  public int findCount(){
	  return computerDao.findCount();
  }
  
  //��id��ѯ����
  public Computer findByNid(String nid){
	  return computerDao.findByNid(nid);
  }
  
  //������ģ����ѯ������Ϣ
  public List<Computer> findByNname(String nname){
	  
	  return computerDao.findByNname(nname);
  }
  
}
