import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URlFileUpload {
    @Test
    public void testUrlUpload(){
        String fromUrl="https://raw.githubusercontent.com/antirez/redis/unstable/src/redis-trib.rb";
        String fromUrl1="https://gitee.com/baomidou/mybatisplus-spring-mvc/repository/archive/master.zip";
        try {
            URL url = new URL(fromUrl1);
            URLConnection conn = url.openConnection();
//设置超时间为3秒
            conn.setConnectTimeout(3*1000);
//防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");


            // 防止屏蔽程序抓取而返回403错误
//            User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.162 Safari/537.36
            InputStream inputStream=(InputStream) conn.getInputStream();
            File file=new File("D:"+File.separator+"ruby"+File.separator+"rubyrb.txt");
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            int len=0;byte buffer[]=new byte[1024];
            while ((len=inputStream.read(buffer,0,1024))!=-1){
                bufferedOutputStream.flush();
                bufferedOutputStream.write(buffer,0,len);
                byteArrayOutputStream.flush();
                byteArrayOutputStream.write(buffer,0,len);

            }
            byte byteArrayData[]=byteArrayOutputStream.toByteArray();
            String byteArrayDataString=new String(byteArrayData,"utf-8");
            System.out.println(byteArrayDataString);
            bufferedOutputStream.close();
            fileOutputStream.close();

            byteArrayOutputStream.close();
            inputStream.close();



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
