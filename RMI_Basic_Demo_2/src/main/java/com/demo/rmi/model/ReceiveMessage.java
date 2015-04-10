package com.demo.rmi.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReceiveMessage extends Remote {

	public void receiveMessage (String msg) throws RemoteException;
}
