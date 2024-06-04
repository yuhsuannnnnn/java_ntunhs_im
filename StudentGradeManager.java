package test;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class StudentGradeManager extends JFrame {
    private JButton addButton, findButton, deleteButton, listButton;
    private JTextField nameField, heightField, weightField;
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private Map<String, Student> students;
    private File csvFile;

    public StudentGradeManager() {
        super("Student BMI Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new FlowLayout());

        students = new HashMap<>();
        fileChooser = new JFileChooser();
        
        nameField = new JTextField(10);
        heightField = new JTextField(10);
        weightField = new JTextField(10);

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Height (cm):"));
        add(heightField);
        add(new JLabel("Weight (kg):"));
        add(weightField);

        addButton = new JButton("Add/Update Student");
        addButton.addActionListener(this::addOrUpdateStudent);
        add(addButton);

        findButton = new JButton("Find Student");
        findButton.addActionListener(this::findStudent);
        add(findButton);

        deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(this::deleteStudent);
        add(deleteButton);

        listButton = new JButton("List Students");
        listButton.addActionListener(this::listStudents);
        add(listButton);

        textArea = new JTextArea(15, 50);
        add(new JScrollPane(textArea));

        // Save CSV file to desktop
        String desktopPath = System.getProperty("user.home") + "/Desktop";
        csvFile = new File(desktopPath, "students.csv");

        // Load existing records from CSV file
        loadExistingRecords();

        setVisible(true);
    }

    private void addOrUpdateStudent(ActionEvent e) {
        try {
            String name = nameField.getText();
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());

            Student student = new Student(name, height, weight);
            students.put(name, student);
            textArea.setText("Student added/updated: " + student.toString());
            appendPreviousRecords(); // Display previous records
            saveToCSV();
            openCSVFile(); // Open CSV file after saving
        } catch (NumberFormatException ex) {
            textArea.setText("Please enter valid height and weight values.");
        }
    }

    private void findStudent(ActionEvent e) {
        String name = nameField.getText();
        Student student = students.get(name);
        if (student != null) {
            textArea.setText("Found: " + student.toString());
        } else {
            textArea.setText("Student not found: " + name);
        }
    }

    private void deleteStudent(ActionEvent e) {
        String name = nameField.getText();
        if (students.remove(name) != null) {
            textArea.setText("Student deleted: " + name);
        } else {
            textArea.setText("Student not found: " + name);
        }
        saveToCSV();
        openCSVFile(); // Open CSV file after saving
    }

    private void listStudents(ActionEvent e) {
        StringBuilder builder = new StringBuilder("All Students:\n");
        students.values().forEach(student -> builder.append(student.toString()).append("\n"));
        textArea.setText(builder.toString());
    }

    private void saveToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            writer.println("Name,Height,Weight,BMI");
            for (Student student : students.values()) {
                writer.printf("%s,%.2f,%.2f,%.2f%n", student.getName(), student.getHeight(), student.getWeight(), student.calculateBMI());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void openCSVFile() {
        try {
            Desktop.getDesktop().open(csvFile);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void appendPreviousRecords() {
        StringBuilder builder = new StringBuilder(textArea.getText());
        if (!students.isEmpty()) {
            builder.append("\nPrevious Records:\n");
            for (Student student : students.values()) {
                builder.append(student.toString()).append("\n");
            }
        }
        textArea.setText(builder.toString());
    }

    private void loadExistingRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Skip header line
                if (!line.startsWith("Name")) {
                    String[] parts = line.split(",");
                    String name = parts[0];
                    double height = Double.parseDouble(parts[1]);
                    double weight = Double.parseDouble(parts[2]);
                    double bmi = Double.parseDouble(parts[3]);
                    Student student = new Student(name, height, weight);
                    students.put(name, student);
                }
            }
            // Display loaded records
            appendPreviousRecords();
        } catch (IOException | NumberFormatException e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new StudentGradeManager();
    }
}