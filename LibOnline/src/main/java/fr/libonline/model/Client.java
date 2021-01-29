package fr.libonline.model;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private String login;
	private String password;

	public Client() {

	}

	public Client(int id, String nom, String prenom, String adresse, String login, String password) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.login = login;
		this.password = password;
	}

	public Client(String nom, String prenom, String adresse, String login, String password) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.login = login;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public Client id(int id) {
		this.id = id;
		return this;
	}

	public String getNom() {
		return nom;
	}

	public Client nom(String nom) {
		this.nom = nom;
		return this;
	}

	public String getPrenom() {
		return prenom;
	}

	public Client prenom(String prenom) {
		this.prenom = prenom;
		return this;
	}

	public String getAdresse() {
		return adresse;
	}

	public Client adresse(String adresse) {
		this.adresse = adresse;
		return this;
	}

	public String getLogin() {
		return login;
	}

	public Client login(String login) {
		this.login = login;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Client password(String password) {
		this.password = password;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [id=").append(id).append(", nom=").append(nom).append(", prenom=").append(prenom)
				.append(", adresse=").append(adresse).append(", login=").append(login).append(", password=")
				.append(password).append("]");
		return builder.toString();
	}

}
