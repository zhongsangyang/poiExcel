import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
* 最后一行是空行就少一次，最后一行没空行就应该是行数相等的值
*
* http://blog.csdn.net/zhu1qiu/article/details/71170850 map遍历的五种方法
* */
public class CompareRubyRbFileTest {
    @Test
   public void CompareFileIsSame() {
        FileReader fileReader = null;
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(new File("F:\\RedisInsatall\\6379\\redis-trib.rb"));
            fileReader2 = new FileReader(new File("F:\\RedisInsatall\\6379\\rubyrb.rb"));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
            String str = null;
            String str1 = null;
            int rowNumber = 1, count = 0;
            int rowNumber2 = 1;
            Map<Integer, String> map = new HashMap();
            Map<Integer, String> map1 = new HashMap();
            while ((str = bufferedReader.readLine()) != null) {
                map.put(rowNumber, str);
                ++rowNumber;
            }
            while ((str1 = bufferedReader2.readLine()) != null) {
                map1.put(rowNumber2, str1);
                ++rowNumber2;
            }
            bufferedReader.close();
            bufferedReader2.close();
            fileReader.close();
            fileReader2.close();
            Iterator iterable = map.entrySet().iterator();
            Iterator iterable1 = map1.entrySet().iterator();
            for (Iterator i = map.keySet().iterator(); i.hasNext(); ) {
                Object obj = i.next();
                for (Iterator j = map1.keySet().iterator(); j.hasNext(); ) {
                    Object object1 = j.next();
                    if (obj.equals(object1) && map.get(obj).equals(map1.get(object1))) {
                        ++count;
                    }
                }
            }
            System.out.println(count + "次");

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
}
