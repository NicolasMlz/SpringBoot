package br.com.cod3r.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.cod3r.exerciciossb.model.entities.Produto;

public interface ProdutoRepository 
	extends PagingAndSortingRepository<Produto, Integer> {
	
//ALGUNS EXEMPLOS
	//findByNomeContaining
	//findByNomeIsContaining
	//findByNomeContains
	//findByNomeStartsWith
	//findByNomeEndsWith
	//findByNomeNotContaining
	
	public  Iterable<Produto> findByNomeContainingIgnoreCase(String nome);
	
	//-------------------------------------MUITO IMPORTANTE-------------------------------------------
	//CONSULTAR POR COMANDO SQL
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> procurarPorSql(@Param("nome") String nome);
	//-------------------------------------MUITO IMPORTANTE-------------------------------------------
	
}
