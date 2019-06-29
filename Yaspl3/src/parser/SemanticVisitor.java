package parser;

import java.util.ArrayList;
import java.util.Stack;

import astNodes.*;
import exception.MultipleDeclaretionException;
import exception.NotDeclaretionException;
import exception.ParameterError;
import exception.TypeMismatchException;
import lexical.SymbolTable;

public class SemanticVisitor implements Visitor {

	private Stack<SymbolTable> stack;

	public SemanticVisitor() {
		stack = new Stack<SymbolTable>();

	}

	@Override
	public void visit(Visitable visitable) {

		String className = visitable.getClass().getName();
		//System.out.println("class name " + className);

		switch (className) {
		case "astNodes.ProgramOP":
			semanticProgramOP(visitable);
			break;
		case "astNodes.VarDecelOP":
			try {
				semanticVarDecelOP(visitable);
			} catch (MultipleDeclaretionException e) {
				e.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.VarInitOP":
			try {
				semanticVarInitOP(visitable);
			} catch (NotDeclaretionException | TypeMismatchException e2) {
				e2.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.ProcDecelOP":
			try {
				semanticProcDecelOP(visitable);
			} catch (MultipleDeclaretionException e) {
				e.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.ParOP":
			try {
				semanticParOP(visitable);
			} catch (MultipleDeclaretionException e) {
				e.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.BodyOP":
			semanticBodyOP(visitable);
			break;
		case "astNodes.AssignOP":
			try {
				semanticAssignOP(visitable);
			} catch (NotDeclaretionException | TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.WriteOP":
			semanticWriteOP(visitable);
			break;
		case "astNodes.ReadOP":
			try {
				semanticReadOP(visitable);
			} catch (NotDeclaretionException | TypeMismatchException e5) {
				e5.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.CallOP":
			try {
				semanticCallOP(visitable);
			} catch (NotDeclaretionException | ParameterError | TypeMismatchException e4) {
				e4.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.WhileOP":
			try {
				semanticWhileOP(visitable);
			} catch (TypeMismatchException e3) {
				e3.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.IfThenElseOp":
			try {
				semanticIfThenElseOp(visitable);
			} catch (TypeMismatchException e3) {
				e3.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.IfThenOp":
			try {
				semanticIfThenOp(visitable);
			} catch (TypeMismatchException e3) {
				e3.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.CompStatOP":
			semanticCompStatOP(visitable);
			break;
		case "astNodes.AddOP":
			try {
				semanticAddOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.DiffOP":
			try {
				semanticDiffOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.MulOP":
			try {
				semanticMulOP(visitable);
			} catch (TypeMismatchException e2) {
				e2.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.DivOP":
			try {
				semanticDivOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.OrOP":
			try {
				semanticOrOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.AndOP":
			try {
				semanticAndOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.NotOP":
			try {
				semanticNotOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.UminusOP":
			try {
				semanticUminusOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.GtOP":
			try {
				semanticGtOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.GeOP":
			try {
				semanticGeOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.LtOP":
			try {
				semanticLtOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.LeOP":
			try {
				semanticLeOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.EqOP":
			try {
				semanticEqOP(visitable);
			} catch (TypeMismatchException e1) {
				e1.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.Identifier":
			try {
				semanticIdentifier(visitable);
			} catch (NotDeclaretionException e) {
				e.printStackTrace();
				System.exit(0);

			}
			break;
		case "astNodes.StringConst":
			semanticStringConst(visitable);
			break;
		case "astNodes.CharConst":
			semanticCharConst(visitable);
			break;
		case "astNodes.DoubleConst":
			semanticDoubleConst(visitable);
			break;
		case "astNodes.IntConst":
			semanticIntConst(visitable);
			break;
		case "astNodes.BooleanConst":
			semanticBooleanConst(visitable);
			break;

		default:
			System.out.println("default error: class name " + className);
			break;
		}

	}

	/// start expr
	private void semanticStringConst(Visitable visitable) {
		StringConst stringConst = (StringConst) visitable;
		stringConst.setNodeType(TypeChecker.STRING);
	}

	private void semanticCharConst(Visitable visitable) {
		CharConst charConst = (CharConst) visitable;
		charConst.setNodeType(TypeChecker.CHAR);
	}

	private void semanticIntConst(Visitable visitable) {
		IntConst intConst = (IntConst) visitable;
		intConst.setNodeType(TypeChecker.INT);
	}

	private void semanticBooleanConst(Visitable visitable) {
		BooleanConst booleanConst = (BooleanConst) visitable;
		booleanConst.setNodeType(TypeChecker.BOOLE);
	}

	private void semanticDoubleConst(Visitable visitable) {
		DoubleConst doubleConst = (DoubleConst) visitable;
		doubleConst.setNodeType(TypeChecker.DOUBLE);
	}

	
	private void semanticAddOP(Visitable visitable) throws TypeMismatchException {
		AddOP expr = (AddOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.AddOP, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticDiffOP(Visitable visitable) throws TypeMismatchException {
		DiffOP expr = (DiffOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.DiffOp, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticDivOP(Visitable visitable) throws TypeMismatchException {
		DivOP expr = (DivOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.DivOp, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticMulOP(Visitable visitable) throws TypeMismatchException {
		MulOP expr = (MulOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.MulOP, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticOrOP(Visitable visitable) throws TypeMismatchException {
		OrOP expr = (OrOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.OrOP, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticAndOP(Visitable visitable) throws TypeMismatchException {
		AndOP expr = (AndOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.AndOp, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticNotOP(Visitable visitable) throws TypeMismatchException {
		NotOP expr = (NotOP) visitable;
		expr.getExpr1().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.NotOP, expr.getExpr1().getNodeType());

		expr.setNodeType(resultType);

	}

	private void semanticUminusOP(Visitable visitable) throws TypeMismatchException {
		UminusOP expr = (UminusOP) visitable;
		expr.getExpr1().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.UminusOP, expr.getExpr1().getNodeType());

		expr.setNodeType(resultType);

	}

	private void semanticGtOP(Visitable visitable) throws TypeMismatchException {
		GtOP expr = (GtOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.RelOp, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticGeOP(Visitable visitable) throws TypeMismatchException {
		GeOP expr = (GeOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.RelOp, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticLtOP(Visitable visitable) throws TypeMismatchException {
		LtOP expr = (LtOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.RelOp, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticLeOP(Visitable visitable) throws TypeMismatchException {
		LeOP expr = (LeOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.RelOp, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticEqOP(Visitable visitable) throws TypeMismatchException {
		EqOP expr = (EqOP) visitable;
		expr.getExpr1().accept(this);
		expr.getExpr2().accept(this);
		String resultType = TypeChecker.typeCheck(TypeChecker.EqOp, expr.getExpr1().getNodeType(),
				expr.getExpr2().getNodeType());

		expr.setNodeType(resultType);
	}

	private void semanticIdentifier(Visitable visitable) throws NotDeclaretionException {
		Identifier identifier = (Identifier) visitable;
		
		//System.out.println(".....INTO IDENTIFEIR: "+identifier);
		
		Identifier resultId = findInStackTables(identifier.getNameId());
		identifier.setInOrOut(resultId.getInOrOut());
		//System.out.println(identifier.getNameId()+"/////"+resultId.getNameId()+"//////settetd: "+resultId.getInOrOut());
		identifier.setNodeType(resultId.getType());

	}
	/// end expr

	/// start statment
	private void semanticWriteOP(Visitable visitable) {
		WriteOP writeOP = (WriteOP) visitable;

		for (Expr e : writeOP.getExprs()) {
			e.accept(this);
		}
		writeOP.setNodeType(TypeChecker.VOID);
	}

	private void semanticReadOP(Visitable visitable) throws NotDeclaretionException, TypeMismatchException {
		
		ReadOP readOP = (ReadOP) visitable;
		ArrayList<Identifier> ids = readOP.getIdentifier();

		for (Identifier s : ids) {
			Identifier id = findInStackTables(s.getNameId());
			TypeChecker.typeCheck(TypeChecker.ReadOP,id.getType());
			s.setType(id.getType());
			s.setInOrOut(id.getInOrOut());
			//readOP.addIdentifier(id);
		}

		readOP.setNodeType(TypeChecker.VOID);

	}

	private void semanticCallOP(Visitable visitable)
			throws NotDeclaretionException, ParameterError, TypeMismatchException {

		CallOP callOP = (CallOP) visitable;
		Identifier functionName = findInStackTables(callOP.getId().getNameId());
		callOP.setId(functionName);

		ArrayList<Expr> arguments = callOP.getArguments();
		ArrayList<ParamCallFunction> typeOfRequestParam = functionName.getParamTypeFunction();

		for (Expr e : arguments) {
			e.accept(this);
			e.getNodeType();
		}

		if (functionName.isFunction()) {

			//boolean mayBeTrue = typeOfRequestParam.size() == arguments.size();

			if (typeOfRequestParam.size() == arguments.size()) {
				for (int i = 0; i < functionName.getParamTypeFunction().size(); i++) {
		
					if(typeOfRequestParam.get(i).getReturnType().equals(TypeChecker.INOUT) || typeOfRequestParam.get(i).getReturnType().equals(TypeChecker.OUT)) {

						if(!(arguments.get(i) instanceof Identifier)) {
							throw new TypeMismatchException("I parametri OUT e INOUT, devono essere identificatori");
						}
					}					
					TypeChecker.typeCheck(TypeChecker.CallOP, arguments.get(i).getNodeType(),
							typeOfRequestParam.get(i).getVariableType());
					}
			} else {
				System.out.println("Errore Non Previsto: il numero dei parametri non coincide :(");
			}
		} else {
			throw new NotDeclaretionException("\n......NON DOVEVA CAPITARE.....questa non sembrerebbe una funzione\n");
		}

		callOP.setNodeType(TypeChecker.VOID);

	}

	private void semanticAssignOP(Visitable visitable) throws NotDeclaretionException, TypeMismatchException {
		AssignOP assignOP = (AssignOP) visitable;		
		assignOP.setId(findInStackTables(assignOP.getId().getNameId()));
		assignOP.getExpr().accept(this);
		
		TypeChecker.typeCheck(TypeChecker.AssignOP, assignOP.getId().getType(), assignOP.getExpr().getNodeType());
		
	}

	private void semanticWhileOP(Visitable visitable) throws TypeMismatchException {
		WhileOP whileOP = (WhileOP) visitable;
		whileOP.getExpr().accept(this);
		TypeChecker.typeCheck(TypeChecker.Conditionl, whileOP.getExpr().getNodeType());
		whileOP.getStatment().accept(this);

		whileOP.setNodeType(TypeChecker.VOID);

	}

	private void semanticIfThenElseOp(Visitable visitable) throws TypeMismatchException {
		IfThenElseOp ifThenElseOp = (IfThenElseOp) visitable;
		ifThenElseOp.getExpr().accept(this);
		
		TypeChecker.typeCheck(TypeChecker.Conditionl, ifThenElseOp.getExpr().getNodeType());

		ifThenElseOp.getTureStatments().accept(this);
		ifThenElseOp.getFalseStatments().accept(this);

		ifThenElseOp.setNodeType(TypeChecker.VOID);
	}

	private void semanticIfThenOp(Visitable visitable) throws TypeMismatchException {
		IfThenOp ifThenOp = (IfThenOp) visitable;
		ifThenOp.getExpr().accept(this);
		TypeChecker.typeCheck(TypeChecker.Conditionl, ifThenOp.getExpr().getNodeType());
		ifThenOp.getStatment().accept(this);

		ifThenOp.setNodeType(TypeChecker.VOID);

	}

	private void semanticCompStatOP(Visitable visitable) {
		CompStatOP compStatOP = (CompStatOP) visitable;

		for (Statment s : compStatOP.getStatments()) {
			s.accept(this);
		}

		compStatOP.setNodeType(TypeChecker.VOID);

	}

	/// end statment

	private void semanticBodyOP(Visitable visitable) {
		BodyOP bodyOP = (BodyOP) visitable;

		for (VarDecelOP varDecel : bodyOP.getDecs()) {
			varDecel.accept(this);
		}
		for (Statment s : bodyOP.getStatments()) {
			s.accept(this);
		}

	}

	private void semanticParOP(Visitable visitable) throws MultipleDeclaretionException {

		ParOP parOP = (ParOP) visitable;
		
		parOP.getId().setInOrOut(parOP.getReturnType());
		parOP.getId().setType(parOP.getType());
		
		stack.peek().installID(parOP.getId());
		parOP.setNodeType(TypeChecker.VOID);
	}

	private void semanticProcDecelOP(Visitable visitable) throws MultipleDeclaretionException {

		ProcDecelOP procDecelOP = (ProcDecelOP) visitable;
		SymbolTable symTable = new SymbolTable("ProcDecelOP");
		int numOfParam = procDecelOP.getPars().size();

		procDecelOP.getId().setType(TypeChecker.FUNCTION);
		procDecelOP.getId().setInOrOut(""+numOfParam);
		
		Identifier newProc = procDecelOP.getId();

		stack.peek().installID(newProc);

		stack.push(symTable);

		stack.peek().installID(newProc);

		for (ParOP param : procDecelOP.getPars()) {
			// stack.peek().installID(new
			// Identifier(vars.getId(),null,varDecelOP.getType()));			
			newProc.addParamTypeFunction(new ParamCallFunction(param.getReturnType(),param.getType()));
			param.accept(this);
		}

		procDecelOP.getBody().accept(this);

		//System.out.println("tolgo la tabella dallo stack-----------");

		procDecelOP.setSymTable(stack.pop());
		procDecelOP.setNodeType(TypeChecker.VOID);

	}

	private void semanticVarInitOP(Visitable visitable) throws NotDeclaretionException, TypeMismatchException {

		VarInitOP varInitOP = (VarInitOP) visitable;
		Identifier localID = findInStackTables(varInitOP.getId().getNameId());
		varInitOP.setId(localID);

		if (varInitOP.getExp() != null) {
			// System.out.println(""+localID.getType());
			varInitOP.getExp().accept(this);
			TypeChecker.typeCheck(TypeChecker.AssignOP, localID.getType(), varInitOP.getExp().getNodeType());
		}
		varInitOP.setNodeType(TypeChecker.VOID);

	}

	private void semanticVarDecelOP(Visitable visitable) throws MultipleDeclaretionException {

		VarDecelOP varDecelOP = (VarDecelOP) visitable;
		for (VarInitOP vars : varDecelOP.getVarInit()) {
			vars.getId().setType(varDecelOP.getType());
			stack.peek().installID(vars.getId());
			vars.getId();
			vars.accept(this);
		}

		varDecelOP.setNodeType(TypeChecker.VOID);
	}

	private void semanticProgramOP(Visitable visitable) {

		ProgramOP prog = (ProgramOP) visitable;
		SymbolTable symTable = new SymbolTable("ProgramOP");
		// prog.setSymTable(symTable);
		stack.push(symTable);

		for (Decls d : prog.getDecs()) {

			if (d instanceof VarDecelOP) {
				((VarDecelOP) d).accept(this);
			}

			else if (d instanceof ProcDecelOP) {
				((ProcDecelOP) d).accept(this);

			} else {
				System.out.println("Errore Non Previsto: SemanticVisitor-semanticProgramOP");

			}
		}

		for (Statment s : prog.getStatments()) {

			s.accept(this);

		}

		prog.setSymTable(stack.pop());
		prog.setNodeType(TypeChecker.VOID);
		System.out.println("Analisi semantica conclusa!");
	}

	private Identifier findInStackTables(String id) throws NotDeclaretionException {

		//System.out.println("number of symbol table: " + stack.size());

		for (int i = 0; i < stack.size(); i++) {
			//System.out.println("symbol table nello stack......");
			//System.out.println(stack.get(i).getName());
		}

		SymbolTable temp = stack.get(stack.size() - 1);

		if (temp.containsKey(id)) {
			return temp.get(id);
		} else {
			if (stack.size() != 0) {
				SymbolTable tempProgOP = stack.get(0);

				if (tempProgOP.containsKey(id)) {
					return tempProgOP.get(id);
				} else {
					throw new NotDeclaretionException("" + id + " (neanche nello scoop padre) ");
				} // fine blocco3
			} else {
				throw new NotDeclaretionException("" + id);
			} // fine blocco 2
		} // fine blocco 1
	}

}
