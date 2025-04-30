package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddDVDToStoreScreen extends AddItemToStoreScreen {

    public AddDVDToStoreScreen(Store store) {
        super(store);
        setTitle("Add DVD to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2, 10, 10));

        // Các trường nhập liệu cho DVD
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField(20);

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField(20);

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField(20);

        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField(20);

        JLabel lengthLabel = new JLabel("Length (minutes):");
        JTextField lengthField = new JTextField(20);

        // Nút thêm vào cửa hàng
        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = 0.0f;
            try {
                cost = Float.parseFloat(costField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Tạo đối tượng DigitalVideoDisc và thêm vào cửa hàng
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, directorField.getText(), Integer.parseInt(lengthField.getText()), cost);
            store.addMedia(dvd);

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
        center.add(directorLabel);
        center.add(directorField);
        center.add(lengthLabel);
        center.add(lengthField);
        center.add(new JLabel());
        center.add(addButton);

        return center;
    }
}
