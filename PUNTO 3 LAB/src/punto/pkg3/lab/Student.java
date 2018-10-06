/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.pkg3.lab;

/**
 *
 * @author Microsoft Windows 10
 */
public class Student {
    private String name;
    private Grade[] grades;
    private Module[] takes;

    public Student(String name, Module modules) {
        this.name = name;
        this.grades = new Grade[7];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade[] getGrades() {
        return grades;
    }

    public void setGrades(Grade[] grades) {
        this.grades = grades;
    }

    public Module[] getTakes() {
        return takes;
    }

    public void setTakes(Module[] takes) {
        this.takes = takes;
    }
    
    
    
}
