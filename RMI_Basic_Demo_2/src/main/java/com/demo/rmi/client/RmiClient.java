package com.demo.rmi.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import com.demo.rmi.model.ReceiveMessage;

public class RmiClient {

	public static void main(String[] args) {
		String serverAdd = args[0];
		String thisPort = args[1];
		String msg = args[2];
		try {
			Registry registry = LocateRegistry.getRegistry(serverAdd, Integer.parseInt(thisPort));
			ReceiveMessage receiveMsg = (ReceiveMessage) registry.lookup("rmiServer");
			System.out.println("client calling server...");
			receiveMsg.receiveMessage(msg);
			System.out.println("client called server...");
			Thread.sleep(2000);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
