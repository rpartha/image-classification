import java.util.ArrayList;

public class Perceptron {
	
	
	
	public static ArrayList<int[]> perceptronDigitTrain(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels){
		double startTime = System.currentTimeMillis();
		ArrayList<int[]> allWeights = new ArrayList<>();
		int[] weight0 = new int[811];
		allWeights.add(weight0);
		int[] weight1 = new int[811];
		allWeights.add(weight1);
		int[] weight2 = new int[811];
		allWeights.add(weight2);
		int[] weight3 = new int[811];
		allWeights.add(weight3);
		int[] weight4 = new int[811];
		allWeights.add(weight4);
		int[] weight5 = new int[811];
		allWeights.add(weight5);
		int[] weight6 = new int[811];
		allWeights.add(weight6);
		int[] weight7 = new int[811];
		allWeights.add(weight7);
		int[] weight8 = new int[811];
		allWeights.add(weight8);
		int[] weight9 = new int[811];
		allWeights.add(weight9);
		int[] phi = new int[810];
		int function0 = 0;
		int function1 = 0;
		int function2 = 0;
		int function3 = 0;
		int function4 = 0;
		int function5 = 0;
		int function6 = 0;
		int function7 = 0;
		int function8 = 0;
		int function9 = 0;
		int max = -1;
		int maxVal = -1;
		
		boolean madeAMistake = false;  //starts
		while(true){
			for(int i = 0; i < arrDigit.size(); i++){
				max = -1;
				maxVal = -1;
				for(int q = 0; q < 810; q++){
					phi[q] = 0;
				}
				madeAMistake = false;
				function0 = 0;
				function1 = 0;
				function2 = 0;
				function3 = 0;
				function4 = 0;
				function5 = 0;
				function6 = 0;
				function7 = 0;
				function8 = 0;
				function9 = 0;
				int count = 0;
				for(int h = 0; h < 27; h++){
					for(int k = 0; k < 30; k++){
						if(arrDigit.get(i)[h][k] == '#' || arrDigit.get(i)[h][k] == '+'){
							phi[count] = 1;
						}
						else{
							phi[count] = 0;
						}
						count++;
					}
				}
				function0 = allWeights.get(0)[0];
				function1 = allWeights.get(1)[0];
				function2 = allWeights.get(2)[0];
				function3 = allWeights.get(3)[0];
				function4 = allWeights.get(4)[0];
				function5 = allWeights.get(5)[0];
				function6 = allWeights.get(6)[0];
				function7 = allWeights.get(7)[0];
				function8 = allWeights.get(8)[0];
				function9 = allWeights.get(9)[0];
				for(int a = 1; a < 811; a++){
					function0 += allWeights.get(0)[a]*phi[a-1];
				}
				if(function0 > max){
					max = function0;
					maxVal = 0;
				}
				for(int a = 1; a < 811; a++){
					function1 += allWeights.get(1)[a]*phi[a-1];
				}
				if(function1 > max){
					max = function1;
					maxVal = 1;
				}
				for(int a = 1; a < 811; a++){
					function2 += allWeights.get(2)[a]*phi[a-1];
				}
				if(function2 > max){
					max = function2;
					maxVal = 2;
				}
				for(int a = 1; a < 811; a++){
					function3 += allWeights.get(3)[a]*phi[a-1];
				}
				if(function3 > max){
					max = function3;
					maxVal = 3;
				}
				for(int a = 1; a < 811; a++){
					function4 += allWeights.get(4)[a]*phi[a-1];
				}
				if(function4 > max){
					max = function4;
					maxVal = 4;
				}
				for(int a = 1; a < 811; a++){
					function5 += allWeights.get(5)[a]*phi[a-1];
				}
				if(function5 > max){
					max = function5;
					maxVal = 5;
				}
				for(int a = 1; a < 811; a++){
					function6 += allWeights.get(6)[a]*phi[a-1];
				}
				if(function6 > max){
					max = function6;
					maxVal = 6;
				}
				for(int a = 1; a < 811; a++){
					function7 += allWeights.get(7)[a]*phi[a-1];
				}
				if(function7 > max){
					max = function7;
					maxVal = 7;
				}
				for(int a = 1; a < 811; a++){
					function8 += allWeights.get(8)[a]*phi[a-1];
				}
				if(function8 > max){
					max = function8;
					maxVal = 8;
				}
				for(int a = 1; a < 811; a++){
					function9 += allWeights.get(9)[a]*phi[a-1];
				}
				if(function9 > max){
					max = function9;
					maxVal = 9;
				}
				if(arrLabels.get(i) == maxVal){
					
				}
				else{
					madeAMistake = true;
					allWeights.get(maxVal)[0] -= 1;
					allWeights.get(arrLabels.get(i))[0] += 1;
					for(int a = 1; a < 811; a++){
						allWeights.get(maxVal)[a] -= phi[a-1];
						allWeights.get(arrLabels.get(i))[a] += phi[a-1];
					}
				}
			}
			if(!madeAMistake){
				break;
			}
		}
		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		time /= 1000;
		if(arrLabels.size() == 501){
			System.out.println("Time for training 10% of data set: " + time);
		}
		else if(arrLabels.size() == 1001){
			System.out.println("Time for training 20% of data set: " + time);
		}
		else if(arrLabels.size() == 1501){
			System.out.println("Time for training 30% of data set: " + time);
		}
		else if(arrLabels.size() == 2001){
			System.out.println("Time for training 40% of data set: " + time);
		}
		else if(arrLabels.size() == 2501){
			System.out.println("Time for training 50% of data set: " + time);
		}
		else if(arrLabels.size() == 3001){
			System.out.println("Time for training 60% of data set: " + time);
		}
		else if(arrLabels.size() == 3501){
			System.out.println("Time for training 70% of data set: " + time);
		}
		else if(arrLabels.size() == 4001){
			System.out.println("Time for training 80% of data set: " + time);
		}
		else if(arrLabels.size() == 4501){
			System.out.println("Time for training 90% of data set: " + time);
		}
		else if(arrLabels.size() == 5000){
			System.out.println("Time for training 100% of data set: " + time);
		}
		return allWeights;
		
	}
	
