package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.prog.methods.grpc.*;
import com.example.demo.prog.methods.rest.*;

import java.util.Scanner;

@SpringBootApplication
public class SpringBootDogStoreClientApplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//gRPC
		System.out.println("gRPC:");
		
		DogGrpcMethods dogs = new DogGrpcMethods();
		dogs.dogsReport();
		dogs.createDogs();
		dogs.dogsReport();
		
		CashierGrpcMethods cashiers = new CashierGrpcMethods();
		cashiers.cashiersReport();
		cashiers.createCashiers();
		cashiers.cashiersReport();
		
		CashRegisterGrpcMethods cashRegisters = new CashRegisterGrpcMethods();
		cashRegisters.cashRegistersReport();
		cashRegisters.createCashRegisters();
		cashRegisters.cashRegistersReport();
		
		AccessoriesGrpcMethods accessories = new AccessoriesGrpcMethods();
		accessories.accessoriesReport();
		accessories.createAccessories();
		accessories.accessoriesReport();
		
		System.out.println("Please, enter ID of cash register youre working at:");
		String cashRegId = in.nextLine();
		
		System.out.println("Please, enter ID of dog you want to sell for customer:");
		String dogId = in.nextLine();
		
		dogs.sellDog(cashRegId, dogId);
		System.out.println("Money were added:");
		cashRegisters.cashRegistersReport();
		
		System.out.println("Please, enter ID of accessory you want to sell for customer:");
		String accessoryId = in.nextLine();
		
		accessories.sellAccessory(cashRegId, accessoryId);
		System.out.println("Money were added:");
		cashRegisters.cashRegistersReport();
		
		//REST
		System.out.println("REST:");
		
		CashRegisterMethods cashReg = new CashRegisterMethods();
		CashierMethods cashier = new CashierMethods();
		DogMethods dog = new DogMethods();
		AccessoriesMethods accessory = new AccessoriesMethods();
		
		cashReg.createCashRegister();
		cashier.createCashier();
		dog.createDogs();
		accessory.createForDogs();
		
		cashReg.cashRegisterReport();
		cashier.cashierReport();
		dog.dogsReport();
		accessory.forDogsReport();
		
		System.out.println("Please, enter ID of cash register youre working at:");
		String cashRegisterId = in.nextLine();
		
		System.out.println("Please, enter ID of dog you want to sell for customer:");
		String dogsId = in.nextLine();
		
		dog.sellDog(cashRegisterId, dogsId);
		System.out.println("Money were added:");
		cashReg.cashRegisterReport();
		
		System.out.println("Please, enter ID of accessory you want to sell for customer:");
		String accessoriesId = in.nextLine();
		
		accessory.sellAccessory(cashRegisterId, accessoriesId);
		System.out.println("Money were added:");
		cashReg.cashRegisterReport();
	}

}
