import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemeberDB {
	Connection con;
	private static  String dburl = "jdbc:mysql://localhost/blueshop?characterEncoding=utf-8";

	public static void main(String[] args) {
		findall();
		findone("somsak");

		

	}
	
public static void findall() 
{
		
	try (Connection connection = DriverManager.getConnection(dburl,"root","")) {
        String query = "SELECT * FROM member";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
        	String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String mobile = resultSet.getString("mobile");
            String email = resultSet.getString("email");
            System.out.println("Username: " + username+"\t" + "Password: " + password+"\t\t"+"name: " + name+"\t\t" +"address: " + address+"\t" +
            		"mobile: " + mobile+"\t" +"email: " + email);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
		
		
}
public static void findone(String username) 
{
	try (Connection connection = DriverManager.getConnection(dburl,"root","")) {
        String query = "SELECT * FROM member WHERE username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
        	String username2 = resultSet.getString("username");
            String password = resultSet.getString("password");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String mobile = resultSet.getString("mobile");
            String email = resultSet.getString("email");
            System.out.println("Username: " + username2+"\t" + "Password: " + password+"\t\t"+"name: " + name+"\t\t" +"address: " + address+"\t" +
            		"mobile: " + mobile+"\t" +"email: " + email);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
	
	
	
	
}

}


