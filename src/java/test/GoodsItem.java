package test;

import org.apache.commons.lang3.StringUtils;

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
    stradavar_prime_blueprint("stradavar_prime_blueprint",11,15),
    kogake_prime_gauntlet("kogake_prime_gauntlet",11,15),
    tiberon_prime_barrel("tiberon_prime_barrel",11,15),
    tiberon_prime_stock("tiberon_prime_stock",11,15),
    zhuge_prime_barrel("zhuge_prime_barrel",11,15),
    zephyr_prime_blueprint("zephyr_prime_blueprint",11,15),
    zephyr_prime_systems("zephyr_prime_systems",11,15),
    tiberon_prime_set("tiberon_prime_set",24,34);



    private String commodityName;
    private int threshhold;
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
        switch (goodsName) {
            case "limbo_prime_neuroptics":
                return GoodsItem.limbo_prime_neuroptics;
            case "chroma_prime_neuroptics":
                return GoodsItem.chroma_prime_neuroptics;
            case "mesa_prime_neuroptics":
                return GoodsItem.mesa_prime_neuroptics;
            case "stradavar_prime_blueprint":
                return GoodsItem.stradavar_prime_blueprint;
            case "kogake_prime_gauntlet":
                return GoodsItem.kogake_prime_gauntlet;
            case "tiberon_prime_barrel":
                return GoodsItem.tiberon_prime_barrel;
            case "tiberon_prime_stock":
                return GoodsItem.tiberon_prime_stock;
            case "zhuge_prime_barrel":
                return GoodsItem.zhuge_prime_barrel;
            case "zephyr_prime_blueprint":
                return GoodsItem.zephyr_prime_blueprint;
            case "zephyr_prime_systems":
                return GoodsItem.zephyr_prime_systems;
            case "tiberon_prime_set":
                return GoodsItem.tiberon_prime_set;

            default:
                return null;


        }
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
