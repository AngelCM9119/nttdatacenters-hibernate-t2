package com.nttdata.hibernate;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.Contract;
import com.nttdata.hibernate.services.ClientServiceImpl;
import com.nttdata.hibernate.services.ContractServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args)
    {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
    	Session session = factory.openSession();
    	
    	ClientServiceImpl clientService = new ClientServiceImpl(session);
    	ContractServiceImpl contractService = new ContractServiceImpl(session);
    	
    	// datos de auditoria
    	String user = "ACM";
    	Date date = new Date();
    	
    	Client c1 = new Client();
    	c1.setName("Angel");
    	c1.setLastname1("Calle");
    	c1.setLastname2("Martin");
    	c1.setDni("12345678B");
    	c1.setUpdatedUser(user);
    	c1.setUpdatedDate(date);
    	
    	Client c2 = new Client();
    	c2.setName("Manuel");
    	c2.setLastname1("Gutierrez");
    	c2.setLastname2("Carmona");
    	c2.setDni("98765432C");
    	c2.setUpdatedUser(user);
    	c2.setUpdatedDate(date);
    	
    	Client c3 = new Client();
    	c3.setName("Maite");
    	c3.setLastname1("Figueroa");
    	c3.setLastname2("Espinosa");
    	c3.setDni("11111111D");
    	c3.setUpdatedUser(user);
    	c3.setUpdatedDate(date);
    	
    	Calendar cal = Calendar.getInstance();    	
    	Contract ct1 = new Contract();
    	ct1.setClient(c1);
    	cal.set(2017, Calendar.MARCH, 1);
    	ct1.setDate(cal.getTime());
    	cal.set(2019, Calendar.DECEMBER, 31);
    	ct1.setExpirationDate(cal.getTime());
    	ct1.setPrice(1500);
    	ct1.setUpdatedUser(user);
    	ct1.setUpdatedDate(date);
    	
    	Contract ct2 = new Contract();
    	ct2.setClient(c1);
    	cal.set(2020, Calendar.JANUARY, 1);
    	ct2.setDate(cal.getTime());
    	cal.set(2021, Calendar.AUGUST, 31);
    	ct2.setExpirationDate(cal.getTime());
    	ct2.setPrice(1800);
    	ct2.setUpdatedUser(user);
    	ct2.setUpdatedDate(date);
    	
    	Contract ct3 = new Contract();
    	ct3.setClient(c2);
    	cal.set(2017, Calendar.JANUARY, 1);
    	ct3.setDate(cal.getTime());
    	cal.set(2018, Calendar.JUNE, 30);
    	ct3.setExpirationDate(cal.getTime());
    	ct3.setPrice(1200);
    	ct3.setUpdatedUser(user);
    	ct3.setUpdatedDate(date);
    	
    	Contract ct4 = new Contract();
    	ct4.setClient(c3);
    	cal.set(2017, Calendar.JANUARY, 1);
    	ct4.setDate(cal.getTime());
    	cal.set(2017, Calendar.DECEMBER, 31);
    	ct4.setExpirationDate(cal.getTime());
    	ct4.setPrice(1600);
    	ct4.setUpdatedUser(user);
    	ct4.setUpdatedDate(date);
    	
    	
    	clientService.insertClient(c1);
    	clientService.insertClient(c2);
    	clientService.insertClient(c3);
    	contractService.insertContract(ct1);
    	contractService.insertContract(ct2);
    	contractService.insertContract(ct3);
    	contractService.insertContract(ct4);
    	
    	c1.setContracts(contractService.getAllContractsByClientId(1L));
    	
    	System.out.println("clientes: "+clientService.getAllClients());    	
    	System.out.println("contratos del cliente 1: "+c1.getContracts());
    	
    	session.close();    	
    }
}
