package com.ing.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import com.ing.bean.Transaction;
import com.ing.util.TransactionException;

public interface TransactionOB{
 
	
	ArrayList<Transaction> getTransactionList() throws TransactionException;
 
}