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
- [10. 외부 설정 2부](#외부-설정-2부)
    - [1. 프로퍼티 Bean 등록 방법](#프로퍼티-Bean-등록-방법)
    - [2. 프로퍼티 값 검증](#프로퍼티-값-검증)

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

1. @Value('')

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

하지만 Spring 에서는 자동으로 EnableConfigurationProperties 등록이 되어있으므로 
JjunproProperties.class에 Bean 등록 @Component 어노테이션만 작성하면 등록이 됩니다.

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