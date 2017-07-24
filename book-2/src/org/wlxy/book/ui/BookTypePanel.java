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

import org.wlxy.book.service.BookTypeService;
import org.wlxy.book.vo.BookType;


/**
 * @ClassName BookTypePanel
 * @Description TODO(�鱾����Panel)
 * @author Administrator
 * @Date 2017��7��12�� ����2:32:38
 * @version 1.0.0
 */
public class BookTypePanel extends CommonJPanel {

    
    private BookTypeService bookTypeService;
    // ����Jtable����
    private Vector colums;
    // ��ǩ ����
    JLabel serchLabel;
    // ������
    JTextField nameSerchText ;
    // ��ѯbutton
    JButton queryButton;

    // id(����)
    JTextField bookTypeId;
    // ��������
    JTextField bookTypeName;

    // ���
    JTextArea typeIntro;
 

    // ����button
    JButton saveButton ;

    // ���button
    JButton clearButton ;

    // ��ʼ����
    private void initColumns() {
        this.colums = new Vector();
        this.colums.add("id");
        this.colums.add("��������");
        this.colums.add("���");
       
    }
     
    //��ȡ�б�����
    @Override
    public Vector<String> getColumns() {
        return this.colums;
    }
  
     public BookTypePanel(BookTypeService bookTypeService){
         this.bookTypeService = bookTypeService;
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
         //�������, �޸ĵĽ���
         JPanel downPane = new JPanel();
         downPane.setLayout(new BoxLayout(downPane, BoxLayout.Y_AXIS));
         /*******************************************************/
         Box downBox1 = new Box(BoxLayout.X_AXIS);
         //�½�JTextField����id
    //     bookTypeId = new JTextField("");
         bookTypeId = new JTextField("");
         bookTypeId.setVisible(false);
         downBox1.add(bookTypeId);
         //�б������box
         downBox1.add(new JLabel("�������ƣ�"));
         downBox1.add(Box.createHorizontalStrut(10));
         bookTypeName = new JTextField(10);
         downBox1.add(bookTypeName);
         downBox1.add(Box.createHorizontalStrut(400));
        
         /*******************************************************/
         Box downBox3 = new Box(BoxLayout.X_AXIS);
         downBox3.add(new JLabel("��飺"));
         downBox3.add(Box.createHorizontalStrut(35));
         typeIntro = new JTextArea("", 5, 5);
         JScrollPane introScrollPane = new JScrollPane(typeIntro);
         //���û���
         typeIntro.setLineWrap(true);
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
         
         //�б�Ϊ��ӽ���
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

    //��ձ�������
    @Override
    public void clear() {
        this.refreshTable();
        this.bookTypeId.setText("");
        this.typeIntro.setText("");
        this.bookTypeName.setText("");
       
    }

    // ��ѯ���ݿⲢ���ض�Ӧ�����ݸ�ʽ, ���ø����setDatas�����������ݼ���
    @Override
    public void setViewDatas() {
        // ʹ��ҵ��ӿڵõ�����
        Vector<BookType> BookType = (Vector<BookType>) bookTypeService.findAll();
        // ������ת������ʾ��ʽ
        Vector<Vector> datas = changeDatas(BookType);
        // ���ø����setDatas����
        setDatas(datas);
    }

    /**
     * ������ת������ͼ���ĸ�ʽ
     * 
     * @param datas
     * @return
     */
    private Vector<Vector> changeDatas(Vector<BookType> datas) {
        Vector<Vector> view = new Vector<Vector>();
        for (BookType c : datas) {
            Vector v = new Vector();
            v.add(c.getID());
            v.add(c.getTYPE_NAME());
            v.add(c.getTYPE_INTRO());
           
            view.add(v);
        }
        return view;
    }

    // ��ʼ��������
    private void initListeners() {
        // ���ѡ�������
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

    //�ӱ��л�ȡ���ݲ���װ��BookType����, û��id
    
    private BookType getBookType() {
        String bookTypeName = this.bookTypeName.getText();
        String typeIntro = this.typeIntro.getText();
     
        return new BookType(null, bookTypeName, typeIntro);
    }
    
    // ����������ĳ���������
    private void save() {
        if (this.bookTypeName.getText().trim().equals("")) {
            //���ø���ķ���������������ʾ
            showWarn("���������������");
            return;
        }
        if("".equals(this.bookTypeId.getText())){
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
        String id = this.bookTypeId.getText().trim();
        //�ӱ��л�ȡtext�е�ֵ������һ�����������
        BookType bookType = getBookType();
        bookType.setID(id);
        //���ݴ���ĳ���������޸ĳ�������Ϣ
        bookTypeService.update(bookType);
        //�����ݿ��в�ѯ���еļ�¼������Jtable��չʾ
        setViewDatas();
        //ˢ���б�
        refreshTable();
    }
    
    //��ӳ�������Ϣ
    public void add(){
        //�ӱ��л�ȡtext�е�ֵ������һ�����������
        BookType bookType = getBookType();
        bookTypeService.add(bookType);
        //�����ݿ��в�ѯ���еļ�¼������Jtable��չʾ
        setViewDatas();
        //����·������ı����е�����
        clear();      
    }
    
    //������ģ����ѯ
    private void query() {
        String name = this.nameSerchText.getText();
        Vector<BookType> bookTypes= (Vector<BookType>)bookTypeService.findByName(name);
        //ת�����ݸ�ʽ
        Vector<Vector> datas =  changeDatas(bookTypes);
        //��������
        setDatas(datas);
        //ˢ���б�
        refreshTable();
    }
    
    //�鿴һ��������
    private void view(String id) {
        BookType c = bookTypeService.findByID(id);
        //����ID��JTextFiled�����أ�
        this.bookTypeId.setText(c.getID().toString());
        //�����鱾����
        this.bookTypeName.setText(c.getTYPE_NAME());
        //�����������
        this.typeIntro.setText(c.getTYPE_INTRO());
       
    }

}
