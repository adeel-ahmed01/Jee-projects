package fr.libonline.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import fr.libonline.dao.LivreDao;
import fr.libonline.model.Livre;

public class LivreDaoJpaImpl extends DaoJpa implements LivreDao {

	private static final String SELECT_ALL = "SELECT l FROM Livre l";
	
	private static final String SELECT_BY_ID = "SELECT l FROM Livre l WHERE l.id = :id";

	private static final String SELECT_BY_AUTEUR = 	"SELECT l FROM Livre l " //
													+ "WHERE l.auteur = :auteur ";//

	private static final String SELECT_BY_TITRE = "SELECT l FROM Livre l " //
													+ "WHERE l.titre = :titre "; //
	private static final String SELECT_ALL_PHOTOS = "SELECT l FROM Livre l " //
													+ "WHERE l.photo = :photo "; //

	private static final String DELETE = "DELETE FROM Livre l WHERE l.id = :id";

	
	@Override
	public List<Livre> findAll() {
		return em
				.createQuery(SELECT_ALL, Livre.class)
				.getResultList();
	}

	@Override
	public Livre findById(int id) {
		return em
				.createQuery(SELECT_BY_ID, Livre.class)
				.setParameter("id", id)
				.getSingleResult();
	}
	
	public Livre findByAuthor(String auteur) {
		try {
			return em
					.createQuery(SELECT_BY_AUTEUR, Livre.class)
					.setParameter("auteur", auteur)
					.setMaxResults(1)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Livre findByTitle(String titre) {
		try {
			return em
					.createQuery(SELECT_BY_TITRE, Livre.class)
					.setParameter("titre", titre)
					.setMaxResults(1)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Livre findAllPics(String photo) {
		try {
			//Cast ajoute a Livre pour renvoi des resultats multiples
			return (Livre) em
					.createQuery(SELECT_ALL_PHOTOS, Livre.class)
					.setParameter("photo", photo)
					.getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Livre add(Livre entity) {
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
	public Livre save(Livre entity) {
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
