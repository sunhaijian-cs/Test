package algo.lc;

import org.junit.Test;

import java.util.regex.Pattern;
import java.util.regex.Pattern;
/**
 * @Author: sunhaijian
 * @Date: 2020/6/16
 * @Description:
 **/
public class Validate_IP_Address_468 {

        String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
        Pattern pattenIPv4 =
                Pattern.compile("^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$");

        String chunkIPv6 = "([0-9a-fA-F]{1,4})";
        Pattern pattenIPv6 =
                Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");
        @Test
        public void test(){

            System.out.println(validIPAddress("0.4.1.1"));
        }


        public String validIPAddress(String IP) {
            if (pattenIPv4.matcher(IP).matches()) {
                return "IPv4";
            }
            return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
        }

}
