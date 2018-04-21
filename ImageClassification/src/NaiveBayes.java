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
		/*for(char[][] a : arrFace){
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
		}*/
		ArrayList<Structure> structArrList = new ArrayList<>();
		ArrayList<char[][]> justFaces = new ArrayList<>();
		ArrayList<char[][]> nonFaces = new ArrayList<>();
		for(int i = 0; i < arrLabels.size(); i++){
			if(arrLabels.get(i) == 1){
				Structure face = new Structure(arrFace.get(i), true);
				structArrList.add(face);
				justFaces.add(arrFace.get(i));
			}
			else {
				Structure nonface = new Structure(arrFace.get(i),false);
				structArrList.add(nonface);
				nonFaces.add(arrFace.get(i));
			}
		}
		int numFace = 0;
		for(int label : arrLabels){
			if(label == 1){
				numFace++;
			}
		}
		double ytrue = (double) numFace/451;
		double yfalse = (double)(451 - numFace)/451;
		double[][] probYTrue = new double[69][70];
		double[][] probYFalse = new double[69][70];
		int[] finalVals = new int[451];
		double finalYTrue = 1;
		double finalYFalse = 1;
		double finalResult = 0;
		int numCurrentLevelFace = 0;
		int numCurrentLevelNotFace = 0;
		int temp = 0;
		int w = 0;
		int numCorrect = 0;
		for(int i = 0; i < 69; i++){
			w = 0;
			temp = 0;
			numCurrentLevelFace = 0;
			numCurrentLevelNotFace = 0;
			for(int currentPixel = 0; currentPixel < 70; currentPixel++){
				numCurrentLevelFace = 0;
				numCurrentLevelNotFace = 0;
				for(int imageNum = 0; imageNum < structArrList.size(); imageNum++){
					temp = 0;
					for(int j = 0; j < 70; j++){
						if(structArrList.get(imageNum).arrList[i][j] == '#'){
							temp++;
						}
					}
					if(temp == currentPixel && structArrList.get(imageNum).face){
						numCurrentLevelFace++;
					}
					else if(temp == currentPixel && !structArrList.get(imageNum).face){
						numCurrentLevelNotFace++;
					}
				}
				probYTrue[i][w] = (double) numCurrentLevelFace/numFace;
				probYFalse[i][w] = (double) numCurrentLevelNotFace/numFace;
				if(probYTrue[i][w] == 0){
					probYTrue[i][w] = 0.01;
				}
				if(probYFalse[i][w] == 0){
					probYFalse[i][w] = 0.01;
				}
				w++;
			}
		}
		for(int imageNum = 0; imageNum < structArrList.size(); imageNum++){
			numCurrentLevelFace = 0;
			finalYTrue = 1;
			finalYFalse = 1;
			temp = 0;
			for(int i = 0; i < 69; i++){
				temp = 0;
				for(int j = 0; j < 70; j++){
					if(structArrList.get(imageNum).arrList[i][j] == '#'){
						temp++;
					}
				}
				finalYTrue *= (double) probYTrue[i][temp];
				finalYFalse *= (double) probYFalse[i][temp];
			}
			finalResult = (double) (finalYTrue * ytrue)/(finalYFalse * yfalse);
			if(finalResult >= 1){
				finalVals[imageNum] = 1;
			}
			else{
				finalVals[imageNum] = 0;
			}
		}
		
		for(int i = 0; i < 451; i++){
			if(finalVals[i] == arrLabels.get(i)){
				numCorrect += 1;
			}
		}
		double finalRes = (double) numCorrect/451*100;
		System.out.println("Accuracy: " + finalRes + " %");
		
		return 0;
	}
}
