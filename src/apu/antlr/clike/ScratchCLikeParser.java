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
		FOR_TAG=18, WHILE_TAG=19, METHOD_DEF_TAG=20, ATOMIC_METHOD_TAG=21, WHEN_TAG=22, 
		WHEN_CLICKED=23, WHEN_RECEIVE=24, WHEN_KEY=25, WHEN_CLONED=26, WHEN_SENSOR=27, 
		WHEN_FLAG=28, REPEAT_TAG=29, SINGLE_FRAME_TAG=30, ARRAY_TAG=31, IDENTIFIER=32, 
		STRINGLITERAL=33, OPENP=34, CLOSEP=35, OPENB=36, CLOSEB=37, SEMICOLON=38, 
		EQUALS=39, PLUS_EQUALS=40, MINUS_EQUALS=41, PLUS_PLUS=42, MINUS_MINUS=43, 
		COMMA=44, OPENC=45, CLOSEC=46, NUMBER=47, LETTER=48, WS=49, BlockComment=50, 
		LineComment=51;
	public static final String[] tokenNames = {
		"<INVALID>", "'true'", "'if'", "'else'", "'&&'", "'||'", "'!'", "'=='", 
		"'!='", "'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", 
		"'for'", "'while'", "'void'", "'@atomic'", "'@when'", "'clicked'", "'received'", 
		"'keyPressed'", "'cloned'", "'sensorGreaterThan'", "'greenFlag'", "'repeat'", 
		"'@singleframe'", "'array'", "IDENTIFIER", "STRINGLITERAL", "'('", "')'", 
		"'{'", "'}'", "';'", "'='", "'+='", "'-='", "'++'", "'--'", "','", "'['", 
		"']'", "NUMBER", "LETTER", "WS", "BlockComment", "LineComment"
	};
	public static final int
		RULE_eval = 0, RULE_body = 1, RULE_braces = 2, RULE_emptyBraces = 3, RULE_methodBody = 4, 
		RULE_line = 5, RULE_whenDef = 6, RULE_ifElse = 7, RULE_forLoop = 8, RULE_whileLoop = 9, 
		RULE_repeatSingleFrameLoop = 10, RULE_conditionItem = 11, RULE_conditionAndOr = 12, 
		RULE_conditionAndOrNoP = 13, RULE_condition = 14, RULE_methodCall = 15, 
		RULE_variableSet = 16, RULE_varExp = 17, RULE_arrayCreate = 18, RULE_arrayDef = 19, 
		RULE_paramsDef = 20, RULE_paramDef = 21, RULE_params = 22, RULE_mathExp = 23, 
		RULE_mathAdditionExp = 24, RULE_mathMultiplyExp = 25, RULE_mathAtomExp = 26, 
		RULE_arrayIdentifier = 27;
	public static final String[] ruleNames = {
		"eval", "body", "braces", "emptyBraces", "methodBody", "line", "whenDef", 
		"ifElse", "forLoop", "whileLoop", "repeatSingleFrameLoop", "conditionItem", 
		"conditionAndOr", "conditionAndOrNoP", "condition", "methodCall", "variableSet", 
		"varExp", "arrayCreate", "arrayDef", "paramsDef", "paramDef", "params", 
		"mathExp", "mathAdditionExp", "mathMultiplyExp", "mathAtomExp", "arrayIdentifier"
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
			setState(56); body();
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
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF_TAG) | (1L << FOR_TAG) | (1L << WHILE_TAG) | (1L << METHOD_DEF_TAG) | (1L << WHEN_TAG) | (1L << REPEAT_TAG) | (1L << IDENTIFIER) | (1L << OPENB))) != 0)) {
				{
				setState(60);
				switch (_input.LA(1)) {
				case IDENTIFIER:
					{
					setState(58); line();
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
					setState(59); braces();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(64);
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
			setState(72);
			switch (_input.LA(1)) {
			case OPENB:
				enterOuterAlt(_localctx, 1);
				{
				setState(65); emptyBraces();
				}
				break;
			case METHOD_DEF_TAG:
				enterOuterAlt(_localctx, 2);
				{
				setState(66); methodBody();
				}
				break;
			case IF_TAG:
				enterOuterAlt(_localctx, 3);
				{
				setState(67); ifElse();
				}
				break;
			case FOR_TAG:
				enterOuterAlt(_localctx, 4);
				{
				setState(68); forLoop();
				}
				break;
			case WHILE_TAG:
				enterOuterAlt(_localctx, 5);
				{
				setState(69); whileLoop();
				}
				break;
			case REPEAT_TAG:
				enterOuterAlt(_localctx, 6);
				{
				setState(70); repeatSingleFrameLoop();
				}
				break;
			case WHEN_TAG:
				enterOuterAlt(_localctx, 7);
				{
				setState(71); whenDef();
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
			setState(74); match(OPENB);
			setState(75); body();
			setState(76); match(CLOSEB);
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
			setState(78); match(METHOD_DEF_TAG);
			setState(80);
			_la = _input.LA(1);
			if (_la==ATOMIC_METHOD_TAG) {
				{
				setState(79); match(ATOMIC_METHOD_TAG);
				}
			}

			setState(82); match(IDENTIFIER);
			setState(83); match(OPENP);
			setState(85);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(84); paramsDef();
				}
			}

			setState(87); match(CLOSEP);
			setState(88); match(OPENB);
			setState(89); body();
			setState(90); match(CLOSEB);
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
			setState(95);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(92); methodCall();
				}
				break;
			case 2:
				{
				setState(93); variableSet();
				}
				break;
			case 3:
				{
				setState(94); arrayCreate();
				}
				break;
			}
			setState(97); match(SEMICOLON);
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
		enterRule(_localctx, 12, RULE_whenDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99); match(WHEN_TAG);
			setState(100);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << WHEN_CLICKED) | (1L << WHEN_RECEIVE) | (1L << WHEN_KEY) | (1L << WHEN_CLONED) | (1L << WHEN_SENSOR) | (1L << WHEN_FLAG))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << STRINGLITERAL) | (1L << OPENP) | (1L << NUMBER))) != 0)) {
				{
				{
				setState(101); varExp();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107); match(OPENB);
			setState(108); body();
			setState(109); match(CLOSEB);
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
		enterRule(_localctx, 14, RULE_ifElse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(IF_TAG);
			setState(112); conditionAndOr();
			setState(113); match(OPENB);
			setState(114); body();
			setState(115); match(CLOSEB);
			setState(121);
			_la = _input.LA(1);
			if (_la==ELSE_TAG) {
				{
				setState(116); match(ELSE_TAG);
				setState(117); match(OPENB);
				setState(118); body();
				setState(119); match(CLOSEB);
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
		enterRule(_localctx, 16, RULE_forLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); match(FOR_TAG);
			setState(124); match(OPENP);
			setState(125); variableSet();
			setState(126); match(SEMICOLON);
			setState(127); conditionAndOrNoP();
			setState(128); match(SEMICOLON);
			setState(129); variableSet();
			setState(130); match(CLOSEP);
			setState(131); match(OPENB);
			setState(132); body();
			setState(133); match(CLOSEB);
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
		enterRule(_localctx, 18, RULE_whileLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135); match(WHILE_TAG);
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(136); conditionAndOr();
				}
				break;
			case 2:
				{
				{
				setState(137); match(OPENP);
				setState(138); match(BOOL_TRUE);
				setState(139); match(CLOSEP);
				}
				}
				break;
			}
			setState(142); match(OPENB);
			setState(143); body();
			setState(144); match(CLOSEB);
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
		enterRule(_localctx, 20, RULE_repeatSingleFrameLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(REPEAT_TAG);
			setState(147); match(SINGLE_FRAME_TAG);
			setState(148); match(OPENP);
			setState(149); match(NUMBER);
			setState(150); match(CLOSEP);
			setState(151); match(OPENB);
			setState(152); body();
			setState(153); match(CLOSEB);
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
		enterRule(_localctx, 22, RULE_conditionItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if (_la==BOOL_NOT) {
				{
				setState(155); match(BOOL_NOT);
				}
			}

			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(158); condition();
				}
				break;
			case 2:
				{
				setState(159); conditionAndOr();
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
		enterRule(_localctx, 24, RULE_conditionAndOr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(OPENP);
			setState(166);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(163); conditionItem();
				setState(164);
				_la = _input.LA(1);
				if ( !(_la==BOOL_AND || _la==BOOL_OR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			}
			setState(168); conditionItem();
			setState(169); match(CLOSEP);
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
		enterRule(_localctx, 26, RULE_conditionAndOrNoP);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(171); conditionItem();
				setState(172);
				_la = _input.LA(1);
				if ( !(_la==BOOL_AND || _la==BOOL_OR) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			}
			setState(176); conditionItem();
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
		enterRule(_localctx, 28, RULE_condition);
		int _la;
		try {
			setState(187);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(178); varExp();
				setState(182);
				switch (_input.LA(1)) {
				case BOOL_EQUALS:
				case BOOL_NEQUALS:
					{
					setState(179);
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
					setState(180);
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
					setState(181);
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
				setState(184); varExp();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(186); methodCall();
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
		enterRule(_localctx, 30, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); match(IDENTIFIER);
			setState(190); match(OPENP);
			setState(192);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << STRINGLITERAL) | (1L << OPENP) | (1L << NUMBER))) != 0)) {
				{
				setState(191); params();
				}
			}

			setState(194); match(CLOSEP);
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
		enterRule(_localctx, 32, RULE_variableSet);
		int _la;
		try {
			setState(207);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(198);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(196); match(IDENTIFIER);
					}
					break;
				case 2:
					{
					setState(197); arrayIdentifier();
					}
					break;
				}
				setState(200);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EQUALS) | (1L << PLUS_EQUALS) | (1L << MINUS_EQUALS))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(201); varExp();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(204);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(202); match(IDENTIFIER);
					}
					break;
				case 2:
					{
					setState(203); arrayIdentifier();
					}
					break;
				}
				setState(206);
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
		enterRule(_localctx, 34, RULE_varExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(209);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IDENTIFIER) | (1L << STRINGLITERAL) | (1L << NUMBER))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case 2:
				{
				setState(212);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(210); arrayIdentifier();
					}
					break;
				case 2:
					{
					setState(211); mathExp();
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
		enterRule(_localctx, 36, RULE_arrayCreate);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216); arrayDef();
			setState(217); match(EQUALS);
			setState(219);
			_la = _input.LA(1);
			if (_la==SINGLE_FRAME_TAG) {
				{
				setState(218); match(SINGLE_FRAME_TAG);
				}
			}

			setState(221); match(ARRAY_TAG);
			setState(222); match(OPENC);
			setState(223); match(NUMBER);
			setState(224); match(CLOSEC);
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
		enterRule(_localctx, 38, RULE_arrayDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); match(IDENTIFIER);
			setState(227); match(OPENC);
			setState(228); match(CLOSEC);
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
		enterRule(_localctx, 40, RULE_paramsDef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(230); paramDef();
					setState(231); match(COMMA);
					}
					} 
				}
				setState(237);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(238); paramDef();
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
		enterRule(_localctx, 42, RULE_paramDef);
		try {
			setState(242);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(240); match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(241); arrayDef();
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
		enterRule(_localctx, 44, RULE_params);
		try {
			int _alt;
			setState(254);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(244); varExp();
						setState(245); match(COMMA);
						}
						} 
					}
					setState(251);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
				}
				setState(252); varExp();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(253); arrayDef();
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
		enterRule(_localctx, 46, RULE_mathExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256); mathAdditionExp();
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
		enterRule(_localctx, 48, RULE_mathAdditionExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258); mathMultiplyExp();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MATH_PLUS || _la==MATH_MINUS) {
				{
				setState(263);
				switch (_input.LA(1)) {
				case MATH_PLUS:
					{
					setState(259); match(MATH_PLUS);
					setState(260); mathMultiplyExp();
					}
					break;
				case MATH_MINUS:
					{
					setState(261); match(MATH_MINUS);
					setState(262); mathMultiplyExp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(267);
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
		enterRule(_localctx, 50, RULE_mathMultiplyExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268); mathAtomExp();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MATH_TIMES) | (1L << MATH_DIVIDE) | (1L << MATH_MODULO))) != 0)) {
				{
				setState(275);
				switch (_input.LA(1)) {
				case MATH_TIMES:
					{
					setState(269); match(MATH_TIMES);
					setState(270); mathAtomExp();
					}
					break;
				case MATH_DIVIDE:
					{
					setState(271); match(MATH_DIVIDE);
					setState(272); mathAtomExp();
					}
					break;
				case MATH_MODULO:
					{
					setState(273); match(MATH_MODULO);
					setState(274); mathAtomExp();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(279);
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
		enterRule(_localctx, 52, RULE_mathAtomExp);
		try {
			setState(292);
			switch (_input.LA(1)) {
			case IDENTIFIER:
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(286);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(280); match(NUMBER);
					}
					break;
				case 2:
					{
					setState(281); match(IDENTIFIER);
					}
					break;
				case 3:
					{
					setState(284);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						setState(282); arrayIdentifier();
						}
						break;
					case 2:
						{
						setState(283); methodCall();
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
				setState(288); match(OPENP);
				setState(289); mathAdditionExp();
				setState(290); match(CLOSEP);
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
		enterRule(_localctx, 54, RULE_arrayIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(IDENTIFIER);
			setState(295); match(OPENC);
			setState(296); varExp();
			setState(297); match(CLOSEC);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\65\u012e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\7\3?\n\3\f\3"+
		"\16\3B\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4K\n\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\5\6S\n\6\3\6\3\6\3\6\5\6X\n\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\5\7b"+
		"\n\7\3\7\3\7\3\b\3\b\3\b\7\bi\n\b\f\b\16\bl\13\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t|\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13\u008f\n\13\3\13\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\5\r\u009f\n\r\3"+
		"\r\3\r\5\r\u00a3\n\r\3\16\3\16\3\16\3\16\5\16\u00a9\n\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\5\17\u00b1\n\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u00b9"+
		"\n\20\3\20\3\20\3\20\5\20\u00be\n\20\3\21\3\21\3\21\5\21\u00c3\n\21\3"+
		"\21\3\21\3\22\3\22\5\22\u00c9\n\22\3\22\3\22\3\22\3\22\5\22\u00cf\n\22"+
		"\3\22\5\22\u00d2\n\22\3\23\3\23\3\23\5\23\u00d7\n\23\5\23\u00d9\n\23\3"+
		"\24\3\24\3\24\5\24\u00de\n\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\7\26\u00ec\n\26\f\26\16\26\u00ef\13\26\3\26\3\26"+
		"\3\27\3\27\5\27\u00f5\n\27\3\30\3\30\3\30\7\30\u00fa\n\30\f\30\16\30\u00fd"+
		"\13\30\3\30\3\30\5\30\u0101\n\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\7"+
		"\32\u010a\n\32\f\32\16\32\u010d\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\7\33\u0116\n\33\f\33\16\33\u0119\13\33\3\34\3\34\3\34\3\34\5\34\u011f"+
		"\n\34\5\34\u0121\n\34\3\34\3\34\3\34\3\34\5\34\u0127\n\34\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\2\2\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668\2\n\3\2\31\36\3\2\6\7\3\2\t\n\3\2\13\f\3\2\r\16\3\2"+
		")+\3\2,-\4\2\"#\61\61\u013b\2:\3\2\2\2\4@\3\2\2\2\6J\3\2\2\2\bL\3\2\2"+
		"\2\nP\3\2\2\2\fa\3\2\2\2\16e\3\2\2\2\20q\3\2\2\2\22}\3\2\2\2\24\u0089"+
		"\3\2\2\2\26\u0094\3\2\2\2\30\u009e\3\2\2\2\32\u00a4\3\2\2\2\34\u00b0\3"+
		"\2\2\2\36\u00bd\3\2\2\2 \u00bf\3\2\2\2\"\u00d1\3\2\2\2$\u00d8\3\2\2\2"+
		"&\u00da\3\2\2\2(\u00e4\3\2\2\2*\u00ed\3\2\2\2,\u00f4\3\2\2\2.\u0100\3"+
		"\2\2\2\60\u0102\3\2\2\2\62\u0104\3\2\2\2\64\u010e\3\2\2\2\66\u0126\3\2"+
		"\2\28\u0128\3\2\2\2:;\5\4\3\2;\3\3\2\2\2<?\5\f\7\2=?\5\6\4\2><\3\2\2\2"+
		">=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\5\3\2\2\2B@\3\2\2\2CK\5\b\5"+
		"\2DK\5\n\6\2EK\5\20\t\2FK\5\22\n\2GK\5\24\13\2HK\5\26\f\2IK\5\16\b\2J"+
		"C\3\2\2\2JD\3\2\2\2JE\3\2\2\2JF\3\2\2\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2"+
		"K\7\3\2\2\2LM\7&\2\2MN\5\4\3\2NO\7\'\2\2O\t\3\2\2\2PR\7\26\2\2QS\7\27"+
		"\2\2RQ\3\2\2\2RS\3\2\2\2ST\3\2\2\2TU\7\"\2\2UW\7$\2\2VX\5*\26\2WV\3\2"+
		"\2\2WX\3\2\2\2XY\3\2\2\2YZ\7%\2\2Z[\7&\2\2[\\\5\4\3\2\\]\7\'\2\2]\13\3"+
		"\2\2\2^b\5 \21\2_b\5\"\22\2`b\5&\24\2a^\3\2\2\2a_\3\2\2\2a`\3\2\2\2bc"+
		"\3\2\2\2cd\7(\2\2d\r\3\2\2\2ef\7\30\2\2fj\t\2\2\2gi\5$\23\2hg\3\2\2\2"+
		"il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7&\2\2no\5\4\3\2"+
		"op\7\'\2\2p\17\3\2\2\2qr\7\4\2\2rs\5\32\16\2st\7&\2\2tu\5\4\3\2u{\7\'"+
		"\2\2vw\7\5\2\2wx\7&\2\2xy\5\4\3\2yz\7\'\2\2z|\3\2\2\2{v\3\2\2\2{|\3\2"+
		"\2\2|\21\3\2\2\2}~\7\24\2\2~\177\7$\2\2\177\u0080\5\"\22\2\u0080\u0081"+
		"\7(\2\2\u0081\u0082\5\34\17\2\u0082\u0083\7(\2\2\u0083\u0084\5\"\22\2"+
		"\u0084\u0085\7%\2\2\u0085\u0086\7&\2\2\u0086\u0087\5\4\3\2\u0087\u0088"+
		"\7\'\2\2\u0088\23\3\2\2\2\u0089\u008e\7\25\2\2\u008a\u008f\5\32\16\2\u008b"+
		"\u008c\7$\2\2\u008c\u008d\7\3\2\2\u008d\u008f\7%\2\2\u008e\u008a\3\2\2"+
		"\2\u008e\u008b\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091\7&\2\2\u0091\u0092"+
		"\5\4\3\2\u0092\u0093\7\'\2\2\u0093\25\3\2\2\2\u0094\u0095\7\37\2\2\u0095"+
		"\u0096\7 \2\2\u0096\u0097\7$\2\2\u0097\u0098\7\61\2\2\u0098\u0099\7%\2"+
		"\2\u0099\u009a\7&\2\2\u009a\u009b\5\4\3\2\u009b\u009c\7\'\2\2\u009c\27"+
		"\3\2\2\2\u009d\u009f\7\b\2\2\u009e\u009d\3\2\2\2\u009e\u009f\3\2\2\2\u009f"+
		"\u00a2\3\2\2\2\u00a0\u00a3\5\36\20\2\u00a1\u00a3\5\32\16\2\u00a2\u00a0"+
		"\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\31\3\2\2\2\u00a4\u00a8\7$\2\2\u00a5"+
		"\u00a6\5\30\r\2\u00a6\u00a7\t\3\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a5\3"+
		"\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\5\30\r\2\u00ab"+
		"\u00ac\7%\2\2\u00ac\33\3\2\2\2\u00ad\u00ae\5\30\r\2\u00ae\u00af\t\3\2"+
		"\2\u00af\u00b1\3\2\2\2\u00b0\u00ad\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2"+
		"\3\2\2\2\u00b2\u00b3\5\30\r\2\u00b3\35\3\2\2\2\u00b4\u00b8\5$\23\2\u00b5"+
		"\u00b9\t\4\2\2\u00b6\u00b9\t\5\2\2\u00b7\u00b9\t\6\2\2\u00b8\u00b5\3\2"+
		"\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba"+
		"\u00bb\5$\23\2\u00bb\u00be\3\2\2\2\u00bc\u00be\5 \21\2\u00bd\u00b4\3\2"+
		"\2\2\u00bd\u00bc\3\2\2\2\u00be\37\3\2\2\2\u00bf\u00c0\7\"\2\2\u00c0\u00c2"+
		"\7$\2\2\u00c1\u00c3\5.\30\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\7%\2\2\u00c5!\3\2\2\2\u00c6\u00c9\7\"\2\2\u00c7"+
		"\u00c9\58\35\2\u00c8\u00c6\3\2\2\2\u00c8\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cb\t\7\2\2\u00cb\u00d2\5$\23\2\u00cc\u00cf\7\"\2\2\u00cd"+
		"\u00cf\58\35\2\u00ce\u00cc\3\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d0\3\2"+
		"\2\2\u00d0\u00d2\t\b\2\2\u00d1\u00c8\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2"+
		"#\3\2\2\2\u00d3\u00d9\t\t\2\2\u00d4\u00d7\58\35\2\u00d5\u00d7\5\60\31"+
		"\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d3"+
		"\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9%\3\2\2\2\u00da\u00db\5(\25\2\u00db"+
		"\u00dd\7)\2\2\u00dc\u00de\7 \2\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3\2\2"+
		"\2\u00de\u00df\3\2\2\2\u00df\u00e0\7!\2\2\u00e0\u00e1\7/\2\2\u00e1\u00e2"+
		"\7\61\2\2\u00e2\u00e3\7\60\2\2\u00e3\'\3\2\2\2\u00e4\u00e5\7\"\2\2\u00e5"+
		"\u00e6\7/\2\2\u00e6\u00e7\7\60\2\2\u00e7)\3\2\2\2\u00e8\u00e9\5,\27\2"+
		"\u00e9\u00ea\7.\2\2\u00ea\u00ec\3\2\2\2\u00eb\u00e8\3\2\2\2\u00ec\u00ef"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f1\5,\27\2\u00f1+\3\2\2\2\u00f2\u00f5\7\"\2\2"+
		"\u00f3\u00f5\5(\25\2\u00f4\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5-\3"+
		"\2\2\2\u00f6\u00f7\5$\23\2\u00f7\u00f8\7.\2\2\u00f8\u00fa\3\2\2\2\u00f9"+
		"\u00f6\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2"+
		"\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\5$\23\2\u00ff"+
		"\u0101\5(\25\2\u0100\u00fb\3\2\2\2\u0100\u00ff\3\2\2\2\u0101/\3\2\2\2"+
		"\u0102\u0103\5\62\32\2\u0103\61\3\2\2\2\u0104\u010b\5\64\33\2\u0105\u0106"+
		"\7\17\2\2\u0106\u010a\5\64\33\2\u0107\u0108\7\20\2\2\u0108\u010a\5\64"+
		"\33\2\u0109\u0105\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010d\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\63\3\2\2\2\u010d\u010b\3\2\2"+
		"\2\u010e\u0117\5\66\34\2\u010f\u0110\7\21\2\2\u0110\u0116\5\66\34\2\u0111"+
		"\u0112\7\22\2\2\u0112\u0116\5\66\34\2\u0113\u0114\7\23\2\2\u0114\u0116"+
		"\5\66\34\2\u0115\u010f\3\2\2\2\u0115\u0111\3\2\2\2\u0115\u0113\3\2\2\2"+
		"\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\65"+
		"\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u0121\7\61\2\2\u011b\u0121\7\"\2\2"+
		"\u011c\u011f\58\35\2\u011d\u011f\5 \21\2\u011e\u011c\3\2\2\2\u011e\u011d"+
		"\3\2\2\2\u011f\u0121\3\2\2\2\u0120\u011a\3\2\2\2\u0120\u011b\3\2\2\2\u0120"+
		"\u011e\3\2\2\2\u0121\u0127\3\2\2\2\u0122\u0123\7$\2\2\u0123\u0124\5\62"+
		"\32\2\u0124\u0125\7%\2\2\u0125\u0127\3\2\2\2\u0126\u0120\3\2\2\2\u0126"+
		"\u0122\3\2\2\2\u0127\67\3\2\2\2\u0128\u0129\7\"\2\2\u0129\u012a\7/\2\2"+
		"\u012a\u012b\5$\23\2\u012b\u012c\7\60\2\2\u012c9\3\2\2\2#>@JRWaj{\u008e"+
		"\u009e\u00a2\u00a8\u00b0\u00b8\u00bd\u00c2\u00c8\u00ce\u00d1\u00d6\u00d8"+
		"\u00dd\u00ed\u00f4\u00fb\u0100\u0109\u010b\u0115\u0117\u011e\u0120\u0126";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}