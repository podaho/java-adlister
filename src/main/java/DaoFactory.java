import java.sql.SQLException;

public class DaoFactory {
    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            try {
                adsDao = new MySQLAdsDao(new Config());
            } catch (SQLException e) {
                System.out.println("Error in Instantiating DaoFactory: "+e.getMessage());
            }
        }
        return adsDao;
    }
}
