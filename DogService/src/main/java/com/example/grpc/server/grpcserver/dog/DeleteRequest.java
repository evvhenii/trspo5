// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Dog.proto

package com.example.grpc.server.grpcserver.dog;

/**
 * Protobuf type {@code com.example.grpc.server.grpcserver.dog.DeleteRequest}
 */
public  final class DeleteRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.example.grpc.server.grpcserver.dog.DeleteRequest)
    DeleteRequestOrBuilder {
  // Use DeleteRequest.newBuilder() to construct.
  private DeleteRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DeleteRequest() {
    dogId_ = "";
    cashRegisterId_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private DeleteRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            dogId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            cashRegisterId_ = s;
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.example.grpc.server.grpcserver.dog.Dog.internal_static_com_example_grpc_server_grpcserver_dog_DeleteRequest_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.example.grpc.server.grpcserver.dog.Dog.internal_static_com_example_grpc_server_grpcserver_dog_DeleteRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.example.grpc.server.grpcserver.dog.DeleteRequest.class, com.example.grpc.server.grpcserver.dog.DeleteRequest.Builder.class);
  }

  public static final int DOG_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object dogId_;
  /**
   * <code>string dog_id = 1;</code>
   */
  public java.lang.String getDogId() {
    java.lang.Object ref = dogId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dogId_ = s;
      return s;
    }
  }
  /**
   * <code>string dog_id = 1;</code>
   */
  public com.google.protobuf.ByteString
      getDogIdBytes() {
    java.lang.Object ref = dogId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dogId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int CASH_REGISTER_ID_FIELD_NUMBER = 2;
  private volatile java.lang.Object cashRegisterId_;
  /**
   * <code>string cash_register_id = 2;</code>
   */
  public java.lang.String getCashRegisterId() {
    java.lang.Object ref = cashRegisterId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      cashRegisterId_ = s;
      return s;
    }
  }
  /**
   * <code>string cash_register_id = 2;</code>
   */
  public com.google.protobuf.ByteString
      getCashRegisterIdBytes() {
    java.lang.Object ref = cashRegisterId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      cashRegisterId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getDogIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, dogId_);
    }
    if (!getCashRegisterIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, cashRegisterId_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getDogIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, dogId_);
    }
    if (!getCashRegisterIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, cashRegisterId_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.example.grpc.server.grpcserver.dog.DeleteRequest)) {
      return super.equals(obj);
    }
    com.example.grpc.server.grpcserver.dog.DeleteRequest other = (com.example.grpc.server.grpcserver.dog.DeleteRequest) obj;

    boolean result = true;
    result = result && getDogId()
        .equals(other.getDogId());
    result = result && getCashRegisterId()
        .equals(other.getCashRegisterId());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + DOG_ID_FIELD_NUMBER;
    hash = (53 * hash) + getDogId().hashCode();
    hash = (37 * hash) + CASH_REGISTER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getCashRegisterId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.example.grpc.server.grpcserver.dog.DeleteRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.example.grpc.server.grpcserver.dog.DeleteRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.example.grpc.server.grpcserver.dog.DeleteRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.example.grpc.server.grpcserver.dog.DeleteRequest)
      com.example.grpc.server.grpcserver.dog.DeleteRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.example.grpc.server.grpcserver.dog.Dog.internal_static_com_example_grpc_server_grpcserver_dog_DeleteRequest_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.example.grpc.server.grpcserver.dog.Dog.internal_static_com_example_grpc_server_grpcserver_dog_DeleteRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.example.grpc.server.grpcserver.dog.DeleteRequest.class, com.example.grpc.server.grpcserver.dog.DeleteRequest.Builder.class);
    }

    // Construct using com.example.grpc.server.grpcserver.dog.DeleteRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      dogId_ = "";

      cashRegisterId_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.example.grpc.server.grpcserver.dog.Dog.internal_static_com_example_grpc_server_grpcserver_dog_DeleteRequest_descriptor;
    }

    public com.example.grpc.server.grpcserver.dog.DeleteRequest getDefaultInstanceForType() {
      return com.example.grpc.server.grpcserver.dog.DeleteRequest.getDefaultInstance();
    }

    public com.example.grpc.server.grpcserver.dog.DeleteRequest build() {
      com.example.grpc.server.grpcserver.dog.DeleteRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.example.grpc.server.grpcserver.dog.DeleteRequest buildPartial() {
      com.example.grpc.server.grpcserver.dog.DeleteRequest result = new com.example.grpc.server.grpcserver.dog.DeleteRequest(this);
      result.dogId_ = dogId_;
      result.cashRegisterId_ = cashRegisterId_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.example.grpc.server.grpcserver.dog.DeleteRequest) {
        return mergeFrom((com.example.grpc.server.grpcserver.dog.DeleteRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.example.grpc.server.grpcserver.dog.DeleteRequest other) {
      if (other == com.example.grpc.server.grpcserver.dog.DeleteRequest.getDefaultInstance()) return this;
      if (!other.getDogId().isEmpty()) {
        dogId_ = other.dogId_;
        onChanged();
      }
      if (!other.getCashRegisterId().isEmpty()) {
        cashRegisterId_ = other.cashRegisterId_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.example.grpc.server.grpcserver.dog.DeleteRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.example.grpc.server.grpcserver.dog.DeleteRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object dogId_ = "";
    /**
     * <code>string dog_id = 1;</code>
     */
    public java.lang.String getDogId() {
      java.lang.Object ref = dogId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dogId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dog_id = 1;</code>
     */
    public com.google.protobuf.ByteString
        getDogIdBytes() {
      java.lang.Object ref = dogId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dogId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dog_id = 1;</code>
     */
    public Builder setDogId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dogId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dog_id = 1;</code>
     */
    public Builder clearDogId() {
      
      dogId_ = getDefaultInstance().getDogId();
      onChanged();
      return this;
    }
    /**
     * <code>string dog_id = 1;</code>
     */
    public Builder setDogIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dogId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object cashRegisterId_ = "";
    /**
     * <code>string cash_register_id = 2;</code>
     */
    public java.lang.String getCashRegisterId() {
      java.lang.Object ref = cashRegisterId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        cashRegisterId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string cash_register_id = 2;</code>
     */
    public com.google.protobuf.ByteString
        getCashRegisterIdBytes() {
      java.lang.Object ref = cashRegisterId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        cashRegisterId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string cash_register_id = 2;</code>
     */
    public Builder setCashRegisterId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      cashRegisterId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string cash_register_id = 2;</code>
     */
    public Builder clearCashRegisterId() {
      
      cashRegisterId_ = getDefaultInstance().getCashRegisterId();
      onChanged();
      return this;
    }
    /**
     * <code>string cash_register_id = 2;</code>
     */
    public Builder setCashRegisterIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      cashRegisterId_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.example.grpc.server.grpcserver.dog.DeleteRequest)
  }

  // @@protoc_insertion_point(class_scope:com.example.grpc.server.grpcserver.dog.DeleteRequest)
  private static final com.example.grpc.server.grpcserver.dog.DeleteRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.example.grpc.server.grpcserver.dog.DeleteRequest();
  }

  public static com.example.grpc.server.grpcserver.dog.DeleteRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DeleteRequest>
      PARSER = new com.google.protobuf.AbstractParser<DeleteRequest>() {
    public DeleteRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new DeleteRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DeleteRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DeleteRequest> getParserForType() {
    return PARSER;
  }

  public com.example.grpc.server.grpcserver.dog.DeleteRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
