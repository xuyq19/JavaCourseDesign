package lesson2;

class Triangle {
    double sideA, sideB, sideC, area, length;
    boolean flag;

    public Triangle(double sideA, double sideB, double sideC) {
        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            flag = true;
        } else {
            flag = false;
        }
    }

    public double getLength() {
        if (flag) {
            length = sideA + sideB + sideC;
            return length;
        } else {
            System.out.println("不能构成三角形");
            return 0;
        }
    }

    public double getArea() {
        if (flag) {
            double p = (sideA + sideB + sideC) / 2;
            area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
            return area;
        } else {
            System.out.println("不能构成三角形");
            return 0;
        }
    }

    public void setABC(double sideA, double sideB, double sideC) {
        if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            flag = true;
        } else {
            sideA = sideB = sideC = 0;
            flag = false;
        }
    }
}

class Lader {
    double above, bottom, height, area;

    Lader(double above, double bottom, double height) {
        this.above = above;
        this.bottom = bottom;
        this.height = height;
    }

    public double getArea() {
        area = (above + bottom) * height / 2;
        return area;
    }
}

class Circle {
    double radius, area;

    Circle(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
    }

    double getArea() {
        area = Math.PI * radius * radius;
        return area;
    }

    double getLength() {
        return 2 * Math.PI * radius;
    }

    void setRadius(double newRadius) {
        if (radius > 0) {
            this.radius = newRadius;
        }
    }

    double getRadius() {
        return radius;
    }
}

public class AreaAndLength {
    public static void main(String[] args) {
        double length, area;
        Circle circle = null;
        Triangle triangle = null;
        Lader lader = null;
        circle = new Circle(5);
        triangle = new Triangle(3, 4, 5);
        lader = new Lader(4, 8, 5);
        length = circle.getLength();
        System.out.println("圆的周长为：" + length);
        area = circle.getArea();
        System.out.println("圆的面积为：" + area);
        length = triangle.getLength();
        System.out.println("三角形的周长为：" + length);
        area = triangle.getArea();
        System.out.println("三角形的面积为：" + area);
        area = lader.getArea();
        System.out.println("梯形的面积为：" + area);
        triangle.setABC(12, 34, 1);
        area = triangle.getArea();
        System.out.println("三角形的面积为：" + area);
        length = triangle.getLength();
        System.out.println("三角形的周长为：" + length);
    }
}
