package client;

import common.employee.ContractManager;
import common.employee.Developer;
import common.employee.Employee;
import common.employee.Investigator;
import common.employee.Supporter;
import compensation.Claim;
import contract.Product;
import server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;

public class EmployeeClient {

	private static final int SERVER_PORT_NUMBER = 40029;
	private static Employee employee = null;
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static Server serverImpl;

	public static void main(String[] args) throws IOException, Exception {
		if (!connect())
			return;
		while (employee == null) {
			employee = serverImpl.getEmployee(getStandardInput("Input your Employee ID", reader));
			if (employee == null)
				System.out.println("Login failed");
		}
		while (true) {
			printMenu();
			switch (getStandardInput("Select number", reader)) {
			case "1" -> {
				if (employee instanceof Investigator)
					uploadReport(reader);
				else
					System.out.println("Permission denied!");
			}
			case "2" -> {
				if (employee instanceof Supporter)
					reviewClaim(reader);
				else
					System.out.println("Permission denied!");
			}
			case "3" -> {
				if (employee instanceof Developer)
					developProductInitial(reader);
			}
			case "4" -> {
				if(employee instanceof ContractManager)
					contractManageInitial(reader);
			}
			default -> System.out.println("Invalid input!");
			}
		}
	}

	private static void contractManageInitial(BufferedReader reader) throws IOException{
		while(true) {
		contractManageMenu();
		String choice = reader.readLine().trim();
		switch(choice) {
		case "1" -> {
			manageClaimPayout(reader);
		}
		case "x" -> {
			break;
		}
		default -> {
			System.out.println("잘못된 입력입니다.");
		}
	   }
		break;
      }
    }
	private static void manageClaimPayout(BufferedReader reader) throws IOException{
		System.out.println();
		showList(serverImpl.printClaimPayout());
		System.out.println("지급할 고객의 ID를 입력하여 주십시오.");
		String customerId = reader.readLine().trim();
		System.out.println("해당 고객에게 제지급금을 지급하시겠습니까? Y/N");
		String answer = reader.readLine().trim();
		System.out.println(answer);
		if(answer.equalsIgnoreCase("y")) {
			if(serverImpl.payClaimPayout(customerId)) {
				System.out.println("지급 완료");
	}
		  else {
			  System.out.println("존재하지 않는 고객의 ID입니다.");
		  }
		} else if(answer.equalsIgnoreCase("n")) {
			System.out.println("취소되었습니다.");
		}
	
	}

	private static void contractManageMenu() {
		System.out.println("***** 계약 관리 *****");
		System.out.println("1.제지급금 관리");
		System.out.println("x.이전 메뉴로 나가기");
	}
	

	private static boolean connect() {
		try {
			serverImpl = (Server) LocateRegistry.getRegistry("localhost", SERVER_PORT_NUMBER).lookup("SERVER");
			return true;
		} catch (RemoteException | NotBoundException e) {
			System.out.println("Server connection error");
			return false;
		}
	}

	private static String getStandardInput(String message, BufferedReader reader) throws IOException {
		System.out.print(message + "\n" + ">> ");
		return reader.readLine().trim();
	}

	private static void printMenu() {
		System.out.println("***** Employee Menu *****");
		System.out.println("1. 보고서 업로드");
		System.out.println("2. 문의사항 확인");
		System.out.println("3. 상품 개발");
		System.out.println("4. 계약 관리");
	}

	private static void uploadReport(BufferedReader reader) throws IOException {
		List<Claim> claims = serverImpl.getClaims();
		System.out.println("< Claim List > ");
		for (Claim claim : claims) {
			if (claim.getEmployeeId().equals(employee.getEmployeeId()))
				System.out.println(claim);
		}
		Claim claim = null;
		while (claim == null) {
			String claimId = getStandardInput("Input claim ID", reader);
			for (Claim element : claims) {
				if (element.getClaimId().equals(claimId))
					claim = element;
			}
			if (claim == null)
				System.out.println("Not found!");
		}
		String report = getStandardInput("Input report", reader);
		claim.setReport(report);
		if (serverImpl.updateClaim(claim)) {
			System.out.println("You have been uploaded report successfully!");
			decideCompensation(reader, claim);
		} else
			System.out.println("You have been failed to upload report!");
	}

	private static void decideCompensation(BufferedReader reader, Claim claim) throws IOException {
		int compensation = Integer.parseInt(getStandardInput("Input compensation", reader));
		claim.setCompensation(compensation);
		claim.setReview("Reviewing");
		if (serverImpl.updateClaim(claim)) {
			System.out.println("You have been decided compensation successfully!");
		} else
			System.out.println("You have been failed to decide compensation!");
	}

	private static void reviewClaim(BufferedReader reader) throws IOException {
		List<Claim> claims = serverImpl.getClaims();
		System.out.println("< Claim List > ");
		for (Claim claim : claims) {
			if (claim.getReview().equals("Reviewing"))
				System.out.println(claim);
		}
		Claim claim = null;
		while (claim == null) {
			String claimId = getStandardInput("Input claim ID", reader);
			for (Claim element : claims) {
				if (element.getClaimId().equals(claimId))
					claim = element;
			}
			if (claim == null)
				System.out.println("Not found!");
		}
		String review = getStandardInput("Input review result", reader);
		claim.setReview(review);
		if (serverImpl.updateClaim(claim)) {
			System.out.println("You have been reviewed claim successfully!");
		} else
			System.out.println("You have been failed to review claim!");
	}

