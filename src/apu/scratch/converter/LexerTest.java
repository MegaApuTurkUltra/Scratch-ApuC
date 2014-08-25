/**
 * 
 */
package apu.scratch.converter;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import apu.antlr.clike.ScratchCLikeLexer;

/**
 * @author MegaApuTurkUltra
 * 
 */
public class LexerTest {

	public static void main(String[] args) throws Exception {
		String code = "identifier = 5;// sup\n/*derp\nderp*/";
		ScratchCLikeLexer lexer = new ScratchCLikeLexer(new ANTLRInputStream(
				new StringReader(code)));
		CommonTokenStream stream = new CommonTokenStream(lexer);
		stream.fill();
		Class<ScratchCLikeLexer> lexerClass = ScratchCLikeLexer.class;
		Map<Integer, String> tokenIds = new HashMap<>();
		for (String s : lexer.getRuleNames()) {
			if (s.equals("AChar") || s.equals("AEscapeSequence"))
				continue;
			int num = lexerClass.getDeclaredField(s).getInt((Object) null);
			tokenIds.put(num, s);
		}
		tokenIds.put(Token.EOF, "<EOF>");
		for (Token t : stream.getTokens()) {
			System.out.println(t.getType() + " "+tokenIds.get(t.getType()));
		}
	}

}
