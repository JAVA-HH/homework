package homwork;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

public class Copy {
    public static void main(String[] args) throws IOException {
        Random random = new Random ( );
        HttpURLConnection connection = (HttpURLConnection)
                new URL ("https://tieba.baidu.com/p/2256306796?red_tag=1781367364").openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader buffer = new BufferedReader ( new InputStreamReader ( in ) );
        while (true){
            String s = buffer.readLine ( );
            if (s==null){
                break;
            }else {
                if (s.contains ( "<img" )){
                    show(s,random);
                }
            }
        }
    }

    private static void show(String s, Random random)throws IOException {
        int imgindex = s.indexOf("<img");
        String s1 = s.substring(imgindex);
        System.out.println(s1);
        int srcindex = s1.indexOf("src=");
        String s2 = s1.substring(srcindex+5);
        int yinindex = s2.indexOf("\"");
        String s3 = s2.substring(0, yinindex);
     //   System.out.println(s3);
        if (s3.startsWith("http")){
            HttpURLConnection urlConnection = (HttpURLConnection) new URL(s3).openConnection();
            InputStream in = urlConnection.getInputStream();
            String i = random.nextInt()+"";
            FileOutputStream out = new FileOutputStream("E:\\tupian\\demo\\aaa\\" + i + ".png");
            while (true){
                byte[] bytes = new byte[1024 * 8];
                int len = in.read(bytes);
                if (len==-1){
                    break;
                }
                out.write(bytes,0,len);
            }
        }
        String str = s2.substring(yinindex);
        if (str.contains("<img")){
            show(str,random);
        }
    }
}
