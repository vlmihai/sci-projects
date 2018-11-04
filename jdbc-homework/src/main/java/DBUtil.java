import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Lucian82";
    private static final String HOST = "localhost";
    private static final String PORT = "5432";

    public static Connection getConnection(DBType dbType) throws SQLException {
        loadDriver();
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: DB may be
        // busy, good to set a higher
        // timeout

        Connection connection = null;
        switch (dbType) {
            case MYSQL:
                connection = null;
                break;
            case ORACLE:
                connection = null;
                break;
            case POSTGRESQL:
                String url = new StringBuilder()
                        .append("jdbc:")
                        .append(dbType.toString().toLowerCase())       // “mysql” / “db2” / “mssql” / “oracle” / ...
                        .append("://")
                        .append(HOST)
                        .append(":")
                        .append(PORT)
                        .append("/")
                        .append("booking")
                        .append("?user=")
                        .append(USERNAME)
                        .append("&password=")
                        .append(PASSWORD).toString();

                connection = DriverManager.getConnection(url);
        }

        return connection;
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }
    }

}
