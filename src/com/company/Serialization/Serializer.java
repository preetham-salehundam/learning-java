package com.company.Serialization;

import java.io.*;

public class Serializer {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setDepartmentName("Data Science");
        emp.setEmployeeId(1);
        emp.setEmployeeName("Preetham");
        //statics will not be searlized as they dont belong to the object
        emp.phoneNumber = 3456789;
        //transients wont be stored
        emp.setId(12345);


        try {
            FileOutputStream fos = new FileOutputStream("employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(emp);
            oos.close();
            fos.close();
            System.out.println("Object serializer successfully stored");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();
        }


    }


}

