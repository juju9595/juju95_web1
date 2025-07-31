package example.day02._2REST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller // 해당 클래스에 @Controller 어노테이션 주입
// 1. @Component : Spring 컨테이너(메모리) 에 bean(객체)를 등록한다. <싱글톤 대용>
// 2. Spring Controller 는 기본적으로 HTTP(웹 서블릿) 통신 지원한다.
public class RestController1 {
    // 싱글톤 생략 : @Controller -> @Component 포함되서 자동으로 싱글톤 처럼 하나의 객체를 만들어준다.

    // REST 란 ? CRUD 기능을 HTTP 로 제공하는 아키텍처/기술/구조
    // Spring REST 란? @PostMapping, @GetMapping, @PutMapping, @DeleteMapping 제공하므로 웹기술 제공
    // 1) 등록 : CREATE -> @PostMapping
    @PostMapping
    public void 등록하기(){
        System.out.println("RestController1.등록하기");//soutm자동완성
    }
    @GetMapping // Talend API :
    // 2) 조회 : READ -> @GetMapping
    public void 조회하기(){
        System.out.println("RestController1.조회하기");
    }
    @PutMapping
    // 3) 수정 : UPDATE -> @PutMapping
    public void 수정하기(){
        System.out.println("RestController1.수정하기");
    }
    @DeleteMapping
    // 4) 삭제 : DELETE -> @DeleteMapping
    public void 삭제하기(){
        System.out.println("RestController1.삭제하기");
    }

}//class end
