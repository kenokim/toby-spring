## 토비의 스프링 스터디
### 1.
https://www.youtube.com/watch?v=oR1sYfmMQrI



- Spring app daemon 을 계속 실행하지 않고 바로 종료하는 코드
-> try with resource 로 run 을 한다.
- Bean 은 메소드 결과를 스프링 오브젝트로 사용하겠다는 어노테이션
- ApplicationRunner 를 bean 으로 등록하여 실행 후 바로 종료되는 어플리케이션을 만들 수 있다.




Reactive-streams
iterable 과 observable 은 duality 관계
Complete 개념, 예외처리 기능이 없다.


Observer pattern : 객체 사이에 일대 다의 의존관계를 정의해 두어, 객체의 상태가 변할 때 그 객체에 의존성을 가진 다른 객체들이 알림을 받을 수 있도록 한다.



Spring 5 에서 WebFlux 가 도입되었다.

Spring web vs Reactive - 서로 배타적이며 web 이 우선으로, dispatcherservlet 이 뜰 경우 embedded tomcat 이 실행된다.

AsyncRestTemplate 은 spring 5 에서 deprecated, 6 에서는 삭제되었고 reactive style 이 아니라는 단점이 있었다.

WebClient 가 이를 대체하였고, 비동기 논블로킹 기능을 가진 reactive style 의 기능이다.

스프링 부트는 스프링을 기반으로 실무 환경에 사용 가능한 수준의 standalone 어플리케이션을 빠르게 작성할 수 있도록 도와준다.
