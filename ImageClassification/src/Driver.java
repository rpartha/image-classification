import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipFile;



public class Driver {
	public static void main(String[] args) throws IOException, Exception{
		int[] weights = new int[4831];
		ArrayList<int[]> weightsArrList = new ArrayList<>();
		char c;
		char algo;
		while(true){
			Scanner sc = new Scanner(System.in); 
			System.out.println("Enter 'f' for face, enter 'd' for digit");
			String input = sc.next();
			input = input.toLowerCase();
			c = input.charAt(0);
			if(c != 'f' && c != 'd'){
				System.out.println("Invalid input.");
				continue;
			}
			while(true){
				System.out.println("Enter 'n' for Naive Bayes. Enter 'p' for Perceptron");
				String algoStr = sc.next();
				algoStr = algoStr.toLowerCase();
				algo = algoStr.charAt(0);
				if(algo != 'n' && algo != 'p'){
					System.out.println("Invalid Input.");
				}
				else{
					//sc.close();
					break;
				}
			}
			break;
		}
		File folder = new File("data");
	    File[] fList = folder.listFiles();
	    File folder2 = null;
	    for (File file : fList) {
	        if(file.getName().equals("digitdata") && c == 'd'){
	        	folder2 = new File(file.getAbsolutePath());
	        }
	        else if(file.getName().equals("facedata") && c == 'f'){
	        	folder2 = new File(file.getAbsolutePath());
	        }
	        else {
	        	
	        }
	    }
	    File trainFile = null;
	    File trainLabels = null;
	    File[] fList2 = folder2.listFiles();
	    File validationFile = null;
	    File validationLabels = null;
	    File testFile = null;
	    File testLabels = null;
	    for(File file : fList2){
	    	if(c == 'd' && file.getName().equals("trainingimages")){
	    		trainFile = new File(file.getAbsolutePath());
	    	}
	    	else if(c == 'f' && file.getName().equals("facedatatrain")){
	    		trainFile = new File(file.getAbsolutePath());
	    	}
	    	else {
	    		
	    	}
	    	if(c == 'd' && file.getName().equals("traininglabels")){
	    		trainLabels = new File(file.getAbsolutePath());
	    	}
	    	else if(c == 'f' && file.getName().equals("facedatatrainlabels")){
	    		trainLabels = new File(file.getAbsolutePath());
	    	}
	    	else {
	    		
	    	}
	    	if(c == 'd' && file.getName().equals("validationimages")){
	    		validationFile = new File(file.getAbsolutePath());
	    	}
	    	else if(c == 'f' && file.getName().equals("facedatavalidation")){
	    		validationFile = new File(file.getAbsolutePath());
	    	}
	    	else {
	    		
	    	}
	    	if(c == 'd' && file.getName().equals("validationlabels")){
	    		validationLabels = new File(file.getAbsolutePath());
	    	}
	    	else if(c == 'f' && file.getName().equals("facedatavalidationlabels")){
	    		validationLabels = new File(file.getAbsolutePath());
	    	}
	    	else {
	    		
	    	}
	    	if(c == 'd' && file.getName().equals("testimages")){
	    		testFile = new File(file.getAbsolutePath());
	    	}
	    	else if(c == 'f' && file.getName().equals("facedatatest")){
	    		testFile = new File(file.getAbsolutePath());
	    	}
	    	else {
	    		
	    	}
	    	if(c == 'd' && file.getName().equals("testlabels")){
	    		testLabels = new File(file.getAbsolutePath());
	    	}
	    	else if(c == 'f' && file.getName().equals("facedatatestlabels")){
	    		testLabels = new File(file.getAbsolutePath());
	    	}
	    	else {
	    		
	    	}
	    }
	    ArrayList<char[][]> arrListDatatenpc = new ArrayList<char[][]>();
	    ArrayList<char[][]> arrListDatatwenpc = new ArrayList<char[][]>();
	    ArrayList<char[][]> arrListDatathirdpc = new ArrayList<char[][]>();
	    ArrayList<char[][]> arrListDatafourpc = new ArrayList<char[][]>();
	    ArrayList<char[][]> arrListDatafifpc = new ArrayList<char[][]>();
	    ArrayList<char[][]> arrListDatasixpc = new ArrayList<char[][]>();
	    ArrayList<char[][]> arrListDatasevpc = new ArrayList<char[][]>();
	    ArrayList<char[][]> arrListDataeigpc = new ArrayList<char[][]>();
	    ArrayList<char[][]> arrListDataninpc = new ArrayList<char[][]>();
	    ArrayList<char[][]> arrListData = new ArrayList<char[][]>();
	    FileReader fr = new FileReader(trainFile);
	    BufferedReader br = new BufferedReader(fr);
	    String dataStr = null;
	    int count = 0;
	    if(c == 'd'){
		    while((dataStr = br.readLine()) != null){
		    	char[][] arrDigit = new char[27][30];
			    for(int i = 0; i < 27; i++){
			    	for(int j = 0; j < 30; j++){
			    		try{
			    			arrDigit[i][j] = dataStr.charAt(j);
			    		} catch (Exception e){
			    			
			    		}
			    	}
			    	dataStr = br.readLine();
			    }
			    if(count < 501){
			    	arrListDatatenpc.add(arrDigit);
			    }
			    else if(count < 1001 && count >= 501){
			    	arrListDatatwenpc.add(arrDigit);
			    }
			    else if(count < 1501 && count >= 1001){
			    	arrListDatathirdpc.add(arrDigit);
			    }
			    else if(count < 2001 && count >= 1501){
			    	arrListDatafourpc.add(arrDigit);
			    }
			    else if(count < 2501 && count >= 2001){
			    	arrListDatafifpc.add(arrDigit);
			    }
			    else if(count < 3001 && count >= 2501){
			    	arrListDatasixpc.add(arrDigit);
			    }
			    else if(count < 3501 && count >= 3001){
			    	arrListDatasevpc.add(arrDigit);
			    }
			    else if(count < 4001 && count >= 3501){
			    	arrListDataeigpc.add(arrDigit);
			    }
			    else if(count < 4501 && count >= 4001){
			    	arrListDataninpc.add(arrDigit);
			    }
			    else{
			    	
			    }
			    arrListData.add(arrDigit);
			    count++;
		    }
	    }
	    if(c == 'f'){
	    	while((dataStr = br.readLine()) != null){
	    		char[][] arrFace = new char[69][70];
			    for(int i = 0; i < 69; i++){
			    	for(int j = 0; j < 70; j++){
			    		try{
			    			arrFace[i][j] = dataStr.charAt(j);
			    		} catch (Exception e){
			    			
			    		}
			    	}
			    	dataStr = br.readLine();
			    }
			    if(count < 46){
			    	arrListDatatenpc.add(arrFace);
			    }
			    else if(count < 91 && count >= 46){
			    	arrListDatatwenpc.add(arrFace);
			    }
			    else if(count < 136 && count >= 91){
			    	arrListDatathirdpc.add(arrFace);
			    }
			    else if(count < 181 && count >= 136){
			    	arrListDatafourpc.add(arrFace);
			    }
			    else if(count < 226 && count >= 181){
			    	arrListDatafifpc.add(arrFace);
			    }
			    else if(count < 271 && count >= 226){
			    	arrListDatasixpc.add(arrFace);
			    }
			    else if(count < 316 && count >= 271){
			    	arrListDatasevpc.add(arrFace);
			    }
			    else if(count < 361 && count >= 316){
			    	arrListDataeigpc.add(arrFace);
			    }
			    else if(count < 406 && count >= 361){
			    	arrListDataninpc.add(arrFace);
			    }
			    else{
			    	
			    }
			    arrListData.add(arrFace);
			    count++;
		    }
	    }
	    FileReader filereader = new FileReader(trainLabels);
	    BufferedReader bufferedreader = new BufferedReader(filereader);
	    ArrayList<Character> arrLabelstenpc = new ArrayList<Character>();
	    ArrayList<Character> arrLabelstwenpc = new ArrayList<Character>();
	    ArrayList<Character> arrLabelsthirdpc = new ArrayList<Character>();
	    ArrayList<Character> arrLabelsfourpc = new ArrayList<Character>();
	    ArrayList<Character> arrLabelsfifpc = new ArrayList<Character>();
	    ArrayList<Character> arrLabelssixpc = new ArrayList<Character>();
	    ArrayList<Character> arrLabelssevpc = new ArrayList<Character>();
	    ArrayList<Character> arrLabelseigpc = new ArrayList<Character>();
	    ArrayList<Character> arrLabelsninpc = new ArrayList<Character>();
	    ArrayList<Character> arrLabels = new ArrayList<Character>();
	    String number = null;
	    int countLabels = 0;
	    while((number =  bufferedreader.readLine()) != null){
	    	int asciiVal = Integer.parseInt(number);
	    	char val = (char) asciiVal;
	    	if(c == 'f'){
		    	if(countLabels < 46){
			    	arrLabelstenpc.add(val);
			    }
			    else if(countLabels < 91 && countLabels >= 46){
			    	arrLabelstwenpc.add(val);
			    }
			    else if(countLabels < 136 && countLabels >= 91){
			    	arrLabelsthirdpc.add(val);
			    }
			    else if(countLabels < 181 && countLabels >= 136){
			    	arrLabelsfourpc.add(val);
			    }
			    else if(countLabels < 226 && countLabels >= 181){
			    	arrLabelsfifpc.add(val);
			    }
			    else if(countLabels < 271 && countLabels >= 226){
			    	arrLabelssixpc.add(val);
			    }
			    else if(countLabels < 316 && countLabels >= 271){
			    	arrLabelssevpc.add(val);
			    }
			    else if(countLabels < 361 && countLabels >= 316){
			    	arrLabelseigpc.add(val);
			    }
			    else if(countLabels < 406 && countLabels >= 361){
			    	arrLabelsninpc.add(val);
			    }
			    else{
			    	
			    }
		    	arrLabels.add(val);
	    	}
	    	else if(c == 'd'){
	    		if(countLabels < 501){
			    	arrLabelstenpc.add(val);
			    }
			    else if(countLabels < 1001 && countLabels >= 501){
			    	arrLabelstwenpc.add(val);
			    }
			    else if(countLabels < 1501 && countLabels >= 1001){
			    	arrLabelsthirdpc.add(val);
			    }
			    else if(countLabels < 2001 && countLabels >= 1501){
			    	arrLabelsfourpc.add(val);
			    }
			    else if(countLabels < 2501 && countLabels >= 2001){
			    	arrLabelsfifpc.add(val);
			    }
			    else if(countLabels < 3001 && countLabels >= 2501){
			    	arrLabelssixpc.add(val);
			    }
			    else if(countLabels < 3501 && countLabels >= 3001){
			    	arrLabelssevpc.add(val);
			    }
			    else if(countLabels < 4001 && countLabels >= 3501){
			    	arrLabelseigpc.add(val);
			    }
			    else if(countLabels < 4501 && countLabels >= 4001){
			    	arrLabelsninpc.add(val);
			    }
			    else{
			    	
			    }
	    		arrLabels.add(val);
	    	}
	    	countLabels++;
	    }
	    System.out.println("Training (10%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDatatenpc,arrLabelstenpc, false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDatatenpc,arrLabelstenpc,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatatenpc,arrLabelstenpc);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatatenpc,arrLabelstenpc);
	    }
	    System.out.println("Training (20%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDatatwenpc,arrLabelstwenpc,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDatatwenpc,arrLabelstwenpc,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatatwenpc,arrLabelstwenpc);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatatwenpc,arrLabelstwenpc);
	    }
	    System.out.println("Training (30%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDatathirdpc,arrLabelsthirdpc,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDatathirdpc,arrLabelsthirdpc,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatathirdpc,arrLabelsthirdpc);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatathirdpc,arrLabelsthirdpc);
	    }
	    System.out.println("Training (40%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDatafourpc,arrLabelsfourpc,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDatafourpc,arrLabelsfourpc,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatafourpc,arrLabelsfourpc);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatafourpc,arrLabelsfourpc);
	    }
	    System.out.println("Training (50%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDatafifpc,arrLabelsfifpc,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDatafifpc,arrLabelsfifpc,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatafifpc,arrLabelsfifpc);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatafifpc,arrLabelsfifpc);
	    }
	    System.out.println("Training (60%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDatasixpc,arrLabelssixpc,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDatasixpc,arrLabelssixpc,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatasixpc,arrLabelssixpc);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatasixpc,arrLabelssixpc);
	    }
	    System.out.println("Training (70%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDatasevpc,arrLabelssevpc,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDatasevpc,arrLabelssevpc,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatasevpc,arrLabelssevpc);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatasevpc,arrLabelssevpc);
	    }
	    System.out.println("Training (80%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDataeigpc,arrLabelseigpc,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDataeigpc,arrLabelseigpc,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDataeigpc,arrLabelseigpc);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDataeigpc,arrLabelseigpc);
	    }
	    System.out.println("Training (90%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDataninpc,arrLabelsninpc,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDataninpc,arrLabelsninpc,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDataninpc,arrLabelsninpc);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDataninpc,arrLabelsninpc);
	    }
	    System.out.println("Training (100%): ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListData,arrLabels,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListData,arrLabels,false);
	    }
	    if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListData,arrLabels);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListData,arrLabels);
	    }
	    ArrayList<char[][]> arrListDataValidate = new ArrayList<char[][]>();
	    FileReader frValidate = new FileReader(validationFile);
	    BufferedReader brValidate = new BufferedReader(frValidate);
	    String dataStrValidate = null;
	    if(c == 'd'){
		    while((dataStrValidate = brValidate.readLine()) != null){
		    	char[][] arrDigit = new char[30][30];
			    for(int i = 0; i < 27; i++){
			    	for(int j = 0; j < 30; j++){
			    		try{
			    			arrDigit[i][j] = dataStrValidate.charAt(j);
			    		} catch (Exception e){
			    			
			    		}
			    	}
			    	dataStrValidate = brValidate.readLine();
			    }
			    arrListDataValidate.add(arrDigit);
		    }
	    }
	    if(c == 'f'){
	    	while((dataStrValidate = brValidate.readLine()) != null){
	    		char[][] arrFace = new char[70][70];
			    for(int i = 0; i < 69; i++){
			    	for(int j = 0; j < 70; j++){
			    		try{
			    			arrFace[i][j] = dataStrValidate.charAt(j);
			    		} catch (Exception e){
			    			
			    		}
			    	}
			    	dataStrValidate = brValidate.readLine();
			    }
			    arrListDataValidate.add(arrFace);
		    }
	    }
	    FileReader filereaderValidate = new FileReader(validationLabels);
	    BufferedReader bufferedreaderValidate = new BufferedReader(filereaderValidate);
	    ArrayList<Character> arrLabelsValidate = new ArrayList<Character>();
	    String numberValidate = null;
	    while((numberValidate =  bufferedreaderValidate.readLine()) != null){
	    	int asciiVal = Integer.parseInt(numberValidate);
	    	char val = (char) asciiVal;
	    	arrLabelsValidate.add(val);
	    }
	    System.out.println("Validating: ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDataValidate,arrLabelsValidate,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDataValidate,arrLabelsValidate,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceValidate(arrListDataValidate,arrLabelsValidate,weights);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitValidate(arrListDataValidate,arrLabelsValidate,weightsArrList);
	    }
	    ArrayList<char[][]> arrListDataTest = new ArrayList<char[][]>();
	    FileReader frTest = new FileReader(testFile);
	    BufferedReader brTest = new BufferedReader(frTest);
	    String dataStrTest = null;
	    if(c == 'd'){
		    while((dataStrTest = brTest.readLine()) != null){
		    	char[][] arrDigit = new char[30][30];
			    for(int i = 0; i < 27; i++){
			    	for(int j = 0; j < 30; j++){
			    		try{
			    			arrDigit[i][j] = dataStrTest.charAt(j);
			    		} catch (Exception e){
			    			
			    		}
			    	}
			    	dataStrTest = brTest.readLine();
			    }
			    arrListDataTest.add(arrDigit);
		    }
	    }
	    if(c == 'f'){
	    	while((dataStrTest = brTest.readLine()) != null){
	    		char[][] arrFace = new char[70][70];
			    for(int i = 0; i < 69; i++){
			    	for(int j = 0; j < 70; j++){
			    		try{
			    			arrFace[i][j] = dataStrTest.charAt(j);
			    		} catch (Exception e){
			    			
			    		}
			    	}
			    	dataStrTest = brTest.readLine();
			    }
			    arrListDataTest.add(arrFace);
		    }
	    }
	    FileReader filereaderTest = new FileReader(testLabels);
	    BufferedReader bufferedreaderTest = new BufferedReader(filereaderTest);
	    ArrayList<Character> arrLabelsTest = new ArrayList<Character>();
	    String numberTest = null;
	    while((numberTest =  bufferedreaderTest.readLine()) != null){
	    	int asciiVal = Integer.parseInt(numberTest);
	    	char val = (char) asciiVal;
	    	arrLabelsTest.add(val);
	    }
	    System.out.println("Testing: ");
	    if(algo == 'n' && c == 'f'){
	    	NaiveBayes.naiveBayesFace(arrListDataTest,arrLabelsTest,false);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	NaiveBayes.naiveBayesDigit(arrListDataTest,arrLabelsTest,false);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    while(true){
	    	int index = 0;
			Scanner sc = new Scanner(System.in); 
			System.out.println("Would you like to use the test function? Enter 'y' for yes. Enter 'n' for no.");
			String input = sc.next();
			input = input.toLowerCase();
			char someInput = input.charAt(0);
			if(someInput != 'y' && someInput != 'n'){
				System.out.println("Invalid input.");
				continue;
			}
			if(someInput == 'y'){
				if(c == 'f' && algo == 'n'){
					while(true){
						System.out.println("Please enter an index of the image you would like to test");
						String input2 = sc.next();
						try{
							index = Integer.parseInt(input2);
						} catch(NumberFormatException e){
							System.out.println("Index must be an integer!");
							continue;
						}
						if(index > 150 || index < 1){
							System.out.println("Index out of bounds!");
							continue;
						}
						break;
					}
					NaiveBayes.naiveBayesFaceTestFunction(arrListDataTest, arrLabelsTest, index);
				}
				if(c == 'd' && algo == 'n'){
					while(true){
						System.out.println("Please enter an index of the image you would like to test");
						String input2 = sc.next();
						try{
							index = Integer.parseInt(input2);
						} catch(NumberFormatException e){
							System.out.println("Index must be an integer!");
							continue;
						}
						if(index > 1000 || index < 1){
							System.out.println("Index out of bounds!");
							continue;
						}
						break;
					}
					NaiveBayes.naiveBayesDigitTestFunction(arrListDataTest, arrLabelsTest, index);
				}
				if(c == 'f' && algo == 'p'){
					while(true){
						System.out.println("Please enter an index of the image you would like to test");
						String input2 = sc.next();
						try{
							index = Integer.parseInt(input2);
						} catch(NumberFormatException e){
							System.out.println("Index must be an integer!");
							continue;
						}
						if(index > 150 || index < 1){
							System.out.println("Index out of bounds!");
							continue;
						}
						break;
					}
					Perceptron.perceptronFaceTestFunction(arrListDataTest, arrLabelsTest, index, weights);
				}
				if(c == 'd' && algo == 'p'){
					while(true){
						System.out.println("Please enter an index of the image you would like to test");
						String input2 = sc.next();
						try{
							index = Integer.parseInt(input2);
						} catch(NumberFormatException e){
							System.out.println("Index must be an integer!");
							continue;
						}
						if(index > 1000 || index < 1){
							System.out.println("Index out of bounds!");
							continue;
						}
						break;
					}
					Perceptron.perceptronDigitTestFunction(arrListDataTest, arrLabelsTest, index, weightsArrList);	
				}
			}
			else {
				break;
			}
		}
	}
}
