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
public class Module {
    private String lecturer;
    private String name;
    private Grade[] grades;

    public Module(String lecturer, String name, Grade[] grades) {
        this.lecturer = lecturer;
        this.name = name;
        this.grades = grades;
    }

    public Module(String lecturer, String name) {
        this.lecturer = lecturer;
        this.name = name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
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
    
    
    
}
