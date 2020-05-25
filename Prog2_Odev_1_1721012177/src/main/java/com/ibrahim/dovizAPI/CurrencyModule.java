
package com.ibrahim.dovizAPI;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class CurrencyModule {
    // create Gson instance
    private  Gson gson = new Gson();
    
    //TCMB Api Key
    private  String apiKey ="XXXXXXXXXX";

    //Constructor
    public CurrencyModule(String apiKey) {
        this.apiKey=apiKey;
    }

    

    /////////////////////////////
    ///-------------------------
    // // Apilerden çekilen verileri kullanılabilir hale getiren metotlar
    //
    //Bu günki çekilen tüm parabirimi verilerini model dizisine dönüştüren metod.
    public Currency[] getAllCurrencyWithModel(){
        Map<String, ?> items = getAllCurrency();
        items.remove("Tarih");
        items.remove("UNIXTIME");
        
        Map<String,Object> sortedMap = new TreeMap<String,Object>(items);
        
        Currency[] currencys=new Currency[sortedMap.size()/2];
        
        
        boolean control=true;
        int currencyCounters=0;
        String[] holder =new String[3];
        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            if (control) {

                holder[0]=getShortCode(entry.getKey());
                holder[1]=getCurrencyName(entry.getKey());
                holder[2]=String.valueOf(entry.getValue());
                

                control=false;
            }else{
                currencys[currencyCounters]=new Currency(holder[0], holder[1], holder[2], String.valueOf(entry.getValue()));
                currencyCounters++;
                control=true;
            }
        }
        return currencys;
    }
    //
    //Tüm parabiriminin bugünki dövüz kurlarınn Hasmap olarak döndürür.
    public  HashMap<String, ?> getAllCurrency(){
        return getCurrency(Moneys.ALL).get(0);
    }
    //
    //Gelen parabiriminin bugünki dövüz kurlarınn liste olarak döndürür.
    public  List<HashMap<String, ?>> getCurrency(Moneys moneys){
        return getCurrency(moneys,currentDate(),currentDate());
    }
    //
    //!!!TARİH BİLGİLERİ  "GG-AA-YYYY" OLARAK GİRİLMELİDİR.!!!
    //Gelen parabirimi ve tarih aralıklarına göre dövüz kurlarınn liste olarak döndürür.
    public  List<HashMap<String, ?>> getCurrency(Moneys moneys,String startDate,String endDate){
        
        
        String jsonText=getStringOfJson(moneys,startDate,endDate);
        
        //Jsonumuza uygun tip belirliyoruz.
        Type listType = new TypeToken<List<HashMap<String, ?>>>(){}.getType();
        
        //Jsonumuzu liste halinde çekiyoruz.
        List<HashMap<String, ?>> listOfCurrency = gson.fromJson(jsonText, listType);

        return listOfCurrency;
    }
    ///--------------------------
    /////////////////////////////
     
     
     
     
    /////////////////////////////
    ///-------------------------
    //Gelen parabirimi ve tarih aralıklarına göre dövüz kurlarınn json dosyasını string olarak döndürür.
    private  String getStringOfJson(Moneys moneys,String startDate,String endDAte){
    
        //for all json
        String jsonText="";
        try {
             // read json url 
            URL url = new URL("https://evds2.tcmb.gov.tr/service/evds/series="+moneys+"&startDate="+startDate+"&endDate="+endDAte+"&type=json&key="+apiKey);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
           
            //convert to string
            jsonText = readAll(br);//Json dosyamızın string e dönüştürülmüş hali.
            br.close();
            
        } catch (Exception e) {
            System.out.println("Json okunurken Hata oluştu :"+e.getMessage());
        }
        //jsondan items(parabirimlerini)leriçekmek için kullanıyoruz.
        HashMap<String, String> map = gson.fromJson(jsonText, HashMap.class);     
        String items = String.valueOf(map.get("items"));
        
        return items;
    }
    ///--------------------------
    /////////////////////////////
    
    
    
    
    /////////////////////////////
    ///-------------------------
    ////String ve Enums Veriler İçin Yardımcı metotlar 
    //
    //Keyi Verilen Parabiriminin adını döndüren metod
    public String getCurrencyName(String keyCode){
        String name="";
        if (keyCode.equals("TP_DK_USD_A")|| keyCode.equals("TP_DK_USD_S")|| keyCode.equals("USD")) {
            name="ABD DOLARI";
        }else if (keyCode.equals("TP_DK_AUD_A")|| keyCode.equals("TP_DK_AUD_S")|| keyCode.equals("AUD")) {
            name="AVUSTRALYA DOLARI";
        }else if (keyCode.equals("TP_DK_DKK_A")|| keyCode.equals("TP_DK_DKK_S")|| keyCode.equals("DKK")) {
            name="DANİMARKA KRONU";
        }else if (keyCode.equals("TP_DK_EUR_A")|| keyCode.equals("TP_DK_EUR_S")|| keyCode.equals("EUR")) {
            name="EURO";
        }else if (keyCode.equals("TP_DK_GBP_A")|| keyCode.equals("TP_DK_GBP_S")|| keyCode.equals("GBP")) {
            name="İNGİLİZ STERLİNİ";
        }else if (keyCode.equals("TP_DK_CHF_A")|| keyCode.equals("TP_DK_CHF_S")|| keyCode.equals("CHF")) {
            name="İSVİÇRE FRANGI";
        }else if (keyCode.equals("TP_DK_SEK_A")|| keyCode.equals("TP_DK_SEK_S")|| keyCode.equals("SEK")) {
            name="İSVEÇ KRONU";
        }else if (keyCode.equals("TP_DK_CAD_A")|| keyCode.equals("TP_DK_CAD_S")|| keyCode.equals("CAD")) {
            name="KANADA DOLARI";
        }else if (keyCode.equals("TP_DK_KWD_A")|| keyCode.equals("TP_DK_KWD_S")|| keyCode.equals("KWD")) {
            name="KUVEYT DİNARI";
        }else if (keyCode.equals("TP_DK_NOK_A")|| keyCode.equals("TP_DK_NOK_S")|| keyCode.equals("NOK")) {
            name="NORVEÇ KRONU";
        }else if (keyCode.equals("TP_DK_SAR_A")|| keyCode.equals("TP_DK_SAR_S")|| keyCode.equals("SAR")) {
            name="SUUDİ ARABİSTAN RİYALİ";
        }else if (keyCode.equals("TP_DK_JPY_A")|| keyCode.equals("TP_DK_JPY_S")|| keyCode.equals("JPY")) {
            name="JAPON YENİ";
        }else if (keyCode.equals("TP_DK_BGN_A")|| keyCode.equals("TP_DK_BGN_S")|| keyCode.equals("BGN")) {
            name="BULGAR LEVASI";
        }else if (keyCode.equals("TP_DK_RON_A")|| keyCode.equals("TP_DK_RON_S")|| keyCode.equals("RON")) {
            name="RUMEN LEYİ";
        }else if (keyCode.equals("TP_DK_RUB_A")|| keyCode.equals("TP_DK_RUB_S")|| keyCode.equals("RUB")) {
            name="RUS RUBLESİ";
        }else if (keyCode.equals("TP_DK_IRR_A")|| keyCode.equals("TP_DK_IRR_S")|| keyCode.equals("IRR")) {
            name="İRAN RİYALİ";
        }else if (keyCode.equals("TP_DK_CNY_A")|| keyCode.equals("TP_DK_CNY_S")|| keyCode.equals("CNY")) {
            name="ÇİN YUANI";
        }else if (keyCode.equals("TP_DK_PKR_A")|| keyCode.equals("TP_DK_PKR_S")|| keyCode.equals("PKR")) {
            name="PAKİSTAN RUPİSİ";
        }else if (keyCode.equals("TP_DK_QAR_A")|| keyCode.equals("TP_DK_QAR_S")|| keyCode.equals("QAR")) {
            name="KATAR RİYALİ";
        }
        return name;
    }
    //
    //Kodu veya Keyi Verilen Parabiriminin kısa kodunu döndürür.
    public String getShortCode(String keyCode){
        return keyCode.substring(6,9);
    }
    //
    //String olarak verilen kodun hangi money oldugunu döndürür.
    public Moneys getMoney(String currencyCode){
        for (Moneys money :Moneys.values()) {
            if (money.toString().equals(currencyCode)) {
                return money;
            }
        }
        return Moneys.ALL;
    }
    //
    //json dosyamızdaki tüm veriyi okuyup string olarak döndüren metodumuz.
    //convert to string
    private  String readAll(Reader rd) throws IOException {
      StringBuilder sb = new StringBuilder();
        int cp;
         while ((cp = rd.read()) != -1) {
              sb.append((char) cp);
         }
      return sb.toString();
    }
    //
    //bugünün geçerili tarihini geriye döndürür.
    //return current date
    public  String currentDate(){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(date);
    }
    ///--------------------------
    /////////////////////////////
    
    
    
    //API KEY SETTER...
    public  void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    
    
    
    
    
    
}
