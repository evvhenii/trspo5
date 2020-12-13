package com.example.demo.prog.methods.grpc;

import java.util.List;

import com.example.grpc.server.grpcserver.cashregister.CashRegisterServiceGrpc;
import com.example.grpc.server.grpcserver.cashregister.CreateRequest;
import com.example.grpc.server.grpcserver.cashregister.DeleteRequest;
import com.example.grpc.server.grpcserver.cashregister.GetRequest;
import com.example.grpc.server.grpcserver.cashregister.GetResponse;
import com.example.grpc.server.grpcserver.cashregister.ProtoCashRegister;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CashRegisterGrpcMethods {
	public void cashRegistersReport() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		CashRegisterServiceGrpc.CashRegisterServiceBlockingStub stub = CashRegisterServiceGrpc.newBlockingStub(channel);

		GetResponse response = stub.get(GetRequest.newBuilder().build());
		channel.shutdown();

		List<ProtoCashRegister> cashRegisters = response.getCashregistersList();
		String report = "CashRegisters REPORT:";

		for (ProtoCashRegister cashRegister : cashRegisters) {
			report += cashRegister.getName() + " " + cashRegister.getAddedAmount();
		}

		System.out.println(report);
	}

	public void createCashRegisters() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		CashRegisterServiceGrpc.CashRegisterServiceBlockingStub stub = CashRegisterServiceGrpc.newBlockingStub(channel);

		ProtoCashRegister protoCashRegister = ProtoCashRegister.newBuilder()
				.setName("Eva")
				.setAddedAmount(0)
				.build();

		stub.create(CreateRequest.newBuilder().setCashRegister(protoCashRegister).build());
		channel.shutdown();
	}

	public void deleteCashRegisters(String id) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		CashRegisterServiceGrpc.CashRegisterServiceBlockingStub stub = CashRegisterServiceGrpc.newBlockingStub(channel);

		stub.delete(DeleteRequest.newBuilder()
			    .setCashRegisterId(id)
				.build());
		channel.shutdown();
	}
}
