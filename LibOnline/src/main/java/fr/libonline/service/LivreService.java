package fr.libonline.service;

import java.util.List;

import fr.libonline.dao.jpa.LivreDaoJpaImpl;
import fr.libonline.model.Livre;

public class LivreService implements IService<Livre>{

	@Override
	public List<Livre> findAll() {
		return new LivreDaoJpaImpl().findAll();
	}

	@Override
	public Livre findById(int id) {
		return new LivreDaoJpaImpl().findById(id);
	}

	public Livre findByAuteur(String auteur) {
		return new LivreDaoJpaImpl().findByAuthor(auteur);
	}
	
	public Livre findByTitre(String titre) {
		return new LivreDaoJpaImpl().findByTitle(titre);
	}
	
	public Livre findAllPics(String photo) {
		return new LivreDaoJpaImpl().findAllPics(photo);
	}
	
	@Override
	public Livre add(Livre entity) {
		return new LivreDaoJpaImpl().add(entity);
	}

	@Override
	public Livre save(Livre entity) {
		return new LivreDaoJpaImpl().save(entity);
	}

	@Override
	public boolean deleteById(int id) {
		return new LivreDaoJpaImpl().deleteById(id);
	}

}
