package contract;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
/*
 * @author junse
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:58
 */
public interface ProductList extends Remote{
	public boolean add(String[] values) throws RemoteException;
    public boolean delete(String productId) throws RemoteException;
    public Product retrieve(String productId) throws RemoteException, Exception;
    public List<Product> retrieveAll() throws RemoteException;
    public boolean update(String[] values) throws RemoteException;
//	}
}