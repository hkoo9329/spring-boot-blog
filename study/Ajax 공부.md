

# JQuery 와 Ajax 공부

> >내용 확인 후 추가: 
> >
> >-  [ [SpringSecurity] 스프링 시큐리티 jquery ajax사용시 로그인 하게 하기](https://nkcnow.tistory.com/224)
> >- [Ajax로 Spring Controller와 통신할때 객체구성방법 두가지](http://blog.naver.com/PostView.nhn?blogId=admass&logNo=220885561838&from=search&redirect=Log&widgetTypeCall=true&directAccess=false)
> >- [  SPRING에서 JSON 객체를 파라메터로 넘겼을 경우 처리](https://babolsk.tistory.com/1067)
> >- [Spring-ajax-demo(GItHub)](https://github.com/kdevkr/spring-demo-ajax)
> >- [[[Spring\] Ajax - JSON 응답하기 ( MessageConverter )](https://victorydntmd.tistory.com/172)]





## 목차

1. JQuery 공부
2. JQuery 정리
   - [JQuery를 이용해서 Input 값 변경 실시간 감지](#JQuery를-이용해서-Input-값-변경-실시간-감지)
   - [JQuery를 이용한 ID, Class, Name 별로 Input Value 값 가져오기](#JQuery를-이용한-ID,-Class,-Name-별로-Input-Value-값-가져오기)
   - [JavaScrip - 정규식을 이용한 ID / PW 검사](#JavaScrip---정규식을-이용한-ID-/-PW-검사)
3. Ajax 공부
   - 
4. Ajax 정리
   - [회원 가입 ajax로 id 중복 체크, 비밀번호 확인](#회원-가입-ajax로-id-중복-체크,-비밀번호-확인)
   - [ajax 데이터 넘기기 간단 예제](#ajax-데이터-넘기기-간단-예제)



# JQuery 공부



# JQuery 정리

## JQuery를 이용해서 Input 값 변경 실시간 감지

Input 타입에는  select, checkbox, text, password 등 수 많은 타입을 내장하고 있는데, select나 checkbox 같은 경우에는 값의 변경을 단순히 onchange로도 확인할 수 있습니다. 다만, text나 textarea의 경우에는 값을 적고 있을 때에는 onchange로는 값의 변경을 감지할 수 없습니다. 왜냐하면 onchange 이벤트가 걸리는 시점이 blur(focus와 반대로 오브젝트를 떠나는 시점)이기 때문입니다. 따라서 onchange로는 text나 textarea의 실시간 값 변경을 감지할 수 없습니다. 업무를 하던 중에 실시간으로 값의 변경을 감지해서 앞의 10글자 정도는 고정으로 가져가도록 유지하게 해야하는 때가 있었는데 찾아보니 아래와 같은 방법이 있었습니다.

```javascript
//예전 jQuery라면 on이 아니라 bind나 live 
$("#text").on("propertychange change keyup paste input", function() {
    var currentVal = $(this).val();
    if(currentVal == oldVal) {
        return;
    }
 
    oldVal = currentVal;
    alert("changed!");
});
```

출처 : https://karismamun.tistory.com/66



## JQuery를 이용한 ID, Class, Name 별로 Input Value 값 가져오기

1. 우선 input을 하나 만듭니다.

   ```html
   <input type="hidden" id="test_id" class="test_class" name="test_name" value="test">
   ```

2. 이제 이 input의 value를 jquery를 이용해서 id, class, name별로 각각 접근해서 가져오도록 하겠습니다.

   ```javascript
   //1. id 로 접근해서 가져오기
   var value = $('#test_id').val();
   
   //2. class 로 접근해서 가져오기
   var value = $('.test_class').val();
   
   //3. name으로 접근해서 가져오기
   var value = $('input[name=test_name]').val();
   
   ```

   출처 : https://codethief.io/ko/get-input-value-by-id-class-and-name-using-jquery/



## JavaScrip - 정규식을 이용한 ID / PW 검사

- 첫글자가 영문으로 시작하며 영문과 숫자 조합만 가능하며 4~12자 사이의 ID인지를 검사



```javascript
//정규식을 이용한 ID 검사

function checkID(id){
    var reg_exp = new RegExp("^[a-zA-Z][a-zA-Z0-9]{3,11}$","g");
    var match = reg_exp.exec(id);
    
    if(id==""){
        alert("ID를 입력하세요.");
        return true;
    }
    if(id.length < 4 || id.length > 12){
        alert("ID는 4자 이상 12자 이하로 입력하세오.");
        return true;
    }
    if(match == null){
        alert("ID는 첫글자는 영문으로 시작하며 영문과 숫자 조합만 가능합니다.");
        return true;
    }
    
    return false;

}

//PW 검사
function checkPW(pw){
    if(pw == ""){
        alert("PW를 입력하세요.");
        return true;
    }
    if(pw.length < 6 || pw.length > 16){
        alert("PW는 6자 이상 16자 이하로 입력하세오.");
        return true;
    }
    
    return false;
}

//Login Form
function checkLogin(){
    var f = document.frmLogin;
    
    if(checkID(f.txtId.value)){
        f.txtId.value = "";
        f.txtId.focus();
        return;
    }
    if(checkPW(f.txtPw.Value)){
        f.txtPw.value ="";
        f.txtPw.focus();
        return;
    }
    f.submit();
}
```

출처 : https://tetjjang.tistory.com/316



### 정규식 체크 예

기본적으로 자바스크립트에서 정규표현식은 / (슬래쉬)로 감싼다

"(큰따옴표) 또는 '(작은따옴표)로 감싸지 않는다.

 

그리고 마지막에 /g 또는 /i 또는 /gi 로 끝난다

왜 그런지 궁금하면 각자 찾아보는 걸로 한다~

 

아래에서 뜻하는 정규 표현식은 영문 a-z 로 시작하고 이후에 a-z0-9 사이 문자열이 오면 된다는 것이다.

대괄호 앞에 ^가 붙으면 시작을 뜻하고 대괄호 안에 ^가 붙으면 제외를 뜻한다.

^[a-z]로 되어 있으니 시작을 영문 a-z로 하는 것을 뜻한다

\+ 연산자로 연결을 한다.

{5,19}는 5~19자리를 뜻한다.

 

앞에서 ^[a-z]에서 1자리를 먹었으니 이후에  [a-z0-9]{5,19} 5~19자리이니...

결국은 6~20 자리를 뜻한다.

 

$가 붙으면 끝을 뜻한다.

 [a-z0-9]{5,19}$ 이니.. 영문소문자 또는 숫자로 끝이 나면 된다.

 

​        var idReg = **/^[a-z]+[a-z0-9]{5,19}$/g;**
​        if( !idReg.**test**( $("input[name=uid]").val() ) ) {
​            alert("아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.");
​            return;
​        }

 

아래에는 예제들이다.



**==[영문 대문자 또는 소문자로 시작하는 아이디, 끝날때 영문 대문자 또는 소문자]==**

 var idReg = /^[A-za-z]$/g;

 

**==[영문 대문자 또는 소문자로 시작하는 아이디, 끝날때 제한 없음]==**

var idReg = /^[A-za-z]/g;

 

**==[영문 대문자 또는 소문자 또는 숫자로 시작하는 아이디, 끝날때 영문 대문자 또는 소문자 또는 숫자]==**

var idReg = /^[A-za-z0-9]$/g;

 

**==영문 대문자 또는 소문자 또는 숫자로 시작하는 아이디, 끝날때 제한 없음]==**

var idReg = /^[A-za-z0-9]/g;

 

**==[영문 대문자 또는 소문자로 시작하는 아이디, 길이는 5~15자, 끝날때 영문 대문자 또는 소문자]==**

var idReg = /^[A-za-z]{5,15}$/g;

 

**==문 대문자 또는 소문자로 시작하는 아이디, 길이는 5~15자, 끝날때 제한 없음]==**

var idReg = /^[A-za-z]{5,15}/g;

 

**==[영문 대문자 또는 소문자 또는 숫자로 시작하는 아이디, 길이는 5~15자, 끝날때 영문 대문자 또는 소문자 또는 숫자]==**

var idReg = /^[A-za-z0-9]{5,15}$/g;

 

**==[영문 대문자 또는 소문자 또는 숫자로 시작하는 아이디, 길이는 5~15자, 끝날때 제한 없음]==**

var idReg = /^[A-za-z0-9]{5,15}/g;

 

더 많은 조합들이 있겠지만.. 매번 찾는 아이디 체크에 대해서 작성해 보았습니다.



출처 : https://ikinox.tistory.com/entry/자바스크립트-정규표현식-아이디-체크-영문숫자



### 자바스크립트 이메일 유효성 체크

```html
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

<script type="text/javascript">

	function check() {		

		alert(document.getElementById("email").value);

		var email = document.getElementById("email").value;

		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

				if(exptext.test(email)==false){

			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			

			alert("이 메일형식이 올바르지 않습니다.");

			document.addjoin.email.focus();

			return false;

		}

	}

	

</script>

</head>

<body>

<form onsubmit="check();">

	<input type="text" name="email" id="email"/><br>

	<input type="submit" value="submit">	

</html>

```



출처 : [자바스크립트 이메일 유효성 체크](https://carami.tistory.com/40)













# Ajax 공부

## Ajax 개요

### Ajax

- Ajax는 그 자체가 별도의 새로운 언어는 아니다.
- HTML, CSS, 자바스크립트, DOM, XML 등 기존에 사용되던 여러 기술을 함께 사용하는 새로운 개발 기법이다.

- Ajax는 웹 페이지 전체를 다시 로딩하지 않고도, 웹 페이지의 일부분만을 갱신할 수 있게 해준다.
- 즉, 백그라운드 영역에서 서버와 통신하여 그 결과를 웹 페이지의 일부분에만 표시할 수 있다.

### Ajax란?

- Ajax란 Asynchronous JavaScript and XML의 약자이다.

- Ajax는 빠르게 동작하는 동적인 웹 페이지를 만들기 위한 개발 기법의 하나이다.

- Ajax는 웹 페이지 전체를 다시 로딩하지 않고도, 웹 페이지의 일부분만을 갱신할 수 있다.
- 즉 Ajax를 이용하면 백그라운드 영역에서 서버와 통신하여, 그 결과를 웹 페이지의 일부분에만 표시할 수 있다.
- 이때 서버와는 다음과 같은 다양한 형태의 데이터를 주고 받을 수 있다.
  - JSON
  - XML
  - HTML
  - 텍스트 파일 등

## Ajax의 장점

1. 웹 페이지 전체를 다시 로딩하지 않고도, 웹 페이지의 일부분만을 갱신할 수 있다.
2. 웹 페이지가 로드된 후에 서버로 데이터 요청을 보낼 수 있다.
3. 웹 페이지가 로드된 후에 서버로부터 데이터를 받을 수 있다.
4. 백그라운드 영역에서 서버로 데이터를 보낼 수 있다.

## Ajax의 한계

Ajax를 이용하면 여러 장점이 있지만, 다음과 같은 일들은 처리할 수 없다.

1. Ajax는 클라이언트가 서버에 데이터를 요청하는 클라이언트 폴링 방식을 사용하므로, 서버 푸시 방식의 실시간 서비스는 만들 수 없다.

2. Ajax로는 binary 데이터를 보내거나 받을 수 없다.

3. Ajax 스크립트가 포함된 서버가 아닌 다른 서버로 Ajax 요청을 보내 수 없다.

4. 클라이언트의 PC로 Ajax 요청을 보낼 수 없다.

   >클라이언트 풀링(client pooling) 방식이란 사용자가 직접 원하는 정보를 서버에게 요청하여 얻는 방식을 의미합니다.
   >이에 반해 서버 푸시(server push) 방식이란 사용자가 요청하지 않아도 서버가 알아서 자동으로 특정 정보를 제공하는 것을 의미합니다.
   >요즘 많이들 사용하는 스마트 폰에서 각종 앱이 보내는 푸시 알림이 서버 푸시 방식의 대표적인 예입니다.

### Ajax 프레임워크

- Prototype

- Script.aculo.us

- dojo

- jQuery




## Ajax 동작 원리

### Ajax 구성 요소

Ajax는 기존에 사용되던 여러 기술을 함께 사용하여, 웹 페이지의 일부분만을 갱신할 수 있도록 해주는 개발 기법이다.

Ajax에서 사용하는 기존 기술은 다음과 같다.

- 웹 페이지의 표현을 위한 HTML과 CSS
- 데이터에 접근하거나 화면 구성을 동적으로 조작하기 위해 사용되는 DOM 모델
- 데이터의 교화을 위한 JSON이나 XML
- 웹 서버와의 비동기식 통신을 위한 XMLHttpRequest 객체
- 위에서 언급한 모든 기술을 결합하여 사용자의 작업 흐름을 제어하는데 사용되는 자바스크립트

### Ajax 동작 원리

Ajax의 동작은 위에서 언급한 Ajax 구성 요소들을 사용하여 이루어진다.

Ajax를 이용한 웹 응용 프로그램은 자바스크립트 코드를 통해 웹 서버와 통신을 하게 된다.

따라서 사용자의 동작에는 영향을 주지 않으면서도 백그라운드에서 지속해서 서버와 통신할 수 있다.



![](http://tcpschool.com/lectures/img_ajax_ajax_application.png)

1.  사용자에 의한 요청 이벤트가 발생한다.

2.  요청 이벤트가 발생하면 이벤트 핸들러에 의해 자바스크립트가 호출된다.

3.  자바스크립트는 XMLHttpRequest 객체를 사용하여 서버로 요청을 보낸다.

    이때  웹 브라우저는 요청을 보내고 나서, 서버의 응답을 기다릴 필요 없이 다른 작업을 처리할 수 있다.

4. 서버는 전달 받은 XMLHttpRequest 객체를 가지고 Ajax 요청을 처리한다.

5. &(5와6은 같이 설명)

6. 서버는 처리한 결과를 HTML, XML 또는 JSON 형태의 데이터로 웹 브라우저에 전달한다.

   이때 전달되는 응답은 새로운 페이지를 전부 보내는 것이 아니라 필요한 데이터만을 전달한다.

7. 서버로부터 전달받은 데이터를 가지고 웹 페이지의 일부분만을 갱신하는 자바스크립트를 호출한다.

8. 결과적으로 웹 페이지의 일부분만이 다시 로딩되어 표시된다.



## DOM

### 문서 객체 모델(DOM)이란?

- 문서 객체 모델 (DOM, Document Object Model)은 HTML 문서나 XML 문서에 접근하기 위한 일종의 인터페이스이다.

- 이 모델은 문서 내의 모든 요소의 목적과 특징을 정의하고, 각각의 요소에 접근하는 방법을 제공한다.

  ![](http://tcpschool.com/lectures/img_js_htmldom.png)

  

- Ajax에서는 이러한 DOM을 이용하여 웹 페이지의 일부 요소만을 변경할 수 있다.

- 따라서 Ajax를 배우기 전에 DOM에 대한 기본저깅ㄴ 사항을 알아야한다.

### DOM 요소의 선택

자바스크립트로 DOM 요소를 다루기 위해서는 우선 해당 요소를 선택해야만 한다.

DOM 요소를 선택하는 방법은 다음과 같다.

1. 태그 이름(tag name)을 이용한 선택
2. 아이디(id)를 이용한 선택
3. 클래스(class)를 이용한 선택
4. CSS 선택자(selector)를 이용한 선택
5. HTML 객체 집합 (object collection)을 이용한 선택



### DOM 요소의 내용 변경

DOM을 이용하면 DOM 요소의 내용(content)이나 속성값 등을 손쉽게 변경할 수 있다.

DOM 요소의 내용을 바꾸는 가장 쉬운 방법은 innerHTML 프로퍼티를 이용하는 것이다. 또한. DOM 요소의 속성 이름을 이용하면 속성값을 바로 변경할 수 있다.





출처 : http://tcpschool.com/ajax/ajax_intro_basic

# Ajax 정리



## 회원 가입 ajax로 id 중복 체크, 비밀번호 확인

1. ID 중복 체크

   - Ajax를 이용하여 POST방식으로 checkSingup 요청한다.

   - 요청 시 파라미터로 id 값을 보낸다.

   - Success 요청 성공 시, 조건을 data == "YES"고 id 값이 null이 아니면 사용가능한 것, 그렇지 않으면 중복된 아이디라고 alert 창을 뜨게 함

   - 중복 된 아이디일 경우, id 값이 null이 되고 focus가 맞춰진다.

     

```javascript
<View>
$(function(){
//아이디 중복체크
    $('#id').blur(function(){
        $.ajax({
	     type:"POST",
	     url:"checkSignup",
	     data:{
	            "id":$('#id').val()
	     },
	     success:function(data){//data : checkSignup에서 넘겨준 결과값
	            if($.trim(data)=="YES"){
	               if($('#id').val()!=''){ 
	               	alert("사용가능한 아이디입니다.");
	               }
	           	}else{
	               if($('#id').val()!=''){
	                  alert("중복된 아이디입니다.");
	                  $('#id').val('');
	                  $('#id').focus();
	               }
	            }
	         }
	    }) 
     })

});

```

```java
<Controller>
//아이디 중복 체크
@RequestMapping(value = "/checkSignup", method = RequestMethod.POST)
	public @ResponseBody String AjaxView(  
		        @RequestParam("id") String id){
		String str = "";
		int idcheck = dbPro.idCheck(id);
		if(idcheck==1){ //이미 존재하는 계정
			str = "NO";	
		}else{	//사용 가능한 계정
			str = "YES";	
		}
		return str;
	}

```





2. 비밀 번호 확인
   - PW와 재확인PW가 같은지 확인한다.
   - 일치하지 않을 시, alert창을 띄우고 재확인PW 값을 null로 바꾸고 focus 맞춘다.

```javascript
$(function(){

//비밀번호 확인
	$('#pw2').blur(function(){
	   if($('#pw').val() != $('#pw2').val()){
	    	if($('#pw2').val()!=''){
		    alert("비밀번호가 일치하지 않습니다.");
	    	    $('#pw2').val('');
	          $('#pw2').focus();
	       }
	    }
	})  	   
});



```

```html
<!-- View -->
<p>
	<label>*비밀번호</label>
	<input class="w3-input" type="password" style="width:90%" id="pw" name="pw" value="1234" required>
</p>
			
<p>
	<label>*비밀번호 확인</label>
	<input class="w3-input" type="password" style="width:90%" id="pw2" value="1234" required></p>

```

출처 : https://xodgl2.tistory.com/22



## ajax 데이터 넘기기 간단 예제

 간단하게 input 값들을 문자열, 배열로 한꺼번에 넘기는 예제다.

- Html

  ```html
  <input type="hidden" id="userId" value="abcd">
  <input type="checkbox" name="hobby" value="독서">
  <input type="checkbox" name="hobby" value="운동">
  <input type="checkbox" name="hobby" value="전시관람">
  
  ```

- javascript

  ```javascript
  function ajaxExample(){
      // 사용자 ID를 갖고 온다.
      var userId = $("#userId").val();
   
      // name이 같은 체크박스의 값들을 배열에 담는다.
      var checkboxValues = [];
      $("input[name='hobby']:checked").each(function(i) {
          checkboxValues.push($(this).val());
      });
       
     // 사용자 ID(문자열)와 체크박스 값들(배열)을 name/value 형태로 담는다.
      var allData = { "userId": userId, "checkArray": checkboxValues };
       
      $.ajax({
          url:"goUrl.do",
          type:'GET',
          data: allData,
          success:function(data){
              alert("완료!");
              window.opener.location.reload();
              self.close();
          },
          error:function(jqXHR, textStatus, errorThrown){
              alert("에러 발생~~ \n" + textStatus + " : " + errorThrown);
              self.close();
          }
      });
  }
  ```

- String Controller

  - 배열은 배열로, 스트링은 스트링으로 받으면 된다.

  ```java
  @RequestParam(value="checkArray[]") List<string> arrayParams, @RequestParam(value="userId") String userId
  
  ```

  - 만약 @RequestParam HashMap param으로 받을 경우, 배열은 첫번째 값만 넘어간다. 그러니 배열은 반드시 List로.



출처 : https://zero-gravity.tistory.com/241



## Ajax 에러 쉽게 확인하기

```javascript
    $.ajax({
             type     : "POST"
          ,  url      : "./join_prc.jsp"         
          ,  data     : param
          ,  dataType : "json"
          ,  success  : function(result){
                 alert(result.message);
             }
          ,  error:function(request,status,error){
             console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
          }
         });

// 이부분이 중요 에러 메시지와 내용이 로그로 출력가능
error:function(request,status,error){
             console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
          }
```

출처 : [https://sirdeath.tistory.com/entry/ajax-500-internal-server-%EC%97%90%EB%9F%AC-%EB%B0%9C%EC%83%9D%EC%8B%9C](https://sirdeath.tistory.com/entry/ajax-500-internal-server-에러-발생시)





## @RequestPram의 주의사항

  Annotation 기반 Controller 에서는 HTTP 요청 파라미터를 @RequestParam 을 사용해서 메소드의 파라미터로 바로 전달 할 수 있다.

@RequestParam 은 Key=Value 형태의 HTTP 요청 파라미터를 메소드의 파라미터에 전달해준다.

```java
//유저 아이디가 중복인지 아닌지
@PostMapping("/api/test")
public boolean testUserIdCheck(@RequestPram(value ="id") String id){
   	User user = userRepository.findId(id);
    if(user == null){
        return true; 
    }else{
        return false;
    }
}

// Ajax에서 보내는 데이터 형식은 json의 형식으로
data : {
    "id":"사용자아이디"
}
와 같은 형식이어야함 @RequestPram의 value와 key의 값이 같아야함 
    
```

출처: https://arawn.tistory.com/34 [Arawn's DevNote]  









