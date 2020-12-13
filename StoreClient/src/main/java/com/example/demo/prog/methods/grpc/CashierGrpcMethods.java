package com.example.demo.prog.methods.grpc;

import java.util.List;

import com.example.grpc.server.grpcserver.cashier.CashierServiceGrpc;
import com.example.grpc.server.grpcserver.cashier.CreateRequest;
import com.example.grpc.server.grpcserver.cashier.DeleteRequest;
import com.example.grpc.server.grpcserver.cashier.GetRequest;
import com.example.grpc.server.grpcserver.cashier.GetResponse;
import com.example.grpc.server.grpcserver.cashier.ProtoCashier;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public final class CashierGrpcMethods {
	public void cashiersReport() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);

		GetResponse response = stub.get(GetRequest.newBuilder().build());
		channel.shutdown();

		List<ProtoCashier> cashiers = response.getCashiersList();
		String report = "Cashiers REPORT:";

		for (ProtoCashier protoCashier : cashiers) {
			report += protoCashier.getName();
		}

		System.out.println(report);
	}

	public void createCashiers() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);

		ProtoCashier protoCashier = ProtoCashier.newBuilder()
				.setName("Eva")
				.build();

		stub.create(CreateRequest.newBuilder().setCashier(protoCashier).build());
		channel.shutdown();
	}

	public void deleteCashier(String id) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);

		stub.delete(DeleteRequest.newBuilder()
				.setId(id)
				.build());
		channel.shutdown();
	}
}
