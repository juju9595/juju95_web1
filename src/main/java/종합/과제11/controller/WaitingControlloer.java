package 종합.과제11.controller;


import org.springframework.web.bind.annotation.*;
import 종합.과제11.model.dao.WaitingDao;
import 종합.과제11.model.dto.WaitingDto;

import java.util.ArrayList;

@RestController//싱글톤
public class WaitingControlloer {

    private WaitingDao waitingDao = WaitingDao.getInstance();

    //(1) 등록 기능 구현
    @PostMapping("/waiting")
    public boolean waitingWrite(@RequestBody WaitingDto waitingDto){
        boolean result = waitingDao.waitingWrite(waitingDto);
        //결과를 view에게 리턴한다.
        return result;
    }

    //(2) 전체 조회 기능 구현
    @GetMapping("/waiting")
    public ArrayList<WaitingDto> waitingPrint(){
        ArrayList<WaitingDto> result = waitingDao.waitingPrint();
        return result;
    }

    //(3) 삭제 기능 구현
    @DeleteMapping("/waiting")
    public boolean waitingDelete(@RequestParam int wno){
        boolean result = waitingDao.waitingDelete(wno);
        return result;
    }


    //(4) 수정 기능 구현
    @PutMapping("/waiting")
    public boolean waitingUpdate(@RequestBody WaitingDto waitingDto){
        //dao에게 삭제할 번호 전달 후 결과를 받는다
        boolean result = waitingDao.waitingUpdate(waitingDto);
        //결과를 view 에게 리턴한다.
        return result;
    }

}
