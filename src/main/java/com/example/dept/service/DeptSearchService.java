package com.example.dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Dept;
import com.example.mapper.DeptMapper;
import com.example.util.Pagination;

@Service
public class DeptSearchService {
	
	static Log log = LogFactory.getLog(DeptSearchService.class);
	
	@Autowired
	DeptMapper deptmapper;
	
	public List<Dept> getListAll(){
		log.info("getListAll()");
		return getListAll(false);
	}
	
	public List<Dept> getListAll(boolean withEmp){
		log.info("getListAll(" + withEmp + ")");
		List<Dept> list = null;
		if(withEmp)
			list = deptmapper.selectAllWithEmp();
		else
			list = deptmapper.selectAll();
		return list;
	}
	
	public Map<String, Object> getPage(int pageNo){
		return getPage(pageNo, false);
	}
	
	public Map<String, Object> getPage(int pageNo, boolean withEmp){
		Pagination paging = new Pagination();
		paging.setTotalItem(deptmapper.selectTotalCount());
		paging.setPageNo(pageNo);
		
		List<Dept> list = null;
		if(withEmp)
			list = deptmapper.selectPageWithEmp(paging);
		else
			list = deptmapper.selectPage(paging);
		
		Map<String, Object> map = new HashMap<>();
		map.put("dept", list);
		map.put("paging", paging);
		
		return map;
	}
	
	public Dept getDeptByDeptno(int deptno){
		log.info("getDeptByDeptno(" + deptno + ")");
		return getDeptByDeptno(deptno, false);
	}
	
	public Dept getDeptByDeptno(int deptno, boolean withEmp){
		log.info("getDeptByDeptno(" + deptno + ", " + withEmp + ")");
		Dept dept = null;
		if(withEmp)
			dept = deptmapper.selectByDeptnoWithEmp(deptno);
		else
			dept = deptmapper.selectByDeptno(deptno);
		
//		if(dept == null)
//			throw new NotFoundRuntimeException("해당 부서가 없습니다.");
		return dept;
	}
}
