# ApuC Advanced Doc #
Assumes you know at least one C-like language already.

## Basics ##
Just like C, ApuC consists of lines which all end in a semicolon.  
Also like C, ApuC has blocks consting of an opening curly brace, some number of lines, and then a closing brace.

Each line contains a statement. You can set variables and arrays just like in C.

However, unlike C, ApuC is not **typed**. This means that variables don't have a specific type like string or double precision decimal.  
In ApuC, as in Scratch, you can set variables to whatever you want.

```
derp = 5;
derp = "sup"; // works
```

Identifiers (for variables and functions) are the same as in C. They start with a letter or underscore, and after the first character can have a letter, number, or underscore.

Comments are the same as in C

```
// single line
/*
multi
line
*/
```

Creating arrays is a bit different from C.

```
derp_array[] = array[5];
derp_array[] = @singleframe array[5]; // avoids a loop and just duplicates array creating code
```

Accessing array items is the same as in C, where the first item is index 0.
To get an array's length use the built in function `length`

```
array_length = length(derp_array[]);
```

Calling methods is also the same as C.
```
sayFor("Hi", 5); // says "Hi" for 5 secs
```

To see a full list of built in functions (excluding `length` and math functions) see https://github.com/MegaApuTurkUltra/Scratch-ApuC/blob/master/src/builtin.csv  

Built in math functions are anything in the Scratch operator block () of () except `e ^` which is `powe` and `10 ^` which is `pow10`

```
abs_value = abs(-5);
ln_value = ln(100000);
power_value = pow10(5);
// etc
```

### Math ###

Unlike in Scratch, you can put as many math operators as you want in a line. ApuC will automatically follow order-of-operations order first, and left-to-right order next.

```
derp = 5 + 7 + 6 * 8;
// equivalent to derp = (5 + 7) + (6 * 8);
```

Note that the modulo operator % has the same precedence in order-of-operations order in ApuC as multiplication and division.

## Scope ##

Scope is just like in C, with the drawback that inner scopes cannot define new variables if a parent scope already has one with the same name. This is because ApuC is not typed, so there is no way of knowing if you are defining a variable or setting it.

```
{ // this is a block. blocks are allowed anywhere
    derp = 5;
}

derp = 6; // different derp here. Outer scopes don't have access to inner scopes' variables.
{
    derp = 7; // this is the same derp as in the outer scope. Since the outer scope defined it, we can access it from here
    // note that "defining" here is just setting a variable to something for the first time
}
```

## Defining functions ##

Unlike C, where you have to specify a function's return value, in ApuC you just use the `def` keyword.

```
def say_thingy(thingy){
    say(thingy);
}
```

Function definitions become Scratch "define" blocks. To make them run without screen refresh use the `@atomic` annotation.

```
def @atomic instant_function(){
    // do stuffs
}
```

Returning is also the same as in C. The ApuC compiler will expand it out to setting some variables within a function and then accessing them from outside.  

```
def derp(){
    return 5;
}

say(derp());
```

You can also just use `return` by itself to not return a value, just exit the function. All return statements turn into `stop [this script]` blocks.

You can even call a function multiple times in a line. The compiler handles it all.

```
def derp(){
    return random(1, 10);
}
say(derp() - derp());
```

### When blocks ###

ApuC code that isn't a function automatically goes in a When Green Flag script, but you can also add your own when blocks with the `@when` annotation.

```
@when greenFlag { /* extra green flag script */ }
@when received "derp_broadcast" { /* when received script */ } 
@when keyPressed "space" { }
@when keyPressed "a" { /* any key can go in the quotes */ }
@when cloned { /* when I start as clone */ }
@when clicked { /* this sprite clicked */ }
@when sensorGreaterThan "loudness" 10 { /* when loudness > 10 */ }
```

## Control flow ##

### Conditions ###

Conditions are the same as in C. You can use ==, <=, >=, >, <, and !=.  
You can also use boolean operators &&, ||, and !. Note that with && and ||, only 2 conditions are supported at the moment, unlike math operations

```
derp > 5 && derp < 7 && derp == 6 // not supported
(derp > 5 && derp < 7) && derp == 6 // use parens to group in 2s
!(derp == 7 || derp == 8) // you can use ! like in C
```

### If/else ###

If/else blocks work just like in C, except that else-if clauses are not supported. If you need an else-if clause, just put another if block in your else block.

```
if(derp == 5){
    // derp is 5
} else {
    if(derp < 5){
        // works just like else-if
    } else {
        // works just like the final else
    }
}
```

### For/while loops ###

These work like in C. While becomes `repeat until <not <...>>` and for becomes a more complicated `repeat until <not <...>>`

### Repeat loops ###

ApuC introduces the single frame repeat loop, which ApuC will automatically duplicate the specified number of times.

```
repeat @singleframe (5) {
    say("Hi");
}
// becomes
say("Hi");
say("Hi");
say("Hi");
say("Hi");
say("Hi");
```

### Remember ###

All blocks (defined by an opening curly brace and closing curly brace) have their own inner scope!

# Conclusion #

I hope this advanced tutorial makes sense. If you still don't understand everything, check out the actual ApuC ANTLR grammar definition: https://github.com/MegaApuTurkUltra/Scratch-ApuC/blob/master/src/apu/antlr/clike/ScratchCLike.g4  It's what defines everything in ApuC.  
If you don't understand ANTLR grammar, basically it's made up of rules, like `rulename : def ;`  
Capitalized rules are lexer rules, lowercase are parser rules.  
All lexer rules define some regular expression or literal that they match in some text. They turn each matched item into a **token**.  
The parser builds complicated trees out of these tokens.  
My IDE syntax highlighter also uses these tokens. Each highlighted section is a token.  
For example, `methodCall : IDENTIFIER OPENP params? CLOSEP;` defines a parser rule named methodCall that looks for an identifier token, then an open parentesis token, then tries to match another parser rule called params, then a close parentesis token.  


If you still need more help post on the Scratch forum topic: http://scratch.mit.edu/discuss/topic/50212/