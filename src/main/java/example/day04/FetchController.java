package example.day04;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


//HTTP(클라이언트)의 요청과 응답 처리 담당
@RestController //@Controller(+Component) + @ResponseBody
public class FetchController {
    // ========================= 1-4
    // 1. HTTP 정의 , METHOD : GET, URL : /day04/exam1
    @GetMapping("/day04/exam1")
    public void method(){
        System.out.println("FetchController.method"); // soutm 매소드명 출력
    }// method end
    // 2. HTTP 정의, METHOD : POST, URL : /day04/exam1
    @PostMapping("/day04/exam2")
    public void method2(){
        System.out.println("FetchController.method2");
    }//method end
    // 3.
    @PutMapping("/day04/exam3")
    public void method3(){
        System.out.println("FetchController.method3");
    }
    // 4.
    @DeleteMapping("/day04/exam4")
    public void method4(){
        System.out.println("FetchController.method4");
    }
    // 5. 매개변수(쿼리스트링) 반환값(JSON)
    @GetMapping("/day04/exam5") // localhost:8080/day04/exam5?name=유재석&age=20
    public boolean method5(@RequestParam String name, @RequestParam int age){
        System.out.println("FetchController.method5");
        System.out.println("name = " + name + ", age = " + age);
        boolean result = true;
        System.out.println("result = " + result); //soutv 가장 가까운 지역변수 출력함수
        return result;
    }
    // 6. 매개변수(HTTP본문) 반환값(JSON)
    @PostMapping("/day04/exam6")
    public int method6(@RequestParam Map<String, String>map){
        System.out.println("FetchController.method6");
        System.out.println("map = " + map);
        int result = 20;
        return result;
    }
    // 7.
    @PutMapping("/day04/exam7")
    public TaskDto method7(@RequestBody TaskDto taskDto){
        System.out.println("FetchController.method7");
        System.out.println("taskDto = " + taskDto);
        TaskDto result = new TaskDto("강호동", 40);
        return result;
    }
    //8.
    @DeleteMapping("/day04/exam8")
    //request : http://localhost:8080/day04/exam8?name=유재석?age=10
    //responese : 200,
    public List<TaskDto> method8(@RequestParam String name, int age){
        System.out.println("FetchController.method8");
        System.out.println("name = " + name + ", age = " + age);
        List<TaskDto> result = new ArrayList<>();//임의값
        result.add(new TaskDto("신동엽", 20));
        result.add(new TaskDto("랄라", 10));
        return result;

    }
} // class end
