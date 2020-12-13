package com.example.demo.prog.methods.grpc;

import java.util.List;

import com.example.grpc.server.grpcserver.accessory.CreateRequest;
import com.example.grpc.server.grpcserver.accessory.DeleteRequest;
import com.example.grpc.server.grpcserver.accessory.AccessoryServiceGrpc;
import com.example.grpc.server.grpcserver.accessory.GetRequest;
import com.example.grpc.server.grpcserver.accessory.GetResponse;
import com.example.grpc.server.grpcserver.accessory.ProtoAccessory;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AccessoriesGrpcMethods {
	public void accessoriesReport() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		AccessoryServiceGrpc.AccessoryServiceBlockingStub stub = AccessoryServiceGrpc.newBlockingStub(channel);

		GetResponse response = stub.get(GetRequest.newBuilder().build());
		channel.shutdown();

		List<ProtoAccessory> accessories = response.getAccessoriesList();
		String report = "Accessories REPORT:";

		for (ProtoAccessory protoAccessory : accessories) {
			System.out.println(protoAccessory);
			report += protoAccessory.getType() + " " + protoAccessory.getColor() + " " + protoAccessory.getPrice();
		}

		System.out.println(report);
	}

	public void createAccessories() {
		ManagedChannel channel = ManagedChannelBuilder
				.forAddress("localhost", 9091)
				.usePlaintext()
				.build();
		AccessoryServiceGrpc.AccessoryServiceBlockingStub stub = AccessoryServiceGrpc.newBlockingStub(channel);

		ProtoAccessory protoAccessory = ProtoAccessory.newBuilder()
				.setType("LEASH")
				.setColor("BLACK")
				.setPrice(789)
				.build();

		stub.create(CreateRequest.newBuilder().setAccessory(protoAccessory).build());
		channel.shutdown();
	}

	public void sellAccessory(String cashRegisterId, String accessoryId) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		AccessoryServiceGrpc.AccessoryServiceBlockingStub stub = AccessoryServiceGrpc.newBlockingStub(channel);

		stub.delete(DeleteRequest.newBuilder()
				.setCashRegisterId(cashRegisterId)
				.setAccessoryId(accessoryId)
				.build());
		channel.shutdown();
	}
}
