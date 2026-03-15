import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    public static void main(String[] args) {

        // JDBC URL, username, and password
        String url = "jdbc:mysql://localhost:3306/cse581?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "javadev";       // Your MySQL user
        String password = "Java@1234"; // Your MySQL password

        // Example: Delete employee with empid 144
        String deleteQuery = "DELETE FROM Employee WHERE empid = 144";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {

            // Execute the DELETE query
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            System.out.println("Delete successful! Rows affected: " + rowsDeleted);
            System.out.println();

            // Now display the remaining table rows
            ResultSet rs = statement.executeQuery("SELECT * FROM Employee");

            // Print table header
            System.out.println("EmpID\tName\tDepartment");

            // Iterate over the ResultSet
            while (rs.next()) {
                String empid = rs.getString("empid");
                String name = rs.getString("name");
                String department = rs.getString("department");

                System.out.println(empid + "\t" + name + "\t" + department);
            }

            rs.close(); // Close ResultSet

        } catch (SQLException e) {
            System.out.println("Database operation failed!");
            e.printStackTrace();
        }
    }
}
