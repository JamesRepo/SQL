/*
 * ==== SQL Creator ====
 * Class to create the SQL queries to be output.
 * 
 */
public class SQLCreator {
	/* Variables */
	private String tableName;
	private Site [] sites;
	private String createQueries;
	private String insertQueries;
	/**
	 * Constructor - take in table name from user and sites from file handler
	 * @param tableName
	 * @param sites
	 */
	public SQLCreator(String tableName, Site [] sites) {
		this.tableName = tableName;
		this.sites = sites;
		this.createQueries = "";
		this.insertQueries = "";
	}
	/**
	 * Calls create and insert methods. 
	 */
	public void createAndPopulate() {
		createTables();
		insertValues();
	}
	/**
	 * Gives us the SQL queries to create the tables we need.
	 * Private protection level as only called in this class.
	 */
	private void createTables() {
		// String Builder to make things clearer essentially, allowing for easier edit
		StringBuilder sb = new StringBuilder();
		// Gives formatting space
		sb.append("\n");
		// Creates the main table with the name given by user
		sb.append("CREATE TABLE " + tableName + " (\n"
				+ "Name VARCHAR(50), \n"
				+ "AlarmColor INT, \n"
				+ "Id INT, \n"
				+ "DatasourcesCount INT, \n"
				+ "AlertIcon VARCHAR(50), \n"
				+ "ElementCount INT, \n"
				+ "UniqueId VARCHAR(50), \n"
				+ "PRIMARY KEY (UniqueId)"
				+ ")");
		// More formatting space
		sb.append("\n\n");
		// Create parameter table needed to handle the parameter array in JSON file
		sb.append("CREATE TABLE Parameters (\n"
				+ "ParameterId INT, \n"
				+ "SiteId VARCHAR(50), \n"
				+ "ParameterKey VARCHAR(50), \n"
				+ "ParameterValue VARCHAR(50), \n"
				+ "PRIMARY KEY (ParameterID), \n"
				+ "FOREIGN KEY (SiteId) REFERENCES " + tableName + "(UniqueID)\n"
				+ ")");
		// Format
		sb.append("\n\n");
		// Assign to create queries variable
		createQueries = sb.toString();			
	}
	/**
	 * Gives us SQL statements to add data into tables.
	 * Private as only called in this class.
	 */
	private void insertValues() {
		StringBuilder sb = new StringBuilder();
		// Variable used to give parameter table a primary key. Incremented every time used. 
		int parameterCount = 1;
		for (Site site : sites) {
			// Query for main table.
			sb.append(String.format("INSERT INTO %s (Name, AlarmColor, Id, DatasourcesCount, AlertIcon, ElementCount, UniqueId) "
					+ "VALUES ('%s', %d, %d, %d, '%s', %d, '%s')", tableName, site.getName(), site.getAlarmColor(), site.getId(), site.getDatasourcesCount(), site.getAlertIcon(), site.getElementCount(), site.getUniqueID()));
			sb.append("\n");
			// Query for parameter table. Nested loop but saw no other way to do this
			for (int i = 0; i < site.getParameters().size(); i++) {
				sb.append(String.format("INSERT INTO Parameters (ParameterId, SiteId, ParameterKey, ParameterValue) "
						+ "VALUES (%d, '%s', '%s', '%s') \n", parameterCount++, site.getUniqueID(), site.getParameters().get(i).getKey(), site.getParameters().get(i).getValue()));
			}
			sb.append("\n\n");
		}
		// Assign to variable
		insertQueries = sb.toString();
	}
	/* Getters */
	public String getCreateQueries() {
		return createQueries;
	}
	public String getInsertQueries() {
		return insertQueries;
	}
}