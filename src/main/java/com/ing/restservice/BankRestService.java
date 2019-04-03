package com.ing.restservice;

import java.util.ArrayList;
import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ing.bean.Transaction;
import com.ing.transactionImpl.TransactionOBImpl;
import com.ing.util.Mapper;


@Component
@Path("/Account")
public class BankRestService {
	
	@Autowired
	Mapper mapper;
	
	
	@Autowired
	TransactionOBImpl txnBoImpl;
	/*
	 * http://localhost:8080/RESTWithSpringJersey/API/Employee/abhimanyu/1234
	 */
	//@RolesAllowed("ADMIN")   
	@GET
	@Path(value = "/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> getTransactionList(@PathParam("Id") String Id) {
		 
		List<Transaction> tList;
		
			tList = new  ArrayList<Transaction>();
			tList= txnBoImpl.getTransactionList();
		
		return tList;
	}
}