package com.example.demo.api.controllers.grpc;

import com.example.grpc.server.grpcserver.cashregister.CashRegisterServiceGrpc;
import com.example.grpc.server.grpcserver.cashregister.CashRegisterServiceGrpc.CashRegisterServiceImplBase;
import com.example.grpc.server.grpcserver.cashregister.CreateRequest;
import com.example.grpc.server.grpcserver.cashregister.CreateResponse;
import com.example.grpc.server.grpcserver.cashregister.DeleteRequest;
import com.example.grpc.server.grpcserver.cashregister.DeleteResponse;
import com.example.grpc.server.grpcserver.cashregister.GetRequest;
import com.example.grpc.server.grpcserver.cashregister.GetResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CashRegistersGrpcController extends CashRegisterServiceImplBase {
	@Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9097)
                .usePlaintext()
                .build();
        CashRegisterServiceGrpc.CashRegisterServiceBlockingStub stub = CashRegisterServiceGrpc.newBlockingStub(channel);
        GetResponse response = stub.get(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void create(CreateRequest request, StreamObserver<CreateResponse> responseObserver) {
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9097)
                .usePlaintext()
                .build();
        CashRegisterServiceGrpc.CashRegisterServiceBlockingStub stub = CashRegisterServiceGrpc.newBlockingStub(channel);
        CreateResponse response = stub.create(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
    	ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9097)
                .usePlaintext()
                .build();
        CashRegisterServiceGrpc.CashRegisterServiceBlockingStub stub = CashRegisterServiceGrpc.newBlockingStub(channel);
        DeleteResponse response = stub.delete(request);
        channel.shutdown();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
