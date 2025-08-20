package 종합.평가3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 종합.평가3.model.dto.MoneyDto;
import 종합.평가3.service.MoneyService;

import java.util.ArrayList;

@RestController
@RequestMapping("/money")
public class MoneyController {
    @Autowired private MoneyService moneyService;

    @GetMapping("")
    public ArrayList<MoneyDto> moneyInfo(){
        ArrayList<MoneyDto> result = moneyService.moneyInfo();
        return result;
    }
}
