package server;

import common.customer.Customer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerImpl extends Remote {
    Customer getCustomer(String customerId) throws RemoteException;
}
