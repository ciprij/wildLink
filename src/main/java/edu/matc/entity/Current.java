package edu.matc.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	private Object precipIn;

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
	private Object precipMm;

	@JsonProperty("condition")
	private Condition condition;

	@JsonProperty("vis_km")
	private Object visKm;

	@JsonProperty("pressure_mb")
	private Object pressureMb;

	@JsonProperty("vis_miles")
	private Object visMiles;

	public void setFeelslikeC(Object feelslikeC){
		this.feelslikeC = feelslikeC;
	}

	public Object getFeelslikeC(){
		return feelslikeC;
	}

	public void setFeelslikeF(Object feelslikeF){
		this.feelslikeF = feelslikeF;
	}

	public Object getFeelslikeF(){
		return feelslikeF;
	}

	public void setWindDegree(int windDegree){
		this.windDegree = windDegree;
	}

	public int getWindDegree(){
		return windDegree;
	}

	public void setWindchillF(Object windchillF){
		this.windchillF = windchillF;
	}

	public Object getWindchillF(){
		return windchillF;
	}

	public void setWindchillC(Object windchillC){
		this.windchillC = windchillC;
	}

	public Object getWindchillC(){
		return windchillC;
	}

	public void setLastUpdatedEpoch(int lastUpdatedEpoch){
		this.lastUpdatedEpoch = lastUpdatedEpoch;
	}

	public int getLastUpdatedEpoch(){
		return lastUpdatedEpoch;
	}

	public void setTempC(Object tempC){
		this.tempC = tempC;
	}

	public Object getTempC(){
		return tempC;
	}

	public void setTempF(Object tempF){
		this.tempF = tempF;
	}

	public Object getTempF(){
		return tempF;
	}

	public void setCloud(int cloud){
		this.cloud = cloud;
	}

	public int getCloud(){
		return cloud;
	}

	public void setWindKph(Object windKph){
		this.windKph = windKph;
	}

	public Object getWindKph(){
		return windKph;
	}

	public void setWindMph(Object windMph){
		this.windMph = windMph;
	}

	public Object getWindMph(){
		return windMph;
	}

	public void setHumidity(int humidity){
		this.humidity = humidity;
	}

	public int getHumidity(){
		return humidity;
	}

	public void setDewpointF(Object dewpointF){
		this.dewpointF = dewpointF;
	}

	public Object getDewpointF(){
		return dewpointF;
	}

	public void setUv(Object uv){
		this.uv = uv;
	}

	public Object getUv(){
		return uv;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setHeatindexF(Object heatindexF){
		this.heatindexF = heatindexF;
	}

	public Object getHeatindexF(){
		return heatindexF;
	}

	public void setDewpointC(Object dewpointC){
		this.dewpointC = dewpointC;
	}

	public Object getDewpointC(){
		return dewpointC;
	}

	public void setIsDay(int isDay){
		this.isDay = isDay;
	}

	public int getIsDay(){
		return isDay;
	}

	public void setPrecipIn(Object precipIn){
		this.precipIn = precipIn;
	}

	public Object getPrecipIn(){
		return precipIn;
	}

	public void setHeatindexC(Object heatindexC){
		this.heatindexC = heatindexC;
	}

	public Object getHeatindexC(){
		return heatindexC;
	}

	public void setWindDir(String windDir){
		this.windDir = windDir;
	}

	public String getWindDir(){
		return windDir;
	}

	public void setGustMph(Object gustMph){
		this.gustMph = gustMph;
	}

	public Object getGustMph(){
		return gustMph;
	}

	public void setPressureIn(Object pressureIn){
		this.pressureIn = pressureIn;
	}

	public Object getPressureIn(){
		return pressureIn;
	}

	public void setGustKph(Object gustKph){
		this.gustKph = gustKph;
	}

	public Object getGustKph(){
		return gustKph;
	}

	public void setPrecipMm(Object precipMm){
		this.precipMm = precipMm;
	}

	public Object getPrecipMm(){
		return precipMm;
	}

	public void setCondition(Condition condition){
		this.condition = condition;
	}

	public Condition getCondition(){
		return condition;
	}

	public void setVisKm(Object visKm){
		this.visKm = visKm;
	}

	public Object getVisKm(){
		return visKm;
	}

	public void setPressureMb(Object pressureMb){
		this.pressureMb = pressureMb;
	}

	public Object getPressureMb(){
		return pressureMb;
	}

	public void setVisMiles(Object visMiles){
		this.visMiles = visMiles;
	}

	public Object getVisMiles(){
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