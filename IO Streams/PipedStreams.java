import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.IOException;
class Writer implements Runnable{
	private PipedOutputStream pos;
	public Writer(PipedOutputStream pos)
	{
		this.pos=pos;
	}
	@Override
	public void run()
	{
		try
		{
			String message="Hello from the writer thread.!";
			pos.write(message.getBytes());
			pos.close();
		}
		catch(IOException e)
		{
			System.out.println("Writer Error");
		}
	}
}
class Reader implements Runnable
{
	private PipedInputStream pis;
	public Reader(PipedInputStream pis)
	{
		this.pis=pis;
	}
	@Override
	public void run() 
	{
		try
		{
			int data;
			System.out.print("Reader received:");
			while((data=pis.read())!=-1)
				System.out.print((char)data);
			pis.close();
		}
		catch(IOException e)
		{
			System.out.println("Reader Error:"+e);
		}
	}
}
public class PipedStreams {
	public static void main(String[] args) {
		try
		{
			PipedOutputStream pos=new PipedOutputStream();
			PipedInputStream pis=new PipedInputStream(pos);
			Runnable writerTask=new Writer(pos);
			Runnable readerTask=new Reader(pis);
			Thread writerThread=new Thread(writerTask);
			Thread readerThread=new Thread(readerTask);
			writerThread.start();
			readerThread.start();
			writerThread.join();
			readerThread.join();
		}
		catch(IOException | InterruptedException e)
		{
			System.out.println("Connection Error:"+e);
		}
	}
}
