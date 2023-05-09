package common.contract;


import java.io.File;
import java.util.List;

/**
 * @author imseongbin
 * @version 1.0
 * @created 01-5-2023 ?? 4:49:58
 */
public class Contract {

	private String compensationTeams;
	private int condition;
	private int customerId;
	private int fee;
	private int id;
	private String name;
	private int rate;
	private String teamsOfSubscription;
	private int type;
	private List<File> underwritingReport;

	public Contract(){

	}

	public void finalize() throws Throwable {

	}

	public boolean calculateRate(){
		return false;
	}

}