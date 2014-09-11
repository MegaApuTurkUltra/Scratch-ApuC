/**
 * 
 */
package apu.scratch.converter;

import static apu.antlr.clike.ScratchCLikeLexer.BOOL_EQUALS;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_GT;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_LT;
import static apu.antlr.clike.ScratchCLikeLexer.BOOL_NEQUALS;
import static apu.antlr.clike.ScratchCLikeLexer.HEX_CODE;
import static apu.antlr.clike.ScratchCLikeLexer.IDENTIFIER;
import static apu.antlr.clike.ScratchCLikeLexer.NUMBER;
import static apu.antlr.clike.ScratchCLikeLexer.STRINGLITERAL;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_CLICKED;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_CLONED;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_FLAG;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_KEY;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_RECEIVE;
import static apu.antlr.clike.ScratchCLikeLexer.WHEN_SENSOR;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.json.JSONArray;
import org.json.JSONObject;

import apu.antlr.clike.ScratchCLikeLexer;
import apu.antlr.clike.ScratchCLikeParser;
import apu.antlr.clike.ScratchCLikeParser.ArrayCreateContext;
import apu.antlr.clike.ScratchCLikeParser.ArrayIdentifierContext;
import apu.antlr.clike.ScratchCLikeParser.BodyContext;
import apu.antlr.clike.ScratchCLikeParser.BracesContext;
import apu.antlr.clike.ScratchCLikeParser.ConditionAndOrContext;
import apu.antlr.clike.ScratchCLikeParser.ConditionAndOrNoPContext;
import apu.antlr.clike.ScratchCLikeParser.ConditionContext;
import apu.antlr.clike.ScratchCLikeParser.ConditionItemContext;
import apu.antlr.clike.ScratchCLikeParser.EmptyBracesContext;
import apu.antlr.clike.ScratchCLikeParser.EvalContext;
import apu.antlr.clike.ScratchCLikeParser.ForLoopContext;
import apu.antlr.clike.ScratchCLikeParser.IfElseContext;
import apu.antlr.clike.ScratchCLikeParser.LineContext;
import apu.antlr.clike.ScratchCLikeParser.MathAdditionExpContext;
import apu.antlr.clike.ScratchCLikeParser.MathAtomExpContext;
import apu.antlr.clike.ScratchCLikeParser.MathExpContext;
import apu.antlr.clike.ScratchCLikeParser.MathMultiplyExpContext;
import apu.antlr.clike.ScratchCLikeParser.MethodBodyContext;
import apu.antlr.clike.ScratchCLikeParser.MethodCallContext;
import apu.antlr.clike.ScratchCLikeParser.ParamDefContext;
import apu.antlr.clike.ScratchCLikeParser.ParamsContext;
import apu.antlr.clike.ScratchCLikeParser.ParamsDefContext;
import apu.antlr.clike.ScratchCLikeParser.RepeatSingleFrameLoopContext;
import apu.antlr.clike.ScratchCLikeParser.ReturnStatementContext;
import apu.antlr.clike.ScratchCLikeParser.VarExpContext;
import apu.antlr.clike.ScratchCLikeParser.VariableSetContext;
import apu.antlr.clike.ScratchCLikeParser.WhenDefContext;
import apu.antlr.clike.ScratchCLikeParser.WhileLoopContext;

/**
 * @author MegaApuTurkUltra
 */
