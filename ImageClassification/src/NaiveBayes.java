import java.util.ArrayList;

public class NaiveBayes {
	public static ArrayList<double[][]> naiveBayesDigitTrain(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels, boolean testingFunction){
		ArrayList<double[][]> arrListFinal = new ArrayList<>();
		double startTime = System.currentTimeMillis();
		ArrayList<Structure> structArrList = new ArrayList<>();
		ArrayList<char[][]> zeros = new ArrayList<>();
		ArrayList<char[][]> ones = new ArrayList<>();
		ArrayList<char[][]> twos = new ArrayList<>();
		ArrayList<char[][]> threes = new ArrayList<>();
		ArrayList<char[][]> fours = new ArrayList<>();
		ArrayList<char[][]> fives = new ArrayList<>();
		ArrayList<char[][]> sixes = new ArrayList<>();
		ArrayList<char[][]> sevens = new ArrayList<>();
		ArrayList<char[][]> eights = new ArrayList<>();
		ArrayList<char[][]> nines = new ArrayList<>();
		for(int i = 0; i < arrLabels.size(); i++){
			if(arrLabels.get(i) == 0){
				Structure digit = new Structure(arrDigit.get(i), 0);
				structArrList.add(digit);
				zeros.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 1){
				Structure digit = new Structure(arrDigit.get(i),1);
				structArrList.add(digit);
				ones.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) ==2){
				Structure digit = new Structure(arrDigit.get(i),2);
				structArrList.add(digit);
				twos.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 3){
				Structure digit = new Structure(arrDigit.get(i),3);
				structArrList.add(digit);
				threes.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 4){
				Structure digit = new Structure(arrDigit.get(i),4);
				structArrList.add(digit);
				fours.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 5){
				Structure digit = new Structure(arrDigit.get(i),5);
				structArrList.add(digit);
				fives.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 6){
				Structure digit = new Structure(arrDigit.get(i),6);
				structArrList.add(digit);
				sixes.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 7){
				Structure digit = new Structure(arrDigit.get(i),7);
				structArrList.add(digit);
				sevens.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 8){
				Structure digit = new Structure(arrDigit.get(i),8);
				structArrList.add(digit);
				eights.add(arrDigit.get(i));
			}
			else {
				Structure digit = new Structure(arrDigit.get(i),9);
				structArrList.add(digit);
				nines.add(arrDigit.get(i));
			}
		}
		/*System.out.println("Zeros Size: " + zeros.size());
		System.out.println("Ones Size: " + ones.size());
		System.out.println("Twos Size: " + twos.size());
		System.out.println("Threes Size: " + threes.size());
		System.out.println("Fours Size: " + fours.size());
		System.out.println("Fives Size: " + fives.size());
		System.out.println("Sixes Size: " + sixes.size());
		System.out.println("Sevens Size: " + sevens.size());
		System.out.println("Eights Size: " + eights.size());
		System.out.println("Nines Size: " + nines.size());*/
		
		int numZeros = 0;
		int numOnes = 0;
		int numTwos = 0;
		int numThrees = 0;
		int numFours = 0;
		int numFives = 0;
		int numSixes = 0;
		int numSevens = 0;
		int numEights = 0;
		int numNines = 0;
		for(int label : arrLabels){
			if(label == 0){
				numZeros++;
			}
			else if(label == 1){
				numOnes++;
			}
			else if(label == 2){
				numTwos++;
			}
			else if(label == 3){
				numThrees++;
			}
			else if(label == 4){
				numFours++;
			}
			else if(label == 5){
				numFives++;
			}
			else if(label == 6){
				numSixes++;
			}
			else if(label == 7){
				numSevens++;
			}
			else if(label == 8){
				numEights++;
			}
			else {
				numNines++;
			}
		}
		/*System.out.println("Zeros Size: " + numZeros);
		System.out.println("Ones Size: " + numOnes);
		System.out.println("Twos Size: " + numTwos);
		System.out.println("Threes Size: " + numThrees);
		System.out.println("Fours Size: " + numFours);
		System.out.println("Fives Size: " + numFives);
		System.out.println("Sixes Size: " + numSixes);
		System.out.println("Sevens Size: " + numSevens);
		System.out.println("Eights Size: " + numEights);
		System.out.println("Nines Size: " + numNines);*/
		
