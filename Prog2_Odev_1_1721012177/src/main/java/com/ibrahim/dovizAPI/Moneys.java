/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibrahim.dovizAPI;

/**
 *
 * @author ibrahim
 */
public enum Moneys {
    
    // 3 Farklı Moneys kullanımı var.
    // 1- "ALL" Tüm Parabirimlerinin Alış ve Satış verilerinidi çekmek için kullanılıyor.
    // 2- "USD" ,"EUR",... vb. Belirtilen Parabiriminin Alış VE Satış verilerini çekmek için kullanılıyor.
    // 3- "USD_BUY" ,"AUD_SELL",... vb. Belirtilen Parabiriminin Alış VEYA Satış verilerini çekmek için kullanılıyor.
    
    
    ALL {
      @Override
      public String toString() {
          return  "TP.DK.USD.A-TP.DK.USD.S"+
                  "-TP.DK.AUD.A-TP.DK.AUD.S"+
                  "-TP.DK.DKK.A-TP.DK.DKK.S"+
                  "-TP.DK.EUR.A-TP.DK.EUR.S"+
                  "-TP.DK.GBP.A-TP.DK.GBP.S"+
                  "-TP.DK.CHF.A-TP.DK.CHF.S"+
                  "-TP.DK.SEK.A-TP.DK.SEK.S"+
                  "-TP.DK.CAD.A-TP.DK.CAD.S"+
                  "-TP.DK.KWD.A-TP.DK.KWD.S"+
                  "-TP.DK.NOK.A-TP.DK.NOK.S"+
                  "-TP.DK.SAR.A-TP.DK.SAR.S"+
                  "-TP.DK.JPY.A-TP.DK.JPY.S"+
                  "-TP.DK.BGN.A-TP.DK.BGN.S"+
                  "-TP.DK.RON.A-TP.DK.RON.S"+
                  "-TP.DK.RUB.A-TP.DK.RUB.S"+
                  "-TP.DK.IRR.A-TP.DK.IRR.S"+
                  "-TP.DK.CNY.A-TP.DK.CNY.S"+
                  "-TP.DK.PKR.A-TP.DK.PKR.S"+
                  "-TP.DK.QAR.A-TP.DK.QAR.S";
      }

  }, 
    
    USD {
      @Override
      public String toString() {
          return "TP.DK.USD.A-TP.DK.USD.S";
      }


  },
    
   USD_BUY {
      @Override
      public String toString() {
          return "TP.DK.USD.A";
      }

  },

  USD_SELL {
      @Override
      public String toString() {
          return "TP.DK.USD.S";
      }

  },

  AUD {
      @Override
      public String toString() {
          return "TP.DK.AUD.A-TP.DK.AUD.S";
      }
     
  },
  
  AUD_BUY {
      @Override
      public String toString() {
          return "TP.DK.AUD.A";
      }
     
  },

  AUD_SELL {
      @Override
      public String toString() {
          return "TP.DK.AUD.S";
      }

  },
  DKK {
      @Override
      public String toString() {
          return "TP.DK.DKK.A-TP.DK.DKK.S";
      }
    
  },

  DKK_BUY {
      @Override
      public String toString() {
          return "TP.DK.DKK.A";
      }
    
  },

  DKK_SELL {
      @Override
      public String toString() {
          return "TP.DK.DKK.S";
      }
     
  },
  EUR {
      @Override
      public String toString() {
          return "TP.DK.EUR.A-TP.DK.EUR.S";
      }
   
  },

  EUR_BUY {
      @Override
      public String toString() {
          return "TP.DK.EUR.A";
      }
   
  },

  EUR_SELL {
      @Override
      public String toString() {
          return "TP.DK.EUR.S";
      }
    
  },

  GBP {
      @Override
      public String toString() {
          return "TP.DK.GBP.A-TP.DK.GBP.S";
      }
    
  },

  GBP_BUY {
      @Override
      public String toString() {
          return "TP.DK.GBP.A";
      }
    
  },

  GBP_SELL {
      @Override
      public String toString() {
          return "TP.DK.GBP.S";
      }
   
  },
  CHF {
      @Override
      public String toString() {
          return "TP.DK.CHF.A-TP.DK.CHF.S";
      }

  },


  CHF_BUY {
      @Override
      public String toString() {
          return "TP.DK.CHF.A";
      }

  },

  CHF_SELL {
      @Override
      public String toString() {
          return "TP.DK.CHF.S";
      }

  },

  SEK {
      @Override
      public String toString() {
          return "TP.DK.SEK.A-TP.DK.SEK.S";
      }

  },
  
