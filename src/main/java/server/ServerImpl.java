package server;

import common.contract.ContractList;
import common.customer.Customer;
import common.customer.CustomerList;
import common.employee.Employee;
import common.employee.EmployeeList;
import common.employee.Investigator;
import compensation.Claim;
import compensation.ClaimList;
import contract.Product;
import contract.ProductList;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import claimPayout.ClaimPayout;
import claimPayout.ClaimPayoutList;

public class ServerImpl extends UnicastRemoteObject implements Server {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int PORT_NUMBER = 40029;
//    private static final int CLAIM_LIST_PORT_NUMBER = 20623;
//    private static final int CUSTOMER_LIST_PORT_NUMBER = 30643;
//    private static final int CONTRACT_LIST_PORT_NUMBER = 30223;
    private static final int EMPLOYEE_LIST_PORT_NUMBER = 20649;
    private static final int PRODUCT_LIST_PORT_NUMBER = 40019;
    private static final int CLAIM_PAYOUT_LIST_PORT_NUMBER = 40013;

    public static void main(String[] args) {
        try {
        	System.setProperty("java.rmi.server.hostname", "localhost");
            Registry registry = LocateRegistry.createRegistry(PORT_NUMBER);
            registry.bind("SERVER", new ServerImpl());
            System.out.println("Server is running!");
//            claimListImpl = (ClaimList) LocateRegistry.getRegistry("localhost", CLAIM_LIST_PORT_NUMBER)
//                    .lookup("CLAIM_LIST");
//            System.out.println("ClaimList is bound!");
//            customerListImpl = (CustomerList) LocateRegistry.getRegistry("localhost", CUSTOMER_LIST_PORT_NUMBER)
//                    .lookup("CUSTOMER_LIST");
//            System.out.println("CustomerList is bound!");
            employeeListImpl = (EmployeeList) LocateRegistry.getRegistry("localhost", EMPLOYEE_LIST_PORT_NUMBER)
                    .lookup("EMPLOYEE_LIST");
            System.out.println("EmployeeList is bound!");
//            contractListImpl = (ContractList) LocateRegistry.getRegistry("localhost", CONTRACT_LIST_PORT_NUMBER)
//                    .lookup("CONTRACT_LIST");
//            System.out.println("ContractList is bound!");
            productListImpl = (ProductList) LocateRegistry.getRegistry("localhost", PRODUCT_LIST_PORT_NUMBER)
                    .lookup("PRODUCT_LIST");
            System.out.println("ProductList is bound!");
            claimPayoutListImpl = (ClaimPayoutList) LocateRegistry.getRegistry("localhost", CLAIM_PAYOUT_LIST_PORT_NUMBER)
                    .lookup("CLAIM_PAYOUT_LIST");
            System.out.println("ClaimPayoutList is bound!");
        } catch (RemoteException | AlreadyBoundException | NotBoundException e) {
            e.printStackTrace();
            System.out.println("Bind Failed!");
        }
    }

    private static ClaimList claimListImpl;
    private static CustomerList customerListImpl;
    private static EmployeeList employeeListImpl;
    private static ProductList productListImpl;
    private static ContractList contractListImpl;
    private static ClaimPayoutList claimPayoutListImpl;

    public ServerImpl() throws RemoteException {
        super();
    }

    @Override
    public Customer getCustomer(String customerId) throws RemoteException {
        return customerListImpl.retrieve(customerId);
    }

    @Override
    public Employee getEmployee(String employeeId) throws RemoteException, Exception{
			return employeeListImpl.retrieve(employeeId);
    }

    @Override
    public List<Claim> getClaims() throws RemoteException {
        return claimListImpl.retrieveAll();
    }

    @Override
    public boolean updateClaim(Claim claim) throws RemoteException {
        return claimListImpl.update(claim);
    }

    @Override
    public boolean createClaim(Claim claim) throws RemoteException {
        List<Employee> employeeList = employeeListImpl.retrieveAll();
        List<Employee> investigators = new ArrayList<>();
        for (Employee employee : employeeList)
            if (employee.getDepartment().equals("investigator"))
                investigators.add(employee);
        claim.setEmployeeId(investigators.get(new Random().nextInt(investigators.size()))
                .getEmployeeId());
        return claimListImpl.add(claim);
    }

	@Override
	public boolean createProduct(String[] values) throws RemoteException {
		return productListImpl.add(values);
	}

	@Override
	public boolean updateProduct(String[] values) throws RemoteException {
		productListImpl.update(values);
		return true;
	}
	
	@Override
	public List<Product> printProduct() throws RemoteException {
		return productListImpl.retrieveAll();
	}

	@Override
	public boolean deleteProduct(String value) throws RemoteException {
		return productListImpl.delete(value);
	}
@Override
	public Product retrieveProduct(String value) throws RemoteException, Exception {
		Product retrievedProduct = productListImpl.retrieve(value); 
		return retrievedProduct;
	}

@Override
public List<ClaimPayout> printClaimPayout() throws RemoteException {
	return claimPayoutListImpl.retrieveAll();
}

@Override
public boolean payClaimPayout(String value) throws RemoteException {
	claimPayoutListImpl.delete(value);
	return true;
}
	
}