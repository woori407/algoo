package com.algoo.app.rec.model;

import java.util.List;
import java.util.Map;

import com.algoo.app.company.model.CompanyVO;
import com.algoo.app.service.model.ServiceVO;

public interface RecService{
	public RecVO selectRecByCode(int recCode);
	public CompanyVO selectCompanyByCode(int i);
	public ServiceVO selectServiceByCode(int i);
	
	public int intsertRec(RecVO rVo,ServiceVO sVo);
	
	public int selectTotalCount(RecSeachVO vo);
	public List<RecVO> selectAllRec(RecSeachVO vo);
	public int updateReadCount (int readCount);
	public List<Map<String, Object>> selectJobName();
	public List<Map<String, Object>> selectJobName2(String jobName);
}
