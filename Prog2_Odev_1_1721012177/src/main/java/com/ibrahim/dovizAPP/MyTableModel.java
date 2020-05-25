
package com.ibrahim.dovizAPP;

import com.ibrahim.dovizAPI.Currency;
import javax.swing.table.AbstractTableModel;


public class MyTableModel extends AbstractTableModel{
    private String[] columnsTitle ;
    private Currency[] data;
    

    //Counstructor
    public MyTableModel( Currency[] data,String[] columnsTitle) {
        this.columnsTitle = columnsTitle;
        this.data = data;
    }

    
    
    @Override
    public int getRowCount() {
       return data.length;
    }

    @Override
    public int getColumnCount() {
       return columnsTitle.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//Currency Dizisi olarak gelen metodumuzu Table a işliyor.
        if (columnIndex==0) {
            return data[rowIndex].getCode();
        }else if(columnIndex==1){
            return data[rowIndex].getName();
        }else if(columnIndex==2){
            return data[rowIndex].getBuyPrice();
        }else if(columnIndex==3){
            return data[rowIndex].getSellPrice();
        }else{
            return "eror";
        }
      
     
    }

    @Override
    public String getColumnName(int columnIndex) {//Başlıkları atıyor.
        return columnsTitle[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {//Table daki hücreleri değiştirilemez yapıyor.
        return false;
    }
    
    
    
}
