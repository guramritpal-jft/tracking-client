package com.excercise.tracking.model;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Activity {
	private Integer id;
	private String description;
	private Integer duration;

	public Activity(){

	}
}
