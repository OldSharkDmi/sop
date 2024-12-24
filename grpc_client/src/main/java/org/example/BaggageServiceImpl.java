package org.example;
import com.example.grpc.BaggageServiceGrpc;
import com.example.grpc.BaggageDTO;
import com.example.grpc.BaggageRequest;
import com.example.grpc.BaggageResponse;
import com.example.grpc.BaggageStatus;
import io.grpc.stub.StreamObserver;

class BaggageServiceImpl extends BaggageServiceGrpc.BaggageServiceImplBase {

    @Override
    public void processBaggage(BaggageRequest request, StreamObserver<BaggageResponse> responseObserver) {
        BaggageDTO baggage = request.getBaggage();
        System.out.println("Received baggage: " + baggage);
        BaggageStatus status = baggage.getStatus();
        if (status == BaggageStatus.REGISTERED) {
            status = BaggageStatus.LOADED_IN_PLANE;
        } else if (status == BaggageStatus.LOADED_IN_PLANE) {
            status = BaggageStatus.IN_TRANSIT;
        } else if (status == BaggageStatus.IN_TRANSIT) {
            status = BaggageStatus.UNLOADED_FROM_PLANE;
        } else if (status == BaggageStatus.UNLOADED_FROM_PLANE) {
            status = Math.random() > 0.1 ? BaggageStatus.ISSUED : BaggageStatus.LOST;
        }
        System.out.println("Final status: " + status);
        BaggageResponse response = BaggageResponse.newBuilder()
                .setBaggage(baggage.toBuilder().setStatus(status).build())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}