		double y0 = (double) numZeros/arrDigit.size();
		double y1 = (double) numOnes/arrDigit.size();
		double y2 = (double) numTwos/arrDigit.size();
		double y3 = (double) numThrees/arrDigit.size();
		double y4 = (double) numFours/arrDigit.size();
		double y5 = (double) numFives/arrDigit.size();
		double y6 = (double) numSixes/arrDigit.size();
		double y7 = (double) numSevens/arrDigit.size();
		double y8 = (double) numEights/arrDigit.size();
		double y9 = (double) numNines/arrDigit.size();
		double[][] probY0 = new double[27][30];
		double[][] probY1 = new double[27][30];
		double[][] probY2 = new double[27][30];
		double[][] probY3 = new double[27][30];
		double[][] probY4 = new double[27][30];
		double[][] probY5 = new double[27][30];
		double[][] probY6 = new double[27][30];
		double[][] probY7 = new double[27][30];
		double[][] probY8 = new double[27][30];
		double[][] probY9 = new double[27][30];
		
		int[] finalVals = new int[arrDigit.size()];
		double finalY0 = 1;
		double finalY1 = 1;
		double finalY2 = 1;
		double finalY3 = 1;
		double finalY4 = 1;
		double finalY5 = 1;
		double finalY6 = 1;
		double finalY7 = 1;
		double finalY8 = 1;
		double finalY9 = 1;
		
		double finalResult = 0;
		int numCurrentLevel0 = 0;
		int numCurrentLevel1 = 0;
		int numCurrentLevel2 = 0;
		int numCurrentLevel3 = 0;
		int numCurrentLevel4 = 0;
		int numCurrentLevel5 = 0;
		int numCurrentLevel6 = 0;
		int numCurrentLevel7 = 0;
		int numCurrentLevel8 = 0;
		int numCurrentLevel9 = 0;
		
