import com.google.gson.annotations.SerializedName;
/*
 * ==== Parameter ====
 * Class to store details of within the parameter arrays from JSON file. 
 * 
 */
public class Parameter {
	/* Variables for JSON data */
	@SerializedName("Key")
	private String key;
	@SerializedName("Value")
	private String value;
	/* Empty constructor */
	public Parameter() {}
	/* Getters */
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	/* Setters */
	public void setKey(String key) {
		this.key = key;
	}
	public void setValue(String value) {
		this.value = value;
	}
}