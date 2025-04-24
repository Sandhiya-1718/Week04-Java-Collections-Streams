class FakeConnection{
	public void connect()
	{
		System.out.println("Connection opened.");
	}
	public void process() throws Exception
	{
		System.out.println("Processsing data...");
		throw new Exception("Something went wrong during processing.");
	}
	public void disconnect()
	{
		System.out.println("Connection closed.");
	}
}
public class ConnectionManager {
	public static void main(String[] args) {
		FakeConnection connection=new FakeConnection();
		try
		{
			connection.connect();
			connection.process();
		}
		catch(Exception e)
		{
			System.out.println("Exception caught:"+e.getMessage());
		}
		finally
		{
			connection.disconnect();
		}
	}
}
