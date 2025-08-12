package 종합.과제12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 종합.과제12.model.dto.WaitingDto;
import 종합.과제12.service.WaitingService;

import java.util.List;

@RestController
@RequestMapping("/waiting")
public class WaitingController {
    @Autowired private WaitingService waitingService;

    //(1) 등록 기능 구현
    @PostMapping("")
    public boolean waitingWrite(@RequestBody WaitingDto waitingDto){
        System.out.println("WaitingService.waitingWrite");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingWrite(waitingDto);
        return result;
    }

    //(2) 조회 기능 구현
    @GetMapping("")
    public List<WaitingDto> waitingPrint(){
        List<WaitingDto> result = waitingService.waitingPrint();
        return result;
    }

    //(3) 개별조회 기능 구현
    @GetMapping("/find")
    public WaitingDto waitingFind(@RequestParam int wno){
        System.out.println("WaitingController.waitingFind");
        System.out.println("wno = " + wno);
        WaitingDto result = waitingService.waitingFind(wno);
        return result;
    }

    //(4) 삭제 기능 구현
    @DeleteMapping("")
    public boolean waitingDelete(@RequestParam int wno){
        System.out.println("WaitingController.waitingDelete");
        System.out.println("wno = " + wno);
        boolean result = waitingService.waitingDelete(wno);
        return result;
    }

    //(5) 수정 기능 구현
    @PutMapping("")
    public boolean waitingUpdate(@RequestBody WaitingDto waitingDto){
        System.out.println("WaitingController.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingUpdate(waitingDto);
        return result;
    }

}//class e
