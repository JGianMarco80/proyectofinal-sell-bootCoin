package com.nttdata.bank.sell.model;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Buy implements Serializable{

	private static final long serialVersionUID = 1L;

	private Double amount;
	
	private int mobile;
	
	private Byte payMode;
	
}
