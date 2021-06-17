
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
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
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
	
	
	
//	パラメータ付きのSQLの発行
//	where句を使って条件を絞って取得する方法を実装する！
//	例えば、select * from user where id = 1　のようにidが1のレコードだけを取得してみる！
	
//	上記との変更点はまずPreparedStatement！
//	PreparedStatement statement = connection.prepareStatement("select * from user where id = ?");
//	発行したいSQLはwhere id = 1だが、?を使って表記する！この？をプレースホルダという！!
//	この場合はパラメータを入れてあげる必要がある！
//	statement.executeQuery()の部分！
//	statement.setLong(1, 1L);
//	このテーブルのカラムidはデータベースのint型なので、JavaではLong型になるので、setLongでLong型のパラメータを渡す！(varcharだったらsetString)
//	setLongの第一引数は、?が登場する順番を指定する！
//	第二引数は、SQLに埋め込むパラメータそのものを指定！（この場合は、1でLong型なので、1Lを指定！）
	
//	String型のパラメータを渡したいときの例(select * from user where name = "山田太郎")
//	select * from user where name = ?
//	statement.setString(1, "山田太郎");
	
	
	
//	データ登録・更新・削除
	
//	SQLのinsert文を使ってデータの登録を行う！(Connectionを作るところまではデータの抽出と同じ！)
//	Class.forName("com.mysql.cj.jdbc.Driver");
	
}