  SEK_BUY {
      @Override
      public String toString() {
          return "TP.DK.SEK.A";
      }

  },

  SEK_SELL {
      @Override
      public String toString() {
          return "TP.DK.SEK.S";
      }

  },
  CAD {
      @Override
      public String toString() {
          return "TP.DK.CAD.A-TP.DK.CAD.S";
      }

  },

  CAD_BUY {
      @Override
      public String toString() {
          return "TP.DK.CAD.A";
      }

  },

  CAD_SELL {
      @Override
      public String toString() {
          return "TP.DK.CAD.S";
      }
  },

  KWD {
      @Override
      public String toString() {
          return "TP.DK.KWD.A-TP.DK.KWD.S";
      }

  },

  KWD_BUY {
      @Override
      public String toString() {
          return "TP.DK.KWD.A";
      }

  },

  KWD_SELL {
      @Override
      public String toString() {
          return "TP.DK.KWD.S";
      }

  },

  NOK {
      @Override
      public String toString() {
          return "TP.DK.NOK.A-TP.DK.NOK.S";
      }

  },

  NOK_BUY {
      @Override
      public String toString() {
          return "TP.DK.NOK.A";
      }

  },

  NOK_SELL {
      @Override
      public String toString() {
          return "TP.DK.NOK.S";
      }

  },

  SAR{
      @Override
      public String toString() {
          return "TP.DK.SAR.A-TP.DK.SAR.S";
      }

  },

  SAR_BUY {
      @Override
      public String toString() {
          return "TP.DK.SAR.A";
      }

  },

  SAR_SELL {
      @Override
      public String toString() {
          return "TP.DK.SAR.S";
      }

  },

  JPY {
      @Override
      public String toString() {
          return "TP.DK.JPY.A-TP.DK.JPY.S";
      }

  },

  JPY_BUY {
      @Override
      public String toString() {
          return "TP.DK.JPY.A";
      }

  },

  JPY_SELL {
      @Override
      public String toString() {
          return "TP.DK.JPY.S";
      }

  },

  BGN {
      @Override
      public String toString() {
          return "TP.DK.BGN.A-TP.DK.BGN.S";
      }

  },

  BGN_BUY {
      @Override
      public String toString() {
          return "TP.DK.BGN.A";
      }

  },

  BGN_SELL {
      @Override
      public String toString() {
          return "TP.DK.BGN.S";
      }

  },
  

  RON {
      @Override
      public String toString() {
          return "TP.DK.RON.A-TP.DK.RON.S";
      }

  },

  RON_BUY {
      @Override
      public String toString() {
          return "TP.DK.RON.A";
      }

  },

  RON_SELL {
      @Override
      public String toString() {
          return "TP.DK.RON.S";
      }
 
  },

  RUB {
      @Override
      public String toString() {
          return "TP.DK.RUB.A-TP.DK.RUB.S";
      }
   
  },

  RUB_BUY {
      @Override
      public String toString() {
          return "TP.DK.RUB.A";
      }
   
  },

  RUB_SELL {
      @Override
      public String toString() {
          return "TP.DK.RUB.S";
      }

  },

  IRR {
      @Override
      public String toString() {
          return "TP.DK.IRR.A-TP.DK.IRR.S";
      }

  },

  IRR_BUY {
      @Override
      public String toString() {
          return "TP.DK.IRR.A";
      }

  },

  IRR_SELL {
      @Override
      public String toString() {
          return "TP.DK.IRR.S";
      }

  },

  CNY {
      @Override
      public String toString() {
          return "TP.DK.CNY.A-TP.DK.CNY.S";
      }

  },

  CNY_BUY {
      @Override
      public String toString() {
          return "TP.DK.CNY.A";
      }

  },

  CNY_SELL {
      @Override
      public String toString() {
          return "TP.DK.CNY.S";
      }

  },

  PKR {
      @Override
      public String toString() {
          return "TP.DK.PKR.A-TP.DK.PKR.S";
      }

  },

  PKR_BUY {
      @Override
      public String toString() {
          return "TP.DK.PKR.A";
      }

  },

  PKR_SELL {
      @Override
      public String toString() {
          return "TP.DK.PKR.S";
      }

  },

  QAR {
      @Override
      public String toString() {
          return "TP.DK.QAR.A-TP.DK.QAR.S";
      }
      
  },

  QAR_BUY {
      @Override
      public String toString() {
          return "TP.DK.QAR.A";
      }
      
  },

  QAR_SELL {
      @Override
      public String toString() {
          return "TP.DK.QAR.S";
      }
    
  }
  ;
    
}
