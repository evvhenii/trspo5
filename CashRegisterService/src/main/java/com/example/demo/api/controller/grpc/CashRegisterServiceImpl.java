package com.example.demo.api.controller.grpc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.CashRegisterService;
import com.example.demo.service.model.CashRegister;
import com.example.grpc.server.grpcserver.cashregister.CashRegisterServiceGrpc.CashRegisterServiceImplBase;
import com.example.grpc.server.grpcserver.cashregister.CreateRequest;
import com.example.grpc.server.grpcserver.cashregister.CreateResponse;
import com.example.grpc.server.grpcserver.cashregister.DeleteRequest;
import com.example.grpc.server.grpcserver.cashregister.DeleteResponse;
import com.example.grpc.server.grpcserver.cashregister.GetRequest;
import com.example.grpc.server.grpcserver.cashregister.GetResponse;
import com.example.grpc.server.grpcserver.cashregister.ProtoCashRegister;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CashRegisterServiceImpl extends CashRegisterServiceImplBase{
	private final CashRegisterService cashRegisterService;
	
	@Autowired 
    public CashRegisterServiceImpl(CashRegisterService cashRegisterService) {
      this.cashRegisterService = cashRegisterService;
    }
	
    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
    	List<CashRegister> cashRegisters = cashRegisterService.getCashRegisters();
    	    	
    	List<ProtoCashRegister> protoCashRegisters = new ArrayList<>();
    	for(CashRegister cashRegister: cashRegisters) {
    		ProtoCashRegister protoDog = ProtoCashRegister.newBuilder()
    				.setName(cashRegister.getName())
    				.setAddedAmount(cashRegister.getAmountOfCash())
    				.build();
    		protoCashRegisters.add(protoDog);
    	}
    	GetResponse response = GetResponse.newBuilder().addAllCashregisters(protoCashRegisters).build();
    	    	
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void create(CreateRequest request, StreamObserver<CreateResponse> responseObserver) {
    	String name = request.getCashRegister().getName();
    	int amount = request.getCashRegister().getAddedAmount();
    	CashRegister cashRegister = cashRegisterService.createCashRegister(name, amount);
    	
        CreateResponse response = CreateResponse.newBuilder()
                .setId(cashRegister.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
    	String id = request.getCashRegisterId();
    	String name = cashRegisterService.getCashRegisterById(id).getName();
    	cashRegisterService.deleteCashRegisterById(id);
    	
        DeleteResponse response = DeleteResponse.newBuilder()
                .setReport("Cash register " + name + " was DELETED")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
