package com.epam.mjc.collections.combined;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LessonsGetter {
    public Set<String> getLessons(Map<String, List<String>> timetable) {
    	Set<String> resultSet = new LinkedHashSet<>();
    	for (Map.Entry<String, List<String>> mapElement : timetable.entrySet()) {
			List<String> allLessons = mapElement.getValue();
			for (Iterator<String> iterator = allLessons.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				if (!resultSet.contains(string)) {
					resultSet.add(string);
				}
			}
		}
    	return resultSet;
    }
}
