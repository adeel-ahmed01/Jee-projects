package fr.libonline.service;

import java.util.List;

import fr.libonline.dao.jpa.CommandeDaoJpaImpl;
import fr.libonline.model.Commande;

public class CommandeService implements IService<Commande> {

	@Override
	public List<Commande> findAll() {
		return new CommandeDaoJpaImpl().findAll();
	}

	@Override
	public Commande findById(int id) {
		return new CommandeDaoJpaImpl().findById(id);
	}
	
	@Override
	public Commande add(Commande entity) {
		return new CommandeDaoJpaImpl().add(entity);
	}

	@Override
	public Commande save(Commande entity) {
		return new CommandeDaoJpaImpl().save(entity);
	}

	@Override
	public boolean deleteById(int id) {
		return new CommandeDaoJpaImpl().deleteById(id);
	}

	public List<Commande> findByClientId(int id) {
		return new CommandeDaoJpaImpl().findByClientId(id);
	}

}