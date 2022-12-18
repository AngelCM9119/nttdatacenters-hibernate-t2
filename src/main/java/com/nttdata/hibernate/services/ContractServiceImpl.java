package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.daoi.ContractDaoI;
import com.nttdata.hibernate.daoimpl.ContractDaoImpl;
import com.nttdata.hibernate.persistence.Contract;

public class ContractServiceImpl implements ContractServiceI
{
	/** El DAO del contrato */
	private ContractDaoI dao;

	public ContractServiceImpl(Session session)
	{
		this.dao = new ContractDaoImpl(session);
	}
	
	@Override
	public void insertContract(Contract contract)
	{
		if(contract != null && contract.getId() == null)
			this.dao.insert(contract);
	}

	@Override
	public void updateContract(Contract contract)
	{
		if(contract != null && contract.getId() != null)
			this.dao.update(contract);
	}

	@Override
	public void deleteContract(Contract contract)
	{
		if(contract != null && contract.getId() != null)
			this.dao.delete(contract);
	}

	@Override
	public List<Contract> getAllContracts()
	{
		return this.dao.getAll();
	}

	@Override
	public Contract getContractById(final Long id)
	{
		return this.dao.getById(id);
	}

	@Override
	public List<Contract> getAllContractsByClientId(final Long clientId)
	{
		return this.dao.getByClientId(clientId);
	}
	
}
