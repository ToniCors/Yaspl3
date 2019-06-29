package parser;

import exception.TypeMismatchException;

public class TypeChecker {
	
	public static final String INT = "int";
	public static final String DOUBLE = "double";
	public static final String STRING = "string";
	public static final String CHAR = "char";
	public static final String BOOLE = "bool";
	public static final String VOID = "void";
	public static final String FUNCTION = "function";
	
	public static final String IN = "in";
	public static final String OUT = "out";
	public static final String INOUT = "inout";
	
	public static final String TRUE = "true";
	public static final String FALSE = "false";

	
	
	public static final String AddOP= "AddOP";
	public static final String MulOP = "MulOP" ;
	public static final String DiffOp = "DiffOp";
	public static final String DivOp = "DivOp";
	public static final String RelOp = "RelOp";
	public static final String EqOp = "EqOp";
	public static final String AssignOP= "AssignOP";
	public static final String UminusOP = "UminusOP";
	public static final String CallOP = "CallOP";
	public static final String ReadOP = "ReadOP";
	public static final String WriteOP = "WriteOP";
	public static final String NotOP = "NotOP";
	
	public static final String OrOP = "OrOP";
	public static final String AndOp = "AndOp";
	public static final String Conditionl = "Conditionl";


	public static String typeCheck(String op, String type1) throws TypeMismatchException {		
		// System.out.println("operation: " + op);
		if (op.equals(UminusOP)) {
			return typeCheckUminusOP(type1);
			
		} else if (op.equals(ReadOP)) {
			return typeCheckReadOP(type1);
			
		} else if (op.equals(WriteOP)) {
			return typeCheckWriteOP(type1);
			
		} else if (op.equals(NotOP)) {
			return typeCheckNotOP(type1);
			
		} else if (op.equals(Conditionl)) {
			return typeCheckConditionOP(type1);
		}

		throw new TypeMismatchException("1) Tipo: " + op + " errato,forse non hai visitato il nodo (type:"+type1+")");
	}




	public static String typeCheck(String op, String type1, String type2) throws TypeMismatchException {		
		// System.out.println("operation: " + op);
		if (op.equals(AddOP)) {
			return typeCheckAddOp(type1, type2);
			
		} else if (op.equals(MulOP) || op.equals(DiffOp) || op.equals(DivOp)) {
			return typeCheckAritmeticOP(type1, type2);
			
		} else if (op.equals(RelOp)) {
			return typeCheckRelationalOP(type1, type2);
			
		}  else if (op.equals(EqOp)) {
			return typeCheckEqOP(type1, type2);
			
		} else if (op.equals(AssignOP)) {
			return typeCheckAssignOP(type1, type2);
			
		} else if (op.equals(CallOP)) {
			return typeCheckCallOP(type1, type2);
			
		} else if (op.equals(OrOP) || op.equals(AndOp)) {
			return typeCheckOrAndOP(type1, type2);
			
		} 
		throw new TypeMismatchException("2) Tipo: " + op + " errato,forse non hai visitato il nodo (types: "+type1+" , "+type2+" );");
	}

	// addizione
	private static String typeCheckAddOp(String type1, String type2) throws TypeMismatchException {

		if (type1.equals(INT) && type2.equals(INT)) {
			return INT;
		} else if (type1.equals(INT) && type2.equals(CHAR)) {
			return INT;
		} else if (type1.equals(INT) && type2.equals(BOOLE)) {
			return INT;			
		}else if (type1.equals(INT) && type2.equals(DOUBLE)) {
			return DOUBLE;
		} else if (type1.equals(INT) && type2.equals(STRING)) {
			return STRING;
		
		}else if (type1.equals(DOUBLE) && type2.equals(DOUBLE)) {
			return DOUBLE;
		} else if (type1.equals(DOUBLE) && type2.equals(BOOLE)) {
			return DOUBLE;
		}else if (type1.equals(DOUBLE) && type2.equals(CHAR)) {
			return DOUBLE;
		}else if (type1.equals(DOUBLE) && type2.equals(INT)) {
			return DOUBLE;
		} else if (type1.equals(DOUBLE) && type2.equals(STRING)) {
			return STRING;
			
		}  else if (type1.equals(STRING) && type2.equals(STRING)) {
			return STRING;
		} else if (type1.equals(STRING) && type2.equals(INT)) {
			return STRING;
		} else if (type1.equals(STRING) && type2.equals(DOUBLE)) {
			return STRING;
		} else if (type1.equals(STRING) && type2.equals(CHAR)) {
			return STRING;
			
		}else if (type1.equals(CHAR) && type2.equals(STRING)) {
			return STRING;
		}else if (type1.equals(CHAR) && type2.equals(INT)) {
			return INT;
		}else if (type1.equals(CHAR) && type2.equals(DOUBLE)) {
			return DOUBLE;
		} else if (type1.equals(CHAR) && type2.equals(CHAR)) {
			return STRING;
		} else if (type1.equals(CHAR) && type2.equals(BOOLE)) {
			return INT;
			
		}else if (type1.equals(BOOLE) && type2.equals(INT)) {
			return INT;
		}  else if (type1.equals(BOOLE) && type2.equals(DOUBLE)) {
			return DOUBLE;
		}  else if (type1.equals(BOOLE) && type2.equals(CHAR)) {
			return INT;
		} else if (type1.equals(BOOLE) && type2.equals(BOOLE)) {
			return INT;
		} else {
			throw new TypeMismatchException(
					"Impossibile sommare un: " + type1 + " con un: " + type2);
		}
	}

