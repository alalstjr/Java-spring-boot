--------------------
# Spring Boot
--------------------


# 목차

- [1. Spring Boot 란 무엇인가](#Spring-Boot-란-무엇인가)
- [2. SpringBootApplication 역할](#SpringBootApplication-역할)
    - [1. Application 프로젝트 실행 원리](#Application-프로젝트-실행-원리)
    - [2. @ComponentScan](#@ComponentScan)
- [3. 자동 설정 만들기 1부](#자동-설정-만들기-1부)
    - [1. @Configuration 파일 작성](#@Configuration-파일-작성)
    - [2. 배포용 jar 생성](#배포용-jar-생성)
    - [3. 배포용 jar Bean 실행](#배포용-jar-Bean-실행)
- [4. 자동 설정 만들기 2부](#자동-설정-만들기-2부)
    - [1. 프로젝트에 Bean 등록이 중첩될 경우 덮어쓰기 방지](#프로젝트에-Bean-등록이-중첩될-경우-덮어쓰기-방지)
    - [2. @ConditionalOnMissingBean](#@ConditionalOnMissingBean)
    - [3. properties 활용한 Bean 등록없이 값 수정하기](#properties-활용한-Bean-등록없이-값-수정하기)
        - [1. @ConfigurationProperties](#@ConfigurationProperties)
        - [2. @EnableConfigurationProperties](#@EnableConfigurationProperties)
- [5. 내장 웹서버 이해](#내장-웹서버-이해)
    - [1. 톰캣 객체생성 & 포트 설정 & 톰캣에 컨텍스트 생성](#톰캣-객체생성-&-포트-설정-&-톰캣에-컨텍스트-생성)
    - [2. 서블릿 만들기](#서블릿-만들기)
    - [3. Spring Boot 서버 자동설정 동작확인](#Spring-Boot-서버-자동설정-동작확인)
- [6. 내장 웹 서버 응용](#내장-웹-서버-응용)
    - [1. jetty 내장 웹서버 변경](#jetty-내장-웹서버-변경)
    - [2. undertow 내장 웹서버 변경](#undertow-내장-웹서버-변경)
    - [3. 웹서버 사용하지 않기](#웹서버-사용하지-않기)
    - [4. 웹서버 PORT 변경](#웹서버-PORT-변경)
    - [5. Discover the HTTP Port at Runtime](#Discover-the-HTTP-Port-at-Runtime)
    - [6. HTTPS와 HTTP2](#HTTPS와-HTTP2)
    - [7. HTTPS & HTTP 둘다 적용하기](#HTTPS-&-HTTP-둘다-적용하기)
    - [8. HTTP2 연결](#HTTP2-연결)
- [7. 스프링 부트 활용 1](#스프링-부트-활용-1)
    - [1. SpringApplication](#SpringApplication)
    - [2. 배너](#배너)
        - [1. 만약 배너를 사용하지 않으려면](#만약-배너를-사용하지-않으려면)
        - [2. 베너 커스텀마이징](#베너-커스텀마이징)
        - [3. SpringApplicationBuilder로 빌더 패턴 사용 가능](#SpringApplicationBuilder로-빌더-패턴-사용-가능)
- [8. SpringApplication 2부](#SpringApplication-2부)
    - [1. ApplicationEvent 등록](#ApplicationEvent-등록)
    - [2. WebApplicationType 설정](#WebApplicationType-설정)
    - [3. 애플리케이션 아규먼트 사용하기](#애플리케이션-아규먼트-사용하기)
    - [4. 애플리케이션 실행한 뒤 뭔가 실행하고 싶을 때](#애플리케이션-실행한-뒤-뭔가-실행하고-싶을-때)
- [9. 외부 설정 1부](#외부-설정-1부)
    - [1. 프로퍼티 우선 순위](#프로퍼티-우선-순위)
    - [2. Environment](#Environment)
    - [3. Test 에서의 우선 순위 확인](#Test-에서의-우선-순위-확인)
        - [1. @SpringBootTest](#@SpringBootTest)
        - [2. @TestPropertySource](#@TestPropertySource)
    - [4. 중복의 프로퍼티 관리](#중복의-프로퍼티-관리)
    - [5. application.properties 위치](#application.properties-위치)
    - [6. @Value("")](#@Value(""))
    - [7. 프러퍼티 값이 없다면](#프러퍼티-값이-없다면)
- [10. 외부 설정 2부](#외부-설정-2부)
    - [1. 프로퍼티 Bean 등록 방법](#프로퍼티-Bean-등록-방법)
    - [2. 프로퍼티 값 검증](#프로퍼티-값-검증)
- [11. 프로파일](#프로파일)
    - [1. 프로파일용 프로퍼티](#프로파일용-프로퍼티)
    - [2. 프로파일 추가하기](#프로파일-추가하기)
- [12. 로깅](#로깅)
    - [1. 로그 레벨 조정](#로그-레벨-조정)
    - [2. 커스텀 로그 설정파일 사용하기](#커스텀-로그-설정파일-사용하기)
- [13. 테스트](#테스트)
    - [1. MOCK MVC 클라이언트 사용방법](#MOCK-MVC-클라이언트-사용방법)
    - [2. RANDOM_PORT](#RANDOM_PORT)
        - [1. TestRestTemplate](#TestRestTemplate)
        - [2. WebTestClient](#WebTestClient)
    - [3. 슬라이스 테스트](#슬라이스-테스트)
    - [4. 테스트 유틸](#테스트-유틸)
- [14. Spring Boot DevTools](#Spring-Boot-DevTools)
- [15. 스프링 웹 MVC](#스프링-웹-MVC)
    - [1. 스프링 MVC 확장](#스프링-MVC-확장)
    - [2. 스프링 MVC 재정의](#스프링-MVC-재정의)
- [16. mvc-config-message-converters](#mvc-config-message-converters)
- [17. ViewreSolver](#ViewreSolver)
    - [1. XML 컨버터](#XML-컨버터)
- [18. 정적 리소스 지원](#정적-리소스-지원)
    - [1. root 경로 설정하기](#root-경로-설정하기)
    - [2. 리소스 핸들러 커스텀마이징](#리소스-핸들러-커스텀마이징)
- [19. thymeleaf](#thymeleaf)
    - [1. View 정보 가져와 보여주기](#View-정보-가져와-보여주기)
- [20. ExceptionHandler](#ExceptionHandler)
    - [1. Spring MVC 예외처리 방법](#Spring-MVC-예외처리-방법)
    - [2. Spring Boot 예외처리 방법](#Spring-Boot-예외처리-방법)
    - [3. 커스텀 에러 페이지](#커스텀-에러-페이지)
- [21. Spring HATEOAS](#Spring-HATEOAS)
    - [1. HATEOAS 링크 추가](#HATEOAS-링크-추가)
- [22. SOP과 CORS](#SOP과CORS)
- [23. 인메모리 데이터베이스](#인메모리-데이터베이스)
    - [1. H2 콘솔 사용하는 방법](#H2-콘솔-사용하는-방법)

# Spring Boot 란 무엇인가

제품수준의 스프링기반의 독립적인 에플리케이션을 만들때 빠르고 쉽게 만들 수 있다.
기본적으로 가장 많이 쓰이는 설정을 기본적으로 제공해줌으로서 사용자가 직접 설정할 필요가 없도록
(개발에 집중할 수 있도록) Spring Boot 에서 제공을 해줍니다.
제 삼의 라이브러리 또한 기본 설정을 제공해줍니다. 
예제로) 톰켓의 대한 설정을 기본적으로 제공을 해줍니다. (8080 PORT 실행)

사용자가 원하는데로 설정을 쉽고 빠르게 변경하는것도 가능합니다. (중요
XML 설정을 더이상 사용하지 않습니다.
code generator 또한 하지 않습니다.

Spring Boot 프레임 워크는 Java -v 8 이상부터 사용 가능합니다.

# SpringBootApplication 역할

~~~
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
~~~

`@SpringBootApplication 어노테이션`을 선언해주는 곳은 `프로젝트가 실행되길 원하는 패키지의 가정 처음부분에 선언`해 주는것이 기본적이고 좋습니다.
이유는 `@ComponentScan` 을 해주어야 하는데 실행하는 클래스 위치에서 이하의 패키지 모두를 스캐닝 하도록 되어 있으므로 `최상위에 위치하여 모든 곳을 탐색하도록` 하기 위해서 입니다.

## Application 프로젝트 실행 원리

프로젝트 실행시 자동으로 톰켓 8080 설정되어 실행되는 이유는
@SpringBootApplication 어노테이션 내부의 `@EnableAutoConfiguration` 

## @ComponentScan

@Component 어노테이션을 가진 클레스들을 스캔해서 Bean으로 등록해주는 역할

~~~
@ComponentScan(
    excludeFilters = { 
        @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class)
    }
)
~~~
excludeFilters 선언된 값들을 제외한다는 뜻 (Bean 등록을 제외한다는 뜻)

@Component @Configuration @Repository @Service @Controller @RestController

# 자동 설정 만들기 1부

우선 기존의 프로젝트는 나두고 새로운 프로젝트를 하나 생성합니다.
각각 `배포용 프로젝트는 A` 그리고 `메인 프로젝트는 B` 라고 부르겠습니다.

A, B 프로젝트 둘다 Spring Boot 의존성 추가합니다.

- 의존성 추가
- Maven 코드
~~~
<dependencies>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-autoconfigure</artifactId>
  </dependency>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-autoconfigure-processor</artifactId>
      <optional>true</optional>
  </dependency>
</dependencies>

<dependencyManagement>
  <dependencies>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-dependencies</artifactId>
          <version>2.0.3.RELEASE</version>
          <type>pom</type>
          <scope>import</scope>
      </dependency>
  </dependencies>
</dependencyManagement>
~~~

- Gradle 코드
~~~
dependencies {
	compile group: 'org.springframework.boot', name: 'spring-boot-autoconfigure', version: '2.2.2.RELEASE'
	compile group: 'org.springframework.boot', name: 'spring-boot-autoconfigure-processor', version: '2.2.2.RELEASE'
}
~~~

A 프로젝트 클래스 추가

> A.Holoman.class
~~~
public class Holoman {
    private String  name;
    private Integer howLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHowLong() {
        return howLong;
    }

    public void setHowLong(Integer howLong) {
        this.howLong = howLong;
    }

    @Override
    public String toString() {
        return "Holoman{" + "name='" + name + '\'' + ", howLong=" + howLong + '}';
    }
}
~~~

Holoman.class 를 자동설정해주는 파일을 만들기
원래는 이렇게 무언가를 설정하는 대상이 되는 Holoman.class 같은 경우 다른 프로젝트에 있는경우가 흔하다. 
하지만 편의상 지금은 한 프로젝트에 만드는 것

## @Configuration 파일 작성

> A.HolomanConfiguration.class
~~~
@Configuration
public class HolomanConfiguration {
    @Bean
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setHowLong(5);
        holoman.setName("Jjunpro");
        return holoman;
    }
}
~~~

## 배포용 jar 생성

> A.META-INF.spring.factories
~~~
org.springframework.boot.autoconfigure.EnableAutoConfiguration=\
    me.whiteship.HolomanConfiguration
~~~

설정파일을 명식적으로 정의해 주면
`org.springframework.boot.autoconfigure.EnableAutoConfiguration=\` 
Spring Boot Enable AutoConfiguration 작동되고 있으면 키에 해당하는 것을
`com.backend.project.test1.HolomanConfiguration` 코드를 읽습니다.
그렇게 되면 HolomanConfiguration 내부에 있는 Bean 설정을 보고 holoman 메소드를 사용하게 됩니다.

- Maven
다른 프로젝트에서 사용 가능하도록 maven install 실행

- Gradle 
Gradle - build/jar 실행 build/libs/*.jar 파일 생성 확인
기존 프로젝트에 libs 폴더 root 위치에 생성 libs 폴더에 jar 생성파일을 넣습니다.
gradle 의존성에 libs jar 파일을 불러오도록 설정
~~~
dependencies {
	compile fileTree(dir: 'libs', include: ['*.jar'])
}
~~~

## 배포용 jar Bean 실행

{B 프로젝트} 로 돌아옵니다.

> B.Application.class 일부 수정

~~~
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class)
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
~~~

`좀 더 빠르게 작동하도록 WebApplicationType.NONE 설정`
WebApplicationType.NONE 설정을 하므로서 `Spring Boot가 웹으로 실행이 안되도록` 하였습니다.

Holoman Bean 존재여부 파악을 위해서 Class 생성

> B.ApplicationRunner.class

~~~
@Component
public class HolomanRunner implements ApplicationRunner {
    @Autowired
    Holoman holoman;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holoman);
    }
}
~~~

Spring Boot Application 만들어 질때 자동으로 실행이 되는 Bean 을 만들고 싶을때 사용할 수 있습니다.

{B 프로젝트} 에는 어디에도 `Holoman을 Bean으로 등록하지 않았습니다.`
하지만 `AutoWired 선언으로 가져와 사용할 수 있습니다.`

~~~
Holoman{name='JJunpro', howLong=5}

BUILD SUCCESSFUL in 1s
3 actionable tasks: 1 executed, 2 up-to-date
~~~

정상적으로 `{A 프로젝트} 의 Bean 정보를 가져와 출력`합니다.

# 자동 설정 만들기 2부

## 프로젝트에 Bean 등록이 중첩될 경우 덮어쓰기 방지

Spring Boot에서 Bean을 등록할때 두가지 페이스가 존재합니다.
첫번째 `ComponentScan`으로 Bean을 등록하는게 먼저 입니다.
두번째 `AutoConfiguration`으로 Bean을 등록하는 것이 있습니다.

> B.Application.class
~~~
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    @Bean
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setHowLong(60);
        holoman.setName("JJunpro-update");
        return holoman;
    }
}
~~~

하지만 `출력은 {A 프로젝트} 의 holoman` 입니다.
Bean 등록 순서를 보자면 
Main 에서 ComponentScan 으로 {B 프로젝트} holoman 을 Bean으로 등록합니다.
다음 {A 프로젝트} 의 holoman을 AutoConfiguration 으로 덮어 씌웁니다.
그래서 {A 프로젝트} 의 holoman을 출력하게 되는것입니다.
만약 {B 프로젝트} holoman을 bean으로 등록하려면 `ComponentScan을 우선시`하게 해야 합니다.

## @ConditionalOnMissingBean

스프링 부트가 제공하는 여러가지 기능을 커스텀마이징 하는 기본이 되는 방법중 하나입니다.
`Bean으로 등록하려는 매소드가 이미 Bean으로 등록되어 있다면 제외`시킵니다.

> A.HolomanConfiguration.class

~~~
@Configuration
public class HolomanConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Holoman holoman() {
        Holoman holoman = new Holoman();
        holoman.setHowLong(5);
        holoman.setName("JJunpro");
        return holoman;
    }
}
~~~

@ConditionalOnMissingBean 어노테이션을 추가시켜서 `{B 프로젝트} 에 holoman Bean 등록이 되어 있을경우`
`{A 프로젝트} holoman 메소드는 Bean 으로 등록되지 않습니다.`

다시 {A 프로젝트} 를 jar 추출후 {B 프로젝트} 에서 실행하면 결과는

~~~
Holoman{name='JJunpro-update', howLong=60}
~~~

{B 프로젝트} 의 holoman 정보가 출력하는 것을 확인할 수 있습니다.

## properties 활용한 Bean 등록없이 값 수정하기

만약에 {A 프로젝트} 의 holoman 정보를 하나하나 Bean 등록을 해주어야하는가?
간단하게 정보 하나만 바꾸는 경우에도 Bean 등록을 해주어야 하는가?

> B.application.properties

~~~
holoman.name = properties
holoman.how-long = 100
~~~

변경을 원하는 값을 추가합니다.
카멜기법 || 스네이크 기법 상관없이 입력 가능합니다.

properties 를 사용하여 변경하려면 `{A 프로젝트} 에 properties 해당하는 것을 정의`해 줘야 합니다.

### @ConfigurationProperties

> A.HolomanProperties.class

~~~
@ConfigurationProperties("holoman")
public class HolomanProperties {
    private String name;
    private int    howLong;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHowLong() {
        return howLong;
    }

    public void setHowLong(int howLong) {
        this.howLong = howLong;
    }
}
~~~

### @EnableConfigurationProperties

> A.HolomanConfiguration.class 수정

~~~
@Configuration
@EnableConfigurationProperties(HolomanProperties.class)
public class HolomanConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Holoman holoman(HolomanProperties properties) {
        Holoman holoman = new Holoman();
        holoman.setHowLong(properties.getHowLong());
        holoman.setName(properties.getName());
        return holoman;
    }
}
~~~

EnableConfigurationProperties 어노테이션을 활용하여 HolomanProperties 등록 후
HolomanProperties properties holoman 메소드에 주입 받은 후 값을 넣어줍니다.

{B 프로젝트} holoman 메소드 제거 후 실행하면

~~~
Holoman{name='properties', howLong=100}
~~~

properties 값을 가져온것을 확인할 수 있습니다.

# 내장 웹서버 이해

`Spring Boot 자체가 서버가 아니라` 내장 서블릿 컨테이너를 쉽게 사용하도록 `도와주는 툴` 입니다.

의존성 spring boot starter 추가시 내장 톰켓이 추가된것을 확인할 수 있습니다.

~~~
compile group: 'org.springframework.boot', name: 'spring-boot-starter-web', version: '2.2.2.RELEASE'
~~~

Java Code 로 Tomcat을 만들 수 있습니다.

## 톰캣 객체생성 & 포트 설정 & 톰캣에 컨텍스트 생성

~~~
public class Application {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context= tomcat.addContext("/", "/");
        tomcat.start();
    }
}
~~~

## 서블릿 만들기

~~~
public class Application {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        Context context = tomcat.addContext("/", "/");

        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><title>");
                writer.println("Hey, Tomcat");
                writer.println("</title></head>");
                writer.println("<body><h1>Hello Tomcat</h1></body>");
                writer.println("</html>");
            }
        };

        String servletName = "helloServlet";
        tomcat.addServlet("/", servletName, servlet);
        context.addServletMappingDecoded("/hello", servletName);

        tomcat.start();
        tomcat.getServer().await();
    }
}
~~~

context.addServletMappingDecoded("/", servletName);
hello 요청이 오면은 helloServlet 의 servlet를 보여주도록 합니다. 

이렇게 Spring Boot 를 사용하지 않고 내장 Tomcat으로 서버를 가동하는것을 해보았습니다.

## Spring Boot 서버 자동설정 동작확인

> External Libraries > spring-boot-autoconfigration > META-INF > spring.factories

자동 설정 파일들이 존재합니다.
이중에서 처음 볼것은 ServletWebServerFactoryAutoConfiguration

~~~
@ConditionalOnClass(ServletRequest.class)
// ServletRequest.class 존재할 경우 사용
@Import({톰캣, 제티, 언더토우})
// 다른 Configration 사용하는 어노테이션
~~~

이중에서 톰캣을 들어가 확인하겠습니다.

ServletWebServerFactoryConfigration
EmbeddedTomcat
TomcatServletWebServerFactory 실행

TomcatServletWebServerFactory 내부에서 무엇이 일어나는지 확인해보면
Tomcat이 설정되고 만들어지는 과정이 일어나는 것을 확인할 수 있습니다.

이것으로 확인할 수 있는것은 ServletWebServerFactoryAutoConfiguration 클래스는 내장 설정파일을 만드는 것인것을 확인할 수 있습니다.

이 모든 과정을 보다 상세히 또 유연하고 설절하고 실행해주는게 바로 스프링 부트의 자동 설정.

- ServletWebServerFactoryAutoConfiguration (서블릿 웹 서버 생성)
    - TomcatServletWebServerFactoryCustomizer (서버 커스터마이징)
- DispatcherServletAutoConfiguration
    - 서블릿 만들고 등록

서블릿 웹 서버 생성 클래스와 서블릿 만들고 등록하는 클래스가 따로 존재하는 이유는 서블릿 컨테이너는 pom.xml에 따라서 다 달라질 수 있습니다. 
서블릿은 변하지 않습니다. 그래서 둘은 분리 되어 있습니다.

DispatcherServlet 은 내가 어떠한 서블릿 컨테이너를 사용하던 상관없이 만든 후 지금 있는 서블릿 컨테이너에 등록을 하는 과정이 이 안에서 일어납니다.

# 내장 웹 서버 응용

Gradle 의존성 변경

## jetty 내장 웹서버 변경

~~~
dependencies {
    compile group: 'org.springframework.boot', name: 'spring-boot-autoconfigure', version: '2.2.2.RELEASE'
    compile group: 'org.springframework.boot', name: 'spring-boot-autoconfigure-processor', version: '2.2.2.RELEASE'

    compile group: 'org.springframework.boot', name: 'spring-boot-starter-web', version: '2.2.2.RELEASE'
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-jetty', version: '2.2.2.RELEASE'
}

configurations {
    compile.exclude module: 'spring-boot-starter-tomcat'
}
~~~

configurations 으로 tomcat 의존성을 제외 시키고 jetty 의존성을 추가시킵니다.

> /src/main/java/me/whiteship/Application.class

~~~
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
~~~

별 설정없이 Spring Boot Start 해주면 jetty 8080 서버로 정상적으로 연결 실행되는것을 확인할 수 있습니다.

~~~
[main] me.whiteship.Application                 : Starting Application on gimminscBookPro with PID 1255 (started by kimminseok in /Users/kimminseok/Documents/git-repository/Java-spring-boot/내장 웹 서버 응용/project)
[main] me.whiteship.Application                 : No active profile set, falling back to default profiles: default
[main] org.eclipse.jetty.util.log               : Logging initialized @1421ms to org.eclipse.jetty.util.log.Slf4jLog
[main] o.s.b.w.e.j.JettyServletWebServerFactory : Server initialized with port: 8080
[main] org.eclipse.jetty.server.Server          : jetty-9.4.24.v20191120; built: 2019-11-20T21:37:49.771Z; git: 363d5f2df3a8a28de40604320230664b9c793c16; jvm 11.0.5+10-b520.17
[main] o.e.j.s.h.ContextHandler.application     : Initializing Spring embedded WebApplicationContext
[main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 731 ms
[main] org.eclipse.jetty.server.session         : DefaultSessionIdManager workerName=node0
[main] org.eclipse.jetty.server.session         : No SessionScavenger set, using defaults
[main] org.eclipse.jetty.server.session         : node0 Scavenging every 660000ms
[main] o.e.jetty.server.handler.ContextHandler  : Started o.s.b.w.e.j.JettyEmbeddedWebAppContext@351f2244{application,/,[file:///private/var/folders/tw/z0nxsbm95rl8h8gw78mzxh4h0000gn/T/jetty-docbase.10507278183051399048.8080/],AVAILABLE}
[main] org.eclipse.jetty.server.Server          : Started @1633ms
[main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
[main] o.e.j.s.h.ContextHandler.application     : Initializing Spring DispatcherServlet 'dispatcherServlet'
[main] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
[main] o.s.web.servlet.DispatcherServlet        : Completed initialization in 4 ms
[main] o.e.jetty.server.AbstractConnector       : Started ServerConnector@675ffd1d{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
[main] o.s.b.web.embedded.jetty.JettyWebServer  : Jetty started on port(s) 8080 (http/1.1) with context path '/'
[main] me.whiteship.Application                 : Started Application in 1.439 seconds (JVM running for 1.875)
~~~

## undertow 내장 웹서버 변경

~~~
dependencies {
    compile group: 'org.springframework.boot', name: 'spring-boot-autoconfigure', version: '2.2.2.RELEASE'
    compile group: 'org.springframework.boot', name: 'spring-boot-autoconfigure-processor', version: '2.2.2.RELEASE'

    compile group: 'org.springframework.boot', name: 'spring-boot-starter-web', version: '2.2.2.RELEASE'
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-undertow', version: '2.2.2.RELEASE'
}

configurations {
    compile.exclude module: 'spring-boot-starter-tomcat'
}
~~~

undertow 의존성을 추가합니다.

## 웹서버 사용하지 않기

의존성에 기본적으로 웹 관련된 기술이 추가되어 있다면 Spring Boot는 웹 에플리케이션으로 만들려고 시도합니다.

- main run type 설정
Spring Boot Web Starter 를 사용하지 않으려면 main class 의 run type 을 None 으로 설정하는 방법이 있으며

~~~
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }
}
~~~

- application.properties 설정 
application.properties 에서 설정하는 방법도 있습니다.

~~~
spring.main.web-application-type=none
~~~

## 웹서버 PORT 변경

- application.properties 설정

~~~
server.port = 7070
~~~

랜덤 포트로 설정할경우에는 0 으로 해주면 됩니다.

## Discover the HTTP Port at Runtime

런타임시 HTTP 포트 직접 확인하는 방법

[Discover the HTTP Port at Runtime](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-user-a-random-unassigned-http-port)

> src/main/java/me/whiteship/PortListener.class

~~~
@Component
public class PortListener implements ApplicationListener<ServletWebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        // PORT 정보를 알아내는 방법
        // Web Application Context 정보를 가져옵니다.
        ServletWebServerApplicationContext context = event.getApplicationContext();
        int                                result  = context.getWebServer().getPort();

        System.out.println(result);
    }
}
~~~

ServletWebServerInitializedEvent 이벤트는 웹서버가 초기화가 되면 
onApplicationEvent 이벤트 리스너가 호출이 됩니다.

## HTTPS와 HTTP2

[Configure SSL](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-configure-ssl)

[HTTP & SSL](https://opentutorials.org/course/228/4894)

[generate-keystore.sh](https://gist.github.com/keesun/f93f0b83d7232137283450e08a53c4fd)

~~~
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 4000
~~~

파일 keystore.p12 생성 됩니다. 이것으로 셋팅을 시작합니다.

- application.properties 설정

~~~
server.ssl.key-store = keystore.p12
server.ssl.key-store-password = cmd4515
server.ssl.keyStoreType = PKCS12
server.ssl.keyAlias = tomcat
~~~

> curl -I -k --http2 https://localhost:8080

응답 확인하면 정상으로 접근 합니다.

## HTTPS & HTTP 둘다 적용하기

[HTTP 커넥터는 코딩으로 설정하기](https://github.com/spring-projects/spring-boot/tree/v2.0.3.RELEASE/spring-boot-samples/spring-boot-sample-tomcat-multi-connectors)

HTTPS 를 적용하고 나면 HTTP 연결은 자동으로 끈키게 됩니다.
이유는 HTTP 커넥터는 하나만 존재하는데 그곳에 HTTPS 를 적용해서 HTTP 자동으로 끈키게 되는것입니다.
이를 설정하는 방법의 예제

~~~
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8080);
        return connector;
    }
}
~~~

- application.properties 설정 추가

~~~
server.port= 8443
~~~

이제 8080 PORT 접근시 HTTP 접근이 가능하고
8443 PORT 접근시 HTTPS 접근이 가능합니다.
한번에 두개 접근이 가능하도록 하였습니다.

## HTTP2 연결

HTTP2를 사용하려면 SSL 설정은 기본적으로 되어있어야 합니다.

[Configure HTTP/2](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-configure-http2)

- undertow

undertow 경우 HTTP2 설정방법은 간단합니다.

- application.properties 설정

~~~
server.http2.enabled=true
~~~

# 스프링 부트 활용 1

## SpringApplication

기존 Spring Boot 실행 코드

~~~
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
~~~

이렇게 설정하여 살행하게 되면 `Spring Application 에서 제공하는 기능`을 사용하기 어렵습니다.

인스턴스를 만들어서 run 하는 방법으로 사용하도록 합니다.

~~~
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }
}
~~~

## 배너

- [Customizing the Banner](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-banner)

~~~
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.2.RELEASE)
~~~

Spring Boot 실행시 출력되는 배너를 수정할 수 있습니다.

> /resources/banner.txt

~~~
===========================
    JJunpro Test v0.0.0
===========================
~~~

Spring Document 참고하여 기능을 활용하면

> /resources/banner.txt

~~~
===========================
    JJunpro Test ${spring-boot.version}
===========================
~~~

Spring 버전을 출력하도록 할수도 있습니다.

### 만약 배너를 사용하지 않으려면

~~~
app.setBannerMode(Banner.Mode.OFF);
~~~

### 베너 커스텀마이징

~~~
app.setBanner((environment, sourceClass, out) -> {
    out.println("===========");
    out.println("Edit Banner");
    out.println("===========");
});
~~~

베너가 출력되는 순서는 txt 파일 > Code 순으로 txt 파일이 우선순위가 높습니다.

### SpringApplicationBuilder로 빌더 패턴 사용 가능

[Fluent Builder API](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-fluent-builder-api)

~~~
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(Application.class)
                .run(args);
    }
}
~~~

# SpringApplication 2부

[Application Events and Listeners](#https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-application-events-and-listeners)

## ApplicationEvent 등록

Spring Boot 시작 할때 실행되는 이벤트 리스너
ApplicationContext를 만들기 전에 사용하는 리스너는 @Bean으로 등록할 수 없다.

> SampleListener.class

~~~
public class SampleListener implements ApplicationListener<ApplicationStartingEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("=========");
        System.out.println("App ApplicationStartingEvent");
        System.out.println("=========");
    }
}
~~~

SampleListener 이벤트 클래스를 만들어도 Spring Boot 실행시 아무 반응도 일어나지 않습니다.
SampleListener 이벤트를 실행시키려면 이벤트 등록을 해줘야 합니다.

~~~
SpringApplication app = new SpringApplication(Application.class);
app.addListeners(new SampleListener());
app.run(args);
~~~

결과는 Spring Boot 실행시 맨 위에 문구가 출력 됩니다.

Spring Boot 시작된 후 실행되는 이벤트 리스너

~~~
public class SampleListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        System.out.println("=========");
        System.out.println("App ApplicationStartedEvent");
        System.out.println("=========");
    }
}
~~~

결과는 Spring Boot 실행된 후 맨 마지막에 문구가 출력 됩니다.

## WebApplicationType 설정

[Web Environment](#https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-web-environment)

기본적으로 Spring MVC 구조 또는 SERVLET으로 되어있다면 Type은 SERVLET 으로 구동합니다.

WebApplicationType.SERVLET

Spring MVC 그리고 SERVLET 둘다 존재하지 않는다면 REACTIVE 으로 구동됩니다.

WebApplicationType.REACTIVE

## 애플리케이션 아규먼트 사용하기

ApplicationArguments를 빈으로 등록해 주니까 사용하면 됩니다.

~~~
public class SampleListener {
    public SampleListener(ApplicationArguments arguments) {
        System.out.println("foo: " + arguments.containsOption("foo"));
        System.out.println("bar: " + arguments.containsOption("bar"));
    }
}
~~~

클래스 정의 후 EditConfigurations 수정 클릭 후 
VM options : -Dfoo
Program arguments : --bar
값 추가후 run 실행

결과
~~~
foo: false
bar: true
~~~

이것으로 알 수 있는것은 (--) 추가된것만 arguments 로 들어오는 것을 확인할 수 있습니다.

## 애플리케이션 실행한 뒤 뭔가 실행하고 싶을 때

Applicationrunner

~~~
@Component
public class SampleListener implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("foo: " + args.containsOption("foo"));
        System.out.println("bar: " + args.containsOption("bar"));
    }
}
~~~

CommandLineRunner

~~~
@Component
public class SampleListener implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Arrays.stream(args).forEach(System.out::println);
    }
}
~~~

여러개의 Runner 가 존재할경우

@Order 어노테이션으로 순서를 정할 수 있습니다.

# 외부 설정 1부

- properties
- YAML
- 환경 변수
- 커맨드 라인 아규먼트

외부 설정 파일이라는 것은 에플리케이션에서 사용하는 여러가지 설정값 들을 
에플리케이션 외부 혹은 내부에 정의하는 기능입니다.

> application.properties

~~~
jjunpro.name = jjunpro
~~~

스프링 부트가 에플리케이션을 구동할때 자동으로 로딩하는 컴벤션입니다.
기본적으로 key & value 값을 넣어서 사용합니다.

설정된 값을 가져오는 방법

[Externalized Configuration](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config)

## 프러퍼티 값이 없다면

@Value("${server.error.path:${error.path:/error}}")

server.error.path 가 없다면 error.path 를
error.path 도 없다면 /error 를 
사용한다는 프로퍼티 작성방법

## @Value("")

> SampleRunner.class

~~~
@Component
public class SampleRunner implements ApplicationRunner {

    @Value("${jjunpro.name}")
    private String name;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=============");
        System.out.println(name);
        System.out.println("=============");
    }
}
~~~

정상적으로 properties 값을 가져와 출력하는 것을 확인할 수 있습니다.

## 프로퍼티 우선 순위

1. 유저 홈 디렉토리에 있는 spring-boot-dev-tools.properties
2. 테스트에 있는 @TestPropertySource
3. @SpringBootTest 애노테이션의 properties 애트리뷰트
4. 커맨드 라인 아규먼트
5. SPRING_APPLICATION_JSON (환경 변수 또는 시스템 프로티) 에 들어있는 프로퍼티
6. ServletConfig 파라미터
7. ServletContext 파라미터
8. java:comp/env JNDI 애트리뷰트
9. System.getProperties() 자바 시스템 프로퍼티
10. OS 환경 변수
11. RandomValuePropertySource
12. JAR 밖에 있는 특정 프로파일용 application properties
13. JAR 안에 있는 특정 프로파일용 application properties
14. JAR 밖에 있는 application properties
15. JAR 안에 있는 application properties
16. @PropertySource
17. 기본 프로퍼티 (SpringApplication.setDefaultProperties)

프로퍼티 우선 순위 예제를 하나 보자면

java -jar ${JARfile} --jjunpro.name=update

해당 순위는 4 순위 커맨드 라인 아규먼트에 해당되서 값을 오버라이딩 해서 update 출력됩니다. 

## Environment

모든 프로퍼티들은 기본적으로 `environment 통해서 접근`합니다.

~~~
@Component
public class SampleRunner implements ApplicationRunner {
    @Autowired
    Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=============");
        System.out.println(environment.getProperty("jjunpro.name"));
        System.out.println("=============");
    }
}
~~~

## Test 에서의 우선 순위 확인

~~~
testCompile group: 'org.springframework.boot', name: 'spring-boot-starter-test', version: '2.2.3.RELEASE'
~~~

우선 테스트 코드를 작성하기 이전에 Spring Boot Test 의존성을 추가합니다.

> ApplicationTest.class

~~~
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void main() {
        assertThat(environment.getProperty("jjunpro.name"))
            .isEqualTo("jjunpro");
    }
}
~~~

Test 결과를 확인해 보면 15 순위 프로퍼티를 통해서 정상적으로 통과할 것입니다.
 
테스트에서 사용할 수 있는 테스트 용도 프로퍼티스를 바꿔야 하는 경우 Test 모듈에 똑같은 프로퍼티 파일을 생성 후 값을 추가하면
`기존의 프로퍼티는 무시되고 Test 프로퍼티가 오버리아딩 되어 Test 프로퍼티 값이 참조`됩니다.

> /test/application.properties

~~~
jjunpro.name = jjunproTest
~~~

> ApplicationTest.class

~~~
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void main() {
        assertThat(environment.getProperty("jjunpro.name"))
            .isEqualTo("jjunproTest");
    }
}
~~~

하지만 이렇게 두개의 프로퍼티를 사용하게 되면 큰 문제가 발생하게 됩니다.
예를 들어서 기본 프로퍼티에 age 라는 값을 추가합니다.

> application.properties

~~~
jjunpro.name = jjunpro
jjunpro.age = ${random.int}
~~~

프로퍼티 랜덤값 생성 방법 문서

[Configuring Random Values](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-random-values)

일반적으로 application 을 실행하면

~~~
@Component
public class SampleRunner implements ApplicationRunner {

    @Value("${jjunpro.name}")
    private String name;

    @Value("${jjunpro.age}")
    private String age;

    @Autowired
    Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=============");
        System.out.println(name);
        System.out.println(age);
        System.out.println("=============");
    }
}
~~~

age 값을 정상적으로 가져옵니다.
하지만 테스트 코드를 실행하면 오류가 발생합니다.

~~~
java.lang.IllegalArgumentException: Could not resolve placeholder 'jjunpro.age' in value "${jjunpro.age}"
~~~

처음 일반 프로퍼티의 age 값은 존재합니다 하지만 테스트를 빌드할때 테스트의 프로퍼티를 오버라이드 해서
테스트 프로퍼티에는 age 값이 존재하지 않아 오류가 발생하는것 
SampleRunner 에서는 age 값을 참조하려고 하지만 테스트 프로퍼티에는 age 값이 존재하지 않아 발생하는 오류 
오류를 해결하려면 테스트 프로퍼티에도 age값을 추가해주면 해결됩니다. 

### @SpringBootTest 

 ~~~
@RunWith(SpringRunner.class)
@SpringBootTest(properties = "jjunpro.name=jjunproUpdate")
public class ApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void main() {
        assertThat(environment.getProperty("jjunpro.name"))
            .isEqualTo("jjunproUpdate");
    }
}
 ~~~

 @SpringBootTest 어노테이션의 프로퍼티 설정이 3순위 이기때문에 테스트가 jjunproUpdate 값으로
 통과되는것을 확인할 수 있습니다.

 ### @TestPropertySource

 ~~~
 @TestPropertySource(properties = "jjunpro.name=jjunproUpdate")
 ~~~

 @SpringBootTest 값이 아닌 별도로 프로퍼티를 주고싶다면 2 순위 @TestPropertySource 으로 직접 주는방법

## 중복의 프로퍼티 관리

프로퍼티를 파일로 관리하면 중복의 프로퍼티를 사용 가능합니다.

> test.properties

~~~
jjunpro.name = jjunproNew
jjunpro.age = ${random.int}
~~~

> /test/ApplicationTest.class

~~~
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:/test.properties")
@SpringBootTest
public class ApplicationTest {

    @Autowired
    Environment environment;

    @Test
    public void main() {
        assertThat(environment.getProperty("jjunpro.name"))
            .isEqualTo("jjunproNew");
    }
}
~~~

정상적으로 application.properties 그리고 test.properties 둘다 불러옵니다.

## application.properties 위치

[Application Property Files](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config-application-property-files)

application.properties 우선 순위 (높은게 낮은걸 덮어 씁니다.)

1. file:./config/
2. file:./
3. classpath:/config/
4. classpath:/

4곳에 존재할 수 있습니다. 

# 외부 설정 2부

## 프로퍼티 Bean 등록 방법

같은키로 시작되는 외부설정을 Bean으로 등록하여 사용하는방법

> application.properties

~~~
jjunpro.name = jjunpro
jjunpro.age = ${random.int(0,100)}
jjunpro.fullName = ${jjunpro.name} pow 
~~~

> JjunproProperties.class

~~~
@ConfigurationProperties("jjunpro")
public class JjunproProperties {
    private String name;
    private int age;
    private String fullName;

    // Getter, Setter
~~~

@ConfigurationProperties 값을 바인딩 해줄수 있도록 설정해주는 어노테이션
바인딩한 값을 Bean으로 등록해주도록 도와주는 어노테이션 @EnableConfigurationProperties

> Application.class

~~~
@SpringBootApplication
@EnableConfigurationProperties(JjunproProperties.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }
}
~~~

`하지만 Spring 에서는 자동으로 EnableConfigurationProperties 등록`이 되어있으므로 
JjunproProperties.class에 Bean 등록 `@Component 어노테이션만 작성하면 등록`이 됩니다.

## 프로퍼티 값 검증

[ConfigurationProperties Validation](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config-validation)

@Validated 어노베이션으로 값 검증을 실시합니다.

~~~
@Component
@ConfigurationProperties("jjunpro")
@Validated
public class JjunproProperties {
    @NotEmpty
    private String name;

    ...
}
~~~

name 값이 비어있지 않아야 한다고 선언하고 프로퍼티 name 값을 빈값으로 실행하면

~~~
Property: jjunpro.name
Value: 
Origin: class path resource [application.properties]:2:0
Reason: 반드시 값이 존재하고 길이 혹은 크기가 0보다 커야 합니다.
~~~

다음과 같은 경고문이 발생합니다. 검증 성공 

# 프로파일

@Profile 애노테이션은 어디에?
어떤 특정한 프로파일에서만 특정한 빈을 등록하고 싶을때 사용하는 어노테이션

간단한 예제

> /config/BaseConfiguration.class

~~~
@Profile("prod")
@Configuration
public class BaseConfiguration {
    @Bean
    public String hello() {
        return "hello";
    }
}
~~~

@Configuration 빈을 등록하여 설정 후 Bean 을 사용할 수 있습니다.

hello Bean 을 등록합니다.
TestConfiguration.class 에도 hello를 Bean 으로 등록합니다. 

@Profile("prod") 설정하므로서
해당 Bean 설정 파일 자체가 prod 라는 설정파일 일때만 사용이 됩니다.

> /config/TestConfiguration.class

~~~
@Profile("test")
@Configuration
public class TestConfiguration {
    @Bean
    public String hello() {
        return "helloTest";
    }
}
~~~

> SampleRunner.class

~~~
@Component
public class SampleRunner implements ApplicationRunner {

    // 프로파일 설정 Bean
    @Autowired
    private String hello;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=============");
        System.out.println(hello);
        System.out.println("=============");
    }
}
~~~

hello Bean 을 찾을 수 가 없어서 에러가 발생합니다.

~~~
Field hello in me.whiteship.SampleRunner required a bean of type 'java.lang.String' that could not be found.
~~~

프로파일을 활성화 해주기 위해서 
활설화 하는 프로파일에 설정을 할  수 있습니다.

> application.propertices

~~~
spring.profiles.active = prod
~~~

실행하면 hello Bean 을 정상적으로 가져오는것을 확인할 수 있습니다. 

이번엔 prod 를 test 로 변경하여 실행한다면?

~~~
spring.profiles.active = test
~~~

test 로 설정된 Bean 을 가져와 실행합니다.

## 프로파일용 프로퍼티

application-{profile}.properties

> application-prod.properties

~~~
jjunpro.name = "jjunpro prod"
~~~

> application-test.properties

~~~
jjunpro.name = "jjunpro test"
~~~

> SampleRunner.class

~~~
@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    JjunproProperties jjunproProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=============");
        System.out.println(jjunproProperties.getName());
        System.out.println("=============");
    }
}
~~~

실행해 보면 결과

~~~
=============
"jjunpro prod"
=============
~~~

이런 프로파일 관련된 프로퍼티가 기본 application.propertices 보다 우선순위가 높습니다.
 
## 프로파일 추가하기

spring.profiles.include

여러개의 프로퍼티 파일을 불러오는 설정입니다.

application-update.properties 파일이 존재한다면 해당 프로퍼티를 불러와 사용하는것

~~~
spring.profiles.include = update
~~~

java --jar 패키징으로 실행하는 방법으로는 web, docker 등등 배포할때 사용하며

Program arguments : --sp ring.profiles.active=prod 설정하는식으로는 개발용으로 사용합니다.
설정하여 실행하면 pord 프로퍼티를 실행하게 됩니다.

# 로깅

[Logging](https://docs.spring.io/spring/docs/5.0.0.RC3/spring-framework-reference/overview.html#overview-logging)

[Logging-Spring-Boot](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logging)

- 로깅 퍼사드 VS 로거
- Commons Logging, SLF4j
- JUL, Log4J2, Logback

출력된 로그의 역할

~~~
2020-01-22 17:18:35.730          -> 날짜
INFO                             -> 로그 레벨
912                              -> PID
--- [           main]            -> 쓰레드 이름
com.backend.project.Application: -> 패키지 경로 & 풀패키지 경로 & 클래스 이름
Starting App ...                 -> 상태 정보
~~~

- 스프링 부트 로깅
    - 기본 포맷
    - -debug (일부 핵심 라이브러리만 디버깅 모드로)
    - --trace (전부 다 디버깅 모드로)
    - 컬러 출력: spring.output.ansi.enabled =ㅇ always
    - 파일 출력: logging.file 또는 logging.path
        - logging.file 로그의 파일을 설정
        - logging.path 로그의 경로를 설정
    - 로그 레벨 조정: logging.level.패지키 = 로그 레벨

## 로그 레벨 조정

Spring Poroject 모든 Debug 정보를 출력

~~~
logging.level.org.springframework = debug
~~~

나의 프로젝트 Debug 정보를 출력하는 코드

> SampleRunner.class

~~~
@Component
public class SampleRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(SampleRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("=============");
        logger.debug("My Project Log");
        logger.debug("=============");
    }
}
~~~

~~~
logging.level.me.whiteship = debug
~~~

출력 결과

~~~
2020-01-23 00:54:32.659 DEBUG 1257 --- [           main] me.whiteship.SampleRunner                : =============
2020-01-23 00:54:32.659 DEBUG 1257 --- [           main] me.whiteship.SampleRunner                : My Project Log
2020-01-23 00:54:32.659 DEBUG 1257 --- [           main] me.whiteship.SampleRunner                : =============
~~~

## 커스텀 로그 설정파일 사용하기

[Logback Extensions](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-logback-extensions)
[Configure Logback for Logging](https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-data-access)

이런 설정들을 더 많이 컨트롤 하고싶다면 `로그 설정파일을 추가`하면 됩니다.
`logback-spring.xml` 파일을 추가합니다.
Spring Boot에서 추가 기능을 제공해 줍니다.

- Logback: logback-spring.xml
- Log4J2: log4j2-spring.xml
- JUL (비추): logging.properties

> logback-spring.xml

~~~
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
    <include resource="org/springframework/boot/logging/logback/console-appender.xml" />
    <root level="INFO">
        <appender-ref ref="CONSOLE" />
    </root>
    <logger name="me.whiteship" level="DEBUG"/>
</configuration>
~~~

결과는 위 프로퍼티로 설정한 로그 레벨하고 같은 결과가 나옵니다.
다만 다른부분은 로그 컨트롤하는 부분이 더 넓어졌습니다.

- Logback extension
    - 프로파일 <springProfile name=”프로파일”>
    - Environment 프로퍼티 <springProperty>

[Profile-specific Configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#profile-specific-configuration)

특정한 프로파일인 경우에만 실행하는 로그

# 테스트

테스트 코드를 작성하기 이전에 의존성을 하나 추가합니다.

~~~
testCompile group: 'org.springframework.boot', name: 'spring-boot-starter-test', version: '2.2.3.RELEASE'
~~~

> /sample/SampleController.class

~~~
@RestController
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/hello")
    public String hello() {
        return "hello" + sampleService.getName();
    }
}
~~~

>/sample/SampleService.class

~~~
@Service
public class SampleService {

    public String getName() {
        return "jjunpro";
    }
}
~~~

SampleController.class 의 테스트 코드를 만들어 줍니다.

~~~
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
~~~

@SpringBootTest 어노테이션의 기본값은 MOCK(모조품) 으로 잡혀있습니다.
서블릿 컨테이너를 테스트용으로 뛰우지 않고 모조품을 만들어서 뛰웁니다. 
그래서 서블릿의 모조품이 나옵니다. 
해당 모조품 서블릿에 테스트를 하려면 MOCK MVC 클라이언트를 사용해야 합니다.

## MOCK MVC 클라이언트 사용방법

테스트 클래스에 @AutoConfigureMockMvc 어노테이션을 추가한 후 MockMvc Bean으로 가져옵니다.

~~~
@Autowired
MockMvc mockMvc;
~~~

> SampleControllerTest.class

~~~
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class SampleControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
                // url 접속
        mockMvc.perform(get("/hello"))                  
                // url 접속 상태가 200 인지 체크
                .andExpect(status().isOk())             
                // url content 정보가 작성한 정보와 맞는지 확인
                .andExpect(content().string("hellojjunpro"))
                // 결과를 출력하는 메소드
                .andDo(print());
    }
}
~~~

출력 결과

~~~
MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /hello
       Parameters = {}
          Headers = []
             Body = null
    Session Attrs = {}

Handler:
             Type = me.whiteship.sample.SampleController
           Method = me.whiteship.sample.SampleController#hello()

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = null
             View = null
            Model = null

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"text/plain;charset=UTF-8", Content-Length:"12"]
     Content type = text/plain;charset=UTF-8
             Body = hellojjunpro
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
2020-01-23 02:40:31.086  INFO 2586 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
BUILD SUCCESSFUL in 2s
4 actionable tasks: 3 executed, 1 up-to-date
2:40:31 오전: Tasks execution finished ':cleanTest :test --tests "me.whiteship.sample.SampleControllerTest"'.
~~~

## RANDOM_PORT

RANDOM_PORT 사용시 실제로 서블릿 내장톰캣이 작동합니다.
MOCK MVC를 사용하는것이 아니라 
테스트용 REST 템플릿이나 테스트용 웹 클라이언트를 사용해야 합니다.

### TestRestTemplate

~~~
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void hello() throws Exception {
        String result = testRestTemplate.getForObject(
                "/hello",
                String.class
        );
        // url 작성 후 원하는 Body 타입을 적어주면 결과값이 나옵니다.

        assertThat(result).isEqualTo("hellojjunpro");
    }
}
~~~

실제로 랜덤 포트로 서버가 실행되어 내장 서버로 요청을 보내고 응답을 받은것입니다. 

여기서 문제는 `테스트의 범위가 크다`는 것입니다.
Test는 Service까지 테스트가 접근하는데 개발자는 `Service는 제외하고 Controller만 테스트하고싶다면?`
MockBean을 활용하여 이 연관관계에 있는 SampleService 에 관한것을 mockSampleService 라고 만들면 
application context 안에 들어있는 SampleSampleService Bean을 해당 테스트 코드에서 만든 MOCK Bean으로 교체합니다. 그래서 MockSampleService를 사용하게 됩니다.

결론 `SampleController가 사용하는 SampleService의 모조품을 만들어서 Mock Bean으로 교체`한것입니다.

~~~
    ...

    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("MockJJunpro");

        String result = testRestTemplate.getForObject(
                "/hello",
                String.class
        );
        // url 작성 후 원하는 Body 타입을 적어주면 결과값이 나옵니다.

        assertThat(result).isEqualTo("helloMockJJunpro");
    }
}
~~~

### WebTestClient

Java 5 새로 추가된 웹 플럭스 REST 클라이언트 중 하나
기존에 사용하는 웹 클라이언트는 `동기(synchronous)` 요청 하나보내고 끝날때까지 기다린 후 다음 요청을 보내는 방식
WebTestClient 는 `비동기(asynchronous)` 이벤트가 요청이오면 콜백을 바로 보낼 수 있습니다.

사용하기 이전에 의존성을 추가합니다.
spring-boot-starter-webflux

~~~
compile group: 'org.springframework.boot', name: 'spring-boot-starter-webflux', version: '2.2.3.RELEASE'
~~~

> SampleControllerTest.class

~~~
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SampleControllerTest {
    @Autowired
    WebTestClient webTestClient;

    @MockBean
    SampleService mockSampleService;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("MockJJunpro");

        webTestClient.get()
                .uri("/hello")                  // Req 요청을 만들어서
                .exchange()                     // 보냅니다.
                .expectStatus()                 // 연결상태를 체크합니다
                .isOk()                         // 연결상태가 200일경우
                .expectBody(String.class)       // Body Type
                .isEqualTo("helloMockJJunpro");
    }
}
~~~

## 슬라이스 테스트

- 레이어 별로 잘라서 테스트하고 싶을 때
    - @JsonTest
        - 우리가 가지고 있는 모댈이 JSON으로 나갈때 어떤 형태로 나가는지 테스트 할 수 있는 어노테이션

딱 컨트롤러 하나만 테스트하는 경우

[Auto-configured Spring MVC Tests](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-testing-spring-boot-applications-testing-autoconfigured-mvc-tests)

~~~
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("MockJJunpro");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("helloMockJJunpro"));
    }
}
~~~

@WebMvcTest(SampleController.class) 등록으로 Service 는 따로 등록이 안됩니다.

~~~
@Controller, @ControllerAdvice, @JsonComponent, Converter, GenericConverter, Filter, HandlerInterceptor, WebMvcConfigurer, and HandlerMethodArgumentResolver. Regular @Component
~~~

만 Bean으로 등록이 되며 웹 계층 밑의 Bean들은 의존성이 제외가 됩니다.
만약에 사용하는 의존성이 있다면 Mock(모조품)을 등록해서 사용해야 합니다.

## 테스트 유틸

OutputCaptureRule 활용하여 특정 로그 메시지가 출력이 되는지 테스트 코드로 확인하고 싶을 때 유용하게 쓸 수 있습니다.

~~~
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @MockBean
    SampleService mockSampleService;

    @Autowired
    MockMvc mockMvc;

    @Rule
    public OutputCaptureRule outputCaptureRule = new OutputCaptureRule();

    @Test
    public void hello() throws Exception {
        when(mockSampleService.getName()).thenReturn("MockJJunpro");

        mockMvc.perform(get("/hello"))
                .andExpect(content().string("helloMockJJunpro"));

        assertThat(outputCaptureRule.toString()).contains("holoman")
                .contains("skip");
    }
}
~~~

# Spring Boot DevTools

Spring Boot가 제공하는 옵셔널한 툴

* 신뢰도가 많이 떨어지는 의존성이라 사용을 권하지는 않음 그냥 존재가 있다는것만 인식

사용하기 이전에 의존성을 추가해야 합니다.

~~~
compile group: 'org.springframework.boot', name: 'spring-boot-devtools', version: '2.2.2.RELEASE'
~~~

[Property Defaults](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

위 문서의 git 주소로 들어가면

~~~
properties.put("spring.thymeleaf.cache", "false");
properties.put("spring.freemarker.cache", "false");
properties.put("spring.groovy.template.cache", "false");
properties.put("spring.mustache.cache", "false");
properties.put("server.servlet.session.persistent", "true");
properties.put("spring.h2.console.enabled", "true");
properties.put("spring.resources.cache.period", "0");
properties.put("spring.resources.chain.cache", "false");
properties.put("spring.template.provider.cache", "false");
properties.put("spring.mvc.log-resolved-exception", "true");
properties.put("server.error.include-stacktrace", "ALWAYS");
properties.put("server.servlet.jsp.init-parameters.development", "true");
properties.put("spring.reactor.debug", "true");
~~~

위 설정들이 바뀌게 됩니다.
캐시 설정을 개발 환경에 맞게 변경.

- 클래스패스에 있는 파일이 변경 될 때마다 자동으로 재시작.
- 직접 껐다 켜는거 (cold starts)보다 빠른다. 왜?
(Automatic Restart)[https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-devtools-restart]
클래스 `로더를 두개 사용`합니다.
하나는 `베이스 클래스 로더` 라이브 러리들 개발자가 바꾸지 않는 의존성을 불러들이는 클래스들
개발자의 에플리케이션을 읽어 들이는 `restart classloader`

- 릴로딩 보다는 느리다. (JRebel 같은건 아님)
- 리스타트 하고 싶지 않은 리소스는? spring.devtools.restart.exclude
- 리스타트 기능 끄려면? spring.devtools.restart.enabled = false

# 스프링 웹 MVC

[스프링 웹 MVC](https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/web.html#spring-web)

스프링 웹 MVC 기능을 아무런 설정파일을 작성하지 않아도 개발을 바로 시작할 수 있습니다. 
스프링 부트에서 제공해주는 기본 설정 때문에 가능한 일입니다.

> /External Libraries/spring-boot-autoconfigure/META-INF/spring.factories

내부에서 자동설정을 해주기 때문입니다.

## 스프링 MVC 확장

@Configuration + WebMvcConfigurer

추가적인 설정을 하고 싶다면

> WebConfig.class

~~~
@Configuration
public class WebConfig implements WebMvcConfigurer {
}
~~~

## 스프링 MVC 재정의

@Configuration + @EnableWebMvc

@EnableWebMvc 어노테이션이 붙는 순간 기본 스프링부트의 설정은 사라지고 개발자 본인이 다시 설정을 해줘야 합니다. 

# mvc-config-message-converters

HTTP 요청 본문으로 들어오는 것을 객체로 변환하거나 객체를 HTTP 응답 본문으로 변경할때 사용

어떤 데이터가 요청의 본문에 데이터가 들어있는 상태로 들어오는 데이터를 객체로 받고싶을때 사용
@RequestBody User user

~~~
@RestController
public class UserController {
    @PostMapping("/user")
    @ResponseBody
    public User create(
            @RequestBody User user
    ) {
        return null;
    }
}
~~~

JSON 요청이고 JSON 본문이 들어왔다면 JSON 메세지 컨버터가 사용이 되서 
JSON 메세지를 USER 라는 객체로 컨버팅을 해줍니다.

USER 타입의 객체를 리턴할때 HTTP 자체는 문자이기 때문에 USER 객체 자체를 리턴할 수는 없습니다.
그래서 USER를 변환을 해야합니다. 
기본적으로는 JSON 메세지 컨버터를 사용해서 변환합니다.

만약 String, int 타입일 경우에는 String 메세지 컨버터가 사용됩니다.

또 한가지 

@RestController 어노테이션이 붙어 있다면 @ResponseBody 을 생략을 해도 됩니다.

~~~
...
    @PostMapping("/user")
    public User create(
            @RequestBody User user
    ) {
        return null;
    }
...
~~~

간단 예제

> User.class

~~~
public class User {
    private String username;
    private String password;

    Getter && Setter
}
~~~

> UserController.class

~~~
@RestController
public class UserController {
    @PostMapping("/users/create")
    public User create(
            @RequestBody
                    User user
    ) {
        return user;
    }
}
~~~

> UserControllerTest.class

~~~
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"jjunpro\", \"password\":\"1234\"}";

        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)    // contentType는 JSON 타입
                .accept(MediaType.APPLICATION_JSON)         // 응답은 JSON 타입
                .content(userJson))                         // 응답 본문으로는 Json 내용을 넣습니다.
                .andExpect(status().isOk())                 // 응답 결과를 확인 후
                .andExpect(jsonPath(                        // 응답 결과에 JSON이 맞는지 체크합니다.
                        "$.username",
                        is(equalTo("jjunpro"))
                ))
                .andExpect(jsonPath(
                        "$.password",
                        is(equalTo("1234"))
                ))
                .andDo(print());
    }
}
~~~

결과

~~~
MockHttpServletRequest:
      HTTP Method = POST
      Request URI = /users/create
       Parameters = {}
          Headers = [Content-Type:"application/json", Accept:"application/json", Content-Length:"41"]
             Body = <no character encoding set>
    Session Attrs = {}

Handler:
             Type = me.whiteship.memospringmvc.user.UserController
           Method = me.whiteship.memospringmvc.user.UserController#create(User)

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = null
             View = null
            Model = null

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"application/json"]
     Content type = application/json
             Body = {"username":"jjunpro","password":"1234"}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
~~~

# ViewreSolver

[Spring MVC Auto-configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-spring-mvc-auto-configuration)

들어오는 요청에 Accept Head 에 따라서 응답이 달라집니다.
Accept Head 라는것은 클라이언트가 어떠한 타입의 응답을 원한다 라고 서버에 알리는 것
Accept Head 에따라서 응답이 달라질 수 도 있습니다.
사용자가 어떠한 Veiw 정보를 원하는지 판단하는 정보는 Accept Head 입니다.

물론 Accept Head를 제공하지 않는 요청도 존재합니다.
Accept Head가 존재하지 않는경우에는 format 파라미터로 받을 수 있습니다.
{?format=pdf}

## XML 컨버터

요청은 JSON으로 보내고 응답은 XML로 받아보는 예제

~~~
...
@Test
public void createUser_XML() throws Exception {
    String userJson = "{\"username\":\"jjunpro\", \"password\":\"1234\"}";

    mockMvc
            .perform(post("/users/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_XML)
                    .content(userJson))
            .andExpect(status().isOk())
            .andExpect(xpath("/User/username").string("jjunpro"))
            .andExpect(xpath("/User/password").string("1234"))
            .andDo(print());
}
...
~~~

406 에러가 발생합니다.

~~~
Resolved Exception: Type = org.springframework.web.HttpMediaTypeNotAcceptableException
~~~

미디어 타입을 처리하는 HTTP메세지 컨버터가 존재하지 않을경우 발생하는 오류입니다.

> HttpMessageConvertersAutoConfiguration.class

HTTP 컨버터를 자동 설정해주는 클레스입니다.

import 중에서 {JacksonHttpMessageConvertersConfiguration.class} 내부를 들어가보면
{MappingJackson2XmlHttpMessageConverterConfiguration.class} 를 불러오는 조건을 확인합니다.
@ConditionalOnClass(XmlMapper.class) 는 XmlMapper.class 존재할 경우에만 불러온다고 조건이 있습니다.
그러므로 XML 컨버터를 사용하려면 XmlMapper.class 의존성을 추가해야 합니다.

~~~
compile group: 'com.fasterxml.jackson.dataformat', name: 'jackson-dataformat-xml', version: '2.10.1'
~~~

다시 테스트를 실행하면 정상적으로 통과가 됩니다.

~~~
MockHttpServletRequest:
      HTTP Method = POST
      Request URI = /users/create
       Parameters = {}
          Headers = [Content-Type:"application/json", Accept:"application/xml", Content-Length:"41"]
             Body = <no character encoding set>
    Session Attrs = {}

Handler:
             Type = me.whiteship.memospringmvc.user.UserController
           Method = me.whiteship.memospringmvc.user.UserController#create(User)

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = null
             View = null
            Model = null

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"application/xml;charset=UTF-8"]
     Content type = application/xml;charset=UTF-8
             Body = <User><username>jjunpro</username><password>1234</password></User>
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
BUILD SUCCESSFUL in 7s
~~~

# 정적 리소스 지원

클라이언트에서 요청이 들어왔을 때 그거에 해당하는 리소스가 이미 만들어 져 있는경우 
해당 리소스를 그대로 보내주는 경우

- 기본 리소스 위치
    - classpath:/static
    - classpath:/public
    - classpath:/resources/
    - classpath:/META-INF/resources
    - 예) “/hello.html” => /static/hello.html
    - spring.mvc.static-path-pattern: 맵핑 설정 변경 가능
    - spring.mvc.static-locations: 리소스 찾을 위치 변경 가능

> /resources/static/hello.html

~~~
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    Hello HTML~!
</body>
</html>
~~~

서버 실행 후 크롬 개발자/Network/hello.html 상태를 확인합니다.

~~~
Status Code: 200 

Response Headers
Last-Modified: Fri, 24 Jan 2020 16:56:08 GMT

Request Headers
If-Modified-Since: Fri, 24 Jan 2020 16:56:08 GMT
~~~

If-Modified-Since: 해당 날짜 이후에 바꼇다면 새로 요청을 합니다.
Last-Modified: If-Modified-Since 이후에 새로운 변경 요청이 들어왔으므로 새로운 값을 가져옵니다.

다시 새로고침을 합니다.

~~~
Status Code: 304 

Response Headers
Last-Modified: Fri, 24 Jan 2020 16:56:08 GMT

Request Headers
If-Modified-Since: Fri, 24 Jan 2020 16:56:08 GMT
~~~

서버에서는 Last-Modified 데이터가 변화된것이 없으므로 304가 표시됩니다.
해당 리소스를 다시 보내는것이 아니므로 응답이 더욱 빨라집니다. 

## root 경로 설정하기

- 정적 리소스 맵핑 “/**”

> application.properties

~~~
spring.mvc.static-path-pattern = /static/**
~~~

## 리소스 핸들러 커스텀마이징

> WebConfig.class

addRersourceHandlers 메소드를 활용하여 추가합니다.
기존에 제공하는 리소스 핸들러는 대로 유지하면서 개발자가 원하는 리소스 핸들러만 따로 추가할 수 있습니다.

~~~
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**") 
                // mobile 이라는 요청이 들어 온다면
                .addResourceLocations("classpath:/mobile/")     
                // classpath:map 디렉토리 밑에서 제공을 하겠다.
                .setCachePeriod(20);                            
                // 만드시 classpath는 / 으로 끝나야 합니다.
    }
}
~~~

/mobile/hello.html 파일을 만든 후 서버 실행하여 접근하면 정상 로딩이 됩니다.

# 웹 JAR

웹 JAR 란?
흔히 볼수있는 ReactJS, 제이쿼리, 자바스크립트 등등을 JAR로 만들 수 있습니다.

예제
제이쿼리 의존성을 추가한 후

~~~
compile group: 'org.webjars.bower', name: 'jquery', version: '3.4.1'
~~~

> hello.html

~~~
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    Hello HTML~!
    <script src="/webjars/jquery/3.4.1/dist/jquery.min.js"></script>
    <script>
        $(function(){
            alert("start");
        });
    </script>
</body>
</html>
~~~

해당 webjars 위치 탐색 후 경로를 작성하면 실행 됩니다.

버전 생략하고 사용하려면 webjars-locator-core 의존성 추가

# index 페이지와 파비콘

- 웰컴 페이지
    - index.html 찾아 보고 있으면 제공.
    - index.템플릿 찾아 보고 있으면 제공.
    - 둘 다 없으면 에러 페이지.

일반적으로 spring boot run 실행 후 root 링크로 들어가면 보여지는 Error Page 상태를 
index링크로 연결 시켜주는 행동

1. 정적페이지로 보여주는 방법

> /resources/static/index.html

이제 error 표시가 아닌 Index.html 바로 접근하는것을 확인할 수 있습니다.

파비콘 아이콘 동일하게 resources 폴더 내부 아무곳에 넣으면 표시됩니다.

# thymeleaf

- 스프링 부트가 자동 설정을 지원하는 템플릿 엔진
    - FreeMarker
    - Groovy
    - Thymeleaf
    - Mustache

- JSP를 권장하지 않는 이유
    - JAR 패키징 할 때는 동작하지 않고, WAR 패키징 해야 함.
    - Undertow는 JSP를 지원하지 않음.
    - https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-jsp-limitations

의존성을 추가합니다.

~~~
compile group: 'org.springframework.boot', name: 'spring-boot-starter-thymeleaf', version: '2.2.2.RELEASE'
~~~

동적으로 생성되는 View 들은 src/main/resources/templates 위치에서 찾게 됩니다.

Test Code 작성

> SampleControllerTest.class

~~~
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        // 요청 "/hello"
        // 응답
        // - 모델 name : jjunpro
        // - 뷰  이름  : jjunpro

        mockMvc
                .perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("name", "jjunpro"))
                .andDo(print());
    }
}
~~~

> SampleController.class

~~~
@Controller
public class SampleController {

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "jjunpro");

        return "hello";
    }
}
~~~

@RestController 가 아니기 때문에 
더이상 응답의 본문의 내용이 return 값이 아닙니다.
화면에 전달해야 하는 Model 데이터 정보들 간단하게 map 이라 생각하고 정보를
담으면 됩니다.

> /src/main/resources/templates/hello.html

파일을 하나 생성 후 테스트를 실행합니다.

~~~
MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /hello
       Parameters = {}
          Headers = []
             Body = <no character encoding set>
    Session Attrs = {}

Handler:
             Type = me.whiteship.SampleController
           Method = me.whiteship.SampleController#hello(Model)

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = hello
             View = null
        Attribute = name
            value = jjunpro

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Language:"en", Content-Type:"text/html;charset=UTF-8"]
     Content type = text/html;charset=UTF-8
             Body = <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

</body>
</html>
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
BUILD SUCCESSFUL in 7s
~~~

- Thymeleaf 사용하기
    - https://www.thymeleaf.org/
    - https://www.thymeleaf.org/doc/articles/standarddialect5minutes.html
    - 의존성 추가: spring-boot-starter-thymeleaf
    - 템플릿 파일 위치: /src/main/resources/template/
    - 예제: https://github.com/thymeleaf/thymeleafexamples-stsm/blob/3.0-master/src/main/webapp/WEB-INF/templates/seedstartermng.html

## View 정보 가져와 보여주기

생성한 탬플릿 html 파일

~~~
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1 th:text="${name}">NONE DATA</h1>
</body>
</html>
~~~

만약 name 값이 전달되어 오지않으면 NONE DATA를 출력합니다.

Content 내용에 name 값이 정상 출력되는지 테스트 합니다.

> SampleControllerTest.class

~~~
...
    mockMvc
            .perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(view().name("hello"))
            .andExpect(model().attribute("name", "jjunpro"))
            .andExpect(content().string(containsString("jjunpro")))
            .andDo(print());
...
~~~

# ExceptionHandler

[Error Handling](https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-error-handling)

Spring Boot 프로젝트를 실행 후
인터넷으로 http://localhost:8080 접근 또는
터미널으러 curl http://localhost:8080 으로 접속하면 표시되는 에러가

스프링 부트가 제공하는 기본 예외 처리기 `BasicErrorController` 에서 출력됩니다.
HTML과 JSON 응답 지원

이런 에러를 커스텀하여 직접 사용할 수 있습니다. 

## Spring MVC 예외처리 방법

- 스프링 @MVC 예외 처리 방법
    - @ControllerAdvice
    - @ExceptionHandler

간단 예제

컨트롤러 생성

> SampleController.class

~~~
@Controller
public class SampleController {

    @GetMapping("/hello")
    public String hello() {
        throw new SampleExcepion();
    }

    @ResponseBody
    @ExceptionHandler(SampleExcepion.class)
    public AppError sampleError(SampleExcepion e) {
        AppError appError = new AppError();
        appError.setMessage("error.app.key");
        appError.setReason("NONE");
        return appError;
    }
}
~~~

> SampleExcepion.class

~~~
public class SampleExcepion extends RuntimeException { }
~~~

> AppError.class

~~~
public class AppError {
    private String message;
    private String reason;

    // Getter, Setter
}
~~~

터미널 결과를 확인합니다.

~~~
curl http://localhost:8080/hello
result > {"message":"error.app.key","reason":"NONE"}
~~~

sampleError 메소드는 해당 컨트롤러에서만 사용 가능합니다.
해당 메소드를 전역적으로 사용하려면 클래스를 따로 만든 후 어노테이션 ControllerAdvice 붙여주면 사용 가능합니다.

## Spring Boot 예외처리 방법

- BasicErrorController
    - HTML과 JSON 응답 지원
- 커스터마이징 방법
    - ErrorController 구현

## 커스텀 에러 페이지

상태 코드 값에 따라 에러 페이지 보여주기
src/main/resources/static|template/error/
404.html
5xx.html
ErrorViewResolver 구현

에러가 발생했을 때 응답의 상태값에 따라서 다른 웹 페이지를 보여주는 경우에 

> /resoures/static/error 혹은 /resoures/static/templates/error

HTML 파일의 이름이 상태 코드값과 완전히 똑같거나 4xx || 5xx 식으로 만들어도 됩니다.
400.html 파일을 생성합니다.

# Spring HATEOAS

Hypermedia As The Engine Of Application State

REST(Representational State Transfer) API를 생성 할때 
Representational 와 연관이 되어 있는 링크 정보들 까지 서버가 같이 제공을 하고 
클라이언트는 같이 제공이 된 연관된 링크정보를 바탕으로 리소스에 접근을 하는것

요청 URI가 변경되더라도 클라이언트에서 동적으로 생성된 URI를 사용함으로써, 
`클라이언트가 URI 수정에 따른 코드를 변경하지 않아도 되는 편리함`을 제공합니다.

의존성을 추가합니다.

~~~
compile group: 'org.springframework.boot', name: 'spring-boot-starter-hateoas', version: '2.2.2.RELEASE'
~~~

의존성을 추가하는 순간 스프링부트가 많은것을 자동 설정 해줍니다.

- ObjectMapper 제공
    - spring.jackson.*
    - Jackson2ObjectMapperBuilder

개발자가 제공하는 리소스의 타입을 JSON으로 변환할 때 사용

- LinkDiscovers 제공
    - 클라이언트 쪽에서 링크 정보를 Rel 이름으로 찾을때 사용할 수 있는 XPath 확장 클래스

간단 예제

> SampleController.class

~~~
@RestController
public class SampleController {

    @GetMapping("/hello")
    public Hello hello() {
        Hello hello = new Hello();
        hello.setPrefix("hay~");
        hello.setName("jjunpro!");
        return hello;
    }
}
~~~

> Hello.class

~~~
public class Hello {
    private String Prefix;
    private String name;

    // Getter, Setter, ToString
}
~~~

> SampleControllerTest.class

~~~
@RunWith(SpringRunner.class)
@WebMvcTest(SampleController.class)
public class SampleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc
                .perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.self").exists())
                .andDo(print());
    }
}
~~~

테스트를 실행하면 실패합니다. 
이유는 Hello 객체가 링크 정보를 가지고 있지 않기 때문입니다.
링크를 추가하겠습니다.

## HATEOAS 링크 추가

HATEOAS v1.0 이상 (Spring boot> = 2.2.0)을 사용하는 경우 클래스 이름이 변경되었습니다. 
특히 아래 클래스의 이름이 변경되었습니다.

ResourceSupport 로 변경 RepresentationModel
Resource 로 변경 EntityModel
Resources 로 변경 CollectionModel
PagedResources 로 변경 PagedModel
ResourceAssembler 로 변경 RepresentationModelAssembler
자세한 내용은 https://docs.spring.io/spring-hateoas/docs/current/reference/html/ 
공식 문서를 참조하십시오 .

스프링 부트 스타터를 사용할 때 아래의 종속성은 HATEOAS를 포함하면 충분합니다.

~~~
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-hateoas</artifactId>
</dependency>
~~~

> SampleController.class

~~~
@RestController
public class SampleController {

    @GetMapping("/hello")
    public EntityModel hello() {
        Hello hello = new Hello();
        hello.setPrefix("hay~");
        hello.setName("jjunpro!");

        // 링크를 추가하는 코드
        EntityModel<Hello> helloResource = new EntityModel<>(hello);
        helloResource.add(linkTo(methodOn(SampleController.class).hello()).withSelfRel());

        return helloResource;
    }
}
~~~

methodOn(SampleController.class).hello() 링크 정보를 withSelfRel 만들어서 추가를 합니다.

테스트를 실행합니다.

~~~
MockHttpServletRequest:
      HTTP Method = GET
      Request URI = /hello
       Parameters = {}
          Headers = []
             Body = <no character encoding set>
    Session Attrs = {}

Handler:
             Type = me.whiteship.SampleController
           Method = me.whiteship.SampleController#hello()

Async:
    Async started = false
     Async result = null

Resolved Exception:
             Type = null

ModelAndView:
        View name = null
             View = null
            Model = null

FlashMap:
       Attributes = null

MockHttpServletResponse:
           Status = 200
    Error message = null
          Headers = [Content-Type:"application/hal+json"]
     Content type = application/hal+json
             Body = {"name":"jjunpro!","prefix":"hay~","_links":{"self":{"href":"http://localhost/hello"}}}
    Forwarded URL = null
   Redirected URL = null
          Cookies = []
BUILD SUCCESSFUL in 2s
~~~

# SOP과 CORS

- Single-Origin Policy (같은 곳에서만 요청을 보낼 수 있다.)
- Cross-Origin Resource Sharing
- Origin 이란?
    - URI 스키마 (http, https)
    - hostname (whiteship.me, localhost)
    - 포트 (8080, 18080)

Single-Origin Policy 를 우회하기 위한 표준 기술

서버를 두개 만든 후 한쪽서버에서 다른쪽 서버의 접근을 하면

~~~
Access to XMLHttpRequest at 'http://localhost:8080/hello' from origin 'http://localhost:18080' has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.
~~~

다음과 같은 에러가 발생합니다.

Cross-Origin을 해주기 위해서 어노테이션을 사용하는 방법

> project-1/SampleController.class

~~~
@RestController
public class SampleController {

    @GetMapping("/hello")
    @CrossOrigin("http://localhost:18080")
    public String hello() {
        return "hello";
    }
}
~~~

전역에서 사용하려면 Config를 생성하여 설정합니다.

> WebConfig.class

~~~
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                .addMapping("/**")
                .allowedOrigins("http://localhost:18080");
    }
}
~~~

# 인메모리 데이터베이스

- 지원하는 인-메모리 데이터베이스  
    - H2 (추천, 콘솔 때문에...)
    - HSQL
    - Derby

의존성을 추가합니다.

~~~
dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'
    testCompile group: 'org.springframework.boot', name: 'spring-boot-starter-test', version: '2.2.3.RELEASE'

    compile group: 'com.h2database', name: 'h2', version: '1.4.200'
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-web', version: '2.2.2.RELEASE'
    compile group: 'org.springframework.boot', name: 'spring-boot-starter-jdbc', version: '2.2.2.RELEASE'
}
~~~

간단 예제

> H2Runner.class

~~~
@Component
public class H2Runner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(H2Runner.class);

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            // 접속할 DB의 정보 URL 정보와
            String url = connection
                    .getMetaData()
                    .getURL();
            // user 정보를 확인할 수 있습니다.
            String username = connection
                    .getMetaData()
                    .getUserName();

            logger.info(url + " <:> " + username);

            Statement statement = connection.createStatement();
            String    sql       = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.executeUpdate(sql);
        }

        // jdbcTemplate 사용
        jdbcTemplate.execute("INSERT INTO USER VALUES (1, 'jjunprop')");
    }
}
~~~

접속할 DB의 정보를 확인하는 위치는 DataSourceProperties.class > determineDatabaseName() 에서도 확인할 수 있습니다.

기존 Jdbc 를 사용하는것 보다 코드가 간결하고 try catch 리소스 반납처리가 잘 되어 있으며
jdbcTemplate 사용시 가독성이 높은 에러 메세지를 확인할 수 있습니다.

## H2 콘솔 사용하는 방법

spring-boot-devtools를 추가하거나...
spring.h2.console.enabled=true 만 추가.
/h2-console로 접속 (이 path도 바꿀 수 있음)

JDBC URL: 값이 로거로 출력된 값인지 확인합니다. (jdbc:h2:mem:testdb)