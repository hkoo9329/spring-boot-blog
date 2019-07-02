# JQuery 와 Ajax 공부



## 목차

1. JQuery 공부
2. JQuery 정리
   - [JQuery를 이용해서 Input 값 변경 실시간 감지](#JQuery를-이용해서-Input-값-변경-실시간-감지)
   - [JQuery를 이용한 ID, Class, Name 별로 Input Value 값 가져오기](#JQuery를-이용한-ID,-Class,-Name-별로-Input-Value-값-가져오기)
   - [JavaScrip - 정규식을 이용한 ID / PW 검사](#JavaScrip-정규식을-이용한-ID-/-PW-검사)
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









# Ajax 공부

# Ajax 정리



## 회원 가입 (ajax로 id 중복 체크, 비밀번호 확인)

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

