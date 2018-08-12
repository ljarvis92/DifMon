import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;

public class SiteRetriever {
    public String getHTML(String URL){

        String content = null;
        URLConnection connection;

        try {
            connection =  new URL(URL).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
        }catch ( Exception ex ) {
            ex.printStackTrace();
        }

        return content;
    }
}