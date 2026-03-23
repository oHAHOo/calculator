package org.zerock;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AppCalculator calculator = new AppCalculator();
        String result;
        int menu;

        while (true) {
            //메뉴 출력
            System.out.println("메뉴를 선택하세요.\n");
            System.out.println("1. 계산 하기");
            System.out.println("2. 저장된 계산 결과 출력");
            System.out.println("3. 최근 계산 결과 삭제");
            System.out.println("4. 프로그램 종료");

            //메뉴 번호 입력
            menu = scanner.nextInt();

            //4입력시 프로그램 종료
            if(menu==4)break;

            switch(menu){
                case 1:{//계산하기
                    while(true){
                        try{
                            //첫번째 수 입력
                            System.out.print("첫번째 정수를 입력하세요.");
                            int firstNum = scanner.nextInt();
                            //두번째 수 입력
                            System.out.print("두번째 정수를 입력하세요.");
                            int secondNum = scanner.nextInt();

                            //연산자 입력
                        System.out.println("연산 기호를 입력하세요(+, -, *, /)");
                        char c = scanner.next().charAt(0);

                        switch (c)
                        {
                            case '+': { //덧셈
                                result = firstNum + " " + c + " " + secondNum + " = " + (firstNum + secondNum);
                                System.out.println(result);
                                calculator.setList(result);
                                break;}
                            case '-': { //뺄셈
                                result = firstNum + " " + c + " " + secondNum + " = " + (firstNum - secondNum);
                                System.out.println(result);
                                calculator.setList(result);
                                break;
                            }
                            case '*': { //곱셈
                                result = firstNum + " " + c + " " + secondNum + " = " + (firstNum * secondNum);
                                System.out.println(result);
                                calculator.setList(result);
                                break;
                            }
                            case '/': { //나눗셈
                                if(secondNum == 0 ){ //0으로 나누기 방지
                                    System.out.println("0으로 나눌 수 없습니다.");
                                    break;
                                }
                                result = firstNum + " " + c + " " + secondNum + " = " + (firstNum / secondNum);
                                System.out.println(result);
                                calculator.setList(result);
                                break;
                            }default: //지원하지 않는 연산자 입력시
                            System.out.println("지원하지 않는 연산자 입니다.");

                        }

                        System.out.println("계속 진행하려면 아무 글자나 입력하세요.(계산을 종료하려면 exit를 입력하세요)");
                        String answer = scanner.next();
                        if(answer.equals("exit")){//exit를 입력하면 계산 종료
                            break;
                        }
                        }catch(InputMismatchException e){
                            //정수가 아닐경우 예외 처리
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
