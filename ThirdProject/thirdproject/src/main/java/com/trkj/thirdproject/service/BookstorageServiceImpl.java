package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BookDao;
import com.trkj.thirdproject.dao.BookstorageDao;
import com.trkj.thirdproject.dao.StorageexpenditureDao;
import com.trkj.thirdproject.entity.Book;
import com.trkj.thirdproject.entity.Bookstorage;
import com.trkj.thirdproject.entity.Storageexpenditure;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BookstorageServiceImpl implements BookstorageService {
    @Resource
    private BookstorageDao bookstorageDao;
    @Resource
    private BookDao bookDao;
    @Resource
    private StorageexpenditureDao storageexpendituredao;

    @Override
    public List<Bookstorage> selectAll() {
        return bookstorageDao.selectAll();
    }

    @Override
    public List<Bookstorage> selectBookstorage(String value, String input) {
        return bookstorageDao.selectBookStorage(value, input);
    }

    @Override
    public Bookstorage addBookstorage(Bookstorage bookstorage) {
        bookstorage.setEmpId(1);
        //得到此书的所有数据信息
        Book book = bookDao.selectByPrimaryKey(bookstorage.getBookId());
        //得到此书的进价
        BigDecimal bookjprice=book.getBookjprice();
        //得到此次入库此书的总价
        BigDecimal allsprice= bookjprice.multiply(new BigDecimal(bookstorage.getStoragecount()));
        bookstorage.setTotalprice(allsprice);
        bookstorage.setStoragetime(new Date());
        bookstorageDao.addBookstorage(bookstorage);
        return bookstorage;
    }

    @Override
    public Bookstorage updateByPrimaryKey(Bookstorage bookstorage) {
        bookstorage.setEmpId(1);
        //得到此书的所有数据信息
        Book book = bookDao.selectByPrimaryKey(bookstorage.getBookId());
        //得到此书的进价
        BigDecimal booksprice=book.getBookjprice();
        //得到此次入库此书的总价
        BigDecimal allsprice= booksprice.multiply(new BigDecimal(bookstorage.getStoragecount()));
        bookstorage.setTotalprice(allsprice);
        bookstorageDao.updateByPrimaryKey(bookstorage);
        return bookstorage;
    }

    @Override
    public int deleteByPrimaryKey(int mbookstorageId) {
        bookstorageDao.deleteByPrimaryKey(mbookstorageId);
        return mbookstorageId;
    }
//================================================教材入库支出============================================================
    @Override
    public Storageexpenditure insertStorageexpenditure(Storageexpenditure storageexpenditure) {
        storageexpenditure.setAddtime(new Date());
        //生成订单号
        String number = "RK";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String result = number+ dateFormat.format(new Date()) + storageexpenditure.toString().length();
        storageexpenditure.setExpensesName(result);
        //支出日期
        storageexpenditure.setExpensesDate(new Date());
        //支出明细
        storageexpenditure.setExpensesDetails("教材入库支出");
        //计算总价格
        //得到此书的所有数据信息
        Book book = bookDao.selectByPrimaryKey(storageexpenditure.getBookId());
        //得到此书的进价
        BigDecimal bookjprice=book.getBookjprice();
        //得到此次入库此书的总价
        BigDecimal allsprice= bookjprice.multiply(new BigDecimal(storageexpenditure.getRefundCount()));
        storageexpenditure.setTotalmoney(allsprice);
        storageexpendituredao.insert(storageexpenditure);
        return storageexpenditure;
    }

    @Override
    public List<Storageexpenditure> selectAllStorage() {
        return storageexpendituredao.selectAllStorage();
    }

    @Override
    public Storageexpenditure updateReApproval(Storageexpenditure storageexpenditure) {
        storageexpenditure.setUpdatetime(new Date());
        storageexpendituredao.updateReApproval(storageexpenditure);
        return storageexpenditure;
    }

    @Override
    public Storageexpenditure updateApproval(Storageexpenditure storageexpenditure) {
        storageexpenditure.setUpdatetime(new Date());
        storageexpendituredao.updateApproval(storageexpenditure);
        return storageexpenditure;
    }

    @Override
    public Storageexpenditure deleteTimeliness(Storageexpenditure storageexpenditure) {
        storageexpenditure.setDeletetime(new Date());
        storageexpendituredao.deleteTimeliness(storageexpenditure);
        return storageexpenditure;
    }


}
