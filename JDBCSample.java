//javac JDBCSample.java 
//java -cp .:intersystems-jdbc-3.1.0.jar JDBCSample

import java.sql.*;

public class JDBCSample {
    public static void main(String[] str) throws Exception {
        String url = "jdbc:IRIS://anton-004-NLB-a28a445049b16d48.elb.us-east-1.amazonaws.com:51773/DATA";

        Class.forName("com.intersystems.jdbc.IRISDriver");
        Connection connection = DriverManager.getConnection(url,"_SYSTEM","demo");
        // Replace _SYSTEM and SYS with a username and password on your system

        String createTable = "CREATE TABLE People(ID int, FirstName varchar(255), LastName varchar(255))";
        String insert1 = "INSERT INTO People VALUES (1, 'John', 'Smith')";
        String insert2 = "INSERT INTO People VALUES (2, 'Jane', 'Doe')";
        String query = "SELECT * FROM People";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createTable);
        statement.executeUpdate(insert1);
        statement.executeUpdate(insert2);
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Printing out contents of SELECT query: ");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}