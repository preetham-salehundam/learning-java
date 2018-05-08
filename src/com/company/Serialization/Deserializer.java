package com.company.Serialization;

import java.io.*;

public class Deserializer {

    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("employee.ser")){
                try(ObjectInputStream ois = new ObjectInputStream(fis) ){
                    try {
                        Employee emp = (Employee) ois.readObject();
                        System.out.println(emp);
                        System.out.println(Employee.phoneNumber);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }finally {
                        ois.close();
                        fis.close();
                    }
                }
        }catch (IOException io){
            io.printStackTrace();
        }
    }
}
