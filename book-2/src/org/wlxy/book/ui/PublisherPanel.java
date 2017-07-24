package org.wlxy.book.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.wlxy.book.service.PublisherService;
import org.wlxy.book.vo.Publisher;

/**
 * @ClassName PublisherPanel
 * @Description TODO(������UI����)
 * @author huangato
 * @Date 2017��7��11�� ����2:10:09
 * @version 1.0.0
 */
public class PublisherPanel extends CommonJPanel {

    private static final long serialVersionUID = -4473474710375761300L;
    private PublisherService publisherService;
    // ����Jtable����
    private Vector colums;
    // ��ǩ ����
    JLabel serchLabel;
    // ������
    JTextField nameSerchText ;
    // ��ѯbutton
    JButton queryButton;

    // id(����)
    JTextField publisherId;
    // ����������
    JTextField publisherName;

    // ��ϵ��
    JTextField pubLinkMan;

    // ��ϵ�绰
    JTextField pubTel;

    // ���
    JTextArea pubIntro;

    // ����button
    JButton saveButton ;

    // ���button
    JButton clearButton ;

    // ��ʼ����
    private void initColumns() {
        this.colums = new Vector();
        this.colums.add("id");
        this.colums.add("����������aaa");
        this.colums.add("��ϵ��");
        this.colums.add("��ϵ�绰");
        this.colums.add("���");

    }
     
    //��ȡ�б�����
    @Override
    public Vector<String> getColumns() {
        return this.colums;
    }
  
