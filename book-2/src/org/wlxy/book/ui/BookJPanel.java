package org.wlxy.book.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Collection;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.wlxy.book.vo.Book;
import org.wlxy.book.ui.CommonJTable;
import org.wlxy.book.commons.ImageUtil;
import org.wlxy.book.service.BookService;
import org.wlxy.book.service.BookTypeService;
import org.wlxy.book.service.PublisherService;
import org.wlxy.book.vo.BookType;
import org.wlxy.book.vo.Publisher;


/**
 * @author huangxingbo
 * @version 1.0.0
 * @ClassName BookJPanel
 * @Description TODO(书本类UI界面)
 * @Date 2017年7月13日 上午9:46:09
 */
public class BookJPanel extends CommonJPanel {

    private PublisherService publisherService;
    private BookTypeService bookTypeService;
    private BookService bookService;

    Vector columns;
    //种类下拉框
    JComboBox typeComboBox;

    //出版社下拉框
    JComboBox publisherComboBox;

    //书本id
    JTextField bookId;

    //书本名称
    JTextField bookName;

    //书本价格
    JTextField price;

    //书本介绍
    JTextArea intro;

    JButton clearButton;

    JButton saveButton;

    //查询中的书本名称
    JTextField nameQueryTextField;

    //查询按钮
    JButton queryButton;

    //图片上传按钮
    JButton imageButton;

    //当前界面所显示的图片
    ImageIcon currentImage;

    //当前界面所显示图片的路径
    String currentImagePath;

    //显示图片的JLabel
    JLabel imageLabel;

    JTextField author;

    //文件选择器
    FileChooser chooser;

    private final static String DEFAULT_File_Path = "upload/no_pic.gif";


    //初始化列
    public void initClumns() {
        this.columns = new Vector();
        this.columns.add("id");
        this.columns.add("书本名称");
        this.columns.add("简介");
        this.columns.add("作者");
        this.columns.add("所属种类");
        this.columns.add("出版社");
        this.columns.add("库存");
        this.columns.add("价格");
    }

