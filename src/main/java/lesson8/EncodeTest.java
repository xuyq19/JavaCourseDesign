package lesson8;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author LucasXu
 */
public class EncodeTest {
    public static void main(String[] args) throws Exception {
        String str = "Jackson's bike-bell cost $5 中国";
        String str2 = URLEncoder.encode(str, StandardCharsets.UTF_8);
        System.out.println(str);
        System.out.println(str2);
        String str3 = URLDecoder.decode(str2, StandardCharsets.UTF_8);
        System.out.println(str3);
    }
}
