
public class Consumer {

	private ValuePrinter printer;
	
	private  Producer[] producer;
	
	Consumer(int numberOfProducers){
		this.producer = new Producer[numberOfProducers];
		this.printer = new ValuePrinter();

		//init each producer
		for(int i=0; i<this.producer.length; i++) {
			var producer = new FibProducer(i+"", this.printer);
			 this.producer[i] = producer;
		}
	}
	
	public void run(float time) {
		
		//Starts a producer
		for(int i=0; i< this.producer.length; i++) {
			var producer = this.producer[i];
			producer.start(time);
//			producer.stop();
		}
		

		//Starts a producer
//		for(int i=0; i< this.producer.length; i++) {
//			var producer = this.producer[i];
//			producer.stop();
//		}
	}
}
