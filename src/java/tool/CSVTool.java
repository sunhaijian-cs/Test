package tool;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author: sunhaijian
 * @Date: 2020/10/14
 * @Description:
 **/
public class CSVTool {

    public static void main(String[] args) {
        String srcPath = "/Users/shj/Downloads/tempfile/2020-10-14-14-45-06_EXPORT_CSV_1567716_635_0.csv";
        String charset = "utf-8";
        try (CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(new FileInputStream(new File(srcPath)), charset))).build()) {
            Iterator<String[]> iterator = csvReader.iterator();
            int i=0;
            int count =0;
            while (iterator.hasNext()) {
                if (i==0){
                    iterator.next();
                    i++;
                    continue;
                }
                String[] strings=iterator.next();
                Integer weight=Integer.parseInt(strings[1]);
                Integer height=Integer.parseInt(strings[2]);

                String[] dar=strings[3].split(":");
                Integer w=Integer.parseInt(dar[0]);
                Integer h=Integer.parseInt(dar[1]);
//&&1.0*height/weight!=1.0*w/h
//                1.0*weight/height!=1.0*w/h
                if(1.0*weight/height!=1.0*w/h&&1.0*height/weight==1.0*w/h
                        ){
                    count++;
                    System.out.println("weight/height="+1.0*weight/height);
                    System.out.println("w/h="+1.0*w/h);

                    for (int j = 0; j <strings.length ; j++) {
                        System.out.print(strings[j]+" ");
                    }
                    System.out.println();
                }








//                Arrays.stream(iterator.next()).forEach(System.out::print);

                i++;
//                if(i>100){
//                    break;
//                }
            }

            System.out.println("count:"+count);
//            count:891606
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
