package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store);
        setTitle("Add Book to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2, 10, 10));

        // Các trường nhập liệu cho sách
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField(20);

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField(20);

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField(20);

        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField(20);

        // Nút thêm vào cửa hàng
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = 0.0f;
            try {
                cost = Float.parseFloat(costField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Tạo đối tượng Book và thêm vào cửa hàng
            Book book = new Book(store.getItemsInStore().size() + 1, title, category, cost);
            book.addAuthor(authorField.getText());
            store.addMedia(book);

            // Quay lại màn hình Store
            new StoreManagerScreen(store);
            this.dispose();
        });

        // Thêm các thành phần vào panel
        center.add(titleLabel);
        center.add(titleField);
        center.add(categoryLabel);
        center.add(categoryField);
        center.add(costLabel);
        center.add(costField);
        center.add(authorLabel);
        center.add(authorField);
        center.add(new JLabel());
        center.add(addButton);

        return center;
    }
}
