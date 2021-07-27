package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void writeToObject(String filePath, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile (String filePath){
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>)  ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception e){
            e.printStackTrace();}
        return students;
    }



    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));

        writeToObject("studentList.txt" , students );
        List<Student> studentDataFromFile = readDataFromFile("studentList.txt");
        for (Student s: studentDataFromFile
             ) {
            System.out.println(s);
        }
    }
}

