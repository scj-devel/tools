package sw10.spideybc.util;

import sw10.spideybc.program.AnalysisSpecification;

import com.ibm.wala.classLoader.IMethod;
import com.ibm.wala.types.TypeName;

public class OutputPrinter {

	/* Used to mute test cases */
	public static AnalysisSpecification analysisSpecification = 	AnalysisSpecification.getAnalysisSpecification();	
	
	public enum AnnotationType {
		AnnotationLoop,
		AnnotationArray
	}
	
	public enum ModelType {
		ModelEntry
	}

	/* Accepted loop annotation format */
	private static final String loopSpideyBC = "\'//@ loopbound\'";
	private static final String loopWCA = "\'//@ WCA loop\'";
	
	/* Accepted array annotation format */
	private static final String arraySpideyBC = "\'//@ length\'";
	
	public static void printAnnotationError(AnnotationType type, IMethod method, int lineNumber) {
		StringBuilder msg = new StringBuilder();
		StringBuilder ann = new StringBuilder();
		
		switch(type) {
		case AnnotationLoop:
			msg.append("No loop bound ");
			ann.append(loopSpideyBC + " OR " + loopWCA);
			break;
		case AnnotationArray:
			msg.append("No array length ");
			ann.append(arraySpideyBC);
			break;
		}
		
		msg.append("detected in " + method.getSignature() + "\n");
		msg.append("\tExpected annotation " + ann + " at line " + lineNumber);
		
		OutputPrinter.printError(msg.toString());
	}
	
	public static void printModelError(ModelType type, IMethod method, int lineNumber, TypeName typeName) {
		StringBuilder msg = new StringBuilder();
		msg.append("Model does not contain type '" + typeName + "' at line " + lineNumber + " in " + method.getDeclaringClass().getName().toString());
		OutputPrinter.printError(msg.toString());
	}
	
	public static void printError(String msg) {
		if (RunConfiguration.MUTE == OutputPrinter.analysisSpecification.getRunConfiguration()) {			
			return;			
		}
		
		System.err.println("ERROR: " + msg);
	}
	
	public static void printWarning(String msg) {
		if (RunConfiguration.DEBUG == OutputPrinter.analysisSpecification.getRunConfiguration()) {			
			System.out.println("WARNING: " + msg);			
		}
	}
	
	public static void printInfo(String msg) {
		if (RunConfiguration.DEBUG == OutputPrinter.analysisSpecification.getRunConfiguration()) {
			System.out.println("Info: " + msg);
		}
	}
}
