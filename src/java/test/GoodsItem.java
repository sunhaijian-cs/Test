package test;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunhaijian on 2019/12/24
 */
public enum GoodsItem {

    /**
     *
     */
    limbo_prime_neuroptics("limbo_prime_neuroptics",11,15),
    chroma_prime_neuroptics("chroma_prime_neuroptics",11,15),
    mesa_prime_neuroptics("mesa_prime_neuroptics",11,15),
    dethcube_prime_blueprint("dethcube_prime_blueprint",11,15),
    wukong_prime_blueprint("wukong_prime_blueprint",11,15),
    pyrana_prime_blueprint("pyrana_prime_blueprint",11,15),
    stradavar_prime_blueprint("stradavar_prime_blueprint",11,15),
    kogake_prime_gauntlet("kogake_prime_gauntlet",11,15),
    tiberon_prime_barrel("tiberon_prime_barrel",11,15),
    tiberon_prime_stock("tiberon_prime_stock",11,15),
    zhuge_prime_barrel("zhuge_prime_barrel",11,15),
    zephyr_prime_blueprint("zephyr_prime_blueprint",11,15),
    zephyr_prime_systems("zephyr_prime_systems",11,15),
    akstiletto_prime_blueprint("akstiletto_prime_blueprint",11,15)



//    ,
//    pyrana_prime_set("pyrana_prime_set",14,19),
//    tiberon_prime_set("tiberon_prime_set",25,34)
    ;


    /**
     * 商品名称
     */
    private String commodityName;
    /**
     * 阈值，超过这个值不做计算
     */
    private int threshhold;
    /**
     * 实际价值
     */
    private int real;

    GoodsItem(String commodityName, int threshhold,int real) {
        this.commodityName = commodityName;
        this.threshhold = threshhold;
        this.real= real;
    }

    public static GoodsItem getGoodsItem(String goodsName) {

        if (StringUtils.isBlank(goodsName)) {
            return null;
        }


        for (GoodsItem g : GoodsItem.values()) {
            if(g.getCommodityName().equals(goodsName)){
                return g;
            }
        }

        return null;

//        switch (goodsName) {
//            case "limbo_prime_neuroptics":
//                return GoodsItem.limbo_prime_neuroptics;
//            case "chroma_prime_neuroptics":
//                return GoodsItem.chroma_prime_neuroptics;
//            case "mesa_prime_neuroptics":
//                return GoodsItem.mesa_prime_neuroptics;
//            case "dethcube_prime_blueprint":
//                return GoodsItem.dethcube_prime_blueprint;
//            case "wukong_prime_blueprint":
//                return GoodsItem.wukong_prime_blueprint;
//            case "pyrana_prime_blueprint":
//                return GoodsItem.pyrana_prime_blueprint;
//            case "stradavar_prime_blueprint":
//                return GoodsItem.stradavar_prime_blueprint;
//            case "kogake_prime_gauntlet":
//                return GoodsItem.kogake_prime_gauntlet;
//            case "tiberon_prime_barrel":
//                return GoodsItem.tiberon_prime_barrel;
//            case "tiberon_prime_stock":
//                return GoodsItem.tiberon_prime_stock;
//            case "zhuge_prime_barrel":
//                return GoodsItem.zhuge_prime_barrel;
//            case "zephyr_prime_blueprint":
//                return GoodsItem.zephyr_prime_blueprint;
//            case "zephyr_prime_systems":
//                return GoodsItem.zephyr_prime_systems;
//            case "tiberon_prime_set":
//                return GoodsItem.tiberon_prime_set;
//            case "pyrana_prime_set":
//                return GoodsItem.pyrana_prime_set;
//            case "akstiletto_prime_blueprint":
//                return GoodsItem.akstiletto_prime_blueprint;
//
//            default:
//                return null;
//        }
    }




    public static List<String> getNameList(){
        List<String> ss=new ArrayList<>();
        for (GoodsItem g : GoodsItem.values()) {
            ss.add(g.getCommodityName());
        }
        return ss;
    }




    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public int getThreshhold() {
        return threshhold;
    }

    public void setThreshhold(int threshhold) {
        this.threshhold = threshhold;
    }

    public int getReal() {
        return real;
    }

    public void setReal(int real) {
        this.real = real;
    }
}
