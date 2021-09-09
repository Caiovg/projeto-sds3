package com.devsuperior.dsvendas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.dtos.SaleDTO;
import com.devsuperior.dsvendas.dtos.SaleSuccessDTO;
import com.devsuperior.dsvendas.dtos.SaleSumDTO;
import com.devsuperior.dsvendas.model.Sale;
import com.devsuperior.dsvendas.repository.SaleRepository;
import com.devsuperior.dsvendas.repository.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	//vaifuncionar para busca todos os vendedores, 
	//e não vai mostrar varios selects no console,
	//Mas essa vantagem so funciona pra banco de dados, que tenha poucas informações
	//se tiver muito e melhor nem fazer, pois gera um cache na memoria
	//o que deixa ira acarretar em um um backend mais lento
	@Autowired
	private SellerRepository selllerRepository;
	
	//Busca paginada de vendas, não tras todas as informações
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		selllerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
}
