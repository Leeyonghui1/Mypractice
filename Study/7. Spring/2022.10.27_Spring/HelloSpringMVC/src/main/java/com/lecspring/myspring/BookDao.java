package com.lecspring.myspring;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * BookDao를 Bean으로 등록
 * DB연결 관련된 Bean 객체 :: @Repository
 */

@Repository
public class BookDao {
	// bean객체를 생성하는 데, 적절한 인스턴스를 자동 생성해줌(new 키워드 없이)
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map)
	{
		// mapper(=book_SQL.xml)에 있는 id가 insert인
		// 쿼리를 수행함
		return this.sqlSessionTemplate.insert("book.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map)
	{
		return this.sqlSessionTemplate.selectOne("book.select_detail", map);
	}
	
	public int update(Map<String, Object> map)
	{
		return this.sqlSessionTemplate.update("book.update", map);
	}
	
	public int delete(Map<String, Object> map)
	{
		return this.sqlSessionTemplate.delete("book.delete", map);
	}
	
	public List<Map<String, Object>> selectList(Map<String, Object> map)
	{
		return this.sqlSessionTemplate.selectList("book.select_list", map);
	}
	
	public int countBookBoard(Map<String, Object> map)
	{
		return this.sqlSessionTemplate.selectOne("book.countBookBoard", map);
	}
}
