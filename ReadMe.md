--------------------
# Spring Boot
--------------------


# 목차

- [1. Spring Boot 란 무엇인가](#Spring-Boot-란-무엇인가)
- [2. SpringBootApplication 역할](#SpringBootApplication-역할)
    - [1. Application 프로젝트 실행 원리](#Application-프로젝트-실행-원리)
    - [2. @ComponentScan](#@ComponentScan)
- [3. 자동 설정 만들기 1부](#자동-설정-만들기-1부)
    - [1. @Configuration 파일 작성](#@Configuration-파일-작성)
    - [2. 배포용 jar 생성](#배포용-jar-생성)
    - [3. 배포용 jar Bean 실행](#배포용-jar-Bean-실행)
- [4. 자동 설정 만들기 2부](#자동-설정-만들기-2부)
    - [1. 프로젝트에 Bean 등록이 중첩될 경우 덮어쓰기 방지](#프로젝트에-Bean-등록이-중첩될-경우-덮어쓰기-방지)
    - [2. @ConditionalOnMissingBean](#@ConditionalOnMissingBean)
    - [3. properties 활용한 Bean 등록없이 값 수정하기](#properties-활용한-Bean-등록없이-값-수정하기)
        - [1. @ConfigurationProperties](#@ConfigurationProperties)
        - [2. @EnableConfigurationProperties](#@EnableConfigurationProperties)


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