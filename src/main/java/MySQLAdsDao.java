
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads{
    private Connection connection;

    public MySQLAdsDao(Config cfg) throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
            cfg.getUrl(),
            cfg.getUsername(),
            cfg.getPassword()
        );
    }

    public List<Ad> all() {
        List<Ad> retVal = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Ads");
            while(rs.next()) {
                Ad a = new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                );
                retVal.add(a);
            }
        } catch (SQLException e) {
            System.out.println("MySQLAdsDao SQL Exception caught: "+e.getMessage());
        }
        return retVal;
    }

    public Long insert(Ad ad) {
        long rowsAffected = 0L;
        try {
            Statement stmt = connection.createStatement();
            rowsAffected = stmt.executeUpdate("insert into ads(user_id, title, description) values ("+ad.getUserId()+", '"+ad.getTitle()+"', '"+ad.getDescription()+"');");
        } catch (SQLException e) {
            System.out.println("MySQLAdsDao SQL Exception caught: "+e.getMessage());
        }
        return rowsAffected;
    }
}
