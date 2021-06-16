package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Bookstorage;
import com.trkj.thirdproject.entity.Storageexpenditure;

import java.util.List;

public interface BookstorageService {
    List<Bookstorage> selectAll();

    Bookstorage addBookstorage(Bookstorage bookstorage);

    Bookstorage updateByPrimaryKey(Bookstorage bookstorage);

    int deleteByPrimaryKey(int mbookstorageId);
    //=========================================教材入库支出（财务部）================================================================
    //新增教材入库
    Storageexpenditure insertStorageexpenditure(Storageexpenditure storageexpenditure);
}
