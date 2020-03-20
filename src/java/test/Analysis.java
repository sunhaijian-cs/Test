package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: sunhaijian
 * @Date: 2019/12/6
 * @Description:
 **/
public class Analysis {

    RequestConfig config = RequestConfig.custom().setConnectTimeout(50000).setSocketTimeout(30000).build();

    static List<String> goodsNameList=GoodsItem.getNameList();

    Set<String> allName=new HashSet();


    public static void main(String[] args) {

        try {

            Analysis analysis=new Analysis();
            analysis.getall();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




    @Test
    public void testuserdata(){
        try {
            printUserData("Miamouz");
        }catch (Exception e ){
            e.printStackTrace();
        }
    }


    @Test
    public  void getSingle() throws Exception{
        GoodsItem commodityName= GoodsItem.limbo_prime_neuroptics;

        getAnalysisResult(commodityName);

    }

    @Test
    public  void getall() throws Exception{
        GoodsItem [] goodsItemList=GoodsItem.values();
        writeFile("start\n\r",false);

        for (int i = 0; i <goodsItemList.length ; i++) {
            getAnalysisResult( goodsItemList[i]);
            System.out.println();
            System.out.println("|||||||||||||||||||||||||||||||");
            System.out.println();

        }
    }

//    @Test
    public void writeFile(String content,boolean append){
        String fileName ="test.txt";
        File file = null;
        FileWriter fw = null;
        try {
            file = new File("./"+fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            fw = new FileWriter(file,append);
            fw.write(content);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






//    @Test
    public  void getAnalysisResult(GoodsItem commodityName) throws Exception{



        String url="https://api.warframe.market/v1/items/"+commodityName.getCommodityName()+"/orders";

//        String url1="https://api.warframe.market/v1/profile/Lil-klemy/orders?include=profile";

        HttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        HttpGet httpGet = new HttpGet(url);


        HttpResponse httpResponse=httpclient.execute(httpGet);
//        System.out.println(httpResponse.getEntity().getContent());
        HttpEntity entity=httpResponse.getEntity();
        TreeMap<Integer,OrderBean> sortedMap= new TreeMap();

        String result = null;
        if (entity != null) {
            result = org.apache.http.util.EntityUtils.toString(entity, "utf-8");
            JSONObject jsonObject=JSON.parseObject(result);
            JSONArray jsonArray= jsonObject.getJSONObject("payload").getJSONArray("orders");

            for (int i = 0; i <jsonArray.size() ; i++) {
                JSONObject jsonObject1=jsonArray.getJSONObject(i);

                JSONObject userJson=jsonObject1.getJSONObject("user");
                if("offline".equals(userJson.getString("status"))
                        ||"online".equals(userJson.getString("status"))
                        ||"buy".equals(jsonObject1.getString("order_type"))){
                    continue;
                }else{
                    if(jsonObject1.getDouble("platinum")<commodityName.getThreshhold()){
                        if(allName.contains(userJson.getString("ingame_name"))){
                            continue;
                        }
                        sortedMap .putAll(getUserData(userJson.getString("ingame_name")));
                    }else {
                        continue;
                    }
                }
            }

            System.out.println(commodityName);
            sortedMap.forEach((it,it2)->{
                System.out.println(it+"::::::"+it2.getName());
            });


        }
    }





//    @Test
    public  TreeMap  getUserData(String userName) throws Exception{

        int sum=0;

//        String url="https://api.warframe.market/v1/items/limbo_prime_blueprint/orders";

        String url="https://api.warframe.market/v1/profile/"+userName+"/orders?include=profile";

        HttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        HttpGet httpGet = new HttpGet(url);


        HttpResponse httpResponse=httpclient.execute(httpGet);
        HttpEntity entity=httpResponse.getEntity();
        TreeMap<Integer,OrderBean> sortedMap= new TreeMap();

        String result = null;
        if (entity != null) {
            result = org.apache.http.util.EntityUtils.toString(entity, "utf-8");
            JSONObject jsonObject=JSON.parseObject(result);
            JSONArray jsonArray= jsonObject.getJSONObject("payload").getJSONArray("sell_orders");



            for (int i = 0; i <jsonArray.size() ; i++) {
                JSONObject jsonObject1=jsonArray.getJSONObject(i);

                String goodsName= jsonObject1.getJSONObject("item").getString("url_name");
                String goodsEnName= jsonObject1.getJSONObject("item").getJSONObject("en").getString("item_name");
                GoodsItem goodsItem=GoodsItem.getGoodsItem(goodsName);


                for (int j = 0; j <goodsNameList.size() ; j++) {
                    try {
                        if (goodsName.equals(goodsNameList.get(j))
                                && jsonObject1.getDouble("platinum") <= goodsItem.getThreshhold()) {

                            sum += (goodsItem.getReal() - jsonObject1.getDouble("platinum")) * jsonObject1.getInteger("quantity");

                        } else {
                            continue;
                        }
                    }catch(Exception e){
                        System.out.println(1);
                        e.printStackTrace();
                    }
                }
            }

            if(sum>=10){
                for (int i = 0; i <jsonArray.size() ; i++) {
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);

                    String goodsName= jsonObject1.getJSONObject("item").getString("url_name");
                    String goodsEnName= jsonObject1.getJSONObject("item").getJSONObject("en").getString("item_name");
                    GoodsItem goodsItem=GoodsItem.getGoodsItem(goodsName);

                    for (int j = 0; j <goodsNameList.size() ; j++) {
                        if(goodsName.equals(goodsNameList.get(j))
                                &&jsonObject1.getDouble("platinum")<=goodsItem.getThreshhold()){
                            System.out.println();
                            printinfo(userName,goodsEnName,jsonObject1.getDouble("platinum").intValue());
                            System.out.println("I want "+jsonObject1.getInteger("quantity"));
                            writeFile("I want "+jsonObject1.getInteger("quantity")+"\n",true);

                            allName.add(userName);

    //                        sum+= (goodsItem.getReal()-jsonObject1.getDouble("platinum"))*jsonObject1.getInteger("quantity");

                        }else {
                            continue;
                        }
                    }

                }

                writeFile("用户名 ："+userName+"\n",true);
                writeFile("收益 ："+sum+"\n",true);
                writeFile("-----------------------------------\n",true);


                System.out.println("用户名 ："+userName);
                System.out.println("收益 ："+sum);
                System.out.println("-----------------------------------");

            }
        }




        OrderBean orderBean=new OrderBean();
        orderBean.setName(userName);
//        orderBean.setPrice(jsonObject1.getDouble("platinum"));
//        orderBean.setSum(jsonObject1.getInteger("quantity"));
        orderBean.setEarn(sum);
        sortedMap.put(sum,orderBean);




        return sortedMap;

    }




    public  void printUserData(String userName) throws Exception{

        int sum=0;

//        String url="https://api.warframe.market/v1/items/limbo_prime_blueprint/orders";

        String url="https://api.warframe.market/v1/profile/"+userName+"/orders?include=profile";

        HttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        HttpGet httpGet = new HttpGet(url);


        HttpResponse httpResponse=httpclient.execute(httpGet);
//        System.out.println(httpResponse.getEntity().getContent());
        HttpEntity entity=httpResponse.getEntity();
        TreeMap<Integer,OrderBean> sortedMap= new TreeMap();

        String result = null;
        if (entity != null) {
            result = org.apache.http.util.EntityUtils.toString(entity, "utf-8");
            JSONObject jsonObject=JSON.parseObject(result);
            JSONArray jsonArray= jsonObject.getJSONObject("payload").getJSONArray("sell_orders");

            for (int i = 0; i <jsonArray.size() ; i++) {
                JSONObject jsonObject1=jsonArray.getJSONObject(i);

                String goodsName= jsonObject1.getJSONObject("item").getString("url_name");
                String goodsEnName= jsonObject1.getJSONObject("item").getJSONObject("en").getString("item_name");
                GoodsItem goodsItem=GoodsItem.getGoodsItem(goodsName);

                for (int j = 0; j <goodsNameList.size() ; j++) {
                    if(goodsName.equals(goodsNameList.get(j))
                            &&jsonObject1.getDouble("platinum")<=goodsItem.getThreshhold()){

//                        sum+= (15-jsonObject1.getDouble("platinum"))*jsonObject1.getInteger("quantity");

                        printinfo(userName,goodsEnName,jsonObject1.getDouble("platinum").intValue());
                        System.out.println("I want "+jsonObject1.getInteger("quantity"));

                    }else {
                        continue;
                    }
                }



//                System.out.println("商品："+goodsEnName);
//                System.out.println("白金："+jsonObject1.getString("platinum"));
//                System.out.println("数量："+jsonObject1.getString("quantity"));
//                System.out.println("-----------------------------------");


            }
//            System.out.println(jsonArray.size());

        }

//        System.out.println("用户名 ："+userName);
//        System.out.println("收益 ："+sum);
//        System.out.println("-----------------------------------");


        OrderBean orderBean=new OrderBean();
        orderBean.setName(userName);
//        orderBean.setPrice(jsonObject1.getDouble("platinum"));
//        orderBean.setSum(jsonObject1.getInteger("quantity"));
        orderBean.setEarn(sum);
        sortedMap.put(sum,orderBean);
    }


    public void printinfo(String userName,String goodsName,int price){


            System.out.println("/w "+userName+" Hi! I want to buy: "+goodsName+" for "+price+" platinum. (warframe.market)");

        writeFile("/w "+userName+" Hi! I want to buy: "+goodsName+" for "+price+" platinum. (warframe.market)"+"\n",true);
    }

}



