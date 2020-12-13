package com.example.grpc.server.grpcserver.accessory;

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
    comments = "Source: Accessory.proto")
public final class AccessoryServiceGrpc {

  private AccessoryServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.server.grpcserver.accessory.AccessoryService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.grpc.server.grpcserver.accessory.GetRequest,
      com.example.grpc.server.grpcserver.accessory.GetResponse> METHOD_GET =
      io.grpc.MethodDescriptor.<com.example.grpc.server.grpcserver.accessory.GetRequest, com.example.grpc.server.grpcserver.accessory.GetResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.example.grpc.server.grpcserver.accessory.AccessoryService", "get"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.grpc.server.grpcserver.accessory.GetRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.grpc.server.grpcserver.accessory.GetResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.grpc.server.grpcserver.accessory.DeleteRequest,
      com.example.grpc.server.grpcserver.accessory.DeleteResponse> METHOD_DELETE =
      io.grpc.MethodDescriptor.<com.example.grpc.server.grpcserver.accessory.DeleteRequest, com.example.grpc.server.grpcserver.accessory.DeleteResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.example.grpc.server.grpcserver.accessory.AccessoryService", "delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.grpc.server.grpcserver.accessory.DeleteRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.grpc.server.grpcserver.accessory.DeleteResponse.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.grpc.server.grpcserver.accessory.CreateRequest,
      com.example.grpc.server.grpcserver.accessory.CreateResponse> METHOD_CREATE =
      io.grpc.MethodDescriptor.<com.example.grpc.server.grpcserver.accessory.CreateRequest, com.example.grpc.server.grpcserver.accessory.CreateResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "com.example.grpc.server.grpcserver.accessory.AccessoryService", "create"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.grpc.server.grpcserver.accessory.CreateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.grpc.server.grpcserver.accessory.CreateResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AccessoryServiceStub newStub(io.grpc.Channel channel) {
    return new AccessoryServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AccessoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new AccessoryServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AccessoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new AccessoryServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class AccessoryServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void get(com.example.grpc.server.grpcserver.accessory.GetRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.accessory.GetResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET, responseObserver);
    }

    /**
     */
    public void delete(com.example.grpc.server.grpcserver.accessory.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.accessory.DeleteResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    /**
     */
    public void create(com.example.grpc.server.grpcserver.accessory.CreateRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.accessory.CreateResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET,
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.server.grpcserver.accessory.GetRequest,
                com.example.grpc.server.grpcserver.accessory.GetResponse>(
                  this, METHODID_GET)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.server.grpcserver.accessory.DeleteRequest,
                com.example.grpc.server.grpcserver.accessory.DeleteResponse>(
                  this, METHODID_DELETE)))
          .addMethod(
            METHOD_CREATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.server.grpcserver.accessory.CreateRequest,
                com.example.grpc.server.grpcserver.accessory.CreateResponse>(
                  this, METHODID_CREATE)))
          .build();
    }
  }

  /**
   */
  public static final class AccessoryServiceStub extends io.grpc.stub.AbstractStub<AccessoryServiceStub> {
    private AccessoryServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccessoryServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessoryServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccessoryServiceStub(channel, callOptions);
    }

    /**
     */
    public void get(com.example.grpc.server.grpcserver.accessory.GetRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.accessory.GetResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.example.grpc.server.grpcserver.accessory.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.accessory.DeleteResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void create(com.example.grpc.server.grpcserver.accessory.CreateRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.accessory.CreateResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AccessoryServiceBlockingStub extends io.grpc.stub.AbstractStub<AccessoryServiceBlockingStub> {
    private AccessoryServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccessoryServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessoryServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccessoryServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.server.grpcserver.accessory.GetResponse get(com.example.grpc.server.grpcserver.accessory.GetRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET, getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.server.grpcserver.accessory.DeleteResponse delete(com.example.grpc.server.grpcserver.accessory.DeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.server.grpcserver.accessory.CreateResponse create(com.example.grpc.server.grpcserver.accessory.CreateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AccessoryServiceFutureStub extends io.grpc.stub.AbstractStub<AccessoryServiceFutureStub> {
    private AccessoryServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private AccessoryServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AccessoryServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new AccessoryServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.server.grpcserver.accessory.GetResponse> get(
        com.example.grpc.server.grpcserver.accessory.GetRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.server.grpcserver.accessory.DeleteResponse> delete(
        com.example.grpc.server.grpcserver.accessory.DeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.server.grpcserver.accessory.CreateResponse> create(
        com.example.grpc.server.grpcserver.accessory.CreateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET = 0;
  private static final int METHODID_DELETE = 1;
  private static final int METHODID_CREATE = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AccessoryServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AccessoryServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET:
          serviceImpl.get((com.example.grpc.server.grpcserver.accessory.GetRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.accessory.GetResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.example.grpc.server.grpcserver.accessory.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.accessory.DeleteResponse>) responseObserver);
          break;
        case METHODID_CREATE:
          serviceImpl.create((com.example.grpc.server.grpcserver.accessory.CreateRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.server.grpcserver.accessory.CreateResponse>) responseObserver);
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

  private static final class AccessoryServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.server.grpcserver.accessory.Accessory.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AccessoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AccessoryServiceDescriptorSupplier())
              .addMethod(METHOD_GET)
              .addMethod(METHOD_DELETE)
              .addMethod(METHOD_CREATE)
              .build();
        }
      }
    }
    return result;
  }
}
