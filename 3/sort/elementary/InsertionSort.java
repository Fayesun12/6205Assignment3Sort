/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;


public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort(Config config) {
        this(new BaseHelper<>(DESCRIPTION, config));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    public InsertionSort() {
        this(BaseHelper.getHelper(InsertionSort.class));
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();
//        for(int i=from+1; i<=to-from-1; i++){
//            for(int j=i; j>from; j--){
//                if(helper.swapStableConditional(xs,j) ){
//                    X temp = xs[j];
//                    xs[j] = xs[j-1];
//                    xs[j-1] = temp;
//                }else{
//                    break;
//                }
//            }

//        boolean ifSort = helper.swapConditional(xs,from,to);
//        int length = to - from ;
//        for (int m = 1; m < length; m++) {
//            X key = xs[m];
//            int n = m-1;
//            while ( (n > -1) && (!helper.swapStableConditional(xs,m)) ) {
//                xs[n+1] = xs[n];
//                n--;
//            }
//            xs[n+1] = key;
//        }fanye sun
        for(int a = from + 1; a <  to - from; a++){
            for(int b = a; b > from && helper.compare(xs, b - 1, b) > 0; b-- ){
                helper.swap(xs, b - 1, b);
            }
        };

        // FIXME
        // END 
    }

    public static final String DESCRIPTION = "Insertion sort";

    public static <T extends Comparable<T>> void sort(T[] ts) {
        new InsertionSort<T>().mutatingSort(ts);
    }
}
