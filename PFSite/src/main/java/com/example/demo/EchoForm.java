package com.example.demo;

import java.io.Serializable;

public class EchoForm  implements Serializable{
	
	private static final long serialVesionUID = 1L;
	
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
