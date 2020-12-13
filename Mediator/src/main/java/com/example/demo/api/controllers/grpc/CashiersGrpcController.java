package com.example.demo.api.controllers.grpc;

import com.example.grpc.server.grpcserver.cashier.CashierServiceGrpc;
import com.example.grpc.server.grpcserver.cashier.CashierServiceGrpc.CashierServiceImplBase;
import com.example.grpc.server.grpcserver.cashier.CreateRequest;
import com.example.grpc.server.grpcserver.cashier.CreateResponse;
import com.example.grpc.server.grpcserver.cashier.DeleteRequest;
import com.example.grpc.server.grpcserver.cashier.DeleteResponse;
import com.example.grpc.server.grpcserver.cashier.GetRequest;
import com.example.grpc.server.grpcserver.cashier.GetResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CashiersGrpcController extends CashierServiceImplBase {
	@Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9092)
                .usePlaintext()
                .build();
        CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);
        GetResponse response = stub.get(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void create(CreateRequest request, StreamObserver<CreateResponse> responseObserver) {
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9092)
                .usePlaintext()
                .build();
        CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);
        CreateResponse response = stub.create(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9092)
                .usePlaintext()
                .build();
        CashierServiceGrpc.CashierServiceBlockingStub stub = CashierServiceGrpc.newBlockingStub(channel);
        DeleteResponse response = stub.delete(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}