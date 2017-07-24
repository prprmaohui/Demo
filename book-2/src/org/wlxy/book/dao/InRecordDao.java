package org.wlxy.book.dao;

import java.util.Collection;

import org.wlxy.book.vo.InRecord;

/**
 * @ClassName InRecordDao
 * @Description TODO(�鱾������ݲ�Dao�ӿ�)
 * @author huangtao
 * @Date 2017��7��10�� ����10:11:16
 * @version 1.0.0
 */
public interface InRecordDao {
    
    
    /**
     * �������������������¼
     * @param begin ��ʼ���ڵ��ַ���
     * @param end �������ڵ��ַ�
     * @return
     */
    Collection<InRecord> findByDate(String begin, String end);
     
    
    //����ID�����鱾����¼
     
    InRecord findByID(String id);
    
 
    //�����鱾����¼
    String   save(InRecord InRecord);
     
}
