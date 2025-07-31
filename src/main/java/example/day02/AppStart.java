package example.day02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }//main e
}//class e


/*
[스프링]
    1. 정의 : 스프링은 자바 기반의 엔터프라이즈 급 애플리케이션 개발을 위한 프레임워크
    2. 활용처 : 전자정부프레임워크(대한민국 개바 표준)
    3. 특징 : IOC/DI(다형성 연관되어있음) 객채의존성, AOP 로직분리 모듈(레고)화, MVC2 3tire 지원, 확장성
[스프링 부트]
    1. 스프링 프레임워크를 빠르게 사용할 수 있도록 자동설정기반의 스타터 프레임워크
    2. 활용처 : 복잡한 설정을 제공 받는다.
    3. 특징 : ( 스프링부트 안에 스프링 포함 )
    4. 웹서버 : 내장 Tomcat 제공한다. Tomcat 이란? 자바 회사에서 만든 웹 관련 라이브러리 포함한 소프트웨어
[ 그레이들 ]
    1. 정의 : 그레이들은 자바 기반의 빌드 자동화 소프트웨어
    2. 특징 : 의존성 관리, 배포, 패키징 을 쉽게 코드 한줄로 자동 처리 해준다.(단 한국 라이브러리 없다)
        dependencies {
            implementation 'org.springframework.boot:spring-boot-starter-web'// 스프링부트 웹 설치
                runtimeOnly 'com.mysql:mysql-connector-j' // MYSQL JDBC 라이브러리 설치

[코드] : 명령어
[라이브러리] : 명령어들을 집합(메소드)해서 .jar 확장자로 만든 집합, 미리 만들어진 코드, 예] 도구 제공
[프레임워크] : 라이브러리 + 개발에 필요한 환경설정 까지, 예] 개발 틀 제공
 */