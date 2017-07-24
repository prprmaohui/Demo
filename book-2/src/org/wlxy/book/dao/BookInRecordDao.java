package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.BookInRecord;
import org.wlxy.book.vo.SaleRecord;

/**
 * @ClassName Book_in_record
 * @Description TODO(�鱾����¼���ݲ�dao)
 * @author huangtao
 * @Date 2017��7��10�� ����10:08:42
 * @version 1.0.0
 */
public interface BookInRecordDao {

    /**
     * ������������, ������������֮��Ľ��׼�¼
     * @param begin ��ʼ���ڵ��ַ���, ��ʽΪyyyy-MM-dd
     * @param end �������ڵ��ַ���, ��ʽΪyyyy-MM-dd
     * @return
     */
    Collection<BookInRecord> findByDate(String begin, String end);

    
    //����ID��������¼   
    BookInRecord findByID(String id);
    
 
    //������ۼ�¼
    String  save (BookInRecord bookInRecord);
    
    //��������¼����ȫ�����������¼
    Collection<BookInRecord> findByInRecord(String inRecordId);
    
}
