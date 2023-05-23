package server;

import common.customer.Customer;
import common.employee.Employee;
import compensation.Claim;
import contract.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import claimPayout.ClaimPayout;

public interface Server extends Remote {
    Customer getCustomer(String customerId) throws RemoteException;

    Employee getEmployee(String employeeId) throws RemoteException, Exception;

    List<Claim> getClaims() throws RemoteException;

    boolean updateClaim(Claim claim) throws RemoteException;

    boolean createClaim(Claim claim) throws RemoteException;
    
    boolean createProduct(String[] values) throws RemoteException;
    
    boolean updateProduct(String[] values) throws RemoteException;
    
    List<Product> printProduct() throws RemoteException;
    
    boolean deleteProduct(String value) throws RemoteException;
    
    Product retrieveProduct(String value) throws RemoteException, Exception;
    
 List<ClaimPayout> printClaimPayout() throws RemoteException;
    
    boolean payClaimPayout(String value) throws RemoteException;
}
