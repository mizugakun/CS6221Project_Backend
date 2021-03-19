package com.mangomanagement.demo.dao;

import com.mangomanagement.demo.Entity.StorageDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StorageDetailRepository extends JpaRepository<StorageDetail, String>, JpaSpecificationExecutor<StorageDetail> {

}