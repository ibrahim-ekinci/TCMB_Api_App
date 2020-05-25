
package com.ibrahim.dovizAPP;

import com.ibrahim.dovizAPI.CurrencyModule;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;



public class CurrencyDetailFrame extends javax.swing.JFrame {

    private String currecyShortCode;
    private String currencyCode;
    private String startDate;
    private String endDate;
    
    
    //Constructors
    
    public CurrencyDetailFrame() {
        //internet bağlantısını kontrol ediyoruz...
        InternetConnectionControl();
        initComponents();
    }
    //Verileri çekilecek parabirminin koduile çagırılır.
    public CurrencyDetailFrame(String currecyShortCode) {
        initComponents();
        setDefaultCloseOperation(CurrencyDetailFrame.HIDE_ON_CLOSE);
        
        //icon ve başlık tanımlamaları
        ImageIcon img =new ImageIcon("Image/icon.png");
        this.setIconImage(img.getImage());
        this.setTitle(currecyShortCode);
        
        //Gelen kod değişkenlere atanır.
        this.currecyShortCode=currecyShortCode;
        this.currencyCode="TP.DK."+currecyShortCode+".A-TP.DK."+currecyShortCode+".S";
        
        getData();//veriler çekilir.
    }
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTreeCurrency = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jDateChooserStartTime = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserEndTime = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jTreeCurrency);

        jLabel1.setText("Başlangıç Tarihi :");

        jDateChooserStartTime.setDateFormatString("dd-MM-yyyy");
        jDateChooserStartTime.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserStartTimePropertyChange(evt);
            }
        });

        jLabel2.setText("Bitiş Tarihi :");

        jDateChooserEndTime.setDateFormatString("dd-MM-yyyy");
        jDateChooserEndTime.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooserEndTimePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDateChooserEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Yeni başlangıç Tarihi seçildiğinde tetiklenir.Ve seçilen tarihleri datasını çeker.
    private void jDateChooserStartTimePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserStartTimePropertyChange
        if (jDateChooserStartTime.getDate()==null) {
            jDateChooserStartTime.setDate(addDays(new Date(), -10));
        }else{
              
            Date sellectedDate =jDateChooserStartTime.getDate();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
      
            this.startDate=String.valueOf(df.format(sellectedDate)) ;

            getData();
        }
       
    }//GEN-LAST:event_jDateChooserStartTimePropertyChange
    //Yeni Bitiş Tarihi seçildiğinde tetiklenir. Ve seçilen tarihleri datasını çeker.
    private void jDateChooserEndTimePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooserEndTimePropertyChange
        if (jDateChooserEndTime.getDate()==null) {
            jDateChooserEndTime.setDate(new Date());
        }else{
              
            Date sellectedDate =jDateChooserEndTime.getDate();
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
      
            this.endDate=String.valueOf(df.format(sellectedDate)) ;

            getData();
        }
    }//GEN-LAST:event_jDateChooserEndTimePropertyChange


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrencyDetailFrame().setVisible(true);
            }
        });
    }

    //Verilen Date'e verilen günü sayısını ekleyen metod.
    public static Date addDays(Date date, Integer days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }
    
    
    private void getData(){
       if(currecyShortCode!=null){
        //internet bağlantısını kontrol ediyoruz...
        InternetConnectionControl();
        
           //Api aracılığıyla verilerimizi çekiyoruz.
        String ApiKey="3YVnlw1DWC";
        CurrencyModule currencyModule=new CurrencyModule(ApiKey);
        List<HashMap<String, ?>> currencyList = currencyModule.getCurrency(currencyModule.getMoney(currencyCode), startDate, endDate);
        
        
        //Tree  Doldurma Başlangıç
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(currencyModule.getCurrencyName(currecyShortCode));
       
        for (HashMap<String, ?> map :currencyList) {
            DefaultMutableTreeNode currencyTarih = new DefaultMutableTreeNode(map.get("Tarih"));
             DefaultMutableTreeNode buyPriceTitle= new DefaultMutableTreeNode("Döviz Alış");
             buyPriceTitle.add(new DefaultMutableTreeNode(String.valueOf(map.get("TP_DK_"+currecyShortCode+"_A"))));
             DefaultMutableTreeNode sellPriceTitle= new DefaultMutableTreeNode("Döviz Satış");
             sellPriceTitle.add(new DefaultMutableTreeNode(String.valueOf(map.get("TP_DK_"+currecyShortCode+"_S"))));
             currencyTarih.add(buyPriceTitle);
             currencyTarih.add(sellPriceTitle);
             root.add(currencyTarih);
        }
        
        DefaultTreeModel model = new DefaultTreeModel(root);
        jTreeCurrency.setModel(model);
        //Tree Doldurma Son
       }
    }
    
    
    ///internet Bağlantısının olup olmadıgını kontrol ediyoruz....
    private void InternetConnectionControl(){
         try { 
                 //İNTERNET BAĞLANTISI KONTROLÜ
                 URL url = new URL("https://www.geeksforgeeks.org/"); 
                 URLConnection connection = url.openConnection(); 
                 connection.connect(); 
                 
                 //System.out.println("Connection Successful"); 
             
             } 
              catch (Exception e) { 
                 //System.out.println("Internet Not Connected"); 
                 // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                 int result = JOptionPane.showConfirmDialog(this, "Lütfen Bağlantı Sağlayıp Tekrar Deneyin.","İnternet Bağlantısı Yok.", JOptionPane.CLOSED_OPTION);
                 System.exit(0);
                  
             } 
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser jDateChooserEndTime;
    private com.toedter.calendar.JDateChooser jDateChooserStartTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTreeCurrency;
    // End of variables declaration//GEN-END:variables
}