	// moltipplicazione, divisione, differenza
	private static String typeCheckAritmeticOP(String type1, String type2) throws TypeMismatchException {
		if (type1.equals(INT) && type2.equals(INT)) {
			return INT;
		} else if (type1.equals(INT) && type2.equals(DOUBLE)) {
			return DOUBLE;
		}  else if (type1.equals(INT) && type2.equals(CHAR)) {
			return INT;
		} else if (type1.equals(INT) && type2.equals(BOOLE)) {
			return INT;			
		} else if (type1.equals(DOUBLE) && type2.equals(DOUBLE)) {
			return DOUBLE;
		} else if (type1.equals(DOUBLE) && type2.equals(INT)) {
			return DOUBLE;
		} else if (type1.equals(DOUBLE) && type2.equals(BOOLE)) {
			return DOUBLE;
		}else if (type1.equals(DOUBLE) && type2.equals(CHAR)) {
			return DOUBLE;
		}else if (type1.equals(CHAR) && type2.equals(INT)) {
			return INT;
		}else if (type1.equals(CHAR) && type2.equals(DOUBLE)) {
			return DOUBLE;
		} else if (type1.equals(CHAR) && type2.equals(CHAR)) {
			return INT;
		} else if (type1.equals(CHAR) && type2.equals(BOOLE)) {
			return INT;			
		}else if (type1.equals(BOOLE) && type2.equals(INT)) {
			return INT;
		}  else if (type1.equals(BOOLE) && type2.equals(DOUBLE)) {
			return DOUBLE;
		}  else if (type1.equals(BOOLE) && type2.equals(CHAR)) {
			return INT;
		} else if (type1.equals(BOOLE) && type2.equals(BOOLE)) {
			return INT;
		} 
		throw new TypeMismatchException(
				"Impossibile moltiplicare,dividere o sotrrarre un: " + type1 + " con un: " + type2);
	}

	// gt,ge,lt,le
	private static String typeCheckRelationalOP(String boole1, String boole2) throws TypeMismatchException {

		if (boole1.equals(CHAR) && boole2.equals(CHAR)) {
			return BOOLE;
		} else if (boole1.equals(INT) && boole2.equals(INT)) {
			return BOOLE;
		} else if (boole1.equals(INT) && boole2.equals(CHAR)) {
			return BOOLE;
		} else if (boole1.equals(DOUBLE) && boole2.equals(DOUBLE)) {
			return BOOLE;
		}  else if (boole1.equals(DOUBLE) && boole2.equals(CHAR)) {
			return BOOLE;
		} else if (boole1.equals(DOUBLE) && boole2.equals(INT)) {
			return BOOLE;
		} else if (boole1.equals(INT) && boole2.equals(DOUBLE)) {
			return BOOLE;
		} else if (boole1.equals(STRING) && boole2.equals(STRING)) {
			return BOOLE;
		} else if (boole1.equals(CHAR) && boole2.equals(INT)) {
				return BOOLE;
		}  else if (boole1.equals(CHAR) && boole2.equals(DOUBLE)) {
			return BOOLE;
		} else {
			throw new TypeMismatchException(
					"Impossibile accoppiare un: " + boole1 + " con un: " + boole2 + " in un operazione relazionale");
		}

	}
	
	//eq
	private static String typeCheckEqOP(String boole1, String boole2) throws TypeMismatchException {

		if (boole1.equals(BOOLE) && boole2.equals(BOOLE)) {
			return BOOLE;
		}else {	
		return typeCheckRelationalOP(boole1,boole2);}
	}

