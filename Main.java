import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// thid program to Book Appoinment with Doctor 

abstract class Person { // ABsraaction to Hide the Attributes

    protected int id; // ID of person
    protected String name;
    protected int age;
    protected String gender;
    protected String phone;

    public Person(int id, String name, int age, String gender, String phone) // frist constructor
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    public abstract String getRole();

    public void printInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
        System.out.println("Phone: " + phone);
    }
}

class Doctor extends Person {

    private String specialization;
    private double consultationFee;
    private List<String> bookedSlots;

    public Doctor(int id, String name, int age, String gender, String phone,
            String specialization, double fee) {

        super(id, name, age, gender, phone);
        this.specialization = specialization;
        this.consultationFee = fee;
        this.bookedSlots = new ArrayList<>();
    }

    public String getRole() {
        return "Doctor";
    }

    public void schedule(String dateTime) {
        bookedSlots.add(dateTime);
    }

    public void cancel(String dateTime) {
        bookedSlots.remove(dateTime);
    }

    public boolean isAvailable(String dateTime) {
        return !bookedSlots.contains(dateTime);
    }

    public void printInfo() {
        super.printInfo();
        System.out.println("Specialization: " + specialization);
        System.out.println("Consultation Fee: " + consultationFee);
    }
}

class Patient extends Person {

    public Patient(int id, String name, int age, String gender, String phone) {
        super(id, name, age, gender, phone);
    }

    public String getRole() {
        return "Patient";
    }
}

class Appoinment {

    private Doctor doctor;
    private Patient patient;
    private String dateTime;

    public Appoinment(Doctor doctor, Patient patient, String dateTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
    }

    public void printAppointment() {
        System.out.println("Appointment Details:");
        System.out.println("Doctor: " + doctor.name);
        System.out.println("Patient: " + patient.name);
        System.out.println("Time: " + dateTime);
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // TO ENETR THE input

        Doctor doctor1 = new Doctor(
                1,
                "Ahmed",
                45,
                "Male",
                "01152109556",
                "Dentist",
                300);

        Patient patient1 = new Patient(
                1,
                "Ali",
                20,
                "Male",
                "01152109556");

        doctor1.printInfo();

        System.out.println("Enter appointment time:");
        String time = input.nextLine();

        if (doctor1.isAvailable(time)) // check if Doctor free or no 
        {

            doctor1.schedule(time); // more than one Action

            Appoinment app = new Appoinment(doctor1, patient1, time);

            app.printAppointment();

        } else
            System.out.println("Doctor not available"); // Just one Action

    }
}