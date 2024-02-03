import java.util.ArrayList;
import java.util.Scanner;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }
}

class Student {
    int studentID;
    String name;
    ArrayList<String> registeredCourses;

    Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

class CourseManager {
    ArrayList<Course> courses;

    CourseManager() {
        this.courses = new ArrayList<>();
    }

    void addCourse(Course course) {
        courses.add(course);
    }

    void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Code: " + course.code + ", Title: " + course.title +
                    ", Capacity: " + course.capacity + ", Schedule: " + course.schedule);
        }
    }
}

class StudentManager {
    ArrayList<Student> students;

    StudentManager() {
        this.students = new ArrayList<>();
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void displayStudentCourses(Student student) {
        System.out.println("Registered Courses for " + student.name + " (ID: " + student.studentID + "):");
        for (String course : student.registeredCourses) {
            System.out.println(course);
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        CourseManager courseManager = new CourseManager();
        StudentManager studentManager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        // Sample courses
        Course c1 = new Course("CSE101", "Introduction to Programming", "Basic programming concepts", 30,
                "Mon/Wed/Fri 10:00 AM");
        Course c2 = new Course("MAT201", "Calculus I", "Limits, derivatives, integrals", 25, "Tue/Thu 2:00 PM");
        Course c3 = new Course("PHY301", "Modern Physics", "Quantum mechanics, relativity", 20, "Mon/Wed 1:30 PM");
        Course c4 = new Course("BIO101", "Introduction to Biology", "Basic biology concepts", 25,
                "Tue/Thu 2:00 PM");

        courseManager.addCourse(c1);
        courseManager.addCourse(c2);
        courseManager.addCourse(c3);
        courseManager.addCourse(c4);

        // Sample student
        Student student = new Student(1, "Mohd Umar");
        studentManager.addStudent(student);

        while (true) {
            System.out.println("\n1. Display Courses");
            System.out.println("2. Register for a Course");
            System.out.println("3. Drop a Course");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    courseManager.displayCourses();
                    break;
                case 2:
                    courseManager.displayCourses();
                    System.out.print("Enter the course code to register: ");
                    String courseCode = scanner.next();
                 
                    student.registeredCourses.add(courseCode);
                    System.out.println("Successfully registered for the course!");
                    break;
                case 3:
                    studentManager.displayStudentCourses(student);
                    System.out.print("Enter the course code to drop: ");
                    String dropCourseCode = scanner.next();
                 
                    student.registeredCourses.remove(dropCourseCode);
                    System.out.println("Successfully dropped the course!");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    scanner.close();
            }
        }
    }
}
