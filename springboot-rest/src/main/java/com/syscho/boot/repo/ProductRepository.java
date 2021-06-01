package com.syscho.boot.repo;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.syscho.boot.entity.ProductEntity;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {

	public List<ProductEntity> findAll();

	public ProductEntity findByProductId(Long prodId);

	public List<ProductEntity> findAllByProductName(String prodName);

	public int deleteByProductId(long prodId);
}