	// assegnamento
	private static String typeCheckAssignOP(String boole1, String boole2) throws TypeMismatchException {

		if (boole1.equals(INT) && boole2.equals(INT)) {
			return VOID;
		}else if(boole1.equals(INT) && boole2.equals(DOUBLE)) {
			return VOID;
		}else if(boole1.equals(INT) && boole2.equals(BOOLE)) {
			return VOID;
		}else if(boole1.equals(INT) && boole2.equals(CHAR)) {
			return VOID;
		}else if(boole1.equals(DOUBLE) && boole2.equals(INT)) {
			return VOID;
		}else if(boole1.equals(DOUBLE) && boole2.equals(DOUBLE)) {
			return VOID;
		}else if(boole1.equals(DOUBLE) && boole2.equals(CHAR)) {
			return VOID;
		}else if(boole1.equals(STRING) && boole2.equals(STRING)) {
			return VOID;
		}else if(boole1.equals(CHAR) && boole2.equals(INT)) {
			return VOID;
		}else if(boole1.equals(CHAR) && boole2.equals(DOUBLE)) {
			return VOID;
		}else if(boole1.equals(CHAR) && boole2.equals(CHAR)) {
			return VOID;
		}else if(boole1.equals(BOOLE) && boole2.equals(BOOLE)) {
			return VOID;
		}else if(boole1.equals(BOOLE) && boole2.equals(INT)) {
			return VOID;
		} else {
			throw new TypeMismatchException(
					"Impossibile assegnare un: " + boole1 + " con un: " + boole2 + " in un assegnamento");
		}

	}

	// uminus
	private static String typeCheckUminusOP(String type1) throws TypeMismatchException {
		
		if(type1.equals(INT)) {
			return INT;
		}else if(type1.equals(DOUBLE)) {
			return DOUBLE;
		}/*else if(type1.equals(STRING)) {
			return STRING;
		}*/else{throw new TypeMismatchException("Impossibile utilizzare unminus con un tipo: " + type1);}

	}

	//call
	private static String typeCheckCallOP(String type1, String type2) throws TypeMismatchException {
	
		if (type1.equals(INT) && type2.equals(INT)) {
			return VOID;
		} else if (type1.equals(INT) && type2.equals(BOOLE)) {
			return VOID;
		}else if (type1.equals(INT) && type2.equals(DOUBLE)) {
			return VOID;
		}else if (type1.equals(INT) && type2.equals(CHAR)) {
			return VOID;
		}else if (type1.equals(DOUBLE) && type2.equals(DOUBLE)) {
			return VOID;
		}else if (type1.equals(DOUBLE) && type2.equals(INT)) {
			return VOID;
		}else if (type1.equals(DOUBLE) && type2.equals(CHAR)) {
			return VOID;
		}else if (type1.equals(DOUBLE) && type2.equals(BOOLE)) {
			return VOID;
		}else if (type1.equals(BOOLE) && type2.equals(BOOLE)) {
			return VOID;
		}else if (type1.equals(BOOLE) && type2.equals(INT)) {
			return VOID;
		}else if (type1.equals(BOOLE) && type2.equals(DOUBLE)) {
			return VOID;
		} else if (type1.equals(BOOLE) && type2.equals(CHAR)) {
			return VOID;
		}  else if (type1.equals(STRING) && type2.equals(STRING)) {
			return VOID;
		}else if (type1.equals(CHAR) && type2.equals(CHAR)) {
			return VOID;
		}else if (type1.equals(CHAR) && type2.equals(INT)) {
			return VOID;
		} else if (type1.equals(CHAR) && type2.equals(DOUBLE)) {
			return VOID;
		}  else if (type1.equals(CHAR) && type2.equals(BOOLE)) {
			return VOID;
		}  else {
			throw new TypeMismatchException(
					"Impossibile accoppiare un: " + type1 + " con un: " + type2 + " in una CallOP");
		}
	}
	
	//readop
	private static String typeCheckReadOP(String type1) throws TypeMismatchException {
		if (!type1.equals(BOOLE)) {
			return VOID;
		} else {
			throw new TypeMismatchException("Impossibile utilizzare un tipo: " + type1 + " in una read");
		}
	}
	
	//writeop
	private static String typeCheckWriteOP(String type1) throws TypeMismatchException {
		return VOID;
	}	
	
	// not
	private static String typeCheckNotOP(String boole) throws TypeMismatchException {

		if (boole.equals(BOOLE)) {
			return BOOLE;
		} else if (boole.equals(INT)) {
			return BOOLE;
		} else if (boole.equals(DOUBLE)) {
			return BOOLE;
		}  else if (boole.equals(CHAR)) {
			return BOOLE;
		}  else {
			throw new TypeMismatchException("Impossibile utilizzare un tipo: " + boole + " in una negazione");
		}

	}

	// and e or
	private static String typeCheckOrAndOP(String boole1, String boole2) throws TypeMismatchException {

		if (boole1.equals(BOOLE) && boole2.equals(BOOLE)) {
			return BOOLE;
		} else {
			throw new TypeMismatchException(
					"Impossibile accoppiare un: " + boole1 + " con un: " + boole2 + " in un operazione And o Or");
		}

	}
	
	// if then ,if then else, while
	private static String typeCheckConditionOP(String boole) throws TypeMismatchException {

		if (boole.equals(BOOLE) || boole.equals(INT)) {
			return VOID;
		} else {
			throw new TypeMismatchException("Impossibile utilizzare un tipo: " + boole + " come condizione");
		}

	}

}