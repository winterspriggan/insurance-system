package claimPayout;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import Dao.ClaimPayoutDao;

public class ClaimPayoutListImpl extends UnicastRemoteObject implements ClaimPayoutList{
	/**
	 * 
	 */
	private ClaimPayoutDao claimPayoutDao;
	private static final long serialVersionUID = 1L;
	List<ClaimPayout> claimPayoutList;
	private static final int PORT_NUMBER = 40013;

	protected ClaimPayoutListImpl() throws RemoteException {
		super();
		this.claimPayoutList = new ArrayList<>();
		this.claimPayoutDao = new ClaimPayoutDao();
	}

	public static void main(String[] args) {
		try {
			System.setProperty("java.rmi.server.hostname", "localhost");
			Registry registry = LocateRegistry.createRegistry(PORT_NUMBER);
			registry.bind("CLAIM_PAYOUT_LIST", new ClaimPayoutListImpl());
			System.out.println("ClaimPayoutList is running!");
		} catch (RemoteException | AlreadyBoundException e) {
			e.printStackTrace();
			System.out.println("Bind Failed!");
		}
	}

	@Override
	public boolean add(String[] values) throws RemoteException {
		ClaimPayout claimPayout = new ClaimPayout(values);
		this.claimPayoutList.add(claimPayout);
		return true;
	}

	@Override
	public boolean delete(String customerId) throws RemoteException {
		this.claimPayoutList = claimPayoutDao.retrieveAll();
		for(int i=0; i<this.claimPayoutList.size(); i++) {
			if(this.claimPayoutList.get(i).getCustomerId().equals(customerId)) {
				this.claimPayoutDao.delete(customerId);
				return true;
			} 
		}
		return false;
	}

	@Override
	public ClaimPayout retrieve(String value) throws RemoteException, Exception {
		ClaimPayout claimPayout = this.claimPayoutDao.retrieveOne(value);
		return claimPayout;
	}

	@Override
	public List<ClaimPayout> retrieveAll() throws RemoteException {
		this.claimPayoutList = claimPayoutDao.retrieveAll();
		return this.claimPayoutList;
	}

	@Override
	public boolean update(String[] values) throws RemoteException {
		claimPayoutDao.update(values);
		return true;
	}

}