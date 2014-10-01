package net.designtypes.examples.robust.api;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LifeExpectancyCalculator extends Remote {
	Double getResidualLifeExpecancy(String insureeNumber) throws RemoteException;
}
