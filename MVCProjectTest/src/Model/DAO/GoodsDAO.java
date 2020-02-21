package Model.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DTO.GoodsDTO;

public class GoodsDAO extends DataBaseInfo{
	final String COLUMNS = "goods_seq, goods_num,user_id,goods_name, "
			+ "goods_Price,goods_Qty, goods_Content, goods_Image,"
			+ "goods_Register,goods_Visit";
	public void goodsDelete(String num) {
		getConnection();
		sql = "delete from goods where goods_seq = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void goodsContentUpdate(GoodsDTO goods) {
		getConnection();
		sql = " update goods "
				+ " set goods_price = ? , goods_qty = ?,"
				+ "     goods_content = ?, user_id = ? "
				+ " where goods_seq = ? ";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGoodsPrice());
			pstmt.setInt(2, goods.getGoodsQty());
			pstmt.setString(3, goods.getGoodsContent());
			pstmt.setString(4, goods.getUserId());
			pstmt.setInt(5, goods.getGoodsSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void goodsFileUpdate(GoodsDTO goods) {
		getConnection();
		sql = " update goods "
				+ " set goods_price = ? , goods_qty = ?,"
				+ "     goods_content = ?, user_id = ?,"
				+ "     goods_image = ? "
				+ " where goods_seq = ? ";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, goods.getGoodsPrice());
			pstmt.setInt(2, goods.getGoodsQty());
			pstmt.setString(3, goods.getGoodsContent());
			pstmt.setString(4, goods.getUserId());
			pstmt.setString(5, goods.getGoodsImage());
			pstmt.setInt(6, goods.getGoodsSeq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void visitCountUpdate(String goodsSeq) {
		getConnection();
		sql = " update goods set goods_Visit = goods_Visit + 1 "
			+ " where goods_seq=?";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, goodsSeq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public GoodsDTO goodsDetailSelect(String goodsSeq) {
		GoodsDTO goods = new GoodsDTO();
		getConnection();
		sql = "select " + COLUMNS + " from goods where goods_seq=?";
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, goodsSeq);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return goods;
	}
	
	public List getGoodsAllSelect(Integer page,Integer limit) {
		List list = new ArrayList();
		getConnection();
		int startrow = (page -1) * limit + 1; // 1,11,21
		int endrow = startrow + limit - 1; // 10,20,30
		sql= " select * "
		   + " from ( select rownum rn, " + COLUMNS 
		   + "        from (select " + COLUMNS 
		   + "              from goods order by goods_seq desc"
		   + "              )"
		   + "      ) "
		   + " where rn >=? and rn <=? ";
		System.out.println(sql);
		try {
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	public Integer getGoodsCount() {
		Integer result=0;
		getConnection();
		sql = "select count(*) from  goods";
		try {
			pstmt = conn.prepareStatement(sql);
			rs= pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	public void goodsInsert(GoodsDTO goods) {
		getConnection();
		sql = "insert into goods(" + COLUMNS + ") "
			+ " values(num_seq.nextval,?,?,?,?,?,?,?,sysdate,0)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getGoodsNum());
			pstmt.setString(2, goods.getUserId());
			pstmt.setString(3, goods.getGoodsName());
			pstmt.setInt(4, goods.getGoodsPrice());
			pstmt.setInt(5, goods.getGoodsQty());
			pstmt.setString(6, goods.getGoodsContent());
			pstmt.setString(7, goods.getGoodsImage());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
				
	}
}
