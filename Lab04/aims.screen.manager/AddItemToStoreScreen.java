package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.store.Store;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;

        // Tạo bố cục cửa sổ
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        // Thiết lập tiêu đề và kích thước cửa sổ
        setTitle("Add Item");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Phương thức tạo phần trên của giao diện (Menu và tiêu đề)
    protected JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Phương thức tạo thanh Menu
    protected JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // Thêm các item vào menu
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(e -> {
            new StoreManagerScreen(store);
            this.dispose();
        });
        menu.add(viewStoreItem);

        JMenu smUpdateStore = new JMenu("Update Store");

        // Các item cho việc thêm sách, CD, DVD
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            new AddBookToStoreScreen(store);
            this.dispose();
        });
        smUpdateStore.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            new AddCDToStoreScreen(store);
            this.dispose();
        });
        smUpdateStore.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            new AddDVDToStoreScreen(store);
            this.dispose();
        });
        smUpdateStore.add(addDVDItem);

        menu.add(smUpdateStore);

        // Tạo thanh menu và thêm vào
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    // Phương thức tạo tiêu đề cho cửa sổ
    protected JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("Add Item to Store");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 30));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // Phương thức trừu tượng mà các lớp con cần triển khai để tạo phần nhập liệu trung tâm
    protected abstract JPanel createCenter(); 
}
