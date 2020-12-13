package com.example.demo.api.controller.grpc;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.CashRegisterService;
import com.example.grpc.server.grpcserver.updating.UpdateRequest;
import com.example.grpc.server.grpcserver.updating.UpdateResponse;
import com.example.grpc.server.grpcserver.updating.UpdatingBalanceServiceGrpc.UpdatingBalanceServiceImplBase;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class DogCashRegisterServiceImpl extends UpdatingBalanceServiceImplBase {
	private final CashRegisterService cashRegisterService;
	
	@Autowired 
    public DogCashRegisterServiceImpl(CashRegisterService cashRegisterService) {
      this.cashRegisterService = cashRegisterService;
    }
	
	@Override
    public void update(UpdateRequest request, StreamObserver<UpdateResponse> responseObserver) {
    	String cashRegisterId = request.getCashRegisterId();
    	int price = request.getAddedAmount();
    	
    	cashRegisterService.addCash(cashRegisterId, price);
    	
    	UpdateResponse response = UpdateResponse.newBuilder().build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    	
    }
}
