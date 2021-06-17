
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelectSample {
	
//	まずはJDBCドライバを使えるようにする！
//	Class.forName("com.mysql.cj.jdbc.Driver");
//	上記を実行することで、com.mysql.cj.jdbc.Driverのstaticブロックが実行され、ドライバが使えるようになる！
	
//	次に接続（java.sql.Connection）を作る！
//	Connectionを作るには、接続URlが必要！
//	MySQLの場合は以下のようになる！
//	jdbc:mysql://ホスト名:ポート番号/データベース名?user=ユーザー名&password=パスワード&useSSL=false
//	このURL文字列を使って、Connectionを作る！
//	String url = "jdbc:nysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";
//	Connection connection = DriverManager.getConnection(url);
	
//	Connectionができたら、データの抽出を行う！
//	データの抽出にはSQLを発行することが必要になるが、JDBCでSQLを発行するときは、java.sql.PreparedStatementクラスを使う！
//	PreparedStatement statement = connection.prepareStatement("select * from user");
	
//	次に、このPreparedStatementを実行し、実行結果を取得する！
//	実行結果は、java.sql.ResultSetクラスで受け取る！
//	ResultSet resultSet = statement.executeQuery();
	
//	結果の１行目から、varchar型のnameというカラムの値を取り出すには、
//	resultSet.getString("email");
//	intのidというカラムの値を取り出すには、
//	resultSet.getLong("id");
	
//	ResultSetには、実行したSQLの結果が全て入っている！
//	1行ずつ全てのデータを取り出すには、resultSet.next()を使って以下のようにループさせながら取り出す！
//	while (resultSet.next()) {
//		System.out.println("-----------------");
//		System.out.println(resultSet.getLong("id"));
//		System.out.println(resultSet.getString("email"));
//		System.out.println(resultSet.getString("name"));
//		System.out.println(resultSet.getDate("created_at"));
//		System.out.println(resultSet.getDate("updated_at"));
//	}
	
	
//	Connection、PreparedStatement、ResultSetのclose
//	それぞれcloseする必要がある！
//	resultSet.close();
//	statement.close();
//	connection.close();
	
//	Java7から導入された、try-with-resources構文を使うと、自動的にclose()が呼ばれるので、
//	宣言時に以下のように書くと、closeを呼ぶ必要はない！！
//	Connectionの例
//	String url = "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";
//	try (Connection connection = DriverManager.getConnection(url)) {
//	}
	
//	PreparedStatement、ResultSetの例
//	try (PreparedStatement statement = connection.prepareStatement("select * from user")) {
//		try (ResultSet resultSet = statement.executeQuery()) {
//		}
//	}
	
	
//	実際に上記処理をまとめると以下のようになる！
	
//	DriverとURLは定数にしておく！
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";
	
	public static void main(String[] args) throws ClassNotFoundException {
		try {
//			com.mysql.cj.jdbc.Driverクラスをロードして、初期化処理を行う
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
//			ドライバのクラスがクラスパスに見つからなかった場合にClassNotFoundExceptionが発生する
			e.printStackTrace();
//			ドライバが見つからない場合は、後続の処理を実行できないので、例外をthrowして処理を中断する！
			throw e;
		}
		
//		Connection、PreparedStatementをそれぞれ生成する
		try (Connection connection = DriverManager.getConnection(URL);
				PreparedStatement statement = connection.prepareStatement("select * from user")) {
			
//			StatementにSQLを文字列で与えて実行する
//			戻り値は、SQLの実行結果を表す、ResultSet！
			try (ResultSet resultSet = statement.executeQuery()) {
				
//				SQLの実行結果を、行数ぶんだけループしながら表示！
				while (resultSet.next()) {
					System.out.println("-----------------------");
					System.out.println(resultSet.getLong("id"));
					System.out.println(resultSet.getString("email"));
					System.out.println(resultSet.getString("name"));
					System.out.println(resultSet.getDate("created_at"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
