package com.trkj.thirdproject.service;

import com.trkj.thirdproject.dao.BookDao;
import com.trkj.thirdproject.dao.BookdeliveryDao;
import com.trkj.thirdproject.dao.WarehouseincomeDao;
import com.trkj.thirdproject.entity.Book;
import com.trkj.thirdproject.entity.Bookdelivery;
import com.trkj.thirdproject.entity.Warehouseincome;
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
public class BookdeliveryServiceImpl implements BookdeliveryService {
    @Resource
    private BookdeliveryDao bookdeliveryDao;
    @Resource
    private WarehouseincomeDao warehouseincomedao;
    @Resource
    private BookDao bookdao;

    @Override
    public int deleteByPrimaryKey(int bookdeliveryId) {
        bookdeliveryDao.deleteByPrimaryKey(bookdeliveryId);
        return bookdeliveryId;
    }

    @Override
    public Bookdelivery insert(Bookdelivery bookdelivery) {
        bookdelivery.setEmpId(1);
        bookdelivery.setStudentId(1);
        bookdelivery.setDeliverytime(new Date());
        log.debug(bookdelivery+"");
        bookdeliveryDao.insert(bookdelivery);
        return bookdelivery;
    }
//--------------------------------------------------教材出库收入-----------------------------------------------------------
    @Override
    public Warehouseincome insertincome(Warehouseincome warehouseincome) {
        //新增日期
        warehouseincome.setAddtime(new Date());
        //出库日期
        warehouseincome.setRefundDate(new Date());
        //生成订单号
        String number = "CK";
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String result = number+ dateFormat.format(new Date()) + warehouseincome.toString().length();
        warehouseincome.setRefundName(result);
        //教材出库明细
        warehouseincome.setRefundDetails("教材出库收入");
        //计算总价格
        //得到此书的所有数据信息
        Book book = bookdao.selectByPrimaryKey(warehouseincome.getBookId());
        //得到此书的进价
        BigDecimal bookjprice=book.getBookjprice();
        //得到此次入库此书的总价
        BigDecimal allsprice= bookjprice.multiply(new BigDecimal(warehouseincome.getRefundCount()));
        warehouseincome.setTotalmoney(allsprice);
        log.debug(allsprice+"hahaha");
        warehouseincomedao.insert(warehouseincome);
        return warehouseincome;
    }

    @Override
    public Warehouseincome updateReApproval(Warehouseincome warehouseincome) {
        warehouseincome.setRevokeapptime(new Date());
        warehouseincomedao.updateReApproval(warehouseincome);
        return warehouseincome;
    }

    @Override
    public Warehouseincome updateApproval(Warehouseincome warehouseincome) {
        warehouseincome.setApprovaltime(new Date());
        warehouseincomedao.updateApproval(warehouseincome);
        return warehouseincome;
    }

    @Override
    public List<Warehouseincome> selectAllincome() {
        return warehouseincomedao.selectAllincome();
    }

    @Override
    public List<Warehouseincome> selectBycontionBook2(int Approval, String value1, String value2, String input) {
        return warehouseincomedao.selectBycontionBook2(Approval, value1, value2, input);
    }
}
