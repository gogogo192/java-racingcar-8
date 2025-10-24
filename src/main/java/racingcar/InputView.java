package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] carNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        String[] carNames = input.split(",");
        for(int i=0; i< carNames.length; i++){
            carNames[i] = carNames[i].trim();
            if (carNames[i].isEmpty() || carNames[i].length() > 5)
                throw new IllegalArgumentException("자동차 이름은 1~5글자여야 합니다.");
        }
        return carNames;
    }
    public int playInput(){
        while (true) {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String input = Console.readLine();
            if (!isNumeric(input)) {
                throw new IllegalArgumentException("숫자를 입력해야 합니다.");

            }
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        }
    }
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }

        return true;
    }
}
