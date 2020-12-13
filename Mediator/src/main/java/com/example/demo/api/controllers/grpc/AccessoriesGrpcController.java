package com.example.demo.api.controllers.grpc;

import com.example.grpc.server.grpcserver.accessory.AccessoryServiceGrpc;
import com.example.grpc.server.grpcserver.accessory.AccessoryServiceGrpc.AccessoryServiceImplBase;
import com.example.grpc.server.grpcserver.accessory.CreateRequest;
import com.example.grpc.server.grpcserver.accessory.CreateResponse;
import com.example.grpc.server.grpcserver.accessory.DeleteRequest;
import com.example.grpc.server.grpcserver.accessory.DeleteResponse;
import com.example.grpc.server.grpcserver.accessory.GetRequest;
import com.example.grpc.server.grpcserver.accessory.GetResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class AccessoriesGrpcController extends AccessoryServiceImplBase {
	@Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9098)
                .usePlaintext()
                .build();
        AccessoryServiceGrpc.AccessoryServiceBlockingStub stub = AccessoryServiceGrpc.newBlockingStub(channel);
        GetResponse response = stub.get(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void create(CreateRequest request, StreamObserver<CreateResponse> responseObserver) {
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9098)
                .usePlaintext()
                .build();
    	AccessoryServiceGrpc.AccessoryServiceBlockingStub stub = AccessoryServiceGrpc.newBlockingStub(channel);
        CreateResponse response = stub.create(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9098)
                .usePlaintext()
                .build();
    	AccessoryServiceGrpc.AccessoryServiceBlockingStub stub = AccessoryServiceGrpc.newBlockingStub(channel);
        DeleteResponse response = stub.delete(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}