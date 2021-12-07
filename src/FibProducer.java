import java.util.HashMap;

public class FibProducer extends Producer {
	
	private int fibCounter = 0;
	
	FibProducer(String name, ValueReceiver receiver) {
		super(name, receiver);
		
		setThread(new Thread() {
			public void run() {
				while(true) {
					try {
						generateValue();
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	@Override
	public void generateValue() {
		super.getReceiver().update(this.getName(), fibHelper(this.fibCounter++));
	}
	
	static HashMap<Integer, Integer>  fibPairs = new HashMap<>();
	private static int fibHelper(int number) {
		if( number <= 2) return 1;
		//check if fib already exist
		else if(fibPairs.containsKey(number)) {
			return fibPairs.get(number);
		}
		else {
			//Implement memiozation
			int result = (fibHelper(number - 1) + fibHelper(number - 2));
			fibPairs.put(number, result);
			return result;
		}
	}

}
