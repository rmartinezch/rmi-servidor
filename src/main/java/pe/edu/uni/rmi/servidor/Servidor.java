/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.uni.rmi.servidor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.uni.rmi.interfaz.RmiInterface;

/**
 *
 * @author Intel
 */
public class Servidor extends UnicastRemoteObject implements RmiInterface {

    private final int port = 23456;
    private final String tag = "operation";

    public Servidor() throws RemoteException {
        super();
    }

    public static void main(String args[]) throws RemoteException {
        // Server starts here
//        Servidor servidor = new Servidor();
//        servidor.initServer();
        new Servidor().initServer();
    }

    /**
     * This method creates the connection
     */
    private void initServer() {
        try {
            String ipAddress = InetAddress.getLocalHost().toString();
            System.out.println("ipAddress: " + ipAddress + ":" + port);
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind(tag, (RmiInterface) this);
        } catch (UnknownHostException | RemoteException | AlreadyBoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int suma(int a, int b) throws RemoteException {
        return new Operation().suma(a, b);
    }

    @Override
    public int diferencia(int a, int b) throws RemoteException {
        return new Operation().diferencia(a, b);
    }

    @Override
    public int producto(int a, int b) throws RemoteException {
        return new Operation().producto(a, b);
    }

    @Override
    public int cociente(int a, int b) throws RemoteException {
        return new Operation().cociente(a, b);
    }
}
