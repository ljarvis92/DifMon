public class AppLauncher {
    public static void main(String[] args){
        SiteRetriever sr = new SiteRetriever();
        String test = sr.getHTML("https://www.google.com");

        System.out.println(test);
    }
}
