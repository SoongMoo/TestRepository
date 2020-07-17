package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.CartDTO;
import model.DTO.GoodsDTO;

public class GoodsDAO extends DataBaseInfo{
	final String COLUMNS = "GOODS_NUM, USER_ID,"
			+ "GOODS_NAME,GOODS_CONTENT,GOODS_IMAGE,"
			+ "IP_ADDR, GOODS_PRICE ,"
			+ "READ_COUNT, GOODS_REGISTER ";
	final String CART_COLUMNS = "CART_NUM,GOODS_Num,"
			+ " USER_ID, GOODS_NAME, GOODS_PRICE, "
			+ " GOODS_IMAGE,  QTY, TOTAL_PRICE ";
	public void cartRemove(String [] cartNums) {
		conn = getConnection(); 
		sql = "delete from cart "
			+ " where cart_num = ? ";
		try {
			int j = 0;
			pstmt = conn.prepareStatement(sql);
			for(String cartNum : cartNums) {
				pstmt.setString(1, cartNum);
				int i = pstmt.executeUpdate();
				if( i > 0) { j++; }
			}
			System.out.println(j + "개가 삭제되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public void cartQtyDown(String goodsNum,
			String userId) {
		conn = getConnection(); 
		sql = " update cart "
			+ " set qty = qty - 1,"
			+ "     total_Price = (qty -1) * goods_price "
			+ " where goods_num =? and user_id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			pstmt.setString(2, userId);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public List<CartDTO> cartAllSelect(String userId){
		List<CartDTO> list = new ArrayList<CartDTO>();
		conn = getConnection(); 
		sql = "select " + CART_COLUMNS+ ",  "
			+ " sum(total_price) over (partition by user_id) as sum_total_price"
			+ " from cart "
			+ " where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				CartDTO dto = new CartDTO();
				dto.setCartNum(rs.getInt(1));
				dto.setGoodsNum(rs.getString(2));
				dto.setUserId(rs.getString(3));
				dto.setGoodsName(rs.getString(4));
				dto.setGoodsPrice(rs.getInt(5));
				dto.setGoodsImage(rs.getString(6));
				dto.setQty(rs.getInt(7));
				dto.setTotalPrice(rs.getInt(8));
				dto.setSumTotalPrice(rs.getInt("sum_total_price"));
				list.add(dto);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return list;
	}
	public void goodsCartAdd(GoodsDTO dto,
			String userId) {
		System.out.println("goodsCartAdd : " + userId);
		conn = getConnection(); 
		sql = " merge into cart c  "
			+ " using  (select  goods_num "
			+ "         from goods where goods_num = ?) g"
			+ " on (c.goods_num = g.goods_num and c.user_id =?)"
			+ " When MATCHED THEN "
			+ " 	update set QTY = QTY + 1, "
			+ "                TOTAL_PRICE = (QTY + 1) * GOODS_PRICE  "
			+ " When NOT MATCHED THEN "
			+ " insert (c.CART_NUM, c.goods_num, c.user_id, "
			+ "         c.goods_name, c.goods_price, c.goods_image,"
			+ "         c.qty, c.TOTAL_PRICE) "
			+ " values (num_seq.nextval, ?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, userId);
			pstmt.setString(3, dto.getGoodsNum());
			pstmt.setString(4, userId);
			pstmt.setString(5, dto.getGoodsName());
			pstmt.setLong(6, dto.getGoodsPrice());
			pstmt.setString(7, dto.getGoodsImage());
			pstmt.setInt(8, 1);
			pstmt.setLong(9, dto.getGoodsPrice());
			int i = pstmt.executeUpdate();
			System.out.println(i +"가 변경되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public Integer fileUpdate(GoodsDTO dto) {
		Integer i =0;
		conn = getConnection();
		sql = " update goods "
			+ " set goods_image = ? "
			+ " where user_id = ? and goods_num = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsImage());
			pstmt.setString(2, dto.getUserId());
			pstmt.setString(3, dto.getGoodsNum());
			i = pstmt.executeUpdate();
			System.out.println(i+"개가 수정되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally{close();}
		return i;
	}
	public void goodsContentUpdate(GoodsDTO dto) {
		conn = getConnection();
		sql = " update goods "
			+ " set goods_content = ?, "
			+ "     goods_price = ? "
			+ " where user_id = ? and goods_num = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsContent());
			pstmt.setLong(2, dto.getGoodsPrice());
			pstmt.setString(3, dto.getUserId());
			pstmt.setString(4, dto.getGoodsNum());
			int i = pstmt.executeUpdate();
			System.out.println(i+"개가 수전되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public Integer goodsDel(String goodsNum) {
		Integer i = 0;
		conn = getConnection();
		sql = "delete from goods where goods_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodsNum);
			i = pstmt.executeUpdate();
			System.out.println(i +"개가 삭제되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return i;
	}
	public void updateReadCount(String num) {
		conn = getConnection();
		sql = " update goods "
			+ " set read_count = read_count + 1"
			+ " where goods_num = ? ";
		System.out.println(sql);
		System.out.println(num);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정죄었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
	public Integer goodsCount() {
		Integer i = 0;
		conn = getConnection();
		sql = "select count(*) cnt  from goods";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i = rs.getInt("cnt");
			}
		}catch(Exception e) {e.printStackTrace();
		}finally {close();}
		return i;
	}
	public List<GoodsDTO> goodsSelectAll(int page,
			int limit, String num){
		List<GoodsDTO> list = 
				new ArrayList<GoodsDTO>();
		int startRow = (page -1) * limit +1;
		int endRow = startRow + limit -1;
		String condition = "";
		// deatail 출력시  해당 goodsNum만 가져오기 위한 조건
		if(num != null)
			condition = " and goods_num = '" + num + "'";
		conn = getConnection();
		sql = "select * "
			+ "from (select rownum rn , " + COLUMNS 
			+ " 	 from (select "+ COLUMNS 
			+ " 	  	  from goods where 1=1 "+condition
			+         	  " order by goods_num desc))"
			+ " where rn between ? and ?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsDTO dto = new GoodsDTO();
				dto.setGoodsContent(
						rs.getString("goods_content"));
				dto.setGoodsImage(
						rs.getString("goods_image"));
				dto.setGoodsName(
						rs.getString("goods_name"));
				dto.setGoodsNum(
						rs.getString("goods_num"));
				dto.setGoodsPrice(
						rs.getLong("goods_price"));
				dto.setGoodsRegister(
						rs.getTimestamp("goods_register"));
				dto.setGoodsVisit(
						rs.getLong("READ_COUNT"));
				dto.setIpAddr(
						rs.getString("ip_addr"));
				dto.setUserId(
						rs.getString("user_id"));
				list.add(dto);
			}
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return list;
	}
	public void goodsInsert(GoodsDTO dto) {
		conn = getConnection();
		sql = "insert into goods ("+ COLUMNS + ") "
			+ " values(?,?,?,?,?,?,?,0, sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGoodsNum());
			pstmt.setString(2, dto.getUserId());
			pstmt.setString(3, dto.getGoodsName());
			pstmt.setString(4, dto.getGoodsContent());
			pstmt.setString(5, dto.getGoodsImage());
			pstmt.setString(6, dto.getIpAddr());
			pstmt.setLong(7, dto.getGoodsPrice());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 저장되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
	}
}
