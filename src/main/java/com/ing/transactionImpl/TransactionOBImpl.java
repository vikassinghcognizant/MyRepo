package com.ing.transactionImpl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ing.bean.Transaction;
import com.ing.serviceImpl.TransactionServiceImpl;
import com.ing.transaction.TransactionOB;
import com.ing.util.TransactionException;



public class TransactionOBImpl implements TransactionOB {

    @Autowired
	TransactionServiceImpl tnxserviceImpl;

	public ArrayList<Transaction> getTransactionList()  {
		
		ArrayList<Transaction> tList = null;
		
			try {
				tList = tnxserviceImpl.getTransactionListOB();
			} catch (TransactionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
				
		return tList;
	}

}