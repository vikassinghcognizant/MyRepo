package com.ing.serviceImpl;


import java.util.ArrayList;
import javax.net.ssl.SSLContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import com.ing.bean.Transaction;
import com.ing.service.TransactionService;
import com.ing.util.Mapper;



public class TransactionServiceImpl implements TransactionService {
 
	@Autowired
	RestTemplate restTemplate;
		public ArrayList<Transaction> getTransactionListOB() {
			
			String SERVER_URI ="https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";
			
            
            TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;

                SSLContext sslContext;
                
                  try {
                        sslContext = org.apache.http.ssl.SSLContexts.custom()
                                        .loadTrustMaterial(null, acceptingTrustStrategy)
                                        .build();
                        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

                      CloseableHttpClient httpClient = HttpClients.custom()
                                      .setSSLSocketFactory(csf)
                                      .build();

                      HttpComponentsClientHttpRequestFactory requestFactory =
                                      new HttpComponentsClientHttpRequestFactory();

                      requestFactory.setHttpClient(httpClient);
                      restTemplate = new RestTemplate(requestFactory);
                      
                  } catch (KeyManagementException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                  } catch (NoSuchAlgorithmException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                  } catch (KeyStoreException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                  }


			//we can't get List<Employee> because JSON convertor doesn't know the type of
			//object in the list and hence convert it to default JSON object type LinkedHashMap
			String tnxs = "";
			tnxs = restTemplate.getForObject(SERVER_URI, String.class);
			//System.out.println(tnxs);
			 return Mapper.convertStringToJSON(tnxs);
		}
 
}