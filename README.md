# 🎯 프리코스 1주차 과제 - 문자열 덧셈 계산기

> 내용이 추가 또는 수정될 수 있다.

## 🚀 기능 구현 목록
> - 기능 작동 순서대로 작성한다.
>
> - 스스로 판단한 내용은 (`판단`) 이라고 표시한다.
>   - 판단한 내용에 대한 이유를 설명한다.
>
> - 기능을 구현했다면 해당 기능 목록에 체크한다.

### 1. 사용자로부터 문자열을 입력받는다.
- [x] 사용자로부터 문자열을 입력받는다.

### 2. 입력값을 검증한다.
- [x] 입력값이 null 이면 예외를 발생시킨다. (`판단`: 사용자의 입력 실수 고려)
- [x] 입력값이 올바른 형식인지 확인한다.
  - [x] 입력값 양쪽의 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)
  - [x] 입력값이 입력 형식에 맞지 않으면 예외를 발생시킨다.

### 3. 커스텀 구분자를 지정했다면 기본 구분자에 커스텀 구분자를 추가한다.
- [x] 입력값의 양쪽 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)
- [x] 사용자가 커스텀 구분자를 지정했는지 확인한다.
- [x] 입력값으로부터 커스텀 구분자를 추출한다.
- [x] 커스텀 구분자를 기본 구분자에 추가한다. (`판단`: 사용자가 기본 구분자와 커스텀 구분자 모두 사용할 있도록 구현)

### 4. 입력값으로부터 분리해야 할 문자열을 추출 후 구분자로 분리한다.
- [x] 입력값으로부터 분리해야 할 문자열을 추출한다.
- [x] 추출한 문자열을 구분자로 분리한다.

### 5. 분리한 값들을 검증한다.
- [x] 값 양쪽의 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)
- [x] 값이 숫자가 아니면 예외를 발생시킨다.

### 6. 분리한 값들을 양수로 변환한다.
- [x] 분리한 값들의 양쪽 공백을 제거한다. (`판단`: 사용자의 입력 실수 고려)
- [x] 분리한 값들을 양수로 변환한다.

### 7. 값들을 모두 더해 결과를 산출한다.
- [x] 값들을 모두 더해 결과를 산출한다.

### 8. 결과를 출력한다.
- [x] 결과를 출력한다.

## 🔍 테스트 코드 구현 목록
> 테스트가 정상적으로 통과하면 해당 테스트 목록에 체크한다.

### 1. ApplicationTest
### 정상 입력
- [x] 기본 구분자인 쉼표(`,`)와 콜론(`:`)을 구분자로 사용한 경우
    - [x] 양쪽에 공백을 포함한 경우
    - [x] 값 사이에 공백을 포함한 경우