     public PublisherPanel(PublisherService publisherService){
         this.publisherService = publisherService;
         //��ʼ���м���
         initColumns();
         //�����б�����
         setViewDatas();
         //�����б�
         DefaultTableModel model = new DefaultTableModel(null, this.colums);
         JTable table = new CommonJTable(model);
         setJTable(table);
         JScrollPane upPane = new JScrollPane(table);
         upPane.setPreferredSize(new Dimension(1000, 350));
         //��������, �޸ĵĽ���
         JPanel downPane = new JPanel();
         downPane.setLayout(new BoxLayout(downPane, BoxLayout.Y_AXIS));
         /*******************************************************/
         Box downBox1 = new Box(BoxLayout.X_AXIS);
         //�½�JTextField����id
         publisherId = new JTextField("");
         //����Ϊ���ɼ�
           publisherId.setVisible(false);
           downBox1.add(publisherId);
         //�б������box
         downBox1.add(new JLabel("���������ƣ�"));
         downBox1.add(Box.createHorizontalStrut(10));
         publisherName = new JTextField(10);
         downBox1.add(publisherName);
         downBox1.add(Box.createHorizontalStrut(400));
         /*******************************************************/
         Box downBox2 = new Box(BoxLayout.X_AXIS);
         downBox2.add(new JLabel("��  ϵ  �ˣ�"));
         downBox2.add(Box.createHorizontalStrut(10));
         pubLinkMan = new JTextField(10); 
         downBox2.add(pubLinkMan);
         downBox2.add(Box.createHorizontalStrut(50));
         downBox2.add(new JLabel("��ϵ�绰��"));
         downBox2.add(Box.createHorizontalStrut(10));
         pubTel = new JTextField(10);
         downBox2.add(pubTel);
         /*******************************************************/
         Box downBox3 = new Box(BoxLayout.X_AXIS);
         downBox3.add(new JLabel("��飺"));
         downBox3.add(Box.createHorizontalStrut(35));
         pubIntro = new JTextArea("", 5, 5);
         JScrollPane introScrollPane = new JScrollPane(pubIntro);
         //���û���
         pubIntro.setLineWrap(true);
         downBox3.add(introScrollPane);
         /*******************************************************/
         Box downBox4 = new Box(BoxLayout.X_AXIS);
         saveButton = new JButton("����");
         downBox4.add(saveButton);
         downBox4.add(Box.createHorizontalStrut(30));
         clearButton = new JButton("���");
         downBox4.add(clearButton);
         downBox4.add(Box.createHorizontalStrut(30));
         /*******************************************************/
         downPane.add(getSplitBox());
         downPane.add(downBox1);
         downPane.add(getSplitBox());
         downPane.add(downBox2);
         downPane.add(getSplitBox());
         downPane.add(downBox3);
         downPane.add(getSplitBox());
         downPane.add(downBox4);
         /*******************��ѯ******************/
         JPanel queryPanel = new JPanel();
         Box queryBox = new Box(BoxLayout.X_AXIS);
         queryBox.add(new JLabel("���ƣ�"));
         queryBox.add(Box.createHorizontalStrut(30));
         nameSerchText = new JTextField(20);
         queryBox.add(nameSerchText);
         queryBox.add(Box.createHorizontalStrut(30));
         queryButton = new JButton("��ѯ");
         queryBox.add(queryButton);
         queryPanel.add(queryBox);
         this.add(queryPanel);
         
         //�б�Ϊ���ӽ���
         JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upPane, downPane);
         split.setDividerSize(5);
         this.add(split);
         //��ʼ��������
         initListeners();
     }
    //���ý������ʽ
    @Override
    public void setTableFace() {
         //����ID��
         getJTable().getColumn("id").setMaxWidth(-1);
         getJTable().getColumn("id").setMinWidth(-1);
         //���ü������洢�ı�
         getJTable().getColumn("���").setMaxWidth(400);
         getJTable().setRowHeight(30);
    }

    //��ձ���������
    @Override
    public void clear() {
        this.refreshTable();
        this.publisherId.setText("");
        this.publisherName.setText("");
        this.pubLinkMan.setText("");
        this.pubTel.setText("");
        this.pubIntro.setText("");
    }

    // ��ѯ���ݿⲢ���ض�Ӧ�����ݸ�ʽ, ���ø����setDatas�����������ݼ���
    @Override
    public void setViewDatas() {
        // ʹ��ҵ��ӿڵõ�����
        Vector<Publisher> publisher = (Vector<Publisher>) publisherService.queryAll();
        // ������ת������ʾ��ʽ
        Vector<Vector> datas = changeDatas(publisher);
        // ���ø����setDatas����
        setDatas(datas);

    }

    /**
     * ������ת������ͼ����ĸ�ʽ
     * 
     * @param datas
     * @return
     */
    private Vector<Vector> changeDatas(Vector<Publisher> datas) {
        Vector<Vector> view = new Vector<Vector>();
        for (Publisher c : datas) {
            Vector v = new Vector();
            v.add(c.getID());
            v.add(c.getPUB_NAME());
            v.add(c.getPUB_LINK_MAN());
            v.add(c.getPUB_TEL());
            v.add(c.getPUB_INTRO());

            view.add(v);
        }
        return view;
    }

    // ��ʼ��������
    private void initListeners() {
        // ����ѡ�������
         getJTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // ��ѡ����ʱ����ͷ�ʱ��ִ��
                if (!event.getValueIsAdjusting()) {
                    // ���û��ѡ���κ�һ��, �򷵻�
                    if (getJTable().getSelectedRowCount() != 1)
                        return;
                    // ���ø���ķ������ѡ���е�id
                    String id = getSelectId(getJTable());
                     view(id);
                }
            }
        });
       //��հ�ť������
         clearButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent arg0) {
                 clear();
             }
         });
         //���水ť������
         saveButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent arg0) {
                 save();
             }
         });
         //��ѯ��ť������
         queryButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent arg0) {
                 query();
             }
         });
     }

    //�ӱ����л�ȡ���ݲ���װ��Publisher����, û��id
    
    private Publisher getPublisher() {
        String publisherName = this.publisherName.getText();
        String pubTel = this.pubTel.getText();
        String pubLinkMan = this.pubLinkMan.getText();
        String pubIntro = this.pubIntro.getText();
        return new Publisher(null, publisherName, pubTel, pubLinkMan, pubIntro);
    }
    
    // ������������ĳ���������
    private void save() {
        if (this.publisherName.getText().trim().equals("")) {
            //���ø���ķ���������������ʾ
            showWarn("���������������");
            return;
        }
        if("".equals(this.publisherId.getText())){
            //����������
            add();
        } else{
            //�޸ĳ�����
            update();
        }
        
    }
    
    //�޸ĳ�������Ϣ
    public void  update(){
        //ȡ�õ�ǰ�޸ļ�¼��Idֵ
        String id = this.publisherId.getText().trim();
        //�ӱ����л�ȡtext�е�ֵ������һ�����������
        Publisher publisher = getPublisher();
        publisher.setID_ID(id);
        //���ݴ���ĳ���������޸ĳ�������Ϣ
        publisherService.update(publisher);
        //�����ݿ��в�ѯ���еļ�¼������Jtable��չʾ
        setViewDatas();
        //ˢ���б�
        refreshTable();
    }
    
    //���ӳ�������Ϣ
    public void add(){
        //�ӱ����л�ȡtext�е�ֵ������һ�����������
        Publisher publisher = getPublisher();
        publisherService.add(publisher);
        //�����ݿ��в�ѯ���еļ�¼������Jtable��չʾ
        setViewDatas();
        //����·��������ı����е�����
        clear();      
    }
    
    //������ģ����ѯ
    private void query() {
        String name = this.nameSerchText.getText();
        Vector<Publisher> publishers= (Vector<Publisher>)publisherService.queryByName(name);
        //ת�����ݸ�ʽ
        Vector<Vector> datas =  changeDatas(publishers);
        //��������
        setDatas(datas);
        //ˢ���б�
        refreshTable();
    }
    
    //�鿴һ��������
    private void view(String id) {
        Publisher c = publisherService.queryByID(id);
        //����ID��JTextFiled�����أ�
        this.publisherId.setText(c.getID().toString());
        //���ó��������Ƶ��ı���
        this.publisherName.setText(c.getPUB_NAME());
        //������ϵ�˵��ı���
        this.pubLinkMan.setText(c.getPUB_LINK_MAN());
        //������ϵ�绰���ı���
        this.pubTel.setText(c.getPUB_TEL());
        //���ü����ı���
        this.pubIntro.setText(c.getPUB_INTRO());
    }
    
}