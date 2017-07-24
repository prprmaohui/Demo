package org.wlxy.book.service;

import java.util.Collection;
import java.util.Date;

import org.wlxy.book.vo.InRecord;

/**
 * @ClassName InRecordService
 * @Description TODO(����¼Service��ӿ�)
 * @author huangtao
 * @Date 2017��7��10�� ����2:17:56
 * @version 1.0.0
 */
public interface InRecordService {
    //����¼��Ϣ��� 
    InRecord add (InRecord  inRecord);   
    
    //��ѯȫ������¼
    Collection<InRecord> queryAll(Date date);   
    //����ID��ѯ����¼
    InRecord queryByID(String id );
    
    /**
     * �������ڲ��Ҷ�Ӧ������¼
     * @param date
     * @return
     */
    Collection<InRecord> getAll(Date date);
   
}
