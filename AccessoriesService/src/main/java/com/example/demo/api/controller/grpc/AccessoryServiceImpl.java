package com.example.demo.api.controller.grpc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.AccessoriesService;
import com.example.demo.service.model.Accessory;
import com.example.demo.service.model.Color;
import com.example.demo.service.model.Type;
import com.example.grpc.server.grpcserver.accessory.AccessoryServiceGrpc.AccessoryServiceImplBase;
import com.example.grpc.server.grpcserver.accessory.CreateRequest;
import com.example.grpc.server.grpcserver.accessory.CreateResponse;
import com.example.grpc.server.grpcserver.accessory.DeleteRequest;
import com.example.grpc.server.grpcserver.accessory.DeleteResponse;
import com.example.grpc.server.grpcserver.accessory.GetRequest;
import com.example.grpc.server.grpcserver.accessory.GetResponse;
import com.example.grpc.server.grpcserver.accessory.ProtoAccessory;
import com.example.grpc.server.grpcserver.updating.UpdateRequest;
import com.example.grpc.server.grpcserver.updating.UpdatingBalanceServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AccessoryServiceImpl extends AccessoryServiceImplBase{
	private final AccessoriesService accessoriesService;
	
	@Autowired 
    public AccessoryServiceImpl(AccessoriesService accessoriesService) {
      this.accessoriesService = accessoriesService;
    }
	
    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
    	List<Accessory> accessories = accessoriesService.getAccessories();
    	    	
    	List<ProtoAccessory> protoAccessories = new ArrayList<>();
    	for(Accessory accessory: accessories) {
    		ProtoAccessory protoAccessory = ProtoAccessory.newBuilder()
    				.setType(accessory.getType())
    				.setColor(accessory.getColor())
    				.setPrice(accessory.getPrice())
    				.build();
    		protoAccessories.add(protoAccessory);
    		
    	}
    	GetResponse response = GetResponse.newBuilder().addAllAccessories(protoAccessories).build();
    	    	
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void create(CreateRequest request, StreamObserver<CreateResponse> responseObserver) {
    	String type = request.getAccessory().getType();
    	String color = request.getAccessory().getColor();
    	int price = request.getAccessory().getPrice();
    	Accessory accessory = accessoriesService
    			.takeInStore(Type.valueOf(type), Color.valueOf(color), price);
    	
        CreateResponse response = CreateResponse.newBuilder()
                .setId(accessory.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
    	String accessoryId = request.getAccessoryId();
    	String cashRegisterId = request.getCashRegisterId();
    	String type = accessoriesService.getAccessoryById(accessoryId).getType();
    	int accessoryPrice = accessoriesService.getAccessoryPrice(accessoryId);
    	accessoriesService.sellAccessoryFromStore(accessoryId);
    	    	
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9097)
                .usePlaintext()
                .build();
        UpdatingBalanceServiceGrpc.UpdatingBalanceServiceBlockingStub stub = 
        		UpdatingBalanceServiceGrpc.newBlockingStub(channel);
        stub.update(UpdateRequest.newBuilder()
                .setCashRegisterId(cashRegisterId)
                .setAddedAmount(accessoryPrice)
                .build());
        channel.shutdown();
            	
        DeleteResponse response = DeleteResponse.newBuilder()
                .setReport("Accessory " + type + " was DELETED")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
