package parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import astNodes.AddOP;
import astNodes.AndOP;
import astNodes.AssignOP;
import astNodes.BodyOP;
import astNodes.BooleanConst;
import astNodes.CallOP;
import astNodes.CharConst;
import astNodes.CompStatOP;
import astNodes.Decls;
import astNodes.DiffOP;
import astNodes.DivOP;
import astNodes.DoubleConst;
import astNodes.EqOP;
import astNodes.Expr;
import astNodes.GeOP;
import astNodes.GtOP;
import astNodes.Identifier;
import astNodes.IfThenElseOp;
import astNodes.IfThenOp;
import astNodes.IntConst;
import astNodes.LeOP;
import astNodes.LtOP;
import astNodes.MulOP;
import astNodes.NotOP;
import astNodes.OrOP;
import astNodes.ParOP;
import astNodes.ProcDecelOP;
import astNodes.ProgramOP;
import astNodes.ReadOP;
import astNodes.Statment;
import astNodes.StringConst;
import astNodes.UminusOP;
import astNodes.VarDecelOP;
import astNodes.VarInitOP;
import astNodes.WhileOP;
import astNodes.WriteOP;
import exception.FatalError;
import exception.NotDeclaretionException;
import lexical.SymbolTable;

public class CBuilder implements Visitor {

	private FileWriter outputC;

	private static final String STRING_CONCAT = "char* concat(const char *s1, const char *s2){\nchar *result = malloc(strlen(s1) + strlen(s2) + 1);\nstrcpy(result, s1);\nstrcat(result, s2);\nreturn result;}\n\n\n";
	private static final String INT_TO_STRING = "char* IntToString(int i){\n int temp= i, count=1;\nwhile (temp!=0){ temp/=10; count++;}\nchar * buffer_temp = malloc ((count+1) * sizeof(char));\nchar buffer [strlen(buffer_temp) +1];\nsprintf(buffer, \"%d\", i);\nstrcpy(buffer_temp, buffer);\nreturn buffer_temp;}\n\n\n";
	private static final String CHAR_TO_STRING = "char* CharToString(char c) {\n char * buffer_temp = malloc ((2) * sizeof(char));\nchar buffer [2];\nsprintf(buffer, \"%c\", c);\nstrcpy(buffer_temp, buffer);\nreturn buffer_temp;\n}\n\n";
	private static final String DOUBLE_TO_STRING = "char* DoubleToString(double d) {\nchar * buf;\nint n=20;\ndouble fraction = d - ((long)d);\nint number_of_decimal_digits=1, limit=1;\nint power=10;\nwhile(power*fraction >= limit && number_of_decimal_digits<=4){\nfraction = power*fraction; power*=10; number_of_decimal_digits++;\n}\nint p;\nbuf= malloc (number_of_decimal_digits*10 * sizeof(double));\nfor (p = 0; p < number_of_decimal_digits; p++) {\ndouble x;\nif (snprintf(buf, n, \"%.*g\", p, d) >= n) break;\nsscanf(buf, \"%lf\", &x);\nif (x == d) break;\n}\nreturn buf;\n}\n\n\n";
	private ArrayList<String> keyWord ;
	
	public CBuilder(File out) throws IOException {
		outputC = new FileWriter(out);
		
		
		keyWord = new ArrayList<String>() {{
		    add("auto");
		    add("break");
		    add("case");		    
		    add("char");
		    add("const");
		    add("continue");
		    add("default");
		    add("do");
		    add("double");
		    add("else");
		    add("enum");
		    add("extern");
		    add("float");
		    add("for");
		    add("goto");
		    add("if");
		    add("int");
		    add("long");
		    add("register");
		    add("return");		    
		    add("short");
		    add("signed");
		    add("sizeof");
		    add("static");
		    add("struct");
		    add("switch");
		    add("typedef");
		    add("union");
		    add("unsigned");
		    add("void");
		    add("volatile");
		    add("while");
		}};
	}

