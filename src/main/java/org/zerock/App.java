package org.zerock;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        String result;

        while(true){
            System.out.print("첫번째 정수를 입력하세요.");
            int firstNum = scanner.nextInt();
            System.out.print("두번째 정수를 입력하세요.");
            int secondNum = scanner.nextInt();

            System.out.println("연산 기호를 입력하세요(+, -, *, /)");
            char c = scanner.next().charAt(0);

            switch (c)
            {
                case '+': {
                    result = firstNum + " " + c + " " + secondNum + " = " + (firstNum + secondNum);
                    System.out.println(result);
                    calculator.setList(result);
                    break;}
                case '-': {
                    result = firstNum + " " + c + " " + secondNum + " = " + (firstNum - secondNum);
                    System.out.println(result);
                    calculator.setList(result);
                    break;
                }
                case '*': {
                    result = firstNum + " " + c + " " + secondNum + " = " + (firstNum * secondNum);
                    System.out.println(result);
                    calculator.setList(result);
                    break;
                }
                case '/': {
                    if(secondNum == 0 ){
                        System.out.println("0으로 나눌 수 없습니다.");
                        break;
                    }
                    result = firstNum + " " + c + " " + secondNum + " = " + (firstNum / secondNum);
                    System.out.println(result);
                    calculator.setList(result);
                    break;
                }
            }

            System.out.println("계속 진행하시겠습니까? (종료하려면 exit를 입력하세요)");
            String answer = scanner.next();
            if(answer.equals("exit")){
                scanner.close();
                break;
            }
        }



        }
    }
