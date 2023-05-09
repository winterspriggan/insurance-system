package common.employee;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmployeeList extends Remote {

    public boolean add(Employee employee) throws RemoteException;

    public boolean remove(String employeeId) throws RemoteException;

    public Employee retrieve(String employeeId) throws RemoteException;

    public boolean update(Employee employee) throws RemoteException;

}