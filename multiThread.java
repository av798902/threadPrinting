//Operating systems concept program

public class multiThread implements Runnable
{
	private String charToPrint;
	private static String [] names = new String[3];
	
	public synchronized void run()
	{	
		//These lines would not work. "name" was always initialized
		//to the string "main"
		//String name = Thread.currentThread().getName();
		//System.out.println(name);
		
		System.out.print(charToPrint);
		notifyAll();
		try
		{
		   Thread.sleep(500);                 
        } 
		catch(InterruptedException ex) 
		{
           Thread.currentThread().interrupt();
		} 
	}
		
	public multiThread(String str)
	{
		//The string being passed is what we want to print
		//for a particular thread
		this.charToPrint = str;
		
		//Alternative(?)
		//this.charToPrint = Thread.currentThread().getName();
	}
    public static void main(String [] args)
	{
		//Can alternatively manually assign a thread name
		//Thread printA = new Thread(new multiThread("a"),"a");
		//Thread printB = new Thread(new multiThread("b"),"b");
		//Thread printC = new Thread(new multiThread("c"),"c");
		
		Thread printA = new Thread(new multiThread("a"));
		Thread printB = new Thread(new multiThread("b"));
		Thread printC = new Thread(new multiThread("c"));
		
		names[0] = printA.getName();
		names[1] = printB.getName();
		names[2] = printC.getName();
		
		for(int i = 0; ; i++)
		{	
			printA.run();	
			printB.run();	
			printC.run();
		} 
	}
}//end multiThread
