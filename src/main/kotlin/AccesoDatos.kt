import java.sql.DriverManager
import java.sql.SQLException

object AccesoDatos {
    @Throws(SQLException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        // create connection for a server installed in localhost, with a user "root" with no password
        DriverManager.getConnection("jdbc:mariadb://localhost/", "root", null).use { conn ->
            conn.createStatement().use { stmt ->
                stmt.executeQuery("Select VERSION()").use { resultSet ->
                    // position result to first
                    val rsmd = resultSet.metaData
                    while (resultSet!!.next()) {
                        println(resultSet.getString(1))
                    }
                    // rs.first()
                    // println(rs.getString(1)) //result is "Hello World!"
                }
            }
        }
    }
}
