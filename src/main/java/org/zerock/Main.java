package org.zerock;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("첫번째 정수를 입력하세요.");
        int firstNum = scanner.nextInt();
        System.out.print("두번째 정수를 입력하세요.");
        int secondNum = scanner.nextInt();

        System.out.println("연산 기호를 입력하세요(+, -, *, /)");
        char c = scanner.next().charAt(0);

        switch (c)
            {
            case '+': {
                System.out.println(firstNum + secondNum);
                break;}
            case '-': {
                System.out.println(firstNum - secondNum);
                break;
            }
            case '*': {
                System.out.println(firstNum * secondNum);
                break;
            }
            case '/': {
                if(secondNum == 0 ){
                    System.out.println("0으로 나눌 수 없습니다.");
                    break;
                }
                System.out.println(firstNum / secondNum);
                break;
            }
            }

        }
    }
