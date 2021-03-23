package com.mangomanagement.demo.Service;

import com.mangomanagement.demo.Entity.StorageDetail;

import java.util.List;

public interface StorageService {
    public void save(StorageDetail storageDetail);

    public List<StorageDetail> findStorageList(int userId);

    public StorageDetail findStorage(int userId, int itemId);
}
