package com.example.simpleBot.Simple.Bot.entities;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Bot {
@Id
@GeneratedValue
public int id;
public String command;
public String query;
public String apiurl;
public Bot updateQuery(int id,String command, String query, String apiurl, String apitype, String apikey) {
	this.id=id;
	this.command = command;
	this.query = query;
	this.apiurl = apiurl;
	this.apitype = apitype;
	this.apikey = apikey;
	
	return this;
}
public String getApiurl() {
	return apiurl;
}
public void setApiurl(String apiurl) {
	this.apiurl = apiurl;
}
public String getApitype() {
	return apitype;
}
public void setApitype(String apitype) {
	this.apitype = apitype;
}
public String getApikey() {
	return apikey;
}
public void setApikey(String apikey) {
	this.apikey = apikey;
}
public String apitype;
public String apikey;

public Bot() {
	
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCommand() {
	return command;
}
public void setCommand(String command) {
	this.command = command;
}
public String getQuery() {
	return query;
}
public void setQuery(String query) {
	this.query = query;
}


}
