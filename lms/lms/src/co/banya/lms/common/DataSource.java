package co.banya.lms.common;
// DAO를 만들즈아

//import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource dataSource = new DataSource();
	private Connection conn;
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "banya";
	private String password = "banya";
	
	private DataSource() {}	// 외부에서 생성할 수 없도록 private으로 생성
	
//	private void dbConfig() {	// db.properties파일 값을 가져오기
//		Properties properties = new Properties();
//		String resource = getClass().getResource("db.properties").getPath();
//		// ↑외부에서 properties 파일을 불러옴
//		// ★☆★↓ 하 드 코 딩 하 지 마 시 오↓★☆★
//		try {
//			properties.load(new FileReader(resource));	// 파일 읽어오셈
//			driver = properties.getProperty("driver");
//			url = properties.getProperty("url");
//			user = properties.getProperty("user");
//			password = properties.getProperty("password");
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//	}
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {
//		dbConfig();	// property 값을 가져 옴
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
