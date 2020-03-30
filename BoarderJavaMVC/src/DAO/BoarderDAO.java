package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.BoarderDTO;
import DTO.FileDTO;

public class BoarderDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	Connection connection;
	Statement statement; //stmt
	String sql;
	ResultSet resultSet; // rs
	List<BoarderDTO> list;
	public BoarderDAO() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void FileInsert(List<FileDTO> list) {
		try {
			connection = DriverManager.getConnection(
					url,"STUDY","STUDY");
			statement = connection.createStatement();
			for(FileDTO fd : list) {
				sql = "insert into fileupdate("
						+ "year,model,price,mileage,color"
						+ ",transmission)"
						+ "values('"
						+ fd.getYear() + "','"
						+ fd.getModel()+"','"
						+ fd.getPrice()+"','"
						+ fd.getMileage()+ "','"
						+ fd.getColor()+ "','"
						+ fd.getTransmission()+ "')";
				statement.executeUpdate(sql);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoarderDTO bd) {
		int i = 0;
		try {
			connection = DriverManager.getConnection(
					url,"smrit","oracle");
			statement = connection.createStatement();
			sql = " update board "
				+ " set title='"+bd.getTitle()+"', "
				+ "     content = '"+bd.getContent()+"'"
				+ " where id = '"+bd.getId()+"'";
			i = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public void deleteBoard(int seq) {
		try {
			connection = DriverManager.getConnection(
					url,"smrit","oracle");
			statement = connection.createStatement();
			sql = "delete from board where id = '"
			       + seq +"'";
			int i = statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void searchBoard(int seq, BoarderDTO bd) {
		try {
			connection = DriverManager.getConnection(
					url,"smrit","oracle");
			statement = connection.createStatement();
			sql="select id, title, content "
				+ " from board "
				+ " where id = '" + seq + "'";
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			bd.setId(resultSet.getInt("id"));
			bd.setTitle(resultSet.getString(2));
			bd.setContent(resultSet.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<BoarderDTO> listBoard() {
		try {
			list = new ArrayList<BoarderDTO>();
			connection = DriverManager.getConnection(
					url,"smrit","oracle");
			statement = connection.createStatement();
			sql = "select id , title, content from board";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				BoarderDTO bd = new BoarderDTO();
				bd.setId(resultSet.getInt("id"));
				bd.setTitle(resultSet.getString(2));
				bd.setContent(
						resultSet.getString("content"));
				list.add(bd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;	
	}
	public int boarderInsert(BoarderDTO bd) {
		int result=0;
		try {
			connection = DriverManager.getConnection(
					url,"smrit","oracle");
			statement = connection.createStatement();
			sql=" insert into board (id , title, content) "
					+ " values('"+ bd.getId()+ "',"
					+ " '" + bd.getTitle() + "',"
					+ " '" + bd.getContent() + "')";
			result = statement.executeUpdate(sql);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
