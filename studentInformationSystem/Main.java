import java.util.*;

class Student {
    String studentId;
    String name;
    String address;
    String contactNumber;
    public Student(String studentId, String name, String address, String contactNumber) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
    }
}
class AcademicRecord {
    String studentId;
    Map<String, Integer> coursesAndGrades;
    public AcademicRecord(String studentId) {
        this.studentId = studentId;
        this.coursesAndGrades = new HashMap<>();
    }
}
class StudentInformationSystem {
    Map<String, Student> students;
    Map<String, AcademicRecord> academicRecords;
    public StudentInformationSystem() {
        this.students = new HashMap<>();
        this.academicRecords = new HashMap<>();
    }
    public void addStudent(String studentId, String name, String address, String contactNumber) {
        Student newStudent = new Student(studentId, name, address, contactNumber);
        students.put(studentId, newStudent);
        AcademicRecord academicRecord = new AcademicRecord(studentId);
        academicRecords.put(studentId, academicRecord);

        System.out.println("Student added successfully.");
    }
    public void displayStudentDetails(String studentId) {
        if (students.containsKey(studentId)) {
            Student student = students.get(studentId);
            System.out.println("Student Details:");
            System.out.println("ID: " + student.studentId);
            System.out.println("Name: " + student.name);
            System.out.println("Address: " + student.address);
            System.out.println("Contact Number: " + student.contactNumber);
            displayAcademicRecord(studentId);
        } else {
            System.out.println("Student not found.");
        }
    }
    private void displayAcademicRecord(String studentId) {
        if (academicRecords.containsKey(studentId)) {
            AcademicRecord academicRecord = academicRecords.get(studentId);

            System.out.println("\nAcademic Record found:");
            for (Map.Entry<String, Integer> entry : academicRecord.coursesAndGrades.entrySet()) {
                System.out.println("Course: " + entry.getKey() + ", Grade: " + entry.getValue());
            }
        } else {
            System.out.println("Academic record not found.");
        }
    }
}

public class Main {
        public static void main(String[] args) {
        StudentInformationSystem sis = new StudentInformationSystem();
        sis.addStudent("1", "Shiva", "Banjarahills", "9123114248");
        sis.displayStudentDetails("1");
    }
}
