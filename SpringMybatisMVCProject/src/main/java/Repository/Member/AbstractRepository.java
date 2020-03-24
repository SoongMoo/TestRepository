package Repository.Member;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AbstractRepository {
	private SqlSessionFactory sqlSessionFactory;
	public AbstractRepository() {
		setSqlSessionFactory();
	}
	private void setSqlSessionFactory() {
		String resource = "mybatis-config1.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = 
				new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
