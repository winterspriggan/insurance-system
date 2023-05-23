package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import contract.Product;

public class ProductDao extends Dao {
	public ProductDao() {
		try {
			super.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(Product product) {
		String query = "insert into product (productId, name, target, compensationDetail, rate, profitNLossAnalysis, premiums) values("
				+ "'" + product.getId() + "', " + "'" + product.getProductName() + "', " + "'" + product.getTarget()
				+ "', " + "'" + product.getCompensationDetail() + "', " + product.getRate() + ", " + "'"
				+ product.getProfitNLossAnalysis() + "', " + product.getPremiums() + ");";
		System.out.println(query);
		super.create(query);
	}
	
	public Product retrieveOne(String value) throws SQLException {
		String query = "select * from product where productId='"+value+"';";
		ResultSet resultSet = super.retrieve(query);
		String values[] = new String[7];
		while(resultSet.next()) {
		for(int i=0; i<7; i++) values[i] = resultSet.getString(i+2);
		}
		Product product = new Product(values);
		return product;
	}

	public List<Product> retrieveAll() {
		String query = "select * from product;";
		ResultSet resultSet = super.retrieve(query);
		List<Product> productList = new ArrayList<Product>();
		try {
			while (resultSet.next()) {
				String values[] = new String[7];
				for (int i = 0; i < 7; i++) {
					values[i] = resultSet.getString(i + 2);
				}
				productList.add(new Product(values));

			}
		} catch (SQLException e) {
			System.out.println("SQL문 오류입니다.");
			e.printStackTrace();
		}

		return productList;
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
		String query = "delete from product where productId='" + value + "';";
		System.out.println(query);
		super.delete(query);
	}

}
