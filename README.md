# 서블릿 출력 형식의 이해


* * * 


## 브라우저에 컨텐츠 형식을 알려주지 않은 경우 : 자의적인 해석

## 한글과 콘텐츠 형식 출력하기
## 한글이 깨지는 이유
* 웹서버에 기본적으로 세팅되어 있는 ISO-8859-1 로 되어 있는데 1바이트로 쪼개지기에 한글이 깨진다
* 그렇기에 resp.setCharacterEncoding("UTF-8"); 
resp.setContentType("text/html;charset=UTF-8");로 명시를 해줘야한다.


## GET 요청과 쿼리스트링
* http://localhost/hello
* http://localhost/hello?cnt=3 (쿼리 스트링)
* 무엇인가를 전달할 수 있는것, 요청에 대한 옵션 추가
* getParameter = 사용자가 전달할때 쿼리값을 읽을때 사용


## 사용자 입력을 통한 GET 요청


# 입력할 내용이 많은 경우는 POST 요청
* 주문을 예시로 옵션이 많다면 한곳에 적어서 제출
* hello.html를 복사해서 reg.html 만들고
* form, name등을 수정
* NoticeReg 클래스를 만들고 
* 사용자는 post전달 -> 받아서 사용자에게 다시 확인 받는 설정
* 이러면 쿼리스트링 문자 그대로 길게 표현된다
* 요청바디에 	<form action="notice-reg" method="post">
* 위처럼 method="post를 붙여주면 url에 붙지 않고 요청바디로만 전달, 개발자도구로 들어가서 확인하자

## 한글입력문제
* 내용에 한글을 쓰고 등록을 하면 한글이 깨지는 이유
* iSO-8859-1 = UTF-8로 읽을 수 있도록 설정해야한다
* 	req.setCharacterEncoding("UTF-8"); 를 써주면 한글은 깨지지 않는다

## 서블릿 필터
* 웹서버 -> WAS -> 요청 -> 서블릿 컨테이너 
* -> 인코딩 설정 무조건! -> 그러면 서블릿이 많아짐 -> 서블릿 컨테이너앞에 필터가 있다 
-> 

## 필터설정 두가지 방식
* 서블릿 처럼 xml 로 설정
* 어노테이션으로 설정
* @WebFilter("/*"), 하나로 web.xml에서 여러 작업 매핑작업없이 설정할 수 있다.

## 입력데이터 배열로 받기
* 여러 name을 설정할경우 클래스에도 그 만큼 추가를 해야되기에 코드가 길어진다
* 같은 이름으로 보낼 수 있다.
같은 이름으로 보내면 배열로 받는다.
* 여기서 배열로 받을때는
 String[] num_ = request.getParameterValues("num");  == 이렇게 배열로 받기
 
 
## 상태 유지의 필요성
* 어플리케이션
* hidden input (나중)
* 쿼리 스트링 (나중)
* 세션
* 쿠키

## 어플리케이션 객체 ( 서블릿 컨텍스트 ) 
* 상태저장공간
* a 라는 결과물을 만들어 저장을 하면 b라는 서블릿이 a라는 결과물을 이어받아 새로운 결과물을 만들어낼수 있는 저장공간
 
 
## 세션
* 현재 접속한 사용자 마다 그 공간이 달라진다.

## 웹서버가 현재 사용자 세션을 구분하는 방식
* 브라우저 -> 요청 -> 어플리케이션 공간(개인별 사물함과 같은 공간) ->  

## 세션 메서드
* void setAttribute(String name, Object value) = 지정된 이름으로 객체를 설정
* Object getAttribute(String name) = 지정된 이름의 객체를 반환
* void invalidate() = 세션에서 사용되는 객체들을 바로 해제
* void setMaxinactiveInterval(int interval) = 세션타임아웃을 정수(초)로 설정
* boolean isNew() = 세션이 바로 생성되었는지 확인
* Long getCreationTime() = 세션이 시작된 시간을 반환, 1970년 1월 1일을 시작으로 하는 밀리초
* Long getLastAccessedTime()
* 마지막 요청시간, 1970 1월 1일을 시작으로 하는 밀리초

## cookie를 이용해서 상태 값 유지하기
* 상태값을 사물함에 두는것이 아닌 클라이언트가 가지고 다니는 것
* 헤더설정, 사용자데이터, 

## 쿠키의 path 옵션
* valuecookie.setPath("/Calc2");	
  opcookie.setPath("/Calc2");
			// add라는 경로만 가능

## cookie의 MaxAge옵션
* 브라우저가 닫히면 값도 날라간다.
* 쿠키는 원하는기간까지 해도록 설정하면 그때까지 저장이된다.	


## Application, Session, Cookie 정리
## Application
* 사용범위 : 전역범위에서 사용하는 공간
* 생명주기 : WAS가 시작해서 종료될때까지 
* 저장위치 : WAS 서버의 메모리

## Session
* 세션범위에서 사용하는 공간
* 세션이 시작해서 종료될때 까지
* WAS 서버의 메모리


## Cookie
* Web Browser별 지정된 Path 범주공간
* Browserdp 전달한 시간부터 만료시간까지
* Web Browser의 메모리 또는 파일
* 데이터를 유지해야하면 쿠리 사용


## 동적인 페이지(서버 페이지)의 필요성



## JSP에 코드 블럭
*  		<%%>
