package fr.libonline.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import fr.libonline.dao.ClientDao;
import fr.libonline.dao.CommandeDao;
import fr.libonline.model.Client;
import fr.libonline.model.Commande;

public class CommandeDaoJpaImpl extends DaoJpa implements CommandeDao {
	
	private static final String SELECT_ALL = "SELECT c FROM Commande c";
	
	private static final String SELECT_BY_ID = "SELECT c FROM Commande c WHERE c.id = :id";
	
	private static final String DELETE = "DELETE FROM Commande c WHERE c.id = :id";

	@Override
	public List<Commande> findAll() {
		return em
				.createQuery(SELECT_ALL, Commande.class)
				.getResultList();
	}

	@Override
	public Commande findById(int id) {
		return em
				.createQuery(SELECT_BY_ID, Commande.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public Commande add(Commande entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Commande save(Commande entity) {
		try {
			em.getTransaction().begin();
			if (entity.getId() > 0) {
				// Si l'entity a un id, on fait un update
				entity = em.merge(entity);
			} else {
				// Sinon on fait un insert
				em.persist(entity);
			}
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteById(int id) {
		try {
			em.getTransaction().begin();
			em
				.createQuery(DELETE)
				.setParameter("id", id)
				.executeUpdate();
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
