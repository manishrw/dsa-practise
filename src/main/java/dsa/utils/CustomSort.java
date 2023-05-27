package dsa.utils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CustomSort {
    public static <T extends Comparable<? super T>> List<List<T>> sortNestedLists(List<List<T>> listOfLists, Comparator<T> innerComparator, Comparator<List<T>> outerComparator) {
        List<List<T>> mutableOuterList = new ArrayList<>();

        // Sort the inner lists and add them to the output list
        for (List<T> innerList : listOfLists) {
            List<T> mutableInnerList = new ArrayList<>(innerList);
            mutableInnerList.sort(innerComparator);
            mutableOuterList.add(mutableInnerList);
        }

        // Sort the outer list
        mutableOuterList.sort(outerComparator);

        return mutableOuterList;
    }
}
