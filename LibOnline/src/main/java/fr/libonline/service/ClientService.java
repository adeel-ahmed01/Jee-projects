package fr.libonline.service;

import java.util.List;

import fr.libonline.dao.sql.ClientDaoSqlImpl;
import fr.libonline.model.Client;

public class ClientService implements IService<Client> {
	
	private static final String ADMIN_LOGIN = "admin";

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
	
	public boolean existsByLogin(String login) {
		return new ClientDaoSqlImpl().findByLogin(login) != null;
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

	public boolean validateUserInfo(String login, String password, String nom, String prenom, String adresse) {
		if (
				isInValid(login) ||
				isInValid(password) ||
				isInValid(nom) ||
				isInValid(prenom) ||
				isInValid(adresse) ||
				existsByLogin(login) ||
				login.toLowerCase().equals(ADMIN_LOGIN)
			) {
			return false;
		}
		return true;
	}

	private boolean isInValid(String string) {
		return string == null || string.isEmpty();
	}

}
