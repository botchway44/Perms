
public class ValuePrinter extends ValueReceiver {

	private int valueReceived;

	
	public void update(String producer, int value){
		System.out.println("Producer ::: "+producer + " Value ::: "+ value);
	}
	
	
	int getNumberOfValuesReceived() {
		return this.valueReceived;
	}
}
