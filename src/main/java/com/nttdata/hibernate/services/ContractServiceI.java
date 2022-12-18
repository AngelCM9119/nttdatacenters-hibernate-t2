package com.nttdata.hibernate.services;

import java.util.List;

import com.nttdata.hibernate.persistence.Contract;

public interface ContractServiceI
{
	/**
	 * Inserta un nuevo contrato
	 * @param contract El contrato a insertar
	 */
	public void insertContract(final Contract contract);
	
	/**
	 * Actualiza un contrato existente
	 * @param client El contrato a actualizar
	 */
	public void updateContract(final Contract contract);
	
	/**
	 * Elimina un contrato existente
	 * @param client El contrato a eliminar
	 */
	public void deleteContract(final Contract contract);
	
	/**
	 * Devuelve todos los contratos
	 * @return Una lista con todos los contratos
	 */
	public List<Contract> getAllContracts();
	
	/**
	 * Devuelve el contrato buscado
	 * @param id El ID del contrato que se quiere buscar
	 * @return Devuelve el contrato si existe. En caso contrario, devuelve null
	 */
	public Contract getContractById(final Long id);
	
	/**
	 * Consulta todos los contratos que pertenecen al cliente
	 * @param clientId Id del cliente
	 * @return Una lista con los contratos obtenidos en la consulta
	 */
	public List<Contract> getAllContractsByClientId(final Long clientId);
}
