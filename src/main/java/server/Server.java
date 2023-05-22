package server;

import common.customer.Customer;
import common.employee.Employee;
import compensation.Claim;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServerImpl extends Remote {
    Customer getCustomer(String customerId) throws RemoteException;

    Employee getEmployee(String employeeId) throws RemoteException;

    List<Claim> getClaims() throws RemoteException;

    boolean updateClaim(Claim claim) throws RemoteException;

    boolean createClaim(Claim claim) throws RemoteException;
}
