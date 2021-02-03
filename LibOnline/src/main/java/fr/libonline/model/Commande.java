package fr.libonline.model;

import java.util.Date;

public class Commande {
	
	private int id;
	private Date date;
	private int clientId;
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
