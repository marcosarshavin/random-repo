package code.lunatech.dao.exception;

public class DataAccessException extends RuntimeException	{
	
	private static final long serialVersionUID = 4176218569099609556L;

	public DataAccessException()	{
		super();
	}
	
	public DataAccessException(String message)	{
		super(message);
	}
	
	public DataAccessException(Exception cause)	{
		super(cause);
	}
	
	public DataAccessException(String message, Exception cause)	{
		super(message, cause);
	}

}
