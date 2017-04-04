import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.hadoop.security.UserGroupInformation;


public class HiveConnection {
	 private static String driverName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) throws IOException, SQLException {
		// TODO Auto-generated method stub
System.out.println("Test Connection");
org.apache.hadoop.conf.Configuration conf = new     
org.apache.hadoop.conf.Configuration();
conf.set("hadoop.security.authentication", "Kerberos");
 System.setProperty("java.security.krb5.conf", "D:\\Bhasker\\hivejbdc\\krb5.ini");
UserGroupInformation.setConfiguration(conf);
UserGroupInformation.loginUserFromKeytab("username@Rr.esdfg.xxx.COM", "D:\\Bhasker\\hivejbdc\\csername.keytab");
try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
System.exit(1);
}

//replace "hive" here with the name of the user the queries should run as
Connection con = DriverManager.getConnection("jdbc:hive2://10.92.00.555:10000/Test_sit;principal=hive/yyututit.xxx.yyy.com@REG51.xxx.xxx.COM;kerberosAuthType=fromSubject","username","");
Statement stmt = con.createStatement();
String sql = ("show create table test_sit.tblsample");
ResultSet res = stmt.executeQuery(sql);
while (res.next()) {
    System.out.println(res.getString(1));
  }
String sql1 = ("show tables");
ResultSet res1 = stmt.executeQuery(sql1);
while (res1.next()) {
    System.out.println(res1.getString(1));
  }

	}

}
