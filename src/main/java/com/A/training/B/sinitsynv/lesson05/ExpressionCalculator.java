package com.A.training.B.sinitsynv.lesson05;

class ExpressionCalculator {
    private StackForCalculator<Character> stackForCalculator = new StackForCalculator<>();
    private StringBuilder stringBuilder = new StringBuilder();

    String doTrans(String input) {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    stackForCalculator.push(ch);
                    break;
                case ')':
                    gotParen();
                    break;
                default:
                    stringBuilder.append(ch);
                    break;
            }
        }
        while (!stackForCalculator.isEmpty()) {
            stringBuilder.append(stackForCalculator.pop());
        }
        return stringBuilder.toString();
    }

    private void gotOper(char opThis, int prec1) {
        while (!stackForCalculator.isEmpty()) {
            char opTop = stackForCalculator.pop();
            if (opTop == '(') {
                stackForCalculator.push(opTop);
                break;
            } else {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else {
                    prec2 = 2;
                }
                if (prec2 < prec1) {
                    stackForCalculator.push(opTop);
                    break;
                } else {
                    stringBuilder.append(opTop);
                }
            }
        }
        stackForCalculator.push(opThis);
    }

    private void gotParen() {
        while (!stackForCalculator.isEmpty()) {
            char chx = stackForCalculator.pop();
            if (chx == '(') {
                break;
            } else {
                stringBuilder.append(chx);
            }
        }
    }

    private class StackForCalculator<E> extends LinkedListStack<E> {
        private int size = 0;

        @Override
        public void push(E e) {
            super.push(e);
            size++;
        }

        @Override
        public E pop() {
            size--;
            return super.pop();
        }

        boolean isEmpty() {
            return size == 0;
        }
    }
}
