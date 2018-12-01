

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Demo {
    public static void main(String[] args) {
        String url="https://tieba.baidu.com/p/2256306796?red_tag=1781367364";
        String result="";
        BufferedReader in=null;
        try {
            URL  realUrl=new URL(url);
            URLConnection connection=realUrl.openConnection();
            connection.connect();
            in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line=in.readLine())!=null){
                result+=line+"\n";
            }
        } catch (Exception e) {
            System.out.println("发送get请求出现异常"+e);
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        System.out.println(result);
    }
}
