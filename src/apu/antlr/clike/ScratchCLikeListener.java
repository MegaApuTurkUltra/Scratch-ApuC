// Generated from ScratchCLike.g4 by ANTLR 4.4

  package apu.antlr.clike;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScratchCLikeParser}.
 */
public interface ScratchCLikeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#arrayCreate}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreate(@NotNull ScratchCLikeParser.ArrayCreateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#arrayCreate}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreate(@NotNull ScratchCLikeParser.ArrayCreateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull ScratchCLikeParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull ScratchCLikeParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void enterIfElse(@NotNull ScratchCLikeParser.IfElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#ifElse}.
	 * @param ctx the parse tree
	 */
	void exitIfElse(@NotNull ScratchCLikeParser.IfElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#braces}.
	 * @param ctx the parse tree
	 */
	void enterBraces(@NotNull ScratchCLikeParser.BracesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#braces}.
	 * @param ctx the parse tree
	 */
	void exitBraces(@NotNull ScratchCLikeParser.BracesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(@NotNull ScratchCLikeParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(@NotNull ScratchCLikeParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#mathExp}.
	 * @param ctx the parse tree
	 */
	void enterMathExp(@NotNull ScratchCLikeParser.MathExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#mathExp}.
	 * @param ctx the parse tree
	 */
	void exitMathExp(@NotNull ScratchCLikeParser.MathExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(@NotNull ScratchCLikeParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(@NotNull ScratchCLikeParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(@NotNull ScratchCLikeParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(@NotNull ScratchCLikeParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#paramsDef}.
	 * @param ctx the parse tree
	 */
	void enterParamsDef(@NotNull ScratchCLikeParser.ParamsDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#paramsDef}.
	 * @param ctx the parse tree
	 */
	void exitParamsDef(@NotNull ScratchCLikeParser.ParamsDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#whenDef}.
	 * @param ctx the parse tree
	 */
	void enterWhenDef(@NotNull ScratchCLikeParser.WhenDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#whenDef}.
	 * @param ctx the parse tree
	 */
	void exitWhenDef(@NotNull ScratchCLikeParser.WhenDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#varExp}.
	 * @param ctx the parse tree
	 */
	void enterVarExp(@NotNull ScratchCLikeParser.VarExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#varExp}.
	 * @param ctx the parse tree
	 */
	void exitVarExp(@NotNull ScratchCLikeParser.VarExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#conditionAndOr}.
	 * @param ctx the parse tree
	 */
	void enterConditionAndOr(@NotNull ScratchCLikeParser.ConditionAndOrContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#conditionAndOr}.
	 * @param ctx the parse tree
	 */
	void exitConditionAndOr(@NotNull ScratchCLikeParser.ConditionAndOrContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#arrayDef}.
	 * @param ctx the parse tree
	 */
	void enterArrayDef(@NotNull ScratchCLikeParser.ArrayDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#arrayDef}.
	 * @param ctx the parse tree
	 */
	void exitArrayDef(@NotNull ScratchCLikeParser.ArrayDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#conditionItem}.
	 * @param ctx the parse tree
	 */
	void enterConditionItem(@NotNull ScratchCLikeParser.ConditionItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#conditionItem}.
	 * @param ctx the parse tree
	 */
	void exitConditionItem(@NotNull ScratchCLikeParser.ConditionItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(@NotNull ScratchCLikeParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#forLoop}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(@NotNull ScratchCLikeParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#repeatSingleFrameLoop}.
	 * @param ctx the parse tree
	 */
	void enterRepeatSingleFrameLoop(@NotNull ScratchCLikeParser.RepeatSingleFrameLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#repeatSingleFrameLoop}.
	 * @param ctx the parse tree
	 */
	void exitRepeatSingleFrameLoop(@NotNull ScratchCLikeParser.RepeatSingleFrameLoopContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#mathAdditionExp}.
	 * @param ctx the parse tree
	 */
	void enterMathAdditionExp(@NotNull ScratchCLikeParser.MathAdditionExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#mathAdditionExp}.
	 * @param ctx the parse tree
	 */
	void exitMathAdditionExp(@NotNull ScratchCLikeParser.MathAdditionExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull ScratchCLikeParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull ScratchCLikeParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#variableSet}.
	 * @param ctx the parse tree
	 */
	void enterVariableSet(@NotNull ScratchCLikeParser.VariableSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#variableSet}.
	 * @param ctx the parse tree
	 */
	void exitVariableSet(@NotNull ScratchCLikeParser.VariableSetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(@NotNull ScratchCLikeParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(@NotNull ScratchCLikeParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#mathMultiplyExp}.
	 * @param ctx the parse tree
	 */
	void enterMathMultiplyExp(@NotNull ScratchCLikeParser.MathMultiplyExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#mathMultiplyExp}.
	 * @param ctx the parse tree
	 */
	void exitMathMultiplyExp(@NotNull ScratchCLikeParser.MathMultiplyExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#mathAtomExp}.
	 * @param ctx the parse tree
	 */
	void enterMathAtomExp(@NotNull ScratchCLikeParser.MathAtomExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#mathAtomExp}.
	 * @param ctx the parse tree
	 */
	void exitMathAtomExp(@NotNull ScratchCLikeParser.MathAtomExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(@NotNull ScratchCLikeParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(@NotNull ScratchCLikeParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#emptyBraces}.
	 * @param ctx the parse tree
	 */
	void enterEmptyBraces(@NotNull ScratchCLikeParser.EmptyBracesContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#emptyBraces}.
	 * @param ctx the parse tree
	 */
	void exitEmptyBraces(@NotNull ScratchCLikeParser.EmptyBracesContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#conditionAndOrNoP}.
	 * @param ctx the parse tree
	 */
	void enterConditionAndOrNoP(@NotNull ScratchCLikeParser.ConditionAndOrNoPContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#conditionAndOrNoP}.
	 * @param ctx the parse tree
	 */
	void exitConditionAndOrNoP(@NotNull ScratchCLikeParser.ConditionAndOrNoPContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(@NotNull ScratchCLikeParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(@NotNull ScratchCLikeParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#arrayIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterArrayIdentifier(@NotNull ScratchCLikeParser.ArrayIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#arrayIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitArrayIdentifier(@NotNull ScratchCLikeParser.ArrayIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#paramDef}.
	 * @param ctx the parse tree
	 */
	void enterParamDef(@NotNull ScratchCLikeParser.ParamDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#paramDef}.
	 * @param ctx the parse tree
	 */
	void exitParamDef(@NotNull ScratchCLikeParser.ParamDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link ScratchCLikeParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(@NotNull ScratchCLikeParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by {@link ScratchCLikeParser#whileLoop}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(@NotNull ScratchCLikeParser.WhileLoopContext ctx);
}