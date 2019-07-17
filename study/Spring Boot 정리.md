# Spring Boot 정리



## Spring Boot 란?

- 스프링 부트는 단독 실행되는, 실행하기만 하면 되는 상용화 가능한 수준의, 스프링 기반 애플리케이션을 쉽게 만들어낼 수 있다.

- 최소한의 설정으로 스프링 플랫폼과 서드파티 라이브러리들을 사용할 수 있도록 하고 있다.

  > 스프링 기반의 애플리케이션을 개발하기 쉽도록 기본 설정되어 있는 설정을 기반으로 해서 빠르게 개발할 수 있도록 해주는 개발 플랫폼이랄까?



## 스프링 부트 기능

1. 단독 실행 가능한 스프링 애플리케이션을 생성한다.

   

2. 내장형 톰캣, 제티 혹은 언더토우를 내장 (WAR 파일로 배포할 경우에는 필요없음)

   

3. 기본 설정되어 있는 'starter' 컴포넌트들을 쉽게 추가 가능

   

4. 가능한 자동설정되어 있음

   

5. 상용화에 필요한 통계, 상태 점검 및 외부 설정을 제공

   

6. 설정을 위한 XML 코드를 생성하거나 요구하지 않음



## 스프링 부트 배치

- 스프링 배치는 백엔드의 배치 처리 기능을 구현하는데 사용하는 프레임워크

  > 배치(batch)는 프로그램의 흐름에 따라 순차적으로 자료를 처리한다는 뜻. 배치처리(batch processing)는 `일괄 처리`와 같은 말



- 스프링 부트 배치는 스프링 배치의 설정 요소들을 간편화시켜 스프링 배치를 빠르게 설정하는데 도움을 준다.
  - ex) 휴먼회원 전환 기능 일괄 처리



###  배치처리에 스프링 부트 배치를 써야 하는 이유

스프링 부트 배치의 장점은 다음과 같음

- 대용량 데이터 처리에 최적화되어 고성능을 발휘한다.
- 효과적인 로깅, 통계 처리, 트랜잭션 관리 등 재사용 가능한 필수 기능을 지원한다.
- 수동으로 처리하지 않도록 자동화되어 있다.
- 예외사항과 비정상 동작에 대한 방어 기능이 있다.
- 스프링 부트 배치의 반복되는 작업 프로세스를 이해하면 비즈니스 로직에 집중할 수 있다.

백엔드에서 일어나는 배치 처리에 대한 대부분의 고민은 이미 스프링 부트 배치에서 기능으로 제공한다. 따라서 스프링 부트 배치의 기능을 잘 이해하고 효과적으로 사용하며 비즈니스 로직을 더욱 견고하게 작성하면 된다.





스프링 부트 배치 2.0은 최신 버전인 스프링 배치 4.0을 기반으로 한다.

- 스프링 배치 4.0은 세가지 특징이 있다.
  - 기본적으로 자바 8 이상에서 동작한다. 자바 8은 함수형 인터페이스와 람다를 지원해 한층 더 편리한 개발이 가능
  - 스프링 프레임워크 5로 진화하면서 새롭게 재배열된 의존성 트리를 지원한다.
  - ItemReaders, ItemProcessors, ItemWriters에 대한 빌더를 제공한다.







### 스프링 부트 배치 주의사항

스프링 부트 배치는 스프링 배치를 간편하게 사용할 수 있게 래핑한 프로젝트이다. 따라서 스프링 부트 배치와 스프링 배치 모두에서 다음과 같은 주의사항이 있다.

1. 가능하면 단순화해서 복잡한 구조와 로직을 피해야한다.

2. 데이터를 직접 사용하는 작업이 빈번히 일어나므로 데이터 무결성을 유지하는 유효성 검사 등의 방어책이 있어야 한다.

3. 배치 처리 시 시스템 I/O 사용을 최소화해야 합니다. 잦은 I/O로 데이터베이스 커넥션과 네트워크 비용이 커지면 성능에 영향을 줄 수 있기 때문이다.  따라서 가능하면 한번에 데이터를 조회하여 메모리에 저장해두고 처리를 한 다음, 그 결과를 한번에 데이터베이스에 저장하는 것이 좋다.

