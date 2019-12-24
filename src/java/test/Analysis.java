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

import java.util.*;

/**
 * @Author: sunhaijian
 * @Date: 2019/12/6
 * @Description:
 **/
public class Analysis {

    RequestConfig config = RequestConfig.custom().setConnectTimeout(50000).setSocketTimeout(30000).build();

    List<String> goodsNameList=new ArrayList(Arrays.asList(
            "limbo_prime_neuroptics"
            ,"chroma_prime_neuroptics"
            ,"mesa_prime_neuroptics"
            ,"stradavar_prime_blueprint"
            ,"kogake_prime_gauntlet"
            ,"tiberon_prime_barrel"
            ,"tiberon_prime_stock"
//            ,"tiberon_prime_set"
            ,"zhuge_prime_barrel"
            ,"zephyr_prime_blueprint"
            ,"zephyr_prime_systems"

    ));






    @Test
    public  void getAnalysisResult() throws Exception{
        String goodsName="limbo_prime_neuroptics";
//        String goodsName="chroma_prime_neuroptics";
//        String goodsName="mesa_prime_neuroptics";
//        String goodsName="stradavar_prime_blueprint";
//        String goodsName="kogake_prime_gauntlet";
//        String goodsName="tiberon_prime_barrel";
//        String goodsName="tiberon_prime_stock";
//        String goodsName="zhuge_prime_barrel";
//        String goodsName="zephyr_prime_blueprint";
//        String goodsName="zephyr_prime_systems";



        String url="https://api.warframe.market/v1/items/"+goodsName+"/orders";

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
                    if(jsonObject1.getDouble("platinum")<11){
                        sortedMap .putAll(getUserData(userJson.getString("ingame_name")));
                    }else {
                        continue;
                    }





                    System.out.println(userJson.getString("status"));
                }

//                System.out.println("白金："+jsonObject1.getString("platinum"));
//                System.out.println("数量："+jsonObject1.getString("quantity"));
//                System.out.println("-----------------------------------");
//                OrderBean orderBean=new OrderBean();
//                orderBean.setName(userJson.getString("ingame_name"));
//                orderBean.setPrice(jsonObject1.getDouble("platinum"));
//                orderBean.setSum(jsonObject1.getInteger("quantity"));
//                sortedMap.put(jsonObject1.getDouble("platinum"),orderBean);

            }


            sortedMap.forEach((it,it2)->{
                System.out.println(it+"::::::"+it2);
            });


        }
    }


@Test
    public void testuserdata(){
//    public void testuserdata(String userName,String goodsName,int price){

        try {
            printUserData("ademptia");

//            String userName="111";
////            String goodsName="111";
////            int price=2;


//            System.out.println("/w "+userName+" Hi! I want to buy: "+goodsName+" for "+price+" platinum. (warframe.market)");

        }catch (Exception e ){
            e.printStackTrace();
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


                for (int j = 0; j <goodsNameList.size() ; j++) {
                    if(goodsName.equals(goodsNameList.get(j))
                            &&jsonObject1.getDouble("platinum")<=11){

                        sum+= (15-jsonObject1.getDouble("platinum"))*jsonObject1.getInteger("quantity");

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

        System.out.println("用户名 ："+userName);
        System.out.println("收益 ："+sum);
        System.out.println("-----------------------------------");


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


                for (int j = 0; j <goodsNameList.size() ; j++) {
                    if(goodsName.equals(goodsNameList.get(j))
                            &&jsonObject1.getDouble("platinum")<=11){

//                        sum+= (15-jsonObject1.getDouble("platinum"))*jsonObject1.getInteger("quantity");

                        printinfo(userName,goodsEnName,jsonObject1.getDouble("platinum").intValue());
                        System.out.println("数量："+jsonObject1.getInteger("quantity"));

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

    }

}



