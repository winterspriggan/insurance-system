package claimPayout;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import contract.Product;
public interface ClaimPayoutList extends Remote{
	public boolean add(String[] values) throws RemoteException;
    public boolean delete(String customerId) throws RemoteException;
    public ClaimPayout retrieve(String value) throws RemoteException, Exception;
    public List<ClaimPayout> retrieveAll() throws RemoteException;
    public boolean update(String[] values) throws RemoteException;
}
