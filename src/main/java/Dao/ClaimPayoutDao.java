package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import claimPayout.ClaimPayout;
import contract.Product;

public class ClaimPayoutDao extends Dao{
	public ClaimPayoutDao() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(ClaimPayout claimPayout) {
	}
	
	public ClaimPayout retrieveOne(String value) throws SQLException {
		String query = "select * from claimPayout where customerId='"+value+"';";
		ResultSet resultSet = super.retrieve(query);
		String values[] = new String[3];
		while(resultSet.next()) {
		for(int i=0; i<7; i++) values[i] = resultSet.getString(i+2);
		}
		ClaimPayout claimPayout = new ClaimPayout(values);
		return claimPayout;
	}

	public List<ClaimPayout> retrieveAll() {
		String query = "select * from claimPayout;";
		ResultSet resultSet = super.retrieve(query);
		List<ClaimPayout> claimPayout = new ArrayList<ClaimPayout>();
		try {
			while (resultSet.next()) {
				String values[] = new String[3];
				for (int i = 0; i < 3; i++) {
					values[i] = resultSet.getString(i + 2);
				}
				claimPayout.add(new ClaimPayout(values));

			}
		} catch (SQLException e) {
			System.out.println("SQL문 오류입니다.");
			e.printStackTrace();
		}

		return claimPayout;
	}

	public void update(String[] values) {
		String columnName = getColumnName(Integer.parseInt(values[1]));
		String query = "update product set " + columnName + "='" + values[2] + "' where id=" + values[0] + ";";
		System.out.println(query);
		super.update(query);
	}

	public String getColumnName(int i) {
		switch (i) {
		case 1 -> {
			return "productId";
		}
		case 2 -> {
			return "name";
		}
		case 3 -> {
			return "target";
		}
		case 4 -> {
			return "compensationDetail";
		}
		case 5 -> {
			return "rate";
		}
		case 6 -> {
			return "profitNLossAnalysis";
		}
		case 7 -> {
			return "premiums";
		}
		default -> {
			return "null";
		}
		}
	}

	public void delete(String value) {
		String query = "delete from claimPayout where customerId='" + value + "';";
		System.out.println(query);
		super.delete(query);
	}


}
