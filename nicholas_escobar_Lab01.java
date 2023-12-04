import javax.swing.JOptionPane;

class Polygons {
    double area;

    public Polygons() {}

    public double getArea() {
        return area;
    }

    public void calculateArea() {
        this.area = 0.0;
    }
}

class Rectangle extends Polygons {
    private double length;
    private double width;

    public Rectangle() {
        super();
    }

    public Rectangle setLength(double length) {
        this.length = length;
        calculateArea();
        return this;
    }
    public Rectangle setWidth(double width) {
        this.width = width;
        calculateArea();
        return this;
    }
    @Override
    public void calculateArea() {
        this.area = length * width;
    }
}
class Square extends Rectangle {
    public Square(double side) {
        super.setLength(side);
        super.setWidth(side);
    }
}

class EquilateralTriangle extends Polygons {
    private double side;

    public EquilateralTriangle() {
        super();
    }

    public EquilateralTriangle setSide(double side) {
        this.side = side;
        calculateArea();
        return this;
    }

    @Override
    public void calculateArea() {
        this.area = (Math.sqrt(3) / 4) * side * side; 
    }
}

public class nicholas_escobar_Lab01 {
    public static void main(String[] args) {
        userInterface();
    }

    static void userInterface() {
        JOptionPane.showMessageDialog(null, "Welcome! Choose a shape to calculate the area.");

        while (true) {
            String[] options = {"Rectangle", "Square", "Equilateral Triangle"};
            String selectedShape = (String) JOptionPane.showInputDialog(null, "Choose a shape to calculate the area:","Shape Selection", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (selectedShape != null) {
                switch (selectedShape) {
                    case "Rectangle":
                        double rectLength = Double.parseDouble(JOptionPane.showInputDialog("Enter the length:"));
                        double rectWidth = Double.parseDouble(JOptionPane.showInputDialog("Enter the width:"));
                        Rectangle rectangle = new Rectangle();
                        double rectangleArea = rectangle.setLength(rectLength).setWidth(rectWidth).getArea();
                        JOptionPane.showMessageDialog(null, "The area is: " + rectangleArea);
                        break;
                    case "Square":
                        double side = Double.parseDouble(JOptionPane.showInputDialog("Enter the side length:"));
                        Square square = new Square(side);
                        double squareArea = square.getArea();
                        JOptionPane.showMessageDialog(null, "The area is: " + squareArea);
                        break;
                    case "Equilateral Triangle":
                        double equiSide = Double.parseDouble(JOptionPane.showInputDialog("Enter the side length:"));
                        EquilateralTriangle equilateralTriangle = new EquilateralTriangle();
                        double equiTriangleArea = equilateralTriangle.setSide(equiSide).getArea();
                        JOptionPane.showMessageDialog(null, "The area is: " + equiTriangleArea);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice");
                        break;
                }

                int choice = JOptionPane.showConfirmDialog(null, "Calculate area for another shape?","Continue?", JOptionPane.NO_OPTION,JOptionPane.YES_OPTION);
                if (choice != JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            } else {
                System.exit(0);
            }
        }
    }
}

