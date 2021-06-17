
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
//	String url = "jdbc:mysql://localhost:3306/database01?user=user01&password=password01&useSSL=false";
//	Connection connection = DriverManager.getConnection(url);
	
//	SQLの発行もPreparedStatementのプレースホルダを使ってパラメータを埋め込む！
//	userテーブルにinsert into user (email, name) values ('aaa@aaa.aaa', '山田太郎')のようなinsert文を発行する場合、
//	PreparedStatement statement = connection.prepareStatement("insert into user (email, name) values (?, ?)");
//	上記のようにパラメータの部分を？（プレースホルダ）に置き換える！
	
//	パラメータを埋め込む処理も、抽出の時と同じように以下のようになる！
//	statement.setString(1, "aaa@aaa.aaa");
//	statement.setString(2, "山田太郎");
	
//	SQLの実行は　ResultSet resultSet = statement.executeQuery();ではなく、
//	boolean result = statement.execute(); になる！！
//	trueの場合、statement.getResultSet()でResultSetが取得できる！
//	falseの場合、statement.getUpdateCount()で変更された行数が取得できる！
	
	
//	実行結果が必要ない場合は、単に statement.execute();　としても構わない！
	
	
//	まとめると、データの登録は以下のようになる！（例外処理やclose処理は別途行う必要がある！）
//	PreparedStatement statement = connection.prepareStatement("insert into user (email, name) values (? , ?)");
//	statement.setString(1, "bbb@bbb.bbb");
//	statement.setString(2, "山田三郎");
//	statement.execute();
	
	
//	データの更新は以下のようになる！
//	PreparedStatement statement = connection.prepareStatement("update user set email = ?, name = ? where id = ?");
//	statement.setString(1, "bbb@bbb.bbb");
//	statement.setString(2, "山田三郎");
//	statement.setLong(3, 1L);
//	statement.execute();
	
	
//	データの削除の場合は以下のようになる！
//	PreparedStatement statement = connection.prepareStatement("delete from user where id = ?");
//	statement.setString(1, 1L);
//	statement.execute();
	
	
//	JDBCでの例外処理
//	JDBC接続で発生する例外は、java.sql.SQLException！
	
//	データ取得処理の場合、
//	try {
////		データ所得処理
//	} catch (SQLException e) {
////		例外処理
//	}
	
	
//	データ登録処理の例外処理
//	1レコードを更新するだけなら、データの抽出処理と同じ！
//	try {
////		データ更新処理
//	} catch (SQLException e) {
////		例外処理
//	}
	
	
//	1つの処理で2レコード以上を更新しなければならないケースは注意！！
//	トランザクション、コミット、ロールバック
//	片方が成功して、もう片方が失敗するような状況を防ぐために、データベースにはトランザクションという仕組みが用意されている！
//	トランザクションとは、不可分な処理を実行する仕組み！（全ての処理が成功 or 全ての処理が失敗）
	
//	コミットとは、確定処理のことで、１つのトランザクション内で発行した全てのSQLの実行を確定する処理のこと！
//	トランザクションを使う場合、SQLを実行しただけでは結果がデータベースに反映されないので、全てのSQLを実行したら必ずコミットする必要がある！
	
//	ロールバックとは、取り消し処理のことで、１つのトランザクション内で発行した全てのSQLの実行を取り消すことができる！
//	１つ目のSQLが成功し、２つ目のSQLが失敗のような場合でも、ロールバックすることによって、１つ目のSQLで実行した更新処理もなかったことにできる！
	
	
//	トランザクション処理の実装（手順だけ）
//	Connection connection = null;
//	
//	try {
////		コネクション取得処理
//		connection = ...;
//		
////		1,自動コミットさせない設定
//		connection.setAutoCommit(false);
//		
////		SQLを発行
//		
////		2.全てのSQLが成功したので、コミット処理
//		connection.commit();
//	} catch (Exception e) {
////		3,例外が発生したのでロールバック処理
//		connection.rollback();
//	}
	
}
