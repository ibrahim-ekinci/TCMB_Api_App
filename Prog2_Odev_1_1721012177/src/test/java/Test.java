
import com.ibrahim.dovizAPI.Currency;
import com.ibrahim.dovizAPI.CurrencyModule;
import com.ibrahim.dovizAPI.Moneys;
import java.util.HashMap;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ibrahim
 */
public class Test {
        //Merkez Bankası Döviz Api Kullanımı.
    public static void main(String[] args) {
        
        //Your TCMB Api Key
        //https://evds2.tcmb.gov.tr/   a üye olup profil kısmından api anahtarı diyerek api anahtarınızı alabilirsiniz.
        
        String yourApiKey="3YVnlw1DWC";
        
        //create Currency instance
        CurrencyModule currency = new CurrencyModule(yourApiKey);
        
        
        ////////////////////////////////
        //------------------------------
        //getCurrency() Metodları "List<HashMap<String, ?>>" Tipinde liste döndürür.
        //getAllCurrency() Metodu "HashMap<String, ?>" Tipinde map döndürür.
        //getAllCurrencyWithModel() Metodu Currency[]  tipinde bir Model dizisi döndürür.
        ////////////////////////////////
        //Örnek getCurrency Metodları Tanımlamaları.
        //------------------
        ////Tüm Parabirimlerinin Alış Ve Satışlarını MODEL DİZİSİ olarak döndürür.(O günki)
        Currency[] currencysArray= currency.getAllCurrencyWithModel();
        //------------------
        //Tüm Parabirimlerinin Alış Ve Satışlarını Liste olarak döndürür.(O günki)
        HashMap<String, ?> allCurrencyList= currency.getAllCurrency();
        //------------------
        //Dolar Parabiriminin Alış Ve Satışlarını Liste olarak döndürür.(O günki)
        List<HashMap<String, ?>> currencyList= currency.getCurrency(Moneys.USD);
        //------------------
        //Verilen Tarihler Arasındaki Tüm Dolar Alış Ve Satışlarını Liste olarak döndürür.
        // DİKKAT ZAMAN DİLİMLERİ "GG-AA-YYYY" FORMATINDA GİRİLMELİDİR
        List<HashMap<String, ?>> currencyListDate1= 
                currency.getCurrency(Moneys.USD,"23-03-2020","23-04-2020");
        //------------------
        //Verilen Tarihten Bugüne kadarki Tüm Dolar  Satışlarını Liste olarak döndürür.
        // currency.currentDate() metodu string olarak bugünki zamanı döndürür.
        // DİKKAT ZAMAN DİLİMLERİ "GG-AA-YYYY" FORMATINDA GİRİLMELİDİR
        List<HashMap<String, ?>> currencyListDate2= 
                currency.getCurrency(Moneys.USD_SELL,"20-03-2020",currency.currentDate());
        //------------------------------
        ////////////////////////////////
        
        
        
        
        ////////////////////////////////
        //-----------------------------
        //getCurrency Metodlarında Gelen Listelerin Kullanımı
        ///////////////////////////////
        //getAllCurrencyWithModel() Kullanımı
        System.out.println("Parabirimi Kodu :"+currencysArray[0].getCode());//Parabirimi Kodunu Döndürür örn:"USD"
        currencysArray[0].getName();//Parabirimi Adını Döndürür örn:"ABD Doları"
        currencysArray[0].getBuyPrice();//Parabirimi Alış Fiyatını Döndürür örn:"5.5432"
        currencysArray[0].getSellPrice();//Parabirimi Satış Fiyatını Döndürür örn:"5.5432"
        ///////////////////////////////
        //List de günler Hasmap de parabirimleri ve değerler tutulur.
        //-----------------------------
        //20-03-2020 Tarihi(Yani listelin ilk elemanı) Dolar alış kurunu döndürür.
        System.out.println(currencyListDate1.get(0).get("TP_DK_USD_A"));
        //Listedeki Son Tarihi(Yani listelin son elemanı) Dolar alış kurunu döndürür.
        System.out.println(currencyListDate1.get(currencyListDate1.size()-1).get("TP_DK_USD_A"));
        //
        //Hashmap keyleri kullanımı
        //"Tarih" bu key Tarih değerini tutar..
        //"TP_DK_USD_A" Keyinde "USD" Dolar PARA BİRİMİNİ "A" ise ALIŞ ı temsil eder.
        //"TP_DK_EUR_S" Keyinde "EUR" Euro PARA BİRİMİNİ "S" ise SATIŞ ı temsil eder.
        
        //---TÜM KEYLER
        //"Tarih"    Tarih değerini tutar
        //"TP_DK_USD_A"   "TP_DK_USD_S"   ABD DOLARI
        //"TP_DK_AUD_A"   "TP_DK_AUD_S"   AVUSTRALYA DOLARI
        //"TP_DK_DKK_A"   "TP_DK_DKK_S"   DANİMARKA KRONU
        //"TP_DK_EUR_A"   "TP_DK_EUR_S"   EURO
        //"TP_DK_GBP_A"   "TP_DK_GBP_S"   İNGİLİZ STERLİNİ
        //"TP_DK_CHF_A"   "TP_DK_CHF_S"   İSVİÇRE FRANGI
        //"TP_DK_SEK_A"   "TP_DK_SEK_S"   İSVEÇ KRONU
        //"TP_DK_CAD_A"   "TP_DK_CAD_S"   KANADA DOLARI
        //"TP_DK_KWD_A"   "TP_DK_KWD_S"   KUVEYT DİNARI
        //"TP_DK_NOK_A"   "TP_DK_NOK_S"   NORVEÇ KRONU
        //"TP_DK_SAR_A"   "TP_DK_SAR_S"   SUUDİ ARABİSTAN RİYALİ
        //"TP_DK_JPY_A"   "TP_DK_JPY_S"   JAPON YENİ
        //"TP_DK_BGN_A"   "TP_DK_BGN_S"   BULGAR LEVASI
        //"TP_DK_RON_A"   "TP_DK_RON_S"   RUMEN LEYİ
        //"TP_DK_RUB_A"   "TP_DK_RUB_S"   RUS RUBLESİ
        //"TP_DK_IRR_A"   "TP_DK_IRR_S"   İRAN RİYALİ
        //"TP_DK_CNY_A"   "TP_DK_CNY_S"   ÇİN YUANI
        //"TP_DK_PKR_A"   "TP_DK_PKR_S"   PAKİSTAN RUPİSİ
        //"TP_DK_QAR_A"   "TP_DK_QAR_S"   KATAR RİYALİ
        //------------------------------
        ////////////////////////////////
        
        
        
        //KOD VE İSİM DÖNÜŞÜMLERİ
        
        //Listeden çekilen key i isime çevirir.
        System.out.println(currency.getCurrencyName("TP_DK_QAR_S"));
        
        //getMoney metodu Hasmap keyi verilen veya kısa kodu("USD") Verilen string veriyi Money olarak dönrüüyor.
        Moneys money = currency.getMoney("USD");
        
        //Keyi veya kodu verilen parabiriminin kısa kodunu döndürür. ÖRN : "TP_DK_QAR_S" :"QAR"
        System.out.println(currency.getShortCode("TP_DK_QAR_S"));
        System.out.println(currency.getShortCode("TP.DK.QAR.S"));
        System.out.println(currency.getShortCode(Moneys.QAR_BUY.toString()));
    }
}
