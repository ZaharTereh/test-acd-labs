package by.acdlabs.task;

import java.util.List;

public class RecordComparator{

    public static int compare(List<String> firstRecord, List<String> secondRecord){
        String first = null;
        String second = null;

        int minNumberOfColumn = Math.min(firstRecord.size(), secondRecord.size());

        for (int i = 0; i < minNumberOfColumn; ++i){
            first = firstRecord.get(i);
            second = secondRecord.get(i);

            boolean isFirstNumber = isNumber(first);
            boolean isSecondNumber = isNumber(second);

            if(isFirstNumber && isSecondNumber){
                Integer firstInt = Integer.parseInt(first);
                Integer secondInt = Integer.parseInt(second);
                if (firstInt.compareTo(secondInt) > 0){
                    return 1;
                }else if(firstInt.compareTo(secondInt) < 0){
                    return -1;
                }
            }else if (!isFirstNumber && !isSecondNumber){
                if(first.compareTo(second) > 0){
                    return 1;
                }else if (first.compareTo(second) < 0){
                    return -1;
                }
            }else if(isFirstNumber & !isSecondNumber){
                return -1;
            }else {
                return 1;
            }
        }

        return Integer.compare(firstRecord.size(), secondRecord.size());

    }

    private static boolean isNumber(String string) throws NumberFormatException {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
