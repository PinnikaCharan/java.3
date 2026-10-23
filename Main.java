import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        String deleteSql = "DELETE FROM users WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement deleteUser = connection.prepareStatement(deleteSql)) {
            deleteUser.setInt(1, 2);

            int rowsDeleted = deleteUser.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No rows were deleted.");
            }
        } catch (SQLException e) {
            System.err.println("Database operation failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