4. 일반적으로 같은 서비스에 사용되는 웹, API, 배치, 기타 프로젝트들은 서로 영향을 준다. 따라서 배치 처리가 진행되는 동안 다른 프로젝트 요소에 영향을 주는 경우가 없는지 주의를 기울여야 한다.

5. 스프링 부트 배치는 스케쥴러를 제공하지 않는다. 배치 처리 기능만 제공하며 스케쥴링 기능은 스프링에서 제공하는 쿼츠 프레임워크(Quartz Framework), IBM 티볼리 (Tivoli) 스케쥴러, BMC 컨트롤 - M (Control-M) 등을 이용해야 한다. 

   리눅스 crontab 명령은 가장 간단히 사용할 수 있지만 이는 추천하지 않는다. crontab의 경우 각 서버마다 따로 스케쥴링을 관리해야 하며 무엇보다 클러스터링 기능이 제공되지 않는다. 반면에 쿼츠와 같은 스케쥴링 프레임워크를 사용한다면 클러스터링뿐만 아니라 다양한 스케쥴링 기능, 실행 이력 관리 등 여러 이점을 얻을 수 있다.





### 스프링 부트 배치 이해하기

배치의 일반적인 시나리오는 다음과 같은 3단계로 이뤄진다.

1. 읽기 (read) : 데이터 저장소 (일반적으로 데이터베이스)에서 특정 데이터 레코드를 읽습니다.
2. 처리 (processing) : 원하는 방식으로 데이터를 가공 / 처리한다.
3. 쓰기 (write) : 수정된 데이터를 다시 저장소 (데이터베이스)에 저장한다.

즉, 배치 처리는 읽기 -> 처리 -> 쓰기 흐름을 갖습니다. 

![Screenshot_20190626-174427_LectureNotes](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FMCRsy%2FbtqwqkmgjRA%2FmgxcxyysONngq4W7i2lGA1%2Fimg.jpg)



- Job과 Step = > 1:N의 관계

  

- ItemReader, ItemProcessor, ItemWriter = > 1:1의 관계

즉 Job이라는 하나의 큰 일감 (Job)에 여러 단계 (Step)를 두고, 각 단계를 배치의 기본 흐름대로 구현한다.



### Job

- Job은 배치 처리 과저을 하나의 단위로 만들어 표현한 객체

- 스프링 배치에서 Job 객체는 여러 Step 인스턴스를 포함하는 컨테이너이다.

  > 인스턴스 : 객체 지향 프로그래밍(OOP)에서 해당 클래스의 구조로 컴퓨터 저장공간에 할당된 실체를 의미,
  >
  > OOP에서 객체는 클래스와 인스턴스를 포함한 개념

- Job 객체를 만드는 빌더는 여러 개가 존재, 여러 빌더를 통합 처리하는 공장인 JobBuilderFactory로 원하는 Job을 손쉽게 만들 수 있다.




```java
// JobBuilderFactory.class

public class JobBuilderFactory{
    
    private JobRepository jobRepository;
    
    public JobBuilderFactory(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }
    
    public JobBuilder get(String name){
        JobBuilder builder = new JobBuilder(name).repository(jobRepository);
        return builder;
    }
}

```

- JobBuilderFactory는 JobBuilder를 생성할 수 있는 get() 메서드를 포함하고 있다.
- JobBuilderFactory에 get( ) 메서드를 호출할 때마다 ==새로운 빌더가 생성==
- 새로운 JobBuilder를 생성할 때마다 당초 JobBuilderFactory가 생성될 때 주입받은 JobRepository를 JobBuilder에서 사용할 리포지토리로 설정

```java
//SimpleJobBuilder를 활용한 Job 생성 예제 코드
@Autowired
private JobBuilderFactory jobBuilderFactory;

@Bean
public Job simpleJob(){
    return jobBuilderFactory.get("simpleJob")
        .start(simpleStep())
        .build();
}
```





### JobInstance

- JobInstance는 배치에서 Job이 실행될 때 하나의 Job 실행 단위
- JobInstance는 여러개의 JobExecution을 가질 수 있다.



### JobExecution

- JobExecution은 JobInstance에 대한 한 번의 실행을 나타내는 객체

