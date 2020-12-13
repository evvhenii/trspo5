package com.example.grpc.server.grpcserver.updating;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: UpdatingBalance.proto")
public final class UpdatingBalanceServiceGrpc {

  private UpdatingBalanceServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.server.grpcserver.updating.UpdatingBalanceService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.grpc.server.grpcserver.updating.UpdateRequest,
      com.example.grpc.server.grpcserver.updating.UpdateResponse> METHOD_UPDATE =
      io.grpc.MethodDescriptor.<com.example.grpc.server.grpcserver.updating.UpdateRequest, com.example.grpc.server.grpcserver.updating.UpdateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.example.grpc.server.grpcserver.updating.UpdatingBalanceService", "update"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.grpc.server.grpcserver.updating.UpdateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.grpc.server.grpcserver.updating.UpdateResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UpdatingBalanceServiceStub newStub(io.grpc.Channel channel) {
    return new UpdatingBalanceServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UpdatingBalanceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UpdatingBalanceServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UpdatingBalanceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UpdatingBalanceServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UpdatingBalanceServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void update(com.example.grpc.server.grpcserver.updating.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.updating.UpdateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.server.grpcserver.updating.UpdateRequest,
                com.example.grpc.server.grpcserver.updating.UpdateResponse>(
                  this, METHODID_UPDATE)))
          .build();
    }
  }

  /**
   */
  public static final class UpdatingBalanceServiceStub extends io.grpc.stub.AbstractStub<UpdatingBalanceServiceStub> {
    private UpdatingBalanceServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UpdatingBalanceServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdatingBalanceServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UpdatingBalanceServiceStub(channel, callOptions);
    }

    /**
     */
    public void update(com.example.grpc.server.grpcserver.updating.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.updating.UpdateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UpdatingBalanceServiceBlockingStub extends io.grpc.stub.AbstractStub<UpdatingBalanceServiceBlockingStub> {
    private UpdatingBalanceServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UpdatingBalanceServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdatingBalanceServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UpdatingBalanceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.server.grpcserver.updating.UpdateResponse update(com.example.grpc.server.grpcserver.updating.UpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UpdatingBalanceServiceFutureStub extends io.grpc.stub.AbstractStub<UpdatingBalanceServiceFutureStub> {
    private UpdatingBalanceServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UpdatingBalanceServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UpdatingBalanceServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UpdatingBalanceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.server.grpcserver.updating.UpdateResponse> update(
        com.example.grpc.server.grpcserver.updating.UpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UpdatingBalanceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UpdatingBalanceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_UPDATE:
          serviceImpl.update((com.example.grpc.server.grpcserver.updating.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.updating.UpdateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class UpdatingBalanceServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.server.grpcserver.updating.UpdatingBalance.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UpdatingBalanceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UpdatingBalanceServiceDescriptorSupplier())
              .addMethod(METHOD_UPDATE)
              .build();
        }
      }
    }
    return result;
  }
}
