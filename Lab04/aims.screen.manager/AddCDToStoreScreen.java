package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class AddCDToStoreScreen extends AddItemToStoreScreen {

    public AddCDToStoreScreen(Store store) {
        super(store);
        setTitle("Add CD to Store");
    }

    @Override
    protected JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));

        // Các trường nhập liệu cho CD
        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField(20);

        JLabel categoryLabel = new JLabel("Category:");
        JTextField categoryField = new JTextField(20);

        JLabel costLabel = new JLabel("Cost:");
        JTextField costField = new JTextField(20);

        JLabel artistLabel = new JLabel("Artist:");
        JTextField artistField = new JTextField(20);

        JLabel directorLabel = new JLabel("Director:");
        JTextField directorField = new JTextField(20);

        JLabel lengthLabel = new JLabel("Length (minutes):");
        JTextField lengthField = new JTextField(20);

        // Nút thêm vào cửa hàng
        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = 0.0f;
            try {
                cost = Float.parseFloat(costField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid cost", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Tạo đối tượng CompactDisc và thêm vào cửa hàng
            CompactDisc cd = new CompactDisc(
                store.getItemsInStore().size() + 1, title, category, cost,
                directorField.getText(), Integer.parseInt(lengthField.getText()), artistField.getText()
            );
            store.addMedia(cd);

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
        center.add(artistLabel);
        center.add(artistField);
        center.add(directorLabel);
        center.add(directorField);
        center.add(lengthLabel);
        center.add(lengthField);
        center.add(new JLabel());
        center.add(addButton);

        return center;
    }
}
