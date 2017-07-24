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
 * @Description TODO(书本类型Panel)
 * @author Administrator
 * @Date 2017年7月12日 下午2:32:38
 * @version 1.0.0
 */
public class BookTypePanel extends CommonJPanel {

    
    private BookTypeService bookTypeService;
    // 保存Jtable数据
    private Vector colums;
    // 标签 名称
    JLabel serchLabel;
    // 搜索框
    JTextField nameSerchText ;
    // 查询button
    JButton queryButton;

    // id(隐藏)
    JTextField bookTypeId;
    // 种类名称
    JTextField bookTypeName;

    // 简介
    JTextArea typeIntro;
 

    // 保存button
    JButton saveButton ;

    // 清空button
    JButton clearButton ;

    // 初始化列
    private void initColumns() {
        this.colums = new Vector();
        this.colums.add("id");
        this.colums.add("种类名称");
        this.colums.add("简介");
       
    }
     
    //获取列表数据
    @Override
    public Vector<String> getColumns() {
        return this.colums;
    }
  
     public BookTypePanel(BookTypeService bookTypeService){
         this.bookTypeService = bookTypeService;
         //初始化列集合
         initColumns();
         //设置列表数据
         setViewDatas();
         //设置列表
         DefaultTableModel model = new DefaultTableModel(null, this.colums);
         JTable table = new CommonJTable(model);
         setJTable(table);
         JScrollPane upPane = new JScrollPane(table);
         upPane.setPreferredSize(new Dimension(1000, 350));
         //设置添加, 修改的界面
         JPanel downPane = new JPanel();
         downPane.setLayout(new BoxLayout(downPane, BoxLayout.Y_AXIS));
         /*******************************************************/
         Box downBox1 = new Box(BoxLayout.X_AXIS);
         //新建JTextField保存id
    //     bookTypeId = new JTextField("");
         bookTypeId = new JTextField("");
         bookTypeId.setVisible(false);
         downBox1.add(bookTypeId);
         //列表下面的box
         downBox1.add(new JLabel("种类名称："));
         downBox1.add(Box.createHorizontalStrut(10));
         bookTypeName = new JTextField(10);
         downBox1.add(bookTypeName);
         downBox1.add(Box.createHorizontalStrut(400));
        
         /*******************************************************/
         Box downBox3 = new Box(BoxLayout.X_AXIS);
         downBox3.add(new JLabel("简介："));
         downBox3.add(Box.createHorizontalStrut(35));
         typeIntro = new JTextArea("", 5, 5);
         JScrollPane introScrollPane = new JScrollPane(typeIntro);
         //设置换行
         typeIntro.setLineWrap(true);
         downBox3.add(introScrollPane);
         /*******************************************************/
         Box downBox4 = new Box(BoxLayout.X_AXIS);
         saveButton = new JButton("保存");
         downBox4.add(saveButton);
         downBox4.add(Box.createHorizontalStrut(30));
         clearButton = new JButton("清空");
         downBox4.add(clearButton);
         downBox4.add(Box.createHorizontalStrut(30));
         /*******************************************************/
         downPane.add(getSplitBox());
         downPane.add(downBox1);
         downPane.add(getSplitBox());
         downPane.add(downBox3);
         downPane.add(getSplitBox());
         downPane.add(downBox4);
         /*******************查询******************/
         JPanel queryPanel = new JPanel();
         Box queryBox = new Box(BoxLayout.X_AXIS);
         queryBox.add(new JLabel("名称："));
         queryBox.add(Box.createHorizontalStrut(30));
         nameSerchText = new JTextField(20);
         queryBox.add(nameSerchText);
         queryBox.add(Box.createHorizontalStrut(30));
         queryButton = new JButton("查询");
         queryBox.add(queryButton);
         queryPanel.add(queryBox);
         this.add(queryPanel);
         
         //列表为添加界面
         JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upPane, downPane);
         split.setDividerSize(5);
         this.add(split);
         //初始化监听器
         initListeners();
     }
    //设置界面的样式
    @Override
    public void setTableFace() {
         //隐藏ID列
         getJTable().getColumn("id").setMaxWidth(-1);
         getJTable().getColumn("id").setMinWidth(-1);
         //设置简介的最大存储文本
         getJTable().getColumn("简介").setMaxWidth(400);
         getJTable().setRowHeight(30);
    }

    //清空表单的数据
    @Override
    public void clear() {
        this.refreshTable();
        this.bookTypeId.setText("");
        this.typeIntro.setText("");
        this.bookTypeName.setText("");
       
    }

    // 查询数据库并返回对应的数据格式, 调用父类的setDatas方法设置数据集合
    @Override
    public void setViewDatas() {
        // 使用业务接口得到数据
        Vector<BookType> BookType = (Vector<BookType>) bookTypeService.findAll();
        // 将数据转换成显示格式
        Vector<Vector> datas = changeDatas(BookType);
        // 调用父类的setDatas方法
        setDatas(datas);
    }

    /**
     * 将数据转换成视图表格的格式
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

    // 初始化监听器
    private void initListeners() {
        // 表格选择监听器
         getJTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                // 当选择行时鼠标释放时才执行
                if (!event.getValueIsAdjusting()) {
                    // 如果没有选中任何一行, 则返回
                    if (getJTable().getSelectedRowCount() != 1)
                        return;
                    // 调用父类的方法获得选择行的id
                    String id = getSelectId(getJTable());
                     view(id);
                }
            }
        });
       //清空按钮监听器
         clearButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent arg0) {
                 clear();
             }
         });
         //保存按钮监听器
         saveButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent arg0) {
                 save();
             }
         });
         //查询按钮监听器
         queryButton.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent arg0) {
                 query();
             }
         });
     }

    //从表单中获取数据并封装成BookType对象, 没有id
    
    private BookType getBookType() {
        String bookTypeName = this.bookTypeName.getText();
        String typeIntro = this.typeIntro.getText();
     
        return new BookType(null, bookTypeName, typeIntro);
    }
    
    // 保存表单新增的出版社数据
    private void save() {
        if (this.bookTypeName.getText().trim().equals("")) {
            //调用父类的方法，弹出错误提示
            showWarn("请输入出版社名称");
            return;
        }
        if("".equals(this.bookTypeId.getText())){
            //新增出版社
            add();
        } else{
            //修改出版社
            update();
        }
        
    }
    
    //修改出版社信息
    public void  update(){
        //取得当前修改记录的Id值
        String id = this.bookTypeId.getText().trim();
        //从表单中获取text中的值，构造一个出版社对象
        BookType bookType = getBookType();
        bookType.setID(id);
        //根据传入的出版社对象修改出版社信息
        bookTypeService.update(bookType);
        //从数据库中查询所有的记录，并在Jtable中展示
        setViewDatas();
        //刷新列表
        refreshTable();
    }
    
    //添加出版社信息
    public void add(){
        //从表单中获取text中的值，构造一个出版社对象
        BookType bookType = getBookType();
        bookTypeService.add(bookType);
        //从数据库中查询所有的记录，并在Jtable中展示
        setViewDatas();
        //清空下方表单的文本框中的数据
        clear();      
    }
    
    //按名字模糊查询
    private void query() {
        String name = this.nameSerchText.getText();
        Vector<BookType> bookTypes= (Vector<BookType>)bookTypeService.findByName(name);
        //转换数据格式
        Vector<Vector> datas =  changeDatas(bookTypes);
        //设置数据
        setDatas(datas);
        //刷新列表
        refreshTable();
    }
    
    //查看一个出版社
    private void view(String id) {
        BookType c = bookTypeService.findByID(id);
        //设置ID的JTextFiled（隐藏）
        this.bookTypeId.setText(c.getID().toString());
        //设置书本种类
        this.bookTypeName.setText(c.getTYPE_NAME());
        //设置种类介绍
        this.typeIntro.setText(c.getTYPE_INTRO());
       
    }

}
