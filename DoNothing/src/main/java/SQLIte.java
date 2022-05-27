import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLIte {
    static Connection connection = null;
    /**
     * Conexion a la base de datos
     * @return retorna connection
     */
    public static java.sql.Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:DoNothingBot.db");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveRegister(Connection connection, String userID, String userName){
        String query = "INSERT INTO user ( userID, nameUser) VALUES"
                +"('" +userID +"', '"+userName+"');";
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void joinGroups(Connection connection, String userID, String userName){
        String query = "INSERT INTO user ( userID, nameUser) VALUES"
                +"('" +userID +"', '"+userName+"');";
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
