package org.zerock;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int result;
        int menu;
        String output;

        while (true) {
            System.out.println("메뉴를 선택하세요.\n");
            System.out.println("1. 계산 하기");
            System.out.println("2. 저장된 계산 결과 출력");
            System.out.println("3. 최근 계산 결과 삭제");
            System.out.println("4. 프로그램 종료");
            menu = scanner.nextInt();

            if(menu==4)break;

            switch(menu){
                case 1:{//계산하기
                    while(true){
                        try{
                            System.out.print("첫번째 정수를 입력하세요.");
                            int firstNum = scanner.nextInt();
                            System.out.print("두번째 정수를 입력하세요.");
                            int secondNum = scanner.nextInt();

                            System.out.println("연산 기호를 입력하세요(+, -, *, /)");
                            char c = scanner.next().charAt(0);

                            switch (c)
                            {
                                case '+': {
                                    result = OperatorType.ADD.apply(firstNum,secondNum);
                                    output = firstNum + " " + c + " " + secondNum + " = " + result;
                                    System.out.println(output);
                                    calculator.setList(output);
                                    break;}
                                case '-': {
                                    result = OperatorType.SUBTRACT.apply(firstNum,secondNum);
                                    output = firstNum + " " + c + " " + secondNum + " = " + result;
                                    System.out.println(output);
                                    calculator.setList(output);
                                    break;
                                }
                                case '*': {
                                    result = OperatorType.MULTIPLY.apply(firstNum,secondNum);
                                    output = firstNum + " " + c + " " + secondNum + " = " + result;
                                    System.out.println(output);
                                    calculator.setList(output);
                                    break;
                                }
                                case '/': {
                                    if(secondNum == 0 ){ //0으로 나누기 방지
                                        System.out.println("0으로 나눌 수 없습니다.");
                                        break;
                                    }
                                    result = OperatorType.DIVIDE.apply(firstNum,secondNum);
                                    output = firstNum + " " + c + " " + secondNum + " = " + result;
                                    System.out.println(output);
                                    calculator.setList(output);
                                    break;
                                }default:
                                System.out.println("지원하지 않는 연산자 입니다.");

                            }

                            System.out.println("계속 진행하려면 아무 글자나 입력하세요.(계산을 종료하려면 exit를 입력하세요)");
                            String answer = scanner.next();
                            if(answer.equals("exit")){//exit를 입력하면 계산 종료
                                break;
                            }
                        }catch(InputMismatchException e){
                            System.out.println("정수를 입력하세요\n");
                            scanner.next();
                            break;
                        }
                    }break; //1.계산하기 종료
                }
                case 2:{//저장된 연산 결과 출력
                    System.out.println(calculator.getList());
                    break;
                }
                case 3:{//최근 연산 결과 삭제
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
