package com.prince.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newposition")
public class newpositionregister 
{
	@Id
	String jobtitle;
	String jobdes;
	String loc;
	String type;
	String category;
	String url;
	String date;
	String comname;
	String comdes;
	String website;
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobdes() {
		return jobdes;
	}
	public void setJobdes(String jobdes) {
		this.jobdes = jobdes;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public String getComdes() {
		return comdes;
	}
	public void setComdes(String comdes) {
		this.comdes = comdes;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	@Override
	public String toString() {
		return "newpositionregister [jobtitle=" + jobtitle + ", jobdes=" + jobdes + ", loc=" + loc + ", type=" + type
				+ ", category=" + category + ", url=" + url + ", date=" + date + ", comname=" + comname + ", comdes="
				+ comdes + ", website=" + website + "]";
	}
}
