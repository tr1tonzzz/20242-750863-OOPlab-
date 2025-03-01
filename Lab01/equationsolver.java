	import javax.swing.JOptionPane;
	public class equationsolver {
	    public static void main(String[] args) {
	        String[] options = { "Linear Equation (ax + b = 0)", 
	                             "Linear System (2 variables)", 
	                             "Quadratic Equation (ax^2 + bx + c = 0)" };
	        int choice = JOptionPane.showOptionDialog(null, 
	            "Choose the equation type:", "Equation Solver",
	            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
	            null, options, options[0]);
	        switch (choice) {
	            case 0:
	                solveLinearEquation();
	                break;
	            case 1:
	                solveLinearSystem();
	                break;
	            case 2:
	                solveQuadraticEquation();
	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "Invalid");
	        }
	    }
	    public static void solveLinearEquation() {
	        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter number a:"));
	        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter number b:"));
	        String result;
	        if (a == 0) {
	            result = (b == 0) ? "Infinite solutions." : "No solution.";
	        } else {
	            double x = -b / a;
	            result = "x =" + x;
	        }
	        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
	    }
	    public static void solveLinearSystem() {
	        double a11 = Double.parseDouble(JOptionPane.showInputDialog("Enter a11:"));
	        double a12 = Double.parseDouble(JOptionPane.showInputDialog("Enter a12:"));
	        double b1  = Double.parseDouble(JOptionPane.showInputDialog("Enter b1:"));
	        double a21 = Double.parseDouble(JOptionPane.showInputDialog("Enter a21:"));
	        double a22 = Double.parseDouble(JOptionPane.showInputDialog("Enter a22:"));
	        double b2  = Double.parseDouble(JOptionPane.showInputDialog("Enter b2:"));
	        double D = a11 * a22 - a21 * a12;
	        double D1 = b1 * a22 - b2 * a12;
	        double D2 = a11 * b2 - a21 * b1;
	        String result;
	        if (D != 0) {
	            double x1 = D1 / D;
	            double x2 = D2 / D;
	            result = "x1 = " + x1 + ", x2 = " + x2;
	        } else {
	            result = (D1 == 0 && D2 == 0) ? "Infinite solutions." : "No solution.";
	        }
	        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
	    }
	    public static void solveQuadraticEquation() {
	        double a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
	        double b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));
	        double c = Double.parseDouble(JOptionPane.showInputDialog("Enter c:"));

	        String result;
	        if (a == 0) {
	            double x = -c / b;
	            result = "x =" + x;
	        } else {
	            double delta = b * b - 4 * a * c;
	            if (delta > 0) {
	                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
	                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
	                result = "x1 = " + x1 + ", x2 = " + x2;
	            } else if (delta == 0) {
	                double x = -b / (2 * a);
	                result = "Double root: x = " + x;
	            } else {
	                result = "No real roots.";
	            }
	        }
	        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
	    }
	}
