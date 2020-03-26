package Model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.DTO.GoodsDTO;

public class GoodsDAO {
	DataBaseInfo info;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	String subquery;
	
	public GoodsDAO() {
		this.info = new  DataBaseInfo();
	}
	public void goodsContentUpdate(GoodsDTO goods) {
		sql = " update goods "
				+ " set goods_price = ? , goods_qty = ?,"
				+ "     goods_content = ? "
				+ " where goods_seq = ? and user_id = ?";
			try {
				conn = info.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, goods.getGoodsPrice());
				pstmt.setInt(2, goods.getGoodsQty());
				pstmt.setString(3, goods.getGoodsContent());
				pstmt.setInt(4, goods.getGoodsSeq());
				pstmt.setString(5, goods.getUserId());
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				info.close(rs, pstmt);
			}
	}
	public void goodsNoFileUpdate(GoodsDTO goods) {
		sql = " update goods "
				+ " set goods_price = ? , goods_qty = ?,"
				+ "     goods_content = ? , goods_image = null"
				+ " where goods_seq = ? and user_id = ?";
			try {
				conn = info.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, goods.getGoodsPrice());
				pstmt.setInt(2, goods.getGoodsQty());
				pstmt.setString(3, goods.getGoodsContent());
				pstmt.setInt(4, goods.getGoodsSeq());
				pstmt.setString(5, goods.getUserId());
				pstmt.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				info.close(rs, pstmt);
			}
	}
	public void goodsFileUpdate(GoodsDTO goods){
		sql = " update goods "
			+ " set goods_price = ? , goods_qty = ?,"
			+ "     goods_content = ? , goods_image = ?"
			+ " where goods_seq = ? and user_id = ?";
		try {
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGoodsPrice());
			pstmt.setInt(2, goods.getGoodsQty());
			pstmt.setString(3, goods.getGoodsContent());
			pstmt.setString(4, goods.getGoodsImage());
			pstmt.setInt(5, goods.getGoodsSeq());
			pstmt.setString(6, goods.getUserId());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
	}
	public Integer goodsDelete(Integer goodsSeq, String userId) {
		Integer result = 0;
		sql = "delete from goods where goods_seq = ? and user_id = ?";
		System.out.println(goodsSeq);
		System.out.println("goodsDelete _ session : "  + userId);		
		try {
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, goodsSeq);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return result;
	}
	public GoodsDTO goodsDetailSelect(String num) {
		GoodsDTO goods = new GoodsDTO();
		try {
			conn = info.getConnection();
			sql = "update goods set goods_visit = goods_visit +1 "
					+ " where goods_seq = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			pstmt.executeUpdate();
			
			sql = "select goods_seq, goods_num,  user_id, "
					+ " goods_name, goods_price, goods_qty,  goods_content, "
					+ " goods_image, goods_register, goods_visit "
					+ " from goods "
					+ " where goods_seq = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			rs = pstmt.executeQuery();
			if(rs.next()) {
				goods.setGoodsSeq(rs.getInt(1));
				goods.setGoodsNum(rs.getString(2));
				goods.setUserId(rs.getString(3));
				goods.setGoodsName(rs.getString(4));
				goods.setGoodsPrice(rs.getInt(5));
				goods.setGoodsQty(rs.getInt(6));
				goods.setGoodsContent(rs.getString(7));
				goods.setGoodsImage(rs.getString(8));
				goods.setGoodsRegister(rs.getTimestamp(9));
				goods.setGoodsVisit(rs.getInt(10));
			}
		}catch(Exception e) {	
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return goods;		
	}
	public Integer getGoodsCount() {
		Integer result = 0;
		sql = "select count(*) from goods";
		try {
			conn = info.getConnection();
			pstmt= conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return result;		
	}
	public List<GoodsDTO> getGoodsAllSelect(int page, int limit){
		List<GoodsDTO> list = new ArrayList<GoodsDTO>();
		sql = "select  * "
			+ " from (select rownum rn,goods_seq,goods_num,user_id," 
			+ " goods_name, goods_price, goods_qty,  goods_content, "
			+ " goods_image, goods_register, goods_visit "
			+ " from (select goods_seq, goods_num,  user_id, "
			+ "        goods_name, goods_price, goods_qty,  "
			+ "        goods_content,goods_image, goods_register,"
			+ "         goods_visit "
			+ "         from goods "
			+ "         order by goods_seq desc))"
			+ " where rn >=? and rn <=? ";
		System.out.println(sql);
		int startrow = (page -1) * limit + 1;
		int endrow = startrow + limit - 1;
		try {
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GoodsDTO goods = new GoodsDTO();
				goods.setGoodsSeq(rs.getInt("goods_seq"));
				goods.setGoodsNum(rs.getString("goods_num"));
				goods.setUserId(rs.getString("user_id"));
				goods.setGoodsName(rs.getString("goods_name"));
				goods.setGoodsPrice(rs.getInt("goods_price"));
				goods.setGoodsQty(rs.getInt("goods_qty"));
				goods.setGoodsContent(rs.getString("goods_content"));
				goods.setGoodsImage(rs.getString("goods_image"));
				goods.setGoodsRegister(rs.getTimestamp("goods_register"));
				goods.setGoodsVisit(rs.getInt("goods_visit"));
				list.add(goods);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return list;
	}
	public Integer goodsInsert(GoodsDTO goods) {
		Integer result= 0;
		sql = "insert into goods (goods_seq, goods_num,  user_id, "
			+ " goods_name, goods_price, goods_qty,  goods_content, "
			+ " goods_image, goods_register, goods_visit ) "
			+ " values(no_seq.nextval, ?, ?, ?,?,?,?,?,sysdate,0)";
		try {
			conn = info.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsNum());
			pstmt.setString(2, goods.getUserId());
			pstmt.setString(3, goods.getGoodsName());
			pstmt.setInt(4, goods.getGoodsPrice());
			pstmt.setInt(5, goods.getGoodsQty());
			pstmt.setString(6, goods.getGoodsContent());
			pstmt.setString(7, goods.getGoodsImage());
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			info.close(rs, pstmt);
		}
		return result;
	}
}
