import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/cse581?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "javadev";
        String password = "Java@1234";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // 🔹 UPDATE operation
            String updateQuery =
                    "UPDATE Employee SET department = 'CSE' WHERE empid = 155";

            int rows = statement.executeUpdate(updateQuery);
            System.out.println(rows + " row(s) updated.\n");

            // 🔹 DISPLAY ALL RECORDS AFTER UPDATE
            ResultSet rs = statement.executeQuery("SELECT * FROM Employee");

            System.out.println("EmpID\tName\tDepartment");

            while (rs.next()) {
                System.out.println(
                        rs.getString("empid") + "\t" +
                        rs.getString("name") + "\t" +
                        rs.getString("department")
                );
            }

        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            e.printStackTrace();
        }
    }
}
