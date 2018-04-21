import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipFile;



public class Driver {
	public static void main(String[] args) throws IOException{
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
					sc.close();
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
	    	
	    }
	    ArrayList<char[][]> arrListData = new ArrayList<char[][]>();
	    FileReader fr = new FileReader(trainFile);
	    BufferedReader br = new BufferedReader(fr);
	    //char[][] arrDigit = new char[30][30];
	    //char[][] arrFace = new char[70][70];
	    String dataStr = null;
	    if(c == 'd'){
		    while((dataStr = br.readLine()) != null){
		    	char[][] arrDigit = new char[30][30];
			    for(int i = 0; i < 27; i++){
			    	for(int j = 0; j < 30; j++){
			    		try{
			    			arrDigit[i][j] = dataStr.charAt(j);
			    		} catch (Exception e){
			    			
			    		}
			    		//System.out.print(arrDigit[i][j]);
			    	}
			    	//System.out.println();
			    	dataStr = br.readLine();
			    }
			    arrListData.add(arrDigit);
			    /*if(br.readLine() == null){
			    	break;
			    }
			    else{
			    	br.readLine();
			    }*/
		    }
	    }
	    if(c == 'f'){
	    	while((dataStr = br.readLine()) != null){
	    		char[][] arrFace = new char[70][70];
			    for(int i = 0; i < 69; i++){
			    	for(int j = 0; j < 70; j++){
			    		try{
			    			arrFace[i][j] = dataStr.charAt(j);
			    		} catch (Exception e){
			    			
			    		}
			    		//System.out.print(arrFace[i][j]);
			    	}
			    	//System.out.println();
			    	dataStr = br.readLine();
			    }
			    arrListData.add(arrFace);
			    /*if(br.readLine() == null){
			    	break;
			    }
			    else {
			    	br.readLine();
			    }*/
		    }
	    }
	    FileReader filereader = new FileReader(trainLabels);
	    BufferedReader bufferedreader = new BufferedReader(filereader);
	    ArrayList<Character> arrLabels = new ArrayList<Character>();
	    String number = null;
	    while((number =  bufferedreader.readLine()) != null){
	    	int asciiVal = Integer.parseInt(number);
	    	char val = (char) asciiVal;
	    	arrLabels.add(val);
	    }
	    System.out.println("Training: ");
	    if(algo == 'n' && c == 'f'){
	    	int result = NaiveBayes.naiveBayesFace(arrListData,arrLabels);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	int result = NaiveBayes.naiveBayesDigit(arrListData,arrLabels);
	    }
	    System.out.println("Training: ");
	    if(algo == 'p' && c == 'f'){
	    	int result = Perceptron.perceptronFace(arrListData,arrLabels);
	    }
	    else if(algo == 'p' && c == 'd'){
	    	int result = Perceptron.perceptronDigit(arrListData,arrLabels);
	    }
	    ArrayList<char[][]> arrListDataValidate = new ArrayList<char[][]>();
	    FileReader frValidate = new FileReader(validationFile);
	    BufferedReader brValidate = new BufferedReader(frValidate);
	    //char[][] arrDigit = new char[30][30];
	    //char[][] arrFace = new char[70][70];
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
			    		//System.out.print(arrDigit[i][j]);
			    	}
			    	//System.out.println();
			    	dataStrValidate = brValidate.readLine();
			    }
			    arrListDataValidate.add(arrDigit);
			    /*if(br.readLine() == null){
			    	break;
			    }
			    else{
			    	br.readLine();
			    }*/
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
			    		//System.out.print(arrFace[i][j]);
			    	}
			    	//System.out.println();
			    	dataStrValidate = brValidate.readLine();
			    }
			    arrListDataValidate.add(arrFace);
			    /*if(br.readLine() == null){
			    	break;
			    }
			    else {
			    	br.readLine();
			    }*/
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
	    	int result = NaiveBayes.naiveBayesFace(arrListDataValidate,arrLabelsValidate);
	    }
	    else if(algo == 'n' && c == 'd'){
	    	int result = NaiveBayes.naiveBayesDigit(arrListDataValidate,arrLabelsValidate);
	    }
	}
}
