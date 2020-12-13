package com.example.demo.prog.methods.grpc;

import java.util.List;

import com.example.grpc.server.grpcserver.dog.CreateRequest;
import com.example.grpc.server.grpcserver.dog.DeleteRequest;
import com.example.grpc.server.grpcserver.dog.DogServiceGrpc;
import com.example.grpc.server.grpcserver.dog.GetRequest;
import com.example.grpc.server.grpcserver.dog.GetResponse;
import com.example.grpc.server.grpcserver.dog.ProtoDog;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public final class DogGrpcMethods {
	public void dogsReport() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		DogServiceGrpc.DogServiceBlockingStub stub = DogServiceGrpc.newBlockingStub(channel);

		GetResponse response = stub.get(GetRequest.newBuilder().build());
		channel.shutdown();

		List<ProtoDog> dogs = response.getDogsList();
		String report = "Dogs REPORT:";

		for (ProtoDog dog : dogs) {
			System.out.println(dog);
			report += dog.getBreed() + " " + dog.getName() + dog.getDescription() + " " + dog.getPrice();
		}

		System.out.println(report);
	}

	public void createDogs() {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		DogServiceGrpc.DogServiceBlockingStub stub = DogServiceGrpc.newBlockingStub(channel);

		ProtoDog protoDog = ProtoDog.newBuilder()
				.setName("QQQQ")
				.setBreed("LABRADOR")
				.setDescription("QQQQQQQQ")
				.setPrice(1234567)
				.build();

		stub.create(CreateRequest.newBuilder().setDog(protoDog).build());
		channel.shutdown();
	}

	public void sellDog(String cashRegisterId, String dogId) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9091).usePlaintext().build();
		DogServiceGrpc.DogServiceBlockingStub stub = DogServiceGrpc.newBlockingStub(channel);

		stub.delete(DeleteRequest.newBuilder()
				.setCashRegisterId(cashRegisterId)
				.setDogId(dogId)
				.build());
		channel.shutdown();
	}
}
