
public abstract class Producer {

	private ValueReceiver receiver;
	private String name;
	private Thread thread;
	
	Producer(String name, ValueReceiver receiver){
		this.receiver = receiver;
		this.name = name;
	}
	
	
	public void start(float period) {
		System.out.println("Starting thread");
		this.getThread().start();
	}
	
	public abstract void generateValue();
	
	public void stop() {
		this.getThread().stop();
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public ValueReceiver getReceiver() {
		return this.receiver;
	}


	public Thread getThread() {
		return thread;
	}


	public void setThread(Runnable run) {
		this.thread = new Thread(run);
	}

}
