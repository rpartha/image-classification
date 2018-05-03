import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipFile;
import java.util.Random;


public class Driver {
	public static void randomize(char c, ArrayList<char[][]> arrImageData, ArrayList<Character> arrLabels){
		Random rand = new Random();
		char[][] tempData;
		char tempLabel;
		int n = 0;
		if(c == 'd'){
			for(int i = 0; i < 5000; i++){
				while(true){
					n = rand.nextInt(5000);
					if(n != i){
						break;
					}
				}
				tempData = arrImageData.get(i);
				tempLabel = arrLabels.get(i);
				arrImageData.set(i,arrImageData.get(n)); 
				arrLabels.set(i, arrLabels.get(n));
				arrImageData.set(n, tempData);
				arrLabels.set(n, tempLabel);
			}
		}
		if(c == 'f'){
			for(int i = 0; i < 451; i++){
				while(true){
					n = rand.nextInt(451);
					if(n != i){
						break;
					}
				}
				tempData = arrImageData.get(i);
				tempLabel = arrLabels.get(i);
				arrImageData.set(i,arrImageData.get(n)); 
				arrLabels.set(i, arrLabels.get(n));
				arrImageData.set(n, tempData);
				arrLabels.set(n, tempLabel);
			}
		}
	}
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
			    /*if(count < 501){
			    	arrListDatatenpc.add(arrDigit);
			    }
			    if(count < 1001){
			    	arrListDatatwenpc.add(arrDigit);
			    }
			    if(count < 1501){
			    	arrListDatathirdpc.add(arrDigit);
			    }
			    if(count < 2001){
			    	arrListDatafourpc.add(arrDigit);
			    }
			    if(count < 2501){
			    	arrListDatafifpc.add(arrDigit);
			    }
			    if(count < 3001){
			    	arrListDatasixpc.add(arrDigit);
			    }
			    if(count < 3501){
			    	arrListDatasevpc.add(arrDigit);
			    }
			    if(count < 4001){
			    	arrListDataeigpc.add(arrDigit);
			    }
			    if(count < 4501){
			    	arrListDataninpc.add(arrDigit);
			    }
			    else{
			    	
			    }*/
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
			    /*if(count < 46){
			    	arrListDatatenpc.add(arrFace);
			    }
			    if(count < 91){
			    	arrListDatatwenpc.add(arrFace);
			    }
			    if(count < 136){
			    	arrListDatathirdpc.add(arrFace);
			    }
			    if(count < 181){
			    	arrListDatafourpc.add(arrFace);
			    }
			    if(count < 226){
			    	arrListDatafifpc.add(arrFace);
			    }
			    if(count < 271){
			    	arrListDatasixpc.add(arrFace);
			    }
			    if(count < 316){
			    	arrListDatasevpc.add(arrFace);
			    }
			    if(count < 361){
			    	arrListDataeigpc.add(arrFace);
			    }
			    if(count < 406){
			    	arrListDataninpc.add(arrFace);
			    }
			    else{
			    	
			    }*/
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
		    	/*if(countLabels < 46){
			    	arrLabelstenpc.add(val);
			    }
			    if(countLabels < 91){
			    	arrLabelstwenpc.add(val);
			    }
			    if(countLabels < 136){
			    	arrLabelsthirdpc.add(val);
			    }
			    if(countLabels < 181){
			    	arrLabelsfourpc.add(val);
			    }
			    if(countLabels < 226){
			    	arrLabelsfifpc.add(val);
			    }
			    if(countLabels < 271){
			    	arrLabelssixpc.add(val);
			    }
			    if(countLabels < 316){
			    	arrLabelssevpc.add(val);
			    }
			    if(countLabels < 361){
			    	arrLabelseigpc.add(val);
			    }
			    if(countLabels < 406){
			    	arrLabelsninpc.add(val);
			    }
			    else{
			    	
			    }*/
		    	arrLabels.add(val);
	    	}
	    	else if(c == 'd'){
	    		/*if(countLabels < 501){
			    	arrLabelstenpc.add(val);
			    }
			    if(countLabels < 1001){
			    	arrLabelstwenpc.add(val);
			    }
			    if(countLabels < 1501){
			    	arrLabelsthirdpc.add(val);
			    }
			    if(countLabels < 2001){
			    	arrLabelsfourpc.add(val);
			    }
			    if(countLabels < 2501){
			    	arrLabelsfifpc.add(val);
			    }
			    if(countLabels < 3001){
			    	arrLabelssixpc.add(val);
			    }
			    if(countLabels < 3501){
			    	arrLabelssevpc.add(val);
			    }
			    if(countLabels < 4001){
			    	arrLabelseigpc.add(val);
			    }
			    if(countLabels < 4501){
			    	arrLabelsninpc.add(val);
			    }
			    else{
			    	
			    }*/
	    		arrLabels.add(val);
	    	}
	    	countLabels++;
	    }
	    randomize(c, arrListData,arrLabels);
	    if(c == 'f'){
	    	for(int i = 0; i < 451; i++){
	    		if(i < 46){
	    			arrListDatatenpc.add(arrListData.get(i));
			    	arrLabelstenpc.add(arrLabels.get(i));
			    }
			    if(i < 91){
			    	arrListDatatwenpc.add(arrListData.get(i));
			    	arrLabelstwenpc.add(arrLabels.get(i));
			    }
			    if(i < 136){
			    	arrListDatathirdpc.add(arrListData.get(i));
			    	arrLabelsthirdpc.add(arrLabels.get(i));
			    }
			    if(i < 181){
			    	arrListDatafourpc.add(arrListData.get(i));
			    	arrLabelsfourpc.add(arrLabels.get(i));
			    }
			    if(i < 226){
			    	arrListDatafifpc.add(arrListData.get(i));
			    	arrLabelsfifpc.add(arrLabels.get(i));
			    }
			    if(i < 271){
			    	arrListDatasixpc.add(arrListData.get(i));
			    	arrLabelssixpc.add(arrLabels.get(i));
			    }
			    if(i < 316){
			    	arrListDatasevpc.add(arrListData.get(i));
			    	arrLabelssevpc.add(arrLabels.get(i));
			    }
			    if(i < 361){
			    	arrListDataeigpc.add(arrListData.get(i));
			    	arrLabelseigpc.add(arrLabels.get(i));
			    }
			    if(i < 406){
			    	arrListDataninpc.add(arrListData.get(i));
			    	arrLabelsninpc.add(arrLabels.get(i));
			    }
			    else{
			    	
			    }
	    	}
	    }
	    if(c == 'd'){
	    	for(int i = 0; i < 5000; i++){
	    		if(i < 501){
	    			arrListDatatenpc.add(arrListData.get(i));
			    	arrLabelstenpc.add(arrLabels.get(i));
			    }
			    if(i < 1001){
			    	arrListDatatwenpc.add(arrListData.get(i));
			    	arrLabelstwenpc.add(arrLabels.get(i));
			    }
			    if(i < 1501){
			    	arrListDatathirdpc.add(arrListData.get(i));
			    	arrLabelsthirdpc.add(arrLabels.get(i));
			    }
			    if(i < 2001){
			    	arrListDatafourpc.add(arrListData.get(i));
			    	arrLabelsfourpc.add(arrLabels.get(i));
			    }
			    if(i < 2501){
			    	arrListDatafifpc.add(arrListData.get(i));
			    	arrLabelsfifpc.add(arrLabels.get(i));
			    }
			    if(i < 3001){
			    	arrListDatasixpc.add(arrListData.get(i));
			    	arrLabelssixpc.add(arrLabels.get(i));
			    }
			    if(i < 3501){
			    	arrListDatasevpc.add(arrListData.get(i));
			    	arrLabelssevpc.add(arrLabels.get(i));
			    }
			    if(i < 4001){
			    	arrListDataeigpc.add(arrListData.get(i));
			    	arrLabelseigpc.add(arrLabels.get(i));
			    }
			    if(i < 4501){
			    	arrListDataninpc.add(arrListData.get(i));
			    	arrLabelsninpc.add(arrLabels.get(i));
			    }
			    else{
			    	
			    }
	    	}
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
	    /*System.out.println("Validating: ");
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
	    }*/
	    ArrayList<char[][]> arrListDataTest = new ArrayList<char[][]>();
	    ArrayList<double[][]> arrListFinal = new ArrayList<>();
	    FileReader frTest = new FileReader(testFile);
	    BufferedReader brTest = new BufferedReader(frTest);
	    String dataStrTest = null;
	    if(c == 'd'){
		    while((dataStrTest = brTest.readLine()) != null){
		    	char[][] arrDigit = new char[27][30];
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
	    		char[][] arrFace = new char[69][70];
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
	    System.out.println("Training (10%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListDatatenpc,arrLabelstenpc, true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListDatatenpc,arrLabelstenpc,false);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatatenpc,arrLabelstenpc);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatatenpc,arrLabelstenpc);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    System.out.println("Training (20%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListDatatwenpc,arrLabelstwenpc,true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListDatatwenpc,arrLabelstwenpc,true);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatatwenpc,arrLabelstwenpc);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatatwenpc,arrLabelstwenpc);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    System.out.println("Training (30%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListDatathirdpc,arrLabelsthirdpc,true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListDatathirdpc,arrLabelsthirdpc,true);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatathirdpc,arrLabelsthirdpc);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatathirdpc,arrLabelsthirdpc);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    System.out.println("Training (40%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListDatafourpc,arrLabelsfourpc,true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListDatafourpc,arrLabelsfourpc,true);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatafourpc,arrLabelsfourpc);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatafourpc,arrLabelsfourpc);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    System.out.println("Training (50%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListDatafifpc,arrLabelsfifpc,true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListDatafifpc,arrLabelsfifpc,true);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatafifpc,arrLabelsfifpc);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatafifpc,arrLabelsfifpc);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    System.out.println("Training (60%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListDatasixpc,arrLabelssixpc,true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListDatasixpc,arrLabelssixpc,true);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatasixpc,arrLabelssixpc);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatasixpc,arrLabelssixpc);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    System.out.println("Training (70%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListDatasevpc,arrLabelssevpc,true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListDatasevpc,arrLabelssevpc,true);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDatasevpc,arrLabelssevpc);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDatasevpc,arrLabelssevpc);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    System.out.println("Training (80%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListDataeigpc,arrLabelseigpc,true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListDataeigpc,arrLabelseigpc,true);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDataeigpc,arrLabelseigpc);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDataeigpc,arrLabelseigpc);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    System.out.println("Training (90%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListDataninpc,arrLabelsninpc,true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListDataninpc,arrLabelsninpc,true);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListDataninpc,arrLabelsninpc);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListDataninpc,arrLabelsninpc);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    System.out.println("Training (100%): ");
	    if(algo == 'n' && c == 'f'){
	    	arrListFinal = NaiveBayes.naiveBayesFaceTrain(arrListData,arrLabels,true);
	    	NaiveBayes.naiveBayesFaceTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	arrListFinal = NaiveBayes.naiveBayesDigitTrain(arrListData,arrLabels,true);
	    	NaiveBayes.naiveBayesDigitTest(arrListDataTest,arrLabelsTest,false,arrListFinal);
	    }
	    if(algo == 'p' && c == 'f'){
	    	weights = Perceptron.perceptronFaceTrain(arrListData,arrLabels);
	    	Perceptron.perceptronFaceTest(arrListDataTest,arrLabelsTest,weights,false);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	weightsArrList = Perceptron.perceptronDigitTrain(arrListData,arrLabels);
	    	Perceptron.perceptronDigitTest(arrListDataTest,arrLabelsTest,weightsArrList, false);
	    }
	    /*System.out.println("Testing: ");
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
	    }*/
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
					NaiveBayes.naiveBayesFaceTestFunction(arrListDataTest, arrLabelsTest, index,arrListFinal);
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
					NaiveBayes.naiveBayesDigitTestFunction(arrListDataTest, arrLabelsTest, index,arrListFinal);
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