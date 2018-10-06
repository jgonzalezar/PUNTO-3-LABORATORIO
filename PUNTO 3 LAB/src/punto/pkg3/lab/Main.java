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
public class Main {
    public static void main(String[] args) {
        University university = new University("Unal");
        Module module = new Module("Engineering", "Systems");
        Grade grade = new Grade(5);
        Student stduent = new Student("Juan", module);
        
        
    }
}
