package com.spring.ex01;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlMapper=null;
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				Reader reader=Resources.getResourceAsReader("mybatis/SqlMapConfig.xml");
				sqlMapper=new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			} catch(Exception e) {e.printStackTrace();}
		}
		return sqlMapper;
	}
	public List<MemberVO> selectAllMemberList() {
		sqlMapper=getInstance();
		SqlSession sess=sqlMapper.openSession();
		return sess.selectList("mapper.member.selectAllMemberList");
	}
	public String selectName() {
		sqlMapper=getInstance();
		SqlSession sess=sqlMapper.openSession();
		return (String)sess.selectOne("mapper.member.selectName");
	}
	public int selectPw() {
		sqlMapper=getInstance();
		SqlSession sess=sqlMapper.openSession();
		return (Integer)sess.selectOne("mapper.member.selectPw");
	}
	public MemberVO selectMemberById(String id) {
		sqlMapper=getInstance();
		SqlSession sess=sqlMapper.openSession();
		return (MemberVO)sess.selectOne("mapper.member.selectMemberById", id);
	}
	public List<MemberVO> selectMemberByPw(int pw) {
		sqlMapper=getInstance();
		SqlSession sess=sqlMapper.openSession();
		return sess.selectList("mapper.member.selectMemberByPw", pw);
	}
	public int insertMember(MemberVO memberVO) {
		sqlMapper=getInstance();
		SqlSession sess=sqlMapper.openSession();
		int result=sess.insert("mapper.member.insertMember", memberVO);
		sess.commit();
		return result;
	}
	public int updateMember(MemberVO memberVO) {
		sqlMapper=getInstance();
		SqlSession sess=sqlMapper.openSession();
		int result=sess.update("mapper.member.updateMember", memberVO);
		sess.commit();
		return result;
	}
	public int deleteMember(String id) {
		sqlMapper=getInstance();
		SqlSession sess=sqlMapper.openSession();
		int result=sess.delete("mapper.member.deleteMember", id);
		sess.commit();
		return result;
	}
}
