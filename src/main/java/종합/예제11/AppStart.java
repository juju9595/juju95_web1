package 종합.예제11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        //view 실행하는게 아닌 스프링 실행(부트포함 +@SpringBootApplication) 실행
        //+스프링 실행하면 프로젝트내 resource 폴더의 HTML/CSS/JS 프론트앤드 싹 등록한다.
        SpringApplication.run(AppStart.class);
    }
}
