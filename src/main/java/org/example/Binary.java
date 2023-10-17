package org.example;

import java.util.ArrayList;

public class Binary {

    private ArrayList<Integer> searchList = new ArrayList<>();

    private int count = 0;

    private int recursionStart;
    private int recursionEnd;
    private int recursionSearchIndex = -1;

    public Binary() {
    }

    public void createList(int size, int increment) {
        for (int i = 0 ; i < size ; i++) {
            searchList.add(increment + increment * i);
        }
    }

    public ArrayList<Integer> getSearchList() {
        return searchList;
    }

    public int findIntegerIndexRecursion(int number ) {
        count++;

        if (recursionSearchIndex == -1) {
            recursionStart = 0;
            recursionEnd = searchList.size() - 1;
            recursionSearchIndex = (recursionEnd - recursionStart) / 2;
        } else {
            recursionSearchIndex = (recursionEnd - recursionStart) / 2;
        }

        //TODO - need to check for match with start and end
        if (recursionEnd - recursionStart <= 1) {
            if (searchList.get(recursionStart) == number) {
                return recursionStart;
            } else if (searchList.get(recursionEnd) == number) {
                return recursionEnd;
            } else {
                return -1;
            }
        }

        int result = searchList.get(recursionSearchIndex) - number;

        if (result == 0) {
            return recursionSearchIndex;
        } else if (result > 0) {
            recursionEnd = recursionSearchIndex;
            return findIntegerIndexRecursion(number);
        } else {
            recursionStart = recursionSearchIndex;
            return findIntegerIndexRecursion(number);
        }

    }

    public int findIntegerIndex(int number) {
        int searchIndex;
        int start = 0;
        int end = searchList.size() - 1;

        int result = -1;

        while (end - start > 1 ) {
            searchIndex = start + (end - start) / 2;

            result = searchList.get(searchIndex) - number;

            if (result == 0) {
                return searchIndex;
            } else if (result > 0) {
                end = searchIndex;
            } else {
                start = searchIndex;
            }
            count++;

        }

        //take care of edge case when start and end are 1 apart
        if (end - start <= 1) {
            count++;
            if (result > 0) {
                if (searchList.get(start) == number) {
                    return start;
                }
            }else {
                if (searchList.get(end) == number) {
                    return end;
                }
            }
            //start = end;
        }

        return -1;

    }



    public int getCount() {
        return count;
    }


}