	@Override
	public void visit(Visitable visitable) {

		String className = visitable.getClass().getName();
		//System.out.println("class name "+ className);
		switch (className) {
		case "astNodes.ProgramOP":
			try {
				cBuilderProgramOP(visitable);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.VarDecelOP":
			try {
				cBuilderVarDecelOP(visitable);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.VarInitOP":
			try {
				cBuilderVarInitOP(visitable);
			} catch (IOException | FatalError e) {
				e.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.ProcDecelOP":
			try {
				cBuilderProcDecelOP(visitable);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.ParOP":
			try {
				cBuilderParOP(visitable);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.BodyOP":
			try {
				cBuilderBodyOP(visitable);
			} catch (IOException e3) {
				e3.printStackTrace();	
				System.exit(0);
			}
			break;
		case "astNodes.ReadOP":
			try {
				cBuilderReadOP(visitable);
			} catch (IOException  | FatalError e3) {
				e3.printStackTrace();	
				System.exit(0);
			}
			break;
		case "astNodes.WriteOP":
			try {
				cBuilderWriteOP(visitable);
			} catch (IOException | FatalError e3) {
				e3.printStackTrace();	
				System.exit(0);
			}
			break;
		case "astNodes.AssignOP":
			try {
				cBuilderAssignOP(visitable);
			} catch (IOException e3) {
				e3.printStackTrace();	
				System.exit(0);
			}
			break;
		case "astNodes.CallOP":
			try {
				cBuilderCallOP(visitable);
			} catch (IOException e3) {
				e3.printStackTrace();	
				System.exit(0);
			}
			break;
		case "astNodes.WhileOP":
			try {
				
				cBuilderWhileOP(visitable);
			} catch (IOException e3) {
				e3.printStackTrace();	
				System.exit(0);
			}
			break;
		case "astNodes.IfThenElseOp":
			try {
				cBuilderIfThenElseOp(visitable);
			} catch (IOException e3) {
				e3.printStackTrace();	
				System.exit(0);
			}
			break;
		case "astNodes.IfThenOp":
			try {
				cBuilderIfThenOp(visitable);
			} catch (IOException e3) {
				e3.printStackTrace();	
				System.exit(0);
			}
			break;
		case "astNodes.CompStatOP":
			try {
				cBuilderCompStatOP(visitable);
			} catch (IOException e3) {
				e3.printStackTrace();	
				System.exit(0);
			}
			break;
		case "astNodes.AddOP":
			try {
				cBuilderAddOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.DiffOP":
			try {
				cBuilderDiffOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.MulOP":
			try {
				cBuilderMulOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.DivOP":
			try {
				cBuilderDivOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.OrOP":
			try {
				cBuilderOrOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.AndOP":
			try {
				cBuilderAndOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.NotOP":
			try {
				cBuilderNotOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.UminusOP":
			try {
				cBuilderUminusOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.GtOP":
			try {
				cBuilderGtOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.GeOP":
			try {
				cBuilderGeOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.LtOP":
			try {
				cBuilderLtOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.LeOP":
			try {
				cBuilderLeOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.EqOP":
			try {
				cBuilderEqOP(visitable);
			} catch (IOException e2) {
				e2.printStackTrace();
				System.exit(0);
			}
			break;
		case "astNodes.Identifier":
			try {
				cBuilderIdentifier(visitable);
			} catch (IOException | FatalError e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.StringConst":
			try {
				cBuilderStringConst(visitable);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.CharConst":
			try {
				cBuilderCharConst(visitable);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);

			}

			break;
		case "astNodes.DoubleConst":
			try {
				cBuilderDoubleConst(visitable);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);

			}

			break;
		case "astNodes.IntConst":
			try {
				cBuilderIntConst(visitable);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);

			}

			break;
		case "astNodes.BooleanConst":
			try {
				cBuilderBooleanConst(visitable);
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(0);

			}

			break;

		default:
			System.out.println("FATAL ERROR:  CBuilder....." + className);
			break;
		}

	}

	/// start expr
	private void cBuilderStringConst(Visitable visitable) throws IOException {

		StringConst stringConst = (StringConst) visitable;
		outputC.write(stringConst.getStringConst());
	}

	private void cBuilderCharConst(Visitable visitable) throws IOException {
		CharConst charConst = (CharConst) visitable;
		outputC.write("'" + charConst.getCharConst() + "'");
	}

	private void cBuilderIntConst(Visitable visitable) throws IOException {
		IntConst intConst = (IntConst) visitable;
		outputC.write("" + intConst.getIntConst());

	}

	private void cBuilderBooleanConst(Visitable visitable) throws IOException {
		BooleanConst booleanConst = (BooleanConst) visitable;
		outputC.write("" + booleanConst.isBooleanConst());
	}

	private void cBuilderDoubleConst(Visitable visitable) throws IOException {
		DoubleConst doubleConst = (DoubleConst) visitable;
		outputC.write("" + doubleConst.getDoubleConst());
	}

	private void cBuilderIdentifier(Visitable visitable) throws IOException, FatalError {
		Identifier identifier = (Identifier) visitable;
		
		if(keyWord.contains(identifier.getNameId())){
			throw new FatalError("IMPOSSIBILE CONVERTIRE IN c.\n STAI UTILIZZANDO COME IDENTIFICATORE UNA PAROLA CHIAVE DEL LINGUAGGIO c");
		}
		else {
			System.out.println("nooooooooooooo"+identifier.getNameId());
		}
	
		if(identifier.getInOrOut().equals(TypeChecker.INOUT) || identifier.getInOrOut().equals(TypeChecker.OUT)) {
			outputC.write("*");
			//System.out.println("la stella ci vuole: "+identifier.getInOrOut());

		}
		outputC.write("" + identifier.getNameId());
	}

	private void cBuilderAddOP(Visitable visitable) throws IOException {
		AddOP expr = (AddOP) visitable;

		String type1 = expr.getExpr1().getNodeType();
		String type2 = expr.getExpr2().getNodeType();

		if (type1.equals(TypeChecker.STRING) && type2.equals(TypeChecker.STRING)) {
			outputC.write("concat(");
			expr.getExpr1().accept(this);
			outputC.write(" , ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		} else if (type1.equals(TypeChecker.INT) && type2.equals(TypeChecker.STRING)) {
			outputC.write("concat(IntToString(");
			expr.getExpr1().accept(this);
			outputC.write(")");
			outputC.write(" , ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		} else if (type1.equals(TypeChecker.DOUBLE) && type2.equals(TypeChecker.STRING)) {
			outputC.write("concat(DoubleToString(");
			expr.getExpr1().accept(this);
			outputC.write(")");
			outputC.write(" , ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		} else if (type1.equals(TypeChecker.CHAR) && type2.equals(TypeChecker.STRING)) {
			outputC.write("concat(CharToString(");
			expr.getExpr1().accept(this);
			outputC.write(")");
			outputC.write(" , ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		} else if (type1.equals(TypeChecker.STRING) && type2.equals(TypeChecker.INT)) {

			outputC.write("concat(");
			expr.getExpr1().accept(this);
			outputC.write(" ,IntToString( ");
			expr.getExpr2().accept(this);
			outputC.write("))");

		} else if (type1.equals(TypeChecker.STRING) && type2.equals(TypeChecker.DOUBLE)) {

			outputC.write("concat(");
			expr.getExpr1().accept(this);
			outputC.write(" ,DoubleToString( ");
			expr.getExpr2().accept(this);
			outputC.write("))");

		} else if (type1.equals(TypeChecker.STRING) && type2.equals(TypeChecker.CHAR)) {

			outputC.write("concat(");
			expr.getExpr1().accept(this);
			outputC.write(" ,CharToString( ");
			expr.getExpr2().accept(this);
			outputC.write("))");

		} else if (type1.equals(TypeChecker.CHAR) && type2.equals(TypeChecker.CHAR)) {
			outputC.write("concat(CharToString(");
			expr.getExpr1().accept(this);
			outputC.write(")");
			outputC.write(" ,CharToString( ");
			expr.getExpr2().accept(this);
			outputC.write("))");
		} else {
			outputC.write("(");
			expr.getExpr1().accept(this);
			outputC.write(" + ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		}

	}

	private void cBuilderDiffOP(Visitable visitable) throws IOException {
		DiffOP expr = (DiffOP) visitable;
		outputC.write("(");
		expr.getExpr1().accept(this);
		outputC.write(" - ");
		expr.getExpr2().accept(this);
		outputC.write(")");
	}

	private void cBuilderDivOP(Visitable visitable) throws IOException {
		DivOP expr = (DivOP) visitable;
		outputC.write("(");
		expr.getExpr1().accept(this);
		outputC.write(" / ");
		expr.getExpr2().accept(this);
		outputC.write(")");
	}

	private void cBuilderMulOP(Visitable visitable) throws IOException {
		MulOP expr = (MulOP) visitable;
		outputC.write("(");
		expr.getExpr1().accept(this);
		outputC.write(" * ");
		expr.getExpr2().accept(this);
		outputC.write(")");
	}

	private void cBuilderOrOP(Visitable visitable) throws IOException {
		OrOP expr = (OrOP) visitable;
		outputC.write("(");
		expr.getExpr1().accept(this);
		outputC.write(" || ");
		expr.getExpr2().accept(this);
		outputC.write(")");
	}

	private void cBuilderAndOP(Visitable visitable) throws IOException {
		AndOP expr = (AndOP) visitable;
		outputC.write("(");
		expr.getExpr1().accept(this);
		outputC.write(" && ");
		expr.getExpr2().accept(this);
		outputC.write(")");
	}

	private void cBuilderNotOP(Visitable visitable) throws IOException {
		NotOP expr = (NotOP) visitable;
		outputC.write("!(");
		expr.getExpr1().accept(this);
		outputC.write(")");
	}

	private void cBuilderUminusOP(Visitable visitable) throws IOException {
		UminusOP expr = (UminusOP) visitable;

		/*
		 * if (expr.getExpr1().getNodeType().equals(TypeChecker.STRING)) {
		 * outputC.write("strrev("); expr.getExpr1().accept(this);
		 * 
		 * } else {
		 */
		outputC.write("-(");
		expr.getExpr1().accept(this);
		// }
		outputC.write(")");

	}

	private void cBuilderGtOP(Visitable visitable) throws IOException {
		GtOP expr = (GtOP) visitable;

		if (expr.getExpr1().getNodeType().equals(TypeChecker.STRING)) {
			outputC.write("(strcmp(");
			expr.getExpr1().accept(this);
			outputC.write(",");
			expr.getExpr2().accept(this);
			outputC.write(")");
			outputC.write(">0)");
		} else {
			outputC.write("(");
			expr.getExpr1().accept(this);
			outputC.write(" > ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		}

	}

	private void cBuilderGeOP(Visitable visitable) throws IOException {
		GeOP expr = (GeOP) visitable;
		if (expr.getExpr1().getNodeType().equals(TypeChecker.STRING)) {
			outputC.write("(strcmp(");
			expr.getExpr1().accept(this);
			outputC.write(",");
			expr.getExpr2().accept(this);
			outputC.write(")");
			outputC.write(">0 || strcmp( ");
			expr.getExpr1().accept(this);
			outputC.write(",");
			expr.getExpr2().accept(this);
			outputC.write(")");
			outputC.write("==0)");

		} else {

			outputC.write("(");
			expr.getExpr1().accept(this);
			outputC.write(" >= ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		}
	}

	private void cBuilderLtOP(Visitable visitable) throws IOException {
		LtOP expr = (LtOP) visitable;

		if (expr.getExpr1().getNodeType().equals(TypeChecker.STRING)) {
			outputC.write("(strcmp(");
			expr.getExpr1().accept(this);
			outputC.write(",");
			expr.getExpr2().accept(this);
			outputC.write(")");
			outputC.write("<0)");
		} else {
			outputC.write("(");
			expr.getExpr1().accept(this);
			outputC.write(" < ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		}
	}

	private void cBuilderLeOP(Visitable visitable) throws IOException {
		LeOP expr = (LeOP) visitable;

		if (expr.getExpr1().getNodeType().equals(TypeChecker.STRING)) {
			outputC.write("(strcmp(");
			expr.getExpr1().accept(this);
			outputC.write(",");
			expr.getExpr2().accept(this);
			outputC.write(")");
			outputC.write("<0 || strcmp( ");
			expr.getExpr1().accept(this);
			outputC.write(",");
			expr.getExpr2().accept(this);
			outputC.write(")");
			outputC.write("==0)");

		} else {

			outputC.write("(");
			expr.getExpr1().accept(this);
			outputC.write(" <= ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		}

	}

	private void cBuilderEqOP(Visitable visitable) throws IOException {
		EqOP expr = (EqOP) visitable;

		if (expr.getExpr1().getNodeType().equals(TypeChecker.STRING)) {
			outputC.write("(strcmp(");
			expr.getExpr1().accept(this);
			outputC.write(",");
			expr.getExpr2().accept(this);
			outputC.write(")");
			outputC.write("==0)");
		} else {
			outputC.write("(");
			expr.getExpr1().accept(this);
			outputC.write(" == ");
			expr.getExpr2().accept(this);
			outputC.write(")");
		}
	}

	/// end expr

	/// start statment

	private void cBuilderWriteOP(Visitable visitable) throws IOException, FatalError {
		WriteOP writeOP = (WriteOP) visitable;
		for (Expr e : writeOP.getExprs()) {

			String type = e.getNodeType();
			
			if (type.equals(TypeChecker.STRING)) {
				outputC.write("printf(\"%s \\n\",");
				e.accept(this);

			} else if (type.equals(TypeChecker.CHAR)) {
				outputC.write("printf(\"%c\\n\",");
				e.accept(this);

			} else if (type.equals(TypeChecker.INT)) {
				outputC.write("printf(\"%d\\n\",");
				e.accept(this);

			} else if (type.equals(TypeChecker.DOUBLE)) {
				outputC.write("printf(\"%lf\\n\",");
				e.accept(this);

			} else if (type.equals(TypeChecker.BOOLE)) {
				outputC.write("printf(\"%s\\n\",");
				e.accept(this);
				outputC.write("? \"true\\n\" : \"false\\n\"");
			}else{
				throw new FatalError("Tipo non riconosciuto: "+ type);
			}
			outputC.write(");\n");

		}

	}

	private void cBuilderReadOP(Visitable visitable) throws IOException, FatalError {
		ReadOP readOP = (ReadOP) visitable;

		for (Identifier s : readOP.getIdentifiers()) {			
			String type = s.getType();
			
			if (type.equals(TypeChecker.STRING)) {
				outputC.write("scanf(\"\\n%s\", "+s.getNameId()+");");

			} else if (type.equals(TypeChecker.CHAR)) {
				outputC.write("scanf(\"\\n%c\", &"+s.getNameId()+");");

			} else if (type.equals(TypeChecker.INT)) {
				outputC.write("scanf(\"\\n%d\", &"+s.getNameId()+");");				

			} else if (type.equals(TypeChecker.DOUBLE)) {
				outputC.write("scanf(\"\\n%lf\", &"+s.getNameId()+");");

			} else{
				throw new FatalError("Impossibile leggere un"+ type +"da tastiera");
			}
		}
	}

	private void cBuilderCallOP(Visitable visitable) throws IOException {
		CallOP callOP = (CallOP) visitable;
		
		outputC.write(callOP.getId().getNameId()+"(");
		//outputC.close();

		Identifier id =callOP.getId();
		
		//id.getParamTypeFunction().getClass().get(i);
		
		int i =0;
		
		for (Expr e : callOP.getArguments()) {
			
			//if(!id.getParamTypeFunction().get(i).getVariableType().equals(TypeChecker.STRING)) {
			if(id.getParamTypeFunction().get(i).getReturnType().equals(TypeChecker.INOUT) || id.getParamTypeFunction().get(i).getReturnType().equals(TypeChecker.OUT)) {
				outputC.write("&");

				}
			//}
			e.accept(this);
			
			if (callOP.getArguments().size() - 1 > i) {
				outputC.write(",");
			}
			

			i++;
		}
		outputC.write(");\n");
		
	}

	private void cBuilderAssignOP(Visitable visitable) throws IOException {
		AssignOP assignOP = (AssignOP) visitable;

		Identifier identifier = assignOP.getId();
		outputC.write("( ");

		
		if(identifier.getInOrOut().equals(TypeChecker.INOUT) || identifier.getInOrOut().equals(TypeChecker.OUT)) {
			outputC.write("*");
		}
		
		outputC.write(identifier.getNameId() + "= ");
		assignOP.getExpr().accept(this);
		outputC.write(");\n");

		// outputC.write(";");
	}

	private void cBuilderWhileOP(Visitable visitable) throws IOException {
		WhileOP whileOP = (WhileOP) visitable;

		outputC.write("while(");
		whileOP.getExpr().accept(this);
		outputC.write("){\n");
		whileOP.getStatment().accept(this);
		outputC.write("\n}\n\n");

	}

	private void cBuilderIfThenElseOp(Visitable visitable) throws IOException {
		IfThenElseOp ifThenElseOp = (IfThenElseOp) visitable;

		outputC.write("if(");
		ifThenElseOp.getExpr().accept(this);
		outputC.write("){\n");
		ifThenElseOp.getTureStatments().accept(this);
		outputC.write("\n}else{\n");
		ifThenElseOp.getFalseStatments().accept(this);
		outputC.write("\n}\n\n");
	}

	private void cBuilderIfThenOp(Visitable visitable) throws IOException {
		IfThenOp ifThenOp = (IfThenOp) visitable;
		outputC.write("if(");
		ifThenOp.getExpr().accept(this);
		outputC.write("){\n");
		ifThenOp.getStatment().accept(this);
		outputC.write("\n}\n\n");

	}

	private void cBuilderCompStatOP(Visitable visitable) throws IOException {
		CompStatOP compStatOP = (CompStatOP) visitable;

		for (Statment s : compStatOP.getStatments()) {
			s.accept(this);
			outputC.write("\n");

		}
	}

	/// end statment

	private void cBuilderBodyOP(Visitable visitable) throws IOException {

		BodyOP bodyOP = (BodyOP) visitable;

		for (VarDecelOP varDecel : bodyOP.getDecs()) {
			varDecel.accept(this);
			outputC.write("\n");
		}
		for (Statment s : bodyOP.getStatments()) {
			s.accept(this);
			outputC.write("\n");

		}

	}

	private void cBuilderParOP(Visitable visitable) throws IOException {

		ParOP parOP = (ParOP) visitable;
		
		

		if( parOP.getType().equals(TypeChecker.STRING)) {
			outputC.write("char *");
		}else {
			
			outputC.write(" " + parOP.getType()+" ");
		}
		
		if(parOP.getReturnType().equals(TypeChecker.INOUT) || parOP.getReturnType().equals(TypeChecker.OUT) /*&& !(parOP.getType().equals(TypeChecker.STRING))*/ ) {
			outputC.write("*");
			}
		
		outputC.write(parOP.getId().getNameId());

	}

	private void cBuilderProcDecelOP(Visitable visitable) throws IOException {

		ProcDecelOP procDecelOP = (ProcDecelOP) visitable;
		int i = 0;

		outputC.write("\n void " + procDecelOP.getId().getNameId() + "(");
		for (ParOP param : procDecelOP.getPars()) {
		
			param.accept(this);



			if (procDecelOP.getPars().size() - 1 > i) {
				outputC.write(",");
			}

			i++;
		}

		outputC.write("){\n");
		procDecelOP.getBody().accept(this);
		outputC.write("}\n");

	}

	private void cBuilderVarInitOP(Visitable visitable) throws IOException, FatalError {

		VarInitOP varInitOP = (VarInitOP) visitable;

		if(keyWord.contains(varInitOP.getId().getNameId())){
			throw new FatalError("IMPOSSIBILE CONVERTIRE IN c.\n STAI UTILIZZANDO COME IDENTIFICATORE UNA PAROLA CHIAVE DEL LINGUAGGIO c");
		}
		else {
			System.out.println("nooooooooooooo"+varInitOP.getId().getNameId());
		}
		
		outputC.write(varInitOP.getId().getNameId());

		if (varInitOP.getExp() != null) {
			outputC.write("= ");
			varInitOP.getExp().accept(this);
		}

	}

	private void cBuilderVarDecelOP(Visitable visitable) throws IOException {
		VarDecelOP varDecelOP = (VarDecelOP) visitable;
		int i = 0;

		if (varDecelOP.getType().equals(TypeChecker.STRING))
			outputC.write("char " + "*");
		else
			outputC.write(varDecelOP.getType() + " ");

		for (VarInitOP vars : varDecelOP.getVarInit()) {

			vars.accept(this);
			if (varDecelOP.getVarInit().size() - 1 > i)
				outputC.write(",");

			i++;
		}
		outputC.write(";\n");
		varDecelOP.setNodeType(TypeChecker.VOID);
	}

	private void cBuilderProgramOP(Visitable visitable) throws IOException {
		ProgramOP prog = (ProgramOP) visitable;
		
		outputC.write("#include<stdio.h>\n");
		outputC.write("#include<stdlib.h>\n");
		outputC.write("#include<string.h>\n");
		outputC.write("#include<stdbool.h>\n\n");

		///*
		outputC.write(STRING_CONCAT);
		outputC.write(INT_TO_STRING);
		outputC.write(CHAR_TO_STRING);
		outputC.write(DOUBLE_TO_STRING);
		//*/

		for (Decls d : prog.getDecs()) {

			if (d instanceof VarDecelOP) {
				((VarDecelOP) d).accept(this);
			}

			else if (d instanceof ProcDecelOP) {
				((ProcDecelOP) d).accept(this);
			}

			else {
				System.out.println("++++++Errore Non Previsto: SemanticVisitor-semanticProgramOP+++++++");

			}
		}
		
		outputC.write("\nint main(void) { \n\n\n" + "");

		
		 for (Statment s : prog.getStatments()) {	
			// outputC.write("\n\n}");
			 s.accept(this);		 
		 }
		


		outputC.write("\n\nreturn 0; \n}");

		outputC.close();
		System.out.println("Outpu C creato!\n");


	}

}
