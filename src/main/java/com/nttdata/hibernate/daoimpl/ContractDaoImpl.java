package com.nttdata.hibernate.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nttdata.hibernate.common.CommonDaoImpl;
import com.nttdata.hibernate.daoi.ContractDaoI;
import com.nttdata.hibernate.persistence.Contract;

public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI
{

	public ContractDaoImpl(Session session)
	{
		super(session);
	}

	// Métodos propios de la tabla clientes

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> getByClientId(Long clientId)
	{
		Transaction transaction = checkTransaction();
		List<Contract> res = session.createQuery("FROM "+entityClass.getName()+" WHERE id_cliente = "+clientId).list();
		closeTransaction(transaction);
				
		return res;
	}	

}
