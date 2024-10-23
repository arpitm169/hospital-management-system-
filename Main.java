import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

// Class Patient
class Patient {
    private String name;
    private int patientId;
    private int age;
    private String ailment;

    // Constructor
    public Patient(String name, int patientId, int age, String ailment) {
        this.name = name;
        this.patientId = patientId;
        this.age = age;
        this.ailment = ailment;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getAge() {
        return age;
    }

    public String getAilment() {
        return ailment;
    }

    // Display patient details
    public void displayInfo() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
}

// Class Doctor
class Doctor {
    private String name;
    private int doctorId;
    private String specialization;

    // Constructor
    public Doctor(String name, int doctorId, String specialization) {
        this.name = name;
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    // Display doctor details
    public void displayInfo() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Name: " + name);
        System.out.println("Specialization: " + specialization);
    }
}

// Class Appointment
class Appointment {
    private Patient patient;
    private Doctor doctor;

    // Constructor
    public Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }

    // Display appointment details
    public void displayInfo() {
        System.out.println("Appointment Details:");
        System.out.println("Patient: " + patient.getName() + " (ID: " + patient.getPatientId() + ")");
        System.out.println("Doctor: " + doctor.getName() + " (ID: " + doctor.getDoctorId() + ")");
        System.out.println("Specialization: " + doctor.getSpecialization());
        System.out.println("Ailment: " + patient.getAilment());
    }
}

// Class HospitalManagementSystem
class HospitalManagementSystem {
    private HashMap<Integer, Patient> patientDatabase = new HashMap<>();
    private HashMap<Integer, Doctor> doctorDatabase = new HashMap<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();

    // Method to add a patient
    public void addPatient(Patient patient) {
        patientDatabase.put(patient.getPatientId(), patient);
        System.out.println("Patient added successfully!");
    }

    // Method to view a patient
    public void viewPatient(int patientId) {
        Patient patient = patientDatabase.get(patientId);
        if (patient != null) {
            patient.displayInfo();
        } else {
            System.out.println("Patient not found.");
        }
    }

    // Method to add a doctor
    public void addDoctor(Doctor doctor) {
        doctorDatabase.put(doctor.getDoctorId(), doctor);
        System.out.println("Doctor added successfully!");
    }

    // Method to view a doctor
    public void viewDoctor(int doctorId) {
        Doctor doctor = doctorDatabase.get(doctorId);
        if (doctor != null) {
            doctor.displayInfo();
        } else {
            System.out.println("Doctor not found.");
        }
    }

    // Method to schedule an appointment
    public void scheduleAppointment(int patientId, int doctorId) {
        Patient patient = patientDatabase.get(patientId);
        Doctor doctor = doctorDatabase.get(doctorId);
        if (patient != null && doctor != null) {
            Appointment appointment = new Appointment(patient, doctor);
            appointments.add(appointment);
            System.out.println("Appointment scheduled successfully!");
        } else {
            System.out.println("Invalid patient or doctor ID.");
        }
    }

    // Method to list all appointments
    public void listAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            for (Appointment appointment : appointments) {
                appointment.displayInfo();
                System.out.println("----------------------------");
            }
        }
    }
}

// Main class to interact with the user
public class Main {

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient");
            System.out.println("3. Add Doctor");
            System.out.println("4. View Doctor");
            System.out.println("5. Schedule Appointment");
            System.out.println("6. View All Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Patient
                    System.out.print("Enter patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter patient name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter ailment: ");
                    String ailment = scanner.nextLine();
                    Patient patient = new Patient(patientName, patientId, age, ailment);
                    hms.addPatient(patient);
                    break;
                case 2:
                    // View Patient
                    System.out.print("Enter patient ID to view: ");
                    patientId = scanner.nextInt();
                    hms.viewPatient(patientId);
                    break;
                case 3:
                    // Add Doctor
                    System.out.print("Enter doctor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine();  // consume newline
                    System.out.print("Enter doctor name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter specialization: ");
                    String specialization = scanner.nextLine();
                    Doctor doctor = new Doctor(doctorName, doctorId, specialization);
                    hms.addDoctor(doctor);
                    break;
                case 4:
                    // View Doctor
                    System.out.print("Enter doctor ID to view: ");
                    doctorId = scanner.nextInt();
                    hms.viewDoctor(doctorId);
                    break;
                case 5:
                    // Schedule Appointment
                    System.out.print("Enter patient ID: ");
                    patientId = scanner.nextInt();
                    System.out.print("Enter doctor ID: ");
                    doctorId = scanner.nextInt();
                    hms.scheduleAppointment(patientId, doctorId);
                    break;
                case 6:
                    // View all appointments
                    hms.listAllAppointments();
                    break;
                case 7:
                    // Exit the program
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
