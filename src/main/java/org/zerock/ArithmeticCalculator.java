package org.zerock;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArithmeticCalculator {

    public <T extends Number> double calculate(T a, T b,char operation){
        double firstNum = a.doubleValue(); //입력받은 첫번째 숫자를 실수로 변환
        double secondNum = b.doubleValue(); //입력받은 두번째 숫자를 실수로 변환
        switch (operation){//연산자에 따라 enum에 등록된 계산 실행
            case '+': return OperatorType.ADD.apply(firstNum,secondNum);

            case '-': return OperatorType.SUBTRACT.apply(firstNum,secondNum);

            case '*': return OperatorType.MULTIPLY.apply(firstNum,secondNum);

            case '/': {
                if(secondNum == 0){ //0으로 나누기 예외 처리
                    throw new ArithmeticException("0으로 나눌 수 없습니다");
                }
                return OperatorType.DIVIDE.apply(firstNum,secondNum);
            }//지원하지 않는 연산자 예외 처리
            default: throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + operation);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        ArithmeticCalculator  arithmeticCalculator = new ArithmeticCalculator();
        double result;
        int menu;
        String output;

        while (true) {
            //메뉴 출력
            System.out.println("메뉴를 선택하세요.\n");
            System.out.println("1. 계산 하기");
            System.out.println("2. 저장된 계산 결과 출력");
            System.out.println("3. 최근 계산 결과 삭제");
            System.out.println("4. 입력받은 값보다 큰 결과값 출력");
            System.out.println("5. 프로그램 종료");

            try{//메뉴에 문자입력 예외처리
                menu = Integer.parseInt(scanner.nextLine());}
            catch(NumberFormatException e){
                System.out.println("1~5사이의 숫자를 입력하세요");
                continue;}

            //5 입력시 프로그램 종료
            if(menu==5)break;

            switch(menu){
                case 1:{//계산하기
                    while(true){
                        try{//숫자 입력
                            System.out.print("첫번째 숫자를 입력하세요.");
                            double firstNum = Double.parseDouble(scanner.nextLine());
                            System.out.print("두번째 숫자를 입력하세요.");
                            double secondNum = Double.parseDouble(scanner.nextLine());

                            //연산자 입력
                            System.out.println("연산 기호를 입력하세요(+, -, *, /)");
                            char operation = scanner.nextLine().charAt(0);

                            //계산 실행
                            result = arithmeticCalculator.calculate(firstNum, secondNum, operation);
                            //출력할 메시지 생성
                            output = firstNum + " " + operation + " " + secondNum + " = " + result;
                            //결과 출력
                            System.out.println(output);
                            //결과값 저장
                            calculator.setList(result);

                            System.out.println("계속 진행하려면 아무 글자나 입력하세요.(계산을 종료하려면 exit를 입력하세요)");
                            String answer = scanner.next();
                            if(answer.equals("exit")){//exit를 입력하면 계산 종료
                                break;
                            }
                        }catch(NumberFormatException e){
                            //숫자 입력에 문자 입력시 예외처리
                            System.out.println("숫자를 입력하세요\n");
                            break;
                        }
                    }break; //1.계산하기 종료
                }
                case 2:{//저장된 연산 결과 출력
                    System.out.println(calculator.getList());
                    break;
                }
                case 3:{//최근 연산 결과 삭제
                    if(calculator.getList().isEmpty()){
                        System.out.println("저장된 결과가 없습니다");
                        break;
                    }
                    System.out.println("최근 연산 결과를 삭제했습니다.");
                    calculator.deleteList();
                    break;
                }
                case 4:{//특정 값보다 큰 결과 추출
                    System.out.println("값을 입력하세요");
                    double input =  Double.parseDouble(scanner.nextLine());
                    List<Double> list = calculator.getList().stream()
                            .filter(n -> n > input)
                            .collect(Collectors.toList());
                    System.out.println(list);
                    break;
                }
                default:
                    //존재하지 않는 메뉴 선택시
                    System.out.println("존재하지 않는 메뉴 입니다.");
                    continue;
            }
        }
    }
}
