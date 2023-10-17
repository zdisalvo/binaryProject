package org.example;

import java.util.ArrayList;

public class Binary {

    private ArrayList<Integer> searchList = new ArrayList<>();

    private int count = 0;

    public Binary() {
    }

    public void createList(int size, int increment) {
        for (int i = 0 ; i <= size ; i++) {
            searchList.add(increment + increment * i);
        }
    }

    public ArrayList<Integer> getSearchList() {
        return searchList;
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
