import java.util.List;

import com.google.gson.annotations.SerializedName;
/*
 * ==== Site ====
 * Class to store data from JSON file.
 * Contains all the attributes and accessory methods.
 * 
 */
public class Site {
	/* Variables to store JSON data */
	/* Use of @SerializedName as the attributes are capitalised in JSON file */
	@SerializedName("Name")
	private String name;
	@SerializedName("AlarmColor")
	private int alarmColor;
	@SerializedName("Id")
	private int id;
	@SerializedName("Parameters")
	private List<Parameter> parameters;
	@SerializedName("DatasourcesCount")
	private int datasourcesCount;
	@SerializedName("_alertIcon")
	private String alertIcon;
	@SerializedName("ElementCount")
	private int elementCount;
	@SerializedName("UniqueID")
	private String uniqueId;
	/* Empty constructor */
	public Site() {}
	/* Getters */
	public String getName() {
		return name;
	}
	public int getAlarmColor() {
		return alarmColor;
	}
	public int getId() {
		return id;
	}
	public List<Parameter> getParameters() {
		return parameters;
	}
	public int getDatasourcesCount() {
		return datasourcesCount;
	}
	public String getAlertIcon() {
		return alertIcon;
	}
	public int getElementCount() {
		return elementCount;
	}
	public String getUniqueID() {
		return uniqueId;
	}
	/* Setters */
	public void setName(String name) {
		this.name = name;
	}
	public void setAlarmColor(int alarmColor) {
		this.alarmColor = alarmColor;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
	}
	public void setDatasourcesCount(int datasourcesCount) {
		this.datasourcesCount = datasourcesCount;
	}
	public void setAlertIcon(String alertIcon) {
		this.alertIcon = alertIcon;
	}
	public void setElementCount(int elementCount) {
		this.elementCount = elementCount;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueId = uniqueID;
	}
}