- [x] 커스텀 구분자를 1개 지정한 경우
    - [x] 세미콜론(`;`)으로 지정한 경우
    - [x] 공백(` `)으로 지정한 경우 (`판단`: 커스텀 구분자의 문자 수용 범위에 대한 확장성 고려)
    - [x] 숫자로 지정한 경우 (`판단`: 커스텀 구분자의 문자 수용 범위에 대한 확장성 고려)
    - [x] 백슬래시(`\`)로 지정한 경우 (`판단`: 커스텀 구분자의 문자 수용 범위에 대한 확장성 고려)
- [x] 커스텀 구분자를 여러개 지정한 경우 (`판단`: 커스텀 구분자의 개수에 대한 확장성 고려)
    - [x] 세미콜론(`;`)과 느낌표(`!`)로 지정한 경우
    - [x] 공백(` `)과 숫자로 지정한 경우
    - [x] 숫자 2개 이상으로 지정한 경우
- [x] 구분자를 연속으로 2개 이상 입력한 경우 (`판단`: 사용자의 입력 실수 고려)
- [x] 구분자가 맨 앞이나 맨 뒤에 입력된 경우 (`판단`: 사용자의 입력 실수 고려)
- [x] 한 개 이상의 공백만 입력한 경우 (문제 요구 조건 + `판단`: 입력값 양쪽의 공백 제거하므로 결론적으로 동일)
- [x] 정수의 최댓값(2,147,483,647) 이상의 숫자가 입력된 경우 정상 작동(`판단`: 정수 오버플로우로 인해 예외 발생하지 않도록 구현)
- [x] 숫자만 입력한 경우 (`판단`: 구분자를 사용하지 않는 경우 고려)

### 예외 발생
- [x] 커스텀 구분자로 ""(아무것도 존재하지 않는 문자열)를 지정한 경우  (`판단`: 1개 이상의 문자만이 구분자로 지정 가능)
- [x] 0이 입력된 경우 (`판단`: 문제 조건에서 '양수'만 입력 가능 언급)
- [x] 음수가 입력된 경우
- [x] 음수만 입력한 경우 (`판단`: 문제 조건에서 '양수'만 입력 가능 언급)
- [x] 커스텀 구분자를 지정하는데, `//.*\\n` 패턴이 맨앞에 오지 않는 경우
- [x] 커스텀 구분자를 지정하는데, 커스텀 구분자 지정 패턴이 뒤에 또 다시 나오는 경우

## ✅ 요구 사항 체크
### 과제 진행 요구 사항
- [x] 미션은 문자열 덧셈 계산기 저장소를 포크하고 클론하는 것으로 시작한다.
- [x] 기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리해 추가한다.
- [x] Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
  - [x] AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.
- [x] 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

### 기능 요구 사항
입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.
- [x] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
  - [x] 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6
- [x] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
  - [x] 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- [x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

#### 입출력 요구 사항
##### 입력
- [x] 구분자와 양수로 구성된 문자열
##### 출력
- [x] 덧셈 결과

### 프로그래밍 요구 사항
- [x] JDK 21 버전에서 실행 가능해야 한다.
- [x] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [x] `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [x] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [x] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - [x] 기본적으로 Java Style Guide를 원칙으로 한다.
#### 라이브러리
- [x] `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
  - [x] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console의 readLine()`을 활용한다.

## 📝 구현 코드 명세
| Class                               | Field&Method                                                 | Role(Responsibility)                                         |
|-------------------------------------|--------------------------------------------------------------|--------------------------------------------------------------|
| calculator.Calculator               | public BigInteger calculate(String input)                    | 입력된 문자애 대한 검증 및 파싱을 통한 계산 결과를 얻는 메인 로직                       |
| calculator.data.Number              | private final BigInteger number                              | 하나의 값을 저장하는 변수                                               |
|                                     | public Number(String value)                                  | 생성자 내에서 검증 및 문자를 숫자로 변환                                      |
|                                     | public BigInteger getNumber()                                | 결과값 계산을 위한 값 반환                                              |
|                                     | public static void validateValue(String value)               | 양수 형태의 문자열인지 검증                                              |
| calculator.data.Numbers             | private final List<Number> numbers                           | Number 객체를 리스트로 저장하는 변수                                      |
|                                     | public BigInteger calculateSum()                             | 리스트에 있는 Number 객체가 가진 값을 모두 더함                               |
| calculator.data.InputParser         | private final String input                                   | 사용자의 입력값을 저징하는 변수                                            |
|                                     | public InputParser(String input)                             | 생성자 내에서 입력값 검증                                               |
|                                     | private static void validateNull(String input)               | 입력값이 null인지 검증                                               |
|                                     | private static void validateInputFormat(String input)        | 입력값의 입력 형식이 올바른지 검증                                          |
|                                     | public Target getTargetIfCustom()                            | 사용자가 커스텀 구분자를 지정했다면 커스텀 구분자를 추출해 기본 구분자에 추가하고, 타겟 문자열을 추출해서 반환 |
| calculator.data.Target              | private final String target                                  | 타겟 문자열을 저장하는 변수                                              |
|                                     | public Numbers split()                                       | 타겟 문자열을 구분자로 분리                                              |
| calculator.data.Format              | public static boolean isCustom(String input)                 | 문자열이 커스텀 구분자를 지정한 형식인지 판단                                    |
|                                     | public static int getCustomDelimiterBeginIndex(String input) | 문자열에서 커스텀 구분자의 처음 위치를 찾아서 반환                                 |
|                                     | public static int getCustomDelimiterEndIndex(String input)   | 문자열에서 커스텀 구분자의 마지막 위치를 찾아서 반환                                |
|                                     | public static int getTargetBeginIndex(String input)          | 문자열에서 타겟 문자열의 처음 위치를 찾아서 반환                                  |
|                                     | public static boolean isNotValidInputFormat(String input)    | 입력값의 입력 형식이 올바른지 확인                                          |
|                                     | public static boolean isNotValidNumberFormat(String value)   | 하나의 양수값의 형식이 올바른지 확인                                         |
| calculator.data.Delimiter           | private String delimiter                                     | 구분자를 저장하는 변수                                                 |
|                                     | public void add(String customDelimiter)                      | 커스텀 구분자를 기본 구분자에 추가                                         |
|                                     | public Numbers splitAndMapToNumbers(String target)           | 타겟 문자열을 구분자로 분리한 후, 각 값을 이용해 Number 객체를 생성 하고 리스트로 만들어서 Numbers 객체로 반환 |
|                                     | private void wrap()                                          | 구분자를 `[]`로 감싸줌                                               |
| calculator.util.Extractor           | public static String extractCustomDelimiter(String input)    | 문자열에서 커스텀 구분자를 추출                                            |
|                                     | public static String extractTarget(String input)             | 문자열에서 타겟 문자열을 추출                                             |
| calculator.util.NumberConverter     | public static BigInteger convertStringToNumber(String value) | 문자열을 숫자로 변환                                                  |
| calculator.io.Input                 | public String readInput()                                    | 사용자의 입력 값을 받음                                                |
| calculator.io.Output                | public void printResult(BigInteger result)                   | 결과값을 출력                                                      |
| calculator.error.ErrorMessage(Enum) | INVALID_INPUT_ERROR, INPUT_FORMAT_ERROR                      | 에러 메시지를 저장                                                   |
|                                     | public String getErrorMessage()                              | 에러 메시지를 반환                                                   |