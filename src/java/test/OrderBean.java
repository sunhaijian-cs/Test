package test;

import lombok.Data;
import lombok.ToString;

/**
 * @Author: sunhaijian
 * @Date: 2019/12/21
 * @Description:
 **/
@Data
@ToString
public class OrderBean {

    String name;
    Double price;
    Integer sum;
    Integer earn;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getEarn() {
        return earn;
    }

    public void setEarn(Integer earn) {
        this.earn = earn;
    }
}
