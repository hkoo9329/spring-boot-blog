#Back Button을 처리하기 위한 고찰

OAuth2로 로그인 한 다음에 back button을 누르면 다시 로그인 페이지로 돌아가는 문제 발생.
다시 로그인을 하면 해당 소셜 서버에서 처리가 되지 않아서 에러 발생


1. [Interceptor 또는 cache control](https://stackoverflow.com/questions/18147302/how-to-handle-back-button-using-spring-security)

   Part of you problem comes from browser cache. You can disable it in multiple ways:

- Configure Spring MVC interceptor for all your pages:

  ```xml
  <mvc:annotation-driven/>
  
      <mvc:interceptors>
          <mvc:interceptor>
              <mvc:mapping path="/**/*"/>
              <bean id="webContentInterceptor" class="org.springframework.web.servlet.mvc.WebContentInterceptor">
                  <property name="cacheSeconds" value="0"/>
                  <property name="useExpiresHeader" value="true"/>
                  <property name="useCacheControlHeader" value="true"/>
                  <property name="useCacheControlNoStore" value="true"/>
              </bean>
          </mvc:interceptor>
      </mvc:interceptors>
  ```

- Call response methods:

  ```java
  response.setHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache");
  response.setDateHeader("Expires", 0);
  ```

- Add meta tags to corresponding pages:

  ```xml
   <meta http-equiv="Pragma" content="no-cache">
      <meta http-equiv="Cache-Control" content="no-cache">
      <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
  ```

  

- [cache control](http://docs.spring.io/spring-security/site/docs/4.0.3.RELEASE/reference/htmlsingle/#headers-cache-control) of Spring Security:

  ```java
  @EnableWebSecurity
  public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  
     @Override
     protected void configure(HttpSecurity http) throws Exception {
        http
        // ...
        .headers()
           .defaultsDisabled()
           .cacheControl();
     }
  }
  ```



> 사용해 봤지만 내가 생각했던 동작을 하지 않음



2. [필터 이용](https://www.jeejava.com/prevent-user-going-back-to-login-page-if-already-logged-in-using-filters/)

   > 찾아보기만 하고 사용안해봄 추후에 공부해서 시도해보기로....



3. window.location.replace() 사용
   - replace를 이용하면 현재 페이지를 교체함으로 뒤로가기 스택에 /login이 들어가는 것을 막는다.







## 추가 자료

- [스프링 부트와 OAuth2 정리 글](https://springboot.tistory.com/37)