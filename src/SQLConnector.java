import sun.tools.asm.CatchData;

import java.sql.*;

public class SQLConnector {
    private Connection mSqlConn;
    private static String mjdbcURL = "jdbc:h2:./DifMonDB";
    private static String mUserName = "sa";
    private static String mPassword = "1G4yrHAXdzWZ";

    //Constructors
    SQLConnector(){
        new SQLConnector(mjdbcURL, mUserName, mPassword);
    }

    SQLConnector(String jdbcURL, String userName, String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            mSqlConn = DriverManager.getConnection(jdbcURL, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Methods
    public String[] getSiteURLs(){
        Statement stmt;
        ResultSet rs;
        String query = "SELECT URL FROM REF_MONITOR_SITES";
        Array a = null;
        String[] test = null;

        try {
            stmt = mSqlConn.createStatement();
            rs = stmt.executeQuery(query);
            a = rs.getArray("URL");
            test = (String[]) a.getArray();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return test;
    }

    public void closeConnection() throws Exception {
        try{
            mSqlConn.close();
        } catch (SQLException e){
            throw new SQLException();
        }
    }
}
