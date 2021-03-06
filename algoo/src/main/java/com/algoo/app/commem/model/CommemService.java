package com.algoo.app.commem.model;

public interface CommemService {
	//아이디 중복 확인 시 사용하는 상수
	//해당 아이디가 존재하는지 여부
	public static final int EXIST_ID=1; //해당아이디가 존재
	public static final int NONE_EXIST_ID=2;
	//=> 해당 아이디가 존재하지 않음
	
	//로그인 처리시 사용하는 상수
	public static final int LOGIN_OK=1;//로그인 성공
	public static final int PWD_DISAGREE=2; //비밀번호 불일치
	public static final int ID_NONE=3;//해당아이디가 없는 경우
	
	public int insertCompMember(CommemVO commemVo);
	public int loginCheck(CommemVO commemVo);
	public int checkUserid(String userid);
	public CommemVO selectMemberByUserid(String userid);
	public int updateCompCode(CommemVO commemVo);
	public int updateCompMember(CommemVO commemVo);
	public int withdrawCommem(String userid);
	public int selectAllUserid(String userid);
	public int selectAllNickName(String userid);
	public int selectAllEmail(String userid);
	public String selectId(CommemVO commemVo);
	public int selectCount(CommemVO commemVo);
	public int updatePwd(CommemVO commemVo);
}
