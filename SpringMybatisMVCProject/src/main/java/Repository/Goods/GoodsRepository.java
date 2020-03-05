package Repository.Goods;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.DTO.GoodsDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "goodsMapper";
	public void goodInsert(GoodsDTO dto) {
		String statement = namespace + ".goodsInsert";
		sqlSession.insert(statement, dto);
	}
	public Integer goodsWishAdd(Long goodsSeq,String userId) {
		String statement = namespace + ".goodsList";
		GoodsDTO dto = sqlSession.selectOne(statement,goodsSeq);
		dto.setUserId(userId);
		
		statement = namespace + ".goodsWish";
		sqlSession.update(statement, dto);
		
		statement = namespace + ".goodsWishCount";
		Integer i =  sqlSession.selectOne(statement,goodsSeq);
		return i;
	}
	public GoodsDTO goodsDetail(Long goodsSeq) {
		String statement = namespace + ".goodsList";
		return sqlSession.selectOne(statement,goodsSeq);
	}
	public List<GoodsDTO> goodsList(){
		String statement = namespace + ".goodsList";
		return sqlSession.selectList(statement);
	}
	
}
