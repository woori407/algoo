package com.algoo.app.freeboard.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.algoo.app.common.SearchVO;

@Repository
public class FreeboardDAOMybatis extends SqlSessionDaoSupport implements FreeboardDAO{
	private String namespace="com.mybatis.mapper.oracle.freeboard";

	@Override
	public int insertFreeboard(FreeboardVO freeVo) {
		return getSqlSession().insert(namespace+".insertFreeboard", freeVo);
	}
	
	@Override
	public List<FreeboardVO> selectAllFreeboard(SearchVO searchVo) {
		return getSqlSession().selectList(namespace+".selectAllFreeboard", searchVo);
	}
	
	@Override
	public int selectTotalCount(SearchVO searchVo) {
		return getSqlSession().selectOne(namespace+".selectTotalCount",	searchVo);
	}

	@Override
	public int updateReadCount(int freeNo) {
		return getSqlSession().update(namespace+".updateReadCount", freeNo);
	}

	@Override
	public FreeboardVO selectFreeboardByNo(int freeNo) {
		return getSqlSession().selectOne(namespace+".selectFreeboardByNo", freeNo);
	}

	@Override
	public int editFreeboard(FreeboardVO freeVo) {
		return getSqlSession().update(namespace+".editFreeboard", freeVo);
	}

	@Override
	public void deleteFreeboard(Map<String, String> map) {
		getSqlSession().delete(namespace+".deleteFreeboard", map);
	}
	
	@Override
	public int updateSortNo(FreeboardVO freeVo) {
		return getSqlSession().update(namespace+".updateSortNo", freeVo);
	}

	@Override
	public int insertReply(FreeboardVO freeVo) {
		freeVo.setSortNo(freeVo.getSortNo()+1);
		freeVo.setStep(freeVo.getStep()+1);
		return getSqlSession().insert(namespace+".insertReply", freeVo);
	}

	@Override
	public FreeboardVO prevContent(int freeNo) {
		return getSqlSession().selectOne(namespace+".prevContent", freeNo);
	}

	@Override
	public FreeboardVO nextContent(int freeNo) {
		return getSqlSession().selectOne(namespace+".nextContent", freeNo);
	}

	@Override
	public List<FreeboardVO> selectAll() {
		return getSqlSession().selectList(namespace+".selectAll");
	}

	@Override
	public List<FreeboardVO> selectAdmFreeboard() {
		return getSqlSession().selectList(namespace+".selectAdmFreeboard");
	}
}
