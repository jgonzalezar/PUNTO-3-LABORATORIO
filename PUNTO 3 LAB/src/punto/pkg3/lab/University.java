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
public class University {
    private String nombre;
    private Module[] modules;
    private Student [] students;

    public University(String nombre) {
        this.modules = new Module[7];
        this.students = new Student[100];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Module[] getModules() {
        return modules;
    }

    public void setModules(Module[] modules) {
        this.modules = modules;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
    
        
}
