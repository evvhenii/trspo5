// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Accessory.proto

package com.example.grpc.server.grpcserver.accessory;

public final class Accessory {
  private Accessory() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_server_grpcserver_accessory_ProtoAccessory_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_server_grpcserver_accessory_ProtoAccessory_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_server_grpcserver_accessory_DeleteRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_server_grpcserver_accessory_DeleteRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_server_grpcserver_accessory_DeleteResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_server_grpcserver_accessory_DeleteResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_server_grpcserver_accessory_GetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_server_grpcserver_accessory_GetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_server_grpcserver_accessory_GetResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_server_grpcserver_accessory_GetResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_server_grpcserver_accessory_CreateRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_server_grpcserver_accessory_CreateRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_example_grpc_server_grpcserver_accessory_CreateResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_example_grpc_server_grpcserver_accessory_CreateResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017Accessory.proto\022,com.example.grpc.serv" +
      "er.grpcserver.accessory\"<\n\016ProtoAccessor" +
      "y\022\014\n\004type\030\001 \001(\t\022\r\n\005color\030\002 \001(\t\022\r\n\005price\030" +
      "\003 \001(\005\"?\n\rDeleteRequest\022\024\n\014accessory_id\030\001" +
      " \001(\t\022\030\n\020cash_register_id\030\002 \001(\t\" \n\016Delete" +
      "Response\022\016\n\006report\030\001 \001(\t\"\014\n\nGetRequest\"`" +
      "\n\013GetResponse\022Q\n\013accessories\030\001 \003(\0132<.com" +
      ".example.grpc.server.grpcserver.accessor" +
      "y.ProtoAccessory\"`\n\rCreateRequest\022O\n\tacc" +
      "essory\030\001 \001(\0132<.com.example.grpc.server.g",
      "rpcserver.accessory.ProtoAccessory\"\034\n\016Cr" +
      "eateResponse\022\n\n\002id\030\001 \001(\t2\232\003\n\020AccessorySe" +
      "rvice\022z\n\003get\0228.com.example.grpc.server.g" +
      "rpcserver.accessory.GetRequest\0329.com.exa" +
      "mple.grpc.server.grpcserver.accessory.Ge" +
      "tResponse\022\203\001\n\006delete\022;.com.example.grpc." +
      "server.grpcserver.accessory.DeleteReques" +
      "t\032<.com.example.grpc.server.grpcserver.a" +
      "ccessory.DeleteResponse\022\203\001\n\006create\022;.com" +
      ".example.grpc.server.grpcserver.accessor",
      "y.CreateRequest\032<.com.example.grpc.serve" +
      "r.grpcserver.accessory.CreateResponseB\002P" +
      "\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_example_grpc_server_grpcserver_accessory_ProtoAccessory_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_example_grpc_server_grpcserver_accessory_ProtoAccessory_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_server_grpcserver_accessory_ProtoAccessory_descriptor,
        new java.lang.String[] { "Type", "Color", "Price", });
    internal_static_com_example_grpc_server_grpcserver_accessory_DeleteRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_example_grpc_server_grpcserver_accessory_DeleteRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_server_grpcserver_accessory_DeleteRequest_descriptor,
        new java.lang.String[] { "AccessoryId", "CashRegisterId", });
    internal_static_com_example_grpc_server_grpcserver_accessory_DeleteResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_example_grpc_server_grpcserver_accessory_DeleteResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_server_grpcserver_accessory_DeleteResponse_descriptor,
        new java.lang.String[] { "Report", });
    internal_static_com_example_grpc_server_grpcserver_accessory_GetRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_example_grpc_server_grpcserver_accessory_GetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_server_grpcserver_accessory_GetRequest_descriptor,
        new java.lang.String[] { });
    internal_static_com_example_grpc_server_grpcserver_accessory_GetResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_example_grpc_server_grpcserver_accessory_GetResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_server_grpcserver_accessory_GetResponse_descriptor,
        new java.lang.String[] { "Accessories", });
    internal_static_com_example_grpc_server_grpcserver_accessory_CreateRequest_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_example_grpc_server_grpcserver_accessory_CreateRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_server_grpcserver_accessory_CreateRequest_descriptor,
        new java.lang.String[] { "Accessory", });
    internal_static_com_example_grpc_server_grpcserver_accessory_CreateResponse_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_com_example_grpc_server_grpcserver_accessory_CreateResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_example_grpc_server_grpcserver_accessory_CreateResponse_descriptor,
        new java.lang.String[] { "Id", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