    public BookJPanel(BookService bookService, BookTypeService bookTypeService,
                      PublisherService publisherService) {
        this.bookService = bookService;
        this.bookTypeService = bookTypeService;
        this.publisherService = publisherService;
        setViewDatas();
        initClumns();

        //设置列表
        DefaultTableModel model = new DefaultTableModel(getDatas(), this.columns);
        JTable table = new CommonJTable(model);
        setJTable(table);

        JScrollPane upPane = new JScrollPane(table);
        upPane.setPreferredSize(new Dimension(1000, 350));

        //设置添加, 修改的界面
        JPanel downPane = new JPanel();
        downPane.setLayout(new BoxLayout(downPane, BoxLayout.X_AXIS));

        Box downBox1 = new Box(BoxLayout.X_AXIS);
        //添加id隐藏域
        bookId = new JTextField(10);
        bookId.setVisible(false);
        downBox1.add(bookId);
        //列表下面的box
        downBox1.add(new JLabel("书本名称："));
        downBox1.add(Box.createHorizontalStrut(10));
        bookName = new JTextField(10);
        downBox1.add(bookName);
        downBox1.add(Box.createHorizontalStrut(30));

        downBox1.add(new JLabel("价格："));
        downBox1.add(Box.createHorizontalStrut(10));
        price = new JTextField(10);
        downBox1.add(price);
        downBox1.add(Box.createHorizontalStrut(30));

        downBox1.add(new JLabel("作者："));
        downBox1.add(Box.createHorizontalStrut(10));
        author = new JTextField(10);
        downBox1.add(author);
        downBox1.add(Box.createHorizontalStrut(30));

        /***************************************************/
        Box downBox4 = new Box(BoxLayout.X_AXIS);

        downBox4.add(new JLabel("所属种类："));
        downBox4.add(Box.createHorizontalStrut(10));
        typeComboBox = new JComboBox();
        addBookTypes();
        downBox4.add(typeComboBox);
        downBox4.add(Box.createHorizontalStrut(30));

        downBox4.add(new JLabel("出版社："));
        publisherComboBox = new JComboBox();
        addPublishers();
        downBox4.add(publisherComboBox);
        downBox4.add(Box.createHorizontalStrut(30));

        downBox4.add(new JLabel("书本图片："));
        this.chooser = new FileChooser(this);
        imageButton = new JButton("请选择文件");
        downBox4.add(this.imageButton);
        downBox4.add(Box.createHorizontalStrut(30));

        /*******************************************************/
        Box downBox2 = new Box(BoxLayout.X_AXIS);
        downBox2.add(new JLabel("书本简介："));
        downBox2.add(Box.createHorizontalStrut(10));

        intro = new JTextArea("", 5, 5);
        JScrollPane introScrollPane = new JScrollPane(intro);
        intro.setLineWrap(true);
        downBox2.add(introScrollPane);
        downBox2.add(Box.createHorizontalStrut(30));
        /*******************************************************/
        Box downBox3 = new Box(BoxLayout.X_AXIS);

        saveButton = new JButton("保存");
        downBox3.add(saveButton);
        downBox3.add(Box.createHorizontalStrut(30));

        clearButton = new JButton("清空");
        downBox3.add(clearButton);
        downBox3.add(Box.createHorizontalStrut(30));

        /*******************************************************/
        Box downLeftBox = new Box(BoxLayout.Y_AXIS);

        downLeftBox.add(getSplitBox());
        downLeftBox.add(downBox1);
        downLeftBox.add(getSplitBox());
        downLeftBox.add(downBox4);
        downLeftBox.add(getSplitBox());
        downLeftBox.add(downBox2);
        downLeftBox.add(getSplitBox());
        downLeftBox.add(downBox3);

        Box downRightBox = new Box(BoxLayout.Y_AXIS);
        this.imageLabel = new JLabel();
        this.imageLabel.setPreferredSize(new Dimension(200, 200));
        this.currentImage = new ImageIcon(DEFAULT_File_Path);
        this.currentImagePath = DEFAULT_File_Path;
        this.imageLabel.setIcon(this.currentImage);
        JScrollPane p = new JScrollPane(this.imageLabel);
        downRightBox.add(p);

        downPane.add(downLeftBox);
        downPane.add(downRightBox);

        /*******************查询******************/
        JPanel queryPanel = new JPanel();
        Box queryBox = new Box(BoxLayout.X_AXIS);
        queryBox.add(new JLabel("书名："));
        queryBox.add(Box.createHorizontalStrut(30));
        nameQueryTextField = new JTextField(20);
        queryBox.add(nameQueryTextField);
        queryBox.add(Box.createHorizontalStrut(30));
        queryButton = new JButton("查询");
        queryBox.add(queryButton);
        queryPanel.add(queryBox);
        this.add(queryPanel);

        //列表为添加界面
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upPane, downPane);
        split.setDividerSize(5);
        this.add(split);
        //添加监听器
        initListeners();
    }


    private void initListeners() {
        //表格选择监听器
        getJTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                //当选择行时鼠标释放时才执行
                if (!event.getValueIsAdjusting()) {
                    //如果没有选中任何一行, 则返回
                    if (getJTable().getSelectedRowCount() != 1) return;
                    view();
                }
            }
        });
        //清空按钮监听器
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clear();
            }
        });
        //保存按钮监听器
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //验证空值
                if (bookName.getText().trim().equals("")) {
                    showWarn("请输入书的名称");
                    return;
                }
                save();
            }
        });
        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                query();
            }
        });
        //图片上传按钮
        imageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //   addImage();
            }
        });
        //点击图片
        imageLabel.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                //  showImageFrame();
            }
        });
    }

    //保存
    private void save() {
        //如果bookId的文本框(隐藏)的值为空, 则是新增, 否则为修改
        if (this.bookId.getText().equals("")) {
            add();
        } else {
            update();
        }
    }

    //查看书本
    private void view() {
        String id = getSelectId(getJTable());
        Book book = bookService.queryByID(id);
        this.bookId.setText(book.getID());
        this.bookName.setText(book.getBOOK_NAME());
        this.price.setText(book.getBOOK_PRICE());
        this.intro.setText(book.getBOOK_INTRO());
        this.author.setText(book.getAUTHOR());
        this.typeComboBox.setSelectedItem(makeType(book.getBookType()));
        this.publisherComboBox.setSelectedItem(makePublisher(book.getPublisher()));
        this.currentImage = new ImageIcon(book.getIMAGE_URL());
        this.currentImagePath = book.getIMAGE_URL();
        refreshImage();
    }

    //新增书本
    private void add() {
        if (!validatePrice()) {
            JOptionPane.showMessageDialog(this, "请输入正确的价格");
            return;
        }
        //新增书本时库存为0
        Book book = getBook();
        bookService.add(book);
        //重新读取数据
        setViewDatas();
        //刷新列表, 清空表单
        clear();
    }

    //验证输入
    private boolean validatePrice() {
        String price = this.price.getText();
        try {
            Integer p = Integer.parseInt(price);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    //修改书本, 修改时不需要修改库存, 因为库存取决于销售与入货
    private void update() {
        Book book = getBook();
        //由于是修改, 因此需要设置id
        book.setID(this.bookId.getText());
        bookService.update(book);
        //重新读取数据
        setViewDatas();
        //刷新列表, 清空表单
        clear();
    }

    //根据名称查询书
    private void query() {
        String name = this.nameQueryTextField.getText();
        Vector<Book> books = (Vector<Book>) bookService.queryByName(name);
        Vector<Vector> datas = changeDatas(books);
        setDatas(datas);
        refreshTable();
    }

    //将数据转换成视图表格的格式
    private Vector<Vector> changeDatas(Vector<Book> datas) {

        Vector<Vector> view = new Vector<Vector>();
        if (datas == null) return view;
        for (Book book : datas) {
            Vector v = new Vector();
            v.add(book.getID());
            v.add(book.getBOOK_NAME());
            v.add(book.getBOOK_INTRO());
            v.add(book.getAUTHOR());
            v.add(book.getBookType().getTYPE_NAME());
            v.add(book.getPublisher().getPUB_NAME());
            v.add(book.getREPERTORY_SIZE());
            v.add(book.getBOOK_PRICE());
            view.add(v);
        }
        return view;
    }

    @Override
    public Vector<String> getColumns() {
        return this.columns;
    }


    @Override
    public void setTableFace() {
        //隐藏id列
        getJTable().getColumn("id").setMinWidth(-1);
        getJTable().getColumn("id").setMaxWidth(-1);

        getJTable().getColumn("简介").setMinWidth(350);
        getJTable().setRowHeight(30);
    }

    //从界面中获取数据并封装成Book对象
    private Book getBook() {
        String bookName = this.bookName.getText();
        String price = this.price.getText();
        String intro = this.intro.getText();
        String author = this.author.getText();
        BookType type = (BookType) this.typeComboBox.getSelectedItem();
        Publisher concern = (Publisher) this.publisherComboBox.getSelectedItem();
        return new Book(null, bookName, intro, price, type.getID(),
                concern.getID(), String.valueOf(0), this.currentImagePath, author);
    }

    /*
     * 实现父类方法, 查询数据库并返回对应的数据格式, 调用父类的setDatas方法设置数据集合
     */
    @Override
    public void setViewDatas() {

        try {
            //查找对应的数据
            Vector<Book> books = (Vector<Book>) bookService.queryAll();
            //转换显示格式
            Vector<Vector> datas = changeDatas(books);
            //调用父类方法设置结果集合
            setDatas(datas);
        } catch (Exception e) {
            System.out.println("数据库无数据" + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    //清空表单, 刷新列表
    public void clear() {
        refreshTable();
        this.bookId.setText("");
        this.bookName.setText("");
        this.price.setText("");
        this.intro.setText("");
        this.author.setText("");
        this.typeComboBox.removeAllItems();
        this.publisherComboBox.removeAllItems();
        addBookTypes();
        addPublishers();
        //清空图片域
        this.currentImage = new ImageIcon(DEFAULT_File_Path);
        refreshImage();
        this.currentImagePath = DEFAULT_File_Path;
    }


    //从数据库中获取全部的种类并添加到下拉框中
    private void addBookTypes() {
        //调用种类业务接口取得全部的种类
        Collection<BookType> types = this.bookTypeService.findAll();
        for (BookType type : types) {
            //typeComboBox是种类下拉框对象
            this.typeComboBox.addItem(makeType(type));
        }
    }

    //从数据库中获取全部的出版社并添加到下拉框中
    private void addPublishers() {
        Collection<Publisher> publishers = this.publisherService.queryAll();
        for (Publisher c : publishers) {
            this.publisherComboBox.addItem(makePublisher(c));
        }
    }

    //创建一个Type对象, 用于添加到下拉框中, 该方法中创建的Type对象重写了toString和equals方法
    private BookType makeType(final BookType source) {
        BookType type = new BookType() {
            public String toString() {
                return source.getTYPE_NAME();
            }

            public boolean equals(Object obj) {
                if (obj instanceof BookType) {
                    BookType t = (BookType) obj;
                    if (getID().equals(t.getID())) return true;
                }
                return false;
            }
        };
        type.setID(source.getID());
        return type;
    }


    //创建一个Publisher对象, 用于添加到下拉框中, 该方法中创建的Concern对象重写了toString和equals方法
    private Publisher makePublisher(final Publisher c) {
        Publisher publisher = new Publisher() {
            public String toString() {
                return c.getPUB_NAME();
            }

            public boolean equals(Object obj) {
                if (obj instanceof Publisher) {
                    Publisher co = (Publisher) obj;
                    if (getID().equals(co.getID())) return true;
                }
                return false;
            }
        };
        publisher.setID(c.getID());
        return publisher;
    }

    //文件（图片）选择类
    class FileChooser extends JFileChooser {
        //书本管理界面对象
        BookJPanel bookPanel;

        public FileChooser(BookJPanel bookJPanel) {
            this.bookPanel = bookPanel;
        }

        //选择了文件后触发
        public void approveSelection() {
            //获得选择的文件
            File file = getSelectedFile();
            //调用书本管理界面对象的upload方法
            this.bookPanel.upload(file);
            super.approveSelection();
        }
    }

    //上传图片
    public void upload(File selectFile) {
        try {
            //使用uuid生成文件名，保证文件名唯一
            String uuid = ImageUtil.getUUID();
            //缩略图的url
            String smallFilePath = "upload/" + uuid + ".jpg";
            //原图的url
            String bigFilePath = "upload/" + uuid + "-big.jpg";
            //生成缩略图
            File file = ImageUtil.makeImage(selectFile, smallFilePath, "jpg", true);
            //生成原图
            File source = ImageUtil.makeImage(selectFile, bigFilePath, "jpg", false);
            //设置界面显示的图片对象
            this.currentImage = new ImageIcon(file.getAbsolutePath());
            //设置界面显示的图片url
            this.currentImagePath = smallFilePath;
            //刷新图片显示区
            refreshImage();
        } catch (Exception e) {
            e.printStackTrace();
            showWarn(e.getMessage());
        }
    }

    //刷新图片显示的JLabel
    private void refreshImage() {
        this.imageLabel.setIcon(this.currentImage);
    }


}
