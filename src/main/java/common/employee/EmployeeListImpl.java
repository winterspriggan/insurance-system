package common.employee;


import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeListImpl extends UnicastRemoteObject implements EmployeeList {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PORT_NUMBER = 20649;

    public static void main(String[] args) {
        try {
        	System.setProperty("java.rmi.server.hostname", "localhost");
            Registry registry = LocateRegistry.createRegistry(PORT_NUMBER);
            registry.bind("EMPLOYEE_LIST", new EmployeeListImpl());
            System.out.println("EmployeeList is running!");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
            System.out.println("Bind Failed!");
        }
    }

    private static final String dbPath = "common/employee/employees";
    private List<Employee> employeeList;

    public EmployeeListImpl() throws RemoteException {
        super();
        this.employeeList = new ArrayList<>();
        load();
    }

    private void load() {
        try {
            Employee employee = null;
            String[] values;
            Scanner scanner = new Scanner(new File(dbPath));
            while (scanner.hasNextLine()) {
                values = scanner.nextLine().split(" ");
                switch (values[4]) {
                    case "investigator" -> employee = new Investigator(values);
                    case "supporter" -> employee = new Supporter(values);
                    case "developer" -> employee = new Developer(values);
                    case "contractManager" -> employee = new ContractManager(values);
                }
                this.employeeList.add(employee);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(Employee employee) throws RemoteException {
        for (Employee element : employeeList) {
            if (element.getEmployeeId().equals(employee.getEmployeeId()))
                return false;
        }
        this.employeeList.add(employee);
        return true;
    }

    @Override
    public boolean remove(String employeeId) throws RemoteException {
        for (int idx = 0; idx < employeeList.size(); idx++) {
            if (employeeList.get(idx).getEmployeeId().equals(employeeId)) {
                this.employeeList.remove(idx);
                return true;
            }
        }
        return false;
    }

    @Override
    public Employee retrieve(String employeeId) throws RemoteException, Exception {
        for (Employee element : employeeList) {
            if (element.getEmployeeId().equals(employeeId))
                return element;
        }
        return null;
    }

    @Override
    public List<Employee> retrieveAll() throws RemoteException {
        return employeeList;
    }

    @Override
    public boolean update(Employee employee) throws RemoteException {
        for (int idx = 0; idx < employeeList.size(); idx++) {
            if (employeeList.get(idx).getEmployeeId().equals(employee.getEmployeeId())) {
                this.employeeList.set(idx, employee);
                return true;
            }
        }
        return false;
    }
}