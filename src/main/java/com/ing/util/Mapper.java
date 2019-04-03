package com.ing.util;

import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.ing.bean.Transaction;

public class Mapper {

public static ArrayList<Transaction> convertStringToJSON(String transacStr)

      {

           

            ArrayList<Transaction> transactionList = null;

            if(transacStr != null){

            try {

                 

                  JSONObject jsonObject = new JSONObject(transacStr);

                  if(isJsonKeyExists(jsonObject,"transactions"))

                  {

                        transactionList = new ArrayList<Transaction>();

                        JSONArray jsonArr = jsonObject.getJSONArray("transactions");

                       

                        for (int i = 0; i < jsonArr.length(); i++){

                              JSONObject obj = jsonArr.getJSONObject(i);

                             // Transaction transObj = ctx.getBean(Transaction.class);
                              
                              Transaction transObj = new Transaction();
                             Mapper.mapJSONToTransactionObj(obj, transObj);

                              transactionList.add(transObj);

                        }

                  }

                 

            } catch (Exception e) {

                  try {

                    //    throw new BankTransactionCustomException("Error while reading JSON operation");

                  } catch (Exception e1) {

                        // TODO Auto-generated catch block

                        e1.printStackTrace();

                  }

            }

            }

           // LOGGER.info("END : getJSONObjectFromJSONString() method");

            return transactionList;

      }

private static void mapJSONToTransactionObj(JSONObject obj, Transaction transObj) {
	
	
	transObj.setAccountId(obj.getString("id"));
	
	if(obj.has("this_account")&& obj.getJSONObject("this_account").has("id"))

		transObj.setAccountId(obj.getJSONObject("this_account").optString("id"));
	
	
	if(obj.has("other_account")&& obj.getJSONObject("other_account").has("holder")&& obj.getJSONObject("other_account").getJSONObject("holder").has("name"))

		transObj.setCounterpartyName(obj.getJSONObject("other_account").getJSONObject("holder").optString("name"));
	
	if(obj.has("other_account") && obj.getJSONObject("other_account").has("number"))

		transObj.setCounterpartyAccount(obj.getJSONObject("other_account").optString("number"));


    
	
}

private static boolean isJsonKeyExists(JSONObject jsonObject, String string) {
	// TODO Auto-generated method stub
	return true;
}
	

}