public class ScratchConverter {
	public static void main(String[] args) {
		try {
			init();
		} catch (IOException e1) {
			e1.printStackTrace();
			System.err.println();
			System.err.println("Whoops! Unable to read Scratch "
					+ "definition files. Must be a bug...");
			printUsage();
		}
		if (args.length < 2) {
			printUsage();
		}
		if (args[0].equals("-help")) {
			printUsage();
		}
		File source = new File(args[0]);
		if (!source.exists()) {
			System.err.println("Your source file doesn't exist "
					+ "or you don't have the correct " + "permissions.");
			printUsage();
		}
		File dest = new File(args[1]);
		String code = null;
		try {
			code = new String(Files.readAllBytes(Paths.get(source.toURI())));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println();
			System.err
					.println("Unable to read your code file. Make sure you have "
							+ "the correct permissions.");
			printUsage();
		}
		try {
			CompileResult result = compile(code);
			if (result.errors.size() > 0) {
				System.err.println("Your code has errors:");
				for (CompileError err : result.errors) {
					System.err.println(err.toString());
				}
				printUsage();
			} else {
				try {
					writeToZip(dest, result.scripts);
					System.out.println("Compile successful!");
					System.out.println("\tCompiled " + source.getAbsolutePath()
							+ " to");
					System.out.println("\t" + dest.getAbsolutePath());
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println();
					System.err
							.println("Unable to write to destination"
									+ " file. Make sure you have the correct permissions.");
					printUsage();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println();
			System.err.println("Unable to compile your code because "
					+ "of a severe syntax error (or bug here)");
			printUsage();
		}
	}

	public static void printUsage() {
		System.err.println("Usage:\n\t"
				+ "java -jar apuc-compile.jar <source> <destination>"
				+ "\n\t\tCompiles ApuC code\n\t\tsource: The text"
				+ " file containing your source "
				+ "code\n\t\tdestination: A sprite2 or zip file to put "
				+ "the code in\n\n\tjava -jar apuc-compile.jar -help\n\t"
				+ "\tPrints this section.");
		System.exit(1);
	}

	public static void createProjectFile(File f, Map<String, JSONArray> sprites)
			throws IOException, URISyntaxException {
		JSONArray children = new JSONArray();
		int i = 1;
		for (String name : sprites.keySet()) {
			JSONObject sprite = new JSONObject(spriteBase);
			sprite.put("indexInLibrary", i);
			sprite.put("objName", name);
			sprite.put("scripts", sprites.get(name));

			i++;
			children.put(sprite);
		}

		if (!f.exists()) {
			InputStream in = ScratchConverter.class
					.getResourceAsStream("/BaseProject.sb2");
			Files.copy(in, Paths.get(f.toURI()));
			in.close();
		}

		URI uri = f.toURI();
		uri = new URI("jar:file", uri.getHost(), uri.getPath(),
				uri.getFragment());
		FileSystem fs = FileSystems.newFileSystem(uri,
				new HashMap<String, String>());
		Path json = fs.getPath("/project.json");
		JSONObject obj = new JSONObject(new String(Files.readAllBytes(json)));
		if (obj.has("children"))
			obj.remove("children");
		obj.put("children", children);
		Files.write(json, obj.toString().getBytes(), StandardOpenOption.WRITE,
				StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.SYNC);
		fs.close();
	}

	public static void writeToZip(File f, JSONArray code) throws IOException,
			URISyntaxException {
		if (!f.exists()) {
			InputStream in = ScratchConverter.class
					.getResourceAsStream("/Sprite1.sprite2");
			Files.copy(in, Paths.get(f.toURI()));
			in.close();
		}

		URI uri = f.toURI();
		uri = new URI("jar:file", uri.getHost(), uri.getPath(),
				uri.getFragment());
		FileSystem fs = FileSystems.newFileSystem(uri,
				new HashMap<String, String>());
		Path sprite = fs.getPath("/sprite.json");
		JSONObject obj = new JSONObject(new String(Files.readAllBytes(sprite)));
		if (obj.has("scripts"))
			obj.remove("scripts");
		obj.put("scripts", code);
		Files.write(sprite, obj.toString().getBytes(),
				StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING,
				StandardOpenOption.SYNC);
		fs.close();
	}

	static class Method {
		String identifier;
		String scratchName;
		String desc;
		int numParams;
		List<String> paramNames = new ArrayList<String>();

		public String toString() {
			StringBuffer buf = new StringBuffer();
			buf.append("Method[");
			buf.append(identifier);
			buf.append(", ");
			buf.append(numParams);
			buf.append(", ");
			buf.append(desc);
			buf.append("]");
			return buf.toString();
		}
	}

	static class MethodCall {
		JSONArray call;
		Method calledMethod;
		JSONArray returnVal;

		public MethodCall(JSONArray call, JSONArray returnVal,
				Method calledMethod) {
			super();
			this.call = call;
			this.returnVal = returnVal;
			this.calledMethod = calledMethod;
		}
	}

	static class When {
		static List<Integer> usedIds = new ArrayList<>();
		static Random random = new Random();
		int uid;

		public When() {
			do {
				uid = Math.abs(random.nextInt());
			} while (usedIds.contains(uid));
			usedIds.add(uid);
		}

		public String getReturnStackName() {
			return "returnStack" + uid;
		}
	}

	static class Context {
		static List<Integer> usedIds = new ArrayList<>();
		static List<Integer> usedReturnIds = new ArrayList<>();
		static Random random = new Random();

		static Map<String, String> builtInMath = new HashMap<>();
		static {
			builtInMath.put("abs", "abs");
			builtInMath.put("floor", "floor");
			builtInMath.put("ceiling", "ceiling");
			builtInMath.put("sqrt", "sqrt");
			builtInMath.put("sin", "sin");
			builtInMath.put("cos", "cos");
			builtInMath.put("tan", "tan");
			builtInMath.put("asin", "asin");
			builtInMath.put("acos", "acos");
			builtInMath.put("atan", "atan");
			builtInMath.put("ln", "ln");
			builtInMath.put("log", "log");
			builtInMath.put("powe", "e ^");
			builtInMath.put("pow10", "10 ^");
		}

		static Stack<MethodCall> methodCalls = new Stack<MethodCall>();

		int uid;
		Context parent;
		List<String> variables = new ArrayList<String>();
		List<Context> children = new ArrayList<Context>();
		Method belongsTo = null;

		public Context(Context parent) {
			this.parent = parent;
			if (parent != null)
				parent.children.add(this);
			do {
				uid = Math.abs(random.nextInt());
			} while (usedIds.contains(uid));
			usedIds.add(uid);
		}

		public boolean hasVar(String name) {
			System.out.println(uid + " " + name + " "
					+ variables.contains(name));
			return variables.contains(name);
		}

		public boolean parentHasVar(String name) {
			System.out.println("new parenthasvar");
			if (parent == null)
				return false;
			else
				return parent._parentHasVar0(name);
		}

		private boolean _parentHasVar0(String name) {
			if (parent != null) {
				return variables.contains(name) || parent._parentHasVar0(name);
			} else {
				return variables.contains(name);
			}
		}

		public String getLocalVarName(String name) {
			return name + uid;
		}

		public String getNonLocalVarName(String name) {
			if (parent != null)
				return parent._applyVarName0(name);
			else
				return name;
		}

		private String _applyVarName0(String name) {
			if (hasVar(name)) {
				return getLocalVarName(name);
			}
			if (parent != null) {
				return parent._applyVarName0(name);
			} else {
				return name;
			}
		}

		// public static String getUniqueReturnVar() {
		// int returnUid;
		// do {
		// returnUid = Math.abs(random.nextInt());
		// } while (usedReturnIds.contains(returnUid));
		// usedReturnIds.add(returnUid);
		// return "return" + returnUid;
		// }
	}

	static Map<String, Method> methods = new HashMap<>();

	static List<CompileError> errors = new ArrayList<>();

	static JSONArray root = new JSONArray();

	static List<JSONArray> methodDefs = new ArrayList<JSONArray>();

	static JSONArray current;
	static Stack<JSONArray> stack = new Stack<>();

	static Context currentContext;
	static Stack<Context> contexts = new Stack<>();

	static When currentWhen;
	static Stack<When> whens = new Stack<>();

	static String spriteBase = "";

	private static Map<String, Method> builtInMethods = new HashMap<>();

	static class CompileError {
		int position;
		int endPosition;
		int line;
		int positionInLine;
		String message;

		public CompileError(int position, int line, int positionInLine,
				String message) {
			this(position, position + 1, line, positionInLine, message);
		}

		public CompileError(int position, int endPosition, int line,
				int positionInLine, String message) {
			this.position = position;
			this.endPosition = endPosition;
			this.line = line;
			this.positionInLine = positionInLine;
			this.message = message;
		}

		public String toString() {
			StringBuilder b = new StringBuilder();
			b.append(line);
			b.append(":");
			b.append(positionInLine);
			b.append(" (");
			b.append(position);
			b.append("-");
			b.append(endPosition);
			b.append("): ");
			b.append(message);
			return b.toString();
		}
	}

	static class CompileResult {
		JSONArray scripts;
		List<CompileError> errors;
	}

	public static void init() throws IOException {
		Reader base = new InputStreamReader(
				ScratchConverter.class.getResourceAsStream("/BaseSprite.json"));
		char[] c = new char[128];
		int len;
		StringBuilder sb = new StringBuilder();
		while ((len = base.read(c)) != -1) {
			sb.append(c, 0, len);
		}
		spriteBase = sb.toString();
		base.close();

		BufferedReader in = new BufferedReader(new InputStreamReader(
				ScratchConverter.class.getResourceAsStream("/builtin.csv")));
		String line;
		in.readLine(); // skip header
		while ((line = in.readLine()) != null) {
			String[] split = line.split(",");
			String name = split[0];
			String scratchName = split[1];
			String desc = split[2];

			Method m = new Method();
			m.identifier = name;

			m.desc = desc;
			m.scratchName = scratchName;
			builtInMethods.put(m.identifier, m);

			int lastIndex = 0;
			while (lastIndex != -1) {
				lastIndex = desc.indexOf("()", lastIndex);
				if (lastIndex != -1) {
					m.numParams++;
					lastIndex += 2;
				}
			}
		}
		System.out.println("Done");
	}

	/**
	 * Compiles code and returns a {@link CompileResult}<br/>
	 * NOTE: NOT thread safe
	 * 
	 * @param code
	 *            The code to compile
	 * @return The result
	 * @throws Exception
	 *             If a serious syntax error happens
	 */
	public static CompileResult compile(final String code) throws Exception {
		System.out.println("Compiling...");
		methods.clear();
		errors.clear();
		root = new JSONArray();
		methodDefs.clear();
		current = null;
		stack.clear();
		currentContext = null;
		contexts.clear();
		whens.clear();
		currentWhen = null;

		methods.putAll(builtInMethods);

		root.put(10).put(10);
		current = new JSONArray();
		root.put(current);
		current.put(new JSONArray("['whenGreenFlag']"));
		// System.out.println(root.toString());

		final ScratchCLikeLexer lexer = new ScratchCLikeLexer(null);
		final ScratchCLikeParser parser = new ScratchCLikeParser(null);

		ANTLRInputStream input = new ANTLRInputStream(new StringReader(code));
		lexer.removeErrorListeners();
		lexer.setInputStream(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		parser.removeErrorListeners();
		parser.addErrorListener(new BaseErrorListener() {
			@Override
			public void syntaxError(Recognizer<?, ?> recognizer,
					Object offendingSymbol, int line, int charPositionInLine,
					String msg, RecognitionException e) {
				int pos = 0;
				int counter = 1;
				while (counter < line) {
					if (code.charAt(pos) == '\n')
						counter++;
					pos++;
				}
				pos--;
				pos += charPositionInLine;
				CompileError error = new CompileError(pos, line - 1,
						charPositionInLine, msg);
				if (e != null && e.getOffendingToken() != null) {
					error.position = e.getOffendingToken().getStopIndex();
					error.endPosition = e.getOffendingToken().getStopIndex();
				}
				errors.add(error);
			}
		});
		parser.setBuildParseTree(true);

		parser.setTokenStream(tokens);

		EvalContext main = parser.eval();

		methodPass(main.body());

		currentContext = new Context(null);

		currentWhen = new When();

		parseBody(main.body());
		// for (CompileError s : errors)
		// System.err.println(s.line + ":" + s.positionInLine + s.message);

		JSONArray arr = new JSONArray();
		arr.put(root);
		for (JSONArray a : methodDefs)
			arr.put(a);
		// System.out.println(arr.toString());
		CompileResult result = new CompileResult();
		result.scripts = arr;
		result.errors = new ArrayList<>(errors);

		parseContexts(currentContext, "");

		return result;
	}

	static void parseContexts(Context c, String d) {
		System.out.print(d + c.uid);
		for (String s : c.variables) {
			System.out.print(" " + s);
		}
		System.out.println();
		for (Context c2 : c.children) {
			parseContexts(c2, d + "\t");
		}
	}

	static void pushWhen() {
		When when = new When();
		whens.push(currentWhen);
		currentWhen = when;
	}

	static void popWhen() {
		currentWhen = whens.pop();
	}

	static void pushContext() {
		contexts.push(currentContext);
		Context current = currentContext;
		currentContext = new Context(current);
		currentContext.belongsTo = current.belongsTo;
	}

	static void popContext() {
		currentContext = contexts.pop();
	}

	static JSONArray newJsonArray(Object... objects) {
		return new JSONArray(objects);
	}

	static void pushCurrent(JSONArray newArray) {
		stack.push(current);
		current.put(newArray);
		current = newArray;
	}

	static JSONArray popCurrent() {
		JSONArray old = current;
		current = stack.pop();
		return old;
	}

	static void log(Object... log) {
		// for (int i = 0; i < Thread.currentThread().getStackTrace().length -
		// 4; i++) {
		// System.out.print("    ");
		// }
		// for (Object o : log) {
		// if (o.getClass() != String.class) {
		// System.out.print(o.getClass().getSimpleName());
		// System.out.print("(");
		// System.out.print(o.toString());
		// System.out.print(")");
		// } else {
		// System.out.print(o.toString());
		// }
		// System.out.print(" ");
		// }
		// System.out.println();
	}

	static void methodPass(BodyContext body) {
		if (body == null || body.children == null || body.children.size() == 0)
			return;
		for (ParseTree tree : body.children) {
			if (tree instanceof BracesContext) {
				BracesContext braces = (BracesContext) tree;
				MethodBodyContext method;
				IfElseContext ifElse;
				ForLoopContext forLoop;
				WhileLoopContext whileLoop;
				if ((method = braces.methodBody()) != null) {
					String identifier = method.IDENTIFIER().getText();
					if (methods.containsKey(identifier)) {
						Token start = method.getStart();
						errors.add(new CompileError(start.getStartIndex(),
								start.getStopIndex(), start.getLine(), start
										.getCharPositionInLine(),
								"Duplicate method: " + identifier));
					}
					Method m = new Method();
					methods.put(identifier, m);
					m.identifier = identifier;
					m.desc = "User defined";
					m.numParams = 1;
					ParamsDefContext paramsDef = method.paramsDef();
					if (paramsDef != null) {
						List<ParamDefContext> paramDefs = paramsDef.paramDef();
						m.numParams = paramDefs.size() + 1;
						for (ParamDefContext param : paramDefs) {
							String pIdentifier = param.IDENTIFIER().getText();
							if (m.paramNames.contains(pIdentifier)) {
								Token start = param.getStart();
								errors.add(new CompileError(start
										.getStartIndex(), start.getStopIndex(),
										start.getLine(), start
												.getCharPositionInLine(),
										"Duplicate parameter: " + pIdentifier
												+ " in method " + identifier));
							} else {
								m.paramNames.add(pIdentifier);
							}
						}
					}
					methodPass(method.body());
				}
				if ((ifElse = braces.ifElse()) != null) {
					for (BodyContext body2 : ifElse.body())
						methodPass(body2);
				}
				if ((whileLoop = braces.whileLoop()) != null) {
					methodPass(whileLoop.body());
				}
				if ((forLoop = braces.forLoop()) != null) {
					methodPass(forLoop.body());
				}
			}
		}
	}

	static void parseBody(BodyContext body) {
		log("Body");
		if (body == null || body.children == null || body.children.size() == 0)
			return;
		for (ParseTree tree : body.children) {
			if (tree instanceof BracesContext)
				parseBraces((BracesContext) tree);
			else if (tree instanceof LineContext)
				parseLine((LineContext) tree);
		}
	}

	static void parseLine(LineContext line) {
		VariableSetContext varSet;
		MethodCallContext methodCall;
		ArrayCreateContext arrayCreate;
		ReturnStatementContext returnSt;
		if ((varSet = line.variableSet()) != null) {
			parseVariableSet(varSet);
		}
		if ((methodCall = line.methodCall()) != null) {
			parseMethodCall(methodCall, false);
		}
		if ((arrayCreate = line.arrayCreate()) != null) {
			parseArrayCreate(arrayCreate);
		}
		if ((returnSt = line.returnStatement()) != null) {
			parseReturnStatement(returnSt);
		}
		int size = Context.methodCalls.size();
		int size2 = size;
		Object returnStackName = currentWhen.getReturnStackName();
		if (currentContext.belongsTo != null) {
			returnStackName = newJsonArray("getParam", "returnStackName", "r");
		}
		while (Context.methodCalls.size() > 0) {
			MethodCall call = Context.methodCalls.pop();
			Object o = current.get(current.length() - 1);
			current.put(current.length() - 1, call.call);
			current.put(o);
			call.returnVal.put("getLine:ofList:");
			call.returnVal
					.put(newJsonArray("-",
							newJsonArray("lineCountOfList:", returnStackName),
							size - 1));
			size--;
			call.returnVal.put(returnStackName);
		}
		for (int i = 0; i < size2; i++) {
			pushCurrent(newJsonArray(
					"deleteLine:ofList:",
					returnSt == null ? "last" : newJsonArray("-",
							newJsonArray("lineCountOfList:", returnStackName),
							1), returnStackName));
			popCurrent();
		}
		if (returnSt != null) {
			pushCurrent(newJsonArray("stopScripts", "this script"));
			popCurrent();
		}
	}

	static void parseReturnStatement(ReturnStatementContext returnSt) {
		if (currentContext.belongsTo == null) {
			Token start = returnSt.getStart();
			errors.add(new CompileError(start.getStartIndex(), start
					.getStopIndex(), start.getLine(), start
					.getCharPositionInLine(),
					"Return is not allowed outside of a method"));
			return;
		}
		if (returnSt.varExp() != null) {
			pushCurrent(newJsonArray("append:toList:"));
			parseVarExp(returnSt.varExp());
			current.put(newJsonArray("getParam", "returnStackName", "r"));
			popCurrent();
		}
	}

	static void parseArrayCreate(ArrayCreateContext arrayCreate) {
		String identifier = arrayCreate.arrayDef().IDENTIFIER().getText();

		if (currentContext.belongsTo != null
				&& currentContext.belongsTo.paramNames.contains(identifier)) {
			Token start = arrayCreate.getStart();
			errors.add(new CompileError(start.getStartIndex(), start
					.getStopIndex(), start.getLine(), start
					.getCharPositionInLine(),
					"Setting a parameter is not allowed: " + identifier));
		} else {
			if (currentContext.hasVar(identifier)) {
				identifier = currentContext.getLocalVarName(identifier);
			} else if (currentContext.parentHasVar(identifier)) {
				identifier = currentContext.getNonLocalVarName(identifier);
			} else {
				currentContext.variables.add(identifier);
				identifier = currentContext.getLocalVarName(identifier);
			}
		}

		int size = Integer.parseInt(arrayCreate.NUMBER().getText());
		log("ArrayCreate", identifier, size);
		pushCurrent(new JSONArray("[\"deleteLine:ofList:\", \"all\", \""
				+ identifier + "\"]"));
		popCurrent();
		if (arrayCreate.SINGLE_FRAME_TAG() != null) {
			for (int i = 0; i < size; i++) {
				pushCurrent(new JSONArray("[\"append:toList:\", \"0\", \""
						+ identifier + "\"]"));
				popCurrent();
			}
		} else {
			pushCurrent(new JSONArray("[\"doRepeat\", " + size + ", ["
					+ "[\"append:toList:\", \"0\", \"" + identifier + "\"]]]"));
			popCurrent();
		}
	}

	static void parseMethodCall(MethodCallContext methodCall,
			boolean needsReturnVal) {
		String identifier = methodCall.IDENTIFIER().getText();

		if (identifier.equals("length")) {
			ParamsContext params = methodCall.params();
			if (params == null || params.arrayDef() == null) {
				Token start = (Token) methodCall.IDENTIFIER().getPayload();
				errors.add(new CompileError(start.getStartIndex(), start
						.getStopIndex(), start.getLine(), start
						.getCharPositionInLine(),
						"length needs an array parameter: " + identifier));
				return;
			}
			String arrayId = params.arrayDef().IDENTIFIER().getText();

			if (currentContext.belongsTo != null
					&& currentContext.belongsTo.paramNames.contains(arrayId)) {
				Token start = params.arrayDef().getStart();
				errors.add(new CompileError(start.getStartIndex(), start
						.getStopIndex(), start.getLine(), start
						.getCharPositionInLine(),
						"Array paramaters are not allowed: " + arrayId));
			} else {
				if (currentContext.hasVar(arrayId)) {
					arrayId = currentContext.getLocalVarName(arrayId);
				} else if (currentContext.parentHasVar(arrayId)) {
					arrayId = currentContext.getNonLocalVarName(arrayId);
				} else {
					Token start = params.arrayDef().getStart();
					errors.add(new CompileError(start.getStartIndex(), start
							.getStopIndex(), start.getLine(), start
							.getCharPositionInLine(), arrayId
							+ " has not been set yet in this context"));
					currentContext.variables.add(arrayId);
					arrayId = currentContext.getLocalVarName(arrayId);
				}
			}

			pushCurrent(newJsonArray("lineCountOfList:"));
			current.put(arrayId);
			popCurrent();
			return;
		}

		if (Context.builtInMath.containsKey(identifier)) {
			if (methodCall.params() == null
					|| methodCall.params().varExp().size() != 1) {
				Token start = methodCall.getStart();
				errors.add(new CompileError(start.getStartIndex(), start
						.getStopIndex(), start.getLine(), start
						.getCharPositionInLine(),
						"Built in math functions require exactly 1 parameter: "
								+ identifier));
				return;
			}
			pushCurrent(newJsonArray("computeFunction:of:",
					Context.builtInMath.get(identifier)));
			parseVarExp(methodCall.params().varExp(0));
			popCurrent();
			return;
		}

		String status = "Custom";
		boolean isBuiltin = false;
		Method m;
		if (methods.containsKey(identifier)) {
			m = methods.get(identifier);
			if (m.scratchName != null) {
				status = "Built in: " + m.scratchName;
				isBuiltin = true;
			}
		} else {
			Token start = methodCall.getStart();
			errors.add(new CompileError(start.getStartIndex(), start
					.getStopIndex(), start.getLine(), start
					.getCharPositionInLine(), "Method does not exist: "
					+ identifier));
			return;
		}

		log("MethodCall", identifier, status);

		StringBuilder name = new StringBuilder(identifier);
		if (isBuiltin) {
			pushCurrent(newJsonArray(m.scratchName));
		} else {
			for (int i = 0; i < m.numParams; i++) {
				name.append(" %s"); // because string input works for everything
				// also laziness
			}
			if (needsReturnVal) {
				JSONArray callJson = newJsonArray("call", name.toString());
				JSONArray returnVal = newJsonArray();
				MethodCall call = new MethodCall(callJson, returnVal, m);
				pushCurrent(returnVal);
				popCurrent();
				stack.push(current);
				current = callJson;
				Context.methodCalls.push(call);
			} else
				pushCurrent(newJsonArray("call", name.toString()));
		}

		ParamsContext params = methodCall.params();
		if (params != null) {
			List<VarExpContext> varExps = params.varExp();
			for (VarExpContext varExp : varExps) {
				parseVarExp(varExp);
			}
		}
		if (!isBuiltin) {
			Object returnStackName = currentWhen.getReturnStackName();
			if (currentContext.belongsTo != null) {
				returnStackName = newJsonArray("getParam", "returnStackName",
						"r");
			}
			current.put(returnStackName);
		}
		popCurrent();
	}

	static void parseVariableSet(VariableSetContext varSet) {
		String identifier;

		ArrayIdentifierContext arrayId = null;
		if (varSet.IDENTIFIER() != null) {
			identifier = varSet.IDENTIFIER().getText();
			log("VarSet", identifier);
		} else {
			arrayId = varSet.arrayIdentifier();
			identifier = arrayId.IDENTIFIER().getText();
			log("ArraySet", identifier);
		}

		if (currentContext.belongsTo != null
				&& currentContext.belongsTo.paramNames.contains(identifier)) {
			Token start = varSet.getStart();
			errors.add(new CompileError(start.getStartIndex(), start
					.getStopIndex(), start.getLine(), start
					.getCharPositionInLine(),
					"Setting parameters is not allowed: " + identifier));
		} else {
			if (currentContext.hasVar(identifier)) {
				identifier = currentContext.getLocalVarName(identifier);
			} else if (currentContext.parentHasVar(identifier)) {
				identifier = currentContext.getNonLocalVarName(identifier);
			} else {
				currentContext.variables.add(identifier);
				identifier = currentContext.getLocalVarName(identifier);
			}
		}

		if (varSet.PLUS_PLUS() != null) {
			if (varSet.IDENTIFIER() != null) {
				pushCurrent(newJsonArray("setVar:to:", identifier));
				pushCurrent(newJsonArray("+",
						newJsonArray("readVariable", identifier), 1));
				popCurrent();
				popCurrent();
			} else {
				pushCurrent(newJsonArray("setLine:ofList:to:"));
				pushCurrent(newJsonArray("+", "1"));
				parseVarExp(arrayId.varExp());
				popCurrent();
				current.put(identifier);
				pushCurrent(newJsonArray("+"));
				pushCurrent(newJsonArray("getLine:ofList:"));
				pushCurrent(newJsonArray("+", "1"));
				parseVarExp(arrayId.varExp());
				popCurrent();
				current.put(identifier);
				popCurrent();
				current.put(1);
				popCurrent();
				popCurrent();
			}
		} else if (varSet.MINUS_MINUS() != null) {
			if (varSet.IDENTIFIER() != null) {
				pushCurrent(newJsonArray("setVar:to:", identifier));
				pushCurrent(newJsonArray("-",
						newJsonArray("readVariable", identifier), 1));
				popCurrent();
				popCurrent();
			} else {
				pushCurrent(newJsonArray("setLine:ofList:to:"));
				pushCurrent(newJsonArray("+", "1"));
				parseVarExp(arrayId.varExp());
				popCurrent();
				current.put(identifier);
				pushCurrent(newJsonArray("-"));
				pushCurrent(newJsonArray("getLine:ofList:"));
				pushCurrent(newJsonArray("+", "1"));
				parseVarExp(arrayId.varExp());
				popCurrent();
				current.put(identifier);
				popCurrent();
				current.put(1);
				popCurrent();
				popCurrent();
			}
		} else if (varSet.PLUS_EQUALS() != null) {
			if (varSet.IDENTIFIER() != null) {
				pushCurrent(newJsonArray("setVar:to:", identifier));
				pushCurrent(newJsonArray("+",
						newJsonArray("readVariable", identifier)));
				parseVarExp(varSet.varExp());
				popCurrent();
				popCurrent();
			} else {
				pushCurrent(newJsonArray("setLine:ofList:to:"));
				pushCurrent(newJsonArray("+", "1"));
				parseVarExp(arrayId.varExp());
				popCurrent();
				current.put(identifier);
				pushCurrent(newJsonArray("+"));
				pushCurrent(newJsonArray("getLine:ofList:"));
				pushCurrent(newJsonArray("+", "1"));
				parseVarExp(arrayId.varExp());
				popCurrent();
				current.put(identifier);
				popCurrent();
				parseVarExp(varSet.varExp());
				popCurrent();
				popCurrent();
			}
		} else if (varSet.MINUS_EQUALS() != null) {
			if (varSet.IDENTIFIER() != null) {
				pushCurrent(newJsonArray("setVar:to:", identifier));
				pushCurrent(newJsonArray("-",
						newJsonArray("readVariable", identifier)));
				parseVarExp(varSet.varExp());
				popCurrent();
				popCurrent();
			} else {
				pushCurrent(newJsonArray("setLine:ofList:to:"));
				pushCurrent(newJsonArray("+", "1"));
				parseVarExp(arrayId.varExp());
				popCurrent();
				current.put(identifier);
				pushCurrent(newJsonArray("-"));
				pushCurrent(newJsonArray("getLine:ofList:"));
				pushCurrent(newJsonArray("+", "1"));
				parseVarExp(arrayId.varExp());
				popCurrent();
				current.put(identifier);
				popCurrent();
				parseVarExp(varSet.varExp());
				popCurrent();
				popCurrent();
			}
		} else {
			if (varSet.IDENTIFIER() != null) {
				pushCurrent(newJsonArray("setVar:to:", identifier));
				parseVarExp(varSet.varExp());
				popCurrent();
			} else {
				pushCurrent(newJsonArray("setLine:ofList:to:"));
				pushCurrent(newJsonArray("+", "1"));
				parseVarExp(arrayId.varExp());
				popCurrent();
				current.put(identifier);
				parseVarExp(varSet.varExp());
				popCurrent();
			}
		}

	}

	static void parseBraces(BracesContext braces) {
		EmptyBracesContext empty = braces.emptyBraces();
		if (empty != null) {
			pushContext();
			parseBody(empty.body());
			popContext();
			return;
		}

		WhenDefContext when = braces.whenDef();
		if (when != null) {
			parseWhen(when);
			return;
		}

		MethodBodyContext method;
		IfElseContext ifElse;
		ForLoopContext forLoop;
		WhileLoopContext whileLoop;
		RepeatSingleFrameLoopContext repeatLoop;
		if ((method = braces.methodBody()) != null) {
			parseMethod(method);
		}
		if ((ifElse = braces.ifElse()) != null) {
			parseIfElse(ifElse);
		}
		if ((whileLoop = braces.whileLoop()) != null) {
			parseWhileLoop(whileLoop);
		}
		if ((forLoop = braces.forLoop()) != null) {
			parseForLoop(forLoop);
		}
		if ((repeatLoop = braces.repeatSingleFrameLoop()) != null) {
			parseRepeatLoop(repeatLoop);
		}
	}

	static void parseWhen(WhenDefContext when) {
		pushWhen();
		JSONArray methodArr = new JSONArray();
		methodArr.put(10).put(10);
		JSONArray scripts = new JSONArray();
		methodArr.put(scripts);
		JSONArray header = new JSONArray();
		scripts.put(header);

		switch (((Token) when.children.get(1).getPayload()).getType()) {
		case WHEN_CLICKED:
			header.put("whenClicked");
			break;
		case WHEN_RECEIVE:
			header.put("whenIReceive");
			break;
		case WHEN_KEY:
			header.put("whenKeyPressed");
			break;
		case WHEN_CLONED:
			header.put("whenCloned");
			break;
		case WHEN_SENSOR:
			header.put("whenSensorGreaterThan");
			break;
		case WHEN_FLAG:
		default:
			header.put("whenGreenFlag");
			break;
		}
		stack.push(current);
		current = header;

		for (VarExpContext varExp : when.varExp()) {
			parseVarExp(varExp);
		}

		current = stack.pop();
		stack.push(current);
		current = scripts;

		pushContext();
		currentContext.belongsTo = null;
		parseBody(when.body());
		popContext();

		methodDefs.add(methodArr);
		current = stack.pop();
		popWhen();
	}

	static void parseRepeatLoop(RepeatSingleFrameLoopContext repeat) {
		int times = Integer.parseInt(repeat.NUMBER().getText());
		pushContext();
		for (int i = 0; i < times; i++) {
			parseBody(repeat.body());
		}
		popContext();
	}

	static void parseForLoop(ForLoopContext forLoop) {
		VariableSetContext initial = forLoop.variableSet(0), increment = forLoop
				.variableSet(1);
		log("ForLoop");

		String initialId = initial.IDENTIFIER().getText();

		pushContext();
		if (!currentContext.parentHasVar(initialId))
			currentContext.variables.add(initialId);

		parseVariableSet(initial);
		pushCurrent(newJsonArray("doUntil"));
		pushCurrent(newJsonArray("not"));
		parseConditionAndOrNoP(forLoop.conditionAndOrNoP());
		popCurrent();
		pushCurrent(newJsonArray());

		parseBody(forLoop.body());
		parseVariableSet(increment);

		popContext();

		popCurrent();
		popCurrent();
	}

	static void parseWhileLoop(WhileLoopContext whileLoop) {
		if (whileLoop.BOOL_TRUE() != null) {
			pushCurrent(newJsonArray("doForever"));
			log("Forever");
		} else {
			log("WhileLoop");
			pushCurrent(newJsonArray("doUntil"));
			pushCurrent(newJsonArray("not"));
			parseConditionAndOr(whileLoop.conditionAndOr());
			popCurrent();
		}
		pushCurrent(newJsonArray());

		pushContext();

		parseBody(whileLoop.body());

		popContext();

		popCurrent();
		popCurrent();
	}

	static void parseIfElse(IfElseContext ifElse) {
		List<BodyContext> bodies = ifElse.body();
		boolean ifOnly = bodies.size() == 1;
		if (ifOnly) {
			log("If");
			pushCurrent(newJsonArray("doIf"));
		} else {
			log("IfElse");
			pushCurrent(newJsonArray("doIfElse"));
		}
		parseConditionAndOr(ifElse.conditionAndOr());
		pushCurrent(newJsonArray());

		pushContext();

		parseBody(bodies.get(0));

		popContext();

		popCurrent();
		if (!ifOnly) {
			pushCurrent(newJsonArray());

			pushContext();

			parseBody(bodies.get(1));

			popContext();
			popCurrent();
		}
		popCurrent();
	}

	static void parseConditionAndOrNoP(ConditionAndOrNoPContext andOr) {
		parseConditionItems(andOr.conditionItem(), andOr.BOOL_AND(),
				andOr.BOOL_OR());
	}

	static void parseConditionAndOr(ConditionAndOrContext andOr) {
		if (andOr == null)
			return;
		parseConditionItems(andOr.conditionItem(), andOr.BOOL_AND(),
				andOr.BOOL_OR());
	}

	static void parseConditionItems(List<ConditionItemContext> items,
			TerminalNode boolAnd, TerminalNode boolOr) {
		log("ConditionItems");
		if (items.size() > 1) {
			if (boolAnd != null) {
				log("AND");
				pushCurrent(newJsonArray("&"));
			} else {
				log("OR");
				pushCurrent(newJsonArray("|"));
			}
			for (ConditionItemContext item : items)
				parseConditionItem(item);
			popCurrent();
		} else {
			parseConditionItem(items.get(0));
		}
	}

	static void parseConditionItem(ConditionItemContext item) {
		if (item.BOOL_NOT() != null) {
			log("NOT");
			pushCurrent(newJsonArray("not"));
		}
		ConditionAndOrContext andOr = item.conditionAndOr();
		if (andOr != null) {
			parseConditionAndOr(andOr);
		} else {
			ConditionContext condition = item.condition();

			MethodCallContext methodCall = condition.methodCall();
			if (methodCall != null) {
				parseMethodCall(methodCall, true);
				return;
			}

			List<VarExpContext> varExps = condition.varExp();
			if (condition.BOOL_GTE() != null) {
				log("GTE");
				pushCurrent(newJsonArray("|"));
				pushCurrent(newJsonArray("="));
				parseVarExp(varExps.get(0));
				parseVarExp(varExps.get(1));
				popCurrent();
				pushCurrent(newJsonArray(">"));
				parseVarExp(varExps.get(0));
				parseVarExp(varExps.get(1));
				popCurrent();
				popCurrent();
			} else if (condition.BOOL_LTE() != null) {
				log("LTE");
				pushCurrent(newJsonArray("|"));
				pushCurrent(newJsonArray("="));
				parseVarExp(varExps.get(0));
				parseVarExp(varExps.get(1));
				popCurrent();
				pushCurrent(newJsonArray("<"));
				parseVarExp(varExps.get(0));
				parseVarExp(varExps.get(1));
				popCurrent();
				popCurrent();
			} else {
				ParseTree op = condition.children.get(1);
				int opType = ((Token) op.getPayload()).getType();
				if (opType == BOOL_EQUALS) {
					log("EQUALS");
					pushCurrent(newJsonArray("="));
				} else if (opType == BOOL_NEQUALS) {
					log("NEQUALS");
					pushCurrent(newJsonArray("not"));
					pushCurrent(newJsonArray("="));
				} else if (opType == BOOL_GT) {
					log("GT");
					pushCurrent(newJsonArray(">"));
				} else if (opType == BOOL_LT) {
					log("LT");
					pushCurrent(newJsonArray("<"));
				}
				parseVarExp(condition.varExp(0));
				parseVarExp(condition.varExp(1));
				if (opType == BOOL_NEQUALS) {
					popCurrent();
					popCurrent();
				} else {
					popCurrent();
				}
			}
		}
		if (item.BOOL_NOT() != null)
			popCurrent();
	}

	static void parseVarExp(VarExpContext varExp) {
		log("VarExp");
		ParseTree exp = varExp.getChild(0);
		Object payload = exp.getPayload();
		if (payload instanceof Token) {
			Token token = ((Token) payload);
			int type = token.getType();
			if (type == NUMBER)
				parseNumber((TerminalNode) exp);
			else if (type == STRINGLITERAL)
				parseStringLiteral((TerminalNode) exp);
			else if (type == IDENTIFIER)
				parseVariable((TerminalNode) exp);
			else if (type == HEX_CODE) {
				current.put(Integer.decode(exp.getText()));
			}
		} else {
			MathExpContext mathExp = varExp.mathExp();
			if (mathExp != null)
				parseMathExp(varExp.mathExp());
			else
				parseArrayItem(varExp.arrayIdentifier());
		}
	}

	static void parseMathExp(MathExpContext mathExp) {
		log("MathExp");
		parseMathAdditionExp(mathExp.mathAdditionExp());
	}

	static void parseMathAdditionExp(MathAdditionExpContext mathAdd) {
		log("AdditionExp");
		LinkedList<ParseTree> items = new LinkedList<ParseTree>(
				mathAdd.children);
		if (items.size() == 1) {
			parseMathMultiplyExp((MathMultiplyExpContext) items.get(0)
					.getPayload());
			return;
		}
		JSONArray beforeC = current;
		List<JSONArray> myOps = new ArrayList<>();

		while (items.size() > 1) {
			MathMultiplyExpContext add = (MathMultiplyExpContext) items
					.removeLast().getPayload();
			Token op = (Token) items.removeLast().getPayload();
			log(op.getText());
			pushCurrent(newJsonArray(op.getText()));
			myOps.add(current);
			parseMathMultiplyExp(add);
		}
		MathMultiplyExpContext last = (MathMultiplyExpContext) items
				.removeLast().getPayload();
		parseMathMultiplyExp(last);

		for (JSONArray op : myOps) {
			Object op1 = op.get(1);
			Object op2 = op.get(2);
			op.put(1, op2);
			op.put(2, op1);
		}
		while (current != beforeC)
			popCurrent();
	}

	static void parseMathMultiplyExp(MathMultiplyExpContext mathMult) {
		log("MultExp");
		LinkedList<ParseTree> items = new LinkedList<ParseTree>(
				mathMult.children);
		if (items.size() == 1) {
			parseMathAtomExp((MathAtomExpContext) items.get(0).getPayload());
			return;
		}
		JSONArray beforeC = current;
		List<JSONArray> myOps = new ArrayList<>();

		while (items.size() > 1) {
			MathAtomExpContext add = (MathAtomExpContext) items.removeLast()
					.getPayload();
			Token op = (Token) items.removeLast().getPayload();
			log(op.getText());
			pushCurrent(newJsonArray(op.getText()));
			myOps.add(current);
			parseMathAtomExp(add);
		}
		MathAtomExpContext last = (MathAtomExpContext) items.removeLast()
				.getPayload();
		parseMathAtomExp(last);

		for (JSONArray op : myOps) {
			Object op1 = op.get(1);
			Object op2 = op.get(2);
			op.put(1, op2);
			op.put(2, op1);
		}
		while (current != beforeC)
			popCurrent();
	}

	static void parseMathAtomExp(MathAtomExpContext mathAtom) {
		log("AtomExp");
		MathAdditionExpContext add;
		ArrayIdentifierContext arrayId;
		MethodCallContext methodCall;
		if ((add = mathAtom.mathAdditionExp()) != null) {
			parseMathAdditionExp(add);
		} else if ((arrayId = mathAtom.arrayIdentifier()) != null) {
			parseArrayItem(arrayId);
		} else if ((methodCall = mathAtom.methodCall()) != null) {
			parseMethodCall(methodCall, true);
		} else {
			Token token = ((Token) mathAtom.getChild(0).getPayload());
			int type = token.getType();
			if (type == NUMBER)
				parseNumber((TerminalNode) mathAtom.getChild(0));
			else if (type == IDENTIFIER)
				parseVariable((TerminalNode) mathAtom.getChild(0));
		}
	}

	static void parseNumber(TerminalNode number) {
		double num = Double.parseDouble(number.getText());
		log("Number", num);
		current.put(num);
	}

	static void parseStringLiteral(TerminalNode string) {
		log("StringLiteral", string.getText());
		current.put(string.getText()
				.substring(1, string.getText().length() - 1));
	}

	static void parseVariable(TerminalNode variable) {
		String identifier = variable.getText();
		log("VarGet", identifier);

		if (currentContext.belongsTo != null
				&& currentContext.belongsTo.paramNames.contains(identifier)) {
			log("Param");
			pushCurrent(newJsonArray("getParam", identifier, "r"));
			// strangely the Wiki has nothing
			// about getParam so I don't even
			// know what "r" does
			// I assumed params had "readVariable" too
			// but then I tried it an it didn't work
			// so I had to manually look at some JSON
			// to figure this out
			popCurrent();
			return;
		} else {
			if (currentContext.hasVar(identifier)) {
				identifier = currentContext.getLocalVarName(identifier);
			} else if (currentContext.parentHasVar(identifier)) {
				identifier = currentContext.getNonLocalVarName(identifier);
			} else {
				Token start = (Token) variable.getPayload();
				errors.add(new CompileError(start.getStartIndex(), start
						.getStopIndex(), start.getLine(), start
						.getCharPositionInLine(), identifier
						+ " has not been set yet in this context"));
				currentContext.variables.add(identifier);
				identifier = currentContext.getLocalVarName(identifier);
			}
		}

		pushCurrent(newJsonArray("readVariable", identifier));
		popCurrent();
	}

	static void parseArrayItem(ArrayIdentifierContext arrayId) {
		String identifier = arrayId.IDENTIFIER().getText();
		log("ArrayItemGet", identifier);

		if (currentContext.belongsTo != null
				&& currentContext.belongsTo.paramNames.contains(identifier)) {
			Token start = arrayId.getStart();
			errors.add(new CompileError(start.getStartIndex(), start
					.getStopIndex(), start.getLine(), start
					.getCharPositionInLine(),
					"Array paramaters are not allowed: " + identifier));
		} else {
			if (currentContext.hasVar(identifier)) {
				identifier = currentContext.getLocalVarName(identifier);
			} else if (currentContext.parentHasVar(identifier)) {
				identifier = currentContext.getNonLocalVarName(identifier);
			} else {
				Token start = arrayId.getStart();
				errors.add(new CompileError(start.getStartIndex(), start
						.getStopIndex(), start.getLine(), start
						.getCharPositionInLine(), identifier
						+ " has not been set yet in this context"));
				currentContext.variables.add(identifier);
				identifier = currentContext.getLocalVarName(identifier);
			}
		}

		pushCurrent(newJsonArray("getLine:ofList:"));
		pushCurrent(newJsonArray("+", "1"));
		parseVarExp(arrayId.varExp());
		popCurrent();
		current.put(identifier);
		popCurrent();
	}

	static void parseMethod(MethodBodyContext method) {
		String identifier = method.IDENTIFIER().getText();
		boolean atomic = method.ATOMIC_METHOD_TAG() != null;
		log("MethodDef", identifier);

		Method m = methods.get(identifier);
		StringBuilder name = new StringBuilder(identifier);
		for (int i = 0; i < m.numParams; i++) {
			name.append(" %s");
		}

		JSONArray methodArr = new JSONArray();
		methodArr.put(10).put(10);
		JSONArray scripts = new JSONArray();
		methodArr.put(scripts);
		JSONArray header = new JSONArray();
		scripts.put(header);
		header.put("procDef").put(name.toString());
		JSONArray varNames = new JSONArray();
		header.put(varNames);
		JSONArray defaults = new JSONArray();
		header.put(defaults);
		for (int i = 0; i < m.numParams; i++)
			defaults.put("");
		header.put(atomic);

		ParamsDefContext paramsDef = method.paramsDef();
		if (paramsDef != null) {
			List<ParamDefContext> paramDefs = paramsDef.paramDef();
			for (ParamDefContext paramDef : paramDefs) {
				TerminalNode param = paramDef.IDENTIFIER();
				if (param != null) {
					varNames.put(param.getText());
				} else {
					Token start = (Token) paramDef.arrayDef().IDENTIFIER()
							.getPayload();
					errors.add(new CompileError(start.getStartIndex(), start
							.getStopIndex(), start.getLine(), start
							.getCharPositionInLine(),
							"Arrays are not allowed as method parameters"));
				}
			}
		}
		varNames.put("returnStackName");
		stack.push(current);
		current = scripts;

		pushContext();
		currentContext.belongsTo = m;
		parseBody(method.body());
		popContext();

		current = stack.pop();
		methodDefs.add(methodArr);
	}
}
