// generated with ast extension for cup
// version 0.8
// 12/7/2022 17:49:35


package rs.ac.bg.etf.pp1.ast;

public interface Visitor { 

    public void visit(Mulop Mulop);
    public void visit(RecordDecList RecordDecList);
    public void visit(ConstructorDecl ConstructorDecl);
    public void visit(Relop Relop);
    public void visit(Var Var);
    public void visit(Else Else);
    public void visit(StatementList StatementList);
    public void visit(MethodDecList MethodDecList);
    public void visit(Addop Addop);
    public void visit(Factor Factor);
    public void visit(CondTerm CondTerm);
    public void visit(VarList VarList);
    public void visit(ConstList ConstList);
    public void visit(Designator Designator);
    public void visit(Term Term);
    public void visit(Condition Condition);
    public void visit(MethodPart MethodPart);
    public void visit(Printable Printable);
    public void visit(Statements Statements);
    public void visit(Label Label);
    public void visit(DesignatorName DesignatorName);
    public void visit(VarDecList VarDecList);
    public void visit(OptionalVarDecList OptionalVarDecList);
    public void visit(Expr Expr);
    public void visit(CoalExpr CoalExpr);
    public void visit(ActPars ActPars);
    public void visit(DesignatorStatement DesignatorStatement);
    public void visit(Const Const);
    public void visit(Operations Operations);
    public void visit(FormParamList FormParamList);
    public void visit(Statement Statement);
    public void visit(Expression Expression);
    public void visit(Type Type);
    public void visit(BaseExp BaseExp);
    public void visit(ClassDecList ClassDecList);
    public void visit(CondFact CondFact);
    public void visit(Declaration Declaration);
    public void visit(Param Param);
    public void visit(SingleStatement SingleStatement);
    public void visit(Field Field);
    public void visit(FieldList FieldList);
    public void visit(ConstDecList ConstDecList);
    public void visit(FormPars FormPars);
    public void visit(Mod Mod);
    public void visit(Div Div);
    public void visit(Mul Mul);
    public void visit(Minus Minus);
    public void visit(Plus Plus);
    public void visit(LowerEqual LowerEqual);
    public void visit(Lower Lower);
    public void visit(GreaterEqual GreaterEqual);
    public void visit(Greater Greater);
    public void visit(NoEqual NoEqual);
    public void visit(Equal Equal);
    public void visit(VoidType VoidType);
    public void visit(IdentType IdentType);
    public void visit(Labels Labels);
    public void visit(Coalesce Coalesce);
    public void visit(FactorExpr FactorExpr);
    public void visit(New New);
    public void visit(NewExpr NewExpr);
    public void visit(BooleanConst BooleanConst);
    public void visit(CharacterConst CharacterConst);
    public void visit(NumberConst NumberConst);
    public void visit(VarDesig VarDesig);
    public void visit(FuncCall FuncCall);
    public void visit(SingleFactor SingleFactor);
    public void visit(ListFactor ListFactor);
    public void visit(SingleTerm SingleTerm);
    public void visit(Terms Terms);
    public void visit(TermExpr TermExpr);
    public void visit(AddExpr AddExpr);
    public void visit(Express Express);
    public void visit(MinusExpress MinusExpress);
    public void visit(SingleCondFact SingleCondFact);
    public void visit(CondFactor CondFactor);
    public void visit(SingleCondTerm SingleCondTerm);
    public void visit(CondiTerm CondiTerm);
    public void visit(SignleCondition SignleCondition);
    public void visit(Conditions Conditions);
    public void visit(NoActPars NoActPars);
    public void visit(SingleActPars SingleActPars);
    public void visit(ActParams ActParams);
    public void visit(Dec Dec);
    public void visit(Inc Inc);
    public void visit(ActParameters ActParameters);
    public void visit(AssignOperation AssignOperation);
    public void visit(FieldBox FieldBox);
    public void visit(FieldNoBox FieldNoBox);
    public void visit(SingleField SingleField);
    public void visit(Fields Fields);
    public void visit(DesigName DesigName);
    public void visit(SingleDesig SingleDesig);
    public void visit(DesigList DesigList);
    public void visit(DesignatorStatementOp DesignatorStatementOp);
    public void visit(StatementsBraces StatementsBraces);
    public void visit(NoElse NoElse);
    public void visit(ElseStatement ElseStatement);
    public void visit(NoPrintable NoPrintable);
    public void visit(Prints Prints);
    public void visit(SingleStatementDerived1 SingleStatementDerived1);
    public void visit(PrintStatement PrintStatement);
    public void visit(ReadStatement ReadStatement);
    public void visit(VoidReturn VoidReturn);
    public void visit(ReturnExprStatement ReturnExprStatement);
    public void visit(ContinueStatement ContinueStatement);
    public void visit(BreakStatement BreakStatement);
    public void visit(DoWhileStatement DoWhileStatement);
    public void visit(IfStatement IfStatement);
    public void visit(DesignatorStat DesignatorStat);
    public void visit(Stats Stats);
    public void visit(SingleStat SingleStat);
    public void visit(LabelStatement LabelStatement);
    public void visit(NoStatement NoStatement);
    public void visit(ListOfStatements ListOfStatements);
    public void visit(ParamBox ParamBox);
    public void visit(Parameter Parameter);
    public void visit(SingleParam SingleParam);
    public void visit(FormParams FormParams);
    public void visit(NoParams NoParams);
    public void visit(ParamList ParamList);
    public void visit(NoMethodVarDecList NoMethodVarDecList);
    public void visit(HasVarDecList HasVarDecList);
    public void visit(MethodTypeName MethodTypeName);
    public void visit(Method Method);
    public void visit(SingleMethodDeclaration SingleMethodDeclaration);
    public void visit(MethodDeclerations MethodDeclerations);
    public void visit(RecordName RecordName);
    public void visit(RecordDecleration RecordDecleration);
    public void visit(ConstructorDecleration ConstructorDecleration);
    public void visit(NoMethodPart NoMethodPart);
    public void visit(Methods Methods);
    public void visit(ConstructorAndMethod ConstructorAndMethod);
    public void visit(ClassDeclarations ClassDeclarations);
    public void visit(ClassExtendsDeclerations ClassExtendsDeclerations);
    public void visit(VarArray VarArray);
    public void visit(VarNoArray VarNoArray);
    public void visit(SingleVar SingleVar);
    public void visit(VariableList VariableList);
    public void visit(VarDecListDerived1 VarDecListDerived1);
    public void visit(VarDeclerations VarDeclerations);
    public void visit(BoolConstant BoolConstant);
    public void visit(CharConstant CharConstant);
    public void visit(NumConstant NumConstant);
    public void visit(OneConstant OneConstant);
    public void visit(ConstantList ConstantList);
    public void visit(ConstDeclerations ConstDeclerations);
    public void visit(NoDeclaration NoDeclaration);
    public void visit(RecordDecLarationList RecordDecLarationList);
    public void visit(ClassDeclarationList ClassDeclarationList);
    public void visit(VarDeclarationList VarDeclarationList);
    public void visit(ConstDeclarationList ConstDeclarationList);
    public void visit(ProgName ProgName);
    public void visit(Program Program);

}
