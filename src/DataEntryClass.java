import java.sql.*;
import javax.swing.*;

public class DataEntryClass {

	public static Connection ConnectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/dataform", "root", "");
			JOptionPane.showMessageDialog(null, "Connection Made");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
			return null;

		}

	}

}
