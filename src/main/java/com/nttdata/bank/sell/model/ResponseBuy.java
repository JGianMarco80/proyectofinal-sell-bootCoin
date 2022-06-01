package com.nttdata.bank.sell.model;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ResponseBuy implements Serializable{

	private static final long serialVersionUID = 2968839500814838359L;

	private Double amount;
	
	private int mobile;
	
	private Byte payMode;
	
	private String transactionNumber;
	
}