	public static int[] perceptronFaceTrain(ArrayList<char[][]> arrFace, ArrayList<Character> arrLabels){
		double startTime = System.currentTimeMillis();
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
		double endTime = System.currentTimeMillis();
		double time = endTime - startTime;
		time /= 1000;
		if(arrLabels.size() == 46){
			System.out.println("Time for training 10% of data set: " + time);
		}
		else if(arrLabels.size() == 91){
			System.out.println("Time for training 20% of data set: " + time);
		}
		else if(arrLabels.size() == 136){
			System.out.println("Time for training 30% of data set: " + time);
		}
		else if(arrLabels.size() == 181){
			System.out.println("Time for training 40% of data set: " + time);
		}
		else if(arrLabels.size() == 226){
			System.out.println("Time for training 50% of data set: " + time);
		}
		else if(arrLabels.size() == 271){
			System.out.println("Time for training 60% of data set: " + time);
		}
		else if(arrLabels.size() == 316){
			System.out.println("Time for training 70% of data set: " + time);
		}
		else if(arrLabels.size() == 361){
			System.out.println("Time for training 80% of data set: " + time);
		}
		else if(arrLabels.size() == 406){
			System.out.println("Time for training 90% of data set: " + time);
		}
		else if(arrLabels.size() == 451){
			System.out.println("Time for training 100% of data set: " + time);
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
	public static ArrayList<int[]> perceptronDigitValidate(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels,ArrayList<int[]> allWeights){
		int[] phi = new int[810];
		int function0 = 0;
		int function1 = 0;
		int function2 = 0;
		int function3 = 0;
		int function4 = 0;
		int function5 = 0;
		int function6 = 0;
		int function7 = 0;
		int function8 = 0;
		int function9 = 0;
		int max = -1;
		int maxVal = -1;
		
		boolean madeAMistake = false;  //starts
		while(true){
			for(int i = 0; i < arrDigit.size(); i++){
				max = -1;
				maxVal = -1;
				for(int q = 0; q < 810; q++){
					phi[q] = 0;
				}
				madeAMistake = false;
				function0 = 0;
				function1 = 0;
				function2 = 0;
				function3 = 0;
				function4 = 0;
				function5 = 0;
				function6 = 0;
				function7 = 0;
				function8 = 0;
				function9 = 0;
				int count = 0;
				for(int h = 0; h < 27; h++){
					for(int k = 0; k < 30; k++){
						if(arrDigit.get(i)[h][k] == '#' || arrDigit.get(i)[h][k] == '+'){
							phi[count] = 1;
						}
						else{
							phi[count] = 0;
						}
						count++;
					}
				}
				function0 = allWeights.get(0)[0];
				function1 = allWeights.get(1)[0];
				function2 = allWeights.get(2)[0];
				function3 = allWeights.get(3)[0];
				function4 = allWeights.get(4)[0];
				function5 = allWeights.get(5)[0];
				function6 = allWeights.get(6)[0];
				function7 = allWeights.get(7)[0];
				function8 = allWeights.get(8)[0];
				function9 = allWeights.get(9)[0];
				for(int a = 1; a < 811; a++){
					function0 += allWeights.get(0)[a]*phi[a-1];
				}
				if(function0 > max){
					max = function0;
					maxVal = 0;
				}
				for(int a = 1; a < 811; a++){
					function1 += allWeights.get(1)[a]*phi[a-1];
				}
				if(function1 > max){
					max = function1;
					maxVal = 1;
				}
				for(int a = 1; a < 811; a++){
					function2 += allWeights.get(2)[a]*phi[a-1];
				}
				if(function2 > max){
					max = function2;
					maxVal = 2;
				}
				for(int a = 1; a < 811; a++){
					function3 += allWeights.get(3)[a]*phi[a-1];
				}
				if(function3 > max){
					max = function3;
					maxVal = 3;
				}
				for(int a = 1; a < 811; a++){
					function4 += allWeights.get(4)[a]*phi[a-1];
				}
				if(function4 > max){
					max = function4;
					maxVal = 4;
				}
				for(int a = 1; a < 811; a++){
					function5 += allWeights.get(5)[a]*phi[a-1];
				}
				if(function5 > max){
					max = function5;
					maxVal = 5;
				}
				for(int a = 1; a < 811; a++){
					function6 += allWeights.get(6)[a]*phi[a-1];
				}
				if(function6 > max){
					max = function6;
					maxVal = 6;
				}
				for(int a = 1; a < 811; a++){
					function7 += allWeights.get(7)[a]*phi[a-1];
				}
				if(function7 > max){
					max = function7;
					maxVal = 7;
				}
				for(int a = 1; a < 811; a++){
					function8 += allWeights.get(8)[a]*phi[a-1];
				}
				if(function8 > max){
					max = function8;
					maxVal = 8;
				}
				for(int a = 1; a < 811; a++){
					function9 += allWeights.get(9)[a]*phi[a-1];
				}
				if(function9 > max){
					max = function9;
					maxVal = 9;
				}
				if(arrLabels.get(i) == maxVal){
					
				}
				else{
					madeAMistake = true;
					allWeights.get(maxVal)[0] -= 1;
					allWeights.get(arrLabels.get(i))[0] += 1;
					for(int a = 1; a < 811; a++){
						allWeights.get(maxVal)[a] -= phi[a-1];
						allWeights.get(arrLabels.get(i))[a] += phi[a-1];
					}
				}
			}
			if(!madeAMistake){
				break;
			}
		}
		
		
		return allWeights;
	}
	public static int[] perceptronDigitTest(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels,ArrayList<int[]> allWeights, boolean testingFunction){
		int[] phi = new int[810];
		int function0 = 0;
		int function1 = 0;
		int function2 = 0;
		int function3 = 0;
		int function4 = 0;
		int function5 = 0;
		int function6 = 0;
		int function7 = 0;
		int function8 = 0;
		int function9 = 0;
		int max = -1;
		int maxVal = -1;
		int numCorrect = 0;
		int[] finalResult = new int[1000];
		for(int i = 0; i < arrDigit.size(); i++){
			max = -1;
			maxVal = -1;
			for(int q = 0; q < 810; q++){
				phi[q] = 0;
			}
			function0 = 0;
			function1 = 0;
			function2 = 0;
			function3 = 0;
			function4 = 0;
			function5 = 0;
			function6 = 0;
			function7 = 0;
			function8 = 0;
			function9 = 0;
			int count = 0;
			for(int h = 0; h < 27; h++){
				for(int k = 0; k < 30; k++){
					if(arrDigit.get(i)[h][k] == '#' || arrDigit.get(i)[h][k] == '+'){
						phi[count] = 1;
					}
					else{
						phi[count] = 0;
					}
					count++;
				}
			}
			function0 = allWeights.get(0)[0];
			function1 = allWeights.get(1)[0];
			function2 = allWeights.get(2)[0];
			function3 = allWeights.get(3)[0];
			function4 = allWeights.get(4)[0];
			function5 = allWeights.get(5)[0];
			function6 = allWeights.get(6)[0];
			function7 = allWeights.get(7)[0];
			function8 = allWeights.get(8)[0];
			function9 = allWeights.get(9)[0];
			for(int a = 1; a < 811; a++){
				function0 += allWeights.get(0)[a]*phi[a-1];
			}
			if(function0 > max){
				max = function0;
				maxVal = 0;
			}
			for(int a = 1; a < 811; a++){
				function1 += allWeights.get(1)[a]*phi[a-1];
			}
			if(function1 > max){
				max = function1;
				maxVal = 1;
			}
			for(int a = 1; a < 811; a++){
				function2 += allWeights.get(2)[a]*phi[a-1];
			}
			if(function2 > max){
				max = function2;
				maxVal = 2;
			}
			for(int a = 1; a < 811; a++){
				function3 += allWeights.get(3)[a]*phi[a-1];
			}
			if(function3 > max){
				max = function3;
				maxVal = 3;
			}
			for(int a = 1; a < 811; a++){
				function4 += allWeights.get(4)[a]*phi[a-1];
			}
			if(function4 > max){
				max = function4;
				maxVal = 4;
			}
			for(int a = 1; a < 811; a++){
				function5 += allWeights.get(5)[a]*phi[a-1];
			}
			if(function5 > max){
				max = function5;
				maxVal = 5;
			}
			for(int a = 1; a < 811; a++){
				function6 += allWeights.get(6)[a]*phi[a-1];
			}
			if(function6 > max){
				max = function6;
				maxVal = 6;
			}
			for(int a = 1; a < 811; a++){
				function7 += allWeights.get(7)[a]*phi[a-1];
			}
			if(function7 > max){
				max = function7;
				maxVal = 7;
			}
			for(int a = 1; a < 811; a++){
				function8 += allWeights.get(8)[a]*phi[a-1];
			}
			if(function8 > max){
				max = function8;
				maxVal = 8;
			}
			for(int a = 1; a < 811; a++){
				function9 += allWeights.get(9)[a]*phi[a-1];
			}
			if(function9 > max){
				max = function9;
				maxVal = 9;
			}
			if(arrLabels.get(i) == maxVal){
				numCorrect++;
			}
			finalResult[i] = maxVal;
		}
		double finalRes = (double) numCorrect/arrDigit.size()*100;
		if(!testingFunction){
			System.out.println("Accuracy: " + finalRes + " %");
		}
		return finalResult;
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
	public static void perceptronDigitTestFunction(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels, int index, ArrayList<int[]> allWeights){
		int[] finalVals = perceptronDigitTest(arrDigit, arrLabels, allWeights,true);
		
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