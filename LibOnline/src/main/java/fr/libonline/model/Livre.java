package fr.libonline.model;

public class Livre {
	private int id;
	private String titre;
	private String auteur;
	private Double prix;
	private String photo;
	private String resume;

	public Livre() {

	}

	public Livre(int id, String titre, String auteur, Double prix, String photo, String resume) {
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.prix = prix;
		this.photo = photo;
		this.resume = resume;
	}

	public Livre(String titre, String auteur, double prix, String photo, String resume) {
		this.titre = titre;
		this.auteur = auteur;
		this.prix = prix;
		this.photo = photo;
		this.resume = resume;
	}

	public int getId() {
		return id;
	}

	public Livre id(int id) {
		this.id = id;
		return this;
	}

	public String getTitre() {
		return titre;
	}

	public Livre titre(String titre) {
		this.titre = titre;
		return this;
	}

	public String getAuteur() {
		return auteur;
	}

	public Livre auteur(String auteur) {
		this.auteur = auteur;
		return this;
	}

	public Double getPrix() {
		return prix;
	}

	public Livre prix(Double prix) {
		this.prix = prix;
		return this;
	}

	public String getPhoto() {
		return photo;
	}

	public Livre photo(String photo) {
		this.photo = photo;
		return this;
	}

	public String getResume() {
		return resume;
	}

	public Livre resume(String resume) {
		this.resume = resume;
		return this;
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livre [id=").append(id).append(", titre=").append(titre).append(", auteur=").append(auteur)
				.append(", prix=").append(prix).append(", photo=").append(photo).append(", resume=")
				.append(resume).append("]");
		return builder.toString();
	}
}
