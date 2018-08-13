import java.lang.reflect.Array;
import java.sql.SQLException;

public class AppLauncher {
    public static void main(String[] args){
        SiteRetriever sr = new SiteRetriever();
        SQLConnector sc = new SQLConnector();

        String[] sites = (String[]) sc.getSiteURLs();

        for(int i = 0; i < sites.length; i++){
            String test = sr.getHTML(sites[1]);
            System.out.println(test);
            System.out.println();
            System.out.println("-------------------------------");
            System.out.println();
        }

        try{
            sc.closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
