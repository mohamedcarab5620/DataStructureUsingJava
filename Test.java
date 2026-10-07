import java.util.Date;

class Loan {

    // data field (attributes)
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date LoanDate;
    // constructor oo ah no-argument
    public Loan() {
        this.annualInterestRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
        this.LoanDate = new Date();
    }

    // constructor oo ah with parameter
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    // getters
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }
    public java.util.Date getLoanDate(){
        return LoanDate;
    }
    // setters
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // calculate monthly payment
    public double getMonthlyPayment() {

        double monthlyInterestRate = annualInterestRate / 1200;
        int numberOfPayments = numberOfYears * 12;

        double monthlyPayment =
                loanAmount * monthlyInterestRate /
                        (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

        return monthlyPayment;
    }

    // calculate total payment
    public double getTotalPayment() {

        double totalPayment =
                getMonthlyPayment() * numberOfYears * 12;

        return totalPayment;
    }
}

class BMI {

    // data field (attributes)
    private String name;
    private int age;
    private double weight;
    private double height;

    // constructor oo ah with parameter
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // constructor oo ah with parameter
    // age-ka default ahaan waa 20
    public BMI(String name, double weight, double height) {
        this.name = name;
        this.age = 20;
        this.weight = weight;
        this.height = height;
    }

    // getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    // calculate BMI
    public double getBMI() {

        double bmi = (weight * 703) / (height * height);

        return bmi;
    }

    // get BMI status
    public String getStatus() {

        double bmi = getBMI();

        if (bmi < 18.5) {
            return "Underweight";
        }
        else if (bmi < 25.0) {
            return "Normal";
        }
        else if (bmi < 30.0) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }
}


class Course {

    // data field (attributes)
    private String courseName;
    private String[] students;
    private int numberOfStudents;

    // constructor oo ah with parameter
    public Course(String courseName) {

        this.courseName = courseName;

        // create students array
        this.students = new String[10];

        // initially number of students is 0
        this.numberOfStudents = 0;
    }

    // getter for courseName
    public String getCourseName() {
        return courseName;
    }

    // add a new student
    public void addStudent(String student) {

        // check if the array is full
        if (numberOfStudents >= students.length) {

            // create a larger array
            String[] newStudents = new String[students.length * 2];

            // copy old students to new array
            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }

            // make the new array the students array
            students = newStudents;
        }

        // add the new student
        students[numberOfStudents] = student;

        // increase number of students
        numberOfStudents++;
    }

    // drop a student
    public void dropStudent(String student) {

        // find the student
        for (int i = 0; i < numberOfStudents; i++) {

            if (students[i].equals(student)) {

                // move the students after the removed student
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }

                // remove the last value
                students[numberOfStudents - 1] = null;

                // decrease number of students
                numberOfStudents--;

                // stop the loop
                break;
            }
        }
    }

    // return the students
    public String[] getStudents() {
        return students;
    }

    // return number of students
    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}




// main class
public class Test {

    public static void main(String[] args) {

        // object 1 : we used no-argument constructor
        Loan loan1 = new Loan();

        System.out.println("=== Loan Information ===");
        System.out.println("Interest Rate: " + loan1.getAnnualInterestRate());
        System.out.println("Number of Years: " + loan1.getNumberOfYears());
        System.out.println("Loan Amount: " + loan1.getLoanAmount());
        System.out.println("Loan Date = " + loan1.getLoanDate());
        System.out.println("Monthly Payment: " + loan1.getMonthlyPayment());
        System.out.println("Total Payment: " + loan1.getTotalPayment());


        // object 2 : we used constructor with parameter
        Loan loan2 = new Loan(5.0, 5, 5000);

        System.out.println("\n=== Loan 2 Information ===");
        System.out.println("Interest Rate: " + loan2.getAnnualInterestRate());
        System.out.println("Number of Years: " + loan2.getNumberOfYears());
        System.out.println("Loan Amount: " + loan2.getLoanAmount());
        System.out.println("Monthly Payment: " + loan2.getMonthlyPayment());
        System.out.println("Total Payment: " + loan2.getTotalPayment());


        System.out.println();
        System.out.println("Exercise 2.1 ");

        // object 1 : we used constructor with age
        BMI person1 = new BMI("Ahmed", 22, 160, 70);

        System.out.println("=== BMI Information ===");
        System.out.println("Name: " + person1.getName());
        System.out.println("Age: " + person1.getAge());
        System.out.println("Weight: " + person1.getWeight());
        System.out.println("Height: " + person1.getHeight());
        System.out.println("BMI: " + person1.getBMI());
        System.out.println("Status: " + person1.getStatus());


        // object 2 : we used constructor without age
        BMI person2 = new BMI("Mohamed", 50, 68);

        System.out.println("\n=== BMI 2 Information ===");
        System.out.println("Name: " + person2.getName());
        System.out.println("Age: " + person2.getAge());
        System.out.println("Weight: " + person2.getWeight());
        System.out.println("Height: " + person2.getHeight());
        System.out.println("BMI: " + person2.getBMI());
        System.out.println("Status: " + person2.getStatus());


        System.out.println();
        System.out.println("Exercise 2.2 ");

        // object 1 : create a Course object
        Course course1 = new Course("Java Programming");

        // add students
        course1.addStudent("Ahmed");
        course1.addStudent("Mohamed");
        course1.addStudent("Ali");
        course1.addStudent("Hassan");

        System.out.println("=== Course Information ===");
        System.out.println("Course Name: " + course1.getCourseName());
        System.out.println("Number of Students: " + course1.getNumberOfStudents());

        // display students
        System.out.println("Students:");

        String[] students = course1.getStudents();

        for (int i = 0; i < course1.getNumberOfStudents(); i++) {
            System.out.println("\t" + students[i]);
        }

        // drop one student
        course1.dropStudent("Ali");

        System.out.println("\nAfter dropping Ali:");

        System.out.println("Number of Students: "
                + course1.getNumberOfStudents());

        for (int i = 0; i < course1.getNumberOfStudents(); i++) {
            System.out.println("\t" + course1.getStudents()[i]);
        }
    }
}





