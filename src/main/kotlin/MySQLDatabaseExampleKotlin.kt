// Sample from https://www.tutorialkart.com/kotlin/connect-to-mysql-database-from-kotlin-using-jdbc/
// Modified by Arturo Eduartes
// Date: 11/10/2020
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement
import java.util.Properties

// TODO: getConnection: Add parameters for user, password, database
// TODO: executeMySQLQuery: Add parameter for string of query and return array with rs data
/**
 * Program to list databases in MySQL using Kotlin
 */
object MySQLDatabaseExampleKotlin {
    internal var conn: Connection? = null
    internal var username = "root" // provide the username
    internal var password = "" // provide the corresponding password

    @JvmStatic
    fun main(args: Array<String>) {
        // make a connection to MySQL Server
        getConnection()
        // execute the query via connection object
        executeMySQLQuery()
    }

    /**
     * This method makes a connection to MySQL Server
     * In this example, MySQL Server is running in the local host (so 127.0.0.1)
     * at the standard port 3306
     */
    fun getConnection() {
        val connectionProps = Properties()
        connectionProps.put("user", username)
        connectionProps.put("password", password)
        try {
            Class.forName("org.mariadb.jdbc.Driver").newInstance()
            conn = DriverManager.getConnection(
                "jdbc:" + "mariadb" + "://" +
                    "127.0.0.1" +
                    ":" + "3306" + "/" +
                    "",
                connectionProps
            )
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } catch (ex: Exception) {
            // handle any errors
            ex.printStackTrace()
        }
    }

    fun executeMySQLQuery() {
        var stmt: Statement? = null
        var resultset: ResultSet? = null
        try {
            stmt = conn!!.createStatement()
            resultset = stmt!!.executeQuery("SHOW DATABASES;")
            if (stmt.execute("Select VERSION();")) {
                resultset = stmt.resultSet
            }
            while (resultset!!.next()) {
                println(resultset.getString(1))
            }
        } catch (ex: SQLException) {
            // handle any errors
            ex.printStackTrace()
        } finally {
            // release resources
            if (resultset != null) {
                try {
                    resultset.close()
                } catch (sqlEx: SQLException) {
                }
                resultset = null
            }
            if (stmt != null) {
                try {
                    stmt.close()
                } catch (sqlEx: SQLException) {
                }
                stmt = null
            }
            if (conn != null) {
                try {
                    conn!!.close()
                } catch (sqlEx: SQLException) {
                }
                conn = null
            }
        }
    }
}
