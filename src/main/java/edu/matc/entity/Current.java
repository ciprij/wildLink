package edu.matc.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Current.
 */
public class Current{

	@JsonProperty("feelslike_c")
	private Object feelslikeC;

	@JsonProperty("feelslike_f")
	private Object feelslikeF;

	@JsonProperty("wind_degree")
	private int windDegree;

	@JsonProperty("windchill_f")
	private Object windchillF;

	@JsonProperty("windchill_c")
	private Object windchillC;

	@JsonProperty("last_updated_epoch")
	private int lastUpdatedEpoch;

	@JsonProperty("temp_c")
	private Object tempC;

	@JsonProperty("temp_f")
	private Object tempF;

	@JsonProperty("cloud")
	private int cloud;

	@JsonProperty("wind_kph")
	private Object windKph;

	@JsonProperty("wind_mph")
	private Object windMph;

	@JsonProperty("humidity")
	private int humidity;

	@JsonProperty("dewpoint_f")
	private Object dewpointF;

	@JsonProperty("uv")
	private Object uv;

	@JsonProperty("last_updated")
	private String lastUpdated;

	@JsonProperty("heatindex_f")
	private Object heatindexF;

	@JsonProperty("dewpoint_c")
	private Object dewpointC;

	@JsonProperty("is_day")
	private int isDay;

	@JsonProperty("precip_in")
	private int precipIn;

	@JsonProperty("heatindex_c")
	private Object heatindexC;

	@JsonProperty("wind_dir")
	private String windDir;

	@JsonProperty("gust_mph")
	private Object gustMph;

	@JsonProperty("pressure_in")
	private Object pressureIn;

	@JsonProperty("gust_kph")
	private Object gustKph;

	@JsonProperty("precip_mm")
	private int precipMm;

	@JsonProperty("condition")
	private Condition condition;

	@JsonProperty("vis_km")
	private int visKm;

	@JsonProperty("pressure_mb")
	private int pressureMb;

	@JsonProperty("vis_miles")
	private int visMiles;

    /**
     * Set feelslike c.
     *
     * @param feelslikeC the feelslike c
     */
    public void setFeelslikeC(Object feelslikeC){
		this.feelslikeC = feelslikeC;
	}

    /**
     * Get feelslike c object.
     *
     * @return the object
     */
    public Object getFeelslikeC(){
		return feelslikeC;
	}

    /**
     * Set feelslike f.
     *
     * @param feelslikeF the feelslike f
     */
    public void setFeelslikeF(Object feelslikeF){
		this.feelslikeF = feelslikeF;
	}

    /**
     * Get feelslike f object.
     *
     * @return the object
     */
    public Object getFeelslikeF(){
		return feelslikeF;
	}

    /**
     * Set wind degree.
     *
     * @param windDegree the wind degree
     */
    public void setWindDegree(int windDegree){
		this.windDegree = windDegree;
	}

    /**
     * Get wind degree int.
     *
     * @return the int
     */
    public int getWindDegree(){
		return windDegree;
	}

    /**
     * Set windchill f.
     *
     * @param windchillF the windchill f
     */
    public void setWindchillF(Object windchillF){
		this.windchillF = windchillF;
	}

    /**
     * Get windchill f object.
     *
     * @return the object
     */
    public Object getWindchillF(){
		return windchillF;
	}

    /**
     * Set windchill c.
     *
     * @param windchillC the windchill c
     */
    public void setWindchillC(Object windchillC){
		this.windchillC = windchillC;
	}

    /**
     * Get windchill c object.
     *
     * @return the object
     */
    public Object getWindchillC(){
		return windchillC;
	}

    /**
     * Set last updated epoch.
     *
     * @param lastUpdatedEpoch the last updated epoch
     */
    public void setLastUpdatedEpoch(int lastUpdatedEpoch){
		this.lastUpdatedEpoch = lastUpdatedEpoch;
	}

    /**
     * Get last updated epoch int.
     *
     * @return the int
     */
    public int getLastUpdatedEpoch(){
		return lastUpdatedEpoch;
	}

    /**
     * Set temp c.
     *
     * @param tempC the temp c
     */
    public void setTempC(Object tempC){
		this.tempC = tempC;
	}

