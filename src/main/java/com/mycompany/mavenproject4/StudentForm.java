package com.mycompany.mavenproject4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class StudentForm extends JFrame {
    private JTable customerTable;
    private DefaultTableModel tableModel;
    private JTextField nameField;
    private JTextField phoneField;
    private JTextField addressField;
    private JButton saveButton;
    private JButton editButton;
    private JButton deleteButton;
    private int id;
    private String studentName;
    private String studentId;
    private String studyProgram;
    private String purpose;
    private LocalDateTime visitTime;

    private List<Student> studentList;
       private Student student;
    private AbstractButton idField;
    private AbstractButton jurusanField;
    private AbstractButton tujuanField;
    private AbstractButton jamKunjunganField;
    private String jurusan;
    private String tujuan;
    private String jamKunjungan;
 

    public StudentForm() {
        studentList = new ArrayList<>();

        setTitle("Library visit Log | Student Data");
        setSize(650, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // TABEL
        tableModel = new DefaultTableModel(new String[]{"Nama", "ID", "Jurusan", "Tujuan", "Jam Kunjungan"}, 0);
        customerTable = new JTable(tableModel);
        add(new JScrollPane(customerTable), BorderLayout.CENTER);

        // FORM INPUT
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        inputPanel.add(new JLabel("Nama:"));
        nameField = new JTextField(12);
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("ID:"));
        phoneField = new JTextField(10);
        inputPanel.add(phoneField);

        inputPanel.add(new JLabel("Jurusan:"));
        addressField = new JTextField(15);
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Tujuan:"));
        addressField = new JTextField(15);
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Jam Kunjungan:"));
        addressField = new JTextField(15);
        inputPanel.add(addressField);


        // TOMBOL
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        saveButton = new JButton("Simpan");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Hapus");

        buttonPanel.add(saveButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(inputPanel, BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        // ACTIONS
        saveButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String address = addressField.getText().trim();

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
                return;
            }

            String nama = null;
            Student student = new Student(nama, id, jurusan, tujuan, jamKunjungan);
            studentList.add(student);
            tableModel.addRow(new Object[]{name, id, jurusan, tujuan, jamKunjungan});
            clearFields();
        });

        editButton.addActionListener(e -> {
            int row = customerTable.getSelectedRow();
            if (row != -1) {
                String nama = nameField.getText().trim();
                String phone = phoneField.getText().trim();
                String address = addressField.getText().trim();

                if (nama.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Semua field harus diisi!");
                    return;
                }

                tableModel.setValueAt(nama, row, 0);
                tableModel.setValueAt(phone, row, 1);
                tableModel.setValueAt(address, row, 2);

                Student customer = studentList.get(row);
                customer.setName(nama);
                customer.setId(id);
                customer.setJurusan(jurusan);
                 customer.setTujuan(tujuan);
                  customer.setJamKunjungan(jamKunjungan);

                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih baris yang ingin diedit!");
            }
        });

        deleteButton.addActionListener(e -> {
            int row = customerTable.getSelectedRow();
            if (row != -1) {
                studentList.remove(row);
                tableModel.removeRow(row);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
            }
        });

        customerTable.getSelectionModel().addListSelectionListener(e -> {
            int row = customerTable.getSelectedRow();
            if (row != -1) {
                nameField.setText(tableModel.getValueAt(row, 0).toString());
                idField.setText(tableModel.getValueAt(row, 1).toString());
                jurusanField.setText(tableModel.getValueAt(row, 2).toString());
                tujuanField.setText(tableModel.getValueAt(row, 2).toString());
                jamKunjunganField.setText(tableModel.getValueAt(row, 2).toString());
            }
        });
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        addressField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentForm().setVisible(true));
    }

    private static class LocalDateTime {

        public LocalDateTime() {
        }
    }
}