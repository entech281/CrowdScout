package com.crowdscout.utils;

import java.util.HashMap;
import java.util.Map;

public class _2DLookupTable{
    private final Map<String, Integer> keysToIndexes;
    private final double[][] values;


    public _2DLookupTable(String[] keys, double[][] values){
        if(keys.length == 0)
            throw new IllegalArgumentException("Cannot create instance of _2DLookupTable with empty key set");
        if(values.length == 0)
            throw new IllegalArgumentException("Cannot create instance of _2DLookupTable with empty value table");
        if(values.length != values[0].length)
            throw new IllegalArgumentException("Cannot create instance of _2DLookupTable having value table with a different width and height");
        if(values.length != keys.length)
            throw new IllegalArgumentException("Cannot create instance of _2DLookupTable where the number of keys and the width of the table is different");
        keysToIndexes = new HashMap<String, Integer>();
        for(int i = 0; i < keys.length; i ++){
            keysToIndexes.put(keys[i], i);
        }
        this.values = values;
    }


    /**
     * @param fileName the location of the file to be desierialized
     * The file must follow the example format
     * 
     * key1,key2,key3
     * # We're using ints for the values of this table
     * 1 3 2
     * 2 1 4
     * 3 2 5
     * @return the desierialized lookup table.
     */
        
    public static _2DLookupTable loadFromFile(String fileName){
        return null;
    }

    public double getValue(String row, String column){
        return values[ keysToIndexes.get(row) ][ keysToIndexes.get(column) ];
    }

}