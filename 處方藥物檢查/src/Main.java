import java.io.*;
import java.util.ArrayList;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[]allergyList= {"Penicillin","Aspirin","Sulfa"};//病人的過敏史
		ArrayList<String>prescription=new ArrayList<>();//醫生開的藥物
		String input="";//輸入的藥物

		while((input=br.readLine())!=null && !input.trim().isEmpty()) {
			prescription.add(input.trim());
		}
		String[]p=prescription.toArray(new String[0]);
		checkPrescription(allergyList,p);

		br.close();
	}
public static void checkPrescription(String[] allergys, String[] pres) {
	boolean isApproved=true;
	ArrayList<String>rejectedDrugs=new ArrayList<>();
	for(String drug:pres) {
		for(String allergy:allergys ) {
			if(drug.equalsIgnoreCase(allergy)) {
				rejectedDrugs.add(drug);
				isApproved=false;
				break;
			}
		}

	}if(isApproved) {
		System.out.println("APPROVED");
	}else {
		System.out.println("REJECTED");
		System.out.println();
		for(String drug:rejectedDrugs) {
			System.out.println(drug);
		}
	}
}
}
