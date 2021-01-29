package fr.libonline.service;

import java.util.List;

import fr.libonline.dao.sql.ClientDaoSqlImpl;
import fr.libonline.model.Client;

public class ClientService implements IService<Client> {

	@Override
	public List<Client> findAll() {
		return new ClientDaoSqlImpl().findAll();
	}

	@Override
	public Client findById(int id) {
		return new ClientDaoSqlImpl().findById(id);
	}
	
	public Client findByCredentiants(String login, String password) {
		return new ClientDaoSqlImpl().findByLoginAndPassword(login, password);
	}

	@Override
	public Client add(Client entity) {
		return new ClientDaoSqlImpl().add(entity);
	}

	@Override
	public Client save(Client entity) {
		return new ClientDaoSqlImpl().save(entity);
	}

	@Override
	public boolean deleteById(int id) {
		return new ClientDaoSqlImpl().deleteById(id);
	}

}
