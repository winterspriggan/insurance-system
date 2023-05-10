package client;

import common.customer.Customer;
import compensation.Claim;
import server.ServerImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.UUID;

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
                case "1" -> createClaim();
                default -> System.out.println("Invalid input!");
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

    private static void createClaim() throws IOException {
        String[] values = new String[12];
        values[0] = UUID.randomUUID().toString();
        values[1] = customer.getCustomerId();
        values[2] = "none";
        values[3] = getStandardInput("Input date", reader);
        values[4] = getStandardInput("Input type", reader);
        values[5] = getStandardInput("Input description", reader).replace(" ", "_");
        values[6] = getStandardInput("Input location", reader).replace(" ", "_");
        values[7] = "none";
        values[8] = "0";
        values[9] = "none";
        values[10] = "none";
        values[11] = "Reporting";
        if (serverImpl.createClaim(new Claim(values)))
            System.out.println("You have been created new claim successfully!");
        else
            System.out.println("You have been failed to create new claim!");
    }

}
