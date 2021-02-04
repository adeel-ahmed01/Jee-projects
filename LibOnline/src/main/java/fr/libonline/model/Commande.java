package fr.libonline.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CM_ID")
	private int id;
	
	@Column(name = "CM_DATE", length = 10, nullable = false)
	private Date date;
	
	@Column(name = "CM_CL_ID", nullable = false)
	private int clientId;
	
	@Column(name = "CM_MONTANT", length = 50, nullable = false)
	private Double montant;
	
	public Commande() {
	
	}
	
	public Commande(int id, Date date, int clientId, Double montant) {
		super();
		this.id = id;
		this.date = date;
		this.clientId = clientId;
		this.montant = montant;
	}

	public Commande(Date date, int clientId, Double montant) {
		super();
		this.date = date;
		this.clientId = clientId;
		this.montant = montant;
	}

	public int getId() {
		return id;
	}

	public Commande id(int id) {
		this.id = id;
		return this;
	}
	
	public Date getDate() {
		return date;
	}

	public Commande date(Date date) {
		this.date = date;
		return this;
	}
	
	public int getClientId() {
		return clientId;
	}
	
	public Commande clientId(int clientId) {
		this.clientId = clientId;
		return this;
	}
	
	public Double getMontant() {
		return montant;
	}
	
	public Commande montant(Double montant) {
		this.montant = montant;
		return this;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", date=" + date + ", clientId=" + clientId + ", montant=" + montant + "]";
	}
	
	

}
