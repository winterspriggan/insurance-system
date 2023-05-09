package common.customer;


import compensation.ClaimListImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class CustomerListImpl extends UnicastRemoteObject implements CustomerList {

    private static final int PORT_NUMBER = 30645;

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(PORT_NUMBER);
            registry.bind("CUSTOMER_LIST", new CustomerListImpl());
            System.out.println("CustomerList is running!");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
            System.out.println("Bind Failed!");
        }
    }

    private List<Customer> customerList;

    public CustomerListImpl() throws RemoteException {
        super();
        this.customerList = new ArrayList<>();
    }

    @Override
    public boolean add(Customer customer) {
        for (Customer element : customerList) {
            if (element.getCustomerId().equals(customer.getCustomerId()))
                return false;
        }
        customerList.add(customer);
        return true;
    }

    @Override
    public boolean remove(String customerId) throws RemoteException {
        for (int idx = 0; idx < customerList.size(); idx++) {
            if (customerList.get(idx).getCustomerId().equals(customerId)) {
                customerList.remove(idx);
                return true;
            }
        }
        return false;
    }


    public Customer retrieve(String customerId) {
        for (Customer element : customerList) {
            if (element.getCustomerId().equals(customerId))
                return element;
        }
        return null;
    }

    @Override
    public boolean update(Customer customer) throws RemoteException {
        for (int idx = 0; idx < customerList.size(); idx++) {
            if (customerList.get(idx).getCustomerId().equals(customer.getCustomerId())) {
                customerList.set(idx, customer);
                return true;
            }
        }
        return false;
    }

}