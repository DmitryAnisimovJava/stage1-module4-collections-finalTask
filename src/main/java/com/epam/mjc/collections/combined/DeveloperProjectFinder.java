package com.epam.mjc.collections.combined;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
    	List<String> projectsList = new ArrayList<>();
    	PriorityQueue<String> queueProjects = new PriorityQueue<>(new DeveloperOrderComparator());
    	for (Map.Entry<String, Set<String>> string : projects.entrySet()) {
			if (string.getValue().contains(developer)) {
				queueProjects.add(string.getKey());
			}
		}
    	while (!queueProjects.isEmpty()) {
			projectsList.add(queueProjects.poll());
		}
    	return projectsList;
    }
}

class DeveloperOrderComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		if (DeveloperOrderComparator.compareLenth(o1, o2) != 0) {
			return DeveloperOrderComparator.compareLenth(o1, o2);
		} else {
			return -(o1.compareTo(o2));
		}
	}
	static int compareLenth(String o1, String o2) {
		if (o1.length() < o2.length()) {
			return 1;
		} else if (o1.length() > o2.length()) {
			return -1;
		} else {
			return 0;
		}
	}
}