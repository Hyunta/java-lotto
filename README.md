## 로또 미션 기능 구현 목록
[x] 구입 금액을 입력받는 기능
[ ] 입력받은 금액만큼 로또를 구매하는 기능
  [x] 구매할 개수를 구하는 기능
  [ ] 랜덤하게 1~45 사이의 숫자 6개를 뽑는 기능
  [ ] 뽑은 숫자를 오름차순으로 정렬하는 기능
[ ] 당첨 번호를 입력받는 기능
  [ ] 입력 문자열을 쉼표 기준으로 분리 
[ ] 보너스 번호를 입력받는 기능
[ ] 당첨 통계를 도출하는 기능
  [ ] 각각의 로또가 당첨인지 판별하는 기능
  [ ] 등수별 로또 개수를 구하는 기능
  [ ] 수익률을 계산하는 기능

## 예외 처리
[x] 구입 금액
  [x] 숫자가 아닌 값을 입력하는 경우
  [x] 1000원 미만이 들어왔을 경우
  [x] 단위가 1000원이 아닐 경우
  - 당첨 번호
    - 6개를 입력했는지
    - 숫자로 입력했는지? 
    - 입력값이 범위 내에 있는지(1~45)
    - 중복되는 값이 있는지
  - 보너스 볼
    - 숫자로 입력했는지
    - 입력값이 범위 내에 있는지(1~45)
    - 당첨 번호와 중복되지 않는지

## 프로그래밍 요구 사항

- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
  - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
  - else 예약어를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  - 힌트: if문에서 값을 반환하는 방식으로 구현하면 else 예약어를 사용하지 않아도 된다.

## 추가된 요구 사항

- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 배열 대신 컬렉션을 사용한다.
- Java Enum을 적용한다.
- 모든 원시 값과 문자열을 포장한다.
- 줄여 쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.