	// 상품 개발
	private static void developProductInitial(BufferedReader reader) throws IOException, Exception {
		while (true) {
			developMenu();
			switch (reader.readLine().trim()) {
			case "1" -> {
				developProduct(reader);
			}
			case "2" -> {
				computeRate(reader);
			}
			case "3" -> {
				retrieveProduct(reader);
			}
			case "4" -> {
				showList(serverImpl.printProduct());
			}
			case "5" -> {
				updateProductList(reader);
			}
			case "6" -> {
				deleteProduct(reader);
			}
			case "x" -> {
				break;
			}
			default -> {
				System.out.println("잘못된 요청입니다. 다시 입력하여 주십시오.");
			}
			}
			break;
		}
	}
	
	private static void retrieveProduct(BufferedReader reader2) throws IOException, Exception{
		System.out.println("검색할 상품의 ID를 입력하여 주십시오.");
		String value = reader.readLine().trim();
		Product product = serverImpl.retrieveProduct(value);
		System.out.println(product.toString());
	}

	private static void deleteProduct(BufferedReader reader) throws IOException{
		showList(serverImpl.printProduct());
		System.out.println("삭제할 상품의 ID를 입력하여 주십시오.");
		String value = reader.readLine().trim();
		if(serverImpl.deleteProduct(value)) {
			System.out.println("삭제 완료");;
		} else {
		   	System.out.println("존재하지 않는 상품의 ID입니다.");
		}
	}

	private static void updateProductList(BufferedReader reader) throws IOException{
		showList(serverImpl.printProduct());
		System.out.println("수정할 행과 열의 번호를 입력해주세요.");
		String values[] = new String[3];
		System.out.println("수정할 행의 번호 : ");
		values[0] = reader.readLine().trim();
		System.out.println("수정할 열의 번호 : ");
		values[1] = reader.readLine().trim();
		System.out.println("수정할 값을 적어주세요 : ");
		values[2] = reader.readLine().trim();
		if(serverImpl.updateProduct(values)) 
			System.out.println("수정 완료");
		
	}
	
	private static void showList(List<?> dataList) {
		String list = "";
		for (int i = 0; i < dataList.size(); i++) {
			list += dataList.get(i) + "\n";
		}
		System.out.println(list);
	}

//	private static void printProductList() throws RemoteException {
//		List<Product> products = serverImpl.printProduct();
//		System.out.println("|| 상품 ID || 상품 이름 || 대상 || 보상내역 || 요율 || 손익분석 || 보험료 ||");
//		for(int i=0; i<products.size(); i++) {
//			System.out.println(products.get(i).toString()); 
//		}
//	}

	private static void developMenu() {
		System.out.println("***** 상품 개발 *****");
		System.out.println("1. 상품 개발");
		System.out.println("2. 요율 계산");
		System.out.println("3. 상품 조회");
		System.out.println("4. 상품 리스트 확인");
		System.out.println("5. 상품 수정");
		System.out.println("6. 상품 삭제");
		System.out.println("x. 이전 메뉴로 나가기");
	}

	private static void developProduct(BufferedReader reader) {
		String[] values = new String[7];
		try {
			System.out.println("************상품 개발*************");
			System.out.println("----상품의 정보를 입력하여 주십시오.----");
			System.out.println("상품 id : ");
			values[0] = reader.readLine().trim();
			
			System.out.println("상품 명 : ");
			values[1] = reader.readLine().trim();
			
			System.out.println("대상 고객 : ");
			values[2] = reader.readLine().trim();
			
			System.out.println("보상 세부 내용 : ");
			values[3] = reader.readLine().trim();
			
			System.out.println("수집된 요율 :  ");
			int value=0;
			try {
			value = Integer.parseInt(reader.readLine().trim());
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력하여 주세요.");
				value = Integer.parseInt(reader.readLine().trim());
			}
			values[4] = ""+value;
			
			System.out.println("손익 분석 : ");
			values[5] = reader.readLine().trim();
			
			
			System.out.println("보험료 : ");
			int val = 0;
			try {
				val = Integer.parseInt(reader.readLine().trim());
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력하여 주세요.");
				val = Integer.parseInt(reader.readLine().trim());
			}
			values[6] = ""+val;
			
			System.out.println("****상품을 업로드 하시겠습니까? (Y/N)****");
			String answer = reader.readLine().trim();
			if (answer.equals("y") || answer.equals("Y")) {
				if (serverImpl.createProduct(values))System.out.println("업로드 완료");
				else  System.out.println("상품 정보 입력 오류");
			}
				else if (answer.equals("n") || answer.equals("N")) {
					System.out.println("상품 개발이 취소되었습니다.");
				}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void computeRate(BufferedReader reader) throws IOException {
		String input[] = new String[4];
		System.out.println("대상 고객의 정보를 입력하여 주세요.");
		System.out.println("성별 : 1. 남자 2.여자");
		reader.readLine();
		System.out.println("대상 고객의 연령대가 60대 이상입니까?");
		System.out.println("1. 예 2.아니오");
		input[0] = reader.readLine();
		System.out.println("가족력이 있는 고객 전용입니까?");
		System.out.println("1. 예 2.아니오");
		input[1] = reader.readLine();
		System.out.println("흡연하는 고객이 대상입니까?");
		System.out.println("1. 예 2.아니오");
		input[2] = reader.readLine();
		System.out.println("상대적으로 위험한 직업을 가진 고객이 대상입니까?");
		System.out.println("1. 예 2.아니오");
		input[3] = reader.readLine();
		double rate = 0;
		for (int i = 0; i < input.length; i++) {
			if (Integer.parseInt(input[i]) == 1)
				rate += 1;
		}
		double resultRate = (100 + (rate * 25)) / 100;
		System.out.println();
		System.out.println("해당 상품의 요율은 " + resultRate + "배 입니다.");
	}

}
