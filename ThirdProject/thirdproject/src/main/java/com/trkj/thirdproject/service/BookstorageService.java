package com.trkj.thirdproject.service;

import com.trkj.thirdproject.entity.Bookstorage;
import com.trkj.thirdproject.entity.Deliveryddetails;
import com.trkj.thirdproject.entity.Storageexpenditure;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookstorageService {
    List<Bookstorage> selectAll();

    List<Bookstorage> selectBookstorage(@Param("value")String value, @Param("input") String input);

    Bookstorage addBookstorage(Bookstorage bookstorage);

    Bookstorage updateByPrimaryKey(Bookstorage bookstorage);

    Bookstorage deleteByPrimaryKey(Bookstorage bookstorage);
    //=========================================教材入库支出（财务部）================================================================
    //新增教材入库
    Storageexpenditure insertStorageexpenditure(Storageexpenditure storageexpenditure);
    //查询所有教材入库
    List<Storageexpenditure> selectAllStorage();
    //撤销审核
    Storageexpenditure updateReApproval(Storageexpenditure storageexpenditure);
    //审核
    Storageexpenditure updateApproval(Storageexpenditure storageexpenditure);
    //删除
    Storageexpenditure deleteTimeliness(Storageexpenditure storageexpenditure);
    //多条件查询
    List<Storageexpenditure> selectBycontionBook(int Approval,String value1,String value2,String input);
}
