package net.designtypes.examples.powerful.core;

import java.rmi.Remote;
import java.rmi.RemoteException;

import net.designtypes.examples.powerful.model.InsureeNumber;

public interface LifeExpectancyFacade extends Remote {
	
	double getResidualLifeExpectancy(InsureeNumber insureeNumber) throws RemoteException;

}
