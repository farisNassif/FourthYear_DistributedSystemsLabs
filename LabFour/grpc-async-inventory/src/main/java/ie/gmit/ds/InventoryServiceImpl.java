package ie.gmit.ds;

import java.util.ArrayList;
import java.util.logging.Logger;

public class InventoryServiceImpl extends InventoryServiceGrpc.InventoryServiceImplBase {
	  private ArrayList<Item> itemsList;
	    private static final Logger logger =
	            Logger.getLogger(InventoryServiceImpl.class.getName());

	    public InventoryServiceImpl() {
	        itemsList = new ArrayList<>();
	        createDummyItems();
	    }

	    @Override
	    public void addItem(Item item,
	                        StreamObserver<BoolValue> responseObserver) {
	        try {
	            itemsList.add(item);
	            logger.info("Added new item: " + item);
	            responseObserver.onNext(BoolValue.newBuilder().setValue(true).build());
	        } catch (RuntimeException ex) {
	            responseObserver.onNext(BoolValue.newBuilder().setValue(false).build());
	        }
	        responseObserver.onCompleted();
	    }

	    @Override
	    public void getItems(Empty request,
	                         StreamObserver<Items> responseObserver) {
	        Items.Builder items = Items.newBuilder();
	        for (Item item : itemsList) {
	            items.addItems(item);
	        }
	        responseObserver.onNext(items.build());
	        responseObserver.onCompleted();
	    }
}
