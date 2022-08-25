package br.com.cod3r.exerciciossb.controllers;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.cod3r.exerciciossb.model.entities.Produto;
import br.com.cod3r.exerciciossb.model.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    //INSERIR OU ALTERAR PRODUTO
//  @PostMapping
    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public @ResponseBody Produto novoProduto(@Valid Produto produto) {
        produtoRepository.save(produto);
        return produto;
    }
    
    //OBTER TODOS OS PRODUTOS
    // NAO REOCMENDAVEL NUMA APLICACAO REAL
    @GetMapping
    public Iterable<Produto> obterProdutos() {
    	return produtoRepository.findAll();
    }
    
    //OBTER TODOS OS PRODUTOS POR PAGINA
    @GetMapping(path = "/pagina/{numeroPg}/{qtdePg}")
    public Iterable<Produto> obterProdutosPorPagina(
    		@PathVariable int numeroPg, @PathVariable int qtdePg) {
    	if(qtdePg >= 5) qtdePg = 5;
    	Pageable page = PageRequest.of(numeroPg, qtdePg);
    	return produtoRepository.findAll(page);
    }
    
    //OBTER PRODUTO POR ID
    @GetMapping(path = "/{id}")
    public Optional<Produto>  obterProdutoPorId(@PathVariable int id) {
    	return produtoRepository.findById(id);
    }
    
    //OBTER PRODUTOS POR STRING
    @GetMapping(path = "/nome/{nome}")
    public Iterable<Produto> obterProdutosPorNome(
    		@PathVariable String nome) {
    	return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }
    
    //OBTER PRODUTOS POR STRING E MAIOR QUE PRECO
    @GetMapping(path = "/nomeSQL/{nome}")
    public Iterable<Produto> obterProdutosPorNomeEMaiorQuePreco(
    		@PathVariable String nome) {
    	return produtoRepository.procurarPorSql(nome);
    }
    
    //REMOVER PRODUTO
    @DeleteMapping(path = "/{id}")
    public void removerProduto(@PathVariable int id) {
    	produtoRepository.deleteById(id);
    }
    
//    @PutMapping
//    public Produto alterarProduto(@Valid Produto produto) {
//    	produtoRepository.save(produto);
//    	return produto;
//    }
    
}
