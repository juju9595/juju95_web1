package 종합.과제12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 종합.과제12.model.dao.WaitingDao;
import 종합.과제12.model.dto.WaitingDto;

import java.util.List;

@Service
public class WaitingService {

    //등록
    @Autowired private WaitingDao waitingDao;
    public boolean waitingWrite(WaitingDto waitingDto){
        System.out.println("WaitingService.waitingWrite");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingWrite(waitingDto);
        return result;
    }

    // 전체조회
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingService.waitingPrint");
        List<WaitingDto> result = waitingDao.waitingPrint();
        return  result;
    }

    // 개별조회
    public WaitingDto waitingFind(int wno){
        System.out.println("WaitingService.waitingFind");
        System.out.println("wno = " + wno);
        WaitingDto result = waitingDao.waitingFind(wno);
        return result;
    }

    //삭제
    public boolean waitingDelete(int wno){
        System.out.println("WaitingService.waitingDelete");
        System.out.println("wno = " + wno);
        boolean result = waitingDao.waitingDelete(wno);
        return result;
    }

    //수정
    public boolean waitingUpdate(WaitingDto waitingDto){
        System.out.println("WaitingService.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingUpdate(waitingDto);
        return result;
    }

}//class e
