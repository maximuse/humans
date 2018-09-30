package hu.nyirszikszi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		ArrayList<Integer> years = new ArrayList<>();
		ArrayList<String> jobs = new ArrayList<>();
		
		try {
			Scanner s = new Scanner(new File("list.txt"));
			
			while (s.hasNext()) {
				String line = s.nextLine();
				
				String[] array = line.split(";");
				names.add(array[0]);
				years.add(Integer.parseInt(array[1]));
				jobs.add(array[2]);
			}
			
			s.close();
		}
		catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.print("A legfiatalabb munkatárs: ");
		theYoungestWorker(names, years, jobs);
		System.out.println();
		getWorkerName("designer", names, jobs);
		getWorkerName("titkárnó", names, jobs);
	}
	
	private static void theYoungestWorker (ArrayList<String> names, ArrayList<Integer> years, ArrayList<String> jobs) {
		int year = years.get(0);
		Integer index = null;
		
		for (int i = 0; i < years.size(); i++) {
			if (year < years.get(i)) {
				year = years.get(i);
				index = i;
			}
		}
		
		if (index != null) {
			System.out.println(names.get(index) + " (" + years.get(index) + ") - " + jobs.get(index));
		}
	}
	
	private static void getWorkerName (String job, ArrayList<String> names, ArrayList<String> jobs) {
		Integer index = null;
		
		for (int i = 0; i < jobs.size(); i++) {
			if (job.equals(jobs.get(i))) {
				index = i;
			}
		}
		
		if (index == null) {
			System.out.println("Nincs találat a(z) \"" + job + "\" kifejezésre.");
		}
		else {
			System.out.println(names.get(index) + " (" + job + ")");
		}
	}
}