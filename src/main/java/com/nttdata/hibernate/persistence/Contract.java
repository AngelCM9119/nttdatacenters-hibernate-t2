package com.nttdata.hibernate.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * Clase que representa a la tabla Contratos en la base de datos
 * @author Ángel
 *
 */
@Entity
@Table(name="contratos")
public class Contract extends AbstractEntity implements Serializable
{
	/** Serial version ID */
	private static final long serialVersionUID = 1L;
	
	/** Identificador del contrato */
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	/** Fecha de vigencia del contrato */
	@Column(name="fecha_vigencia")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	/** Fecha de caducidad del contrato */
	@Column(name="fecha_cad")
	@Temporal(TemporalType.DATE)
	private Date expDate;
	
	/** Precio mensual */
	@Column(name="precio")
	private int price;
	
	/** Cliente al que pertenece este contrato */
	@JoinColumn(name="id_cliente", referencedColumnName = "id")
	@ManyToOne
	private Client client;

	@Override
	public long getSerialId()
	{
		return this.id;
	}

	@Override
	public void setSerialId(long id)
	{
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId()
	{
		return id;
	}

	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}

	/**
	 * @return the expiration date
	 */
	public Date getExpirationDate()
	{
		return expDate;
	}

	/**
	 * @param expDate the expiration date to set
	 */
	public void setExpirationDate(Date expDate)
	{
		this.expDate = expDate;
	}

	/**
	 * @return the price
	 */
	public int getPrice()
	{
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price)
	{
		this.price = price;
	}

	/**
	 * @return the client
	 */
	public Client getClient()
	{
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client)
	{
		this.client = client;
	}

	@Override
	public String toString()
	{
		return "Contract [id=" + id + ", date=" + date + ", expDate=" + expDate + ", price=" + price + ", client=" + client.getName() + "]";
	}

	
	
	
	
}