		int temp = 0;
		int w = 0;
		int numCorrect = 0;
		for(int i = 0; i < 27; i++){
			w = 0;
			temp = 0;
			numCurrentLevel0 = 0;
			numCurrentLevel1 = 0;
			numCurrentLevel2 = 0;
			numCurrentLevel3 = 0;
			numCurrentLevel4 = 0;
			numCurrentLevel5 = 0;
			numCurrentLevel6 = 0;
			numCurrentLevel7 = 0;
			numCurrentLevel8 = 0;
			numCurrentLevel9 = 0;
			for(int currentPixel = 0; currentPixel < 30; currentPixel++){
				numCurrentLevel0 = 0;
				numCurrentLevel1 = 0;
				numCurrentLevel2 = 0;
				numCurrentLevel3 = 0;
				numCurrentLevel4 = 0;
				numCurrentLevel5 = 0;
				numCurrentLevel6 = 0;
				numCurrentLevel7 = 0;
				numCurrentLevel8 = 0;
				numCurrentLevel9 = 0;
				for(int imageNum = 0; imageNum < structArrList.size(); imageNum++){
					temp = 0;
					for(int j = 0; j < 30; j++){
						if(structArrList.get(imageNum).arrList[i][j] == '#' || structArrList.get(imageNum).arrList[i][j] == '+'){
							temp++;
						}
					}
					if(temp == currentPixel && structArrList.get(imageNum).val == 0){
						numCurrentLevel0++;
					}
					else if(temp == currentPixel && structArrList.get(imageNum).val == 1){
						numCurrentLevel1++;
					}
					else if(temp == currentPixel && structArrList.get(imageNum).val == 2){
						numCurrentLevel2++;
					}
					else if(temp == currentPixel && structArrList.get(imageNum).val == 3){
						numCurrentLevel3++;
					}
					else if(temp == currentPixel && structArrList.get(imageNum).val == 4){
						numCurrentLevel4++;
					}
					else if(temp == currentPixel && structArrList.get(imageNum).val == 5){
						numCurrentLevel5++;
					}
					else if(temp == currentPixel && structArrList.get(imageNum).val == 6){
						numCurrentLevel6++;
					}
					else if(temp == currentPixel && structArrList.get(imageNum).val == 7){
						numCurrentLevel7++;
					}
					else if(temp == currentPixel && structArrList.get(imageNum).val == 8){
						numCurrentLevel8++;
					}
					else if(temp == currentPixel && structArrList.get(imageNum).val == 9){
						numCurrentLevel9++;
					}
				}
				probY0[i][w] = (double) numCurrentLevel0/numZeros;
				probY1[i][w] = (double) numCurrentLevel1/numOnes;
				probY2[i][w] = (double) numCurrentLevel2/numTwos;
				probY3[i][w] = (double) numCurrentLevel3/numThrees;
				probY4[i][w] = (double) numCurrentLevel4/numFours;
				probY5[i][w] = (double) numCurrentLevel5/numFives;
				probY6[i][w] = (double) numCurrentLevel6/numSixes;
				probY7[i][w] = (double) numCurrentLevel7/numSevens;
				probY8[i][w] = (double) numCurrentLevel8/numEights;
				probY9[i][w] = (double) numCurrentLevel9/numNines;
				
				if(probY0[i][w] == 0){
					probY0[i][w] = 0.01;
				}
				if(probY1[i][w] == 0){
					probY1[i][w] = 0.01;
				}
				if(probY2[i][w] == 0){
					probY2[i][w] = 0.01;
				}
				if(probY3[i][w] == 0){
					probY3[i][w] = 0.01;
				}
				if(probY4[i][w] == 0){
					probY4[i][w] = 0.01;
				}
				if(probY5[i][w] == 0){
					probY5[i][w] = 0.01;
				}
				if(probY6[i][w] == 0){
					probY6[i][w] = 0.01;
				}
				if(probY7[i][w] == 0){
					probY7[i][w] = 0.01;
				}
				if(probY8[i][w] == 0){
					probY8[i][w] = 0.01;
				}
				if(probY9[i][w] == 0){
					probY9[i][w] = 0.01;
				}
				w++;
			}
		}
		double max = 0;
		int maxVal = -1;
		for(int imageNum = 0; imageNum < structArrList.size(); imageNum++){
			finalY0 = 1;
			finalY1 = 1;
			finalY2 = 1;
			finalY3 = 1;
			finalY4 = 1;
			finalY5 = 1;
			finalY6 = 1;
			finalY7 = 1;
			finalY8 = 1;
			finalY9 = 1;
			max = 0;
			maxVal = -1;
			temp = 0;
			for(int i = 0; i < 27; i++){
				temp = 0;
				for(int j = 0; j < 30; j++){
					if(structArrList.get(imageNum).arrList[i][j] == '#' || structArrList.get(imageNum).arrList[i][j] == '+'){
						temp++;
					}
				}
				finalY0 *= (double) probY0[i][temp];
				finalY1 *= (double) probY1[i][temp];
				finalY2 *= (double) probY2[i][temp];
				finalY3 *= (double) probY3[i][temp];
				finalY4 *= (double) probY4[i][temp];
				finalY5 *= (double) probY5[i][temp];
				finalY6 *= (double) probY6[i][temp];
				finalY7 *= (double) probY7[i][temp];
				finalY8 *= (double) probY8[i][temp];
				finalY9 *= (double) probY9[i][temp];
				
			}
			for(int i = 0; i < 10; i++){
				if(i == 0){
					finalResult = (double) (finalY0 * y0);
					if(finalResult > max){
						max = finalResult;
						maxVal = 0;
					}
				}
				else if(i == 1){
					finalResult = (double) (finalY1 * y1);
					if(finalResult > max){
						max = finalResult;
						maxVal = 1;
					}
				}
				else if(i == 2){
					finalResult = (double) (finalY2 * y2);
					if(finalResult > max){
						max = finalResult;
						maxVal = 2;
					}
				}
				else if(i == 3){
					finalResult = (double) (finalY3 * y3);
					if(finalResult > max){
						max = finalResult;
						maxVal = 3;
					}
				}
				else if(i == 4){
					finalResult = (double) (finalY4 * y4);
					if(finalResult > max){
						max = finalResult;
						maxVal = 4;
					}
				}
				else if(i == 5){
					finalResult = (double) (finalY5 * y5);
					if(finalResult > max){
						max = finalResult;
						maxVal = 5;
					}
				}
				else if(i == 6){
					finalResult = (double) (finalY6 * y6);
					if(finalResult > max){
						max = finalResult;
						maxVal = 6;
					}
				}
				else if(i == 7){
					finalResult = (double) (finalY7 * y7);
					if(finalResult > max){
						max = finalResult;
						maxVal = 7;
					}
				}
				else if(i == 8){
					finalResult = (double) (finalY8 * y8);
					if(finalResult > max){
						max = finalResult;
						maxVal = 8;
					}
				}
				else{
					finalResult = (double) (finalY9 * y9);
					if(finalResult > max){
						max = finalResult;
						maxVal = 9;
					}
				}
			}
			finalVals[imageNum] = maxVal;
		}
		arrListFinal.add(probY0);
		arrListFinal.add(probY1);
		arrListFinal.add(probY2);
		arrListFinal.add(probY3);
		arrListFinal.add(probY4);
		arrListFinal.add(probY5);
		arrListFinal.add(probY6);
		arrListFinal.add(probY7);
		arrListFinal.add(probY8);
		arrListFinal.add(probY9);
		
