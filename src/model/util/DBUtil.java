/* ???
 * 1. JDBC URL - oracle.jdbc.driver.OracleDriver
 */
package model.util;

import java.io.FileInputStream;
import java.util.Properties;


public class DBUtil {
	private static Properties admin = new Properties();
	static {
		try {
			admin.load(new FileInputStream("admin.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getAdminId() {
		return admin.getProperty("admin.id");
	}
	
	public static String getAdminPw() {
		return admin.getProperty("admin.pw");
	}
}
