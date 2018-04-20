import java.util.ArrayList;

public class NaiveBayes {
	public static int naiveBayesDigit(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels){
		for(char[][] a : arrDigit){
			for(int b = 0; b < 30; b++){
				for(int c = 0; c < 30; c++){
					System.out.print(a[b][c]);
				}
				System.out.println();
			}
		}
		System.out.println("Number of Images: " + arrDigit.size());
		System.out.println("Number of Labels: " + arrLabels.size());
		System.out.println("Something's Wrong!");
		if(arrDigit.size() != arrLabels.size()){
			System.out.println("Number of Images: " + arrDigit.size());
			System.out.println("Number of Labels: " + arrLabels.size());
			System.out.println("Something's Wrong!");
		}
		return 0;
	}
	public static int naiveBayesFace(ArrayList<char[][]> arrFace, ArrayList<Character> arrLabels){
		for(char[][] a : arrFace){
			for(int b = 0; b < 69; b++){
				for(int c = 0; c < 70; c++){
					System.out.print(a[b][c]);
				}
				System.out.println();
			}
		}
		if(arrFace.size() != arrLabels.size()){
			System.out.println("Number of Images: " + arrFace.size());
			System.out.println("Number of Labels: " + arrLabels.size());
			System.out.println("Something's Wrong!");
		}
		int numFace = 0;
		for(char label : arrLabels){
			if(label == '1'){
				numFace++;
			}
		}
		
		return 0;
	}
}
