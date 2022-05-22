package lesson3;

abstract class Employee {
    String EmpName;
    char sex;
    double EmpSal;

    Employee(String en, char s, double es) {
        EmpName = en;
        sex = s;
        EmpSal = es;
    }

    public String getName() {
        return EmpName;
    }

    public char getSex() {
        return sex;
    }

    public abstract double getSal();

    public void setSal(int basSal) {
        EmpSal = basSal;
    }
}

class Worker extends Employee {
    char category;
    boolean dressAllowance;

    Worker(String en, char s, double es, char c, boolean d) {
        super(en, s, es);
        category = c;
        dressAllowance = d;
    }

    public char getCategory() {
        return category;
    }

    public boolean getDressAllowance() {
        return dressAllowance;
    }

    public double getSal() {
        return EmpSal;
    }
}

class Superior extends Employee {
    int experience;
    boolean vehicle;
    double medicalAllowance;

    Superior(String en, char s, double es, int e, boolean v, double ma) {
        super(en, s, es);
        experience = e;
        vehicle = v;
        medicalAllowance = ma;
    }

    public int getExp() {
        return experience;
    }

    public boolean getVehicle() {
        return vehicle;
    }

    public double getMedicalAll() {
        return medicalAllowance;
    }

    public double getSal() {
        return EmpSal * 4 + 1000 + medicalAllowance;
    }
}

class Officer extends Superior {
    double travelAllowance;

    Officer(String en, char s, double es, int e, boolean v, double ma, double ta) {
        super(en, s, es, e, v, ma);
        travelAllowance = ta;
    }

    public double getTravelAll() {
        return travelAllowance;
    }

    public double getSal() {
        return EmpSal * 2 + 200 + travelAllowance + medicalAllowance;
    }
}

class Manager extends Superior {
    double clubAllowance;

    Manager(String en, char s, double es, int e, boolean v, double ma, double ca) {
        super(en, s, es, e, v, ma);
        clubAllowance = ca;
    }

    public double getClubAll() {
        return clubAllowance;
    }

    public double getSal() {
        return EmpSal * 5 + 2000 + clubAllowance + medicalAllowance;
    }
}

class InheDemo {
    public static void main(String[] args) {
        Worker w = new Worker("M.John", 'M', 1200.50, 'B', true);
        System.out.println("Worker Info:");
        System.out.println("Name: " + w.getName());
        System.out.println("Gender:" + w.getSex());
        System.out.println("Salary:" + w.getSal());
        System.out.println("Category:" + w.getCategory());
        if (w.getDressAllowance()) {
            System.out.println("提供服装津贴");
        } else {
            System.out.println("不提供服装津贴");
        }
        Officer o = new Officer("S.David", 'F', 2500.70, 15, true, 345.60, 200);
        System.out.println("Officer Info:");
        System.out.println("Name: " + o.getName());
        System.out.println("Gender:" + o.getSex());
        System.out.println("Salary:" + o.getSal());
        System.out.println("Experience:" + o.getExp() + " years");
        if (o.getVehicle()) {
            System.out.println("提供交通工具");
        } else {
            System.out.println("不提供交通工具");
        }
        System.out.println("Medical Allowance:" + o.getMedicalAll());
        System.out.println("Travel Allowance:" + o.getTravelAll());
        Manager m = new Manager("ArnoldShwaz", 'M', 4500.70, 15, true, 345.60, 300);
        System.out.println("\nManager Info:");
        System.out.println("Name: " + m.getName());
        System.out.println("Gender:" + m.getSex());
        System.out.println("Salary:" + m.getSal());
        System.out.println("Experience:" + m.getExp());
        if (m.getVehicle()) {
            System.out.println("提供交通工具");
        } else {
            System.out.println("不提供交通工具");
        }
        System.out.println("Medical Allowance:" + m.getMedicalAll());
        System.out.println("Club Allowance:" + m.getClubAll());
    }
}
