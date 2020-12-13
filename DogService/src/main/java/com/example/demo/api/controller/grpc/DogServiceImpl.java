package com.example.demo.api.controller.grpc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.DogsService;
import com.example.demo.service.model.Breed;
import com.example.demo.service.model.Dog;
import com.example.grpc.server.grpcserver.dog.CreateRequest;
import com.example.grpc.server.grpcserver.dog.CreateResponse;
import com.example.grpc.server.grpcserver.dog.DeleteRequest;
import com.example.grpc.server.grpcserver.dog.DeleteResponse;
import com.example.grpc.server.grpcserver.dog.DogServiceGrpc.DogServiceImplBase;
import com.example.grpc.server.grpcserver.dog.GetRequest;
import com.example.grpc.server.grpcserver.dog.GetResponse;
import com.example.grpc.server.grpcserver.dog.ProtoDog;
import com.example.grpc.server.grpcserver.updating.UpdateRequest;
import com.example.grpc.server.grpcserver.updating.UpdatingBalanceServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class DogServiceImpl extends DogServiceImplBase{
	private final DogsService dogService;
	
	@Autowired 
    public DogServiceImpl(DogsService dogService) {
      this.dogService = dogService;
    }
	
    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
    	List<Dog> dogs = dogService.getDogs();
    	    	
    	List<ProtoDog> protoDogs = new ArrayList<>();
    	for(Dog dog: dogs) {
    		ProtoDog protoDog = ProtoDog.newBuilder()
    				.setName(dog.getName())
    				.setBreed(dog.getBreed())
    				.setDescription(dog.getDescription())
    				.setPrice(dog.getPrice())
    				.build();
    		protoDogs.add(protoDog);
    		
    	}
    	GetResponse response = GetResponse.newBuilder().addAllDogs(protoDogs).build();
    	    	
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void create(CreateRequest request, StreamObserver<CreateResponse> responseObserver) {
    	String name = request.getDog().getName();
    	String breed = request.getDog().getBreed();
    	String description = request.getDog().getDescription();
    	int price = request.getDog().getPrice();
    	Dog dog = dogService.takeInStore(Breed.valueOf(breed), name, description, price);
    	
        CreateResponse response = CreateResponse.newBuilder()
                .setId(dog.getDogId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
    	String dogId = request.getDogId();
    	System.out.println("dogId" + dogId);
    	String cashRegisterId = request.getCashRegisterId();
    	String name = dogService.getDogById(dogId).getName();
    	int dogPrice = dogService.getDogPrice(dogId);
    	dogService.sellDogFromStore(dogId);
    	    	
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9097)
                .usePlaintext()
                .build();
        UpdatingBalanceServiceGrpc.UpdatingBalanceServiceBlockingStub stub = 
        		UpdatingBalanceServiceGrpc.newBlockingStub(channel);
        stub.update(UpdateRequest.newBuilder()
                .setCashRegisterId(cashRegisterId)
                .setAddedAmount(dogPrice)
                .build());
        channel.shutdown();
            	
        DeleteResponse response = DeleteResponse.newBuilder()
                .setReport("Dog " + name + " was DELETED")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
