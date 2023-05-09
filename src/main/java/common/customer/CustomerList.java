package common.customer;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CustomerList extends Remote {

    public boolean add(Customer customer) throws RemoteException;

    public boolean remove(String customerId) throws RemoteException;

    public Customer retrieve(String id) throws RemoteException;

    public boolean update(Customer customer) throws RemoteException;

}