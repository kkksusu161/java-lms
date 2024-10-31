## 질문 삭제하기 규칙
- 질문 데이터를 완전히 삭제하는 것이 아니라 데이터의 상태를 삭제 상태(deleted - boolean type)로 변경한다.<br>
- 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다.<br>
- 답변이 없는 경우 삭제가 가능하다.<br>
- 질문자와답변글의모든답변자같은경우삭제가가능하다.<br>
- 질문을 삭제할 때 답변 또한 삭제해야 하며, 답변의 삭제 또한 삭제 상태(deleted)를 변경
한다.<br>
- 질문자와답변자가다른경우답변을삭제할수없다.<br>
- 질문과 답변 삭제 이력에 대한 정보를 DeleteHistory를 활용해 남긴다.<br>


## 리팩터링 요구사항
- nextstep.qna.service.QnaService의 deleteQuestion()는 앞의 질문 삭제 기능을 구현한 코드이다. 이 메소드는 단위 테스트하기 어려운 코드와 단위 테스트 가능한 코드가 섞여 있다.<Br>
-[x] QnaService의 deleteQuestion() 메서드에 단위 테스트 가능한 코드(핵심 비지니스 로직)를 도메인 모델 객체에 구현한다.<Br>
-[x] QnaService의 비지니스 로직을 도메인 모델로 이동하는 리팩터링을 진행할 때 TDD로 구현한다.<Br>
-[x] QnaService의 deleteQuestion() 메서드에 대한 단위 테스트는 src/test/java 폴더 nextstep.qna.service.QnaServiceTest이다. 도메인 모델로 로직을 이동한 후에도 QnaServiceTest의 모든 테스트는 통과해야 한다.<Br>

## TODO
- [x] 일급 콜렉션으로 구현해 본다 -> Answers / DeleteHistorys
- [x] 인스턴스 변수의 수를 줄이기 위해 도전한다 -> QuestionBoard
  - Question의 Content와 Title을 묶어보기
- [x] QnaService deleteQuestion()를 줄여본다.
- [x] 각 도메인 객체 테스트 추가

## Hint
객체의 상태 데이터를 꺼내지(get)말고 메시지를 보낸다.<br>
규칙 8: 일급 콜렉션을 쓴다.<br>  
Question의 List를 일급 콜렉션으로 구현해 본다.<br>
규칙 7: 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.<br>
인스턴스 변수의 수를 줄이기 위해 도전한다.<br>
도메인 모델에 setter 메서드 추가하지 않는다.<br>
