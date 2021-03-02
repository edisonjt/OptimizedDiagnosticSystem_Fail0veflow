/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.optimizeddiagnosticsystem.model;

import ec.edu.espe.filemanager.utils.Data;
import java.util.Scanner;

/**
 *
 * @author luist
 */
public class Nurse extends MedicalStaff {

    private boolean prescription;
    private String workShift;

    //CONSTRUCTORS
    public Nurse(String workShift, String titleCode, String password, String surname, String name, int age, String homeAddress, String gender, String dateOfBirth, int emergencyNumber, boolean option) {
        super(titleCode, password, surname, name, age, homeAddress, gender, dateOfBirth, emergencyNumber, option);
        this.workShift = workShift;
    }

    public Nurse(boolean prescription, String name, String gender, String dateOfBirth) {
        super(name, gender, dateOfBirth);
        this.prescription = prescription;
    }

    public Nurse() {

    }

    //METHODS
    @Override
    public void register() {
        Scanner scan = new Scanner(System.in);
        System.out.println("=======================================");
        System.out.println("*****Nurse's data*****");
        System.out.println("");
        System.out.println("Name: ");
        setName(scan.nextLine());
        System.out.println("Surname: ");
        setSurname(scan.nextLine());
        System.out.println("Gender ");
        setGender(scan.nextLine());
        System.out.println("Date of birth");
        setDateOfBirth(scan.nextLine());
        try {
            System.out.println("Age: ");
            setAge(Integer.parseInt(scan.nextLine()));
            System.out.println("Emergency Number: ");
            setEmergencyNumber(Integer.parseInt(scan.nextLine()));
        } catch (NumberFormatException ex) {
            System.out.println("very large number");
        }

        System.out.println("Home Address: ");
        setHomeAddress(scan.nextLine());

        System.out.println("Work Shift");
        setWorkShift(scan.nextLine());
        System.out.println("Title code: ");
        setTitleCode(scan.nextLine());
        System.out.println("Do you want to save? Please put True or False");
        setOption(scan.nextBoolean());

    }

    @Override
    public void createPass(boolean option) {
        if (option == true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the new password");
            String pass = scan.nextLine();
            String nurseToSave = pass;
            Data.save("PassNursSystem.csv", nurseToSave + "\n", true);
        }

    }

    @Override
    public void createPass(boolean option, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //SETT AND GETT
    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    public String getWorkShift() {
        return workShift;
    }

    public boolean isPrescription() {
        return prescription;
    }

    public void setPrescription(boolean prescription) {
        this.prescription = prescription;
    }

}
