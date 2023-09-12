package com.epam.mjc.collections.combined;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
    	Map<Integer, Set<String>> resultMap = new TreeMap<>();
    	Queue<String> myQueue = new LinkedList<>();
    	for (Map.Entry<String, Integer> iterable_element : sourceMap.entrySet()) {
			myQueue.add(iterable_element.getKey());
		} 
    	if (myQueue.isEmpty()) {
			return resultMap;
		}
    	while (!myQueue.isEmpty()) {
			if (!resultMap.containsKey(myQueue.peek().length())) {
				Set<String> setOfValues = new HashSet<>();
				setOfValues.add(myQueue.peek());
				resultMap.put(myQueue.peek().length(), setOfValues);
				myQueue.poll();
			} else  {
				Set<String> returnedSet = resultMap.get(myQueue.peek().length());
				returnedSet.add(myQueue.peek());
				resultMap.put(myQueue.peek().length(), returnedSet);
				myQueue.poll();
			} 
		}
    	return resultMap;
    }
}
