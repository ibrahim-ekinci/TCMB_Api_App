
package com.ibrahim.dovizAPP;

import com.ibrahim.dovizAPI.Currency;
import com.ibrahim.dovizAPI.CurrencyModule;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;



public class MainFrame extends javax.swing.JFrame {


    public MainFrame() {
      //internet bağlantısını kontrol ediyoruz...
      InternetConnectionControl();
      
      initComponents();
      
      //icon ve başlık tanımlamaları
      ImageIcon img =new ImageIcon("Image/icon.png");
      this.setIconImage(img.getImage());
      this.setTitle("Döviz Kurları");
      
      //Api den veri çekme ve JTable Bağlantısı
      getData();
          
      
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCurrencys = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableCurrencys.setAutoCreateRowSorter(true);
        jTableCurrencys.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableCurrencys.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableCurrencys.setSurrendersFocusOnKeystroke(true);
        jTableCurrencys.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCurrencysMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCurrencys);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    //Jtable da bir veriye çift tıklandıgında Tetiklenir ve Tıklanan satırdaki parabirimi detaylarını açar.
    private void jTableCurrencysMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCurrencysMouseClicked
      if (evt.getClickCount() == 2) {
        int index = jTableCurrencys.getSelectedRow();
        TableModel model = jTableCurrencys.getModel();
        String currecyShortCode =String.valueOf(model.getValueAt(index, 0));
         
        CurrencyDetailFrame detailFrame = new CurrencyDetailFrame(currecyShortCode);
        detailFrame.show();

      }
    }//GEN-LAST:event_jTableCurrencysMouseClicked


    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
              MainFrame mainFrame = new MainFrame();

              mainFrame.setVisible(true);
            }
        });
    }
    
    private void getData(){
        
        //Table Başlıkları
        String[] columnsTitle ={"Döviz Kodu","Döviz Cinsi","Döviz Alış","Döviz Satış"};

        
        String apiKey="3YVnlw1DWC";
        CurrencyModule currencyModule = new CurrencyModule(apiKey);
        
        //Ogünki verileri çekiyoruz.
        Currency[] currency = currencyModule.getAllCurrencyWithModel();
        
        //verileri oluşturdugumuz modelle bağlıyoruz.
        MyTableModel tableModel =new MyTableModel(currency,columnsTitle);
        jTableCurrencys.setModel(tableModel);
        
        
        
        
        
        // Table aralıklarını ayarlıyoruz.
        TableColumn column =null;
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            column=jTableCurrencys.getColumnModel().getColumn(i);
            if (i==0) {
                column.setPreferredWidth(70);
            }else if(i==1){
                 column.setPreferredWidth(150);
            }else{
                column.setPreferredWidth(90);
            }
        }
    }
    
    ///internet Bağlantısının olup olmadıgını kontrol ediyoruz....
    private void InternetConnectionControl(){
         try { 
                 //İNTERNET BAĞLANTISI KONTROLÜ
                 URL url = new URL("https://www.geeksforgeeks.org/"); 
                 URLConnection connection = url.openConnection(); 
                 connection.connect(); 
                 
                // System.out.println("Connection Successful"); 
             
             } 
              catch (Exception e) { 
                 //System.out.println("Internet Not Connected"); 
                 // frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                 int result = JOptionPane.showConfirmDialog(this, "Lütfen Bağlantı Sağlayıp Tekrar Deneyin.","İnternet Bağlantısı Yok.", JOptionPane.CLOSED_OPTION);
                 System.exit(0);
                  
             } 
    }
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCurrencys;
    // End of variables declaration//GEN-END:variables
}
