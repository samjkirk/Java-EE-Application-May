package constants;

public class Constants {
	public static final String UNIT_NAME = "primary";
	
	public static final String ACCOUNT_ID = "ACCOUNT_ID";
	public static final String TRANSACTION_ID = "TRANSACTION_ID";
	public static final String TRANSACTION_NAME = "TRANSACTION_NAME";
	
	public static final String FIRST_NAME = "First_Name";
	public static final String LAST_NAME = "Last_Name";
	public static final String ID = "id";
	public static final String ACCOUNT_NUMBER = "Acc_Number";
	public static final String ACCOUNT = "account";
	
	public static final String QUERY1 = "SELECT a FROM Account a";
	public static final String BANNED_ACCOUNT_MESSAGE = "{\"message\": \"this account is blocked\"}";
	public static final String ACCOUNT_ADDED = "{\"message\": \"account has been added\"}";
	public static final String ACCOUNT_DELETED = "{\"message\": \"account deleted\"}";
	public static final String ACCOUNT_UPDATED = "{\"message\": \"account updated\"}";
	
	public static final String ACCOUNT_PATH = "/account";
	public static final String JSON_PATH = "/json";
	public static final String JSON_PATH_WITH_ID = "/json/{id}";
	public static final String PRODUCES = "application/json";
	public static final String REST = "rest";
}
