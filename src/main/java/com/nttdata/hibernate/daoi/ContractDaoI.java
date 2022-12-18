package com.nttdata.hibernate.daoi;

import java.util.List;

import com.nttdata.hibernate.common.CommonDaoI;
import com.nttdata.hibernate.persistence.Contract;

public interface ContractDaoI extends CommonDaoI<Contract>
{
	/**
	 * Consulta todos los contratos que tiene un cliente
	 * @param clientId Id del cliente
	 * @return Una lista con los contratos del cliente
	 */
	public List<Contract> getByClientId(Long clientId);
}
