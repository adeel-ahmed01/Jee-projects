package fr.libonline.service;

import java.util.List;

import fr.libonline.dao.sql.LivreDaoSqlImpl;
import fr.libonline.model.Livre;

public class LivreService implements IService<Livre>{

	@Override
	public List<Livre> findAll() {
		return new LivreDaoSqlImpl().findAll();
	}

	@Override
	public Livre findById(int id) {
		return new LivreDaoSqlImpl().findById(id);
	}

	@Override
	public Livre add(Livre entity) {
		return new LivreDaoSqlImpl().add(entity);
	}

	@Override
	public Livre save(Livre entity) {
		return new LivreDaoSqlImpl().save(entity);
	}

	@Override
	public boolean deleteById(int id) {
		return new LivreDaoSqlImpl().deleteById(id);
	}

}
