import javax.swing.JOptionPane;
public class caculate {
    public static void main(String[] args) {
        String strNum1 = JOptionPane.showInputDialog("Enter 1st number:");
        double num1 = Double.parseDouble(strNum1);
        String strNum2 = JOptionPane.showInputDialog("Enter 2nd number:");
        double num2 = Double.parseDouble(strNum2);
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        String result = "Sum: " + sum + "\nDifference: " + difference + "\nProduct: " + product;
        if (num2 != 0) {
            double quotient = num1 / num2;
            result += "\nQuotient: " + quotient;
        } else {
            result += "\nCannot divide by zero.";
        }
        JOptionPane.showMessageDialog(null, result, "Calculation Result", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
