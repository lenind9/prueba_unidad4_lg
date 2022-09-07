package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencillo;


@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public Producto buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Producto.class, id);
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Producto buscarPorCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :datoCodigoBarras", Producto.class);
		myQuery.setParameter("datoCodigoBarras", codigoBarras);
		try {
			return myQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public ProductoSencillo buscarProdSencillo(String codigoBarras) {
		// TODO Auto-generated method stub
		/*Query myQuery = this.entityManager.createNativeQuery("SELECT NEW com.uce.edu.demo.modelo.ProductoSencillo(p.codigoBarras, p.stock) FROM Producto p"
				+ "WHERE p.codigoBarras = :datoCodigoBarras AND p.stock = :datoStock", ProductoSencillo.class);*/
		TypedQuery<ProductoSencillo> myQuery = this.entityManager.createQuery("SELECT NEW com.uce.edu.demo.modelo.ProductoSencillo(p.codigoBarras, p.nombre, p.categoria, p.stock) "
				+ "FROM Producto p WHERE p.codigoBarras = :datoCodigoBarras", ProductoSencillo.class);
		myQuery.setParameter("datoCodigoBarras", codigoBarras);
		//return (ProductoSencillo) myQuery.getSingleResult();
		return myQuery.getSingleResult();
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myQuery = this.entityManager.createQuery("SELECT p FROM Producto p", Producto.class);
		return myQuery.getResultList();
	}

}
