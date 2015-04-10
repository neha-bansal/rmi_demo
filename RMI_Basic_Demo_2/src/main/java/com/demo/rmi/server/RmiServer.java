package com.demo.rmi.server;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import com.demo.rmi.model.ReceiveMessage;

public class RmiServer extends UnicastRemoteObject implements ReceiveMessage {

	public RmiServer() throws RemoteException {
		String ipAddress = "";
		try {
			ipAddress = InetAddress.getLocalHost().toString();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		int thisPort=3232;  // this port(registry's port)
        System.out.println("this address=" + ipAddress + ",port=" + thisPort);
        
        Registry registry = LocateRegistry.createRegistry(thisPort);
        registry.rebind("rmiServer", this);
	}
	
	public static void main(String[] args) {
		try {
			ReceiveMessage rmiServer = new RmiServer();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void receiveMessage(String msg) {
		System.out.println(msg);
	}
}
