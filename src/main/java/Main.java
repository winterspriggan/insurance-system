import common.contract.Contract;
import common.contract.ContractList;
import common.contract.ContractListImpl;
import common.customer.Customer;
import common.customer.CustomerList;
import common.customer.CustomerListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;
        while(flag){
            String line = br.readLine().trim();
            //show menu
            switch (line) {
                case "1":
                    registerCustomer(br);
                    break;
                case "2":
                    System.out.println("222");
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    public static void registerCustomer(BufferedReader br) throws IOException {
        CustomerList customerList = new CustomerListImpl();
        Customer customer = new Customer();

        System.out.println("---회원 가입 정보 입력하기---");

        System.out.print("1. 정보를 입력하세요 : ");
        String line = br.readLine().trim();

    }

    public static void designInsurance(BufferedReader br) {
        ContractList contractList = new ContractListImpl();
        Contract contract = new Contract();
    }

}