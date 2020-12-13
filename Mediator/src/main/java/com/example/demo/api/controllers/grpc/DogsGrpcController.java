package com.example.demo.api.controllers.grpc;

import com.example.grpc.server.grpcserver.dog.CreateRequest;
import com.example.grpc.server.grpcserver.dog.CreateResponse;
import com.example.grpc.server.grpcserver.dog.DeleteRequest;
import com.example.grpc.server.grpcserver.dog.DeleteResponse;
import com.example.grpc.server.grpcserver.dog.DogServiceGrpc;
import com.example.grpc.server.grpcserver.dog.DogServiceGrpc.DogServiceImplBase;
import com.example.grpc.server.grpcserver.dog.GetRequest;
import com.example.grpc.server.grpcserver.dog.GetResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class DogsGrpcController extends DogServiceImplBase{
	@Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        DogServiceGrpc.DogServiceBlockingStub stub = DogServiceGrpc.newBlockingStub(channel);
        GetResponse response = stub.get(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void create(CreateRequest request, StreamObserver<CreateResponse> responseObserver) {
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        DogServiceGrpc.DogServiceBlockingStub stub = DogServiceGrpc.newBlockingStub(channel);
        CreateResponse response = stub.create(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        DogServiceGrpc.DogServiceBlockingStub stub = DogServiceGrpc.newBlockingStub(channel);
        DeleteResponse response = stub.delete(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
