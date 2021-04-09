package com.mangomanagement.demo.ServiceImpl;

import com.mangomanagement.demo.Entity.StorageDetail;
import com.mangomanagement.demo.Service.StorageService;
import com.mangomanagement.demo.dao.StorageDetailRepository;
import com.mangomanagement.demo.util.query.SearchCriteria;
import com.mangomanagement.demo.util.query.SpecificationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageDetailRepository storageRepository;

    public StorageServiceImpl(StorageDetailRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public void save(StorageDetail storageDetail) {
        storageRepository.save(storageDetail);
    }

    @Override
    public List<StorageDetail> findStorageList(int userId) {
        String id = "" + userId;
        SpecificationImpl<StorageDetail> sp = new SpecificationImpl<>(new SearchCriteria("userId", "=", id));
        List<StorageDetail> res = storageRepository.findAll(sp);

        return res;
    }

    @Override
    public StorageDetail findStorage(int userId, int itemId) {
        Specification<StorageDetail> sp1 = new SpecificationImpl<>(new SearchCriteria("userId", "=", "" + userId));
        List<StorageDetail> list = storageRepository.findAll(Specification.where(sp1));

        StorageDetail res = null;
        for (StorageDetail detail : list) {
            if (detail.getItemId() == itemId) {
                res = detail;
                break;
            }
        }

        if (res == null) {
            throw new RuntimeException("User " + userId + " don't has item. Item id = " + itemId);
        }

        return res;
    }
}
