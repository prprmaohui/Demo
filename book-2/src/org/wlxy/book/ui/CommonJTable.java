package org.wlxy.book.ui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;


/**
 * @ClassName CommonJTable
 * @Description TODO( ����JTable�Ļ��� )
 * @author huangato
 * @Date 2017��7��11�� ����9:20:57
 * @version 1.0.0
 */
public  class CommonJTable extends JTable {
    
    public CommonJTable(TableModel dm) {
        super(dm);
        //���ñ��ֻ��ѡ��һ��
        getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
    }
    //��д����ķ���, ʹ���еĵ�Ԫ�񲻿ɱ༭
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
