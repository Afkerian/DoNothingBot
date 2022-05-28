import java.sql.*;

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
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void saveRegister(Connection connection, String userID, String firstName, String lastName, String userName, String message, String idChat, String dateMessage, String nameChat){
        String query = "INSERT INTO logsMessages ( userID, firstName, lastName, userName, message, idChat, dateMessage, nameChat) VALUES"
                + "('"+userID+"', '"+firstName+"', '"+lastName+"', '"+userName+"', '"+message+"', '"+idChat+"', '"+dateMessage+"','"+nameChat+"');";

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

    public  static ResultSet getBestUsers(Connection connection){
        String query = "SELECT userName FROM logsMessages";
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }
}