    /**
     * Get temp c object.
     *
     * @return the object
     */
    public Object getTempC(){
		return tempC;
	}

    /**
     * Set temp f.
     *
     * @param tempF the temp f
     */
    public void setTempF(Object tempF){
		this.tempF = tempF;
	}

    /**
     * Get temp f object.
     *
     * @return the object
     */
    public Object getTempF(){
		return tempF;
	}

    /**
     * Set cloud.
     *
     * @param cloud the cloud
     */
    public void setCloud(int cloud){
		this.cloud = cloud;
	}

    /**
     * Get cloud int.
     *
     * @return the int
     */
    public int getCloud(){
		return cloud;
	}

    /**
     * Set wind kph.
     *
     * @param windKph the wind kph
     */
    public void setWindKph(Object windKph){
		this.windKph = windKph;
	}

    /**
     * Get wind kph object.
     *
     * @return the object
     */
    public Object getWindKph(){
		return windKph;
	}

    /**
     * Set wind mph.
     *
     * @param windMph the wind mph
     */
    public void setWindMph(Object windMph){
		this.windMph = windMph;
	}

    /**
     * Get wind mph object.
     *
     * @return the object
     */
    public Object getWindMph(){
		return windMph;
	}

    /**
     * Set humidity.
     *
     * @param humidity the humidity
     */
    public void setHumidity(int humidity){
		this.humidity = humidity;
	}

    /**
     * Get humidity int.
     *
     * @return the int
     */
    public int getHumidity(){
		return humidity;
	}

    /**
     * Set dewpoint f.
     *
     * @param dewpointF the dewpoint f
     */
    public void setDewpointF(Object dewpointF){
		this.dewpointF = dewpointF;
	}

    /**
     * Get dewpoint f object.
     *
     * @return the object
     */
    public Object getDewpointF(){
		return dewpointF;
	}

    /**
     * Set uv.
     *
     * @param uv the uv
     */
    public void setUv(Object uv){
		this.uv = uv;
	}

    /**
     * Get uv object.
     *
     * @return the object
     */
    public Object getUv(){
		return uv;
	}

    /**
     * Set last updated.
     *
     * @param lastUpdated the last updated
     */
    public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

    /**
     * Get last updated string.
     *
     * @return the string
     */
    public String getLastUpdated(){
		return lastUpdated;
	}

    /**
     * Set heatindex f.
     *
     * @param heatindexF the heatindex f
     */
    public void setHeatindexF(Object heatindexF){
		this.heatindexF = heatindexF;
	}

    /**
     * Get heatindex f object.
     *
     * @return the object
     */
    public Object getHeatindexF(){
		return heatindexF;
	}

    /**
     * Set dewpoint c.
     *
     * @param dewpointC the dewpoint c
     */
    public void setDewpointC(Object dewpointC){
		this.dewpointC = dewpointC;
	}

    /**
     * Get dewpoint c object.
     *
     * @return the object
     */
    public Object getDewpointC(){
		return dewpointC;
	}

    /**
     * Set is day.
     *
     * @param isDay the is day
     */
    public void setIsDay(int isDay){
		this.isDay = isDay;
	}

    /**
     * Get is day int.
     *
     * @return the int
     */
    public int getIsDay(){
		return isDay;
	}

    /**
     * Set precip in.
     *
     * @param precipIn the precip in
     */
    public void setPrecipIn(int precipIn){
		this.precipIn = precipIn;
	}

    /**
     * Get precip in int.
     *
     * @return the int
     */
    public int getPrecipIn(){
		return precipIn;
	}

    /**
     * Set heatindex c.
     *
     * @param heatindexC the heatindex c
     */
    public void setHeatindexC(Object heatindexC){
		this.heatindexC = heatindexC;
	}

    /**
     * Get heatindex c object.
     *
     * @return the object
     */
    public Object getHeatindexC(){
		return heatindexC;
	}

    /**
     * Set wind dir.
     *
     * @param windDir the wind dir
     */
    public void setWindDir(String windDir){
		this.windDir = windDir;
	}

