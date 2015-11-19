package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Test {
	
	private static HashMap<String, Integer> th;
	private static String[] keys;
	private static ArrayList<Integer>[] adjList;

	public static boolean konektatuta(String a1, String a2){
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
	
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];
	
		aztertuak[pos1] = true;
		aztertuGabeak.add(pos1);
		
		while(!aurkitua && !aztertuGabeak.isEmpty()) {
				
			Integer egungoa = aztertuGabeak.remove();
			
			if (egungoa == pos2) {
				aurkitua = true;
			}
			else { 
				for(int i: adjList[egungoa]) {
					if(!aztertuak[i]){
						aztertuGabeak.add(i);
						aztertuak[i] = true;
					}
				}
			}
		
		}
		
		return aurkitua;
	}
	
	public static void main(String[] args) {
		th = new HashMap<String, Integer>();
		adjList = (ArrayList<Integer>[]) new ArrayList[10];
		keys = new String[10];
		
		th.put("Jolie", 0);
		th.put("Bardem", 1);
		th.put("Neeson", 2);
		th.put("Casino", 3);
		th.put("F&F", 4);
		th.put("Reeves", 5);
		
		keys[0] = "Jolie";
		keys[1] = "Bardem";
		keys[2] = "Neeson";
		keys[3] = "Casino";
		keys[4] = "F&F";
		keys[5] = "Reeves";
	
		
		adjList[0] = new ArrayList<>();
		adjList[0].add(3);
		
		adjList[1] = new ArrayList<>();
		adjList[1].add(3);
		adjList[1].add(4);
		
		adjList[2] = new ArrayList<>();
		adjList[2].add(3);
		
		adjList[3] = new ArrayList<>();
		adjList[3].add(0);
		adjList[3].add(1);
		adjList[3].add(2);
		
		adjList[4] = new ArrayList<>();
		adjList[4].add(1);
		adjList[4].add(5);
		
		adjList[5] = new ArrayList<>();
		adjList[5].add(4);

		System.out.println(new Test().konektatutaErlazioa("Casino", "Reeves").toString());
	}

	public ArrayList<String> konektatutaErlazioa(String a1, String a2){
		Integer[] nondik= new Integer[th.size()];
		Queue<Integer> aztertuGabeak = new LinkedList<Integer>();
		
		int pos1 = th.get(a1);
		int pos2 = th.get(a2);
		boolean aurkitua = false;
		boolean[] aztertuak = new boolean[th.size()];
	
		aztertuak[pos1] = true;
		nondik[pos1] = -1;
		aztertuGabeak.add(pos1);
		
		
		while(!aurkitua && !aztertuGabeak.isEmpty()) {
				
			Integer egungoa = aztertuGabeak.remove();
			
			if (egungoa == pos2) {
				aurkitua = true;
			}
			else { 
				for(int i: adjList[egungoa]) {
					if(!aztertuak[i]){
						aztertuGabeak.add(i);
						aztertuak[i]= true;
						nondik[i] = egungoa;
					}
				}
			}
		
		}
		if(!aurkitua){
			return null;
		}
		else{
			int j = pos2;
			ArrayList<String> eran = new ArrayList<String>();
			while(j!=pos1){
				eran.add(this.keys[j]);
				j = nondik[j];
			}
			eran.add(this.keys[j]);
			Collections.reverse(eran);
			return eran;
		}
		
		
	}
}
