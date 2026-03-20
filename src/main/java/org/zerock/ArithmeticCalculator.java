package org.zerock;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticCalculator {

    public <T extends Number> double calculate(T a, T b,char operation){
        double firstNum = a.doubleValue();
        double secondNum = b.doubleValue();
        switch (operation){
            case '+': return OperatorType.ADD.apply(firstNum,secondNum);

            case '-': return OperatorType.SUBTRACT.apply(firstNum,secondNum);

            case '*': return OperatorType.MULTIPLY.apply(firstNum,secondNum);

            case '/': {
                if(secondNum == 0){
                    throw new ArithmeticException("0으로 나눌 수 없습니다");
                }
                return OperatorType.DIVIDE.apply(firstNum,secondNum);
            }
            default: return 0;
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
            System.out.println("메뉴를 선택하세요.\n");
            System.out.println("1. 계산 하기");
            System.out.println("2. 저장된 계산 결과 출력");
            System.out.println("3. 최근 계산 결과 삭제");
            System.out.println("4. 프로그램 종료");
            menu = Integer.parseInt(scanner.nextLine());

            if(menu==4)break;

            switch(menu){
                case 1:{//계산하기
                    while(true){
                        try{
                            System.out.print("첫번째 숫자를 입력하세요.");
                            double firstNum = Double.parseDouble(scanner.nextLine());
                            System.out.print("두번째 숫자를 입력하세요.");
                            double secondNum = Double.parseDouble(scanner.nextLine());

                            System.out.println("연산 기호를 입력하세요(+, -, *, /)");
                            char operation = scanner.nextLine().charAt(0);

                            result = arithmeticCalculator.calculate(firstNum, secondNum, operation);
                            output = firstNum + " " + operation + " " + secondNum + " = " + result;
                            System.out.println(output);
                            calculator.setList(output);

                            System.out.println("계속 진행하려면 아무 글자나 입력하세요.(계산을 종료하려면 exit를 입력하세요)");
                            String answer = scanner.next();
                            if(answer.equals("exit")){//exit를 입력하면 계산 종료
                                break;
                            }
                        }catch(NumberFormatException e){
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
                default:
                    System.out.println("존재하지 않는 메뉴 입니다.");
                    continue;
            }
        }
    }
}
