package model.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DTO.OptionsDTO;
import model.DTO.QuestionDTO;
import model.DTO.QuestionOptionsDTO;

public class QuestionDAO extends DataBaseInfo{
	public List<QuestionOptionsDTO> surveySelect(
			String userId) {
		List<QuestionOptionsDTO> list = 
				new ArrayList<QuestionOptionsDTO>() ;
		conn = getConnection();
		List<Integer> nums = new ArrayList<Integer>();
		try {
			sql = " select question_num from question "
				+ " where user_id =  ? order by QUESTION_NUM ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				nums.add(rs.getInt(1));
			}
			int qnum = 0;
			if(rs.next()) qnum = rs.getInt(1);
			rs.close();
			pstmt.close();
			sql ="select q.QUESTION_NUM QUESTION_NUM, "
			   + "QUESTION_TITLE,OPTIONS_NUM, "
			   + "OPTIONS_NAME " 
			   + " from question q , options o" 
			   + " where q.question_num = o.question_num(+) " 
			   + " and q.user_id = ? and q.QUESTION_NUM = ? "
			   + " order by q.QUESTION_NUM ";
			pstmt = conn.prepareStatement(sql,
					ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, userId);
			for(int i : nums) {
				pstmt.setInt(2, i);
				rs = pstmt.executeQuery();
				QuestionDTO qdto = new QuestionDTO();
				List<OptionsDTO> options = 
						new ArrayList<OptionsDTO>();
				QuestionOptionsDTO qoDTO = 
						new QuestionOptionsDTO();
				if(rs.next()) {
					qdto.setQuestionNum(
							rs.getInt("QUESTION_NUM"));
					qdto.setQuestionTitle(
							rs.getString("QUESTION_TITLE"));
				}
				rs.beforeFirst();
				while(rs.next()) {
					OptionsDTO odto = new OptionsDTO();
					odto.setOptionsName(rs.getString("OPTIONS_NAME"));
					odto.setOptionsNum(rs.getInt("OPTIONS_NUM"));
					options.add(odto);
				}
				qoDTO.setQuestion(qdto);
				qoDTO.setOptions(options);
				list.add(qoDTO);
			}
			System.out.println("aaaa :"+ list.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {close();}	
		return list; 
	}
	public void optionInsert(OptionsDTO odto) {
		conn = getConnection();
		sql = " insert into OPTIONS (user_id,QUESTION_NUM,"
			+ " OPTIONS_NUM , OPTIONS_NAME) "
			+ " values(?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, odto.getUserId());
			pstmt.setInt(2, odto.getQuestionNum());
			pstmt.setInt(3, odto.getOptionsNum());
			pstmt.setString(4, odto.getOptionsName());
			int i = pstmt.executeUpdate();
			System.out.println( i + "개가 입력되었습니다.");
		}catch(Exception e) {}finally {close();}
	}
	public int questionInsert(QuestionDTO qdto) {
		int i = 0;
		conn = getConnection();
		try {
			sql = " select nvl(max(QUESTION_NUM),0) + 1 "
					+ " from QUESTION "
					+ " where user_id = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, qdto.getUserId());
			rs = pstmt.executeQuery();
			rs.next();
			i = rs.getInt(1);
			rs.close();
			pstmt.close();
			sql = " insert into QUESTION (QUESTION_NUM,"
					+ "       QUESTION_TITLE, user_id ) "
					+ " values (?, ?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			pstmt.setString(2, qdto.getQuestionTitle());
			pstmt.setString(3, qdto.getUserId());
			int j = pstmt.executeUpdate();
			System.out.println(j + "개가 입력되었습니다.");
		}catch(Exception e) {e.printStackTrace();}
		finally {close();}
		return i;
	}
}
