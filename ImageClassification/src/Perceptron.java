import java.util.ArrayList;

public class Perceptron {
	
	
	
	public static int[] perceptronDigitTrain(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels){
		ArrayList<int[]> allWeights = new ArrayList<>();
		
		
		return null;
		
	}
	
	public static int[] perceptronFaceTrain(ArrayList<char[][]> arrFace, ArrayList<Character> arrLabels){
	
		int[] weight = new int[4831];
		int[] phi = new int[4830];
		int function = 0;
		boolean madeAMistake = false;  //starts
		while(true){
			for(int i = 0; i < arrFace.size(); i++){
				for(int q = 0; q < 4830; q++){
					phi[q] = 0;
				}
				madeAMistake = false;
				function = 0;
				int count = 0;
				for(int h = 0; h < 69; h++){
					for(int k = 0; k < 70; k++){
						if(arrFace.get(i)[h][k] == '#'){
							phi[count] = 1;
						}
						else{
							phi[count] = 0;
						}
						count++;
					}
				}
				function = weight[0];
				for(int a = 1; a < 4831; a++){
					function+= weight[a]*phi[a-1];
				}
				//System.out.println("Function: " + function);
				if((function >= 0 && arrLabels.get(i) == 1) || (function < 0 && arrLabels.get(i) == 0)){
					continue;
				}else{
					madeAMistake = true;
					if(arrLabels.get(i) == 1){
						weight[0] += 1;
						for(int b = 1; b < 4830; b++){
							weight[b] += phi[b-1]; 
						}
					}
					else {
						weight[0] -= 1;
						for(int b = 1; b < 4830; b++){
							weight[b] -= phi[b-1]; 
						}
					}
				}
			}
			if(!madeAMistake){
				break;
			}
		}
		
		
		return weight;
		
	}
	public static int[] perceptronFaceValidate(ArrayList<char[][]> arrFace, ArrayList<Character> arrLabels, int[] weight){
		int[] phi = new int[4830];
		int function = 0;
		boolean madeAMistake = false;  //starts 
		while(true){
			for(int i = 0; i < arrFace.size(); i++){
				for(int q = 0; q < 4830; q++){
					phi[q] = 0;
				}
				madeAMistake = false;
				function = 0;
				int count = 0;
				for(int h = 0; h < 69; h++){
					for(int k = 0; k < 70; k++){
						if(arrFace.get(i)[h][k] == '#'){
							phi[count] = 1;
						}
						else{
							phi[count] = 0;
						}
						count++;
					}
				}
				function = weight[0];
				for(int a = 1; a < 4831; a++){
					function+= weight[a]*phi[a-1];
				}
				//System.out.println("Function: " + function);
				if((function >= 0 && arrLabels.get(i) == 1) || (function < 0 && arrLabels.get(i) == 0)){
					continue;
				}else{
					madeAMistake = true;
					if(arrLabels.get(i) == 1){
						weight[0] += 1;
						for(int b = 1; b < 4830; b++){
							weight[b] += phi[b-1]; 
						}
					}
					else {
						weight[0] -= 1;
						for(int b = 1; b < 4830; b++){
							weight[b] -= phi[b-1]; 
						}
					}
				}
			}
			if(!madeAMistake){
				break;
			}
		}
		
		
		return weight;
	}
	public static int[] perceptronDigitValidate(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels,int[] weight){
		
		
		
		return null;
		
	}
	public static int[] perceptronDigitTest(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels,int[] weight){
		return null;
	}
	public static int[] perceptronFaceTest(ArrayList<char[][]> arrFace, ArrayList<Character> arrLabels,int[] weight,boolean testingFunction){
		int[] phi = new int[4831];
		int function = 0;
		int numCorrect = 0;
		int[] resultArr = new int[arrFace.size()];
		for(int i = 0; i < arrFace.size(); i++){
			for(int d = 0; d < 4830; d++){
				phi[d] = 0;
			}
			function = 0;
			int count = 0;
			for(int h = 0; h < 69; h++){
				for(int k = 0; k < 70; k++){
					if(arrFace.get(i)[h][k] == '#'){
						phi[count] = 1;
					}
					else{
						phi[count] = 0;
					}
					count++;
				}
			}
			function = weight[0];
			for(int a = 1; a < 4831; a++){
				function+= weight[a]*phi[a-1];
			}
			if((function >= 0 && arrLabels.get(i) == 1) || (function < 0 && arrLabels.get(i) == 0)){
				numCorrect++;
			}
			if(function >= 0){
				resultArr[i] = 1;
			}
			else {
				resultArr[i] = 0;
			}
		}
		double finalRes = (double) numCorrect/arrFace.size()*100;
		if(!testingFunction){
			System.out.println("Accuracy: " + finalRes + " %");
		}
		
		
		return resultArr;
	}
	public static void perceptronDigitTestFunction(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels, int index, int[] weights){
		int[] finalVals = perceptronDigitTest(arrDigit, arrLabels, weights);
		
		int predictedAnswer = finalVals[index-1];
		System.out.println("Predicted Answer: " + predictedAnswer);
		System.out.println("Actual Answer: " + (int) arrLabels.get(index-1));
	}
	public static void perceptronFaceTestFunction(ArrayList<char[][]> arrFace, ArrayList<Character> arrLabels, int index, int[] weights){
		int[] finalVals = perceptronFaceTest(arrFace,arrLabels, weights,true);
		
		int predictedAnswer = finalVals[index-1];
		System.out.println("Predicted Answer: " + predictedAnswer);
		System.out.println("Actual Answer: " + (int) arrLabels.get(index-1));
	}
		
		
}