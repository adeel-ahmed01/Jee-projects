package fr.libonline.service;

import java.util.List;

import fr.libonline.dao.sql.CommandeDaoSqlImpl;
import fr.libonline.model.Commande;

public class CommandeService implements IService<Commande> {

	@Override
	public List<Commande> findAll() {
		return new CommandeDaoSqlImpl().findAll();
	}

	@Override
	public Commande findById(int id) {
		return new CommandeDaoSqlImpl().findById(id);
	}
	
	@Override
	public Commande add(Commande entity) {
		return new CommandeDaoSqlImpl().add(entity);
	}

	@Override
	public Commande save(Commande entity) {
		return new CommandeDaoSqlImpl().save(entity);
	}

	@Override
	public boolean deleteById(int id) {
		return new CommandeDaoSqlImpl().deleteById(id);
	}

}