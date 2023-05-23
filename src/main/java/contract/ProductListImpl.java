package contract;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.ProductDao;

public class ProductListImpl extends UnicastRemoteObject implements ProductList {
	/**
	 * 
	 */
	private ProductDao productDao;
	private static final long serialVersionUID = 1L;
	List<Product> productList;
	private static final int PORT_NUMBER = 40019;

	protected ProductListImpl() throws RemoteException {
		super();
		this.productList = new ArrayList<>();
		this.productDao = new ProductDao();
	}

	public static void main(String[] args) {
		try {
			System.setProperty("java.rmi.server.hostname", "localhost");
			Registry registry = LocateRegistry.createRegistry(PORT_NUMBER);
			registry.bind("PRODUCT_LIST", new ProductListImpl());
			System.out.println("ProductList is running!");
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
			System.out.println("Bind Failed!");
		}
	}

	@Override
	public boolean add(String[] values) throws RemoteException {
		Product product = new Product(values);
		this.productList.add(product);
		this.productDao.insert(product);
		return true;
	}

	@Override
	public boolean delete(String productId) throws RemoteException {
		this.productDao.delete(productId);
		return true;
	}

	@Override
	public Product retrieve(String productId) throws RemoteException, Exception {
		Product product = this.productDao.retrieveOne(productId);
		return product;
	}

	@Override
	public List<Product> retrieveAll() throws RemoteException {
		this.productList = productDao.retrieveAll();
		return this.productList;
	}

	@Override
	public boolean update(String[] values) throws RemoteException {
		productDao.update(values);
		return true;
	}

}