package com.example.demo.api.controller.grpc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.CashierService;
import com.example.demo.service.model.Cashier;
import com.example.grpc.server.grpcserver.cashier.CashierServiceGrpc.CashierServiceImplBase;
import com.example.grpc.server.grpcserver.cashier.CreateRequest;
import com.example.grpc.server.grpcserver.cashier.CreateResponse;
import com.example.grpc.server.grpcserver.cashier.DeleteRequest;
import com.example.grpc.server.grpcserver.cashier.DeleteResponse;
import com.example.grpc.server.grpcserver.cashier.GetRequest;
import com.example.grpc.server.grpcserver.cashier.GetResponse;
import com.example.grpc.server.grpcserver.cashier.ProtoCashier;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CashierServiceImpl extends CashierServiceImplBase {
	private final CashierService cashierService;
	
	@Autowired 
    public CashierServiceImpl(CashierService cashierService) {
      this.cashierService = cashierService;
    }
	
    @Override
    public void get(GetRequest request, StreamObserver<GetResponse> responseObserver) {
    	List<Cashier> cashiers = cashierService.getCashiers();
    	    	
    	List<ProtoCashier> protoCashiers = new ArrayList<>();
    	for(Cashier cashier: cashiers) {
    		ProtoCashier protoDog = ProtoCashier.newBuilder()
    				.setName(cashier.getName())
    				.build();
    		protoCashiers.add(protoDog);
    		
    	}
    	GetResponse response = GetResponse.newBuilder().addAllCashiers(protoCashiers).build();
    	    	
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void create(CreateRequest request, StreamObserver<CreateResponse> responseObserver) {
    	String name = request.getCashier().getName();
    	Cashier cashier = cashierService.createCashier(name);
    	
        CreateResponse response = CreateResponse.newBuilder()
                .setId(cashier.getId())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    @Override
    public void delete(DeleteRequest request, StreamObserver<DeleteResponse> responseObserver) {
    	String id = request.getId();
    	String name = cashierService.getCashierById(id).getName();
    	cashierService.deleteCashierById(id);
    	
        DeleteResponse response = DeleteResponse.newBuilder()
                .setReport(name + " was DELETED")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