		/*for(int i = 0; i < arrDigit.size(); i++){
			if(finalVals[i] == arrLabels.get(i)){
				numCorrect += 1;
			}
		}
		double finalRes = (double) numCorrect/arrDigit.size()*100;
		if(!testingFunction){
			System.out.println("Accuracy: " + finalRes + " %");
		}*/
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
		return arrListFinal;
	}
	public static int[] naiveBayesDigitTest(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels, boolean testingFunction,ArrayList<double[][]> arrListFinal){
		ArrayList<Structure> structArrList = new ArrayList<>();
		ArrayList<char[][]> zeros = new ArrayList<>();
		ArrayList<char[][]> ones = new ArrayList<>();
		ArrayList<char[][]> twos = new ArrayList<>();
		ArrayList<char[][]> threes = new ArrayList<>();
		ArrayList<char[][]> fours = new ArrayList<>();
		ArrayList<char[][]> fives = new ArrayList<>();
		ArrayList<char[][]> sixes = new ArrayList<>();
		ArrayList<char[][]> sevens = new ArrayList<>();
		ArrayList<char[][]> eights = new ArrayList<>();
		ArrayList<char[][]> nines = new ArrayList<>();
		for(int i = 0; i < arrLabels.size(); i++){
			if(arrLabels.get(i) == 0){
				Structure digit = new Structure(arrDigit.get(i), 0);
				structArrList.add(digit);
				zeros.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 1){
				Structure digit = new Structure(arrDigit.get(i),1);
				structArrList.add(digit);
				ones.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) ==2){
				Structure digit = new Structure(arrDigit.get(i),2);
				structArrList.add(digit);
				twos.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 3){
				Structure digit = new Structure(arrDigit.get(i),3);
				structArrList.add(digit);
				threes.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 4){
				Structure digit = new Structure(arrDigit.get(i),4);
				structArrList.add(digit);
				fours.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 5){
				Structure digit = new Structure(arrDigit.get(i),5);
				structArrList.add(digit);
				fives.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 6){
				Structure digit = new Structure(arrDigit.get(i),6);
				structArrList.add(digit);
				sixes.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 7){
				Structure digit = new Structure(arrDigit.get(i),7);
				structArrList.add(digit);
				sevens.add(arrDigit.get(i));
			}
			else if(arrLabels.get(i) == 8){
				Structure digit = new Structure(arrDigit.get(i),8);
				structArrList.add(digit);
				eights.add(arrDigit.get(i));
			}
			else {
				Structure digit = new Structure(arrDigit.get(i),9);
				structArrList.add(digit);
				nines.add(arrDigit.get(i));
			}
		}
		int numZeros = 0;
		int numOnes = 0;
		int numTwos = 0;
		int numThrees = 0;
		int numFours = 0;
		int numFives = 0;
		int numSixes = 0;
		int numSevens = 0;
		int numEights = 0;
		int numNines = 0;
		for(int label : arrLabels){
			if(label == 0){
				numZeros++;
			}
			else if(label == 1){
				numOnes++;
			}
			else if(label == 2){
				numTwos++;
			}
			else if(label == 3){
				numThrees++;
			}
			else if(label == 4){
				numFours++;
			}
			else if(label == 5){
				numFives++;
			}
			else if(label == 6){
				numSixes++;
			}
			else if(label == 7){
				numSevens++;
			}
			else if(label == 8){
				numEights++;
			}
			else {
				numNines++;
			}
		}
		double y0 = (double) numZeros/arrDigit.size();
		double y1 = (double) numOnes/arrDigit.size();
		double y2 = (double) numTwos/arrDigit.size();
		double y3 = (double) numThrees/arrDigit.size();
		double y4 = (double) numFours/arrDigit.size();
		double y5 = (double) numFives/arrDigit.size();
		double y6 = (double) numSixes/arrDigit.size();
		double y7 = (double) numSevens/arrDigit.size();
		double y8 = (double) numEights/arrDigit.size();
		double y9 = (double) numNines/arrDigit.size();
		int[] finalVals = new int[arrDigit.size()];
		double finalY0 = 1;
		double finalY1 = 1;
		double finalY2 = 1;
		double finalY3 = 1;
		double finalY4 = 1;
		double finalY5 = 1;
		double finalY6 = 1;
		double finalY7 = 1;
		double finalY8 = 1;
		double finalY9 = 1;
		double finalResult = 0;
		int numCorrect = 0;
		double max = 0;
		int maxVal = -1;
		int temp = 0;
		for(int imageNum = 0; imageNum < structArrList.size(); imageNum++){
			finalY0 = 1;
			finalY1 = 1;
			finalY2 = 1;
			finalY3 = 1;
			finalY4 = 1;
			finalY5 = 1;
			finalY6 = 1;
			finalY7 = 1;
			finalY8 = 1;
			finalY9 = 1;
			max = 0;
			maxVal = -1;
			temp = 0;
			for(int i = 0; i < 27; i++){
				temp = 0;
				for(int j = 0; j < 30; j++){
					if(structArrList.get(imageNum).arrList[i][j] == '#' || structArrList.get(imageNum).arrList[i][j] == '+'){
						temp++;
					}
				}
				finalY0 *= (double) arrListFinal.get(0)[i][temp];
				finalY1 *= (double) arrListFinal.get(1)[i][temp];
				finalY2 *= (double) arrListFinal.get(2)[i][temp];
				finalY3 *= (double) arrListFinal.get(3)[i][temp];
				finalY4 *= (double) arrListFinal.get(4)[i][temp];
				finalY5 *= (double) arrListFinal.get(5)[i][temp];
				finalY6 *= (double) arrListFinal.get(6)[i][temp];
				finalY7 *= (double) arrListFinal.get(7)[i][temp];
				finalY8 *= (double) arrListFinal.get(8)[i][temp];
				finalY9 *= (double) arrListFinal.get(9)[i][temp];
				
			}
			for(int i = 0; i < 10; i++){
				if(i == 0){
					finalResult = (double) (finalY0 * y0);
					if(finalResult > max){
						max = finalResult;
						maxVal = 0;
					}
				}
				else if(i == 1){
					finalResult = (double) (finalY1 * y1);
					if(finalResult > max){
						max = finalResult;
						maxVal = 1;
					}
				}
				else if(i == 2){
					finalResult = (double) (finalY2 * y2);
					if(finalResult > max){
						max = finalResult;
						maxVal = 2;
					}
				}
				else if(i == 3){
					finalResult = (double) (finalY3 * y3);
					if(finalResult > max){
						max = finalResult;
						maxVal = 3;
					}
				}
				else if(i == 4){
					finalResult = (double) (finalY4 * y4);
					if(finalResult > max){
						max = finalResult;
						maxVal = 4;
					}
				}
				else if(i == 5){
					finalResult = (double) (finalY5 * y5);
					if(finalResult > max){
						max = finalResult;
						maxVal = 5;
					}
				}
				else if(i == 6){
					finalResult = (double) (finalY6 * y6);
					if(finalResult > max){
						max = finalResult;
						maxVal = 6;
					}
				}
				else if(i == 7){
					finalResult = (double) (finalY7 * y7);
					if(finalResult > max){
						max = finalResult;
						maxVal = 7;
					}
				}
				else if(i == 8){
					finalResult = (double) (finalY8 * y8);
					if(finalResult > max){
						max = finalResult;
						maxVal = 8;
					}
				}
				else{
					finalResult = (double) (finalY9 * y9);
					if(finalResult > max){
						max = finalResult;
						maxVal = 9;
					}
				}
			}
			finalVals[imageNum] = maxVal;
		}
		for(int i = 0; i < arrDigit.size(); i++){
			if(finalVals[i] == arrLabels.get(i)){
				numCorrect += 1;
			}
		}
		double finalRes = (double) numCorrect/arrDigit.size()*100;
		if(!testingFunction){
			System.out.println("Accuracy: " + finalRes + " %");
		}
		return finalVals;
	}
	public static void naiveBayesDigitTestFunction(ArrayList<char[][]> arrDigit, ArrayList<Character> arrLabels, int index,ArrayList<double[][]> arrListFinal){
		int[] finalVals = naiveBayesDigitTest(arrDigit, arrLabels, true,arrListFinal);
		
		int predictedAnswer = finalVals[index-1];
		System.out.println("Predicted Answer: " + predictedAnswer);
		System.out.println("Actual Answer: " + (int) arrLabels.get(index-1));
	}
	
	
	public static ArrayList<double[][]> naiveBayesFaceTrain(ArrayList<char[][]> arrFace, ArrayList<Character> arrLabels, boolean testingFunction){
		ArrayList<double[][]> finalArrList = new ArrayList<>();
		double startTime = System.currentTimeMillis();
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
		double ytrue = (double) numFace/arrFace.size();
		double yfalse = (double)(arrFace.size() - numFace)/arrFace.size();
		double[][] probYTrue = new double[69][70];
		double[][] probYFalse = new double[69][70];
		int[] finalVals = new int[arrFace.size()];
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
				probYFalse[i][w] = (double) numCurrentLevelNotFace/(arrLabels.size() -numFace);
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
		finalArrList.add(probYTrue);
		finalArrList.add(probYFalse);
		/*for(int i = 0; i < arrFace.size(); i++){
			if(finalVals[i] == arrLabels.get(i)){
				numCorrect += 1;
			}
		}
		double finalRes = (double) numCorrect/arrFace.size()*100;
		if(!testingFunction){
			System.out.println("Accuracy: " + finalRes + " %");
		}*/
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
		
		return finalArrList;
	}
	public static int[] naiveBayesFaceTest(ArrayList<char[][]> arrFace, ArrayList<Character> arrLabels, boolean testingFunction,ArrayList<double[][]> finalArrList){
		double[][] probYTrue = finalArrList.get(0);
		double[][] probYFalse = finalArrList.get(1);
		int[] finalVals = new int[arrFace.size()];
		ArrayList<Structure> structArrList = new ArrayList<>();
		ArrayList<char[][]> justFaces = new ArrayList<>();
		ArrayList<char[][]> nonFaces = new ArrayList<>();
		int numFace = 0;
		int numCorrect = 0;
		int numCurrentLevelFace = 0;
		double finalYTrue = 0;
		double finalYFalse = 0;
		double finalResult = 0;
		int temp = 0;
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
		for(int label : arrLabels){
			if(label == 1){
				numFace++;
			}
		}
		double ytrue = (double) numFace/arrFace.size();
		double yfalse = (double)(arrFace.size() - numFace)/arrFace.size();
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
		for(int i = 0; i < arrFace.size(); i++){
			if(finalVals[i] == arrLabels.get(i)){
				numCorrect += 1;
			}
		}
		double finalRes = (double) numCorrect/arrFace.size()*100;
		if(!testingFunction){
			System.out.println("Accuracy: " + finalRes + " %");
		}
		
		return finalVals;
	}
	
	public static void naiveBayesFaceTestFunction(ArrayList<char[][]> arrFace, ArrayList<Character> arrLabels, int index, ArrayList<double[][]> arrListFinal){
		int[] finalVals = naiveBayesFaceTest(arrFace,arrLabels, true,arrListFinal);
		
		int predictedAnswer = finalVals[index-1];
		System.out.println("Predicted Answer: " + predictedAnswer);
		System.out.println("Actual Answer: " + (int) arrLabels.get(index-1));
	}
}