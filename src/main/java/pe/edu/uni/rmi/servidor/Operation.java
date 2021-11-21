/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.uni.rmi.servidor;
import pe.edu.uni.rmi.interfaz.RmiInterface;

/**
 * Basic operations
 * @author Intel
 */
public class Operation implements RmiInterface {
    
    @Override
    public int suma(int a, int b) {
        int res = a + b;
        System.out.println(a + " + " + b + " = " + res);
        return res;
    }
    @Override
    public int diferencia(int a, int b) {
        int res = a - b;
        System.out.println(a + " - " + b + " = " + res);
        return res;
    }
    @Override
    public int producto(int a, int b) {
        int res = a * b;
        System.out.println(a + " x " + b + " = " + res);
        return res;
    }
    @Override
    public int cociente(int a, int b) {
        int res = 0;
        if (b != 0)
            res = a / b;
        System.out.println(a + " / " + b + " = " + res);
        return res;
    }    
}
