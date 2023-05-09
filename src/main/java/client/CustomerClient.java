package client;

import common.customer.Customer;
import server.ServerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class CustomerClient {

    private static final int SERVER_PORT_NUMBER = 40022;
    private static Customer customer = null;
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ServerImpl serverImpl;

    public static void main(String[] args) throws IOException {
        if (!connect()) return;
        while (customer == null) {
            customer = serverImpl.getCustomer(getStandardInput("Input your Customer ID", reader));
            if (customer == null)
                System.out.println("Login failed");
        }
        while (true) {
            printMenu();
            switch (getStandardInput("Select number", reader)) {
                case "1" -> System.out.println("Create new claim");
            }
        }
    }

    private static boolean connect() {
        try {
            serverImpl = (ServerImpl) LocateRegistry.getRegistry("localhost", SERVER_PORT_NUMBER)
                    .lookup("SERVER");
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
        System.out.println("***** Customer Menu *****");
        System.out.println("1. Create new claim");
    }

}
