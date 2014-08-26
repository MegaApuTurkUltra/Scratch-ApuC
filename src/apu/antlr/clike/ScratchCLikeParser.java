// Generated from ScratchCLike.g4 by ANTLR 4.4

  package apu.antlr.clike;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ScratchCLikeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOL_TRUE=1, IF_TAG=2, ELSE_TAG=3, BOOL_AND=4, BOOL_OR=5, BOOL_NOT=6, 
		BOOL_EQUALS=7, BOOL_NEQUALS=8, BOOL_GT=9, BOOL_LT=10, BOOL_GTE=11, BOOL_LTE=12, 
		MATH_PLUS=13, MATH_MINUS=14, MATH_TIMES=15, MATH_DIVIDE=16, MATH_MODULO=17, 
		FOR_TAG=18, WHILE_TAG=19, METHOD_DEF_TAG=20, ATOMIC_METHOD_TAG=21, RETURN_TAG=22, 
		WHEN_TAG=23, WHEN_CLICKED=24, WHEN_RECEIVE=25, WHEN_KEY=26, WHEN_CLONED=27, 
		WHEN_SENSOR=28, WHEN_FLAG=29, REPEAT_TAG=30, SINGLE_FRAME_TAG=31, ARRAY_TAG=32, 
		IDENTIFIER=33, STRINGLITERAL=34, OPENP=35, CLOSEP=36, OPENB=37, CLOSEB=38, 
		SEMICOLON=39, EQUALS=40, PLUS_EQUALS=41, MINUS_EQUALS=42, PLUS_PLUS=43, 
		MINUS_MINUS=44, COMMA=45, OPENC=46, CLOSEC=47, NUMBER=48, LETTER=49, WS=50, 
		BlockComment=51, LineComment=52;
	public static final String[] tokenNames = {
		"<INVALID>", "'true'", "'if'", "'else'", "'&&'", "'||'", "'!'", "'=='", 
		"'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'for'", "'while'", "'def'", "'@atomic'", "'return'", "'@when'", "'clicked'", 
		"'received'", "'keyPressed'", "'cloned'", "'sensorGreaterThan'", "'greenFlag'", 
		"'repeat'", "'@singleframe'", "'array'", "IDENTIFIER", "STRINGLITERAL", 
		"'('", "')'", "'{'", "'}'", "';'", "'='", "'+='", "'-='", "'++'", "'--'", 
		"','", "'['", "']'", "NUMBER", "LETTER", "WS", "BlockComment", "LineComment"
	};
	public static final int
		RULE_eval = 0, RULE_body = 1, RULE_braces = 2, RULE_emptyBraces = 3, RULE_methodBody = 4, 
		RULE_line = 5, RULE_returnStatement = 6, RULE_whenDef = 7, RULE_ifElse = 8, 
		RULE_forLoop = 9, RULE_whileLoop = 10, RULE_repeatSingleFrameLoop = 11, 
		RULE_conditionItem = 12, RULE_conditionAndOr = 13, RULE_conditionAndOrNoP = 14, 
		RULE_condition = 15, RULE_methodCall = 16, RULE_variableSet = 17, RULE_varExp = 18, 
		RULE_arrayCreate = 19, RULE_arrayDef = 20, RULE_paramsDef = 21, RULE_paramDef = 22, 
		RULE_params = 23, RULE_mathExp = 24, RULE_mathAdditionExp = 25, RULE_mathMultiplyExp = 26, 
		RULE_mathAtomExp = 27, RULE_arrayIdentifier = 28;
	public static final String[] ruleNames = {
		"eval", "body", "braces", "emptyBraces", "methodBody", "line", "returnStatement", 
		"whenDef", "ifElse", "forLoop", "whileLoop", "repeatSingleFrameLoop", 
		"conditionItem", "conditionAndOr", "conditionAndOrNoP", "condition", "methodCall", 
		"variableSet", "varExp", "arrayCreate", "arrayDef", "paramsDef", "paramDef", 
		"params", "mathExp", "mathAdditionExp", "mathMultiplyExp", "mathAtomExp", 
		"arrayIdentifier"
	};

	@Override
	public String getGrammarFileName() { return "ScratchCLike.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ScratchCLikeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvalContext extends ParserRuleContext {
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitEval(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public List<BracesContext> braces() {
			return getRuleContexts(BracesContext.class);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public BracesContext braces(int i) {
			return getRuleContext(BracesContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitBody(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF_TAG) | (1L << FOR_TAG) | (1L << WHILE_TAG) | (1L << METHOD_DEF_TAG) | (1L << RETURN_TAG) | (1L << WHEN_TAG) | (1L << REPEAT_TAG) | (1L << IDENTIFIER) | (1L << OPENB))) != 0)) {
				{
				setState(62);
				switch (_input.LA(1)) {
				case RETURN_TAG:
				case IDENTIFIER:
					{
					setState(60); line();
					}
					break;
				case IF_TAG:
				case FOR_TAG:
				case WHILE_TAG:
				case METHOD_DEF_TAG:
				case WHEN_TAG:
				case REPEAT_TAG:
				case OPENB:
					{
					setState(61); braces();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BracesContext extends ParserRuleContext {
		public WhenDefContext whenDef() {
			return getRuleContext(WhenDefContext.class,0);
		}
		public EmptyBracesContext emptyBraces() {
			return getRuleContext(EmptyBracesContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public IfElseContext ifElse() {
			return getRuleContext(IfElseContext.class,0);
		}
		public WhileLoopContext whileLoop() {
			return getRuleContext(WhileLoopContext.class,0);
		}
		public ForLoopContext forLoop() {
			return getRuleContext(ForLoopContext.class,0);
		}
		public RepeatSingleFrameLoopContext repeatSingleFrameLoop() {
			return getRuleContext(RepeatSingleFrameLoopContext.class,0);
		}
		public BracesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_braces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitBraces(this);
		}
	}

	public final BracesContext braces() throws RecognitionException {
		BracesContext _localctx = new BracesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_braces);
		try {
			setState(74);
			switch (_input.LA(1)) {
			case OPENB:
				enterOuterAlt(_localctx, 1);
				{
				setState(67); emptyBraces();
				}
				break;
			case METHOD_DEF_TAG:
				enterOuterAlt(_localctx, 2);
				{
				setState(68); methodBody();
				}
				break;
			case IF_TAG:
				enterOuterAlt(_localctx, 3);
				{
				setState(69); ifElse();
				}
				break;
			case FOR_TAG:
				enterOuterAlt(_localctx, 4);
				{
				setState(70); forLoop();
				}
				break;
			case WHILE_TAG:
				enterOuterAlt(_localctx, 5);
				{
				setState(71); whileLoop();
				}
				break;
			case REPEAT_TAG:
				enterOuterAlt(_localctx, 6);
				{
				setState(72); repeatSingleFrameLoop();
				}
				break;
			case WHEN_TAG:
				enterOuterAlt(_localctx, 7);
				{
				setState(73); whenDef();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyBracesContext extends ParserRuleContext {
		public TerminalNode OPENB() { return getToken(ScratchCLikeParser.OPENB, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode CLOSEB() { return getToken(ScratchCLikeParser.CLOSEB, 0); }
		public EmptyBracesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyBraces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterEmptyBraces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitEmptyBraces(this);
		}
	}

	public final EmptyBracesContext emptyBraces() throws RecognitionException {
		EmptyBracesContext _localctx = new EmptyBracesContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_emptyBraces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76); match(OPENB);
			setState(77); body();
			setState(78); match(CLOSEB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodBodyContext extends ParserRuleContext {
		public TerminalNode OPENB() { return getToken(ScratchCLikeParser.OPENB, 0); }
		public ParamsDefContext paramsDef() {
			return getRuleContext(ParamsDefContext.class,0);
		}
		public TerminalNode CLOSEP() { return getToken(ScratchCLikeParser.CLOSEP, 0); }
		public TerminalNode ATOMIC_METHOD_TAG() { return getToken(ScratchCLikeParser.ATOMIC_METHOD_TAG, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ScratchCLikeParser.IDENTIFIER, 0); }
		public TerminalNode OPENP() { return getToken(ScratchCLikeParser.OPENP, 0); }
		public TerminalNode CLOSEB() { return getToken(ScratchCLikeParser.CLOSEB, 0); }
		public TerminalNode METHOD_DEF_TAG() { return getToken(ScratchCLikeParser.METHOD_DEF_TAG, 0); }
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitMethodBody(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80); match(METHOD_DEF_TAG);
			setState(82);
			_la = _input.LA(1);
			if (_la==ATOMIC_METHOD_TAG) {
				{
				setState(81); match(ATOMIC_METHOD_TAG);
				}
			}

			setState(84); match(IDENTIFIER);
			setState(85); match(OPENP);
			setState(87);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(86); paramsDef();
				}
			}

			setState(89); match(CLOSEP);
			setState(90); match(OPENB);
			setState(91); body();
			setState(92); match(CLOSEB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LineContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(ScratchCLikeParser.SEMICOLON, 0); }
		public VariableSetContext variableSet() {
			return getRuleContext(VariableSetContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ArrayCreateContext arrayCreate() {
			return getRuleContext(ArrayCreateContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(94); methodCall();
				}
				break;
			case 2:
				{
				setState(95); variableSet();
				}
				break;
			case 3:
				{
				setState(96); arrayCreate();
				}
				break;
			case 4:
				{
				setState(97); returnStatement();
				}
				break;
			}
			setState(100); match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN_TAG() { return getToken(ScratchCLikeParser.RETURN_TAG, 0); }
		public VarExpContext varExp() {
			return getRuleContext(VarExpContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(RETURN_TAG);
			setState(104);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << STRINGLITERAL) | (1L << OPENP) | (1L << NUMBER))) != 0)) {
				{
				setState(103); varExp();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhenDefContext extends ParserRuleContext {
		public TerminalNode WHEN_FLAG() { return getToken(ScratchCLikeParser.WHEN_FLAG, 0); }
		public TerminalNode WHEN_CLONED() { return getToken(ScratchCLikeParser.WHEN_CLONED, 0); }
		public TerminalNode OPENB() { return getToken(ScratchCLikeParser.OPENB, 0); }
		public TerminalNode WHEN_KEY() { return getToken(ScratchCLikeParser.WHEN_KEY, 0); }
		public TerminalNode WHEN_CLICKED() { return getToken(ScratchCLikeParser.WHEN_CLICKED, 0); }
		public List<VarExpContext> varExp() {
			return getRuleContexts(VarExpContext.class);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode WHEN_TAG() { return getToken(ScratchCLikeParser.WHEN_TAG, 0); }
		public VarExpContext varExp(int i) {
			return getRuleContext(VarExpContext.class,i);
		}
		public TerminalNode WHEN_RECEIVE() { return getToken(ScratchCLikeParser.WHEN_RECEIVE, 0); }
		public TerminalNode WHEN_SENSOR() { return getToken(ScratchCLikeParser.WHEN_SENSOR, 0); }
		public TerminalNode CLOSEB() { return getToken(ScratchCLikeParser.CLOSEB, 0); }
		public WhenDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterWhenDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitWhenDef(this);
		}
	}

	public final WhenDefContext whenDef() throws RecognitionException {
		WhenDefContext _localctx = new WhenDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_whenDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106); match(WHEN_TAG);
			setState(107);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WHEN_CLICKED) | (1L << WHEN_RECEIVE) | (1L << WHEN_KEY) | (1L << WHEN_CLONED) | (1L << WHEN_SENSOR) | (1L << WHEN_FLAG))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << STRINGLITERAL) | (1L << OPENP) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(108); varExp();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114); match(OPENB);
			setState(115); body();
			setState(116); match(CLOSEB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfElseContext extends ParserRuleContext {
		public List<TerminalNode> OPENB() { return getTokens(ScratchCLikeParser.OPENB); }
		public ConditionAndOrContext conditionAndOr() {
			return getRuleContext(ConditionAndOrContext.class,0);
		}
		public TerminalNode IF_TAG() { return getToken(ScratchCLikeParser.IF_TAG, 0); }
		public TerminalNode CLOSEB(int i) {
			return getToken(ScratchCLikeParser.CLOSEB, i);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public TerminalNode OPENB(int i) {
			return getToken(ScratchCLikeParser.OPENB, i);
		}
		public TerminalNode ELSE_TAG() { return getToken(ScratchCLikeParser.ELSE_TAG, 0); }
		public List<TerminalNode> CLOSEB() { return getTokens(ScratchCLikeParser.CLOSEB); }
		public IfElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterIfElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitIfElse(this);
		}
	}

	public final IfElseContext ifElse() throws RecognitionException {
		IfElseContext _localctx = new IfElseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifElse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); match(IF_TAG);
			setState(119); conditionAndOr();
			setState(120); match(OPENB);
			setState(121); body();
			setState(122); match(CLOSEB);
			setState(128);
			_la = _input.LA(1);
			if (_la==ELSE_TAG) {
				{
				setState(123); match(ELSE_TAG);
				setState(124); match(OPENB);
				setState(125); body();
				setState(126); match(CLOSEB);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForLoopContext extends ParserRuleContext {
		public TerminalNode OPENB() { return getToken(ScratchCLikeParser.OPENB, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(ScratchCLikeParser.SEMICOLON); }
		public TerminalNode CLOSEP() { return getToken(ScratchCLikeParser.CLOSEP, 0); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(ScratchCLikeParser.SEMICOLON, i);
		}
		public List<VariableSetContext> variableSet() {
			return getRuleContexts(VariableSetContext.class);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode OPENP() { return getToken(ScratchCLikeParser.OPENP, 0); }
		public VariableSetContext variableSet(int i) {
			return getRuleContext(VariableSetContext.class,i);
		}
		public TerminalNode FOR_TAG() { return getToken(ScratchCLikeParser.FOR_TAG, 0); }
		public ConditionAndOrNoPContext conditionAndOrNoP() {
			return getRuleContext(ConditionAndOrNoPContext.class,0);
		}
		public TerminalNode CLOSEB() { return getToken(ScratchCLikeParser.CLOSEB, 0); }
		public ForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitForLoop(this);
		}
	}

	public final ForLoopContext forLoop() throws RecognitionException {
		ForLoopContext _localctx = new ForLoopContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); match(FOR_TAG);
			setState(131); match(OPENP);
			setState(132); variableSet();
			setState(133); match(SEMICOLON);
			setState(134); conditionAndOrNoP();
			setState(135); match(SEMICOLON);
			setState(136); variableSet();
			setState(137); match(CLOSEP);
			setState(138); match(OPENB);
			setState(139); body();
			setState(140); match(CLOSEB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileLoopContext extends ParserRuleContext {
		public TerminalNode OPENB() { return getToken(ScratchCLikeParser.OPENB, 0); }
		public TerminalNode BOOL_TRUE() { return getToken(ScratchCLikeParser.BOOL_TRUE, 0); }
		public ConditionAndOrContext conditionAndOr() {
			return getRuleContext(ConditionAndOrContext.class,0);
		}
		public TerminalNode CLOSEP() { return getToken(ScratchCLikeParser.CLOSEP, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode OPENP() { return getToken(ScratchCLikeParser.OPENP, 0); }
		public TerminalNode WHILE_TAG() { return getToken(ScratchCLikeParser.WHILE_TAG, 0); }
		public TerminalNode CLOSEB() { return getToken(ScratchCLikeParser.CLOSEB, 0); }
		public WhileLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitWhileLoop(this);
		}
	}

	public final WhileLoopContext whileLoop() throws RecognitionException {
		WhileLoopContext _localctx = new WhileLoopContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(WHILE_TAG);
			setState(147);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(143); conditionAndOr();
				}
				break;
			case 2:
				{
				{
				setState(144); match(OPENP);
				setState(145); match(BOOL_TRUE);
				setState(146); match(CLOSEP);
				}
				}
				break;
			}
			setState(149); match(OPENB);
			setState(150); body();
			setState(151); match(CLOSEB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RepeatSingleFrameLoopContext extends ParserRuleContext {
		public TerminalNode OPENB() { return getToken(ScratchCLikeParser.OPENB, 0); }
		public TerminalNode REPEAT_TAG() { return getToken(ScratchCLikeParser.REPEAT_TAG, 0); }
		public TerminalNode CLOSEP() { return getToken(ScratchCLikeParser.CLOSEP, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode OPENP() { return getToken(ScratchCLikeParser.OPENP, 0); }
		public TerminalNode SINGLE_FRAME_TAG() { return getToken(ScratchCLikeParser.SINGLE_FRAME_TAG, 0); }
		public TerminalNode NUMBER() { return getToken(ScratchCLikeParser.NUMBER, 0); }
		public TerminalNode CLOSEB() { return getToken(ScratchCLikeParser.CLOSEB, 0); }
		public RepeatSingleFrameLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_repeatSingleFrameLoop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterRepeatSingleFrameLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitRepeatSingleFrameLoop(this);
		}
	}

	public final RepeatSingleFrameLoopContext repeatSingleFrameLoop() throws RecognitionException {
		RepeatSingleFrameLoopContext _localctx = new RepeatSingleFrameLoopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_repeatSingleFrameLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); match(REPEAT_TAG);
			setState(154); match(SINGLE_FRAME_TAG);
			setState(155); match(OPENP);
			setState(156); match(NUMBER);
			setState(157); match(CLOSEP);
			setState(158); match(OPENB);
			setState(159); body();
			setState(160); match(CLOSEB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionItemContext extends ParserRuleContext {
		public ConditionAndOrContext conditionAndOr() {
			return getRuleContext(ConditionAndOrContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode BOOL_NOT() { return getToken(ScratchCLikeParser.BOOL_NOT, 0); }
		public ConditionItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterConditionItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitConditionItem(this);
		}
	}

	public final ConditionItemContext conditionItem() throws RecognitionException {
		ConditionItemContext _localctx = new ConditionItemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_conditionItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			_la = _input.LA(1);
			if (_la==BOOL_NOT) {
				{
				setState(162); match(BOOL_NOT);
				}
			}

			setState(167);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(165); condition();
				}
				break;
			case 2:
				{
				setState(166); conditionAndOr();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionAndOrContext extends ParserRuleContext {
		public TerminalNode BOOL_AND() { return getToken(ScratchCLikeParser.BOOL_AND, 0); }
		public TerminalNode CLOSEP() { return getToken(ScratchCLikeParser.CLOSEP, 0); }
		public List<ConditionItemContext> conditionItem() {
			return getRuleContexts(ConditionItemContext.class);
		}
		public TerminalNode OPENP() { return getToken(ScratchCLikeParser.OPENP, 0); }
		public TerminalNode BOOL_OR() { return getToken(ScratchCLikeParser.BOOL_OR, 0); }
		public ConditionItemContext conditionItem(int i) {
			return getRuleContext(ConditionItemContext.class,i);
		}
		public ConditionAndOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionAndOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterConditionAndOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitConditionAndOr(this);
		}
	}

	public final ConditionAndOrContext conditionAndOr() throws RecognitionException {
		ConditionAndOrContext _localctx = new ConditionAndOrContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_conditionAndOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); match(OPENP);
			setState(173);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(170); conditionItem();
				setState(171);
				_la = _input.LA(1);
				if ( !(_la==BOOL_AND || _la==BOOL_OR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			}
			setState(175); conditionItem();
			setState(176); match(CLOSEP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionAndOrNoPContext extends ParserRuleContext {
		public TerminalNode BOOL_AND() { return getToken(ScratchCLikeParser.BOOL_AND, 0); }
		public List<ConditionItemContext> conditionItem() {
			return getRuleContexts(ConditionItemContext.class);
		}
		public TerminalNode BOOL_OR() { return getToken(ScratchCLikeParser.BOOL_OR, 0); }
		public ConditionItemContext conditionItem(int i) {
			return getRuleContext(ConditionItemContext.class,i);
		}
		public ConditionAndOrNoPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionAndOrNoP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterConditionAndOrNoP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitConditionAndOrNoP(this);
		}
	}

	public final ConditionAndOrNoPContext conditionAndOrNoP() throws RecognitionException {
		ConditionAndOrNoPContext _localctx = new ConditionAndOrNoPContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_conditionAndOrNoP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(178); conditionItem();
				setState(179);
				_la = _input.LA(1);
				if ( !(_la==BOOL_AND || _la==BOOL_OR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			}
			setState(183); conditionItem();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode BOOL_GTE() { return getToken(ScratchCLikeParser.BOOL_GTE, 0); }
		public TerminalNode BOOL_LT() { return getToken(ScratchCLikeParser.BOOL_LT, 0); }
		public TerminalNode BOOL_GT() { return getToken(ScratchCLikeParser.BOOL_GT, 0); }
		public TerminalNode BOOL_EQUALS() { return getToken(ScratchCLikeParser.BOOL_EQUALS, 0); }
		public TerminalNode BOOL_LTE() { return getToken(ScratchCLikeParser.BOOL_LTE, 0); }
		public TerminalNode BOOL_NEQUALS() { return getToken(ScratchCLikeParser.BOOL_NEQUALS, 0); }
		public List<VarExpContext> varExp() {
			return getRuleContexts(VarExpContext.class);
		}
		public VarExpContext varExp(int i) {
			return getRuleContext(VarExpContext.class,i);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_condition);
		int _la;
		try {
			setState(194);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(185); varExp();
				setState(189);
				switch (_input.LA(1)) {
				case BOOL_EQUALS:
				case BOOL_NEQUALS:
					{
					setState(186);
					_la = _input.LA(1);
					if ( !(_la==BOOL_EQUALS || _la==BOOL_NEQUALS) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case BOOL_GT:
				case BOOL_LT:
					{
					setState(187);
					_la = _input.LA(1);
					if ( !(_la==BOOL_GT || _la==BOOL_LT) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				case BOOL_GTE:
				case BOOL_LTE:
					{
					setState(188);
					_la = _input.LA(1);
					if ( !(_la==BOOL_GTE || _la==BOOL_LTE) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(191); varExp();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(193); methodCall();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodCallContext extends ParserRuleContext {
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode CLOSEP() { return getToken(ScratchCLikeParser.CLOSEP, 0); }
		public TerminalNode IDENTIFIER() { return getToken(ScratchCLikeParser.IDENTIFIER, 0); }
		public TerminalNode OPENP() { return getToken(ScratchCLikeParser.OPENP, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitMethodCall(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196); match(IDENTIFIER);
			setState(197); match(OPENP);
			setState(199);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << STRINGLITERAL) | (1L << OPENP) | (1L << NUMBER))) != 0)) {
				{
				setState(198); params();
				}
			}

			setState(201); match(CLOSEP);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableSetContext extends ParserRuleContext {
		public TerminalNode MINUS_MINUS() { return getToken(ScratchCLikeParser.MINUS_MINUS, 0); }
		public TerminalNode PLUS_EQUALS() { return getToken(ScratchCLikeParser.PLUS_EQUALS, 0); }
		public TerminalNode EQUALS() { return getToken(ScratchCLikeParser.EQUALS, 0); }
		public ArrayIdentifierContext arrayIdentifier() {
			return getRuleContext(ArrayIdentifierContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ScratchCLikeParser.IDENTIFIER, 0); }
		public VarExpContext varExp() {
			return getRuleContext(VarExpContext.class,0);
		}
		public TerminalNode PLUS_PLUS() { return getToken(ScratchCLikeParser.PLUS_PLUS, 0); }
		public TerminalNode MINUS_EQUALS() { return getToken(ScratchCLikeParser.MINUS_EQUALS, 0); }
		public VariableSetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableSet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterVariableSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitVariableSet(this);
		}
	}

	public final VariableSetContext variableSet() throws RecognitionException {
		VariableSetContext _localctx = new VariableSetContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_variableSet);
		int _la;
		try {
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(205);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(203); match(IDENTIFIER);
					}
					break;
				case 2:
					{
					setState(204); arrayIdentifier();
					}
					break;
				}
				setState(207);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << PLUS_EQUALS) | (1L << MINUS_EQUALS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(208); varExp();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(211);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(209); match(IDENTIFIER);
					}
					break;
				case 2:
					{
					setState(210); arrayIdentifier();
					}
					break;
				}
				setState(213);
				_la = _input.LA(1);
				if ( !(_la==PLUS_PLUS || _la==MINUS_MINUS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarExpContext extends ParserRuleContext {
		public ArrayIdentifierContext arrayIdentifier() {
			return getRuleContext(ArrayIdentifierContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ScratchCLikeParser.IDENTIFIER, 0); }
		public MathExpContext mathExp() {
			return getRuleContext(MathExpContext.class,0);
		}
		public TerminalNode STRINGLITERAL() { return getToken(ScratchCLikeParser.STRINGLITERAL, 0); }
		public TerminalNode NUMBER() { return getToken(ScratchCLikeParser.NUMBER, 0); }
		public VarExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterVarExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitVarExp(this);
		}
	}

	public final VarExpContext varExp() throws RecognitionException {
		VarExpContext _localctx = new VarExpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(216);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << STRINGLITERAL) | (1L << NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 2:
				{
				setState(219);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(217); arrayIdentifier();
					}
					break;
				case 2:
					{
					setState(218); mathExp();
					}
					break;
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayCreateContext extends ParserRuleContext {
		public ArrayDefContext arrayDef() {
			return getRuleContext(ArrayDefContext.class,0);
		}
		public TerminalNode ARRAY_TAG() { return getToken(ScratchCLikeParser.ARRAY_TAG, 0); }
		public TerminalNode EQUALS() { return getToken(ScratchCLikeParser.EQUALS, 0); }
		public TerminalNode SINGLE_FRAME_TAG() { return getToken(ScratchCLikeParser.SINGLE_FRAME_TAG, 0); }
		public TerminalNode NUMBER() { return getToken(ScratchCLikeParser.NUMBER, 0); }
		public TerminalNode OPENC() { return getToken(ScratchCLikeParser.OPENC, 0); }
		public TerminalNode CLOSEC() { return getToken(ScratchCLikeParser.CLOSEC, 0); }
		public ArrayCreateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterArrayCreate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitArrayCreate(this);
		}
	}

	public final ArrayCreateContext arrayCreate() throws RecognitionException {
		ArrayCreateContext _localctx = new ArrayCreateContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_arrayCreate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223); arrayDef();
			setState(224); match(EQUALS);
			setState(226);
			_la = _input.LA(1);
			if (_la==SINGLE_FRAME_TAG) {
				{
				setState(225); match(SINGLE_FRAME_TAG);
				}
			}

			setState(228); match(ARRAY_TAG);
			setState(229); match(OPENC);
			setState(230); match(NUMBER);
			setState(231); match(CLOSEC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayDefContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(ScratchCLikeParser.IDENTIFIER, 0); }
		public TerminalNode OPENC() { return getToken(ScratchCLikeParser.OPENC, 0); }
		public TerminalNode CLOSEC() { return getToken(ScratchCLikeParser.CLOSEC, 0); }
		public ArrayDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterArrayDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitArrayDef(this);
		}
	}

	public final ArrayDefContext arrayDef() throws RecognitionException {
		ArrayDefContext _localctx = new ArrayDefContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_arrayDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233); match(IDENTIFIER);
			setState(234); match(OPENC);
			setState(235); match(CLOSEC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsDefContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(ScratchCLikeParser.COMMA); }
		public ParamDefContext paramDef(int i) {
			return getRuleContext(ParamDefContext.class,i);
		}
		public List<ParamDefContext> paramDef() {
			return getRuleContexts(ParamDefContext.class);
		}
		public TerminalNode COMMA(int i) {
			return getToken(ScratchCLikeParser.COMMA, i);
		}
		public ParamsDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramsDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterParamsDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitParamsDef(this);
		}
	}

	public final ParamsDefContext paramsDef() throws RecognitionException {
		ParamsDefContext _localctx = new ParamsDefContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_paramsDef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(237); paramDef();
					setState(238); match(COMMA);
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(245); paramDef();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamDefContext extends ParserRuleContext {
		public ArrayDefContext arrayDef() {
			return getRuleContext(ArrayDefContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ScratchCLikeParser.IDENTIFIER, 0); }
		public ParamDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterParamDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitParamDef(this);
		}
	}

	public final ParamDefContext paramDef() throws RecognitionException {
		ParamDefContext _localctx = new ParamDefContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_paramDef);
		try {
			setState(249);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247); match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248); arrayDef();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public ArrayDefContext arrayDef() {
			return getRuleContext(ArrayDefContext.class,0);
		}
		public List<VarExpContext> varExp() {
			return getRuleContexts(VarExpContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(ScratchCLikeParser.COMMA); }
		public VarExpContext varExp(int i) {
			return getRuleContext(VarExpContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(ScratchCLikeParser.COMMA, i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_params);
		try {
			int _alt;
			setState(261);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(251); varExp();
						setState(252); match(COMMA);
						}
						} 
					}
					setState(258);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
				}
				setState(259); varExp();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(260); arrayDef();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathExpContext extends ParserRuleContext {
		public MathAdditionExpContext mathAdditionExp() {
			return getRuleContext(MathAdditionExpContext.class,0);
		}
		public MathExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterMathExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitMathExp(this);
		}
	}

	public final MathExpContext mathExp() throws RecognitionException {
		MathExpContext _localctx = new MathExpContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_mathExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); mathAdditionExp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathAdditionExpContext extends ParserRuleContext {
		public TerminalNode MATH_PLUS(int i) {
			return getToken(ScratchCLikeParser.MATH_PLUS, i);
		}
		public MathMultiplyExpContext mathMultiplyExp(int i) {
			return getRuleContext(MathMultiplyExpContext.class,i);
		}
		public List<TerminalNode> MATH_MINUS() { return getTokens(ScratchCLikeParser.MATH_MINUS); }
		public List<MathMultiplyExpContext> mathMultiplyExp() {
			return getRuleContexts(MathMultiplyExpContext.class);
		}
		public List<TerminalNode> MATH_PLUS() { return getTokens(ScratchCLikeParser.MATH_PLUS); }
		public TerminalNode MATH_MINUS(int i) {
			return getToken(ScratchCLikeParser.MATH_MINUS, i);
		}
		public MathAdditionExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathAdditionExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterMathAdditionExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitMathAdditionExp(this);
		}
	}

	public final MathAdditionExpContext mathAdditionExp() throws RecognitionException {
		MathAdditionExpContext _localctx = new MathAdditionExpContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_mathAdditionExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265); mathMultiplyExp();
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MATH_PLUS || _la==MATH_MINUS) {
				{
				setState(270);
				switch (_input.LA(1)) {
				case MATH_PLUS:
					{
					setState(266); match(MATH_PLUS);
					setState(267); mathMultiplyExp();
					}
					break;
				case MATH_MINUS:
					{
					setState(268); match(MATH_MINUS);
					setState(269); mathMultiplyExp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(274);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathMultiplyExpContext extends ParserRuleContext {
		public List<MathAtomExpContext> mathAtomExp() {
			return getRuleContexts(MathAtomExpContext.class);
		}
		public MathAtomExpContext mathAtomExp(int i) {
			return getRuleContext(MathAtomExpContext.class,i);
		}
		public TerminalNode MATH_MODULO(int i) {
			return getToken(ScratchCLikeParser.MATH_MODULO, i);
		}
		public List<TerminalNode> MATH_TIMES() { return getTokens(ScratchCLikeParser.MATH_TIMES); }
		public List<TerminalNode> MATH_DIVIDE() { return getTokens(ScratchCLikeParser.MATH_DIVIDE); }
		public TerminalNode MATH_TIMES(int i) {
			return getToken(ScratchCLikeParser.MATH_TIMES, i);
		}
		public TerminalNode MATH_DIVIDE(int i) {
			return getToken(ScratchCLikeParser.MATH_DIVIDE, i);
		}
		public List<TerminalNode> MATH_MODULO() { return getTokens(ScratchCLikeParser.MATH_MODULO); }
		public MathMultiplyExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathMultiplyExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterMathMultiplyExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitMathMultiplyExp(this);
		}
	}

	public final MathMultiplyExpContext mathMultiplyExp() throws RecognitionException {
		MathMultiplyExpContext _localctx = new MathMultiplyExpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_mathMultiplyExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275); mathAtomExp();
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MATH_TIMES) | (1L << MATH_DIVIDE) | (1L << MATH_MODULO))) != 0)) {
				{
				setState(282);
				switch (_input.LA(1)) {
				case MATH_TIMES:
					{
					setState(276); match(MATH_TIMES);
					setState(277); mathAtomExp();
					}
					break;
				case MATH_DIVIDE:
					{
					setState(278); match(MATH_DIVIDE);
					setState(279); mathAtomExp();
					}
					break;
				case MATH_MODULO:
					{
					setState(280); match(MATH_MODULO);
					setState(281); mathAtomExp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MathAtomExpContext extends ParserRuleContext {
		public TerminalNode CLOSEP() { return getToken(ScratchCLikeParser.CLOSEP, 0); }
		public ArrayIdentifierContext arrayIdentifier() {
			return getRuleContext(ArrayIdentifierContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ScratchCLikeParser.IDENTIFIER, 0); }
		public TerminalNode OPENP() { return getToken(ScratchCLikeParser.OPENP, 0); }
		public MathAdditionExpContext mathAdditionExp() {
			return getRuleContext(MathAdditionExpContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(ScratchCLikeParser.NUMBER, 0); }
		public MathAtomExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mathAtomExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterMathAtomExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitMathAtomExp(this);
		}
	}

	public final MathAtomExpContext mathAtomExp() throws RecognitionException {
		MathAtomExpContext _localctx = new MathAtomExpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_mathAtomExp);
		try {
			setState(299);
			switch (_input.LA(1)) {
			case IDENTIFIER:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
				case 1:
					{
					setState(287); match(NUMBER);
					}
					break;
				case 2:
					{
					setState(288); match(IDENTIFIER);
					}
					break;
				case 3:
					{
					setState(291);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						setState(289); arrayIdentifier();
						}
						break;
					case 2:
						{
						setState(290); methodCall();
						}
						break;
					}
					}
					break;
				}
				}
				break;
			case OPENP:
				enterOuterAlt(_localctx, 2);
				{
				setState(295); match(OPENP);
				setState(296); mathAdditionExp();
				setState(297); match(CLOSEP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayIdentifierContext extends ParserRuleContext {
		public VarExpContext varExp() {
			return getRuleContext(VarExpContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(ScratchCLikeParser.IDENTIFIER, 0); }
		public TerminalNode OPENC() { return getToken(ScratchCLikeParser.OPENC, 0); }
		public TerminalNode CLOSEC() { return getToken(ScratchCLikeParser.CLOSEC, 0); }
		public ArrayIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).enterArrayIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ScratchCLikeListener ) ((ScratchCLikeListener)listener).exitArrayIdentifier(this);
		}
	}

	public final ArrayIdentifierContext arrayIdentifier() throws RecognitionException {
		ArrayIdentifierContext _localctx = new ArrayIdentifierContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arrayIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301); match(IDENTIFIER);
			setState(302); match(OPENC);
			setState(303); varExp();
			setState(304); match(CLOSEC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\66\u0135\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3\3\7\3"+
		"A\n\3\f\3\16\3D\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4M\n\4\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\5\6U\n\6\3\6\3\6\3\6\5\6Z\n\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\5\7e\n\7\3\7\3\7\3\b\3\b\5\bk\n\b\3\t\3\t\3\t\7\tp\n\t\f\t\16"+
		"\ts\13\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0083"+
		"\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u0096\n\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\5\16\u00a6\n\16\3\16\3\16\5\16\u00aa\n\16\3\17\3\17\3"+
		"\17\3\17\5\17\u00b0\n\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u00b8\n\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\5\21\u00c0\n\21\3\21\3\21\3\21\5\21\u00c5"+
		"\n\21\3\22\3\22\3\22\5\22\u00ca\n\22\3\22\3\22\3\23\3\23\5\23\u00d0\n"+
		"\23\3\23\3\23\3\23\3\23\5\23\u00d6\n\23\3\23\5\23\u00d9\n\23\3\24\3\24"+
		"\3\24\5\24\u00de\n\24\5\24\u00e0\n\24\3\25\3\25\3\25\5\25\u00e5\n\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\27\7\27\u00f3"+
		"\n\27\f\27\16\27\u00f6\13\27\3\27\3\27\3\30\3\30\5\30\u00fc\n\30\3\31"+
		"\3\31\3\31\7\31\u0101\n\31\f\31\16\31\u0104\13\31\3\31\3\31\5\31\u0108"+
		"\n\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\7\33\u0111\n\33\f\33\16\33\u0114"+
		"\13\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u011d\n\34\f\34\16\34\u0120"+
		"\13\34\3\35\3\35\3\35\3\35\5\35\u0126\n\35\5\35\u0128\n\35\3\35\3\35\3"+
		"\35\3\35\5\35\u012e\n\35\3\36\3\36\3\36\3\36\3\36\3\36\2\2\37\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:\2\n\3\2\32\37\3"+
		"\2\6\7\3\2\t\n\3\2\13\f\3\2\r\16\3\2*,\3\2-.\4\2#$\62\62\u0143\2<\3\2"+
		"\2\2\4B\3\2\2\2\6L\3\2\2\2\bN\3\2\2\2\nR\3\2\2\2\fd\3\2\2\2\16h\3\2\2"+
		"\2\20l\3\2\2\2\22x\3\2\2\2\24\u0084\3\2\2\2\26\u0090\3\2\2\2\30\u009b"+
		"\3\2\2\2\32\u00a5\3\2\2\2\34\u00ab\3\2\2\2\36\u00b7\3\2\2\2 \u00c4\3\2"+
		"\2\2\"\u00c6\3\2\2\2$\u00d8\3\2\2\2&\u00df\3\2\2\2(\u00e1\3\2\2\2*\u00eb"+
		"\3\2\2\2,\u00f4\3\2\2\2.\u00fb\3\2\2\2\60\u0107\3\2\2\2\62\u0109\3\2\2"+
		"\2\64\u010b\3\2\2\2\66\u0115\3\2\2\28\u012d\3\2\2\2:\u012f\3\2\2\2<=\5"+
		"\4\3\2=\3\3\2\2\2>A\5\f\7\2?A\5\6\4\2@>\3\2\2\2@?\3\2\2\2AD\3\2\2\2B@"+
		"\3\2\2\2BC\3\2\2\2C\5\3\2\2\2DB\3\2\2\2EM\5\b\5\2FM\5\n\6\2GM\5\22\n\2"+
		"HM\5\24\13\2IM\5\26\f\2JM\5\30\r\2KM\5\20\t\2LE\3\2\2\2LF\3\2\2\2LG\3"+
		"\2\2\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2M\7\3\2\2\2NO\7\'\2\2OP"+
		"\5\4\3\2PQ\7(\2\2Q\t\3\2\2\2RT\7\26\2\2SU\7\27\2\2TS\3\2\2\2TU\3\2\2\2"+
		"UV\3\2\2\2VW\7#\2\2WY\7%\2\2XZ\5,\27\2YX\3\2\2\2YZ\3\2\2\2Z[\3\2\2\2["+
		"\\\7&\2\2\\]\7\'\2\2]^\5\4\3\2^_\7(\2\2_\13\3\2\2\2`e\5\"\22\2ae\5$\23"+
		"\2be\5(\25\2ce\5\16\b\2d`\3\2\2\2da\3\2\2\2db\3\2\2\2dc\3\2\2\2ef\3\2"+
		"\2\2fg\7)\2\2g\r\3\2\2\2hj\7\30\2\2ik\5&\24\2ji\3\2\2\2jk\3\2\2\2k\17"+
		"\3\2\2\2lm\7\31\2\2mq\t\2\2\2np\5&\24\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2"+
		"qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\'\2\2uv\5\4\3\2vw\7(\2\2w\21\3\2\2"+
		"\2xy\7\4\2\2yz\5\34\17\2z{\7\'\2\2{|\5\4\3\2|\u0082\7(\2\2}~\7\5\2\2~"+
		"\177\7\'\2\2\177\u0080\5\4\3\2\u0080\u0081\7(\2\2\u0081\u0083\3\2\2\2"+
		"\u0082}\3\2\2\2\u0082\u0083\3\2\2\2\u0083\23\3\2\2\2\u0084\u0085\7\24"+
		"\2\2\u0085\u0086\7%\2\2\u0086\u0087\5$\23\2\u0087\u0088\7)\2\2\u0088\u0089"+
		"\5\36\20\2\u0089\u008a\7)\2\2\u008a\u008b\5$\23\2\u008b\u008c\7&\2\2\u008c"+
		"\u008d\7\'\2\2\u008d\u008e\5\4\3\2\u008e\u008f\7(\2\2\u008f\25\3\2\2\2"+
		"\u0090\u0095\7\25\2\2\u0091\u0096\5\34\17\2\u0092\u0093\7%\2\2\u0093\u0094"+
		"\7\3\2\2\u0094\u0096\7&\2\2\u0095\u0091\3\2\2\2\u0095\u0092\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\7\'\2\2\u0098\u0099\5\4\3\2\u0099\u009a\7("+
		"\2\2\u009a\27\3\2\2\2\u009b\u009c\7 \2\2\u009c\u009d\7!\2\2\u009d\u009e"+
		"\7%\2\2\u009e\u009f\7\62\2\2\u009f\u00a0\7&\2\2\u00a0\u00a1\7\'\2\2\u00a1"+
		"\u00a2\5\4\3\2\u00a2\u00a3\7(\2\2\u00a3\31\3\2\2\2\u00a4\u00a6\7\b\2\2"+
		"\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00aa"+
		"\5 \21\2\u00a8\u00aa\5\34\17\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2"+
		"\u00aa\33\3\2\2\2\u00ab\u00af\7%\2\2\u00ac\u00ad\5\32\16\2\u00ad\u00ae"+
		"\t\3\2\2\u00ae\u00b0\3\2\2\2\u00af\u00ac\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\5\32\16\2\u00b2\u00b3\7&\2\2\u00b3\35\3\2\2"+
		"\2\u00b4\u00b5\5\32\16\2\u00b5\u00b6\t\3\2\2\u00b6\u00b8\3\2\2\2\u00b7"+
		"\u00b4\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\5\32"+
		"\16\2\u00ba\37\3\2\2\2\u00bb\u00bf\5&\24\2\u00bc\u00c0\t\4\2\2\u00bd\u00c0"+
		"\t\5\2\2\u00be\u00c0\t\6\2\2\u00bf\u00bc\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\5&\24\2\u00c2\u00c5\3\2"+
		"\2\2\u00c3\u00c5\5\"\22\2\u00c4\u00bb\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5"+
		"!\3\2\2\2\u00c6\u00c7\7#\2\2\u00c7\u00c9\7%\2\2\u00c8\u00ca\5\60\31\2"+
		"\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc"+
		"\7&\2\2\u00cc#\3\2\2\2\u00cd\u00d0\7#\2\2\u00ce\u00d0\5:\36\2\u00cf\u00cd"+
		"\3\2\2\2\u00cf\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\t\7\2\2\u00d2"+
		"\u00d9\5&\24\2\u00d3\u00d6\7#\2\2\u00d4\u00d6\5:\36\2\u00d5\u00d3\3\2"+
		"\2\2\u00d5\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d9\t\b\2\2\u00d8"+
		"\u00cf\3\2\2\2\u00d8\u00d5\3\2\2\2\u00d9%\3\2\2\2\u00da\u00e0\t\t\2\2"+
		"\u00db\u00de\5:\36\2\u00dc\u00de\5\62\32\2\u00dd\u00db\3\2\2\2\u00dd\u00dc"+
		"\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00da\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\'\3\2\2\2\u00e1\u00e2\5*\26\2\u00e2\u00e4\7*\2\2\u00e3\u00e5\7!\2\2\u00e4"+
		"\u00e3\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\7\""+
		"\2\2\u00e7\u00e8\7\60\2\2\u00e8\u00e9\7\62\2\2\u00e9\u00ea\7\61\2\2\u00ea"+
		")\3\2\2\2\u00eb\u00ec\7#\2\2\u00ec\u00ed\7\60\2\2\u00ed\u00ee\7\61\2\2"+
		"\u00ee+\3\2\2\2\u00ef\u00f0\5.\30\2\u00f0\u00f1\7/\2\2\u00f1\u00f3\3\2"+
		"\2\2\u00f2\u00ef\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f8\5."+
		"\30\2\u00f8-\3\2\2\2\u00f9\u00fc\7#\2\2\u00fa\u00fc\5*\26\2\u00fb\u00f9"+
		"\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc/\3\2\2\2\u00fd\u00fe\5&\24\2\u00fe"+
		"\u00ff\7/\2\2\u00ff\u0101\3\2\2\2\u0100\u00fd\3\2\2\2\u0101\u0104\3\2"+
		"\2\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0105\u0108\5&\24\2\u0106\u0108\5*\26\2\u0107\u0102\3\2"+
		"\2\2\u0107\u0106\3\2\2\2\u0108\61\3\2\2\2\u0109\u010a\5\64\33\2\u010a"+
		"\63\3\2\2\2\u010b\u0112\5\66\34\2\u010c\u010d\7\17\2\2\u010d\u0111\5\66"+
		"\34\2\u010e\u010f\7\20\2\2\u010f\u0111\5\66\34\2\u0110\u010c\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0111\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2"+
		"\2\2\u0113\65\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u011e\58\35\2\u0116\u0117"+
		"\7\21\2\2\u0117\u011d\58\35\2\u0118\u0119\7\22\2\2\u0119\u011d\58\35\2"+
		"\u011a\u011b\7\23\2\2\u011b\u011d\58\35\2\u011c\u0116\3\2\2\2\u011c\u0118"+
		"\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f\67\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0128\7\62\2"+
		"\2\u0122\u0128\7#\2\2\u0123\u0126\5:\36\2\u0124\u0126\5\"\22\2\u0125\u0123"+
		"\3\2\2\2\u0125\u0124\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0121\3\2\2\2\u0127"+
		"\u0122\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u012e\3\2\2\2\u0129\u012a\7%"+
		"\2\2\u012a\u012b\5\64\33\2\u012b\u012c\7&\2\2\u012c\u012e\3\2\2\2\u012d"+
		"\u0127\3\2\2\2\u012d\u0129\3\2\2\2\u012e9\3\2\2\2\u012f\u0130\7#\2\2\u0130"+
		"\u0131\7\60\2\2\u0131\u0132\5&\24\2\u0132\u0133\7\61\2\2\u0133;\3\2\2"+
		"\2$@BLTYdjq\u0082\u0095\u00a5\u00a9\u00af\u00b7\u00bf\u00c4\u00c9\u00cf"+
		"\u00d5\u00d8\u00dd\u00df\u00e4\u00f4\u00fb\u0102\u0107\u0110\u0112\u011c"+
		"\u011e\u0125\u0127\u012d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}