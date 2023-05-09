package server;

import common.customer.Customer;
import common.customer.CustomerListImpl;
import compensation.ClaimList;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ServerImpl {

    private static final int PORT_NUMBER = 30022;
    private static final int CLAIM_LIST_PORT_NUMBER = 20622;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(PORT_NUMBER);
            registry.bind("SERVER", new Server());
            System.out.println("Server is running!");
            claimListImpl = (ClaimList) LocateRegistry.getRegistry("localhost", CLAIM_LIST_PORT_NUMBER)
                    .lookup("CLAIM_LIST");
            System.out.println("ClaimList is bound!");
        } catch (RemoteException | AlreadyBoundException | NotBoundException e) {
            e.printStackTrace();
            System.out.println("Bind Failed!");
        }
    }

    private static ClaimList claimListImpl;
    private static CustomerListImpl customerListImpl;

    public Server() throws RemoteException {
        super();
    }

    @Override
    public Customer getCustomer(String customerId) throws RemoteException {
        return customerListImpl.retrieve(customerId);
    }
}