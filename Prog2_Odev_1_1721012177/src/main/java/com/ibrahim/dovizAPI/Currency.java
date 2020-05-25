
package com.ibrahim.dovizAPI;


public class Currency {
    private String code;
    private String name;
    private Object buyPrice;
    private Object sellPrice;

   

    
    
    
    //Constructors
    
     public Currency() {
        this.code = "";
        this.name = "";
        this.buyPrice = "";
        this.sellPrice = "";
    }
    
    public Currency(String code, String name, Object buyPrice, Object sellPrice) {
        this.code = code;
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }
    
    
    
    
    
    //getters and setters

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Object buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Object getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Object sellPrice) {
        this.sellPrice = sellPrice;
    }
    
}