    /**
     * Get wind dir string.
     *
     * @return the string
     */
    public String getWindDir(){
		return windDir;
	}

    /**
     * Set gust mph.
     *
     * @param gustMph the gust mph
     */
    public void setGustMph(Object gustMph){
		this.gustMph = gustMph;
	}

    /**
     * Get gust mph object.
     *
     * @return the object
     */
    public Object getGustMph(){
		return gustMph;
	}

    /**
     * Set pressure in.
     *
     * @param pressureIn the pressure in
     */
    public void setPressureIn(Object pressureIn){
		this.pressureIn = pressureIn;
	}

    /**
     * Get pressure in object.
     *
     * @return the object
     */
    public Object getPressureIn(){
		return pressureIn;
	}

    /**
     * Set gust kph.
     *
     * @param gustKph the gust kph
     */
    public void setGustKph(Object gustKph){
		this.gustKph = gustKph;
	}

    /**
     * Get gust kph object.
     *
     * @return the object
     */
    public Object getGustKph(){
		return gustKph;
	}

    /**
     * Set precip mm.
     *
     * @param precipMm the precip mm
     */
    public void setPrecipMm(int precipMm){
		this.precipMm = precipMm;
	}

    /**
     * Get precip mm int.
     *
     * @return the int
     */
    public int getPrecipMm(){
		return precipMm;
	}

    /**
     * Set condition.
     *
     * @param condition the condition
     */
    public void setCondition(Condition condition){
		this.condition = condition;
	}

    /**
     * Get condition condition.
     *
     * @return the condition
     */
    public Condition getCondition(){
		return condition;
	}

    /**
     * Set vis km.
     *
     * @param visKm the vis km
     */
    public void setVisKm(int visKm){
		this.visKm = visKm;
	}

    /**
     * Get vis km int.
     *
     * @return the int
     */
    public int getVisKm(){
		return visKm;
	}

    /**
     * Set pressure mb.
     *
     * @param pressureMb the pressure mb
     */
    public void setPressureMb(int pressureMb){
		this.pressureMb = pressureMb;
	}

    /**
     * Get pressure mb int.
     *
     * @return the int
     */
    public int getPressureMb(){
		return pressureMb;
	}

    /**
     * Set vis miles.
     *
     * @param visMiles the vis miles
     */
    public void setVisMiles(int visMiles){
		this.visMiles = visMiles;
	}

    /**
     * Get vis miles int.
     *
     * @return the int
     */
    public int getVisMiles(){
		return visMiles;
	}

	@Override
	public String toString(){
		return
				"Current{" +
						"feelslike_c = '" + feelslikeC + '\'' +
						",feelslike_f = '" + feelslikeF + '\'' +
						",wind_degree = '" + windDegree + '\'' +
						",windchill_f = '" + windchillF + '\'' +
						",windchill_c = '" + windchillC + '\'' +
						",last_updated_epoch = '" + lastUpdatedEpoch + '\'' +
						",temp_c = '" + tempC + '\'' +
						",temp_f = '" + tempF + '\'' +
						",cloud = '" + cloud + '\'' +
						",wind_kph = '" + windKph + '\'' +
						",wind_mph = '" + windMph + '\'' +
						",humidity = '" + humidity + '\'' +
						",dewpoint_f = '" + dewpointF + '\'' +
						",uv = '" + uv + '\'' +
						",last_updated = '" + lastUpdated + '\'' +
						",heatindex_f = '" + heatindexF + '\'' +
						",dewpoint_c = '" + dewpointC + '\'' +
						",is_day = '" + isDay + '\'' +
						",precip_in = '" + precipIn + '\'' +
						",heatindex_c = '" + heatindexC + '\'' +
						",wind_dir = '" + windDir + '\'' +
						",gust_mph = '" + gustMph + '\'' +
						",pressure_in = '" + pressureIn + '\'' +
						",gust_kph = '" + gustKph + '\'' +
						",precip_mm = '" + precipMm + '\'' +
						",condition = '" + condition + '\'' +
						",vis_km = '" + visKm + '\'' +
						",pressure_mb = '" + pressureMb + '\'' +
						",vis_miles = '" + visMiles + '\'' +
						"}";
	}
}