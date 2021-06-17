
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Jdbc_practice {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		
		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(url);
			
			connection.setAutoCommit(false);
			
			PreparedStatement statement1 = connection.prepareStatement("update user set money = money - 1000 where id = ?");
			PreparedStatement statement2 = connection.prepareStatement("update user set money = money + 1000 where id = ?");
			statement1.setLong(1, 2L);
			statement2.setLong(1, 3L);
			statement1.execute();
			statement2.execute();
			
			connection.commit();
			
		} catch (Exception e) {
			connection.rollback();
		}
	}
}
