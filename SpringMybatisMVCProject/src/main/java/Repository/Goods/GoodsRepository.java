package Repository.Goods;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.DTO.CartDTO;
import Model.DTO.CartRemove;
import Model.DTO.GoodsDTO;
import Model.DTO.WishDTO;

public class GoodsRepository {
	@Autowired
	SqlSession sqlSession;
	private final String namespace = "goodsMapper";
	
	public void goodsCartRemove(Map<String, Object> condition) {
		String statement = namespace + ".CartRemove";
		sqlSession.delete(statement, condition);
	}
	
	public void goodsCartQtyDown(CartDTO cart) {
		String statement = namespace + ".cartDown";
		sqlSession.update(statement, cart);
	}
	public Integer goodsCartAdd(CartDTO dto) {
		String statement = namespace + ".cartInsert";
		try {
			sqlSession.insert(statement, dto);
		}catch(Exception e) {}
		return 1;
	}
	public List<CartDTO> cartList(String userId){
		String statement = namespace + ".cartList";
		return sqlSession.selectList(statement,userId);
	}
	public void goodInsert(GoodsDTO dto) {
		String statement = namespace + ".goodsInsert";
		sqlSession.insert(statement, dto);
	}
	public List<GoodsDTO> goodsWishList(String userId){
		String statement = namespace + ".goodsWishList";
		return sqlSession.selectList(statement,userId);
	}
	public Integer goodsWishAdd(Long goodsSeq,String userId) {
		WishDTO dto = new WishDTO();
		dto.setGoodsSeq(goodsSeq);
		dto.setUserId(userId);
		String statement = namespace + ".goodsWishCount";
		Integer i =  sqlSession.selectOne(statement,dto);
		
		if(i == 0) {
			statement = namespace + ".wishInsert";
			sqlSession.insert(statement,dto);
			i = 1;
		}else {
			statement = namespace + ".wishDelete";
			sqlSession.delete(statement,dto);
			i = 0;
		}
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
