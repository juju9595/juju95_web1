package 종합.평가3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.평가3.model.dao.MoneyDao;
import 종합.평가3.model.dto.MoneyDto;

import java.util.ArrayList;

@Service
public class MoneyService {
    @Autowired private MoneyDao moneyDao;

    //1. 회원매출조회
    public ArrayList<MoneyDto> moneyInfo(){
        ArrayList<MoneyDto> result = moneyDao.moneyInfo();
        return result;
    }

}
