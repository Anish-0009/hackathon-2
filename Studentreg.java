import java.util.Scanner;

class Studentreg {
    private String studentName;
    private String rollNumber;
    private double marks;
    private String courseName;
    private int courseCredits;

    // Parameterized constructor
    public Studentreg(String studentName, String rollNumber, double marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // Method to calculate course fee (Rs. 1500 per credit)
    public double calculateFee() {
        return courseCredits * 1500.0;
    }

    // Method to check eligibility (marks >= 50)
    public boolean checkEligibility() {
        return marks >= 50.0;
    }

    // Method to calculate scholarship amount based on marks
    public double calculateScholarship() {
        double fee = calculateFee();
        if (marks >= 85.0) {
            return 0.20 * fee; // 20% scholarship
        } else if (marks >= 70.0) {
            return 0.10 * fee; // 10% scholarship
        } else {
            return 0.0; // No scholarship
        }
    }

    // Method to calculate final fee after scholarship deduction
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    // Method to display all student and fee details
    public void displayDetails() {
        System.out.println("\n=== Student Registration Details ===");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Eligibility Status: Eligible");
        System.out.println("Total Course Fee: Rs. " + calculateFee());
        System.out.println("Scholarship Amount: Rs. " + calculateScholarship());
        System.out.println("Final Fee to Pay: Rs. " + calculateFinalFee());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNumber = scanner.nextLine();

        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();

        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();

        // Create object using parameterized constructor
        Studentreg student = new Studentreg(studentName, rollNumber, marks, courseName, courseCredits);

        // Check eligibility and process registration
        if (student.checkEligibility()) {
            student.displayDetails();
        } else {
            System.out.println("\nRegistration Failed: Student is not eligible for course registration (Marks < 50).");
        }

        scanner.close();
    }
}